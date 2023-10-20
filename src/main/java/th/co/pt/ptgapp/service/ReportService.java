package th.co.pt.ptgapp.service;

import net.sf.jasperreports.engine.*;
import th.co.pt.ptgapp.controller.bean.ReportSetting;
import th.co.pt.ptgapp.dao.ReportDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
	
	@Autowired
	ReportDao reportdao;


    public  InputStream getResourceFile(String path, String fileName) throws FileNotFoundException {


        InputStream jrxmlFile = null;
        try {
            String fullPath = path + "/" + fileName;

//			jrxmlFile = new FileInputStream(fullPath);
            jrxmlFile = Thread.currentThread().getContextClassLoader().getResourceAsStream(fullPath);

        } catch (Exception e) {
            throw new FileNotFoundException("Report Template Not Found.");
        }

        return jrxmlFile;
    }
    public  JasperPrint exportReport(String reportName, Map<String, Object> params, JRDataSource dataSource) throws IOException, JRException {
//        logger.debug("exportReport reportName=" + reportName);

        for (Map.Entry<String, Object> e : params.entrySet()) {
//            logger.debug("param=" + e.getKey() + ", value=" + e.getValue());
        }

        JasperPrint jasperPrint = null;
        InputStream jasperStream = null;
        try {
            //jasperStream = getResourceFile("report/jrxml", reportName + ".jasper");
            JasperReport jasperReport = JasperCompileManager.compileReport(getResourceFile("report/jrxml", reportName + ".jrxml"));
            jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
        } catch (JRException e) {
//            logger.error(e.getMessage(), e);
            throw e;
        } finally {
            if (jasperStream != null) {
                jasperStream.close();
            }
        }

        return jasperPrint;
    }
    
    
    public List<Object> inquiryyear(){
    	
    	List<Object> result = new ArrayList<Object>();
    	    	
    	result = reportdao.getInquiryyear();
    	
    	return result;
    }
    
    
	public List<Map<String,Object>> inqueryDataChart(ReportSetting varireportS) {
		
		System.out.println(varireportS.getYearWatch());
    	System.out.println(varireportS.getMonthWatch());
    	
		return null;
	}
    
}
