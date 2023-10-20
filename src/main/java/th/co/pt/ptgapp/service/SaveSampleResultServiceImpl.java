package th.co.pt.ptgapp.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import th.co.pt.ptgapp.controller.bean.MemberObj; 
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.ResultObj;
import th.co.pt.ptgapp.dao.MenuDao;
import th.co.pt.ptgapp.dao.RandomOilDao;
import th.co.pt.ptgapp.dao.SaveSampleResultDao;


@Service("SaveSampleResultService")
public class SaveSampleResultServiceImpl   implements SaveSampleResultService
{
	@Autowired
	private SaveSampleResultDao saveSampleResultDao;
  
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public  Map<String,Object>  saveSampleResult(RandomOil objReq) throws   Exception   {
    	 Map<String,Object>     obj =  new  HashMap<String,Object>();
      
    	 RandomOil recObjReq = saveSampleResultDao.saveSampleResult(objReq);
//	     if(recObjReq.getResult().equals("1")){	 
//		    obj= randomOilDao.summaryRandomOilDetail(recObjReq);
//	     }
    	 obj.put("labCode", recObjReq.getLabCode_No());
		 obj.put("success", recObjReq.getResult())  ;
	     obj.put("message", recObjReq.getMessage());
     
		return obj;
       
    }

	@Override
	public Map<String, Object> queryDataRandomSimpleResult(RandomOil objReq) {
		Map<String,Object>     obj =  new  HashMap<String,Object>();      
   	 	obj  = saveSampleResultDao.queryDataRandomSimpleResult(objReq);

		return obj;
	}
     
}
