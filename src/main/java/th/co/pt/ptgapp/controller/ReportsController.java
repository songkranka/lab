package th.co.pt.ptgapp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.maven.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import th.co.pt.ptgapp.controller.bean.ReportSetting;
import th.co.pt.ptgapp.service.ReportService;

import org.apache.commons.codec.binary.Base64;

@Controller
public class ReportsController {
	
	@Autowired
	ReportService reportservice;
	
	
	@RequestMapping(value = "ReportSum") 
	public ModelAndView reportsum(HttpServletRequest req,Model model,HttpSession session) throws Exception {
		
		ModelAndView mav = new ModelAndView("reportsum"); 
		return mav;
	}
	
	@RequestMapping(value = "inquiryYear")
	public @ResponseBody Map<String,Object> inquiryyear(HttpServletRequest req,HttpSession session){
		
		Map<String,Object> obj = new HashMap<String,Object>();
		try {
			
			obj.put("success","1") ;
			obj.put("data",reportservice.inquiryyear());
   		 	obj.put("message","Success");
			
		}catch(Exception ex){
			
			obj.put("success","0") ;
   		 	obj.put("message","Error someing! : "+ex.getMessage());
   		 	ex.printStackTrace();
			
		}
		
		return obj;
	}
	
	@RequestMapping(value = "/ReportSum/getreportsum/{pamisterReq}",method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getreportsum(@PathVariable String pamisterReq,HttpServletRequest req,HttpSession session){
		
		Map<String,Object> obj = new HashMap<String,Object>();
		ReportSetting VarireportS = new ReportSetting();
		try {

			String DecodePara = DecodeBase64(pamisterReq);
			String[] splitData = DecodePara.split(":");
			
			VarireportS.setYearWatch(splitData[0]);
			VarireportS.setMonthWatch(splitData[1]);
			
			reportservice.inqueryDataChart(VarireportS);
			
			obj.put("success","1") ;
			obj.put("data","mew");
   		 	obj.put("message","Success");
			
		}catch(Exception ex){
			
			obj.put("success","0") ;
   		 	obj.put("message","Error someing! : "+ex.getMessage());
   		 	ex.printStackTrace();
			
		}
		
		return obj;
		
	}
	
	public String DecodeBase64(String encodeStr) {
		
		byte[] decodedBytes = Base64.decodeBase64(encodeStr);
		String decodedString = new String(decodedBytes);
		return decodedString;
		
	}
	
	@RequestMapping(value = "ReportSum/reportdumpdf/{pamisterReq}",method = RequestMethod.GET) 
	public ModelAndView reportdumpdf(@PathVariable String pamisterReq,HttpServletRequest req,Model model,HttpSession session) throws Exception {
		
		String DecodePara = DecodeBase64(pamisterReq);
		String[] splitData = DecodePara.split(":");
		
		ModelAndView mav = new ModelAndView("reportSumPDF");
		mav.addObject("YearWatch",splitData[0]);
		mav.addObject("MonthWatch",splitData[1]);
		
		return mav;
	}
	
}
