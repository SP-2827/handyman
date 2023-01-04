package in.handyman.raven.lib;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.TotalHits;
import co.elastic.clients.elasticsearch.indices.Alias;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import in.handyman.raven.exception.HandymanException;
import in.handyman.raven.lambda.access.ResourceAccess;
import in.handyman.raven.lambda.action.ActionExecution;
import in.handyman.raven.lambda.action.IActionExecution;
import in.handyman.raven.lambda.doa.audit.ActionExecutionAudit;
import in.handyman.raven.lib.model.TqaFilter;
import in.handyman.raven.util.CommonQueryUtil;
import in.handyman.raven.util.InstanceUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Auto Generated By Raven
 */
@ActionExecution(
        actionName = "TqaFilter"
)
public class TqaFilterAction implements IActionExecution {
    public static final String INPUT_FILE_PATH = "input_file_path";
    private static final MediaType MediaTypeJSON = MediaType
            .parse("application/json; charset=utf-8");
    private final ActionExecutionAudit action;
    private final Logger log;
    private final TqaFilter tqaFilter;
    private final Marker aMarker;
    private final ObjectMapper mapper = new ObjectMapper();


    public TqaFilterAction(final ActionExecutionAudit action, final Logger log,
                           final Object tqaFilter) {
        this.tqaFilter = (TqaFilter) tqaFilter;
        this.action = action;
        this.log = log;
        this.aMarker = MarkerFactory.getMarker(" TqaFilter:" + this.tqaFilter.getName());
    }

    @Override
    public void execute() throws Exception {

        final Jdbi jdbi = ResourceAccess.rdbmsJDBIConn(tqaFilter.getResourceConn());
        final List<Map<String, Object>> synonymsResult = new ArrayList<>();
        final List<Map<String, Object>> inputPathResult = new ArrayList<>();
        jdbi.useTransaction(handle -> {
            final List<String> formattedQuery = CommonQueryUtil.getFormattedQuery(tqaFilter.getSynonymSqlQuery());
            formattedQuery.forEach(sqlToExecute -> {
                synonymsResult.addAll(handle.createQuery(sqlToExecute).mapToMap().stream().collect(Collectors.toList()));
            });
        });
        jdbi.useTransaction(handle -> {
            final List<String> formattedQuery = CommonQueryUtil.getFormattedQuery(tqaFilter.getInputFilePathSqlQuery());
            formattedQuery.forEach(sqlToExecute -> {
                inputPathResult.addAll(handle.createQuery(sqlToExecute).mapToMap().stream().collect(Collectors.toList()));
            });
        });

        final String esUsername = action.getContext().get("es.username");
        final String esPassword = action.getContext().get("es.password");
        final String esHostname = action.getContext().get("es.hostname");

        var elasticsearchClient = InstanceUtil.createElasticsearchClient(esUsername, esPassword, esHostname);
        final String indexName = "source_of_truth";
        createIndex(elasticsearchClient, indexName);

        final String threadCount = tqaFilter.getThreadCount();

//
//
//        if (threadCount != null) {
//            final ExecutorService executorService = Executors.newFixedThreadPool(Integer.parseInt(threadCount));
//        }
//

        createTruePositive(jdbi, synonymsResult, inputPathResult, elasticsearchClient, indexName);

        createFalsePositive(jdbi, inputPathResult);

    }

    private void createIndex(final ElasticsearchClient elasticsearchClient, final String indexName) throws IOException {
        Set<String> alias = Collections.emptySet();

        final boolean exists = elasticsearchClient.indices().exists(builder -> builder.index(indexName)).value();
        if (!exists) {
            var createIndexResponse = elasticsearchClient.indices()
                    .create(new CreateIndexRequest.Builder().index(indexName)
                            .aliases(alias.stream().collect(Collectors.toMap(o -> o, s ->
                                    new Alias.Builder().isWriteIndex(true).build()))).build());
            log.info(aMarker, "response status {} shard {}", createIndexResponse.acknowledged(),
                    createIndexResponse.shardsAcknowledged());
        }
    }

