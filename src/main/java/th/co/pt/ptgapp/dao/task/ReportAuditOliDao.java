package th.co.pt.ptgapp.dao.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import th.co.pt.ptgapp.utils.DateUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class ReportAuditOliDao {

    @Autowired
    private NamedParameterJdbcTemplate npJdbcTemplate;

    public List<ReportAuditOliDto> getTotalStation() {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT TYPE_STATION,COUNT(1) AS TOTALS ");
        sql.append(" FROM MB_STATION_MASTER ");
        sql.append(" GROUP BY TYPE_STATION ");
        List<ReportAuditOliDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportAuditOliDto>() {
            @Override
            public ReportAuditOliDto mapRow(ResultSet resultSet, int i) throws SQLException {
                return toDto(resultSet);
            }
        });
        return list;
    }


    public List<ReportAuditOliDto> getTotalTripByCondition(String sDate, String eDate, String trip) {
        Date startDate = DateUtil.stringTodate(sDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        Date endDate = DateUtil.stringTodate(eDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("V_FROM_DATE",startDate);
        parameters.addValue("V_TO_DATE",endDate);
        if(!trip.equals("0")) {
            parameters.addValue("V_TRIP_ID",trip);
        }
        StringBuffer sql = new StringBuffer();
        sql.append(" select c.TYPE_STATION,COUNT(1) AS TOTALS from ( ");
        sql.append(" SELECT LH.PLAN_DT_ID,SM.TYPE_STATION ");
        sql.append(" FROM MB_LTR_HD LH ");
        sql.append("    LEFT JOIN MB_ACTION_PLAN_DT APD ON LH.PLAN_DT_ID = APD.PLAN_DT_ID ");
        sql.append("    LEFT JOIN MB_STATION_MASTER SM ON APD.COST_CENTER = SM.COST_CENTER ");
        sql.append(" WHERE 1=1 ");
//        sql.append("    AND LH.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_DATE)) ");
//        sql.append("    AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_DATE))) ");
        sql.append("    AND LH.CREATE_DATE BETWEEN :V_FROM_DATE ");
        sql.append("    AND DATEADD(DAY, 1, :V_TO_DATE) ");
        if(!trip.equals("0")) {
            sql.append("    AND APD.TRIP_ID =:V_TRIP_ID ");
        }
        sql.append(" GROUP BY LH.PLAN_DT_ID,SM.TYPE_STATION ");
        sql.append(" ) c group by c.TYPE_STATION ");
        List<ReportAuditOliDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportAuditOliDto>() {
            @Override
            public ReportAuditOliDto mapRow(ResultSet resultSet, int i) throws SQLException {
                return toDto(resultSet);
            }
        });
        return list;
    }

    private ReportAuditOliDto toDto(ResultSet resultSet) throws SQLException {
        ReportAuditOliDto dto = new ReportAuditOliDto(String.valueOf(resultSet.getString("TYPE_STATION")),Integer.parseInt(String.valueOf(resultSet.getString("TOTALS"))));
        return dto;
    }


}
