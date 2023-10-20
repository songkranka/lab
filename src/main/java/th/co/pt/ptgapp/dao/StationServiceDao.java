package th.co.pt.ptgapp.dao ;


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

import java.sql.Types;
import java.util.Map;

@Service
public class StationServiceDao {
	 @Autowired
	private PlatformTransactionManager txManager; 
 
    @Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


public String updateModelStation(ModelStation objReq) {
	String result =null,msg =null;

	
	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("updateModelStation") ;
	SqlParameterSource in = new MapSqlParameterSource().addValue("costcenter",objReq.getCostcenter(),Types.VARCHAR)
	    	.addValue("grad",objReq.getGrad(),Types.VARCHAR)
	    	.addValue("createBy",objReq.getCreateBy(),Types.VARCHAR)
	      	.addValue("pResult",Types.VARCHAR)
	      	.addValue("pMessage",Types.VARCHAR);
	Map<String, Object> out = call.execute(in);
	result =(String)out.get("pResult");
	return result;
}

 
}
