package th.co.pt.ptgapp.service;

import java.util.List;
import java.util.Map;

import th.co.pt.ptgapp.controller.bean.TestscoreObj;

public interface Testscore{
	
	List<Map<String,Object>> inqueryListscore(TestscoreObj objReq) throws Exception;
	String insertTestcore(TestscoreObj objReq) throws Exception;
	String deleteTestcore(TestscoreObj objReq) throws Exception;
	String updateTestscore(TestscoreObj objReq) throws Exception;
	
} 