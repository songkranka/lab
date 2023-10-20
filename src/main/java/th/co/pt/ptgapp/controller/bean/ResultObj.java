package th.co.pt.ptgapp.controller.bean;

import java.util.List;



public class ResultObj {
	public int status; 
	public int success;
    public String message;
    public String runno_oa_ref;
    public String hd_no;
    public String cancel_user;
    public String default_page; 
    public String approveDate;
    public String roleId;
    public String signatureImg;
    public String getSignatureImg() {
		return signatureImg;
	}

	public void setSignatureImg(String signatureImg) {
		this.signatureImg = signatureImg;
	}
	private MemberObj datatMember; 
	private List<RandomOil> data;
	
	public MemberObj getDatatMember() {
		return datatMember;
	}

	public void setDatatMember(MemberObj datatMember) {
		this.datatMember = datatMember;
	}
	
    public List<RandomOil> getData() {
        return data;
    }

    public void setData(List<RandomOil> data) {
        this.data = data;
    }

    public String getApproveDate() {
        return approveDate;
    }

    public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
    public void setApproveDate(String approveDate) {
        this.approveDate = approveDate;
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

    public String getRunno_oa_ref() {
        return runno_oa_ref;
    }

    public void setRunno_oa_ref(String runno_oa_ref) {
        this.runno_oa_ref = runno_oa_ref;
    }

  
    public String getCancel_user() {
        return cancel_user;
    }

    public void setCancel_user(String cancel_user) {
        this.cancel_user = cancel_user;
    }

    public String getDefault_page() {
        return default_page;
    }

    public void setDefault_page(String default_page) {
        this.default_page = default_page;
    }

	public String getHd_no() {
		return hd_no;
	}

	public void setHd_no(String hd_no) {
		this.hd_no = hd_no;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
 
}

