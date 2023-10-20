package th.co.pt.ptgapp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import th.co.pt.ptgapp.controller.bean.RandomMeter;
import th.co.pt.ptgapp.controller.bean.RandomPlantMeterEntity;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("RandomMeterDao")
public class RandomMeterDao {

	@Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<Map<String, Object>> viewMeter(RandomMeter entity) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		entity.setFlagAll((entity.getFlagAll()!=null)?entity.getFlagAll():"");

		
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("getMasterMeter") ;
		
		SqlParameterSource in = new MapSqlParameterSource()
			.addValue("plantId",entity.getDefaultPlant(),Types.VARCHAR)
			.addValue("flagAll",entity.getFlagAll(),Types.VARCHAR)
			.addValue("pResult",Types.VARCHAR)
			.addValue("pMessage",Types.VARCHAR);	
		
		result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		return result;
	}

	public Map<String,Object> saveMeter(RandomMeter entity) {

		
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("insertMasterMeter") ;
		
		SqlParameterSource in = new MapSqlParameterSource() 
			.addValue("meterNo",entity.getMeterNo(),Types.VARCHAR)
			.addValue("productId",entity.getProductId(),Types.VARCHAR)
			.addValue("plantId",entity.getPlantId(),Types.VARCHAR)
			.addValue("createBy",entity.getCreateBy(),Types.VARCHAR)
			
			.addValue("pResult",Types.VARCHAR)
			.addValue("pMessage",Types.VARCHAR);
			 
				
		Map<String, Object> out = call.execute(in);	
		String result =(String)out.get("pResult");
		String msg =(String)out.get("pMessage");
								
		return out;
	}
	public Map<String,Object>  saveRandomMeter(List<RandomPlantMeterEntity> listEntity) {
		logger.info("----- dao saveRandomMeter ------ ");
		
		RandomPlantMeterEntity En = new RandomPlantMeterEntity();
		En.setWorkMonth(listEntity.get(0).getWorkDtmDB().substring(0, 6));
		deleteRandomMeter(En);
		
		Map<String, Object> out = new HashMap<String, Object>();
		int sizeOfRow = listEntity.size();
		

		for ( RandomPlantMeterEntity entity : listEntity ) {

			
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("insertRandomMeterPlant") ;
			SqlParameterSource in = new MapSqlParameterSource() 
			.addValue("seq",entity.getSeq(),Types.VARCHAR)
			.addValue("workDtm",entity.getWorkDtmDB(),Types.NVARCHAR)
			
			//.addValue("meterNo",entity.getMeterNo(),Types.NVARCHAR)
			//.addValue("productId",entity.getProductId(),Types.NVARCHAR)
			//.addValue("plantId",entity.getPlantId(),Types.NVARCHAR)
			
			.addValue("createBy",entity.getCreateBy(),Types.VARCHAR)
			.addValue("updateBy",entity.getUpdateBy(),Types.VARCHAR)
			
			.addValue("pResult",Types.VARCHAR)
			.addValue("pMessage",Types.VARCHAR);	
			
			out = call.execute(in);	

			logger.info("   response : "+out.toString());
		}
		logger.info("  ");

								
		return out;		
	}

	public Map<String,Object>  deleteRandomMeter(RandomPlantMeterEntity entity) {
		Map<String, Object> out = new HashMap<String, Object>();

		logger.info("   workMonth >> "+entity.getWorkMonth());
		logger.info("  ");
		
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("deleteRandomMeterPlant") ;
		SqlParameterSource in = new MapSqlParameterSource() 
		.addValue("workMonth",entity.getWorkMonth(),Types.VARCHAR)
		
		.addValue("pResult",Types.VARCHAR)
		.addValue("pMessage",Types.VARCHAR);	
		
		out = call.execute(in);	
								
		return out;		
	}
	
	public Map<String,Object> countRandomMeterPlantList(RandomPlantMeterEntity entity) {
		Map<String, Object> out = new HashMap<String, Object>();
		

		
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("countRandomMeterPlant") ;
		
		SqlParameterSource in = new MapSqlParameterSource()
			.addValue("workMonth",entity.getWorkMonth(),Types.VARCHAR)
			.addValue("plantID",entity.getPlantId(),Types.VARCHAR)
			.addValue("pResult",Types.VARCHAR)
			.addValue("pMessage",Types.VARCHAR);	
		
		List<Map<String, Object>> listOut = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		out = listOut.get(0);

		
		return out;
	}
	
	public List<Map<String, Object>> viewRandomMeterPlant(RandomPlantMeterEntity entity) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		

		
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("inquiryRandomMeterPlant") ;
		
		SqlParameterSource in = new MapSqlParameterSource()
			.addValue("workMonth",entity.getWorkMonth(),Types.VARCHAR)
			.addValue("plantID",entity.getPlantId(),Types.VARCHAR)
			.addValue("pResult",Types.VARCHAR)
			.addValue("pMessage",Types.VARCHAR);	
		
		result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");		
		

		
		return result;
	}
}
