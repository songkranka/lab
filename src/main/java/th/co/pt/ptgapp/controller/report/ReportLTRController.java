package th.co.pt.ptgapp.controller.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.view.JasperViewer;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.ModelReport;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.entity.RequestCondition;
import th.co.pt.ptgapp.entity.WaitWorkModel;
import th.co.pt.ptgapp.entity.report.DataExportList;
import th.co.pt.ptgapp.entity.report.ReportRequestNo;
import th.co.pt.ptgapp.service.report.ReportLTRService;
import th.co.pt.ptgapp.utils.CGlobal;
import th.co.pt.ptgapp.utils.ReportUtils;
import th.co.pt.ptgapp.utils.WebUtil;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.google.gson.Gson;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;

import org.apache.maven.model.Model;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@Controller
public class ReportLTRController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ReportLTRService reportLTRService;

	@Autowired
	ServletContext context;

	@RequestMapping("reportLTR")
	public ModelAndView reportLTRTuckView() throws Exception {
		return new ModelAndView("reportLTRTuckView");
	}

	@RequestMapping(value = "/exportReportLTR", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> reportLTRTuck(@RequestParam(value = "productType") String productType,
			@RequestParam(value = "checkType") String checkType,

			@RequestParam(value = "labCode") String labCode, HttpServletRequest req, HttpServletResponse httpResposne,
			HttpSession session) throws Exception {
		JRPdfExporter exporter = new JRPdfExporter();
		httpResposne.setContentType("application/pdf");
		httpResposne.setHeader("Content-Disposition", "inline;filename=Report.pdf");
		// JRPdfExporter jrPdfExporter = new JRPdfExporter();
		try {
			logger.info(" labCode : {}", labCode);
			String labCodeArr[] = labCode.split(",");
			logger.info("<==== reportLTRTuck =====>");
			logger.info("labCodeArr :{}", labCodeArr.length);

			MemberObj memberObj = CGlobal.getC_UserInfo(session);
			String printReportBy = memberObj.getNamempt();
			logger.info("memberObj :{}", memberObj);
			List<Map<String, Object>> result = reportLTRService.mapDataForReportLTR(labCodeArr, productType, checkType,
					printReportBy, memberObj.getCodempid());

//				JasperPrint jasperPrint = getReportLTR(result,productType);
			List<JasperPrint> list = new ArrayList<JasperPrint>();
		
			for (Map<String, Object> m : result) {
				JasperPrint jasperPrint = getReportLTR(m, productType, checkType);
				list.add(jasperPrint);
			}
			
			logger.info("<===== List :  =======> {}", list);
			logger.info("<===== jasperPrint :  =======> {}", list.size());

			exporter.setExporterInput(SimpleExporterInput.getInstance(list));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(httpResposne.getOutputStream()));
			exporter.exportReport();
			return new ResponseEntity<String>("", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception : {}", e);
			throw new RuntimeException(e.getMessage());
		}

	}

	@SuppressWarnings({ "resource" })
	@RequestMapping(value = "/reportExcelHeader", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<StreamingResponseBody> reportExcelTrip(
			@RequestParam(value = "labCode") String labCode, @RequestParam(value = "reportType") String reportType)
			throws Exception {

		// System.out.println(objReq.getTripID());
		Workbook workBook = new XSSFWorkbook();
		// workBook.close();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String nameReport = "";
		String labCodeArr[] = labCode.split(",");
		workBook = reportLTRService.exportReportPageHeader(labCodeArr);

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + reportType + " Result" + ".xlsx")
				.body(workBook::write);
	}

	@SuppressWarnings({ "resource" })
	@RequestMapping(value = "/reportExcelHeaderTools", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<StreamingResponseBody> reportExcelHeaderTools(
			@RequestParam(value = "labCode") String labCode, @RequestParam(value = "reportType") String reportType)
			throws Exception {

		// System.out.println(objReq.getTripID());
		Workbook workBook = new XSSFWorkbook();
		// workBook.close();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String nameReport = "";
		String labCodeArr[] = labCode.split(",");
		workBook = reportLTRService.exportReportPageHeaderTools(labCodeArr);

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + reportType + " Result" + ".xlsx")
				.body(workBook::write);
	}

	public JasperPrint getReportLTR(Map<String, Object> objReq, String productType, String checkType) throws Exception {
		JasperPrint jasperPrint = null;
		List<JasperPrint> jasperPrints = new ArrayList<>();
		String pathLicen = "";
		String pathLicenApp = "";
		try {
			logger.info("<==== getReportLTR =====>");
			Map parameters = new HashMap();
			logger.info("<===== objReq =======> {}", objReq.size());
			List<Map<String, Object>> list = new ArrayList<>();
//  			 String path ="/site/wwwroot/webapps/imageLab2020/";
//  			 String path  =" report/jrxml/image/";
			String path = context.getRealPath("resources/image/");
			String pathlicen = context.getRealPath("resources/license/");
			String pathReport = context.getRealPath("resources/report/");
			pathLicen = reportLTRService.findLicen(objReq.get("V_REPORTED_BY_CODE").toString());

			String picReportBy = pathlicen + pathLicen;
			pathLicenApp = reportLTRService.findLicen(objReq.get("V_APPROVE_BY_CODE").toString());

			String picApproveBy = pathlicen + pathLicenApp;
			FileSystemResource filepicReportBy, filepicApproveBy;

			filepicReportBy = new FileSystemResource(picReportBy);
			filepicApproveBy = new FileSystemResource(picApproveBy);
			// System.out.println(picReportBy);
			// System.out.println(picApproveBy);
			if (filepicReportBy.exists() && pathLicen != "") {
				// parameters.put("IMG_RP_BY",
				// (pathLicen!=null&&pathLicen!="")?context.getRealPath(pathLicen):pathlicen+""+objReq.get("V_REPORTED_BY_CODE").toString()+".png");
				parameters.put("IMG_RP_BY", pathlicen + pathLicen);
			} else {
				parameters.put("IMG_RP_BY", pathlicen + "" + objReq.get("V_REPORTED_BY_CODE").toString() + ".png");
			}

			if (filepicApproveBy.exists() && pathLicenApp != "") {
				parameters.put("IMG_AP_BY", pathlicen + pathLicenApp);
			} else {
				parameters.put("IMG_AP_BY", pathlicen + "" + objReq.get("V_APPROVE_BY_CODE").toString() + ".png");
			}

			if ("LTR".equals(checkType)) {

				list.add(objReq);
				if ("00001".equals(productType) || "00010".equals(productType)) {
					// add condition
					if ("100000041".equals(objReq.get("PRODUCT_CODE").toString())
							&& "IRPC".equals(String.valueOf(objReq.get("LTR_CC")))) {
						
						String desc = objReq.get("V_REPORTED_BY_CODE").toString();
						
						jasperPrint = ReportUtils.exportReportV2("LTR_C_CAR_BIO", parameters,
								new JRBeanCollectionDataSource(list),
								objReq.get("LTR_CODE_NO").toString() + "_" + objReq.get("LTR_CODE").toString(), "LTR",
								pathReport);
					} else {
						
						String desc = objReq.get("V_REPORTED_BY_CODE").toString();
						
						jasperPrint = ReportUtils.exportReportV2("LTR_C_CAR", parameters,
								new JRBeanCollectionDataSource(list),
								objReq.get("LTR_CODE_NO").toString() + "_" + objReq.get("LTR_CODE").toString(), "LTR",
								pathReport);
					}
				} else if ("00002".equals(productType) || "00009".equals(productType) || "00008".equals(productType)) {
					if ("IRPC".equals(String.valueOf(objReq.get("LTR_CC")))) {
						jasperPrint = ReportUtils.exportReportV2("LTR_C_BOAT_COND", parameters,
								new JRBeanCollectionDataSource(list),
								objReq.get("LTR_CODE_NO").toString() + "_" + objReq.get("LTR_CODE").toString(), "LTR",
								pathReport);
					} else {
						jasperPrint = ReportUtils.exportReportV2("LTR_C_BOAT", parameters,
								new JRBeanCollectionDataSource(list),
								objReq.get("LTR_CODE_NO").toString() + "_" + objReq.get("LTR_CODE").toString(), "LTR",
								pathReport);
					}

				} else if ("00003".equals(productType)) {
					if ("IRPC".equals(String.valueOf(objReq.get("LTR_CC")))) {
						jasperPrint = ReportUtils.exportReportV2("LTR_TRUCT_COND", parameters,
								new JRBeanCollectionDataSource(list),
								objReq.get("LTR_CODE_NO").toString() + "_" + objReq.get("LTR_CODE").toString(), "LTR",
								pathReport);
					} else {
						jasperPrint = ReportUtils.exportReportV2("LTR_TRUCT", parameters,
								new JRBeanCollectionDataSource(list),
								objReq.get("LTR_CODE_NO").toString() + "_" + objReq.get("LTR_CODE").toString(), "LTR",
								pathReport);
					}

				} else if ("00004".equals(productType)) {
					parameters.put("IMG_1", path + "logoPTG.png");
					parameters.put("IMG_2", path + "logoPTG2.png");
					// add condition
					if ("IRPC".equals(String.valueOf(objReq.get("LTR_CC")))) {
						jasperPrint = ReportUtils.exportReportV2("LTR_T_COND", parameters,
								new JRBeanCollectionDataSource(list),
								objReq.get("LTR_CODE_NO").toString() + "_" + objReq.get("LTR_CODE").toString(), "LTR",
								pathReport);
					} else {

						jasperPrint = ReportUtils.exportReportV2("LTR_T", parameters,
								new JRBeanCollectionDataSource(list),
								objReq.get("LTR_CODE_NO").toString() + "_" + objReq.get("LTR_CODE").toString(), "LTR",
								pathReport);
					}
				} else if ("00005".equals(productType)) {
					jasperPrint = ReportUtils.exportReportV2("LTR_RETURN", parameters,
							new JRBeanCollectionDataSource(list),
							objReq.get("LTR_CODE_NO").toString() + "_" + objReq.get("LTR_CODE").toString(), "LTR",
							pathReport);
				} else if ("00006".equals(productType)) {
					// add condition
					if ("IRPC".equals(String.valueOf(objReq.get("LTR_CC")))) {
						jasperPrint = ReportUtils.exportReportV2("LTR_Additive3_COND", parameters,
								new JRBeanCollectionDataSource(list),
								objReq.get("PARAM_1").toString() + "_" + objReq.get("LTR_CODE").toString(), "LTR",
								pathReport);
					} else {
						jasperPrint = ReportUtils.exportReportV2("LTR_Additive3", parameters,
								new JRBeanCollectionDataSource(list),
								objReq.get("PARAM_1").toString() + "_" + objReq.get("LTR_CODE").toString(), "LTR",
								pathReport);
					}
				} else if ("00007".equals(productType)) {
					jasperPrint = ReportUtils.exportReportV2("LTR_OTHER", parameters,
							new JRBeanCollectionDataSource(list),
							objReq.get("LTR_CODE_NO").toString() + "_" + objReq.get("LTR_CODE").toString(), "LTR",
							pathReport);
				}
			} else {

//				parameters.put("IMG_RP_BY", (pathLicen!=null&&pathLicen!="")?context.getRealPath(pathLicen):pathlicen+""+objReq.get("V_REPORTED_BY_CODE").toString()+".png");
//				parameters.put("IMG_AP_BY", pathlicen+""+objReq.get("V_APPROVE_BY_CODE").toString()+".png");
				parameters.put("IMG_1", path + "logoPTG.png");
				parameters.put("IMG_2", path + "logoPTG4.png");

				logger.info("parameter :{}", parameters);
				list.add(objReq);
				jasperPrint = ReportUtils.exportReportV2("COQ_T", parameters, new JRBeanCollectionDataSource(list),
						objReq.get("LTR_CODE_NO").toString() + "_" + objReq.get("LTR_CODE").toString(), "COQ",
						pathReport);
			}

			return jasperPrint;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception :{} ", e);
			throw new RuntimeException(e.getMessage());
		}
	}

	@RequestMapping(value = "getDataReportLTR", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDataReportLTR(@RequestBody String json, HttpServletRequest req,
			HttpSession session) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> reportLTRResultList = new ArrayList<Map<String, Object>>();
		try {
			JSONObject jo = new JSONObject(json);
			String startDate = jo.getString("startDate");
			String endDate = jo.getString("endDate");
			String sampleTypeCode[] = jo.getString("sampleTypeCode").toString().split("#");
			String productType[] = jo.getString("productType").toString().split("#");
			String plantID = jo.getString("plantID");
			String typeReportSearch = jo.getString("typeReportSearch");
			String resultHd = jo.getString("resultltr");
			logger.info("startDate :{}", startDate);
			logger.info("endDate :{}", endDate);
			logger.info("sampleTypeCode :{}", sampleTypeCode);
			logger.info("productType :{}", productType);
			reportLTRResultList = reportLTRService.getDataReportLTR(startDate, endDate, productType, sampleTypeCode,
					plantID, typeReportSearch, resultHd);
			result.put("success", "1");
		} catch (Exception ex) {
			result.put("success", "0");
			result.put("message", ex.getMessage());
			ex.printStackTrace();
		}
		// System.out.println(randomLastResult);
		logger.info("reportLTRResultList : {}", reportLTRResultList.size());
		return reportLTRResultList;

	}

	// แยกตามคลัง
	@RequestMapping("reportLTRPlant")
	public ModelAndView reportLTRPlantView() throws Exception {
		return new ModelAndView("reportLTRPlantView");
	}

	@RequestMapping("cancelThisMonth")
	public ModelAndView cancelThisMonthView() throws Exception {
		return new ModelAndView("cancelThisMonthView");
	}

	@RequestMapping(value = "reportExcelCancel", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<StreamingResponseBody> reportExcelCancel(
			@RequestParam(value = "year") String year, @RequestParam(value = "month") String month,
			@RequestParam(value = "plant") String plant) throws Exception {

		Workbook workBook = new XSSFWorkbook();
		// workBook.close();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		workBook = reportLTRService.exportReportCancel(year, month, plant);

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=Cancel" + month + "" + year + ".xlsx")
				.body(workBook::write);
	}

	@RequestMapping(value = "sendmailtoadmin", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> sendMailToStore(HttpSession session, @RequestParam String labcode,
			@RequestBody RandomOil ran) {
		Map<String, Object> map = null;
		List<Map<String, String>> list = null;
		try {
			map = new HashMap<String, Object>();
			MemberObj memberObj = CGlobal.getC_UserInfo(session);
			list = reportLTRService.getRoleAdmin(ran.getRole_id());
			reportLTRService.SendMailCancel(list, memberObj.getNamempt(), labcode);
			map.put("resultCode", "00");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "reportcrate/{productid}/{sampletype}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> reportcrate(@PathVariable String productid, @PathVariable String sampletype,
			HttpServletResponse httpResposne) throws Exception {
		JRPdfExporter exporter = new JRPdfExporter();
		httpResposne.setContentType("application/pdf");
		httpResposne.setHeader("Content-Disposition", "inline;filename=Report.pdf");
		// JRPdfExporter jrPdfExporter = new JRPdfExporter();
		List<Map<String, Object>> res = null;
		List<Map<String, Object>> filterdata = null;

		try {
			List<JasperPrint> list = new ArrayList<JasperPrint>();
			res = reportLTRService.exportReportCrate(productid, sampletype);
			// filter data to report
			if (res.size() > 0) {
				filterdata = reportLTRService.filterDataCrate(sampletype, res);
				for (Map<String, Object> m : filterdata) {
					JasperPrint jasperPrint = reportLTRService.filterDataCrate(m, res.get(0));
					list.add(jasperPrint);

				}
				logger.info("<===== jasperPrint :  =======> {}", list.size());

				exporter.setExporterInput(SimpleExporterInput.getInstance(list));
				exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(httpResposne.getOutputStream()));
				exporter.exportReport();
			}
			return new ResponseEntity<String>("", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception : {}", e);
			throw new RuntimeException(e.getMessage());
		}

	}

	@ResponseBody
	@RequestMapping("/sendmailcompleteltr")
	public void sendMailCompleteLTR() {
		reportLTRService.sendmailCompleteLtr();
	}

	@RequestMapping(value = "waitworksubrole", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> waitworksubrole(@RequestParam String ltrid, HttpServletResponse httpResposne,
			HttpSession session) throws Exception {
		JRPdfExporter exporter = new JRPdfExporter();
		httpResposne.setContentType("application/pdf");
		httpResposne.setHeader("Content-Disposition", "inline;filename=Report.pdf");
		// JRPdfExporter jrPdfExporter = new JRPdfExporter();
		List<WaitWorkModel> res = null;
		Map<String, List<WaitWorkModel>> filterdata = null;
		List<JasperPrint> list = new ArrayList<JasperPrint>();
		try {

			MemberObj memberObj = CGlobal.getC_UserInfo(session);

			res = new ArrayList<WaitWorkModel>();
			res = reportLTRService.getDataLtrIdWaitwork(ltrid, memberObj.getCodempid(), memberObj.getRole_id());

			// filter data to report
			if (res.size() > 0) {
				filterdata = reportLTRService.filterDataWaitwork(res, memberObj.getRole_id());
				for (int i = 0; i < filterdata.size(); i++) {
					JasperPrint jasperPrint = reportLTRService.exportWaitwork(filterdata.get("num" + i),
							memberObj.getRole_id());
					list.add(jasperPrint);
				}
				logger.info("<===== jasperPrint :  =======> {}", list.size());
				reportLTRService.getUpdateStatusPrintWaitwork("U", ltrid, memberObj.getRole_id());
				exporter.setExporterInput(SimpleExporterInput.getInstance(list));
				exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(httpResposne.getOutputStream()));
				exporter.exportReport();
			}
			return new ResponseEntity<String>("", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception : {}", e);
			throw new RuntimeException(e.getMessage());
		}

	}

	@RequestMapping(value = "/conditionLTR", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> conditionLTR(@RequestBody RequestCondition requestCondition) {
		List<Map<String, Object>> response = null;
		try {
			response = reportLTRService.conditionLTRService(requestCondition);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@GetMapping("/testmail")
	@ResponseBody
	public void testmail() {
		reportLTRService.testmail();
	}

	@RequestMapping("reportRandomSample2")
	public ModelAndView reportRandomSample2() throws Exception {
		return new ModelAndView("reportRandomSample2");
	}

	@RequestMapping(value = "reportExcelRandomSample2", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<StreamingResponseBody> reportExcelRandomSample2(
			@RequestParam(value = "from") String from) throws Exception {

		Workbook workBook = new XSSFWorkbook();

		// workBook.close();
		workBook = reportLTRService.exportReportExcelRandomSample2(from);

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + from + ".xlsx").body(workBook::write);
	}

	@RequestMapping(value = "reportExcelRandomSampleBefore", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<StreamingResponseBody> reportExcelRandomSampleBefore(
			@RequestParam(value = "from") String from, @RequestParam(value = "round") String round) throws Exception {

		Workbook workBook = new XSSFWorkbook();
		String roundTxt = "";
		if ("M".equals(round)) {
			roundTxt = "Morning";
		} else {
			roundTxt = "Afternoon";
		}
		// workBook.close();
		workBook = reportLTRService.exportReportExcelRandomSampleBefore(from, round);

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=" + from + "_" + roundTxt + ".xlsx")
				.body(workBook::write);
	}

	@RequestMapping(value = "/exportReportExample", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> exportReportExample(HttpServletResponse httpResposne, HttpSession session)
			throws Exception {
		List<Map<String, Object>> obj = new ArrayList<>();

		JasperPrint jasperPrint = null;
		JRBeanCollectionDataSource jr = null;
		JRBeanCollectionDataSource jrsubdata = null;
		Map<String, Object> map = null;
		Map<String, Object> submap = null;
		ReportRequestNo pr = null;

		List<Map<String, Object>> listExport = null;
		List<ReportRequestNo> listdata = null;
		Path path = Paths.get("sub.jrxml");

		try {

			listExport = new ArrayList<>();

			submap = new HashMap<String, Object>();
			listdata = new ArrayList<>();
			map = new HashMap<String, Object>();
			for (int i = 0; i < 3; i++) {
				pr = new ReportRequestNo();
				pr.setLabCode("LAB" + i);
				pr.setType("TYPE" + i);
				pr.setProduct("PRODUCT" + i);
				listdata.add(pr);
			}
			jrsubdata = new JRBeanCollectionDataSource(listdata);
			submap.put("CollectionBeanParamSub", jrsubdata);
			submap.put("header", "BOX 1");
			listExport.add(submap);

			submap = new HashMap<String, Object>();
			listdata = new ArrayList<>();
			map = new HashMap<String, Object>();
			for (int i = 0; i < 3; i++) {
				pr = new ReportRequestNo();
				pr.setLabCode("LAB" + i);
				pr.setType("TYPE" + i);
				pr.setProduct("PRODUCT" + i);
				listdata.add(pr);
			}
			jrsubdata = new JRBeanCollectionDataSource(listdata);
			submap.put("CollectionBeanParamSub", jrsubdata);
			submap.put("header", "BOX 2");
			listExport.add(submap);

//	    		
//	    		submap.put("f1", "A");
//	    		listExport.add(submap);
//	    		submap= new HashMap<String, Object>();
//	    		submap.put("f1", "B");
//	    		listExport.add(submap);
//	    		submap= new HashMap<String, Object>();
//	    		submap.put("f1", "C");
//	    		listExport.add(submap);
			jr = new JRBeanCollectionDataSource(listExport);

			map.put("PATH", "D:/ptg-lab-webapp-project2/src/main/java/report/jrxml/sub.jasper");
			map.put("CollectionBeanParam", jr);

			jasperPrint = ReportUtils.exportReport("DynamicTable", map, new JREmptyDataSource());
			httpResposne.setContentType("application/pdf");
			httpResposne.setHeader("Content-disposition", "inline; filename=assignment.pdf");
			OutputStream out = httpResposne.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, out);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return new ResponseEntity<>("", HttpStatus.OK);
	}

}