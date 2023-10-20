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

import th.co.pt.ptgapp.controller.bean.TestscoreObj;
import th.co.pt.ptgapp.utils.WebUtil;

@Service
public class TestScoreDao {
	 @Autowired
	private PlatformTransactionManager txManager; 
 
    @Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    
    public List<Map<String, Object>>  inqueryListscore(TestscoreObj objReq) throws Exception{
    	 
     
    	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("inqueryListscore") ; 
    	SqlParameterSource in = new MapSqlParameterSource().addValue("lab_check_comp",objReq.getLab_check_comp(),Types.VARCHAR);
    	List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		
		return list;
    }
    
    public String insertTestscore(TestscoreObj objReq)throws Exception{
    	
    	String result =null,msg =null;
    	
    	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("insertTestscore") ;
    	SqlParameterSource in = new MapSqlParameterSource().addValue("lab_check_comp",objReq.getLab_check_comp(),Types.VARCHAR)
    	.addValue("general_min",objReq.getGeneral_min(),Types.FLOAT)
    	.addValue("general_max",objReq.getGeneral_max(),Types.FLOAT)
    	.addValue("api_min",objReq.getApi_min(),Types.FLOAT)
    	.addValue("api_max",objReq.getApi_max(),Types.FLOAT)
    	.addValue("ethanol_min",objReq.getEthanol_min(),Types.FLOAT)
    	.addValue("ethanol_max",objReq.getEthanol_max(),Types.FLOAT)
      	.addValue("create_by",objReq.getCodeEmid(),Types.VARCHAR)
      	.addValue("pResult",Types.VARCHAR)
      	.addValue("pMessage",Types.VARCHAR);
    	Map<String, Object> out = call.execute(in);
    	result =(String)out.get("pResult");
    	return result;
    }
    
public String deleteTestcore(TestscoreObj objReq)throws Exception{
    	
    	String result =null,msg =null;
    	
    	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("deleteTestscore") ;
    	SqlParameterSource in = new MapSqlParameterSource().addValue("lab_check_comp",objReq.getLab_check_comp(),Types.VARCHAR)
      	.addValue("pResult",Types.VARCHAR)
      	.addValue("pMessage",Types.VARCHAR);
    	Map<String, Object> out = call.execute(in);
    	result =(String)out.get("pResult");
    	return result;
    }

public String updateTestscore(TestscoreObj objReq) {
	String result =null,msg =null;
	
	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("updateTestscore") ;
	SqlParameterSource in = new MapSqlParameterSource().addValue("lab_check_comp",objReq.getLab_check_comp(),Types.VARCHAR)
	    	.addValue("general_min",objReq.getGeneral_min(),Types.FLOAT)
	    	.addValue("general_max",objReq.getGeneral_max(),Types.FLOAT)
	    	.addValue("api_min",objReq.getApi_min(),Types.FLOAT)
	    	.addValue("api_max",objReq.getApi_max(),Types.FLOAT)
	    	.addValue("ethanol_min",objReq.getEthanol_min(),Types.FLOAT)
	    	.addValue("ethanol_max",objReq.getEthanol_max(),Types.FLOAT)
	      	.addValue("update_by",objReq.getCodeEmid(),Types.VARCHAR)
	      	.addValue("pResult",Types.VARCHAR)
	      	.addValue("pMessage",Types.VARCHAR);
	Map<String, Object> out = call.execute(in);
	result =(String)out.get("pResult");
	return result;
}

 
}
