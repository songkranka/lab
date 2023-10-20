package th.co.pt.ptgapp.service.report;




import java.util.*;
import org.apache.poi.ss.usermodel.Workbook;


import net.sf.jasperreports.engine.JasperPrint;
import th.co.pt.ptgapp.entity.RequestCondition;
import th.co.pt.ptgapp.entity.WaitWorkModel;

public interface ReportLTRService {
   public List<Map<String,Object>>mapDataForReportLTR(String[] labCode,String productType,String reportType,String reportedBy,String codEmpId);
   
   public Workbook exportReportPageHeader(String[] labCode);
   
   public List<Map<String,Object>> getDataReportLTR(String startDate,String endDate,String []productType,String []sampleTypeCode,String plantID,String typeReportSearch,String result);

   public String findLicen(String string);

   public Workbook exportReportCancel(String year, String month, String plant);

   public String SendMailCancel(List<Map<String,String>> userTo,String userfrom,String labcode);

   public List<Map<String, String>> getRoleAdmin(String role_id);

   public List<Map<String, Object>> exportReportCrate(String productid,String sampletype);

   public List<Map<String, Object>> filterDataCrate(String sampletype, List<Map<String, Object>> res);

   public JasperPrint filterDataCrate(Map<String, Object> m,Map<String, Object> detail);

   public void sendmailCompleteLtr();

   public List<Map<String,Object>> conditionLTRService(RequestCondition requestCondition);

   public List<Map<String, Object>> getRemarkReport(RequestCondition requestCondition);

   public List<WaitWorkModel> getDataLtrIdWaitwork(String ltrid, String codempid,String role);

   public Map<String,List<WaitWorkModel>> filterDataWaitwork(List<WaitWorkModel> res,String role);

   public JasperPrint exportWaitwork(List<WaitWorkModel> listwaitwork, String role);

   public void getUpdateStatusPrintWaitwork(String string, String ltrid,String roleId);

   public void testmail();

   public Workbook exportReportExcelRandomSample2(String from);

   public Workbook exportReportExcelRandomSampleBefore(String from,String round);

   public Workbook exportReportPageHeaderTools(String[] labCodeArr);





}
