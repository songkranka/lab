package th.co.pt.ptgapp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import javax.xml.ws.http.HTTPException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import ch.qos.logback.classic.Logger;
import th.co.pt.ptgapp.controller.bean.CaSetupAllowceObj;
import th.co.pt.ptgapp.controller.bean.CaSetupGprovinceObj;
import th.co.pt.ptgapp.controller.bean.CaSetupKiloObj;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.MessageObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.ResultObj;
import th.co.pt.ptgapp.entity.MobileLtrSpec;
import th.co.pt.ptgapp.entity.MobilePlant;
import th.co.pt.ptgapp.entity.MobileTool;
import th.co.pt.ptgapp.entity.VisualAndColor;
import th.co.pt.ptgapp.service.MenuService;
import th.co.pt.ptgapp.service.UtilService;
import th.co.pt.ptgapp.service.report.dto.AddNewSource;
import th.co.pt.ptgapp.service.report.dto.AddNewUser;
import th.co.pt.ptgapp.service.report.dto.LTRSpec;
import th.co.pt.ptgapp.utils.CGlobal;
import th.co.pt.ptgapp.utils.WebUtil;

@Controller
public class UtilServiceController {
	@Autowired
	private UtilService utilService;
	@Autowired
	private JdbcTemplate jdbcTemplateSQLSERVER;
	
	@RequestMapping(value = "/util-getmsg", method = RequestMethod.POST)
	public @ResponseBody MessageObj login(@RequestBody MessageObj msg) {
		MessageObj result = new MessageObj();
		result.message_id = msg.message_id;
		result.message_desc = WebUtil.GetPropertyMessage("MsgLabConfig", msg.message_id);
		return result;
	}

