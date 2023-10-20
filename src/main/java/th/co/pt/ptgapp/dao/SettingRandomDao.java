package th.co.pt.ptgapp.dao ;


import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import th.co.pt.ptgapp.controller.bean.SettingRandomObj;
import th.co.pt.ptgapp.utils.WebUtil;

@Service
public class SettingRandomDao {
	 @Autowired
	private PlatformTransactionManager txManager; 
 
    @Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    
    public List<Map<String, Object>>  inquerySettingRandom(SettingRandomObj objReq) throws Exception{
    	 
     
    	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("inquerySettingRandom") ; 
    	SqlParameterSource in = new MapSqlParameterSource().addValue("compname",objReq.getCompname(),Types.VARCHAR);
    	List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		
		return list;
    }
    
    public String insertSettingRandom(SettingRandomObj objReq)throws Exception{
    	
    	String result =null,msg =null;
    	
    	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("insertSettingRandom") ;
    	SqlParameterSource in = new MapSqlParameterSource()
    	.addValue("sample_cnt",objReq.getSample_cnt(),Types.FLOAT)
    	.addValue("random_percent",objReq.getRandom_percent(),Types.FLOAT)
    	.addValue("codcomp",objReq.getCodcomp(),Types.VARCHAR)
    	.addValue("compname",objReq.getCompname(),Types.VARCHAR)
    	.addValue("amt_perkilo",objReq.getAmt_perkilo(),Types.FLOAT)
    	.addValue("amt_pernighthotel",objReq.getAmt_pernighthotel(),Types.FLOAT)
      	.addValue("create_by",objReq.getCodeEmid(),Types.VARCHAR)
      	.addValue("pResult",Types.VARCHAR)
      	.addValue("pMessage",Types.VARCHAR);
    	Map<String, Object> out = call.execute(in);
    	result =(String)out.get("pResult");
    	return result;
    }
    
public String deleteSettingRandom(SettingRandomObj objReq)throws Exception{
    	
    	String result =null,msg =null;
    	
    	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("deleteSettingRandom") ;
    	SqlParameterSource in = new MapSqlParameterSource().addValue("code",objReq.getCode(),Types.VARCHAR)
      	.addValue("pResult",Types.VARCHAR)
      	.addValue("pMessage",Types.VARCHAR);
    	Map<String, Object> out = call.execute(in);
    	result =(String)out.get("pResult");
    	return result;
    }

public String updateSettingRandom(SettingRandomObj objReq) {
	String result =null,msg =null;
	
	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("updateSettingRandom") ;
	SqlParameterSource in = new MapSqlParameterSource()
			.addValue("code",objReq.getCode(),Types.VARCHAR)
			.addValue("compname",objReq.getCompname(),Types.VARCHAR)
			.addValue("sample_cnt",objReq.getSample_cnt(),Types.FLOAT)
	    	.addValue("random_percent",objReq.getRandom_percent(),Types.FLOAT)
	    	.addValue("amt_perkilo",objReq.getAmt_perkilo(),Types.FLOAT)
	    	.addValue("amt_pernighthotel",objReq.getAmt_pernighthotel(),Types.FLOAT)
	      	.addValue("update_by",objReq.getCodeEmid(),Types.VARCHAR)
	      	.addValue("pResult",Types.VARCHAR)
	      	.addValue("pMessage",Types.VARCHAR);
	Map<String, Object> out = call.execute(in);
	result =(String)out.get("pResult");
	return result;
}

 
}
