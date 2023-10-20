package th.co.pt.ptgapp.dao.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TripDao {

    @Autowired
    private NamedParameterJdbcTemplate npJdbcTemplate;

    public List<TripDto> findTripByComplete() {
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT TRIP_ID, TRIP_NAME FROM MB_ACTION_PLAN_HD WHERE COMPLETE_FLG = 'Y' ");
        List<TripDto> list = npJdbcTemplate.query(sql.toString(), new RowMapper<TripDto>() {
            @Override
            public TripDto mapRow(ResultSet resultSet, int i) throws SQLException {
                return toDto(resultSet);
            }
        });
        return list;
    }

    private TripDto toDto(ResultSet resultSet) throws SQLException {
        TripDto dto = new TripDto(String.valueOf(resultSet.getString("TRIP_ID")),String.valueOf(resultSet.getString("TRIP_NAME")));
        return dto;
    }
}

