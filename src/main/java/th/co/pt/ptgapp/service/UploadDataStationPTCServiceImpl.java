package th.co.pt.ptgapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.pt.ptgapp.controller.bean.MbStationMaster;
import th.co.pt.ptgapp.dao.UploadDataStationPTCDao;

@Service("UploadDataStationPTCService")
public class UploadDataStationPTCServiceImpl implements UploadDataStationPTCService {

	@Autowired
	UploadDataStationPTCDao uploadDataStationPTCDao;
	
	@Override
	public Map<String, Object> importMasterStationPTC(List<MbStationMaster> list) throws Exception {
		return uploadDataStationPTCDao.importMasterStationPTC(list);
		//return uploadDataStationPTCDao.importMasterStationPTC_ps(list);
	}

}
