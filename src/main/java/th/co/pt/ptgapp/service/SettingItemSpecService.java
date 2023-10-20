package th.co.pt.ptgapp.service;

import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.SettingItemSpec;
import th.co.pt.ptgapp.service.report.dto.LTRSpec;

import java.util.List;
import java.util.Map;

public interface SettingItemSpecService {
   
	public List<Map<String,Object>> getItemName();
	public List<Map<String,Object>> getMethodMaster();
	public List<Map<String,Object>> getToolsMaster();
	public List<Map<String,Object>> getGroup();
	public List<Map<String,Object>> insertItemSpecAssign(SettingItemSpec settingItemSpec);
 	public List<Map<String,Object>> getLTRSpec(LTRSpec reqObj);
}
