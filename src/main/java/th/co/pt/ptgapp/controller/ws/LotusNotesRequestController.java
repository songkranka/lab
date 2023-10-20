package th.co.pt.ptgapp.controller.ws;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.workflow.*;
import th.co.pt.ptgapp.service.RandomService;
import th.co.pt.ptgapp.service.ws.lotusnotes.IPtgService;
import th.co.pt.ptgapp.service.ws.lotusnotes.WFLotusNotesWebService;
import th.co.pt.ptgapp.service.ws.lotusnotes.request.CreateRequestRequest;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.CreateRequestResponse;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.ItemResponse;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.WsConstant;
import th.co.pt.ptgapp.utils.CGlobal;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class LotusNotesRequestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WFLotusNotesWebService webServiceSoap ;
	
	@Autowired
	private RandomService randomService;

	@Autowired
	private IPtgService ptgService;

	@RequestMapping(value = "/reqItemList", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> getItemList( @RequestBody GetItemListEntity entity ,HttpSession session) {

		Map<String,Object> result = new HashMap<>();
		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
		entity.initDummy(WFConstant.DUMMY_DELIM);
		entity.setSystem(WFConstant.SYSTEM_NAME);
		entity.setDummy01(WFConstant.FIELD_PRODUCT+WFConstant.DUMMY_DELIM+entity.getProduct());
		entity.setDummy02(WFConstant.FIELD_TYPE+WFConstant.DUMMY_DELIM+entity.getTypeOfSample());
		entity.setEmployeeID(memberObj.getCodempid());
		try {
			String items = ptgService.getItemList(null);
			ObjectMapper mapper = new ObjectMapper();
			ItemResponse itemResponse = mapper.readValue(items, ItemResponse.class);
			logger.debug("{}",itemResponse);
			String smg = itemResponse.getErrorcode().concat(" : ").concat(itemResponse.getErrorMsg());
			if(StringUtils.isEmpty(WsConstant.getErrorCode().getString(itemResponse.getErrorcode())) && itemResponse.getDetail().size()>0){
				Map<String,Object> assignFlg = randomService.getAssignmentFlag(entity);
				if(StringUtils.isEmpty(assignFlg.get(WsConstant.TXT_ASSIGN_STATUS))) {
					CreateRequestRequest request = new CreateRequestRequest();
					request.setSystemName(WFConstant.SYSTEM_NAME);
					request.setProcess(WFConstant.PROCESS_ASSIGNMENT);
					request.setRequestID(entity.getLabCode());
					request.setRequesterID(memberObj.getCodempid());
					request.setTotalrecord(itemResponse.getDetail().size());
					request.setDummy01(entity.getDummy01());
					request.setDummy02(entity.getDummy02());
					request.setSeq(WsConstant.genSeq(itemResponse.getDetail().size()));
					request.setTestItemCode(WsConstant.getPip(itemResponse.getDetail().stream().map(e->e.getTestItemcode()).collect(Collectors.toList())));
					request.setTesttoolCode(WsConstant.getPip(itemResponse.getDetail().stream().map(e->e.getTesttoolcode()).collect(Collectors.toList())));
					request.setTestMethodCode(WsConstant.getPip(itemResponse.getDetail().stream().map(e->e.getTestmathodcode()).collect(Collectors.toList())));
					request.setTestSpecCode(WsConstant.getPip(itemResponse.getDetail().stream().map(e->e.getTestSpeccode()).collect(Collectors.toList())));
					request.setTestUnitCode(WsConstant.getPip(itemResponse.getDetail().stream().map(e->e.getTestUnitcode()).collect(Collectors.toList())));
					request.setMemberlist(WsConstant.getMemList(itemResponse.getDetail()));
					String requestDetail = ptgService.getRequestDetail(request);
					CreateRequestResponse createRequestResponse = mapper.readValue(requestDetail, CreateRequestResponse.class);
					String createSmg = createRequestResponse.getErrorCode().concat(" : ").concat(createRequestResponse.getErrorMsg());
					logger.debug("{}",createRequestResponse);
					if(StringUtils.isEmpty(WsConstant.getErrorCode().getString(createRequestResponse.getErrorCode()))){
						/****
						 * insert to database labdb
						 * *****/


						result.put(WsConstant.WEB_STATUS_CODE,WsConstant.WEB_SUCCESS_CODE);
						result.put(WsConstant.WEB_STATUS_SMG,smg);
						result.put(WsConstant.WEB_DATA_KEY,itemResponse);
						logger.debug("{}",webServiceSoap.requestItemList(entity));
					}else{
						logger.debug("{}",createRequestResponse);
						result.put(WsConstant.WEB_STATUS_CODE,WsConstant.WEB_ERROR_CODE);
						result.put(WsConstant.WEB_STATUS_SMG,createSmg);
					}
					logger.info("{}",requestDetail);
				}else{
					logger.debug("{}",assignFlg);
				}
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


	@RequestMapping(value = "/submitAssignment_back", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object>submitAssignmentx( @RequestBody SubmitRequestEntity entity ,HttpSession session) {

		MemberObj  memberObj = CGlobal.getC_UserInfo(session);

		Map<String,Object> result = new HashMap<String, Object>();

		entity.setProcess(WFConstant.PROCESS_ASSIGNMENT);
		entity.setRequesterID(memberObj.getCodempid());
		entity.setRequestID(entity.getLabCode());
		entity.setEmployeeID(memberObj.getCodempid());
		entity.initDummy("#");

		try {
			result = webServiceSoap.requestSubmitAssign(entity);

			logger.info("return assignment");
			logger.info(result.toString());
		} catch (Exception e) {
			result = null;
		}
		return result;
	}

	// #######

	@RequestMapping(value = "/reqItemList_bak", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object>reqItemList( @RequestBody GetItemListEntity entity ,HttpSession session) {

		Map<String,Object> result = new HashMap<String, Object>();
		Map<String,Object> wfResult = new HashMap<String, Object>();
		RandomOil objReq = new RandomOil();
		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
		// initial request 
		entity.initDummy(WFConstant.DUMMY_DELIM);
		entity.setSystem(WFConstant.SYSTEM_NAME);
		entity.setDummy01(WFConstant.FIELD_PRODUCT+WFConstant.DUMMY_DELIM+entity.getProduct());
		entity.setDummy02(WFConstant.FIELD_TYPE+WFConstant.DUMMY_DELIM+entity.getTypeOfSample());
		entity.setEmployeeID(memberObj.getCodempid());
		try {
			String items = ptgService.getItemList(null);
			ObjectMapper mapper = new ObjectMapper();
			ItemResponse itemResponse = mapper.readValue(items, ItemResponse.class);
			logger.info("{}",itemResponse);
			if(StringUtils.isEmpty(WsConstant.getErrorCode().getString(itemResponse.getErrorcode()))){

			}else{

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
        	wfResult = webServiceSoap.requestItemList(entity);
        	result = wfResult;
        	
        	Map<String,Object> assignFlg = randomService.getAssignmentFlag(entity);
        	if(assignFlg.get("ASSIGN_STATUS") == null) {
        		result.put("asgnflg", "F");
        	} else {
        		result.put("asgnflg", "T");
        	}
        	logger.info("  "+result.toString());
        } catch (Exception e) {
        	wfResult = null;
        	result = null;
        }
		return result;
	}

	@RequestMapping(value = "/submitAssignment", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object>submitAssignment( @RequestBody SubmitRequestEntity entity ,HttpSession session) {
		
		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
		
		Map<String,Object> result = new HashMap<String, Object>();
		
		entity.setProcess(WFConstant.PROCESS_ASSIGNMENT);
		entity.setRequesterID(memberObj.getCodempid());
		entity.setRequestID(entity.getLabCode());
		entity.setEmployeeID(memberObj.getCodempid());
		entity.initDummy("#");

        try {
        	result = webServiceSoap.requestSubmitAssign(entity);
        	
        	logger.info("return assignment");
        	logger.info(result.toString());
        } catch (Exception e) {
        	result = null;
        }
		return result;
	}

	@RequestMapping(value = "/saveAssignment", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object>saveAssignment( @RequestBody ReturnAssignmentEntity entity ,HttpSession session) {
		MemberObj  memberObj = CGlobal.getC_UserInfo(session);	
		Map<String,Object> result = new HashMap<String, Object>();
        try {
        	entity.setReqBy(memberObj.getCodempid());
        	result = randomService.saveAssignment(entity);
        	SubmitRequestEntity ent = new SubmitRequestEntity();
					        	ent.setAssignFlag("1");
					        	ent.setLabCode(entity.getRequestID());
					        	ent.setEmployeeID(memberObj.getCodempid());
        	Map<String,Object> updFlg = randomService.updateAssignFlag(ent);
        } catch (Exception e) {
        	logger.error("",e);
        	result = null;
        }
		return result;
	}

	@RequestMapping(value = "/reqOwnerTask", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object>reqOwnerTask( @RequestBody GetWorkSelfEntity entity ,HttpSession session) {
		
		Map<String,Object> result = new HashMap<String, Object>();
		logger.info("@RequestBody entity =  "+ entity.toString() );
		System.out.println("SSSSSSSSSSSs");
		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
		entity.setSystem(WFConstant.SYSTEM_NAME);
		entity.setEmployee(memberObj.getCodempid());
        try {
        	result = webServiceSoap.requestWorkSelf(entity);
        	result.put("param", entity);
        	logger.info("  "+result.toString());
        } catch (Exception e) {
        	result = null;
        }
		return result;
	}

	@RequestMapping(value = "/reqTblMaster", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object>reqTblMaster( @RequestBody GetMasterEntity entity ,HttpSession session ) {
		
		Map<String,Object> result = new HashMap<String, Object>();
		logger.info("@RequestBody entity =  "+ entity.toString() );
		
        try {
        	result = webServiceSoap.requestMasterTable(entity);
        	logger.info("  "+result.toString());
        } catch (Exception e) {
        	result = null;
        }
		return result;
	}

	@RequestMapping(value = "/reqWorkflowStatus", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object>reqWorkflowStatus( @RequestBody GetWFStatusEntity entity ) {
		
		Map<String,Object> result = new HashMap<String, Object>();
		logger.info("@RequestBody entity =  "+ entity.toString() );
		
        try {
        	result = webServiceSoap.requestWorkflowStatus(entity);
        	logger.info("  "+result.toString());
        } catch (Exception e) {
        	result = null;
        }
		return result;
	}
	
}
