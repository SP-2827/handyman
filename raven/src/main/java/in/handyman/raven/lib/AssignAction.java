package in.handyman.raven.lib;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zaxxer.hikari.HikariDataSource;
import in.handyman.raven.audit.AuditService;
import in.handyman.raven.connection.ResourceAccess;
import in.handyman.raven.context.ActionContext;
import in.handyman.raven.exception.HandymanException;
import in.handyman.raven.lambda.LambdaAutowire;
import in.handyman.raven.lambda.LambdaExecution;
import in.handyman.raven.lib.model.Assign;
import in.handyman.raven.util.CommonQueryUtil;
import in.handyman.raven.util.ExceptionUtil;
import in.handyman.raven.util.UniqueID;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.MarkerManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

/**
 * Auto Generated By Raven
 */
@LambdaAutowire(
        lambdaName = "Assign"
)
@Log4j2
public class AssignAction implements LambdaExecution {

    private final ActionContext actionContext;
    private final Assign context;
    private final MarkerManager.Log4jMarker aMarker;

    public AssignAction(final ActionContext actionContext, final Object context) {
        this.context = (Assign) context;
        this.actionContext = actionContext;
        this.aMarker = new MarkerManager.Log4jMarker("Assign");
        this.actionContext.getDetailMap().putPOJO("context", context);
    }

    @Override
    public void execute() throws Exception {
        final String dbSrc = context.getSource();
        log.info("Transform action input variables id: {}, name: {}, source-database: {} ", actionContext.getLambdaId(), context.getName(), dbSrc);
        log.info("Sql input post parameter ingestion \n {}", context.getValue());
        final HikariDataSource hikariDataSource = ResourceAccess.rdbmsConn(dbSrc);
        final ObjectNode detailMap = actionContext.getDetailMap();
        try (final Connection connection = hikariDataSource.getConnection()) {
            final List<String> formattedQuery = CommonQueryUtil.getFormattedQuery(context.getValue());
            for (var sqlToExecute : formattedQuery) {
                log.info(aMarker, "Execution query sql#{} on db=#{}", sqlToExecute, dbSrc);
                final Long statementId = UniqueID.getId();
                AuditService.insertStatementAudit(statementId, actionContext.getLambdaId(),
                        actionContext.getName(), actionContext.getProcessName());
                try (final Statement stmt = connection.createStatement()) {
                    try (var rs = stmt.executeQuery(sqlToExecute)) {
                        var columnCount = rs.getMetaData().getColumnCount();
                        while (rs.next()) {
                            final Map<String, String> configContext = actionContext.getContext();
                            CommonQueryUtil.addKeyConfig(configContext, detailMap,
                                    rs, columnCount, context.getName());
                        }
                    }
                    var warnings = ExceptionUtil.completeSQLWarning(stmt.getWarnings());
                    detailMap.put(sqlToExecute + ".stmtCount", stmt.getUpdateCount());
                    detailMap.put(sqlToExecute + ".warnings", warnings);
                    AuditService.updateStatementAudit(statementId, 0, 0, sqlToExecute, 1);
                    log.info(aMarker, " id# {}, executed script {} rows returned {}", statementId.toString(), sqlToExecute, 0);
                    stmt.clearWarnings();
                } catch (SQLSyntaxErrorException ex) {
                    log.error(aMarker, "Stopping execution, General Error executing sql for {} with for campaign {}", sqlToExecute, ex);
                    detailMap.put(sqlToExecute + ".exception", ExceptionUtil.toString(ex));
                    throw new HandymanException("Process failed", ex);
                } catch (SQLException ex) {
                    log.error(aMarker, "Continuing to execute, even though SQL Error executing sql for {} ", sqlToExecute, ex);
                    detailMap.put(sqlToExecute + ".exception", ExceptionUtil.toString(ex));
                } catch (Throwable ex) {
                    log.error(aMarker, "Stopping execution, General Error executing sql for {} with for campaign {}", sqlToExecute, ex);
                    detailMap.put(sqlToExecute + ".exception", ExceptionUtil.toString(ex));
                    throw new HandymanException("Process failed", ex);
                }
            }
        }
    }

    @Override
    public boolean executeIf() {
        return context.getCondition();
    }
}
