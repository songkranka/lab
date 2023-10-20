package th.co.pt.ptgapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.pt.ptgapp.controller.bean.TestscoreObj;
import th.co.pt.ptgapp.dao.TestScoreDao;

@Service("Testscore")
public class TestscoreImpl implements Testscore{
	
	@Autowired
	private TestScoreDao testScoreDao;
	
	@Override
	public List<Map<String, Object>> inqueryListscore(TestscoreObj objReq) throws Exception{
		
		List<Map<String,Object>> recList = testScoreDao.inqueryListscore(objReq);
		
		return recList;
		
	}
	
	@Override
	public String insertTestcore(TestscoreObj objReq) throws Exception{
		
		String recList = testScoreDao.insertTestscore(objReq);
		
		return recList;
	}
	
	@Override
	public String deleteTestcore(TestscoreObj objReq) throws Exception{
		
		String recList = testScoreDao.deleteTestcore(objReq);
		
		return recList;
	}

	@Override
	public String updateTestscore(TestscoreObj objReq) throws Exception {
		
		String recList = testScoreDao.updateTestscore(objReq);
		
		return recList;
	}
	

	
}