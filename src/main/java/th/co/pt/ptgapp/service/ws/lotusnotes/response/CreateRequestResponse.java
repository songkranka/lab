package th.co.pt.ptgapp.service.ws.lotusnotes.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateRequestResponse implements Serializable {

    private String system;
    private String errorMsg;
    private String errorCode;
    private String process;
    private String requestID;
    private String remark;

    private List<DetailForCreate> detail;

    @JsonProperty("System")
    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    @JsonProperty("ErrorMsg")
    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @JsonProperty("Errorcode")
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @JsonProperty("Process")
    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    @JsonProperty("RequestID")
    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    @JsonProperty("Remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @JsonProperty("Detail")
    public List<DetailForCreate> getDetail() {
        return detail;
    }

    public void setDetail(List<DetailForCreate> detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "CreateRequestResponse{" +
                "system='" + system + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", process='" + process + '\'' +
                ", requestID='" + requestID + '\'' +
                ", remark='" + remark + '\'' +
                ", detail=" + detail +
                '}';
    }
}
