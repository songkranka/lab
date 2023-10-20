package th.co.pt.ptgapp.dao;

import java.sql.Types;
import java.util.ArrayList;
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

import th.co.pt.ptgapp.controller.bean.ReportInfoEntity;
import th.co.pt.ptgapp.controller.bean.report.MbServiceStationEntity;

@Service
public class ReportDao {
	@Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public Map<String, Object> getReportInfo(ReportInfoEntity entity) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("getReportInfo") ;
		
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("reportno",entity.getReportNo(),Types.VARCHAR);
		
		List<Map<String, Object>> listOut = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		result = listOut.get(0);
		
		return result;
	}
	
	public List<Map<String, Object>> getRptMbServiceStation(MbServiceStationEntity entity){
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("getRptMbServiceStation") ;
		
		SqlParameterSource in = new MapSqlParameterSource()
			.addValue("tripId",entity.getMb_trip_id(),Types.VARCHAR)
			.addValue("reportID", entity.getReportID(),Types.VARCHAR)
			.addValue("reportNo", entity.getReportNo(),Types.VARCHAR)
			.addValue("requestBy", entity.getRequestBy(),Types.VARCHAR);	
		
		result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		
		return result;
	}
	
	public Map<String, Object> pushReportTransaction(Map<String, Object> obj) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		logger.info("dao pushReportTransaction print param : "+obj.toString());
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("insertReportTransaction") ;
		SqlParameterSource in = new MapSqlParameterSource() 
				.addValue("reportId",obj.get("reportId"),Types.VARCHAR)
				.addValue("reportNo",obj.get("reportNo"),Types.VARCHAR)
				.addValue("reportFileType",obj.get("reportFileType"),Types.VARCHAR)
				.addValue("reportParam",obj.get("reportParam"),Types.VARCHAR)
				.addValue("createBy",obj.get("createBy"),Types.VARCHAR)
				
				.addValue("pResult",Types.VARCHAR)
				.addValue("pMessage",Types.VARCHAR);
		
		result = call.execute(in);	
		return result;
	}
	
	public List<Object> getInquiryyear(){
		List<Object> result = new ArrayList<>();
		
		logger.info("dao Report SUM : ");
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getYearMakeReport") ;
		try{
			//result.put("Data",call.execute());
			result.add(call.execute().get("#result-set-1"));
			
		}catch (Exception e) {
			result.add(call.execute());
		}
		
		return result;
	}
	
}
