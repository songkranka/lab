package th.co.pt.ptgapp.controller.bean.workflow;

import java.util.List;

public class ReturnAssignmentDtlEntity {

	private String testItemCode;
	private String testItem;
	private String seqNo;
	private String testToolCode;
	private String testTool;
	private String testMethodCode;
	private String testMethod;
	private String testSpecCode;
	private String testSpec;
	private String testSpec2;
	private String testUnitCode;
	private String testUnit;
	private List<ReturnAssignmentMemberEntity> member;
	public String getTestItemCode() {
		return testItemCode;
	}
	public void setTestItemCode(String testItemCode) {
		this.testItemCode = testItemCode;
	}
	public String getTestItem() {
		return testItem;
	}
	public void setTestItem(String testItem) {
		this.testItem = testItem;
	}
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getTestToolCode() {
		return testToolCode;
	}
	public void setTestToolCode(String testToolCode) {
		this.testToolCode = testToolCode;
	}
	public String getTestTool() {
		return testTool;
	}
	public void setTestTool(String testTool) {
		this.testTool = testTool;
	}
	public String getTestMethodCode() {
		return testMethodCode;
	}
	public void setTestMethodCode(String testMethodCode) {
		this.testMethodCode = testMethodCode;
	}
	public String getTestMethod() {
		return testMethod;
	}
	public void setTestMethod(String testMethod) {
		this.testMethod = testMethod;
	}
	public String getTestSpecCode() {
		return testSpecCode;
	}
	public void setTestSpecCode(String testSpecCode) {
		this.testSpecCode = testSpecCode;
	}
	public String getTestSpec() {
		return testSpec;
	}
	public void setTestSpec(String testSpec) {
		this.testSpec = testSpec;
	}
	public String getTestSpec2() {
		return testSpec2;
	}
	public void setTestSpec2(String testSpec2) {
		this.testSpec2 = testSpec2;
	}
	public String getTestUnitCode() {
		return testUnitCode;
	}
	public void setTestUnitCode(String testUnitCode) {
		this.testUnitCode = testUnitCode;
	}
	public String getTestUnit() {
		return testUnit;
	}
	public void setTestUnit(String testUnit) {
		this.testUnit = testUnit;
	}
	public List<ReturnAssignmentMemberEntity> getMember() {
		return member;
	}
	public void setMember(List<ReturnAssignmentMemberEntity> member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "ReturnAssignmentDtlEntity [testItemCode=" + testItemCode + ", testItem=" + testItem + ", seqNo=" + seqNo
				+ ", testToolCode=" + testToolCode + ", testTool=" + testTool + ", testMethodCode=" + testMethodCode
				+ ", testMethod=" + testMethod + ", testSpecCode=" + testSpecCode + ", testSpec=" + testSpec
				+ ", testSpec2=" + testSpec2 + ", testUnitCode=" + testUnitCode + ", testUnit=" + testUnit + ", member="
				+ member + "]";
	}
	
	
}
