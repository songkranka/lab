package th.co.pt.ptgapp.controller;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.SendMailWFObj;
import th.co.pt.ptgapp.service.SendMailServiceImpl;
import th.co.pt.ptgapp.utils.CGlobal;

@Controller
public class SubmitReceiveController {
    @Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;
    
    @Autowired
	private SendMailServiceImpl sendMailServiceImpl;
    
	@RequestMapping("getAssignWorkDetail")
	 public ModelAndView initAssignmentDetail() throws Exception {	 
	     return new ModelAndView("getAssignWorkDetail");
	}
   @RequestMapping(value = "getAssignWorkDetail", method = RequestMethod.POST)
   public @ResponseBody
   Map<String,Object> getAssignWorkDetail(@RequestBody RandomOil objReq, HttpSession session) throws Exception{
       Map<String,Object>  result  =  new HashMap<>();
       //System.out.println(session);
       MemberObj memberObj = CGlobal.getC_UserInfo(session);
       objReq.setUserTypeID(memberObj.getCodempid());
       System.out.println("User = "+objReq.getUserTypeID()+"|"+objReq.getTypeWork()+"|"+objReq.getLtrdt());
       try{
       	 SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                    .withProcedureName("assignWorkToUser");
            SqlParameterSource in = new MapSqlParameterSource()
            		.addValue("typeWork", objReq.getTypeWork(),Types.VARCHAR)
           		 	.addValue("ltrdt", objReq.getLtrdt(), Types.VARCHAR)
                    .addValue("usertypeID", objReq.getUserTypeID(), Types.VARCHAR);
           List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
    		result.put("list", list);
    		//System.out.println(list);
           
       }catch (Exception ex){
           ex.printStackTrace();
           throw ex;
       }
       return result;
   }
   @RequestMapping(value = "insertLTRDTSub", method = RequestMethod.POST)
   public @ResponseBody
   Map<String,Object> saveSubmitData(@RequestBody RandomOil objReq, HttpSession session) throws Exception{
       Map<String,Object>  result  =  new HashMap<>();
       //System.out.println(session);
       MemberObj memberObj = CGlobal.getC_UserInfo(session);
       objReq.setUserTypeID(memberObj.getCodempid());
		
		
		
		  System.out.println(objReq.getLtrhd());
		  System.out.println(objReq.getLtrResult());
		  System.out.println(objReq.getLabCode());
		  System.out.println(objReq.getLtrdt());
		  System.out.println(objReq.getUserTypeID());
		 
		 
	 List<Map<String, Object>>  resultList = new ArrayList<Map<String, Object>>();
       try{
       	 SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                    .withProcedureName("insertLTRDTSub");
            SqlParameterSource in = new MapSqlParameterSource()
            		.addValue("comment", objReq.getComment(), Types.VARCHAR)
            		.addValue("ltrHD", objReq.getLtrhd(), Types.VARCHAR)
            		.addValue("ltrResult", objReq.getLtrResult(), Types.VARCHAR)
            		.addValue("labCode", objReq.getLabCode(), Types.VARCHAR)
           		 	.addValue("ltrdt", objReq.getLtrdt(), Types.VARCHAR)
           		 	.addValue("createBy", objReq.getUserTypeID(), Types.VARCHAR)
           		 	.addValue("pResult", Types.VARCHAR);
            resultList = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
            //System.out.println(resultList);
            
            Map<String, String> pResult = new HashMap<String, String>();
            //pResult = sendMailServiceImpl.FormatListtoMap(resultList);
    	    //System.out.println(pResult.get("RESULT"));
			if("1".equals(pResult.get("RESULT"))) {	
				 //sendMailServiceImpl.SendMailWF(pResult,session,objReq);
				 result.put("success", "1");
			}else {
				 result.put("success", "1");
			}      
       }catch (Exception ex){
    	   result.put("success", "2");
           ex.printStackTrace();
           throw ex;
       }
       return result;
   }
   @RequestMapping(value = "updateResultUncertainty", method = RequestMethod.POST)
   public @ResponseBody
   Map<String,Object> updateResultUncertainty(@RequestBody RandomOil objReq, HttpSession session) throws Exception{
       Map<String,Object>  result  =  new HashMap<>();
       //System.out.println(session);
       MemberObj memberObj = CGlobal.getC_UserInfo(session);
       objReq.setUserTypeID(memberObj.getCodempid());
	 
	 List<Map<String, Object>>  resultList = new ArrayList<Map<String, Object>>();
       try{
    	   System.out.println(objReq.getLtrhd());
    	   System.out.println( objReq.getResultUncer());
    	   System.out.println(objReq.getLtrdt());
       	 SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                    .withProcedureName("updateResultUncertainty");
            SqlParameterSource in = new MapSqlParameterSource()
            		.addValue("ltrCode", objReq.getLtrhd(), Types.VARCHAR)
            		.addValue("resultUncer", objReq.getResultUncer(), Types.VARCHAR)
           		 	.addValue("ltrdtID", objReq.getLtrdt(), Types.VARCHAR)
           		 	.addValue("createBy", objReq.getUserTypeID(), Types.VARCHAR);
            resultList = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
            result.put("success", "1");
       }catch (Exception ex){
    	   result.put("success", "2");
           ex.printStackTrace();
           throw ex;
       }
       return result;
   }
   @RequestMapping(value = "insertLtrLevelCode", method = RequestMethod.POST)
   public @ResponseBody
   Map<String,Object> saveSubmitDataUML(@RequestBody RandomOil objReq, HttpSession session) throws Exception{
       Map<String,Object>  result  =  new HashMap<>();
       //System.out.println(session);
       MemberObj memberObj = CGlobal.getC_UserInfo(session);
       objReq.setCreateBy(memberObj.getCodempid());

	 List<Map<String, Object>>  resultList = new ArrayList<Map<String, Object>>();
       try{
       	 SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                    .withProcedureName("insertLtrLevelCode");
            SqlParameterSource in = new MapSqlParameterSource()
            		.addValue("ltr_dt_id", objReq.getLtrDtIdUML(), Types.VARCHAR)
            		.addValue("lld_name", objReq.getNameUML(), Types.VARCHAR)
            		.addValue("lld_value", objReq.getValueUML(), Types.VARCHAR)
            		.addValue("lld_levelCode", objReq.getLevelCodeUML(), Types.VARCHAR)
           		 	.addValue("create_by", objReq.getCreateBy(), Types.VARCHAR);
            resultList = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
            result.put("success", "1");
       }catch (Exception ex){
    	   result.put("success", "2");
           ex.printStackTrace();
           throw ex;
       }
       return result;
   }
   @RequestMapping(value = "returnSubmitWorkToUser", method = RequestMethod.POST)
   public @ResponseBody
   Map<String,Object> returnSubmitWorkToUser(@RequestBody RandomOil objReq, HttpSession session) throws Exception{
       Map<String,Object>  result  =  new HashMap<>();
       MemberObj memberObj = CGlobal.getC_UserInfo(session);
       objReq.setUserTypeID(memberObj.getCodempid());
       //System.out.println(objReq.getLtrsubID());
       try{
       	 SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                    .withProcedureName("returnSubmitWorkToUser");
            SqlParameterSource in = new MapSqlParameterSource()
           		 	.addValue("ltrsubID", objReq.getLtrsubID(), Types.VARCHAR);
           List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
           result.put("success", "1");
       }catch (Exception ex){
    	   result.put("success", "2");
           ex.printStackTrace();
           throw ex;
       }
       return result;
   }
   
   @RequestMapping(value = "updateLTRHDresult", method = RequestMethod.POST)
   public @ResponseBody
   Map<String,Object> updateLTRHDresult(@RequestBody RandomOil objReq, HttpSession session) throws Exception{
       Map<String,Object>  result  =  new HashMap<>();
       //System.out.println(session);
       MemberObj memberObj = CGlobal.getC_UserInfo(session);
       objReq.setUserTypeID(memberObj.getCodempid());
	
       try{
       	 SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                    .withProcedureName("updateLTRHDresult");
            SqlParameterSource in = new MapSqlParameterSource()
            		.addValue("ltrhd", objReq.getLtrhd(), Types.VARCHAR)
            		.addValue("statusLTR", objReq.getStatusLTR(), Types.VARCHAR)
            		.addValue("remark_a4", objReq.getRemark(), Types.VARCHAR);
           List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
           result.put("success", "1");
       }catch (Exception ex){
    	   result.put("success", "2");
           ex.printStackTrace();
           throw ex;
       }
       return result;
   }
}
