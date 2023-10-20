package th.co.pt.ptgapp.controller;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import th.co.pt.ptgapp.controller.bean.UserMenuObj;
import th.co.pt.ptgapp.service.MenuService;

 

 

@Controller
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/getmenu", method = RequestMethod.POST)
	public @ResponseBody UserMenuObj GetMenu(@RequestBody UserMenuObj user_menu,HttpSession session, HttpServletRequest httpRequest)
	{	
		try{
			System.out.println("menuService !!!");
			return menuService.GetMenu(user_menu.strPage,session,httpRequest);
		}catch(Exception e){
			System.out.println("Section Time Out !!!");
		}
		return null;
	}
	
 
	
}
