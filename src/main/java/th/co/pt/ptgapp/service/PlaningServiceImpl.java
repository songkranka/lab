package th.co.pt.ptgapp.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import th.co.pt.ptgapp.controller.bean.ActionPlanBranch;
import th.co.pt.ptgapp.controller.bean.MbStationMaster;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.ResultObj;
import th.co.pt.ptgapp.dao.ActionPlanBranchDao;
import th.co.pt.ptgapp.dao.MenuDao;
import th.co.pt.ptgapp.dao.RandomOilDao;


@Service("PlaningService")
public class PlaningServiceImpl implements PlaningService {

    @Autowired
    private ActionPlanBranchDao actionPlanBranchDao;

    @Override
    public List<Map<String, Object>> inquiryActionPlanBranch(ActionPlanBranch objReq) throws Exception {


        List<Map<String, Object>> recList = actionPlanBranchDao.inquiryActionPlanBranch(objReq);
        for (Map<String, Object> map : recList) {


            objReq.setTrip_id((String) map.get("trip_id"));
            
            List<Map<String, Object>>  listLtr =	actionPlanBranchDao.inquiryLTR((String) map.get("trip_id"));

			List<Map<String, Object>>  listMpTools =	actionPlanBranchDao.inquiryMPTools((String) map.get("trip_id"));
			
            List<Map<String, Object>> listBranchDte = actionPlanBranchDao.inquiryActionPlanBranchDetail(objReq);
            
            for(Map<String, Object> maps : listBranchDte){
            	String plan_dt_id = (String) maps.get("PLAN_DT_ID");
            	
            	List<Map<String, Object>> data_ltr =  (List<Map<String, Object>>) listLtr.stream()
            											.filter(lists -> plan_dt_id.equals((String) lists.get("PLAN_DT_ID")))
        												.collect(Collectors.toList());
            	
            	List<Map<String, Object>> DATA_MPTOOLS =  (List<Map<String, Object>>) listMpTools.stream()
						.filter(lists -> plan_dt_id.equals((String) lists.get("PLAN_DT_ID")))
						.collect(Collectors.toList());
            	
    			maps.put("data_ltr", data_ltr);
    			maps.put("DATA_MPTOOLS", DATA_MPTOOLS);
    			
    			
    		}
            
            map.put("data_station", listBranchDte);

            List<Map<String, Object>> listBranchOperator = actionPlanBranchDao.inquiryActionPlanOperator(objReq);
            map.put("data_officer", listBranchOperator);
        }

        return recList;

    }

    @Override
    public List<Map<String, Object>> inquiryLTRSpec(ActionPlanBranch objReq) throws Exception {

        List<Map<String, Object>> recList = actionPlanBranchDao.inquiryLTRSpec(objReq);

        return recList;
    }

    @Override
    public List<Map<String, Object>> inquiryLabScoreSpec(ActionPlanBranch objReq) throws Exception {

        List<Map<String, Object>> recList = actionPlanBranchDao.inquiryLabScoreSpec(objReq);

        return recList;
    }

    @Override
    public List<Map<String, Object>> inquiryActionPlanBranchByStatus(ActionPlanBranch objReq) throws Exception {

        List<Map<String, Object>> recList = actionPlanBranchDao.inquiryActionPlanBranch(objReq);


        return recList;

    }

    @Override
    public List<Map<String, Object>> inquiryMBStationMaster(ActionPlanBranch objReq) throws Exception {


        List<Map<String, Object>> recList = actionPlanBranchDao.inquiryMBStationMaster(objReq);


        return recList;

    }

    @Override
    public Map<String, Object> updateMBStationMaster(MbStationMaster objReq) throws Exception {


    	Map<String, Object> recList = actionPlanBranchDao.updateMBStationMaster(objReq);


        return recList;

    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Map<String, Object> saveActionPlan(ActionPlanBranch objReq) throws Exception {
        Map<String, Object> obj = new HashMap<String, Object>();


        ActionPlanBranch recObjReq = actionPlanBranchDao.saveActionPlan(objReq);
        obj.put("trip_no", recObjReq.getTrip_id());
        obj.put("success", recObjReq.getResult());
        obj.put("message", recObjReq.getMessage());

        return obj;

    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Map<String, Object> updateActionPlan(ActionPlanBranch objReq) throws Exception {
        Map<String, Object> obj = new HashMap<String, Object>();

        RandomOil recObjReq = actionPlanBranchDao.updateActionPlan(objReq);

        obj.put("success", recObjReq.getResult());
        obj.put("message", recObjReq.getMessage());

        return obj;

    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ResultObj updateStatusActionPlan(ActionPlanBranch objReq) throws Exception {

        ResultObj obj = new ResultObj();

        actionPlanBranchDao.updateStatusActionPlan(objReq);
        obj.setSuccess(Integer.parseInt(objReq.getResult()));
        obj.setMessage(objReq.getMessage());
        return obj;

    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Map<String, Object> syncReceiveLTR(Map<String, Object> objReq) throws Exception {
        Map<String, Object> obj = new HashMap<String, Object>();


        RandomOil recObjReq = actionPlanBranchDao.syncReceiveLTR(objReq);

        obj.put("success", recObjReq.getResult());
        obj.put("message", recObjReq.getMessage());

        return obj;

    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Map<String, Object> syncReceiveUpdateStatus(Map<String, Object> objReq) throws Exception {
        Map<String, Object> obj = new HashMap<String, Object>();


        RandomOil recObjReq = actionPlanBranchDao.syncReceiveUpdateStatus(objReq);

        obj.put("success", recObjReq.getResult());
        obj.put("message", recObjReq.getMessage());

        return obj;

    }
}