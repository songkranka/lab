package th.co.pt.ptgapp.controller.bean;

public class RandomPlantMeterEntity {
	
	private String transId;
	private String workDtm;
	private String workMonth;
	private String seq;
	private String plantId;
	private String plantName;
	private String productId;
	private String productName;
	private String meterNo;
	private String createBy;
	private String createDate;
	private String updateBy;
	private String updateDate;

	private final int DD = 0;
	private final int MM = 1;
	private final int YYYY = 2;
	
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	public String getWorkDtm() {
		return workDtm;
	}
	public void setWorkDtm(String workDtm) {
		this.workDtm = workDtm;
	}
	public String getWorkDtmDB() {
		return new StringBuffer(append(workDtm.split("/")[YYYY], "0000")).append(append(workDtm.split("/")[MM], "00")).append(append(workDtm.split("/")[DD], "00")).toString();
	}
	public String getWorkMonth() {
		return workMonth;
	}
	public void setWorkMonth(String workMonth) {
		this.workMonth = workMonth;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getPlantId() {
		return plantId;
	}
	public void setPlantId(String plantId) {
		this.plantId = plantId;
	}
	public String getPlantName() {
		return plantName;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getMeterNo() {
		return meterNo;
	}
	public void setMeterNo(String meterNo) {
		this.meterNo = meterNo;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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
	
	@Override
	public String toString() {
		return "RandomPlantMeterEntity [workDtm=" + workDtm + ", seq=" + seq + ", plantId=" + plantId + ", plantName="
				+ plantName + ", productId=" + productId + ", productName=" + productName + ", meterNo=" + meterNo
				+ ", getWorkDtm()=" + getWorkDtm() + ", getSeq()=" + getSeq() + ", getPlantId()=" + getPlantId()
				+ ", getPlantName()=" + getPlantName() + ", getProductId()=" + getProductId() + ", getProductName()="
				+ getProductName() + ", getMeterNo()=" + getMeterNo() + "]";
	}
	
	private final String append(String target, String format) {
		return new StringBuffer().append(format.substring(0, format.length()-target.length())).append(target).toString();
		//return format.substring(0, format.length()-target.length())+target;
	}
}
