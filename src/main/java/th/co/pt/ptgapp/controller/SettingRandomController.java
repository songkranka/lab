package th.co.pt.ptgapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import th.co.pt.ptgapp.controller.bean.ActionPlanBranch;
import th.co.pt.ptgapp.controller.bean.ModelStation;
import th.co.pt.ptgapp.controller.bean.SettingRandomObj;
import th.co.pt.ptgapp.service.StationService;
import th.co.pt.ptgapp.service.SettingRandom;

@Controller
public class SettingRandomController {
	
	@Autowired
	private SettingRandom settingrandom;
	
//	@Autowired
//	private StationService stationservice;
	
	@RequestMapping("settingRandom")
	public ModelAndView settingRandom(HttpServletRequest req,HttpSession session)throws  Exception{
		
		return new ModelAndView("settingRandom");
		
	}
	
	@RequestMapping(value="/inquirySettingRandom",method=RequestMethod.POST)
	 public @ResponseBody   Map<String, Object> inquirySettingRandom(@RequestBody SettingRandomObj objReq,HttpServletRequest req,HttpSession session)throws  Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			List<Map<String,Object>> list = settingrandom.inquerySettingRandom(objReq);
			map.put("success","1");
			map.put("message", "");
			map.put("list",list);
			
		}catch (Exception e) {
			map.put("success","0");
			map.put("message", e.getMessage());
		}
		
		
		return map;
	}
	
	@RequestMapping(value="/insertSettingRandom",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> insertSettingRandom(@RequestBody SettingRandomObj objReq,HttpServletRequest req,HttpSession session)throws  Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			String list = settingrandom.insertSettingRandom(objReq);
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
	
	@RequestMapping(value="/deleteSettingRandom",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> deleteSettingRandom(@RequestBody SettingRandomObj objReq,HttpServletRequest req,HttpSession session)throws  Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			String list = settingrandom.deleteSettingRandom(objReq);
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
	
	@RequestMapping(value="/updateSettingRandom",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> updateSettingRandom(@RequestBody SettingRandomObj objReq,HttpServletRequest req,HttpSession session)throws  Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			String list = settingrandom.updateSettingRandom(objReq);
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
	
//	@RequestMapping("settingmodel")
//	public ModelAndView settingmodel(HttpServletRequest req,HttpSession session)throws  Exception{
//		
//		return new ModelAndView("SetModel");
//		
//	}
//	
//	
//	@RequestMapping(value="/update_Model",method=RequestMethod.POST)
//	public @ResponseBody Map<String,Object> update_Model(@RequestBody ModelStation objReq,HttpServletRequest req,HttpSession session)throws  Exception{
//		Map<String,Object> map = new HashMap<String,Object>();
//		
//		try{
//			
//			System.out.println("=================update_Model controller====================");
//			String list = stationservice.updateModel(objReq);
//			if(list.equals("1")){
//				//True
//				map.put("success","1");
//				map.put("message","success");
//			}else{
//				//false
//				map.put("success","0");
//				map.put("message","error-");
//			}
//			
//		}catch (Exception e) {
//			map.put("success","0");
//			map.put("message", e.getMessage());
//		}
//		
//		return map;
//	}
	
}