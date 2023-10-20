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
import th.co.pt.ptgapp.controller.bean.SettingRandomSortingObj;
import th.co.pt.ptgapp.service.SettingRandomSorting;

@Controller
public class SettingRandomSortingController {
	
	@Autowired
	private SettingRandomSorting settingRandomSorting;
	
	
	@RequestMapping("settingRandomSorting")
	public ModelAndView settingRandomLast(HttpServletRequest req,HttpSession session)throws  Exception{
		
		return new ModelAndView("settingRandomSorting");
		
	}
	
	@RequestMapping(value="/inquirySettingRandomSorting",method=RequestMethod.POST)
	 public @ResponseBody   Map<String, Object> inquirySettingRandomSorting(@RequestBody SettingRandomSortingObj objReq,HttpServletRequest req,HttpSession session)throws  Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			List<Map<String,Object>> list = settingRandomSorting.inquirySettingRandomSorting(objReq);
			map.put("success","1");
			map.put("message", "");
			map.put("list",list);
			
		}catch (Exception e) {
			map.put("success","0");
			map.put("message", e.getMessage());
		}
		
		
		return map;
	}
	
	@RequestMapping(value="/insertSettingRandomSorting",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> insertSettingRandomSorting(@RequestBody SettingRandomSortingObj objReq,HttpServletRequest req,HttpSession session)throws  Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			String list = settingRandomSorting.insertSettingRandomSorting(objReq);
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
	
	@RequestMapping(value="/deleteSettingRandomSorting",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> deleteSettingRandomSorting(@RequestBody SettingRandomSortingObj objReq,HttpServletRequest req,HttpSession session)throws  Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			String list = settingRandomSorting.deleteSettingRandomSorting(objReq);
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
	
	@RequestMapping(value="/updateSettingRandomSorting",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> updateSettingRandomSorting(@RequestBody SettingRandomSortingObj objReq,HttpServletRequest req,HttpSession session)throws  Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		try{
			String list = settingRandomSorting.updateSettingRandomSorting(objReq);
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