    private void createTruePositive(final Jdbi jdbi, final List<Map<String, Object>> synonymsResult, final List<Map<String, Object>> inputPathResult, final ElasticsearchClient elasticsearchClient, final String indexName) throws IOException {


        final List<TruePositiveFilterResult> truePositives = new ArrayList<>();

        extractionApi(indexName, inputPathResult, tqaFilter.getOutputDir(), elasticsearchClient);
        for (var input : inputPathResult) {

            final String inputFilePath = Optional.ofNullable(input.get(INPUT_FILE_PATH)).map(String::valueOf).orElse(null);
            final Integer paperNo = Optional.ofNullable(input.get("paper_no")).map(String::valueOf).map(Integer::parseInt).orElse(null);
            final String refId = Optional.ofNullable(input.get("ref_id")).map(String::valueOf).orElse(null);

            final Map<Long, List<Map<String, Object>>> longListMap = synonymsResult.stream()
                    .collect(Collectors.groupingBy(synonym -> Optional.ofNullable(synonym.get("sor_id")).map(String::valueOf).map(Long::valueOf).orElse(null)));

            for (var sorId : longListMap.keySet()) {

                for (var synonym : longListMap.get(sorId)) {

                    final String synonymName = Optional.ofNullable(synonym.get("synonym_name")).map(String::valueOf).orElse(null);
                    final Long tsId = Optional.ofNullable(synonym.get("ts_id")).map(String::valueOf).map(Long::valueOf).orElse(null);
                    final Long sqId = Optional.ofNullable(synonym.get("sq_id")).map(String::valueOf).map(Long::valueOf).orElse(null);
                    final String question = Optional.ofNullable(synonym.get("question")).map(String::valueOf).orElse(null);

                    if (synonymName != null && inputFilePath != null) {


                        final SearchResponse<Object> filterList = elasticsearchClient
                                .search(s -> s.index(indexName)
                                        .query(q -> q.bool(bool -> bool.must(query ->
                                                        query.matchPhrase(dd -> dd.field("page_content").query(synonymName)))
                                                .must(query ->
                                                        query.matchPhrase(dd -> dd.field("file_path").query(inputFilePath))
                                                )
                                        )), Object.class);

                        log.debug(aMarker, filterList.toString());

                        final long hitsCount = Optional.ofNullable(filterList.hits().total()).map(TotalHits::value).orElse(0L);
                        truePositives.add(TruePositiveFilterResult.builder()
                                .inputFilePath(inputFilePath)
                                .synonymName(synonymName)
                                .rootPipelineId(action.getRootPipelineId())
                                .truePositiveHitCount(hitsCount)
                                .truthSynonymId(tsId)
                                .synonymQuestionId(sqId)
                                .sorId(sorId)
                                .paperNo(paperNo)
                                .refId(refId)
                                .docnetQuestion(question)
                                .build());
//                        if (hitsCount > 0) {
//                            break;
//                        }
                    }
                }
            }
        }

        List<List<TruePositiveFilterResult>> smallerLists = tqaFilter.getWriteBatchSize() != null
                ? Lists.partition(truePositives, Integer.parseInt(tqaFilter.getWriteBatchSize()))
                : Collections.singletonList(truePositives);

        smallerLists.forEach(truePositiveFilterResults -> {
            jdbi.useTransaction(handle -> {
                ;

                for (var tpfr : truePositiveFilterResults) {
                    handle.createUpdate("INSERT INTO tqa.true_positive_filter_result (input_file_path, synonym_name, truth_synonym_id," +
                                    " synonym_question_id, true_positive_hit_count, root_pipeline_id,ref_id,paper_no,sor_id,docnet_question)" +
                                    " VALUES( :inputFilePath , :synonymName , :truthSynonymId , :synonymQuestionId , :truePositiveHitCount , :rootPipelineId ,:refId,:paperNo,:sorId,:docnetQuestion);")
                            .bindBean(tpfr).execute();
                    log.debug(aMarker, "inserted {} into true positive result", tpfr);
                }


            });

        });

    }

