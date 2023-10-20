package th.co.pt.ptgapp.service.report;

import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperPrint;
import th.co.pt.ptgapp.entity.MBReportData;

public interface IMobReportService {

    JasperPrint generateReportPage1(String sDate,String eDate,String trip) throws Exception;
    JasperPrint generateReportPage2(String sDate,String eDate,String trip) throws Exception;
    JasperPrint generateReportPage3(String sDate,String eDate,String trip) throws Exception;
	JasperPrint generateFristPage(String trips, String company);
	JasperPrint generateReportSecondPage(String trips, String company);
	List<Map<String, Object>> getListReceiveOil(String tripid, String station);
	List<Map<String, Object>> deleteMBListReceive(String tripid, String station, String productcode);
	List<Map<String, Object>> getListSchedule(String tripid, String station);
	List<Map<String, Object>> deleteMBListSchedule(String tripid, String station, String productcode);
	List<Map<String, Object>> updateNCRNo(MBReportData mbReportData);
	List<Map<String, Object>> saveListSchedule(MBReportData mbReportData);
	List<Map<String, Object>> saveListReceive(MBReportData mbReportData);
	JasperPrint generateReportThirdPage(String trips, String company);
}
