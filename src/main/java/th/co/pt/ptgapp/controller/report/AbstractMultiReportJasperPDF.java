package th.co.pt.ptgapp.controller.report;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class AbstractMultiReportJasperPDF {

    public static Logger LOGGER = LoggerFactory.getLogger(AbstractMultiReportJasperPDF.class);


    public void exportReportByResultSet(HttpServletResponse response,
                                        List<JasperPrint> listJasperPrint,
                                        String reportFileName) throws JRException, IOException {

        OutputStream outputStream2 = response.getOutputStream();

        response.setContentType("application/x-pdf");
        response.setHeader("Content-disposition", "inline; filename="+reportFileName);
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(SimpleExporterInput.getInstance(listJasperPrint)); //Set as export input my list with JasperPrint s

        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream2)); //or any other out streaam
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        configuration.setCreatingBatchModeBookmarks(true); //add this so your bookmarks work, you may set other parameters
        exporter.setConfiguration(configuration);
        exporter.exportReport();

    }

    public JasperPrint exportReportByResultSet(HttpServletRequest request, HttpServletResponse response, Map<String,Object> configure, Collection<?> listCollection){
        JasperPrint jasperPrint = null;
        return jasperPrint;
    }
}
