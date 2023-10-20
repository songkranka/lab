package th.co.pt.ptgapp.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class TestReport2 {

	
	public static void main(String[] args) throws JRException, IOException {
		Map<String,Object> map = new HashMap<>();
		File sourceFile = new File("/ptg-lab-webapp-project2/src/main/resources/MyFancyPantsReport.jrprint");
		System.out.println(sourceFile.isFile());
//		JasperPrint jasperPrint = (JasperPrint)JRLoader.loadObject(sourceFile);

//			File pdf = File.createTempFile("output.", ".pdf");
//			System.out.println(pdf.getAbsolutePath());
//			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(pdf));
	}
	
}
