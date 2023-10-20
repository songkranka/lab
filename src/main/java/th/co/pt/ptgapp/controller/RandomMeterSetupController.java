package th.co.pt.ptgapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomMeter;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.service.RandomMeterSetupService;
import th.co.pt.ptgapp.utils.CGlobal;

@Controller
public class RandomMeterSetupController {

	@Autowired
	private RandomMeterSetupService meterService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("randomMeterSetup")
	public ModelAndView randomMeterSetup(HttpServletRequest request, HttpSession session ,Model model) throws Exception {
		
		ModelAndView view = new ModelAndView("randomMeterSetup");
		try {
			MemberObj  memberObj = CGlobal.getC_UserInfo(session);
			RandomOil objReq =new RandomOil();
	    	objReq.setNameStore(memberObj.getPlantId());
	
	    	Map<String, Object> result = new HashMap<String, Object>();
	    	result.put("PLANT_ID", memberObj.getPlantId());
	    	
	    	view.addObject("PLANT_ID", memberObj.getPlantId());
		} catch(Exception e) {
			logger.error("Error exception :",e);
			logger.error("Session is EXPIRE");
		}
		return view;
    	
	}
	
	@RequestMapping(value = "/initMeterManage", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object>initMeterManage() {
		
		Map<String,Object>  result  =  new HashMap<String, Object>();
		List<Map<String, Object>> listMeter = new ArrayList<Map<String, Object>>();
		Map<String,Object>  mpUser  =  new HashMap<String, Object>();
		
		result.put("defaultPlant", mpUser);
		result.put("listMeterData", listMeter);
		//result.put("", null);
		
		return result;
	}
	
	@RequestMapping(value = "/viewMeter", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> viewMeter(@RequestBody RandomMeter entity, HttpServletRequest request,HttpSession session) {
		Map<String,Object>  result  =  new HashMap<String, Object>();
		try {
			List<Map<String, Object>> listMeter = meterService.fetchMeterForPlant(entity);
			result.put("resultMeter", listMeter) ;
		} catch (Exception e) {
			logger.error("Error view meter : ", e);
		}
		return result;
	}
	
	@RequestMapping(value = "/saveMeter", method = RequestMethod.POST) 
	public @ResponseBody Map<String,Object> saveMeter(@RequestBody RandomMeter entity, HttpServletRequest request,HttpSession session) {
		Map<String,Object>  result  =  new HashMap<String, Object>();
		try {
			MemberObj  memberObj = CGlobal.getC_UserInfo(session);
			entity.setCreateBy(memberObj.getCodempid());
			entity.setPlantId((entity.getPlantId()==null)?entity.getDefaultPlant():entity.getPlantId());
			
			result = meterService.saveMeterForPlant(entity);
			logger.info("alter save master meter");
			logger.info("pResult == "+(String)result.get("pResult"));
			logger.info("pMessage == "+(String)result.get("pMessage"));
		} catch (Exception e) {
			logger.error("Error view meter : ", e);
		}
		return result;
	}
}
