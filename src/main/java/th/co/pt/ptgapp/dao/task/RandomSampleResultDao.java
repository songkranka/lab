package th.co.pt.ptgapp.dao.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.WsConstant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RandomSampleResultDao {

    @Autowired
    private NamedParameterJdbcTemplate npJdbcTemplate;

    public List<RandomSampleResultDto> findRandomSampleByLabCode(List<String> labCodeList) {
        StringBuffer sql = new StringBuffer();
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("labCodeList", labCodeList);
        sql.append(" SELECT ");
        sql.append("    a.LAB_CODE,a.PLANT_ID, ");
        sql.append("    (select b.plant_name  from plant b where b.plant_id=a.plant_id  ) as plant_name ");
        sql.append("    ,a.DO_NO,a.PO_NO,a.SHIPMENT_NO,a.CAR_SLOT,convert(char, a.SAMPLE_EXPIRE_DATE, 103) as STR_SAMPLE_EXPIRE_DATE ");
        sql.append("    ,convert(char, a.SAMPLE_DATE, 103) as STR_SAMPLE_DATE ");
        sql.append("    ,(select b.SAMPLE_LEVEL_DESC  from  MASTER_GET_SAMPLE b where b.SAMPLE_LEVEL_CODE=a.SAMPLE_LEVEL_CODE ) as SAMPLE_LEVEL_DESC ");
        sql.append("    ,a.CAR_NO,a.CAR_SLOT ,a.BOAT_NO,a.BOAT_NAME,a.BOAT_SLOT,a.TANK_NO ");
        sql.append("    ,a.CREATE_BY,a.SAMPLE_STAFF_ID,a.SAMPLE_STAFF_NAME ,a.SAMPLE_REFER,a.SAMPLE_DATA_GROUP,a.SAMPLE_DATA_SEQ ");
        sql.append("    ,a.SOURCE_ID,(select b.SOURCE_name  from SOURCE b where b.SOURCE_ID=a.SOURCE_id ) as source_name ,a.PRODUCT_ID ");
        sql.append("    ,(select b.product_code  from product b where b.PRODUCT_ID=a.product_id ) as PRODUCT_CODE ");
        sql.append("    ,(select b.product_name  from product b where b.PRODUCT_ID=a.product_id ) as product_name ");
        sql.append("    ,a.LOGIS_ID,(select b.logis_name  from Logistics b where b.LOGIS_ID=a.LOGIS_ID )as logis_name ");
        sql.append("    ,a.PO_DATE, a.status , convert(char, a.PO_DATE, 103) STRPO_DATE ");
        sql.append("    ,re.COLOR_FLAG,l.RESULT_STATUS ");
        sql.append("    ,(case when  l.RESULT_STATUS is   null  then 'หมอบหมายงาน' when  l.RESULT_STATUS = '01' then 'บันทึกผลการทดสอบ' end ) STATUS_DESC,ST.SAMPLE_TYPE_CODE ");
        sql.append("    ,ST.SAMPLE_TYPE_NAME,re.ASSIGN_STATUS ");
        sql.append(" FROM RANDOM_SAMPLE_RESULT  a ");
        sql.append("    inner join RANDOM_SAMPLE_LAST_RESULT re on re.LAB_CODE   = a.LAB_CODE ");
        sql.append("    left join LTR l on l.LAB_CODE = re.LAB_CODE ");
        sql.append("    LEFT JOIN MASTER_SAMPLE_TYPE ST ON ST.SAMPLE_TYPE_CODE = A.SAMPLE_TYPE ");
        sql.append(" WHERE 1=1 ");
        //sql.append("    and a.status <> '04' and (l.result_status ='01' or l.result_status is null) ");
        sql.append("    and a.LAB_CODE in (:labCodeList) ");
        List<RandomSampleResultDto> list = npJdbcTemplate.query(sql.toString(), parameters, new RowMapper<RandomSampleResultDto>() {
            @Override
            public RandomSampleResultDto mapRow(ResultSet resultSet, int i) throws SQLException {
                return toDto(resultSet);
            }
        });
        return list;
    }

    private RandomSampleResultDto toDto(ResultSet resultSet) throws SQLException {
        RandomSampleResultDto dto = new RandomSampleResultDto();
        dto.setLabCode(WsConstant.replaceNull(resultSet.getString("LAB_CODE")));
        dto.setPlantId(WsConstant.replaceNull(resultSet.getString("PLANT_ID")));
        dto.setPlantName(WsConstant.replaceNull(resultSet.getString("plant_name")));
        dto.setDoNo(WsConstant.replaceNull(resultSet.getString("DO_NO")));
        dto.setPoNo(WsConstant.replaceNull(resultSet.getString("PO_NO")));
        dto.setShipmentNo(WsConstant.replaceNull(resultSet.getString("SHIPMENT_NO")));
        dto.setCarSlot(WsConstant.replaceNull(resultSet.getString("CAR_SLOT")));
        dto.setStrSampleExpreDate(WsConstant.replaceNull(resultSet.getString("STR_SAMPLE_EXPIRE_DATE")));
        dto.setBoatNo(WsConstant.replaceNull(resultSet.getString("BOAT_NO")));
        dto.setBoatName(WsConstant.replaceNull(resultSet.getString("BOAT_NAME")));
        dto.setBoatSlot(WsConstant.replaceNull(resultSet.getString("BOAT_SLOT")));
        dto.setTankNo(WsConstant.replaceNull(resultSet.getString("TANK_NO")));
        dto.setCreateBy(WsConstant.replaceNull(resultSet.getString("CREATE_BY")));
        dto.setSampleStaffId(WsConstant.replaceNull(resultSet.getString("SAMPLE_STAFF_ID")));
        dto.setSampleStaffName(WsConstant.replaceNull(resultSet.getString("SAMPLE_STAFF_NAME")));
        dto.setSampleRefer(WsConstant.replaceNull(resultSet.getString("SAMPLE_REFER")));
        dto.setSampleDataGroup(WsConstant.replaceNull(resultSet.getString("SAMPLE_DATA_GROUP")));
        dto.setSampleDataSeq(WsConstant.replaceNull(resultSet.getString("SAMPLE_DATA_SEQ")));
        dto.setSourceId(WsConstant.replaceNull(resultSet.getString("SOURCE_ID")));
        dto.setSourceName(WsConstant.replaceNull(resultSet.getString("source_name")));
        dto.setProductId(WsConstant.replaceNull(resultSet.getString("PRODUCT_ID")));
        dto.setProductCode(WsConstant.replaceNull(resultSet.getString("PRODUCT_CODE")));
        dto.setProductName(WsConstant.replaceNull(resultSet.getString("product_name")));
        dto.setLogisId(WsConstant.replaceNull(resultSet.getString("LOGIS_ID")));
        dto.setLogisName(WsConstant.replaceNull(resultSet.getString("logis_name")));
        dto.setPoDate(WsConstant.replaceNull(resultSet.getString("PO_DATE")));
        dto.setStatus(WsConstant.replaceNull(resultSet.getString("status")));
        dto.setStrpoDate(WsConstant.replaceNull(resultSet.getString("STRPO_DATE")));
        dto.setColorFlag(WsConstant.replaceNull(resultSet.getString("COLOR_FLAG")));
        dto.setResultStatus(WsConstant.replaceNull(resultSet.getString("RESULT_STATUS")));
        dto.setStatusDesc(WsConstant.replaceNull(resultSet.getString("STATUS_DESC")));
        dto.setSampleTypeCode(WsConstant.replaceNull(resultSet.getString("SAMPLE_TYPE_CODE")));
        dto.setSampleTypeName(WsConstant.replaceNull(resultSet.getString("SAMPLE_TYPE_NAME")));
        dto.setAssignStatus(WsConstant.replaceNull(resultSet.getString("ASSIGN_STATUS")));
        return dto;
    }
}
