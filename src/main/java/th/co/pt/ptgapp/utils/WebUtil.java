package th.co.pt.ptgapp.utils;

import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import th.co.pt.ptgapp.controller.bean.MainMenuObj;
import th.co.pt.ptgapp.controller.bean.MemberObj;

 

public class WebUtil {
    public static final String EnvironmentText = "";
    public static final String DEVELOPING_USER_ID = "";
    public static final String DEVELOPING_USER_PASS = "";
    public static boolean IsStringEmpty(final String s) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }
    public static HttpSession session() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true); // true == allow create
    }
    public static String GetPropertyMessage(String file_name,String key)
    {
        ResourceBundle rb = ResourceBundle.getBundle(file_name);

        String result= rb.getString(key);
        return result;
    }
    public static String WebServiceUrl()
    {
        return WebUtil.GetPropertyMessage("application", "webservice_url");
    }
    public static String WebServiceUrlPcca()
    {
        return WebUtil.GetPropertyMessage("application", "webservice_url_pcca");
    }
    public static String SsoLogOutUrl()
    {

        return WebUtil.GetPropertyMessage("webconfigmsg", "sso_url_logout");
    }
    public static String WebServiceIntranet()
    {

        return WebUtil.GetPropertyMessage("webconfigmsg", "webservice_intranet_url");
    }
    public static String webservice_WorkFlow_url()
    {

        return WebUtil.GetPropertyMessage("webconfigmsg", "webservice_WorkFlow_url");
    }
    
    public static Boolean InitMember(MemberObj ref_member,HttpSession session) {
		Boolean success = false;
		if(ref_member != null)
		 { 
             MainMenuObj home = new MainMenuObj();
             home.app_path ="caHome";
             home.app_desc="เธซเธ�เน�เธฒเน�เธฃเธ�";
             home.app_head_desc= "";
             home.app_desc_en="Home";
             home.app_head_desc_en= "";
             MainMenuObj error = new MainMenuObj();
             error.app_path ="error";
             error.app_desc="เธซเธ�เน�เธฒเน�เธฃเธ�";
             error.app_head_desc= "";
             error.app_desc_en="Home";
             error.app_head_desc_en= "";
             ref_member.mainmenu.add(home);
             ref_member.mainmenu.add(error);
             
 
                    
             success = true;
             CGlobal.setC_UserInfo(ref_member, session);

         }
         else
         {
        	 CGlobal.setC_UserInfo(null, session);
         }
		
		
		return success;
	}
    public String isEmpty(String value){
    	
    	value  = ((value==null||value.equalsIgnoreCase("null")||value.trim().equalsIgnoreCase("")||value.trim().equalsIgnoreCase("-"))?"0":value) ;
    	
    	return value;
    }
}

