package th.co.pt.ptgapp.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.ws.WFConstant;
import th.co.pt.ptgapp.dao.task.ItemDto;
import th.co.pt.ptgapp.dao.task.LtrDao;
import th.co.pt.ptgapp.dao.task.LtrDto;
import th.co.pt.ptgapp.dao.task.LtrJoinltrDtlDto;
import th.co.pt.ptgapp.service.RandomService;
import th.co.pt.ptgapp.service.task.IItemService;
import th.co.pt.ptgapp.service.task.IMasterService;
import th.co.pt.ptgapp.service.ws.lotusnotes.IPtgService;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.WsConstant;
import th.co.pt.ptgapp.utils.CGlobal;
import th.co.pt.ptgapp.utils.ParamMap;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class WatingForCheckerTaskController {

    @Autowired
    private RandomService randomService;

    @Autowired
    private IPtgService ptgService;

    @Autowired
    private LtrDao ltrDao;

    @Autowired
    private IItemService itemService;

    @Autowired
    private IMasterService masterService;

    @RequestMapping(value = "/waitAuditTask")
    public String waitAuditTaskDetail(@RequestParam(value = "labCodeNo", required = false) String labCodeNo,
                                      @RequestParam(value = "plantId", required = false) String plantId,
                                      Model model)throws  Exception{
        RandomOil randomOil = new RandomOil();
        randomOil.setNameStore(plantId);
        randomOil.setLabCode_No(labCodeNo);
        Map<String,Object> randomLastResult = randomService.inquiryRandomLastResult(randomOil);
        if(!randomLastResult.isEmpty()) {
            List<Map<String, Object>> list = (List<Map<String, Object>>) randomLastResult.get("list");
            model.addAttribute("task", list.get(0));
        }
        return "waitAuditTask";
    }


    @RequestMapping(value = "/api/saveSendReviseTask", method = RequestMethod.POST)
    public @ResponseBody
    Map<String,Object> saveSendReviseTask(@RequestBody HashMap<String,Object> params, HttpSession session) throws Exception {
        Map<String,Object>  result  =  new HashMap<>();
        MemberObj member = CGlobal.getC_UserInfo(session);
        if(member!=null) {
            try {
                ParamMap paramMap = new ParamMap();
                paramMap.setParamMap(params);
                String labcode = paramMap.getString("labCode");
                String comment = paramMap.getString("comment");
                if(!StringUtils.isEmpty(labcode)){
                    // call WF submitDecisiopn
                    Map<String,Object> res = ptgService.submitDecision(labcode,comment,member.codempid,"Revise", WFConstant.PROCESS_ASSIGNMENT,"");
                    if(res.get("result").equals(WsConstant.WEB_SUCCESS_CODE)){
                        LtrDto dto = new LtrDto();
                        dto.setLabCode(labcode);
                        dto.setUpdateBy(member.getCodempid());
                        dto.setResultStatus("05");// Revise
                        randomService.updateLtrResultStatus(dto);
                        result.put("result",WsConstant.WEB_SUCCESS_CODE);
                    }else {
                        result.put("result",WsConstant.WEB_ERROR_CODE);
                    }
                }else{
                    result.put("result", WsConstant.WEB_ERROR_CODE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw ex;
            }
        }
        return result;
    }


    @RequestMapping(value = "/api/saveSendApproveTask", method = RequestMethod.POST)
    public @ResponseBody
    Map<String,Object> saveSendApproveTask(@RequestBody HashMap<String,Object> params, HttpSession session) throws Exception {
        Map<String,Object>  result  =  new HashMap<>();
        MemberObj member = CGlobal.getC_UserInfo(session);
        if(member!=null) {
            try {
                ParamMap paramMap = new ParamMap();
                paramMap.setParamMap(params);
                String labcode = paramMap.getString("labCode");
                String comment = paramMap.getString("comment");
                if(!StringUtils.isEmpty(labcode)){
                    // call WF submitDecisiopn
                    Map<String,Object> res = ptgService.submitDecision(labcode,comment,member.codempid,"Approve", WFConstant.PROCESS_ASSIGNMENT,"");
                    if(res.get("result").equals(WsConstant.WEB_SUCCESS_CODE)){
                        LtrDto dto = new LtrDto();
                        dto.setLabCode(labcode);
                        dto.setUpdateBy(member.getCodempid());
                        dto.setResultStatus("02");// Approve
                        randomService.updateLtrResultStatus(dto);
                        result.put("result",WsConstant.WEB_SUCCESS_CODE);
                    }else {
                        result.put("result",WsConstant.WEB_ERROR_CODE);
                    }
                }else{
                    result.put("result", WsConstant.WEB_ERROR_CODE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw ex;
            }
        }
        return result;
    }


    @RequestMapping(value = "/api/getLtrByWfId", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> getItemByWfId(@RequestBody HashMap<String,Object> params, HttpSession session) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put(WsConstant.WEB_STATUS_CODE, WsConstant.WEB_ERROR_CODE);
        MemberObj member = CGlobal.getC_UserInfo(session);
        List<ItemDto> listResponse = new ArrayList<>();
        if (member != null) {
            try {
                ParamMap paramMap = new ParamMap();
                paramMap.setParamMap(params);
                String wfId = paramMap.getString("param_wf_id");
                List<LtrJoinltrDtlDto> ltrResult = ltrDao.getLtrDtlByLabCode(wfId);
                List<ItemDto> ls = itemService.findItemByReqNo(wfId);
                Map<String, List<ItemDto>> map = ls.stream().collect(Collectors.groupingBy(ItemDto::getReqDtlNo));
                for (Map.Entry<String, List<ItemDto>> entry : map.entrySet()) {
                    ItemDto temp = new ItemDto();
                    String empId = "";
                    String empName = "";
                    for(ItemDto dto : entry.getValue()){
                        if(StringUtils.isEmpty(temp.getWfId())){
                            BeanUtils.copyProperties(dto, temp);
                        }
                        empId = empId+","+dto.getEmpId();
                        empName = empName+","+dto.getEmpName();
                    }
                    temp.setEmpId(empId.substring(1));
                    temp.setEmpName(empName.substring(1));
                    List<LtrJoinltrDtlDto> ltrObj = ltrResult.stream().filter(e->e.getAnalyzeCode().equals(temp.getAnalyzeCode())).collect(Collectors.toList());
                    if(!ltrObj.isEmpty()) {
                        if (temp.getAnalyzeCode().equals("0016")) {
                            temp.setVisualDdl(masterService.getVisualDdl());
                            temp.setSpaceCode(ltrObj.get(0).getVisual());
                            temp.setSpaceValueDesc(StringUtils.isEmpty(ltrObj.get(0).getVisualDesc())?"":ltrObj.get(0).getVisualDesc());
                        } else if (temp.getAnalyzeCode().equals("0003")) {
                            temp.setColorDdl(masterService.getColorDdl());
                            temp.setSpaceCode(ltrObj.get(0).getColor());
                            temp.setSpaceValueDesc(StringUtils.isEmpty(ltrObj.get(0).getColorDesc())?"":ltrObj.get(0).getColorDesc());
                        } else {
                            temp.setSpaceValue(ltrObj.get(0).getResult());
                        }
                    }
                    temp.setReadOnly(true);
                    listResponse.add(temp);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                throw ex;
            }

        }
        result.put(WsConstant.WEB_DATA_RESULT_LISTS,listResponse);
        return result;
    }
}
