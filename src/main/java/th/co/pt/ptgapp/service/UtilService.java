package th.co.pt.ptgapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.entity.MobileLtrSpec;
import th.co.pt.ptgapp.entity.MobilePlant;
import th.co.pt.ptgapp.entity.MobileTool;
import th.co.pt.ptgapp.entity.VisualAndColor;
import th.co.pt.ptgapp.service.report.dto.AddNewSource;
import th.co.pt.ptgapp.service.report.dto.AddNewUser;
import th.co.pt.ptgapp.service.report.dto.LTRSpec;

 
 
public interface UtilService {
	List<Map<String, Object>> getDropdownPlant(RandomOil objReq);
	List<Map<String,Object>> getDropdownProduct();
	List<Map<String,Object>> getDropdownProductMobile();
	List<Map<String,Object>> getDropdownLogistics();
	List<Map<String,Object>> getDropdownSource();
	List<Map<String,Object>> getDropdownGetSample();
	List<Map<String,Object>> getDropdownSampleType();
	List<Map<String,Object>>  getDropdownMBRole() ;
	List<Map<String,Object>>  getDropdownTypeStation() ;
	List<Map<String,Object>> getDropdownTrip();
	List<Map<String,Object>>  getDropdownRegion(RandomOil objReq) ;
	List<Map<String,Object>>  getDropdownArea(RandomOil objReq) ;
	List<Map<String,Object>>  getDropdownProvince(RandomOil objReq) ;
	List<Map<String,Object>>  getSetupRandom(RandomOil objReq) ;
	List<Map<String,Object>>  getDropDownSetupColor(RandomOil objReq) ;
	List<Map<String,Object>>  getDropDownSetupColorASTM(RandomOil objReq) ;
	List<Map<String,Object>>  getDropDownVisual(RandomOil objReq) ;
	List<Map<String,Object>>  getCommentHistory(RandomOil objReq) ;
	List<Map<String, Object>> getDropdownTypeStation2();
	List<Map<String, Object>> getDropdownSavePoint();
	List<Map<String, Object>> getDropdownLogisticBoat();
	List<Map<String, Object>> getDropdownStatus();
	List<Map<String, Object>> getDropdowncauseChgStatus();
	List<Map<String, Object>> getDropdownSubType();
	List<Map<String, Object>> getAutoRandomFlg();
	List<Map<String, Object>> getUserCreateHistory(RandomOil objReq);
	List<Map<String, Object>> getProductionDescription();

	List<Map<String, Object>> getConfigWork(RandomOil objReq);
	List<Map<String, Object>> getSetupWork(RandomOil objReq);
	List<Map<String, Object>> getReasonRevise();
	List<Map<String, Object>> getuserdetail();
	List<Map<String, Object>> getRoleUser();
	List<Map<String, Object>> getPlantUser();
	Map<String, Object> checkProfile(MemberObj data);
	String saveImage(MultipartFile upload_signature);
	List<Map<String, Object>> addNewUser(AddNewUser addnewuser);
	List<Map<String,Object>> deleteUser(RandomOil objReq);
	List<Map<String, Object>> editOldUser(AddNewUser addnewuser);

	List<Map<String, Object>> getOilforEdit(RandomOil objReq);
	List<Map<String, Object>> saveEditOil(RandomOil objReq);
	List<Map<String, Object>> getUnitSpecForUpdate(RandomOil objReq);
	List<Map<String, Object>> saveSpecUnit(RandomOil objReq);
	List<Map<String, Object>> getVisual();
	List<Map<String, Object>> getColor();
	List<Map<String, Object>> getMyDetail(String codempid);
	List<Map<String, Object>> geteditdropdown(RandomOil objReq);
	List<Map<String, Object>> updateDynamicToolId(RandomOil objReq);
	List<Map<String, Object>> getWaitwork(String productID);
	List<Map<String, Object>> getmethodcondition(String methodDataAss);
	List<Map<String, Object>> getSpecMobileLtr(String productID);
	List<Map<String, Object>> getMobileTool();
	List<Map<String, Object>> getMobilePlant();
	List<Map<String, Object>> saveMobileLtrSpec(MobileLtrSpec mobileLtrSpec);
	List<Map<String, Object>> updateMobileTool(MobileTool mobileTool, String status);
	List<Map<String, Object>> deleteMobileTool(MobileTool mobileTool);
	List<Map<String, Object>> updateMobilePlant(MobilePlant mobilePlant, String status);
	List<Map<String, Object>> deleteMobilePlant(MobilePlant mobilePlant);
	List<Map<String, Object>> getrootcause();
	List<Map<String, Object>> saverootcause(String labcode, String rtcode, String rtdesc);
	List<Map<String, Object>> getVisualt();
	List<Map<String, Object>> updateVisual(VisualAndColor visualAndColor, String status);
	List<Map<String, Object>> deleteVisual(VisualAndColor visualAndColor);
	List<Map<String, Object>> updateColor(VisualAndColor visualAndColor, String status);
	List<Map<String, Object>> deleteColor(VisualAndColor visualAndColor);
	List<Map<String, Object>> checkIRPC(String labCode);
	List<Map<String, Object>> assignToTemp(String ltrNo,String empcode);
	List<Map<String, Object>> returnFromTemp(String ltrNo, String codempid);
	List<Map<String, Object>> saveSpecUncer(RandomOil objReq);
	void triggerUpdateLtrdtSub();
	List<Map<String, Object>> getsourcedetail(AddNewSource objReq);
	List<Map<String, Object>> deleteSource(AddNewSource objReq);
	List<Map<String, Object>> saveSource(AddNewSource objReq);
	List<Map<String, Object>> editSource(AddNewSource objReq);
	List<Map<String, Object>> updateLTRSpec(LTRSpec objReq);

	
}
