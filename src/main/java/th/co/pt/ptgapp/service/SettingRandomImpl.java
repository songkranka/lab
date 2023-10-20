package th.co.pt.ptgapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.pt.ptgapp.controller.bean.SettingRandomObj;
import th.co.pt.ptgapp.dao.SettingRandomDao;

@Service("SettingRandom")
public class SettingRandomImpl implements SettingRandom{
	
	@Autowired
	private SettingRandomDao settingRandomDao;
	
	@Override
	public List<Map<String, Object>> inquerySettingRandom(SettingRandomObj objReq) throws Exception{
		
		List<Map<String,Object>> recList = settingRandomDao.inquerySettingRandom(objReq);
		
		return recList;
		
	}
	
	@Override
	public String insertSettingRandom(SettingRandomObj objReq) throws Exception{
		
		String recList = settingRandomDao.insertSettingRandom(objReq);
		
		return recList;
	}
	
	@Override
	public String deleteSettingRandom(SettingRandomObj objReq) throws Exception{
		
		String recList = settingRandomDao.deleteSettingRandom(objReq);
		
		return recList;
	}

	@Override
	public String updateSettingRandom(SettingRandomObj objReq) throws Exception {
		
		String recList = settingRandomDao.updateSettingRandom(objReq);
		
		return recList;
	}
	

	
}