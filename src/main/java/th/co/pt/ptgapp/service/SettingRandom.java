package th.co.pt.ptgapp.service;

import java.util.List;
import java.util.Map;

import th.co.pt.ptgapp.controller.bean.SettingRandomObj;

public interface SettingRandom{
	
	List<Map<String,Object>> inquerySettingRandom(SettingRandomObj objReq) throws Exception;
	String insertSettingRandom(SettingRandomObj objReq) throws Exception;
	String deleteSettingRandom(SettingRandomObj objReq) throws Exception;
	String updateSettingRandom(SettingRandomObj objReq) throws Exception;
	
} 