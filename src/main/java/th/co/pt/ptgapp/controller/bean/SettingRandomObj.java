package th.co.pt.ptgapp.controller.bean;

import java.util.Date;

public class SettingRandomObj{
	
	private String code;
	private String compname;
	private Float sample_cnt;
	private Float random_percent;
	private String codcomp;
	private Float amt_perkilo;
	private Float amt_pernighthotel;
	private String create_by;
	private Date create_date;
	private Date update_by;
	private Float update_date;
	private String codeEmid;
	
	public String getCodeEmid() {
		return codeEmid;
	}
	public void setCodeEmid(String codeEmid) {
		this.codeEmid = codeEmid;
	}
	
	public String getCode() {
		return code;
	}
	public void setLab_check_comp(String code) {
		this.code = code;
	}
	public Float getSample_cnt() {
		return sample_cnt;
	}
	public void setSample_cnt(Float sample_cnt) {
		this.sample_cnt = sample_cnt;
	}
	public Float getRandom_percent() {
		return random_percent;
	}
	public void setRandom_percent(Float random_percent) {
		this.random_percent = random_percent;
	}
	public String getCodcomp() {
		return codcomp;
	}
	public void setCodcomp(String codcomp) {
		this.codcomp = codcomp;
	}
	public String getCompname() {
		return compname;
	}
	public void setCompname(String compname) {
		this.compname = compname;
	}
	public Float getAmt_perkilo() {
		return amt_perkilo;
	}
	public void setAmt_perkilo(Float amt_perkilo) {
		this.amt_perkilo = amt_perkilo;
	}
	public Float getAmt_pernighthotel() {
		return amt_pernighthotel;
	}
	public void setAmt_pernighthotel(Float amt_pernighthotel) {
		this.amt_pernighthotel = amt_pernighthotel;
	}

	public String getCreate_by() {
		return create_by;
	}
	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getUpdate_by() {
		return update_by;
	}
	public void setUpdate_by(Date update_by) {
		this.update_by = update_by;
	}
	public Float getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Float update_date) {
		this.update_date = update_date;
	}
	
	
	
}