    private void extractionApi(final String indexName, final List<Map<String, Object>> inputPathResult, final String outputDir, final ElasticsearchClient elasticsearchClient) {

        final OkHttpClient httpclient = InstanceUtil.createOkHttpClient();

        for (var input : inputPathResult) {

            final String inputFilePath = Optional.ofNullable(input.get(INPUT_FILE_PATH)).map(String::valueOf).orElse(null);

            final ObjectNode objectNode = mapper.createObjectNode();
            objectNode.put("inputFilePath", inputFilePath);
            objectNode.put("outputDir", outputDir);
            final String extractionUrl = action.getContext().get("copro.data-extraction.url");

            Request request = new Request.Builder().url(extractionUrl)
                    .post(RequestBody.create(objectNode.toString(), MediaTypeJSON)).build();

            try (Response response = httpclient.newCall(request).execute()) {
                String responseBody = response.body().string();
                JsonNode extractedResult = mapper.readTree(responseBody);
                if (response.isSuccessful()) {
                    String indexId = String.valueOf(System.currentTimeMillis());
                    ObjectNode indexNode = mapper.createObjectNode();
                    indexNode.put("type", "AGADIA_SOT");
                    indexNode.put("created_at", String.valueOf(LocalDateTime.now()));
                    indexNode.put("file_path", inputFilePath);
                    indexNode.set("page_content", extractedResult.get("pageContent"));
                    final IndexResponse indexResponse = elasticsearchClient.index(IndexRequest.of(indexReq -> indexReq
                            .index(indexName)
                            .id(indexId)
                            .document(indexNode))
                    );
                    log.info(aMarker, "response status {} payloadID {}", indexResponse.index(), indexResponse.id());
                } else {
                    log.error(aMarker, "The Failure Response {} --> {}", inputFilePath, responseBody);
                }


            } catch (Exception e) {
                log.error(aMarker, "The Exception occurred ", e);
                throw new HandymanException("Failed to execute", e);
            }
        }

    }

