package in.handyman.raven.lib;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import in.handyman.raven.exception.HandymanException;
import in.handyman.raven.lambda.action.ActionExecution;
import in.handyman.raven.lambda.action.IActionExecution;
import in.handyman.raven.lambda.doa.audit.ActionExecutionAudit;
import in.handyman.raven.lib.model.DocnetAttribution;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Auto Generated By Raven
 */
@ActionExecution(
    actionName = "DocnetAttribution"
)
public class DocnetAttributionAction implements IActionExecution {
  private final ActionExecutionAudit action;

  private final Logger log;

  private final DocnetAttribution docnetAttribution;

  private final Marker aMarker;
  private final String URI;
  private final ObjectMapper mapper = new ObjectMapper();
  private static final MediaType MediaTypeJSON = MediaType.parse("application/json; charset=utf-8");

  public DocnetAttributionAction(final ActionExecutionAudit action, final Logger log,
      final Object docnetAttribution) {
    this.docnetAttribution = (DocnetAttribution) docnetAttribution;
    this.action = action;
    this.log = log;
    this.aMarker = MarkerFactory.getMarker(" DocnetAttribution:"+this.docnetAttribution.getName());
    this.URI=action.getContext().get("copro.docnet-attribution.url");
  }

  @Override
  public void execute() throws Exception {
    final OkHttpClient httpclient = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.MINUTES)
            .writeTimeout(10, TimeUnit.MINUTES)
            .readTimeout(10, TimeUnit.MINUTES).build();


    log.info(aMarker, "The request got it successfully for Asset ID and QA List {} {}",
            docnetAttribution.getName(),docnetAttribution.getQuestionList());

    final ObjectNode objectNode = mapper.createObjectNode();

    JsonNode questionList=mapper.readTree(docnetAttribution.getQuestionList());
    JsonNode keyName = questionList.get("f1");
    String multipleQaList = questionList.get("f2").toString();
    objectNode.put("inputFilePath",docnetAttribution.getInputFilePath());
    objectNode.set("attributes",mapper.readTree(multipleQaList));

    Request request = new Request.Builder().url(URI)
            .post(RequestBody.create(objectNode.toString(),MediaTypeJSON)).build();

    try (Response response = httpclient.newCall(request).execute()) {
      String responseBody = response.body().string();
      String name = docnetAttribution.getName() + "_response";
      log.info(aMarker, "The response got it successfully for Asset ID and Attribution List {}",
              responseBody);

      JsonNode actualObj = mapper.readTree(responseBody);

      JsonNode attributeKeys = questionList.get("f2");
      ArrayList<String> attributionResult = new ArrayList<String>();
      for (JsonNode fieldName : attributeKeys) {
        JsonNode value = actualObj.get("attributionValue").get(fieldName.asText());
        attributionResult.add(value.toString());
      }
      ObjectNode resultNode = mapper.createObjectNode();
      resultNode.put("key_name", keyName.asText());
      resultNode.put("attribution_result", attributionResult.toString());
      if (response.isSuccessful()) {
        action.getContext().put(name, resultNode.toString());
        action.getContext().put(name.concat(".error"), "false");
        log.info(aMarker, "The Successful Response  {} {}", name, responseBody);
      } else {
        action.getContext().put(name.concat(".error"), "true");
        log.info(aMarker, "The Failure Response  {} {}", name, responseBody);
      }
    }catch (Exception e){
      log.info(aMarker, "The Exception occurred ",e);
      throw new HandymanException("Failed to execute", e);
    }
  }

  @Override
  public boolean executeIf() throws Exception {
    return docnetAttribution.getCondition();
  }
}
