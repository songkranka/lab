package th.co.pt.ptgapp.service.ws.lotusnotes.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetailForCreate implements Serializable {

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
    private List<MemberForCreate> memberList;

    @JsonProperty("TestItemCode")
    public String getTestItemCode() {
        return testItemCode;
    }

    public void setTestItemCode(String testItemCode) {
        this.testItemCode = testItemCode;
    }

    @JsonProperty("TestItem")
    public String getTestItem() {
        return testItem;
    }

    public void setTestItem(String testItem) {
        this.testItem = testItem;
    }

    @JsonProperty("SeqNo")
    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    @JsonProperty("TestToolCode")
    public String getTestToolCode() {
        return testToolCode;
    }

    public void setTestToolCode(String testToolCode) {
        this.testToolCode = testToolCode;
    }

    @JsonProperty("TestTool")
    public String getTestTool() {
        return testTool;
    }

    public void setTestTool(String testTool) {
        this.testTool = testTool;
    }

    @JsonProperty("TestMethodCode")
    public String getTestMethodCode() {
        return testMethodCode;
    }

    public void setTestMethodCode(String testMethodCode) {
        this.testMethodCode = testMethodCode;
    }

    @JsonProperty("TestMethod")
    public String getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(String testMethod) {
        this.testMethod = testMethod;
    }

    @JsonProperty("TestSpecCode")
    public String getTestSpecCode() {
        return testSpecCode;
    }

    public void setTestSpecCode(String testSpecCode) {
        this.testSpecCode = testSpecCode;
    }

    @JsonProperty("TestSpec")
    public String getTestSpec() {
        return testSpec;
    }

    public void setTestSpec(String testSpec) {
        this.testSpec = testSpec;
    }

    @JsonProperty("TestSpec2")
    public String getTestSpec2() {
        return testSpec2;
    }

    public void setTestSpec2(String testSpec2) {
        this.testSpec2 = testSpec2;
    }

    @JsonProperty("TestUnitCode")
    public String getTestUnitCode() {
        return testUnitCode;
    }

    public void setTestUnitCode(String testUnitCode) {
        this.testUnitCode = testUnitCode;
    }

    @JsonProperty("TestUnit")
    public String getTestUnit() {
        return testUnit;
    }

    public void setTestUnit(String testUnit) {
        this.testUnit = testUnit;
    }

    @JsonProperty("Member")
    public List<MemberForCreate> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<MemberForCreate> memberList) {
        this.memberList = memberList;
    }

    @Override
    public String toString() {
        return "DetailForCreate{" +
                "testItemCode='" + testItemCode + '\'' +
                ", testItem='" + testItem + '\'' +
                ", seqNo='" + seqNo + '\'' +
                ", testToolCode='" + testToolCode + '\'' +
                ", testTool='" + testTool + '\'' +
                ", testMethodCode='" + testMethodCode + '\'' +
                ", testMethod='" + testMethod + '\'' +
                ", testSpecCode='" + testSpecCode + '\'' +
                ", testSpec='" + testSpec + '\'' +
                ", testSpec2='" + testSpec2 + '\'' +
                ", testUnitCode='" + testUnitCode + '\'' +
                ", testUnit='" + testUnit + '\'' +
                ", memberList=" + memberList +
                '}';
    }
}
