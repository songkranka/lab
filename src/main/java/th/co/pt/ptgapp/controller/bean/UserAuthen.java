package th.co.pt.ptgapp.controller.bean;

public class UserAuthen {
	public boolean hasEmail;
	public boolean isSuccessful;
	public boolean resetPassword;
	public String responseMessage;
 
	public String getResponseMessage() {
		return responseMessage;
	}
	public boolean isHasEmail() {
		return hasEmail;
	}
	public void setHasEmail(boolean hasEmail) {
		this.hasEmail = hasEmail;
	}
	public boolean isSuccessful() {
		return isSuccessful;
	}
	public void setSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}
	public boolean isResetPassword() {
		return resetPassword;
	}
	public void setResetPassword(boolean resetPassword) {
		this.resetPassword = resetPassword;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	} 
}
