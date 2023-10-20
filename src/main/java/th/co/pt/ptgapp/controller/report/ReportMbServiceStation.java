package th.co.pt.ptgapp.controller.report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import th.co.pt.ptgapp.controller.bean.ReportInfoEntity;
import th.co.pt.ptgapp.service.UtilService;
import th.co.pt.ptgapp.service.report.ReportService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReportMbServiceStation {


	@Autowired
	private UtilService utilService;
	@Autowired
	private ReportService reportService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
//	@RequestMapping("reportMobileSummaryServiceStation")
//	public String MainPage(Model model) throws Exception {
//			try {
//				ReportInfoEntity entity = new ReportInfoEntity();
//				entity.setReportNo("M0001");
//				Map<String, Object> rptInfo = reportService.getReportInfo(entity);
//				model.addAttribute("reportCategory", rptInfo.get("REPORT_CATEGORY"));
//				model.addAttribute("reportID", rptInfo.get("REPORT_ID"));
//				model.addAttribute("reportNo", rptInfo.get("REPORT_NO"));
//				model.addAttribute("reportName", rptInfo.get("REPORT_NAME"));
//			} catch(Exception e) {
//				logger.error("Error exception :",e);
//				logger.error("Session is EXPIRE");
//			}
//			return "summaryMobile";
//	 }



	@RequestMapping("reportMobileSummaryServiceStation")
	public ModelAndView MainPage(HttpServletRequest request, HttpServletResponse response, HttpSession session , Model model) throws Exception {
		ModelAndView view = new ModelAndView("reportMobileSummaryServiceStation");
		try {
			Map<String, Object> reportInfo = new HashMap<String, Object>();
			ReportInfoEntity entity = new ReportInfoEntity();
			entity.setReportNo("M0001");
			Map<String, Object> rptInfo = reportService.getReportInfo(entity);
			reportInfo.put("reportCategory", rptInfo.get("REPORT_CATEGORY"));
			reportInfo.put("reportID", rptInfo.get("REPORT_ID"));
			reportInfo.put("reportNo", rptInfo.get("REPORT_NO"));
			reportInfo.put("reportName", rptInfo.get("REPORT_NAME"));
			view.addObject("reportInfo", reportInfo);
		} catch(Exception e) {
			logger.error("Error exception :",e);
			logger.error("Session is EXPIRE");
		}
		return view;
	}
	@RequestMapping("reportMobileSummaryServiceStationExcel")
	public ModelAndView MainPageExcel(HttpServletRequest request, HttpServletResponse response, HttpSession session , Model model) throws Exception {
		ModelAndView view = new ModelAndView("reportMobileSummaryServiceStationExcel");
		return view;
	}
	
	 @RequestMapping(value = "rpt-getDropdownTrip", method = RequestMethod.POST)
	    public @ResponseBody  Map<String,Object>  getDropdownTrip( HttpServletRequest req,HttpSession session )throws  Exception{
	    	 Map<String,Object>  obj  =  new HashMap<String, Object>();
	    	try{
	    		List<Map<String,Object>> final_res = new ArrayList<Map<String,Object>>();
	    		List<Map<String,Object>> ddl = utilService.getDropdownTrip();
	    		for(Map<String,Object> i : ddl){
	    			Map<String,Object> newMap = new HashMap<String,Object>();
	    			newMap.put("CTID", i.get("TID"));
	    			newMap.put("CTNAME",i.get("TID") + " - " + i.get("TNAME"));//TNAME
	    			final_res.add(newMap);
	    			
	    		}
	    		
	            obj.put("rptddl", final_res);
	    	}catch (Exception ex){
	    		ex.printStackTrace();
	    	}
	    	    	
	        return obj;
	}


}
