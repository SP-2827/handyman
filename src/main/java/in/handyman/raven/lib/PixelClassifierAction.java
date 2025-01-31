package in.handyman.raven.lib;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import in.handyman.raven.exception.HandymanException;
import in.handyman.raven.lambda.action.ActionExecution;
import in.handyman.raven.lambda.action.IActionExecution;
import in.handyman.raven.lambda.doa.audit.ActionExecutionAudit;
import in.handyman.raven.lib.model.PixelClassifier;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Auto Generated By Raven
 */
@ActionExecution(
        actionName = "PixelClassifier"
)
public class PixelClassifierAction implements IActionExecution {
    private static final MediaType MediaTypeJSON = MediaType
            .parse("application/json; charset=utf-8");
    private final ActionExecutionAudit action;
    private final Logger log;
    private final PixelClassifier pixelClassifier;
    private final Marker aMarker;
    private final ObjectMapper mapper = new ObjectMapper();
    private final String URI;

    public PixelClassifierAction(final ActionExecutionAudit action, final Logger log,
                                 final Object pixelClassifier) {
        this.pixelClassifier = (PixelClassifier) pixelClassifier;
        this.action = action;
        this.log = log;
        this.aMarker = MarkerFactory.getMarker(" PixelClassifier:" + this.pixelClassifier.getName());
        this.URI = action.getContext().get("copro.pixel-classifier.url");

    }

    @Override
    public void execute() throws Exception {

        log.info(aMarker, "<-------Pixel Classifier Action for {} has been started------->" + pixelClassifier.getName());
        final OkHttpClient httpclient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.MINUTES)
                .writeTimeout(10, TimeUnit.MINUTES)
                .readTimeout(10, TimeUnit.MINUTES)
                .build();

        final ObjectNode objectNode = mapper.createObjectNode();

        objectNode.put("inputFilePath", pixelClassifier.getInputFilePath());
        objectNode.put("outputDir", pixelClassifier.getOutputDir());
        objectNode.put("modelFilePath", pixelClassifier.getModelFilePath());
        objectNode.set("labels", mapper.readTree(pixelClassifier.getLabels()));

        log.info(aMarker, " Input variables id : {}", action.getActionId());
        Request request = new Request.Builder().url(URI)
                .post(RequestBody.create(objectNode.toString(), MediaTypeJSON)).build();

        log.debug(aMarker, "Request has been build with the parameters \n URI : {} \n Input-File-Path : {} \n Output-Directory : {} \n Model-Path : {} \n Path-Labels : {}", URI, pixelClassifier.getInputFilePath(), pixelClassifier.getOutputDir(), pixelClassifier.getModelFilePath(), pixelClassifier.getLabels());
        String name = pixelClassifier.getName() + "_response";
        log.debug(aMarker, "The Request Details: {}", request);
        try (Response response = httpclient.newCall(request).execute()) {
            String responseBody = response.body().string();
            String labelName = pixelClassifier.getName() + "_label";
            if (response.isSuccessful()) {
                action.getContext().put(name, responseBody);
                action.getContext().put(labelName, Optional.ofNullable(mapper.readTree(responseBody).get("label")).map(JsonNode::asText).map(String::toLowerCase).orElseThrow());
                action.getContext().put(name.concat(".error"), "false");
                log.info(aMarker, "The Successful Response for {} --> {}", name, responseBody);
            } else {
                action.getContext().put(name.concat(".error"), "true");
                action.getContext().put(name.concat(".errorMessage"), responseBody);
                log.info(aMarker, "The Failure Response {} --> {}", name, responseBody);
            }
            log.info(aMarker, "<-------Pixel Classifier Action for {} has been completed------->" + pixelClassifier.getName());
        } catch (Exception e) {
            action.getContext().put(name.concat(".error"), "true");
            action.getContext().put(name.concat(".errorMessage"), e.getMessage());
            log.info(aMarker, "The Exception occurred ", e);
            throw new HandymanException("Failed to execute", e);
        }
    }

    @Override
    public boolean executeIf() throws Exception {
        return pixelClassifier.getCondition();
    }
}
