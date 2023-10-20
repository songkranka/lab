package th.co.pt.ptgapp.controller.bean;

import java.util.Date;

public class SettingAssignObj {
	
	private String asm_id;
	private String asm_name;
	private String asm_status;
	////////////////////////////////////
	private String create_by;
	private Date create_date;
	private Date update_by;
	private Float update_date;
	////////////////////////////////////
	public String getASM_id() {
		return asm_id;
	}
	public void setASM_id(String asm_id) {
		this.asm_id = asm_id;
	}
	public String getASM_name() {
		return asm_name;
	}
	public void setASM_name(String asm_name) {
		this.asm_name = asm_name;
	}
	public String getASM_status() {
		return asm_status;
	}
	public void setASM_status(String asm_status) {
		this.asm_status = asm_status;
	}
	
	////////////////////////////////////
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
