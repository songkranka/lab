package th.co.pt.ptgapp.controller.bean.workflow;

import java.util.List;

public class ReturnAssignmentEntity {
	
	private String system;
	private String errorMsg;
	private String errorcode;
	private String process;
	private String requestID;
	private String remark;
	private String reqBy;
	private String product; 
	private String sampleType; 
	
	private List<ReturnAssignmentDtlEntity> detail;
	
	
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
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
	public String getReqBy() {
		return reqBy;
	}
	public void setReqBy(String reqBy) {
		this.reqBy = reqBy;
	}
	public List<ReturnAssignmentDtlEntity> getDetail() {
		return detail;
	}
	public void setDetail(List<ReturnAssignmentDtlEntity> detail) {
		this.detail = detail;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getSampleType() {
		return sampleType;
	}
	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}
	@Override
	public String toString() {
		return "ReturnAssignmentEntity [system=" + system + ", errorMsg=" + errorMsg + ", errorcode=" + errorcode
				+ ", process=" + process + ", requestID=" + requestID + ", remark=" + remark + ", reqBy=" + reqBy
				+ ", product=" + product + ", sampleType=" + sampleType + ", detail=" + detail + "]";
	}
	
}
