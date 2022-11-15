package in.handyman.raven.lib;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.indices.Alias;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import in.handyman.raven.lambda.action.ActionExecution;
import in.handyman.raven.lambda.action.IActionExecution;
import in.handyman.raven.lambda.doa.audit.ActionExecutionAudit;
import in.handyman.raven.lib.model.ElasticStore;

import java.io.IOException;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.elasticsearch.client.RestClient;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Auto Generated By Raven
 */
@ActionExecution(
        actionName = "ElasticStore"
)
public class ElasticStoreAction implements IActionExecution {
    private final ActionExecutionAudit action;

    private final Logger log;

    private final ElasticStore elasticStore;

    private final Marker aMarker;

    public ElasticStoreAction(final ActionExecutionAudit action, final Logger log,
                              final Object elasticStore) {
        this.elasticStore = (ElasticStore) elasticStore;
        this.action = action;
        this.log = log;
        this.aMarker = MarkerFactory.getMarker(" ElasticStore:" + this.elasticStore.getName());
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
            final String host = elasticStore.getHost();
            final String userName = elasticStore.getUser();
            final String password = elasticStore.getPassword();
            final String indexName = elasticStore.getIndexName();
            final String indexType = elasticStore.getIndexType();
            final String indexId = String.valueOf(System.currentTimeMillis());
            final String dataNode = elasticStore.getDataNode();
            final ElasticsearchClient elasticsearchClient = getElasticsearchClient(userName, password, host);
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
            IndexResponse indexResponse = elasticsearchClient.index(IndexRequest.of(indexReq -> indexReq
                    .index(indexName)
                    .id(indexId)
                    .document(dataNode))
            );
            log.info(aMarker, "response status {} payloadID {}", indexResponse.index(), indexResponse.id());

        } catch (IOException ex) {
            throw new Exception("Index save failed", ex);
        }
    }

    @Override
    public boolean executeIf() throws Exception {
        return elasticStore.getCondition();
    }
}
