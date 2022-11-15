package in.handyman.raven.lib;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import in.handyman.raven.exception.HandymanException;
import in.handyman.raven.lambda.action.ActionExecution;
import in.handyman.raven.lambda.action.IActionExecution;
import in.handyman.raven.lambda.doa.audit.ActionExecutionAudit;
import in.handyman.raven.lib.model.AbsentKeyFilter;
import okhttp3.MediaType;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.elasticsearch.client.RestClient;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Auto Generated By Raven
 */
@ActionExecution(
        actionName = "AbsentKeyFilter"
)
public class AbsentKeyFilterAction implements IActionExecution {
    private static final MediaType MediaTypeJSON = MediaType.parse("application/json; charset=utf-8");
    private final ActionExecutionAudit action;
    private final Logger log;
    private final AbsentKeyFilter absentKeyFilter;
    private final Marker aMarker;
    private final ElasticsearchClient elasticsearchClient;
    private final ObjectMapper mapper = new ObjectMapper();
    private final String URI;
    private final String esUsername;
    private final String esPassword;
    private final String esHostname;

    public AbsentKeyFilterAction(final ActionExecutionAudit action, final Logger log,
                                 final Object absentKeyFilter) {
        this.absentKeyFilter = (AbsentKeyFilter) absentKeyFilter;
        this.action = action;
        this.log = log;
        this.aMarker = MarkerFactory.getMarker(" AbsentKeyFilter:" + this.absentKeyFilter.getName());
        this.esUsername = action.getContext().get("es.username");
        this.esPassword = action.getContext().get("es.password");
        this.esHostname = action.getContext().get("es.hostname");
        this.elasticsearchClient = getElasticsearchClient(esUsername, esPassword, esHostname);
        this.URI = action.getContext().get("copro.data-extraction.url");
    }

    private static ElasticsearchClient getElasticsearchClient(String userName, String password, String hostName) {

        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(userName, password));
        var restClient = RestClient.builder(new HttpHost(hostName, Integer.parseInt("9200"))).setRequestConfigCallback(requestConfigBuilder -> requestConfigBuilder.setConnectTimeout(6000000).setSocketTimeout(6000000)).setHttpClientConfigCallback(httpAsyncClientBuilder -> {
            httpAsyncClientBuilder.setMaxConnTotal(500);
            httpAsyncClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
            httpAsyncClientBuilder.setDefaultIOReactorConfig(IOReactorConfig.custom().setIoThreadCount(10).build());
            return httpAsyncClientBuilder;
        }).build();
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        var transport = new RestClientTransport(restClient, new JacksonJsonpMapper(mapper));
        return new ElasticsearchClient(transport);
    }

    @Override
    public void execute() throws Exception {
        try {
            log.info(aMarker, "<-------Absent Key Filter Action for {} has been started------->" + absentKeyFilter.getName());

            JsonNode sorQuestionList = mapper.readTree(absentKeyFilter.getSorList());
            String sorName = sorQuestionList.get("f1").asText();
            JSONArray absentKeyList = new JSONArray();
            ObjectNode searchBuilderResult = mapper.createObjectNode();
            SearchResponse<Object> filterList = elasticsearchClient
                    .search(s -> s.index("source_of_truth")
                            .query(q -> q.bool(bool -> bool.must(query ->
                                            query.matchPhrase(dd -> dd.field("page_content").query(sorName))).must(query ->
                                            query.matchPhrase(dd -> dd.field("intics_reference_id").query(absentKeyFilter.getInticsReferenceId()))).must(query ->
                                            query.matchPhrase(dd -> dd.field("file_path").query(absentKeyFilter.getFilePath()))
                                    )
                            )), Object.class);
            long hitsCount = filterList.hits().total().value();
            if (hitsCount > 0) {
                String indexId = filterList.hits().hits().get(0).id();

                List<String> filteredSorList = new ArrayList<>();
                for (JsonNode fieldName : sorQuestionList.get("f2")) {
                    String questionKey = fieldName.asText();
                    SearchResponse<Object> filteredQuestionList = elasticsearchClient
                            .search(s -> s.index("source_of_truth")
                                    .query(q -> q.bool(bool -> bool.must(query ->
                                            query.matchPhrase(dd -> dd.field("page_content").query(questionKey))).must(query ->
                                            query.matchPhrase(dd -> dd.field("_id").query(indexId)))
                                    )), Object.class);
                    long questionHitCount = filteredQuestionList.hits().total().value();
                    if (questionHitCount > 0) {
                        filteredSorList.add(questionKey);
                    }
                }
                filterList.hits().hits().forEach(res -> {
                    searchBuilderResult.put("key_name", sorName);
                    searchBuilderResult.put("isFiltered", true);
                    searchBuilderResult.putPOJO("question_list", filteredSorList);
                    searchBuilderResult.put("confidence_score", res.score());
                });
            } else {
                searchBuilderResult.put("key_name", sorName);
                searchBuilderResult.put("isFiltered", false);
            }
            absentKeyList.put(searchBuilderResult);

            if (absentKeyList.length() == 0) {
                log.info(aMarker, "Absent Key Filter List count is {} for the File  {} ", absentKeyList.length(), absentKeyFilter.getFilePath());
                action.getContext().put(absentKeyFilter.getName() + "_response", absentKeyList.toString());
                action.getContext().put(absentKeyFilter.getName().concat(".value"), "false");
            } else {
                log.info(aMarker, "Absent Key Filter List count is {} for the File  {} ", absentKeyList.length(), absentKeyFilter.getFilePath());
                action.getContext().put(absentKeyFilter.getName() + "_response", absentKeyList.toString());
                action.getContext().put(absentKeyFilter.getName().concat(".value"), "true");
            }
            log.info(aMarker, "<-------Absent Key Filter Action for {} has been completed------->" + absentKeyFilter.getName());
        } catch (Exception e) {
            action.getContext().put(absentKeyFilter.getName().concat(".error"), "true");
            log.info(aMarker, "The Exception occurred ", e);
            throw new HandymanException("Failed to execute", e);
        }
    }

    @Override
    public boolean executeIf() throws Exception {
        return absentKeyFilter.getCondition();
    }
}


