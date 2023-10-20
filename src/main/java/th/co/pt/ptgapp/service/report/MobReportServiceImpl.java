package th.co.pt.ptgapp.service.report;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.co.pt.ptgapp.dao.task.ReportPtfNotReceiveOilDao;
import th.co.pt.ptgapp.dao.task.ReportTableStationNotQADao;
import th.co.pt.ptgapp.entity.MBReportData;
import th.co.pt.ptgapp.entity.report.*;
import th.co.pt.ptgapp.utils.CalendarUtils;
import th.co.pt.ptgapp.utils.ReportUtils;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletContext;

@Service
public class MobReportServiceImpl implements IMobReportService {

    public static Logger LOGGER = LoggerFactory.getLogger(MobReportServiceImpl.class);

    private static SimpleDateFormat dfExport = new SimpleDateFormat("ddMMyyyyHHmm");

    @Autowired
    private DataReport001Service dataReport001Service;

    @Autowired
    private DataReport002Service dataReport002Service;

    @Autowired
    private DataReport003Service dataReport003Service;

    @Autowired
    private ReportPtfNotReceiveOilDao reportPtfNotReceiveOilDao;

    @Autowired
    private ReportTableStationNotQADao reportTableStationNotQADao;
    
	@Autowired
	ServletContext context;

