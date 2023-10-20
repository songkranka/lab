package th.co.pt.ptgapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.co.pt.ptgapp.controller.bean.SettingRandomSortingObj;
import th.co.pt.ptgapp.dao.SettingRandomSortingDao;

@Service("SettingRandomSorting")
public class SettingRandomSortingImpl implements SettingRandomSorting{
	
	@Autowired
	private SettingRandomSortingDao settingRandomSortingDao;
	
	@Override
	public List<Map<String, Object>> inquirySettingRandomSorting(SettingRandomSortingObj objReq) throws Exception{
		
		List<Map<String,Object>> recList = settingRandomSortingDao.inquirySettingRandomSorting(objReq);
		
		return recList;
		
		
	}
	
	@Override
	public String insertSettingRandomSorting(SettingRandomSortingObj objReq) throws Exception{
		
		String recList = settingRandomSortingDao.insertSettingRandomSorting(objReq);
		
		return recList;
	}
	
	@Override
	public String deleteSettingRandomSorting(SettingRandomSortingObj objReq) throws Exception{
		
		String recList = settingRandomSortingDao.deleteSettingRandomSorting(objReq);
		
		return recList;
	}

	@Override
	public String updateSettingRandomSorting(SettingRandomSortingObj objReq) throws Exception {
		
		String recList = settingRandomSortingDao.updateSettingRandomSorting(objReq);
		
		return recList;
	}
	

	
}