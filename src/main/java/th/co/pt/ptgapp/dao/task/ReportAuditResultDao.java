package th.co.pt.ptgapp.dao.task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import th.co.pt.ptgapp.utils.DateUtil;

@Repository
public class ReportAuditResultDao {

	@Autowired
    private NamedParameterJdbcTemplate npJdbcTemplate;
	
    @Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;

	
	public List<ReportAuditResultDto> getAuditResultAll(String typeStation,String sDate,String eDate,String trip) {
        Date startDate = DateUtil.stringTodate(sDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        Date endDate = DateUtil.stringTodate(eDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("V_FROM_CREATE_DATE",startDate);
        parameters.addValue("V_TO_CREATE_DATE",endDate);
        parameters.addValue("V_TYPE_STATION",typeStation);
        if(!trip.equals("0")) {
            parameters.addValue("V_TRIP_ID",trip);
        }
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT PR.PLANT_RECEIVE_NAMEEN as PLANT_RECEIVE, COUNT(1) AS TOTALS ");
        sql.append(" FROM MB_ACTION_PLAN_HD APH ");
        sql.append("    LEFT JOIN MB_ACTION_PLAN_DT APD ON APD.TRIP_ID = APH.TRIP_ID ");
        sql.append("    LEFT JOIN MB_STATION_MASTER SM ON SM.COST_CENTER = APD.COST_CENTER ");
        sql.append("     JOIN (SELECT LHD.PLAN_DT_ID FROM MB_LTR_HD LHD ");
        sql.append("    		WHERE LHD.CREATE_DATE BETWEEN :V_FROM_CREATE_DATE ");
        sql.append("    		AND DATEADD(DAY, 1, :V_TO_CREATE_DATE) group by LHD.PLAN_DT_ID) LH on LH.PLAN_DT_ID = APD.PLAN_DT_ID");
        sql.append("    LEFT JOIN MB_LAB_MPTOOLS LMT ON LMT.PLAN_DT_ID = APD.PLAN_DT_ID ");
        sql.append("    LEFT JOIN MB_PLANT_RECEIVE PR ON PR.PLANT_RECEIVE_NAMETH LIKE '%' + SM.PLANT_RECEIVE + '%' ");
        sql.append(" WHERE 1=1 ");
//        sql.append("    AND LH.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_CREATE_DATE)) ");
        //sql.append("    AND SM.PLANT_RECEIVE IS NOT NULL ");
        sql.append("    AND SM.TYPE_STATION =:V_TYPE_STATION ");
        if(!trip.equals("0")) {
            sql.append("    AND APD.TRIP_ID =:V_TRIP_ID ");
        }
        sql.append(" GROUP BY PR.PLANT_RECEIVE_NAMEEN ");
        List<ReportAuditResultDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportAuditResultDto>() {
            @Override
            public ReportAuditResultDto mapRow(ResultSet resultSet, int i) throws SQLException {
            	return toDto(resultSet);
            }
        });
        List<ReportAuditResultDto> plist = getStation(typeStation);
        List<ReportAuditResultDto> pTemp = new ArrayList<>();
        for(ReportAuditResultDto a : plist){
            pTemp = list.stream()
                    .filter(e->e.getStationType().equalsIgnoreCase(a.getStationType()))
                    .collect(Collectors.toList());
            if(pTemp.isEmpty()){
                list.add(a);
            }
        }
        return list;
    }
	
	public List<ReportAuditResultDto> getAuditResultN(String typeStation,String sDate,String eDate,String trip) {
        Date startDate = DateUtil.stringTodate(sDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        Date endDate = DateUtil.stringTodate(eDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("V_FROM_CREATE_DATE",startDate);
        parameters.addValue("V_TO_CREATE_DATE",endDate);
        parameters.addValue("V_TYPE_STATION",typeStation);
        if(!trip.equals("0")) {
            parameters.addValue("V_TRIP_ID",trip);
        }
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT PR.PLANT_RECEIVE_NAMEEN as PLANT_RECEIVE, COUNT(1) AS TOTALS ");
        sql.append(" FROM MB_ACTION_PLAN_HD APH ");
        sql.append("    LEFT JOIN MB_ACTION_PLAN_DT APD ON APD.TRIP_ID = APH.TRIP_ID ");
        sql.append("    LEFT JOIN MB_STATION_MASTER SM ON SM.COST_CENTER = APD.COST_CENTER ");
        sql.append("     JOIN (SELECT LHD.PLAN_DT_ID FROM MB_LTR_HD LHD ");
        sql.append("    		WHERE LHD.CREATE_DATE BETWEEN :V_FROM_CREATE_DATE ");
        sql.append("    		AND DATEADD(DAY, 1, :V_TO_CREATE_DATE) group by LHD.PLAN_DT_ID) LH on LH.PLAN_DT_ID = APD.PLAN_DT_ID");
        sql.append("    LEFT JOIN MB_LAB_MPTOOLS LMT ON LMT.PLAN_DT_ID = APD.PLAN_DT_ID ");
        sql.append("    LEFT JOIN MB_PLANT_RECEIVE PR ON PR.PLANT_RECEIVE_NAMETH LIKE '%' + SM.PLANT_RECEIVE + '%' ");
        sql.append(" WHERE 1=1 ");
//        sql.append("    AND LH.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_CREATE_DATE)) ");
//        sql.append("    AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_CREATE_DATE))) ");
        //sql.append("    AND SM.PLANT_RECEIVE IS NOT NULL ");
        sql.append("    AND SM.TYPE_STATION =:V_TYPE_STATION ");
        if(!trip.equals("0")) {
            sql.append("    AND APD.TRIP_ID =:V_TRIP_ID ");
        }
        sql.append("     AND LMT.CHECK_FLG = 'N' ");
        sql.append(" GROUP BY PR.PLANT_RECEIVE_NAMEEN ");
        List<ReportAuditResultDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportAuditResultDto>() {
            @Override
            public ReportAuditResultDto mapRow(ResultSet resultSet, int i) throws SQLException {
            	return toDto(resultSet);
            }
        });
        List<ReportAuditResultDto> plist = getStation(typeStation);
        List<ReportAuditResultDto> pTemp = new ArrayList<>();
        for(ReportAuditResultDto a : plist){
            pTemp = list.stream()
                    .filter(e->e.getStationType().equalsIgnoreCase(a.getStationType()))
                    .collect(Collectors.toList());
            if(pTemp.isEmpty()){
                list.add(a);
            }
        }
        return list;
    }

	
	public List<ReportAuditResultDto> getAuditResultAllStation(String typeStation,String sDate,String eDate,String trip) {
        Date startDate = DateUtil.stringTodate(sDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        Date endDate = DateUtil.stringTodate(eDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("V_FROM_CREATE_DATE",startDate);
        parameters.addValue("V_TO_CREATE_DATE",endDate);
        parameters.addValue("V_TYPE_STATION",typeStation);
        if(!trip.equals("0")) {
            parameters.addValue("V_TRIP_ID",trip);
        }
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT PR.PLANT_RECEIVE_NAMEEN as PLANT_RECEIVE, COUNT(1) AS TOTALS ");
        sql.append(" FROM MB_ACTION_PLAN_HD APH ");
        sql.append("     JOIN MB_ACTION_PLAN_DT APD ON APD.TRIP_ID = APH.TRIP_ID ");
        sql.append("     JOIN MB_STATION_MASTER SM ON SM.COST_CENTER = APD.COST_CENTER ");
        sql.append("     JOIN (SELECT LHD.PLAN_DT_ID FROM MB_LTR_HD LHD ");
        sql.append("    		WHERE LHD.CREATE_DATE BETWEEN :V_FROM_CREATE_DATE ");
        sql.append("    		AND DATEADD(DAY, 1, :V_TO_CREATE_DATE) group by LHD.PLAN_DT_ID) LH on LH.PLAN_DT_ID = APD.PLAN_DT_ID");
        sql.append("     JOIN MB_PLANT_RECEIVE PR ON PR.PLANT_RECEIVE_NAMETH LIKE '%' + SM.PLANT_RECEIVE + '%' ");
        sql.append(" WHERE 1=1 ");
//        sql.append("    AND LH.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_CREATE_DATE)) ");
//        sql.append("    AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_CREATE_DATE))) ");
        
        //sql.append("    AND SM.PLANT_RECEIVE IS NOT NULL ");
        sql.append("    AND SM.TYPE_STATION =:V_TYPE_STATION ");
        if(!trip.equals("0")) {
            sql.append("    AND APD.TRIP_ID =:V_TRIP_ID ");
        }
        sql.append(" GROUP BY PR.PLANT_RECEIVE_NAMEEN ");
        List<ReportAuditResultDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportAuditResultDto>() {
            @Override
            public ReportAuditResultDto mapRow(ResultSet resultSet, int i) throws SQLException {
            	return toDto(resultSet);
            }
        });
        List<ReportAuditResultDto> plist = getStation(typeStation);
        List<ReportAuditResultDto> pTemp = new ArrayList<>();
        for(ReportAuditResultDto a : plist){
            pTemp = list.stream()
                    .filter(e->e.getStationType().equalsIgnoreCase(a.getStationType()))
                    .collect(Collectors.toList());
            if(pTemp.isEmpty()){
                list.add(a);
            }
        }
        return list;
    }
	
	public List<ReportAuditResultDto> getAuditResultLiter(String typeStation,String sDate,String eDate,String trip) {
        Date startDate = DateUtil.stringTodate(sDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        Date endDate = DateUtil.stringTodate(eDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("V_FROM_CREATE_DATE",startDate);
        parameters.addValue("V_TO_CREATE_DATE",endDate);
        parameters.addValue("V_TYPE_STATION",typeStation);
        if(!trip.equals("0")) {
            parameters.addValue("V_TRIP_ID",trip);
        }
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT PR.PLANT_RECEIVE_NAMEEN as PLANT_RECEIVE, COUNT(1) AS TOTALS ");
        sql.append(" FROM MB_ACTION_PLAN_HD APH ");
        sql.append("     JOIN MB_ACTION_PLAN_DT APD ON APD.TRIP_ID = APH.TRIP_ID ");
        sql.append("     JOIN MB_STATION_MASTER SM ON SM.COST_CENTER = APD.COST_CENTER ");
        sql.append("     JOIN (SELECT LHD.PLAN_DT_ID FROM MB_LTR_HD LHD ");
        sql.append("    		WHERE LHD.CREATE_DATE BETWEEN :V_FROM_CREATE_DATE ");
        sql.append("    		AND DATEADD(DAY, 1, :V_TO_CREATE_DATE) group by LHD.PLAN_DT_ID) LH on LH.PLAN_DT_ID = APD.PLAN_DT_ID");
        sql.append("     JOIN MB_LAB_CHECK LC ON LC.PLAN_DT_ID = APD.PLAN_DT_ID ");
        sql.append("     JOIN MB_PLANT_RECEIVE PR ON PR.PLANT_RECEIVE_NAMETH LIKE '%' + SM.PLANT_RECEIVE + '%' ");
        sql.append(" WHERE 1=1 ");
//        sql.append("    AND LH.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_CREATE_DATE)) ");
//        sql.append("    AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_CREATE_DATE))) ");
        //sql.append("    AND SM.PLANT_RECEIVE IS NOT NULL ");
        sql.append("    AND SM.TYPE_STATION =:V_TYPE_STATION ");
        if(!trip.equals("0")) {
            sql.append("    AND APD.TRIP_ID =:V_TRIP_ID ");
        }
        sql.append("     AND LC.CHECK_LITER_DATE IS NOT NULL ");
        sql.append(" GROUP BY PR.PLANT_RECEIVE_NAMEEN ");
        List<ReportAuditResultDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportAuditResultDto>() {
            @Override
            public ReportAuditResultDto mapRow(ResultSet resultSet, int i) throws SQLException {
            	return toDto(resultSet);
            }
        });
        List<ReportAuditResultDto> plist = getStation(typeStation);
        List<ReportAuditResultDto> pTemp = new ArrayList<>();
        for(ReportAuditResultDto a : plist){
            pTemp = list.stream()
                    .filter(e->e.getStationType().equalsIgnoreCase(a.getStationType()))
                    .collect(Collectors.toList());
            if(pTemp.isEmpty()){
                list.add(a);
            }
        }
        return list;
    }
 
	public List<ReportAuditResultDto> getAuditResultScore(String typeStation,String sDate,String eDate,String trip) {
        Date startDate = DateUtil.stringTodate(sDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        Date endDate = DateUtil.stringTodate(eDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("V_FROM_CREATE_DATE",startDate);
        parameters.addValue("V_TO_CREATE_DATE",endDate);
        parameters.addValue("V_TYPE_STATION",typeStation);
        if(!trip.equals("0")) {
            parameters.addValue("V_TRIP_ID",trip);
        }
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT PR.PLANT_RECEIVE_NAMEEN as PLANT_RECEIVE, COUNT(1) AS TOTALS ");
        sql.append(" FROM MB_ACTION_PLAN_HD APH ");
        sql.append("     JOIN MB_ACTION_PLAN_DT APD ON APD.TRIP_ID = APH.TRIP_ID ");
        sql.append("     JOIN MB_STATION_MASTER SM ON SM.COST_CENTER = APD.COST_CENTER ");
        sql.append("     JOIN (SELECT LHD.PLAN_DT_ID FROM MB_LTR_HD LHD ");
        sql.append("    		WHERE LHD.CREATE_DATE BETWEEN :V_FROM_CREATE_DATE ");
        sql.append("    		AND DATEADD(DAY, 1, :V_TO_CREATE_DATE) group by LHD.PLAN_DT_ID) LH on LH.PLAN_DT_ID = APD.PLAN_DT_ID");
        sql.append("     JOIN MB_LAB_SCORE LS ON LS.PLAN_DT_ID = APD.PLAN_DT_ID ");
        sql.append("     JOIN MB_PLANT_RECEIVE PR ON PR.PLANT_RECEIVE_NAMETH LIKE '%' + SM.PLANT_RECEIVE + '%' ");
        sql.append(" WHERE 1=1 ");
//        sql.append("    AND LH.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_CREATE_DATE)) ");
//        sql.append("    AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_CREATE_DATE))) ");
        //sql.append("    AND SM.PLANT_RECEIVE IS NOT NULL ");
        sql.append("    AND SM.TYPE_STATION =:V_TYPE_STATION ");
        if(!trip.equals("0")) {
            sql.append("    AND APD.TRIP_ID =:V_TRIP_ID ");
        }
        sql.append("     AND (LS.GENERAL IS NOT NULL ");
        sql.append("     OR LS.API IS NOT NULL ");
        sql.append("     OR LS.ETHANOL IS NOT NULL) ");
        sql.append(" GROUP BY PR.PLANT_RECEIVE_NAMEEN ");
        List<ReportAuditResultDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportAuditResultDto>() {
            @Override
            public ReportAuditResultDto mapRow(ResultSet resultSet, int i) throws SQLException {
            	return toDto(resultSet);
            }
        });
        List<ReportAuditResultDto> plist = getStation(typeStation);
        List<ReportAuditResultDto> pTemp = new ArrayList<>();
        for(ReportAuditResultDto a : plist){
            pTemp = list.stream()
                    .filter(e->e.getStationType().equalsIgnoreCase(a.getStationType()))
                    .collect(Collectors.toList());
            if(pTemp.isEmpty()){
                list.add(a);
            }
        }
        return list;
    }
 
 	public List<ReportAuditResultDto> getStation(String typeStation) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("V_TYPE_STATION",typeStation);
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT PR.PLANT_RECEIVE_NAMEEN as PLANT_RECEIVE,'0' AS TOTALS ");
        sql.append(" FROM MB_STATION_MASTER SM ");
        sql.append(" LEFT JOIN MB_PLANT_RECEIVE PR ON PR.PLANT_RECEIVE_NAMETH LIKE '%' + SM.PLANT_RECEIVE + '%' ");
        sql.append(" WHERE SM.TYPE_STATION =:V_TYPE_STATION ");
        sql.append(" GROUP BY PR.PLANT_RECEIVE_NAMEEN ");
        List<ReportAuditResultDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportAuditResultDto>() {
            @Override
            public ReportAuditResultDto mapRow(ResultSet resultSet, int i) throws SQLException {
            	return toDto(resultSet);
            }
        });

        return list;
    }
 	
    private ReportAuditResultDto toDto(ResultSet resultSet) throws SQLException {
    	ReportAuditResultDto dto = new ReportAuditResultDto(
    			String.valueOf(resultSet.getString("PLANT_RECEIVE")),
                Integer.parseInt(String.valueOf(resultSet.getString("TOTALS"))));
        return dto;
    }
    
    public List<ReportAuditResultDto> getAuditResultAllV2(String typeStation,String sDate,String eDate,String trip) {
        Date startDate = DateUtil.stringTodate(sDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        Date endDate = DateUtil.stringTodate(eDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("V_FROM_CREATE_DATE",startDate);
        parameters.addValue("V_TO_CREATE_DATE",endDate);
        parameters.addValue("V_TYPE_STATION",typeStation);
        if(!trip.equals("0")) {
            parameters.addValue("V_TRIP_ID",trip);
        }
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT LMT.TOOLS_NAME,COUNT(1) AS TOTALS ");
        sql.append(" FROM MB_ACTION_PLAN_HD APH ");
        sql.append("    INNER JOIN MB_ACTION_PLAN_DT APD ON APD.TRIP_ID = APH.TRIP_ID ");
        sql.append("    INNER JOIN MB_STATION_MASTER SM ON SM.COST_CENTER = APD.COST_CENTER ");
        sql.append("     JOIN (SELECT LHD.PLAN_DT_ID FROM MB_LTR_HD LHD ");
        sql.append("    		WHERE LHD.CREATE_DATE BETWEEN :V_FROM_CREATE_DATE ");
        sql.append("    		AND DATEADD(DAY, 1, :V_TO_CREATE_DATE) group by LHD.PLAN_DT_ID) LH on LH.PLAN_DT_ID = APD.PLAN_DT_ID");
        sql.append("    INNER JOIN MB_LAB_MPTOOLS LMT ON LMT.PLAN_DT_ID = APD.PLAN_DT_ID ");
        //sql.append("    LEFT JOIN MB_PLANT_RECEIVE PR ON PR.PLANT_RECEIVE_NAMETH LIKE '%' + SM.PLANT_RECEIVE + '%' ");
        sql.append(" WHERE 1=1 ");
//        sql.append("    AND LH.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_CREATE_DATE)) ");
        //sql.append("    AND SM.PLANT_RECEIVE IS NOT NULL ");
        sql.append("    AND SM.TYPE_STATION =:V_TYPE_STATION ");
        sql.append("    AND APD.TRIP_ID =:V_TRIP_ID ");
        sql.append(" GROUP BY LMT.TOOLS_NAME ");
        List<ReportAuditResultDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportAuditResultDto>() {
            @Override
            public ReportAuditResultDto mapRow(ResultSet resultSet, int i) throws SQLException {
            	return toDtoTools(resultSet);
            }
        });
        List<ReportAuditResultDto> plist = getToolsMB();
        List<ReportAuditResultDto> pTemp = new ArrayList<>();
        for(ReportAuditResultDto a : plist){
            pTemp = list.stream()
                    .filter(e->e.getToolsName().equalsIgnoreCase(a.getToolsName()))
                    .collect(Collectors.toList());
            if(pTemp.isEmpty()){
                list.add(a);
            }
        }
        return list;
    }
	
	public List<ReportAuditResultDto> getAuditResultNV2(String typeStation,String sDate,String eDate,String trip) {
        Date startDate = DateUtil.stringTodate(sDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        Date endDate = DateUtil.stringTodate(eDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("V_FROM_CREATE_DATE",startDate);
        parameters.addValue("V_TO_CREATE_DATE",endDate);
        parameters.addValue("V_TYPE_STATION",typeStation);
        if(!trip.equals("0")) {
            parameters.addValue("V_TRIP_ID",trip);
        }
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT LMT.TOOLS_NAME, COUNT(1) AS TOTALS,LMT.REMARK ");
        sql.append(" FROM MB_ACTION_PLAN_HD APH ");
        sql.append("    LEFT JOIN MB_ACTION_PLAN_DT APD ON APD.TRIP_ID = APH.TRIP_ID ");
        sql.append("    LEFT JOIN MB_STATION_MASTER SM ON SM.COST_CENTER = APD.COST_CENTER ");
        sql.append("     JOIN (SELECT LHD.PLAN_DT_ID FROM MB_LTR_HD LHD ");
        sql.append("    		WHERE LHD.CREATE_DATE BETWEEN :V_FROM_CREATE_DATE ");
        sql.append("    		AND DATEADD(DAY, 1, :V_TO_CREATE_DATE) group by LHD.PLAN_DT_ID) LH on LH.PLAN_DT_ID = APD.PLAN_DT_ID");
        sql.append("    LEFT JOIN MB_LAB_MPTOOLS LMT ON LMT.PLAN_DT_ID = APD.PLAN_DT_ID ");
        sql.append("    LEFT JOIN MB_PLANT_RECEIVE PR ON PR.PLANT_RECEIVE_NAMETH LIKE '%' + SM.PLANT_RECEIVE + '%' ");
        sql.append(" WHERE 1=1 ");
//        sql.append("    AND LH.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_CREATE_DATE)) ");
//        sql.append("    AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_CREATE_DATE))) ");
        //sql.append("    AND SM.PLANT_RECEIVE IS NOT NULL ");
        sql.append("    AND SM.TYPE_STATION =:V_TYPE_STATION ");
        if(!trip.equals("0")) {
            sql.append("    AND APD.TRIP_ID =:V_TRIP_ID ");
        }
        sql.append("     AND LMT.CHECK_FLG = 'N' ");
        sql.append(" GROUP BY LMT.TOOLS_NAME,LMT.REMARK ORDER By LMT.TOOLS_NAME ");
        List<ReportAuditResultDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportAuditResultDto>() {
            @Override
            public ReportAuditResultDto mapRow(ResultSet resultSet, int i) throws SQLException {
            	return toDtoTools(resultSet);
            }
        });
//        List<ReportAuditResultDto> plist = getToolsMB();
//        List<ReportAuditResultDto> pTemp = new ArrayList<>();
//        for(ReportAuditResultDto a : plist){
//            pTemp = list.stream()
//                    .filter(e->e.getToolsName().equalsIgnoreCase(a.getToolsName()))
//                    .collect(Collectors.toList());
//            if(pTemp.isEmpty()){
//                list.add(a);
//            }
//        }
        return list;
    }
	
    private ReportAuditResultDto toDtoTools(ResultSet resultSet) throws SQLException {
    	ReportAuditResultDto dto = new ReportAuditResultDto();
    	if(resultSet.getString("TOOLS_NAME").matches("(.*)ไฮโดรมิเตอร์(.*)")) {
    		dto.setToolsName(String.valueOf(resultSet.getString("TOOLS_NAME").split(" ")[1]));
    	}else {
    		//dto.setToolsName(String.valueOf(resultSet.getString("TOOLS_NAME"))+" "+resultSet.getString("REMARK")+"| "+resultSet.getString("TOTALS"));
    		dto.setToolsName(String.valueOf(resultSet.getString("TOOLS_NAME")));
    	}
    	
    	dto.setTotals(Integer.parseInt(String.valueOf(resultSet.getString("TOTALS"))));
    	dto.setItemName(resultSet.getString("TOOLS_NAME"));
        return dto;
    }
	
 	public List<ReportAuditResultDto> getToolsMB() {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        StringBuffer sql = new StringBuffer();
        sql.append(" select TOOLS_NAME,'0' AS TOTALS from MB_LAB_MPTOOLS GROUP BY TOOLS_NAME ");
        List<ReportAuditResultDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportAuditResultDto>() {
            @Override
            public ReportAuditResultDto mapRow(ResultSet resultSet, int i) throws SQLException {
            	return toDtoTools(resultSet);
            }
        });

        return list;
    }

	public List<Map<String, Object>> getTotalBreakdown(String company, String trip) {
		List<Map<String, Object>>  result =null;
		Map<String, Object> map =null;
    	try {
    		
    		map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getTotalToolBreakdown");
					
				SqlParameterSource in = new MapSqlParameterSource()
						.addValue("tripId", trip,Types.VARCHAR)
						.addValue("typeStation", company,Types.VARCHAR);
				
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
				
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}
}
