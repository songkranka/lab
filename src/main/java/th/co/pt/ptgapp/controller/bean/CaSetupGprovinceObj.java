package th.co.pt.ptgapp.controller.bean;

//import java.math.BigDecimal;
import java.util.List;




public class CaSetupGprovinceObj {
	private String gpmId;
	private String gpmName;
	private String compId;
	private String compName;
	private String minLvName;
	private String maxLvName;
	private String maxLv;
	private String minLv;
	private String amount;
	private String createBy;
	private String updateBy;
	private String updateDate;
	private int success;
	private String message;
	private List<CaSetupGprovinceObj> caSetupGprovinceObj;
	
	
	
	
	public String getGpmId() {
		return gpmId;
	}
	public void setGpmId(String gpmId) {
		this.gpmId = gpmId;
	}
	public String getGpmName() {
		return gpmName;
	}
	public void setGpmName(String gpmName) {
		this.gpmName = gpmName;
	}
	public String getCompId() {
		return compId;
	}
	public void setCompId(String compId) {
		this.compId = compId;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getMinLvName() {
		return minLvName;
	}
	public void setMinLvName(String minLvName) {
		this.minLvName = minLvName;
	}
	public String getMaxLvName() {
		return maxLvName;
	}
	public void setMaxLvName(String maxLvName) {
		this.maxLvName = maxLvName;
	}
	public String getMaxLv() {
		return maxLv;
	}
	public void setMaxLv(String maxLv) {
		this.maxLv = maxLv;
	}
	public String getMinLv() {
		return minLv;
	}
	public void setMinLv(String minLv) {
		this.minLv = minLv;
	}
	
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public List<CaSetupGprovinceObj> getCaSetupGprovinceObj() {
		return caSetupGprovinceObj;
	}
	public void setCaSetupGprovinceObj(List<CaSetupGprovinceObj> caSetupGprovinceObj) {
		this.caSetupGprovinceObj = caSetupGprovinceObj;
	}
	
	
	
	
	
}
