package th.co.pt.ptgapp.entity;

import java.io.Serializable;

public class StationBean implements Serializable {

    private String stationName;
    private String plantDt;
    private String chkDate;
    private String productName;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getPlantDt() {
        return plantDt;
    }

    public void setPlantDt(String plantDt) {
        this.plantDt = plantDt;
    }

    public String getChkDate() {
        return chkDate;
    }

    public void setChkDate(String chkDate) {
        this.chkDate = chkDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
