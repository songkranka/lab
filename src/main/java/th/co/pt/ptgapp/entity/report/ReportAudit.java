package th.co.pt.ptgapp.entity.report;

import java.io.Serializable;

public class ReportAudit implements Serializable {

    private String category;

    private int total;

    private int num;

    private double perCent;
    
    private String series;
    
   
	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

    public ReportAudit() {
    }

    public ReportAudit(String bran, int total, int num, double perCent){
        this.category = bran;
        this.total = total;
        this.num = num;
        this.perCent = perCent;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPerCent() {
        return perCent;
    }

    public void setPerCent(double perCent) {
        this.perCent = perCent;
    }
}
