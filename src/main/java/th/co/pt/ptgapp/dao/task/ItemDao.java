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
public class ItemDao {

    @Autowired
    private NamedParameterJdbcTemplate npJdbcTemplate;

    public List<ItemDto> findItemByReqNo(String wfId) {
        StringBuffer sql = new StringBuffer();
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("wfId", wfId);
        sql.append(" SELECT H.WF_ID,H.REQ_ITEM_ID,D.REQ_DTL_NO,D.ANALYZE_CODE,D.ANALYZE_VALUE,D.MATERIAL_CODE,D.MATERIAL_VALUE,D.METHOD_CODE,D.METHOD_VALUE,D.SPEC_CODE,D.SPEC_VALUE, ");
        sql.append(" D.SPEC2_CODE,D.SPEC2_VALUE,D.UNIT_CODE,D.UNIT_VALUE,M.EMP_ID,M.EMP_NAME,M.WORK_GROUP ");
        sql.append(" FROM GET_ITEM_REQT_HD H");
        sql.append(" LEFT JOIN GET_ITEM_REQT_DL D ON H.REQ_ITEM_ID = D.REQ_ITEM_ID ");
        sql.append(" LEFT JOIN GET_ITEM_WORKGROUP M ON D.REQ_DTL_NO = M.REQ_DTL_NO ");
        sql.append(" WHERE H.WF_ID =:wfId  ");
        List<ItemDto> list = npJdbcTemplate.query(sql.toString(), parameters, new RowMapper<ItemDto>() {
            @Override
            public ItemDto mapRow(ResultSet resultSet, int i) throws SQLException {
                return toDto(resultSet);
            }
        });
        return list;
    }

    private ItemDto toDto(ResultSet resultSet) throws SQLException {
        ItemDto dto = new ItemDto();
        dto.setWfId(WsConstant.replaceNull(resultSet.getString("WF_ID")));
        dto.setReqItemId(WsConstant.replaceNull(resultSet.getString("REQ_ITEM_ID")));
        dto.setReqDtlNo(WsConstant.replaceNull(resultSet.getString("REQ_DTL_NO")));
        dto.setAnalyzeCode(WsConstant.replaceNull(resultSet.getString("ANALYZE_CODE")));
        dto.setAnalyzeValue(WsConstant.replaceNull(resultSet.getString("ANALYZE_VALUE")));
        dto.setMeterialCode(WsConstant.replaceNull(resultSet.getString("MATERIAL_CODE")));
        dto.setMeterialValue(WsConstant.replaceNull(resultSet.getString("MATERIAL_VALUE")));
        dto.setMethodCode(WsConstant.replaceNull(resultSet.getString("METHOD_CODE")));
        dto.setMethodValue(WsConstant.replaceNull(resultSet.getString("METHOD_VALUE")));
        dto.setSpaceCode(WsConstant.replaceNull(resultSet.getString("SPEC_CODE")));
        dto.setSpaceValue(WsConstant.replaceNull(resultSet.getString("SPEC_VALUE")));
        dto.setSpace2Code(WsConstant.replaceNull(resultSet.getString("SPEC2_CODE")));
        dto.setSpace2Value(WsConstant.replaceNull(resultSet.getString("SPEC2_VALUE")));
        dto.setUnitCode(WsConstant.replaceNull(resultSet.getString("UNIT_CODE")));
        dto.setUnitValue(WsConstant.replaceNull(resultSet.getString("UNIT_VALUE")));
        dto.setEmpId(WsConstant.replaceNull(resultSet.getString("EMP_ID")));
        dto.setEmpName(WsConstant.replaceNull(resultSet.getString("EMP_NAME")));
        dto.setWorkGroup(WsConstant.replaceNull(resultSet.getString("WORK_GROUP")));
        dto.setReadOnly(true);
        return dto;
    }
}
