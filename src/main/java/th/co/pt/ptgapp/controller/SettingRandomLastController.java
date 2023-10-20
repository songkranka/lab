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


import th.co.pt.ptgapp.controller.bean.ModelStation;
import th.co.pt.ptgapp.controller.bean.SettingRandomLastObj;
import th.co.pt.ptgapp.service.SettingRandomLast;

@Controller
public class SettingRandomLastController {
	
	@Autowired
	private SettingRandomLast settingrandomlast;
	
	
	@RequestMapping("settingRandomLast")
	public ModelAndView settingRandomLast(HttpServletRequest req,HttpSession session)throws  Exception{
		
		return new ModelAndView("settingRandomLast");
		
	}
	
	@RequestMapping(value="/inquirySettingRandomLast",method=RequestMethod.POST)
	 public @ResponseBody   Map<String, Object> inquirySettingRandomLast(@RequestBody SettingRandomLastObj objReq,HttpServletRequest req,HttpSession session)throws  Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			List<Map<String,Object>> list = settingrandomlast.inquirySettingRandomLast(objReq);
			map.put("success","1");
			map.put("message", "");
			map.put("list",list);
			
		}catch (Exception e) {
			map.put("success","0");
			map.put("message", e.getMessage());
		}
		
		
		return map;
	}
	
	@RequestMapping(value="/insertSettingRandomLast",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> insertSettingRandomLast(@RequestBody SettingRandomLastObj objReq,HttpServletRequest req,HttpSession session)throws  Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			String list = settingrandomlast.insertSettingRandomLast(objReq);
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
	
	@RequestMapping(value="/deleteSettingRandomLast",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> deleteSettingRandomLast(@RequestBody SettingRandomLastObj objReq,HttpServletRequest req,HttpSession session)throws  Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			String list = settingrandomlast.deleteSettingRandomLast(objReq);
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
	
	@RequestMapping(value="/updateSettingRandomLast",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> updateSettingRandomLast(@RequestBody SettingRandomLastObj objReq,HttpServletRequest req,HttpSession session)throws  Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			String list = settingrandomlast.updateSettingRandomLast(objReq);
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
	
}