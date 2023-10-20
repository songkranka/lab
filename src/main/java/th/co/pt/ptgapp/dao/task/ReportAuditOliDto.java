package th.co.pt.ptgapp.dao.task;

public class ReportAuditOliDto {

    private String stationType;
    private Integer totals;

    public ReportAuditOliDto() {
    }

    public ReportAuditOliDto(String stationType, Integer totals) {
        this.stationType = stationType;
        this.totals = totals;
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    public Integer getTotals() {
        return totals;
    }

    public void setTotals(Integer totals) {
        this.totals = totals;
    }
}
