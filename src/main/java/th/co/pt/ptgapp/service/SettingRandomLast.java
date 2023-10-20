package th.co.pt.ptgapp.service;

import java.util.List;
import java.util.Map;

import th.co.pt.ptgapp.controller.bean.SettingRandomLastObj;

public interface SettingRandomLast{
	
	List<Map<String,Object>> inquirySettingRandomLast(SettingRandomLastObj objReq) throws Exception;
	String insertSettingRandomLast(SettingRandomLastObj objReq) throws Exception;
	String deleteSettingRandomLast(SettingRandomLastObj objReq) throws Exception;
	String updateSettingRandomLast(SettingRandomLastObj objReq) throws Exception;
	
} 