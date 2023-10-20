package th.co.pt.ptgapp.dao.task;

public class ReportOilStationDto {
	private String typeStation;
    private String years;
    private Integer totals;
    
    public ReportOilStationDto(String typeStation, String years, Integer totals) {
        this.typeStation = typeStation;
        this.years = years;
        this.totals = totals;
    }

    public String getTypeStation() {
        return typeStation;
    }

    public void setTypeStation(String typeStation) {
        this.typeStation = typeStation;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public Integer getTotals() {
        return totals;
    }

    public void setTotals(Integer totals) {
        this.totals = totals;
    }
}
