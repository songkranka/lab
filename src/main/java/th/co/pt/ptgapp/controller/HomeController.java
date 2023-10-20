package th.co.pt.ptgapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import th.co.pt.ptgapp.controller.bean.CaClreqtObj;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.ws.WFConstant;
import th.co.pt.ptgapp.dao.task.LtrDao;
import th.co.pt.ptgapp.dao.task.LtrDtlDto;
import th.co.pt.ptgapp.dao.task.LtrDto;
import th.co.pt.ptgapp.dao.task.RandomSampleResultDto;
import th.co.pt.ptgapp.entity.TaskListBean;
import th.co.pt.ptgapp.service.MenuServiceImpl;
import th.co.pt.ptgapp.service.SendMailService;
import th.co.pt.ptgapp.service.task.IRandomSampleResultService;
import th.co.pt.ptgapp.service.ws.lotusnotes.IPtgService;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.WsConstant;
import th.co.pt.ptgapp.utils.CGlobal;
import th.co.pt.ptgapp.utils.ParamMap;
import th.co.pt.ptgapp.utils.WebUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.sql.Types;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Controller
public class HomeController {
	private final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private MenuServiceImpl menuServiceImpl;
	@Autowired
	private IPtgService ptgService;
    @Autowired
	private IRandomSampleResultService randomSampleResultService;
    @Autowired
    private LtrDao ltrDao;
    @Autowired
    private SendMailService sendMailService;

    @Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;
    
    @RequestMapping("home")
    public String home() {
        return "home";
    }
    //getLevelHead
    @RequestMapping(value = "/api/getLevelHead", method = RequestMethod.POST)
    public @ResponseBody
    Map<String,Object> getLevelHead(@RequestBody RandomOil objReq, HttpSession session) throws Exception{
        Map<String,Object>  result  =  new HashMap<>();
        MemberObj memberObj = CGlobal.getC_UserInfo(session);
        objReq.setUserTypeID(memberObj.getCodempid());
        //System.out.println(memberObj.getEmail());
        try{
        	 SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                     .withProcedureName("getLevelHead");
             SqlParameterSource in = new MapSqlParameterSource()
                     .addValue("usertypeID", objReq.getUserTypeID(), Types.VARCHAR);
            List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
     		result.put("list", list);
     		result.put("role",memberObj.getRole_id());
     		//System.out.println(list+"|"+objReq.getTypeWork());     
        }catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
        return result;
    }
    
    @RequestMapping(value = "/api/getAssignWork", method = RequestMethod.POST)
    public @ResponseBody
    Map<String,Object> getAssignWork(@RequestBody RandomOil objReq, HttpSession session) throws Exception{
        Map<String,Object>  result  =  new HashMap<>();
        //System.out.println(session);
        MemberObj memberObj = CGlobal.getC_UserInfo(session);
        objReq.setUserTypeID(memberObj.getCodempid());
        //System.out.println("User = "+objReq.getUserTypeID());
        try{
        	 SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                     .withProcedureName("getAssLtrHD");
             SqlParameterSource in = new MapSqlParameterSource()
            		 .addValue("typeWork", objReq.getTypeWork(),Types.VARCHAR)
                     .addValue("usertypeID", objReq.getUserTypeID(), Types.VARCHAR);
            List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
     		result.put("list", list);
     		//System.out.println(list+"|"+objReq.getTypeWork());
            
        }catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
        return result;
    }
    
    @RequestMapping(value = "/api/getAssignWorkForPrint", method = RequestMethod.POST)
    public @ResponseBody
    Map<String,Object> getAssignWorkForPrint(@RequestBody RandomOil objReq, HttpSession session) throws Exception{
        Map<String,Object>  result  =  new HashMap<>();
        //System.out.println(session);
        MemberObj memberObj = CGlobal.getC_UserInfo(session);
        objReq.setUserTypeID(memberObj.getCodempid());
        //System.out.println("User = "+objReq.getUserTypeID());
        try{
        	 SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                     .withProcedureName("getAssLtrHDForPrint");
             SqlParameterSource in = new MapSqlParameterSource()
            		 .addValue("typeWork", objReq.getTypeWork(),Types.VARCHAR)
                     .addValue("usertypeID", objReq.getUserTypeID(), Types.VARCHAR);
            List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
     		result.put("list", list);
     		//System.out.println(list+"|"+objReq.getTypeWork());
            
        }catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
        return result;
    }
    
