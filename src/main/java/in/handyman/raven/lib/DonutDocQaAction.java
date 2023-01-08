package in.handyman.raven.lib;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import in.handyman.raven.exception.HandymanException;
import in.handyman.raven.lambda.access.ResourceAccess;
import in.handyman.raven.lambda.action.ActionExecution;
import in.handyman.raven.lambda.action.IActionExecution;
import in.handyman.raven.lambda.doa.audit.ActionExecutionAudit;
import in.handyman.raven.lib.model.DonutDocQa;
import in.handyman.raven.util.CommonQueryUtil;
import in.handyman.raven.util.InstanceUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.PreparedBatch;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Auto Generated By Raven
 */
@ActionExecution(
        actionName = "DonutDocQa"
)
public class DonutDocQaAction implements IActionExecution {
    public static final String ATTRIBUTION_URL = "copro.docnet-attribution.url";
    private final ActionExecutionAudit action;

    private final Logger log;

    private final DonutDocQa donutDocQa;

    private final Marker aMarker;
    private final List<String> nodes;

    private final AtomicInteger counter = new AtomicInteger();

    public DonutDocQaAction(final ActionExecutionAudit action, final Logger log,
                            final Object donutDocQa) {
        this.donutDocQa = (DonutDocQa) donutDocQa;
        this.action = action;
        this.log = log;
        this.aMarker = MarkerFactory.getMarker(" DonutDocQa: " + this.donutDocQa.getName());
        this.nodes = Optional.ofNullable(action.getContext().get(ATTRIBUTION_URL)).map(s -> Arrays.asList(s.split(","))).orElse(Collections.emptyList());
    }

    @Override
    public void execute() throws Exception {
        log.info(aMarker, "<-------Donut Attribution Action for {} has been started------->" + donutDocQa.getName());
        final Jdbi jdbi = ResourceAccess.rdbmsJDBIConn(donutDocQa.getResourceConn());
        final List<DonutLineItem> donutLineItems = new ArrayList<>();
        jdbi.useTransaction(handle -> {
            final List<String> formattedQuery = CommonQueryUtil.getFormattedQuery(donutDocQa.getQuestionSql());
            formattedQuery.forEach(sqlToExecute -> donutLineItems.addAll(handle.createQuery(sqlToExecute)
                    .mapToBean(DonutLineItem.class)
                    .stream().collect(Collectors.toList())));
        });

        // Create DDL

        jdbi.useTransaction(handle -> handle.execute("create table if not exists macro.donut_docqa_action ( id bigserial not null, question text, predicted_attribution_value text, action_id bigint, root_pipeline_id bigint, created_date timestamp not null default now() );"));


        final int parallelism;
        if (donutDocQa.getForkBatchSize() != null) {
            parallelism = Integer.parseInt(donutDocQa.getForkBatchSize());
        } else {
            parallelism = 1;
        }


        final int size = nodes.size();
        if (parallelism > 1) {
            final CountDownLatch countDownLatch = new CountDownLatch(parallelism);
            final ExecutorService executorService = Executors.newFixedThreadPool(parallelism);
            final List<List<DonutLineItem>> donutLineItemPartitions = Lists.partition(donutLineItems, parallelism);
            donutLineItemPartitions.forEach(donutLineItems1 -> executorService.submit(() -> computeProcess(jdbi, size, donutLineItems1)));
            countDownLatch.await();
        } else {
            computeProcess(jdbi, size, donutLineItems);
        }
    }

    private void computeProcess(final Jdbi jdbi, final int nodeSize, final List<DonutLineItem> donutLineItems) {
        final List<String> questions = donutLineItems.stream().map(DonutLineItem::getQuestion).collect(Collectors.toList());
        final String node = nodes.get(counter.incrementAndGet() % nodeSize);

        log.info(aMarker, "preparing {} for rest api call", questions.size());
        final List<DonutLineItem> lineItems = new DonutApiCaller(node).compute(donutDocQa.getInputFilePath(), donutDocQa.getOutputDir(), questions);
        log.info(aMarker, "completed {}", lineItems.size());

        jdbi.useTransaction(handle -> {
            final PreparedBatch batch = handle.prepareBatch("INSERT INTO macro.donut_docqa_action (question, predicted_attribution_value, action_id, root_pipeline_id) VALUES(:question,:predictedAttributionValue, " + action.getActionId() + ", " + action.getRootPipelineId() + ");");
            Lists.partition(lineItems, 100).forEach(donutLineItems2 -> {
                log.info(aMarker, "inserting into donut_docqa_action {}", donutLineItems2.size());
                donutLineItems2.forEach(batch::bindPojo);
                int[] counts = batch.execute();
                log.info(aMarker, " persisted {} in donut_docqa_action", counts);
            });
        });
    }

    @Override
    public boolean executeIf() throws Exception {
        return donutDocQa.getCondition();
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class DonutLineItem {

        private String predictedAttributionValue;
        private String question;

    }


    @Slf4j
    public static class DonutApiCaller {

        private final OkHttpClient httpclient = InstanceUtil.createOkHttpClient();
        private static final MediaType MediaTypeJSON = MediaType.parse("application/json; charset=utf-8");
        private static final ObjectMapper MAPPER = new ObjectMapper();

        private final String node;

        public DonutApiCaller(final String node) {
            this.node = node;
        }

        protected List<DonutLineItem> compute(final String inputPath, final String outputDir, final List<String> questions) {
            final ObjectNode objectNode = MAPPER.createObjectNode();
            objectNode.put("inputFilePath", inputPath);
            objectNode.putPOJO("attributes", questions);
            objectNode.put("outputDir", outputDir);
            final Request request = new Request.Builder().url(node)
                    .post(RequestBody.create(objectNode.toString(), MediaTypeJSON)).build();
            log.info("Request URL : {} Question List size {}", node, questions.size());
            try (Response response = httpclient.newCall(request).execute()) {
                String responseBody = Objects.requireNonNull(response.body()).string();
                if (response.isSuccessful()) {
                    List<DonutLineItem> donutLineItems = MAPPER.readValue(responseBody, new TypeReference<>() {
                    });
                    log.info("DonutLineItem size {}", donutLineItems.size());
                    return donutLineItems;
                } else {
                    throw new HandymanException(responseBody);
                }
            } catch (Exception e) {
                throw new HandymanException("Failed to execute the rest api call " + node, e);
            }
        }
    }

}
