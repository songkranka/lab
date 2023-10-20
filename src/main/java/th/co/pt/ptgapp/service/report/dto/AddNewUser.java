package th.co.pt.ptgapp.service.report.dto;

import org.springframework.web.multipart.MultipartFile;

public class AddNewUser {

	private String code_empid;
	private String name_emp;
	private String role_dropdown;
	private String plat_dropdown;
	private String status_dropdown;
	private MultipartFile upload_signature;
	
	private String createBy;
	private String pathFile;
	
	
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getPathFile() {
		return pathFile;
	}
	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}
	public String getCode_empid() {
		return code_empid;
	}
	public void setCode_empid(String code_empid) {
		this.code_empid = code_empid;
	}
	public String getName_emp() {
		return name_emp;
	}
	public void setName_emp(String name_emp) {
		this.name_emp = name_emp;
	}
	public String getRole_dropdown() {
		return role_dropdown;
	}
	public void setRole_dropdown(String role_dropdown) {
		this.role_dropdown = role_dropdown;
	}
	public String getPlat_dropdown() {
		return plat_dropdown;
	}
	public void setPlat_dropdown(String plat_dropdown) {
		this.plat_dropdown = plat_dropdown;
	}
	public String getStatus_dropdown() {
		return status_dropdown;
	}
	public void setStatus_dropdown(String status_dropdown) {
		this.status_dropdown = status_dropdown;
	}
	public MultipartFile getUpload_signature() {
		return upload_signature;
	}
	public void setUpload_signature(MultipartFile upload_signature) {
		this.upload_signature = upload_signature;
	}
	
	
}