    @RequestMapping(value = "/api/getMyTaskList_old", method = RequestMethod.POST)
    public @ResponseBody
    Map<String,Object> getItems_old(@RequestBody HashMap<String,Object> params,@ModelAttribute CaClreqtObj objReq, HttpSession session) throws Exception{
        Map<String,Object>  result  =  new HashMap<>();
        result.put(WsConstant.WEB_STATUS_CODE,WsConstant.WEB_ERROR_CODE);
        List<TaskListBean> newList = new ArrayList<>();
        List<TaskListBean> submitList = new ArrayList<>();
        List<TaskListBean> completeList = new ArrayList<>();
        try{
            ParamMap paramMap = new ParamMap();
            paramMap.setParamMap(params);
            MemberObj memberObj = CGlobal.getC_UserInfo(session);
            CaClreqtObj obj =  objReq;
            obj.setCodempid(memberObj.getCodempid());
            Map<String, Object> info = menuServiceImpl.getMPUserInfo(obj);
            String[] fws = WebUtil.GetPropertyMessage("workflow", "work_status").split(",");
            ParamMap reqMap = new ParamMap();
            for (String s : fws){
                reqMap.put("systemT", WFConstant.SYSTEM_NAME);
                reqMap.put("employee",memberObj.getCodempid());
                reqMap.put("wfStatus",s.trim());
                String res = ptgService.getMyWork(reqMap);
                ObjectMapper mapper = new ObjectMapper();
                Map<String,Object> map = mapper.readValue(res, Map.class);
                if("900".equals(map.get("ErrorCode"))){
                    List<Map> list = (List) map.get(String.valueOf(map.get("EmployeeID")));
                    List<String> labCodeList = new ArrayList<>();
                    for (Map<String,String> m :list) {
                        RandomOil rand = new RandomOil();
                        rand.setLabCode_No(String.valueOf(m.get("RequestID")));
                        if (!StringUtils.isEmpty(String.valueOf(m.get("RequestID")))) {
                            labCodeList.add(String.valueOf(m.get("RequestID")).trim());
                        }
                    }
                    if(!labCodeList.isEmpty()){
                        System.out.println("start "+ new Date() );
                        List<RandomSampleResultDto> sampleList = randomSampleResultService.findRandomSampleByLabCode(labCodeList);
                        System.out.println("end "+ new Date());
                        for (RandomSampleResultDto sample : sampleList) {
                            TaskListBean tb = new TaskListBean();
                            tb.setReqNo(sample.getLabCode());
                            tb.setPlant(sample.getPlantName());
                            tb.setPrd(sample.getProductName());
                            tb.setSamp(sample.getSampleTypeName());
                            tb.setSampdate(sample.getStrpoDate());
                            tb.setExprdate(sample.getStrSampleExpreDate());
                            tb.setProdCode(sample.getProductCode());
                            tb.setPlantId(sample.getPlantId());
                            if("New".equalsIgnoreCase(s)){
                                newList.add(tb);
                            }else if("On Process".equalsIgnoreCase(s)){
                                submitList.add(tb);
                            }else if("Complete".equalsIgnoreCase(s)){
                                completeList.add(tb);
                            }
                        }
                    }
                }
            }
            result.put(WsConstant.WEB_STATUS_CODE, WsConstant.WEB_SUCCESS_CODE);
            result.put("userType",String.valueOf(info.get("USER_TYPE_ID")).substring(0,2));
            result.put("newList", newList);
            result.put("submitList", submitList);
            result.put("completeList", completeList);
        }catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
        return result;
    }


