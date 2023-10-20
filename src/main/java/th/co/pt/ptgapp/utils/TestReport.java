package th.co.pt.ptgapp.utils;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import th.co.pt.ptgapp.service.report.dto.RepConstant;
import th.co.pt.ptgapp.service.report.dto.ReportDto;

import java.io.IOException;
import java.util.*;

public class TestReport {

    public static void main(String[] args) throws IOException {

//        String str = " {\"SystemT\":\"Lab Assignment\",\"EmployeeID\":\"470251\",\"WFDateTime\":\"10/01/2019 03:36:38 PM ZE7\",\"MsgCode\":\"100\",\"ErrorCode\":\"900\",\"ErrorMsg\":\"Complete\",\"Remark\":\"\",\"470251\" : [{\"WFStep\":\"Assignment\",\"WFStatus\":\"New\",\"RequestID\":\"11-09-TEST-LTR-19-00113\"},{\"WFStep\":\"Assignment\",\"WFStatus\":\"New\",\"RequestID\":\"11-09-TEST-LTR-19-00114\"},{\"WFStep\":\"Assignment\",\"WFStatus\":\"New\",\"RequestID\":\"01-0-3-00214-0-19-00011\"},{\"WFStep\":\"Assignment\",\"WFStatus\":\"New\",\"RequestID\":\"01-0-3-00214-0-19-00020\"},{\"WFStep\":\"Assignment\",\"WFStatus\":\"New\",\"RequestID\":\"1080\"},{\"WFStep\":\"Assignment\",\"WFStatus\":\"New\",\"RequestID\":\"05-0-3-00211-0-19-00081\"},{\"WFStep\":\"Assignment\",\"WFStatus\":\"New\",\"RequestID\":\"05-0-3-00211-0-19-00081-1\"},{\"WFStep\":\"Assignment\",\"WFStatus\":\"New\",\"RequestID\":\"05-0-3-00211-0-19-00081-2\"},{\"WFStep\":\"Assignment\",\"WFStatus\":\"New\",\"RequestID\":\"05-0-3-00211-0-19-00081-3\"},{\"WFStep\":\"Assignment\",\"WFStatus\":\"New\",\"RequestID\":\"05-0-3-00211-0-19-00081-4\"},{\"WFStep\":\"Assignment\",\"WFStatus\":\"New\",\"RequestID\":\"GSH91\"},{\"WFStep\":\"Assignment\",\"WFStatus\":\"New\",\"RequestID\":\"ADO\"}]}";
//        ObjectMapper mapper = new ObjectMapper();
//        Map<String,Object> res = mapper.readValue(str, Map.class);
//        System.out.println(res.get("EmployeeID"));
//        System.out.println(res.get("ErrorCode"));
//        if("900".equals(res.get("ErrorCode"))){
//            List<Map> list = (List) res.get(String.valueOf(res.get("EmployeeID")));
//            System.out.println(list);
//
//            for (Map<String,String> m :list){
//                System.out.println(m.get("RequestID"));
//            }
//        }

//        List<ReportDto> dto1 = new ArrayList<>();
//        dto1.add(new ReportDto("PC1", 24, 1,95.5));
//        dto1.add(new ReportDto("KK2", 588, 19, 90.8));
//        dto1.add(new ReportDto("LP3", 630, 30, 75.0));
//        dto1.add(new ReportDto("PC4", 24, 1,95.5));
//        dto1.add(new ReportDto("KK5", 588, 19, 90.8));
//        dto1.add(new ReportDto("LP6", 630, 30, 75.0));
//        dto1.add(new ReportDto("PC7", 24, 1,95.5));
//        dto1.add(new ReportDto("KK8", 588, 19, 90.8));
//        dto1.add(new ReportDto("LP9", 630, 30, 75.0));
//        dto1.add(new ReportDto("LP10", 630, 30, 75.0));
//
//        List<ReportDto> dto2 = new ArrayList<>();
//        dto2.add(new ReportDto("PC1", 24, 1,95.5));
//        dto2.add(new ReportDto("KK2", 588, 19, 90.8));
//        dto2.add(new ReportDto("LP3", 630, 30, 75.0));
//        dto2.add(new ReportDto("PC4", 24, 1,95.5));
//        dto2.add(new ReportDto("KK5", 588, 19, 90.8));
//        dto2.add(new ReportDto("LP6", 630, 30, 75.0));
//        dto2.add(new ReportDto("PC7", 24, 1,95.5));
//        dto2.add(new ReportDto("KK8", 588, 19, 90.8));
//        dto2.add(new ReportDto("LP9", 630, 30, 75.0));
//        dto2.add(new ReportDto("LP10", 630, 30, 75.0));
//
//
//        rep004(dto1,dto1,dto2,dto2);



        ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "f", "g"));


        listTwo.removeAll(listOne);
        listOne.addAll(listTwo);

        System.out.println(listOne);

    }


    private static void rep004(List<ReportDto> dto1,List<ReportDto> dto2,List<ReportDto> dto3,List<ReportDto> dto4){

        Map<String, Object> param = new HashMap<>();
        param.put("DATA_TOOL_PTC", dto1);
        param.put("DATA_TOOL_PTF", dto1);
        param.put("DATA_TEST_PTC", dto2);
        param.put("DATA_TRAIN_PTC", dto2);
        try {
            List<JasperPrint> jasperPrints = new ArrayList<JasperPrint>();
            JasperReport report = JasperCompileManager.compileReport(RepConstant.REPORT_JRXML_004);
            jasperPrints.add(JasperFillManager.fillReport(report, param, new JREmptyDataSource()));
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrints));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(RepConstant.REPORT_PDF_004));
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            configuration.setCreatingBatchModeBookmarks(true);
            exporter.setConfiguration(configuration);
            exporter.exportReport();
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}