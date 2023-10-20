package th.co.pt.ptgapp.service.ws.lotusnotes.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Substitue implements Serializable {

    private String substitueID;
    private String substitueName;

    @JsonProperty("SubstitueID")
    public String getSubstitueID() {
        return substitueID;
    }

    public void setSubstitueID(String substitueID) {
        this.substitueID = substitueID;
    }
    @JsonProperty("SubstitueName")
    public String getSubstitueName() {
        return substitueName;
    }

    public void setSubstitueName(String substitueName) {
        this.substitueName = substitueName;
    }
}
