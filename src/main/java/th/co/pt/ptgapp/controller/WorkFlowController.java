package th.co.pt.ptgapp.controller;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.SendMailWFObj;
import th.co.pt.ptgapp.controller.bean.UpdateHeaderObj;
import th.co.pt.ptgapp.service.SendMailService;
import th.co.pt.ptgapp.service.SendMailServiceImpl;
import th.co.pt.ptgapp.utils.CGlobal;

@Controller
public class WorkFlowController {
	@Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;
	
	@Autowired
	private SendMailServiceImpl sendMailServiceImpl;
	
	 @RequestMapping("workFlow")
	 public ModelAndView initAssignment(HttpServletRequest req, Model model) throws Exception {
	     return new ModelAndView("workFlow");
	 }
	 @RequestMapping(value = "getGroupUserTypeID", method = RequestMethod.POST)
	 public @ResponseBody Map<String,Object> queryGroupUserTypeID(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
		 Map<String,Object> result = new HashMap<String, Object>();
		 try{	
	            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
	                    .withProcedureName("getGroupUserTypeID");
	            SqlParameterSource in = new MapSqlParameterSource();
	            List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
				result.put("list", list);
	            result.put("success", "1") ;
	    	}catch (Exception ex){
	    		result.put("success", "0") ;
	    		result.put("message", ex.getMessage());
	    		ex.printStackTrace();
	    	}
		 //System.out.println(result);
		 return result;
	    	
	 }
	 @RequestMapping(value = "getUserMapping", method = RequestMethod.POST)
	 public @ResponseBody Map<String,Object> queryGroupUserMapping(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
		 Map<String,Object> result = new HashMap<String, Object>();
		 try{	
	            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
	                    .withProcedureName("getUserMapping");
	            SqlParameterSource in = new MapSqlParameterSource();
	            List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
				result.put("list", list);
	            result.put("success", "1") ;
	    	}catch (Exception ex){
	    		result.put("success", "0") ;
	    		result.put("message", ex.getMessage());
	    		ex.printStackTrace();
	    	}
		 //System.out.println(result);
		 return result;
	    	
	 }
	 @RequestMapping(value = "updateUserGroupWorkFlow", method = RequestMethod.POST)
	 public @ResponseBody Map<String,Object> updateGroupUserMapping(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
		 Map<String,Object> result = new HashMap<String, Object>();
		 MemberObj  memberObj = CGlobal.getC_UserInfo(session);
		 objReq.setCreateBy(memberObj.getCodempid());	 
		 try{	
			 	for(int i=0;i<objReq.getUserID().split(",").length;i++) {
			 		//System.out.println(objReq.getUserID().split(",")[i]+"|"+objReq.getGroupID().split(",")[i]+"|"+objReq.getSendGroupMap());
			 		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("updateUserGroupWorkFlow");
			            SqlParameterSource in = new MapSqlParameterSource()            		
			            		.addValue("createBy",objReq.getCreateBy() , Types.VARCHAR)
			            		.addValue("sendGroupMap",objReq.getSendGroupMap() , Types.VARCHAR)
			            		 .addValue("userID", objReq.getUserID().split(",")[i] , Types.VARCHAR)
			            		 .addValue("groupID", objReq.getGroupID().split(",")[i], Types.VARCHAR);
			        call.execute(in).get("#result-set-1");
			 	}
	            result.put("success", "1") ;
	    	}catch (Exception ex){
	    		result.put("success", "0") ;
	    		result.put("message", ex.getMessage());
	    		ex.printStackTrace();
	    	}
	    
		 //System.out.println(result);
		 return result;
	    	
	 }
	 @RequestMapping(value = "insertWFLTR", method = RequestMethod.POST)
	 public @ResponseBody Map<String,Object> insertWFLTR(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
		 Map<String,Object> result = new HashMap<String, Object>();
		 List<Map<String, Object>>  resultList = new ArrayList<Map<String, Object>>();
		 MemberObj  memberObj = CGlobal.getC_UserInfo(session);
		 objReq.setCreateBy(memberObj.getCodempid());	
		 String descPrdFromId="";
		 try{		
			 		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("insertWFLTR");
			            SqlParameterSource in = new MapSqlParameterSource()            		
			            	.addValue("userType",objReq.getCreateBy() , Types.VARCHAR)
			            	.addValue("ltr_code",objReq.getLtrhd() , Types.VARCHAR)
			            	.addValue("status", objReq.getStatus(), Types.VARCHAR)
			            	.addValue("comment", objReq.getComment(), Types.VARCHAR)
			            	.addValue("labCode", objReq.getLabCode(), Types.VARCHAR)
			            	.addValue("product_dese", objReq.getProduct_desc(), Types.VARCHAR)			            	
			            	.addValue("pResult", Types.VARCHAR)
			            	.addValue("product_dese_id", objReq.getProductID())
			            	.addValue("revise_id", objReq.getReviseCode())
			            	.addValue("revise_des", objReq.getReviseDes());
			            resultList = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			            System.out.println(objReq.getCreateBy());
			            System.out.println(objReq.getLtrhd());
			            System.out.println(objReq.getStatus());
			            System.out.println(objReq.getLabCode());
			            System.out.println(objReq.getProduct_desc());
			            Map<String, String> pResult = new HashMap<String, String>();
			           //pResult = sendMailServiceImpl.FormatListtoMap(resultList); 
			    	  
//						if("08".equals(pResult.get("STATUS_WF"))) {
//							 sendMailServiceImpl.SendMailWFSendGridTest();
//							 result.put("success", "1") ;
//						}else {
							 result.put("success", "1") ;
//						}
							          
	    	}catch (Exception ex){
	    		result.put("success", "0") ;
	    		result.put("message", ex.getMessage());
	    		ex.printStackTrace();
	    	}
	    
		 //System.out.println(result);
		 return result;
	    	
	 }

