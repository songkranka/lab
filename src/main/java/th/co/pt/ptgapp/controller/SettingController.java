package th.co.pt.ptgapp.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import th.co.pt.ptgapp.controller.bean.*;

import th.co.pt.ptgapp.service.SettingItemSpecService;
import th.co.pt.ptgapp.service.StationService;
import th.co.pt.ptgapp.service.Testscore;
import th.co.pt.ptgapp.service.UtilService;
import th.co.pt.ptgapp.service.report.dto.LTRSpec;
import th.co.pt.ptgapp.utils.CGlobal;
import th.co.pt.ptgapp.utils.WebUtil;

@Controller
public class SettingController {
	
	@Autowired
	private Testscore testscore;
	@Autowired
	private UtilService utilService;
	
	@Autowired
	private StationService stationservice;

	@Autowired
	private SettingItemSpecService settingItemSpecService;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("setTestScores")
	public ModelAndView setTestScores(HttpServletRequest req,HttpSession session)throws  Exception{
		
		return new ModelAndView("setTestScores");
		
	}
	
	@RequestMapping(value="/inquiryTestscore",method=RequestMethod.POST)
	 public @ResponseBody   Map<String, Object> inquiryTestscore(@RequestBody TestscoreObj objReq,HttpServletRequest req,HttpSession session)throws  Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			List<Map<String,Object>> list = testscore.inqueryListscore(objReq);
			map.put("success","1");
			map.put("message", "");
			map.put("list",list);
			
		}catch (Exception e) {
			map.put("success","0");
			map.put("message", e.getMessage());
		}
		
		
		return map;
	}
	
	@RequestMapping(value="/insertTestscore",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> insertTestscore(@RequestBody TestscoreObj objReq,HttpServletRequest req,HttpSession session)throws  Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			String list = testscore.insertTestcore(objReq);
			if(list.equals("1")){
				//True
				map.put("success","1");
			}else{
				//false
				map.put("success","0");
			}
		}catch (Exception e) {
			map.put("success","0");
			map.put("message", e.getMessage());
		}
		
		return map;
	}
	
	@RequestMapping(value="/deleteTestscore",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> deleteTestscore(@RequestBody TestscoreObj objReq,HttpServletRequest req,HttpSession session)throws  Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			String list = testscore.deleteTestcore(objReq);
			if(list.equals("1")){
				//True
				map.put("success","1");
			}else{
				//false
				map.put("success","0");
			}
		}catch (Exception e) {
			map.put("success","0");
			map.put("message", e.getMessage());
		}
		
		return map;
	}
	
	@RequestMapping(value="/updateTestscore",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> updateTestscore(@RequestBody TestscoreObj objReq,HttpServletRequest req,HttpSession session)throws  Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			String list = testscore.updateTestscore(objReq);
			if(list.equals("1")){
				//True
				map.put("success","1");
			}else{
				//false
				map.put("success","0");
			}
		}catch (Exception e) {
			map.put("success","0");
			map.put("message", e.getMessage());
		}
		
		return map;
	}
	
	@RequestMapping("settingmodel")
	public ModelAndView settingmodel(HttpServletRequest req,HttpSession session)throws  Exception{
		
		return new ModelAndView("SetModel");
		
	}
	
	
	@RequestMapping(value="/update_Model",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> update_Model(@RequestBody ModelStation objReq,HttpServletRequest req,HttpSession session)throws  Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			
			System.out.println("=================update_Model controller====================");
			String list = stationservice.updateModel(objReq);
			if(list.equals("1")){
				//True
				map.put("success","1");
				map.put("message","success");
			}else{
				//false
				map.put("success","0");
				map.put("message","error-");
			}
			
		}catch (Exception e) {
			map.put("success","0");
			map.put("message", e.getMessage());
		}
		
		return map;
	}
	
	
	
	/*@RequestMapping("settingRandom")
	public ModelAndView settingRandom(HttpServletRequest req,HttpSession session)throws  Exception{
		
		return new ModelAndView("settingRandom");
		
	}*/
	@RequestMapping("settingItemSpecs")
	public ModelAndView settingItemSpecs() throws Exception {
		return new ModelAndView("settingItemSpecsView");
	}

	@RequestMapping(value = "getItemName", method = RequestMethod.POST)
	public @ResponseBody List<Map<String,Object>> getItemName(HttpServletRequest req,HttpSession session )throws  Exception{
		Map<String,Object> result = new HashMap<String, Object>();
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		try{
			resultList = settingItemSpecService.getItemName();
			result.put("success", "1") ;
		}catch (Exception ex){
			result.put("success", "0") ;
			result.put("message", ex.getMessage());
			ex.printStackTrace();
		}
		return resultList;
	}
	@RequestMapping(value = "getMethodMaster", method = RequestMethod.POST)
	public @ResponseBody List<Map<String,Object>> getMethodMaster(HttpServletRequest req,HttpSession session )throws  Exception{
		Map<String,Object> result = new HashMap<String, Object>();
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		try{
			resultList = settingItemSpecService.getMethodMaster();
			result.put("success", "1") ;
		}catch (Exception ex){
			result.put("success", "0") ;
			result.put("message", ex.getMessage());
			ex.printStackTrace();
		}
		return resultList;
	}
	@RequestMapping(value = "getToolsMaster", method = RequestMethod.POST)
	public @ResponseBody List<Map<String,Object>> getToolsMaster(HttpServletRequest req,HttpSession session )throws  Exception{
		Map<String,Object> result = new HashMap<String, Object>();
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		try{
			resultList = settingItemSpecService.getToolsMaster();
			result.put("success", "1") ;
		}catch (Exception ex){
			result.put("success", "0") ;
			result.put("message", ex.getMessage());
			ex.printStackTrace();
		}
		return resultList;
	}
	@RequestMapping(value = "getGroup", method = RequestMethod.POST)
	public @ResponseBody List<Map<String,Object>> getGroup(HttpServletRequest req,HttpSession session )throws  Exception{
		Map<String,Object> result = new HashMap<String, Object>();
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		try{
			resultList = settingItemSpecService.getGroup();
			result.put("success", "1") ;
		}catch (Exception ex){
			result.put("success", "0") ;
			result.put("message", ex.getMessage());
			ex.printStackTrace();
		}
		return resultList;
	}


	@RequestMapping(value = "insertItemSpecAssign", method = RequestMethod.POST)
    public @ResponseBody List<Map<String,Object>> insertItemSpecAssign(@RequestBody SettingItemSpec settingItemSpec, HttpServletRequest req, HttpSession session)throws  Exception{
		List<Map<String,Object>>result = new ArrayList<>();

		try{


			result = settingItemSpecService.insertItemSpecAssign(settingItemSpec);

			return result;
		}catch (Exception ex){

			logger.error("Exception : {}",ex);
			throw new RuntimeException(ex.getMessage());
		}

	}
	
	 @RequestMapping("manageUser")
	 public ModelAndView manageUser(HttpServletRequest req, Model model) throws Exception {
	     return new ModelAndView("manageUser");
	 }
	 @RequestMapping("manageSource")
	 public ModelAndView manageSource(HttpServletRequest req, Model model) throws Exception {
	     return new ModelAndView("manageSource");
	 }
	 @RequestMapping("setltrspec")
	 public ModelAndView setltrspec(HttpServletRequest req, Model model, HttpSession session) throws Exception {
	     Map<String, Object> map = new HashMap<>(); // Initialize map

	     MemberObj memberObj = CGlobal.getC_UserInfo(session);

	     List<Map<String, Object>> userlist = utilService.getMyDetail(memberObj.getCodempid());
	     map.put("userdetail", userlist.get(0));

	     String roleId = userlist.get(0).get("ROLE_ID").toString();

	     if ("0005".equalsIgnoreCase(roleId)) {
	         // Do something with roleId
	         logger.info(roleId.toString());
	         return new ModelAndView("setltrspec", map); // Pass map to the view
	     } else {
	         return new ModelAndView("/home");
	     }
	 }

	 //@RequestMapping("setltrspecdetail")
	 @RequestMapping(value = "/setltrspecdetail", method = RequestMethod.GET)
	 public ModelAndView setltrspecdetail(HttpServletRequest req, Model model, @RequestParam(value = "productId", required = true) String paramValue, HttpSession session) throws Exception {
	     
		 LTRSpec reqModel = new LTRSpec();
		 List<Map<String, Object>>result = new ArrayList<>();
		 
		 reqModel.setProduct_id(paramValue);
		 result = settingItemSpecService.getLTRSpec(reqModel);
		 
		 model.addAttribute("ltr_spec_id", result.get(0).get("LTR_SPEC_ID"));
		 model.addAttribute("dispenser", result.get(0).get("DISPENSER"));
		 model.addAttribute("sn", result.get(0).get("SN"));
		 model.addAttribute("slot_number", result.get(0).get("SLOT_NUMBER"));
		 model.addAttribute("meter_total", result.get(0).get("METER_TOTAL"));
		 model.addAttribute("feature", result.get(0).get("FEATURE"));
		 model.addAttribute("color", result.get(0).get("COLOR"));
		 model.addAttribute("api_min", result.get(0).get("API_MIN"));
		 model.addAttribute("api_max", result.get(0).get("API_MAX"));
		 model.addAttribute("temp_min", result.get(0).get("TEMP_MIN"));
		 model.addAttribute("temp_max", result.get(0).get("TEMP_MAX"));
		 model.addAttribute("api_60_min", result.get(0).get("API_60_MIN"));
		 model.addAttribute("api_60_max", result.get(0).get("API_60_MAX"));
		 model.addAttribute("distill_min", result.get(0).get("DISTILL_MIN"));
		 model.addAttribute("distill_max", result.get(0).get("DISTILL_MAX"));
		 model.addAttribute("evaporation_10_min", result.get(0).get("EVAPORATION_10_MIN"));
		 model.addAttribute("evaporation_10_max", result.get(0).get("EVAPORATION_10_MAX"));
		 model.addAttribute("evaporation_50_min", result.get(0).get("EVAPORATION_50_MIN"));
		 model.addAttribute("evaporation_50_max", result.get(0).get("EVAPORATION_50_MAX"));
		 model.addAttribute("evaporation_90_min", result.get(0).get("EVAPORATION_90_MIN"));
		 model.addAttribute("evaporation_90_max", result.get(0).get("EVAPORATION_90_MAX"));
		 model.addAttribute("boil_min", result.get(0).get("BOIL_MIN"));
		 model.addAttribute("boil_max", result.get(0).get("BOIL_MAX"));
		 model.addAttribute("waste_min", result.get(0).get("WASTE_MIN"));
		 model.addAttribute("waste_max", result.get(0).get("WASTE_MAX"));
		 model.addAttribute("ethanol_min", result.get(0).get("ETHANOL_MIN"));
		 model.addAttribute("ethanol_max", result.get(0).get("ETHANOL_MAX"));
		 model.addAttribute("flash_point_min", result.get(0).get("FLASH_POINT_MIN"));
		 model.addAttribute("flash_point_max", result.get(0).get("FLASH_POINT_MAX"));
		 model.addAttribute("biodiesel_min", result.get(0).get("BIODIESEL_MIN"));
		 model.addAttribute("biodiesel_max", result.get(0).get("BIODIESEL_MAX"));
		 model.addAttribute("cetane_min", result.get(0).get("CETANE_MIN"));
		 model.addAttribute("cetane_max", result.get(0).get("CETANE_MAX"));
		 model.addAttribute("ron_min", result.get(0).get("RON_MIN"));
		 model.addAttribute("ron_max", result.get(0).get("RON_MAX"));
		 model.addAttribute("mon_min", result.get(0).get("MON_MIN"));
		 model.addAttribute("mon_max", result.get(0).get("MON_MAX"));
		 model.addAttribute("create_by", result.get(0).get("CREATE_BY"));
		 model.addAttribute("create_date", result.get(0).get("CREATE_DATE"));
		 model.addAttribute("update_by", result.get(0).get("UPDATE_BY"));
		 model.addAttribute("update_date", result.get(0).get("UPDATE_DATE"));		 
		 model.addAttribute("product_id", result.get(0).get("PRODUCT_ID"));
		 model.addAttribute("ltr_h_id", result.get(0).get("LTR_H_ID"));
		 model.addAttribute("product_name", result.get(0).get("product_name"));
		 model.addAttribute("update_by_name", result.get(0).get("NAMET"));
		 
		 return new ModelAndView("setltrspecdetail");
	 }
}