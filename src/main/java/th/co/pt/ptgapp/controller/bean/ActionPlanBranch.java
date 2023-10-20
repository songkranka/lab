package th.co.pt.ptgapp.controller.bean;

import java.util.List;

 
public class ActionPlanBranch {

    private String trip_id ;
	private String codcomp ;
	private String codcomp_name ;
    private String create_by;
    private String create_date ;
    private String update_by ;
    private String update_date ;
    private String complete_flg ;
    private String status ;
    private String cnt_station ;
    private String cnt_station_perday;
    private String total_day ;
    private String allowce_amt_total ;
    private String hotel_cnt_night ;
    private String hotel_cnt_room ;
    private String hotel_amt_total ;
    private String total_mile_station ;
    private String oil_per_liter ;
    private String car_amt;
    private String amt_other;
    private String expense_perstation;
    private String total_amount ; 
	private String plandate ;
	private String plan_desc ;
    private String plan_begin;
    private String place_begin ;
    private String place_destination ;
    private String mile_total ;
    private String center_code ; 
    private String addr_tumbon;
    private String addr_aumphur ;
    private String addr_province ; 
    private String plan_dte_id ;  
	private String codempid ;
	private String namempt;
    private String codpos;
    private String namepost ;
    private String roleId;
    private String createBy;
    private String result;  
	private String message;
	private String tripName;
	private String orgCode;
	private String orgName;
	private String seq;
	private String cost_center; 
	private String region;
	private String area;
	private String province;
	private String roleIdToo;
	private String reviceOil;
	private String update_flg;
	private String startDate;
	private String endDate;
	private String typeStation;
	
	
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getTypeStation() {
		return typeStation;
	}
	public void setTypeStation(String typeStation) {
		this.typeStation = typeStation;
	}
	private List<ActionPlanBranch> data_station;
	private List<ActionPlanBranch> data_officer;
  