    private void createFalsePositive(final Jdbi jdbi, final List<Map<String, Object>> inputPathResult) {
        final OkHttpClient okHttpClient = InstanceUtil.createOkHttpClient();
        final Long processId = action.getProcessId();

        for (var input : inputPathResult) {

            final String inputFilePath = Optional.ofNullable(input.get(INPUT_FILE_PATH)).map(String::valueOf).orElse(null);
            final Integer paperNo = Optional.ofNullable(input.get("paper_no")).map(String::valueOf).map(Integer::parseInt).orElse(null);
            final String refId = Optional.ofNullable(input.get("ref_id")).map(String::valueOf).orElse(null);

            final ObjectNode objectNode = mapper.createObjectNode();

            objectNode.put("inputFilePath", inputFilePath);
            objectNode.put("outputDir", tqaFilter.getOutputDir());
            objectNode.put("maxDoctrDiff", tqaFilter.getMaxDoctrDiff());
            objectNode.put("maxQuestionDiff", tqaFilter.getMaxQuestionDiff());


            final String truthExtractorUrl = tqaFilter.getTruthExtractorUrl();
            final Request request = new Request.Builder().url(truthExtractorUrl)
                    .post(RequestBody.create(objectNode.toString(), MediaTypeJSON)).build();

            log.debug(aMarker, "URL {} request body {}", truthExtractorUrl, objectNode);
            try (final Response response = okHttpClient.newCall(request).execute()) {
                final String responseBody = Objects.requireNonNull(response.body()).string();
                if (response.isSuccessful()) {
                    final TruthExtractionResponse truthExtractionResponse = mapper.readValue(responseBody, TruthExtractionResponse.class);
                    jdbi.useTransaction(handle -> {

                        final QaPairResult qaPairResult = QaPairResult.builder()
                                .inputFilePath(inputFilePath)
                                .rootPipelineId(action.getRootPipelineId())
                                .processId(processId)
                                .response(responseBody)
                                .paperNo(paperNo)
                                .refId(refId)
                                .build();
                        handle.createUpdate("INSERT INTO truth_attribution.sot_qa_pairing_result (input_file_path,root_pipeline_id, process_id, response,intics_reference_id, paper_no  )" +
                                        " select  :inputFilePath , :rootPipelineId , :processId ,cast(:response as json),:refId,:paperNo ;")
                                .bindBean(qaPairResult)
                                .execute();
                        log.debug(aMarker, "inserted {} into QA pairing result", qaPairResult);
                    });
                    final List<FalsePositiveFilterResult> falsePositiveFilterResults = truthExtractionResponse.getQaPairs().stream()
                            .map(qaPair -> FalsePositiveFilterResult.builder()
                                    // .question(qaPair.getQuestionParts()
                                    //         .stream().map(Part::getContent).collect(Collectors.joining(" ")))
                                    .question(qaPair.getQuestion())
                                    .answerCount(qaPair.getAnswerParts().size())
                                    .inputFilePath(inputFilePath)
                                    .rootPipelineId(action.getRootPipelineId())
                                    .paperNo(paperNo)
                                    .refId(refId)
                                    .build())
                            .collect(Collectors.toList());


                    List<List<FalsePositiveFilterResult>> smallerLists = tqaFilter.getWriteBatchSize() != null
                            ? Lists.partition(falsePositiveFilterResults, Integer.parseInt(tqaFilter.getWriteBatchSize()))
                            : Collections.singletonList(falsePositiveFilterResults);

                    smallerLists.forEach(truePositiveFilterResults -> {

                        jdbi.useTransaction(handle -> {

                            for (var tpfr : truePositiveFilterResults) {
                                handle.createUpdate("INSERT INTO tqa.false_positive_filter_result (input_file_path, question, answer_count, root_pipeline_id,ref_id,paper_no)" +
                                        " VALUES( :inputFilePath , :question , :answerCount ,:rootPipelineId,:refId,:paperNo );").bindBean(tpfr).execute();
                                log.debug(aMarker, "inserted {} into false positive result", tpfr);
                            }


                        });

                    });
                } else {
                    log.error(aMarker, " response failed {} ", responseBody);
                }
            } catch (Exception e) {
                log.error(aMarker, "The Exception occurred ", e);
            }

        }


    }

    @Override
    public boolean executeIf() throws Exception {
        return tqaFilter.getCondition();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class TruePositiveFilterResult {

        private String inputFilePath;
        private String synonymName;
        private String docnetQuestion;

        private Long truthSynonymId;
        private Long synonymQuestionId;

        private long truePositiveHitCount;

        private Long rootPipelineId;

        private String refId;
        private Long sorId;
        private Integer paperNo;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class FalsePositiveFilterResult {

        private String inputFilePath;
        private String question;

        private long answerCount;

        private Long rootPipelineId;
        private String refId;
        private Integer paperNo;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class QaPairResult {

        private String inputFilePath;
        private String response;
        private Long rootPipelineId;
        private String refId;
        private Long processId;
        private Integer paperNo;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    static
    class TruthExtractionResponse {

        private List<QaPair> qaPairs = new ArrayList<>();

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class QaPair {

        private Integer id;
        private List<Part> questionParts = new ArrayList<>();
        private String question;
        private String answer;
        private List<Part> answerParts = new ArrayList<>();

    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Part {

        private String content;
        private PartPosition position;

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PartPosition {

        private Double left;
        private Double upper;
        private Double right;
        private Double lower;
        private String filePath;
    }


}
