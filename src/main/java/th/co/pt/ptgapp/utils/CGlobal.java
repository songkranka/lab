package th.co.pt.ptgapp.utils;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import th.co.pt.ptgapp.controller.bean.MemberObj;

 

public class CGlobal {
	private static  MemberObj C_UserInfo;

	public static  MemberObj getC_UserInfo(HttpSession session) {
		C_UserInfo=(MemberObj)session.getAttribute("C_UserInfo");
		return C_UserInfo;
	}

	public static void setC_UserInfo(MemberObj c_UserInfo,HttpSession session) {
		session.setAttribute("C_UserInfo", c_UserInfo);
		//C_UserInfo = c_UserInfo;
	}


	
}
