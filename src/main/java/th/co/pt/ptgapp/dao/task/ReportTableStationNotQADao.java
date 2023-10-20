package th.co.pt.ptgapp.dao.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import th.co.pt.ptgapp.entity.report.ReportTableStationNotQA;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.WsConstant;
import th.co.pt.ptgapp.utils.DateUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class ReportTableStationNotQADao {

    @Autowired
    private NamedParameterJdbcTemplate npJdbcTemplate;

    public List<ReportTableStationNotQA> getStationNotQA(String sDate, String eDate,String trip) {
        StringBuffer sql = new StringBuffer();
        Date startDate = DateUtil.stringTodate(sDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        Date endDate = DateUtil.stringTodate(eDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("V_FROM_DATE", startDate);
        parameters.addValue("V_TO_DATE", endDate);
        if(!trip.equals("0")) {
            parameters.addValue("V_TRIP_ID",trip);
        }
        sql.append(" SELECT SM.CENTER_NAME, SM.PLACE, LTR.CREATE_DATE, P.PRODUCT_CODE ");
        sql.append(" FROM MB_LTR_HD LTR ");
        sql.append("    LEFT JOIN PRODUCT P ON SUBSTRING(P.PRODUCT_ID,8,9) = LTR.PRODUCT_ID ");
        sql.append("    LEFT JOIN MB_ACTION_PLAN_DT APD ON APD.PLAN_DT_ID = LTR.PLAN_DT_ID ");
        sql.append("    LEFT JOIN MB_STATION_MASTER SM ON SM.COST_CENTER = APD.COST_CENTER ");
        sql.append(" WHERE 1=1 ");
        sql.append("    AND LTR.[RESULT] = 'N' ");
//        sql.append("    AND LTR.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_DATE)) ");
//        sql.append("    AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_DATE))) ");
        sql.append("    AND LTR.CREATE_DATE BETWEEN :V_FROM_DATE ");
        sql.append("    AND DATEADD(DAY, 1, :V_TO_DATE) ");
        if(!trip.equals("0")) {
            sql.append("    AND APD.TRIP_ID =:V_TRIP_ID ");
        }
        sql.append(" GROUP BY SM.CENTER_NAME, SM.PLACE, LTR.CREATE_DATE, P.PRODUCT_CODE ");
        List<ReportTableStationNotQA> list = npJdbcTemplate.query(sql.toString(), parameters, new RowMapper<ReportTableStationNotQA>() {
            @Override
            public ReportTableStationNotQA mapRow(ResultSet resultSet, int i) throws SQLException {
                return toDto(resultSet);
            }
        });
        return list;
    }

    private ReportTableStationNotQA toDto(ResultSet resultSet) throws SQLException {
        ReportTableStationNotQA dto = new ReportTableStationNotQA();
        dto.setStation(WsConstant.replaceNull(String.valueOf(resultSet.getString("CENTER_NAME"))));
        dto.setSaleArea(WsConstant.replaceNull(String.valueOf(resultSet.getString("PLACE"))));
        dto.setInspectionDate(WsConstant.replaceNull(String.valueOf(resultSet.getString("CREATE_DATE")).split(" ")[0]));
        dto.setUnacceptableProducts(WsConstant.replaceNull(String.valueOf(resultSet.getString("PRODUCT_CODE"))));
        return dto;
    }
}
