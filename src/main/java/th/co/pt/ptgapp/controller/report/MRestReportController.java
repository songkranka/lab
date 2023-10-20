package th.co.pt.ptgapp.controller.report;

import net.sf.jasperreports.engine.JasperPrint;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.ErrorPageFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.*;

import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.dao.task.TripDto;
import th.co.pt.ptgapp.entity.MBReportData;
import th.co.pt.ptgapp.service.report.DataReport001Service;
import th.co.pt.ptgapp.service.report.IMobReportService;
import th.co.pt.ptgapp.service.task.ITripService;
import th.co.pt.ptgapp.utils.CGlobal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/report")
public class MRestReportController extends AbstractMultiReportJasperPDF {

    private static SimpleDateFormat dfExport = new SimpleDateFormat("ddMMyyyyHHmm");
    
    @Autowired
    private ITripService tripService;

    @Autowired
    private IMobReportService mobReportService;

    @Autowired
    private DataReport001Service dataReport001Service;
    @RequestMapping(value = "/mobSumReport", method = RequestMethod.GET)
    public void mobileSum(@RequestParam(name = "trips") String trips, HttpServletResponse response) throws Exception {
        Date dateExport = new Date();
		 String d1="";
		 String d2="";
		    List<Map<String,Object>> listCreatedate=dataReport001Service.getMBCreateDateHD(trips);
		    
		    d1=listCreatedate.get(0).get("date").toString();
		    d2=listCreatedate.get(listCreatedate.size()-1).get("date").toString();		
        String reportFileName = "SummaryReport_"+dfExport.format(dateExport)+".pdf";

        JasperPrint jasperPrintPage1 = mobReportService.generateReportPage1(d1,d2,trips);
        JasperPrint jasperPrintPage2 = mobReportService.generateReportPage2(d1,d2,trips);
        JasperPrint jasperPrintPage3 = mobReportService.generateReportPage3(d1,d2,trips);

        List<JasperPrint> listJasperPrint = new ArrayList<JasperPrint>();
        listJasperPrint.add(jasperPrintPage1);
        listJasperPrint.add(jasperPrintPage3);
        listJasperPrint.add(jasperPrintPage2);

        exportReportByResultSet(response,listJasperPrint,reportFileName);

    }

    @RequestMapping(value = "/trips", method = RequestMethod.POST)
    public List<TripDto> getTripe(@RequestBody HashMap<String,Object> params) throws Exception {
        try{
            return tripService.findTripByComplete();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
    
    @RequestMapping(value = "/getmobilereportonepage", method = RequestMethod.GET)
    public void getmobilereportonepage(@RequestParam(name = "trips") String trips, HttpServletResponse response,@RequestParam(name = "company") String company) throws Exception {
        Date dateExport = new Date();

        String reportFileName = "SummaryReport_"+dfExport.format(dateExport)+".pdf";

        JasperPrint jasperPrintPage1 = mobReportService.generateFristPage(trips,company);
        JasperPrint jasperPrintPage2 = mobReportService.generateReportSecondPage(trips,company);
       
        List<JasperPrint> listJasperPrint = new ArrayList<JasperPrint>();
        listJasperPrint.add(jasperPrintPage1);
        listJasperPrint.add(jasperPrintPage2);
        if("PTF".equals(company)) {
        	 JasperPrint jasperPrintPage3 = mobReportService.generateReportThirdPage(trips,company);
        	listJasperPrint.add(jasperPrintPage3);
        }
        exportReportByResultSet(response,listJasperPrint,reportFileName);

    }
    
    
    @RequestMapping(value = "/getMBListReceive/{tripid}/{station}", method = RequestMethod.GET)
    public List<Map<String,Object>> getMBListReceive(@PathVariable String tripid,@PathVariable String station) throws Exception {
    	List<Map<String,Object>> result = null;
        try{
        	result= mobReportService.getListReceiveOil(tripid,station);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }
    
    @RequestMapping(value = "/deleteMBListReceive/{tripid}/{station}/{productcode}", method = RequestMethod.GET)
    public List<Map<String,Object>> deleteMBListReceive(@PathVariable String tripid,@PathVariable String station,@PathVariable String productcode) throws Exception {
    	List<Map<String,Object>> result = null;
        try{
        	result= mobReportService.deleteMBListReceive(tripid,station,productcode);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }
    @RequestMapping(value = "/getMBListSchedule/{tripid}/{station}", method = RequestMethod.GET)
    public List<Map<String,Object>> getMBListSchedule(@PathVariable String tripid,@PathVariable String station) throws Exception {
    	List<Map<String,Object>> result = null;
        try{
        	result= mobReportService.getListSchedule(tripid,station);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }
    
    @RequestMapping(value = "/deleteMBListSchedule/{tripid}/{station}/{productcode}", method = RequestMethod.GET)
    public List<Map<String,Object>> deleteMBListSchedule(@PathVariable String tripid,@PathVariable String station,@PathVariable String productcode) throws Exception {
    	List<Map<String,Object>> result = null;
        try{
        	result= mobReportService.deleteMBListSchedule(tripid,station,productcode);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }
    
    
    @RequestMapping(value = "/saveListReceive", method = RequestMethod.POST)
    public List<Map<String,Object>> saveListReceive(@RequestBody MBReportData mbReportData,HttpSession session ) throws Exception {
    	List<Map<String,Object>> result = null;
        try{
        	 MemberObj  memberObj = CGlobal.getC_UserInfo(session);
        	 mbReportData.setCreateBy(memberObj.getCodempid());
        	result=mobReportService.saveListReceive(mbReportData);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }
    
    @RequestMapping(value = "/updateNCRNo", method = RequestMethod.POST)
    public List<Map<String,Object>> updateNCRNo(@RequestBody MBReportData mbReportData,HttpSession session ) throws Exception {
    	List<Map<String,Object>> result = null;
        try{
        	 MemberObj  memberObj = CGlobal.getC_UserInfo(session);
        	 mbReportData.setCreateBy(memberObj.getCodempid());
        	result=mobReportService.updateNCRNo(mbReportData);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }
    
    @RequestMapping(value = "/saveListSchedule", method = RequestMethod.POST)
    public List<Map<String,Object>> saveListSchedule(@RequestBody MBReportData mbReportData,HttpSession session ) throws Exception {
    	List<Map<String,Object>> result = null;
        try{
        	 MemberObj  memberObj = CGlobal.getC_UserInfo(session);
        	 mbReportData.setCreateBy(memberObj.getCodempid());
        	result=mobReportService.saveListSchedule(mbReportData);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }
    

}
