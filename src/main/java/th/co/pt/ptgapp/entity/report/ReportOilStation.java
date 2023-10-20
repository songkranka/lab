package th.co.pt.ptgapp.entity.report;

import java.io.Serializable;

public class ReportOilStation implements Serializable {

    private String category;
    private String yearName1;
    private Integer year1;
    private String yearName2;
    private Integer year2;
    private String yearName3;
    private Integer year3;

    public ReportOilStation(String category,Integer year1,Integer year2,Integer year3,String yearName1,String yearName2,String yearName3){
        this.category = category;
        this.year1 = year1;
        this.year2 = year2;
        this.year3 = year3;
        this.yearName1 = yearName1;
        this.yearName2 = yearName2;
        this.yearName3 = yearName3;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getYear1() {
        return year1;
    }

    public void setYear1(Integer year1) {
        this.year1 = year1;
    }

    public Integer getYear2() {
        return year2;
    }

    public void setYear2(Integer year2) {
        this.year2 = year2;
    }

    public Integer getYear3() {
        return year3;
    }

    public void setYear3(Integer year3) {
        this.year3 = year3;
    }
    
    public String getYearName1() {
        return yearName1;
    }

    public void setYearName1(String yearName1) {
        this.yearName1 = yearName1;
    }
    
    public String getYearName2() {
        return yearName2;
    }

    public void setYearName2(String yearName2) {
        this.yearName2 = yearName2;
    }
    
    public String getYearName3() {
        return yearName3;
    }

    public void setYearName3(String yearName3) {
        this.yearName3 = yearName3;
    }

}
