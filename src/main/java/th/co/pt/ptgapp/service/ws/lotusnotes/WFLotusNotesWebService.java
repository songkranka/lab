package th.co.pt.ptgapp.service.ws.lotusnotes;

import java.util.Map;

import th.co.pt.ptgapp.controller.bean.workflow.GetItemListEntity;
import th.co.pt.ptgapp.controller.bean.workflow.GetMasterEntity;
import th.co.pt.ptgapp.controller.bean.workflow.GetWFStatusEntity;
import th.co.pt.ptgapp.controller.bean.workflow.GetWorkSelfEntity;
import th.co.pt.ptgapp.controller.bean.workflow.SubmitRequestEntity;

public interface WFLotusNotesWebService {
	public Map<String, Object> requestItemList(GetItemListEntity entity) throws Exception;
	public Map<String, Object> requestSubmitAssign(SubmitRequestEntity entity) throws Exception;
	public Map<String, Object> requestMasterTable(GetMasterEntity entity) throws Exception;
	public Map<String, Object> requestWorkflowStatus(GetWFStatusEntity entity) throws Exception;
	public Map<String, Object> requestWorkSelf(GetWorkSelfEntity entity) throws Exception;
	
}
