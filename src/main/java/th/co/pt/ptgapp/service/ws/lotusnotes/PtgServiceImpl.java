package th.co.pt.ptgapp.service.ws.lotusnotes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
//import ptg.lotus.servic.createdocnote.CreateDoc_Notes;
//import ptg.lotus.servic.createdocnote.CreateDoc_NotesServiceLocator;
//import ptg.lotus.servic.createrequest.CreateRequest;
//import ptg.lotus.servic.createrequest.CreateRequestServiceLocator;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.workflow.SubmitRequestEntity;
import th.co.pt.ptgapp.controller.ws.WFConstant;
import th.co.pt.ptgapp.dao.task.LtrDao;
import th.co.pt.ptgapp.dao.task.LtrDtlDto;
import th.co.pt.ptgapp.dao.task.LtrDto;
import th.co.pt.ptgapp.service.RandomService;
import th.co.pt.ptgapp.service.ws.lotusnotes.dto.RandomSampleDto;
import th.co.pt.ptgapp.service.ws.lotusnotes.request.CreateRequestRequest;
import th.co.pt.ptgapp.service.ws.lotusnotes.request.ItemRequest;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.CreateRequestResponse;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.ItemResponse;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.WsConstant;
import th.co.pt.ptgapp.utils.CGlobal;
import th.co.pt.ptgapp.utils.ParamMap;

