package th.co.pt.ptgapp.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import th.co.pt.ptgapp.controller.bean.CaClreqtObj;
import th.co.pt.ptgapp.controller.bean.UserMenuObj;

public interface MenuService {
	UserMenuObj GetMenu(String strPage,HttpSession session, HttpServletRequest httpRequest);
	public Map<String, Object> getMPUserInfo(CaClreqtObj obj) throws Exception ;
}
