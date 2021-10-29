package in.handyman.raven.process;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import in.handyman.raven.util.UniqueID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class Context {

    @Builder.Default
    private Long lambdaId = UniqueID.getId();
    private String lambdaName;
    private String name;
    @Builder.Default
    private Integer status = ProcessStatus.STARTED;

    private Long processId;
    private String processName;
    private Map<String, String> context;

    @Builder.Default
    private ObjectNode detailMap = JsonNodeFactory.instance.objectNode();

    public void setStatus(final Integer status) {
        if (ProcessStatus.STARTED.equals(status)) {
            this.status = status;
        }
    }

}