    @RequestMapping(value = "/api/getMyTaskList", method = RequestMethod.POST)
    public @ResponseBody
    Map<String,Object> getItems(@RequestBody HashMap<String,Object> params,@ModelAttribute CaClreqtObj objReq, HttpSession session) throws Exception{
        Map<String,Object>  result  =  new HashMap<>();
        result.put(WsConstant.WEB_STATUS_CODE,WsConstant.WEB_ERROR_CODE);
        List<TaskListBean> newList = new ArrayList<>();
        List<TaskListBean> reviseList = new ArrayList<>();
        List<TaskListBean> submitList = new ArrayList<>();
        List<TaskListBean> completeList = new ArrayList<>();
        List<TaskListBean> waitAuditList = new ArrayList<>();
        List<TaskListBean> waitApprovedList = new ArrayList<>();
        try{
            ParamMap paramMap = new ParamMap();
            paramMap.setParamMap(params);
            MemberObj memberObj = CGlobal.getC_UserInfo(session);
            CaClreqtObj obj =  objReq;
            obj.setCodempid(memberObj.getCodempid());
            Map<String, Object> info = menuServiceImpl.getMPUserInfo(obj);
            ParamMap reqMap = new ParamMap();
            reqMap.put("systemT", WFConstant.SYSTEM_NAME);
            reqMap.put("employee",memberObj.getCodempid());
            reqMap.put("wfStatus","");
            String res = ptgService.getMyWork(reqMap); // RES
            //System.out.println("RES = "+res+"\nsystemT = "+WFConstant.SYSTEM_NAME+"\nemployee = "+memberObj.getCodempid()+"\nSESSION = "+session);
            ObjectMapper mapper = new ObjectMapper();
            Map<String,Object> map = mapper.readValue(res, Map.class);
            if("900".equals(map.get("ErrorCode"))){
                List<Map> list = (List) map.get(String.valueOf(map.get("EmployeeID")));
                List<String> labCodeList = new ArrayList<>();
                Map<String,Map<String,String>> mapResult = new HashMap<>();
                for (Map<String,String> m :list) {
                    if (!StringUtils.isEmpty(String.valueOf(m.get("RequestID")))) {
                        labCodeList.add(String.valueOf(m.get("RequestID")).trim());
                        mapResult.put(String.valueOf(m.get("RequestID")).trim(),m);
                        //System.out.println(String.valueOf("LAB CODE = "+m.get("RequestID")).trim()); // Request ID
                    }
                }
                if(!labCodeList.isEmpty()){
                    List<RandomSampleResultDto> sampleList = randomSampleResultService.findRandomSampleByLabCode(labCodeList);
                    for (RandomSampleResultDto sample : sampleList) {
                        Map<String,String> mp = mapResult.get(sample.getLabCode());
                        if(!mp.isEmpty()){
                            TaskListBean tb = new TaskListBean();
                            tb.setReqNo(sample.getLabCode());
                            tb.setPlant(sample.getPlantName());
                            tb.setPrd(sample.getProductName());
                            tb.setSamp(sample.getSampleTypeName());
                            tb.setSampdate(sample.getStrpoDate());
                            tb.setExprdate(sample.getStrSampleExpreDate());
                            tb.setProdCode(sample.getProductCode());
                            tb.setPlantId(sample.getPlantId());
                            tb.setWfStep(mp.get("WFStep"));
                            tb.setWfStatus(mp.get("WFStatus"));
                            if("New".equalsIgnoreCase(mp.get("WFStatus"))){
//                                reviseList.add(tb);
                                LtrDto ltrDto = ltrDao.findLtrByLabCode(sample.getLabCode());
                                if(ltrDto != null){
                                    List<LtrDtlDto> dtlList = ltrDao.findLtrDtlByLtrNo(ltrDto.getLtrNo());
                                    List<LtrDtlDto> temp = dtlList.stream()
                                            .filter(e->(!StringUtils.isEmpty(e.getUpdateBy()) && e.getUpdateBy().equals(memberObj.codempid)))
                                            .collect(Collectors.toList());
                                    if(temp.isEmpty()){
                                        newList.add(tb);
                                    }else {
                                        submitList.add(tb);
                                    }
                                }else{
                                    newList.add(tb);
                                }
                            }else if("Completed".equalsIgnoreCase(mp.get("WFStatus"))) {
                                completeList.add(tb);
                            }else if("Wating for Checker".equalsIgnoreCase(mp.get("WFStatus"))){
                                waitAuditList.add(tb);
                            }else if("Wating for Team Lead".equalsIgnoreCase(mp.get("WFStatus"))){
                                waitApprovedList.add(tb);
                            }else{
                                System.out.println("WFStatus is not match");
                            }
                        }
                    }
                }
            }

            result.put(WsConstant.WEB_STATUS_CODE, WsConstant.WEB_SUCCESS_CODE);
            result.put("userType",String.valueOf(info.get("USER_TYPE_ID")).substring(0,2));
            result.put("newList", newList);
            result.put("submitList", submitList);
            result.put("completeList", completeList);
            result.put("reviseList", reviseList);
            result.put("waitApprovedList", waitApprovedList);
            result.put("waitAuditList", waitAuditList);
            result.put("urole", memberObj.getRole_id());
        }catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
        return result;
    }
    /******** end ***********/

