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

import th.co.pt.ptgapp.controller.bean.SettingRandomSortingObj;
import th.co.pt.ptgapp.utils.WebUtil;

@Service
public class SettingRandomSortingDao {
	 @Autowired
	private PlatformTransactionManager txManager; 
 
    @Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    
    public List<Map<String, Object>>  inquirySettingRandomSorting(SettingRandomSortingObj objReq) throws Exception{
    	 
     
    	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("inquirySettingRandomSorting") ; 
    	SqlParameterSource in = new MapSqlParameterSource().addValue("compname",objReq.getCompname(),Types.VARCHAR);
    	List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		
		return list;
    }
    
    public String insertSettingRandomSorting(SettingRandomSortingObj objReq)throws Exception{
    	
    	String result =null,msg =null;
    	
    	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("insertSettingRandomSorting") ;
    	SqlParameterSource in = new MapSqlParameterSource()
    	.addValue("codcomp",objReq.getCodcomp(),Types.VARCHAR)
    	.addValue("compname",objReq.getCompname(),Types.VARCHAR)
    	.addValue("cretiria_name",objReq.getCretiria_name(),Types.VARCHAR)
    	.addValue("seq",objReq.getSeq(),Types.FLOAT)
      	.addValue("create_by",objReq.getCodeEmid(),Types.VARCHAR)
      	.addValue("pResult",Types.VARCHAR)
      	.addValue("pMessage",Types.VARCHAR);
    	Map<String, Object> out = call.execute(in);
    	result =(String)out.get("pResult");
    	return result;
    }
    
public String deleteSettingRandomSorting(SettingRandomSortingObj objReq)throws Exception{
    	
    	String result =null,msg =null;
    	
    	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("deleteSettingRandomSorting") ;
    	SqlParameterSource in = new MapSqlParameterSource().addValue("cretiria_code",objReq.getCretiria_code(),Types.VARCHAR)
      	.addValue("pResult",Types.VARCHAR)
      	.addValue("pMessage",Types.VARCHAR);
    	Map<String, Object> out = call.execute(in);
    	result =(String)out.get("pResult");
    	return result;
    }

public String updateSettingRandomSorting(SettingRandomSortingObj objReq) {
	String result =null,msg =null;
	
	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("updateSettingRandomSorting") ;
	SqlParameterSource in = new MapSqlParameterSource()
			.addValue("cretiria_code",objReq.getCretiria_code(),Types.VARCHAR)
	    	.addValue("compname",objReq.getCompname(),Types.VARCHAR)
	    	.addValue("cretiria_name",objReq.getCretiria_name(),Types.VARCHAR)
	    	.addValue("seq",objReq.getSeq(),Types.FLOAT)
	      	.addValue("update_by",objReq.getCodeEmid(),Types.VARCHAR)
	      	.addValue("pResult",Types.VARCHAR)
	      	.addValue("pMessage",Types.VARCHAR);
	Map<String, Object> out = call.execute(in);
	result =(String)out.get("pResult");
	return result;
}

 
}
