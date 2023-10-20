package th.co.pt.ptgapp.service.ws.lotusnotes;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.co.pt.ptgapp.agent.GetWorkSelfAgent;
import th.co.pt.ptgapp.agent.LotusNotesWebServiceAgent;
import th.co.pt.ptgapp.agent.RequestWFStatusAgent;
import th.co.pt.ptgapp.agent.WFGetMasterAgent;
import th.co.pt.ptgapp.controller.bean.workflow.*;

import java.util.Map;

@Service("WFLotusNotesWebService")
public class WFLotusNotesWebServiceImpl implements WFLotusNotesWebService {

	@Autowired
	LotusNotesWebServiceAgent lotusNotesAgent ;
	@Autowired
	WFGetMasterAgent wfGetMasterAgent ;
	@Autowired
	RequestWFStatusAgent reqtWFStatusAgent; 
	@Autowired
	GetWorkSelfAgent getWorkSelfAgent;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	@Override
	public Map<String, Object> requestItemList(GetItemListEntity entity) throws Exception {
		return lotusNotesAgent.AgentRequstItem(entity);
	}

	@Override
	public Map<String, Object> requestMasterTable(GetMasterEntity entity) throws Exception {
		return wfGetMasterAgent.requestMasterAgent(entity);
	}

	@Override
	public Map<String, Object> requestSubmitAssign(SubmitRequestEntity entity) throws Exception {
		return lotusNotesAgent.AgentSubmitAssignment(entity);
	}

	@Override
	public Map<String, Object> requestWorkflowStatus(GetWFStatusEntity entity) throws Exception {
		return reqtWFStatusAgent.reqtWorkflowStatus(entity);
	}

	@Override
	public Map<String, Object> requestWorkSelf(GetWorkSelfEntity entity) throws Exception {
		return getWorkSelfAgent.requestWorkSelf(entity);
	}

	
}