    /*@RequestMapping("home")
    public ModelAndView home( @ModelAttribute CaClreqtObj objReq, HttpServletRequest req, Model model,HttpSession session ) throws  Exception {
    	MemberObj  memberObj = CGlobal.getC_UserInfo(session);
    	CaClreqtObj obj =  objReq;
    	obj.setCodempid(memberObj.getCodempid());
    	Map<String, Object> info = menuServiceImpl.getMPUserInfo(obj);
    	ModelAndView mav = new ModelAndView("home");
    	mav.addObject("statusList", WebUtil.GetPropertyMessage("workflow", "work_status"));
    	mav.addObject("mpmember" ,info);
    	return mav;
    }*/


    @RequestMapping("homePage")
    public ModelAndView homePage(HttpServletRequest req,Model model) {
        return new ModelAndView("homepage");
    }
  
    @RequestMapping("AjaxInfo")
    public void AjaxInfo(HttpServletRequest req,Model model, HttpServletResponse response)throws Exception{
        PrintWriter out = response.getWriter();
        String mode =req.getParameter("mode");
        if("AjaxInfo".equals(mode)) {
            String json = "A0001";
            TimeUnit.MINUTES.sleep(3);
            out.println(json);
        }
    }
    
    @RequestMapping("testsendgrid")
    @ResponseBody
    public void testsendgrid(HttpServletRequest req,Model model, HttpServletResponse response,@RequestParam String from,@RequestParam String to){
    	sendMailService.sendGridSendMail("text/html","<h3>TEST MAIL FORM</h3>",from,to,"Send gird send mail");
    }

    @RequestMapping("/viewwaitwork")
    public ModelAndView viewwaitwork(HttpServletRequest req,Model model) throws Exception{
    	   return new ModelAndView("viewwaitwork");
   
    }
    
    @RequestMapping("/reportcrate")
    public ModelAndView reportcrate(HttpServletRequest req,Model model) throws Exception{
    	   return new ModelAndView("reportcrate");
   
    }
    
    @RequestMapping("/viewwaitworksubrole")
    public ModelAndView viewwaitworksubrole(HttpServletRequest req,Model model) throws Exception{
    	   return new ModelAndView("viewwaitworksubrole");
   
    }
    
    @RequestMapping("/reportLtrCondition")
    public ModelAndView reportLtrCondition(HttpServletRequest req,Model model) throws Exception{
    	   return new ModelAndView("reportLtrCondition");
   
    }
    
    @RequestMapping("/manageDataMaster")
    public ModelAndView manageDataMaster(HttpServletRequest req,Model model) throws Exception{
    	   return new ModelAndView("manageDataMaster");
   
    }
    
    @RequestMapping("/manageDataVisual")
    public ModelAndView manageDataVisual(HttpServletRequest req,Model model) throws Exception{
    	   return new ModelAndView("manageDataVisual");
   
    }
    
    @RequestMapping("/manageDataColor")
    public ModelAndView manageDataColor(HttpServletRequest req,Model model) throws Exception{
    	   return new ModelAndView("manageDataColor");
   
    }
    
    
    @ResponseBody
    @RequestMapping("/test")
    public String Test(HttpServletRequest req,Model model) throws Exception{
    	String userInput = "jndi:ldap://127.0.0.1:3089";
    	logger.info("User Input:" + userInput);
    	   return "";
   
    }
    
}
