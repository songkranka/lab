package th.co.pt.ptgapp.service.ws.lotusnotes.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemResponse implements Serializable {

    private String systemT;
    private String dummy01;
    private String dummy02;
    private String dummy03;
    private String dummy04;
    private String dummy05;
    private String dummy06;
    private String dummy07;
    private String dummy08;
    private String dummy09;
    private String dummy10;
    private String dummy11;
    private String dummy12;
    private String dummy13;
    private String dummy14;
    private String dummy15;
    private String dummy16;
    private String dummy17;
    private String dummy18;
    private String dummy19;
    private String dummy20;
    private String errorMsg;
    private String errorcode;
    private String remark;
    private List<Detail> detail;

    @JsonProperty("SystemT")
    public String getSystemT() {
        return systemT;
    }

    public void setSystemT(String systemT) {
        this.systemT = systemT;
    }

    @JsonProperty("Dummy01")
    public String getDummy01() {
        return dummy01;
    }

    public void setDummy01(String dummy01) {
        this.dummy01 = dummy01;
    }

    @JsonProperty("Dummy02")
    public String getDummy02() {
        return dummy02;
    }

    public void setDummy02(String dummy02) {
        this.dummy02 = dummy02;
    }

    @JsonProperty("Dummy03")
    public String getDummy03() {
        return dummy03;
    }

    public void setDummy03(String dummy03) {
        this.dummy03 = dummy03;
    }

    @JsonProperty("Dummy04")
    public String getDummy04() {
        return dummy04;
    }

    public void setDummy04(String dummy04) {
        this.dummy04 = dummy04;
    }

    @JsonProperty("Dummy05")
    public String getDummy05() {
        return dummy05;
    }

    public void setDummy05(String dummy05) {
        this.dummy05 = dummy05;
    }

    @JsonProperty("Dummy06")
    public String getDummy06() {
        return dummy06;
    }

    public void setDummy06(String dummy06) {
        this.dummy06 = dummy06;
    }

    @JsonProperty("Dummy07")
    public String getDummy07() {
        return dummy07;
    }

    public void setDummy07(String dummy07) {
        this.dummy07 = dummy07;
    }

    @JsonProperty("Dummy08")
    public String getDummy08() {
        return dummy08;
    }

    public void setDummy08(String dummy08) {
        this.dummy08 = dummy08;
    }

    @JsonProperty("Dummy09")
    public String getDummy09() {
        return dummy09;
    }

    public void setDummy09(String dummy09) {
        this.dummy09 = dummy09;
    }

    @JsonProperty("Dummy10")
    public String getDummy10() {
        return dummy10;
    }

    public void setDummy10(String dummy10) {
        this.dummy10 = dummy10;
    }

    @JsonProperty("Dummy11")
    public String getDummy11() {
        return dummy11;
    }

    public void setDummy11(String dummy11) {
        this.dummy11 = dummy11;
    }

    @JsonProperty("Dummy12")
    public String getDummy12() {
        return dummy12;
    }

    public void setDummy12(String dummy12) {
        this.dummy12 = dummy12;
    }

    @JsonProperty("Dummy13")
    public String getDummy13() {
        return dummy13;
    }

    public void setDummy13(String dummy13) {
        this.dummy13 = dummy13;
    }

    @JsonProperty("Dummy14")
    public String getDummy14() {
        return dummy14;
    }

    public void setDummy14(String dummy14) {
        this.dummy14 = dummy14;
    }

    @JsonProperty("Dummy15")
    public String getDummy15() {
        return dummy15;
    }

    public void setDummy15(String dummy15) {
        this.dummy15 = dummy15;
    }

    @JsonProperty("Dummy16")
    public String getDummy16() {
        return dummy16;
    }

    public void setDummy16(String dummy16) {
        this.dummy16 = dummy16;
    }

    @JsonProperty("Dummy17")
    public String getDummy17() {
        return dummy17;
    }

    public void setDummy17(String dummy17) {
        this.dummy17 = dummy17;
    }

    @JsonProperty("Dummy18")
    public String getDummy18() {
        return dummy18;
    }

    public void setDummy18(String dummy18) {
        this.dummy18 = dummy18;
    }

    @JsonProperty("Dummy19")
    public String getDummy19() {
        return dummy19;
    }

    public void setDummy19(String dummy19) {
        this.dummy19 = dummy19;
    }

    @JsonProperty("Dummy20")
    public String getDummy20() {
        return dummy20;
    }

    public void setDummy20(String dummy20) {
        this.dummy20 = dummy20;
    }

    @JsonProperty("ErrorMsg")
    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @JsonProperty("Errorcode")
    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    @JsonProperty("Remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @JsonProperty("Detail")
    public List<Detail> getDetail() {
        return detail;
    }

    public void setDetail(List<Detail> detail) {
        this.detail = detail;
    }
}
