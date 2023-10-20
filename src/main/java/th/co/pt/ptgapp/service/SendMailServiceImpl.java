package th.co.pt.ptgapp.service;

import java.io.IOException;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import org.aspectj.weaver.tools.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

import th.co.pt.ptgapp.controller.bean.MailObj;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.SendMailWFObj;
import th.co.pt.ptgapp.utils.CGlobal;
import th.co.pt.ptgapp.utils.WebUtil;

@Service("sendMailService")
public class SendMailServiceImpl implements SendMailService {
	@Autowired
	private Environment env;
	
	public Map<String, String> FormatListtoMap(List<Map<String,Object>> resultList){
		Map<String, String> pResult = new HashMap<String, String>();
		try {
		    for(Map<String, Object> element: resultList) {
		        for(Entry<String, Object> entry : element.entrySet()) {
		        	pResult.put(entry.getKey(), (String) entry.getValue());
		        }
		    }	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return pResult;
	}
	
	
	public String SendMailWF(Map<String,String> objReq,HttpSession session,RandomOil ranObj) throws Exception {
		String result = "0";
		try {
			MemberObj  memberObj = CGlobal.getC_UserInfo(session);
			String uri = WebUtil.WebServiceUrl() + "HrisService/member-getmemberprofile";
			MemberObj dataTo = new MemberObj();	
			MemberObj dataFrom = new MemberObj();
			SendMailWFObj sen = new SendMailWFObj();
			//SET TIME
			DateTimeFormatter tTime = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
			LocalDateTime now = LocalDateTime.now();  
			
			for(int i=0;i<objReq.get("CODEMP_TO").split(",").length;i++) {	
				dataTo.codempid = objReq.get("CODEMP_TO").split(",")[i];
				dataFrom.codempid = objReq.get("CODEMP_FROM");
				RestTemplate restTemplate = new RestTemplate();
				MemberObj member_dataTo = restTemplate.postForObject(uri,dataTo,MemberObj.class);
				MemberObj member_dataFrom = restTemplate.postForObject(uri,dataFrom,MemberObj.class);
				
				//System.out.println(member_dataTo.getEmail()+"|"+member_dataFrom.getEmail());
				
				if(null!=member_dataTo.getEmail()) {
					//MD5
					String myToken = tTime.format(now)+"a49d2aff2d0404f318f471358ab6fe1b";
					MessageDigest md = MessageDigest.getInstance("MD5");
					md.update(myToken.getBytes());
				    byte[] digest = md.digest();
				    String myTokenResult = DatatypeConverter.printHexBinary(digest).toLowerCase();
					
					//sen.setEmailTo(member_dataTo.getEmail());
				    sen.setEmailTo("zomads17@gmail.com");
				    //sen.setEmailTo("chaiyarut.ju@pt.co.th");
					sen.setEmailFrom("main.lab@pt.co.th");
					sen.setLtr_code(objReq.get("LTR_CODE"));
					sen.setComment(objReq.get("COMMENT"));
					sen.setSampleTypeName(objReq.get("SAMPLE_TYPE_NAME"));
					sen.setProductName(objReq.get("PRODUCT_NAME"));
					sen.setUrl_wf(ranObj.getUrl_wf());
					sen.setTimeEmal(tTime.format(now));
					sen.setTokenMail(myTokenResult);
					sen.setNameTo(member_dataTo.getNamempt());
					sen.setNameFrom(member_dataFrom.getNamempt());
					SendMail(sen);
				}			
			}
			result = "1";
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
	public String SendMail(SendMailWFObj sen) {
		String result = "";
		String uri = "https://asv-it-bot03-uat.azurewebsites.net/sendmail";
		System.out.println(uri+"|URL");
		System.out.println(sen.getEmailFrom()+"|From");
		System.out.println(sen.getEmailTo()+"|TO");
		System.out.println("Test Sub Mail|SUB");
		System.out.println("TEST MSG|MSG");
		System.out.println(sen.getTokenMail()+"|TOKEN");
		System.out.println(sen.getTimeEmal()+"|TIME");
		System.out.println("PTG01|SRC");
				
		String msgDetail = "<h4 >เรียน "+sen.getNameTo()+"</h4>\r\n" + 
				"<h5 >&nbsp;&nbsp;&nbsp;&nbsp;มีรายการอนุมัติ LTR<br>\r\n" + 
				"  &nbsp;&nbsp;&nbsp;&nbsp;เลข LTR : "+sen.getLtr_code()+"<br>\r\n" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;ประเภทตัวอย่าง : "+sen.getSampleTypeName()+"<br>\r\n" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;ผลิตภัณฑ์ : "+sen.getProductName()+"<br>\r\n" + 
				"  &nbsp;&nbsp;&nbsp;&nbsp;click link <a href="+sen.getUrl_wf()+">"+sen.getUrl_wf()+"</a></h5>\r\n" + 
				"<br><h5>Best Regards<br>Lab Analysis.</h5>";
		
		sen.setMsgMail(msgDetail);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		Map<String, Object> map = new HashMap<>();
		map.put("FROM", sen.getEmailFrom());
		map.put("TO", sen.getEmailTo());
		map.put("SUB", "Approve MainLab");
		map.put("MSG", sen.getMsgMail());
		map.put("TOKEN",sen.getTokenMail());
		map.put("TIME", sen.getTimeEmal());
		map.put("SRC", "PTG01");
		
		System.out.println(map+"|"+headers);
		// build the request
		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

		// send POST request
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity(uri, entity, String.class);
		
		/*
		if (response.getStatusCode() == HttpStatus.CREATED) {
		    System.out.println("Request Successful");
		    System.out.println(response.getBody());
		} else {
		    System.out.println("Request Failed");
		    System.out.println(response.getStatusCode());
		}
		*/
		return result;
	}
	
	
	public String SendMailWF2(HttpSession session) throws Exception {
		String result = "0";
		try {
			MemberObj  memberObj = CGlobal.getC_UserInfo(session);
			String uri = WebUtil.WebServiceUrl() + "HrisService/member-getmemberprofile";
			MemberObj dataTo = new MemberObj();	
			MemberObj dataFrom = new MemberObj();
			SendMailWFObj sen = new SendMailWFObj();
			//SET TIME
			DateTimeFormatter tTime = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
			LocalDateTime now = LocalDateTime.now();  
			

				dataTo.codempid = "62020020";
				dataFrom.codempid = "62020020";
				RestTemplate restTemplate = new RestTemplate();
				MemberObj member_dataTo = restTemplate.postForObject(uri,dataTo,MemberObj.class);
				MemberObj member_dataFrom = restTemplate.postForObject(uri,dataFrom,MemberObj.class);
				
				//System.out.println(member_dataTo.getEmail()+"|"+member_dataFrom.getEmail());
				
				if(null!=member_dataTo.getEmail()) {
					//MD5
					String myToken = tTime.format(now)+"a49d2aff2d0404f318f471358ab6fe1b";
					MessageDigest md = MessageDigest.getInstance("MD5");
					md.update(myToken.getBytes());
				    byte[] digest = md.digest();
				    String myTokenResult = DatatypeConverter.printHexBinary(digest).toLowerCase();
					
					//sen.setEmailTo(member_dataTo.getEmail());
				    sen.setEmailTo("somkid.pu@pt.co.th");
				    //sen.setEmailTo("chaiyarut.ju@pt.co.th");
					sen.setEmailFrom("main.lab@pt.co.th");
					sen.setLtr_code("1111111");
					sen.setComment("TEST");
					sen.setSampleTypeName("SHOP");
					sen.setProductName("GAS");
					sen.setUrl_wf("www.google.com");
					sen.setTimeEmal(tTime.format(now));
					sen.setTokenMail(myTokenResult);
					sen.setNameTo(member_dataTo.getNamempt());
					sen.setNameFrom(member_dataFrom.getNamempt());
					SendMail(sen);
				}			
			
			result = "1";
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
	public String SendMailWFSendGridTest(){
		String result = "0";
		try {
			sendGridSendMail("text/html","<h3>TEST MAIL FORM</h3>","main.lab@pt.co.th","zomads17@gmail.com","Send gird send mail");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
	@Override
	public void sendGridSendMail(String Typecontent,String contentstr,String fromstr,String tostr,String Subject)  {
		System.out.println("FROM : "+fromstr);
		System.out.println("TO   : "+tostr);
		Email from = new Email(env.getProperty("head.sender"));
	    String subject = Subject;
	    Email to = new Email(tostr);
	    Content content = new Content(Typecontent, contentstr);
	    Mail mail = new Mail(from, subject, to, content);

	    SendGrid sg = new SendGrid(env.getProperty("sendgrid.api.key"));
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println(response.getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	    } catch (IOException ex) {
	    	ex.printStackTrace();
	    }
	}
}
