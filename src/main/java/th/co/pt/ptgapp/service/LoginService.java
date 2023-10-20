package th.co.pt.ptgapp.service;

import th.co.pt.ptgapp.controller.bean.MemberAccountObj;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.UserDto;

import javax.servlet.http.HttpSession;

public interface LoginService {
   
	MemberObj getUser(MemberObj user) throws Exception ;
	 
}
