package th.co.pt.ptgapp.dao;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import th.co.pt.ptgapp.controller.bean.SettingAssignObj;
import th.co.pt.ptgapp.controller.bean.SettingRandomObj;

@Service
public class SettingAssignmentDao {

	 @Autowired
	 private JdbcTemplate jdbcTemplateSQLSERVER;
	 
	 public String updateSettingAssign(SettingAssignObj objReq) {
			String result =null,msg =null;
			
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("updateSettingAssignment") ;
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("asm_id",objReq.getASM_id(),Types.INTEGER)
					.addValue("asm_status",objReq.getASM_status(),Types.VARCHAR)
					.addValue("update_by",objReq.getUpdate_by(),Types.VARCHAR)
			      	.addValue("pResult",Types.VARCHAR)
			      	.addValue("pMessage",Types.VARCHAR);
			Map<String, Object> out = call.execute(in);
			result =(String)out.get("pResult");
			return result;
		}
	 public  List<Map<String, Object>> getDropdownSettingAssign(SettingAssignObj objReq) {
		 SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDropdownSettingAssign");
		 SqlParameterSource in = new MapSqlParameterSource().addValue("asm_id",objReq.getASM_id(),Types.VARCHAR);;
		 List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		 return list;
		 
	 }
}
