package th.co.pt.ptgapp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import th.co.pt.ptgapp.config.MSGLabPropertiesServiceImpl;
import th.co.pt.ptgapp.config.PtgPropertiesServiceImpl;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.service.RandomService;
import th.co.pt.ptgapp.utils.CGlobal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SearchLTRNoController {
	@Autowired
	private RandomService randomService;
	
    @Autowired
    private PtgPropertiesServiceImpl PtgPropertiesServiceImpl;
  
    @Autowired
    private MSGLabPropertiesServiceImpl msgLabPropertiesService;

    @RequestMapping("/initSearchLTRNo")
    public ModelAndView home_test(HttpServletRequest req,Model model) throws Exception{
       // System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
       
        //userService.getUser("xx");
    	RandomOil objReq =new RandomOil();
    	//List<Map<String, Object>> resultList = randomService.groupNameStoreRandomOil(objReq);
    	
    	 
        return new ModelAndView("initSearchLTRNo");
    }
    @RequestMapping(value = "/inquirySearchLTRNO", method = RequestMethod.POST)
    public @ResponseBody  	 Map<String,Object>   inquiryLTRNO(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
   	 Map<String,Object>  obj  =  new HashMap<String, Object>();
    	try{
    		int i=0 ;
    	 
    		
    		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
    		
			System.out.println(memberObj.getCodempid());
    		objReq.setCreateBy(memberObj.getCodempid());
    		objReq.setRole_id(memberObj.getRole_id());
    		System.out.println(memberObj.getRole_id());
            obj = randomService.inquiryLTRNO(objReq);
            
            obj.put("success", 1);
    	}catch (Exception ex){
    		 obj.put("success", 0);
    		 obj.put("message", (ex.getMessage().length()>500?ex.getMessage().substring(0, 500):ex.getMessage())); 
    		 ex.printStackTrace();
    	}
    	    	
        return obj;
    }
   
    @RequestMapping(value = "/initInquirySearchLTRNODetail")
    public ModelAndView   assignRandomLastResult()throws  Exception{
       	
    	  return new ModelAndView("initInquirySearchLTRNODetail");
    }
 
     
}