	 public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getCost_center() {
		return cost_center;
	}
	public void setCost_center(String cost_center) {
		this.cost_center = cost_center;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
    public String getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(String trip_id) {
		this.trip_id = trip_id;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getTripName() {
		return tripName;
	}
	public void setTripName(String tripName) {
		this.tripName = tripName;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
	 public String getRoleId() {
			return roleId;
	 }
	 public void setRoleId(String roleId) {
			this.roleId = roleId;
	 }
     
	public String getCodcomp() {
		return codcomp;
	}
	public void setCodcomp(String codcomp) {
		this.codcomp = codcomp;
	}
	public String getCodcomp_name() {
		return codcomp_name;
	}
	public void setCodcomp_name(String codcomp_name) {
		this.codcomp_name = codcomp_name;
	}
	public String getCreate_by() {
		return create_by;
	}
	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getUpdate_by() {
		return update_by;
	}
	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getComplete_flg() {
		return complete_flg;
	}
	public void setComplete_flg(String complete_flg) {
		this.complete_flg = complete_flg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCnt_station() {
		return cnt_station;
	}
	public void setCnt_station(String cnt_station) {
		this.cnt_station = cnt_station;
	}
	public String getCnt_station_perday() {
		return cnt_station_perday;
	}
	public void setCnt_station_perday(String cnt_station_perday) {
		this.cnt_station_perday = cnt_station_perday;
	}
	public String getTotal_day() {
		return total_day;
	}
	public void setTotal_day(String total_day) {
		this.total_day = total_day;
	}
	public String getAllowce_amt_total() {
		return allowce_amt_total;
	}
	public void setAllowce_amt_total(String allowce_amt_total) {
		this.allowce_amt_total = allowce_amt_total;
	}
	public String getHotel_cnt_night() {
		return hotel_cnt_night;
	}
	public void setHotel_cnt_night(String hotel_cnt_night) {
		this.hotel_cnt_night = hotel_cnt_night;
	}
	public String getHotel_cnt_room() {
		return hotel_cnt_room;
	}
	public void setHotel_cnt_room(String hotel_cnt_room) {
		this.hotel_cnt_room = hotel_cnt_room;
	}
	public String getHotel_amt_total() {
		return hotel_amt_total;
	}
	public void setHotel_amt_total(String hotel_amt_total) {
		this.hotel_amt_total = hotel_amt_total;
	}
	public String getTotal_mile_station() {
		return total_mile_station;
	}
	public void setTotal_mile_station(String total_mile_station) {
		this.total_mile_station = total_mile_station;
	}
	public String getOil_per_liter() {
		return oil_per_liter;
	}
	public void setOil_per_liter(String oil_per_liter) {
		this.oil_per_liter = oil_per_liter;
	}
	public String getCar_amt() {
		return car_amt;
	}
	public void setCar_amt(String car_amt) {
		this.car_amt = car_amt;
	}
	public String getAmt_other() {
		return amt_other;
	}
	public void setAmt_other(String amt_other) {
		this.amt_other = amt_other;
	}
	public String getExpense_perstation() {
		return expense_perstation;
	}
	public void setExpense_perstation(String expense_perstation) {
		this.expense_perstation = expense_perstation;
	}
	public String getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	public String getPlandate() {
		return plandate;
	}
	public void setPlandate(String plandate) {
		this.plandate = plandate;
	}
	public String getPlan_desc() {
		return plan_desc;
	}
	public void setPlan_desc(String plan_desc) {
		this.plan_desc = plan_desc;
	}
	public String getPlan_begin() {
		return plan_begin;
	}
	public void setPlan_begin(String plan_begin) {
		this.plan_begin = plan_begin;
	}
	public String getPlace_begin() {
		return place_begin;
	}
	public void setPlace_begin(String place_begin) {
		this.place_begin = place_begin;
	}
	public String getPlace_destination() {
		return place_destination;
	}
	public void setPlace_destination(String place_destination) {
		this.place_destination = place_destination;
	}
	public String getMile_total() {
		return mile_total;
	}
	public void setMile_total(String mile_total) {
		this.mile_total = mile_total;
	}
	public String getCenter_code() {
		return center_code;
	}
	public void setCenter_code(String center_code) {
		this.center_code = center_code;
	}
	public String getAddr_tumbon() {
		return addr_tumbon;
	}
	public void setAddr_tumbon(String addr_tumbon) {
		this.addr_tumbon = addr_tumbon;
	}
	public String getAddr_aumphur() {
		return addr_aumphur;
	}
	public void setAddr_aumphur(String addr_aumphur) {
		this.addr_aumphur = addr_aumphur;
	}
	public String getAddr_province() {
		return addr_province;
	}
	public void setAddr_province(String addr_province) {
		this.addr_province = addr_province;
	}
	public String getPlan_dte_id() {
		return plan_dte_id;
	}
	public void setPlan_dte_id(String plan_dte_id) {
		this.plan_dte_id = plan_dte_id;
	}
	public String getCodempid() {
		return codempid;
	}
	public void setCodempid(String codempid) {
		this.codempid = codempid;
	}
	public String getNamempt() {
		return namempt;
	}
	public void setNamempt(String namempt) {
		this.namempt = namempt;
	}
	public String getCodpos() {
		return codpos;
	}
	public void setCodpos(String codpos) {
		this.codpos = codpos;
	}
	public String getNamepost() {
		return namepost;
	}
	public void setNamepost(String namepost) {
		this.namepost = namepost;
	}
	public List<ActionPlanBranch> getData_station() {
		return data_station;
	}
	public void setData_station(List<ActionPlanBranch> data_station) {
		this.data_station = data_station;
	}
	public List<ActionPlanBranch> getData_officer() {
		return data_officer;
	}
	public void setData_officer(List<ActionPlanBranch> data_officer) {
		this.data_officer = data_officer;
	}
	public String getRoleIdToo() {
		return roleIdToo;
	}
	public void setRoleIdToo(String roleIdToo) {
		this.roleIdToo = roleIdToo;
	}
	public String getReviceOil() {
		return reviceOil;
	}
	public void setReviceOil(String reviceOil) {
		this.reviceOil = reviceOil;
	}
	
	public String getUpdate_flg() {
		return update_flg;
	}
	public void setUpdate_flg(String update_flg) {
		this.update_flg = update_flg;
	}

 
 


}
