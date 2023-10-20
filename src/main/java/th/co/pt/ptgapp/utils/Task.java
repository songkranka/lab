package th.co.pt.ptgapp.utils;

public class Task {
    private String branch;
    private int totals;
    private int error;
    private double perError;

    public Task() {
    }

    public Task(String branch, int totals, int error, double perError) {
        this.branch = branch;
        this.totals = totals;
        this.error = error;
        this.perError = perError;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getTotals() {
        return totals;
    }

    public void setTotals(int totals) {
        this.totals = totals;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public double getPerError() {
        return perError;
    }

    public void setPerError(double perError) {
        this.perError = perError;
    }

    @Override
    public String toString() {
        return "Task{" +
                "branch='" + branch + '\'' +
                ", totals=" + totals +
                ", error=" + error +
                ", perError=" + perError +
                '}';
    }
}
