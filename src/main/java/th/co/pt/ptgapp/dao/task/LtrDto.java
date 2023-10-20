package th.co.pt.ptgapp.dao.task;

public class LtrDto {

    private String labCode;
    private String ltrNo;
    private String resultStatus;
    private String resultLtr;
    private String createBy;
    private String updateBy;

    public String getLabCode() {
        return labCode;
    }

    public void setLabCode(String labCode) {
        this.labCode = labCode;
    }

    public String getLtrNo() {
        return ltrNo;
    }

    public void setLtrNo(String ltrNo) {
        this.ltrNo = ltrNo;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getResultLtr() {
        return resultLtr;
    }

    public void setResultLtr(String resultLtr) {
        this.resultLtr = resultLtr;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}
