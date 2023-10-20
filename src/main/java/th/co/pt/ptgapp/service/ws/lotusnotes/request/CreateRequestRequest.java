package th.co.pt.ptgapp.service.ws.lotusnotes.request;

import java.io.Serializable;

public class CreateRequestRequest implements Serializable {
    private String systemName;
    private String process;
    private String requestID;
    private String requesterID;
    private int totalrecord;
    private String dummy01;
    private String dummy02;
    private String seq;
    private String testItemCode;
    private String testtoolCode;
    private String testMethodCode;
    private String testSpecCode;
    private String testUnitCode;
    private String memberlist;

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getRequesterID() {
        return requesterID;
    }

    public void setRequesterID(String requesterID) {
        this.requesterID = requesterID;
    }

    public int getTotalrecord() {
        return totalrecord;
    }

    public void setTotalrecord(int totalrecord) {
        this.totalrecord = totalrecord;
    }

    public String getDummy01() {
        return dummy01;
    }

    public void setDummy01(String dummy01) {
        this.dummy01 = dummy01;
    }

    public String getDummy02() {
        return dummy02;
    }

    public void setDummy02(String dummy02) {
        this.dummy02 = dummy02;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getTestItemCode() {
        return testItemCode;
    }

    public void setTestItemCode(String testItemCode) {
        this.testItemCode = testItemCode;
    }

    public String getTesttoolCode() {
        return testtoolCode;
    }

    public void setTesttoolCode(String testtoolCode) {
        this.testtoolCode = testtoolCode;
    }

    public String getTestMethodCode() {
        return testMethodCode;
    }

    public void setTestMethodCode(String testMethodCode) {
        this.testMethodCode = testMethodCode;
    }

    public String getTestSpecCode() {
        return testSpecCode;
    }

    public void setTestSpecCode(String testSpecCode) {
        this.testSpecCode = testSpecCode;
    }

    public String getTestUnitCode() {
        return testUnitCode;
    }

    public void setTestUnitCode(String testUnitCode) {
        this.testUnitCode = testUnitCode;
    }

    public String getMemberlist() {
        return memberlist;
    }

    public void setMemberlist(String memberlist) {
        this.memberlist = memberlist;
    }

    @Override
    public String toString() {
        return "CreateRequestRequest{" +
                "systemName='" + systemName + '\'' +
                ", process='" + process + '\'' +
                ", requestID='" + requestID + '\'' +
                ", requesterID='" + requesterID + '\'' +
                ", totalrecord=" + totalrecord +
                ", dummy01='" + dummy01 + '\'' +
                ", dummy02='" + dummy02 + '\'' +
                ", seq='" + seq + '\'' +
                ", testItemCode='" + testItemCode + '\'' +
                ", testtoolCode='" + testtoolCode + '\'' +
                ", testMethodCode='" + testMethodCode + '\'' +
                ", testSpecCode='" + testSpecCode + '\'' +
                ", testUnitCode='" + testUnitCode + '\'' +
                ", memberlist='" + memberlist + '\'' +
                '}';
    }
}
