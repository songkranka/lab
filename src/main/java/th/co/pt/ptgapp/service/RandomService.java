package th.co.pt.ptgapp.service;

import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.ResultObj;
import th.co.pt.ptgapp.controller.bean.workflow.GetItemListEntity;
import th.co.pt.ptgapp.controller.bean.workflow.MemberWorkGroupBean;
import th.co.pt.ptgapp.controller.bean.workflow.ReturnAssignmentEntity;
import th.co.pt.ptgapp.controller.bean.workflow.SubmitRequestEntity;
import th.co.pt.ptgapp.dao.task.LtrDto;
import th.co.pt.ptgapp.service.ws.lotusnotes.dto.RandomSampleDto;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.CreateRequestResponse;
import th.co.pt.ptgapp.utils.ParamMap;

import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperPrint;

public interface RandomService {
	
	 
	 Map<String,Object>  inquiryRequestAnalysis(RandomOil objReq) throws Exception   ;
	 Map<String,Object>  inquiryRequestAnalysisOilDetail(RandomOil objReq) throws Exception   ;
	 Map<String,Object>  inquiryRandomOilDetail(RandomOil objReq) throws Exception   ;
	 Map<String,Object>    inquirySaveResultAnalysisOil(RandomOil objReq) throws   Exception   ;
	 Map<String,Object>    inquiryLTRNO(RandomOil objReq) throws   Exception   ;
	 Map<String,Object>    inquiryLTRByLTRNO(RandomOil objReq) throws   Exception   ;
	 Map<String,Object>    inquiryAnalyzeSpec(RandomOil objReq) throws   Exception   ;
	 Map<String,Object>  inquiryRandomLastResult(RandomOil objReq) throws   Exception ; 
	 Map<String,Object>  inquiryRandomOilSpareDetail(RandomOil objReq) throws Exception   ;
	 Map<String,Object>  randomOilRequestNoDetail(RandomOil objReq) throws Exception   ;
	 Map<String,Object>  assignRandomLastResultDetail(RandomOil objReq) throws Exception   ;
	   ResultObj   updateStatusSendRequest(RandomOil objReq) throws   Exception  ;
	 Map<String,Object> saveRandomOil(RandomOil objReq) throws Exception   ;
	 ResultObj updateStatusRandomOil(RandomOil objReq) throws Exception   ;
	 ResultObj updateStatusRandomOilDte(RandomOil objReq) throws Exception   ;
	 ResultObj updateReceiveFlgRandomOilDte(RandomOil objReq) throws Exception   ;
	 
	 ResultObj updateLtrDTE(RandomOil objReq) throws Exception   ;
	 ResultObj updateStatusLTRNO(RandomOil objReq) throws Exception   ;
	 Map<String,Object> editSubSeqRandomOil(RandomOil objReq) throws Exception   ;
	 List<Map<String, Object>> groupNameStoreRandomOil(RandomOil objReq) throws Exception   ;
	 Map<String, Object> getNameStoreSetupRandomOil(RandomOil objReq) throws Exception   ;
	 Map<String,Object> sendRequestRandomOil(RandomOil objReq) throws Exception   ;
	 Map<String,Object> insertRandomLastResult(RandomOil objReq) throws Exception   ;
	 Map<String,Object> sendRequestAssignRandomOil(RandomOil objReq) throws Exception   ;
	 Map<String,Object>  cntWaitingRandomLastResult(RandomOil objReq) throws Exception   ;
	 
	 Map<String,Object>  updateAssignFlagStatus(RandomOil objReq) throws Exception   ;
	Map<String, Object> getSampleData(RandomOil entity) throws Exception ;
	Map<String, Object> getWorkgroupMember(MemberWorkGroupBean bean) throws Exception ;
	Map<String, Object> getAssignmentFlag(GetItemListEntity entity) throws Exception ;
	Map<String, Object> updateAssignFlag ( SubmitRequestEntity entity ) throws Exception ;
	
	Map<String,Object> getAllTask(RandomOil objReq) throws Exception   ;
	
	Map<String,Object>  saveAssignment(ReturnAssignmentEntity entity) throws Exception   ;

	public Map<String, Object> insertAcssignJob(ParamMap paramMap, CreateRequestResponse response);

	List<RandomSampleDto> findSampleByLabCodes(List<String> labcode) throws Exception;

	Map<String,Object> saveTaskList(List<Map<String,Object>> list, String labCode, MemberObj member) throws Exception;
	boolean saveFlagAll(String labCode) throws Exception;
	boolean resultFlagYAndUpdate(String labCode, MemberObj member) throws Exception;
	boolean updateLtrResultStatus(LtrDto ltrDto) throws Exception;
	Map<String, Object> updateCarNo(RandomOil objReq) throws Exception;
	Map<String, Object> queryDataFreeCar(RandomOil objReq) throws Exception;
	Map<String, Object> updateCancelStatus(RandomOil objReq)throws Exception;
	Map<String, Object> checkPrint(RandomOil objReq) throws Exception;
	Map<String, Object> updateStatusSendAnalysis(RandomOil objReq) throws Exception;
	Map<String, Object> updateFlgRandom(RandomOil objReq) throws Exception;
	JasperPrint getDataRandomOilReport(RandomOil objReq);
	JasperPrint reportAssignmentWork(List<Map<String,Object>> obj);
	List<Map<String, Object>> inquiryRandomOilDetailGetList(RandomOil objReq) throws Exception;

}
