package th.co.pt.ptgapp.entity.report;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class DataExportList {
	private List<ReportRequestNo> data;

	public List<ReportRequestNo> getData() {
		return data;
	}
	public void setData(List<ReportRequestNo> data) {
		this.data = data;
	}
	
}
