package th.co.pt.ptgapp.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import th.co.pt.ptgapp.controller.bean.RandomOil;

public interface SendMailService {

	 String SendMailWF(Map<String,String> objReq,HttpSession session,RandomOil ranObj) throws Exception;

	 void sendGridSendMail(String Typecontent, String contentstr, String fromstr, String tostr, String Subject); 
	
}
