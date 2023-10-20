package th.co.pt.ptgapp.dao.task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import th.co.pt.ptgapp.utils.DateUtil;

@Repository
public class ReportOilStationDao {

	 @Autowired
     private NamedParameterJdbcTemplate npJdbcTemplate;
	 
	 public List<ReportOilStationDto> getOilStation(String year) {
	        Date startDate = DateUtil.stringTodate("01/01/"+year,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
	        Date endDate = DateUtil.stringTodate("31/12/"+year,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
	        MapSqlParameterSource parameters = new MapSqlParameterSource();
	        parameters.addValue("V_FROM_CREATE_DATE",startDate);
	        parameters.addValue("V_TO_CREATE_DATE",endDate);
	        StringBuffer sql = new StringBuffer();
	        sql.append(" SELECT SM.TYPE_STATION, COUNT(1) AS TOTALS ");
	        sql.append(" FROM MB_ACTION_PLAN_HD APH ");
	        sql.append("    LEFT JOIN MB_ACTION_PLAN_DT APD ON APD.TRIP_ID = APH.TRIP_ID ");
	        sql.append("    LEFT JOIN MB_STATION_MASTER SM ON SM.COST_CENTER = APD.COST_CENTER ");
	        sql.append("    LEFT JOIN MB_LTR_HD LH ON LH.PLAN_DT_ID = APD.PLAN_DT_ID ");
	        sql.append("    LEFT JOIN PRODUCT P ON SUBSTRING(P.PRODUCT_ID,8,9) = LH.PRODUCT_ID ");
	        sql.append(" WHERE 1=1 ");
//	        sql.append("    AND LH.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_CREATE_DATE)) ");
//	        sql.append("    AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_CREATE_DATE))) ");
	        sql.append("    AND LH.CREATE_DATE BETWEEN :V_FROM_CREATE_DATE ");
	        sql.append("    AND DATEADD(DAY, 1, :V_TO_CREATE_DATE) ");
	        //sql.append("    AND SM.PLANT_RECEIVE IS NOT NULL ");
	        sql.append("     AND LH.[RESULT] = 'Y' ");
	        sql.append(" GROUP BY SM.TYPE_STATION ");
	        List<ReportOilStationDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportOilStationDto>() {
	            @Override
	            public ReportOilStationDto mapRow(ResultSet resultSet, int i) throws SQLException {
	            	return toDto(resultSet,Integer.toString(Integer.parseInt(year)+543));
	            }
	        });
	        List<ReportOilStationDto> plist = getTypeStation(year);
	        List<ReportOilStationDto> pTemp = new ArrayList<>();
	        for(ReportOilStationDto a : plist){
	            pTemp = list.stream()
	                    .filter(e->e.getTypeStation().equalsIgnoreCase(a.getTypeStation()))
	                    .collect(Collectors.toList());
	            if(pTemp.isEmpty()){
	                list.add(a);
	            }
	        }
	        return list;
	    }
	 
	 	public List<ReportOilStationDto> getTypeStation(String year) {
	        MapSqlParameterSource parameters = new MapSqlParameterSource();
	        StringBuffer sql = new StringBuffer();
	        sql.append(" SELECT SM.TYPE_STATION, '0' AS TOTALS ");
	        sql.append(" FROM MB_STATION_MASTER SM ");
	        sql.append(" GROUP BY SM.TYPE_STATION ");
	        List<ReportOilStationDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportOilStationDto>() {
	            @Override
	            public ReportOilStationDto mapRow(ResultSet resultSet, int i) throws SQLException {
	            	return toDto(resultSet,Integer.toString(Integer.parseInt(year)+543));
	            }
	        });

	        return list;
	    }
	 	
	    private ReportOilStationDto toDto(ResultSet resultSet,String year) throws SQLException {
	    	ReportOilStationDto dto = new ReportOilStationDto(
	                String.valueOf(resultSet.getString("TYPE_STATION")),
	                year,
	                Integer.parseInt(String.valueOf(resultSet.getString("TOTALS"))));
	        return dto;
	    }

}
