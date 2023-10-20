package th.co.pt.ptgapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.co.pt.ptgapp.controller.bean.SettingAssignObj;
import th.co.pt.ptgapp.controller.bean.SettingItemSpec;
import th.co.pt.ptgapp.dao.SettingAssignmentDao;
import th.co.pt.ptgapp.dao.SettingItemSpecServiceDao;
import th.co.pt.ptgapp.service.report.dto.LTRSpec;

import java.util.List;
import java.util.Map;

@Service("SettingItemSpecService")
public class SettingItemSpecServiceImpl implements SettingItemSpecService{
	@Autowired
	SettingItemSpecServiceDao settingItemSpecServiceDao;
	@Override
	public List<Map<String, Object>> getItemName() {
		return settingItemSpecServiceDao.getItemName();
	}

	@Override
	public List<Map<String, Object>> getMethodMaster() {
		return settingItemSpecServiceDao.getMethodMaster();
	}

	@Override
	public List<Map<String, Object>> getToolsMaster() {
		return settingItemSpecServiceDao.getToolsMaster();
	}

	@Override
	public List<Map<String, Object>> getGroup() {
		return settingItemSpecServiceDao.getGroup();
	}

	@Override
	public List<Map<String,Object>> insertItemSpecAssign(SettingItemSpec settingItemSpec) {
		return settingItemSpecServiceDao.insertItemSpecAssign(settingItemSpec);
	}

	@Override
	public List<Map<String, Object>> getLTRSpec(LTRSpec reqObj) {
		// TODO Auto-generated method stub
		return settingItemSpecServiceDao.getLTRSpec(reqObj);
	}
}
