package th.co.pt.ptgapp.service;

import java.util.List;
import java.util.Map;

import th.co.pt.ptgapp.controller.bean.MemberAccountObj;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.ResultObj;
import th.co.pt.ptgapp.controller.bean.UserDto;

import javax.servlet.http.HttpSession;

public interface SaveSampleResultService {
	
	 
	 
	public  Map<String,Object>  saveSampleResult(RandomOil objReq) throws   Exception ;

	public Map<String, Object> queryDataRandomSimpleResult(RandomOil objReq);
}  
