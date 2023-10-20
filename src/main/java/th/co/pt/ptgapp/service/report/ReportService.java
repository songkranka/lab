package th.co.pt.ptgapp.service.report;

import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperPrint;
import th.co.pt.ptgapp.controller.bean.ReportInfoEntity;
import th.co.pt.ptgapp.controller.bean.report.MbServiceStationEntity;


public interface ReportService {
	Map<String,Object>  getReportInfo(ReportInfoEntity entity) throws Exception;
	List<Map<String, Object>> getRptMbServiceStation(MbServiceStationEntity entity) throws Exception;
	Map<String,Object>  pushReportTransaction(Map<String,Object> obj) throws Exception;
}
