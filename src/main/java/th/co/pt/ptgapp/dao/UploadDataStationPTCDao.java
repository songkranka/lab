package th.co.pt.ptgapp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import th.co.pt.ptgapp.controller.bean.MbStationMaster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UploadDataStationPTCDao {

    @Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public Map<String, Object> importMasterStationPTC(List<MbStationMaster> list){
    	
    	Map<String, Object> reault = new HashMap<String, Object>();
    	int size = list.size();
    	
    	logger.info("List<MbStationMaster> size = "+size);
    	if(size > 0) {

    		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("insertStationMaster") ;
    		
    		// SqlParameterSource in = null;	
    		for (int i = 0; i < size; i++) {

    			MbStationMaster entity = (MbStationMaster)list.get(i);
    			//logger.info("  entity : "+entity.toString());
    			
    			SqlParameterSource in = new MapSqlParameterSource() 
    					.addValue("type",entity.getType(),Types.VARCHAR)
    					.addValue("productId",entity.getProductID(),Types.VARCHAR)
    					.addValue("siteCode",entity.getSiteCode(),Types.VARCHAR)
    					.addValue("ref",entity.getRef(),Types.VARCHAR)
    					.addValue("place",entity.getPlace(),Types.VARCHAR)
    					.addValue("plantId",entity.getPlantID(),Types.VARCHAR)
    					.addValue("costCenter",entity.getCostCenter(),Types.VARCHAR)
    					.addValue("profitCenter",entity.getProfitCenter(),Types.VARCHAR)
    					.addValue("centerName",entity.getCenterName(),Types.VARCHAR)
    					.addValue("part",entity.getPart(),Types.VARCHAR)
    					.addValue("addrTumbon",entity.getAddrTumbon(),Types.VARCHAR)
    					.addValue("addrAmphur",entity.getAddrAmphur(),Types.VARCHAR)
    					.addValue("addrProvince",entity.getAddrProvince(),Types.VARCHAR)
    					.addValue("postCode",entity.getPostCode(),Types.VARCHAR)
    					.addValue("address",entity.getAddress(),Types.VARCHAR)
    					.addValue("model",entity.getModel(),Types.VARCHAR)
    					.addValue("plantReceive",entity.getPlantReceive(),Types.VARCHAR)
    					.addValue("operatingStatus",entity.getOperatingStatus(),Types.VARCHAR)
    					.addValue("email",entity.getEmail(),Types.VARCHAR)
    					.addValue("phoneNo",entity.getPhoneNo(),Types.VARCHAR)
    					.addValue("mobileNo",entity.getMobileNo(),Types.VARCHAR)
    					.addValue("gps",entity.getGps(),Types.VARCHAR)
    					.addValue("createBy",entity.getCreateBy(),Types.VARCHAR)
    					.addValue("typeStation",entity.getTypeStation(),Types.VARCHAR)
    					
    					.addValue("pResult",Types.VARCHAR)
    					.addValue("pMessage",Types.VARCHAR);

    			//logger.info("param >> type : " + entity.getType() + " ,productId : " + entity.getProductID() + " ,siteCode : " + entity.getSiteCode() + " ,ref : " + entity.getRef() + " ,place : " + entity.getPlace() + " ,plantId : " + entity.getPlantID() + " ,costCenter : " + entity.getCostCenter() + " ,profitCenter : " + entity.getProfitCenter() + " ,centerName : " + entity.getCenterName() + " ,part : " + entity.getPart() + " ,addrTumbon : " + entity.getAddrTumbon() + " ,addrAmphur : " + entity.getAddrAmphur() + " ,addrProvince : " + entity.getAddrProvince() + " ,postCode : " + entity.getPostCode() + " ,address : " + entity.getAddress() + " ,entity : " + entity.getModel() + " ,plantReceive : " + entity.getPlantReceive() + " ,operatingStatus : " + entity.getOperatingStatus() + " ,email : " + entity.getEmail() + " ,phoneNo : " + entity.getPhoneNo() + " ,mobileNo : " + entity.getMobileNo() + " ,gps : " + entity.getGps() + " ,createBy : " + entity.getCreateBy() + " ,typeStation : " + entity.getTypeStation() );
    			
    			reault = call.execute(in);	
    			String result =(String)reault.get("pResult");
    			String msg =(String)reault.get("pMessage");
    			
    			logger.info("execute insert {result : "+result+", msg : "+msg+"} " + i);
    			
    		}
			logger.info("reault = " + reault.toString());
    	} else {
    		logger.warn("List<MbStationMaster> is '0' [has 'ZERO'] ");
    	}
    	return reault;
    }
    
    public Map<String, Object> importMasterStationPTC_ps(List<MbStationMaster> list) {
    	Map<String, Object> reault = new HashMap<String, Object>();
    	
    	//SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER);

    	int size = list.size();

    	logger.info("(ps) List<MbStationMaster> size = "+size);

    	String sql = "INSERT INTO dbo.MB_STATION_MASTER (NO ,TYPE ,PRODUCT_ID ,SITE_CODE ,REF ,PLACE ,PLANT_ID ,COST_CENTER ,PROFIT_CENTER ,CENTER_NAME ,PART ,ADDR_TUMBON ,ADDR_AMPHUR ,ADDR_PROVINCE ,POST_CODE ,ADDRESS ,MODEL ,PLANT_RECEIVE ,OPERATING_STATUS ,EMAIL ,PHONE_NO ,MOBILE_NO ,GPS ,CREATE_BY ,CREATE_DATE ,UPDATE_BY ,UPDATE_DATE ,TYPE_STATION) VALUES ( ? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ) ";
    	
    	if(size > 0) {
    		Connection conn = null;
        	try {
        		conn = jdbcTemplateSQLSERVER.getDataSource().getConnection();
        		//conn = jdbcTemplateSQLSERVER.getDataSource().getConnection();
    			conn.setAutoCommit(false);
    			logger.info("get Conn = "+conn.toString());
    			
    			PreparedStatement ps = conn.prepareStatement(sql);
    			try {
	    			for (int i = 0; i < size; i++) {
	
	        			MbStationMaster entity = (MbStationMaster)list.get(i);
	        			
	        			Map<String, Object> checkIfExists = isExists(entity.getCostCenter());
	        			if(checkIfExists.get("EXISTS").toString().equals("NOT_EXISTS")){
	
	            			java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
	            			
	            			ps.setString(1, getIncrementNo().get("RUNNO").toString());
	            			ps.setString(2, entity.getType());
	            			ps.setString(3, entity.getProductID());
	            			ps.setString(4, entity.getSiteCode());
	            			ps.setString(5, entity.getRef());
	            			ps.setString(6, entity.getPlace());
	            			ps.setString(7, entity.getPlantID());
	            			ps.setString(8, entity.getCostCenter());
	            			ps.setString(9, entity.getProfitCenter());
	            			ps.setString(10, entity.getCenterName());
	            			ps.setString(11, entity.getPart());
	            			ps.setString(12, entity.getAddrTumbon());
	            			ps.setString(13, entity.getAddrAmphur());
	            			ps.setString(14, entity.getAddrProvince());
	            			ps.setString(15, entity.getPostCode());
	            			ps.setString(16, entity.getAddress());
	            			ps.setString(17, entity.getModel());
	            			ps.setString(18, entity.getPlantReceive());
	            			ps.setString(19, entity.getOperatingStatus());
	            			ps.setString(20, entity.getEmail());
	            			ps.setString(21, entity.getPhoneNo());
	            			ps.setString(22, entity.getMobileNo());
	            			ps.setString(23, entity.getGps());
	            			ps.setString(24, entity.getCreateBy());
	            			ps.setDate(25, sqlDate);
	            			ps.setString(26, entity.getCreateBy());
	            			ps.setDate(27, sqlDate);
	            			ps.setString(28, entity.getTypeStation());
	
	            			ps.executeUpdate();        				
	        			} else {
	        				logger.info("this COST_CENTER is EXISTS / please check ['"+entity.getCostCenter()+"'] ");
	        			}
	    			}
    			} catch(Exception e) {
    				logger.error("error ps",e);
    			} finally {
    				if (ps != null) try {ps.close();} catch(Exception e){}
    			}
    			conn.commit();
    		} catch (SQLException e) {
    			logger.error("Error Exception PS ",e);
    		} finally {
    			if (conn != null) {
    				try{conn.close();}catch(SQLException e){}
    			}
    		}
        	
    	} else {
    		logger.warn("(ps) List<MbStationMaster> is '0' [has 'ZERO'] ");
    	}
    	
    	return reault;
    }
    
    public Map<String, Object> getIncrementNo() {
    	Map<String, Object> result = new HashMap<String, Object>();
    	
    	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
  				 .withProcedureName("getRunnoStationMaster") ;

    	SqlParameterSource in = new MapSqlParameterSource()
				.addValue("pResult",Types.VARCHAR)
				.addValue("pMessage",Types.VARCHAR);
    	//
    	List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
    	result.put("RUNNO", list.get(0).get("RUNNO"));
    	
    	return result;
    }
    
    public Map<String, Object> isExists(String CostCenter) {
    	Map<String, Object> result = new HashMap<String, Object>();
    	
    	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
  				 .withProcedureName("getIsExistsStationMaster") ;

    	SqlParameterSource in = new MapSqlParameterSource()
				.addValue("costCenter",CostCenter,Types.VARCHAR)
				.addValue("pResult",Types.VARCHAR)
				.addValue("pMessage",Types.VARCHAR);
    	
    	List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
    	result.put("EXISTS", list.get(0).get("EXISTS_STS"));
    	
    	return result;
    }
} 
