package th.co.pt.ptgapp.dao.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import th.co.pt.ptgapp.entity.MBReportData;
import th.co.pt.ptgapp.entity.report.PerformanceOil;
import th.co.pt.ptgapp.utils.DateUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ReportAuditDao {

    @Autowired
    private NamedParameterJdbcTemplate npJdbcTemplate;
    
    @Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;

    public List<ReportAuditDto> getAllResultTripByCondition(String sDate, String eDate, String trip,String typeStation) {
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
        sql.append(" SELECT P.PRODUCT_CODE, COUNT(1) AS TOTALS ");
        sql.append(" FROM MB_ACTION_PLAN_HD APH ");
        sql.append("    LEFT JOIN MB_ACTION_PLAN_DT APD ON APD.TRIP_ID = APH.TRIP_ID ");
        sql.append("    LEFT JOIN MB_STATION_MASTER SM ON SM.COST_CENTER = APD.COST_CENTER ");
        sql.append("    LEFT JOIN MB_LTR_HD LH ON LH.PLAN_DT_ID = APD.PLAN_DT_ID ");
        sql.append("    LEFT JOIN PRODUCT P ON SUBSTRING(P.PRODUCT_ID,8,9) = LH.PRODUCT_ID ");
        sql.append(" WHERE 1=1 ");
//        sql.append("    AND LH.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_CREATE_DATE)) ");
//        sql.append("    AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_CREATE_DATE))) ");
        sql.append("    AND LH.CREATE_DATE BETWEEN :V_FROM_CREATE_DATE ");
        sql.append("    AND DATEADD(DAY, 1, :V_TO_CREATE_DATE) ");
        //sql.append("    AND SM.PLANT_RECEIVE IS NOT NULL ");
        sql.append("    AND SM.TYPE_STATION =:V_TYPE_STATION ");
        if(!trip.equals("0")) {
            sql.append("    AND APD.TRIP_ID =:V_TRIP_ID ");
        }
        sql.append(" GROUP BY P.PRODUCT_CODE ");
        List<ReportAuditDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportAuditDto>() {
            @Override
            public ReportAuditDto mapRow(ResultSet resultSet, int i) throws SQLException {
                return toDto(resultSet);
            }
        });

        List<ReportAuditDto> plist = getProducts();
        List<ReportAuditDto> pTemp = new ArrayList<>();
        for(ReportAuditDto a : plist){
            pTemp = list.stream().filter(e->e.getPlant().equalsIgnoreCase(a.getPlant())).collect(Collectors.toList());
            if(pTemp.isEmpty()){
                list.add(a);
            }
        }
        return list;
    }

    public List<ReportAuditDto> getYResultTripByCondition(String sDate, String eDate, String trip,String typeStation) {
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
        sql.append(" SELECT P.PRODUCT_CODE, COUNT(1) AS TOTALS ");
        sql.append(" FROM MB_ACTION_PLAN_HD APH ");
        sql.append("    LEFT JOIN MB_ACTION_PLAN_DT APD ON APD.TRIP_ID = APH.TRIP_ID ");
        sql.append("    LEFT JOIN MB_STATION_MASTER SM ON SM.COST_CENTER = APD.COST_CENTER ");
        sql.append("    LEFT JOIN MB_LTR_HD LH ON LH.PLAN_DT_ID = APD.PLAN_DT_ID ");
        sql.append("    LEFT JOIN PRODUCT P ON SUBSTRING(P.PRODUCT_ID,8,9) = LH.PRODUCT_ID ");
        sql.append(" WHERE 1=1 ");
//        sql.append("    AND LH.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_CREATE_DATE)) ");
//        sql.append("    AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_CREATE_DATE))) ");
        sql.append("    AND LH.CREATE_DATE BETWEEN :V_FROM_CREATE_DATE ");
        sql.append("    AND DATEADD(DAY, 1, :V_TO_CREATE_DATE) ");
        //sql.append("    AND SM.PLANT_RECEIVE IS NOT NULL ");
        sql.append("    AND SM.TYPE_STATION =:V_TYPE_STATION ");
        if(!trip.equals("0")) {
            sql.append("    AND APD.TRIP_ID =:V_TRIP_ID ");
        }
        sql.append("     AND LH.[RESULT] = 'Y' ");
        sql.append(" GROUP BY P.PRODUCT_CODE ");
        List<ReportAuditDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportAuditDto>() {
            @Override
            public ReportAuditDto mapRow(ResultSet resultSet, int i) throws SQLException {
                return toDto(resultSet);
            }
        });
        List<ReportAuditDto> plist = getProducts();
        List<ReportAuditDto> pTemp = new ArrayList<>();
        for(ReportAuditDto a : plist){
            pTemp = list.stream().filter(e->e.getPlant().equalsIgnoreCase(a.getPlant())).collect(Collectors.toList());
            if(pTemp.isEmpty()){
                list.add(a);
            }
        }
        return list;
    }

    public List<ReportAuditDto> getAllResultTripByConditionPlace(String sDate, String eDate, String trip,String typeStation) {
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
        sql.append(" select st.PLACE, COUNT(1) AS TOTALS from ( ");
        sql.append(" SELECT SM.COST_CENTER,SM.PLACE ");
        sql.append(" FROM MB_ACTION_PLAN_HD APH ");
        sql.append("    LEFT JOIN MB_ACTION_PLAN_DT APD ON APD.TRIP_ID = APH.TRIP_ID ");
        sql.append("    LEFT JOIN MB_STATION_MASTER SM ON SM.COST_CENTER = APD.COST_CENTER ");
        sql.append("    LEFT JOIN MB_LTR_HD LH ON LH.PLAN_DT_ID = APD.PLAN_DT_ID ");
        sql.append("    LEFT JOIN PRODUCT P ON SUBSTRING(P.PRODUCT_ID,8,9) = LH.PRODUCT_ID ");
        sql.append(" WHERE 1=1 ");
//        sql.append("    AND LH.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_CREATE_DATE)) ");
//        sql.append("    AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_CREATE_DATE))) ");
        sql.append("    AND LH.CREATE_DATE BETWEEN :V_FROM_CREATE_DATE ");
        sql.append("    AND DATEADD(DAY, 1, :V_TO_CREATE_DATE) ");
        //sql.append("    AND SM.PLANT_RECEIVE IS NOT NULL ");
        sql.append("    AND SM.TYPE_STATION =:V_TYPE_STATION ");
        if(!trip.equals("0")) {
            sql.append("    AND APD.TRIP_ID =:V_TRIP_ID ");
        }
        sql.append(" GROUP BY SM.COST_CENTER,SM.PLACE) st ");
        sql.append(" GROUP BY st.PLACE ");
        List<ReportAuditDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportAuditDto>() {
            @Override
            public ReportAuditDto mapRow(ResultSet resultSet, int i) throws SQLException {
                return toDtoPlace(resultSet);
            }
        });
        List<ReportAuditDto> plist = getPlaces(trip,typeStation);
        List<ReportAuditDto> pTemp = new ArrayList<>();
        for(ReportAuditDto a : plist){
            pTemp = list.stream().filter(e->e.getPlant().equalsIgnoreCase(a.getPlant())).collect(Collectors.toList());
            if(pTemp.isEmpty()){
                list.add(a);
            }
        }
        return list;
    }

    public List<ReportAuditDto> getYResultTripByConditionPlace(String sDate, String eDate, String trip,String typeStation) {
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
        sql.append(" SELECT SM.PLACE, COUNT(1) AS TOTALS ");
        sql.append(" FROM MB_ACTION_PLAN_HD APH ");
        sql.append("    LEFT JOIN MB_ACTION_PLAN_DT APD ON APD.TRIP_ID = APH.TRIP_ID ");
        sql.append("    LEFT JOIN MB_STATION_MASTER SM ON SM.COST_CENTER = APD.COST_CENTER ");
        sql.append("    LEFT JOIN MB_LTR_HD LH ON LH.PLAN_DT_ID = APD.PLAN_DT_ID ");
        sql.append("    LEFT JOIN PRODUCT P ON SUBSTRING(P.PRODUCT_ID,8,9) = LH.PRODUCT_ID ");
        sql.append(" WHERE 1=1 ");
//        sql.append("    AND LH.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_CREATE_DATE)) ");
//        sql.append("    AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_CREATE_DATE))) ");
        sql.append("    AND LH.CREATE_DATE BETWEEN :V_FROM_CREATE_DATE ");
        sql.append("    AND DATEADD(DAY, 1, :V_TO_CREATE_DATE) ");
        //sql.append("    AND SM.PLANT_RECEIVE IS NOT NULL ");
        sql.append("    AND SM.TYPE_STATION =:V_TYPE_STATION ");
        if(!trip.equals("0")) {
            sql.append("    AND APD.TRIP_ID =:V_TRIP_ID ");
        }
        sql.append("     AND LH.[RESULT] = 'Y' ");
        sql.append(" GROUP BY SM.PLACE ");
        List<ReportAuditDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportAuditDto>() {
            @Override
            public ReportAuditDto mapRow(ResultSet resultSet, int i) throws SQLException {
                return toDtoPlace(resultSet);
            }
        });
        List<ReportAuditDto> plist = getPlaces(trip,typeStation);
        List<ReportAuditDto> pTemp = new ArrayList<>();
        for(ReportAuditDto a : plist){
            pTemp = list.stream().filter(e->e.getPlant().equalsIgnoreCase(a.getPlant())).collect(Collectors.toList());
            if(pTemp.isEmpty()){
                list.add(a);
            }
        }
        return list;
    }


    public List<ReportAuditDto> getProducts() {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT P.PRODUCT_CODE, '0' AS TOTALS ");
        sql.append(" FROM PRODUCT P ");
        List<ReportAuditDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportAuditDto>() {
            @Override
            public ReportAuditDto mapRow(ResultSet resultSet, int i) throws SQLException {
                return toDto(resultSet);
            }
        });
        return list;
    }
    

    public List<ReportAuditDto> getPlaces(String trip,String typeStation) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();

        parameters.addValue("V_TYPE_STATION",typeStation);
        parameters.addValue("V_TRIP_ID",trip);
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT SM.PLACE, '0' AS TOTALS ");
        sql.append(" FROM MB_ACTION_PLAN_HD APH ");
        sql.append("    LEFT JOIN MB_ACTION_PLAN_DT APD ON APD.TRIP_ID = APH.TRIP_ID ");
        sql.append("    LEFT JOIN MB_STATION_MASTER SM ON SM.COST_CENTER = APD.COST_CENTER ");
        sql.append("    LEFT JOIN MB_LTR_HD LH ON LH.PLAN_DT_ID = APD.PLAN_DT_ID ");
        sql.append("    LEFT JOIN PRODUCT P ON SUBSTRING(P.PRODUCT_ID,8,9) = LH.PRODUCT_ID ");
        sql.append(" WHERE 1=1 ");
        sql.append("    AND SM.TYPE_STATION =:V_TYPE_STATION ");
        sql.append("    AND APD.TRIP_ID =:V_TRIP_ID ");
        sql.append(" GROUP BY SM.PLACE ");
        List<ReportAuditDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportAuditDto>() {
            @Override
            public ReportAuditDto mapRow(ResultSet resultSet, int i) throws SQLException {
                return toDtoPlace(resultSet);
            }
        });
        return list;
    }

    private ReportAuditDto toDto(ResultSet resultSet) throws SQLException {
        ReportAuditDto dto = new ReportAuditDto(String.valueOf(resultSet.getString("PRODUCT_CODE")),Integer.parseInt(String.valueOf(resultSet.getString("TOTALS"))));
        return dto;
    }

    private ReportAuditDto toDtoPlace(ResultSet resultSet) throws SQLException {
        ReportAuditDto dto = new ReportAuditDto(String.valueOf(resultSet.getString("PLACE")),Integer.parseInt(String.valueOf(resultSet.getString("TOTALS"))));
        return dto;
    }
    
    public List<Map<String, Object>> getMBProduct(){
    	List<Map<String, Object>>  result =null;

    	try {
    		result = new ArrayList<Map<String, Object>>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getMBProduct");
				SqlParameterSource in = new MapSqlParameterSource();
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
    	
    }
    
    public List<Map<String, Object>> getMBProductResult(String trip,String stDate,String enDate){
    	List<Map<String, Object>>  result =null;
        Date startDate = DateUtil.stringTodate(stDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        Date endDate = DateUtil.stringTodate(enDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);

    	try {
    		result = new ArrayList<Map<String, Object>>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getMBProductCondition");
					
				SqlParameterSource in = new MapSqlParameterSource() 
						 .addValue("trip",trip,Types.VARCHAR)
						 .addValue("stDate",startDate,Types.DATE)
						 .addValue("enDate",endDate,Types.DATE);
				
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
    	
    }
    
    public List<Map<String, Object>> getMBResultTest(String trip,String company){
    	List<Map<String, Object>>  result =null;
    	try {
    		result = new ArrayList<Map<String, Object>>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getMBResultTest");
					
				SqlParameterSource in = new MapSqlParameterSource() 
						 .addValue("tripID",trip,Types.VARCHAR)
						 .addValue("company",company,Types.VARCHAR);
				
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
    	
    }
    
    public List<Map<String, Object>> getMBBreakdown(String trip,String company){
    	List<Map<String, Object>>  result =null;

    	try {
    		result = new ArrayList<Map<String, Object>>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getToolsBreakdown");
					
				SqlParameterSource in = new MapSqlParameterSource() 
						 .addValue("tripId",trip,Types.VARCHAR)
						 .addValue("company",company,Types.VARCHAR);
				
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
    	
    }

	public List<Map<String, Object>> getMBDateBetweenDao(String tripid) {
		List<Map<String, Object>>  result =null;

    	try {
    		result = new ArrayList<Map<String, Object>>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getMBDateHDReport");
					
				SqlParameterSource in = new MapSqlParameterSource() 
						 .addValue("tripId",tripid,Types.VARCHAR);
				
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}

	public List<Map<String, Object>> getMBGroupProvinceDao(String tripid) {
		List<Map<String, Object>>  result =null;

    	try {
    		result = new ArrayList<Map<String, Object>>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getMBGroupProvince");
					
				SqlParameterSource in = new MapSqlParameterSource() 
						 .addValue("tripId",tripid,Types.VARCHAR);
				
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}

	public List<Map<String, Object>> getMBGroupPlantDao(String tripid) {
		List<Map<String, Object>>  result =null;

    	try {
    		result = new ArrayList<Map<String, Object>>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getMBGroupPlant");
					
				SqlParameterSource in = new MapSqlParameterSource() 
						 .addValue("tripId",tripid,Types.VARCHAR);
				
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}

	public List<Map<String, Object>> getMBListReceiveOilDao(String tripid,String station) {
		List<Map<String, Object>>  result =null;

    	try {
    		result = new ArrayList<Map<String, Object>>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getMBReceiveOilDetail");
					
				SqlParameterSource in = new MapSqlParameterSource().addValue("tripId", tripid,Types.VARCHAR).addValue("stationCode", station,Types.VARCHAR);
				
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}

	public List<Map<String, Object>> getMBListScheduleOilDao(String tripid,String station) {
		List<Map<String, Object>>  result =null;

    	try {
    		result = new ArrayList<Map<String, Object>>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getMBScheduleOilDetail");
					
				SqlParameterSource in = new MapSqlParameterSource().addValue("tripId", tripid,Types.VARCHAR).addValue("stationCode", station,Types.VARCHAR);
				
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}

	public List<Map<String, Object>> saveListReceiveDao(MBReportData mbReportData) {
		List<Map<String, Object>>  result =null;
		Map<String, Object> map =null;
    	try {
    		
    		map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("saveMBReceiveOil");
					
				SqlParameterSource in = new MapSqlParameterSource()
						.addValue("productArr", mbReportData.getProductArr(),Types.VARCHAR)
						.addValue("causeArr", mbReportData.getCauseArr(),Types.VARCHAR)
						.addValue("tripidArr", mbReportData.getTripidArr(),Types.VARCHAR)
						.addValue("costcenterArr", mbReportData.getCostcenterArr(),Types.VARCHAR)
						.addValue("statusArr", mbReportData.getStatusArr(),Types.VARCHAR)
    		            .addValue("createBy", mbReportData.getCreateBy(),Types.VARCHAR);
				
				call.execute(in).get("#result-set-1");
				result = new ArrayList<Map<String, Object>>();
				map.put("status", "00");
				result.add(map);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}

	public List<Map<String, Object>> updateNCRNo(MBReportData mbReportData) {
		List<Map<String, Object>>  result =null;
		Map<String, Object> map =null;
    	try {
    		
    		map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getUpdateNCR");
					
				SqlParameterSource in = new MapSqlParameterSource()
			
						.addValue("tripId", mbReportData.getTripidArr(),Types.VARCHAR)
						.addValue("costcenter", mbReportData.getCostcenterArr(),Types.VARCHAR)
    		            .addValue("ncrno", mbReportData.getNcrArr(),Types.VARCHAR);
				
				call.execute(in).get("#result-set-1");
				result = new ArrayList<Map<String, Object>>();
				map.put("status", "00");
				result.add(map);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}

	public List<Map<String, Object>> saveListSchedule(MBReportData mbReportData) {
		List<Map<String, Object>>  result =null;
		Map<String, Object> map =null;
    	try {
    		
    		map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("saveMBScheduleOil");
					
				SqlParameterSource in = new MapSqlParameterSource()
						.addValue("productArr", mbReportData.getProductArr(),Types.VARCHAR)
						.addValue("causeArr", mbReportData.getCauseArr(),Types.VARCHAR)
						.addValue("tripidArr", mbReportData.getTripidArr(),Types.VARCHAR)
						.addValue("costcenterArr", mbReportData.getCostcenterArr(),Types.VARCHAR)
						.addValue("statusArr", mbReportData.getStatusArr(),Types.VARCHAR)
						.addValue("ncrArr", mbReportData.getNcrArr(),Types.VARCHAR)
    		            .addValue("createBy", mbReportData.getCreateBy(),Types.VARCHAR);
				
				call.execute(in).get("#result-set-1");
				result = new ArrayList<Map<String, Object>>();
				map.put("status", "00");
				result.add(map);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}

	public List<Map<String, String>> listAuditOil(String trip) {
		List<Map<String, String>>  result =null;
		Map<String, Object> map =null;
    	try {
    		
    		map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getAuditOil");
					
				SqlParameterSource in = new MapSqlParameterSource()
						.addValue("tripId", trip,Types.VARCHAR);
				
				result = (List<Map<String, String>>)call.execute(in).get("#result-set-1");
				
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}

	public List<Map<String, String>> listAuditNot(String trip,String company) {
		List<Map<String, String>>  result =null;
		Map<String, Object> map =null;
    	try {
    		
    		map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getAuditSchedule");
					
				SqlParameterSource in = new MapSqlParameterSource()
						.addValue("tripId", trip,Types.VARCHAR)
						.addValue("company", company,Types.VARCHAR);
				
				result = (List<Map<String, String>>)call.execute(in).get("#result-set-1");
				
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}

	public List<Map<String, Object>> getReportAuditBytripId(String trip,String company) {
		List<Map<String, Object>>  result =null;
		Map<String, Object> map =null;
    	try {
    		
    		map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getMBGraphScheduleOilDetail");
					
				SqlParameterSource in = new MapSqlParameterSource()
						.addValue("tripId", trip,Types.VARCHAR)
						.addValue("company", company,Types.VARCHAR);
				
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
				
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}

	public List<Map<String, Object>> getReportAuditNotBytripId(String trip) {
		List<Map<String, Object>>  result =null;
		Map<String, Object> map =null;
    	try {
    		
    		map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getMBGraphReceiveOilDetail");
					
				SqlParameterSource in = new MapSqlParameterSource()
						.addValue("tripId", trip,Types.VARCHAR);
				
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
				
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}

	public List<Map<String, Object>> getWording(String trip) {
		List<Map<String, Object>>  result =null;
		Map<String, Object> map =null;
    	try {
    		
    		map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getMBWording");
					
				SqlParameterSource in = new MapSqlParameterSource()
						.addValue("tripId", trip,Types.VARCHAR);
				
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
				
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}

	public List<Map<String, Object>> getMBCreateDateHD(String trip) {
		List<Map<String, Object>>  result =null;
		Map<String, Object> map =null;
    	try {
    		
    		map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getCreateDateMBLtrHd");
					
				SqlParameterSource in = new MapSqlParameterSource()
						.addValue("tripId", trip,Types.VARCHAR);
				
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
				
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}

	public List<Map<String, Object>> deleteMBListReceive(String tripid, String station,String productcode) {
		List<Map<String, Object>>  result =null;
		Map<String, Object> map =null;
    	try {
    		map = new HashMap<String, Object>();
    		result = new ArrayList<Map<String, Object>>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("deleteMBReceiveOilDetail");
					
				SqlParameterSource in = new MapSqlParameterSource().addValue("tripId", tripid,Types.VARCHAR).addValue("stationCode", station,Types.VARCHAR).addValue("productcode", productcode,Types.VARCHAR);
				
				call.execute(in).get("#result-set-1");
				result = new ArrayList<Map<String, Object>>();
				map.put("status", "00");
				result.add(map);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}

	public List<Map<String, Object>> deleteMBListSchedule(String tripid, String station, String productcode) {
		List<Map<String, Object>>  result =null;
		Map<String, Object> map =null;
    	try {
    		map = new HashMap<String, Object>();
    		result = new ArrayList<Map<String, Object>>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("deleteMBRScheduleOilDetail");
					
				SqlParameterSource in = new MapSqlParameterSource().addValue("tripId", tripid,Types.VARCHAR).addValue("stationCode", station,Types.VARCHAR).addValue("productcode", productcode,Types.VARCHAR);
				
				call.execute(in).get("#result-set-1");
			
				result = new ArrayList<Map<String, Object>>();
				map.put("status", "00");
				result.add(map);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}

	public List<Map<String, Object>> getReportAuditTotalBytripId(String trip, String company) {
		List<Map<String, Object>>  result =null;
		Map<String, Object> map =null;
    	try {
    		
    		map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getTripTotalOil");
					
				SqlParameterSource in = new MapSqlParameterSource()
						.addValue("tripId", trip,Types.VARCHAR).addValue("typeStation", company,Types.VARCHAR);
				
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
				
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}

	public List<Map<String, Object>>  getlistResultLiteDao(String trip, String company) {
		List<Map<String, Object>>  result =null;
		Map<String, Object> map =null;
    	try {
    		
    		map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getResultPlaceLite");
					
				SqlParameterSource in = new MapSqlParameterSource()
						.addValue("tripId", trip,Types.VARCHAR).addValue("typeStation", company,Types.VARCHAR);
				
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
				
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}

	public List<Map<String, Object>> getlistResultTotalLiteDao(String trip, String company) {
		List<Map<String, Object>>  result =null;
		Map<String, Object> map =null;
    	try {
    		
    		map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getTotalPlaceLite");
					
				SqlParameterSource in = new MapSqlParameterSource()
						.addValue("tripId", trip,Types.VARCHAR).addValue("typeStation", company,Types.VARCHAR);
				
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
				
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}

	public List<Map<String, Object>> getlistResultSummary(String trip, String company) {
		List<Map<String, Object>>  result =null;
		Map<String, Object> map =null;
    	try {
    		
    		map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getSummaryTest");
					
				SqlParameterSource in = new MapSqlParameterSource()
						.addValue("tripId", trip,Types.VARCHAR).addValue("typeStation", company,Types.VARCHAR);
				
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
				
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}

	public List<Map<String, Object>> getlistResultTotalSummary(String trip, String company) {
		List<Map<String, Object>>  result =null;
		Map<String, Object> map =null;
    	try {
    		
    		map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getTotalSummaryTest");
					
				SqlParameterSource in = new MapSqlParameterSource()
						.addValue("tripId", trip,Types.VARCHAR).addValue("typeStation", company,Types.VARCHAR);
				
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
				
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return result;
	}
}
