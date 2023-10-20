package th.co.pt.ptgapp.service;

import java.util.List;
import java.util.Map;

import th.co.pt.ptgapp.controller.bean.MbStationMaster;

public interface UploadDataStationPTCService {

	public Map<String,Object>  importMasterStationPTC(List<MbStationMaster> list) throws Exception   ;
	
}
