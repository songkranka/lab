package th.co.pt.ptgapp.controller.bean.report;

public class MbServiceStationEntity {
	
	/** parameter info **/
	private String t;
	private String rn;
	private String rt;
	
	/** report info **/
	private String reportID;
	private String reportNo;
	private String reportName;
	private String reportType; // 1 = pdf, 2 = excel
	private String requestDate;
	private String requestBy;
	private String generateDate;

	/** report detail **/
	
	private String mb_ds_seq;
	private String mb_station_seq;
	private String mb_trip_id;
	private String mb_trip_date;
	private String mb_trip_year;
	private String mb_trip_station;
	private String mb_product_id;
	private String mb_product_name;
	private String mb_percent_dregs;
	private String mb_percent_et;
	private String mb_percent_fame;
	private String mb_ibp;
	private String mb_fbp;
	private String mb_ltr_color;
	private String mb_ltr_feature;
	private String mb_ltr_api;
	private String mb_ltr_temp;
	private String mb_ltr_api60;
	private String mb_ltr_distill;
	private String mb_ltr_t10;
	private String mb_ltr_t50;
	private String mb_ltr_t90;
	private String mb_ltr_fp;
	private String mb_ltr_ci;
	private String mb_ltr_ron;
	private String mb_ltr_mon;
	private String mb_ltr_ag;
	private String mb_ltr_result;
	private String mb_ltr_stickerNo;
	private String mb_ltr_sediment;

