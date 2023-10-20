package th.co.pt.ptgapp.dao.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import th.co.pt.ptgapp.utils.DateUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ReportReceiveOilDao {

    @Autowired
    private NamedParameterJdbcTemplate npJdbcTemplate;

    public List<ReportReceiveOilDto> getFranchiseReceiveOil(String sDate,String eDate, String trip,String flagReceive) {
        Date startDate = DateUtil.stringTodate(sDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        Date endDate = DateUtil.stringTodate(eDate,DateUtil.DATE_PATTERN_DDMMYYYY,DateUtil.ENG_LOCALE);
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("V_FROM_UPDATE_DATE",startDate);
        parameters.addValue("V_TO_UPDATE_DATE",endDate);
        parameters.addValue("V_RECEIVEOIL",flagReceive);
        if(!trip.equals("0")) {
            parameters.addValue("V_TRIP_ID",trip);
        }
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT PR.PLANT_RECEIVE_NAMEEN as PLANT_RECEIVE,COUNT(1) AS TOTALS ");
        sql.append(" FROM MB_ACTION_PLAN_HD H ");
        sql.append("    LEFT JOIN MB_ACTION_PLAN_DT D ON H.TRIP_ID = D.TRIP_ID ");
        sql.append("    LEFT JOIN MB_STATION_MASTER SM ON SM.COST_CENTER = D.COST_CENTER ");
        sql.append("    LEFT JOIN MB_LTR_HD LH ON LH.PLAN_DT_ID = D.PLAN_DT_ID ");
        sql.append("    LEFT JOIN MB_PLANT_RECEIVE PR ON PR.PLANT_RECEIVE_NAMETH = SM.PLANT_RECEIVE ");
        sql.append(" WHERE 1=1 ");
        sql.append("    AND SM.TYPE_STATION = 'PTF' ");
        if(!trip.equals("0")) {
            sql.append("    AND D.TRIP_ID =:V_TRIP_ID ");
        }
        sql.append("    AND D.RECEIVEOIL =:V_RECEIVEOIL ");
        sql.append("    AND SM.PLANT_RECEIVE IS NOT NULL");
        
//        sql.append("    AND H.UPDATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_UPDATE_DATE)) ");
//        sql.append("    AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_UPDATE_DATE))) ");
        sql.append("    AND H.UPDATE_DATE BETWEEN :V_FROM_UPDATE_DATE ");
        sql.append("    AND DATEADD(DAY, 1, :V_TO_UPDATE_DATE) ");
        sql.append(" GROUP BY PR.PLANT_RECEIVE_NAMEEN ");
        List<ReportReceiveOilDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportReceiveOilDto>() {
            @Override
            public ReportReceiveOilDto mapRow(ResultSet resultSet, int i) throws SQLException {
                return toDto(resultSet);
            }
        });
        List<ReportReceiveOilDto> plist = getTotalPlan(flagReceive);
        List<ReportReceiveOilDto> pTemp = new ArrayList<>();
        for(ReportReceiveOilDto a : plist){
            pTemp = list.stream()
                    .filter(e->e.getPlantReceive().equalsIgnoreCase(a.getPlantReceive()))
                    .collect(Collectors.toList());
            if(pTemp.isEmpty()){
                list.add(a);
            }
        }
        return list;
    }


    public List<ReportReceiveOilDto> getTotalPlan(String flag) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT PR.PLANT_RECEIVE_NAMEEN as PLANT_RECEIVE ");
        sql.append(" FROM MB_STATION_MASTER SM ");
        sql.append(" LEFT JOIN MB_PLANT_RECEIVE PR ON PR.PLANT_RECEIVE_NAMETH = SM.PLANT_RECEIVE ");
        sql.append(" WHERE SM.PLANT_RECEIVE IS NOT NULL ");
        sql.append(" AND SM.TYPE_STATION = 'PTF' ");
        sql.append(" GROUP BY PR.PLANT_RECEIVE_NAMEEN ");
        List<ReportReceiveOilDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<ReportReceiveOilDto>() {
            @Override
            public ReportReceiveOilDto mapRow(ResultSet resultSet, int i) throws SQLException {
                return toPlant(resultSet);
            }
        });
        list.stream().forEach(e->e.setReceiveOil(flag));
//        List<ReportReceiveOilDto> tempList = new ArrayList<ReportReceiveOilDto>(list);
//        for(ReportReceiveOilDto ls : tempList){
//            ls.setReceiveOil("2");
//            list.add(ls);
//        }
        return list;
    }

    private ReportReceiveOilDto toPlant(ResultSet resultSet) throws SQLException {
        ReportReceiveOilDto dto = new ReportReceiveOilDto(
                String.valueOf(resultSet.getString("PLANT_RECEIVE")),
                "1",
                0);
        return dto;
    }
    private ReportReceiveOilDto toDto(ResultSet resultSet) throws SQLException {
        ReportReceiveOilDto dto = new ReportReceiveOilDto(
                String.valueOf(resultSet.getString("PLANT_RECEIVE")),
                "1",
                Integer.parseInt(String.valueOf(resultSet.getString("TOTALS"))));
        return dto;
    }

}
