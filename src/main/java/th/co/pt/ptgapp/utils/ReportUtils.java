package th.co.pt.ptgapp.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(ReportUtils.class);
	private static String ROOT_FILE ="src/main/resources/";
	
	public static InputStream getResourceFile(String path, String fileName) throws FileNotFoundException {
		
		logger.info(" ReportUtils.getResourceFile::fileName  = " + fileName);
		logger.info(" ReportUtils.getResourceFile::inputPath = " + path);
		InputStream jrxmlFile = null;
		try {
			String fullPath = path + "/" + fileName;
			logger.info(" Full path report = " + fullPath);
			jrxmlFile = Thread.currentThread().getContextClassLoader().getResourceAsStream(fullPath);
			logger.info(" file ........... = " + jrxmlFile);
		} catch (Exception e) {
			logger.error("Report Template Not Found.",e);
			throw new FileNotFoundException("Report Template Not Found.");
		}
		
		return jrxmlFile;
	}
	
	public static JasperPrint exportReport(String reportName, Map<String, Object> params, JRDataSource dataSource) throws IOException, JRException {
		logger.info("exportReport reportName='" + reportName + "'");
		for (Entry<String, Object> e : params.entrySet()) {
			logger.info("param=" + e.getKey() + ", value=" + e.getValue());
		}
		
		JasperPrint jasperPrint = null;
		InputStream jasperStream = null;
		try {			
			//jasperStream = getResourceFile("report/jrxml", reportName + ".jasper");
			logger.info("Start compile report by Jasper");
			JasperReport jasperReport = JasperCompileManager.compileReport(getResourceFile("report/jrxml", reportName + ".jrxml"));
			logger.info("Compile report by Jasper : Success");
			
			logger.info("Start fill manager report");
			jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
			logger.info("Fill manager report : Success");
			
		} catch (JRException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} finally {
			if (jasperStream != null) {
				jasperStream.close();
			}
		}
		
		return jasperPrint;
	}
	public static JasperPrint exportReport2(String reportName, Map<String, Object> params, JRDataSource dataSource) throws IOException, JRException {
		logger.info("exportReport2 reportName=" + reportName);
		
		for (Entry<String, Object> e : params.entrySet()) {
			logger.info("  param=" + e.getKey() + ", value=" + e.getValue());
		}
		
		JasperPrint jasperPrint = null;
		InputStream jasperStream = null;
		try { 
			logger.info("Start stream file report by Jasper");
			jasperStream = getResourceFile("report/jrxml", reportName + ".jasper");
			logger.info("Stream file report by Jasper : Success");
			
			logger.info("Start compile report by Jasper");
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
			logger.info("Compile report by Jasper : Success");
			
			logger.info("Start fill manager report");
			jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
			logger.info("Fill manager report : Success");
			
		} catch (JRException e) {
			logger.error("Error JRException in exportReport2");
			logger.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			logger.error("Error Exception in exportReport2");
			logger.error(e.getMessage(), e);
			throw e;
		} finally {
			if (jasperStream != null) {
				jasperStream.close();
			}
		}
		
		return jasperPrint;
	}
		
/*	public static JasperPrint exportReport2(String reportName, Map<String, Object> params) throws IOException, JRException {
		logger.info("exportReport reportName=" + reportName);
		
		for (Entry<String, Object> e : params.entrySet()) {
			logger.info("param=" + e.getKey() + ", value=" + e.getValue());
		}
		
		JasperPrint jasperPrint = null;
		InputStream jasperStream = null;
		try {			
			//jasperStream = getResourceFile("report/jrxml", reportName + ".jasper");
			JasperReport jasperReport = JasperCompileManager.compileReport(getResourceFile("report/jrxml", reportName + ".jrxml"));
			jasperPrint = JasperFillManager.fillReport(jasperReport, params);
		} catch (JRException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} finally {
			if (jasperStream != null) {
				jasperStream.close();
			}
		}
		
		return jasperPrint;
	}*/
	
	public static void closeResourceFileInputStream(Map<String, Object> params) {
		for (Object value : params.values()) {
			if (value instanceof InputStream && value != null) {
				try {
					((InputStream) value).close();
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
	}
	
	public static JasperPrint exportReportV2(String reportName, Map<String, Object> params, JRDataSource dataSource,String filename,String type,String path) throws IOException, JRException {
		logger.info("exportReportV2 reportName='" + filename + "'");
		for (Entry<String, Object> e : params.entrySet()) {
			logger.info("param=" + e.getKey() + ", value=" + e.getValue());
		}
		File f = null;
		JasperPrint jasperPrint = null;
		InputStream jasperStream = null;
		try {			
			//jasperStream = getResourceFile("report/jrxml", reportName + ".jasper");
			logger.info("Start compile report by Jasper");
			JasperReport jasperReport = JasperCompileManager.compileReport(getResourceFile("report/jrxml", reportName + ".jrxml"));
			logger.info("Compile report by Jasper : Success");
			
			logger.info("Start fill manager report");
			jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

			f=new File(path+filename+"_"+type+".jrprint");
			if(!f.isFile()) {
				JRSaver.saveObject(jasperPrint, f);
			}else {
			jasperPrint = (JasperPrint)JRLoader.loadObject(f);
			}
			
			logger.info("Fill manager report : Success");
			
		} catch (JRException e) {
			logger.error(e.getMessage(), e);
			throw e;
		} finally {
			if (jasperStream != null) {
				jasperStream.close();
			}
		}
		
		return jasperPrint;
	}
	
/***********************************************************************************************************/	
/***********************************************************************************************************/
	
	
	
 
}
