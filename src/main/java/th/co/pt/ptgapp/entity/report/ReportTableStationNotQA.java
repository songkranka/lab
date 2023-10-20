package th.co.pt.ptgapp.entity.report;

import java.io.Serializable;

public class ReportTableStationNotQA implements Serializable {

    private String station;

    private String saleArea;

    private String inspectionDate;

    private String unacceptableProducts;

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getSaleArea() {
        return saleArea;
    }

    public void setSaleArea(String saleArea) {
        this.saleArea = saleArea;
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getUnacceptableProducts() {
        return unacceptableProducts;
    }

    public void setUnacceptableProducts(String unacceptableProducts) {
        this.unacceptableProducts = unacceptableProducts;
    }

}
