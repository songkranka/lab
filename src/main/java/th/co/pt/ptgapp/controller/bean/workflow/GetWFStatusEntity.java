package th.co.pt.ptgapp.controller.bean.workflow;

import java.util.List;

public class GetWFStatusEntity {

	private String system;
	private String process;
	private String requestID;
	private String codempid;
	private String fullEmpName;
	private String wfStep;
	private String wfStatus;
	private String errorMsg;
	private String errorCode;
	private String remark;
	private List<StatusWFHistoryEntity> historyStatus;
	
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getRequestID() {
		return requestID;
	}
	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCodempid() {
		return codempid;
	}
	public void setCodempid(String codempid) {
		this.codempid = codempid;
	}
	public String getFullEmpName() {
		return fullEmpName;
	}
	public void setFullEmpName(String fullEmpName) {
		this.fullEmpName = fullEmpName;
	}
	public String getWfStep() {
		return wfStep;
	}
	public void setWfStep(String wfStep) {
		this.wfStep = wfStep;
	}
	public String getWfStatus() {
		return wfStatus;
	}
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}
	public List<StatusWFHistoryEntity> getHistoryStatus() {
		return historyStatus;
	}
	public void setHistoryStatus(List<StatusWFHistoryEntity> historyStatus) {
		this.historyStatus = historyStatus;
	}
}
