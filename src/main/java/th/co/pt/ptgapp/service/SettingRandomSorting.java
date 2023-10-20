package th.co.pt.ptgapp.service;

import java.util.List;
import java.util.Map;

import th.co.pt.ptgapp.controller.bean.SettingRandomSortingObj;

public interface SettingRandomSorting{
	
	List<Map<String,Object>> inquirySettingRandomSorting(SettingRandomSortingObj objReq) throws Exception;
	String insertSettingRandomSorting(SettingRandomSortingObj objReq) throws Exception;
	String deleteSettingRandomSorting(SettingRandomSortingObj objReq) throws Exception;
	String updateSettingRandomSorting(SettingRandomSortingObj objReq) throws Exception;
	
} 