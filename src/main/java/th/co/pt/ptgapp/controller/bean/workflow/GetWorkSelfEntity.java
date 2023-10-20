package th.co.pt.ptgapp.controller.bean.workflow;

public class GetWorkSelfEntity {
	
	private String system;
	private String bound;
	private String requestID;
	private String employee;
	private String wfStatus;
	private String wfStep;
	private String wfDate;
	private String wfTime;
	private String errorCode;
	private String errorMsg;
	private String remark;
	private String reqBy;
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getBound() {
		return bound;
	}
	public void setBound(String bound) {
		this.bound = bound;
	}
	public String getRequestID() {
		return requestID;
	}
	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String getWfStatus() {
		return wfStatus;
	}
	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}
	public String getWfStep() {
		return wfStep;
	}
	public void setWfStep(String wfStep) {
		this.wfStep = wfStep;
	}
	public String getWfDate() {
		return wfDate;
	}
	public void setWfDate(String wfDate) {
		this.wfDate = wfDate;
	}
	public String getWfTime() {
		return wfTime;
	}
	public void setWfTime(String wfTime) {
		this.wfTime = wfTime;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getReqBy() {
		return reqBy;
	}
	public void setReqBy(String reqBy) {
		this.reqBy = reqBy;
	}
	@Override
	public String toString() {
		return "GetWorkSelfEntity [system=" + system + ", bound=" + bound + ", requestID=" + requestID + ", employee="
				+ employee + ", wfStatus=" + wfStatus + ", wfStep=" + wfStep + ", wfDate=" + wfDate + ", wfTime="
				+ wfTime + ", errorCode=" + errorCode + ", errorMsg=" + errorMsg + ", remark=" + remark + ", reqBy="
				+ reqBy + "]";
	}
	
}
