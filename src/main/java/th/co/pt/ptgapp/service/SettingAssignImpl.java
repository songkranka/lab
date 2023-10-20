package th.co.pt.ptgapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.pt.ptgapp.controller.bean.SettingAssignObj;
import th.co.pt.ptgapp.dao.SettingAssignmentDao;

@Service("SettingAssignment")
public class SettingAssignImpl implements SettingAssignment{
	@Autowired
	private SettingAssignmentDao settingAssignmentDao;

	@Override
	public String updateSettingAssign(SettingAssignObj objReq) throws Exception{
		String updateAssign = settingAssignmentDao.updateSettingAssign(objReq);
		return updateAssign;
	}
	@Override
	public List<Map<String, Object>> getDropdownSettingAssign(SettingAssignObj objReq) throws Exception{
		List<Map<String, Object>> getDropdownAssign = settingAssignmentDao.getDropdownSettingAssign(objReq);
		return getDropdownAssign;
	}
	
}
