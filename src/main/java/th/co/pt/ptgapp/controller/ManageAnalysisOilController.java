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
import th.co.pt.ptgapp.controller.bean.ResultObj;
import th.co.pt.ptgapp.service.RandomService;
import th.co.pt.ptgapp.utils.CGlobal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ManageAnalysisOilController {
	@Autowired
	private RandomService randomService;
	
    @Autowired
    private PtgPropertiesServiceImpl PtgPropertiesServiceImpl;
  
    @Autowired
    private MSGLabPropertiesServiceImpl msgLabPropertiesService;


    @RequestMapping("manageAnalysisOil")
    public ModelAndView home_test(HttpServletRequest req,Model model) throws Exception{
       // System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
       
        //userService.getUser("xx");
    	RandomOil objReq =new RandomOil();
    	//objReq.setNameStore("60");
    	
    	List<Map<String, Object>> resultList = randomService.groupNameStoreRandomOil(objReq);
    	   return new ModelAndView("manageAnalysisOil","Model",resultList);
   
    }
    @RequestMapping("manageAnalysisOilEdit")
    public ModelAndView manageAnalysisOilEdit(HttpServletRequest req,Model model) throws Exception{
    	   return new ModelAndView("manageAnalysisOilEdit");
   
    }
    @RequestMapping(value = "/inquiryRequestAnalysisOil", method = RequestMethod.POST)
    public @ResponseBody  Map<String,Object>  inquiryRandomOil(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
    	 Map<String,Object>  obj  =  new HashMap<String, Object>();
    	try{
    		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
    		
		 
            obj = randomService.inquiryRequestAnalysis(objReq);
            obj.put("success", "1") ;
    	}catch (Exception ex){
    	    obj.put("success", "0") ;
    		 obj.put("message", ex.getMessage());
    		ex.printStackTrace();
    	}
    	    	
        return obj;
    }
    @RequestMapping("manageAnalysisOilDetail")
    public ModelAndView manageAnalysisOilDetail(HttpServletRequest req) throws Exception{
       // System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
       
        //userService.getUser("xx");
    	//RandomOil objReq =new RandomOil();
    	//objReq.setNameStore("60");
    	
    	//List<Map<String, Object>> resultList = randomService.groupNameStoreRandomOil(objReq);
    	 
    	   return new ModelAndView("manageAnalysisOilDetail");
   
    }
    @RequestMapping(value = "/inquiryRequestAnalysisOilDetail", method = RequestMethod.POST)
    public @ResponseBody  Map<String,Object>  inquiryRequestAnalysisOilDetail(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
    	 Map<String,Object>  obj  =  new HashMap<String, Object>();
    	try{
    		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
    		
		 
            obj = randomService.inquiryRequestAnalysisOilDetail(objReq);
            
            obj.put("success", "1") ;
    	}catch (Exception ex){
    	    obj.put("success", "0") ;
    		 obj.put("message", ex.getMessage());
    		ex.printStackTrace();
    	}
    	    	
        return obj;
    }
    @RequestMapping(value = "/updateStatusSendRequest", method = RequestMethod.POST)
    public @ResponseBody  ResultObj updateStatusSendRequest(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
    	ResultObj obj = new ResultObj();
    	try{
    		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
    		objReq.setUpdateBy(memberObj.getCodempid());
		 
            obj = randomService.updateStatusSendRequest(objReq);
            
    
    	}catch (Exception ex){
    		 obj.setMessage(ex.getMessage());
    		ex.printStackTrace();
    	}
    	    	
        return obj;
    }
    
    
}