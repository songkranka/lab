package th.co.pt.ptgapp.dao.report;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.HashMapChangeSet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import th.co.pt.ptgapp.entity.RequestCondition;
import th.co.pt.ptgapp.entity.ResultLTrBean;
import th.co.pt.ptgapp.entity.StationBean;
import th.co.pt.ptgapp.utils.MessageConfig;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
@Repository
public class ReportLTRDao {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	int flagyO;
	int flaguO;
	int flagnO;
	String conditionO;
	
	@Autowired
	private  JdbcTemplate jdbcTemplateSQLSERVER;

	@Autowired
	MessageConfig messageConfig;
	
	//report 1
	public List<Map<String,Object>> getDataForLTR(String[] labCode,String reportedBy,String codEmpId){
		Map<String,Integer> result = new HashMap<>();
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		String productCode="";
		String productSub = "";
		int flagy=0;
		int flagu=0;
		int flagn=0;
		flagyO=0;
		flaguO=0;
		flagnO=0;
		
		String condition ="";
		conditionO ="";
		
		try {
			StringBuffer sql = new StringBuffer();

			String str = "";
			for(String s : labCode){
				if("".equals(str)){
					str = "'"+s+"'";
				}else{
					str+=","+"'"+s+"'";
				}
			}
			//logger.info("labCode : {}",str);

			//checkUserA1(codEmpId,str);
			StringBuffer sql2 = new StringBuffer();
			//===================================================
			String params = getSampleTyepCodeAndProductType(labCode);
			//logger.info("params --> store : {}",params);
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDataReportLTR") ;
//            //logger.info(" call :{}",call);

			SqlParameterSource in = new MapSqlParameterSource().addValue("param",params,Types.VARCHAR);
			//Map<String, Object> mapStroeProce= call.execute(in);
//            //logger.info("mapStroeProce : {}",mapStroeProce);

			List<Map<String, Object>>  listMapStroeGetData= (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			Map<String, Map<String,Object>> listDataOrigin = new HashMap<>();
			
			logger.info("listMapStroeGetData : {}",listMapStroeGetData);
			
			String userA1 = getReportedRoleA1("user");
			String codempA1 = getReportedRoleA1("codemp");
			String userLabTeamLead = getReportedRoleLabTeamLead("");
			String codempLabTeamLead = getReportedRoleLabTeamLead("codemp");
			List<Map<String,Object>> listData = new ArrayList<>();
			Map<String,Object> mapData = new HashMap<>();
			Map<String,Object> mapDataDiff = new HashMap<>();
			String labCodeCheck = "";
			boolean checkLabCode =true;
			Integer index =1;
			String disStr = "";
//			List<String> labCodeChk = new ArrayList<>();

			Set<String>labCodeChk = new HashSet<>();
			
			//get labCode for check
			//List<String>listLabCode = new ArrayList<>();
			for(Map<String,Object> m : listMapStroeGetData){
				labCodeChk.add(m.get("labCode").toString());
			}

			LinkedHashSet<String> fifo = new LinkedHashSet<String>();
			for(Map<String,Object> m : listMapStroeGetData){
				fifo.add(m.get("labCode").toString());
			}
			str="";
			for(String s : fifo){
				if("".equals(str)){
					str = "'"+s+"'";
				}else{
					str+=","+"'"+s+"'";
				}
			}
//			Map<Object,String> mapCheLabCode = new HashMap<>();
//			
//			int cheIndex= 0;
//			for(String s : labCodeChk){
//				mapCheLabCode.put(cheIndex,s);
//				cheIndex++;
//			}

			// Year
			Date date = new Date();
			SimpleDateFormat DateFor = new SimpleDateFormat("YY");
			String stringDate= DateFor.format(date);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			String printDate= dateFormat.format(date);

			String patternOneDigit = "###,###.#";
			String patternTwoDigit = "###,###.##";
			String patternThreeDigit = "###,###.###";
			String patternFourDigit = "###,###.####";
			DecimalFormat decimalFormat1 = new DecimalFormat(patternOneDigit);
			DecimalFormat decimalFormat2 = new DecimalFormat(patternTwoDigit);
			DecimalFormat decimalFormat3 = new DecimalFormat(patternThreeDigit);
			DecimalFormat decimalFormat4 = new DecimalFormat(patternFourDigit);

			String productNameReportTruck = messageConfig.get("title.truck");
			
			List<Map<String,Object>> listDataHeader = getDataTitle(str);
			
			Integer sequent = 1;
			Map<String,Object> dataHeader =  new HashMap<>();
			
			List<Map<String,Object>> userPrintLtr = setFlagPrintLTR(labCode,reportedBy,codEmpId);
			for(int i =0 ;i< str.split(",").length;i++){
				boolean checkResult =true;
				disStr = "";
				dataHeader = listDataHeader.get(i);
				
				//dataHeader.put("SAMPLE_POINT_DESC",dataHeader.get("SAMPLE_POINT_DESC").toString());
				
				if(dataHeader.get("LTR_CODE_REF") != null && !dataHeader.get("LTR_CODE_REF").toString().isEmpty())
					listDataOrigin = getDataOrigin(dataHeader.get("SAMPLE_TYPE"), dataHeader.get("LTR_CODE_REF").toString());
				
				mapData = new HashMap<>();
				mapData.put("productName",dataHeader.get("PRODUCT_NAME") ==null ? "-":dataHeader.get("PRODUCT_NAME").toString());
				mapData.put("LTR_TO", dataHeader.get("PLANT_NAME") ==null ? "-":dataHeader.get("PLANT_NAME").toString());
				mapData.put("LTR_CODE",  dataHeader.get("LTR_CODE").toString() );
				//condition report

				

				if("005".equals(dataHeader.get("SUB_TYPE_CODE") ==null ? "-":dataHeader.get("SUB_TYPE_CODE").toString())||"100000041".equals(dataHeader.get("PRODUCT_ID") ==null ? "-":dataHeader.get("PRODUCT_ID").toString())){
					mapData.put("LTR_CC", "IRPC");
				}
				String zManualType = dataHeader.get("manual_type") == null ? "-" : dataHeader.get("manual_type").toString();
				if("00001".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())
						||"00010".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())) {
					if("N".equals(zManualType)){
						mapData.put("LTR_CC", "SUPPLY & TRANSPORT SECTION");
					}else {
						if(dataHeader.get("PRODUCT_ID").toString().equals("100000041")) {
							mapData.put("LTR_CC", "IRPC");
						}else {
							mapData.put("LTR_CC", "-");
						}
					}
					
					/*if ("ไบโอดีเซล".equals(dataHeader.get("PRODUCT_NAME"))) {
						mapData.put("LTR_CC", "IRPC");
						mapData.put("INV_NO", dataHeader.get("SAMPLE_TYPEC_DESC") == null ? "-" : dataHeader.get("SAMPLE_TYPEC_DESC").toString());
					}else if("N".equals(dataHeader.get("manual_type") == null ? "-" : dataHeader.get("manual_type").toString())){
						mapData.put("LTR_CC", "SUPPLY & TRANSPORT SECTION");
					}else if("Y".equals(dataHeader.get("manual_type") == null ? "-" : dataHeader.get("manual_type").toString())){
						mapData.put("LTR_CC", "-");
					}else{
						mapData.put("LTR_CC", "SUPPLY & TRANSPORT SECTION");
					}*/

				}else if("00002".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())
						||"00008".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())
						||"00009".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())) {
//					if("0001".equals(dataHeader.get("TYPE_STATION_ID") ==null ? "-":dataHeader.get("TYPE_STATION_ID").toString())) {
//						mapData.put("LTR_CC", "ผู้จัดการเขต");
//					}else if("0002".equals(dataHeader.get("TYPE_STATION_ID") ==null ? "-":dataHeader.get("TYPE_STATION_ID").toString())){
//						mapData.put("LTR_CC", "ผู้จัดฝ่ายการขาย");
//					}else {
						mapData.put("LTR_CC", "IRPC");
						//mapData.put("LTR_CC", "-");
//					}

				}else if("00003".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())) {
//					if("0001".equals(dataHeader.get("TYPE_STATION_ID") ==null ? "-":dataHeader.get("TYPE_STATION_ID").toString())) {
//						mapData.put("LTR_CC", "ผู้จัดการเขต");
//					}else if("0002".equals(dataHeader.get("TYPE_STATION_ID") ==null ? "-":dataHeader.get("TYPE_STATION_ID").toString())){
//						mapData.put("LTR_CC", "ผู้จัดฝ่ายการขาย");
//					}else {
						//mapData.put("LTR_CC", "IRPC");
						mapData.put("LTR_CC", "IRPC");
//					}
				}else if("00004".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())) {
					if("0001".equals(dataHeader.get("TYPE_STATION_ID") ==null ? "-":dataHeader.get("TYPE_STATION_ID").toString())) {
						mapData.put("LTR_CC", "ผู้จัดการเขต");
					}else if("0002".equals(dataHeader.get("TYPE_STATION_ID") ==null ? "-":dataHeader.get("TYPE_STATION_ID").toString())){
						mapData.put("LTR_CC", "ผู้จัดฝ่ายการขาย");
					}else {
						if(dataHeader.get("PRODUCT_ID").toString().equals("100000041") || dataHeader.get("SUB_TYPE_CODE").toString().equals("005")) {
							mapData.put("LTR_CC", "IRPC");
						}else {
							mapData.put("LTR_CC", "-");
						}
					}

				}else if("00005".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())) {
					if("0001".equals(dataHeader.get("TYPE_STATION_ID") ==null ? "-":dataHeader.get("TYPE_STATION_ID").toString())) {
						mapData.put("LTR_CC", "ผู้จัดการเขต");
					}else if("0002".equals(dataHeader.get("TYPE_STATION_ID") ==null ? "-":dataHeader.get("TYPE_STATION_ID").toString())){
						mapData.put("LTR_CC", "ผู้จัดฝ่ายการขาย");
					}else {
						mapData.put("LTR_CC", "-");
					}

				}else if("00006".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())) {
					if("0001".equals(dataHeader.get("TYPE_STATION_ID") ==null ? "-":dataHeader.get("TYPE_STATION_ID").toString())) {
						mapData.put("LTR_CC", "ผู้จัดการเขต");
					}else if("0002".equals(dataHeader.get("TYPE_STATION_ID") ==null ? "-":dataHeader.get("TYPE_STATION_ID").toString())){
						mapData.put("LTR_CC", "ผู้จัดฝ่ายการขาย");
					}else {
						mapData.put("LTR_CC", "IRPC");
					}

				}else {
					if("0001".equals(dataHeader.get("TYPE_STATION_ID") ==null ? "-":dataHeader.get("TYPE_STATION_ID").toString())) {
						mapData.put("LTR_CC", "ผู้จัดการเขต");
					}else if("0002".equals(dataHeader.get("TYPE_STATION_ID") ==null ? "-":dataHeader.get("TYPE_STATION_ID").toString())){
						mapData.put("LTR_CC", "ผู้จัดฝ่ายการขาย");
					}else if("0003".equals(dataHeader.get("TYPE_STATION_ID") ==null ? "-":dataHeader.get("TYPE_STATION_ID").toString())){
						mapData.put("LTR_CC", "ผู้จัดการเขต");
					}else if("0004".equals(dataHeader.get("TYPE_STATION_ID") ==null ? "-":dataHeader.get("TYPE_STATION_ID").toString())){
						mapData.put("LTR_CC", "ผู้จัดการเขต");
					}else {
						mapData.put("LTR_CC", "-");
					}
				}
				
			
				
				
				mapData.put("LTR_CAR_NO", dataHeader.get("CAR_NO") ==null ? "-":dataHeader.get("CAR_NO").toString().concat("/").concat(stringDate));

				mapData.put("LTR_PRODUCT", dataHeader.get("PRODUCT_NAME_REPORT") ==null ? "-":dataHeader.get("PRODUCT_NAME_REPORT").toString());
				if("00001".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())
						||"00010".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())
						) {
					mapData.put("PRODUCT_DESC", dataHeader.get("SAMPLE_TYPEC_DESC") ==null ? "-":dataHeader.get("SAMPLE_TYPEC_DESC").toString());
					mapData.put("LTR_REF", dataHeader.get("SEND_REQT_ID") ==null ? "-":dataHeader.get("SEND_REQT_ID").toString());
					//LTR_DESC for LTR_C_CAR and LTR_C_CAR_BIO Only
					mapData.put("LTR_DESC", dataHeader.get("SAMPLE_POINT_DESC") == null ?
							dataHeader.get("SAMPLE_TYPEC_DESC") == null ? "" : dataHeader.get("SAMPLE_TYPEC_DESC") :
								dataHeader.get("SAMPLE_POINT_DESC").toString());
					mapData.put("LTR_VESSEL", dataHeader.get("VESSEL") ==null ? "-":dataHeader.get("VESSEL").toString());
				}else if("00002".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())
						||"00008".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())
						||"00009".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())
						) {

//					mapData.put("LTR_PRODUCT", dataHeader.get("PRODUCT_NAME_REPORT") ==null ? "-":dataHeader.get("PRODUCT_NAME_REPORT").toString());
					mapData.put("LTR_REF", dataHeader.get("SEND_REQT_ID") ==null ? "-":dataHeader.get("SEND_REQT_ID").toString());
					//LTR_DESC for LTR_C_CAR and LTR_C_CAR_BIO Only
					mapData.put("LTR_DESC", dataHeader.get("SAMPLE_POINT_DESC") == null ?
							dataHeader.get("SAMPLE_TYPEC_DESC") == null ? "" : dataHeader.get("SAMPLE_TYPEC_DESC") :
								dataHeader.get("SAMPLE_POINT_DESC").toString());mapData.put("LTR_VESSEL", dataHeader.get("BOAT_NAME") ==null ? "-":dataHeader.get("BOAT_NAME").toString());
					mapData.put("SHIPMENT_NO", dataHeader.get("BOAT_NO") ==null ? "-":dataHeader.get("BOAT_NO").toString());
				}else if("00003".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())) {
					String carNoAndSlot = "";
					String carNo = dataHeader.get("CAR_NO") ==null ? "-":dataHeader.get("CAR_NO").toString();
					String carSlot = dataHeader.get("CAR_SLOT") ==null ? "-":dataHeader.get("CAR_SLOT").toString();

					mapData.put("LTR_PRODUCT", productNameReportTruck);
					mapData.put("LTR_REF", dataHeader.get("METER_NO") ==null ? "-":dataHeader.get("METER_NO").toString());
					//LTR_DESC for LTR_C_CAR and LTR_C_CAR_BIO Only
					mapData.put("LTR_DESC", dataHeader.get("SAMPLE_POINT_DESC") == null ?
							dataHeader.get("SAMPLE_TYPEC_DESC") == null ? "" : dataHeader.get("SAMPLE_TYPEC_DESC") :
								dataHeader.get("SAMPLE_POINT_DESC").toString());					mapData.put("LTR_REQUEST_NO", dataHeader.get("SEND_REQT_ID") ==null ? "-":dataHeader.get("SEND_REQT_ID").toString());
					mapData.put("LTR_VESSEL", carNo+"/"+carSlot);
				}else if("00004".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())){
//					mapData.put("LTR_PRODUCT", dataHeader.get("PRODUCT_NAME_REPORT") ==null ? "-":dataHeader.get("PRODUCT_NAME_REPORT").toString());
					mapData.put("LTR_REF", dataHeader.get("SEND_REQT_ID") ==null ? "-":dataHeader.get("SEND_REQT_ID").toString());
					//LTR_DESC for LTR_C_CAR and LTR_C_CAR_BIO Only
					mapData.put("LTR_DESC", dataHeader.get("SAMPLE_POINT_DESC") == null ?
							dataHeader.get("SAMPLE_TYPEC_DESC") == null ? "" : dataHeader.get("SAMPLE_TYPEC_DESC") :
								dataHeader.get("SAMPLE_POINT_DESC").toString());					mapData.put("PRODUCT_DESC", dataHeader.get("SAMPLE_TYPEC_DESC") ==null ? "-":dataHeader.get("SAMPLE_TYPEC_DESC").toString());
					mapData.put("LTR_VESSEL", dataHeader.get("VESSEL") ==null ? "-":dataHeader.get("VESSEL").toString());

				}else if("00005".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())){
//					mapData.put("LTR_PRODUCT", dataHeader.get("PRODUCT_NAME_REPORT") ==null ? "-":dataHeader.get("PRODUCT_NAME_REPORT").toString());
					mapData.put("LTR_REF", dataHeader.get("SEND_REQT_ID") ==null ? "-":dataHeader.get("SEND_REQT_ID").toString());
					//LTR_DESC for LTR_C_CAR and LTR_C_CAR_BIO Only
					mapData.put("LTR_DESC", dataHeader.get("SAMPLE_POINT_DESC") == null ?
							dataHeader.get("SAMPLE_TYPEC_DESC") == null ? "" : dataHeader.get("SAMPLE_TYPEC_DESC") :
								dataHeader.get("SAMPLE_POINT_DESC").toString());					mapData.put("PRODUCT_DESC", dataHeader.get("RETURNR_DESC") ==null ? "-":dataHeader.get("RETURNR_DESC").toString());
					mapData.put("LTR_VESSEL", dataHeader.get("SAMPLE_POINT_DESC") ==null ? "-":dataHeader.get("SAMPLE_POINT_DESC").toString());
				}else if("00007".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())){
//					mapData.put("LTR_PRODUCT", dataHeader.get("PRODUCT_NAME_REPORT") ==null ? "-":dataHeader.get("PRODUCT_NAME_REPORT").toString());
					mapData.put("LTR_REF", dataHeader.get("SEND_REQT_ID") ==null ? "-":dataHeader.get("SEND_REQT_ID").toString());
					//LTR_DESC for LTR_C_CAR and LTR_C_CAR_BIO Only
					mapData.put("LTR_DESC", dataHeader.get("SAMPLE_POINT_DESC") == null ?
							dataHeader.get("SAMPLE_TYPEC_DESC") == null ? "" : dataHeader.get("SAMPLE_TYPEC_DESC") :
								dataHeader.get("SAMPLE_POINT_DESC").toString());					mapData.put("LTR_VESSEL", dataHeader.get("SAMPLE_POINT_DESC") ==null ? "-":dataHeader.get("SAMPLE_POINT_DESC").toString());
					mapData.put("V_REASON", dataHeader.get("RETURNR_DESC") ==null ? "-":dataHeader.get("RETURNR_DESC").toString());

				}

				mapData.put("LTR_DATE",dataHeader.get("DTS_CREATE_DATE") ==null ? "-":dataHeader.get("DTS_CREATE_DATE").toString() );




				String resString = "";
				if( "Y".equals(dataHeader.get("manual_type") ==null ? "-":dataHeader.get("manual_type").toString())) {
					resString = dataHeader.get("SAMPLE_DATE") ==null ? "-":dataHeader.get("SAMPLE_DATE").toString();
					//resString = dataHeader.get("RAN_STICKER_DATE") ==null ? "-":dataHeader.get("RAN_STICKER_DATE").toString();
					//resString += " ; ".concat(dataHeader.get("SAMPLE_TYPEC_DESC") ==null ? "-":dataHeader.get("SAMPLE_TYPEC_DESC").toString());
					mapData.put("LTR_DATE_EX", resString);
					mapData.put("LTR_GAUGE","-");
					mapData.put("LTR_GAUGE2","");
					//System.out.println(resString);
				}else {
					resString = dataHeader.get("RAN_STICKER_DATE") ==null ? "-":dataHeader.get("RAN_STICKER_DATE").toString();
					//resString += " ; ".concat(dataHeader.get("SAMPLE_TYPEC_DESC") ==null ? "-":dataHeader.get("SAMPLE_TYPEC_DESC").toString());
					mapData.put("LTR_DATE_EX", resString);
					mapData.put("LTR_GAUGE", dataHeader.get("SOURCE_NAME") ==null ? "-":dataHeader.get("SOURCE_NAME").toString());
					mapData.put("LTR_GAUGE2", dataHeader.get("LOGIS_NAME") ==null ? "-":dataHeader.get("LOGIS_NAME").toString());
				}
				//System.out.println(resString);
				mapData.put("LTR_REPORT", dataHeader.get("report_no") ==null ? "-":dataHeader.get("report_no").toString());
				mapData.put("REPLACE_NEW_LTR", dataHeader.get("report_no_ref")==null||dataHeader.get("report_no_ref").toString().length()<5  ? "":"(ออกทดแทน "+dataHeader.get("report_no_ref").toString()+")");
//				mapData.put("P_HEAD_RANDOM_DATE", dataHeader.get("RAN_CREATE_DATE") ==null ? "-":dataHeader.get("RAN_CREATE_DATE").toString());
				mapData.put("LTR_CODE_NO", dataHeader.get("LAB_CODE") ==null ? "-":dataHeader.get("LAB_CODE").toString());
				mapData.put("P_HEAD", "Uncertainty");
				mapData.put("P_HEAD_TEST_ITEMS", "TEST ITEMS");
				mapData.put("P_HEAD_UNIT", "UNIT");
				mapData.put("P_HEAD_TEST_METHOD", "TEST METHOD");
				mapData.put("P_HEAD_SPECS", "SPECS");
				mapData.put("P_HEAD_TEST_RESULT", "TEST RESULT");
				String gaugeStr1 = dataHeader.get("SOURCE_NAME") ==null ? "-":dataHeader.get("SOURCE_NAME").toString()+",";
				String gaugeStr2 = dataHeader.get("LOGIS_NAME") ==null ? "-":dataHeader.get("LOGIS_NAME").toString();
				//logger.info("gaugeStr : {}",gaugeStr1.concat(gaugeStr2));
				

//				mapData.put("V_APPROVE_BY", dataHeader.get("APPROVE_BY") ==null ? "-":dataHeader.get("APPROVE_BY").toString());
				mapData.put("V_APPROVE_BY", userLabTeamLead);
				mapData.put("V_APPROVE_BY_CODE", codempLabTeamLead);
				mapData.put("V_APPROVE_DATE", dataHeader.get("APPROVE_DATE") ==null ? printDate :dataHeader.get("APPROVE_DATE").toString());
//				mapData.put("V_REPORTED_BY", dataHeader.get("REPORTED_BY") ==null ? "-":dataHeader.get("REPORTED_BY").toString());
//				mapData.put("V_REPORTED_DATE", dataHeader.get("REPORTED_DATE") ==null ? "-":dataHeader.get("REPORTED_DATE").toString());
				mapData.put("V_REPORTED_BY", dataHeader.get("rREPORTED_BY") ==null ? printDate :dataHeader.get("rREPORTED_BY").toString());
				mapData.put("V_REPORTED_BY_CODE", dataHeader.get("rREPORTED_BY_CODE") ==null ? printDate :dataHeader.get("rREPORTED_BY_CODE").toString());
				mapData.put("V_REPORTED_DATE",dataHeader.get("rREPORTED_DATE") ==null ? printDate :dataHeader.get("rREPORTED_DATE").toString());
