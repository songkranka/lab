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

import th.co.pt.ptgapp.controller.bean.SettingRandomLastObj;
import th.co.pt.ptgapp.utils.WebUtil;

@Service
public class SettingRandomLastDao {
	 @Autowired
	private PlatformTransactionManager txManager; 
 
    @Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    
    public List<Map<String, Object>>  inquirySettingRandomLast(SettingRandomLastObj objReq) throws Exception{
    	 
     
    	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("inquirySettingRandomLast") ; 
    	SqlParameterSource in = new MapSqlParameterSource().addValue("code",objReq.getCode(),Types.VARCHAR);
    	List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		
		return list;
    }
    
    public String insertSettingRandomLast(SettingRandomLastObj objReq)throws Exception{
    	
    	String result =null,msg =null;

    	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("insertSettingRandomLast") ;
    	SqlParameterSource in = new MapSqlParameterSource()
    	.addValue("simple_min",objReq.getSimple_min(),Types.FLOAT)
    	.addValue("simple_max",objReq.getSimple_max(),Types.FLOAT)
    	.addValue("green_cnt",objReq.getGreen_cnt(),Types.FLOAT)
    	.addValue("yellow_cnt",objReq.getYellow_cnt(),Types.FLOAT)
    	.addValue("red_cnt",objReq.getRed_cnt(),Types.FLOAT)
    	.addValue("yellow_pass",objReq.getYellow_pass(),Types.FLOAT)
      	.addValue("red_pass",objReq.getRed_pass(),Types.FLOAT)
      	.addValue("pResult",Types.VARCHAR)
      	.addValue("pMessage",Types.VARCHAR);
    	Map<String, Object> out = call.execute(in);
    	result =(String)out.get("pResult");
    	return result;
    }
    
public String deleteSettingRandomLast(SettingRandomLastObj objReq)throws Exception{
    	
    	String result =null,msg =null;
    	
    	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("deleteSettingRandomLast") ;
    	SqlParameterSource in = new MapSqlParameterSource().addValue("code",objReq.getCode(),Types.VARCHAR)
      	.addValue("pResult",Types.VARCHAR)
      	.addValue("pMessage",Types.VARCHAR);
    	Map<String, Object> out = call.execute(in);
    	result =(String)out.get("pResult");
    	return result;
    }

public String updateSettingRandomLast(SettingRandomLastObj objReq) {
	String result =null,msg =null;
	
	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("updateSettingRandomLast") ;
	SqlParameterSource in = new MapSqlParameterSource()
			.addValue("code",objReq.getCode(),Types.VARCHAR)
		  	.addValue("simple_min",objReq.getSimple_min(),Types.FLOAT)
	    	.addValue("simple_max",objReq.getSimple_max(),Types.FLOAT)
	    	.addValue("green_cnt",objReq.getGreen_cnt(),Types.FLOAT)
	    	.addValue("yellow_cnt",objReq.getYellow_cnt(),Types.FLOAT)
	    	.addValue("red_cnt",objReq.getRed_cnt(),Types.FLOAT)
	    	.addValue("yellow_pass",objReq.getYellow_pass(),Types.FLOAT)
	      	.addValue("red_pass",objReq.getRed_pass(),Types.FLOAT)
	      	.addValue("pResult",Types.VARCHAR)
	      	.addValue("pMessage",Types.VARCHAR);
	Map<String, Object> out = call.execute(in);
	result =(String)out.get("pResult");
	return result;
}

 
}