	private String orgName;
	private String part;
	
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
	public String getMb_ds_seq() {
		return mb_ds_seq;
	}
	public void setMb_ds_seq(String mb_ds_seq) {
		this.mb_ds_seq = mb_ds_seq;
	}
	public String getMb_station_seq() {
		return mb_station_seq;
	}
	public void setMb_station_seq(String mb_station_seq) {
		this.mb_station_seq = mb_station_seq;
	}
	public String getMb_trip_id() {
		return mb_trip_id;
	}
	public void setMb_trip_id(String mb_trip_id) {
		this.mb_trip_id = mb_trip_id;
	}
	public String getMb_trip_date() {
		return mb_trip_date;
	}
	public void setMb_trip_date(String mb_trip_date) {
		this.mb_trip_date = mb_trip_date;
	}
	public String getMb_trip_year() {
		return mb_trip_year;
	}
	public void setMb_trip_year(String mb_trip_year) {
		this.mb_trip_year = mb_trip_year;
	}
	public String getMb_trip_station() {
		return mb_trip_station;
	}
	public void setMb_trip_station(String mb_trip_station) {
		this.mb_trip_station = mb_trip_station;
	}
	public String getMb_product_id() {
		return mb_product_id;
	}
	public void setMb_product_id(String mb_product_id) {
		this.mb_product_id = mb_product_id;
	}
	public String getMb_product_name() {
		return mb_product_name;
	}
	public void setMb_product_name(String mb_product_name) {
		this.mb_product_name = mb_product_name;
	}
	public String getMb_percent_dregs() {
		return mb_percent_dregs;
	}
	public void setMb_percent_dregs(String mb_percent_dregs) {
		this.mb_percent_dregs = mb_percent_dregs;
	}
	public String getMb_percent_et() {
		return mb_percent_et;
	}
	public void setMb_percent_et(String mb_percent_et) {
		this.mb_percent_et = mb_percent_et;
	}
	public String getMb_percent_fame() {
		return mb_percent_fame;
	}
	public void setMb_percent_fame(String mb_percent_fame) {
		this.mb_percent_fame = mb_percent_fame;
	}
	public String getMb_ibp() {
		return mb_ibp;
	}
	public void setMb_ibp(String mb_ibp) {
		this.mb_ibp = mb_ibp;
	}
	public String getMb_fbp() {
		return mb_fbp;
	}
	public void setMb_fbp(String mb_fbp) {
		this.mb_fbp = mb_fbp;
	}
	public String getMb_ltr_color() {
		return mb_ltr_color;
	}
	public void setMb_ltr_color(String mb_ltr_color) {
		this.mb_ltr_color = mb_ltr_color;
	}
	public String getMb_ltr_feature() {
		return mb_ltr_feature;
	}
	public void setMb_ltr_feature(String mb_ltr_feature) {
		this.mb_ltr_feature = mb_ltr_feature;
	}
	public String getMb_ltr_api() {
		return mb_ltr_api;
	}
	public void setMb_ltr_api(String mb_ltr_api) {
		this.mb_ltr_api = mb_ltr_api;
	}
	public String getMb_ltr_temp() {
		return mb_ltr_temp;
	}
	public void setMb_ltr_temp(String mb_ltr_temp) {
		this.mb_ltr_temp = mb_ltr_temp;
	}
	public String getMb_ltr_api60() {
		return mb_ltr_api60;
	}
	public void setMb_ltr_api60(String mb_ltr_api60) {
		this.mb_ltr_api60 = mb_ltr_api60;
	}
	public String getMb_ltr_distill() {
		return mb_ltr_distill;
	}
	public void setMb_ltr_distill(String mb_ltr_distill) {
		this.mb_ltr_distill = mb_ltr_distill;
	}
	public String getMb_ltr_t10() {
		return mb_ltr_t10;
	}
	public void setMb_ltr_t10(String mb_ltr_t10) {
		this.mb_ltr_t10 = mb_ltr_t10;
	}
	public String getMb_ltr_t50() {
		return mb_ltr_t50;
	}
	public void setMb_ltr_t50(String mb_ltr_t50) {
		this.mb_ltr_t50 = mb_ltr_t50;
	}
	public String getMb_ltr_t90() {
		return mb_ltr_t90;
	}
	public void setMb_ltr_t90(String mb_ltr_t90) {
		this.mb_ltr_t90 = mb_ltr_t90;
	}
	public String getMb_ltr_fp() {
		return mb_ltr_fp;
	}
	public void setMb_ltr_fp(String mb_ltr_fp) {
		this.mb_ltr_fp = mb_ltr_fp;
	}
	public String getMb_ltr_ci() {
		return mb_ltr_ci;
	}
	public void setMb_ltr_ci(String mb_ltr_ci) {
		this.mb_ltr_ci = mb_ltr_ci;
	}
	public String getMb_ltr_ron() {
		return mb_ltr_ron;
	}
	public void setMb_ltr_ron(String mb_ltr_ron) {
		this.mb_ltr_ron = mb_ltr_ron;
	}
	public String getMb_ltr_mon() {
		return mb_ltr_mon;
	}
	public void setMb_ltr_mon(String mb_ltr_mon) {
		this.mb_ltr_mon = mb_ltr_mon;
	}
	public String getMb_ltr_ag() {
		return mb_ltr_ag;
	}
	public void setMb_ltr_ag(String mb_ltr_ag) {
		this.mb_ltr_ag = mb_ltr_ag;
	}
	public String getMb_ltr_result() {
		return mb_ltr_result;
	}
	public void setMb_ltr_result(String mb_ltr_result) {
		this.mb_ltr_result = mb_ltr_result;
	}
	public String getMb_ltr_stickerNo() {
		return mb_ltr_stickerNo;
	}
	public void setMb_ltr_stickerNo(String mb_ltr_stickerNo) {
		this.mb_ltr_stickerNo = mb_ltr_stickerNo;
	}
	public String getMb_ltr_sediment() {
		return mb_ltr_sediment;
	}
	public void setMb_ltr_sediment(String mb_ltr_sediment) {
		this.mb_ltr_sediment = mb_ltr_sediment;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public void setExample(){
		setMb_ds_seq("1");
		setMb_station_seq("1");
		setMb_trip_id("1901210001");
		setMb_trip_date("16/01/2019");
		setMb_trip_year("2019");
		setMb_trip_station("2");
		setMb_product_id("");
		setMb_product_name("");
		setMb_percent_dregs("");
		setMb_percent_et("");
		setMb_percent_fame("");
		setMb_ibp("");
		setMb_fbp("");
		setMb_ltr_color("");
		setMb_ltr_feature("");
		setMb_ltr_api("");
		setMb_ltr_temp("");
		setMb_ltr_api60("");
		setMb_ltr_distill("");
		setMb_ltr_t10("");
		setMb_ltr_t50("");
		setMb_ltr_t90("");
		setMb_ltr_fp("");
		setMb_ltr_ci("");
		setMb_ltr_ron("");
		setMb_ltr_mon("");
		setMb_ltr_ag("");
		setMb_ltr_result("");
		setMb_ltr_stickerNo("");
		setMb_ltr_sediment("");
		setOrgName("");
		setPart("");
	}

	@Override
	public String toString() {
		return "MbServiceStationEntity [ "
				+ "\n   reportID=" + reportID 
				+ "\n,  reportNo=" + reportNo 
				+ "\n,  reportName=" + reportName 
				+ "\n,  reportType=" + reportType 
				+ "\n,  requestDate=" + requestDate 
				+ "\n,  requestBy=" + requestBy 
				+ "\n,  generateDate=" + generateDate 
				+ "\n,  mb_ds_seq=" + mb_ds_seq 
				+ "\n,  mb_station_seq=" + mb_station_seq 
				+ "\n,  mb_trip_id=" + mb_trip_id 
				+ "\n,  mb_trip_date=" + mb_trip_date 
				+ "\n,  mb_trip_year=" + mb_trip_year 
				+ "\n,  mb_trip_station=" + mb_trip_station 
				+ "\n,  mb_product_id=" + mb_product_id 
				+ "\n,  mb_product_name=" + mb_product_name 
				+ "\n,  mb_percent_dregs=" + mb_percent_dregs 
				+ "\n,  mb_percent_et=" + mb_percent_et 
				+ "\n,  mb_percent_fame=" + mb_percent_fame 
				+ "\n,  mb_ibp=" + mb_ibp 
				+ "\n,  mb_fbp=" + mb_fbp 
				+ "\n,  mb_ltr_color=" + mb_ltr_color 
				+ "\n,  mb_ltr_feature=" + mb_ltr_feature 
				+ "\n,  mb_ltr_api=" + mb_ltr_api 
				+ "\n,  mb_ltr_temp=" + mb_ltr_temp 
				+ "\n,  mb_ltr_api60=" + mb_ltr_api60 
				+ "\n,  mb_ltr_distill=" + mb_ltr_distill 
				+ "\n,  mb_ltr_t10=" + mb_ltr_t10 
				+ "\n,  mb_ltr_t50=" + mb_ltr_t50 
				+ "\n,  mb_ltr_t90=" + mb_ltr_t90 
				+ "\n,  mb_ltr_fp=" + mb_ltr_fp 
				+ "\n,  mb_ltr_ci=" + mb_ltr_ci 
				+ "\n,  mb_ltr_ron=" + mb_ltr_ron 
				+ "\n,  mb_ltr_mon=" + mb_ltr_mon 
				+ "\n,  mb_ltr_ag=" + mb_ltr_ag 
				+ "\n,  mb_ltr_result=" + mb_ltr_result 
				+ "\n,  mb_ltr_stickerNo=" + mb_ltr_stickerNo 
				+ "\n,  mb_ltr_sediment=" + mb_ltr_sediment 
				+ "\n]";  
	}

	

}
