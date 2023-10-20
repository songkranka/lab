package th.co.pt.ptgapp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import th.co.pt.ptgapp.config.MSGLabPropertiesServiceImpl;
import th.co.pt.ptgapp.config.PtgPropertiesServiceImpl;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.ResultObj;
import th.co.pt.ptgapp.entity.report.ReportRequestNo;
import th.co.pt.ptgapp.service.RandomService;
import th.co.pt.ptgapp.utils.CGlobal;
import th.co.pt.ptgapp.utils.ReportUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RandomOilController {

	@Autowired
	private RandomService randomService;
	
    @Autowired
    private PtgPropertiesServiceImpl PtgPropertiesServiceImpl;
  
    @Autowired
    private MSGLabPropertiesServiceImpl msgLabPropertiesService;
	
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @RequestMapping("randomOil")
    public ModelAndView home_test(HttpServletRequest req, HttpSession session, Model model) throws Exception{
       // System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
       
    	MemberObj  memberObj = CGlobal.getC_UserInfo(session);
        //userService.getUser("xx");
    	RandomOil objReq =new RandomOil();
    	//objReq.setNameStore(memberObj.getPlantId());
    	//System.out.println(memberObj);
        //userService.getUser("xx");
    	//RandomOil objReq =new RandomOil();
    	List<Map<String, Object>> resultList = randomService.groupNameStoreRandomOil(objReq);
    	
    	 
        return new ModelAndView("randomOil","Model",resultList);
    }
    
    
    @RequestMapping(value = "/gotopageRandomOilDetail", method = RequestMethod.GET)
	public ModelAndView gotopageRandomOilDetail() {
    	
		return new ModelAndView("randomOilDetail");
	}
    @RequestMapping(value = "/randomOilDetail", method = RequestMethod.POST)
    public @ResponseBody  Map<String,Object>  randomOilDetail(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
    	 Map<String,Object>  obj  =  new HashMap<String, Object>();
    	try{
    		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
    		//System.out.println(memberObj.getPlantId());
    		if(objReq.getStatus().equals("01")) {
    			objReq.setNameStore(memberObj.getPlantId());
    		}
    		else {
    			//System.out.println(objReq.getNameStore());
    		}
    		//objReq.setCreateBy(memberObj.getCodempid());
    		//System.out.println("NameStore==>"+objReq.getNameStore());
            obj = randomService.inquiryRandomOilDetail(objReq);
            //System.out.println("LAB CODE = "+objReq.getLabCode());
          obj.put("user", memberObj.getNamempt()) ;
            obj.put("userId", memberObj.getCodempid()) ;
            obj.put("success", "1") ;
    	}catch (Exception ex){
    	    obj.put("success", "0") ;
    		 obj.put("message", ex.getMessage());
    		ex.printStackTrace();
    	}
    	    	
        return obj;
    }
    @RequestMapping(value = "/saveRandomOil", method = RequestMethod.POST)
    public @ResponseBody  	 Map<String,Object>   saveRandomOil(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
   	 Map<String,Object>  obj  =  new HashMap<String, Object>();
    	try{
    		int i=0 ;
    		/*while(i<100000){
    			System.out.println(i);
    			i++;
    		}*/
    		logger.info("=== Input Parameter ===");
    		logger.info(objReq.toString());
    		
    		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
    		
			//System.out.println(memberObj.getCodempid());
    		objReq.setCreateBy(memberObj.getCodempid());
            obj = randomService.saveRandomOil(objReq);
            
    	}catch (Exception ex){
    		 obj.put("success", 0);
    		 obj.put("message", (ex.getMessage().length()>500?ex.getMessage().substring(0, 500):ex.getMessage())); 
    		 ex.printStackTrace();
    	}
        return obj;
    }
    @RequestMapping(value = "/updateStatusRandomOil" , method = RequestMethod.POST)
    public @ResponseBody ResultObj  sendApprovingRandomOil(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
    	ResultObj obj = new ResultObj();
    	try{
    		MemberObj  memberObj = CGlobal.getC_UserInfo(session); 
    		objReq.setCreateBy(memberObj.getCodempid());
            obj = randomService.updateStatusRandomOil(objReq);       
            obj.setSuccess(1);
    	}catch (Exception ex){
    		 obj.setSuccess(0);
    		 obj.setMessage(ex.getMessage());
    		ex.printStackTrace();
    	}   	    	
        return obj;
    }
    @RequestMapping(value = "/updateFlgRandom" , method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateFlgRandom(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
   	 Map<String,Object>  obj  =  new HashMap<String, Object>();
    	try{
            obj = randomService.updateFlgRandom(objReq);  
            obj.put("success", 1);
    	}catch (Exception ex){
    		obj.put("success", 0);
    		ex.printStackTrace();
    	}   	    	
        return obj;
    }
    @RequestMapping(value = "/updateStatusRandomOilDTE" , method = RequestMethod.POST)
    public @ResponseBody ResultObj  updateStatusRandomOilDTE(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
    	ResultObj obj = new ResultObj();
    	try{
    		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
    		
			 
    		objReq.setCreateBy(memberObj.getCodempid());
            obj = randomService.updateStatusRandomOilDte(objReq);
            
            
    	}catch (Exception ex){
    		 obj.setSuccess(0);
    		 obj.setMessage(ex.getMessage());
    		ex.printStackTrace();
    	}
    	    	
        return obj;
    }
    @RequestMapping(value = "/updateReceiveFlgRandomOilDte" , method = RequestMethod.POST)
    public @ResponseBody ResultObj  updateReceiveFlgRandomOilDte(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
    	ResultObj obj = new ResultObj();
    	try{
    		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
    		
			 
    		objReq.setCreateBy(memberObj.getCodempid());
            obj = randomService.updateReceiveFlgRandomOilDte(objReq);
            
         
    	}catch (Exception ex){
    		 obj.setSuccess(0);
    		 obj.setMessage(ex.getMessage());
    		ex.printStackTrace();
    	}
    	    	
        return obj;
    }
    
    @RequestMapping(value="exportRequestNo/{requestno}/{status}",method = RequestMethod.GET)
 	@ResponseBody
 	public ResponseEntity<Object> exportRequestNo(HttpServletResponse httpResposne,@PathVariable String requestno,HttpSession session,@PathVariable String status){
 		JasperPrint jasperPrint = null;	
 		List<Map<String, Object>> listmap = null;
 		RandomOil objReq = null;
 		try {	
 			listmap = new ArrayList<Map<String,Object>>();
 			objReq = new RandomOil();
 			objReq.setReqNo(requestno);
 			objReq.setStatus(status);
 			MemberObj  memberObj = CGlobal.getC_UserInfo(session);
    		
    		if(objReq.getStatus().equals("01")) {
    			objReq.setNameStore(memberObj.getPlantId());
    		}
    		else {
    			//System.out.println(objReq.getNameStore());
    		}
    		jasperPrint=randomService.getDataRandomOilReport(objReq);
 			httpResposne.setContentType("application/pdf");
 			httpResposne.setHeader("Content-disposition", "inline; filename="+requestno+".pdf");
 			OutputStream out = httpResposne.getOutputStream();
 			JasperExportManager.exportReportToPdfStream(jasperPrint,out);
 		}catch (Exception e) {
			e.printStackTrace();
		}
 		return new ResponseEntity<>("",HttpStatus.OK);
 	}
    

    @RequestMapping(value = "exportAssigmentWork/{status}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object>  randomOilDetail( HttpServletResponse httpResposne,HttpSession session ,@PathVariable String status)throws  Exception{
    	 List<Map<String,Object>>  obj  =  new  ArrayList<>();
    	 RandomOil objReq =null;
    	 JasperPrint jasperPrint = null;	
    	try{
    		objReq = new RandomOil();
    		objReq.setStatus(status);
    		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
            obj = randomService.inquiryRandomOilDetailGetList(objReq);
            jasperPrint=randomService.reportAssignmentWork(obj);
            httpResposne.setContentType("application/pdf");
 			httpResposne.setHeader("Content-disposition", "inline; filename=assignment.pdf");
 			OutputStream out = httpResposne.getOutputStream();
 			JasperExportManager.exportReportToPdfStream(jasperPrint,out);

    	}catch (Exception ex){
    		ex.printStackTrace();
    	}
    	    	
    	return new ResponseEntity<>("",HttpStatus.OK);
    }
    
}
