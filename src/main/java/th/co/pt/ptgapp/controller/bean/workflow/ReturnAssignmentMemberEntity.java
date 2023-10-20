package th.co.pt.ptgapp.controller.bean.workflow;

public class ReturnAssignmentMemberEntity {
	
	private String memberID;
	private String membersName;

	public final String MEMBER_TYPE_ASSIGNMENT = "0";
	public final String MEMBER_TYPE_ACTURE = "1";
	
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getMembersName() {
		return membersName;
	}
	public void setMembersName(String membersName) {
		this.membersName = membersName;
	}
	@Override
	public String toString() {
		return "ReturnAssignmentMemberEntity [memberID=" + memberID + ", membersName=" + membersName + "]";
	}
	

}
