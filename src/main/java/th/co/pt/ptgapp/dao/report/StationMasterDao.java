package th.co.pt.ptgapp.dao.report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import th.co.pt.ptgapp.entity.ResultLTrBean;
import th.co.pt.ptgapp.entity.StationBean;

import java.util.*;

@Repository
public class StationMasterDao {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;

    //report 1
    public Map<String,Integer> getTotalStation(){
        Map<String,Integer> result = new HashMap<>();
        result.put("PTC",0);
        result.put("PTF",0);
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT TYPE_STATION,COUNT(1) AS TOTAL ");
            sql.append(" FROM MB_STATION_MASTER ");
            sql.append(" GROUP BY TYPE_STATION ");
            List<Map<String,Object>> list = jdbcTemplateSQLSERVER.queryForList(sql.toString());
            for(Map<String,Object> map : list){
                result.put(String.valueOf(map.get("TYPE_STATION")),Integer.parseInt(String.valueOf(map.get("TOTAL"))));
            }
        }catch (Exception e){
            logger.error("{}",e.getMessage());
            throw e;
        }
        return result;
    }

    //report 1
    public Map<String,Integer> getTotalLtr(Date dateFrom, Date dateTo){
        Map<String,Integer> result = new HashMap<>();
        result.put("PTC",0);
        result.put("PTF",0);
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT SM.TYPE_STATION,COUNT(1) AS TOTAL ");
            sql.append(" FROM MB_LTR_HD LH ");
            sql.append(" LEFT JOIN MB_ACTION_PLAN_DT APD ON LH.PLAN_DT_ID = APD.PLAN_DT_ID ");
            sql.append(" LEFT JOIN MB_STATION_MASTER SM ON APD.COST_CENTER = SM.COST_CENTER ");
            sql.append(" WHERE 1=1 ");
            sql.append(" AND LH.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_DATE)) AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_DATE))) ");
            sql.append(" GROUP BY SM.TYPE_STATION ");
            List<Map<String,Object>> list = jdbcTemplateSQLSERVER.queryForList(sql.toString(),
                    new MapSqlParameterSource()
                    .addValue("V_FROM_DATE", dateFrom)
                    .addValue("V_TO_DATE", dateTo));
            for(Map<String,Object> map : list){
                result.put(String.valueOf(map.get("TYPE_STATION")),Integer.parseInt(String.valueOf(map.get("TOTAL"))));
            }
        }catch (Exception e){
            logger.error("{}",e.getMessage());
            throw e;
        }
        return result;
    }

    //report 2
    public List<ResultLTrBean> getResultlLtr(Date dateFrom, Date dateTo){
        List<ResultLTrBean> result = new ArrayList<>();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT SM.TYPE_STATION,LH.PLAN_DT_ID, LH.[RESULT],COUNT(1) AS TOTAL ");
            sql.append(" FROM MB_LTR_HD LH ");
            sql.append(" LEFT JOIN MB_ACTION_PLAN_DT APD ON LH.PLAN_DT_ID = APD.PLAN_DT_ID ");
            sql.append(" LEFT JOIN MB_STATION_MASTER SM ON APD.COST_CENTER = SM.COST_CENTER ");
            sql.append(" WHERE 1=1 ");
            sql.append(" AND LH.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_DATE)) AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_DATE))) ");
            sql.append(" GROUP BY LH.[RESULT],LH.PLAN_DT_ID,SM.TYPE_STATION ");
            List<Map<String,Object>> list = jdbcTemplateSQLSERVER.queryForList(sql.toString(),
                    new MapSqlParameterSource()
                            .addValue("V_FROM_DATE", dateFrom)
                            .addValue("V_TO_DATE", dateTo));
            for(Map<String,Object> map : list){
                ResultLTrBean resultLTrBean = new ResultLTrBean();
                resultLTrBean.setTypeStation(String.valueOf(map.get("TYPE_STATION")));
                resultLTrBean.setPlantDt(String.valueOf(map.get("PLAN_DT_ID")));
                resultLTrBean.setResult(String.valueOf(map.get("RESULT")));
                resultLTrBean.setTotals(Integer.valueOf(String.valueOf(map.get("TOTAL"))));
                result.add(resultLTrBean);
            }
        }catch (Exception e){
            logger.error("{}",e.getMessage());
            throw e;
        }
        return result;
    }

    //report 3
    public List<ResultLTrBean> getReceiveOil(Date dateFrom, Date dateTo){
        List<ResultLTrBean> result = new ArrayList<>();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT LH.PLAN_DT_ID,APD.RECEIVEOIL ");
            sql.append(" FROM MB_LTR_HD LH ");
            sql.append(" LEFT JOIN MB_ACTION_PLAN_DT APD ON LH.PLAN_DT_ID = APD.PLAN_DT_ID ");
            sql.append(" LEFT JOIN MB_STATION_MASTER SM ON APD.COST_CENTER = SM.COST_CENTER ");
            sql.append(" WHERE 1=1 ");
            sql.append(" AND LH.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_DATE)) AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_DATE))) ");
            sql.append(" AND SM.TYPE_STATION = 'PTF' ");
            sql.append(" GROUP BY LH.PLAN_DT_ID,APD.RECEIVEOIL ");
            List<Map<String,Object>> list = jdbcTemplateSQLSERVER.queryForList(sql.toString(),
                    new MapSqlParameterSource()
                            .addValue("V_FROM_DATE", dateFrom)
                            .addValue("V_TO_DATE", dateTo));
            for(Map<String,Object> map : list){
                ResultLTrBean resultLTrBean = new ResultLTrBean();
                resultLTrBean.setTypeStation("PTF");
                resultLTrBean.setPlantDt(String.valueOf(map.get("PLAN_DT_ID")));
                resultLTrBean.setResult(String.valueOf(map.get("RECEIVEOIL")));
                resultLTrBean.setTotals(0);
                result.add(resultLTrBean);
            }
        }catch (Exception e){
            logger.error("{}",e.getMessage());
            throw e;
        }
        return result;
    }


    //report 5,6
    public List<ResultLTrBean> getResultTool(Date dateFrom, Date dateTo){
        List<ResultLTrBean> result = new ArrayList<>();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT SM.TYPE_STATION,TOOL.PLAN_DT_ID, TOOL.CHECK_FLG,COUNT(1) AS TOTAL ");
            sql.append(" FROM MB_LAB_MPTOOLS TOOL ");
            sql.append(" LEFT JOIN MB_ACTION_PLAN_DT APD ON TOOL.PLAN_DT_ID = APD.PLAN_DT_ID ");
            sql.append(" LEFT JOIN MB_STATION_MASTER SM ON APD.COST_CENTER = SM.COST_CENTER ");
            sql.append(" WHERE 1=1 ");
            sql.append(" AND TOOL.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_DATE)) AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_DATE))) ");
            sql.append(" GROUP BY TOOL.CHECK_FLG,TOOL.PLAN_DT_ID,SM.TYPE_STATION ");
            List<Map<String,Object>> list = jdbcTemplateSQLSERVER.queryForList(sql.toString(),
                    new MapSqlParameterSource()
                            .addValue("V_FROM_DATE", dateFrom)
                            .addValue("V_TO_DATE", dateTo));
            for(Map<String,Object> map : list){
                ResultLTrBean resultLTrBean = new ResultLTrBean();
                resultLTrBean.setTypeStation(String.valueOf(map.get("TYPE_STATION")));
                resultLTrBean.setPlantDt(String.valueOf(map.get("PLAN_DT_ID")));
                resultLTrBean.setResult(String.valueOf(map.get("CHECK_FLG")));
                resultLTrBean.setTotals(Integer.valueOf(String.valueOf(map.get("TOTAL"))));
                result.add(resultLTrBean);
            }
        }catch (Exception e){
            logger.error("{}",e.getMessage());
            throw e;
        }
        return result;
    }

    //report 7
    public List<ResultLTrBean> getResult5Liter(Date dateFrom, Date dateTo){
        List<ResultLTrBean> result = new ArrayList<>();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT SM.TYPE_STATION,LCK.PLAN_DT_ID, LCK.LAB_CHECK_COMP,COUNT(1) AS TOTAL ");
            sql.append(" FROM MB_LAB_CHECK LCK ");
            sql.append(" LEFT JOIN MB_ACTION_PLAN_DT APD ON LCK.PLAN_DT_ID = APD.PLAN_DT_ID ");
            sql.append(" LEFT JOIN MB_STATION_MASTER SM ON APD.COST_CENTER = SM.COST_CENTER ");
            sql.append(" WHERE 1=1 ");
            sql.append(" AND LCK.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_DATE)) AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_DATE))) ");
            sql.append(" AND SM.TYPE_STATION = 'PTC' ");
            sql.append(" GROUP BY LCK.LAB_CHECK_COMP,LCK.PLAN_DT_ID,SM.TYPE_STATION ");
            List<Map<String,Object>> list = jdbcTemplateSQLSERVER.queryForList(sql.toString(),
                    new MapSqlParameterSource()
                            .addValue("V_FROM_DATE", dateFrom)
                            .addValue("V_TO_DATE", dateTo));
            for(Map<String,Object> map : list){
                ResultLTrBean resultLTrBean = new ResultLTrBean();
                resultLTrBean.setTypeStation(String.valueOf(map.get("TYPE_STATION")));
                resultLTrBean.setPlantDt(String.valueOf(map.get("PLAN_DT_ID")));
                resultLTrBean.setResult(String.valueOf(map.get("LAB_CHECK_COMP")));
                resultLTrBean.setTotals(Integer.valueOf(String.valueOf(map.get("TOTAL"))));
                result.add(resultLTrBean);
            }
        }catch (Exception e){
            logger.error("{}",e.getMessage());
            throw e;
        }
        return result;
    }

    //report 8
    public List<ResultLTrBean> getResultTrain(Date dateFrom, Date dateTo){
        List<ResultLTrBean> result = new ArrayList<>();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT SM.TYPE_STATION,LSC.PLAN_DT_ID,COUNT(1) AS TOTAL ");
            sql.append(" FROM MB_LAB_SCORE LSC ");
            sql.append(" LEFT JOIN MB_ACTION_PLAN_DT APD ON LSC.PLAN_DT_ID = APD.PLAN_DT_ID ");
            sql.append(" LEFT JOIN MB_STATION_MASTER SM ON APD.COST_CENTER = SM.COST_CENTER ");
            sql.append(" WHERE 1=1 ");
            sql.append(" AND LSC.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_DATE)) AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_DATE))) ");
            sql.append(" AND SM.TYPE_STATION = 'PTC' ");
            sql.append(" GROUP BY LSC.PLAN_DT_ID,SM.TYPE_STATION ");
            List<Map<String,Object>> list = jdbcTemplateSQLSERVER.queryForList(sql.toString(),
                    new MapSqlParameterSource()
                            .addValue("V_FROM_DATE", dateFrom)
                            .addValue("V_TO_DATE", dateTo));
            for(Map<String,Object> map : list){
                ResultLTrBean resultLTrBean = new ResultLTrBean();
                resultLTrBean.setTypeStation(String.valueOf(map.get("TYPE_STATION")));
                resultLTrBean.setPlantDt(String.valueOf(map.get("PLAN_DT_ID")));
                resultLTrBean.setResult("Y");
                resultLTrBean.setTotals(Integer.valueOf(String.valueOf(map.get("TOTAL"))));
                result.add(resultLTrBean);
            }
        }catch (Exception e){
            logger.error("{}",e.getMessage());
            throw e;
        }
        return result;
    }


    public List<StationBean> getStationNotReceiveOil(Date dateFrom, Date dateTo){
        List<StationBean> result = new ArrayList<>();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT SM.CENTER_NAME,SM.PLACE,LTRH.CREATE_DATE,P.PRODUCT_NAME ");
            sql.append(" FROM MB_LTR_HD LTRH ");
            sql.append(" LEFT JOIN PRODUCT P ON SUBSTRING(P.PRODUCT_ID,8,9) = LTRH.PRODUCT_ID ");
            sql.append(" LEFT JOIN MB_ACTION_PLAN_DT APD ON LTRH.PLAN_DT_ID = APD.PLAN_DT_ID ");
            sql.append(" LEFT JOIN MB_STATION_MASTER SM ON SM.COST_CENTER = APD.COST_CENTER ");
            sql.append(" AND APD.RECEIVEOIL = '1' ");
            sql.append(" AND LTRH.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_DATE)) AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_DATE))) ");
            List<Map<String,Object>> list = jdbcTemplateSQLSERVER.queryForList(sql.toString(),
                    new MapSqlParameterSource()
                            .addValue("V_FROM_DATE", dateFrom)
                            .addValue("V_TO_DATE", dateTo));
            for(Map<String,Object> map : list){
                StationBean stationBean = new StationBean();
                stationBean.setStationName(String.valueOf(map.get("CENTER_NAME")));
                stationBean.setPlantDt(String.valueOf(map.get("PLACE")));
                stationBean.setChkDate(String.valueOf(map.get("CREATE_DATE")));
                stationBean.setProductName(String.valueOf(map.get("PRODUCT_NAME")));
                result.add(stationBean);
            }
        }catch (Exception e){
            logger.error("{}",e.getMessage());
            throw e;
        }
        return result;
    }

    public List<StationBean> getStationOffSpac(Date dateFrom, Date dateTo){
        List<StationBean> result = new ArrayList<>();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT SM.CENTER_NAME, SM.PLACE, LTR.CREATE_DATE, P.PRODUCT_NAME ");
            sql.append(" FROM MB_LTR_HD LTR ");
            sql.append(" LEFT JOIN PRODUCT P ON SUBSTRING(P.PRODUCT_ID,8,9) = LTR.PRODUCT_ID ");
            sql.append(" LEFT JOIN MB_ACTION_PLAN_DT APD ON APD.PLAN_DT_ID = LTR.PLAN_DT_ID ");
            sql.append(" LEFT JOIN MB_STATION_MASTER SM ON SM.COST_CENTER = APD.COST_CENTER ");
            sql.append(" AND LTR.[RESULT] = 'N' ");
            sql.append(" AND LTR.CREATE_DATE BETWEEN CONVERT(DATETIME, CONVERT(DATE, :V_FROM_DATE)) AND DATEADD(DAY, 1, CONVERT(DATETIME, CONVERT(DATE, :V_TO_DATE))) ");
            sql.append(" GROUP BY SM.CENTER_NAME, SM.PLACE, LTR.CREATE_DATE, P.PRODUCT_NAME ");
            List<Map<String,Object>> list = jdbcTemplateSQLSERVER.queryForList(sql.toString(),
                    new MapSqlParameterSource()
                            .addValue("V_FROM_DATE", dateFrom)
                            .addValue("V_TO_DATE", dateTo));
            for(Map<String,Object> map : list){
                StationBean stationBean = new StationBean();
                stationBean.setStationName(String.valueOf(map.get("CENTER_NAME")));
                stationBean.setPlantDt(String.valueOf(map.get("PLACE")));
                stationBean.setChkDate(String.valueOf(map.get("CREATE_DATE")));
                stationBean.setProductName(String.valueOf(map.get("PRODUCT_NAME")));
                result.add(stationBean);
            }
        }catch (Exception e){
            logger.error("{}",e.getMessage());
            throw e;
        }
        return result;
    }

}
