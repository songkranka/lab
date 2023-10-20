package th.co.pt.ptgapp.entity;

import java.io.Serializable;

public class TaskListBean implements Serializable {

    private String reqNo;
    private String plant;
    private String samp;
    private String prd;
    private String sampdate;
    private String exprdate;


    private String plantId;
    private String prodCode;


    private String wfStep;
    private String wfStatus;


    public String getReqNo() {
        return reqNo;
    }

    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getSamp() {
        return samp;
    }

    public void setSamp(String samp) {
        this.samp = samp;
    }

    public String getPrd() {
        return prd;
    }

    public void setPrd(String prd) {
        this.prd = prd;
    }

    public String getSampdate() {
        return sampdate;
    }

    public void setSampdate(String sampdate) {
        this.sampdate = sampdate;
    }

    public String getExprdate() {
        return exprdate;
    }

    public void setExprdate(String exprdate) {
        this.exprdate = exprdate;
    }

    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getWfStep() {
        return wfStep;
    }

    public void setWfStep(String wfStep) {
        this.wfStep = wfStep;
    }

    public String getWfStatus() {
        return wfStatus;
    }

    public void setWfStatus(String wfStatus) {
        this.wfStatus = wfStatus;
    }
}
