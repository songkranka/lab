package th.co.pt.ptgapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.pt.ptgapp.controller.bean.SettingRandomLastObj;
import th.co.pt.ptgapp.dao.SettingRandomLastDao;

@Service("SettingRandomLast")
public class SettingRandomLastImpl implements SettingRandomLast{
	
	@Autowired
	private SettingRandomLastDao settingRandomLastDao;
	
	@Override
	public List<Map<String, Object>> inquirySettingRandomLast(SettingRandomLastObj objReq) throws Exception{
		
		List<Map<String,Object>> recList = settingRandomLastDao.inquirySettingRandomLast(objReq);
		
		return recList;
		
	}
	
	@Override
	public String insertSettingRandomLast(SettingRandomLastObj objReq) throws Exception{
		
		String recList = settingRandomLastDao.insertSettingRandomLast(objReq);
		
		return recList;
	}
	
	@Override
	public String deleteSettingRandomLast(SettingRandomLastObj objReq) throws Exception{
		
		String recList = settingRandomLastDao.deleteSettingRandomLast(objReq);
		
		return recList;
	}

	@Override
	public String updateSettingRandomLast(SettingRandomLastObj objReq) throws Exception {
		
		String recList = settingRandomLastDao.updateSettingRandomLast(objReq);
		
		return recList;
	}
	

	
}