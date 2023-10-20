package th.co.pt.ptgapp.controller.bean;

public class ReportInfoEntity {

	/** parameter info **/
	private String t;
	private String rn;
	private String rt;
	private String ri;

	/** report info **/
	private String reportID;
	private String reportNo;
	private String reportName;
	private String reportType; // 1 = pdf, 2 = excel
	private String requestDate;
	private String requestBy;
	private String generateDate;
	private String runningDate;
	
	/** report criteria **/
	private String mb_trip_id;
	
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
		setMb_trip_id(t);
	}
	public String getRn() {
		return rn;
	}
	public void setRn(String rn) {
		this.rn = rn;
		setReportNo(rn);
	}
	public String getRt() {
		return rt;
	}
	public void setRt(String rt) {
		this.rt = rt;
		setReportType(rt);
	}
	public String getRi() {
		return ri;
	}
	public void setRi(String ri) {
		this.ri = ri;
		setReportID(getRi());
	}
	public String getReportID() {
		return reportID;
	}
	public void setReportID(String reportID) {
		this.reportID = reportID;
	}
	public String getReportNo() {
		return reportNo;
	}
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getRequestBy() {
		return requestBy;
	}
	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}
	public String getGenerateDate() {
		return generateDate;
	}
	public void setGenerateDate(String generateDate) {
		this.generateDate = generateDate;
	}
	public String getRunningDate() {
		return runningDate;
	}
	public void setRunningDate(String runningDate) {
		this.runningDate = runningDate;
	}
	public String getMb_trip_id() {
		return mb_trip_id;
	}
	public void setMb_trip_id(String mb_trip_id) {
		this.mb_trip_id = mb_trip_id;
	}
	

	
}
