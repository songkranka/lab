package th.co.pt.ptgapp.dao.task;

public class ReportAuditResultDto {
	private String stationType;
    private Integer totals;

    private String toolsName;
    
    private String itemName;
    
    public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getToolsName() {
		return toolsName;
	}

	public void setToolsName(String toolsName) {
		this.toolsName = toolsName;
	}
    public ReportAuditResultDto() {
    }

    public ReportAuditResultDto(String stationType, Integer totals) {
        this.stationType = stationType;
        this.totals = totals;
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    public Integer getTotals() {
        return totals;
    }

    public void setTotals(Integer totals) {
        this.totals = totals;
    }
}

