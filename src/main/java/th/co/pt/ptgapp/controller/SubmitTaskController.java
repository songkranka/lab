package th.co.pt.ptgapp.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.dao.task.ItemDto;
import th.co.pt.ptgapp.dao.task.LtrDao;
import th.co.pt.ptgapp.dao.task.LtrDtlDto;
import th.co.pt.ptgapp.dao.task.LtrDto;
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
public class SubmitTaskController {

    @Autowired
    private IItemService itemService;

    @Autowired
    private RandomService randomService;

    @Autowired
    private IPtgService ptgService;

    @Autowired
    private IMasterService masterService;

    @Autowired
    private LtrDao ltrDao;

    @RequestMapping(value = "/submitTask")
    public String assignmentTaskDetail(@RequestParam(value = "labCodeNo", required = false) String labCodeNo,
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
        return "submitTask";
    }


    @RequestMapping(value = "/api/getItemByWfId", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> getItemByWfId(@RequestBody HashMap<String,Object> params, HttpSession session) throws Exception {
        Map<String,Object>  result  =  new HashMap<>();
        result.put(WsConstant.WEB_STATUS_CODE,WsConstant.WEB_ERROR_CODE);
        MemberObj member = CGlobal.getC_UserInfo(session);
        if(member!=null) {
            try {
                List<ItemDto> lists = new ArrayList<>();
                List<ItemDto> listResponse = new ArrayList<>();
                ParamMap paramMap = new ParamMap();
                paramMap.setParamMap(params);
                String wfId = paramMap.getString("param_wf_id");
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

                    if(empId.contains(member.codempid)){
                        temp.setReadOnly(false);
                    }

                    temp.setEmpId(empId.substring(1));
                    temp.setEmpName(empName.substring(1));
                    if(temp.getAnalyzeCode().equals("0016")){
                        temp.setVisualDdl(masterService.getVisualDdl());
                    }
                    if(temp.getAnalyzeCode().equals("0003")){
                        temp.setColorDdl(masterService.getColorDdl());
                    }
                    lists.add(temp);
                }

                LtrDto ltrDto = ltrDao.findLtrByLabCode(wfId);
                List<LtrDtlDto> ltrDtlDtoList = new ArrayList<>();
                if(ltrDto!=null){
                    ltrDtlDtoList =  ltrDao.findLtrDtlByLtrNo(ltrDto.getLtrNo());
                }
                for(ItemDto dto : lists){
                    if(!ltrDtlDtoList.isEmpty()){
                        List<LtrDtlDto> ltrDtlDtoListTmp = ltrDtlDtoList.stream()
                                .filter(e->e.getIdMaterial().equalsIgnoreCase(dto.getMeterialCode())
                                        && e.getIdAnalyze().equalsIgnoreCase(dto.getAnalyzeCode()))
                                .collect(Collectors.toList());
                        if(!ltrDtlDtoListTmp.isEmpty()){
                            LtrDtlDto dtl = ltrDtlDtoListTmp.get(0);
                            if(dtl!=null) {
                                if (!StringUtils.isEmpty(dtl.getColor())) {
                                    dto.setSpaceValueDesc(dtl.getColorDesc());
                                    dto.setSpaceCode(dtl.getColor());
                                } else if (!StringUtils.isEmpty(dtl.getVisual())) {
                                    dto.setSpaceValueDesc(dtl.getVisualDesc());
                                    dto.setSpaceCode(dtl.getVisual());
                                } else if (!StringUtils.isEmpty(dtl.getResult())) {
                                    dto.setSpaceValue(dtl.getResult());
                                    dto.setSpaceValueDesc("");
                                }
                                if(!StringUtils.isEmpty(dtl.getUpdateBy())){
                                    if(dtl.getUpdateBy().equals(member.codempid)){
                                        dto.setReadOnly(false);
                                    }else {
                                        dto.setReadOnly(true);
                                    }
                                }
                            }
                        }
                    }
                    listResponse.add(dto);
                }

                result.put(WsConstant.WEB_STATUS_CODE, WsConstant.WEB_SUCCESS_CODE);
                result.put(WsConstant.WEB_DATA_RESULT_LISTS, listResponse);
                result.put("localLoginId", member.getCodempid());
                session.setAttribute("listItemDto", listResponse);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw ex;
            }
        }
        return result;
    }


    @RequestMapping(value = "/api/getDdlList", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> getItemDdl(@RequestBody HashMap<String,Object> params, HttpSession session) throws Exception {
        Map<String,Object>  result  =  new HashMap<>();
        result.put(WsConstant.WEB_STATUS_CODE,WsConstant.WEB_ERROR_CODE);
        MemberObj member = CGlobal.getC_UserInfo(session);
        if(member!=null) {
            try {
                ParamMap paramMap = new ParamMap();
                paramMap.setParamMap(params);
                result.put("ddlColor", masterService.getColorDdl());
                result.put("ddlVisual", masterService.getVisualDdl());
                result.put(WsConstant.WEB_STATUS_CODE, WsConstant.WEB_SUCCESS_CODE);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw ex;
            }
        }
        return result;
    }


    @RequestMapping(value = "/api/saveDataOfTask", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> saveDataOfTask(@RequestBody HashMap<String,Object> params, HttpSession session) throws Exception {
        Map<String,Object>  result  =  new HashMap<>();
        MemberObj member = CGlobal.getC_UserInfo(session);
        if(member!=null) {
            try {
                ParamMap paramMap = new ParamMap();
                paramMap.setParamMap(params);
                List<Map<String,Object>> list = (List<Map<String, Object>>) paramMap.getObject("data_table");
                result = randomService.saveTaskList(list,paramMap.getString("labCode"),member);
                if(result.get("result").equals(WsConstant.WEB_SUCCESS_CODE)){
                    if(randomService.saveFlagAll(paramMap.getString("labCode"))){
                        randomService.resultFlagYAndUpdate(paramMap.getString("labCode"),member);
                        // call WF submitTask
                        Map<String,Object> res = ptgService.submitTask(paramMap.getString("labCode"));
                        if(res.get("result").equals(WsConstant.WEB_SUCCESS_CODE)){
                            LtrDto dto = new LtrDto();
                            dto.setLabCode(paramMap.getString("labCode"));
                            dto.setUpdateBy(member.getCodempid());
                            dto.setResultStatus("07");// wait audit
                            randomService.updateLtrResultStatus(dto);
                            result.put("result",WsConstant.WEB_SUCCESS_CODE);
                        }else {
                            result.put("result",WsConstant.WEB_ERROR_CODE);
                        }

                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw ex;
            }
        }
        return result;
    }
    @RequestMapping("assignmentDetailTask")
	 public ModelAndView initAssignmentDetail() throws Exception {
		 
	     return new ModelAndView("assignmentTaskLastResult");
	 }

}
