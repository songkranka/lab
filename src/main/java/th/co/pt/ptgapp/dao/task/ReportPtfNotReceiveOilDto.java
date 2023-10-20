package th.co.pt.ptgapp.dao.task;

public class ReportPtfNotReceiveOilDto {

    private String centerName;
    private String place;
    private String dateAudit;
    private String produceCode;

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDateAudit() {
        return dateAudit;
    }

    public void setDateAudit(String dateAudit) {
        this.dateAudit = dateAudit;
    }

    public String getProduceCode() {
        return produceCode;
    }

    public void setProduceCode(String produceCode) {
        this.produceCode = produceCode;
    }
}