	 @RequestMapping(value = "testmail", method = RequestMethod.POST)
	 public @ResponseBody void testmail(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
		 MemberObj  memberObj = CGlobal.getC_UserInfo(session);
		 objReq.setCreateBy(memberObj.getCodempid());	
		 try{
			sendMailServiceImpl.SendMailWF2(session);
								          
	    	}catch (Exception ex){
	    		
	    		ex.printStackTrace();
	    	}	
	 }

	 @RequestMapping(value = "updateHeader", method = RequestMethod.POST)
	 public @ResponseBody Map<String, Object> updateHeader(@RequestBody UpdateHeaderObj objReq, HttpServletRequest req, HttpSession session) throws Exception {
	     Map<String, Object> result = new HashMap<String, Object>();
	     List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
	     MemberObj  memberObj = CGlobal.getC_UserInfo(session);
	     try {
	         // Check if labCode and sampleDate are provided and not null
	         if (objReq.getLabCode() != null && objReq.getSampleDate() != null && memberObj.getRole_id().equals("0005")) {
	             SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("updateHeader");
	             SqlParameterSource in = new MapSqlParameterSource()
	                 .addValue("carSlot", objReq.getCarSlot() != null ? objReq.getCarSlot() : null)
	                 .addValue("carNo", objReq.getCarNo() != null ? objReq.getCarNo() : null)
	                 .addValue("labCode", objReq.getLabCode())
	                 .addValue("sampleTypecDesc", objReq.getSampleTypecDesc() != null ? objReq.getSampleTypecDesc() : null)
	                 .addValue("boatName", objReq.getBoatName() != null ? objReq.getBoatName() : null)
	                 .addValue("boatSlot", objReq.getBoatSlot() != null ? objReq.getBoatSlot() : null)
	                 .addValue("shipmentNo", objReq.getShipmentNo() != null ? objReq.getShipmentNo() : null)
	                 .addValue("tankNo", objReq.getTankNo() != null ? objReq.getTankNo() : null)
	                 .addValue("sampleStaffName", objReq.getSampleStaffName() != null ? objReq.getSampleStaffName() : null)
	                 .addValue("poNo", objReq.getPoNo() != null ? objReq.getPoNo() : null)
	                 .addValue("meterNo", objReq.getMeterNo() != null ? objReq.getMeterNo() : null)
	                 .addValue("adtvLotNo", objReq.getAdtvLotNo() != null ? objReq.getAdtvLotNo() : null)
	                 .addValue("pointSave", objReq.getPointSave() != null ? objReq.getPointSave() : null)
	                 .addValue("typeSationId", objReq.getTypeSationId() != null ? objReq.getTypeSationId() : null)
	                 .addValue("returnrDesc", objReq.getReturnrDesc() != null ? objReq.getReturnrDesc() : null)
	                 .addValue("sampleLevelCode", objReq.getSampleLevelCode() != null ? objReq.getSampleLevelCode() : null)
	                 .addValue("samplePointDesc", objReq.getSamplePointDesc() != null ? objReq.getSamplePointDesc() : null)
	                 .addValue("sampleDate", objReq.getSampleDate());
	             
	             //Show all variable
	             /*for (String paramName : in.getParameterNames()) {
	            	    Object paramValue = in.getValue(paramName);
	            	    System.out.println(paramName + ": " + paramValue);
	            	}*/
	             resultList = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
	             Map<String, String> pResult = new HashMap<String, String>();

	             result.put("success", "1");
	             result.put("list", resultList);
	             System.out.println("UpdateHeader API executed successfully.");
	         } else {
	             // Handle the case where labCode or sampleDate is null
	             result.put("success", "0");
	             result.put("message", "labCode and sampleDate must have values and cannot be null.");
	         }
	     } catch (Exception ex) {
	         result.put("success", "0");
	         result.put("message", ex.getMessage());
	         ex.printStackTrace();

	         // Print an error message
	         System.err.println("Error in UpdateHeader API: " + ex.getMessage());
	     }

	     // System.out.println(result);
	     return result;
	 }


}
