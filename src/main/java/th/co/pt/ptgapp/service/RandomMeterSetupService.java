package th.co.pt.ptgapp.service;

import java.util.List;
import java.util.Map;

import th.co.pt.ptgapp.controller.bean.RandomMeter;
import th.co.pt.ptgapp.controller.bean.RandomPlantMeterEntity;

public interface RandomMeterSetupService {
	public List<Map<String, Object>>  fetchMeterForPlant(RandomMeter entity) throws Exception   ;
	public List<Map<String, Object>>  fetchRandomMeter(RandomPlantMeterEntity entity) throws Exception   ;
	public Map<String,Object>  saveMeterForPlant(RandomMeter entity) throws Exception   ;
	public Map<String,Object>  saveRandomMeter(List<RandomPlantMeterEntity> listEntity) throws Exception   ;
	public Map<String,Object>  getCountActivateList(RandomPlantMeterEntity entity) throws Exception   ;
	
}