import javax.servlet.http.HttpSession;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PtgServiceImpl implements IPtgService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RandomService randomService;
    @Autowired
    private LtrDao ltrDao;


    @Override
    public String getMyWork(ParamMap param) throws RemoteException {
        String result = null;
        /*try {
            ptg.lotus.servic.getmywork.SubmitTaskServiceLocator submitTaskServiceLocator = new ptg.lotus.servic.getmywork.SubmitTaskServiceLocator();
            submitTaskServiceLocator.setEndpointAddress("Domino","http://172.16.112.127:80/Dev/WebService.nsf/GetMyWork?OpenWebService");
            ptg.lotus.servic.getmywork.SubmitTask service = submitTaskServiceLocator.getDomino();
            result = service.request_GetMyWork(param.getString("systemT"),param.getString("employee"),param.getString("wfStatus"));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //System.out.println("RESULT = "+result);
        return result;
    }

    @Override
    public String getItemList(ItemRequest request) throws RemoteException {
        String result = null;
        /*try {
            logger.info("{}",request);
            CreateDoc_NotesServiceLocator createDocNotesServiceLocator = new CreateDoc_NotesServiceLocator();
            createDocNotesServiceLocator.setEndpointAddress("Domino","http://172.16.112.127:80/Dev/WebService.nsf/CreateDoc_Notes?OpenWebService");
            CreateDoc_Notes service = createDocNotesServiceLocator.getDomino();
            result = service.getItemList(
                    request.getSystem(),
                    request.getDummy01(),
                    request.getDummy02(),
                    strReplace(request.getDummy03()),
                    strReplace(request.getDummy04()),
                    strReplace(request.getDummy05()),
                    strReplace(request.getDummy06()),
                    strReplace(request.getDummy07()),
                    strReplace(request.getDummy08()),
                    strReplace(request.getDummy09()),
                    strReplace(request.getDummy10()),
                    strReplace(request.getDummy11()),
                    strReplace(request.getDummy12()),
                    strReplace(request.getDummy13()),
                    strReplace(request.getDummy14()),
                    strReplace(request.getDummy15()),
                    strReplace(request.getDummy16()),
                    strReplace(request.getDummy17()),
                    strReplace(request.getDummy18()),
                    strReplace(request.getDummy19()),
                    strReplace(request.getDummy20())
                    );
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("{}",result);*/
        return result;
    }

    @Override
    public String getRequestDetail(CreateRequestRequest request) throws RemoteException {
        String result = null;
        /*try {
            CreateRequestServiceLocator createRequestServiceLocator = new CreateRequestServiceLocator();
            createRequestServiceLocator.setEndpointAddress("Domino","http://172.16.112.127:80/Dev/WebService.nsf/CreateRequest?OpenWebService");
            CreateRequest service = createRequestServiceLocator.getDomino();
            result = service.getRequest_Detail(
                    request.getSystemName(),
                    request.getProcess(),
                    request.getRequestID(),
                    request.getRequesterID(),
                    request.getTotalrecord(),
                    request.getDummy01(),
                    request.getDummy02(),
                    "#",
                    "#",
                    "#",
                    "#",
                    "#",
                    "#",
                    "#",
                    "#",
                    "#",
                    "#",
                    "#",
                    "#",
                    "#",
                    "#",
                    "#",
                    "#",
                    "#",
                    "#",
                    request.getSeq(),
                    request.getTestItemCode(),
                    request.getTesttoolCode(),
                    request.getTestMethodCode(),
                    request.getTestSpecCode(),
                    request.getTestUnitCode(),
                    request.getMemberlist()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return result;
    }

    @Override
    public String requestGetMaster(ParamMap param) throws RemoteException {
        String result = null;
       /* try {
            ptg.lotus.servic.getmaster.SubmitTaskServiceLocator submitTaskServiceLocator = new ptg.lotus.servic.getmaster.SubmitTaskServiceLocator();
            submitTaskServiceLocator.setEndpointAddress("Domino","http://172.16.112.127:80/Dev/WebService.nsf/GetMaster?OpenWebService");
            ptg.lotus.servic.getmaster.SubmitTask service = submitTaskServiceLocator.getDomino();
            result = service.request_GetMaster(param.getString("systemT"),param.getString("table"));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return result;
    }

    @Override
    public String requestGetStatus(ParamMap param) throws RemoteException {
        String result = null;
       /* try {
            ptg.lotus.servic.getstatus.SubmitTaskServiceLocator submitTaskServiceLocator = new ptg.lotus.servic.getstatus.SubmitTaskServiceLocator();
            submitTaskServiceLocator.setEndpointAddress("Domino","http://172.16.112.127:80/Dev/WebService.nsf/GetStatus?OpenWebService");
            ptg.lotus.servic.getstatus.SubmitTask service = submitTaskServiceLocator.getDomino();
            result = service.request_GetStatus(param.getString("systemT"),param.getString("process"),param.getString("requestID"));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return result;
    }

    @Override
    public String submitChangeRequest(ParamMap param) throws RemoteException {
        String result = null;
       /* try {
            ptg.lotus.servic.submitchangerequest.SubmitTaskServiceLocator submitTaskServiceLocator = new ptg.lotus.servic.submitchangerequest.SubmitTaskServiceLocator();
            submitTaskServiceLocator.setEndpointAddress("Domino","http://172.16.112.127:80/Dev/WebService.nsf/SubmitChangeRequest?OpenWebService");
            ptg.lotus.servic.submitchangerequest.SubmitTask service = submitTaskServiceLocator.getDomino();
            result = service.submit_ChangeRequest(
                    param.getString("systemT"),
                    param.getString("process"),
                    param.getString("requestID"),
                    param.getString("employeeID"),
                    param.getString("changeRequestID"));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return result;
    }

    @Override
    public Map<String,Object> submitDecision(String labcode,String comment,String empId,String act,String process,String changeId) throws RemoteException {
        HashMap<String,Object> response = new HashMap<>();
      /*  try {
            ptg.lotus.servic.submitdecision.SubmitTaskServiceLocator submitTaskServiceLocator = new ptg.lotus.servic.submitdecision.SubmitTaskServiceLocator();
            submitTaskServiceLocator.setEndpointAddress("Domino","http://172.16.112.127:80/Dev/WebService.nsf/SubmitDecision?OpenWebService");
            ptg.lotus.servic.submitdecision.SubmitTask service = submitTaskServiceLocator.getDomino();
            String result = service.submit_Decision(
                    WFConstant.SYSTEM_NAME,
                    process,
                    labcode,
                    changeId,
                    empId,
                    act,
                    comment
            );*/
//            if(process.equals(WFConstant.PROCESS_ASSIGNMENT)) {
//                result = service.submit_Decision(
//                        WFConstant.SYSTEM_NAME,
//                        WFConstant.PROCESS_ASSIGNMENT,
//                        labcode,
//                        changeId,
//                        empId,
//                        act,
//                        comment
//                );
//            }else if(process.equals(WFConstant.PROCESS_CHANGE)){
//                result = service.submit_Decision(
//                        WFConstant.SYSTEM_NAME,
//                        WFConstant.PROCESS_CHANGE,
//                        labcode,
//                        changeId,
//                        empId,
//                        act,
//                        comment
//                );
//            }
/*            if(!StringUtils.isEmpty(act)) {
                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> map = mapper.readValue(result, Map.class);
                if ("900".equals(map.get("ErrorCode"))) {
                    response.put("result", WsConstant.WEB_SUCCESS_CODE);
                } else {
                    response.put("result", WsConstant.WEB_ERROR_CODE);
                }
            }else{
                response.put("result", WsConstant.WEB_ERROR_CODE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //return response;
        return null;
    }

    @Override
    public Map<String,Object> submitTask(String labcode) throws RemoteException {
        /*HashMap<String,Object> response = new HashMap<>();
        LtrDto ltr = ltrDao.findLtrByLabCode(labcode);
        if(ltr!=null) {
            List<LtrDtlDto> dtlList = ltrDao.findLtrDtlByLtrNo(ltr.getLtrNo());
            if(!dtlList.isEmpty()) {
                List<String> empList = dtlList.stream().map(e->e.getUpdateBy()).collect(Collectors.toList());
                String empStr = WsConstant.getPip(empList);
                try {
                    ptg.lotus.servic.submittask.SubmitTaskServiceLocator submitTaskServiceLocator = new ptg.lotus.servic.submittask.SubmitTaskServiceLocator();
                    submitTaskServiceLocator.setEndpointAddress("Domino", "http://172.16.112.127:80/Dev/WebService.nsf/SubmitTask?OpenWebService");
                    ptg.lotus.servic.submittask.SubmitTask service = submitTaskServiceLocator.getDomino();
                    String result = service.submit_Task(WFConstant.SYSTEM_NAME, WFConstant.PROCESS_ASSIGNMENT, labcode, WsConstant.genSeq(dtlList.size()), empStr);
                    ObjectMapper mapper = new ObjectMapper();
                    Map<String,Object> map = mapper.readValue(result, Map.class);
                    if("900".equals(map.get("ErrorCode"))){
                        response.put("result",WsConstant.WEB_SUCCESS_CODE);
                    }else {
                        response.put("result",WsConstant.WEB_ERROR_CODE);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }*/
        //return response;
    	return null;
    }

    @Override
    public Map<String, Object> assignJob(RandomSampleDto sample, HttpSession session) {
        Map<String,Object> result = new HashMap<>();
        MemberObj memberObj = CGlobal.getC_UserInfo(session);
        ItemRequest itemRequest = new ItemRequest();
        itemRequest.setSystem(WFConstant.SYSTEM_NAME);
        itemRequest.setDummy01(WFConstant.FIELD_PRODUCT+WFConstant.DUMMY_DELIM+sample.getProductCode());
        itemRequest.setDummy02(WFConstant.FIELD_TYPE+WFConstant.DUMMY_DELIM+sample.getSampleTypeName());
        try {
            String items = getItemList(itemRequest);
            ObjectMapper mapper = new ObjectMapper();
            ItemResponse itemResponse = mapper.readValue(items, ItemResponse.class);
            logger.debug("{}",itemResponse);
            String smg = itemResponse.getErrorcode().concat(" : ").concat(itemResponse.getErrorMsg());
            if(StringUtils.isEmpty(WsConstant.getErrorCode().getString(itemResponse.getErrorcode())) && itemResponse.getDetail().size()>0){
                CreateRequestRequest request = new CreateRequestRequest();
                request.setSystemName(WFConstant.SYSTEM_NAME);
                request.setProcess(WFConstant.PROCESS_ASSIGNMENT);
                request.setRequestID(sample.getLabCode());
                request.setRequesterID(memberObj.getCodempid());
                request.setTotalrecord(itemResponse.getDetail().size());
                request.setDummy01(itemRequest.getDummy01());
                request.setDummy02(itemRequest.getDummy02());
                request.setSeq(WsConstant.genSeq(itemResponse.getDetail().size()));
                request.setTestItemCode(WsConstant.getPip(itemResponse.getDetail().stream().map(e->e.getTestItemcode()).collect(Collectors.toList())));
                request.setTesttoolCode(WsConstant.getPip(itemResponse.getDetail().stream().map(e->e.getTesttoolcode()).collect(Collectors.toList())));
                request.setTestMethodCode(WsConstant.getPip(itemResponse.getDetail().stream().map(e->e.getTestmathodcode()).collect(Collectors.toList())));
                request.setTestSpecCode(WsConstant.getPip(itemResponse.getDetail().stream().map(e->e.getTestSpeccode()).collect(Collectors.toList())));
                request.setTestUnitCode(WsConstant.getPip(itemResponse.getDetail().stream().map(e->e.getTestUnitcode()).collect(Collectors.toList())));
                request.setMemberlist(WsConstant.getMemList(itemResponse.getDetail()));
                logger.info("{}",request);
                String requestDetail = getRequestDetail(request);
                CreateRequestResponse createRequestResponse = mapper.readValue(requestDetail, CreateRequestResponse.class);
                String createSmg = createRequestResponse.getErrorCode().concat(" : ").concat(createRequestResponse.getErrorMsg());
                logger.info("{}",createRequestResponse);
                if(StringUtils.isEmpty(WsConstant.getErrorCode().getString(createRequestResponse.getErrorCode()))){
                    try {
                        HashMap<String,Object> map = new HashMap<>();
                        map.put("product",request.getDummy01());
                        map.put("sampleType",request.getDummy01());
                        map.put("reqBy",memberObj.getCodempid());
                        ParamMap paramMap = new ParamMap();
                        paramMap.setParamMap(map);
                        Map<String,Object> assignJobResult = randomService.insertAcssignJob(paramMap,createRequestResponse);
                        if(!assignJobResult.isEmpty() && "S".equalsIgnoreCase(String.valueOf(assignJobResult.get("status")))){
                            SubmitRequestEntity requestEntity = new SubmitRequestEntity();
                            requestEntity.setAssignFlag("1");
                            requestEntity.setLabCode(createRequestResponse.getRequestID());
                            requestEntity.setEmployeeID(memberObj.getCodempid());
                            Map<String,Object> updFlg = randomService.updateAssignFlag(requestEntity);
                            logger.debug("{}",updFlg.isEmpty());
                            result.put(WsConstant.WEB_STATUS_CODE,WsConstant.WEB_SUCCESS_CODE);
                            result.put(WsConstant.WEB_STATUS_SMG,"assigned success");
                            result.put(WsConstant.WEB_DATA_KEY,createRequestResponse.getRequestID());
                        }else{
                            logger.debug("Save Assignment fail!");
                            result.put(WsConstant.WEB_STATUS_SMG,"Save Assignment fail!");
                            result.put(WsConstant.WEB_STATUS_CODE,WsConstant.WEB_ERROR_CODE);
                        }
                    } catch (Exception e) {
                        logger.error("{}",e);
                        e.printStackTrace();
                    }
                }else{
                    logger.debug("{}",createRequestResponse);
                    result.put(WsConstant.WEB_STATUS_CODE,WsConstant.WEB_ERROR_CODE);
                    result.put(WsConstant.WEB_STATUS_SMG,createSmg);
                }
                logger.info("{}",requestDetail);
            }else{
                logger.debug("{}",smg);
                result.put(WsConstant.WEB_STATUS_CODE,WsConstant.WEB_ERROR_CODE);
                result.put(WsConstant.WEB_STATUS_SMG,smg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private String strReplace(String str){
        return StringUtils.isEmpty(str)?"#":str.trim();
    }

}
