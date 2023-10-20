package th.co.pt.ptgapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 

import th.co.pt.ptgapp.controller.bean.MemberObj; 
import th.co.pt.ptgapp.dao.MenuDao;


@Service("loginService")
public class LoginServiceImpl   implements LoginService
{
	@Autowired
	private MenuDao menuDao;
	
    @Override
    @Transactional
    public MemberObj getUser(MemberObj user) throws Exception {

        MemberObj ref_member = menuDao.GetUserPermiss(user);
		
		return ref_member;
       
    }
    
}
