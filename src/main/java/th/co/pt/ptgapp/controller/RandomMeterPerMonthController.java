package th.co.pt.ptgapp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.classic.spi.LoggingEvent;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomMeter;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.RandomPlantMeterEntity;
import th.co.pt.ptgapp.service.RandomMeterSetupService;
import th.co.pt.ptgapp.service.UtilService;
import th.co.pt.ptgapp.utils.CGlobal;
import th.co.pt.ptgapp.utils.CalendarUtils;

@Controller
public class RandomMeterPerMonthController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RandomMeterSetupService meterService;
	
	@RequestMapping("randomMeterPerMonth")
	public ModelAndView randomMeterPerMonth(HttpServletRequest request, HttpSession session ,Model model) throws Exception {
		
		ModelAndView view = new ModelAndView("randomMeterPerMonth");
		try {
			MemberObj  memberObj = CGlobal.getC_UserInfo(session);
			RandomOil objReq =new RandomOil();
	    	objReq.setNameStore(memberObj.getPlantId());
	
	    	Map<String, Object> result = new HashMap<String, Object>();
	    	result.put("PLANT_ID", memberObj.getPlantId());

	    	view.addObject("PLANT_ID", memberObj.getPlantId());
	    	view.addObject("USER_LOGIN", memberObj.getCodempid().toString());
	    	    	
	    	//logger.info(""+memberObj.toString());
		} catch(Exception e) {
			logger.error("Error exception :",e);
			logger.error("Session is EXPIRE");
		}
		return view;
		
	}
	@RequestMapping(value = "/initCalendarMeter", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object>initCalendarMeter() {
		Map<String,Object>  result  =  new HashMap<String, Object>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		String TargetDate = sdf.format(new Date());
		String[] splitDate = TargetDate.split("/");
		
		List<Map<String, Object>> listMonth = generateMonthCalendar(TargetDate);
		
		result.put("monthCalendar", listMonth);
		result.put("monthName", CalendarUtils.convertToMonthName(Integer.parseInt(splitDate[1])));
		result.put("monthNo", splitDate[1]);
		result.put("Year", splitDate[2]);
		result.put("totalWeek", ((String[][]) listMonth.get(0).get("DAT")).length);
		result.put("defaultPlant", null);
		
		return result;
	}
	@RequestMapping(value = "/selectCalendarMeter", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object>selectCalendarMeter(HttpServletRequest request, HttpSession session, @RequestBody RandomMeter obj) {
		
		Map<String,Object>  result  =  new HashMap<String, Object>();
		String TargetDate = "01/"+obj.getTargetMonth()+"/"+obj.getTargetYear();
		
		logger.info("TargetDate = "+TargetDate);
		
		List<Map<String, Object>> listMonth = generateMonthCalendar(TargetDate);
				
		result.put("monthCalendar", listMonth);
		result.put("monthName", CalendarUtils.convertToMonthName(Integer.parseInt(obj.getTargetMonth())));
		result.put("monthNo", obj.getTargetMonth());
		result.put("Year", obj.getTargetYear());
		result.put("totalWeek", ((String[][]) listMonth.get(0).get("DAT")).length);
		result.put("defaultPlant", null);
		
		return result;
	}
	private List<Map<String, Object>> generateMonthCalendar(String DateOfMonth){
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf ; 
		try {
			sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date convertedDate = sdf.parse(DateOfMonth);
			
			calendar.setTime(convertedDate); 
			sdf = new SimpleDateFormat("dd");

			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			Date lastDayOfMonth = calendar.getTime();
			
			int total_day = Integer.parseInt(sdf.format(lastDayOfMonth));
			int total_week = calendar.get(Calendar.WEEK_OF_MONTH)+1;
			
			String[][] arrMonth = new String[total_week][7];
			arrMonth[0] = new String[]{"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};

			sdf = new SimpleDateFormat("dd/MM/yyyy");
			for( int runDay = 1; runDay <= total_day; runDay++ ) {
				String IncDate = String.valueOf(runDay)+"/"+String.valueOf((calendar.get(Calendar.MONTH)+1))+"/"+String.valueOf(calendar.get(Calendar.YEAR));
				calendar.setTime(sdf.parse(IncDate));
				
				int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
				int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)-1;

				arrMonth[weekOfMonth][dayOfWeek] = String.valueOf(runDay);
			}
			
			Map<String,Object> resObj = new HashMap<String,Object>();
			resObj.put("DAT", arrMonth);
			result.add(resObj);

			logger.info("  ");
		} catch (ParseException e) {
			logger.error("ParseException ",e);
		} catch (Exception e) {
			logger.error("Exception ",e);
		}
		return result;
	}

	@RequestMapping(value = "/initlistMonth", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object>initlistMonth(HttpServletRequest request, HttpSession session) {
		Map<String,Object>  result  =  new HashMap<String, Object>();
		List<Map<String, Object>> listYear = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> listMonth = new ArrayList<Map<String, Object>>();
		for(int yr = 0 ; yr < 100; yr ++) {
			Map<String,Object>  yearObj  =  new HashMap<String, Object>();
			int newYearConfig = 2017+yr;
			yearObj.put("display", newYearConfig);
			yearObj.put("value", newYearConfig);
			listYear.add(yearObj);
		}
		
		for ( int mon = 0 ; mon < 12 ; mon++ ) {
			int cMonth = mon+1;
			Map<String,Object>  monthObj  =  new HashMap<String, Object>();
			monthObj.put("display", CalendarUtils.convertToMonthName(cMonth));
			monthObj.put("value", cMonth);			
			listMonth.add(monthObj);
		}
		result.put("listYear", listYear);
		result.put("listMonth", listMonth);
		
		return result;
	}
	@RequestMapping(value = "/getMeterPlant", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> getMeterPlant(@RequestBody RandomMeter entity, HttpServletRequest request,HttpSession session) {
		Map<String,Object>  result  =  new HashMap<String, Object>();
		try {
			
			logger.info("List plant id ("+entity.getListPlant()+")");
			entity.setPlantId(entity.getListPlant());
			entity.setDefaultPlant(entity.getListPlant());
			logger.info("get plant id ("+entity.getPlantId()+")");
			logger.info("get def plant id ("+entity.getDefaultPlant()+")");
			List<Map<String, Object>> listMeter = meterService.fetchMeterForPlant(entity);
			result.put("resultMeter", listMeter) ;
		} catch (Exception e) {
			logger.error("Error get meter plant : ", e);
		}
		return result;
	}
	@RequestMapping(value = "/saveRandomMeter", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> saveRandomMeter(@RequestBody List<RandomPlantMeterEntity> listEntity, HttpServletRequest request,HttpSession session) {
		Map<String,Object>  result  =  new HashMap<String, Object>();
		try{
			MemberObj  memberObj = CGlobal.getC_UserInfo(session);
			String UserCodeId = memberObj.getCodempid();
			logger.info("----  Start to Save Random Meter Plant  ----");
			logger.info("size Of Param :: "+listEntity.size());
			
			
			
			//for (RandomPlantMeterEntity entity : listEntity) {
			//	logger.info("Print En : "+entity.toString());
			//}
			//logger.info("get param == "+listEntity.toString());
			result = meterService.saveRandomMeter(listEntity);
			logger.info("pResult == "+(String)result.get("pResult"));
			logger.info("pMessage == "+(String)result.get("pMessage"));
			
		} catch (Exception e) {
			result.put("pResult", "0");
			result.put("pMessage", "Controller Exception '"+e.getMessage()+"'");
			logger.error("Error Save Random Meter Plant : ", e);
		}
		return result;
	}
	
	@RequestMapping(value = "/viewRandomMeter", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> viewRandomMeter(@RequestBody RandomPlantMeterEntity entity, HttpServletRequest request,HttpSession session) {
		Map<String,Object>  result  =  new HashMap<String, Object>();
		
		try {
			logger.info("get history random meter");
			
			List<Map<String, Object>> list = meterService.fetchRandomMeter(entity);
			result.put("resultList", list) ;
			
		} catch (Exception e) {
			result.put("pResult", "0");
			result.put("pMessage", "Controller Exception '"+e.getMessage()+"'");
			logger.error("Error Save Random Meter Plant : ", e);
		}
		
		return result;
	}
}
