package th.co.pt.ptgapp.dao.task;

public class ReportReceiveOilDto {
    private String plantReceive;
    private String receiveOil;
    private Integer totals;

    public ReportReceiveOilDto() {
    }

    public ReportReceiveOilDto(String plantReceive, String receiveOil, Integer totals) {
        this.plantReceive = plantReceive;
        this.receiveOil = receiveOil;
        this.totals = totals;
    }

    public String getPlantReceive() {
        return plantReceive;
    }

    public void setPlantReceive(String plantReceive) {
        this.plantReceive = plantReceive;
    }

    public String getReceiveOil() {
        return receiveOil;
    }

    public void setReceiveOil(String receiveOil) {
        this.receiveOil = receiveOil;
    }

    public Integer getTotals() {
        return totals;
    }

    public void setTotals(Integer totals) {
        this.totals = totals;
    }
}
