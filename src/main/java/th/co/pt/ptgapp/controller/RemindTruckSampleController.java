package th.co.pt.ptgapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.RandomPlantMeterEntity;
import th.co.pt.ptgapp.service.RandomMeterSetupService;
import th.co.pt.ptgapp.utils.CGlobal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RemindTruckSampleController {

	@Autowired
	private RandomMeterSetupService meterService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("remindingTruckSample")
	public ModelAndView remindingTruckSample(HttpServletRequest request, HttpSession session ,Model model) throws Exception{
		ModelAndView view = new ModelAndView("remindingTruckSample");
		try {
			MemberObj  memberObj = CGlobal.getC_UserInfo(session);
			RandomOil objReq = new RandomOil();
	    	objReq.setNameStore(memberObj.getPlantId());
		} catch(Exception e) {
			logger.error("Error exception :",e);
			logger.error("Session is EXPIRE");
		}
		return view;
	}
	
	@RequestMapping(value = "/getListViewRemindJob", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> getListViewRemindJob(HttpServletRequest request,HttpSession session) {
		Map<String,Object>  result  =  new HashMap<String, Object>();
		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");

		RandomPlantMeterEntity entity = new RandomPlantMeterEntity();
		entity.setPlantId(memberObj.getPlantId());
		entity.setCreateBy(memberObj.getCodempid());
		entity.setWorkDtm(df.format(date).toString());
		entity.setWorkMonth(df.format(date).toString().substring(0, 6));
		
		//logger.info("USER ID = "+memberObj.getNameth());
		logger.info("Now Date = "+df.format(date).toString());
		logger.info("Now Month = "+df.format(date).toString().substring(0, 6));
		logger.info("CODEMP ID = "+memberObj.getCodempid());
		logger.info("PLANT ID = "+memberObj.getPlantId());
		
		try {
			List<Map<String, Object>> list = meterService.fetchRandomMeter(entity);
			result.put("resultList", list) ;
		} catch (Exception e) {
			result.put("pResult", "0");
			result.put("pMessage", "RemindTruckSample Controller Exception '"+e.getMessage()+"'");
			
			logger.error("Error Get List View Reminding Job Plant : ", e);
		}
		return result;
	}
}
