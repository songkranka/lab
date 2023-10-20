package th.co.pt.ptgapp.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import th.co.pt.ptgapp.controller.bean.ModelStation;
import th.co.pt.ptgapp.controller.bean.SettingItemSpec;
import th.co.pt.ptgapp.service.report.dto.LTRSpec;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SettingItemSpecServiceDao {


    @Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<Map<String,Object>> getItemName(){
    	List<Map<String,Object>>resultList = new ArrayList<>();
    	StringBuilder sql = new StringBuilder();
    	try{
			sql.append(" SELECT ITEM_ID,ITEM_NAME,ITEM_UNIT FROM ASS_ITEM_MASTER  \n");
			logger.info(" sql : {} ",sql.toString());
			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			logger.info("resultList : {}",resultList.size());
			return resultList;
		}catch (Exception e){
    		logger.error("Exception : {}",e);
    		throw new RuntimeException(e.getMessage());
		}
	}

	public List<Map<String,Object>> getToolsMaster(){
		List<Map<String,Object>>resultList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		try{
			sql.append(" select TOOL_ID,TOOL_NAME from ASS_TOOL_MASTER WHERE IS_ENABLE='Y'  \n");
			logger.info(" sql : {} ",sql.toString());
			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			logger.info("resultList : {}",resultList.size());
			return resultList;
		}catch (Exception e){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}
	public List<Map<String,Object>> getGroup(){
		List<Map<String,Object>>resultList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		try{
			sql.append(" select USER_TYPE_ID,USER_TYPE_DTL from USER_TYPE  WHERE USER_TYPE_ID >'0006' \n");
			logger.info(" sql : {} ",sql.toString());
			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			logger.info("resultList : {}",resultList.size());
			return resultList;
		}catch (Exception e){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}
	public List<Map<String,Object>> getMethodMaster(){
		List<Map<String,Object>>resultList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		try{
			sql.append(" select METHOD_ID,METHOD_NAME from ASS_METHOD_MASTER WHERE IS_ENABLE='Y'  \n");
			logger.info(" sql : {} ",sql.toString());
			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			logger.info("resultList : {}",resultList.size());
			return resultList;
		}catch (Exception e){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}

	public List<Map<String,Object>> insertItemSpecAssign(SettingItemSpec settingItemSpec){
    	try {
    		List<Map<String,Object>> result = new ArrayList<>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("insertSpecAssign") ;
				logger.info("productIDStr : {}",settingItemSpec.getProductIDStr());
				logger.info("sampleTypeStr : {}",settingItemSpec.getSampleTypeStr());
				logger.info("itemId : {}",settingItemSpec.getItemIdStr());
				logger.info("methodStr : {}",settingItemSpec.getMethodStr());
				logger.info("toolsStr : {}",settingItemSpec.getToolsStr());
				logger.info("userGroupStr : {}",settingItemSpec.getUserGroupStr());
				logger.info("unitStr : {}",settingItemSpec.getUnitStr());
				logger.info("minStr : {}",settingItemSpec.getMinStr());
				logger.info("maxStr : {}",settingItemSpec.getMaxStr());
				logger.info("specTextStr : {}",settingItemSpec.getSpecTextStr());
				logger.info("inputTypeStr : {}",settingItemSpec.getInputTypeStr());
				logger.info("specRangStr : {}",settingItemSpec.getSpecRangStr());
				if("".equals(settingItemSpec.getToolsStr())){
					logger.info("toolsStr 1  : {}",settingItemSpec.getToolsStr());
				}else{
					logger.info("toolsStr 2  : {}","''");
				}


			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("productID",settingItemSpec.getProductIDStr(),Types.VARCHAR)
					.addValue("sampleTypeID",settingItemSpec.getSampleTypeStr(),Types.VARCHAR)
					.addValue("itemID",settingItemSpec.getItemIdStr(),Types.VARCHAR)
//					.addValue("unit",settingItemSpec.getUnitStr(),Types.VARCHAR)
					.addValue("methodID",settingItemSpec.getMethodStr(),Types.VARCHAR)
					.addValue("toolsID",settingItemSpec.getToolsStr() ==""?"''":settingItemSpec.getToolsStr(),Types.VARCHAR)
					.addValue("userGroupID",settingItemSpec.getUserGroupStr(),Types.VARCHAR)
					.addValue("specRange",settingItemSpec.getSpecRangStr(),Types.VARCHAR)
					.addValue("min",settingItemSpec.getMinStr()==""?',':settingItemSpec.getMinStr(),Types.VARCHAR)
					.addValue("max",settingItemSpec.getMaxStr()==""?',':settingItemSpec.getMaxStr(),Types.VARCHAR)
					.addValue("specText",settingItemSpec.getSpecTextStr(),Types.VARCHAR)
					.addValue("inputType",settingItemSpec.getInputTypeStr(),Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			logger.info("result : {}",result);
			return result;
		}catch (Exception e){
    		logger.error("Exception : {}",e);
    		throw new RuntimeException(e.getMessage());
		}
	}

	public List<Map<String, Object>> getLTRSpec(LTRSpec objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- GetLTRSpec ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getLTRSpec");
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("productId", objReq.getProduct_id(), Types.VARCHAR);

			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

			System.out.println(objReq);

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}
 
}
