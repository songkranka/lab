package th.co.pt.ptgapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.pt.ptgapp.controller.bean.RandomMeter;
import th.co.pt.ptgapp.controller.bean.RandomPlantMeterEntity;
import th.co.pt.ptgapp.dao.RandomMeterDao;

@Service("RandomMeterSetupService")
public class RandomMeterSetupServiceImpl implements RandomMeterSetupService {
	
	@Autowired
	private RandomMeterDao meterDao;
	
	@Override
	public List<Map<String, Object>> fetchMeterForPlant(RandomMeter entity) throws Exception {
		return meterDao.viewMeter(entity);
	}

	@Override
	public Map<String, Object> saveMeterForPlant(RandomMeter entity) throws Exception {
		return meterDao.saveMeter(entity);
	}

	@Override
	public Map<String, Object> saveRandomMeter(List<RandomPlantMeterEntity> listEntity) throws Exception {
		return meterDao.saveRandomMeter(listEntity);
	}

	@Override
	public List<Map<String, Object>> fetchRandomMeter(RandomPlantMeterEntity entity) throws Exception {
		return meterDao.viewRandomMeterPlant(entity);
	}

	@Override
	public Map<String, Object> getCountActivateList(RandomPlantMeterEntity entity) throws Exception {
		return meterDao.countRandomMeterPlantList(entity);
	}

}
