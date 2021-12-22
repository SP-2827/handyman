package in.handyman.raven.lib.model;

import in.handyman.raven.lambda.action.ActionContext;
import in.handyman.raven.lambda.action.IActionContext;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Auto Generated By Raven
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@ActionContext(
        actionName = "ExtractTAR"
)
public class ExtractTAR implements IActionContext {
    private String name;

    private String source;

    private String destination;

    private String value;

    private Boolean condition = true;
}
