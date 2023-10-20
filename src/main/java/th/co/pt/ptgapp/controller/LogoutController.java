package th.co.pt.ptgapp.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
 

@Controller
public class LogoutController {
	 
	private  final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value = "/account-logout", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest httpRequest,HttpServletResponse httpResponse) {
	
		//CGlobal.setC_UserInfo(null, httpRequest.getSession());
		
		httpRequest.getSession().invalidate();
		
		for (Cookie c : httpRequest.getCookies()) {
			if(c.getName().equals("uid")){
				c.setMaxAge(0);
				
			}
			
		}
//		Cookie cookie = new Cookie("user", null); // Not necessary, but saves bandwidth.
//		cookie.setPath("/MyApplication");
//		cookie.setHttpOnly(true);
//		cookie.setMaxAge(0); // Don't set to -1 or it will become a session cookie!
//		request.addCookie(cookie);
		//http://sso.ptg.com:8080/openam/XUI/#loggedOut/
		return new ModelAndView("account_login"); //run local
		//return new ModelAndView(new RedirectView("https://sso.pt.co.th/openam/UI/Logout")); //deploy sso
	}

	
}