	@RequestMapping(value = "/util-getDropdownPlant", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> GetAllStore(@RequestBody RandomOil objReq, HttpSession session) {
		/*
		 * MemberObj memberObj = CGlobal.getC_UserInfo(session);
		 * if(objReq.getStatus().equals("randomoil")) { objReq.setPlantid(null); } else
		 * { objReq.setPlantid(memberObj.getPlantId()); }
		 */
		List<Map<String, Object>> obj = utilService.getDropdownPlant(objReq);
		return obj;
	}

	@RequestMapping(value = "/util-getDropdownProduct", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropdownProduct() {

		List<Map<String, Object>> obj = utilService.getDropdownProduct();

		return obj;
	}

	@RequestMapping(value = "/util-getDropdownProductMobile", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropdownProductMobile() {

		List<Map<String, Object>> obj = utilService.getDropdownProductMobile();

		return obj;
	}

	@RequestMapping(value = "/util-getAutoRandomFlg", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getAutoRandomFlg() {
		List<Map<String, Object>> obj = utilService.getAutoRandomFlg();
		return obj;
	}

	@RequestMapping(value = "/util-getDropdownLogistics", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropdownLogistics() {

		List<Map<String, Object>> obj = utilService.getDropdownLogistics();

		return obj;
	}

	@RequestMapping(value = "/util-getDropdownSource", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropdownSource() {

		List<Map<String, Object>> obj = utilService.getDropdownSource();

		return obj;
	}

	@RequestMapping(value = "/util-getDropdownGetSample", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropdownGetSample() {

		List<Map<String, Object>> obj = utilService.getDropdownGetSample();

		return obj;
	}

	@RequestMapping(value = "/util-getDropdownSampleType", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropdownSampleType() {

		List<Map<String, Object>> obj = utilService.getDropdownSampleType();

		return obj;
	}

	@RequestMapping(value = "/util-getDropdownMBRole", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropdownMBRole() {

		List<Map<String, Object>> obj = utilService.getDropdownMBRole();

		return obj;
	}

	@RequestMapping(value = "/util-getDropdownTypeStation", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropdownTypeStation() {

		List<Map<String, Object>> obj = utilService.getDropdownTypeStation();

		return obj;
	}

	@RequestMapping(value = "/util-getDropdownRegion", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropdownRegion(@RequestBody RandomOil objReq) {
		// System.out.println("----- crontroler ------ "+objReq.getTypeStation());
		List<Map<String, Object>> obj = utilService.getDropdownRegion(objReq);

		return obj;
	}

	@RequestMapping(value = "/util-getDropdownArea", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropdownArea(@RequestBody RandomOil objReq) {

		List<Map<String, Object>> obj = utilService.getDropdownArea(objReq);

		return obj;
	}

	@RequestMapping(value = "/util-getDropdownProvince", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropdownProvince(@RequestBody RandomOil objReq) {

		List<Map<String, Object>> obj = utilService.getDropdownProvince(objReq);

		return obj;
	}

	@RequestMapping(value = "/util-getSetupRandom", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getSetupRandom(@RequestBody RandomOil objReq) {

		List<Map<String, Object>> obj = utilService.getSetupRandom(objReq);

		return obj;
	}

	@RequestMapping(value = "/util-getDropDownSetupColor", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropDownSetupColor(@RequestBody RandomOil objReq) {

		List<Map<String, Object>> obj = utilService.getDropDownSetupColor(objReq);

		return obj;
	}

	@RequestMapping(value = "/util-getDropDownSetupColorASTM", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropDownSetupColorASTM(@RequestBody RandomOil objReq) {

		List<Map<String, Object>> obj = utilService.getDropDownSetupColorASTM(objReq);

		return obj;
	}

	@RequestMapping(value = "/util-getDropDownVisual", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropDownVisual(@RequestBody RandomOil objReq) {

		List<Map<String, Object>> obj = utilService.getDropDownVisual(objReq);
		return obj;
	}

	@RequestMapping(value = "/util-getCommentHistory", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getCommentHistory(@RequestBody RandomOil objReq) {

		List<Map<String, Object>> obj = utilService.getCommentHistory(objReq);
		return obj;
	}

	@RequestMapping(value = "/util-getUserCreateHistory", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getUserCreateHistory(@RequestBody RandomOil objReq) {

		List<Map<String, Object>> obj = utilService.getUserCreateHistory(objReq);
		return obj;
	}

	@RequestMapping(value = "/util-getConfigWork", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getConfigWork(@RequestBody RandomOil objReq) {

		List<Map<String, Object>> obj = utilService.getConfigWork(objReq);
		return obj;
	}

	@RequestMapping(value = "/util-getProductionDescription", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> getProductionDescription() {
		List<Map<String, Object>> obj = utilService.getProductionDescription();
		return obj;
	}

	@RequestMapping(value = "/util-getDropdownTypeStation2", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropdownTypeStation2() {

		List<Map<String, Object>> obj = utilService.getDropdownTypeStation2();

		return obj;
	}

	@RequestMapping(value = "/util-getDropdownSavepointlocation", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropdownSavaPoint() {

		List<Map<String, Object>> obj = utilService.getDropdownSavePoint();

		return obj;
	}

	@RequestMapping(value = "/util-getDropdownStatusStore", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropdownStatus() {

		List<Map<String, Object>> obj = utilService.getDropdownStatus();

		return obj;
	}

	@RequestMapping(value = "/util-getDropdownLogisticBoat", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropdownLogisticBoat() {

		List<Map<String, Object>> obj = utilService.getDropdownLogisticBoat();

		return obj;
	}

	@RequestMapping(value = "/util-getDropdownTrip", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropdownTrip() {

		List<Map<String, Object>> obj = utilService.getDropdownTrip();

		return obj;
	}

	@RequestMapping(value = "/util-getDropdowncauseChgStatus", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropdowncauseChgStatus() {

		List<Map<String, Object>> obj = utilService.getDropdowncauseChgStatus();

		return obj;
	}

	@RequestMapping(value = "/util-getDropdownSubType", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getDropdownSubType() {

		List<Map<String, Object>> obj = utilService.getDropdownSubType();

		return obj;
	}

	@RequestMapping(value = "/util-getmemberprofile", method = RequestMethod.POST)
	public @ResponseBody MemberObj getmemberprofile(@RequestBody MemberObj member) {

		MemberObj member_data = new MemberObj();

		try {
			// System.out.println(" member.codempid=="+ member.codempid);
			String uri = WebUtil.WebServiceUrl() + "HrisService/member-getmemberprofile";

			MemberObj data = new MemberObj();
			data.codempid = member.codempid;
			RestTemplate restTemplate = new RestTemplate();
			member_data = restTemplate.postForObject(uri, data, MemberObj.class);
			// System.out.println(" after.codempid=="+ member_data.codempid);
		} catch (Exception ex) {

			ex.printStackTrace();
			throw new HTTPException(404);
		}

		System.out.println("member_data response >>>> " + member_data.toString());

		return member_data;
	}

	@RequestMapping(value = "/util-allowanceExpense", method = RequestMethod.POST)
	public @ResponseBody CaSetupAllowceObj allowanceExpense(@RequestBody MemberObj member) {

		CaSetupAllowceObj rtnSetupAllowceObj = new CaSetupAllowceObj();
		// System.out.println("all member : "+member.toString());
		// System.out.println("CodempId : "+member.getCodempid());
		// System.out.println("numlvl : "+member.getNumlvl());

		try {
			String uri = WebUtil.WebServiceUrlPcca() + "PccaService/allowanceExpense";

			RestTemplate restTemplate = new RestTemplate();
			rtnSetupAllowceObj = restTemplate.postForObject(uri, member, CaSetupAllowceObj.class);
			// System.out.println(" after.pDay=="+ rtnSetupAllowceObj.getpDay());

			// System.out.println("CompId : "+rtnSetupAllowceObj.getCompId());
			// System.out.println("CompName : "+rtnSetupAllowceObj.getCompName());
		} catch (Exception ex) {

			ex.printStackTrace();
			throw new HTTPException(404);
		}
		return rtnSetupAllowceObj;
	}

	@RequestMapping(value = "/util-accomModationExpense", method = RequestMethod.POST)
	public @ResponseBody CaSetupGprovinceObj accomModationExpense(@RequestBody MemberObj member) {

		CaSetupGprovinceObj caSetupGprovinceObj = new CaSetupGprovinceObj();

		try {

			String uri = WebUtil.WebServiceUrl() + "PccaService/accomModationExpense";

			RestTemplate restTemplate = new RestTemplate();
			caSetupGprovinceObj = restTemplate.postForObject(uri, member, CaSetupGprovinceObj.class);

		} catch (Exception ex) {

			ex.printStackTrace();
			throw new HTTPException(404);
		}
		return caSetupGprovinceObj;
	}

	@RequestMapping(value = "/util-transportExpense", method = RequestMethod.POST)
	public @ResponseBody CaSetupKiloObj transportExpense(@RequestBody MemberObj member) {

		CaSetupKiloObj rtnObj = new CaSetupKiloObj();

		try {

			String uri = WebUtil.WebServiceUrl() + "PccaService/transportExpense";

			RestTemplate restTemplate = new RestTemplate();
			rtnObj = restTemplate.postForObject(uri, member, CaSetupKiloObj.class);

		} catch (Exception ex) {

			ex.printStackTrace();
			throw new HTTPException(404);
		}
		return rtnObj;
	}

	@RequestMapping(value = "/getThaiBuddaDate", method = RequestMethod.POST)
	public @ResponseBody RandomOil getCurrentDate(@RequestBody RandomOil criteria, HttpSession session) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
		SimpleDateFormat df_th = new SimpleDateFormat("dd/MM/yyyy", new Locale("th", "TH"));
		RandomOil result = new RandomOil();
		try {

			if (criteria.getPoDate() != null && !criteria.getPoDate().equals("")) {
				result.setPoDate(df_th.format(sdf.parse(criteria.getPoDate())));
			} else {
				result.setPoDate(sdf.format(new Date()));
			}

		} catch (Exception ex) {

			ex.printStackTrace();
			throw new HTTPException(404);
		}
		return result;
	}

	@RequestMapping(value = "/util-getSetupWork", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getSetupWork(@RequestBody RandomOil objReq) {
		List<Map<String, Object>> obj = null;
		try {
			obj = utilService.getSetupWork(objReq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@RequestMapping(value = "/util-getReasonRevise", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getReasonRevise() {
		List<Map<String, Object>> obj = null;
		try {
			obj = utilService.getReasonRevise();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-getuserdetail", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getuserdetail(HttpSession session) throws Exception {
		Map<String, Object> map = null;
		try {
			map = new HashMap<>();
			MemberObj memberObj = CGlobal.getC_UserInfo(session);
			List<Map<String, Object>> userlist = utilService.getMyDetail(memberObj.getCodempid());
			map.put("userdetail", userlist.get(0));

			if ("0010".equals(userlist.get(0).get("ROLE_ID").toString())
					|| "0005".equals(userlist.get(0).get("ROLE_ID").toString())
					|| "0004".equals(userlist.get(0).get("ROLE_ID").toString())
					|| "0007".equals(userlist.get(0).get("ROLE_ID").toString())) {

				List<Map<String, Object>> obj = utilService.getuserdetail();
				map.put("userlist", obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/util-getusermobiledetail", method = RequestMethod.GET)
	public @ResponseBody String getusermobiledetail(@RequestParam("empId") String empId ){
	    Map<String, Object> map = null;
	    String SIGNATURE_IMG_Path = "";
	    List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
	    try {
	        map = new HashMap<>();
	        
	        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getuserDetail");
			SqlParameterSource in = new MapSqlParameterSource().addValue("codeemp", empId);
			result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
	        
	        SIGNATURE_IMG_Path = result.get(0).get("SIGNATURE_IMG").toString();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    map.put("SIGNATURE_IMG_Path", SIGNATURE_IMG_Path);
	    ObjectMapper objectMapper = new ObjectMapper();
	    try {
	        return objectMapper.writeValueAsString(map);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	        return "";
	    }
	}


	
	@RequestMapping(value = "/util-getsourcedetail", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getsourcedetail(HttpSession session) throws Exception {
		Map<String, Object> map = null;
		try {
			map = new HashMap<>();
			MemberObj memberObj = CGlobal.getC_UserInfo(session);
			List<Map<String, Object>> userlist = utilService.getMyDetail(memberObj.getCodempid());
			map.put("userdetail", userlist.get(0));

			if ("0010".equals(userlist.get(0).get("ROLE_ID").toString())
					|| "0005".equals(userlist.get(0).get("ROLE_ID").toString())
					|| "0004".equals(userlist.get(0).get("ROLE_ID").toString())
					|| "0007".equals(userlist.get(0).get("ROLE_ID").toString())) {

				AddNewSource model = new AddNewSource();

				model.setsource_id(null);

				List<Map<String, Object>> obj = utilService.getsourcedetail(model);

				map.put("sourcelist", obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/util-getRoleUser", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getRoleUser() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Map<String, Object>> obj = utilService.getRoleUser();
		return obj;
	}

	@RequestMapping(value = "/util-getPlantUser", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getPlantUser() {

		List<Map<String, Object>> obj = null;
		try {
			obj = utilService.getPlantUser();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-checkProfile", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> checkProfile(@RequestBody MemberObj member) {
		Map<String, Object> obj = null;
		try {
			obj = utilService.checkProfile(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@RequestMapping(value = "/util-saveuser/{status}", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveuser(@ModelAttribute AddNewUser addnewuser, HttpSession session,
			@PathVariable String status) {
		String pathImage = "";
		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();
			MemberObj memberObj = CGlobal.getC_UserInfo(session);
			if (memberObj.getCodempid() == "" || memberObj.getCodempid() == null) {
				return map;
			}
			if (addnewuser.getUpload_signature() != null && !addnewuser.getUpload_signature().isEmpty()) {
				pathImage = utilService.saveImage(addnewuser.getUpload_signature());
			}
			addnewuser.setCreateBy(memberObj.getCodempid());
			addnewuser.setPathFile(pathImage);
			if ("add".equals(status)) {
				utilService.addNewUser(addnewuser);
			} else {
				utilService.editOldUser(addnewuser);
			}

			map.put("resultCode", "00");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/util-savesource/{status}", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> savesource(@ModelAttribute AddNewSource addnewsource, HttpSession session,
			@PathVariable String status) {

		Map<String, Object> map = null;
		try {
			map = new HashMap<String, Object>();

			// get user from session
			MemberObj memberObj = CGlobal.getC_UserInfo(session);
			if (memberObj.getCodempid() == "" || memberObj.getCodempid() == null) {
				return map;
			}

			addnewsource.setcreate_by(memberObj.getCodempid());
			addnewsource.setupdate_by(memberObj.getCodempid());
			addnewsource.setupdate_date(memberObj.getCodempid());

			// check from database

			// System.out.println("getObj = " + obj);

			if (status.equals("add")) {
				List<Map<String, Object>> obj = utilService.getsourcedetail(addnewsource);
				if (obj.isEmpty()) {
					utilService.saveSource(addnewsource);
					map.put("status", "Save Successful");
				} else {
					map.put("status", "Source Id : " + addnewsource.getsource_id() + " is already exist");
				}
			} else if (status.equals("edit")) {
				utilService.editSource(addnewsource);
				map.put("status", "Save Successful");
			}

			map.put("resultCode", "00");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/util-deleteUser", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> deleteUser(@RequestBody RandomOil objReq) {
		List<Map<String, Object>> obj = null;
		try {
			obj = utilService.deleteUser(objReq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@RequestMapping(value = "/util-deleteSource", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> deleteSource(@RequestBody AddNewSource objReq) {
		List<Map<String, Object>> obj = null;
		try {
			obj = utilService.deleteSource(objReq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@RequestMapping(value = "/util-getOilforEdit", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getOilforEdit(@RequestBody RandomOil objReq) {
		List<Map<String, Object>> obj = null;
		try {
			obj = utilService.getOilforEdit(objReq);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-saveEditOil", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> saveEditOil(@RequestBody RandomOil objReq) {
		List<Map<String, Object>> obj = null;
		try {
			obj = utilService.saveEditOil(objReq);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-getUnitSpecForUpdate", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getUnitSpecForUpdate(@RequestBody RandomOil objReq) {
		List<Map<String, Object>> obj = null;
		try {
			obj = utilService.getUnitSpecForUpdate(objReq);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-saveSpecUnit", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> saveSpecUnit(@RequestBody RandomOil objReq, HttpSession session) {
		List<Map<String, Object>> obj = null;
		try {
			MemberObj memberObj = CGlobal.getC_UserInfo(session);
			objReq.setCreateBy(memberObj.getCodempid());
			obj = utilService.saveSpecUnit(objReq);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-getVisual", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getVisual() {
		List<Map<String, Object>> obj = null;
		try {
			obj = utilService.getVisual();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@RequestMapping(value = "/util-getColor", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getColor() {
		List<Map<String, Object>> obj = null;
		try {
			obj = utilService.getColor();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-geteditdropdown", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> geteditdropdown(@RequestBody RandomOil objReq) {
		List<Map<String, Object>> obj = null;
		try {
			obj = utilService.geteditdropdown(objReq);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-updateDynamicToolId", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> updateDynamicToolId(@RequestBody RandomOil objReq) {
		List<Map<String, Object>> obj = null;
		try {
			obj = utilService.updateDynamicToolId(objReq);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-getWaitwork", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getWaitwork(@RequestBody RandomOil objReq) {
		List<Map<String, Object>> obj = null;
		try {
			obj = utilService.getWaitwork(objReq.getProductID());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-getmethodcondition", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getmethodcondition(@RequestBody RandomOil objReq) {
		List<Map<String, Object>> obj = null;
		try {
			obj = utilService.getmethodcondition(objReq.getMethodDataAss());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-getSpecMobileLtr", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> getSpecMobileLtr(@RequestBody RandomOil objReq) {
		List<Map<String, Object>> obj = null;
		try {
			obj = utilService.getSpecMobileLtr(objReq.getProductID());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-getMobileTool", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getMobileTool() {
		List<Map<String, Object>> obj = null;
		try {
			obj = utilService.getMobileTool();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-getMobilePlant", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getMobilePlant() {
		List<Map<String, Object>> obj = null;
		try {
			obj = utilService.getMobilePlant();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-saveMobileLtrSpec", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> saveMobileLtrSpec(@RequestBody MobileLtrSpec mobileLtrSpec,
			HttpSession session) {
		List<Map<String, Object>> obj = null;
		MemberObj memberObj = CGlobal.getC_UserInfo(session);
		try {
			mobileLtrSpec.setUpdateBy(memberObj.getCodempid());
			obj = utilService.saveMobileLtrSpec(mobileLtrSpec);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-updateMobileTool/{status}", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> updateMobileTool(@ModelAttribute MobileTool mobileTool, HttpSession session,
			@PathVariable String status) {
		List<Map<String, Object>> obj = null;
		MemberObj memberObj = CGlobal.getC_UserInfo(session);
		try {
			mobileTool.setUpdateBy(memberObj.getCodempid());
			obj = utilService.updateMobileTool(mobileTool, status);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-deleteMobileTool", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> deleteMobileTool(@RequestBody MobileTool mobileTool) {
		List<Map<String, Object>> obj = null;

		try {
			obj = utilService.deleteMobileTool(mobileTool);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-updateMobilePlant/{status}", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> updateMobilePlant(@ModelAttribute MobilePlant mobilePlant, HttpSession session,
			@PathVariable String status) {
		List<Map<String, Object>> obj = null;
		MemberObj memberObj = CGlobal.getC_UserInfo(session);
		try {
			mobilePlant.setUpdateBy(memberObj.getCodempid());
			obj = utilService.updateMobilePlant(mobilePlant, status);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-deleteMobilePlant", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> deleteMobilePlant(@RequestBody MobilePlant mobilePlant) {
		List<Map<String, Object>> obj = null;

		try {
			obj = utilService.deleteMobilePlant(mobilePlant);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-getrootcause", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getrootcausegetrootcause() {
		List<Map<String, Object>> obj = null;
		try {
			obj = utilService.getrootcause();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-saverootcause", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> saverootcause(@RequestParam String labcode, @RequestParam String rtcode,
			@RequestParam String rtdesc) {
		List<Map<String, Object>> obj = null;

		try {
			obj = utilService.saverootcause(labcode, rtcode, rtdesc);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-getVisualt", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getVisualt() {
		List<Map<String, Object>> obj = null;
		try {
			obj = utilService.getVisualt();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-updateVisual/{status}", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> updateVisual(@ModelAttribute VisualAndColor visualAndColor, HttpSession session,
			@PathVariable String status) {
		List<Map<String, Object>> obj = null;
		MemberObj memberObj = CGlobal.getC_UserInfo(session);
		try {
			visualAndColor.setUpdateBy(memberObj.getCodempid());
			obj = utilService.updateVisual(visualAndColor, status);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-deleteVisual", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> deleteVisual(@RequestBody VisualAndColor visualAndColor) {
		List<Map<String, Object>> obj = null;

		try {
			obj = utilService.deleteVisual(visualAndColor);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-updateColor/{status}", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> updateColor(@ModelAttribute VisualAndColor visualAndColor, HttpSession session,
			@PathVariable String status) {
		List<Map<String, Object>> obj = null;
		MemberObj memberObj = CGlobal.getC_UserInfo(session);
		try {
			visualAndColor.setUpdateBy(memberObj.getCodempid());
			obj = utilService.updateColor(visualAndColor, status);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-deleteColor", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> deleteColor(@RequestBody VisualAndColor visualAndColor) {
		List<Map<String, Object>> obj = null;

		try {
			obj = utilService.deleteColor(visualAndColor);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-checkIRPC", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> checkIRPC(@RequestBody RandomOil objReq) {
		List<Map<String, Object>> obj = null;
		try {
			obj = utilService.checkIRPC(objReq.getLabCode());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	// new service
	@RequestMapping(value = "/util-assignToTemp", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> assignToTemp(@RequestBody RandomOil objReq, HttpSession session) {
		List<Map<String, Object>> obj = null;

		try {
			MemberObj memberObj = CGlobal.getC_UserInfo(session);
			obj = utilService.assignToTemp(objReq.getLtrNo(), memberObj.getCodempid());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-returnFromTemp", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> returnFromTemp(@RequestBody RandomOil objReq, HttpSession session) {
		List<Map<String, Object>> obj = null;

		try {
			utilService.triggerUpdateLtrdtSub();
			MemberObj memberObj = CGlobal.getC_UserInfo(session);
			obj = utilService.returnFromTemp(objReq.getLtrNo(), memberObj.getCodempid());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

	@RequestMapping(value = "/util-saveSpecUncer", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> saveSpecUncer(@RequestBody RandomOil objReq, HttpSession session) {
		List<Map<String, Object>> obj = null;
		try {
			MemberObj memberObj = CGlobal.getC_UserInfo(session);
			objReq.setCreateBy(memberObj.getCodempid());
			obj = utilService.saveSpecUncer(objReq);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}
	
	@RequestMapping(value = "/util-updateLTRSpec", method = RequestMethod.POST)
	public @ResponseBody List<Map<String, Object>> updateLTRSpec(@ModelAttribute LTRSpec objReq, HttpSession session) {
		List<Map<String, Object>> obj = null;
		try {
			MemberObj memberObj = CGlobal.getC_UserInfo(session);
			objReq.setUpdate_by(memberObj.getCodempid());
			obj = utilService.updateLTRSpec(objReq);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

}