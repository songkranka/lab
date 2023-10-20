package th.co.pt.ptgapp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import th.co.pt.ptgapp.controller.bean.CaClreqtObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.UserDto;
import th.co.pt.ptgapp.entity.MobileLtrSpec;
import th.co.pt.ptgapp.entity.MobilePlant;
import th.co.pt.ptgapp.entity.MobileTool;
import th.co.pt.ptgapp.entity.VisualAndColor;
import th.co.pt.ptgapp.service.report.dto.AddNewSource;
import th.co.pt.ptgapp.service.report.dto.AddNewUser;
import th.co.pt.ptgapp.service.report.dto.LTRSpec;

import java.sql.Types;

//import th.co.pt.ptgapp.utils.JdbcTmpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UtilDao {

//    @Autowired
//    private JdbcTmpl jdbcTmpl;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplateSQLSERVER;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<Map<String, Object>> getDropdownPlant(RandomOil objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		// System.out.println("PLAN ID + + >"+objReq.getPlantid());
		logger.info("----- getDropdownPlant ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDropdownPlant");
			SqlParameterSource in = new MapSqlParameterSource().addValue("planID", objReq.getPlantid(), Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getDropdownProduct() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getDropdownProduct ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDropdownProduct");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getDropdownProductMobile() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getDropdownProduct Mobile ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					.withProcedureName("getDropdownProductMobile");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getDropdownLogistics() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- GetDropdownLogistics ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDropdownLogistics");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getDropdownSource() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getDropdownSource ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDropdownSource");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getAutoRandomFlg() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getAutoRandomFlg ------ ");
		try {
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getFlgRandom");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getDropdownGetSample() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getDropdownGetSample ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDropdownGetSample");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getDropdownSampleType() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getDropdownSampleType ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDropdownSampleType");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getDropdownMBRole() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getDropdownMBRole ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDropdownMBRole");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getDropdownTypeStation() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getDropdownTypeStation ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDropdownTypeStation");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getDropdownTypeStation2() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getDropdownTypeStation ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					.withProcedureName("getDropdownTypeStation2");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getDropdownSavePoint() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getDropdownTypeStation ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					.withProcedureName("getDropdownSavePointLocation");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getDropdownStatus() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getDropdownTypeStation ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDropdownStatus");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getDropdownRegion(RandomOil objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		// logger.info("-----objReq.getTypeStation() ------ "+objReq.getTypeStation());
		try {
			logger.info("----- getDropdownRegion ------ ");
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDropdownRegion");
			SqlParameterSource in = new MapSqlParameterSource().addValue("typeStation", objReq.getTypeStation(),
					Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getDropdownArea(RandomOil objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getDropdownArea ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDropdownArea");
			SqlParameterSource in = new MapSqlParameterSource().addValue("region", objReq.getRegion(), Types.VARCHAR)
					.addValue("type_station", objReq.getTypeStation(), Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getDropdownProvince(RandomOil objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getDropdownArea ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDropdownProvince");
			SqlParameterSource in = new MapSqlParameterSource().addValue("area", objReq.getArea(), Types.VARCHAR)
					.addValue("type_station", objReq.getTypeStation(), Types.VARCHAR)
					.addValue("region", objReq.getRegion(), Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getSetupRandom(RandomOil objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getSetupRandom ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getSetupRandom");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getDropDownSetupColor(RandomOil objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getDropDownSetupColor ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDropDownSetupColor");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getDropDownSetupColorASTM(RandomOil objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getDropDownSetupColor ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDropDownColorASTM");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getDropDownVisual(RandomOil objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getDropDownVisual ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDropDownVisual");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getCommentHistory(RandomOil objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getCommentHistory ------ ");
		try {
			// System.out.println(objReq.getLtrhd());
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getCommentHistory");
			SqlParameterSource in = new MapSqlParameterSource().addValue("ltrhd", objReq.getLtrhd(), Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getDropdownTrip() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getDropdownTrip ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDropdownTrip");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public Map<String, Object> getMpUserInfo(CaClreqtObj obj) {

		StringBuffer sql = new StringBuffer();

		sql.append(" SELECT U.CODEMP_ID,U.ROLE_ID,U.NAMET,U.NAMEE,U.IS_ACTIVE,U.PLANT_ID ");
		sql.append(" FROM DBO.MP_USER U ");
		sql.append(" WHERE U.CODEMP_ID = '" + obj.getCodempid() + "' ");
		sql.append("  ");
		logger.info(sql.toString());

		Map<String, Object> result = jdbcTemplateSQLSERVER.queryForMap(sql.toString());
		if (result.get("CODEMP_ID") == null) {
			result.put("USER_TYPE_ID", "NF");
		}

		return result;
	}

	public List<Map<String, Object>> getDropdownLogisticBoat() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		// logger.info("----- getDropDownSetupColor ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					.withProcedureName("getDropDownLogisticBoat");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getDropdowncauseChgStatus() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		// logger.info("----- getDropDownSetupColor ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					.withProcedureName("getDropDowncauseChgStatus");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getDropdownSubType() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		// logger.info("----- getDropDownSetupColor ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDropDownSubType");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getUserCreateHistory(RandomOil objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getUserCreateHistory ------ ");
		try {
			// System.out.println(objReq.getLtrhd());
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getUserCreateHistory");
			SqlParameterSource in = new MapSqlParameterSource().addValue("ltrhd", objReq.getLtrhd(), Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getProductionDescription() {
		StringBuffer sql = new StringBuffer();
		List<Map<String, Object>> list = null;
		try {
			sql.append(" select PDDESC_ID,PDDESC_NAME from ASS_PRODUCT_DESC_MASTER apdm   ");
			logger.info("SQL:-> " + sql.toString());

			list = jdbcTemplateSQLSERVER.queryForList(sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Map<String, Object>> getConfigWork(RandomOil objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getConfigWork ------ ");
		try {
			// System.out.println(objReq.getLtrhd());
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getConfigWork");
			SqlParameterSource in = new MapSqlParameterSource().addValue("sample_code", objReq.getSampleType())
					.addValue("product_code", objReq.getProductID());
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getSetupWork(RandomOil objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getSetupWork ------ ");
		try {
			// System.out.println(objReq.getLtrhd());
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getdataSetupWork");
			SqlParameterSource in = new MapSqlParameterSource().addValue("samplecode", objReq.getSampleType())
					.addValue("productId", objReq.getProductID());
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getReasonRevise() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getReasonRevise ------ ");
		try {
			// System.out.println(objReq.getLtrhd());
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getReasonRevise");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getuserdetail() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getuserdetail ------ ");
		try {
			// System.out.println(objReq.getLtrhd());
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getuserDetail");
			SqlParameterSource in = new MapSqlParameterSource().addValue("codeemp", "");
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getsourcedetail(AddNewSource objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getsourcedetail ------ ");
		try {
			// System.out.println(objReq.getLtrhd());
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getSourceDetail");
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("source_id", objReq.getsource_id(), Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getRoleUser() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getRoleUser ------ ");
		try {
			// System.out.println(objReq.getLtrhd());
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getRoleUser");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getPlantUser() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getPlantUser ------ ");
		try {
			// System.out.println(objReq.getLtrhd());
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getPlantUser");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> checkDuplicateUser(String codeemp) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- checkDuplicateUser ------ ");
		try {
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getuserDetail");
			SqlParameterSource in = new MapSqlParameterSource().addValue("codeemp", codeemp);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> addNewUser(AddNewUser addnewuser) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- addNewUser ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("inserNewUser");
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("pathImage", addnewuser.getPathFile(), Types.VARCHAR)
					.addValue("codeEmp", addnewuser.getCode_empid(), Types.VARCHAR)
					.addValue("roleId", addnewuser.getRole_dropdown(), Types.VARCHAR)
					.addValue("name", addnewuser.getName_emp(), Types.VARCHAR)
					.addValue("status", addnewuser.getStatus_dropdown(), Types.VARCHAR)
					.addValue("createBy", addnewuser.getCreateBy(), Types.VARCHAR)
					.addValue("plantid", addnewuser.getPlat_dropdown(), Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> deleteUser(RandomOil objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- deleteUser ------ ");
		Map<String, Object> map = null;
		try {

			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("deleteOldUser");
			SqlParameterSource in = new MapSqlParameterSource().addValue("item", objReq.getUsrDataAss(), Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> deleteSource(AddNewSource objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- deleteUser ------ ");
		Map<String, Object> map = null;
		try {

			System.out.println(objReq.getsource_id());

			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("deleteSource");
			SqlParameterSource in = new MapSqlParameterSource().addValue("source_id", objReq.getsource_id(),
					Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> editOldUser(AddNewUser addnewuser) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- EditUser ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("updateUser");
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("pathImage", addnewuser.getPathFile(), Types.VARCHAR)
					.addValue("codeEmp", addnewuser.getCode_empid(), Types.VARCHAR)
					.addValue("roleId", addnewuser.getRole_dropdown(), Types.VARCHAR)
					.addValue("name", addnewuser.getName_emp(), Types.VARCHAR)
					.addValue("status", addnewuser.getStatus_dropdown(), Types.VARCHAR)
					.addValue("createBy", addnewuser.getCreateBy(), Types.VARCHAR)
					.addValue("plantid",addnewuser.getPlat_dropdown(), Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		
		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> editSource(AddNewSource addNewSource) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- updateSource ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("updateSource");
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("source_id", addNewSource.getsource_id(), Types.VARCHAR)
					.addValue("source_name", addNewSource.getsource_name(), Types.VARCHAR)
					.addValue("codcomp", addNewSource.getcodcomp(), Types.VARCHAR)
					.addValue("update_by", addNewSource.getupdate_by(), Types.VARCHAR);

			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

			System.out.println(addNewSource);

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}
	
	public List<Map<String, Object>> updateLTRSpec(LTRSpec objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- updateLTRSpec ------ ");
		try {
			
			logger.info("float value '" + objReq.getDistill_min() + "'");
			logger.info("float value '" + objReq.getDistill_max() + "'");
			
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("updateLTRSpec");
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("ltr_spec_id", objReq.getLtr_spec_id(),Types.VARCHAR)
					.addValue("dispenser", objReq.getDispenser(),Types.VARCHAR)
					.addValue("sn", objReq.getSn(),Types.VARCHAR)
					.addValue("slot_number", objReq.getSlot_number(),Types.VARCHAR)
					.addValue("meter_total", objReq.getMeter_total()  ,Types.VARCHAR)
					.addValue("feature", objReq.getFeature(),Types.VARCHAR)
					.addValue("color", objReq.getColor(),Types.VARCHAR)
					.addValue("api_min", objReq.getApi_min() ,Types.DECIMAL)
					.addValue("api_max", objReq.getApi_max() ,Types.DECIMAL)
					.addValue("temp_min", objReq.getTemp_min() ,Types.DECIMAL)
					.addValue("temp_max", objReq.getTemp_max() ,Types.DECIMAL)
					.addValue("api_60_min", objReq.getApi_60_min() ,Types.DECIMAL)
					.addValue("api_60_max", objReq.getApi_60_max() ,Types.DECIMAL)
					.addValue("distill_min", objReq.getDistill_min() ,Types.DECIMAL)
					.addValue("distill_max", objReq.getDistill_max() ,Types.DECIMAL)
					.addValue("evaporation_10_min", objReq.getEvaporation_10_min()  ,Types.DECIMAL)
					.addValue("evaporation_10_max", objReq.getEvaporation_10_max() ,Types.DECIMAL)
					.addValue("evaporation_50_min", objReq.getEvaporation_50_min() ,Types.DECIMAL)
					.addValue("evaporation_50_max", objReq.getEvaporation_50_max() ,Types.DECIMAL)
					.addValue("evaporation_90_min", objReq.getEvaporation_90_min() ,Types.DECIMAL)
					.addValue("evaporation_90_max", objReq.getEvaporation_90_max() ,Types.DECIMAL)
					.addValue("boil_min", objReq.getBoil_min() ,Types.DECIMAL)
					.addValue("boil_max", objReq.getBoil_max() ,Types.DECIMAL)
					.addValue("waste_min", objReq.getWaste_min() ,Types.DECIMAL)
					.addValue("waste_max", objReq.getWaste_max() ,Types.DECIMAL)
					.addValue("ethanol_min", objReq.getEthanol_min() ,Types.DECIMAL)
					.addValue("ethanol_max", objReq.getEthanol_max() ,Types.DECIMAL)
					.addValue("flash_point_min", objReq.getFlash_point_min() ,Types.DECIMAL)
					.addValue("flash_point_max", objReq.getFlash_point_max() ,Types.DECIMAL)
					.addValue("biodiesel_min", objReq.getBiodiesel_min() ,Types.DECIMAL)
					.addValue("biodiesel_max", objReq.getBiodiesel_max() ,Types.DECIMAL)
					.addValue("cetane_min", objReq.getCetane_min() ,Types.DECIMAL)
					.addValue("cetane_max", objReq.getCetane_max() ,Types.DECIMAL)
					.addValue("ron_min", objReq.getRon_min() ,Types.DECIMAL)
					.addValue("ron_max", objReq.getRon_max() ,Types.DECIMAL)
					.addValue("mon_min", objReq.getMon_min() ,Types.DECIMAL)
					.addValue("mon_max", objReq.getMon_max() ,Types.DECIMAL)
					.addValue("create_by", objReq.getCreate_by(),Types.VARCHAR)
					.addValue("create_date", objReq.getCreate_date(),Types.VARCHAR)
					.addValue("update_by", objReq.getUpdate_by(),Types.VARCHAR)
					.addValue("update_date", objReq.getUpdate_date(),Types.VARCHAR)
					.addValue("product_id", objReq.getProduct_id(),Types.VARCHAR)
					.addValue("ltr_h_id", objReq.getLtr_h_id(),Types.VARCHAR);
			
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			
			return result;
			
		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getOilforEdit(RandomOil objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getOilforEdit ------ ");
		try {

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getOilForEdit");
			SqlParameterSource in = new MapSqlParameterSource().addValue("labcode", objReq.getLabCode(), Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> saveEditOil(RandomOil objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- saveEditOil ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("saveEditOil");
			SqlParameterSource in = new MapSqlParameterSource().addValue("labcode", objReq.getLabCode(), Types.VARCHAR)
					.addValue("pddesk", objReq.getProduct_desc(), Types.VARCHAR)
					.addValue("idpddesk", objReq.getProductID(), Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> saveNewSource(AddNewSource objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- saveNewSource ------ ");
		Map<String, Object> map = null;

		System.out.println(objReq.getsource_id());
		System.out.println(objReq.getsource_name());
		System.out.println(objReq.getcodcomp());
		System.out.println(objReq.getcreate_by());

		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("insertNewSource");
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("source_id", objReq.getsource_id(), Types.VARCHAR)
					.addValue("source_name", objReq.getsource_name(), Types.VARCHAR)
					.addValue("codcomp", objReq.getcodcomp(), Types.VARCHAR)
					.addValue("create_by", objReq.getcreate_by(), Types.VARCHAR);

			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		System.out.println(result.toString());

		return result;
	}

	public List<Map<String, Object>> getUnitSpecForUpdate(RandomOil objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getUnitSpecForUpdate ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getUnitSpecForUpdate");
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("productCode", objReq.getProductID(), Types.VARCHAR)
					.addValue("sampleTypeCode", objReq.getSampleType(), Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> saveSpecUnit(RandomOil objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- saveSpecUnit ------ ");
		Map<String, Object> map = null;

		System.out.println("itemId :" + objReq.getItemIdDataAss());
		System.out.println("itemmpId :" + objReq.getItemMpDataAss());
		System.out.println("specMin :" + objReq.getSpecMinDataAss());
		System.out.println("specMax :" + objReq.getSpecMaxDataAss());
		System.out.println("uncer :" + objReq.getUncerDataAss());
		System.out.println("color :" + objReq.getColorDataAss());
		System.out.println("productCode :" + objReq.getProductID());
		System.out.println("colorobj :" + objReq.getColorObjDataAss());
		System.out.println("colorobj :" + objReq.getColorObjDataAss());
		System.out.println("unit :" + objReq.getUnitDataAss());
		System.out.println("isenabled :" + objReq.getIsEnabled());
		System.out.println("specbasic :" + objReq.getSpec());
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("saveSpecUnit");
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("itemId", objReq.getItemIdDataAss(), Types.VARCHAR)
					.addValue("itemmpId", objReq.getItemMpDataAss(), Types.VARCHAR)
					.addValue("specMin", objReq.getSpecMinDataAss(), Types.VARCHAR)
					.addValue("specMax", objReq.getSpecMaxDataAss(), Types.VARCHAR)
					// .addValue("uncer",objReq.getUncerDataAss(), Types.VARCHAR)
					.addValue("color", objReq.getColorDataAss(), Types.VARCHAR)
					.addValue("productCode", objReq.getProductID(), Types.VARCHAR)
					.addValue("sampleType", objReq.getSampleType(), Types.VARCHAR)
					.addValue("colorobj", objReq.getColorObjDataAss(), Types.VARCHAR)
					.addValue("updateBy", objReq.getCreateBy(), Types.VARCHAR)
					.addValue("isenbled", objReq.getIsEnabled(), Types.VARCHAR)
					.addValue("unit", objReq.getUnitDataAss(), Types.VARCHAR)
					.addValue("specBasic", objReq.getSpec(), Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getVisual() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getVisual ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDataVisual");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}
		return result;

	}

	public List<Map<String, Object>> getColor() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getColor ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getColorSetup");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}
		return result;
	}

	public List<Map<String, Object>> geteditdropdown(RandomOil objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- geteditdropdown ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDynamicToolId");
			SqlParameterSource in = new MapSqlParameterSource().addValue("itemMpId", objReq.getItemmp_id(),
					Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> updateDynamicToolId(RandomOil objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- updateDynamicToolId ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("updateDynamicToolId");
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("itemmpId", objReq.getItemMpDataAss(), Types.VARCHAR)
					.addValue("methodId", objReq.getMethodDataAss(), Types.VARCHAR)
					.addValue("ltrCode", objReq.getLtrdt(), Types.VARCHAR)
					.addValue("ltrDtId", objReq.getLtrDtID(), Types.VARCHAR)
					.addValue("productId", objReq.getProductID(), Types.VARCHAR)
					.addValue("sampleTypeCode", objReq.getSampleType(), Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getWaitwork(String productID, String labarr) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getWaitwork ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getWaitwork");
			SqlParameterSource in = new MapSqlParameterSource().addValue("productId", productID, Types.VARCHAR)
					.addValue("labcode", labarr, Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getmethodcondition(String methodDataAss) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getmethodcondition ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getMethodCondition");
			SqlParameterSource in = new MapSqlParameterSource().addValue("itemmp", methodDataAss, Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getSpecMobileLtr(String productID) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getSpecMobileLtr ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getMobileLtrSpec");
			SqlParameterSource in = new MapSqlParameterSource().addValue("productId", productID, Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getMobileTool() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getMobileTool ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getMobileTool");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getMobilePlant() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getMobilePlant ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getMobilePlant");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> saveMobileLtrSpec(MobileLtrSpec mobileLtrSpec) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- saveMobileLtrSpec ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("updateMobileLtrSpec");
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("dispenser", mobileLtrSpec.getDspenser(), Types.VARCHAR)
					.addValue("sn", mobileLtrSpec.getSn(), Types.VARCHAR)
					.addValue("slotNumber", mobileLtrSpec.getSlotNumber(), Types.VARCHAR)
					.addValue("meterTotal", mobileLtrSpec.getMeterTotal(), Types.VARCHAR)
					.addValue("feature", mobileLtrSpec.getFeature(), Types.VARCHAR)
					.addValue("color", mobileLtrSpec.getColor(), Types.VARCHAR)
					.addValue("apiMin", mobileLtrSpec.getApiMin(), Types.VARCHAR)
					.addValue("apiMax", mobileLtrSpec.getApiMax(), Types.VARCHAR)
					.addValue("tempMin", mobileLtrSpec.getTempMin(), Types.VARCHAR)
					.addValue("tempMax", mobileLtrSpec.getTempMax(), Types.VARCHAR)
					.addValue("api60min", mobileLtrSpec.getApi60min(), Types.VARCHAR)
					.addValue("api60Max", mobileLtrSpec.getApi60Max(), Types.VARCHAR)
					.addValue("distillMin", mobileLtrSpec.getDistillMin(), Types.VARCHAR)
					.addValue("distillMax", mobileLtrSpec.getDistillMax(), Types.VARCHAR)
					.addValue("evaporation10Min", mobileLtrSpec.getEvaporation10Min(), Types.VARCHAR)
					.addValue("evaporation10Max", mobileLtrSpec.getEvaporation10Max(), Types.VARCHAR)
					.addValue("evaporation50Min", mobileLtrSpec.getEvaporation50Min(), Types.VARCHAR)
					.addValue("evaporation50Max", mobileLtrSpec.getEvaporation50Max(), Types.VARCHAR)
					.addValue("evaporation90Min", mobileLtrSpec.getEvaporation90Min(), Types.VARCHAR)
					.addValue("evaporation90Max", mobileLtrSpec.getEvaporation90Max(), Types.VARCHAR)
					.addValue("boilMin", mobileLtrSpec.getBoilMin(), Types.VARCHAR)
					.addValue("boilMax", mobileLtrSpec.getBoilMax(), Types.VARCHAR)
					.addValue("wasteMin", mobileLtrSpec.getWasteMin(), Types.VARCHAR)
					.addValue("wasteMax", mobileLtrSpec.getWasteMax(), Types.VARCHAR)
					.addValue("ethanolMin", mobileLtrSpec.getEthanolMin(), Types.VARCHAR)
					.addValue("ethanolMax", mobileLtrSpec.getEthanolMax(), Types.VARCHAR)
					.addValue("flashpointMin", mobileLtrSpec.getFlashpointMin(), Types.VARCHAR)
					.addValue("flashpointMax", mobileLtrSpec.getFlashpointMax(), Types.VARCHAR)
					.addValue("bioDieselMin", mobileLtrSpec.getBioDieselMin(), Types.VARCHAR)
					.addValue("bioDieselMax", mobileLtrSpec.getBioDieselMax(), Types.VARCHAR)
					.addValue("cetaneMin", mobileLtrSpec.getCetaneMin(), Types.VARCHAR)
					.addValue("cetaneMax", mobileLtrSpec.getCetaneMax(), Types.VARCHAR)
					.addValue("ronMin", mobileLtrSpec.getRonMin(), Types.VARCHAR)
					.addValue("ronMax", mobileLtrSpec.getRonMax(), Types.VARCHAR)
					.addValue("monMin", mobileLtrSpec.getMonMin(), Types.VARCHAR)
					.addValue("monMax", mobileLtrSpec.getMonMax(), Types.VARCHAR)
					.addValue("updateBy", mobileLtrSpec.getUpdateBy(), Types.VARCHAR)
					.addValue("productId", mobileLtrSpec.getProductId(), Types.VARCHAR)
					.addValue("ltrSpecId", mobileLtrSpec.getLtrSpecId(), Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> updateMobileTool(MobileTool mobileTool, String status) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- updateMobileTool ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("updateMobileTool");
			SqlParameterSource in = new MapSqlParameterSource().addValue("statusCond", status, Types.VARCHAR)
					.addValue("toolCode", mobileTool.getToolsCode(), Types.VARCHAR)
					.addValue("toolName", mobileTool.getToolsName(), Types.VARCHAR)
					.addValue("status", mobileTool.getStatus(), Types.VARCHAR)
					.addValue("updateBy", mobileTool.getUpdateBy(), Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> deleteMobileTool(MobileTool mobileTool) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- updateMobileTool ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("deleteMobileTools");
			SqlParameterSource in = new MapSqlParameterSource().addValue("toolsId", mobileTool.getToolsCode(),
					Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> updateMobilePlant(MobilePlant mobilePlant, String status) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- updateMobileTool ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("updateMobilePlant");
			SqlParameterSource in = new MapSqlParameterSource().addValue("statusCond", status, Types.VARCHAR)
					.addValue("plantReceiveCode", mobilePlant.getPlantReceiveCode(), Types.VARCHAR)
					.addValue("plantReceiveNameTH", mobilePlant.getPlantReceiveNameTH(), Types.VARCHAR)
					.addValue("plantReceiveNameEN", mobilePlant.getPlantReceiveNameEN(), Types.VARCHAR)
					.addValue("updateBy", mobilePlant.getUpdateBy(), Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> deleteMobilePlant(MobilePlant mobilePlant) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- deleteMobilePlant ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("deleteMobilePlant");
			SqlParameterSource in = new MapSqlParameterSource().addValue("plantId", mobilePlant.getPlantReceiveCode(),
					Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getrootcause() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getrootcause ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getRootcause");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> saverootcause(String labcode, String rtcode, String rtdesc) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- saverootcause ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("saveRootcause");
			SqlParameterSource in = new MapSqlParameterSource().addValue("labcode", labcode, Types.VARCHAR)
					.addValue("rtcode", rtcode, Types.VARCHAR).addValue("rtdesc", rtdesc, Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getLabWaitwork(String productID) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getLabWaitwork ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getLabcodeWaitwork");
			SqlParameterSource in = new MapSqlParameterSource().addValue("productId", productID, Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> getVisualt() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- getVisualt ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDataVisual");
			SqlParameterSource in = new MapSqlParameterSource();
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> updateVisual(VisualAndColor visualAndColor, String status) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- updateVisual ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("updateVisual");
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("visualCode", visualAndColor.getId(), Types.VARCHAR)
					.addValue("visualName", visualAndColor.getVisualName(), Types.VARCHAR)
					.addValue("updateBy", visualAndColor.getUpdateBy(), Types.VARCHAR)
					.addValue("statusCond", status, Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> deleteVisual(VisualAndColor visualAndColor) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- deleteVisual ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("deleteVisual");
			SqlParameterSource in = new MapSqlParameterSource().addValue("idtxt", visualAndColor.getId(),
					Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> updateColor(VisualAndColor visualAndColor, String status) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- updateColor ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("updateSetUpColor");
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("colorCode", visualAndColor.getId(), Types.VARCHAR)
					.addValue("colorName", visualAndColor.getColorName(), Types.VARCHAR)
					.addValue("updateBy", visualAndColor.getUpdateBy(), Types.VARCHAR)
					.addValue("statusCond", status, Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> deleteColor(VisualAndColor visualAndColor) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- deleteColor ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("deleteColorSetup");
			SqlParameterSource in = new MapSqlParameterSource().addValue("idtxt", visualAndColor.getId(),
					Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> checkIRPC(String checkIRPC) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- checkIRPC ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("checkIrpc");
			SqlParameterSource in = new MapSqlParameterSource().addValue("labcode", checkIRPC, Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> assignToTemp(String ltrNo, String empcode) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- assignToTemp ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("assignToTemp");
			SqlParameterSource in = new MapSqlParameterSource().addValue("ltrcode", ltrNo, Types.VARCHAR)
					.addValue("createBy", empcode, Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> returnFromTemp(String ltrNo, String codempid) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- returnFromTemp ------ ");
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("returnFromTemp");
			SqlParameterSource in = new MapSqlParameterSource().addValue("ltrcode", ltrNo, Types.VARCHAR)
					.addValue("createBy", codempid, Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}

		return result;
	}

	public List<Map<String, Object>> saveSpecUncer(RandomOil objReq) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		logger.info("----- saveSpecUncer ------ ");
		Map<String, Object> map = null;

		try {
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("updateLTRUncer");
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("itemMp", objReq.getItemMpDataAss(), Types.VARCHAR)
					.addValue("toolId", objReq.getToolsDataAss(), Types.VARCHAR)
					.addValue("productId", objReq.getProductID(), Types.VARCHAR)
					.addValue("sampleType", objReq.getSampleType(), Types.VARCHAR)
					.addValue("createBy", objReq.getCreateBy(), Types.VARCHAR)
					.addValue("uncerValue", objReq.getUncerDataAss(), Types.VARCHAR);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			if (result == null) {
				result = new ArrayList<Map<String, Object>>();
				map.put("resultCode", "00");
				result.add(map);
			}

		} catch (Exception e) {
			logger.error("error:" + e);
		}
		return result;
	}

	public void triggerUpdateLtrdtSub() {
		logger.info("----- triggerUpdateLtrdtSub ------ ");
		try {
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("triggerUpdateItem");
			SqlParameterSource in = new MapSqlParameterSource();
			call.execute(in).get("#result-set-1");
		} catch (Exception e) {
			logger.error("error:" + e);
		}

	}
	
}
