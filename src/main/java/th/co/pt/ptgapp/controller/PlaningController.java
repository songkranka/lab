package th.co.pt.ptgapp.controller;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import th.co.pt.ptgapp.config.MSGLabPropertiesServiceImpl;
import th.co.pt.ptgapp.config.PtgPropertiesServiceImpl;
import th.co.pt.ptgapp.controller.bean.ActionPlanBranch;
import th.co.pt.ptgapp.controller.bean.MbStationMaster;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.ResultObj;
import th.co.pt.ptgapp.service.PlaningService;
import th.co.pt.ptgapp.utils.CGlobal;
import th.co.pt.ptgapp.utils.FileUploadUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PlaningController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PlaningService planingService;

    @Autowired
    private PtgPropertiesServiceImpl PtgPropertiesServiceImpl;

    @Autowired
    private MSGLabPropertiesServiceImpl msgLabPropertiesService;

    @Autowired
    ServletContext context;

    @RequestMapping(value = "/planingdetail", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> planingdetail(@RequestBody(required = false) ActionPlanBranch objReq, HttpServletRequest req, HttpSession session) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if (objReq == null) {
                objReq = new ActionPlanBranch();

            }
            // objReq.setStatus("1"); //'waiting sync'
            objReq.setComplete_flg("N"); // cretiria completeFlag is null
            System.out.println("planingdetail==>");
            List<Map<String, Object>> listObj = planingService.inquiryActionPlanBranch(objReq);
            List<Map<String, Object>> listLtrSpec = planingService.inquiryLTRSpec(objReq);
            List<Map<String, Object>> listLabScoreSpec = planingService.inquiryLabScoreSpec(objReq);
            map.put("status", "1");
            map.put("message", "");
            map.put("data_planing", listObj);
            map.put("ltrSpec", listLtrSpec);
            map.put("data_lab_score_spec", listLabScoreSpec);
            System.out.println("===============end planingdetail=========================");
        } catch (Exception ex) {
            map.put("status", "0");
            map.put("message", ex.getMessage());
            ex.printStackTrace();
        }

        return map;
    }
    
    @RequestMapping(value = "/getDataMBStationCsv", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getDataMBStationCsv() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
    	List<MbStationMaster> list = new ArrayList<MbStationMaster>();
        try {

        	String absolutePath = context.getRealPath("resources/uploads");
        	File filedel = new File(absolutePath+"/station.csv");
        	
        	if(filedel.exists()){
        		FileInputStream fis = new FileInputStream(filedel);
    			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
	        	try (BufferedReader br = new BufferedReader(isr)) {
	        	    
	        		String line;
	
	    			int brLine = 1;
	    			
	    			logger.info("Line : " + brLine);

	    			
	        	    while ((line = br.readLine()) != null) {
	        	        if(brLine > 0){
	    					MbStationMaster master = new MbStationMaster();
	    					
	    					//String finalLine;
	    					//byte[] toByte = line.getBytes("MS874");
	    					//logger.info("get Byte = "+toByte.toString());
	    					
	    					//finalLine = new String(toByte,"UTF-8");
	    					//logger.info("final Line data = "+line);
	    					String csv[] = line.toString().trim().split("\\|");	
	    					//String csv[] = finalLine.toString().trim().split("\\|");
	
	    		            //logger.info("info after split == "+csv.toString());
	    		            //logger.info("  csv[1] == "+csv[1].trim());
	    		            //logger.info("  csv[2] == "+csv[2].trim());
	    					//logger.info("line"+csv[0]+" --- model :"+csv[45]);
	    					
	    					//Check lenght
	    					if(csv.length >= 62) {
	    						
	    						logger.info("Line : " + brLine);

		    		            master.setType(csv[1]);
		    		            master.setProductID(csv[2]);
		    		            master.setSiteCode(csv[4]);
		    		            master.setRef(csv[5]);
		    		            master.setPlace(csv[8]);
		    		            master.setPlantID(csv[9]);
		    		            master.setCostCenter(csv[10]);
		    		            master.setProfitCenter(csv[11]);
		    		            master.setCenterName(csv[12]);
		    		            master.setPart(csv[13]);
		    		            master.setAddrTumbon(csv[14]);
		    		            master.setAddrAmphur(csv[15]);
		    		            master.setAddrProvince(csv[16]);
		    		            master.setPostCode(csv[17]);
		    		            master.setAddress(csv[18]);
		    		            master.setEmail(csv[22]);
		    		            master.setMobileNo(csv[24]);
		    		            master.setPhoneNo(csv[25]);
		    		            master.setGps(csv[42]);
		    		            master.setModel(csv[46]);
		    		            master.setPlantReceive(csv[47]);
		    		            //master.setOperatingStatus(csv[47]);
		    		            //master.setTypeStation(csv[62]);
		    		            master.setTypeStation(csv[62].replaceAll(",", "")); // remove comma from typeStation field
		    		            master.setCreateBy("JobMobile");
		    		            
		    		            list.add(master);
	    					}
	    				}

	    	            brLine++;
	        	    }
	        	}
	        	
	        	
	        	filedel.delete();
        	}
        	
        	map.put("data", list);
        	map.put("status", "1");
            map.put("message", "");
        } catch (Exception ex) {
            map.put("status", "0");
            map.put("message", ex.getMessage());
            ex.printStackTrace();
        }

        return map;
    }

    
    @RequestMapping(value = "/updateDataMBStations", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> updateDataMBStations(@RequestBody MbStationMaster objReq, HttpServletRequest req, HttpSession session) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        
        try {
            logger.info("updateDataMBStations==>");
            Map<String, Object> result = planingService.updateMBStationMaster(objReq);
            map.put("success", result.get("pResult"));
            map.put("message", result.get("pMessage"));

        } catch (Exception ex) {
            map.put("success", "0");
            map.put("message", ex.getMessage());
            ex.printStackTrace();
        }
        return map;
    }

    @RequestMapping("initPlaning")
    public ModelAndView initPlaning(HttpServletRequest req, HttpSession session) throws Exception {

        return new ModelAndView("initPlaning");
    }


    @PostMapping(
            value = "/inquiryPlaning",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @RequestMapping(value = "/inquiryPlaning", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> inquiryPlaning(@RequestBody ActionPlanBranch objReq, HttpServletRequest req, HttpSession session) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            logger.info("inquiryPlaning==>");
            List<Map<String, Object>> listObj = planingService.inquiryActionPlanBranchByStatus(objReq);
            map.put("success", "1");
            map.put("message", "");
            map.put("list", listObj);

        } catch (Exception ex) {
            map.put("success", "0");
            map.put("message", ex.getMessage());
            ex.printStackTrace();
        }

        return map;
    }

    @RequestMapping(value = "/inquiryPlaningDetail", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> inquiryPlaningDetail(@RequestBody ActionPlanBranch objReq, HttpServletRequest req, HttpSession session) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        try {

            System.out.println("inquiryPlaning==>" + objReq.toString());
            List<Map<String, Object>> listObj = planingService.inquiryActionPlanBranch(objReq);
            map.put("success", "1");
            map.put("message", "");
            map.put("list", listObj);

        } catch (Exception ex) {
            map.put("success", "0");
            map.put("message", ex.getMessage());
            ex.printStackTrace();
        }

        return map;
    }

    @RequestMapping("initPlaningDetail")
    public ModelAndView manageAnalysisOilDetail(HttpServletRequest req) throws Exception {
        // System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        //userService.getUser("xx");
        //RandomOil objReq =new RandomOil();
        //objReq.setNameStore("60");

        //List<Map<String, Object>> resultList = randomService.groupNameStoreRandomOil(objReq);

        return new ModelAndView("initPlaningDetail");

    }

    @RequestMapping(value = "/inquiryMBStationMaster", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> inquiryMBStationMaster(@RequestBody ActionPlanBranch objReq, HttpServletRequest req, HttpSession session) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        try {

            System.out.println("inquiryPlaning==>");
            List<Map<String, Object>> listObj = planingService.inquiryMBStationMaster(objReq);
            map.put("success", "1");
            map.put("message", "");
            map.put("list", listObj);

        } catch (Exception ex) {
            map.put("success", "0");
            map.put("message", ex.getMessage());
            ex.printStackTrace();
        }

        return map;
    }

    @RequestMapping(value = "/insertActionPlan", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> insertActionPlan(@RequestBody ActionPlanBranch objReq, HttpServletRequest req, HttpSession session) throws Exception {
        Map<String, Object> obj = new HashMap<String, Object>();
        try {
            int i = 0;


            MemberObj memberObj = CGlobal.getC_UserInfo(session);

            System.out.println(memberObj.getCodempid());
            objReq.setCreateBy(memberObj.getCodempid());
            obj = planingService.saveActionPlan(objReq);


        } catch (Exception ex) {
            obj.put("success", 0);
            obj.put("message", (ex.getMessage().length() > 500 ? ex.getMessage().substring(0, 500) : ex.getMessage()));
            ex.printStackTrace();
        }

        return obj;
    }

    @RequestMapping(value = "/updateActionPlan", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> updateActionPlan(@RequestBody ActionPlanBranch objReq, HttpServletRequest req, HttpSession session) throws Exception {
        Map<String, Object> obj = new HashMap<String, Object>();
        try {
            int i = 0;


            MemberObj memberObj = CGlobal.getC_UserInfo(session);

            System.out.println(memberObj.getCodempid());
            objReq.setCreateBy(memberObj.getCodempid());
            obj = planingService.updateActionPlan(objReq);


        } catch (Exception ex) {
            obj.put("success", 0);
            obj.put("message", (ex.getMessage().length() > 500 ? ex.getMessage().substring(0, 500) : ex.getMessage()));
            ex.printStackTrace();
        }

        return obj;
    }

    @RequestMapping(value = "/updateStatusActionPlan", method = RequestMethod.POST)
    public @ResponseBody
    ResultObj updateStatusActionPlan(@RequestBody ActionPlanBranch objReq, HttpServletRequest req, HttpSession session) throws Exception {
        ResultObj obj = new ResultObj();
        try {
            MemberObj memberObj = CGlobal.getC_UserInfo(session);

            objReq.setCreateBy(memberObj.getCodempid());
            obj = planingService.updateStatusActionPlan(objReq);


        } catch (Exception ex) {
            obj.setSuccess(0);
            obj.setMessage(ex.getMessage());
            ex.printStackTrace();
        }

        return obj;
    }

    @RequestMapping(value = "/syncReceiveLTR", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> syncReceiveLTR(@RequestBody Map<String, Object> mapObj, HttpServletRequest req, HttpSession session) throws Exception {
        Map<String, Object> obj = new HashMap<String, Object>();
        try {
            int i = 0;

            System.out.println("===start syncReceiveLTR===");
            //MemberObj  memberObj = CGlobal.getC_UserInfo(session);

            //System.out.println(memberObj.getCodempid());
            //objReq.setCreateBy(memberObj.getCodempid());
            obj = planingService.syncReceiveLTR(mapObj);
            System.out.println("===end syncReceiveLTR===");

        } catch (Exception ex) {
            obj.put("success", 0);
            obj.put("message", (ex.getMessage().length() > 500 ? ex.getMessage().substring(0, 500) : ex.getMessage()));
            ex.printStackTrace();
        }

        return obj;


    }

    @RequestMapping(value = "/syncReceiveUpdateStatus", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> syncReceiveUpdateStatus(@RequestBody Map<String, Object> mapObj, HttpServletRequest req, HttpSession session) throws Exception {
        Map<String, Object> obj = new HashMap<String, Object>();
        try {
            int i = 0;

            System.out.println("===start syncReceiveLTR===");
            //MemberObj  memberObj = CGlobal.getC_UserInfo(session);

            //System.out.println(memberObj.getCodempid());
            //objReq.setCreateBy(memberObj.getCodempid());
            obj = planingService.syncReceiveUpdateStatus(mapObj);
            System.out.println("===end syncReceiveLTR===");

        } catch (Exception ex) {
            obj.put("success", 0);
            obj.put("message", (ex.getMessage().length() > 500 ? ex.getMessage().substring(0, 500) : ex.getMessage()));
            ex.printStackTrace();
        }

        return obj;


    }

    @RequestMapping(value = "/uploadimages_signature", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> uploadimgsignature(@RequestParam("name") String nameFiles, @RequestParam("img") MultipartFile dataFiles, HttpServletRequest req, HttpSession session) throws Exception {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("success", 1);
        obj.put("message", "SUCCESS");

        System.out.println("===Start upload===");

        String getPatch = context.getRealPath("assets/imgsignature/");

        byte[] bytes = dataFiles.getBytes();
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(getPatch + dataFiles.getOriginalFilename())));
        stream.write(bytes);
        stream.close();

        System.out.println("===End upload===");

        return obj;
    }

}