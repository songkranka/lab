package th.co.pt.ptgapp.controller;
 
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.tempuri.PTWebServiceSoapProxy;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.ResultObj;
import th.co.pt.ptgapp.controller.bean.UserAuthen;
import th.co.pt.ptgapp.service.LoginService;
import th.co.pt.ptgapp.service.RandomService;
import th.co.pt.ptgapp.utils.WebUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class ApiLoginController {
	@Autowired
	private LoginService loginService;

    @Autowired
    private RandomService randomService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/testsoaplogin",method = RequestMethod.POST)
	@ResponseBody
	public UserAuthen mockResult(@RequestBody MemberObj member) throws RemoteException {
		PTWebServiceSoapProxy approve_service = new PTWebServiceSoapProxy();
		approve_service.setEndpoint(member.getTitle()) ; 
		String  actResult =  	 approve_service.getPTWebServiceSoap().LDAP_HRIS_USER_AUTHEN(member.codempid, member.password).toString()  ;
		Gson gson1 = new Gson();
		UserAuthen result_Login = gson1.fromJson(actResult,UserAuthen.class);
		return result_Login;
	}
  //prd remove _back uat add _back	
  @RequestMapping(value = "/login_back", method = RequestMethod.POST) //PROD
	public @ResponseBody ResultObj login2(@RequestBody MemberObj member, HttpServletRequest httpRequest) {
			ResultObj result = new ResultObj();
			try
			{
				logger.info("Start login");
				PTWebServiceSoapProxy approve_service = new PTWebServiceSoapProxy();
				 approve_service.setEndpoint(WebUtil.GetPropertyMessage("application", "url_login") ) ; 
				String  actResult =  	 approve_service.getPTWebServiceSoap().LDAP_HRIS_USER_AUTHEN(member.codempid, member.password).toString()  ;
				Gson gson1 = new Gson();
				 
				
				UserAuthen result_Login = gson1.fromJson(actResult,UserAuthen.class);
				
				logger.info("actResult====>"+actResult);
				if(result_Login.isSuccessful){
					
					String uri = WebUtil.WebServiceUrl() + "HrisService/member-getmemberprofile";
					//System.out.println(uri);
					MemberObj data = new MemberObj();
					data.codempid = member.codempid;
					data.password = member.password;
					
					RestTemplate restTemplate = new RestTemplate();
					MemberObj member_data = restTemplate.postForObject(uri, data,MemberObj.class);
					
						 if (member_data != null) {
								if (!WebUtil.IsStringEmpty(member_data.codempid)) {
									
									member_data = loginService.getUser(member_data); 
									
									if (WebUtil.InitMember(member_data,httpRequest.getSession())) {
										result.setStatus(1);
										result.setMessage("login success"); 
									    result.setDefault_page(member_data.getPage_default());
									    result.setDatatMember(member_data);
									    result.setRoleId(member_data.getRole_id());
									} else {
										result.setSuccess(0);
										result.setMessage("login error"); 
									}
								}
								else
								{
									result.setSuccess(0);
									result.setMessage("login error"); 
								}
						} else {
							result.setSuccess(0);
							result.setMessage("login error"); 
						} 
						//logger.info("login success");
						
						//result.setStatus(1);
						//result.setMessage("login success"); 
				} else {
					result.setStatus(0);
					result.setMessage(result_Login.responseMessage); 
				}
			
				return result;
			}catch(Exception ex){
				logger.error(ex.getMessage(),ex);
				ex.printStackTrace();
				result.setStatus(0);
				result.setMessage("login error : "+ex.getMessage());
				return result;
			}
		
		//return result;
	}
	
	@RequestMapping("login") //UAT
	public @ResponseBody ResultObj login(@RequestBody MemberObj member, HttpServletRequest httpRequest, HttpSession session) {
		ResultObj result = new ResultObj();
		try{
		String uri = WebUtil.WebServiceUrl() + "HrisService/member-getmemberprofile";
		MemberObj data = new MemberObj();
		
		data.codempid = member.codempid;
		data.password = member.password;
		RestTemplate restTemplate = new RestTemplate();
		MemberObj member_data = restTemplate.postForObject(uri,data,MemberObj.class);
		//System.out.println(uri+"|"+data+"|"+MemberObj.class);
		/** fix for develop ****/
		if (!WebUtil.IsStringEmpty(member_data.codempid)) {
			//System.out.println(member_data.mainmenu);
			member_data = loginService.getUser(member_data);
			//System.out.println(member_data.mainmenu);
			if (member_data.mainmenu != null) {
				
                List<Map<String, Object>> storeList = new ArrayList<>();
                List<Map<String, Object>> sessionStore = (List<Map<String, Object>>) session.getAttribute("storeList");
                if(sessionStore==null){           	
                    storeList = randomService.groupNameStoreRandomOil(new RandomOil());
                }
                if(storeList!=null && storeList.size()>0) {
                    session.setAttribute("storeList",storeList);
                    session.setAttribute("sessionStoreId",storeList.get(0).get("PLANT_ID"));
                }
				if (WebUtil.InitMember(member_data,httpRequest.getSession())) {
					//System.out.println("sss");
					result.setStatus(1);
					result.setMessage("login success");
					result.setDefault_page(member_data.getPage_default());
					result.setDatatMember(member_data);
					result.setRoleId(member_data.getRole_id());
					result.setSignatureImg(member_data.getSignature_img());
				} else {
					result.setStatus(0);
					result.setMessage("login error");
				}
			} else {
				result.setStatus(0);
				result.setMessage("contact admin is Authorize LAB"); 
				logger.error("contact admin is Authorize LAB");
				logger.error("Maybe 'LAB DB' is DOWN!!");
			} 		
		} else {
			result.setStatus(0);
			result.setMessage("contact admin is Authorize HRIS"); 
			logger.error("contact admin is Authorize HRIS");
			logger.error("Maybe 'HRIS DB' is DOWN!!");
		}
		
		}catch(Exception ex){
			ex.printStackTrace();
			result.setStatus(0);
			result.setMessage("login error");
			logger.error("exceprion : ",ex);
		}
		return result;
	}

	public void forwardRequest(String url, HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
	    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}
    @RequestMapping(value="welcome" , method = RequestMethod.GET)  
    public ModelAndView welcome(HttpServletRequest req,Model model){
	        return new ModelAndView("account_login");
    }
}

