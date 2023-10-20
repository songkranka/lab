package th.co.pt.ptgapp.controller;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.ws.WFConstant;
import th.co.pt.ptgapp.service.RandomService;
import th.co.pt.ptgapp.service.ws.lotusnotes.request.ItemRequest;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.ItemResponse;
import th.co.pt.ptgapp.utils.CGlobal;

@Controller
public class AssignmentController {
	@Autowired
	private RandomService randomService;
	
	@Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;
	
	 @RequestMapping("assignment")
	 public ModelAndView initAssignment(HttpServletRequest req, Model model) throws Exception {
	     return new ModelAndView("assignment");
	 }
	 @RequestMapping(value = "insertLTRAssignment", method = RequestMethod.POST)
	 public @ResponseBody Map<String,Object> insertLTRAssignment(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
		 Map<String,Object> result = new HashMap<String, Object>();
		 try{	
			 
			 MemberObj  memberObj = CGlobal.getC_UserInfo(session);
			 objReq.setCreateBy(memberObj.getCodempid());
			 
			 //System.out.println(objReq.getLabCode()+"|"+objReq.getCreateBy());
	            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
	                    .withProcedureName("insertLTRAssignment");
	            SqlParameterSource in = new MapSqlParameterSource()
	                    .addValue("createBy", objReq.getCreateBy(), Types.VARCHAR)
	                    .addValue("labCode", objReq.getLabCode(), Types.VARCHAR);
	            call.execute(in).get("#result-set-1");
	            result.put("success", "1") ;
	    	}catch (Exception ex){
	    		result.put("success", "0") ;
	    		result.put("message", ex.getMessage());
	    		ex.printStackTrace();
	    	}
		 //System.out.println(result);
		 return result;
	    	
	 }
	 @RequestMapping("assignmentDetail")
	 public ModelAndView initAssignmentDetail() throws Exception {
		 
	     return new ModelAndView("assignmentDetail");
	 }
	 @RequestMapping(value = "QueryAssignmentDetail", method = RequestMethod.POST)
	 public @ResponseBody Map<String,Object> QueryAssignmentDetail(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
		 Map<String,Object> result = new HashMap<String, Object>();
		 Map<String,Object> randomLastResult = new HashMap<String, Object>();
		 try{	
			 randomLastResult = randomService.inquiryRandomLastResult(objReq);
			 randomLastResult.put("success", "1") ;
	    }catch (Exception ex){
	    	randomLastResult.put("success", "0") ;
	    	randomLastResult.put("message", ex.getMessage());
	    	ex.printStackTrace();
	    	}
		 //System.out.println(randomLastResult);
		 return randomLastResult;
	    	
	 }
	 @RequestMapping(value = "querySpecLTRAssignment", method = RequestMethod.POST)
	 public @ResponseBody Map<String,Object> querySpecLTRAssignment(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
		 Map<String,Object> result = new HashMap<String, Object>();
		 try{	
	            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
	                    .withProcedureName("querySpecLTRAssignment");
	            SqlParameterSource in = new MapSqlParameterSource()
	            		.addValue("chkmenu", objReq.getChkmenu(), Types.VARCHAR)
	                    .addValue("labCode", objReq.getLabCode(), Types.VARCHAR);
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
	 @RequestMapping(value = "getDropdownUserType", method = RequestMethod.POST)
	 public @ResponseBody Map<String,Object> getDropDownUserType(HttpServletRequest req,HttpSession session )throws  Exception{
		 Map<String,Object> result = new HashMap<String, Object>();
		 try{	
	            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
	                    .withProcedureName("getDropdownUserType");
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
	 @RequestMapping(value = "getDropDownTools", method = RequestMethod.POST)
	 public @ResponseBody Map<String,Object> getDropDownTools(HttpServletRequest req,HttpSession session )throws  Exception{
		 Map<String,Object> result = new HashMap<String, Object>();
		 try{	
	            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
	                    .withProcedureName("getDropDownToolsAssignment");
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
	 @RequestMapping(value = "getDropDownMethod", method = RequestMethod.POST)
	 public @ResponseBody Map<String,Object> getDropDownMethod(HttpServletRequest req,HttpSession session )throws  Exception{
		 Map<String,Object> result = new HashMap<String, Object>();
		 try{	
	            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
	                    .withProcedureName("getDropDownMethodAssignment");
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
	 @RequestMapping(value = "saveDataAssignment", method = RequestMethod.POST)
	 public @ResponseBody Map<String,Object> SaveDataLTRAssignment(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
		 Map<String,Object> result = new HashMap<String, Object>();
		 try{	
			
			 MemberObj  memberObj = CGlobal.getC_UserInfo(session);
			 objReq.setCreateBy(memberObj.getCodempid());
			
			
			
			 System.out.println(objReq.getCreateBy());
			 System.out.println(objReq.getLabCode_No());
			 System.out.println(objReq.getUsrDataAss());
			 System.out.println(objReq.getToolsDataAss());
			 System.out.println(objReq.getMethodDataAss());
			 System.out.println(objReq.getLtrDtID());
			 
			 
			 
	         SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
	                    .withProcedureName("insertLTRLastResult");
	         SqlParameterSource in = new MapSqlParameterSource()
	                    .addValue("createBy", objReq.getCreateBy(), Types.VARCHAR)
	                    .addValue("labCode", objReq.getLabCode_No(), Types.VARCHAR)
	                    .addValue("userGroupID", objReq.getUsrDataAss(), Types.VARCHAR)
	                    .addValue("toolsID", objReq.getToolsDataAss(), Types.VARCHAR)
	                    .addValue("ltrDtID", objReq.getLtrDtID(), Types.VARCHAR)
	                    .addValue("methodID", objReq.getMethodDataAss(), Types.VARCHAR);
	         call.execute(in).get("#result-set-1");
	         result.put("success", "1") ;
	    	}catch (Exception ex){
	    		result.put("success", "0") ;
	    		result.put("message", ex.getMessage());
	    		ex.printStackTrace();
	    	}
		 //System.out.println(result);
		 return result;
	    	
	 }
	 
	 @RequestMapping(value = "findCurrentSetup", method = RequestMethod.POST)
	 public @ResponseBody List<Map<String,Object>> findCurrentSetup(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
		 String reportBy ="";
			List<Map<String,Object>>resultList =new ArrayList<>();
			try {
				StringBuilder sql = new StringBuilder();

				sql.append(" select PRODUCT_ID,SAMPLE_TYPE_CODE,ITEM_ID,aism.METHOD_ID,aism.TOOL_ID from ASS_ITEM_SPEC_MP aism ");
				sql.append(" where 1=1 ");
				sql.append(" and  aism.PRODUCT_ID ='"+objReq.getProductID()+"' and aism.SAMPLE_TYPE_CODE ='"+objReq.getSampleType()+"'  ");

				resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());


			}catch(Exception e) {
				e.printStackTrace();
			}
			return resultList;
	    	
	 }
	 @RequestMapping(value = "saveDataSettingAssignment", method = RequestMethod.POST)
	 public @ResponseBody Map<String,Object> SaveDataSettingAssignment(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
		 Map<String,Object> result = new HashMap<String, Object>();
		 try{	
			
			 MemberObj  memberObj = CGlobal.getC_UserInfo(session);
			 objReq.setCreateBy(memberObj.getCodempid());
			
			
			
			 System.out.println("UPDATE BY :"+objReq.getCreateBy());
			 System.out.println("SAMPLE TYPE :"+objReq.getSampleType());
			 System.out.println("PRODUCT ID :"+objReq.getProductID());
			 System.out.println("ARR TOOL :"+objReq.getToolsDataAss());
			 System.out.println("ARR METHOD: "+objReq.getMethodDataAss());
			 System.out.println("ARR ITEM :"+objReq.getItemIdDataAss());
			 System.out.println("ARR ITEM MP :"+objReq.getItemMpDataAss());
			 
			 
			 
			 SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
             .withProcedureName("getUpdateSetupWork");
			 SqlParameterSource in = new MapSqlParameterSource()
     		.addValue("product", objReq.getProductID(),Types.VARCHAR)
     		.addValue("methods", objReq.getMethodDataAss(),Types.VARCHAR)
     		.addValue("item", objReq.getItemIdDataAss(),Types.VARCHAR)
     		.addValue("update_by", objReq.getCreateBy(),Types.VARCHAR)
     		.addValue("tool", objReq.getToolsDataAss(),Types.VARCHAR)
     		.addValue("itemmp", objReq.getItemMpDataAss(),Types.VARCHAR)
     		.addValue("samplecode", objReq.getSampleType(),Types.VARCHAR);
			 call.execute(in).get("#result-set-1");
			 result.put("result", "00");
	    	}catch (Exception ex){
	    		result.put("success", "0") ;
	    		result.put("message", ex.getMessage());
	    		ex.printStackTrace();
	    	}
		 //System.out.println(result);
		 return result;
	    	
	 }
	 
	 //SETTING ASSIGN SPEC
	 @RequestMapping("settingSPECAssign")
	 public ModelAndView settingSpecAssign(HttpServletRequest req, Model model) throws Exception {
	     return new ModelAndView("settingSPECAssign");
	 }
	 
	 @RequestMapping("settingWork")
	 public ModelAndView settingWork(HttpServletRequest req, Model model) throws Exception {
	     return new ModelAndView("settingWork");
	 }
	 
	 @RequestMapping("settingMobileLtrSpec")
	 public ModelAndView settingMobileLtrSpec(HttpServletRequest req, Model model) throws Exception {
	     return new ModelAndView("settingMobileLtrSpec");
	 }
	 
	 
	 @RequestMapping("settingWorkForAdmin")
	 public ModelAndView settingWorkForAdmin(HttpServletRequest req, Model model) throws Exception {
	     return new ModelAndView("settingWorkForAdmin");
	 }
	 
	 //Query Spec Item
	 @RequestMapping(value = "querySPITEM", method = RequestMethod.POST)
	 public @ResponseBody Map<String,Object> querySPITEM(@RequestBody RandomOil objReq,HttpServletRequest req,HttpSession session )throws  Exception{
		 Map<String,Object> result = new HashMap<String, Object>();
		 try{	
	            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
	                    .withProcedureName("querySPITEM");
	            SqlParameterSource in = new MapSqlParameterSource()
	            		.addValue("productID", objReq.getProductID(),Types.VARCHAR)
	            		.addValue("sampleType", objReq.getSampleType(),Types.VARCHAR);
	            List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
	            result.put("list", list);
	    	}catch (Exception ex){
	    		result.put("message", ex.getMessage());
	    		ex.printStackTrace();
	    	}
		 return result;
	    	
	 }
	 @RequestMapping(value = "updateMPSpecAssign", method = RequestMethod.POST)
	 public @ResponseBody Map<String,Object> updateMPSpecAssign(@RequestBody RandomOil objReq,HttpServletRequest req,HttpSession session )throws  Exception{
		 Map<String,Object> result = new HashMap<String, Object>();
		 try{	
	            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
	                    .withProcedureName("updateMPSpecAssign");
	            SqlParameterSource in = new MapSqlParameterSource()
	            		.addValue("itemmp_id", objReq.getItemmp_id(),Types.VARCHAR)
	            		.addValue("status", objReq.getStatus(),Types.VARCHAR);
	            List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
	            result.put("list", list);
	    	}catch (Exception ex){
	    		result.put("message", ex.getMessage());
	    		ex.printStackTrace();
	    	}
		 return result;
	    	
	 }
	 
	 @RequestMapping(value = "checkWorkWaiting/{productId}/{sampleType}", method = RequestMethod.GET)
	 public @ResponseBody Map<String,Object> checkWorkWaiting(HttpServletRequest req,HttpSession session ,@PathVariable String productId,@PathVariable String sampleType)throws  Exception{
		 Map<String,Object> result = new HashMap<String, Object>();
		 List<Map<String, Object>> list=null;
		 try{	
	            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
	                    .withProcedureName("getCheckWorkEndWF");
	            SqlParameterSource in = new MapSqlParameterSource()
	            		.addValue("productId", productId,Types.VARCHAR)
	            		.addValue("sampleTypeId", sampleType,Types.VARCHAR);
	            list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
	          
	    	}catch (Exception ex){
	    		result.put("message", ex.getMessage());
	    		ex.printStackTrace();
	    	}
		 return list.get(0);
	    	
	 }
	 
	 @RequestMapping("settingMobileTool")
	 public ModelAndView settingMobileTool(HttpServletRequest req, Model model) throws Exception {
	     return new ModelAndView("settingMobileTool");
	 }
	 
	 @RequestMapping("settingMobilePlant")
	 public ModelAndView settingMobilePlant(HttpServletRequest req, Model model) throws Exception {
	     return new ModelAndView("settingMobilePlant");
	 }
	 
	 @RequestMapping(value = "cancelLTRAssignment", method = RequestMethod.POST)
	 public @ResponseBody Map<String,Object> cancelLTRAssignment(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
		 Map<String,Object> result = new HashMap<String, Object>();
		 try{	
			 
			 MemberObj  memberObj = CGlobal.getC_UserInfo(session);
			 objReq.setCreateBy(memberObj.getCodempid());
			 
			 //System.out.println(objReq.getLabCode()+"|"+objReq.getCreateBy());
	            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
	                    .withProcedureName("cancelLTRAssignment");
	            SqlParameterSource in = new MapSqlParameterSource()
	                    .addValue("createBy", objReq.getCreateBy(), Types.VARCHAR)
	                    .addValue("labCode", objReq.getLabCode(), Types.VARCHAR);
	            call.execute(in).get("#result-set-1");
	            result.put("success", "1") ;
	    	}catch (Exception ex){
	    		result.put("success", "0") ;
	    		result.put("message", ex.getMessage());
	    		ex.printStackTrace();
	    	}
		 //System.out.println(result);
		 return result;
	    	
	 }
}
