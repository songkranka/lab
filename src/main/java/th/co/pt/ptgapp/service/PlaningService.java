package th.co.pt.ptgapp.service;

import java.util.List;
import java.util.Map;

import th.co.pt.ptgapp.controller.bean.ActionPlanBranch;
import th.co.pt.ptgapp.controller.bean.MbStationMaster;
import th.co.pt.ptgapp.controller.bean.MemberAccountObj;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.ResultObj;
import th.co.pt.ptgapp.controller.bean.UserDto;

import javax.servlet.http.HttpSession;

public interface PlaningService {

    List<Map<String, Object>> inquiryActionPlanBranch(ActionPlanBranch objReq) throws Exception;

    List<Map<String, Object>> inquiryActionPlanBranchByStatus(ActionPlanBranch objReq) throws Exception;

    Map<String, Object> saveActionPlan(ActionPlanBranch objReq) throws Exception;

    Map<String, Object> updateActionPlan(ActionPlanBranch objReq) throws Exception;

    ResultObj updateStatusActionPlan(ActionPlanBranch objReq) throws Exception;

    Map<String, Object> syncReceiveLTR(Map<String, Object> objReq) throws Exception;

    Map<String, Object> syncReceiveUpdateStatus(Map<String, Object> objReq) throws Exception;

    List<Map<String, Object>> inquiryLTRSpec(ActionPlanBranch objReq) throws Exception;

    List<Map<String, Object>> inquiryLabScoreSpec(ActionPlanBranch objReq) throws Exception;

    List<Map<String, Object>> inquiryMBStationMaster(ActionPlanBranch objReq) throws Exception;

    Map<String, Object> updateMBStationMaster(MbStationMaster objReq) throws Exception;
}
