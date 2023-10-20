package th.co.pt.ptgapp.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import th.co.pt.ptgapp.controller.bean.MainMenuObj;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.ResultObj;
import th.co.pt.ptgapp.controller.bean.UserMenuObj;
import th.co.pt.ptgapp.dao.MenuDao;
import th.co.pt.ptgapp.dao.RandomOilDao;
import th.co.pt.ptgapp.dao.UtilDao;
import th.co.pt.ptgapp.entity.MobileLtrSpec;
import th.co.pt.ptgapp.entity.MobilePlant;
import th.co.pt.ptgapp.entity.MobileTool;
import th.co.pt.ptgapp.entity.VisualAndColor;
import th.co.pt.ptgapp.service.report.dto.AddNewSource;
import th.co.pt.ptgapp.service.report.dto.AddNewUser;
import th.co.pt.ptgapp.service.report.dto.LTRSpec;
import th.co.pt.ptgapp.utils.CGlobal;
import th.co.pt.ptgapp.utils.WebUtil;

 

@Repository("utilService")
public class UtilServiceImpl implements UtilService {
	@Autowired
	private UtilDao utilDao;
	
	@Autowired
	ServletContext context;
	
	@Value("${path.signature}")
	private String pathSignature;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<Map<String,Object>> getDropdownPlant(RandomOil objReq) {
 
		List<Map<String,Object>> obj=	utilDao.getDropdownPlant(objReq);
			
			return obj;
	}
	public List<Map<String,Object>> getDropdownProduct() {
		 
		List<Map<String,Object>> obj=	utilDao.getDropdownProduct();
			
			return obj;
	}
	public List<Map<String,Object>> getDropdownProductMobile() {
		 
		List<Map<String,Object>> obj=	utilDao.getDropdownProductMobile();
			
			return obj;
	}
	public List<Map<String,Object>> getDropdownLogistics() {
		 
		List<Map<String,Object>> obj=	utilDao.getDropdownLogistics();
			
			return obj;
	}
	public List<Map<String,Object>> getAutoRandomFlg() {
		 
		List<Map<String,Object>> obj=	utilDao.getAutoRandomFlg();
			
			return obj;
	}
	public List<Map<String,Object>> getDropdownSource() {
		 
		List<Map<String,Object>> obj=	utilDao.getDropdownSource();
			
			return obj;
	}
	public List<Map<String,Object>> getDropdownGetSample() {
		 
		List<Map<String,Object>> obj=	utilDao.getDropdownGetSample();
			
			return obj;
	}
	public List<Map<String,Object>> getDropdownSampleType() {
		 
		List<Map<String,Object>> obj=	utilDao.getDropdownSampleType();
			
			return obj;
	}
	 public List<Map<String,Object>>  getDropdownMBRole() {	 
		List<Map<String,Object>> obj=	utilDao.getDropdownMBRole();
			
			return obj;
	}
	 public List<Map<String,Object>> getDropdownTypeStation() {
		 
			List<Map<String,Object>> obj=	utilDao.getDropdownTypeStation();
				
				return obj;
	 }
	public List<Map<String,Object>> getDropdownRegion(RandomOil objReq) {
		 
		List<Map<String,Object>> obj=	utilDao.getDropdownRegion(objReq);
			
			return obj;
	}
	 public List<Map<String,Object>>  getDropdownArea(RandomOil objReq) {	 
		List<Map<String,Object>> obj=	utilDao.getDropdownArea(objReq);
			
			return obj;
	}
	 public List<Map<String,Object>>  getDropdownProvince(RandomOil objReq) {	 
			List<Map<String,Object>> obj=	utilDao.getDropdownProvince(objReq);
				
				return obj;
	 }
	 public List<Map<String,Object>>  getSetupRandom(RandomOil objReq) {	 
			List<Map<String,Object>> obj=	utilDao.getSetupRandom(objReq);
				
				return obj;
	 }
	 public List<Map<String,Object>>  getDropDownSetupColor(RandomOil objReq) {	 
			List<Map<String,Object>> obj=	utilDao.getDropDownSetupColor(objReq);
				
				return obj;
	 }
	 public List<Map<String,Object>>  getDropDownSetupColorASTM(RandomOil objReq) {	 
			List<Map<String,Object>> obj=	utilDao.getDropDownSetupColorASTM(objReq);
				
				return obj;
	 }
	 public List<Map<String,Object>>  getDropDownVisual(RandomOil objReq) {	 
			List<Map<String,Object>> obj=	utilDao.getDropDownVisual(objReq);
				
				return obj;
	 }
	 public List<Map<String,Object>>  getCommentHistory(RandomOil objReq) {	 
			List<Map<String,Object>> obj=	utilDao.getCommentHistory(objReq);
				
				return obj;
	 }
	 public List<Map<String,Object>> getDropdownTypeStation2() {
		 
			List<Map<String,Object>> obj=	utilDao.getDropdownTypeStation2();
				
				return obj;
	 }
	 public List<Map<String,Object>> getDropdownSavePoint() {
		 
			List<Map<String,Object>> obj=	utilDao.getDropdownSavePoint();
				
				return obj;
	 }
	 public List<Map<String,Object>> getDropdownStatus() {
		 
			List<Map<String,Object>> obj=	utilDao.getDropdownStatus();
				
				return obj;
	 }
	 public List<Map<String,Object>> getDropdownLogisticBoat() {
		 
			List<Map<String,Object>> obj=	utilDao.getDropdownLogisticBoat();
				
				return obj;
	 }
	@Override
	public List<Map<String, Object>> getDropdownTrip() {
		List<Map<String,Object>> obj=	utilDao.getDropdownTrip();
		
		return obj;
	}
	@Override
	public List<Map<String, Object>> getDropdowncauseChgStatus() {
		List<Map<String,Object>> obj=	utilDao.getDropdowncauseChgStatus();
		
		return obj;
	}
	public List<Map<String, Object>> getDropdownSubType() {
		List<Map<String,Object>> obj=	utilDao.getDropdownSubType();
		
		return obj;
	}
	@Override
	public List<Map<String, Object>> getUserCreateHistory(RandomOil objReq) {
		List<Map<String,Object>> obj=	utilDao.getUserCreateHistory(objReq);
		
		return obj;
	}
	@Override
	public List<Map<String, Object>> getProductionDescription() {
		List<Map<String,Object>> obj=	utilDao.getProductionDescription();
		
		return obj;
	}


