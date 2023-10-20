package th.co.pt.ptgapp.entity;

import java.io.Serializable;

public class ResultLTrBean implements Serializable {

    private String typeStation;
    private String plantDt;
    private String result;
    private Integer totals;

    public ResultLTrBean() {
    }

    public ResultLTrBean(String typeStation, String plantDt, String result, Integer totals) {
        this.typeStation = typeStation;
        this.plantDt = plantDt;
        this.result = result;
        this.totals = totals;
    }

    public String getTypeStation() {
        return typeStation;
    }

    public void setTypeStation(String typeStation) {
        this.typeStation = typeStation;
    }

    public String getPlantDt() {
        return plantDt;
    }

    public void setPlantDt(String plantDt) {
        this.plantDt = plantDt;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getTotals() {
        return totals;
    }

    public void setTotals(Integer totals) {
        this.totals = totals;
    }
}
