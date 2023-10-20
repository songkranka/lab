package th.co.pt.ptgapp.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.client.RestTemplate;
import th.co.pt.ptgapp.controller.bean.ActionPlanBranch;
import th.co.pt.ptgapp.controller.bean.MbStationMaster;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.utils.WebUtil;

import javax.xml.ws.http.HTTPException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActionPlanBranchDao {
    @Autowired
    private PlatformTransactionManager txManager;

    @Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public List<Map<String, Object>> inquiryActionPlanBranch(ActionPlanBranch objReq) throws Exception {


        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("inquiryActionPlanBranch");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("status", objReq.getStatus(), Types.VARCHAR)
                .addValue("tripId", objReq.getTrip_id(), Types.VARCHAR)
                .addValue("completeFlagIsnull", objReq.getComplete_flg(), Types.VARCHAR)
        		.addValue("update_flg", objReq.getUpdate_flg(), Types.VARCHAR);
        List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

        return list;
    }

    public List<Map<String, Object>> inquiryActionPlanBranchDetail(ActionPlanBranch objReq) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();




        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                .withProcedureName("inquiryActionPlanBranchDetail");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("trip_id", objReq.getTrip_id(), Types.VARCHAR);
        List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");


        return list;
    }

    public List<Map<String, Object>> inquiryActionPlanOperator(ActionPlanBranch objReq) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();

        logger.info("----- inquiryActionPlanOperator ------ ");
		logger.info(objReq.getTrip_id());
        
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                .withProcedureName("inquiryActionPlanOperator");

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("trip_id", objReq.getTrip_id(), Types.VARCHAR);

        List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

        return setNewActionPlanOperator(list);
    }

    public List<Map<String, Object>> inquiryLTR(String objReq) throws Exception{
    	Map<String,Object> result = new HashMap<String, Object>();
    	  
		logger.info("----- inquiryLTR ------ ");
		logger.info(objReq);
		  
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("inquiryLtr") ;
			SqlParameterSource in = new MapSqlParameterSource()  
			.addValue("trip_id",objReq,Types.VARCHAR)  ;
			List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
	
		 
		 
		return list;
    }

    public List<Map<String, Object>> inquiryMPTools(String objReq) throws Exception{
    	Map<String,Object> result = new HashMap<String, Object>();
    	  
		logger.info("----- inquiryMPTools ------ ");
		logger.info(objReq);
		  
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("inquiryMPTools") ;
			SqlParameterSource in = new MapSqlParameterSource()  
			.addValue("trip_id",objReq,Types.VARCHAR)  ;
			List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
	
		 
		 
		return list;
    }

    public List<Map<String, Object>> setNewActionPlanOperator(List<Map<String, Object>> list) throws Exception {

        int size = list.size();
        logger.info("----- setNewActionPlanOperator ------ "+size);
        for (int i = 0; i < size; i++) {
            Map<String, Object> map = list.get(i);
            //System.out.println("get Map Employee Before ::"+map.toString());

            try {
                MemberObj member_data = new MemberObj();
                // System.out.println(" member.codempid=="+ member.codempid);
                String uri = WebUtil.WebServiceUrl() + "HrisService/member-getmemberprofile";
                MemberObj data = new MemberObj();
                data.codempid = map.get("CODEMPID").toString();

                RestTemplate restTemplate = new RestTemplate();
                member_data = restTemplate.postForObject(uri, data, MemberObj.class);

                //System.out.println(" after.codempid=="+ member_data.codempid);
                //System.out.println(" member_data   =="+ member_data.toString());
                if(member_data.nampost != null){
                	map.put("NAMEPOST", member_data.nampost.toString());
                }else{
                	map.put("NAMEPOST", "");
                }
            } catch (Exception ex) {

                ex.printStackTrace();
                throw new HTTPException(404);
            }

            //System.out.println("get Map Employee After ::"+map.toString());
        }

        return list;
    }

    public List<Map<String, Object>> inquiryLTRSpec(ActionPlanBranch objReq) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();

        logger.info("----- inquiryLTRSpec ------ ");

        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                .withProcedureName("inquiryLTRSpec");

        List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute().get("#result-set-1");

        return list;
    }

    public List<Map<String, Object>> inquiryLabScoreSpec(ActionPlanBranch objReq) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();

        logger.info("----- inquiryLabScoreSpec ------ ");

        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                .withProcedureName("inquiryLabScoreSpec");

        List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute().get("#result-set-1");

        return list;
    }

    public List<Map<String, Object>> inquiryMBStationMaster(ActionPlanBranch objReq) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();

        logger.info("----- inquiryMBStationMaster ------ ");

        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                .withProcedureName("inquiryMBStationMaster");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("region", objReq.getRegion(), Types.VARCHAR)
                .addValue("area", objReq.getArea(), Types.VARCHAR)
                .addValue("type_station", objReq.getTypeStation(), Types.VARCHAR)
                .addValue("province", objReq.getProvince(), Types.VARCHAR);
        List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

        return list;
    }

    public Map<String, Object> updateMBStationMaster(MbStationMaster objReq) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();

        logger.info("----- updateMBStationMaster ------ ");

        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                .withProcedureName("insertStationMaster");
        SqlParameterSource in = new MapSqlParameterSource() 
				.addValue("type",objReq.getType(),Types.VARCHAR)
				.addValue("productId",objReq.getProductID(),Types.VARCHAR)
				.addValue("siteCode",objReq.getSiteCode(),Types.VARCHAR)
				.addValue("ref",objReq.getRefs(),Types.VARCHAR)
				.addValue("place",objReq.getPlace(),Types.VARCHAR)
				.addValue("plantId",objReq.getPlantID(),Types.VARCHAR)
				.addValue("costCenter",objReq.getCostCenter(),Types.VARCHAR)
				.addValue("profitCenter",objReq.getProfitCenter(),Types.VARCHAR)
				.addValue("centerName",objReq.getCenterName(),Types.VARCHAR)
				.addValue("part",objReq.getPart(),Types.VARCHAR)
				.addValue("addrTumbon",objReq.getAddrTumbon(),Types.VARCHAR)
				.addValue("addrAmphur",objReq.getAddrAmphur(),Types.VARCHAR)
				.addValue("addrProvince",objReq.getAddrProvince(),Types.VARCHAR)
				.addValue("postCode",objReq.getPostCode(),Types.VARCHAR)
				.addValue("address",objReq.getAddress(),Types.VARCHAR)
				.addValue("model",objReq.getModel(),Types.VARCHAR)
				.addValue("plantReceive",objReq.getPlantReceive(),Types.VARCHAR)
				.addValue("operatingStatus",objReq.getOperatingStatus(),Types.VARCHAR)
				.addValue("email",objReq.getEmail(),Types.VARCHAR)
				.addValue("phoneNo",objReq.getPhoneNo(),Types.VARCHAR)
				.addValue("mobileNo",objReq.getMobileNo(),Types.VARCHAR)
				.addValue("gps",objReq.getGps(),Types.VARCHAR)
				.addValue("createBy",objReq.getCreateBy(),Types.VARCHAR)
				.addValue("typeStation",objReq.getTypeStation(),Types.VARCHAR)
				.addValue("pResult",Types.VARCHAR)
				.addValue("pMessage",Types.VARCHAR);
        result = call.execute(in);	
        return result;
    }

    public ActionPlanBranch saveActionPlan(ActionPlanBranch objReq) throws Exception {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = txManager.getTransaction(def);
        ActionPlanBranch rtnObjReq = new ActionPlanBranch();
//    	TransactionDefinition def = new DefaultTransactionDefinition();
//	    TransactionStatus status = txManager.getTransaction(def);
        String result = "", msg = "", tripId = "";
        String startDateArr[] = objReq.getStartDate().split("/");
        String endDateArr[] =objReq.getEndDate().split("/");
        String startDateTxt = startDateArr[2]+"-"+startDateArr[1]+"-"+startDateArr[0];
        String endDateTxt=endDateArr[2]+"-"+endDateArr[1]+"-"+endDateArr[0];
        
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                .withProcedureName("insertActionPlan");


        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("trip_name", objReq.getTripName(), Types.VARCHAR)
                .addValue("org_code", objReq.getOrgCode(), Types.VARCHAR)
                .addValue("org_name", objReq.getOrgName(), Types.VARCHAR)
                .addValue("complete_flg", objReq.getComplete_flg(), Types.VARCHAR)
                .addValue("cnt_station", objReq.getCnt_station(), Types.VARCHAR)
                .addValue("cnt_station_perday", objReq.getCnt_station_perday(), Types.VARCHAR)
                .addValue("total_day", objReq.getTotal_day(), Types.VARCHAR)
                .addValue("allowce_amt_total", objReq.getAllowce_amt_total(), Types.VARCHAR)
                .addValue("hotel_cnt_night", objReq.getHotel_cnt_night(), Types.VARCHAR)
                .addValue("hotel_cnt_room", objReq.getHotel_cnt_room(), Types.VARCHAR)
                .addValue("hotel_amt_total", objReq.getHotel_amt_total(), Types.VARCHAR)
                .addValue("total_mile_station", objReq.getTotal_mile_station(), Types.VARCHAR)
                .addValue("oil_per_liter", objReq.getOil_per_liter(), Types.VARCHAR)
                .addValue("car_amt", objReq.getCar_amt(), Types.VARCHAR)
                .addValue("amt_other", objReq.getAmt_other(), Types.VARCHAR)
                .addValue("expense_perstation", objReq.getExpense_perstation(), Types.VARCHAR)
                .addValue("total_amount", objReq.getTotal_amount(), Types.VARCHAR)
                .addValue("createBy", objReq.getCreateBy(), Types.VARCHAR)
                .addValue("startDate",startDateTxt , Types.VARCHAR)
                .addValue("endDate",endDateTxt , Types.VARCHAR)
                .addValue("trip_id", Types.VARCHAR)
                .addValue("pResult", Types.VARCHAR)
                .addValue("pMessage", Types.VARCHAR);

        Map<String, Object> out = call.execute(in);
        result = (String) out.get("pResult");
        msg = (String) out.get("pMessage");
        tripId = (String) out.get("trip_id");
        rtnObjReq.setTrip_id(tripId);
        if (!result.equals("0")) {
            result = "0";
            msg = "";
            logger.info("----- insertActionPlanDetail ------ ");
            logger.info("----- getData_station ------ " + objReq.getData_station().size());
            SimpleJdbcCall call2 = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                    .withProcedureName("insertActionPlanDetail");
            for (int i = 0; objReq.getData_station() != null && i < objReq.getData_station().size(); i++) {
                ActionPlanBranch obj = (ActionPlanBranch) objReq.getData_station().get(i);
                //logger.info("labcode_no"+objLTE.getLabCode_No());
                //logger.info("role_id"+objLTE.getRole_id());
                //logger.info("role_mapping_id"+objLTE.getRole_mapping_id());


                in = new MapSqlParameterSource()
                        .addValue("trip_id", tripId, Types.VARCHAR)
                        .addValue("plan_date", obj.getPlandate(), Types.VARCHAR)
                        .addValue("plan_desc", obj.getPlan_desc(), Types.VARCHAR)
                        .addValue("plan_begin", obj.getPlace_begin(), Types.VARCHAR)
                        .addValue("plan_destination", obj.getPlace_destination(), Types.VARCHAR)
                        .addValue("mile_total", obj.getMile_total(), Types.VARCHAR)
                        .addValue("seq", obj.getSeq(), Types.VARCHAR)
                        .addValue("cost_center", obj.getCost_center(), Types.VARCHAR)
                        .addValue("org_code", obj.getOrgCode(), Types.VARCHAR)
                        .addValue("org_name", obj.getOrgName(), Types.VARCHAR)
                        .addValue("addr_tumbon", obj.getAddr_tumbon(), Types.VARCHAR)
                        .addValue("addr_aumphur", obj.getAddr_aumphur(), Types.VARCHAR)
                        .addValue("addr_province", obj.getAddr_province(), Types.VARCHAR)
                        .addValue("createBy", objReq.getCreateBy(), Types.VARCHAR)
                        .addValue("receive", obj.getReviceOil(), Types.VARCHAR)
                        .addValue("pResult", Types.VARCHAR)
                        .addValue("pMessage", Types.VARCHAR);

                out = call2.execute(in);
                result = (String) out.get("pResult");
                msg = (String) out.get("pMessage");

                logger.info("result" + result);
                logger.info("msg" + msg);

                if (result.equals("0")) {
                    break;
                }

            }
            if (!result.equals("0")) {
                logger.info("----- insertActionPlanStaff ------ ");
                result = "0";
                msg = "";
                SimpleJdbcCall call3 = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                        .withProcedureName("insertActionPlanStaff");
                for (int i = 0; objReq.getData_officer() != null && i < objReq.getData_officer().size(); i++) {
                    ActionPlanBranch obj = (ActionPlanBranch) objReq.getData_officer().get(i);
                    //logger.info("labcode_no"+objLTE.getLabCode_No());
                    //logger.info("role_id"+objLTE.getRole_id());
                    //logger.info("role_mapping_id"+objLTE.getRole_mapping_id());


                    in = new MapSqlParameterSource()
                            .addValue("trip_id", tripId, Types.VARCHAR)
                            .addValue("codempid", obj.getCodempid(), Types.VARCHAR)
                            .addValue("namempt", obj.getNamempt(), Types.VARCHAR)
                            .addValue("namepost", obj.getRoleId(), Types.VARCHAR)
                            .addValue("role_id", obj.getRoleIdToo(), Types.VARCHAR)

                            .addValue("createBy", objReq.getCreateBy(), Types.VARCHAR)
                            .addValue("pResult", Types.VARCHAR)
                            .addValue("pMessage", Types.VARCHAR);

                    out = call3.execute(in);
                    result = (String) out.get("pResult");
                    msg = (String) out.get("pMessage");

                    logger.info("result" + result);
                    logger.info("msg" + msg);

                    if (result.equals("0")) {
                        break;
                    }

                }
                rtnObjReq.setResult(result);
                rtnObjReq.setMessage(msg);
                if (!result.equals("0")) {

                    txManager.commit(status);
                } else {

                    txManager.rollback(status);
                }
            } else {
                txManager.rollback(status);
                rtnObjReq.setResult(result);
                rtnObjReq.setMessage(msg);
            }
        } else {
            // txManager.rollback(status);
            rtnObjReq.setResult(result);
            rtnObjReq.setMessage(msg);
        }

        //logger.info("result"+result);
        //logger.info("msg==>"+msg);
        return rtnObjReq;


    }

    public RandomOil updateActionPlan(ActionPlanBranch objReq) throws Exception {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = txManager.getTransaction(def);
        RandomOil rtnObjReq = new RandomOil();
//    	TransactionDefinition def = new DefaultTransactionDefinition();
//	    TransactionStatus status = txManager.getTransaction(def);
        logger.info("----- updateActionPlan ------ ");
        String result = "", msg = "", tripId = "";
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                .withProcedureName("updateActionPlan");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("trip_id", objReq.getTrip_id(), Types.VARCHAR)
                .addValue("trip_name", objReq.getTripName(), Types.VARCHAR)
                .addValue("org_code", objReq.getOrgCode(), Types.VARCHAR)
                .addValue("org_name", objReq.getOrgName(), Types.VARCHAR)
                .addValue("complete_flg", objReq.getComplete_flg(), Types.VARCHAR)
                .addValue("cnt_station", objReq.getCnt_station(), Types.VARCHAR)
                .addValue("cnt_station_perday", objReq.getCnt_station_perday(), Types.VARCHAR)
                .addValue("total_day", objReq.getTotal_day(), Types.VARCHAR)
                .addValue("allowce_amt_total", objReq.getAllowce_amt_total(), Types.VARCHAR)
                .addValue("hotel_cnt_night", objReq.getHotel_cnt_night(), Types.VARCHAR)
                .addValue("hotel_cnt_room", objReq.getHotel_cnt_room(), Types.VARCHAR)
                .addValue("hotel_amt_total", objReq.getHotel_amt_total(), Types.VARCHAR)
                .addValue("total_mile_station", objReq.getTotal_mile_station(), Types.VARCHAR)
                .addValue("oil_per_liter", objReq.getOil_per_liter(), Types.VARCHAR)
                .addValue("car_amt", objReq.getCar_amt(), Types.VARCHAR)
                .addValue("amt_other", objReq.getAmt_other(), Types.VARCHAR)
                .addValue("expense_perstation", objReq.getExpense_perstation(), Types.VARCHAR)
                .addValue("total_amount", objReq.getTotal_amount(), Types.VARCHAR)
                .addValue("createBy", objReq.getCreateBy(), Types.VARCHAR)
                .addValue("pResult", Types.VARCHAR)
                .addValue("pMessage", Types.VARCHAR);

        Map<String, Object> out = call.execute(in);
        result = (String) out.get("pResult");
        msg = (String) out.get("pMessage");
        if (!result.equals("0")) {
            result = "0";
            msg = "";
            call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                    .withProcedureName("deleteActionPlanDetail");
            in = new MapSqlParameterSource()
                    .addValue("trip_id", objReq.getTrip_id(), Types.VARCHAR)
                    .addValue("pResult", Types.VARCHAR)
                    .addValue("pMessage", Types.VARCHAR);

            out = call.execute(in);
            result = (String) out.get("pResult");
            msg = (String) out.get("pMessage");
            if (!result.equals("0")) {
                result = "0";
                msg = "";
                call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                        .withProcedureName("insertActionPlanDetail");
                for (int i = 0; objReq.getData_station() != null && i < objReq.getData_station().size(); i++) {
                    ActionPlanBranch obj = (ActionPlanBranch) objReq.getData_station().get(i);
                    //logger.info("labcode_no"+objLTE.getLabCode_No());
                    //logger.info("role_id"+objLTE.getRole_id());
                    //logger.info("role_mapping_id"+objLTE.getRole_mapping_id());
                    in = new MapSqlParameterSource()
                            .addValue("trip_id", objReq.getTrip_id(), Types.VARCHAR)
                            .addValue("plan_date", obj.getPlandate(), Types.VARCHAR)
                            .addValue("plan_desc", obj.getPlan_desc(), Types.VARCHAR)
                            .addValue("plan_begin", obj.getPlace_begin(), Types.VARCHAR)
                            .addValue("plan_destination", obj.getPlace_destination(), Types.VARCHAR)
                            .addValue("mile_total", obj.getMile_total(), Types.VARCHAR)
                            .addValue("seq", obj.getSeq(), Types.VARCHAR)
                            .addValue("cost_center", obj.getCost_center(), Types.VARCHAR)
                            .addValue("org_code", obj.getOrgCode(), Types.VARCHAR)
                            .addValue("org_name", obj.getOrgName(), Types.VARCHAR)
                            .addValue("addr_tumbon", obj.getAddr_tumbon(), Types.VARCHAR)
                            .addValue("addr_aumphur", obj.getAddr_aumphur(), Types.VARCHAR)
                            .addValue("addr_province", obj.getAddr_province(), Types.VARCHAR)
                            .addValue("createBy", objReq.getCreateBy(), Types.VARCHAR)
                            .addValue("receive", obj.getReviceOil(), Types.VARCHAR)
                            .addValue("pResult", Types.VARCHAR)
                            .addValue("pMessage", Types.VARCHAR);

                    out = call.execute(in);
                    result = (String) out.get("pResult");
                    msg = (String) out.get("pMessage");

                    logger.info("result" + result);
                    logger.info("msg" + msg);

                    if (result.equals("0")) {
                        break;
                    }

                }
                if (!result.equals("0")) {
                    result = "0";
                    msg = "";
                    call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                            .withProcedureName("deleteActionPlanStaff");
                    in = new MapSqlParameterSource()
                            .addValue("trip_id", objReq.getTrip_id(), Types.VARCHAR)
                            .addValue("pResult", Types.VARCHAR)
                            .addValue("pMessage", Types.VARCHAR);

                    out = call.execute(in);
                    result = (String) out.get("pResult");
                    msg = (String) out.get("pMessage");
                    if (!result.equals("0")) {
                        result = "0";
                        msg = "";
                        call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                                .withProcedureName("insertActionPlanStaff");
                        for (int i = 0; objReq.getData_officer() != null && i < objReq.getData_officer().size(); i++) {
                            ActionPlanBranch obj = (ActionPlanBranch) objReq.getData_officer().get(i);
                            //logger.info("labcode_no"+objLTE.getLabCode_No());
                            //logger.info("role_id"+objLTE.getRole_id());
                            //logger.info("role_mapping_id"+objLTE.getRole_mapping_id());
                            in = new MapSqlParameterSource()
                                    .addValue("trip_id", objReq.getTrip_id(), Types.VARCHAR)
                                    .addValue("codempid", obj.getCodempid(), Types.VARCHAR)
                                    .addValue("namempt", obj.getNamempt(), Types.VARCHAR)
                                    .addValue("namepost", obj.getRoleId(), Types.VARCHAR)
                                    .addValue("role_id", obj.getRoleIdToo(), Types.VARCHAR)

                                    .addValue("createBy", objReq.getCreateBy(), Types.VARCHAR)
                                    .addValue("pResult", Types.VARCHAR)
                                    .addValue("pMessage", Types.VARCHAR);

                            out = call.execute(in);
                            result = (String) out.get("pResult");
                            msg = (String) out.get("pMessage");

                            logger.info("result" + result);
                            logger.info("msg" + msg);

                            if (result.equals("0")) {
                                break;
                            }

                        }
                        rtnObjReq.setResult(result);
                        rtnObjReq.setMessage(msg);
                        if (!result.equals("0")) {

                            txManager.commit(status);
                        } else {

                            txManager.rollback(status);
                        }//end insertActionPlanStaff
                    } else {
                        txManager.rollback(status);
                        rtnObjReq.setResult(result);
                        rtnObjReq.setMessage(msg);
                    }//deleteActionPlanStaff
                } else {
                    txManager.rollback(status);
                    rtnObjReq.setResult(result);
                    rtnObjReq.setMessage(msg);
                }//insertActionPlanDetail

            } else {
                txManager.rollback(status);
                rtnObjReq.setResult(result);
                rtnObjReq.setMessage(msg);
            }    //deleteActionPlanDetail
        } else {
            txManager.rollback(status);
            rtnObjReq.setResult(result);
            rtnObjReq.setMessage(msg);
        }

        //logger.info("result"+result);
        //logger.info("msg==>"+msg);
        return rtnObjReq;

    }

    public void updateStatusActionPlan(ActionPlanBranch objReq) throws Exception {

        //StringBuffer sql = new StringBuffer();
        logger.info("----- updateStatusActionPlan ------ ");

        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                .withProcedureName("updateStatusActionPlan");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("trip_id", objReq.getTrip_id(), Types.VARCHAR)
                .addValue("status", objReq.getStatus(), Types.VARCHAR)
                .addValue("createBy", objReq.getCreateBy(), Types.VARCHAR)
                .addValue("pResult", Types.VARCHAR)
                .addValue("pMessage", Types.VARCHAR);


        Map<String, Object> out = call.execute(in);
        String result = (String) out.get("pResult");
        String msg = (String) out.get("pMessage");

        objReq.setResult(result);
        objReq.setMessage(msg);


    }

    public RandomOil syncReceiveLTR(Map<String, Object> mapObj) throws Exception {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = txManager.getTransaction(def);
        RandomOil rtnObjReq = new RandomOil();
        String createBy = null;
        String result = "0", msg = "", ltr_hd_id = "";

        List<Map<String, Object>> listObj = (List<Map<String, Object>>) mapObj.get("data_planing");
        for (Map<String, Object> map : listObj) {
            String value = (String) map.get("COMPLETE_FLG");
            String TRIP_ID = (String) map.get("TRIP_ID");
		    String  update_flg_val = (String)map.get("UPDATE_FLG");

            if (value != null && !value.equalsIgnoreCase("null") && !value.trim().equalsIgnoreCase("") && !value.trim().equalsIgnoreCase("-")) {
                logger.info("----- pass data_planing in loop------ ");
                SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                        .withProcedureName("updateCompleteFlgActionPlan");
                SqlParameterSource in = new MapSqlParameterSource()
                        .addValue("trip_id", TRIP_ID, Types.VARCHAR)
                        .addValue("completeFlg", value, Types.VARCHAR)
  					  	.addValue("updateFlg",update_flg_val,Types.VARCHAR) 
                        .addValue("createBy", (String) map.get("CREATE_BY"), Types.VARCHAR)
                        .addValue("pResult", Types.VARCHAR)
                        .addValue("pMessage", Types.VARCHAR);
                Map<String, Object> out = call.execute(in);
                result = (String) out.get("pResult");
                msg = (String) out.get("pMessage");
                createBy = (String) map.get("CREATE_BY");
            }

            if (result.equals("0")) {
                break;
            }

            List<Map<String, Object>> listdata_station = (List<Map<String, Object>>) map.get("data_station");
            for (Map<String, Object> mapStation : listdata_station) {
                logger.info("----- pass data_station ------ ");
                result = "0";
                msg = "";

                SimpleJdbcCall callUP = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                        .withProcedureName("updateActionPlanDT");
                SqlParameterSource inUP = new MapSqlParameterSource()
                        .addValue("plan_dt_id", (String) mapStation.get("PLAN_DT_ID"), Types.VARCHAR)
                        .addValue("namesignature", (String) mapStation.get("NAMESIGNATURE"), Types.VARCHAR)
                        .addValue("positionsignature", (String) mapStation.get("POSITIONSIGNATURE"), Types.VARCHAR)
                        .addValue("imgpartsignature", (String) mapStation.get("IMAGESSIGNATURE"), Types.VARCHAR)
                        .addValue("codempidsignature", (String) mapStation.get("CODEMPIDSIGNATURE"), Types.VARCHAR)
                        .addValue("createBy", createBy, Types.VARCHAR)
                        .addValue("pResult", Types.VARCHAR)
                        .addValue("pMessage", Types.VARCHAR);
                Map<String, Object> outUP = callUP.execute(inUP);


                SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                        .withProcedureName("deleteMBLABMPTOOLS");
                SqlParameterSource in = new MapSqlParameterSource()
                        .addValue("plan_dt_id", (String) mapStation.get("PLAN_DT_ID"), Types.VARCHAR)
                        .addValue("pResult", Types.VARCHAR)
                        .addValue("pMessage", Types.VARCHAR);
                Map<String, Object> out = call.execute(in);
                result = (String) out.get("pResult");
                msg = (String) out.get("pMessage");

                if (!result.equals("0")) {
                    List<Map<String, Object>> listmpTools = (List<Map<String, Object>>) mapStation.get("DATA_MPTOOLS");
                    for (Map<String, Object> mapTools : listmpTools) {
                        result = "0";
                        msg = "";
                        call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                                .withProcedureName("insertMBLABMPTOOLS");
                        logger.info("----- pass insertMBLABMPTOOLS ------ ");
                        in = new MapSqlParameterSource()
                                .addValue("plan_dt_id", (String) mapStation.get("PLAN_DT_ID"), Types.VARCHAR)
                                .addValue("tools_code", (String) mapTools.get("TOOLS_CODE"), Types.VARCHAR)
                                .addValue("tools_name", (String) mapTools.get("TOOLS_NAME"), Types.VARCHAR)
                                .addValue("check_flg", (String) mapTools.get("CHECK_FLG"), Types.VARCHAR)
                                .addValue("remark", (String) mapTools.get("REMARK"), Types.VARCHAR)
                                .addValue("createBy", (String) mapTools.get("CREATE_BY"), Types.VARCHAR)


                                .addValue("pResult", Types.VARCHAR)
                                .addValue("pMessage", Types.VARCHAR);

                        out = call.execute(in);
                        result = (String) out.get("pResult");
                        msg = (String) out.get("pMessage");
                        // logger.info("----- insertMBLABMPTOOLS result ------ "+result);
                        // logger.info("----- insertMBLABMPTOOLS msg ------ "+msg);
                        //logger.info("result"+result);
                        //	logger.info("msg"+msg);

                        if (result.equals("0")) {
                            break;
                        }
                    }
                }
                if (result.equals("0")) {
                    break;
                }
                call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                        .withProcedureName("deleteMBLABCHECK");
                in = new MapSqlParameterSource()
                        .addValue("plan_dt_id", (String) mapStation.get("PLAN_DT_ID"), Types.VARCHAR)
                        .addValue("pResult", Types.VARCHAR)
                        .addValue("pMessage", Types.VARCHAR);
                out = call.execute(in);
                result = (String) out.get("pResult");
                msg = (String) out.get("pMessage");

                if (!result.equals("0")) {

                    result = "0";
                    msg = "";
                    call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                            .withProcedureName("insertMBLABCHECK");
                    logger.info("----- pass insertMBLABCHECK ------ ");
                    if(mapStation.get("CHECK_LITER_DATE") != null && !mapStation.get("CHECK_LITER_DATE").equals("")){

                        logger.info((String) mapStation.get("CHECK_LITER_DATE"));
                    	String[] chk_liter_date = mapStation.get("CHECK_LITER_DATE").toString().split("-",3);
                    	if(chk_liter_date.length ==3){
	                    	if(Integer.parseInt(chk_liter_date[1]) > 12){
	                        	mapStation.put("CHECK_LITER_DATE", chk_liter_date[1]+"-"+chk_liter_date[2]+"-"+chk_liter_date[0]);
	                        }else{
	                            mapStation.put("CHECK_LITER_DATE", chk_liter_date[2]+"-"+chk_liter_date[1]+"-"+chk_liter_date[0]);
	                        }
                    	}else{
                    		chk_liter_date = mapStation.get("CHECK_LITER_DATE").toString().split("/",3);
                    		mapStation.put("CHECK_LITER_DATE", chk_liter_date[0]+"-"+chk_liter_date[1]+"-"+chk_liter_date[2]);
                    	}
                    }
                    
                    if(mapStation.get("WM_DATE") != null && !mapStation.get("WM_DATE").equals("")){

                        String[] chk_wm_date = mapStation.get("WM_DATE").toString().split("-",3);
                        if(chk_wm_date.length ==3){
	                    	if(Integer.parseInt(chk_wm_date[1]) > 12){
	                        	mapStation.put("WM_DATE", chk_wm_date[1]+"-"+chk_wm_date[2]+"-"+chk_wm_date[0]);
	                        }else{
	                            mapStation.put("WM_DATE", chk_wm_date[2]+"-"+chk_wm_date[1]+"-"+chk_wm_date[0]);
	                        }
                    	}else{
                    		chk_wm_date = mapStation.get("WM_DATE").toString().split("/",3);
                    		mapStation.put("WM_DATE", chk_wm_date[0]+"-"+chk_wm_date[1]+"-"+chk_wm_date[2]);
                    	}
                    }
                    
                    if(mapStation.get("WM_NEXT_DATE") != null && !mapStation.get("WM_NEXT_DATE").equals("")){

                        String[] chk_wm_next_date = mapStation.get("WM_NEXT_DATE").toString().split("-",3);
                        if(chk_wm_next_date.length ==3){
	                    	if(Integer.parseInt(chk_wm_next_date[1]) > 12){
	                        	mapStation.put("WM_NEXT_DATE", chk_wm_next_date[1]+"-"+chk_wm_next_date[2]+"-"+chk_wm_next_date[0]);
	                        }else{
	                            mapStation.put("WM_NEXT_DATE", chk_wm_next_date[2]+"-"+chk_wm_next_date[1]+"-"+chk_wm_next_date[0]);
	                        }
                    	}else{
                    		chk_wm_next_date = mapStation.get("WM_NEXT_DATE").toString().split("/",3);
                    		mapStation.put("WM_NEXT_DATE", chk_wm_next_date[0]+"-"+chk_wm_next_date[1]+"-"+chk_wm_next_date[2]);
                    	}
                    }
                    
                    if(mapStation.get("TIME_CHECK") != null && !mapStation.get("TIME_CHECK").equals("")){

                        String[] chk_time_check = mapStation.get("TIME_CHECK").toString().split("T",2);
                        if(chk_time_check.length ==2){
                        	mapStation.put("TIME_CHECK", chk_time_check[1].substring(0,5));
                    	}
                    }
                    
                    in = new MapSqlParameterSource()
                            .addValue("plan_dt_id", (String) mapStation.get("PLAN_DT_ID"), Types.VARCHAR)
                            .addValue("codempid", (String) mapStation.get("CODEMPID"), Types.VARCHAR)
                            .addValue("namempt", (String) mapStation.get("NAMEMPT"), Types.VARCHAR)
                            .addValue("codpos", (String) mapStation.get("CODPOS"), Types.VARCHAR)
                            .addValue("namepost", (String) mapStation.get("NAMEPOST"), Types.VARCHAR)

                            .addValue("check_liter_org", (String) mapStation.get("CHECK_LITER_ORG"), Types.VARCHAR)
                            .addValue("check_liter_date", (String) mapStation.get("CHECK_LITER_DATE"), Types.VARCHAR)
                            .addValue("check_liter_refer", (String) mapStation.get("CHECK_LITER_REFER"), Types.VARCHAR)

                            .addValue("wm_date", (String) mapStation.get("WM_DATE"), Types.VARCHAR)
                            .addValue("wm_next_date", (String) mapStation.get("WM_NEXT_DATE"), Types.VARCHAR)
                            .addValue("wm_refer", (String) mapStation.get("WM_REFER"), Types.VARCHAR)

                            .addValue("remark", (String) mapStation.get("REMARK"), Types.VARCHAR)
                            .addValue("time_check", (String) mapStation.get("TIME_CHECK"), Types.VARCHAR)
                            .addValue("lab_check_comp", (String) mapStation.get("LAB_CHECK_COMP"), Types.VARCHAR)

                            .addValue("createBy", (String) mapStation.get("CREATE_BY"), Types.VARCHAR)
                            .addValue("pResult", Types.VARCHAR)
                            .addValue("pMessage", Types.VARCHAR);
                    logger.info("  CHECK_LITER_DATE---> " + (String) mapStation.get("CHECK_LITER_DATE"));
                    logger.info("  WM_NEXT_DATE---> " + (String) mapStation.get("WM_NEXT_DATE"));
                    logger.info("  WM_DATE---> " + (String) mapStation.get("WM_DATE"));
                    logger.info("  time_check---> " + (String) mapStation.get("TIME_CHECK"));
                    out = call.execute(in);
                    result = (String) out.get("pResult");
                    msg = (String) out.get("pMessage");

                    //logger.info("result"+result);
                    //	logger.info("msg"+msg);
                    logger.info("----- insertMBLABCHECK result ------ " + result);
                    logger.info("----- insertMBLABCHECK msg ------ " + msg);
                    if (result.equals("0")) {
                        break;
                    }

                }
                if (result.equals("0")) {
                    break;
                }
                call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                        .withProcedureName("deleteMBLABSCORE");
                in = new MapSqlParameterSource()
                        .addValue("plan_dt_id", (String) mapStation.get("PLAN_DT_ID"), Types.VARCHAR)
                        .addValue("pResult", Types.VARCHAR)
                        .addValue("pMessage", Types.VARCHAR);
                out = call.execute(in);
                result = (String) out.get("pResult");
                msg = (String) out.get("pMessage");

                if (!result.equals("0")) {

                    result = "0";
                    msg = "";
                    call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                            .withProcedureName("insertMBLABSCORE");
                    logger.info("----- pass insertMBLABSCORE ------ ");
                    logger.info("----- TYPENOTRAND ------ " + mapStation.get("TYPENOTRAND").toString());
                    
                    if(mapStation.containsKey("API") && mapStation.containsKey("GENERAL") && mapStation.containsKey("ETHANOL")){
                    	
                    	if(mapStation.get("API").toString().equals("")){
                    		mapStation.put("API", null);
                    	}
                    	
                    	if(mapStation.get("GENERAL").toString().equals("")){
                    		mapStation.put("GENERAL", null);
                    	}
                    	
                    	if(mapStation.get("ETHANOL").toString().equals("")){
                    		mapStation.put("ETHANOL", null);
                    	}
                    }
                    
                    in = new MapSqlParameterSource()
                            .addValue("plan_dt_id", (String) mapStation.get("PLAN_DT_ID"), Types.VARCHAR)
                            .addValue("general", (String) mapStation.get("GENERAL"), Types.VARCHAR)
                            .addValue("api", (String) mapStation.get("API"), Types.VARCHAR)
                            .addValue("ethanol", (String) mapStation.get("ETHANOL"), Types.VARCHAR)
                            .addValue("nametrand", (String) mapStation.get("NAMETRAND"), Types.VARCHAR)
                            .addValue("typenotrand", mapStation.get("TYPENOTRAND").toString(), Types.VARCHAR)
                            .addValue("createBy", (String) mapStation.get("CREATE_BY"), Types.VARCHAR)
                            .addValue("pResult", Types.VARCHAR)
                            .addValue("pMessage", Types.VARCHAR);

                    out = call.execute(in);
                    result = (String) out.get("pResult");
                    msg = (String) out.get("pMessage");

                    //logger.info("result"+result);
                    //	logger.info("msg"+msg);
                    logger.info("----- insertMBLABSCORE result ------ " + result);
                    logger.info("----- insertMBLABSCORE msg ------ " + msg);
                    if (result.equals("0")) {
                        break;
                    }

                }
                if (result.equals("0")) {
                    break;
                }
                if (mapStation.get("data_ltr") != null && !mapStation.get("data_ltr").equals("")) {
                    List<Map<String, Object>> listltr = (List<Map<String, Object>>) mapStation.get("data_ltr");
                    for (Map<String, Object> mapLtr : listltr) {


                        logger.info("----- pass DATA_LTR ------ ");
                        logger.info("----- plan_dt_id ------ " + (String) mapStation.get("PLAN_DT_ID"));
                        logger.info("----- product_id ------ " + (String) mapLtr.get("PRODUCT_ID"));
                        if (mapLtr.get("PRODUCT_ID") == null) {
                            continue;
                        }
                        call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                                .withProcedureName("inquiryltr_hd_id");
                        in = new MapSqlParameterSource()
                                .addValue("plan_dt_id", (String) mapStation.get("PLAN_DT_ID"), Types.VARCHAR)
                                .addValue("product_id", (String) mapLtr.get("PRODUCT_ID"), Types.VARCHAR)
                                .addValue("ltr_hd_id", Types.VARCHAR)
                                .addValue("pResult", Types.VARCHAR)
                                .addValue("pMessage", Types.VARCHAR);

                        out = call.execute(in);
                        result = (String) out.get("pResult");
                        msg = (String) out.get("pMessage");
                        ltr_hd_id = (String) out.get("ltr_hd_id");
                        logger.info("----- pass ltr_hd_id ------ " + ltr_hd_id);
                        //logger.info("-----  result ------ "+result);
                        // logger.info("-----  msg ------ "+msg);

                        if (ltr_hd_id == null || ltr_hd_id.equals("") || ltr_hd_id.equals("12")) {
                            logger.info("----- pass insertMBLTRHD ------ ");
                            call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                                    .withProcedureName("insertMBLTRHD");
                            in = new MapSqlParameterSource()
                                    .addValue("plan_dt_id", (String) mapStation.get("PLAN_DT_ID"), Types.VARCHAR)
                                    .addValue("product_id", (String) mapLtr.get("PRODUCT_ID"), Types.VARCHAR)
                                    .addValue("result", (String) mapLtr.get("RESULT"), Types.VARCHAR)
                                    .addValue("sticker_no", (String) mapLtr.get("STICKER_NO"), Types.VARCHAR)
                                    .addValue("createBy", (String) mapLtr.get("CREATE_BY"), Types.VARCHAR)
                                    .addValue("ltr_hd_id", Types.VARCHAR)
                                    .addValue("pResult", Types.VARCHAR)
                                    .addValue("pMessage", Types.VARCHAR);

                            out = call.execute(in);
                            result = (String) out.get("pResult");
                            msg = (String) out.get("pMessage");
                            ltr_hd_id = (String) out.get("ltr_hd_id");
                            logger.info("----- pass after insertMBLTRHD  result------ " + result);
                            logger.info("----- pass after insertMBLTRHD ------ " + ltr_hd_id);
                        } else {
                            logger.info("----- pass updateMBLTRHD ------ ");
                            call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                                    .withProcedureName("updateMBLTRHD");
                            in = new MapSqlParameterSource()
                                    .addValue("ltr_hd_id", ltr_hd_id, Types.VARCHAR)
                                    .addValue("plan_dt_id", (String) mapStation.get("PLAN_DT_ID"), Types.VARCHAR)
                                    .addValue("product_id", (String) mapLtr.get("PRODUCT_ID"), Types.VARCHAR)
                                    .addValue("result", (String) mapLtr.get("RESULT"), Types.VARCHAR)
                                    .addValue("sticker_no", (String) mapLtr.get("STICKER_NO"), Types.VARCHAR)
                                    .addValue("createBy", (String) mapLtr.get("CREATE_BY"), Types.VARCHAR)
                                    .addValue("pResult", Types.VARCHAR)
                                    .addValue("pMessage", Types.VARCHAR);

                            out = call.execute(in);
                            result = (String) out.get("pResult");
                            msg = (String) out.get("pMessage");

                            logger.info("----- pass after updateMBLTRHD  result------ " + result);
                            logger.info("----- pass after updateMBLTRHD  msg------ " + msg);
                        }

                        if (!result.equals("0")) {
                            logger.info("----- pass before deleteMBLTRDT  result------ " + result);
                            logger.info("----- pass deleteMBLTRDT ------ ");
                            result = "0";
                            msg = "";
                            call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                                    .withProcedureName("deleteMBLTRDT");
                            in = new MapSqlParameterSource()
                                    .addValue("ltr_hd_id", ltr_hd_id, Types.VARCHAR)
                                    .addValue("pResult", Types.VARCHAR)
                                    .addValue("pMessage", Types.VARCHAR);
                            out = call.execute(in);
                            result = (String) out.get("pResult");
                            msg = (String) out.get("pMessage");
                            logger.info("----- pass after deleteMBLTRDT  result------ " + result);
                            logger.info("----- pass after deleteMBLTRDT  msg------ " + msg);
                            if (!result.equals("0")) {
                                result = "0";
                                msg = "";
                                

                                if(mapLtr.containsKey("API")){
                                	if(mapLtr.get("API").toString().equals("") || mapLtr.get("API").toString().equals("-")){
                                		mapLtr.put("API", null);
                                	}
                                }
                                if(mapLtr.containsKey("TEMP")){
                                	if(mapLtr.get("TEMP").toString().equals("") || mapLtr.get("TEMP").toString().equals("-")){
                                		mapLtr.put("TEMP", null);
                                	}
                                }
                                if(mapLtr.containsKey("BOIL")){
                                	if(mapLtr.get("BOIL").toString().equals("") || mapLtr.get("BOIL").toString().equals("-")){
                                		mapLtr.put("BOIL", null);
                                	}
                                }
                                if(mapLtr.containsKey("WASTE_OIL")){
                                	if(mapLtr.get("WASTE_OIL").toString().equals("") || mapLtr.get("WASTE_OIL").toString().equals("-")){
                                		mapLtr.put("WASTE_OIL", null);
                                	}
                                }
                                if(mapLtr.containsKey("ETHANOL")){
                                	if(mapLtr.get("ETHANOL").toString().equals("") || mapLtr.get("ETHANOL").toString().equals("-")){
                                		mapLtr.put("ETHANOL", null);
                                	}
                                }
                                if(mapLtr.containsKey("FLASH_POINT")){
                                	if(mapLtr.get("FLASH_POINT").toString().equals("") || mapLtr.get("FLASH_POINT").toString().equals("-")){
                                		mapLtr.put("FLASH_POINT", null);
                                	}
                                }
                                if(mapLtr.containsKey("BIODIESEL")){
                                	if(mapLtr.get("BIODIESEL").toString().equals("") || mapLtr.get("BIODIESEL").toString().equals("-")){
                                		mapLtr.put("BIODIESEL", null);
                                	}
                                }
                                if(mapLtr.containsKey("CETANE")){
                                	if(mapLtr.get("CETANE").toString().equals("") || mapLtr.get("CETANE").toString().equals("-")){
                                		mapLtr.put("CETANE", null);
                                	}
                                }
                                if(mapLtr.containsKey("RON")){
                                	if(mapLtr.get("RON").toString().equals("") || mapLtr.get("RON").toString().equals("-")){
                                		mapLtr.put("RON", null);
                                	}
                                }
                                if(mapLtr.containsKey("MON")){
                                	if(mapLtr.get("MON").toString().equals("") || mapLtr.get("MON").toString().equals("-")){
                                		mapLtr.put("MON", null);
                                	}
                                }
                                
                                call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                                        .withProcedureName("insertMBLTRDT");
                                logger.info("----- pass insertMBLTRDT ------ ");
                                in = new MapSqlParameterSource()
                                        .addValue("ltr_hd_id", ltr_hd_id, Types.VARCHAR)
                                        .addValue("dispenser", (String) mapLtr.get("DISPENSER"), Types.VARCHAR)
                                        .addValue("sn", (String) mapLtr.get("SN"), Types.VARCHAR)
                                        .addValue("slot_number", new WebUtil().isEmpty((String) mapLtr.get("SLOT_NUMBER")), Types.VARCHAR)
                                        .addValue("meter_total", new WebUtil().isEmpty((String) mapLtr.get("METER_TOTAL")), Types.VARCHAR)
                                        .addValue("feature", (String) mapLtr.get("FEATURE"), Types.VARCHAR)
                                        .addValue("color", (String) mapLtr.get("COLOR"), Types.VARCHAR)
                                        .addValue("color_desc", (String) mapLtr.get("COLOR_DESC"), Types.VARCHAR)
                                        .addValue("api", (String) mapLtr.get("API"), Types.VARCHAR)
                                        .addValue("temp",(String) mapLtr.get("TEMP"), Types.VARCHAR)
                                        .addValue("api_60", new WebUtil().isEmpty((String) mapLtr.get("API_60")), Types.VARCHAR)
                                        .addValue("distill", new WebUtil().isEmpty((String) mapLtr.get("DISTILL")), Types.VARCHAR)
                                        .addValue("evaporation_10", new WebUtil().isEmpty((String) mapLtr.get("EVAPORATION_10")), Types.VARCHAR)
                                        .addValue("evaporation_50", new WebUtil().isEmpty((String) mapLtr.get("EVAPORATION_50")), Types.VARCHAR)

                                        .addValue("evaporation_90", new WebUtil().isEmpty((String) mapLtr.get("EVAPORATION_90")), Types.VARCHAR)
                                        .addValue("boil",(String) mapLtr.get("BOIL"), Types.VARCHAR)
                                        .addValue("waste_oil", (String) mapLtr.get("WASTE_OIL"), Types.VARCHAR)

                                        .addValue("ethanol", (String) mapLtr.get("ETHANOL"), Types.VARCHAR)
                                        .addValue("flash_point", (String) mapLtr.get("FLASH_POINT"), Types.VARCHAR)
                                        .addValue("biodiesel", (String) mapLtr.get("BIODIESEL"), Types.VARCHAR)
                                        .addValue("cetane", (String) mapLtr.get("CETANE"), Types.VARCHAR)
                                        .addValue("ron", (String) mapLtr.get("RON"), Types.VARCHAR)
                                        .addValue("mon", (String) mapLtr.get("MON"), Types.VARCHAR)
                                        .addValue("sequented", mapLtr.get("SEQUENTED"), Types.INTEGER)
                                        .addValue("createBy", (String) mapLtr.get("CREATE_BY"), Types.VARCHAR)
                                        .addValue("pResult", Types.VARCHAR)
                                        .addValue("pMessage", Types.VARCHAR);
                                if ((String) mapLtr.get("RON") == null || ((String) mapLtr.get("RON")).equals("null")) {
                                    logger.info("-----is null ------");
                                }
																			 /* if((String)mapLtr.get("ETHANOL")==null||((String)mapLtr.get("ETHANOL")).equals("")){
																			    	 logger.info("-----ETHANOL is ------"+mapLtr.get("ETHANOL"));
																			    }else{
																			    	 logger.info("-----not is empty ------");
																			    }*/
                                logger.info("-----ltr_hd_id ------" + ltr_hd_id);
                                logger.info("-----DISPENSER ------" + (String) mapLtr.get("DISPENSER"));
                                logger.info("-----SN ------" + (String) mapLtr.get("SN"));
                                logger.info("-----SLOT_NUMBER ------" + (String) mapLtr.get("SLOT_NUMBER"));
                                logger.info("-----METER_TOTAL ------" + (String) mapLtr.get("METER_TOTAL"));
                                logger.info("-----FEATURE ------" + (String) mapLtr.get("FEATURE"));
                                logger.info("-----COLOR ------" + (String) mapLtr.get("COLOR"));
                                logger.info("-----COLOR DESC------" + (String) mapLtr.get("COLOR_DESC"));
                                logger.info("-----API ------" + (String) mapLtr.get("API"));
                                logger.info("-----TEMP ------" + (String) mapLtr.get("TEMP"));
                                logger.info("-----API_60 ------" + (String) mapLtr.get("API_60"));
                                logger.info("-----DISTILL ------" + (String) mapLtr.get("DISTILL"));
                                logger.info("-----EVAPORATION_10 ------" + (String) mapLtr.get("EVAPORATION_10"));
                                logger.info("-----EVAPORATION_50 ------" + (String) mapLtr.get("EVAPORATION_50"));
                                logger.info("-----EVAPORATION_90 ------" + (String) mapLtr.get("EVAPORATION_90"));

                                logger.info("-----BOIL ------" + (String) mapLtr.get("BOIL"));
                                logger.info("-----WASTE_OIL ------" + (String) mapLtr.get("WASTE_OIL"));
                                logger.info("-----ETHANOL ------" + mapLtr.get("ETHANOL"));


                                logger.info("-----FLASH_POINT ------" + (String) mapLtr.get("FLASH_POINT"));
                                logger.info("-----BIODIESEL ------" + (String) mapLtr.get("BIODIESEL"));
                                logger.info("-----CETANE ------" + (String) mapLtr.get("CETANE"));

                                logger.info("-----RON ------" + (String) mapLtr.get("RON"));
                                logger.info("-----MON ------" + (String) mapLtr.get("MON"));
                                out = call.execute(in);
                                result = (String) out.get("pResult");
                                msg = (String) out.get("pMessage");

                                //logger.info("result"+result);
                                //	logger.info("msg"+msg);
                                logger.info("----- pass after insertMBLTRDT  result------ " + result);
                                logger.info("----- pass after insertMBLTRDT  msg------ " + msg);
                                if (result.equals("0")) {
                                    break;
                                }

                            }

                        }
                        if (result.equals("0")) {
                            break;
                        }
                    }
                    if (result.equals("0")) {
                        break;
                    }
                }
                //logger.info("result"+result);
                //logger.info("msg==>"+msg);

            }
            logger.info("----- pass Listdata Station close ------ ");
            if (result.equals("0")) {
                break;
            }
        }//end list
        if (!result.equals("0")) {
            msg = "";
            txManager.commit(status);
        } else {
            logger.info("msg==>" + msg);
            txManager.rollback(status);
        }
        rtnObjReq.setResult(result);
        rtnObjReq.setMessage(msg);
        return rtnObjReq;
    }

    public RandomOil syncReceiveUpdateStatus(Map<String, Object> mapObj) throws Exception {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = txManager.getTransaction(def);
        RandomOil rtnObjReq = new RandomOil();
        String result = "0", msg = "", ltr_hd_id = "";
        logger.info("----- syncReceiveLTR ------ ");

        List<Map<String, Object>> listObj = (List<Map<String, Object>>) mapObj.get("data_planing");
        for (Map<String, Object> map : listObj) {
            String TRIP_ID = (String) map.get("TRIP_ID");
            String create_by = (String) map.get("CREATE_BY");
            ActionPlanBranch objReq = new ActionPlanBranch();
            objReq.setTrip_id(TRIP_ID);
            objReq.setStatus("2");
            objReq.setCreate_by(create_by);
            updateStatusActionPlan(objReq);

            if (objReq.getMessage() != null && objReq.getMessage().equals("")) {
                msg += "TRIP_ID:" + objReq.getMessage();

                break;
            }
            result = objReq.getResult();
        }//end list
        if (!result.equals("0")) {

            txManager.commit(status);
        } else {
            logger.info("msg==>" + msg);
            txManager.rollback(status);
        }
        rtnObjReq.setResult(result);
        rtnObjReq.setMessage(msg);
        return rtnObjReq;
    }
}