	@Override
	public List<Map<String, Object>> getConfigWork(RandomOil objReq) {
		List<Map<String,Object>> obj=	utilDao.getConfigWork(objReq);
		
		return obj;
	}
	@Override
	public List<Map<String, Object>> getSetupWork(RandomOil objReq) {
		List<Map<String,Object>> obj=	utilDao.getSetupWork(objReq);
		
		return obj;
	}
	@Override
	public List<Map<String, Object>> getReasonRevise() {
		List<Map<String,Object>> obj=	utilDao.getReasonRevise();
		
		return obj;
	}
	@Override
	public List<Map<String, Object>> getuserdetail() {
		List<Map<String,Object>> obj=	utilDao.getuserdetail();
		
		return obj;
	}
	@Override
	public List<Map<String, Object>> getsourcedetail(AddNewSource objReq) {
		List<Map<String,Object>> obj=	utilDao.getsourcedetail(objReq);
		
		return obj;
	}
	@Override
	public List<Map<String, Object>> getRoleUser() {
		List<Map<String,Object>> obj=	utilDao.getRoleUser();
		
		return obj;
	}
	@Override
	public List<Map<String, Object>> getPlantUser() {
		List<Map<String,Object>> obj=	utilDao.getPlantUser();
		
		return obj;
	}
	@Override
	public Map<String, Object> checkProfile(MemberObj data) {
		Map<String,Object> map = null;
		Map<String,Object> subData = null;
		try {
			logger.info("codempid : "+data.getCodempid());
			//FOR TEST
			map = new HashMap<>();
			
			List<Map<String,Object>> obj=	utilDao.checkDuplicateUser(data.getCodempid());
			if(obj.size()>0) {
				map.put("resultCode", "01");
				map.put("messageError", "Duplicate User");
				return map;
			}
			
			subData = new HashMap<String, Object>();
			String uri = WebUtil.WebServiceUrl() + "HrisService/member-getmemberprofile";
			

			RestTemplate restTemplate = new RestTemplate();
			MemberObj member_data = restTemplate.postForObject(uri, data,MemberObj.class);
			
			
			if(member_data.getNamempt()!=null&&member_data.getNamempt()!="") {
				subData.put("namempt",member_data.getNamempt());
				map.put("resultCode", "00");
				map.put("data", subData);
				logger.info("resultCode : "+ "00");
			}else {
				logger.info("resultCode : "+"01");
				map.put("resultCode", "01");
				map.put("messageError", "User not found");
			}

		}catch(Exception e) {
			
		}
		return map;
	}
	@Override
	public String saveImage(MultipartFile upload_signature) {
	   	 InputStream inputStream = null;
         OutputStream outputStream = null;
         String pathlicen =null;
         UUID uuid =null;
         File newFile = null;
         String path=null;
         String fileName=upload_signature.getOriginalFilename();
		try {
			  pathlicen= context.getRealPath(pathSignature);
			  uuid=UUID.randomUUID();
			  newFile=new File(pathlicen + uuid+"."+fileName.split("\\.")[1]);
			  path= pathSignature+uuid+"."+fileName.split("\\.")[1];
			  inputStream = upload_signature.getInputStream();

	             if (!newFile.exists()) {
	                 newFile.createNewFile();
	             }
	             outputStream = new FileOutputStream(newFile);
	             int read = 0;
	             byte[] bytes = new byte[1024];

	             while ((read = inputStream.read(bytes)) != -1) {
	                 outputStream.write(bytes, 0, read);
	             }  
	         
		}catch(Exception e) {
			e.printStackTrace();
		}
		return path;
		
	}
	@Override
	public List<Map<String, Object>> addNewUser(AddNewUser addnewuser) {
		List<Map<String, Object>> obj=	utilDao.addNewUser(addnewuser);
		return obj;
	}
	@Override
	public List<Map<String,Object>> deleteUser(RandomOil objReq) {
		List<Map<String, Object>> obj=	utilDao.deleteUser(objReq);
		return obj;
	}
	@Override
	public List<Map<String,Object>> deleteSource(AddNewSource objReq ) {
		List<Map<String, Object>> obj=	utilDao.deleteSource(objReq);
		return obj;
	}
	@Override
	public List<Map<String, Object>> editOldUser(AddNewUser addnewuser) {
		List<Map<String, Object>> obj=	utilDao.editOldUser(addnewuser);
		return obj;
	}
	@Override
	public List<Map<String, Object>> getOilforEdit(RandomOil objReq) {
		List<Map<String, Object>> obj=	utilDao.getOilforEdit(objReq);
		return obj;
	}
	@Override
	public List<Map<String, Object>> saveEditOil(RandomOil objReq) {
		List<Map<String, Object>> obj=	utilDao.saveEditOil(objReq);
		return obj;
	}
	@Override
	public List<Map<String, Object>> getUnitSpecForUpdate(RandomOil objReq) {
		List<Map<String, Object>> obj=	utilDao.getUnitSpecForUpdate(objReq);
		return obj;
	}
	@Override
	public List<Map<String, Object>> saveSpecUnit(RandomOil objReq) {
		List<Map<String, Object>> obj=	utilDao.saveSpecUnit(objReq);
		return obj;
	}
	@Override
	public List<Map<String, Object>> getVisual() {
		List<Map<String, Object>> obj=	utilDao.getVisual();
		return obj;
	}
	@Override
	public List<Map<String, Object>> getColor() {
		List<Map<String, Object>> obj=	utilDao.getColor();
		return obj;
	}
	@Override
	public List<Map<String, Object>> getMyDetail(String codempid) {
		List<Map<String,Object>> obj=	utilDao.checkDuplicateUser(codempid);
		return obj;
	}
	@Override
	public List<Map<String, Object>> geteditdropdown(RandomOil objReq) {
		List<Map<String,Object>> obj=	utilDao.geteditdropdown(objReq);
		return obj;
	}
	@Override
	public List<Map<String, Object>> updateDynamicToolId(RandomOil objReq) {
		List<Map<String,Object>> obj=	utilDao.updateDynamicToolId(objReq);
		return obj;
	}
	@Override
	public List<Map<String, Object>> getWaitwork(String productID) {
		List<Map<String,Object>> obj=null;
		List<Map<String,Object>> getlab=null;
		String labcodeArr = "";
		try {
			getlab = utilDao.getLabWaitwork(productID);
			if(getlab.size()>0) {
				labcodeArr="";
				for(Map<String,Object>map:getlab) {
					labcodeArr+="'"+map.get("LAB_CODE").toString()+"',";
				}
			labcodeArr=labcodeArr.substring(0,labcodeArr.length()-1);
			}
			
			obj=	utilDao.getWaitwork(productID,labcodeArr);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
	@Override
	public List<Map<String, Object>> getmethodcondition(String methodDataAss) {
		List<Map<String,Object>> obj=	utilDao.getmethodcondition(methodDataAss);
		return obj;
	}
	@Override
	public List<Map<String, Object>> getSpecMobileLtr(String productID) {
		List<Map<String,Object>> obj=	utilDao.getSpecMobileLtr(productID);
		return obj;
	}
	@Override
	public List<Map<String, Object>> getMobileTool() {
		List<Map<String,Object>> obj=	utilDao.getMobileTool();
		return obj;
	}
	@Override
	public List<Map<String, Object>> getMobilePlant() {
		List<Map<String,Object>> obj=	utilDao.getMobilePlant();
		return obj;
	}
	@Override
	public List<Map<String, Object>> saveMobileLtrSpec(MobileLtrSpec mobileLtrSpec) {
		List<Map<String,Object>> obj=	utilDao.saveMobileLtrSpec(mobileLtrSpec);
		return obj;
	}
	@Override
	public List<Map<String, Object>> updateMobileTool(MobileTool mobileTool, String status) {
		List<Map<String,Object>> obj=	utilDao.updateMobileTool(mobileTool,status);
		return obj;
	}
	@Override
	public List<Map<String, Object>> deleteMobileTool(MobileTool mobileTool) {
		List<Map<String,Object>> obj=	utilDao.deleteMobileTool(mobileTool);
		return obj;
	}
	@Override
	public List<Map<String, Object>> updateMobilePlant(MobilePlant mobilePlant, String status) {
		List<Map<String,Object>> obj=	utilDao.updateMobilePlant(mobilePlant,status);
		return obj;
	}
	@Override
	public List<Map<String, Object>> deleteMobilePlant(MobilePlant mobilePlant) {
		List<Map<String,Object>> obj=	utilDao.deleteMobilePlant(mobilePlant);
		return obj;
	}
	@Override
	public List<Map<String, Object>> getrootcause() {
		List<Map<String,Object>> obj=	utilDao.getrootcause();
		return obj;
	}
	@Override
	public List<Map<String, Object>> saverootcause(String labcode, String rtcode, String rtdesc) {
		List<Map<String,Object>> obj=	utilDao.saverootcause(labcode,rtcode,rtdesc);
		return obj;
	}
	@Override
	public List<Map<String, Object>> getVisualt() {
		List<Map<String,Object>> obj=	utilDao.getVisualt();
		return obj;
	}
	@Override
	public List<Map<String, Object>> updateVisual(VisualAndColor visualAndColor, String status) {
		List<Map<String,Object>> obj=	utilDao.updateVisual(visualAndColor,status);
		return obj;
	}
	@Override
	public List<Map<String, Object>> deleteVisual(VisualAndColor visualAndColor) {
		List<Map<String,Object>> obj=	utilDao.deleteVisual(visualAndColor);
		return obj;
	}
	@Override
	public List<Map<String, Object>> updateColor(VisualAndColor visualAndColor, String status) {
		List<Map<String,Object>> obj=	utilDao.updateColor(visualAndColor,status);
		return obj;
	}
	@Override
	public List<Map<String, Object>> deleteColor(VisualAndColor visualAndColor) {
		List<Map<String,Object>> obj=	utilDao.deleteColor(visualAndColor);
		return obj;
	}
	@Override
	public List<Map<String, Object>> checkIRPC(String labCode) {
		List<Map<String,Object>> obj=	utilDao.checkIRPC(labCode);
		return obj;
	}
	@Override
	public List<Map<String, Object>> assignToTemp(String ltrNo,String empcode) {
		List<Map<String,Object>> obj=	utilDao.assignToTemp(ltrNo,empcode);
		return obj;
	}
	@Override
	public List<Map<String, Object>> returnFromTemp(String ltrNo, String codempid) {
		List<Map<String,Object>> obj=	utilDao.returnFromTemp(ltrNo,codempid);
		return obj;
	}
	@Override
	public List<Map<String, Object>> saveSpecUncer(RandomOil objReq) {
		List<Map<String, Object>> obj=	utilDao.saveSpecUncer(objReq);
		return obj;
	}
	@Override
	public List<Map<String, Object>> saveSource(AddNewSource objReq) {
		List<Map<String, Object>> obj=	utilDao.saveNewSource(objReq);
		return obj;
	}
	@Override
	public List<Map<String, Object>> editSource(AddNewSource objReq) {
		List<Map<String, Object>> obj=	utilDao.editSource(objReq);
		return obj;
	}
	@Override
	public void triggerUpdateLtrdtSub() {
		utilDao.triggerUpdateLtrdtSub();
		
	}
	@Override
	public List<Map<String, Object>> updateLTRSpec(LTRSpec objReq) {
		// TODO Auto-generated method stub
		return utilDao.updateLTRSpec(objReq);
	}

	
}
