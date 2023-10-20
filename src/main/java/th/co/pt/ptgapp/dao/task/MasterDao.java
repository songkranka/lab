package th.co.pt.ptgapp.dao.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MasterDao {

    @Autowired
    private NamedParameterJdbcTemplate npJdbcTemplate;

    public List<DrawdownDto> getVisualDdl() {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT CODE,NAME FROM MASTER_VISUAL ");
        List<DrawdownDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<DrawdownDto>() {
            @Override
            public DrawdownDto mapRow(ResultSet resultSet, int i) throws SQLException {
                DrawdownDto dto = new DrawdownDto();
                dto.setCode(resultSet.getString("CODE"));
                dto.setValue(resultSet.getString("NAME"));
                return dto;
            }
        });
        return list;
    }


    public List<DrawdownDto> getColorDdl() {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT CODE,NAME FROM MASTER_COLOR ");
        List<DrawdownDto> list = npJdbcTemplate.query(sql.toString(),parameters, new RowMapper<DrawdownDto>() {
            @Override
            public DrawdownDto mapRow(ResultSet resultSet, int i) throws SQLException {
                DrawdownDto dto = new DrawdownDto();
                dto.setCode(resultSet.getString("CODE"));
                dto.setValue(resultSet.getString("NAME"));
                return dto;
            }
        });
        return list;
    }
}
