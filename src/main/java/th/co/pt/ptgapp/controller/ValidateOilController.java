package th.co.pt.ptgapp.controller;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import th.co.pt.ptgapp.config.MSGLabPropertiesServiceImpl;
import th.co.pt.ptgapp.config.PtgPropertiesServiceImpl;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.ResultObj;
import th.co.pt.ptgapp.service.RandomService;
import th.co.pt.ptgapp.utils.CGlobal;
import th.co.pt.ptgapp.utils.ReportUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ValidateOilController {
	@Autowired
	private RandomService randomService;

	@Autowired
	private PtgPropertiesServiceImpl PtgPropertiesServiceImpl;

	@Autowired
	private MSGLabPropertiesServiceImpl msgLabPropertiesService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("requestValidate")
	public ModelAndView home_test(HttpServletRequest req, Model model, HttpSession session) throws Exception {
		// System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		MemberObj memberObj = CGlobal.getC_UserInfo(session);
		// userService.getUser("xx");
		RandomOil objReq = new RandomOil();
		// objReq.setNameStore(memberObj.getPlantId());

		// Map<String, Object> result =
		// randomService.getNameStoreSetupRandomOil(objReq);
		Map<String, Object> result = new HashMap<String, Object>();
		// result.put("PLANT_ID", memberObj.getPlantId());

		return new ModelAndView("requestValidateOil", "Model", result);
	}

	@RequestMapping("editdatarandom")
	public @ResponseBody Map<String, Object> editdatarandom(@RequestBody RandomOil objReq, HttpServletRequest req,
			HttpSession session) throws Exception {
		// System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

		MemberObj memberObj = CGlobal.getC_UserInfo(session);

		System.out.println("editdata");
		objReq.setCreateBy(memberObj.getCodempid());
		Map<String, Object> result = randomService.editSubSeqRandomOil(objReq);

		return result;
	}

	@RequestMapping("updatedataCarNoValue")
	public @ResponseBody Map<String, Object> updateCarNo(@RequestBody RandomOil objReq, HttpServletRequest req,
			HttpSession session) throws Exception {
		MemberObj memberObj = CGlobal.getC_UserInfo(session);
		// objReq.setCreateBy(memberObj.getCodempid());
		Map<String, Object> result = new HashMap<String, Object>();
		// System.out.println("VALUE =
		// "+objReq.getCarNo()+":"+objReq.getLabCode_No()+":"+objReq.getStatus());
		try {
			result = randomService.updateCarNo(objReq);
			result.put("success", "1");
		} catch (Exception ex) {
			result.put("success", "0");
			result.put("message", ex.getMessage());
			ex.printStackTrace();
		}

		return result;
	}

	@RequestMapping("checkedPrint")
	public @ResponseBody Map<String, Object> checkPrint(@RequestBody RandomOil objReq, HttpServletRequest req,
			HttpSession session) throws Exception {
		MemberObj memberObj = CGlobal.getC_UserInfo(session);
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result = randomService.checkPrint(objReq);
			result.put("success", "1");
		} catch (Exception ex) {
			result.put("success", "0");
			result.put("message", ex.getMessage());
			ex.printStackTrace();
		}
		return result;
	}

	@RequestMapping("updateCancelStatus")
	public @ResponseBody Map<String, Object> updateCancelStatus(@RequestBody RandomOil objReq, HttpServletRequest req,
			HttpSession session) throws Exception {
		MemberObj memberObj = CGlobal.getC_UserInfo(session);
		// objReq.setCreateBy(memberObj.getCodempid());
		Map<String, Object> result = new HashMap<String, Object>();
		// System.out.println("VALUE =
		// "+objReq.getCarNo()+":"+objReq.getLabCode_No()+":"+objReq.getStatus());
		try {
			result = randomService.updateCancelStatus(objReq);
			result.put("success", "1");
		} catch (Exception ex) {
			result.put("success", "0");
			result.put("message", ex.getMessage());
			ex.printStackTrace();
		}

		return result;
	}

	@RequestMapping("queryDataFreeCar")
	public @ResponseBody Map<String, Object> queryDataFreeCar(@RequestBody RandomOil objReq, HttpServletRequest req,
			HttpSession session) throws Exception {
		MemberObj memberObj = CGlobal.getC_UserInfo(session);
		// objReq.setCreateBy(memberObj.getCodempid());
		Map<String, Object> result = new HashMap<String, Object>();
		// System.out.println("VALUE =
		// "+objReq.getCarNo()+":"+objReq.getLabCode_No()+":"+objReq.getStatus());
		try {
			result = randomService.queryDataFreeCar(objReq);
			result.put("success", "1");
		} catch (Exception ex) {
			result.put("success", "0");
			result.put("message", ex.getMessage());
			ex.printStackTrace();
		}

		return result;
	}

	@RequestMapping(value = "/sendRequestRandomOil", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveRandomOil(@RequestBody RandomOil objReq, HttpServletRequest req,
			HttpSession session) throws Exception {
		Map<String, Object> obj = new HashMap<String, Object>();
		try {
			logger.info("----- send Request Random Oil Analysis paper -------");
//    		int i=0 ;
//    		while(i<100000){
//    			System.out.println(i);
//    			i++;
//    		}
			/*
			 * for(int i=0;i<objReq.getListRandomOil().size();i++){ RandomOil obj1
			 * =objReq.getListRandomOil().get(i);
			 * System.out.println("labocde==>"+obj1.getLabCode_No()); }
			 */
			MemberObj memberObj = CGlobal.getC_UserInfo(session);
			// logger.info(memberObj.toString());

			// System.out.println(memberObj.getCodempid());
			objReq.setCreateBy(memberObj.getCodempid());
			objReq.setNameStore(memberObj.getPlantId());
			// objReq.setManualType(manualType);

			logger.info("-------- print param obj 'RandomOil' --------");
			logger.info(objReq.toString());
			obj = randomService.sendRequestRandomOil(objReq);
			// obj.put("success", 1);

		} catch (Exception ex) {
			obj.put("success", 0);
			obj.put("message", (ex.getMessage().length() > 200 ? ex.getMessage().substring(0, 200) : ex.getMessage()));
			ex.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/updateStatusSendAnalysis", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateStatusSendAnalysis(@RequestBody RandomOil objReq,
			HttpServletRequest req, HttpSession session) throws Exception {
		Map<String, Object> obj = new HashMap<String, Object>();
		try {
			logger.info("----- send Request Random Oil Analysis Change status to 02 -------");
			MemberObj memberObj = CGlobal.getC_UserInfo(session);
			objReq.setCreateBy(memberObj.getCodempid());
			objReq.setNameStore(memberObj.getPlantId());
			obj = randomService.updateStatusSendAnalysis(objReq);
		} catch (Exception ex) {
			obj.put("success", 0);
			obj.put("message", (ex.getMessage().length() > 200 ? ex.getMessage().substring(0, 200) : ex.getMessage()));
			ex.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/randomOilSpareDetail", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> randomOilSpareDetail(@RequestBody RandomOil objReq, HttpServletRequest req,
			HttpSession session) throws Exception {
		Map<String, Object> obj = new HashMap<String, Object>();
		try {

			// System.out.println("NameStore==>"+objReq.getNameStore());
			obj = randomService.inquiryRandomOilSpareDetail(objReq);

			obj.put("success", "1");
		} catch (Exception ex) {
			obj.put("success", "0");
			obj.put("message", ex.getMessage());
			ex.printStackTrace();
		}

		return obj;
	}

	@RequestMapping("reportHome")
	public void reportHome(@ModelAttribute RandomOil objReq, HttpServletRequest req, HttpServletResponse httpResposne,
			HttpSession session) throws Exception {
		JRPdfExporter exporter = new JRPdfExporter();
		httpResposne.setContentType("application/pdf");
		httpResposne.setHeader("Content-Disposition", "inline;filename=ReportAll.pdf");
		System.out.println("----- objReq ------ " + objReq.getLabCode_No());
		System.out.println("----- objReq(in) ------ " + objReq.getLabCode_NoIn());
		MemberObj memberObj = CGlobal.getC_UserInfo(session);
		System.out.println(memberObj.getNamempt() + "NAME");
		objReq.setPrintName(memberObj.getNamempt());

		System.out.println("Object request" + objReq);
		
		Map<String, Object> obj = explandResult(randomService.inquiryRandomOilDetail(objReq));
		// System.out.println("line 155 = "+objReq);
		System.out.println("Object result" + obj);

		JasperPrint jasperPrint = getReportTrans(obj);

		List<JasperPrint> list = new ArrayList<JasperPrint>();
		list.add(jasperPrint);

		// System.out.println("JASPER = "+jasperPrint);
		exporter.setExporterInput(SimpleExporterInput.getInstance(list));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(httpResposne.getOutputStream()));
		exporter.exportReport();

		Runtime runtime = Runtime.getRuntime();
		long totalMemory = runtime.totalMemory(); // current heap allocated to the VM process
		long freeMemory = runtime.freeMemory(); // out of the current heap, how much is free
		long maxMemory = runtime.maxMemory(); // Max heap VM can use e.g. Xmx setting
		long usedMemory = totalMemory - freeMemory; // how much of the current heap the VM is using
		long availableMemory = maxMemory - usedMemory; // available memory i.e. Maximum heap size minus the current
														// amount used
		System.out
				.println("maxMemory|" + maxMemory + "usedMemory=" + usedMemory + "|availableMemory=" + availableMemory);

		System.gc();
	}

	public Map<String, Object> explandResult(Map<String, Object> objReq) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();

		List<Map<String, Object>> lstObj = new ArrayList<Map<String, Object>>();

		List list = (List) objReq.get("list");
		// System.out.println("(line183)PRINT LIST = "+list);
		// System.out.println(list.size()); //size count data

		for (int i = 0; i < list.size(); i++) {
			Map mapReq = (Map) list.get(i);
			RandomOil randomOil = new RandomOil();
			randomOil.setSampleResult(mapReq);
			String sampleLvlCode = mapReq.get("SAMPLE_LEVEL_CODE") == null ? ""
					: (String) mapReq.get("SAMPLE_LEVEL_CODE");
			// System.out.print(mapReq.get("SAMPLE_LEVEL_CODE"));
			if (sampleLvlCode.equals("00001")) {
				if (mapReq.get("BOAT_SLOTS") != null || mapReq.get("BOAT_SLOTP") != null) {
					// System.out.println("B");
					int boatSlotS = Integer.parseInt(mapReq.get("BOAT_SLOTS").toString());
					int boatSlotP = Integer.parseInt(mapReq.get("BOAT_SLOTP").toString());
					// System.out.println(boatSlot);
					if (boatSlotS == 0 || boatSlotP == 0) {
						// randomOil.setCarSlot("");
						randomOil.setBoatSlot("");
						randomOil.setSampleLevelCode("00001");
						randomOil.setSampleLevelDesc("AL");
						lstObj.add(setNewMapObject(randomOil));
					} else {
						for (int s = 0; s < mapReq.get("BOAT_SLOTS").toString().length(); s++) {
							// System.out.println("Count Boat Slot = "+b);
							String bCount = Integer.toString(s + 1);
							randomOil.setBoatSlot(mapReq.get("BOAT_SLOTS").toString().split("")[s] + "S");
							// randomOil.setCarSlot("");
							randomOil.setSampleLevelCode("00001");
							randomOil.setSampleLevelDesc("AL");
							lstObj.add(setNewMapObject(randomOil));
						}
						for (int p = 0; p < mapReq.get("BOAT_SLOTP").toString().length(); p++) {
							// System.out.println("Count Boat Slot = "+b);
							String bCount = Integer.toString(p + 1);
							randomOil.setBoatSlot(mapReq.get("BOAT_SLOTP").toString().split("")[p] + "P");
							// randomOil.setCarSlot("");
							randomOil.setSampleLevelCode("00001");
							randomOil.setSampleLevelDesc("AL");
							lstObj.add(setNewMapObject(randomOil));
						}
					}

				} else {
					// System.out.println("A");
					randomOil.setBoatSlot("");
					randomOil.setSampleLevelCode("00001");
					randomOil.setSampleLevelDesc("AL");
					randomOil.setCarSlot(mapReq.get("CAR_SLOT") == null ? "" : (String) mapReq.get("CAR_SLOT"));
					lstObj.add(setNewMapObject(randomOil));
				}

			} else if (sampleLvlCode.equals("00002")) {
				randomOil.setSampleLevelCode("00002");
				randomOil.setSampleLevelDesc("U");
				lstObj.add(setNewMapObject(randomOil));

			} else if (sampleLvlCode.equals("00003")) {
				randomOil.setSampleLevelCode("00003");
				randomOil.setSampleLevelDesc("M");
				lstObj.add(setNewMapObject(randomOil));

			} else if (sampleLvlCode.equals("00004")) {
				randomOil.setSampleLevelCode("00004");
				randomOil.setSampleLevelDesc("L");
				lstObj.add(setNewMapObject(randomOil));

			} else if (sampleLvlCode.equals("00005")) {
				randomOil.setSampleLevelCode("00002");
				randomOil.setSampleLevelDesc("U");
				lstObj.add(setNewMapObject(randomOil));

				randomOil.setSampleLevelCode("00003");
				randomOil.setSampleLevelDesc("M");
				lstObj.add(setNewMapObject(randomOil));

				randomOil.setSampleLevelCode("00004");
				randomOil.setSampleLevelDesc("L");
				lstObj.add(setNewMapObject(randomOil));

			} else if (sampleLvlCode.equals("00006")) {
				randomOil.setSampleLevelCode("00006");
				randomOil.setSampleLevelDesc("U");
				lstObj.add(setNewMapObject(randomOil));

				randomOil.setSampleLevelCode("00006");
				randomOil.setSampleLevelDesc("L");
				lstObj.add(setNewMapObject(randomOil));
			} else if (sampleLvlCode.equals("00007")) {
				randomOil.setSampleLevelCode("00007");
				randomOil.setSampleLevelDesc("M");
				lstObj.add(setNewMapObject(randomOil));

				randomOil.setSampleLevelCode("00007");
				randomOil.setSampleLevelDesc("L");
				lstObj.add(setNewMapObject(randomOil));
			} else if (sampleLvlCode.equals("00008")) {
				randomOil.setSampleLevelCode("00008");
				randomOil.setSampleLevelDesc("L");
				lstObj.add(setNewMapObject(randomOil));

				randomOil.setSampleLevelCode("00008");
				randomOil.setSampleLevelDesc("L");
				lstObj.add(setNewMapObject(randomOil));
			} else if (sampleLvlCode.equals("00009")) {
				randomOil.setSampleLevelCode("00009");
				randomOil.setSampleLevelDesc("M");
				lstObj.add(setNewMapObject(randomOil));

				randomOil.setSampleLevelCode("00009");
				randomOil.setSampleLevelDesc("M");
				lstObj.add(setNewMapObject(randomOil));
			} else if (sampleLvlCode.equals("00010")) {
				randomOil.setSampleLevelCode("00010");
				randomOil.setSampleLevelDesc("L");
				lstObj.add(setNewMapObject(randomOil));

				randomOil.setSampleLevelCode("00010");
				randomOil.setSampleLevelDesc("L");
				lstObj.add(setNewMapObject(randomOil));

				randomOil.setSampleLevelCode("00010");
				randomOil.setSampleLevelDesc("L");
				lstObj.add(setNewMapObject(randomOil));
			} else if (sampleLvlCode.equals("00011")) {
				randomOil.setSampleLevelCode("00011");
				randomOil.setSampleLevelDesc("M");
				lstObj.add(setNewMapObject(randomOil));

				randomOil.setSampleLevelCode("00011");
				randomOil.setSampleLevelDesc("M");
				lstObj.add(setNewMapObject(randomOil));

				randomOil.setSampleLevelCode("00011");
				randomOil.setSampleLevelDesc("M");
				lstObj.add(setNewMapObject(randomOil));
			} else if (sampleLvlCode.equals("00012")) {
				randomOil.setSampleLevelCode("00012");
				randomOil.setSampleLevelDesc("AL");
				lstObj.add(setNewMapObject(randomOil));

				randomOil.setSampleLevelCode("00012");
				randomOil.setSampleLevelDesc("AL");
				lstObj.add(setNewMapObject(randomOil));

			} else if (sampleLvlCode.equals("00013")) {
				randomOil.setSampleLevelCode("00013");
				randomOil.setSampleLevelDesc("AL");
				lstObj.add(setNewMapObject(randomOil));

				randomOil.setSampleLevelCode("00013");
				randomOil.setSampleLevelDesc("AL");
				lstObj.add(setNewMapObject(randomOil));

				randomOil.setSampleLevelCode("00013");
				randomOil.setSampleLevelDesc("AL");
				lstObj.add(setNewMapObject(randomOil));
			} else {
				System.out.println("ELSE");

			}

		}
		result.put("list", lstObj);
		return result;
	}

	public Map<String, Object> setNewMapObject(RandomOil randomOil) throws Exception {
		// public Map<String,Object> setNewMapObject(Map<String,Object> mapReq,String
		// sampleCode,String sampleDesc)throws Exception {
		Map<String, Object> mapReq = randomOil.getSampleResult();
		String sampleCode = randomOil.getSampleLevelCode();
		String sampleDesc = randomOil.getSampleLevelDesc();
		String boatSlot = randomOil.getBoatSlot();
		// boatSlot New
		String boatSlotS = randomOil.getBoatSlotS();
		String boatSlotP = randomOil.getBoatSlotP();
		// System.out.println(boatSlot);
		String carSlot = randomOil.getCarSlot();
		String staff_name = randomOil.getCreateBy();
		Map<String, Object> objReq = new HashMap<String, Object>();
		// System.out.println("line 239 = "+boatSlot);
		objReq.put("BOAT_SLOTS", boatSlotS);
		objReq.put("BOAT_SLOTP", boatSlotP);

		objReq.put("LAB_CODE", mapReq.get("LAB_CODE"));
		objReq.put("PLANT_ID", mapReq.get("PLANT_ID"));
		objReq.put("plant_name", mapReq.get("plant_name"));
		// แสดง Shipment No. ที่บันทึกไว้ (c-boat) PO
		if ("00002".equals(mapReq.get("SAMPLE_TYPE")) || "00009".equals(mapReq.get("SAMPLE_TYPE"))
				|| "00008".equals(mapReq.get("SAMPLE_TYPE"))) {
			objReq.put("PO_NO", mapReq.get("BOAT_NO"));
		} else {
			objReq.put("PO_NO", mapReq.get("PO_NO"));
		}
		objReq.put("DO_NO", mapReq.get("DO_NO"));
		objReq.put("SHIPMENT_NO", mapReq.get("SHIPMENT_NO"));
		objReq.put("CAR_SLOT", mapReq.get("CAR_SLOT"));
		objReq.put("STR_SAMPLE_EXPIRE_DATE", mapReq.get("STR_SAMPLE_EXPIRE_DATE"));
		objReq.put("STR_SAMPLE_DATE", mapReq.get("STR_SAMPLE_DATE"));
		objReq.put("SAMPLE_LEVEL_CODE", sampleCode);
		objReq.put("SAMPLE_LEVEL_DESC", sampleDesc);
		objReq.put("CAR_NO", mapReq.get("CAR_NO"));
		objReq.put("BOAT_NO", mapReq.get("BOAT_NO"));
		objReq.put("BOAT_NAME", mapReq.get("BOAT_NAME"));
		objReq.put("BOAT_SLOT", boatSlot);
		objReq.put("CREATE_BY", mapReq.get("CREATE_BY"));
		objReq.put("SAMPLE_STAFF_ID", mapReq.get("SAMPLE_STAFF_ID"));
		objReq.put("SAMPLE_STAFF_NAME", mapReq.get("PRINT_NAME"));
		objReq.put("SAMPLE_REFER", mapReq.get("SAMPLE_REFER"));
		objReq.put("SAMPLE_DATA_GROUP", mapReq.get("SAMPLE_DATA_GROUP"));
		objReq.put("SAMPLE_DATA_SEQ", mapReq.get("SAMPLE_DATA_SEQ"));
		objReq.put("SOURCE_ID", mapReq.get("SOURCE_ID"));
		// แหล่งที่มาให้ระบุเป็นชื่อคลัง T
		if ("00004".equals(mapReq.get("SAMPLE_TYPE"))) {
			objReq.put("source_name", mapReq.get("plant_name"));
			objReq.put("logis_name", "-");
		} else if ("00005".equals(mapReq.get("SAMPLE_TYPE"))) { // RETURN
			objReq.put("source_name", mapReq.get("SOURCE_OTHER_DESC"));
			objReq.put("logis_name", mapReq.get("LOGIS_ID") == "99999999" ? (String) mapReq.get("OTHERLOGISTIC")
					: (String) mapReq.get("logis_name"));
		} else if ("00002".equals(mapReq.get("SAMPLE_TYPE")) || "00009".equals(mapReq.get("SAMPLE_TYPE"))
				|| "00008".equals(mapReq.get("SAMPLE_TYPE"))) { // BOAT
			objReq.put("logis_name", "-");
			objReq.put("source_name", mapReq.get("source_name"));
		} else if ("00007".equals(mapReq.get("SAMPLE_TYPE"))) {
			objReq.put("source_name", mapReq.get("SOURCE_OTHER_DESC"));
			objReq.put("logis_name", mapReq.get("LOGIS_ID") == "99999999" ? (String) mapReq.get("OTHERLOGISTIC")
					: (String) mapReq.get("logis_name"));
		} else {
			objReq.put("source_name", mapReq.get("source_name"));
			objReq.put("logis_name", mapReq.get("logis_name"));
		}
		// ใส่ชื่อต่อท้าย product เช่น PT Max Diesel B7 (T)
		objReq.put("PRODUCT_ID", mapReq.get("PRODUCT_ID"));
//    	if("00006".equals(mapReq.get("SAMPLE_TYPE")) && "00002".equals(mapReq.get("SAMPLE_TYPE"))) {
//    		objReq.put("product_name",mapReq.get("product_name"));
//    		
//    	}else {
//    		objReq.put("product_name",mapReq.get("product_name")==null?"":(String)mapReq.get("product_name")+" ("+mapReq.get("SAMPLE_TYPE_NAME")==null?"":(String)mapReq.get("SAMPLE_TYPE_NAME")+")");
//    	}
		String productStr = mapReq.get("product_name") == null ? "" : (String) mapReq.get("product_name");
		String typeStr = mapReq.get("SAMPLE_TYPE_NAME") == null ? ""
				: " (" + (String) mapReq.get("SAMPLE_TYPE_NAME") + ")";
		// productStr.replace("\n", "").replace("\r", "").concat(typeStr);
		objReq.put("product_name", productStr.trim().concat(typeStr));

		objReq.put("LOGIS_ID", mapReq.get("LOGIS_ID"));
		objReq.put("TANK_NO", mapReq.get("TANK_NO"));
		objReq.put("PO_DATE", mapReq.get("PO_DATE"));
		objReq.put("status", mapReq.get("status"));
		objReq.put("STRPO_DATE", mapReq.get("STRPO_DATE"));
		objReq.put("METER_NO", mapReq.get("METER_NO"));
		objReq.put("RANDOM_METER_ID", mapReq.get("RANDOM_METER_ID"));
		if ("00003".equals(mapReq.get("SAMPLE_TYPE"))) {
			objReq.put("SAMPLE_POINT_DESC", mapReq.get("METER_NO") == null ? "" : (String) mapReq.get("METER_NO"));
			objReq.put("RETURNR_DESC", mapReq.get("RETURNR_DESC") == null ? "" : (String) mapReq.get("RETURNR_DESC"));
		} else {
			objReq.put("SAMPLE_POINT_DESC",
					mapReq.get("SAMPLE_POINT_DESC") == null ? "" : (String) mapReq.get("SAMPLE_POINT_DESC"));
			objReq.put("RETURNR_DESC", mapReq.get("RETURNR_DESC") == null ? "" : (String) mapReq.get("RETURNR_DESC"));
		}

		return objReq;
	}

	public JasperPrint getReportTrans(Map<String, Object> objReq) throws Exception {
		JasperPrint jasperPrint = null;
		BufferedImage image = null;

		Map parameters = new HashMap();
		List<RandomOil> lstObj = new ArrayList();

		List list = (List) objReq.get("list");
		
		System.out.println(list);
		
		for (int i = 0; i < list.size(); i++) {
			RandomOil model = new RandomOil();
			Map mapReq = (Map) list.get(i);
			logger.info("CAR SLOT:{}", mapReq.get("CAR_SLOT"));
			logger.info("LOGIS NAME:{}", mapReq.get("logis_name"));
			logger.info("BOAT SLOT:{}", mapReq.get("BOAT_SLOT"));

			model.setPointSaveDetail(
					mapReq.get("SAMPLE_POINT_DESC") == null ? "" : (String) mapReq.get("SAMPLE_POINT_DESC"));
			model.setcauseReturn(mapReq.get("RETURNR_DESC") == null ? "" : (String) mapReq.get("RETURNR_DESC"));
			model.setLabCode_No(mapReq.get("LAB_CODE") == null ? "" : (String) mapReq.get("LAB_CODE"));
			model.setPoNo(mapReq.get("PO_NO") == null ? "" : (String) mapReq.get("PO_NO"));
			model.setPlantname(mapReq.get("plant_name") == null ? "" : (String) mapReq.get("plant_name"));
			model.setPlantid(mapReq.get("PLANT_ID") == null ? "" : (String) mapReq.get("PLANT_ID"));
			model.setProductOil(mapReq.get("product_name") == null ? "" : (String) mapReq.get("product_name"));
			model.setSourceId(mapReq.get("source_name") == null ? "" : (String) mapReq.get("source_name"));
			model.setTankNo(mapReq.get("TANK_NO") == null ? "" : (String) mapReq.get("TANK_NO"));
			model.setSampleType(
					mapReq.get("SAMPLE_LEVEL_DESC") == null ? "" : (String) mapReq.get("SAMPLE_LEVEL_DESC"));
			model.setBoatName(mapReq.get("BOAT_NAME") == null ? "" : (String) mapReq.get("BOAT_NAME"));
			model.setCarNo(mapReq.get("CAR_NO") == null ? "" : (String) mapReq.get("CAR_NO"));
			model.setSampleDate(mapReq.get("STR_SAMPLE_DATE") == null ? "" : (String) mapReq.get("STR_SAMPLE_DATE"));
			model.setCreateBy(mapReq.get("SAMPLE_STAFF_NAME") == null ? "" : (String) mapReq.get("SAMPLE_STAFF_NAME"));
			model.setExpireDate(
					mapReq.get("STR_SAMPLE_EXPIRE_DATE") == null ? "" : (String) mapReq.get("STR_SAMPLE_EXPIRE_DATE"));
			model.setCarSlot(mapReq.get("CAR_SLOT") == null ? "" : "" + (String) mapReq.get("CAR_SLOT"));
			model.setBoatSlot(mapReq.get("BOAT_SLOT") == null ? "" : "" + (String) mapReq.get("BOAT_SLOT"));
			model.setLogisticName(mapReq.get("logis_name") == null ? "" : "" + (String) mapReq.get("logis_name"));

			// model.setPointSaveDetail(mapReq.get("pointSaveDetail") == null ? "" : "" +
			// (String) mapReq.get("pointSaveDetail"));

			// System.out.println(mapReq.get("CAR_SLOT"));
			/*
			 * parameters.put("labCode",mapReq.get("LAB_CODE")==null?"":(String)mapReq.get(
			 * "LAB_CODE"));
			 * parameters.put("pono",mapReq.get("PO_NO")==null?"":(String)mapReq.get("PO_NO"
			 * ));
			 * parameters.put("plantname",mapReq.get("plant_name")==null?"":(String)mapReq.
			 * get("plant_name"));
			 * parameters.put("plantid",mapReq.get("PLANT_ID")==null?"":(String)mapReq.get(
			 * "PLANT_ID"));
			 * parameters.put("product",mapReq.get("product_name")==null?"":(String)mapReq.
			 * get("product_name"));
			 * parameters.put("source",mapReq.get("source_name")==null?"":(String)mapReq.get
			 * ("source_name"));
			 * parameters.put("tankno",mapReq.get("TANK_NO")==null?"":(String)mapReq.get(
			 * "TANK_NO"));
			 * parameters.put("boatname",mapReq.get("BOAT_NAME")==null?"":(String)mapReq.get
			 * ("BOAT_NAME"));
			 * parameters.put("slotboat",mapReq.get("BOAT_SLOT")==null?"":""+(int)mapReq.get
			 * ("BOAT_SLOT"));
			 * parameters.put("carno",mapReq.get("CAR_NO")==null?"":(String)mapReq.get(
			 * "CAR_NO"));
			 * parameters.put("slotcar",mapReq.get("CAR_SLOT")==null?"":""+(int)mapReq.get(
			 * "CAR_SLOT"));
			 * parameters.put("samplelevel",(String)mapReq.get("SAMPLE_LEVEL_DESC")==null?""
			 * :(String)mapReq.get("SAMPLE_LEVEL_DESC"));
			 * parameters.put("sampledate",(String)mapReq.get("STR_SAMPLE_DATE")==null?"":(
			 * String)mapReq.get("STR_SAMPLE_DATE"));
			 * parameters.put("staffname",(String)mapReq.get("SAMPLE_STAFF_NAME")==null?"":(
			 * String)mapReq.get("SAMPLE_STAFF_NAME"));
			 * parameters.put("sampleexpiredate",mapReq.get("STR_SAMPLE_EXPIRE_DATE")==null?
			 * "":(String)mapReq.get("STR_SAMPLE_EXPIRE_DATE"));
			 * parameters.put("barcode",mapReq.get("LAB_CODE")==null?"":(String)mapReq.get(
			 * "LAB_CODE"));
			 * parameters.put("qrcode",mapReq.get("LAB_CODE")==null?"":(String)mapReq.get(
			 * "LAB_CODE"));
			 */
			lstObj.add(model);

			System.out.println("Model = " + model);
			System.out.println("List = " + lstObj);
		}
		jasperPrint = ReportUtils.exportReport("printLabel", parameters, new JRBeanCollectionDataSource(lstObj));

		// System.out.println(jasperPrint);

		return jasperPrint;
	}

	@RequestMapping("manageReviseRequestNo")
	public ModelAndView manageReviseRequestNo(HttpServletRequest req, Model model, HttpSession session)
			throws Exception {
		// System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		MemberObj memberObj = CGlobal.getC_UserInfo(session);
		// userService.getUser("xx");
		RandomOil objReq = new RandomOil();
		objReq.setNameStore(memberObj.getPlantId());

		// Map<String, Object> result =
		// randomService.getNameStoreSetupRandomOil(objReq);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("PLANT_ID", memberObj.getPlantId());
		return new ModelAndView("manageReviseRequestNo", "Model", result);

	}

	@RequestMapping("redirectRequestNoDetail")
	public ModelAndView manageAnalysisOilDetail(HttpServletRequest req) throws Exception {
		// System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

		// userService.getUser("xx");
		// RandomOil objReq =new RandomOil();
		// objReq.setNameStore("60");

		// List<Map<String, Object>> resultList =
		// randomService.groupNameStoreRandomOil(objReq);

		return new ModelAndView("redirectRequestNoDetail");

	}

	@RequestMapping(value = "randomOilRequestNoDetail", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> randomOilRequestNoDetail(@RequestBody RandomOil objReq,
			HttpServletRequest req, HttpSession session) throws Exception {
		Map<String, Object> obj = new HashMap<String, Object>();
		try {

			System.out.println("NameStore==>" + objReq.getNameStore());
			obj = randomService.inquiryRequestAnalysisOilDetail(objReq);
			MemberObj memberObj = CGlobal.getC_UserInfo(session);
			obj.put("success", "1");
			obj.put("user", memberObj.getNamempt());
			obj.put("userId", memberObj.getCodempid());
		} catch (Exception ex) {
			obj.put("success", "0");
			obj.put("message", ex.getMessage());
			ex.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "sendRequestNoUpdateStatus", method = RequestMethod.POST)
	public @ResponseBody ResultObj sendRequestNoUpdateStatus(@RequestBody RandomOil objReq, HttpServletRequest req,
			HttpSession session) throws Exception {
		ResultObj obj = new ResultObj();
		try {

			System.out.println("NameStore==>" + objReq.getNameStore());
			obj = randomService.updateStatusSendRequest(objReq);

			// obj.put("success", "1") ;
		} catch (Exception ex) {
			obj.setSuccess(0);
			obj.setMessage(ex.getMessage());
			ex.printStackTrace();
		}

		return obj;
	}

}
