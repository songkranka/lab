package th.co.pt.ptgapp.controller;

import java.sql.Types;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import th.co.pt.ptgapp.controller.bean.SettingAssignObj;
import th.co.pt.ptgapp.service.SettingAssignment;


@Controller
public class SettingAssignmentController {
	
	@Autowired
	private SettingAssignment settingassign;
	@RequestMapping("/settingAssignment")
	public ModelAndView settingAssign(HttpServletRequest req,HttpSession session)throws  Exception{
		return new ModelAndView("settingAssignment");	
	}
	@RequestMapping(value="/updateSettingAssign",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> updateSettingAssign(@RequestBody SettingAssignObj objReq,HttpServletRequest req,HttpSession session)throws  Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		//System.out.println("ID = "+objReq.getASM_id());
		try{
			String list = settingassign.updateSettingAssign(objReq);
			if(list.equals("1")){
				//True
				map.put("success","1");
				
			}else{
				//false
				map.put("success","0");
			}
		}catch (Exception e) {
			//System.out.println("Error");
			map.put("success","0");
			map.put("message", e.getMessage());
		}
		
		return map;
	}
	@RequestMapping(value="/getDropdownSettingAssign",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getDropdown(@RequestBody SettingAssignObj objReq,HttpServletRequest req,HttpSession session)throws  Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			List<Map<String,Object>> list = settingassign.getDropdownSettingAssign(objReq);
			//System.out.println(list);
			map.put("success","1");
			map.put("message", "");
			map.put("list",list);
			
		}catch (Exception e) {
			map.put("success","0");
			map.put("message", e.getMessage());
		}	
		return map;
	}
}
