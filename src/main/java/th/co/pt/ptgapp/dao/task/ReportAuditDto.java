package th.co.pt.ptgapp.dao.task;

public class ReportAuditDto {

    private String plant;
    private Integer total;

    public ReportAuditDto() {
    }

    public ReportAuditDto(String plant, Integer total) {
        this.plant = plant;
        this.total = total;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
