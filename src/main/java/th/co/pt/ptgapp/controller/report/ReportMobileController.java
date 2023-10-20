package th.co.pt.ptgapp.controller.report;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.ReportInfoEntity;
import th.co.pt.ptgapp.controller.bean.report.MbServiceStationEntity;
import th.co.pt.ptgapp.service.report.ReportService;
import th.co.pt.ptgapp.utils.CGlobal;
import th.co.pt.ptgapp.utils.ReportUtils;

@Controller
public class ReportMobileController {

	private final String REPORT_TYPE_PDF = "1";
	private final String REPORT_TYPE_EXCEL = "2";
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ReportService reportService;
	
	@RequestMapping("reportMobile")
	public void reportMobile(@ModelAttribute ReportInfoEntity entity, HttpServletRequest request , HttpServletResponse response, HttpSession session) throws Exception { 
		
		if (entity.getReportNo().equals("M0001")) { 
			rptMbServiceStation(entity, request, response, session);
		} else {
			// < add new and other condition report > in 'else if' statement
		}
		
	}

	private void rptMbServiceStation(ReportInfoEntity entity, HttpServletRequest request, HttpServletResponse response, HttpSession session){

		logger.info("Report Mobile - Service Station ");
		logger.info("Print Input Param ===============================>>> ");
		logger.info("reportID =>>> "+entity.getReportID());
		logger.info("reportNo =>>> "+entity.getReportNo());
		logger.info("reportType =>>> "+entity.getReportType());
		logger.info("mb_trip_id =>>> "+entity.getMb_trip_id());
		
		logger.info("Generate Report 'rptMbServiceStation' ");
		
		//Initial Report Properties
		String OUTPUT_PDF_NAME = "report_mobile_service_station";
		String OUTPUT_XLS_NAME = "report_mobile_service_station";
		String REPORT_FILE_NAME = "mb_service_station";
		
		logger.info("Initial Report Condition. ");
		MbServiceStationEntity repEntity = new MbServiceStationEntity();
		repEntity.setReportID(entity.getReportID());
		repEntity.setReportNo(entity.getReportNo());
		repEntity.setReportType(entity.getReportType());
		repEntity.setMb_trip_id(entity.getMb_trip_id());
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		// This report not have Parameter
		
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Map<String, Object>> rptObj = reportService.getRptMbServiceStation(repEntity);
			List<MbServiceStationEntity> listEntity = convertListMbServiceStation(rptObj);

			MemberObj  memberObj = CGlobal.getC_UserInfo(session);
			
			map.put("reportId", entity.getReportID());
			map.put("reportNo", entity.getReportNo());
			map.put("reportParam", "param:{tripid:'"+entity.getMb_trip_id()+"'}");
			map.put("createBy", memberObj.getCodempid());
			if(entity.getReportType().equals(REPORT_TYPE_PDF)) {
				
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "inline;filename="+OUTPUT_PDF_NAME+".pdf");
				response.setCharacterEncoding("UTF-8");
				
				JRPdfExporter exporter = new JRPdfExporter();
				JasperPrint jasperPrint =  ReportUtils.exportReport(REPORT_FILE_NAME, parameters, new JRBeanCollectionDataSource(listEntity));
				
				logger.info("add JasperList ");
				List<JasperPrint> list = new ArrayList<JasperPrint>();
				list.add(jasperPrint);

				exporter.setExporterInput(SimpleExporterInput.getInstance(list));
				exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
				exporter.exportReport();
				
				map.put("reportFileType", "pdf");
				pushReportTransaction(map);
				
			} else if(entity.getReportType().equals(REPORT_TYPE_EXCEL)) {
				
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition", "inline;filename="+OUTPUT_XLS_NAME+".xlsx");
				response.setCharacterEncoding("UTF-8");

				JasperPrint jasperPrint = ReportUtils.exportReport2(REPORT_FILE_NAME, parameters, new JRBeanCollectionDataSource(listEntity));
				
				//ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

				JRXlsxExporter xlsExporter = new JRXlsxExporter();
				xlsExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
				//xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));
				xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
				xlsExporter.exportReport();
				
				 Runtime runtime = Runtime.getRuntime();
				  long totalMemory = runtime.totalMemory(); // current heap allocated to the VM process
				  long freeMemory = runtime.freeMemory(); // out of the current heap, how much is free
				  long maxMemory = runtime.maxMemory(); // Max heap VM can use e.g. Xmx setting
				  long usedMemory = totalMemory - freeMemory; // how much of the current heap the VM is using
				  long availableMemory = maxMemory - usedMemory; // available memory i.e. Maximum heap size minus the current amount used
				 System.out.println("maxMemory|"+maxMemory+"usedMemory="+usedMemory+"|availableMemory="+availableMemory);
				 System.gc();
				 
				 map.put("reportFileType", "xlsx");
				 pushReportTransaction(map);
			}
		} catch (IOException e) {
			logger.error("getReportTrans IO Error ",e);
		} catch (JRException e) {
			logger.error("getReportTrans JR Error ",e);
		} catch (Exception e) {
			logger.error("Error Exception on rptMbServiceStation()",e);
		}
		
	}
	private List<MbServiceStationEntity> convertListMbServiceStation(List<Map<String, Object>> rptObj) {
		List<MbServiceStationEntity> list = new ArrayList<MbServiceStationEntity>();
		for(Map<String, Object> obj : rptObj) {
			MbServiceStationEntity entity = new MbServiceStationEntity();

			entity.setMb_ds_seq(obj.get("seq").toString());
			entity.setMb_station_seq(obj.get("seq").toString());
			entity.setMb_trip_id(obj.get("trip_id").toString());
			entity.setMb_trip_station(obj.get("trip_name").toString());
			entity.setMb_trip_date(obj.get("plan_date").toString());
			entity.setMb_trip_year(obj.get("plan_year").toString());
			entity.setMb_product_id(obj.get("product_id").toString());
			entity.setMb_product_name(obj.get("product_name").toString());
			entity.setMb_ltr_result(obj.get("result").toString());
			entity.setMb_ltr_stickerNo(obj.get("sticker_no").toString());
			entity.setMb_ltr_feature(obj.get("feature").toString());
			entity.setMb_ltr_color(obj.get("color").toString());
			entity.setMb_ltr_api(obj.get("api").toString());
			entity.setMb_ltr_temp(obj.get("temp").toString());
			entity.setMb_ltr_api60(obj.get("api_60").toString());
			entity.setMb_ibp(obj.get("distill").toString());
			entity.setMb_ltr_t10(obj.get("evaporation_10").toString());
			entity.setMb_ltr_t50(obj.get("evaporation_50").toString());
			entity.setMb_ltr_t90(obj.get("evaporation_90").toString());
			entity.setMb_fbp(obj.get("fbp").toString());
			entity.setMb_percent_dregs(obj.get("waste_oil").toString());
			entity.setMb_percent_et(obj.get("ethanol").toString());
			entity.setMb_ltr_fp(obj.get("fp").toString());
			entity.setMb_percent_fame(obj.get("biodiesel").toString());
			entity.setMb_ltr_ci(obj.get("cetane").toString());
			entity.setMb_ltr_ron(obj.get("ron").toString());
			entity.setMb_ltr_mon(obj.get("mon").toString());
			entity.setOrgName(obj.get("orgName").toString());
			entity.setPart(obj.get("part").toString());

			logger.info(entity.toString());
			list.add(entity);
		}
		return list;
	}
	private void pushReportTransaction(Map<String,Object> objParam) {
		try {
			Map<String, Object> trans = reportService.pushReportTransaction(objParam);
			
			String result =(String)trans.get("pResult");
			String msg =(String)trans.get("pMessage");

			logger.info("response result from db = '"+result+"'");
			logger.info("response message from db = '"+msg+"'");
			
			if(result.equals("1")){
				logger.info("Push Report to Database : SUCCESS ");
			} else {
				logger.error("Push Report to Database : ERROR ");
			}
			
		} catch (Exception e) {
			logger.error("Push Report to Database : Error Exception ",e);
		} finally {
			logger.info("Push Report to Database : END Process ");
		}
	}

}