    private JasperPrint createReport(Map<String,Object> configure, Collection<?> listCollection){
        try {
            String jasperFileName = (String) configure.get("JASPER_FILE_NAME");
            Map<String, Object> params = (Map<String, Object>) configure.get("PARAM");
            InputStream jasperStream = this.getClass().getClassLoader().getResourceAsStream("jasperreports/" + jasperFileName);
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(listCollection);
            LOGGER.debug("-=jasperStream {}=-", jasperStream);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
            LOGGER.debug("jasperReport :: {}", jasperReport);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,beanColDataSource);
            return jasperPrint;
        }catch (Exception e) {
            LOGGER.error("Can't Generate Report",e);
            throw new RuntimeException("Can't Generate Report",e);
        }

    }
    
    private JasperPrint createTableReport(Map<String,Object> configure){
        try {
            String jasperFileName = (String) configure.get("JASPER_FILE_NAME");
            Map<String, Object> params = (Map<String, Object>) configure.get("PARAM");
            InputStream jasperStream = this.getClass().getClassLoader().getResourceAsStream("jasperreports/" + jasperFileName);
            
            LOGGER.debug("-=jasperStream {}=-", jasperStream);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
            LOGGER.debug("jasperReport :: {}", jasperReport);
            List<ReportTableStationPTF> DATA_STATION_PTF = (List<ReportTableStationPTF>) params.get("DATA_STATION_PTF");
            JRBeanCollectionDataSource beanColDataSourceStationPTF = new JRBeanCollectionDataSource(DATA_STATION_PTF);
            List<ReportTableStationNotQA> DATA_STATION_NOT_QA = (List<ReportTableStationNotQA>) params.get("DATA_STATION_NOT_QA");
            JRBeanCollectionDataSource beanColDataSourceStationNonQA = new JRBeanCollectionDataSource(DATA_STATION_NOT_QA);
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("DATA_STATION_PTF", beanColDataSourceStationPTF);
            parameters.put("DATA_STATION_NOT_QA", beanColDataSourceStationNonQA);
            JasperPrint jasperPrint = JasperFillManager.fillReport(this.getClass().getClassLoader().getResource("jasperreports/" + jasperFileName).getFile(),parameters,new JREmptyDataSource());
            return jasperPrint;
        }catch (Exception e) {
            LOGGER.error("Can't Generate Report1",e);
            throw new RuntimeException("Can't Generate Report1",e);
        }

    }


    @Override
    public JasperPrint generateReportPage1(String sDate,String eDate,String trip){
        Date dateExport = new Date();
        String reportName = "QAPerformanceReport";
        String reportFileName = "QAPerformanceReport"+dfExport.format(dateExport)+".pdf";
        String jasperFileName = "QAPerformanceReport.jasper";
        
        List<ReportAuditOil> listReportAuditOilPTC = dataReport001Service.listReportAuditOilPTC(sDate,eDate,trip);
        List<ReportAuditOil> listReportAuditOilPTF = dataReport001Service.listReportAuditOilPTF(sDate,eDate,trip);
        List<ReportAudit> listReportAuditPTC = dataReport001Service.listReportAuditPTC(sDate,eDate,trip);
        List<ReportAudit> listReportAuditPTF = dataReport001Service.listReportAuditPTF(sDate,eDate,trip);
        List<ReportAudit> listReportAuditFranchisePTF = dataReport001Service.listReportAuditFranchisePTF(sDate,eDate,trip);
        List<ReportOilStation> listReportOilStation = dataReport001Service.listReportOilStation(sDate,eDate,trip);
        List<ReportAudit> listReportAuditPTCPlace = new ArrayList<ReportAudit>();
        if(!trip.equals("0")) {
        	jasperFileName = "QAPerformanceTripReport.jasper";
        	listReportAuditPTCPlace = dataReport001Service.listReportAuditPTCPlace(sDate,eDate,trip);
        }
        Map<String,Object> params = new HashMap<>();
        params.put("TITLE_NAME","รายงานผลการปฏิบัติงานส่วนประกันคุณภาพประจำปี "+sDate.split("\\/")[2]);
        params.put("SUB_TITLE_NAME","กระบวนการ ตรวจสอบคุณภาพน้ำมันที่สถานีบริการ");
        params.put("DATE_EDIT_DATA","9 ตุลาคม 2562");
        params.put("DATA_BETWEEN",sDate.concat(" - ").concat(eDate));
        Map<String, Object> configure = new HashMap<>();
        configure.put("REPORT_NAME", reportName);
        configure.put("REPORT_FILE_NAME", reportFileName);
        configure.put("JASPER_FILE_NAME", jasperFileName);
        params.put("DATA_AUDIT_OIL_PTC",listReportAuditOilPTC);
        params.put("DATA_AUDIT_OIL_PTF",listReportAuditOilPTF);
        params.put("DATA_AUDIT_PTC",listReportAuditPTC);
        params.put("DATA_AUDIT_PTF",listReportAuditPTF);
        params.put("DATA_AUDIT_FRANCHISE_PTF",listReportAuditFranchisePTF);
        if(!trip.equals("0")) {
        	params.put("DATA_OIL_STATION",listReportAuditPTCPlace);
        }else{
        	params.put("DATA_OIL_STATION",listReportOilStation);
        }
        
        configure.put("PARAM", params);
        JasperPrint jasperPrintPage = createReport(configure,null);
        return jasperPrintPage;
    }

    @Override
    public JasperPrint generateReportPage2(String sDate,String eDate,String trip){
        Date dateExport = new Date();
        String reportName = "StationResultReport";
        String reportFileName = "StationResultReport"+dfExport.format(dateExport)+".pdf";
        String jasperFileName = "StationResultReport.jasper";
        List<ReportTableStationPTF> listReportTableStationPTF = reportPtfNotReceiveOilDao.getPtfNotReceive(sDate,eDate,trip);
        List<ReportTableStationNotQA> listReportTableStationNotQA = reportTableStationNotQADao.getStationNotQA(sDate,eDate,trip);
        Map<String,Object> params = new HashMap<>();
        Map<String, Object> configure = new HashMap<>();
        configure.put("REPORT_NAME", reportName);
        configure.put("REPORT_FILE_NAME", reportFileName);
        configure.put("JASPER_FILE_NAME", jasperFileName);
        params.put("DATA_STATION_PTF",listReportTableStationPTF);
        params.put("DATA_STATION_NOT_QA",listReportTableStationNotQA);
        configure.put("PARAM", params);
        JasperPrint jasperPrintPage = createTableReport(configure);
        return jasperPrintPage;
    }

    @Override
    public JasperPrint generateReportPage3(String sDate,String eDate,String trip){
        Date dateExport = new Date();

        String reportName = "QATestResultReport";
        String reportFileName = "QATestResultReport"+dfExport.format(dateExport)+".pdf";
        String jasperFileName = "QATestResultReport.jasper";
        

        List<ReportAuditResult> listReportAuditResultPTC = dataReport003Service.listReportAuditResultPTC(sDate,eDate,trip);
        List<ReportAuditResult> listReportAuditResultPTF = dataReport003Service.listReportAuditResultPTF(sDate,eDate,trip);

        List<ReportAuditResult> listReportAuditTestResult = dataReport003Service.listReportAuditTestResult(sDate,eDate,trip);
        List<ReportAuditResult> listReportAuditTrainingResult = dataReport003Service.listReportAuditTrainingResult(sDate,eDate,trip);


        Map<String,Object> params = new HashMap<>();

        Map<String, Object> configure = new HashMap<>();
        configure.put("REPORT_NAME", reportName);
        configure.put("REPORT_FILE_NAME", reportFileName);
        configure.put("JASPER_FILE_NAME", jasperFileName);


        params.put("DATA_AUDIT_TEST_PTC_RESULT",listReportAuditResultPTC);
        params.put("DATA_AUDIT_TEST_PTF_RESULT",listReportAuditResultPTF);
        params.put("DATA_AUDIT_TEST_RESULT",listReportAuditTestResult);
        params.put("DATA_AUDIT_TRAINING_RESULT",listReportAuditTrainingResult);


        configure.put("PARAM", params);

        JasperPrint jasperPrintPage = createReport(configure,null);

        return jasperPrintPage;
    }
    
    @Override
	public JasperPrint generateFristPage( String trip, String company) {
		 //company="PTC";
		 String jasperFileName = "";
		 String path = context.getRealPath("resources/image/");
		 List<ReportAudit> listReportAuditPTCPlace = new ArrayList<ReportAudit>();
		 Map<String,Object> params = new HashMap<>();
		 int dynamicGraph1=7;
		 int dynamicGraph2=10;
		 int dynamicGraph3=10;
		 String sDate="";
		 String eDate="";
		 	
		    List<Map<String,Object>> listCreatedate=dataReport001Service.getMBCreateDateHD(trip);
		    
		    sDate=listCreatedate.get(0).get("date").toString();
		    eDate=listCreatedate.get(listCreatedate.size()-1).get("date").toString();		
	 		params.put("date_verify", returnThaiDateReportFormat(trip));//1
	 		
	 		params.put("province", returnMBGroupProvince(trip));//2
	 		
	 		params.put("district", returnMBGroupPlant(trip));//3
	 		
	 		if("PTF".equals(company)) {
	 			List<Map<String,Object>>  getWording = dataReport001Service.getWording(trip);
	 			params.put("text_1", "เข้าตรวจทั้งหมด = "+getWording.get(0).get("TOTAL").toString()+" สถานี ประเมินรับน้ำมันบริษัทฯ = "+getWording.get(0).get("RECEIVE").toString());
	 			params.put("text_2", "ประเมินไม่รับน้ำมันบริษัทฯ = "+getWording.get(0).get("NOT_RECEIVE").toString() +" สถานี");
	 			params.put("img_logo", path+"ptg.png");
	 			params.put("name_office", "ลูกค้าแฟรนไชส์");
	 		}else if("PTC".equals(company)) {
	 			params.put("img_logo", path+"ptg.png");
	 			params.put("name_office", "บริษัท ปิโตรเลี่ยมไทยคอร์ปอเรชั่น จำกัด");
	 		}else if("OLP".equals(company)) {
	 			params.put("img_logo", path+"olympus.png");
	 			params.put("name_office", "บริษัท โอลิมปัส ออยล์ จํากัด");
	 		}else if("BPTG".equals(company)) {
	 			params.put("img_logo", path+"bptg.jpeg");
	 			params.put("name_office", "บริษัท บีพีทีจี จํากัด");
	 		}
	 		
		 	if("PTF".equals(company)) {
		 		jasperFileName = "FRANCH_CHART2";
		 		//GRAPH 1
		 		List<Map<String,Object>>  listReportAuditNot = dataReport001Service.getReportAuditNotBytripId(trip);
		 		params.put("CHART_DATASET",new JRBeanCollectionDataSource(listReportAuditNot));
		 		params.put("color_page", "#FFFFFF");
		 		
		 		for(Map<String,Object> m:listReportAuditNot) {
		 			if(Integer.parseInt(m.get("unit").toString())>dynamicGraph1) {
		 				dynamicGraph1=100;
		 			}
		 		}


		 	}else if("PTC".equals(company)) {
		 		jasperFileName = "OFFICE_CHART2";
		 		//GRAPH 1
		 		listReportAuditPTCPlace = dataReport001Service.listReportAuditPTCPlaceV2(sDate,eDate,trip,company);
		 		params.put("CHART_DATASET",new JRBeanCollectionDataSource(listReportAuditPTCPlace));
		 		params.put("color_page", "#FFFFFF");
		 		
		 		for(ReportAudit r:listReportAuditPTCPlace) {
		 			if(r.getTotal()>dynamicGraph1) {
		 				dynamicGraph1=100;
		 			}
		 		}
		 	}else {
		 		jasperFileName = "OFFICE_CHART2";
		 		//GRAPH 1
		 		listReportAuditPTCPlace = dataReport001Service.listReportAuditPTCPlaceV2(sDate,eDate,trip,company);
		 		params.put("CHART_DATASET",new JRBeanCollectionDataSource(listReportAuditPTCPlace));
		 		params.put("color_page", "#FFFFFF");
		 		for(ReportAudit r:listReportAuditPTCPlace) {
		 			if(r.getTotal()>dynamicGraph1) {
		 				dynamicGraph1=100;
		 			}
		 		}
		 	}
		 	       
		 	params.put("DYNAMIC_GRAPH1", dynamicGraph1);
	        	
	        //GRAPH 2    
	        List<ReportAuditResult> listReportAuditResult = dataReport003Service.listReportAuditResultV2(sDate,eDate,trip,company);
	        for(ReportAuditResult r :listReportAuditResult) {
	        	if(r.getNum()>dynamicGraph2) {
	        		dynamicGraph2=100;
	        	}
	        }
	        //GRAPH 3    
	        //List<ReportAudit> listReportAudit = dataReport001Service.listReportAuditV2(sDate,eDate,trip);
	        List<PerformanceOil>  listReportAudit = dataReport001Service.getReportAuditBytripId(trip,company);
	        for(PerformanceOil p :listReportAudit) {
	        	if(p.getUnit()>dynamicGraph3) {
	        		dynamicGraph3=100;
	        	}
	        }
	        //GRAPH 4
	        Map<String,Object> mapResultTest = dataReport001Service.listMBResultTest(company,trip);
	        params.putAll(mapResultTest);
	        //params.put("CHART2_DATASET",new JRBeanCollectionDataSource(listReportAudit));
	        params.put("CHART2_DATASET",listReportAudit);
	        params.put("PIE_DATASET",listReportAuditResult);
	        params.put("DYNAMIC_GRAPH2",dynamicGraph2);
	        params.put("DYNAMIC_GRAPH3",dynamicGraph3);
	        JasperPrint jasperPrintPage = null;
			try {
				jasperPrintPage = ReportUtils.exportReport(jasperFileName, params, new JREmptyDataSource());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        		//createReport(configure,null);
	        return jasperPrintPage;
	}

	@Override
	public JasperPrint generateReportSecondPage(String trip, String company) {
		 String jasperFileName = "REPORT_PAGE2";
		 Map<String,Object> params = new HashMap<>();
		 
		 int dynamicGraph5=10;
		 int dynamicGraph6=10;
		 
		 List<Map<String,Object>> listWrongTool = dataReport001Service.listWrongTool(trip,company);
		 List<Map<String,String>> listAUDIT_NOT = dataReport001Service.listAuditNot(trip,company);
		 List<PerformanceOil>  listResultLite = dataReport001Service.getlistResultLite(trip,company);
		 
	 		for(PerformanceOil p:listResultLite) {
	 			if(p.getUnit()>dynamicGraph6) {
	 				dynamicGraph6=100;
	 			}
	 		}
		 List<PerformanceOil>  listSummaryTest = dataReport001Service.getlistSummaryTest(trip,company);
	 		for(PerformanceOil p:listSummaryTest) {
	 			if(p.getUnit()>dynamicGraph5) {
	 				dynamicGraph5=100;
	 			}
	 		}
		 params.put("WRONG_TOOL",new JRBeanCollectionDataSource(listWrongTool));
		 params.put("AUDIT_NOT",new JRBeanCollectionDataSource(listAUDIT_NOT));
		 params.put("RESULT_LITE",listResultLite);
		 params.put("SUMMARY_TEST",listSummaryTest);
		 params.put("DYNAMIC_GRAPH5",dynamicGraph5);
		 params.put("DYNAMIC_GRAPH6",dynamicGraph6);
        JasperPrint jasperPrintPage = null;
		try {
			jasperPrintPage = ReportUtils.exportReport(jasperFileName, params, new JREmptyDataSource());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        		//createReport(configure,null);
        return jasperPrintPage;
	}
	

	public String returnThaiDateReportFormat(String tripid) {
		String startDateArr[]; 
		String endDateArr[];
		String startDateTxt = "";
		String endDateTxt ="";
		String dateBetween="";
		List<Map<String,Object>> listDate=dataReport001Service.getMBDateBetween(tripid);
		if(listDate.size()>0&&listDate.get(0).get("START_DATE")!=null&&listDate.get(0).get("END_DATE")!=null) {
			startDateArr=listDate.get(0).get("START_DATE").toString().split("-");
			endDateArr=listDate.get(0).get("END_DATE").toString().split("-");
			
			if(startDateArr[0].equals(endDateArr[0])) {
				
				if(startDateArr[1].equals(endDateArr[1])) {
					startDateTxt=startDateArr[2];
					endDateTxt =endDateArr[2]+" "+CalendarUtils.convertToMonthName(Integer.parseInt(endDateArr[1]));
					dateBetween=startDateTxt+"-"+endDateTxt+" "+(Integer.parseInt(startDateArr[0])+543);
				}else {
					startDateTxt=startDateArr[2]+" "+CalendarUtils.convertToMonthName(Integer.parseInt(startDateArr[1]));
					endDateTxt =endDateArr[2]+" "+CalendarUtils.convertToMonthName(Integer.parseInt(endDateArr[1]));
					dateBetween=startDateTxt+"-"+endDateTxt+" "+(Integer.parseInt(startDateArr[0])+543);
				}
				
			}else {
				startDateTxt=startDateArr[2]+" "+CalendarUtils.convertToMonthName(Integer.parseInt(startDateArr[1]))+" "+(Integer.parseInt(startDateArr[0])+543);
				endDateTxt =endDateArr[2]+" "+CalendarUtils.convertToMonthName(Integer.parseInt(endDateArr[1]))+" "+(Integer.parseInt(endDateArr[0])+543);
				dateBetween=startDateTxt+"-"+endDateTxt;
			}
			
		}
		
		return dateBetween;
	}
	
	public String returnMBGroupProvince(String tripid) {
		String resultTxt ="";
		List<Map<String,Object>> listProvince=dataReport001Service.getMBGroupProvince(tripid);
		if(listProvince.size()>0) {

			Set<String> distinctPlants = new HashSet<>();
			for (Map<String, Object> m : listProvince) {
			    String plant = m.get("ADDR_PROVINCE").toString().replace("จังหวัด", "");;
			    distinctPlants.add(plant);
			}
			resultTxt = String.join(",", distinctPlants);
			
			//resultTxt=resultTxt.substring(0, resultTxt.length()-1);
		}
		
		return resultTxt;
	}
	
	public String returnMBGroupPlant(String tripid) {
		String resultTxt ="";
		List<Map<String,Object>> listPlant=dataReport001Service.getMBGroupPlant(tripid);
		if(listPlant.size()>0) {
			
			Set<String> distinctPlants = new HashSet<>();
			for (Map<String, Object> m : listPlant) {
			    String plant = m.get("PLANT_RECEIVE").toString();
			    distinctPlants.add(plant);
			}
			resultTxt = String.join(",", distinctPlants);
			
			//resultTxt=resultTxt.substring(0, resultTxt.length()-1);
		}
		
		return resultTxt;
	}
	
	
	@Override
	public List<Map<String,Object>> getListReceiveOil(String tripid,String station){
		List<Map<String,Object>> result = null;
		
		try {
			result=dataReport001Service.getMBListReceiveOil(tripid,station);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	

	@Override
	public List<Map<String,Object>> getListSchedule(String tripid,String station){
		List<Map<String,Object>> result = null;
		try {
			result=dataReport001Service.getMBListScheduleOil(tripid,station);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public List<Map<String, Object>> saveListReceive(MBReportData mbReportData) {
		List<Map<String,Object>> result = null;
	try {
		result=dataReport001Service.saveListReceive(mbReportData);
	}catch(Exception e) {
		e.printStackTrace();
	}
		return result;
	}

	@Override
	public List<Map<String, Object>> updateNCRNo(MBReportData mbReportData) {
		List<Map<String,Object>> result = null;
	try {
		result=dataReport001Service.updateNCRNo(mbReportData);
	}catch(Exception e) {
		e.printStackTrace();
	}
		return result;
	}

	@Override
	public List<Map<String, Object>> saveListSchedule(MBReportData mbReportData) {
		List<Map<String,Object>> result = null;
	try {
		result=dataReport001Service.saveListSchedule(mbReportData);
	}catch(Exception e) {
		e.printStackTrace();
	}
		return result;
	}

	@Override
	public List<Map<String, Object>> deleteMBListReceive(String tripid, String station, String productcode) {
		List<Map<String,Object>> result = null;
		
		try {
			result=dataReport001Service.deleteMBListReceive(tripid,station,productcode);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Map<String, Object>> deleteMBListSchedule(String tripid, String station, String productcode) {
		List<Map<String,Object>> result = null;
		
		try {
			result=dataReport001Service.deleteMBListSchedule(tripid,station,productcode);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public JasperPrint generateReportThirdPage(String trips, String company) {

		 String jasperFileName = "REPORT_PAGE3";
		 Map<String,Object> params = new HashMap<>();
		
		 List<Map<String,String>> listAUditOil = dataReport001Service.listAuditOil(trips);
		 params.put("AUDIT_OIL",new JRBeanCollectionDataSource(listAUditOil)); 
		
        JasperPrint jasperPrintPage = null;
		try {
			jasperPrintPage = ReportUtils.exportReport(jasperFileName, params, new JREmptyDataSource());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        		//createReport(configure,null);
        return jasperPrintPage;
	}
	
}