//				if(labCode[i].equalsIgnoreCase(userPrintLtr.get(i).get("labCode")==null ?"":userPrintLtr.get(i).get("labCode").toString())) {
//					if(null!= userPrintLtr.get(i).get("roleId") && "A1".equals(userPrintLtr.get(i).get("roleId").toString())){
//						mapData.put("V_REPORTED_BY", userPrintLtr.get(i).get("printName")==null?"":userPrintLtr.get(i).get("printName").toString());
//						mapData.put("V_REPORTED_BY_CODE", userPrintLtr.get(i).get("codemp_id")==null?"":userPrintLtr.get(i).get("codemp_id").toString());
//					}else{
//						mapData.put("V_REPORTED_BY", userA1);
//						mapData.put("V_REPORTED_BY_CODE", codempA1);
//					}
//
//				}
				
				
			
				if(checkConditionReport(dataHeader)&&"IRPC".equals(mapData.get("LTR_CC").toString())) {
					mapData.put("NOTE_FROM_ADMIN", dataHeader.get("remarkfromadmin") ==null ? "":"3. "+dataHeader.get("remarkfromadmin").toString());
				}else {
					mapData.put("NOTE_FROM_ADMIN", dataHeader.get("remarkfromadmin") ==null ? "":"หมายเหตุ : "+dataHeader.get("remarkfromadmin").toString());
				}

				
				//Result Test

				index=1;
				sql = new StringBuffer();
				sql.append("  select distinct(agi.GITEM_NAME) ,agi.gitem_id \n");
				sql.append(" from ASS_LTR_DT dt with (nolock) \n");
				sql.append(" inner join ASS_LTR_DT_USER ud with (nolock) on ud.LTR_DT_ID = dt.LTR_DT_ID  \n");
				sql.append(" inner join ASS_ITEM_SPEC_MP i with (nolock) on i.ITEMMP_ID = dt.ITEMMP_ID \n");
				sql.append(" inner join ASS_ITEM_SPEC_MP_METHOD m with (nolock) on m.ITEMMP_ID = dt.ITEMMP_ID  \n");
				sql.append(" inner join ASS_ITEM_SPEC_MP_TOOL t with (nolock) on t.ITEMMP_ID = dt.ITEMMP_ID \n");
				sql.append(" inner join ASS_ITEM_SPEC_MP_USER u with (nolock) on u.ITEMMP_ID = dt.ITEMMP_ID \n");
				sql.append(" inner join ASS_METHOD_MASTER ma with (nolock) on ma.METHOD_ID = dt.METHOD_ID \n");
				sql.append(" inner join ASS_TOOL_MASTER ta with (nolock) on ta.TOOL_ID = dt.TOOL_ID \n");
				sql.append(" inner join ASS_ITEM_MASTER ia with (nolock) on ia.ITEM_ID = dt.ITEM_ID \n");
				sql.append(" inner join USER_TYPE ut with (nolock) on ut.USER_TYPE_ID = ud.USER_TYPE_ID \n");
				sql.append(" inner join PRODUCT_MAINLAB p with (nolock) on p.PRODUCT_ID = i.PRODUCT_ID \n");
				sql.append(" inner join ASS_ITEM_SPEC_MP_SPDETAIL sp with (nolock) on sp.itemmp_id = dt.ITEMMP_ID \n");
				sql.append(" inner join ASS_LTR_DT_SUB sub with (nolock) on sub.ltr_dt_id = dt.LTR_DT_ID \n");
				sql.append(" inner join ASS_PRODUCT_GPMP apg with (nolock) on apg.PRODUCT_ID =  p.PRODUCT_ID \n");
				sql.append(" inner join ASS_GROUP_ITEM agi  with (nolock) on agi.GITEM_ID =  apg.GITEM_ID \n");
				sql.append(" inner join ASS_GROUP_ITEM_SPEC agis with (nolock) on agis.GITEM_ID = apg.GITEM_ID and agis.ITEMMP_ID = ia.ITEM_ID  \n");
				sql.append(" where 1=1 \n");
				sql.append("  and m.DEFAULT_FLG = 'Y' and t.DEFAULT_FLG = 'Y' and u.DEFAULT_FLG = 'Y'  \n");
				sql.append(" and dt.LTR_CODE in (select LTR_CODE from ASS_LTR_HD where LAB_CODE in ("+"'"+str.split(",")[i].replaceAll("'", "")+"'"+") ) \n");
				sql.append(" order by agi.gitem_id asc \n");

				List<Map<String,Object>> listGroupItems = jdbcTemplateSQLSERVER.queryForList(sql.toString());
				
				// check IRPC
				if("IRPC".equals(mapData.get("LTR_CC").toString())) {

					for(Map<String,Object> m : listMapStroeGetData){
						if(str.split(",")[i].replaceAll("'", "").equalsIgnoreCase(m.get("labCode").toString())){
							if("ผ่าน".equals(m.get("UNCERT"))
							||"ผ่านแบบมีเงื่อนไข".equals(m.get("UNCERT"))&&("00003").equals(dataHeader.get("SAMPLE_TYPE")!=null?dataHeader.get("SAMPLE_TYPE").toString():"")		
							||!"0010".equals(m.get("itemsId").toString())&&!"0013".equals(m.get("itemsId").toString())&&"ผ่านแบบมีเงื่อนไข".equals(m.get("UNCERT"))	
						
							){
								flagy++;
							}else if("ผ่านแบบมีเงื่อนไข".equals(m.get("UNCERT"))){
								flagu++;
								
							}else if("ไม่ผ่าน".equals(m.get("UNCERT"))) {
								flagn++;
							}
						}
					}
					//check flag
					if(flagn>0) {
						condition="N";
					}else if(flagu>0) {
						condition="U";
					}else {
						condition="Y";
					}
					//check flag
					if(flagnO>0) {
						conditionO="N";
					}else if(flaguO>0) {
						conditionO="U";
					}else {
						conditionO="Y";
					}
					
					String descEdit = dataHeader.get("REVISE_DESC") ==null ? "-":dataHeader.get("REVISE_DESC").toString();
					mapData.put("PROBLEM_TEXT", (descEdit!=null&&descEdit!=""&&!descEdit.equals("-"))?"สาเหตุ : "+descEdit:"");
					
					for(Map<String,Object> map : listGroupItems) {
						if(checkProductB100(str.split(",")[i].replaceAll("'", ""))){
							mapData.put("LABEL_TEST_ITEM_".concat(index.toString()), map.get("GITEM_NAME").toString() + " : ");
							mapData.put("V_UNIT_".concat(index.toString()), "");
							mapData.put("V_METHOD_".concat(index.toString()), "");
							mapData.put("V_SPECS_".concat(index.toString()), "");
							mapData.put("V_TEST_RESULT_".concat(index.toString()), "");
							index++;
						}


						

						int indexSt =0;
						String chkLap ="";
						for(Map<String,Object> m : listMapStroeGetData){
							if(str.split(",")[i].replaceAll("'", "").equalsIgnoreCase(m.get("labCode").toString())){
								if(map.get("GITEM_NAME").toString().equals(m.get("gitemName").toString())){
									if(m.get("itemName").toString().length()>11){
										String checkStr = m.get("itemName").toString().substring(0, 12);
//									//logger.info(" checkStr : {}",checkStr);
										if("Distillation".equalsIgnoreCase(checkStr)){
											if("".equals(disStr)){
												disStr = "     "+ m.get("itemName").toString().substring(0, 12)+" : "+m.get("itemName").toString().substring(13);
												mapData.put("LABEL_TEST_ITEM_".concat(index.toString()),disStr.concat("*"));
											}else{

												mapData.put("LABEL_TEST_ITEM_".concat(index.toString()),"                        "+ m.get("itemName").toString().substring(12).concat("*"));
											}
										}else{
											
											if(checkConditionReport(dataHeader)) {
											if(("00002".equals(dataHeader.get("SAMPLE_TYPE")!=null?dataHeader.get("SAMPLE_TYPE").toString():"-")
													||"00009".equals(dataHeader.get("SAMPLE_TYPE")!=null?dataHeader.get("SAMPLE_TYPE").toString():"-")
													||"00008".equals(dataHeader.get("SAMPLE_TYPE")!=null?dataHeader.get("SAMPLE_TYPE").toString():"-")
													||("00004").equals(dataHeader.get("SAMPLE_TYPE")!=null?dataHeader.get("SAMPLE_TYPE").toString():"")&&"100000001".equals(dataHeader.get("PRODUCT_ID")!=null?dataHeader.get("PRODUCT_ID").toString():""))
													&&(
															m.get("itemsId").toString().equals("0010")||
															m.get("itemsId").toString().equals("0013")) ||
															(m.get("itemsId").toString().equals("0012") && m.get("methodName").toString().equals("ASTM D 4052-22"))
															){
											mapData.put("LABEL_TEST_ITEM_".concat(index.toString()),"     "+ m.get("itemName").toString());
											}else {
											mapData.put("LABEL_TEST_ITEM_".concat(index.toString()),"     "+ m.get("itemName").toString().concat("*"));
											}
											
											}else {
											mapData.put("LABEL_TEST_ITEM_".concat(index.toString()),"     "+ m.get("itemName").toString());
											}

											
										}
									}else{
											
										if(checkConditionReport(dataHeader)) {
										if(("00002".equals(dataHeader.get("SAMPLE_TYPE")!=null?dataHeader.get("SAMPLE_TYPE").toString():"-")
												||"00009".equals(dataHeader.get("SAMPLE_TYPE")!=null?dataHeader.get("SAMPLE_TYPE").toString():"-")
												||"00008".equals(dataHeader.get("SAMPLE_TYPE")!=null?dataHeader.get("SAMPLE_TYPE").toString():"-")
												||("00004").equals(dataHeader.get("SAMPLE_TYPE")!=null?dataHeader.get("SAMPLE_TYPE").toString():"")&&"100000001".equals(dataHeader.get("PRODUCT_ID")!=null?dataHeader.get("PRODUCT_ID").toString():""))
												&&(m.get("itemsId").toString().equals("0010")||m.get("itemsId").toString().equals("0013"))) {
										mapData.put("LABEL_TEST_ITEM_".concat(index.toString()),"     "+ m.get("itemName").toString());
										}else {
										mapData.put("LABEL_TEST_ITEM_".concat(index.toString()),"     "+ m.get("itemName").toString().concat("*"));
										}
										
										}else {
										mapData.put("LABEL_TEST_ITEM_".concat(index.toString()),"     "+ m.get("itemName").toString());
										}


									}
									String zItemUint = m.get("itemUnit") ==null ?"-": m.get("itemUnit").toString();
									mapData.put("V_UNIT_".concat(index.toString()),zItemUint );
//									if(zItemUint.equals("C")) {
//										mapData.put("V_UNIT_".concat(index.toString()),"°".concat(zItemUint));
//									}else {
//										mapData.put("V_UNIT_".concat(index.toString()),zItemUint );
//									}
									
									mapData.put("V_METHOD_".concat(index.toString()), m.get("methodName").toString());

									mapData.put("V_SPECS_".concat(index.toString()), m.get("specItemBacisText").toString());
									
										if(("0010".equals(m.get("itemsId").toString())||"0013".equals(m.get("itemsId").toString())	
												)) {
											if("ผ่านแบบมีเงื่อนไข".equals(m.get("UNCERT"))&&flagn==0) {
												mapData.put("V_UNCERT".concat(index.toString()),  m.get("RESULT_UN").toString());
											}else {
												mapData.put("V_UNCERT".concat(index.toString()),  "-");
											}
											
										}else {
											mapData.put("V_UNCERT".concat(index.toString()),  "-");
											
										}
									
									if(
										(
										("00003").equals(dataHeader.get("SAMPLE_TYPE")!=null?dataHeader.get("SAMPLE_TYPE").toString():"")
										||!"0010".equals(m.get("itemsId").toString())&&!"0013".equals(m.get("itemsId").toString())&&"ผ่านแบบมีเงื่อนไข".equals(m.get("UNCERT"))
										)
										&&!(m.get("itemsId").toString().equals("0012") && m.get("methodName").toString().equals("ASTM D 4052-22"))

										) {
										//mapData.put("V_FLG_U_".concat(index.toString()),  "ผ่านแบบมีเงื่อนไข".equals(m.get("UNCERT").toString())?"ผ่าน":m.get("UNCERT").toString());
										mapData.put("V_FLG_U_".concat(index.toString()),  "ผ่านแบบมีเงื่อนไข".equals(m.get("UNCERT").toString())?"ผ่าน*":m.get("UNCERT").toString().concat("*"));
									}else {
										//mapData.put("V_FLG_U_".concat(index.toString()),  m.get("UNCERT").toString());
										if("0010".equals(m.get("itemsId").toString()) || "0013".equals(m.get("itemsId").toString()) || "-".equals(m.get("UNCERT"))
											|| 	(m.get("itemsId").toString().equals("0012") && m.get("methodName").toString().equals("ASTM D 4052-22"))
												){
											String label = mapData.get("LABEL_TEST_ITEM_".concat(index.toString())).toString();
											int length = label.length();
											
											if(Character.compare('*',label.charAt(length-1)) == 0 && !"-".equals(m.get("UNCERT"))){
												mapData.put("V_FLG_U_".concat(index.toString()),  m.get("UNCERT").toString().concat("*"));
											} else {
												mapData.put("V_FLG_U_".concat(index.toString()),  m.get("UNCERT").toString());
											}
										} else {
											mapData.put("V_FLG_U_".concat(index.toString()),  m.get("UNCERT").toString().concat("*"));
										}
									}
									
									
								
									if(productCode.isEmpty()&&m.get("prductId")!=null) {
										productCode= m.get("prductId").toString();
									}
									if(productSub.isEmpty()&&m.get("sub_type_code")!=null) {
										productSub = m.get("sub_type_code").toString();
									}

									
									//ผ่าน
									if(("ผ่านแบบมีเงื่อนไข".equals(m.get("UNCERT").toString())&&("00003").equals(dataHeader.get("SAMPLE_TYPE")!=null?dataHeader.get("SAMPLE_TYPE").toString():""))
								    ||"ผ่าน".equals(m.get("UNCERT"))
									||!"0010".equals(m.get("itemsId").toString())&&!"0013".equals(m.get("itemsId").toString())&&"ผ่านแบบมีเงื่อนไข".equals(m.get("UNCERT"))	
									) {
										checkDataResultLTR(m,index,mapData,"");
									}else if("ผ่านแบบมีเงื่อนไข".equals(m.get("UNCERT").toString())) {
										checkDataResultLTR(m,index,mapData,"**");
									}else if("ไม่ผ่าน".equals(m.get("UNCERT").toString())) {
										//checkDataResultLTR(m,index,mapData,"***");
										checkDataResultLTR(m,index,mapData,"**");
									}else{
										mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");	
									}
									//ผ่านแบบมีเงื่อนไข
									//ไม่ผ่าน
									
//									if("Y".equals(m.get("specRang").toString())){
//										checkDataResultLTR(m,index,mapData,"");
//									}else{
//										checkDataResultLTR(m,index,mapData,"");
//									}

									String key = m.get("itemsId").toString().concat(m.get("methodID").toString());
									
									if(listDataOrigin.size() > 0){
										if(listDataOrigin.get(key) != null) {
											if(m.get("methodName") != null && listDataOrigin.get(key).get("methodName") != null && !m.get("methodName").toString().equals(listDataOrigin.get(key).get("methodName").toString())) mapData.put("C_V_METHOD_".concat(index.toString()), "V_METHOD_".concat(index.toString()));
											if(m.get("specItemBacisText") != null && listDataOrigin.get(key).get("specItemBacisText") != null && !m.get("specItemBacisText").toString().equals(listDataOrigin.get(key).get("specItemBacisText").toString())) mapData.put("C_V_SPECS_".concat(index.toString()), "V_SPECS_".concat(index.toString()));
											if(m.get("resultText") != null && listDataOrigin.get(key).get("resultNum") != null && !m.get("resultText").toString().equals(listDataOrigin.get(key).get("resultNum").toString())) mapData.put("C_V_TEST_RESULT_".concat(index.toString()), "V_TEST_RESULT_".concat(index.toString()));
											if(m.get("UNCERT") != null && listDataOrigin.get(key).get("UNCERT") != null && !m.get("UNCERT").toString().equals(listDataOrigin.get(key).get("UNCERT").toString())) mapData.put("C_V_FLG_U_".concat(index.toString()), "V_FLG_U_".concat(index.toString()));
											if(m.get("RESULT_UN") != null && listDataOrigin.get(key).get("RESULT_UN") != null && !m.get("RESULT_UN").toString().equals(listDataOrigin.get(key).get("RESULT_UN").toString())) mapData.put("C_V_UNCERT".concat(index.toString()), "V_UNCERT".concat(index.toString()));
										}
									}
									
									index++;
								}
							}
						}
					}
					
					//add paramer prod
					mapData.put("PRODUCT_CODE", productCode);
					mapData.put("PRODUCT_SUB", productSub);
		
					productCode="";
					productSub="";
					
					
					if("N".equals(condition)){
						mapData.put("P_RESULT_TEST", "ไม่ผ่าน");
						//mapData.put("P_RESULT_TEST", "ไม่ผ่านการตรวจสอบ");
						//mapData.put("NON_PASS", "    ");
					}else if("U".equals(condition)&&!("00003").equals(dataHeader.get("SAMPLE_TYPE")!=null?dataHeader.get("SAMPLE_TYPE").toString():"")) {
						mapData.put("P_RESULT_TEST", "ผ่านแบบมีเงื่อนไข");
						
					}else{
						mapData.put("P_RESULT_TEST", "ผ่าน");
						//mapData.put("P_RESULT_TEST", "ผ่านการตรวจสอบ");
						//mapData.put("NON_PASS", "หมายเหตุ ; เครื่องหมาย * หมายถึง รายการวิเคราะห์ที่ไม่เป็นไปตามข้อกำหนด");
					}
					
					if(!conditionO.isEmpty() && !conditionO.equals(condition) && dataHeader.get("LTR_CODE_REF") != null)
						mapData.put("C_P_RESULT_TEST", "P_RESULT_TEST");
					
					condition="";
					conditionO="";
					flagn=0;
					flagu=0;
					flagy=0;
					flagnO=0;
					flaguO=0;
					flagyO=0;
					listData.add(mapData);
					
				}else {
					String descEdit = "";
					descEdit = dataHeader.get("REVISE_DESC") ==null ? "-":dataHeader.get("REVISE_DESC").toString();
					mapData.put("PROBLEM_TEXT", (descEdit!=null&&descEdit!=""&&!descEdit.equals("-"))?"สาเหตุ : "+descEdit:"");
					
					for(Map<String,Object> map : listGroupItems) {
						if(checkProductB100(str.split(",")[i].replaceAll("'", ""))){
							mapData.put("LABEL_TEST_ITEM_".concat(index.toString()), map.get("GITEM_NAME").toString() + " : ");
							mapData.put("V_UNIT_".concat(index.toString()), "");
							mapData.put("V_METHOD_".concat(index.toString()), "");
							mapData.put("V_SPECS_".concat(index.toString()), "");
							mapData.put("V_TEST_RESULT_".concat(index.toString()), "");
							index++;
						}

						for(Map<String,Object> m : listMapStroeGetData){
							if(str.split(",")[i].replaceAll("'", "").equalsIgnoreCase(m.get("labCode").toString())){
								if("Y".equals(m.get("resultLtr").toString())){
									checkResult =true;
								}else{
									checkResult =false;
									break;
								}
							}
						}
						int indexSt =0;
						String chkLap ="";
						for(Map<String,Object> m : listMapStroeGetData){
							if(str.split(",")[i].replaceAll("'", "").equalsIgnoreCase(m.get("labCode").toString())){
								if(map.get("GITEM_NAME").toString().equals(m.get("gitemName").toString())){
									if(m.get("itemName").toString().length()>11){
										String checkStr = m.get("itemName").toString().substring(0, 12);
//									//logger.info(" checkStr : {}",checkStr);
										if("Distillation".equalsIgnoreCase(checkStr)){
											if("".equals(disStr)){
												disStr = "     "+ m.get("itemName").toString().substring(0, 12)+" : "+m.get("itemName").toString().substring(13);
												mapData.put("LABEL_TEST_ITEM_".concat(index.toString()),disStr);
											}else{

												mapData.put("LABEL_TEST_ITEM_".concat(index.toString()),"                        "+ m.get("itemName").toString().substring(12));
											}
										}else{
											
											mapData.put("LABEL_TEST_ITEM_".concat(index.toString()),"     "+ m.get("itemName").toString());
										}
									}else{

										mapData.put("LABEL_TEST_ITEM_".concat(index.toString()),"     "+ m.get("itemName").toString());
									}
									String zItemUint = m.get("itemUnit") ==null ?"-": m.get("itemUnit").toString();
									mapData.put("V_UNIT_".concat(index.toString()),zItemUint );
//									if(zItemUint.equals("C")) {
//										mapData.put("V_UNIT_".concat(index.toString()),"°".concat(zItemUint));
//									}else {
//										mapData.put("V_UNIT_".concat(index.toString()),zItemUint );
//									}
									
									mapData.put("V_METHOD_".concat(index.toString()), m.get("methodName").toString());

									mapData.put("V_SPECS_".concat(index.toString()), m.get("specItemBacisText").toString());
								
									mapData.put("V_UNCERT".concat(index.toString()),  m.get("RESULT_UN").toString());
		

									mapData.put("V_FLG_U_".concat(index.toString()),  m.get("UNCERT").toString());
									
								
									if(productCode.isEmpty()&&m.get("prductId")!=null) {
										productCode= m.get("prductId").toString();
									}
									if(productSub.isEmpty()&&m.get("sub_type_code")!=null) {
										productSub = m.get("sub_type_code").toString();
									}

									
									if("Y".equals(m.get("specRang").toString())){
										checkDataResultLTR(m,index,mapData,"");
									}else{
										checkDataResultLTR(m,index,mapData,"");
									}




									index++;
								}
							}
						}
					}
					
					//add paramer prod
					mapData.put("PRODUCT_CODE", productCode);
					mapData.put("PRODUCT_SUB", productSub);
		
					productCode="";
					productSub="";
					
					if(checkResult){
						mapData.put("P_RESULT_TEST", "ผ่าน");
						//mapData.put("P_RESULT_TEST", "ผ่านการตรวจสอบ");
						//mapData.put("NON_PASS", "    ");
					}else{
						mapData.put("P_RESULT_TEST", "ไม่ผ่าน");
						//mapData.put("P_RESULT_TEST", "ไม่ผ่านการตรวจสอบ");
						//mapData.put("NON_PASS", "หมายเหตุ ; เครื่องหมาย * หมายถึง รายการวิเคราะห์ที่ไม่เป็นไปตามข้อกำหนด");
					}

					listData.add(mapData);
				}
						
				
			}

			//logger.info("listData :{}",listData.size());
			logger.info("result list :{}",listData);
			return listData;
		}catch (Exception e){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}

	}
	private boolean checkConditionReport(Map<String, Object> dataHeader) {
		boolean result =false;
		if("00002".equals(dataHeader.get("SAMPLE_TYPE")!=null?dataHeader.get("SAMPLE_TYPE").toString():"-")
				||"00009".equals(dataHeader.get("SAMPLE_TYPE")!=null?dataHeader.get("SAMPLE_TYPE").toString():"-")
				||"00008".equals(dataHeader.get("SAMPLE_TYPE")!=null?dataHeader.get("SAMPLE_TYPE").toString():"-")
				||"00003".equals(dataHeader.get("SAMPLE_TYPE")!=null?dataHeader.get("SAMPLE_TYPE").toString():"-")
				||("00001".equals(dataHeader.get("SAMPLE_TYPE")!=null?dataHeader.get("SAMPLE_TYPE").toString():"-")&&"100000041".equals(dataHeader.get("PRODUCT_ID")!=null?dataHeader.get("PRODUCT_ID").toString():"-"))
				||("00004".equals(dataHeader.get("SAMPLE_TYPE")!=null?dataHeader.get("SAMPLE_TYPE").toString():"-")&&"100000001".equals(dataHeader.get("PRODUCT_ID")!=null?dataHeader.get("PRODUCT_ID").toString():"-"))
				||("00004".equals(dataHeader.get("SAMPLE_TYPE")!=null?dataHeader.get("SAMPLE_TYPE").toString():"-")&&"100000041".equals(dataHeader.get("PRODUCT_ID")!=null?dataHeader.get("PRODUCT_ID").toString():"-"))
				||("00004".equals(dataHeader.get("SAMPLE_TYPE")!=null?dataHeader.get("SAMPLE_TYPE").toString():"-")&&"005".equals(dataHeader.get("SUB_TYPE_CODE")!=null?dataHeader.get("SUB_TYPE_CODE").toString():"-"))
				) {
			result = true;
		}
		return result;
	}
	public void checkDataResultLTR(Map<String,Object> m,Integer index,Map<String,Object> mapData,String str) {
		if("0001".equals(m.get("itemsId").toString())){
			mapData.put("V_TEST_RESULT_".concat(index.toString()),  m.get("resultText")==null?"-":m.get("resultText").toString().concat(str));
		}
		else if("0002".equals(m.get("itemsId").toString())){
			mapData.put("V_TEST_RESULT_".concat(index.toString()),  m.get("resultText")==null?"-":m.get("resultText").toString().concat(str));
		}
		else if("0003".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				if(!m.get("resultText").toString().contains("L")){
					String resultNum = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultNum.toString().concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), m.get("resultText").toString().toString().concat(str));

				}
