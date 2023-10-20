package th.co.pt.ptgapp.dao ;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import th.co.pt.ptgapp.controller.bean.UserDto;
 
//import th.co.pt.ptgapp.utils.JdbcTmpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserDao  {

//    @Autowired
//    private JdbcTmpl jdbcTmpl;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<UserDto> getUser(String id) {
        List<UserDto> result = new ArrayList<UserDto>();
        String sp = "SEARCH_EMPLOYEE";
        try {

            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PKG_HRMWS_SERVICE")
                    .withProcedureName(sp)
                    .returningResultSet("P_CURSOR",
                            new BeanPropertyRowMapper(UserDto.class));

            result = call.executeFunction(List.class,id);

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            // ex.printStackTrace();
        }
        return result;
    }
//    @Override
//    @Transactional
//    public UserDto getUser(String id) throws Exception {
//            String sql="";
//        UserDto retDto= new UserDto();
//        sql = sql + "  select * from HRMS.Movement_V";
//        System.out.println("SQL = " + sql);
//        List<Map> UserList = this.jdbcTmpl.executeQuery(sql, Map.class);
//        if(UserList.size()>0) {
//            retDto.setUser(jdbcTmpl.chkNull((String) ((Map) UserList.get(0)).get(1)));
////            retDto.setUser(jdbcTmpl.chkNull((String) ((Map) UserList.get(0)).get("fild")));
//        }
//        // access DB
//        return new UserDto();
//    }
}
