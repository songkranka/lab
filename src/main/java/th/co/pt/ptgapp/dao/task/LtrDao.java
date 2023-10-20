package th.co.pt.ptgapp.dao.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LtrDao {

    @Autowired
    private NamedParameterJdbcTemplate npJdbcTemplate;

    /********* Flag_Save *********/
    public boolean saveFlagAll(String labCode) throws Exception {
        StringBuffer sql = new StringBuffer();
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("labCode", labCode);
        sql.append(" select l.ltr_no ");
        sql.append(" from ltr as l ");
        sql.append(" left join ltr_dte d on l.ltr_no = d.ltr_no ");
        sql.append(" where l.lab_code = :labCode and d.flag_save != 'Y' and l.result_status != '06' ");
        List<String> list = npJdbcTemplate.query(sql.toString(), parameters, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString("ltr_no");
            }
        });
        return list.isEmpty()?true:false;
    }

    /********* LTR Operator*********/
    public LtrDto findLtrByLabCode(String labCode) {
        StringBuffer sql = new StringBuffer();
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("labCode", labCode);
        sql.append(" SELECT * FROM LTR WHERE LAB_CODE = :labCode AND RESULT_STATUS != '06' ");
        List<LtrDto> list = npJdbcTemplate.query(sql.toString(), parameters, new RowMapper<LtrDto>() {
            @Override
            public LtrDto mapRow(ResultSet resultSet, int i) throws SQLException {
                LtrDto dto = new LtrDto();
                dto.setLabCode(resultSet.getString("LAB_CODE"));
                dto.setLtrNo(resultSet.getString("LTR_NO"));
                dto.setResultStatus(resultSet.getString("RESULT_STATUS"));
                dto.setResultLtr(resultSet.getString("RESULT_LTR"));
                return dto;
            }
        });
        return list.size()>0?list.get(0):null;
    }

    public LtrDto insertLtr(LtrDto dto) {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" INSERT INTO LTR(LAB_CODE,LTR_NO,RESULT_STATUS,CREATE_BY,CREATE_DATE, UPDATE_BY,RESULT_LTR,UPDATE_DATE) ");
            sql.append(" VALUES( ");
            sql.append(" :labcode, ");
            sql.append(" :ltrNo, ");
            sql.append(" :resultStatus, ");
            sql.append(" :createBy, ");
            sql.append(" GETDATE(), ");
            sql.append(" :updateBy, ");
            sql.append(" :resultLtr, ");
            sql.append(" GETDATE()) ");
            Map parameters = new HashMap();
            parameters.put("labcode", dto.getLabCode());
            parameters.put("resultStatus", dto.getResultStatus());
            parameters.put("ltrNo", dto.getLtrNo());
            parameters.put("createBy", dto.getCreateBy());
            parameters.put("resultLtr",dto.getResultLtr());
            parameters.put("updateBy", dto.getUpdateBy());
            System.out.println(sql.toString());
            npJdbcTemplate.update(sql.toString(), parameters);
            return dto;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public boolean updateLtrResultStatus(LtrDto dto) {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("UPDATE LTR SET RESULT_STATUS  = :resultStatus, UPDATE_BY = :updateBy, UPDATE_DATE  = GETDATE() WHERE LAB_CODE = :labCode AND RESULT_STATUS != '06' ");
            MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue("resultStatus", dto.getResultStatus());
            parameters.addValue("updateBy", dto.getUpdateBy());
            parameters.addValue("labCode", dto.getLabCode());
            npJdbcTemplate.update(sql.toString(), parameters);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public boolean updateResultLtr(LtrDto dto) {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("UPDATE LTR SET RESULT_LTR = :resultLtr, UPDATE_BY = :updateBy, UPDATE_DATE  = GETDATE() WHERE LAB_CODE = :labCode AND RESULT_STATUS != '06' ");
            MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue("resultLtr", dto.getResultLtr());
            parameters.addValue("updateBy", dto.getUpdateBy());
            parameters.addValue("labCode", dto.getLabCode());
            npJdbcTemplate.update(sql.toString(), parameters);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public String genLtrNo() {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT CONCAT(right(CONVERT(VARCHAR(10), getDate(), 112),6), TRIM(FORMAT(ISNULL(max(SUBSTRING(LTR_NO, 7 , 4)),'0000')+1,'0000'))) from LTR where  right(CONVERT(VARCHAR(10), CREATE_DATE, 112),6) = right(CONVERT(VARCHAR(10), getDate(), 112),6) ");
            MapSqlParameterSource parameters = new MapSqlParameterSource();
            List<String> list = npJdbcTemplate.query(sql.toString(), parameters, new RowMapper<String>() {
                @Override
                public String mapRow(ResultSet resultSet, int i) throws SQLException {
                    return resultSet.getString(1);
                }
            });
            return list.size()>0?list.get(0):null;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    /********* LTR_DTE Operator *********/
    public List<LtrDtlDto> findLtrDtlByLtrNo(String ltrNo) {
        StringBuffer sql = new StringBuffer();
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("ltrNo", ltrNo);
        sql.append(" SELECT ANALYZE_CODE,LTR_NO,LTR_NO_DTE,ID_MATERIAL,[ROLE],COLOR,COLOR_DESC,VISUAL,VISUAL_DESC,FLAG_SAVE,[RESULT],CREATE_BY,UPDATE_BY FROM LTR_DTE WHERE LTR_NO = :ltrNo ");
        List<LtrDtlDto> list = npJdbcTemplate.query(sql.toString(), parameters, new RowMapper<LtrDtlDto>() {
            @Override
            public LtrDtlDto mapRow(ResultSet resultSet, int i) throws SQLException {
                LtrDtlDto dto = new LtrDtlDto();
                dto.setLtrNo(resultSet.getString("LTR_NO"));
                dto.setLtrNoDtl(resultSet.getString("LTR_NO_DTE"));
                dto.setColor(resultSet.getString("COLOR"));
                dto.setColorDesc(resultSet.getString("COLOR_DESC"));
                dto.setCreateBy(resultSet.getString("CREATE_BY"));
                dto.setUpdateBy(resultSet.getString("UPDATE_BY"));
                dto.setFlagSave(resultSet.getString("FLAG_SAVE"));
                dto.setIdMaterial(resultSet.getString("ID_MATERIAL"));
                dto.setResult(resultSet.getString("RESULT"));
                dto.setRole(resultSet.getString("ROLE"));
                dto.setVisual(resultSet.getString("VISUAL"));
                dto.setVisualDesc(resultSet.getString("VISUAL_DESC"));
                dto.setIdAnalyze(resultSet.getString("ANALYZE_CODE"));
                return dto;
            }
        });
        return list;
    }

    public LtrDtlDto insertLtrDtl(LtrDtlDto dto) {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" INSERT INTO LTR_DTE(LTR_NO,LTR_NO_DTE,ID_MATERIAL,[ROLE],COLOR,COLOR_DESC,[RESULT],FLAG_SAVE,CREATE_BY,CREATE_DATE,UPDATE_BY,UPDATE_DATE,VISUAL,VISUAL_DESC,FLAG_RESULT,ANALYZE_CODE) ");
            sql.append(" VALUES (:ltrNo, :ltrNoDte, :idMaterial, :role, :color, :colorDesc, :result, :flagSave, :createBy, GETDATE(), :updateBy, GETDATE(), :visual, :visualDesc, :flagResult, :idAnalyze ) ");
            Map parameters = new HashMap();
            parameters.put("ltrNo", dto.getLtrNo());
            parameters.put("ltrNoDte", dto.getLtrNoDtl());
            parameters.put("idMaterial", dto.getIdMaterial());
            parameters.put("role", dto.getRole());
            parameters.put("color", dto.getColor());
            parameters.put("colorDesc", dto.getColorDesc());
            parameters.put("result", dto.getResult());
            parameters.put("flagSave", dto.getFlagSave());
            parameters.put("createBy", dto.getCreateBy());
            parameters.put("updateBy", dto.getUpdateBy());
            parameters.put("visual", dto.getVisual());
            parameters.put("visualDesc", dto.getVisualDesc());
            parameters.put("flagResult", dto.getFlagResult());
            parameters.put("idAnalyze", dto.getIdAnalyze());
            npJdbcTemplate.update(sql.toString(), parameters);
            return dto;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public LtrDtlDto updateLtrdtl(LtrDtlDto dto) {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" UPDATE LTR_DTE SET [ROLE] = :role, COLOR = :color, COLOR_DESC = :colorDesc, [RESULT] = :result, ");
            sql.append(" FLAG_SAVE = :flagSave, VISUAL = :visual, VISUAL_DESC = :visualDesc, FLAG_RESULT = :flagResult, UPDATE_BY = :updateBy, UPDATE_DATE = GETDATE() ");
            sql.append(" WHERE LTR_NO = :ltrNo AND ID_MATERIAL = :idMaterial ");
            MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue("role", dto.getRole());
            parameters.addValue("color", dto.getColor());
            parameters.addValue("colorDesc", dto.getColorDesc());
            parameters.addValue("result", dto.getResult());
            parameters.addValue("flagSave", dto.getFlagSave());
            parameters.addValue("visual", dto.getVisual());
            parameters.addValue("visualDesc", dto.getVisualDesc());
            parameters.addValue("flagResult", dto.getFlagResult());
            parameters.addValue("updateBy", dto.getUpdateBy());
            parameters.addValue("ltrNo", dto.getLtrNo());
            parameters.addValue("idMaterial", dto.getLtrNoDtl());
            npJdbcTemplate.update(sql.toString(), parameters);
            return dto;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }


    public boolean resultFlagY(String labCode) throws Exception {
        StringBuffer sql = new StringBuffer();
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("labCode", labCode);
        sql.append(" select l.ltr_no ");
        sql.append(" from ltr as l ");
        sql.append(" left join ltr_dte d on l.ltr_no = d.ltr_no ");
        sql.append(" where l.lab_code = :labCode and d.flag_result != 'Y' and l.result_status != '06' ");
        List<String> list = npJdbcTemplate.query(sql.toString(), parameters, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString("ltr_no");
            }
        });
        return list.isEmpty()?true:false;
    }

    public List<LtrJoinltrDtlDto> getLtrDtlByLabCode(String labCode){
        StringBuffer sql = new StringBuffer();
        List<LtrJoinltrDtlDto> list = null;
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("labCode", labCode);
        sql.append(" select l.lab_code, l.ltr_no,ld.ltr_no_dte,ld.id_material,ld.[role],ld.color,ld.color_desc,ld.[result], ");
        sql.append(" ld.flag_save,ld.update_by,ld.visual,ld.visual_desc,ld.flag_result,ld.analyze_code ");
        sql.append(" from ltr l ");
        sql.append(" left join ltr_dte ld on l.ltr_no = ld.ltr_no ");
        sql.append(" where l.lab_code = :labCode and l.result_status != '06' ");
        list = npJdbcTemplate.query(sql.toString(), parameters, new RowMapper<LtrJoinltrDtlDto>() {
            @Override
            public LtrJoinltrDtlDto mapRow(ResultSet resultSet, int i) throws SQLException {
                LtrJoinltrDtlDto dto = new LtrJoinltrDtlDto();
                dto.setLabcode(resultSet.getString("lab_code"));
                dto.setLtrNo(resultSet.getString("ltr_no"));
                dto.setIdMaterial(resultSet.getString("id_material"));
                dto.setRole(resultSet.getString("role"));
                dto.setColor(resultSet.getString("color"));
                dto.setColorDesc(resultSet.getString("color_desc"));
                dto.setResult(resultSet.getString("result"));
                dto.setFlagSave(resultSet.getString("flag_save"));
                dto.setUpdateBy(resultSet.getString("update_by"));
                dto.setVisual(resultSet.getString("visual"));
                dto.setVisualDesc(resultSet.getString("visual_desc"));
                dto.setFlagResult(resultSet.getString("flag_result"));
                dto.setAnalyzeCode(resultSet.getString("analyze_code"));
                return dto;
            }
        });
        return list;
    }

}
