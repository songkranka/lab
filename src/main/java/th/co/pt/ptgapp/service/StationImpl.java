package th.co.pt.ptgapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.pt.ptgapp.controller.bean.ModelStation;
import th.co.pt.ptgapp.dao.StationServiceDao;

@Service("StationService")
public class StationImpl implements StationService {
	
	@Autowired
	private StationServiceDao stationservicedao;
	
	@Override
	public String updateModel(ModelStation objReq) throws Exception {
		
		System.out.println("=================update_Model Service====================");
		
		String recList = stationservicedao.updateModelStation(objReq);
		
		return recList;
	}

}
