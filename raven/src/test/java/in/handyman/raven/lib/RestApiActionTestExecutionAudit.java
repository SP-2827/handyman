package in.handyman.raven.lib;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import in.handyman.raven.lambda.process.HRequestResolver;
import in.handyman.raven.lambda.process.LContext;
import in.handyman.raven.lambda.process.LambdaEngine;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

@Slf4j
class RestApiActionTestExecutionAudit {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void execute() {
        ObjectNode objectNode = objectMapper.createObjectNode();

        ObjectNode node = objectMapper.createObjectNode();
        ObjectNode node2 = objectMapper.createObjectNode();

        node.put("faxReferenceId", "AGA-REF-ID-001");
        node.put("callBackUrl", "AGA-REF-ID-001");
        node.put("faxChecksum", "bccf7e4800b32ed0e272acd436bfa32c3f3ec393");
        node.put("faxFileUri", "https://www.tutorialspoint.com/java/pdf/java_interfaces.pdf");

        node2.put("faxReferenceId", "AGA-REF-ID-002");
        node2.put("callBackUrl", "AGA-REF-ID-001");
        node2.put("faxChecksum", "72acd436bfa32c3f3ec393");
        node2.put("faxFileUri", "https://www.tutorialspoint.com/java/pdf/java_interfaces.pdf");

        objectNode.putPOJO("faxDocument", List.of(node, node2));

        LContext request = LContext.builder()
                .pipelineName("fax.processing.producer")
                .processLoadType(HRequestResolver.LoadType.FILE.name())
                .inheritedContext(Map.of("request", objectNode.toString()))
                .build();

        log.info(request.toString());
        LambdaEngine.start(request);
    }


    @Test
    public void testTruthAttributionDDL() {
        LContext request = LContext.builder()
                .pipelineName("db.test")
                .processLoadType(HRequestResolver.LoadType.FILE.name())
                .build();
        log.info(request.toString());
        LambdaEngine.start(request);
    }


    @Test
    public void denoiseMainCaller() {
        LContext request = LContext.builder()
                .pipelineName("denoise.main.caller")
                .processLoadType(HRequestResolver.LoadType.FILE.name())
                .build();
        log.info(request.toString());
        LambdaEngine.start(request);
    }

    @Test
    public void rootTest() {
        LContext request = LContext.builder()
                .pipelineName("root.processor")
                .processLoadType(HRequestResolver.LoadType.FILE.name())
                .build();
        log.info(request.toString());
        LambdaEngine.start(request);
    }
    @Test
    public void testTruthAttributionSummoning() {
        LContext request = LContext.builder()
                .pipelineName("truth.attribution.summoning")
                .processLoadType(HRequestResolver.LoadType.FILE.name())
                .build();
        log.info(request.toString());
        LambdaEngine.start(request);
    }




    @Test
    void executeQR() {
        LambdaEngine.start(LContext.builder()
                .pipelineName("qr.grouping.process")
                .processLoadType(HRequestResolver.LoadType.FILE.name())
                .inheritedContext(Map.of("batch_id", "12"))
                .build());
    }

}