//		String resultNum = String.format("%.1f", Double.parseDouble(m.get("resultNum").toString() ==null ? "" : m.get("resultNum").toString()));
			}

		}
		else if("0004".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultNum = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				if(!"0.0".equalsIgnoreCase(resultNum)){
					String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultNum.toString().concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}

			}
		}
		else if("0005".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				if(!"0.0".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.toString().concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}
			}
		}
		else if("0006".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				if(!"0.0".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.toString().concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}
			}
		}
		else if("0007".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				if(!"0.0".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.toString().concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}
			}
		}
		else if("0008".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				if(!"0.0".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.toString().concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}
			}
		}
		else if("0009".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				if(!"0.0".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.toString().concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}
			}
		}
		else if("0010".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{  
			    if(("100000001".equals(m.get("prductId").toString())||"100000006".equals(m.get("prductId").toString())||"100000007".equals(m.get("prductId").toString())||"100000009".equals(m.get("prductId").toString()))
			   	
			    		) {
			    	
			    	
			    	if(Double.parseDouble(m.get("resultText").toString())<10) {
			    		mapData.put("V_TEST_RESULT_".concat(index.toString()), "<10.0".concat(str));
			    	}else if(Double.parseDouble(m.get("resultText").toString())<40){
			    		mapData.put("V_TEST_RESULT_".concat(index.toString()), "<40.0".concat(str));
			    	}else {
			    		//if("00002".equals(m.get("sampleType").toString())||"00004".equals(m.get("sampleType").toString())   ){
			    		String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
			    		mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.toString().concat(str));
			    	}
			    	
			    }else {
				boolean chk = m.get("resultText").toString().contains(">");
				if(!chk){
					String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
					if(!"0.0".equalsIgnoreCase(resultText)){
						mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.toString().concat(str));
					}else{
						mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
					}
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), m.get("resultText").toString().toString().concat(str));
				}
			    }
			}
		}
		else if("0011".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				if(!"0.0".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.toString().concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}
			}
		}
		else if("0012".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.4f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				if(!"0.0000".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.toString().concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}
			}
		}
		else if("0013".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.3f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				if(!"0.000".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.toString().concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}

			}
		}
		else if("0014".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				if(!"0".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.toString().concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}
			}

		}
		else if("0015".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
//		double val = Double.parseDouble(m.get("resultText").toString());
//		int intVal = (int) Math.floor(val);
//		String resultText = String.valueOf(intVal);
				mapData.put("V_TEST_RESULT_".concat(index.toString()), m.get("resultText").toString().toString().concat(str));
			}
		}
		else if("0016".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				double val = Double.parseDouble(m.get("resultText").toString());
				int intVal = (int) Math.floor(val);
				String resultText = String.valueOf(intVal);
				mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.toString().concat(str));
			}
		}
		else if("0017".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.3f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				if(!"0.000".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.toString().concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}
			}
		}
		else if("0018".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = (m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()) ;
				if(!resultText.equalsIgnoreCase("7")||resultText.equalsIgnoreCase("7")&&m.get("prductId").toString().equals("100000009")) {
					resultText = String.format("%.1f", Double.parseDouble(resultText));
				}
				//if(!"0.0".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.toString().concat(str));
				//}else{
				//	mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				//}
			}
		}
		else if("0019".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				if(!"0.0".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.toString().concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}
			}
		}
		else if("0020".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{

				mapData.put("V_TEST_RESULT_".concat(index.toString()), m.get("resultText").toString().toString().concat(str));
			}
		}
		else if("0021".equals(m.get("itemsId").toString())){
			String resultText = (m.get("resultText") ==null ? "-" : m.get("resultText").toString());
			if("-".equals(resultText)){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				if(m.get("methodID").toString().equals("0018"))
				{ 
					double val = Double.parseDouble(resultText); 
					int intVal = (int) Math.floor(val); 
					String stringVal = String.valueOf(intVal);
					mapData.put("V_TEST_RESULT_".concat(index.toString()), stringVal.concat(str)); 
					
				}else{ 
					double val = Double.parseDouble(resultText);
					mapData.put("V_TEST_RESULT_".concat(index.toString()), String.format("%.1f", val).toString().concat(str));
				}
				 

			}
		}
		else if("0022".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{

				boolean chk = m.get("resultText").toString().contains(">");
				if(!chk){
					double val = Double.parseDouble(m.get("resultText").toString().toString().concat(str));
					int intVal = (int) Math.floor(val);
					String resultText = String.valueOf(intVal);
					if(!"0".equalsIgnoreCase(resultText)){
						mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.toString().concat(str));
					}else{
						mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
					}
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), m.get("resultText").toString().toString().concat(str));
				}

			}
		}
		else if("0023".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				double val = Double.parseDouble(m.get("resultText").toString().toString().concat(str));
				int intVal = (int) Math.floor(val);
				String resultText = String.valueOf(intVal);
				if(!"0".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.toString().concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}
			}
		}
	}
	public List<Map<String,Object>> getDataReportLTR(String startDate, String endDate, String []productType, String []sampleTypeCode,String plantID,String typeReportSearch,String result) {
		List<Map<String,Object>>  resultList = new ArrayList<Map<String,Object>>();
		SimpleDateFormat sf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");
		
		StringBuffer sql = new StringBuffer();
		try{
			startDate=sf2.format(sf1.parse(startDate));
			endDate=sf2.format(sf1.parse(endDate));
			String productTypeStr = "";
			String sampleTypeCodeStr = "";
			for(String s : productType){
				if("".equals(productTypeStr)){
					productTypeStr = "'"+s+"'";
				}else{
					productTypeStr+=","+"'"+s+"'";
				}
			}

			for(String s : sampleTypeCode){
				if("".equals(sampleTypeCodeStr)){
					sampleTypeCodeStr = "'"+s+"'";
				}else{
					sampleTypeCodeStr+=","+"'"+s+"'";
				}
			}

			sql.append(" select distinct ran.SUB_TYPE_CODE,hd.LAB_CODE,sm.SAMPLE_TYPE_NAME,convert(varchar, dts.CREATE_DATE, 103) as 'CREATE_DATE',dts.ASSIGN_BY,pm.PRODUCT_NAME,sst.SAMPLE_TYPE_CODE,pm.PRODUCT_ID,concat(SUBSTRING(hd.LTR_CODE, 4, 7),'/',SUBSTRING(hd.LTR_CODE, 1, 2)) as REPORT_NO,p.PLANT_NAME \n");
			sql.append(" from ASS_LTR_DT_SUB dts \n");
			sql.append(" inner join ASS_LTR_DT dt on dt.LTR_DT_ID = dts.LTR_DT_ID \n");
			sql.append(" inner join ASS_LTR_HD hd on hd.LTR_CODE = dt.LTR_CODE \n");
			sql.append(" inner join MASTER_SAMPLE_TYPE sm on sm.SAMPLE_TYPE_CODE = dt.SAMPLE_TYPE_CODE \n");
			sql.append(" inner join PRODUCT_MAINLAB pm on pm.PRODUCT_ID = dt.PRODUCT_ID \n");
			sql.append(" inner join MASTER_SAMPLE_TYPE sst on sst.SAMPLE_TYPE_CODE = sm.SAMPLE_TYPE_CODE \n");
			sql.append(" inner join RANDOM_SAMPLE_RESULT ran on ran.LAB_CODE = hd.LAB_CODE \n");
			sql.append(" inner join PLANT p on ran .PLANT_ID = p.PLANT_ID \n");
			sql.append(" inner join ASS_WF_LTR awl on awl.LTR_CODE =dt.LTR_CODE  \n");
			sql.append(" where 1=1 and hd.UPDATE_DATE BETWEEN '"+startDate+" 00:00:00' and '"+endDate+" 23:59:59'  \n");
			sql.append(" and awl.STATUS = '08' \n");

			if(result!=null && !result.isEmpty()) {
				sql.append(" and hd.RESULT_LTR in ("+result+") \n");
			}
			
			if(plantID.isEmpty()) {
			}else {
				sql.append(" and p.CENTER_CODE = (select CENTER_CODE from PLANT where PLANT_ID ='"+plantID+"') \n");
			}
			//logger.info("productType :{}",productType);
			//logger.info("sampleTypeCode :{}",sampleTypeCode);
			if(!"'ALL'".equals(productTypeStr.trim())){
				sql.append(" and dt.PRODUCT_ID in ("+productTypeStr+") \n");
			}
			if(!"'ALL'".equals(sampleTypeCodeStr.trim())){
				sql.append(" and dt.SAMPLE_TYPE_CODE in ("+sampleTypeCodeStr+") \n");
			}
			
			logger.info("SQL Data Report : {}",sql.toString());

			List<Map<String,Object>> list = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			////logger.info("list : {}",list.size());
			Map<String,Object> obj = new HashMap<String,Object>();
			String labCode ="";
			String sampleTypeName ="";
			String createDate = "";
			String createBy = "";
			String productName = "";
			String sampleCode = "";
			String productId = "";
			String subTypeCode = "";
			String reportNo="";
			String plantName="";
			for(Map<String,Object> map : list){
				obj = new HashMap<>();
				labCode = map.get("LAB_CODE") == null ? "" :  map.get("LAB_CODE").toString();
				sampleTypeName = map.get("SAMPLE_TYPE_NAME") == null ? "" :  map.get("SAMPLE_TYPE_NAME").toString();
				createDate =  map.get("CREATE_DATE") ==null ?"" : map.get("CREATE_DATE").toString();
				createBy =  map.get("ASSIGN_BY") ==null ?"" : map.get("ASSIGN_BY").toString();
				productName =  map.get("PRODUCT_NAME") ==null ? "" : map.get("PRODUCT_NAME").toString();
				sampleCode =  map.get("SAMPLE_TYPE_CODE") ==null ? "" : map.get("SAMPLE_TYPE_CODE").toString();
				productId =  map.get("PRODUCT_ID") ==null ? "" : map.get("PRODUCT_ID").toString();
				subTypeCode = map.get("SUB_TYPE_CODE") ==null ? "" : map.get("SUB_TYPE_CODE").toString();
				reportNo= map.get("REPORT_NO") ==null ? "" : map.get("REPORT_NO").toString();
				plantName= map.get("PLANT_NAME") ==null ? "" : map.get("PLANT_NAME").toString();
				obj.put("labCode", labCode);
				obj.put("sampleTypeName", sampleTypeName);
				obj.put("createDate", createDate);
				obj.put("createBy", createBy);
				obj.put("productName", productName);
				obj.put("sampleCode", sampleCode);
				obj.put("productId", productId);
				obj.put("reportNo", reportNo);
				obj.put("plantName", plantName);
				//ตัวอย่าง T ประเภท ประจำเดือนและประจำสัปดาห์
				//System.out.println(sampleCode+"|"+subTypeCode);
				//typeReportSearch 1=LTR,2=COQ
				if(sampleCode.equals("00004") && typeReportSearch.equals("2")) {
					if(subTypeCode.equals("003") || subTypeCode.equals("004")) {
						resultList.add(obj);
					}
				}else if(sampleCode.equals("00004") && typeReportSearch.equals("1")) {
					if(subTypeCode.equals("003") || subTypeCode.equals("004") ) {
						if( productId.equals("100000006") || productId.equals("100000007") || 
								productId.equals("100000009") || productId.equals("100000001")) {
							
						}else {
							resultList.add(obj);
						}
					}else {
						resultList.add(obj);
					}
				}else {
					resultList.add(obj);
				}
			}
			return resultList;
		}catch(Exception e){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}

	public String getSampleTyepCodeAndProductType(String[] labCode) {
		List<Map<String,Object>>  resultList = new ArrayList<Map<String,Object>>();
		StringBuffer sql = new StringBuffer();
		try{
			String str = "";
			for(String s : labCode){
				if("".equals(str)){
					str = "'"+s+"'";
				}else{
					str+=","+"'"+s+"'";
				}
			}

			sql.append(" select distinct hd.LAB_CODE,sm.SAMPLE_TYPE_NAME,convert(varchar, dts.CREATE_DATE, 103) as 'CREATE_DATE',dts.ASSIGN_BY,pm.PRODUCT_NAME,dt.PRODUCT_ID,dt.SAMPLE_TYPE_CODE \n");
			sql.append(" from ASS_LTR_DT_SUB dts \n");
			sql.append(" inner join ASS_LTR_DT dt on dt.LTR_DT_ID = dts.LTR_DT_ID \n");
			sql.append(" inner join ASS_LTR_HD hd on hd.LTR_CODE = dt.LTR_CODE \n");
			sql.append(" inner join MASTER_SAMPLE_TYPE sm on sm.SAMPLE_TYPE_CODE = dt.SAMPLE_TYPE_CODE \n");
			sql.append(" inner join PRODUCT_MAINLAB pm on pm.PRODUCT_ID = dt.PRODUCT_ID \n");
			sql.append(" where 1=1 \n");
			sql.append(" and hd.STATUS = '08' \n");
//   		sql.append(" and dt.PRODUCT_ID in ('100000006') \n");
			sql.append("  and hd.LAB_CODE in ("+str+") \n");
//   		sql.append("  and hd.LAB_CODE in ('06-0-3-0021H-0-20-00001') \n");
//	    //logger.info("SQL : {}",sql.toString());

			List<Map<String,Object>> list = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			//logger.info("list : {}",list.size());
			Map<String,Object> obj = new HashMap<String,Object>();

			String sampleTypeCode ="";
			String productId = "";
			int i =0;
			Integer a =1;
			String params ="";

			for(Map<String,Object> map : list){
				sampleTypeCode = map.get("SAMPLE_TYPE_CODE")==null ? "": map.get("SAMPLE_TYPE_CODE").toString();
				productId = map.get("PRODUCT_ID")==null ? "": map.get("PRODUCT_ID").toString();
				if("".equals(params)){
					params += a+"|"+labCode[i]+"|"+sampleTypeCode+"|"+productId+"";
//				  params += a+"|"+"06-0-3-0021H-0-20-00001"+"|"+"00003"+"|"+"100000006"+"";
				}else{
					params+=","+a+"|"+(labCode.length==1?labCode[0]:labCode[i])+"|"+sampleTypeCode+"|"+productId+"";
//				  params+=","+a+"|"+"06-0-3-0021H-0-20-00001"+"|"+"00003"+"|"+"100000006"+"";
				}
				i++;
				a++;


			}

			//logger.info("params : {}",params);
			return params;
		}catch(Exception e){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}

	public List<Map<String,Object>> getDataForLTRReportHeader(String producId){
		List<Map<String,Object>>resultList = new ArrayList<>();
		try{
			StringBuilder sql = new StringBuilder();
//			sql.append("  SELECT ITEM_NAME,ITEM_ID FROM ASS_ITEM_MASTER \n ");
			sql.append(" select distinct ia.ITEM_NAME,ia.ITEM_ID \n ");

			sql.append(" from ASS_LTR_DT dt with (nolock) \n ");
			sql.append(" inner join ASS_LTR_HD hd with (nolock) on hd.LTR_CODE = dt.LTR_CODE \n ");
			sql.append(" inner join ASS_LTR_DT_USER dtu with (nolock) on dtu.LTR_DT_ID = dt.LTR_DT_ID \n ");
			sql.append(" inner join ASS_METHOD_MASTER ma with (nolock) on ma.METHOD_ID = dt.METHOD_ID \n ");
			sql.append(" inner join ASS_TOOL_MASTER ta with (nolock) on ta.TOOL_ID = dt.TOOL_ID \n ");
			sql.append(" inner join ASS_ITEM_MASTER ia with (nolock) on ia.ITEM_ID = dt.ITEM_ID \n ");
			sql.append(" inner join PRODUCT_MAINLAB p with (nolock) on p.PRODUCT_ID = dt.PRODUCT_ID \n ");
			sql.append(" inner join USER_TYPE ut with (nolock) on ut.USER_TYPE_ID = dtu.USER_TYPE_ID \n ");
			sql.append(" inner join ASS_ITEM_SPEC_MP_SPDETAIL spd with (nolock) on spd.ITEMMP_ID = dt.ITEMMP_ID \n ");
			sql.append(" inner join ASS_LTR_DT_SUB ds with (nolock) on ds.LTR_DT_ID = dt.LTR_DT_ID \n ");
			sql.append(" where ds.SAVE_FLAG = 'Y' \n ");
			sql.append("  AND dt.PRODUCT_ID ='"+producId+"'\n ");
			sql.append(" order by ia.ITEM_ID \n ");

			//logger.info(" sql getDataForLTRReportHeader : :{}",sql.toString());
			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			//logger.info("getDataForLTRReportHeader resultList : {}",resultList.size());
			return resultList;
		}catch (Exception e){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}
	public List<Map<String,Object>> getDataForLTRReportHeaderExcel(String[] labCode){
		List<Map<String,Object>>resultList = new ArrayList<>();
		try{
			StringBuilder sql = new StringBuilder();
			String str = "";
			for(String s : labCode) {
				if ("".equals(str)) {
					str = "'" + s + "'";
				} else {
					str += "," + "'" + s + "'";
				}
			}
//			sql.append("  SELECT ITEM_NAME,ITEM_ID FROM ASS_ITEM_MASTER \n ");
			sql.append(" select distinct  p.PRODUCT_ID,(case when p.PRODUCT_ID = '100000001' or p.PRODUCT_ID = '100000006' \r\n" + 
					"					 or p.PRODUCT_ID = '100000007' or p.PRODUCT_ID = '100000009' then \r\n" + 
					"					 (case when ia.ITEM_ID = '0005' then 'Distillation 10% recov.'\r\n" + 
					"					 when ia.ITEM_ID = '0006' then 'Distillation 50% recov.'\r\n" + 
					"					 when ia.ITEM_ID = '0007' then 'Distillation 90% recov.' else ia.ITEM_NAME end) \r\n" + 
					"					 else  ia.ITEM_NAME end) as ITEM_NAME,ia.ITEM_ID  \n ");
			sql.append(" from ASS_LTR_DT dt with (nolock) \n ");
			sql.append(" inner join ASS_LTR_HD hd with (nolock) on hd.LTR_CODE = dt.LTR_CODE \n ");
			sql.append(" inner join ASS_LTR_DT_USER dtu with (nolock) on dtu.LTR_DT_ID = dt.LTR_DT_ID \n ");
			sql.append(" inner join ASS_METHOD_MASTER ma with (nolock) on ma.METHOD_ID = dt.METHOD_ID \n ");
			sql.append(" inner join ASS_TOOL_MASTER ta with (nolock) on ta.TOOL_ID = dt.TOOL_ID \n ");
			sql.append(" inner join ASS_ITEM_MASTER ia with (nolock) on ia.ITEM_ID = dt.ITEM_ID \n ");
			sql.append(" inner join PRODUCT_MAINLAB p with (nolock) on p.PRODUCT_ID = dt.PRODUCT_ID \n ");
			sql.append(" inner join USER_TYPE ut with (nolock) on ut.USER_TYPE_ID = dtu.USER_TYPE_ID \n ");
			sql.append(" inner join ASS_ITEM_SPEC_MP_SPDETAIL spd with (nolock) on spd.ITEMMP_ID = dt.ITEMMP_ID \n ");
			sql.append(" inner join ASS_LTR_DT_SUB ds with (nolock) on ds.LTR_DT_ID = dt.LTR_DT_ID \n ");
			sql.append(" where ds.SAVE_FLAG = 'Y' \n ");
			sql.append("  AND  hd.LAB_CODE in( "+str+" )\n ");
			sql.append(" order by ia.ITEM_ID \n ");

			//logger.info(" sql getDataForLTRReportHeader : :{}",sql.toString());
			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			//logger.info("getDataForLTRReportHeader resultList : {}",resultList.size());
			return resultList;
		}catch (Exception e){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public List<Map<String,Object>> getDataForLTRReportHeaderExcelForTool(String[] labCode){
		List<Map<String,Object>>resultList = new ArrayList<>();
		try{
			StringBuilder sql = new StringBuilder();
			String str = "";
			for(String s : labCode) {
				if ("".equals(str)) {
					str = "'" + s + "'";
				} else {
					str += "," + "'" + s + "'";
				}
			}
//			sql.append("  SELECT ITEM_NAME,ITEM_ID FROM ASS_ITEM_MASTER \n ");
			sql.append(" select distinct  p.PRODUCT_ID,(case when p.PRODUCT_ID = '100000001' or p.PRODUCT_ID = '100000006' \r\n" + 
					"					 or p.PRODUCT_ID = '100000007' or p.PRODUCT_ID = '100000009' then \r\n" + 
					"					 (case when ia.ITEM_ID = '0005' then 'Distillation 10% recov.'\r\n" + 
					"					 when ia.ITEM_ID = '0006' then 'Distillation 50% recov.'\r\n" + 
					"					 when ia.ITEM_ID = '0007' then 'Distillation 90% recov.' else ia.ITEM_NAME end) \r\n" + 
					"					 else  ia.ITEM_NAME end) as ITEM_NAME,ia.ITEM_ID  \n ");
			sql.append(" from ASS_LTR_DT dt with (nolock) \n ");
			sql.append(" inner join ASS_LTR_HD hd with (nolock) on hd.LTR_CODE = dt.LTR_CODE \n ");
			sql.append(" inner join ASS_LTR_DT_USER dtu with (nolock) on dtu.LTR_DT_ID = dt.LTR_DT_ID \n ");
			sql.append(" inner join ASS_METHOD_MASTER ma with (nolock) on ma.METHOD_ID = dt.METHOD_ID \n ");
			sql.append(" inner join ASS_TOOL_MASTER ta with (nolock) on ta.TOOL_ID = dt.TOOL_ID \n ");
			sql.append(" inner join ASS_ITEM_MASTER ia with (nolock) on ia.ITEM_ID = dt.ITEM_ID \n ");
			sql.append(" inner join PRODUCT_MAINLAB p with (nolock) on p.PRODUCT_ID = dt.PRODUCT_ID \n ");
			sql.append(" inner join USER_TYPE ut with (nolock) on ut.USER_TYPE_ID = dtu.USER_TYPE_ID \n ");
			sql.append(" inner join ASS_ITEM_SPEC_MP_SPDETAIL spd with (nolock) on spd.ITEMMP_ID = dt.ITEMMP_ID \n ");
			sql.append(" inner join ASS_LTR_DT_SUB ds with (nolock) on ds.LTR_DT_ID = dt.LTR_DT_ID \n ");
			sql.append(" where ds.SAVE_FLAG = 'Y'  \n ");
			sql.append("  AND  hd.LAB_CODE in( "+str+" )\n ");
			sql.append(" order by ia.ITEM_ID \n ");

			//logger.info(" sql getDataForLTRReportHeader : :{}",sql.toString());
			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			//logger.info("getDataForLTRReportHeader resultList : {}",resultList.size());
			return resultList;
		}catch (Exception e){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}
	public List<Map<String,Object>> getProductNameForLTRReportHeader(String[] labCode){
		List<Map<String,Object>>resultList = new ArrayList<>();
		try{
			StringBuilder sql = new StringBuilder();

			String str = "";
			for(String s : labCode){
				if("".equals(str)){
					str = "'"+s+"'";
				}else{
					str+=","+"'"+s+"'";
				}
			}

			sql.append("  select distinct pm.PRODUCT_NAME,ran.PRODUCT_ID from RANDOM_SAMPLE_RESULT ran \n");
			sql.append(" inner join PRODUCT_MAINLAB pm on pm.PRODUCT_ID = ran.PRODUCT_ID \n");
			sql.append(" where ran.LAB_CODE in ("+str+") \n");

//			//logger.info(" sql : :{}",sql.toString());
			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());

			//logger.info("getProductNameForLTRReportHeader resultList : {}",resultList.size());
			return resultList;
		}catch (Exception e){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}

	public List<Map<String,Object>> getDataDetailInLabCode(String[] labCode){
		List<Map<String,Object>>resultList = new ArrayList<>();
		try{
			StringBuilder sql = new StringBuilder();

			String str = "";
			for(String s : labCode) {
				if ("".equals(str)) {
					str = "'" + s + "'";
				} else {
					str += "," + "'" + s + "'";
				}
			}
			sql.append(" select ma.METHOD_ID,ran.SAMPLE_TYPEC_DESC,hd.LAB_CODE,ia.ITEM_NAME \n");
			sql.append(" ,(case when mp.STATUS = 'N' then '-' else (case when ds.RESULT_TEXT = '' then convert(varchar(30),ds.RESULT_NUM) else ds.RESULT_TEXT end) end) as RESULT_TEST \n");
			sql.append(" ,dt.PRODUCT_ID,p.PRODUCT_NAME,dtu.USER_TYPE_ID,ut.USER_TYPE_DTL,hd.LTR_CODE,(case when ds.RESULT_FLAG = 'Y' then 'ผ่าน' else 'ไม่ผ่าน' end) AS RESULT_FLAG,usr.NAMET as APPROVE_BY,ds.RESULT_FLAG  as STATUS_FLAG,ia.ITEM_ID \n");
			sql.append(" ,case when ds.RESULT_TEXT ='-' then 'X' when (ia.ITEM_ID='0001' or ia.ITEM_ID='0002' ) then '-'  else ta.TOOL_NAME end  as TOOL_NAME from ASS_LTR_DT dt with (nolock) \n");
			sql.append(" inner join ASS_LTR_HD hd with (nolock) on hd.LTR_CODE = dt.LTR_CODE \n");
			sql.append(" inner join ASS_LTR_DT_USER dtu with (nolock) on dtu.LTR_DT_ID = dt.LTR_DT_ID \n");
			sql.append(" inner join ASS_METHOD_MASTER ma with (nolock) on ma.METHOD_ID = dt.METHOD_ID \n");
			sql.append(" inner join ASS_TOOL_MASTER ta with (nolock) on ta.TOOL_ID = dt.TOOL_ID \n");
			sql.append(" inner join ASS_ITEM_MASTER ia with (nolock) on ia.ITEM_ID = dt.ITEM_ID \n");
			sql.append(" inner join PRODUCT_MAINLAB p with (nolock) on p.PRODUCT_ID = dt.PRODUCT_ID \n");
			sql.append(" inner join USER_TYPE ut with (nolock) on ut.USER_TYPE_ID = dtu.USER_TYPE_ID \n");
			sql.append(" inner join ASS_ITEM_SPEC_MP_SPDETAIL spd with (nolock) on spd.ITEMMP_ID = dt.ITEMMP_ID \n");
			sql.append(" inner join ASS_LTR_DT_SUB ds with (nolock) on ds.LTR_DT_ID = dt.LTR_DT_ID \n");
			sql.append(" inner join ASS_WF_LTR wf with (nolock) on wf.LTR_CODE = hd.LTR_CODE \n");
			sql.append(" inner join MP_USER usr with (nolock) on usr.CODEMP_ID = wf.APPROVE_BY \n");
			sql.append(" inner join ASS_ITEM_SPEC_MP mp with (nolock) on mp.ITEMMP_ID = dt.ITEMMP_ID \n");
			sql.append(" inner join RANDOM_SAMPLE_RESULT ran with (nolock) on ran.LAB_CODE = hd.LAB_CODE \n");

			sql.append(" where hd.LAB_CODE in( "+str+" )\n");
			//sql.append(" and ds.SAVE_FLAG = 'Y' \n");
			sql.append(" and wf.END_WF = 'Y' and hd.STATUS = '08' \n");
			sql.append(" order by hd.LAB_CODE,ia.ITEM_ID \n");
			//logger.info(" Print Result SQL : {} resultList : {}",sql.toString());
			//logger.info(" sql : :{}",sql.toString());
			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());

			//logger.info(" getProductNameForLTRReportHeader resultList : {}",resultList.size());
			return resultList;
		}catch (Exception e){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}


	public List<Map<String,Object>> getDataInfoByLabCode(String [] labCode){
		try{
			List<Map<String,Object>>resultList = new ArrayList<>();
			String str = "";
			for(String s : labCode) {
				if ("".equals(str)) {
					str = "'" + s + "'";
				} else {
					str += "," + "'" + s + "'";
				}
			}
			//logger.info("labCode : {}",str);
			StringBuilder sql = new StringBuilder();
			sql.append(" select distinct ran.MANUAL_TYPE,ran.METER_NO,ran.BOAT_NAME,ran.CAR_SLOT,p.PLANT_NAME,pro.PRODUCT_NAME,pro.PRODUCT_ID \n");
			sql.append(" ,convert(varchar, ran.PRINT_STICKER_DATE, 103)as RAN_STICKER_DATE,isnull(loca.LOC_NAME,'-') as LOC_NAME \n");
			sql.append(" , convert(varchar, ran.UPDATE_DATE , 103) as DTS_CREATE_DATE \n");
			sql.append(" ,ran.SEND_REQT_ID,ran.LAB_CODE,(case when ran.MANUAL_TYPE='Y' then convert(varchar, ran.SAMPLE_DATE , 103) else  convert(varchar, ran.PRINT_STICKER_DATE , 103) end) as RAN_CREATE_DATE_SAMPLE \n");
			sql.append(" ,convert(varchar, ran.UPDATE_DATE, 103)as RAN_CREATE_DATE,convert(varchar, hd.CREATE_DATE, 103) as REPORT_DATE_LTR \n");
			sql.append(" ,s.SOURCE_NAME,lb.LOGIS_NAME,l.LOGIS_NAME,ran.SAMPLE_TYPEC_DESC,ran.TANK_NO,pro.PRODUCT_CODE,pro.PRODUCT_NAME,ran.SAMPLE_POINT_DESC,ran.ADTV_LOT_NO,ran.RETURNR_DESC,ran.BOAT_NO \n");
			sql.append(" ,ran.SAMPLE_TYPE,ran.CAR_NO,ran.PO_NO,concat(SUBSTRING(hd.LTR_CODE, 4, 7),'/',SUBSTRING(hd.LTR_CODE, 1, 2)) as report_no ");
			sql.append(" from ASS_LTR_DT_SUB dts \n");
			sql.append(" inner join ASS_LTR_DT dt on dt.LTR_DT_ID = dts.LTR_DT_ID \n");
			sql.append(" inner join ASS_LTR_HD hd on hd.LTR_CODE = dt.LTR_CODE \n");
			sql.append(" inner join RANDOM_SAMPLE_RESULT ran on ran.LAB_CODE = hd.LAB_CODE \n");
			sql.append(" inner join PLANT p on p.PLANT_ID = ran.PLANT_ID \n");
			sql.append(" inner join PRODUCT_MAINLAB pro on pro.PRODUCT_ID = ran.PRODUCT_ID \n");
			sql.append(" left join LOCATION_PRODUCT_R loca on loca.LOC_ID = ran.LOC_ID \n");
			sql.append(" left join SOURCE s on s.SOURCE_ID = ran.SOURCE_ID \n");
			sql.append(" left join LOGISTICS_BOAT lb on lb.LOGIS_ID = ran.LOGIS_ID \n");
			sql.append(" left join LOGISTICS l on l.LOGIS_ID = ran.LOGIS_ID \n");
			sql.append(" where 1=1  \n");
			sql.append(" and hd.STATUS = '08'  \n");
			sql.append(" and hd.LAB_CODE in ("+str+") \n");
			//logger.info("getDataInfoByLabCode sql  : {}",sql.toString());
			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			//logger.info("getDataInfoByLabCode resultList : {}",resultList.size());
			return resultList;
		}catch (Exception e ){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}

	public List<Map<String,Object>>getProductNameByLabCode(String [] labCode){
		List<Map<String,Object>>resultList = new ArrayList<>();

		try{
			String str = "";
			for(String s : labCode) {
				if ("".equals(str)) {
					str = "'" + s + "'";
				} else {
					str += "," + "'" + s + "'";
				}
			}
			//logger.info("labCode : {}",str);
			StringBuilder sql = new StringBuilder();
			sql.append(" select  distinct hd.LAB_CODE,p.PRODUCT_NAME, p.PRODUCT_ID\n");
			sql.append(" from ASS_LTR_DT dt with (nolock)  \n");
			sql.append(" inner join ASS_LTR_HD hd with (nolock) on hd.LTR_CODE = dt.LTR_CODE  \n");
			sql.append(" inner join ASS_LTR_DT_USER dtu with (nolock) on dtu.LTR_DT_ID = dt.LTR_DT_ID \n ");
			sql.append(" inner join ASS_METHOD_MASTER ma with (nolock) on ma.METHOD_ID = dt.METHOD_ID \n ");
			sql.append(" inner join ASS_TOOL_MASTER ta with (nolock) on ta.TOOL_ID = dt.TOOL_ID \n ");
			sql.append(" inner join ASS_ITEM_MASTER ia with (nolock) on ia.ITEM_ID = dt.ITEM_ID \n ");
			sql.append(" inner join PRODUCT_MAINLAB p with (nolock) on p.PRODUCT_ID = dt.PRODUCT_ID \n ");
			sql.append(" inner join USER_TYPE ut with (nolock) on ut.USER_TYPE_ID = dtu.USER_TYPE_ID \n ");
			sql.append(" inner join ASS_ITEM_SPEC_MP_SPDETAIL spd with (nolock) on spd.ITEMMP_ID = dt.ITEMMP_ID \n ");
			sql.append(" inner join ASS_LTR_DT_SUB ds with (nolock) on ds.LTR_DT_ID = dt.LTR_DT_ID \n ");
			sql.append(" where hd.LAB_CODE in ("+str+") \n ");
			sql.append(" and ds.SAVE_FLAG = 'Y' \n ");
			sql.append(" order by p.PRODUCT_NAME \n ");
//			//logger.info("sql  : {}",sql.toString());
			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			//logger.info("getProductNameByLabCode resultList : {}",resultList.size());
			return resultList;
		}catch (Exception e){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}
	public List<Map<String,Object>>getProductNameByLabCodeSheet(String [] labCode){
		List<Map<String,Object>>resultList = new ArrayList<>();

		try{
			String str = "";
			for(String s : labCode) {
				if ("".equals(str)) {
					str = "'" + s + "'";
				} else {
					str += "," + "'" + s + "'";
				}
			}
			//logger.info("labCode : {}",str);
			StringBuilder sql = new StringBuilder();
			sql.append(" select  distinct p.PRODUCT_NAME, p.PRODUCT_ID\n");
			sql.append(" from ASS_LTR_DT dt with (nolock)  \n");
			sql.append(" inner join ASS_LTR_HD hd with (nolock) on hd.LTR_CODE = dt.LTR_CODE  \n");
			sql.append(" inner join ASS_LTR_DT_USER dtu with (nolock) on dtu.LTR_DT_ID = dt.LTR_DT_ID \n ");
			sql.append(" inner join ASS_METHOD_MASTER ma with (nolock) on ma.METHOD_ID = dt.METHOD_ID \n ");
			sql.append(" inner join ASS_TOOL_MASTER ta with (nolock) on ta.TOOL_ID = dt.TOOL_ID \n ");
			sql.append(" inner join ASS_ITEM_MASTER ia with (nolock) on ia.ITEM_ID = dt.ITEM_ID \n ");
			sql.append(" inner join PRODUCT_MAINLAB p with (nolock) on p.PRODUCT_ID = dt.PRODUCT_ID \n ");
			sql.append(" inner join USER_TYPE ut with (nolock) on ut.USER_TYPE_ID = dtu.USER_TYPE_ID \n ");
			sql.append(" inner join ASS_ITEM_SPEC_MP_SPDETAIL spd with (nolock) on spd.ITEMMP_ID = dt.ITEMMP_ID \n ");
			sql.append(" inner join ASS_LTR_DT_SUB ds with (nolock) on ds.LTR_DT_ID = dt.LTR_DT_ID \n ");
			sql.append(" where hd.LAB_CODE in ("+str+") \n ");
			sql.append(" and ds.SAVE_FLAG = 'Y' \n ");
			sql.append(" order by p.PRODUCT_NAME \n ");
//			//logger.info("sql  : {}",sql.toString());
			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			//logger.info("getProductNameByLabCode resultList : {}",resultList.size());
			return resultList;
		}catch (Exception e){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}
	//Report Addtive
	public List<Map<String,Object>> getDataReportAdditives(String[] labCode,String reportedBy){
		List<Map<String,Object>> resultList = new ArrayList<>();
		List<Map<String,Object>> data = new ArrayList<>();

		try{
			String str = "";
			for(String s : labCode) {
				if ("".equals(str)) {
					str = "'" + s + "'";
				} else {
					str += "," + "'" + s + "'";
				}
			}
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			String printDate= dateFormat.format(date);
			SimpleDateFormat DateFor = new SimpleDateFormat("YY");
			String stringDate= DateFor.format(date);

			StringBuilder sql = new StringBuilder();
			List<Map<String,Object>>dataTitle = getDataTitleAdditive(str);
			List<Map<String,Object>>dataHeaderTable = getDataAdditiveHeader(str);
			List<Map<String,Object>>dataAdditiveDetail = getDataAdditiveDetail(str);
			Map<String,Object>mapProduct = new HashMap<>();
			List<Map<String,Object>>mapProductList = new ArrayList<>();
			String strProduct = "";
			String strProduct2 = "";

			List<Map<String,Object>>dataHeader = new ArrayList<>();
			Map<String,Object>mapTitle =new HashMap<>();
			Integer sequent =1;
			Integer paraNum = 3;
			boolean chkNewProduct = true;
			String userA1  = getReportedRoleA1("user");
			String codempA1  = getReportedRoleA1("codemp");
			String userLabTeamLead = getReportedRoleLabTeamLead("");
			String codempLabTeamLead = getReportedRoleLabTeamLead("codemp");
			Map<String,Object>mapDataReport = new HashMap<>();
			for(Map<String,Object> m :dataTitle ){
				mapDataReport = new HashMap<>();
				mapDataReport.put("LTR_TO",m.get("PLANT_NAME") ==null ? "-":m.get("PLANT_NAME").toString());
				mapDataReport.put("LTR_CC", "IRPC");
				mapDataReport.put("LTR_PRODUCT", m.get("PRODUCT_CODE") ==null ? "-":m.get("PRODUCT_CODE").toString() );
				mapDataReport.put("LTR_DATE",m.get("RAN_CREATE_DATE") ==null ? "-":m.get("RAN_CREATE_DATE").toString() );
				mapDataReport.put("LTR_VESSEL", m.get("LOC_NAME") ==null ? "-":m.get("LOC_NAME").toString());
				mapDataReport.put("LTR_REF", m.get("SEND_REQT_ID") ==null ? "-":m.get("SEND_REQT_ID").toString());
				//LTR_DESC for LTR_C_CAR and LTR_C_CAR_BIO Only
				mapDataReport.put("LTR_DESC", m.get("SAMPLE_POINT_DESC") == null ?
						m.get("SAMPLE_TYPEC_DESC") == null ? "" : m.get("SAMPLE_TYPEC_DESC") :
							m.get("SAMPLE_POINT_DESC").toString());
				mapDataReport.put("LTR_DATE_EX", m.get("RAN_CREATE_DATE") ==null ? "-":m.get("RAN_CREATE_DATE").toString());
				mapDataReport.put("LTR_CODE_NO", m.get("LAB_CODE") ==null ? "-":m.get("LAB_CODE").toString());
				mapDataReport.put("LOT_NO", m.get("ADTV_LOT_NO") ==null ? "-":m.get("ADTV_LOT_NO").toString());
				mapDataReport.put("PO_NO", m.get("ADTV_PO_NO") ==null ? "-":m.get("ADTV_PO_NO").toString());
//				mapDataReport.put("V_APPROVE_BY", m.get("APPROVE_BY") ==null ? "-":m.get("APPROVE_BY").toString());
				mapDataReport.put("V_APPROVE_BY",userLabTeamLead);
				mapDataReport.put("V_APPROVE_BY_CODE",codempLabTeamLead);
				mapDataReport.put("V_APPROVE_DATE", m.get("APPROVE_DATE") ==null ? "-":m.get("APPROVE_DATE").toString());
//				mapData.put("V_REPORTED_BY", dataHeader.get("REPORTED_BY") ==null ? "-":dataHeader.get("REPORTED_BY").toString());
//				mapData.put("V_REPORTED_DATE", dataHeader.get("REPORTED_DATE") ==null ? "-":dataHeader.get("REPORTED_DATE").toString());
				mapDataReport.put("V_REPORTED_BY", userA1);
				mapDataReport.put("V_REPORTED_BY_CODE", codempA1);
				mapDataReport.put("V_REPORTED_DATE",printDate);
				mapDataReport.put("LTR_REPORT", m.get("report_no") ==null ? "-":m.get("report_no").toString());
				Integer indexHeader = 1;
				List<String> keysGetData = new ArrayList<>();
				for(Map<String,Object> mapHeader : dataHeaderTable){
					mapDataReport.put("HEADER_".concat(indexHeader.toString()), mapHeader.get("ITEM_NAME") ==null ? "-":mapHeader.get("ITEM_NAME").toString());
					keysGetData.add( mapHeader.get("ITEM_ID").toString());
					indexHeader++;
				}
				//logger.info("keysGetData : {} ",keysGetData);
				Integer indexDetail = 1;
				boolean checkResultLTR = true;
				float b_total = 0.00f;
				float c_total = 0.00f;
				float d_total = 0.00f;
//				for(Map<String,Object>mapDetail : dataAdditiveDetail){
//					//logger.info("LOC_ID 1 : {}",m.get("LOC_ID").toString());
//					//logger.info("LOC_ID 2 : {}",mapDetail.get("LOC_ID").toString());
//					//logger.info("PRODUCT_ID 1 : {}",m.get("PRODUCT_ID"	).toString());
//					//logger.info("PRODUCT_ID 2 : {}",mapDetail.get("PRODUCT_ID").toString());
//					if(m.get("LOC_ID").toString().equals(mapDetail.get("LOC_ID").toString())&&m.get("PRODUCT_ID").toString().equals(mapDetail.get("product_id").toString())){
//						if("Y".equals(mapDetail.get("RESULT_LTR").toString())&&checkResultLTR==true){
//							checkResultLTR =true;
//						}else{
//							checkResultLTR =false;
//						}
//						mapDataReport.put("PARAM_".concat(indexDetail.toString()), mapDetail.get("LAB_CODE") ==null ? "-":mapDetail.get("LAB_CODE").toString());
//						mapDataReport.put("A_PARAM_".concat(indexDetail.toString()), mapDetail.get("LOC_NAME") ==null ? "-":mapDetail.get("LOC_NAME").toString());
//						mapDataReport.put("B_PARAM_".concat(indexDetail.toString()), mapDetail.get(keysGetData.get(0)) ==null ? "-":mapDetail.get(keysGetData.get(0)).toString());
//						mapDataReport.put("C_PARAM_".concat(indexDetail.toString()), mapDetail.get(keysGetData.get(1)) ==null ? "-":mapDetail.get(keysGetData.get(1)).toString());
//						mapDataReport.put("D_PARAM_".concat(indexDetail.toString()), mapDetail.get(keysGetData.get(2)) ==null ? "-":mapDetail.get(keysGetData.get(2)).toString());
//						indexDetail++;
//						b_total += Float.parseFloat(mapDetail.get(keysGetData.get(0)) ==null ? "":mapDetail.get(keysGetData.get(0)).toString());
//						c_total += Float.parseFloat(mapDetail.get(keysGetData.get(1)) ==null ? "":mapDetail.get(keysGetData.get(1)).toString());
//						d_total += Float.parseFloat(mapDetail.get(keysGetData.get(2)) ==null ? "":mapDetail.get(keysGetData.get(2)).toString());
//					}
//				}
				if(checkResultLTR){
					mapDataReport.put("RESULT_TEST","ผ่านการตรวจสอบ");
				}else {
					mapDataReport.put("RESULT_TEST","ไม่ผ่านการตรวจสอบ");
				}
				mapDataReport.put("B_TOTAL",b_total);
				mapDataReport.put("C_TOTAL",c_total);
				mapDataReport.put("D_TOTAL",d_total);
				//logger.info("mapDataReport : {}",mapDataReport);
				resultList.add(mapDataReport);
			}

			//logger.info("resultList additive : {}",resultList.size());
			return  resultList;
		}catch (Exception e ){
			//logger.info("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}

	public List<Map<String,Object>>getDataTitle(String  labCode){
		List<Map<String,Object>>resultList =new ArrayList<>();
		try{
			StringBuilder sql = new StringBuilder();
			sql.append(" select distinct ran.METER_NO,concat(SUBSTRING(hd.LTR_CODE, 4, 7),'/',SUBSTRING(hd.LTR_CODE, 1, 2)) as report_no,p.PLANT_NAME,pro.PRODUCT_NAME,hd.LTR_CODE_REF,hd.REVISE_DESC \n");
			sql.append(	",concat(SUBSTRING(hd.LTR_CODE_REF, 4, 7),'/',SUBSTRING(hd.LTR_CODE_REF, 1, 2)) as report_no_ref \n");
			sql.append(" ,convert(varchar, ran.PRINT_STICKER_DATE, 103)as RAN_STICKER_DATE,isnull(loca.LOC_NAME,'-') as LOC_NAME \n");
			sql.append(" ,convert(varchar, ran.SAMPLE_DATE, 103)as SAMPLE_DATE \n");
			sql.append(" ,convert(varchar, ran.UPDATE_DATE , 103)as DTS_CREATE_DATE \n");
			sql.append(" ,ran.SEND_REQT_ID,ran.LAB_CODE,convert(varchar, hd.PRINT_LTR_DATE, 103) as rREPORTED_DATE,hd.PRINT_LTR_NAME as rREPORTED_BY_CODE \n"); 
			sql.append(	",usra.NAMET as rREPORTED_BY \n");
			sql.append(	",hd.REMARK as remarkfromadmin,hd.RESULT_LTR \n");
			sql.append(" ,convert(varchar, ran.UPDATE_DATE, 103)as RAN_CREATE_DATE \n");
			sql.append(" ,s.SOURCE_NAME,isnull((case when ran.SAMPLE_TYPE = '00002' then lb.LOGIS_NAME when ran.SAMPLE_TYPE = '00008' then lb.LOGIS_NAME when ran.SAMPLE_TYPE = '00009' then lb.LOGIS_NAME else l.LOGIS_NAME end),'-')as LOGIS_NAME,pro.PRODUCT_ID,dt.SAMPLE_TYPE_CODE \n");
			sql.append(" ,pro.PRODUCT_NAME_REPORT \n");
//			sql.append(" , ran.SAMPLE_STAFF_NAME as REPORTED_BY \n");
//			sql.append(" ,(SELECT NAMET FROM MP_USER WHERE CODEMP_ID =awl.approve_BY) as APPROVE_BY \n");
			sql.append("  ,convert(varchar, awl.APPROVE_DATE, 103)as APPROVE_DATE \n");
			sql.append(" ,convert(varchar, awl.APPROVE_DATE, 103)as REPORTED_DATE  \n");
//			 ,(case when dt.SAMPLE_TYPE_CODE = '00001' then (concat(concat(ran.CAR_SLOT,'/'),ran.CAR_NO))--'ช่องรถ/ทะเบียนรถ'
//					 when dt.SAMPLE_TYPE_CODE = '00004' then ran.TANK_NO --'หมายเลขถัง'
//					 else loca.LOC_NAME end) AS VESSEL
			sql.append(" ,(case when dt.SAMPLE_TYPE_CODE = '00001' or dt.SAMPLE_TYPE_CODE = '00010' then (concat(concat(ran.CAR_NO,'/'),ran.CAR_SLOT)) \n");
			sql.append(" when dt.SAMPLE_TYPE_CODE = '00004' then ran.TANK_NO \n");
			sql.append("  else loca.LOC_NAME end) AS VESSEL,ran.METER_NO ,ran.BOAT_NO,ran.BOAT_NAME,ran.CAR_NO,ran.CAR_SLOT,dt.LTR_CODE,ran.TYPE_STATION_ID,hd.PRODUCT_DESC,ran.SAMPLE_TYPEC_DESC \n");
			sql.append("  ,ran.SOURCE_OTHER_DESC,ran.RETURNR_DESC,ran.SAMPLE_POINT_DESC,ran.ADDITIVE_INV_NO,(SELECT NAMET FROM MP_USER WHERE CODEMP_ID = ran.UPDATE_BY)   AS APPROVE_BY,ran.SUB_TYPE_CODE,ran.manual_type,ran.SAMPLE_TYPEC_DESC,ran.SAMPLE_TYPE,hd.LTR_CODE \n");
			sql.append(" from ASS_LTR_DT_SUB dts \n");
			sql.append(" inner join ASS_LTR_DT dt on dt.LTR_DT_ID = dts.LTR_DT_ID \n");
			sql.append(" inner join ASS_LTR_HD hd on hd.LTR_CODE = dt.LTR_CODE \n");
			sql.append(" inner join RANDOM_SAMPLE_RESULT ran on ran.LAB_CODE = hd.LAB_CODE \n");
			sql.append(" inner join PLANT p on p.PLANT_ID = ran.PLANT_ID \n");
			sql.append(" inner join PRODUCT_MAINLAB pro on pro.PRODUCT_ID = ran.PRODUCT_ID \n");
			sql.append(" left join LOCATION_PRODUCT_R loca on loca.LOC_ID = ran.LOC_ID \n");
			sql.append(" left join SOURCE s on s.SOURCE_ID = ran.SOURCE_ID \n");
			sql.append(" left join LOGISTICS_BOAT lb on lb.LOGIS_ID = ran.LOGIS_ID \n");
			sql.append(" left join LOGISTICS l on l.LOGIS_ID = ran.LOGIS_ID \n");
			sql.append(" left join ASS_WF_LTR awl on awl.LTR_CODE = dt.LTR_CODE	and awl.LTR_CODE = hd.LTR_CODE \n");
			sql.append(" left join MP_USER usra on usra.CODEMP_ID = hd.PRINT_LTR_NAME \n");
			sql.append(" where 1=1  \n");
//			sql.append(" and awl.STATUS = '08'  \n");
			sql.append(" and hd.LAB_CODE in ("+labCode+") \n");
//			sql.append(" and awl.USER_TYPE_ID='0005' \n");
			sql.append(" AND awl.STATUS='08' \n");
			sql.append(" ORDER BY pro.PRODUCT_ID ,ran.LAB_CODE ");
			////logger.info("sql datatile : {}",sql.toString());


			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			return resultList;
		}catch (Exception e){
			logger.error("Exectpion : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}



	public boolean checkProductB100(String labCode){
		boolean status =true;

		List<Map<String,Object>>result = new ArrayList<>();
		try{
			StringBuilder sql = new StringBuilder();
			sql.append( " SELECT PM.PRODUCT_ID,PM.PRODUCT_NAME FROM RANDOM_SAMPLE_RESULT  RS \n");
			sql.append( " INNER JOIN PRODUCT_MAINLAB PM ON PM.PRODUCT_ID = RS.PRODUCT_ID \n");
			sql.append( " WHERE LAB_CODE ='"+labCode+"' \n");

//			//logger.info("check Product : {}",sql.toString());
			result = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			for(Map<String,Object> m : result){
				if("100000041".equals(m.get("PRODUCT_ID"))){
					status = false;
				}else{
					status = true;
				}
			}
			return status;
		}catch (Exception e){
			logger.error("Exception : {}",e);
			throw  new RuntimeException(e.getMessage());
		}
	}

	public List<Map<String,Object>>getDataTitleAdditive(String  labCode){
		List<Map<String,Object>>resultList =new ArrayList<>();
		try{
			StringBuilder sql = new StringBuilder();
			sql.append(" select distinct concat(SUBSTRING(hd.LTR_CODE, 4, 7),'/',SUBSTRING(hd.LTR_CODE, 1, 2)) as report_no,p.PLANT_NAME,pro.PRODUCT_NAME  \n ");
			sql.append(" ,convert(varchar, ran.PRINT_STICKER_DATE, 103)as RAN_STICKER_DATE,isnull(loca.LOC_NAME,'-') as LOC_NAME ,loca.LOC_ID \n ");
			sql.append(" ,convert(varchar, ran.CREATE_DATE, 103)as RAN_CREATE_DATE  \n ");
			sql.append(" ,s.SOURCE_NAME,l.LOGIS_NAME ,pro.PRODUCT_ID,hd.LAB_CODE ,pro.PRODUCT_CODE\n ");
			sql.append(" ,hd.LTR_CODE \n ");
			sql.append(" ,ran.ADTV_LOT_NO \n ");
			sql.append(" ,ran.ADTV_PO_NO \n ");
			sql.append(" ,MU.CODEMP_ID as APPROVE_BY_CODE,MU.NAMET as APPROVE_BY  \n");
			sql.append(" ,pro.PRODUCT_NAME_REPORT,ran.SAMPLE_POINT_DESC ,convert(varchar, awl.APPROVE_DATE, 103)as APPROVE_DATE,convert(varchar, awl.APPROVE_DATE, 103)as REPORTED_DATE \n");
			sql.append(" from ASS_LTR_DT_SUB dts  \n ");
			sql.append(" inner join ASS_LTR_DT dt on dt.LTR_DT_ID = dts.LTR_DT_ID  \n ");
			sql.append(" inner join ASS_LTR_HD hd on hd.LTR_CODE = dt.LTR_CODE  \n ");
			sql.append(" inner join RANDOM_SAMPLE_RESULT ran on ran.LAB_CODE = hd.LAB_CODE  \n ");
			sql.append(" inner join PLANT p on p.PLANT_ID = ran.PLANT_ID  \n ");
			sql.append(" inner join PRODUCT_MAINLAB pro on pro.PRODUCT_ID = ran.PRODUCT_ID  \n ");
			sql.append(" left join LOCATION_PRODUCT_R loca on loca.LOC_ID = ran.LOC_ID  \n ");
			sql.append(" left join SOURCE s on s.SOURCE_ID = ran.SOURCE_ID  \n ");
			sql.append(" left join LOGISTICS_BOAT lb on lb.LOGIS_ID = ran.LOGIS_ID  \n ");
			sql.append(" left join LOGISTICS l on l.LOGIS_ID = ran.LOGIS_ID  \n ");
			sql.append(" inner join ASS_WF_LTR awl on awl.LTR_CODE = dt.LTR_CODE	and awl.LTR_CODE = hd.LTR_CODE \n");
			sql.append(" inner join MP_USER MU on MU.CODEMP_ID = awl.APPROVE_BY  \n ");
			sql.append(" where 1=1   \n ");
			sql.append(" and awl.STATUS = '08'   \n ");
			sql.append(" and hd.LAB_CODE in ("+labCode+")  \n ");
			sql.append("  and awl.USER_TYPE_ID='0005' \n");
			sql.append(" group by p.PLANT_NAME,pro.PRODUCT_NAME  \n ");
			sql.append(" ,loca.LOC_NAME \n ");
			sql.append(" , ran.CREATE_DATE \n ");
			sql.append(" ,s.SOURCE_NAME,l.LOGIS_NAME ,pro.PRODUCT_ID,hd.LAB_CODE,loca.LOC_ID,pro.PRODUCT_CODE \n ");
			sql.append(" ,hd.LTR_CODE	 \n");
			sql.append(" ,ran.ADTV_LOT_NO \n");
			sql.append(" ,ran.ADTV_PO_NO \n");
			sql.append(" ,ran.SAMPLE_STAFF_NAME \n");
			sql.append(" ,MU.NAMET ,MU.CODEMP_ID \n");
			sql.append(" ,ran.CREATE_DATE,pro.PRODUCT_NAME_REPORT,ran.SAMPLE_POINT_DESC,ran.UPDATE_DATE,awl.APPROVE_DATE \n");
			//logger.info("sql  data title Additive : {}",sql.toString());
			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			return resultList;
		}catch (Exception e){
			logger.error("Exectpion : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}

	public List<Map<String,Object>>getDataAdditiveHeader(String  labCode){
		List<Map<String,Object>>resultList =new ArrayList<>();
		try{
			StringBuilder sql = new StringBuilder();
			sql.append( " select distinct im.ITEM_NAME,im.ITEM_ID \n");
			sql.append( " from \n");
			//	-- LTR DETAIL
			sql.append( " ASS_LTR_DT dt \n");
			sql.append( " inner join ASS_LTR_HD hd on hd.LTR_CODE = dt.LTR_CODE \n");
			sql.append( " inner join ASS_LTR_DT_SUB ds on ds.LTR_DT_ID = dt.LTR_DT_ID \n");
			sql.append( " inner join ASS_LTR_DT_USER us on us.LTR_DT_ID = dt.LTR_DT_ID \n");
			//	-- RANDOM SAMPLE RESULT
			sql.append( " inner join RANDOM_SAMPLE_RESULT ran on ran.LAB_CODE = hd.LAB_CODE \n");
			//	-- จุดเก็บ
			sql.append( " inner join LOCATION_PRODUCT_R loc on loc.LOC_ID = ran.LOC_ID \n");
			//	-- PRODUCT
			sql.append( " inner join PRODUCT_MAINLAB pm on pm.PRODUCT_ID = ran.PRODUCT_ID \n");
			//	-- Item Name
			sql.append( " inner join ASS_ITEM_MASTER im on im.ITEM_ID = dt.ITEM_ID \n");
			sql.append( " where 1=1 \n");
			sql.append( "and hd.LAB_CODE in("+labCode+") \n");
			sql.append( "order by ITEM_NAME asc \n");
			//logger.info("getDataAdditiveHeader : {}",sql.toString());
			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			return resultList;
		}catch (Exception e){
			logger.error("Exectpion : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}
	public List<Map<String,Object>>getDataAdditiveDetail(String  labCode){
		List<Map<String,Object>>resultList =new ArrayList<>();
		try{
			StringBuilder sql = new StringBuilder();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDataAddtitive") ;
			//logger.info(" labCode :{}",labCode);
			SqlParameterSource in = new MapSqlParameterSource().addValue("labCode",labCode,Types.VARCHAR);
			//logger.info("getDataAdditiveHeader : {}",sql.toString());
			resultList = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			return resultList;
		}catch (Exception e){
			logger.error("Exectpion : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}


	public String pad(Integer num) {
		String s = num.toString();
		while (s.length() < 5) s = "0" + s;
		return s;
	}

	public List<Map<String,Object>> getApproveByAndRemark(String[] labCode){
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		try {

			String str = "";
			for(String s : labCode) {
				if ("".equals(str)) {
					str = "'" + s + "'";
				} else {
					str += "," + "'" + s + "'";
				}
			}
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT  hd.LAB_CODE,(case when hd.RESULT_LTR = 'U' then 'ผ่านแบบมีเงื่อนไข' when hd.RESULT_LTR = 'Y' then 'ผ่าน'\r\n" + 
					"			 else 'ไม่ผ่าน' end) as RESULT_FLAG  \n ");
			sql.append(" ,mu.NAMET as APPROVE_BY,ds.ITEMMPSP_ID  \n ");
			sql.append("  ,sam.PRODUCT_ID,hd.RTDESC,sam.SAMPLE_TYPE \n ");
			sql.append(" FROM ASS_WF_LTR wf \n ");
			sql.append(" inner join MP_USER mu on mu.CODEMP_ID = wf.APPROVE_BY \n ");
			sql.append(" inner join ASS_LTR_HD hd with (nolock) on hd.LTR_CODE =wf.LTR_CODE \n ");
			sql.append(" left join ASS_LTR_DT_SUB ds with (nolock) on ds.LTR_DT_ID = wf.LTR_CODE \n ");
			sql.append(" left join ASS_ITEM_SPEC_MP asm with (nolock) on asm.ITEMMP_ID =ds.ITEMMPSP_ID  \n ");
			sql.append(" left join RANDOM_SAMPLE_RESULT sam with (nolock) on sam.LAB_CODE = hd.LAB_CODE \n");
			sql.append(" where 1=1 \n ");
			sql.append(" and hd.LAB_CODE  in( "+str+" ) \n ");
			sql.append(" and wf.END_WF = 'Y' and hd.STATUS = '08' \n ");
			sql.append(" order by hd.LAB_CODE \n ");

			//logger.info("getApproveByAndRemark : {}",sql.toString());
			result = jdbcTemplateSQLSERVER.queryForList(sql.toString());

			return result;
		}catch(Exception e) {
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}





	public List<Map<String,Object>> getDataForCOQ(String[] labCode,String reportedBy,String codeComp){
		Map<String,Integer> result = new HashMap<>();
		List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
		String descEdit="";
		flagyO=0;
		flaguO=0;
		flagnO=0;
		conditionO = "";
		
		try {
			StringBuffer sql = new StringBuffer();

			String str = "";
			for(String s : labCode){
				if("".equals(str)){
					str = "'"+s+"'";
				}else{
					str+=","+"'"+s+"'";
				}
			}
			
			//checkUserA1(codeComp,str);
			//logger.info("labCode : {}",str);
			String userA1  = getReportedRoleA1("user");
			String codempA1 = getReportedRoleA1("codemp");

			StringBuffer sql2 = new StringBuffer();
			//===================================================
			String params = getSampleTyepCodeAndProductType(labCode);
			//logger.info("params --> store : {}",params);
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getDataReportLTR") ;
//	            //logger.info(" call :{}",call);

			SqlParameterSource in = new MapSqlParameterSource().addValue("param",params,Types.VARCHAR);
			//Map<String, Object> mapStroeProce= call.execute(in);
//	            //logger.info("mapStroeProce : {}",mapStroeProce);

			List<Map<String, Object>>  listMapStroeGetData= (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			Map<String, Map<String,Object>> listDataOrigin = new HashMap<>();
			//logger.info("listMapStroeGetData : {}",listMapStroeGetData.size());

			List<Map<String,Object>> listData = new ArrayList<>();
			Map<String,Object> mapData = new HashMap<>();
			String labCodeCheck = "";
			boolean checkLabCode =true;
			Integer index =1;
			String disStr = "";
			String conditionO = "";
//				List<String> labCodeChk = new ArrayList<>();

			Set<String>labCodeChk = new HashSet<>();

			//get labCode for check
			//List<String>listLabCode = new ArrayList<>();
			for(Map<String,Object> m : listMapStroeGetData){
				labCodeChk.add(m.get("labCode").toString());
			}

			LinkedHashSet<String> fifo = new LinkedHashSet<String>();
			for(Map<String,Object> m : listMapStroeGetData){
				fifo.add(m.get("labCode").toString());
			}
			str="";
			for(String s : fifo){
				if("".equals(str)){
					str = "'"+s+"'";
				}else{
					str+=","+"'"+s+"'";
				}
			}

			Map<Object,String> mapCheLabCode = new HashMap<>();
			int cheIndex= 0;
			for(String s : labCodeChk){
				mapCheLabCode.put(cheIndex,s);
				cheIndex++;
			}

			// Year
			Date date = new Date();
			SimpleDateFormat DateFor = new SimpleDateFormat("YY");

			String stringDate= DateFor.format(date);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			String printDate= dateFormat.format(date);
			String patternOneDigit = "###,###.#";
			String patternTwoDigit = "###,###.##";
			String patternThreeDigit = "###,###.###";
			String patternFourDigit = "###,###.####";
			DecimalFormat decimalFormat1 = new DecimalFormat(patternOneDigit);
			DecimalFormat decimalFormat2 = new DecimalFormat(patternTwoDigit);
			DecimalFormat decimalFormat3 = new DecimalFormat(patternThreeDigit);
			DecimalFormat decimalFormat4 = new DecimalFormat(patternFourDigit);

			// get From message.properties
			setFlagPrintLTR(labCode,reportedBy,codeComp);
			String productNameReportTruck = messageConfig.get("title.truck");
			List<Map<String,Object>> listDataHeader = getDataTitleCOQ(str);
			Integer sequent = 1;
			Map<String,Object> dataHeader =  new HashMap<>();
			for(int i =0 ;i< str.split(",").length;i++){
				disStr="";
				//boolean checkResult =true;
				String checkResult = "";
				dataHeader = listDataHeader.get(i);
				
				if(dataHeader.get("LTR_CODE_REF") != null && !dataHeader.get("LTR_CODE_REF").toString().isEmpty())
					listDataOrigin = getDataOrigin(dataHeader.get("SAMPLE_TYPE"), dataHeader.get("LTR_CODE_REF").toString());
				////logger.info("data header : {}",listDataHeader);
				mapData = new HashMap<>();
				mapData.put("LTR_TO", dataHeader.get("PLANT_NAME") ==null ? "-":dataHeader.get("PLANT_NAME").toString());
				mapData.put("NOTE_FROM_ADMIN", dataHeader.get("remarkfromadmin") ==null ? "":"4  "+dataHeader.get("remarkfromadmin").toString());
				mapData.put("LTR_CODE", dataHeader.get("LTR_CODE").toString());
				if("00001".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())
					||	"00010".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())
						) {
					mapData.put("LTR_CC", "-");
				}else {
					if("100000001".equals(dataHeader.get("PRODUCT_ID") ==null ? "-":dataHeader.get("PRODUCT_ID").toString())) {
						mapData.put("LTR_CC", "IRPC");
					}else {
						mapData.put("LTR_CC", "-");
					}

				}
				if("00003".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())) {
					mapData.put("LTR_PRODUCT", productNameReportTruck);
				}else if("00004".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ? "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())){
					mapData.put("LTR_PRODUCT", dataHeader.get("PRODUCT_NAME_REPORT") ==null ? "-":dataHeader.get("PRODUCT_NAME_REPORT").toString());
				}else {
					mapData.put("LTR_PRODUCT", dataHeader.get("PRODUCT_NAME_REPORT") ==null ? "-":dataHeader.get("PRODUCT_NAME_REPORT").toString());
				}

				mapData.put("LTR_DATE",dataHeader.get("DTS_CREATE_DATE") ==null ? "-":dataHeader.get("DTS_CREATE_DATE").toString() );

				mapData.put("LTR_VESSEL", dataHeader.get("VESSEL") ==null ? "-":dataHeader.get("VESSEL").toString());

				String ltr_ref;
				ltr_ref = dataHeader.get("SEND_REQT_ID") ==null ? "-":dataHeader.get("SEND_REQT_ID").toString()+";\n";
				ltr_ref += dataHeader.get("SAMPLE_TYPEC_DESC") ==null ? "-":dataHeader.get("SAMPLE_TYPEC_DESC").toString()+"\n";
				mapData.put("LTR_REF", ltr_ref);

				descEdit = dataHeader.get("REVISE_DESC") ==null ? "-":dataHeader.get("REVISE_DESC").toString();
				if( "Y".equals(dataHeader.get("manual_type").toString())) {
					mapData.put("LTR_DATE_EX", dataHeader.get("SAMPLE_DATE") ==null ? "-":dataHeader.get("SAMPLE_DATE").toString());
				}else {
					mapData.put("LTR_DATE_EX", dataHeader.get("CREATE_DATE") ==null ? "-":dataHeader.get("CREATE_DATE").toString());
				}
				
				
				mapData.put("LTR_REPORT", dataHeader.get("report_no") ==null ? "-":dataHeader.get("report_no").toString());
				mapData.put("REPLACE_NEW_LTR", dataHeader.get("report_no_ref") ==null ||dataHeader.get("report_no_ref").toString().length()<5? "":"(ออกทดแทน "+dataHeader.get("report_no_ref").toString()+")");
				mapData.put("PROBLEM_TEXT", (descEdit!=null&&descEdit!=""&&!descEdit.equals("-"))?"สาเหตุ : "+descEdit:"");

//					mapData.put("P_HEAD_RANDOM_DATE", dataHeader.get("RAN_CREATE_DATE") ==null ? "-":dataHeader.get("RAN_CREATE_DATE").toString());
				mapData.put("LTR_CODE_NO", dataHeader.get("LAB_CODE") ==null ? "-":dataHeader.get("LAB_CODE").toString());
				mapData.put("P_HEAD", "Uncertainty");
				mapData.put("P_HEAD_TEST_ITEMS", "TEST ITEMS");
				mapData.put("P_HEAD_UNIT", "UNIT");
				mapData.put("P_HEAD_TEST_METHOD", "TEST METHOD");
				mapData.put("P_HEAD_SPECS", "SPECS");
				mapData.put("P_HEAD_TEST_RESULT", "TEST RESULT");
				/*
				 * if("00004".equals(dataHeader.get("SAMPLE_TYPE_CODE") ==null ?
				 * "-":dataHeader.get("SAMPLE_TYPE_CODE").toString())) {
				 * mapData.put("PRODUCT_DESC", dataHeader.get("SAMPLE_TYPEC_DESC") ==null ?
				 * "-":dataHeader.get("SAMPLE_TYPEC_DESC").toString()); }else {
				 * mapData.put("PRODUCT_DESC", dataHeader.get("PRODUCT_DESC") ==null ?
				 * "-":dataHeader.get("PRODUCT_DESC").toString()); }
				 */
				mapData.put("PRODUCT_DESC", dataHeader.get("PRODUCT_DESC") ==null ? "-":dataHeader.get("PRODUCT_DESC").toString());

				String gaugeStr1 = dataHeader.get("SOURCE_NAME") ==null ? "-":dataHeader.get("SOURCE_NAME").toString()+",";
				String gaugeStr2 = dataHeader.get("LOGIS_NAME") ==null ? "-":dataHeader.get("LOGIS_NAME").toString();
				////logger.info("gaugeStr : {}",gaugeStr1.concat(gaugeStr2));
				mapData.put("LTR_GAUGE", gaugeStr1);
				mapData.put("LTR_GAUGE2", gaugeStr2);

				mapData.put("V_APPROVE_BY", dataHeader.get("APPROVE_BY") ==null ? "-":dataHeader.get("APPROVE_BY").toString());
				mapData.put("V_APPROVE_BY_CODE", dataHeader.get("approve_BY_code") ==null ? "-":dataHeader.get("approve_BY_code").toString());
				mapData.put("V_APPROVE_DATE", dataHeader.get("APPROVE_DATE") ==null ? "-":dataHeader.get("APPROVE_DATE").toString());
				mapData.put("V_REPORTED_BY", dataHeader.get("rREPORTED_BY") ==null ? printDate :dataHeader.get("rREPORTED_BY").toString());
				mapData.put("V_REPORTED_BY_CODE", dataHeader.get("rREPORTED_BY_CODE") ==null ? printDate :dataHeader.get("rREPORTED_BY_CODE").toString());
				mapData.put("V_REPORTED_DATE",dataHeader.get("rREPORTED_DATE") ==null ? printDate :dataHeader.get("rREPORTED_DATE").toString());
				mapData.put("QOC_ADDRESS", dataHeader.get("QOC_ADDRESS") ==null ? "-":dataHeader.get("QOC_ADDRESS").toString());
				mapData.put("RECEIVE_DATE", dataHeader.get("RECEIVE_DATE") ==null ? "-":dataHeader.get("RECEIVE_DATE").toString());
				//Result Test
				mapData.put("ISSUE_DATE",dataHeader.get("issue_date") ==null ? "-":dataHeader.get("issue_date").toString() );
				mapData.put("TESTED_DATE",dataHeader.get("tested_date") ==null ? "-":dataHeader.get("tested_date").toString() );
				String reason = "1  รายงานนี้เป็นรายงานผลการตรวจสอบเฉพาะตัวอย่างที่นำมาทดสอบเท่านั้น, รายงานผลการทดสอบนี้ต้องไม่ถูกทำสำเนาเฉพาะเพียงบางส่วน\n ";
				reason+="ยกเว้นทำสำเนาทั้งฉบับ และห้องปฏิบัติการจะไม่รับผิดชอบส่วนของข้อมูลที่ได้มาจากลูกค้า\n";
				reason+="2  สัญลักษณ์   * หมายถึง รายการทดสอบที่ไม่อยู่ในขอบเขตการรับรอง  ISO/IEC 17025:2017  ของห้องปฏิบัติการส่วนประกันคุณภาพ\n";
				//reason+="3  สัญลักษณ์  ** หมายถึง ผ่านแบบมีเงื่อนไข (Conditional Pass) ตามมาตรฐาน ILAC G8:2009 rule (Non-binary Statement with Guard Band)\n";
				//reason+="4  สัญลักษณ์  *** หมายถึง รายการวิเคราะห์ที่ไม่เป็นไปตามข้อกำหนด\n ";
				reason+="3  สัญลักษณ์  ** หมายถึง รายการวิเคราะห์ที่ไม่เป็นไปตามข้อกำหนด\n";
				reason+="4  การรายงานผลโดยใช้กฎการตัดสิน แบบไบนารีสำหรับการยอมรับอย่างง่าย (Simple acceptance ) (w=0 ) อาจจะมีความเป็นไปได้ที่จะตัดสินผลผิดพลาดสูงสุด 50 %\n ";
				//logger.info("reason : {}",reason);
				mapData.put("REASON",reason);

				if(dataHeader.get("result_coq").equals("Y")){
					mapData.put("P_RESULT_TEST", "ผ่าน*");
					//mapData.put("P_RESULT_TEST", "ผ่านการตรวจสอบ");
				}else if(dataHeader.get("result_coq").equals("U")) {
					mapData.put("P_RESULT_TEST", "ผ่านแบบมีเงื่อนไข");
				}else{
					mapData.put("P_RESULT_TEST", "ไม่ผ่าน*");
					//mapData.put("P_RESULT_TEST", "ไม่ผ่านการตรวจสอบ");
				}
				
				//check flag
				if(flagnO>0) {
					conditionO="N";
				}else if(flaguO>0) {
					conditionO="U";
				}else {
					conditionO="Y";
				}
				
				if(!conditionO.isEmpty() && !conditionO.equals(dataHeader.get("result_coq")) && dataHeader.get("LTR_CODE_REF") != null )
					mapData.put("C_P_RESULT_TEST", "P_RESULT_TEST");
					
				index=1;
				sql = new StringBuffer();
				sql.append("  select distinct(agi.GITEM_NAME) ,agi.gitem_id \n");
				sql.append(" from ASS_LTR_DT dt with (nolock) \n");
				sql.append(" inner join ASS_LTR_DT_USER ud with (nolock) on ud.LTR_DT_ID = dt.LTR_DT_ID  \n");
				sql.append(" inner join ASS_ITEM_SPEC_MP i with (nolock) on i.ITEMMP_ID = dt.ITEMMP_ID \n");
				sql.append(" inner join ASS_ITEM_SPEC_MP_METHOD m with (nolock) on m.ITEMMP_ID = dt.ITEMMP_ID  \n");
				sql.append(" inner join ASS_ITEM_SPEC_MP_TOOL t with (nolock) on t.ITEMMP_ID = dt.ITEMMP_ID \n");
				sql.append(" inner join ASS_ITEM_SPEC_MP_USER u with (nolock) on u.ITEMMP_ID = dt.ITEMMP_ID \n");
				sql.append(" inner join ASS_METHOD_MASTER ma with (nolock) on ma.METHOD_ID = dt.METHOD_ID \n");
				sql.append(" inner join ASS_TOOL_MASTER ta with (nolock) on ta.TOOL_ID = dt.TOOL_ID \n");
				sql.append(" inner join ASS_ITEM_MASTER ia with (nolock) on ia.ITEM_ID = dt.ITEM_ID \n");
				sql.append(" inner join USER_TYPE ut with (nolock) on ut.USER_TYPE_ID = ud.USER_TYPE_ID \n");
				sql.append(" inner join PRODUCT_MAINLAB p with (nolock) on p.PRODUCT_ID = i.PRODUCT_ID \n");
				sql.append(" inner join ASS_ITEM_SPEC_MP_SPDETAIL sp with (nolock) on sp.itemmp_id = dt.ITEMMP_ID \n");
				sql.append(" inner join ASS_LTR_DT_SUB sub with (nolock) on sub.ltr_dt_id = dt.LTR_DT_ID \n");
				sql.append(" inner join ASS_PRODUCT_GPMP apg with (nolock) on apg.PRODUCT_ID =  p.PRODUCT_ID \n");
				sql.append(" inner join ASS_GROUP_ITEM agi  with (nolock) on agi.GITEM_ID =  apg.GITEM_ID \n");
				sql.append(" inner join ASS_GROUP_ITEM_SPEC agis with (nolock) on agis.GITEM_ID = apg.GITEM_ID and agis.ITEMMP_ID = ia.ITEM_ID  \n");
				sql.append(" where 1=1 \n");
				sql.append("  and m.DEFAULT_FLG = 'Y' and t.DEFAULT_FLG = 'Y' and u.DEFAULT_FLG = 'Y'  \n");
				sql.append(" and dt.LTR_CODE in (select LTR_CODE from ASS_LTR_HD where LAB_CODE in ("+"'"+str.split(",")[i].replaceAll("'", "")+"'"+") ) \n");
				sql.append(" order by agi.gitem_id asc \n");


				List<Map<String,Object>> listGroupItems = jdbcTemplateSQLSERVER.queryForList(sql.toString());
				for(Map<String,Object> map : listGroupItems) {
					if(checkProductB100(str.split(",")[i].replaceAll("'", ""))){
						mapData.put("LABEL_TEST_ITEM_".concat(index.toString()), map.get("GITEM_NAME").toString() + " : ");
						mapData.put("V_UNIT_".concat(index.toString()), "");
						mapData.put("V_METHOD_".concat(index.toString()), "");
						mapData.put("V_SPECS_".concat(index.toString()), "");
						mapData.put("V_TEST_RESULT_".concat(index.toString()), "");
						index++;
					}

					for(Map<String,Object> m : listMapStroeGetData){
						if(str.split(",")[i].replaceAll("'", "").equalsIgnoreCase(m.get("labCode").toString())){
							if(map.get("GITEM_NAME").toString().equals(m.get("gitemName").toString())){

								if(m.get("itemName").toString().length()>11){
									String checkStr = m.get("itemName").toString().substring(0, 12);
//									//logger.info(" checkStr : {}",checkStr);
									if("Distillation".equalsIgnoreCase(checkStr)){
										if("".equals(disStr)){
											disStr = "     "+ m.get("itemName").toString().substring(0, 12).concat("*")+" : "+m.get("itemName").toString().substring(13);
											mapData.put("LABEL_TEST_ITEM_".concat(index.toString()),disStr);
										}else{
											mapData.put("LABEL_TEST_ITEM_".concat(index.toString()),"                        "+ m.get("itemName").toString().substring(12));
										}

									}else{
										if(
												m.get("itemsId").toString().equals("0010") ||
												m.get("itemsId").toString().equals("0013") ||
												(m.get("itemsId").toString().equals("0012") && m.get("methodName").toString().equals("ASTM D 4052-22"))
												) {
											mapData.put("LABEL_TEST_ITEM_".concat(index.toString()),"     "+ m.get("itemName").toString());
										}else {
											mapData.put("LABEL_TEST_ITEM_".concat(index.toString()),"     "+ m.get("itemName").toString().concat("*"));
										}
										
									}
								}else{

									if(m.get("itemsId").toString().equals("0010") || m.get("itemsId").toString().equals("0012") 
											|| m.get("itemsId").toString().equals("0013")) {
										mapData.put("LABEL_TEST_ITEM_".concat(index.toString()),"     "+ m.get("itemName").toString());
									}else {
										mapData.put("LABEL_TEST_ITEM_".concat(index.toString()),"     "+ m.get("itemName").toString().concat("*"));
									}
									//mapData.put("LABEL_TEST_ITEM_".concat(index.toString()),"     "+ m.get("itemName").toString());
								}
								String zItemUint =  m.get("itemUnit") ==null ?"-": m.get("itemUnit").toString();
								mapData.put("V_UNIT_".concat(index.toString()),zItemUint );
//								if(zItemUint.equals("C")) {
//									mapData.put("V_UNIT_".concat(index.toString()),"°".concat(zItemUint));
//								}else {
//									mapData.put("V_UNIT_".concat(index.toString()),zItemUint );
//								}
								//mapData.put("V_UNIT_".concat(index.toString()),);
								mapData.put("V_METHOD_".concat(index.toString()), m.get("methodName").toString());
								mapData.put("V_SPECS_".concat(index.toString()), m.get("specItemBacisText").toString());


								if(null == m.get("UNCERT")||"".equals( m.get("UNCERT"))){
									mapData.put("V_RESULT".concat(index.toString()),m.get("UNCERT") == null ?"" : m.get("UNCERT").toString());
								}else{
									System.out.println(m);
									if(m.get("resultText").equals("-")) {
										mapData.put("V_RESULT".concat(index.toString()),  "-");
									}else {
										//mapData.put("V_RESULT".concat(index.toString()),  m.get("UNCERT").toString());
										if("0010".equals(m.get("itemsId")) ||
												"0013".equals(m.get("itemsId")) ||
												("0012".equals(m.get("itemsId")) &&  m.get("methodName").toString().equals("ASTM D 4052-22")) ||
												"-".equals(m.get("UNCERT").toString())){
											String label = mapData.get("LABEL_TEST_ITEM_".concat(index.toString())).toString();
											int length = label.length();
															
											if(Character.compare('*',label.charAt(length-1)) == 0 && !"-".equals(m.get("UNCERT"))){
												mapData.put("V_RESULT".concat(index.toString()),  m.get("UNCERT").toString().concat("*"));
											} else {
												mapData.put("V_RESULT".concat(index.toString()),  m.get("UNCERT").toString());
											}
										} else {
											mapData.put("V_RESULT".concat(index.toString()),  m.get("UNCERT").toString().concat("*"));
										}
									}
									
								}



								if(null == m.get("RESULT_UN")||"".equals( m.get("RESULT_UN"))){
									mapData.put("V_UNCERT".concat(index.toString()),"-");
								}else{

									mapData.put("V_UNCERT".concat(index.toString()),  m.get("RESULT_UN").toString());
								}

								
								if("Y".equals(m.get("specRang").toString())){ //ผ่าน
									////logger.info("itemName Y :{}",m.get("itemName").toString());
									checkResultData(m,index,mapData,"");
								}else if("U".equals(m.get("specRang").toString())) { //ผ่านแบบมีเงื่อนไข
									////logger.info("itemName U :{}",m.get("itemName").toString());
									checkResultData(m,index,mapData,"**");
								}else { //if("N".equals(m.get("specRang").toString())){ //ไม่ผ่าน
									////logger.info("itemName N :{}",m.get("itemName").toString());
									//checkResultData(m,index,mapData,"***");
									checkResultData(m,index,mapData,"**");
								}
								
								String key = m.get("itemsId").toString().concat(m.get("methodID").toString());
								
								if(listDataOrigin.size() > 0){
									if(listDataOrigin.get(key) != null){
										if(m.get("methodName") != null && listDataOrigin.get(key).get("methodName") != null)
											if(!m.get("methodName").toString().equals(listDataOrigin.get(key).get("methodName").toString())) mapData.put("C_V_METHOD_".concat(index.toString()), "V_METHOD_".concat(index.toString()));
										if(m.get("specItemBacisText") != null && listDataOrigin.get(key).get("specItemBacisText") != null)
											if(!m.get("specItemBacisText").toString().equals(listDataOrigin.get(key).get("specItemBacisText").toString())) mapData.put("C_V_SPECS_".concat(index.toString()), "V_SPECS_".concat(index.toString()));
										if(m.get("resultText") != null && listDataOrigin.get(key).get("resultNum") != null)
											if(!m.get("resultText").toString().equals(listDataOrigin.get(key).get("resultNum").toString())) mapData.put("C_V_TEST_RESULT_".concat(index.toString()), "V_RESULT".concat(index.toString()));
										if(m.get("UNCERT") != null && listDataOrigin.get(key).get("UNCERT") != null)
											if(!m.get("UNCERT").toString().equals(listDataOrigin.get(key).get("UNCERT").toString())) mapData.put("C_V_RESULT".concat(index.toString()), "V_RESULT".concat(index.toString()));
										if(m.get("RESULT_UN") != null && listDataOrigin.get(key).get("RESULT_UN") != null)
											if(!m.get("RESULT_UN").toString().equals(listDataOrigin.get(key).get("RESULT_UN").toString())) mapData.put("C_V_UNCERT".concat(index.toString()), "V_UNCERT".concat(index.toString()));
									}
								}
								
								index++;
							}
						}else{
//							//logger.info("No Data found");

						}
					}
					
					
				}
				
				

				listData.add(mapData);

			}

			//logger.info("listData :{}",listData.size());
			return listData;
		}catch (Exception e){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}

	}
	public void checkUserA1(String codeComp,String labCode) {
		try {
			SimpleJdbcCall call ;
			SqlParameterSource in;
			//Data
			List<Map<String, Object>> zListData = new ArrayList();
			call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("checkA1Report") ;
			in = new MapSqlParameterSource()
					.addValue("labcode",labCode,Types.VARCHAR)
					.addValue("codempid",codeComp,Types.VARCHAR);
			call.execute(in).get("#result-set-1");		
		}catch(Exception ex) {
			
		}
	}
	public void checkResultData(Map<String,Object> m,Integer index,Map<String,Object> mapData,String str) {
		if("0001".equals(m.get("itemsId").toString())){
			mapData.put("V_TEST_RESULT_".concat(index.toString()),  m.get("resultText")==null?"-":m.get("resultText").toString().concat(str));
		}
		else if("0002".equals(m.get("itemsId").toString())){
			mapData.put("V_TEST_RESULT_".concat(index.toString()),  m.get("resultText")==null?"-":m.get("resultText").toString().concat(str));
		}
		else if("0003".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
//	String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				mapData.put("V_TEST_RESULT_".concat(index.toString()), m.get("resultText").toString() ==null ? "" : m.get("resultText").toString());
			}

		}
		else if("0004".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.concat(str));
			}
		}
		else if("0005".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.concat(str));
			}
		}
		else if("0006".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				if(!"0.0".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText);
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}
			}
		}
		else if("0007".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				if(!"0.0".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}
			}
		}
		else if("0008".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				if(!"0.0".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}
			}
		}
		else if("0009".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				if(!"0.0".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}
			}
		}
		else if("0010".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				if(!"0.0".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}
			}
		}
		else if("0011".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				if(!"0.0".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}
			}
		}
		else if("0012".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.4f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				if(!"0.0000".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}
			}
		}
		else if("0013".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.3f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.concat(str));
			}
		}
		else if("0014".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText =  String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.concat(str));
			}

		}
		else if("0015".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				mapData.put("V_TEST_RESULT_".concat(index.toString()), m.get("resultText").toString().concat(str));
			}
		}
		else if("0016".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				double val = Double.parseDouble(m.get("resultText").toString());
				int intVal = (int) Math.floor(val);
				String resultText = String.valueOf(intVal);
				mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.concat(str));
			}
		}
		else if("0017".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.3f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				if(!"0.000".equalsIgnoreCase(resultText)){
					mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.concat(str));
				}else{
					mapData.put("V_TEST_RESULT_".concat(index.toString()), "-");
				}
			}
		}
		else if("0018".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = (m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()) ;
				if(!resultText.equalsIgnoreCase("7")||resultText.equalsIgnoreCase("7")&&m.get("prductId").toString().equals("100000009")) {
					resultText = String.format("%.1f", Double.parseDouble(resultText));
				}
				mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.concat(str));
			}
		}
		else if("0019".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
				mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.concat(str));
			}
		}
		else if("0020".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{

				mapData.put("V_TEST_RESULT_".concat(index.toString()), m.get("resultText").toString().concat("*"));
			}
		}
		else if("0021".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				if("119000023-WI-002".equalsIgnoreCase(m.get("methodName").toString().trim())){
					double val = Double.parseDouble(m.get("resultText").toString()); 
					int intVal = (int) Math.floor(val); String resultText = String.valueOf(intVal);
					 
					if(!"-".equalsIgnoreCase(resultText))
					{
							mapData.put("V_TEST_RESULT_".concat(index.toString()),resultText.toString().concat(str)); 
					}else{
							mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.toString().concat(str)); 
					} 
				}else{
					Integer num = Integer.parseInt(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString());
					if(num==7){
						mapData.put("V_TEST_RESULT_".concat(index.toString()), num);
					}else{
						String resultText = String.format("%.1f", Double.parseDouble(m.get("resultText").toString() ==null ? "" : m.get("resultText").toString()));
						mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.concat(str));
					}

				}

			}
		}
		else if("0022".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				double val = Double.parseDouble(m.get("resultText").toString());
				int intVal = (int) Math.floor(val);
				String resultText = String.valueOf(intVal);
				mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.concat(str));
			}
		}
		else if("0023".equals(m.get("itemsId").toString())){
			if("-".equals(m.get("resultText") ==null ? "-" : m.get("resultText").toString()) || "".equals(m.get("resultText") == null ? "" : m.get("resultText").toString()) ){
				mapData.put("V_TEST_RESULT_".concat(index.toString()),"-");
			}else{
				double val = Double.parseDouble(m.get("resultText").toString());
				int intVal = (int) Math.floor(val);
				String resultText = String.valueOf(intVal);
				mapData.put("V_TEST_RESULT_".concat(index.toString()), resultText.concat(str));
			}
		}
	}


	public List<Map<String,Object>>getDataTitleCOQ(String  labCode){
		List<Map<String,Object>>resultList =new ArrayList<>();
		try{

			StringBuilder sql = new StringBuilder();
			sql.append("select distinct  awl.approve_BY as approve_BY_code,hd.RESULT_LTR as result_coq,hd.PRODUCT_DESC,concat(SUBSTRING(hd.LTR_CODE, 4, 7),'/',SUBSTRING(hd.LTR_CODE, 1, 2)) as report_no,p.PLANT_NAME,pro.PRODUCT_NAME,hd.LTR_CODE_REF  \n");
			sql.append(",concat(SUBSTRING(hd.LTR_CODE_REF, 4, 7),'/',SUBSTRING(hd.LTR_CODE_REF, 1, 2)) as report_no_ref \n");
			sql.append(",hd.REVISE_DESC \n");
			sql.append(",ran.SAMPLE_TYPEC_DESC,concat(format(ran.UPDATE_DATE,'dd/MM/yy'),' ถึง ',format(hd.UPDATE_DATE,'dd/MM/yy')) as tested_date  \n");
			sql.append(",convert(varchar, ran.PRINT_STICKER_DATE, 103)as RAN_STICKER_DATE,isnull(loca.LOC_NAME,'-') as LOC_NAME  \n");
			sql.append(",convert(varchar, ran.SAMPLE_DATE, 103)as SAMPLE_DATE,ran.manual_type \n");
			sql.append(",format(ran.UPDATE_DATE,'dd/MM/yy') as RECEIVE_DATE  \n");
			sql.append(",ran.SEND_REQT_ID,ran.LAB_CODE  \n");
			sql.append(	",hd.REMARK as remarkfromadmin \n");
			sql.append(",format(ran.CREATE_DATE,'dd/MM/yy') as CREATE_DATE  \n");
			sql.append(" ,convert(varchar, ran.UPDATE_DATE , 103)as DTS_CREATE_DATE  \n");
			sql.append(",s.SOURCE_NAME, convert(varchar, hd.PRINT_LTR_DATE , 103) as rREPORTED_DATE,hd.PRINT_LTR_NAME as rREPORTED_BY_CODE \n") ;
			sql.append(" ,usra.NAMET as rREPORTED_BY \n");
			sql.append(",isnull((case when ran.SAMPLE_TYPE = '00002' then lb.LOGIS_NAME when ran.SAMPLE_TYPE = '00008' then lb.LOGIS_NAME when ran.SAMPLE_TYPE = '00009' then lb.LOGIS_NAME else l.LOGIS_NAME end),'-')as LOGIS_NAME,pro.PRODUCT_ID,dt.SAMPLE_TYPE_CODE  \n");
			sql.append(",pro.PRODUCT_NAME_REPORT  \n");
			sql.append(",(SELECT NAMET FROM MP_USER WHERE CODEMP_ID =awl.approve_BY) as APPROVE_BY \n");
			sql.append(",convert(varchar, awl.APPROVE_DATE, 103)as APPROVE_DATE \n");
			sql.append(",p.ADDRESS as QOC_ADDRESS  \n");
			sql.append(",ran.PLANT_ID,format(hd.UPDATE_DATE,'dd/MM/yy') as issue_date \n");
			sql.append("  ,convert(varchar, ran.CREATE_DATE, 103)as REPORTED_DATE \n");
			sql.append(" ,ran.SAMPLE_STAFF_NAME as REPORTED_BY,hd.PRODUCT_DESC ,ran.BOAT_NO\n");
			sql.append(" ,(case when dt.SAMPLE_TYPE_CODE = '00001' then (concat(concat(ran.CAR_SLOT,'/'),ran.CAR_NO)) when dt.SAMPLE_TYPE_CODE = '00010' then (concat(concat(ran.CAR_SLOT,'/'),ran.CAR_NO)) \n");
			sql.append("when dt.SAMPLE_TYPE_CODE = '00004' then ran.TANK_NO \n");
			sql.append(" else loca.LOC_NAME end) AS VESSEL,pro.PRODUCT_ID,ran.SAMPLE_TYPEC_DESC,hd.LTR_CODE       \n");
			sql.append(" from ASS_LTR_DT_SUB dts  \n");
			sql.append(" inner join ASS_LTR_DT dt on dt.LTR_DT_ID = dts.LTR_DT_ID  \n");
			sql.append(" inner join ASS_LTR_HD hd on hd.LTR_CODE = dt.LTR_CODE  \n");
			sql.append(" inner join RANDOM_SAMPLE_RESULT ran on ran.LAB_CODE = hd.LAB_CODE  \n");
			sql.append(" inner join PLANT p on p.PLANT_ID = ran.PLANT_ID  \n");
			sql.append(" inner join PRODUCT_MAINLAB pro on pro.PRODUCT_ID = ran.PRODUCT_ID  \n");
			sql.append(" left join LOCATION_PRODUCT_R loca on loca.LOC_ID = ran.LOC_ID  \n");
			sql.append(" left join SOURCE s on s.SOURCE_ID = ran.SOURCE_ID  \n");
			sql.append(" left join LOGISTICS_BOAT lb on lb.LOGIS_ID = ran.LOGIS_ID  \n");
			sql.append(" left join LOGISTICS l on l.LOGIS_ID = ran.LOGIS_ID  \n");
			sql.append(" inner join ASS_WF_LTR awl on awl.LTR_CODE = dt.LTR_CODE	 \n");
			sql.append(" left join MP_USER usra on usra.CODEMP_ID = hd.PRINT_LTR_NAME	 \n");
			sql.append(" where 1=1   \n");
			sql.append(" and awl.STATUS = '08'   \n");
			sql.append(" and hd.LAB_CODE in ("+labCode+") \n");
			sql.append(" and awl.USER_TYPE_ID='0005' ");
			sql.append(" ORDER BY ran.LAB_CODE ");
			////logger.info("SQL DATA HEADER COQ: {}",sql.toString());
			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			return resultList;
		}catch (Exception e){
			logger.error("Exectpion : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}


	public List<Map<String,Object>> getDataReportAdditives2(String[] labCode,String reportedBy,String codEmpId){
		List<Map<String,Object>> resultList = new ArrayList<>();
		List<Map<String,Object>> data = new ArrayList<>();

		try{
			String str = "";
			for(String s : labCode) {
				if ("".equals(str)) {
					str = "'" + s + "'";
				} else {
					str += "," + "'" + s + "'";
				}
			}
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
			String printDate= dateFormat.format(date);
			SimpleDateFormat DateFor = new SimpleDateFormat("YY");
			String stringDate= DateFor.format(date);

			StringBuilder sql = new StringBuilder();
			List<Map<String,Object>>dataTitle = getDataTitleAdditive(str);
			List<Map<String,Object>>dataHeaderTable = getDataAdditiveHeader(str);
			List<Map<String,Object>>dataAdditiveDetail = getDataAdditiveDetail(str);
			Map<String,Object>mapProduct = new HashMap<>();
			List<Map<String,Object>>mapProductList = new ArrayList<>();
			String strProduct = "";
			String strProduct2 = "";

			List<Map<String,Object>>dataHeader = new ArrayList<>();
			Map<String,Object>mapTitle =new HashMap<>();
			Integer sequent =1;
			Integer paraNum = 3;
			boolean chkNewProduct = true;

			List<Map<String,Object>>poNoList =new ArrayList<>();
			Map<String,Object>poMap = new HashMap<>();
			Set<String> lotNoSet = new HashSet<>();
			for(Map<String,Object> m : dataTitle){
				lotNoSet.add(m.get("ADTV_LOT_NO").toString());

			}

			
			List<Map<String,Object>> listUser = setFlagPrintLTRForAdditives(labCode,reportedBy,codEmpId);
			
			Map<String,Object> mapUser = new HashMap<>();

			for(Map<String,Object> m : listUser){
				mapUser.put(m.get("ADTV_LOT_NO").toString(),m.get("NAMET")==null ? reportedBy : m.get("NAMET").toString());
			}

			DecimalFormat df = new DecimalFormat("0.0");
			Map<String,Object>mapDataReport = new HashMap<>();
			String[] reportName = {"LZ9045"};
			String vesel ="";
			List<Object> sizeB = new ArrayList<Object>();
			List<Object> sizeC = new ArrayList<Object>();
			List<Object> sizeD = new ArrayList<Object>();
			String userA1 = getReportedRoleA1("user");
			String codempA1 = getReportedRoleA1("codemp");
			List<String> keysGetData = new ArrayList<>();
			for(int i =0;i<reportName.length;i++) {
				for(String lotNoStr : lotNoSet){
					mapDataReport = new HashMap<>();
					for(Map<String,Object> m :dataTitle ){
						if(lotNoStr.equals(m.get("ADTV_LOT_NO").toString().trim())) {
							if("".equals(vesel)) {
								vesel =  m.get("SAMPLE_POINT_DESC") ==null ? "-":m.get("SAMPLE_POINT_DESC").toString();
							}else {
								vesel +=  m.get("SAMPLE_POINT_DESC") ==null ? "-": ","+m.get("SAMPLE_POINT_DESC").toString();
							}
							mapDataReport.put("LTR_TO",m.get("PLANT_NAME") ==null ? "-":m.get("PLANT_NAME").toString());
							mapDataReport.put("LTR_CC", "IRPC");
							mapDataReport.put("LTR_PRODUCT", m.get("PRODUCT_CODE") ==null ? "-":m.get("PRODUCT_CODE").toString() );
							mapDataReport.put("LTR_DATE",m.get("RAN_CREATE_DATE") ==null ? "-":m.get("RAN_CREATE_DATE").toString() );

							mapDataReport.put("LTR_REF", m.get("SEND_REQT_ID") ==null ? "-":m.get("SEND_REQT_ID").toString());
							mapDataReport.put("LTR_DATE_EX", m.get("RAN_CREATE_DATE") ==null ? "-":m.get("RAN_CREATE_DATE").toString());
							//LTR_DESC for LTR_C_CAR and LTR_C_CAR_BIO Only
							mapDataReport.put("LTR_DESC", m.get("SAMPLE_POINT_DESC") == null ?
									m.get("SAMPLE_TYPEC_DESC") == null ? "" : m.get("SAMPLE_TYPEC_DESC") :
										m.get("SAMPLE_POINT_DESC").toString());							mapDataReport.put("LTR_CODE_NO", m.get("LAB_CODE") ==null ? "-":m.get("LAB_CODE").toString());
							mapDataReport.put("LOT_NO", m.get("ADTV_LOT_NO") ==null ? "-":m.get("ADTV_LOT_NO").toString());
							mapDataReport.put("PO_NO", m.get("ADTV_PO_NO") ==null ? "-":m.get("ADTV_PO_NO").toString());
//							mapDataReport.put("V_APPROVE_BY", m.get("APPROVE_BY") ==null ? "-":m.get("APPROVE_BY").toString());
							mapDataReport.put("V_APPROVE_DATE", m.get("APPROVE_DATE") ==null ? printDate :m.get("APPROVE_DATE").toString());
//							mapData.put("V_REPORTED_BY", dataHeader.get("REPORTED_BY") ==null ? "-":dataHeader.get("REPORTED_BY").toString());
//							mapData.put("V_REPORTED_DATE", dataHeader.get("REPORTED_DATE") ==null ? "-":dataHeader.get("REPORTED_DATE").toString());
							System.out.println("debug6");
							System.out.println(m);
							mapDataReport.put("V_APPROVE_BY", m.get("APPROVE_BY").toString());
							mapDataReport.put("V_REPORTED_BY", m.get("APPROVE_BY").toString());
							mapDataReport.put("V_REPORTED_BY_CODE", m.get("APPROVE_BY_CODE").toString());
							mapDataReport.put("V_APPROVE_BY_CODE", m.get("APPROVE_BY_CODE").toString());
							mapDataReport.put("V_REPORTED_DATE", m.get("REPORTED_DATE") ==null ? printDate :m.get("APPROVE_DATE").toString());
							mapDataReport.put("LTR_REPORT", m.get("report_no") ==null ? printDate :m.get("report_no").toString());
							Integer indexHeader = 1;
							System.out.println("debug7");
							keysGetData = new ArrayList<>();
							for(Map<String,Object> mapHeader : dataHeaderTable){
								mapDataReport.put("HEADER_".concat(indexHeader.toString()), mapHeader.get("ITEM_NAME") ==null ? "-":mapHeader.get("ITEM_NAME").toString());
								keysGetData.add( mapHeader.get("ITEM_ID").toString());
								indexHeader++;
							}

							//logger.info("keysGetData : {} ",keysGetData);
							Integer indexDetail = 1;
							boolean checkResultLTR = true;
							Double b_total = 0d;
							Double c_total = 0d;
							Double d_total = 0d;
							Integer bDiv = 0;
							Integer cDiv = 0;
							Integer dDiv = 0;

//							for(Map<String,Object>mapDetail : dataAdditiveDetail){
//								//logger.info("LOC_ID 1 : {}",m.get("LOC_ID").toString());
//								//logger.info("LOC_ID 2 : {}",mapDetail.get("LOC_ID").toString());
//								//logger.info("PRODUCT_ID 1 : {}",m.get("PRODUCT_ID"	).toString());
//								//logger.info("PRODUCT_ID 2 : {}",mapDetail.get("PRODUCT_ID").toString());
//								if(lotNoStr.equals(mapDetail.get("ADTV_LOT_NO").toString().trim())){
//									if("Y".equals(mapDetail.get("RESULT_LTR").toString())&&checkResultLTR==true){
//										checkResultLTR =true;
//									}else{
//										checkResultLTR =false;
//									}
//									
//									//logger.info("PARAM_B",mapDetail.get(keysGetData.get(0)));
//									mapDataReport.put("PARAM_".concat(indexDetail.toString()), mapDetail.get("LAB_CODE") ==null ? "-":mapDetail.get("LAB_CODE").toString());
//									mapDataReport.put("A_PARAM_".concat(indexDetail.toString()), mapDetail.get("LOC_NAME") ==null ? "-":mapDetail.get("LOC_NAME").toString());
//									mapDataReport.put("B_PARAM_".concat(indexDetail.toString()), mapDetail.get(keysGetData.get(0)) ==null ? "-":Double.parseDouble(mapDetail.get(keysGetData.get(0)).toString()));
//									mapDataReport.put("C_PARAM_".concat(indexDetail.toString()), mapDetail.get(keysGetData.get(1)) ==null ? "-": Double.parseDouble(mapDetail.get(keysGetData.get(1)).toString()));
//									mapDataReport.put("D_PARAM_".concat(indexDetail.toString()), mapDetail.get(keysGetData.get(2)) ==null ? "-":Double.parseDouble(mapDetail.get(keysGetData.get(2)).toString()));
//									indexDetail++;
//									b_total += Double.parseDouble(mapDetail.get(keysGetData.get(0)) ==null ? "":mapDetail.get(keysGetData.get(0)).toString());
//
//									c_total += Double.parseDouble(mapDetail.get(keysGetData.get(1)) ==null ? "":mapDetail.get(keysGetData.get(1)).toString());
//
//									//logger.info(" d_total :{} ",mapDetail.get(keysGetData.get(2)).toString());
//									if("-".equals(mapDetail.get(keysGetData.get(2)).toString())) {
//										d_total += 0;
//									}else {
//										d_total += Double.parseDouble(mapDetail.get(keysGetData.get(2)).toString() ==null ? "":mapDetail.get(keysGetData.get(2)).toString());
//									}
//
//
//									bDiv++;
//									cDiv++;
//									dDiv++;
//								}
//
//							}
							if(checkResultLTR){
								mapDataReport.put("RESULT_TEST","ผ่านการตรวจสอบ");
							}else {
								mapDataReport.put("RESULT_TEST","ไม่ผ่านการตรวจสอบ");
							}



							b_total = "-".equals(b_total) ? b_total : b_total/bDiv;
							c_total = "-".equals(c_total) ? c_total : c_total/cDiv;
							d_total = "0".equals(d_total) ? '-' : d_total/dDiv;


							//logger.info("b  : {}",b_total);
							//logger.info("c  : {}",c_total);
							//logger.info("d  : {}",d_total);


							mapDataReport.put("B_TOTAL",Double.parseDouble(df.format(b_total)));
							mapDataReport.put("C_TOTAL",c_total);
							mapDataReport.put("D_TOTAL",d_total);
							//logger.info("B_TOTAL :{}",b_total);
							//logger.info("C_TOTAL :{}",c_total);
							//logger.info("D_TOTAL :{}",d_total);

							mapDataReport.put("LTR_VESSEL", vesel);
							resultList.add(mapDataReport);
						}
						
					}
					
					sequent++;
					vesel="";
				}


			}


			logger.info("resultList additive : {}",resultList.size());
			return  resultList;
		}catch (Exception e ){
			//logger.info("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}
	public List<Map<String,Object>> getDataReportAdditives3(String[] labCode,String reportedBy,String codEmpId){
		List<Map<String,Object>> result = new ArrayList();
		flagyO=0;
		flaguO=0;
		flagnO=0;
		conditionO = "";
		
		try {
			Map<String,Object>mapDataReport = new HashMap<>();
			//logger.info("labCode {}",labCode.toString());
			//logger.info("reportedBy {}",reportedBy);
			//logger.info("codEmpId {}",codEmpId);
			
			String strLabCode = "";
			for(String s : labCode) {
				if ("".equals(strLabCode)) {
					strLabCode = "'" + s + "'";
				} else {
					strLabCode += "," + "'" + s + "'";
				}
			}
			System.out.println(strLabCode);
			System.out.println(codEmpId);
			SimpleJdbcCall call ;
			SqlParameterSource in;
			String resultLtr = "";
			//Data
			List<Map<String, Object>> zListData = new ArrayList();
			call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getReportDataAdditive") ;
			in = new MapSqlParameterSource()
					.addValue("labcode",strLabCode,Types.VARCHAR)
					.addValue("reportBy",codEmpId,Types.VARCHAR);
			zListData = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			setFlagPrintLTR(labCode,reportedBy,"");
			System.out.println("zListData : {} " + zListData);			
			//get Report
			for(Map<String,Object> mapReport :zListData ){
				
				Map<String, Object> dataOriginAddtive = new HashMap<>();
				Map<String, Object> dataAddtiveResult = new HashMap<>();
				
				String rLABCODE = mapReport.get("rLABCODE").toString();
				
				if(mapReport.get("LTR_CODE_REF") != null && !mapReport.get("LTR_CODE_REF").toString().isEmpty()) {
					String ltrCodeRef = mapReport.get("LTR_CODE_REF").toString();
					dataOriginAddtive = getDataOriginAdditive3(ltrCodeRef, rLABCODE, "12");
				}
				
				String ltrCode = mapReport.get("LTR_CODE").toString();
				dataAddtiveResult = getDataOriginAdditive3(ltrCode, rLABCODE, "08");
				
				mapDataReport = new HashMap<>();
				//header
				mapDataReport.put("LTR_TO",mapReport.get("rTO").toString());
				mapDataReport.put("LTR_CC",mapReport.get("rCC").toString());
				mapDataReport.put("LTR_PRODUCT",mapReport.get("rPRODUCT").toString());
				mapDataReport.put("LTR_DATE",mapReport.get("rDATE").toString());
				mapDataReport.put("LTR_VESSEL",mapReport.get("rCONTAINER").toString());
				mapDataReport.put("LTR_REF",mapReport.get("rREF").toString());
				//LTR_DESC for LTR_C_CAR and LTR_C_CAR_BIO Only
				mapDataReport.put("LTR_DESC", mapReport.get("SAMPLE_POINT_DESC") == null ?
						mapReport.get("SAMPLE_TYPEC_DESC") == null ? "" : mapReport.get("SAMPLE_TYPEC_DESC") :
							mapReport.get("SAMPLE_POINT_DESC").toString());
				mapDataReport.put("LTR_REPORT",mapReport.get("rREPORTNO").toString());
				mapDataReport.put("REPLACE_NEW_LTR",mapReport.get("rREPORTREF")==null||mapReport.get("rREPORTREF").toString().length()<5 ?"":"(ออกทดแทน "+mapReport.get("rREPORTREF").toString()+")");
				mapDataReport.put("LOT_NO",mapReport.get("rLOTNO").toString());
				mapDataReport.put("PO_NO",mapReport.get("rPONO").toString());
				//table
				//Specific Gravity @ 60/60 DEGF,0023
				//Flash  Point  PMcc,0010				
				//Viscosity, Kinematic @ 40 C,0013
				double input = 3;
				String as = String.format("%.1f", Double.valueOf(mapReport.get("0023").toString())) ;
				mapDataReport.put("HEADER_1",mapReport.get("rHEADER1").toString().concat("*"));
				mapDataReport.put("HEADER_2",mapReport.get("rHEADER2").toString().concat("*"));
				mapDataReport.put("HEADER_3",mapReport.get("rHEADER3").toString().concat("*"));
				mapDataReport.put("PARAM_1",mapReport.get("rLABCODE").toString());
				mapDataReport.put("A_PARAM_1",mapReport.get("rVESSEL").toString());
				mapDataReport.put("B_PARAM_1",String.format("%.4f", Double.valueOf(mapReport.get("0023").toString()))); 
				mapDataReport.put("C_PARAM_1",String.format("%.1f", Double.valueOf(mapReport.get("0010").toString()))); 
				mapDataReport.put("D_PARAM_1",String.format("%.3f", Double.valueOf(mapReport.get("0013").toString()))); 
				mapDataReport.put("E_PARAM_1","-");
				mapDataReport.put("LTR_CODE",mapReport.get("LTR_CODE").toString());
				mapDataReport.put("PROBLEM_TEXT", (mapReport.get("REVISE_DESC")!=null&&mapReport.get("REVISE_DESC").toString()!=""&&!mapReport.get("REVISE_DESC").toString().equals("-"))?"สาเหตุ : "+mapReport.get("REVISE_DESC").toString():"");
				
				if("N".equals(dataAddtiveResult.get("0023")))
					mapDataReport.put("B_PARAM_1",String.format("%.4f", Double.valueOf(mapReport.get("0023").toString())).concat("**"));
				if("N".equals(dataAddtiveResult.get("0010")))
					mapDataReport.put("C_PARAM_1",String.format("%.1f", Double.valueOf(mapReport.get("0010").toString())).concat("**"));
				if("N".equals(dataAddtiveResult.get("0013")))
					mapDataReport.put("D_PARAM_1",String.format("%.3f", Double.valueOf(mapReport.get("0013").toString())).concat("**"));
				
				if(dataOriginAddtive.size() > 0){
					if(mapReport.get("0010") != null && dataOriginAddtive.get("0010") != null && !mapReport.get("0010").toString().equals(dataOriginAddtive.get("0010").toString())){
						mapDataReport.put("C_C_PARAM_1", "C_PARAM_1");
					}
					if(mapReport.get("0013") != null && dataOriginAddtive.get("0013") != null && !mapReport.get("0013").toString().equals(dataOriginAddtive.get("0013").toString())){
						mapDataReport.put("C_D_PARAM_1", "D_PARAM_1");
					}
					if(mapReport.get("0023") != null && dataOriginAddtive.get("0023") != null && !mapReport.get("0023").toString().equals(dataOriginAddtive.get("0023").toString())){
						mapDataReport.put("C_B_PARAM_1", "B_PARAM_1");
					}
				}
				
				if("IRPC".equals(mapDataReport.get("LTR_CC").toString())) {
					mapDataReport.put("NOTE_FROM_ADMIN",mapReport.get("REMARK")!=null?"3. "+mapReport.get("REMARK").toString():"");
				}else {
					mapDataReport.put("NOTE_FROM_ADMIN",mapReport.get("REMARK")!=null?mapReport.get("REMARK").toString():"");
				}
				
				//footer
				mapDataReport.put("V_REPORTED_BY_CODE",mapReport.get("rREPORT_BY_CODE").toString());
				mapDataReport.put("V_APPROVE_BY_CODE",mapReport.get("rAPPROVE_BY_CODE").toString());
				mapDataReport.put("V_REPORTED_BY",mapReport.get("rREPORT_BY")==null?"":mapReport.get("rREPORT_BY").toString());
				mapDataReport.put("V_REPORTED_DATE",mapReport.get("rREPORT_BY_DATE").toString());
				mapDataReport.put("V_APPROVE_BY",mapReport.get("rAPPROVE_BY").toString());
				mapDataReport.put("V_APPROVE_DATE",mapReport.get("rAPPROVE_BY_DATE").toString());
				if(resultLtr.isEmpty()) {
					resultLtr=String.valueOf(mapReport.get("RESULT_LTR"));
					if("Y".equals(resultLtr)) {
						
						//mapDataReport.put("P_RESULT_TEST","ผ่านการตรวจสอบ");
						mapDataReport.put("P_RESULT_TEST","ผ่าน");
					}else {
						//mapDataReport.put("P_RESULT_TEST","ไม่ผ่านการตรวจสอบ");
						mapDataReport.put("P_RESULT_TEST","ไม่ผ่าน");
					}
				}
				
				//check flag
				if(flagnO>0) {
					conditionO="N";
				}else if(flaguO>0) {
					conditionO="U";
				}else {
					conditionO="Y";
				}
				
				if(!conditionO.isEmpty() && !conditionO.equals(resultLtr))
					mapDataReport.put("C_P_RESULT_TEST", "P_RESULT_TEST");
				
				conditionO="";
				flagnO=0;
				flaguO=0;
				flagyO=0;
				
				result.add(mapDataReport);
				resultLtr="";
			}
			
			logger.info("result :{}",result);
		}catch(Exception ex) {
			logger.info("Exception {}",ex);
		}
		
		return result;
	}

	public  String getReportedRoleA1(String typeR) {
		String reportBy ="";
		List<Map<String,Object>>resultList =new ArrayList<>();
		try {
			StringBuilder sql = new StringBuilder();

			sql.append("SELECT TOP(1) MU.NAMET,MU.NAMEE,MU.CODEMP_ID FROM USER_TYPE UT \n");
			sql.append("INNER JOIN MP_USER MU ON UT.USER_TYPE_ID = MU.ROLE_ID \n");
			sql.append("WHERE USER_TYPE_ID='0007' \n");

			////logger.info("SQL DATA HEADER COQ: {}",sql.toString());

			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			if(0<resultList.size()) {
				if(typeR.equals("codemp")) {
					reportBy = resultList.get(0).get("CODEMP_ID").toString();
				}else {
					reportBy = resultList.get(0).get("NAMET").toString();
				}
				
			}

		}catch(Exception e) {
			logger.error("Exception : {}");
		}
		return reportBy;
	}

	public  String getReportedRoleLabTeamLead(String typeR) {
		String reportBy ="";
		List<Map<String,Object>>resultList =new ArrayList<>();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT TOP(1) MU.NAMET,MU.NAMEE,MU.CODEMP_ID FROM USER_TYPE UT \n");
			sql.append("INNER JOIN MP_USER MU ON UT.USER_TYPE_ID = MU.ROLE_ID \n");
			sql.append("WHERE USER_TYPE_ID='0005' \n");
			////logger.info("SQL DATA HEADER COQ: {}",sql.toString());
			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			if(0<resultList.size()) {
				if(typeR.equals("codemp")) {
					reportBy = resultList.get(0).get("CODEMP_ID").toString();
				}else {
					reportBy = resultList.get(0).get("NAMET").toString();
				}
			}

		}catch(Exception e) {
			logger.error("Exception : {}");
		}
		return reportBy;
	}

	public  List<Map<String,Object>> setFlagPrintLTR(String labCode[], String reportedBy,String codEmpId) {

		List<Map<String,Object>>resultList =new ArrayList<>();
		List<Map<String,Object>>resultListNew =new ArrayList<>();
		Connection conn = null;
		try {

			String str = "";
			for(String s : labCode) {
				if ("".equals(str)) {
					str = "'" + s + "'";
				} else {
					str += "," + "'" + s + "'";
				}
			}

			//logger.info("str :{}",str);
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT  LR.LAB_CODE,HD.FLG_PRINT_LTR,UT.USER_TYPE_DTL  \n");
			sql.append(" ,PRINT_LTR_NAME ,NAMET,MU.CODEMP_ID  \n");
			sql.append("   FROM ASS_LTR_HD HD \n");
			sql.append("    INNER JOIN RANDOM_SAMPLE_RESULT LR  ON HD.LAB_CODE = LR.LAB_CODE \n");
			sql.append("   LEFT JOIN MP_USER MU ON   LR.CREATE_BY= MU.CODEMP_ID  \n");
			sql.append("   LEFT JOIN USER_TYPE UT ON MU.ROLE_ID = UT.USER_TYPE_ID \n");
			sql.append("  WHERE LR.LAB_CODE in ("+str+") AND HD.STATUS = '08' \n");
			sql.append(" ORDER BY LR.LAB_CODE ASC \n");





			//logger.info("SQL DATA FOR SET FLAG {}",sql.toString());
			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			Map<String,Object> mapItem = new HashedMap();
			if(0<resultList.size()) {
				for(Map<String,Object> m : resultList) {
					mapItem = new HashedMap();
					mapItem.put("labCode", m.get("LAB_CODE") ==null?"":m.get("LAB_CODE").toString());
					mapItem.put("flgPrintLtr", m.get("FLG_PRINT_LTR") ==null ? "":m.get("FLG_PRINT_LTR").toString());
					mapItem.put("printName", m.get("NAMET") ==null ? reportedBy:m.get("NAMET").toString());
					mapItem.put("roleId", m.get("USER_TYPE_DTL") == null ? null:m.get("USER_TYPE_DTL").toString());
					mapItem.put("codemp_id", m.get("CODEMP_ID") == null ? null:m.get("CODEMP_ID").toString());
					resultListNew.add(mapItem);
				}
			}


			str = "";
			for(String s : labCode) {
				if ("".equals(str)) {
					str =  s ;
				} else {
					str += ","  + s ;
				}
			}

			SimpleJdbcCall cal = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					.withProcedureName("setFlagPrintLTR");
			//logger.info("lab_code : {}",labCode);
			//logger.info("printBy : {}",reportedBy);
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("lab_code", str, Types.VARCHAR)
					.addValue("printBy", codEmpId,Types.VARCHAR);
			Map<String, Object> out = cal.execute(in);

			return resultListNew;
		}catch(Exception e) {
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}

	}

	public  List<Map<String,Object>> setFlagPrintLTRForAdditives(String labCode[], String reportedBy,String codEmpId) {

		List<Map<String,Object>>resultList =new ArrayList<>();
		List<Map<String,Object>>resultListNew =new ArrayList<>();
		Connection conn = null;
		try {

			String str = "";
			for(String s : labCode) {
				if ("".equals(str)) {
					str = "'" + s + "'";
				} else {
					str += "," + "'" + s + "'";
				}
			}

			//logger.info("str :{}",str);
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT  LR.LAB_CODE,HD.FLG_PRINT_LTR,UT.USER_TYPE_DTL  \n");
			sql.append("  ,PRINT_LTR_NAME ,NAMET  ,SR.ADTV_LOT_NO,SR.ADTV_PO_NO,MU.CODEMP_ID  \n");
			sql.append("   FROM ASS_LTR_HD HD \n");
			sql.append("    INNER JOIN RANDOM_SAMPLE_LAST_RESULT LR  ON HD.LAB_CODE = LR.LAB_CODE \n");
			sql.append("     INNER JOIN RANDOM_SAMPLE_RESULT SR  ON SR.LAB_CODE = LR.LAB_CODE  \n");
			sql.append("   LEFT JOIN MP_USER MU ON   LR.CREATE_BY= MU.CODEMP_ID  \n");
			sql.append("   LEFT JOIN USER_TYPE UT ON MU.ROLE_ID = UT.USER_TYPE_ID \n");
			sql.append("  WHERE LR.LAB_CODE in ("+str+") \n");
			sql.append(" ORDER BY LR.LAB_CODE ASC \n");





			//logger.info("SQL DATA FOR SET FLAG {}",sql.toString());
			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			Map<String,Object> mapItem = new HashedMap();
			if(0<resultList.size()) {
				for(Map<String,Object> m : resultList) {
					mapItem = new HashedMap();
					mapItem.put("labCode", m.get("LAB_CODE") ==null?"":m.get("LAB_CODE").toString());
					mapItem.put("flgPrintLtr", m.get("FLG_PRINT_LTR") ==null ? "":m.get("FLG_PRINT_LTR").toString());
					mapItem.put("printName", m.get("NAMET") ==null ? reportedBy:m.get("NAMET").toString());
					mapItem.put("roleId", m.get("USER_TYPE_DTL") == null ? null:m.get("USER_TYPE_DTL").toString());
					mapItem.put("ADTV_LOT_NO", m.get("ADTV_LOT_NO") == null ? null:m.get("ADTV_LOT_NO").toString());
					mapItem.put("NAMET", m.get("CODEMP_ID") == null ? null:m.get("CODEMP_ID").toString());
					resultListNew.add(mapItem);
				}
			}


			str = "";
			for(String s : labCode) {
				if ("".equals(str)) {
					str =  s ;
				} else {
					str += ","  + s ;
				}
			}

			SimpleJdbcCall cal = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					.withProcedureName("setFlagPrintLTR");
			//logger.info("lab_code : {}",labCode);
			//logger.info("printBy : {}",reportedBy);
			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("lab_code", str, Types.VARCHAR)
					.addValue("printBy", codEmpId,Types.VARCHAR);
			Map<String, Object> out = cal.execute(in);

			return resultListNew;
		}catch(Exception e) {
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}

	}
	public String findLicen(String string) {
		String path ="";
		List<Map<String,Object>>resultList =new ArrayList<>();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT SIGNATURE_IMG FROM MP_USER WHERE  CODEMP_ID = '"+string+"'");
			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			if(!"null".equals(String.valueOf(resultList.get(0).get("SIGNATURE_IMG")))&&!(String.valueOf(resultList.get(0).get("SIGNATURE_IMG")).length()==0)) {
			path= resultList.get(0).get("SIGNATURE_IMG").toString().split("/")[2];
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	public List<Map<String, Object>> getCancelDataReport(String year, String month, String plant,String labcode) {
		List<Map<String, Object>>  result = new ArrayList<Map<String, Object>>();
		logger.info("----- getCancelDataReport ------ ");
		Map<String, Object> map = null;
		try{
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getDataCancelReport");
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("years", year, Types.VARCHAR)
				.addValue("months", month, Types.VARCHAR)
				.addValue("labcode", labcode, Types.VARCHAR)
				.addValue("plant", plant, Types.VARCHAR);
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");		
		}catch(Exception e){
			logger.error("error:"+e);
		}
		return result;
	}
	public List<Map<String, String>> getRoleAdmin(String role_id) {
		List<Map<String, String>>  result = new ArrayList<Map<String, String>>();
		logger.info("----- getRoleAdmin ------ ");
		Map<String, String> map = null;
		try{
			map = new HashMap<String, String>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getRoleAdmin");
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("roles", role_id, Types.VARCHAR);
				result = (List<Map<String, String>>)call.execute(in).get("#result-set-1");
				if(result==null) {
					result=new ArrayList<Map<String, String>>();
					map.put("resultCode", "00");
					result.add(map);	
				}
				
			
		}catch(Exception e){
			logger.error("error:"+e);
		}
		return result;
	}
	public List<Map<String, Object>> getCrateDataReport(String productID, String sampleType) {
		List<Map<String, Object>>  result = new ArrayList<Map<String, Object>>();
		logger.info("----- getCrateDataReport ------ ");
		Map<String, Object> map = null;
		try{
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getReportCrate");
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("productId", productID, Types.VARCHAR)
				.addValue("sampleType", sampleType, Types.VARCHAR);
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
				if(result==null) {
					result=new ArrayList<Map<String, Object>>();
					map.put("resultCode", "00");
					result.add(map);	
				}
				
			
		}catch(Exception e){
			logger.error("error:"+e);
		}
		return result;
	}
	public List<Map<String, Object>> getReportComplete(String centerCode) {
		List<Map<String, Object>>  result = new ArrayList<Map<String, Object>>();
		logger.info("----- getReportComplete ------ ");
		Map<String, Object> map = null;
		try{
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getReportComplete");
				SqlParameterSource in = new MapSqlParameterSource()
						.addValue("plantId", centerCode, Types.VARCHAR);
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");				
		}catch(Exception e){
			logger.error("error:"+e);
		}
		return result;
	}
	public List<Map<String, Object>> getRemarkReport(RequestCondition requestCondition) {
		List<Map<String, Object>>  result = new ArrayList<Map<String, Object>>();
		logger.info("----- getRemarkReport ------ ");
		SimpleDateFormat sf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate=requestCondition.getFromDate();
		String toDate=requestCondition.getToDate();
		Map<String, Object> map = null;
		
		try{
			fromDate=sf2.format(sf1.parse(fromDate));
			toDate=sf2.format(sf1.parse(toDate));
			
			fromDate=fromDate+" 17:00:00";
			toDate =toDate+" 16:59:59";
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getRemarkConditionReport");
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("productId", requestCondition.getProductId(), Types.VARCHAR)
				.addValue("sampleType", requestCondition.getSampleType(), Types.VARCHAR)
				.addValue("fromdate", fromDate, Types.VARCHAR)
				.addValue("todate", toDate, Types.VARCHAR);
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
				if(result==null) {
					result=new ArrayList<Map<String, Object>>();
					map.put("resultCode", "00");
					result.add(map);	
				}
				
			
		}catch(Exception e){
			logger.error("error:"+e);
		}
		return result;
	}
	public List<Map<String, Object>> getDataLtrIdWaitwork(String ltrid, String codempid) {
		List<Map<String, Object>>  result = new ArrayList<Map<String, Object>>();
		logger.info("----- getDataLtrIdWaitwork ------ ");
		Map<String, Object> map = null;
		
		try{
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getDataLtrWaitwork");
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("ltrId", ltrid, Types.VARCHAR)
				.addValue("codeemp", codempid, Types.VARCHAR);
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
				if(result==null) {
					result=new ArrayList<Map<String, Object>>();
					map.put("resultCode", "00");
					result.add(map);	
				}
				
			
		}catch(Exception e){
			logger.error("error:"+e);
		}
		return result;
	}
	public void getUpdateStatusPrintWaitwork(String status, String ltrid,String roleId) {
		List<Map<String, Object>>  result = new ArrayList<Map<String, Object>>();
		logger.info("----- getUpdateStatusPrintWaitwork ------ ");
		Map<String, Object> map = null;
		
		try{
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getUpdateWaitworkPrint");
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("ltrcode", ltrid, Types.VARCHAR)
				.addValue("roleId", roleId, Types.VARCHAR)
				.addValue("status", status, Types.VARCHAR);
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
				if(result==null) {
					result=new ArrayList<Map<String, Object>>();
					map.put("resultCode", "00");
					result.add(map);	
				}
				
			
		}catch(Exception e){
			logger.error("error:"+e);
		}	
	}
	public List<Map<String, Object>> getGroupPlant() {
		List<Map<String, Object>>  result = new ArrayList<Map<String, Object>>();
		logger.info("----- getGroupPlant ------ ");
		Map<String, Object> map = null;
		
		try{
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getGroupPlantComplete");
				SqlParameterSource in = new MapSqlParameterSource();
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
				if(result==null) {
					result=new ArrayList<Map<String, Object>>();
					map.put("resultCode", "00");
					result.add(map);	
				}
				
			
		}catch(Exception e){
			logger.error("error:"+e);
		}	
		
		return result;
		
	}
	public List<Map<String, Object>> getUserPlant(String centercode) {
		List<Map<String, Object>>  result = new ArrayList<Map<String, Object>>();
		logger.info("----- getUserPlant ------ ");
		Map<String, Object> map = null;
		
		try{
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getUserPlant");
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("centerCode", centercode, Types.VARCHAR);
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
				if(result==null) {
					result=new ArrayList<Map<String, Object>>();
					map.put("resultCode", "00");
					result.add(map);	
				}
				
			
		}catch(Exception e){
			logger.error("error:"+e);
		}	
		
		return result;
	}
	public List<Map<String, Object>> getRandomSample2(String from) {
		List<Map<String, Object>>  result = new ArrayList<Map<String, Object>>();
		logger.info("----- getRandomSample2 ------ ");
		Map<String, Object> map = null;
		String sdate[] = from.split("/");	
		String textDate=sdate[2]+"-"+sdate[1]+"-"+sdate[0];
		try{
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getDataRandomSample2");
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("sdate", textDate, Types.VARCHAR);
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
				if(result==null) {
					result=new ArrayList<Map<String, Object>>();
					map.put("resultCode", "00");
					result.add(map);	
				}
				
			
		}catch(Exception e){
			logger.error("error:"+e);
		}	
		
		return result;
	}
	public List<Map<String, Object>> getRandomSample2After(String from) {
		List<Map<String, Object>>  result = new ArrayList<Map<String, Object>>();
		logger.info("----- getRandomSample2After ------ ");
		Map<String, Object> map = null;
		String sdate[] = from.split("/");	
		String textDate=sdate[2]+"-"+sdate[1]+"-"+sdate[0];
		try{
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getDataAfterRandomSample2");
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("sdate", textDate, Types.VARCHAR);
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
				if(result==null) {
					result=new ArrayList<Map<String, Object>>();
					map.put("resultCode", "00");
					result.add(map);	
				}
				
			
		}catch(Exception e){
			logger.error("error:"+e);
		}	
		
		return result;
	}
	
	public List<Map<String, Object>> getRandomSampleFirst(String from, String status,String round) {
		List<Map<String, Object>>  result = new ArrayList<Map<String, Object>>();
		logger.info("----- getRandomSampleFirst ------ ");
		Map<String, Object> map = null;
		String sdate[] = from.split("/");	

		String textSDate=sdate[2]+"-"+sdate[1]+"-"+sdate[0];
		try{
			map = new HashMap<String, Object>();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("getDataRandomSample1");
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("sdate", textSDate, Types.VARCHAR)
				.addValue("status", round, Types.VARCHAR)
				.addValue("random", status, Types.VARCHAR);
				result = (List<Map<String, Object>>)call.execute(in).get("#result-set-1");
				if(result==null) {
					result=new ArrayList<Map<String, Object>>();
					map.put("resultCode", "00");
					result.add(map);	
				}
				
			
		}catch(Exception e){
			logger.error("error:"+e);
		}	
		
		return result;
	}
	
	public Map<String, Map<String,Object>> getDataOrigin(Object sampleType, String  ltrCodeRef){
		List<Map<String,Object>> resultList = new ArrayList<>();
		Map<String, Map<String,Object>> mapResultList = new HashMap<>();
		
		try{
			StringBuilder sql = new StringBuilder();
			sql.append(" select distinct ma.METHOD_ID as methodID, hd.LAB_CODE as labCode, p.product_ID as prductId, ia.ITEM_UNIT as itemUnit, i.ITEMMP_ID as itemMpId \n");
			sql.append(" , p.PRODUCT_NAME as productName, (case when p.product_ID ='100000001' then \n");
			sql.append(" REPLACE(ia.ITEM_NAME, 'evap.', 'recov.') \n");
			sql.append(" when p.product_ID ='100000006' then \n");
			sql.append(" REPLACE(ia.ITEM_NAME, 'evap.', 'recov.') \n");
			sql.append(" when p.product_ID ='100000007' then \n");
			sql.append(" REPLACE(ia.ITEM_NAME, 'evap.', 'recov.') \n");
			sql.append(" when p.product_ID ='100000009' then \n");
			sql.append(" REPLACE(ia.ITEM_NAME, 'evap.', 'recov.') \n");
			sql.append(" else ia.ITEM_NAME end) as itemName \n");
			sql.append(" , ma.METHOD_NAME as methodName, ta.TOOL_NAME as toolName, agi.GITEM_NAME as gitemName, agi.gitem_id as gitemId \n");
			sql.append(" , (case when (case when sp.SPEC_BASIC_TEXT = '' then (concat(concat(sp.SPEC_MIN,' - '),sp.SPEC_MAX)) else sp.SPEC_BASIC_TEXT end) ='0 - 0' then \n");
			sql.append(" ( case when ia.ITEM_ID ='0003' then REPLACE((case when sp.SPEC_BASIC_TEXT = '' then (concat(concat(sp.SPEC_MIN,' - '),sp.SPEC_MAX)) else sp.SPEC_BASIC_TEXT end), '0 - 0', '-') \n");
			sql.append(" else REPLACE((case when sp.SPEC_BASIC_TEXT = '' then (concat(concat(sp.SPEC_MIN,' - '),sp.SPEC_MAX)) else sp.SPEC_BASIC_TEXT end), '0 - 0', '0') end ) \n");
			sql.append(" else (case when sp.SPEC_BASIC_TEXT = '' then (concat(concat(sp.SPEC_MIN,' - '),sp.SPEC_MAX)) else sp.SPEC_BASIC_TEXT end) end ) as specItemBacisText \n");
			sql.append(" , sp.SPEC_MIN as specMin, sp.SPEC_MAX as specMax \n");
			sql.append(" , (case when i.STATUS = 'N' then '-' else sub.result_text end) as resultText \n");
			sql.append(" , (case when i.STATUS = 'N' then '-' else (case when sub.RESULT_TEXT = '' then convert(varchar(30),sub.RESULT_NUM) else sub.RESULT_TEXT end) end) as resultNum \n");
			sql.append(" , sp.IS_SPEC_RANGE as IS_SPEC_RANGE, hd.RESULT_LTR as resultLtr, hd.RESULT_SILVER as resultSilver, i.ITEM_ID as itemMaster, sub.RESULT_FLAG as resultFlag \n");
			sql.append(" , dt.SAMPLE_TYPE_CODE as sampleType, ran.BOAT_NO as shipmentNo \n");
			sql.append(" , (case when sub.RESULT_FLAG_UNCER = 'Y' then 'ผ่าน' \n");
			sql.append(" when sub.RESULT_FLAG_UNCER = 'U' then 'ผ่านแบบมีเงื่อนไข'  \n");
			sql.append(" when sub.RESULT_FLAG_UNCER = 'N' then 'ไม่ผ่าน'  \n");
			sql.append(" else (case when sub.RESULT_FLAG = 'Y' and  sub.RESULT_TEXT !='-' then 'ผ่าน' \n");
			sql.append(" when sub.RESULT_FLAG = 'N' then 'ไม่ผ่าน' else '-' end) end) as UNCERT \n");
			sql.append(" , (case when sub.RESULT_UNCER = 'undefined' or sub.RESULT_UNCER is NULL or sub.RESULT_UNCER = '' then '-' else sub.RESULT_UNCER end) as RESULT_UN \n");
			sql.append(" , ia.ITEM_ID as itemsId, (case when sub.RESULT_FLAG_UNCER is null then sub.RESULT_FLAG else sub.RESULT_FLAG_UNCER end) as specRang, sub.RESULT_FLAG as flg_uncer, ran.SUB_TYPE_CODE as sub_type_code, (case when hd.LTR_CODE_REF is null then '-' when hd.LTR_CODE_REF = '' then '-' else hd.LTR_CODE_REF end) as replace_new_ltr \n");
			sql.append(" from ASS_LTR_DT dt with (nolock) \n");
			sql.append(" inner join ASS_LTR_HD hd on hd.LTR_CODE = dt.LTR_CODE \n");
			sql.append(" inner join ASS_LTR_DT_USER ud with (nolock) on ud.LTR_DT_ID = dt.LTR_DT_ID \n");  
			sql.append(" inner join ASS_ITEM_SPEC_MP i with (nolock) on i.ITEMMP_ID = dt.ITEMMP_ID \n"); 
			sql.append(" inner join ASS_ITEM_SPEC_MP_METHOD m with (nolock) on m.ITEMMP_ID = dt.ITEMMP_ID \n");  
			sql.append(" inner join ASS_ITEM_SPEC_MP_TOOL t with (nolock) on t.ITEMMP_ID = dt.ITEMMP_ID \n"); 
			sql.append(" inner join ASS_ITEM_SPEC_MP_USER u with (nolock) on u.ITEMMP_ID = dt.ITEMMP_ID \n"); 
			sql.append(" inner join ASS_METHOD_MASTER ma with (nolock) on ma.METHOD_ID = dt.METHOD_ID \n"); 
			sql.append(" inner join ASS_TOOL_MASTER ta with (nolock) on ta.TOOL_ID = dt.TOOL_ID \n"); 
			sql.append(" inner join ASS_ITEM_MASTER ia with (nolock) on ia.ITEM_ID = dt.ITEM_ID \n"); 
			sql.append(" inner join USER_TYPE ut with (nolock) on ut.USER_TYPE_ID = ud.USER_TYPE_ID \n"); 
			sql.append(" inner join PRODUCT_MAINLAB p with (nolock) on p.PRODUCT_ID = i.PRODUCT_ID \n"); 
			sql.append(" inner join ASS_ITEM_SPEC_MP_SPDETAIL sp with (nolock) on sp.itemmp_id = dt.ITEMMP_ID \n"); 
			sql.append(" inner join ASS_LTR_DT_SUB sub with (nolock) on sub.ltr_dt_id = dt.LTR_DT_ID \n"); 
			sql.append(" inner join ASS_PRODUCT_GPMP apg with (nolock) on apg.PRODUCT_ID =  p.PRODUCT_ID \n"); 
			sql.append(" inner join ASS_GROUP_ITEM agi  with (nolock) on agi.GITEM_ID =  apg.GITEM_ID \n"); 
			sql.append(" inner join ASS_GROUP_ITEM_SPEC agis with (nolock) on agis.GITEM_ID = apg.GITEM_ID AND agis.ITEMMP_ID = ia.ITEM_ID \n");
			sql.append(" inner join RANDOM_SAMPLE_RESULT ran with (nolock) on ran.LAB_CODE = hd.LAB_CODE \n");
			sql.append(" where 1=1 and dt.LTR_CODE = '" + ltrCodeRef + "' order by i.ITEMMP_ID,agi.gitem_id asc \n");

			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			
			for(int i = 0 ; i < resultList.size() ; i++){
				
				String key = resultList.get(i).get("itemsId").toString().concat(resultList.get(i).get("methodID").toString());
				mapResultList.put(key, resultList.get(i));
				
				String uncert = resultList.get(i).get("UNCERT").toString();
				if("ผ่าน".equals(resultList.get(i).get("UNCERT"))
						||"ผ่านแบบมีเงื่อนไข".equals(uncert)&&("00003").equals(sampleType!=null?sampleType:"")		
						||!"0010".equals(resultList.get(i).get("itemsId").toString())&&!"0013".equals(resultList.get(i).get("itemsId").toString())&&"ผ่านแบบมีเงื่อนไข".equals(uncert)	
					
						){
							flagyO++;
						}else if("ผ่านแบบมีเงื่อนไข".equals(uncert)){
							flaguO++;
							
						}else if("ไม่ผ่าน".equals(uncert)) {
							flagnO++;
						}
			}
			
			return mapResultList;
		}catch (Exception e){
			logger.error("Exectpion : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public Map<String,Object> getDataOriginAdditive3(String ltrCodeRef, String rLABCODE, String status){
		List<Map<String,Object>> resultList = new ArrayList<>();
		Map<String,Object> mapResultList = new HashMap<>();
		
		try{
			StringBuilder sql = new StringBuilder();
			sql.append(" select * from (select ia.ITEM_ID as ITEM_ID, (case when sub.RESULT_TEXT = '' then convert(varchar,sub.RESULT_NUM) else sub.RESULT_TEXT end) as RESULT_TEST, sub.RESULT_FLAG, RESULT_LTR \n");
			sql.append(" from ASS_LTR_HD hd with(nolock) \n");
			sql.append(" inner join RANDOM_SAMPLE_RESULT ran with(nolock) on ran.LAB_CODE = hd.LAB_CODE \n");
			sql.append(" inner join PLANT p with(nolock) on p.PLANT_ID = ran.PLANT_ID \n");
			sql.append(" inner join PRODUCT_MAINLAB pro with(nolock) on pro.PRODUCT_ID = ran.PRODUCT_ID \n");
			sql.append(" inner join ASS_LTR_DT dt with(nolock) on dt.LTR_CODE = hd.LTR_CODE \n");
			sql.append(" inner join ASS_LTR_DT_SUB sub with(nolock) on sub.LTR_DT_ID = dt.LTR_DT_ID \n");
			sql.append(" inner join ASS_ITEM_MASTER ia with(nolock) on ia.ITEM_ID = dt.ITEM_ID \n");
			sql.append(" inner join ASS_WF_LTR wf with(nolock) on wf.LTR_CODE = hd.LTR_CODE \n");
			sql.append(" left join MP_USER usra with(nolock) on usra.CODEMP_ID = wf.APPROVE_BY \n");
			sql.append(" left join MP_USER usrb with(nolock) on usrb.CODEMP_ID = hd.PRINT_LTR_NAME \n");
			sql.append(" where 1=1 and wf.STATUS = '" + status + "' and hd.LTR_CODE = '" + ltrCodeRef + "' and hd.LAB_CODE = '" + rLABCODE + "') a group by a.ITEM_ID, a.RESULT_TEST, a.RESULT_FLAG, RESULT_LTR \n");
			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
			
			if("12".equals(status)) {
				for(int i = 0 ; i < resultList.size() ; i++){
					mapResultList.put(resultList.get(i).get("ITEM_ID").toString(), resultList.get(i).get("RESULT_TEST"));
				} 
			} else {
				for(int i = 0 ; i < resultList.size() ; i++){
					mapResultList.put(resultList.get(i).get("ITEM_ID").toString(), resultList.get(i).get("RESULT_FLAG"));
				}
			}
			
			for(int i = 0 ; i < resultList.size() ; i++){
				String resultLtr = resultList.get(i).get("RESULT_LTR").toString();
				
				if("Y".equals(resultLtr)){
					flagyO++;
				}else if("U".equals(resultLtr)){
					flaguO++;
				}else if("N".equals(resultLtr)) {
					flagnO++;
				}
			}
			
			System.out.println("mapResultList : {} " + mapResultList);
			
			return mapResultList;
		}catch (Exception e){
			logger.error("Exectpion : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}
	
//	public  String findHistoryCreated(String typeR) {
//		String reportBy ="";
//		List<Map<String,Object>>resultList =new ArrayList<>();
//		try {
//			StringBuilder sql = new StringBuilder();
//			sql.append("SELECT TOP(1) MU.NAMET,MU.NAMEE,MU.CODEMP_ID FROM USER_TYPE UT \n");
//			sql.append("INNER JOIN MP_USER MU ON UT.USER_TYPE_ID = MU.ROLE_ID \n");
//			sql.append("WHERE USER_TYPE_ID='0005' \n");
//			////logger.info("SQL DATA HEADER COQ: {}",sql.toString());
//			resultList = jdbcTemplateSQLSERVER.queryForList(sql.toString());
//			if(0<resultList.size()) {
//				if(typeR.equals("codemp")) {
//					reportBy = resultList.get(0).get("CODEMP_ID").toString();
//				}else {
//					reportBy = resultList.get(0).get("NAMET").toString();
//				}
//			}
//
//		}catch(Exception e) {
//			logger.error("Exception : {}");
//		}
//		return reportBy;
//	}
}