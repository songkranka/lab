package th.co.pt.ptgapp.controller.report;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Map;

public abstract class AbstractReportJasperPDF {

    public static Logger LOGGER = LoggerFactory.getLogger(AbstractReportJasperPDF.class);


    public void exportReportByResultSet(HttpServletRequest request, HttpServletResponse response, Map<String,Object> configure, Collection<?> listCollection) throws FileNotFoundException {
        OutputStream outputStream2 = null;
        try{
            String reportFileName     = (String)configure.get("REPORT_FILE_NAME");
            String jasperFileName     = (String)configure.get("JASPER_FILE_NAME");
            Map<String,Object> params = (Map<String,Object>)configure.get("PARAM");
            InputStream jasperStream = getClass().getClassLoader().getResourceAsStream("jasperreports/"+jasperFileName);
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(listCollection);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,beanColDataSource);
            response.setContentType("application/x-pdf");
            response.setHeader("Content-disposition", "inline; filename="+reportFileName);
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            outputStream2 = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream2);
        }catch (Exception e) {
            LOGGER.error("Can't Generate Report",e);
            throw new RuntimeException("Can't Generate Report",e);
        }finally {
            IOUtils.closeQuietly(outputStream2);
        }
    }

}
