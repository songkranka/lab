package th.co.pt.ptgapp.controller.bean.workflow;

import java.util.List;

public class GetMasterEntity {

	private String system ;
	private String table;
	private String errorCode;
	private String errorMsg;
	private String remark;
	private List<MasterListEntity> listMasterValue;
	
	public GetMasterEntity() {}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
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

	public List<MasterListEntity> getListMasterValue() {
		return listMasterValue;
	}

	public void setListMasterValue(List<MasterListEntity> listMasterValue) {
		this.listMasterValue = listMasterValue;
	}

}
