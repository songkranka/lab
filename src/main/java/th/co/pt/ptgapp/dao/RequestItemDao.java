package th.co.pt.ptgapp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RequestItemDao {
	 
    @Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public Map<String, Object> getReqId (){
    	Map<String, Object> result = new HashMap<>();
    	
    	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("getWFItemRequestId");

    	SqlParameterSource in = new MapSqlParameterSource();
    	
    	List<Map<String, Object>> listOut = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		result = listOut.get(0);
		
    	return result;
    }
    
    public Map<String, Object> getDtlNo(){
    	Map<String, Object> result = new HashMap<>();
    	
    	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("getWFItemDtlNo");

    	SqlParameterSource in = new MapSqlParameterSource();
    	
    	List<Map<String, Object>> listOut = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		result = listOut.get(0);
		
    	return result;
    }

	public Map<String, Object> insertWFItemRequest(Map<String, Object> wfItemHead) {

		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("insertWFItemRequest") ;
		
		SqlParameterSource in = new MapSqlParameterSource() 
				.addValue("reqId",wfItemHead.get("reqId"),Types.VARCHAR)
				.addValue("productCode",wfItemHead.get("prodCode"),Types.VARCHAR)
				.addValue("sampleType",wfItemHead.get("samType"),Types.VARCHAR)
				.addValue("stsCode",wfItemHead.get("stsCode"),Types.VARCHAR)
				.addValue("wfid",wfItemHead.get("wfid"),Types.VARCHAR)
				.addValue("msg",wfItemHead.get("msg"),Types.VARCHAR)
				.addValue("remark",wfItemHead.get("remark"),Types.VARCHAR)
				.addValue("reqBy",wfItemHead.get("reqBy"),Types.VARCHAR)
			
			.addValue("pResult",Types.VARCHAR)
			.addValue("pMessage",Types.VARCHAR);
			 
				
		Map<String, Object> out = call.execute(in);	
		String result =(String)out.get("pResult");
		String msg =(String)out.get("pMessage");
		
		return out;
	}

	public  Map<String, Object> insertWFItemRequestDtl(Map<String, Object> wfItemDtl) {

		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("insertWFItemRequestDtl") ;
		
		SqlParameterSource in = new MapSqlParameterSource() 
				.addValue("reqId",wfItemDtl.get("reqid"),Types.VARCHAR)
				.addValue("reqDtlNo",wfItemDtl.get("dtlno"),Types.VARCHAR)
				
				.addValue("analyzeCode",wfItemDtl.get("anaC"),Types.VARCHAR)
				.addValue("analyzeValue",wfItemDtl.get("anaV"),Types.VARCHAR)
				.addValue("materialCode",wfItemDtl.get("matC"),Types.VARCHAR)
				.addValue("materialValue",wfItemDtl.get("matV"),Types.VARCHAR)
				.addValue("methodCode",wfItemDtl.get("metC"),Types.VARCHAR)
				.addValue("methodValue",wfItemDtl.get("metV"),Types.VARCHAR)
				.addValue("specCode",wfItemDtl.get("specC"),Types.VARCHAR)
				.addValue("specValue",wfItemDtl.get("specV"),Types.VARCHAR)
				.addValue("spec2Code",wfItemDtl.get("specC2"),Types.VARCHAR)
				.addValue("spec2Value",wfItemDtl.get("specV2"),Types.VARCHAR)
				.addValue("unitCode",wfItemDtl.get("unitC"),Types.VARCHAR)
				.addValue("unitValue",wfItemDtl.get("unitV"),Types.VARCHAR)
				
				.addValue("reqBy",wfItemDtl.get("reqBy"),Types.VARCHAR)
			
			.addValue("pResult",Types.VARCHAR)
			.addValue("pMessage",Types.VARCHAR);
			 
				
		Map<String, Object> out = call.execute(in);	
		String result =(String)out.get("pResult");
		String msg =(String)out.get("pMessage");
		
		return out;
	}

	public Map<String, Object>  insertWFItemRequestWorkGroup(Map<String, Object> wfWorkGroup) {

		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("insertWFItemRequestWorkGroup") ;
		
		SqlParameterSource in = new MapSqlParameterSource() 
				.addValue("reqDtlNo",wfWorkGroup.get("dtlno"),Types.VARCHAR)
				.addValue("memberType",wfWorkGroup.get("mType"),Types.VARCHAR)
				.addValue("empId",wfWorkGroup.get("empId"),Types.VARCHAR)
				.addValue("empName",wfWorkGroup.get("empName"),Types.VARCHAR)
				.addValue("reqBy",wfWorkGroup.get("reqBy"),Types.VARCHAR)
			.addValue("pResult",Types.VARCHAR)
			.addValue("pMessage",Types.VARCHAR);
			 
		Map<String, Object> out = call.execute(in);	
		String result =(String)out.get("pResult");
		String msg =(String)out.get("pMessage");
		
		return out;
	}

}
