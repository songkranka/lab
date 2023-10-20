package th.co.pt.ptgapp.entity.report;

import java.io.Serializable;

public class ReportAuditOilPTF implements Serializable {

    public ReportAuditOilPTF(String category, int num, int total){

        this.category = category;
        this.num = num;
        this.total = total;

    }

    private String category;

    private int num;

    private int total;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
