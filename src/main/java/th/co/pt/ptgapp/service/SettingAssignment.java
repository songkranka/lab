package th.co.pt.ptgapp.service;

import java.util.List;
import java.util.Map;

import th.co.pt.ptgapp.controller.bean.SettingAssignObj;


public interface SettingAssignment {

	String updateSettingAssign(SettingAssignObj objReq) throws Exception;

	List<Map<String, Object>> getDropdownSettingAssign(SettingAssignObj objReq) throws Exception;

}
