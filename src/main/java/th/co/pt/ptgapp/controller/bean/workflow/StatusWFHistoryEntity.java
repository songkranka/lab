package th.co.pt.ptgapp.controller.bean.workflow;

public class StatusWFHistoryEntity {

	private String wfStepHistory;
	private String operatorName;
	private String decision;
	private String date;
	private String time;	
	private String comment;
	
	public StatusWFHistoryEntity() {}


	public String getWfStepHistory() {
		return wfStepHistory;
	}

	public void setWfStepHistory(String wfStepHistory) {
		this.wfStepHistory = wfStepHistory;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	@Override
	public String toString() {
		return "StatusWFHistoryEntity [wfStepHistory=" + wfStepHistory + ", operatorName=" + operatorName
				+ ", decision=" + decision + ", date=" + date + ", time=" + time + ", comment=" + comment + "]";
	}

}
