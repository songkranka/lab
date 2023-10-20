package th.co.pt.ptgapp.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.utils.CGlobal;

@Controller
public class RandomMeterController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("randomMeter")
	public ModelAndView randomMeter(HttpServletRequest request, HttpSession session ,Model model) throws Exception {

		ModelAndView view = new ModelAndView("randomMeter");
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
}
