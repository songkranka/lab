package th.co.pt.ptgapp.service.report.dto;

import java.io.Serializable;

public class ReportDto implements Serializable {

    private String bran;
    private int total;
    private int numError;
    private double perError;

    public ReportDto() {
    }

    public ReportDto(String bran, int total, int numError, double perError) {
        this.bran = bran;
        this.total = total;
        this.numError = numError;
        this.perError = perError;
    }

    public String getBran() {
        return bran;
    }

    public void setBran(String bran) {
        this.bran = bran;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNumError() {
        return numError;
    }

    public void setNumError(int numError) {
        this.numError = numError;
    }

    public double getPerError() {
        return perError;
    }

    public void setPerError(double perError) {
        this.perError = perError;
    }
}
