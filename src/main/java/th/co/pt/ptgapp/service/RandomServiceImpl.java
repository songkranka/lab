package th.co.pt.ptgapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.ResultObj;
import th.co.pt.ptgapp.controller.bean.workflow.GetItemListEntity;
import th.co.pt.ptgapp.controller.bean.workflow.MemberWorkGroupBean;
import th.co.pt.ptgapp.controller.bean.workflow.ReturnAssignmentEntity;
import th.co.pt.ptgapp.controller.bean.workflow.SubmitRequestEntity;
import th.co.pt.ptgapp.dao.RandomOilDao;
import th.co.pt.ptgapp.dao.task.LtrDao;
import th.co.pt.ptgapp.dao.task.LtrDto;
import th.co.pt.ptgapp.entity.report.ReportRequestNo;
import th.co.pt.ptgapp.service.ws.lotusnotes.dto.RandomSampleDto;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.CreateRequestResponse;
import th.co.pt.ptgapp.utils.ParamMap;
import th.co.pt.ptgapp.utils.ReportUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("randomService")
public class RandomServiceImpl   implements RandomService
{
	@Autowired
	private RandomOilDao randomOilDao;
	@Autowired
	private LtrDao ltrDao;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public  Map<String,Object>   saveRandomOil(RandomOil objReq) throws   Exception   {
    	 Map<String,Object>     obj =  new  HashMap<String,Object>();
    	try{
    	        
    	 RandomOil recObjReq = randomOilDao.insertGroupRandomOil(objReq);
    	 logger.info("response insert group : "+recObjReq.toString());
    	 
	     if(recObjReq.getResult().equals("1")){	 
		    obj= randomOilDao.summaryRandomOilDetail(recObjReq);
	     }
		 obj.put("success", recObjReq.getResult())  ;
	     obj.put("message", recObjReq.getMessage());
       }catch(Exception ex){
    	   obj.put("success", "0")  ;
  	     obj.put("message", ex.getMessage());
       }
		return obj;
       
    }
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public  Map<String,Object>   editSubSeqRandomOil(RandomOil objReq) throws   Exception   {
       
    	 Map<String,Object>     obj =  new  HashMap<String,Object>();
    	         
    	 RandomOil recObjReq = randomOilDao.editSubSeqRandomOil(objReq);
	      
		 obj.put("success", recObjReq.getResult())  ;
	     obj.put("message", recObjReq.getMessage());
	     	 
		return obj;
       
    }
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public  Map<String,Object>   sendRequestRandomOil(RandomOil objReq) throws   Exception   {
       
    	 Map<String,Object>     obj =  new  HashMap<String,Object>();
    	  
		   
		    	  randomOilDao.insertRequestAnalysis(objReq) ;
		    	 //--X randomOilDao.updateReqNoRandomOilDTE(objReq);
		    	  
		    	 obj.put("success", objReq.getResult())  ;
		    	 obj.put("message", objReq.getMessage())  ;
		    	 obj.put("hd_no", objReq.getReqNo());
		return obj;
       
    }
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public  Map<String,Object>   updateStatusSendAnalysis(RandomOil objReq) throws   Exception   {
       
    	 Map<String,Object>     obj =  new  HashMap<String,Object>();	   
		 randomOilDao.updateStatusSendAnalysis(objReq) ;	    	  
		 obj.put("success", objReq.getResult())  ;
		 obj.put("message", objReq.getMessage())  ;
		 return obj;
       
    }
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ResultObj   updateStatusRandomOil(RandomOil objReq) throws   Exception   {
       
    	ResultObj obj  =  new ResultObj();
    	  
	     	 randomOilDao.updateStatusRandomOil(objReq) ;
	    	   
		return obj;
       
    }
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ResultObj   updateStatusRandomOilDte(RandomOil objReq) throws   Exception   {
       
    	ResultObj obj  =  new ResultObj();
    	  
	     	 randomOilDao.updateStatusRandomOilDte(objReq) ;
	     	 obj.setSuccess(Integer.parseInt(objReq.getResult()));
	 	    obj.setMessage(objReq.getMessage());	   
		return obj;
       
    }
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ResultObj   updateReceiveFlgRandomOilDte(RandomOil objReq) throws   Exception   {
       
    	ResultObj obj  =  new ResultObj();
    	  
	     	 randomOilDao.updateReceiveFlgRandomOilDte(objReq) ;
	    obj.setSuccess(Integer.parseInt(objReq.getResult()));
	    obj.setMessage(objReq.getMessage());
	     	 
	    	   
		return obj;
       
    }
    
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ResultObj   updateLtrDTE(RandomOil objReq) throws   Exception   {
       
    	ResultObj obj  =  new ResultObj();
    	  
	     	 randomOilDao.updateLtrDTE(objReq) ;
	    obj.setSuccess(Integer.parseInt(objReq.getResult()));
	    obj.setMessage(objReq.getMessage());
	     	 
	    	   
		return obj;
       
    }
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ResultObj   updateStatusLTRNO(RandomOil objReq) throws   Exception   {
       
    	ResultObj obj  =  new ResultObj();
    	  
	     	 randomOilDao.updateStatusLTRNO(objReq) ;
	     	 obj.setSuccess(Integer.parseInt(objReq.getResult()));
	 	    obj.setMessage(objReq.getMessage());	   
		return obj;
       
    }
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public ResultObj   updateStatusSendRequest(RandomOil objReq) throws   Exception   {
       
    	ResultObj obj  =  new ResultObj();
    	  
	     	 randomOilDao.updateStatusSendRequest(objReq) ;
	    obj.setSuccess(Integer.parseInt(objReq.getResult()));
	    obj.setMessage(objReq.getMessage());
	     	 
	    	   
		return obj;
       
    }
    @Override
    public  Map<String,Object>    inquirySaveResultAnalysisOil(RandomOil objReq) throws   Exception   {
        
   	 Map<String,Object>  obj  =  new  HashMap<String,Object>();
   	 
   	   
   	 obj=	randomOilDao.inquirySaveResultAnalysisOil(objReq);
		 
      
		return obj;
      
   }
    @Override
    public  Map<String,Object>    inquiryLTRNO(RandomOil objReq) throws   Exception   {
        
   	 Map<String,Object>  obj  =  new  HashMap<String,Object>();
   	 
   	   
   	 obj=	randomOilDao.inquiryLTRNO(objReq);
		 
      
		return obj;
      
   }
    @Override
    public  Map<String,Object>    inquiryLTRByLTRNO(RandomOil objReq) throws   Exception   {
        
   	 Map<String,Object>  obj  =  new  HashMap<String,Object>();
   	 
   	   
   	 obj=	randomOilDao.inquiryLTRByLTRNO(objReq);
		 
      
		return obj;
      
   }
    @Override
    public  Map<String,Object>    inquiryAnalyzeSpec(RandomOil objReq) throws   Exception   {
        
   	 Map<String,Object>  obj  =  new  HashMap<String,Object>();
   	 
   	   
   	 obj=	randomOilDao.inquiryAnalyzeSpec(objReq);
		 
      
		return obj;
      
   }
    @Override
    public  Map<String,Object>    inquiryRequestAnalysis(RandomOil objReq) throws   Exception   {
        
   	 Map<String,Object>  obj  =  new  HashMap<String,Object> ();
   	 
   	   
   	 obj=	randomOilDao.inquiryRequestAnalysis(objReq);
		 
      
		return obj;
      
   }
    @Override
    public  Map<String,Object>    inquiryRequestAnalysisOilDetail(RandomOil objReq) throws   Exception   {
        
   	 Map<String,Object>  obj  =  new  HashMap<String,Object> ();
   	 
   	   
   	 obj=	randomOilDao.inquiryRequestAnalysisOilDetail(objReq);
		 
      
		return obj;
      
   }
    @Override
    public Map<String, Object> updateCarNo(RandomOil objReq) throws   Exception   {
        
    	Map<String,Object>     obj =  new  HashMap<String,Object>();
    	obj  = randomOilDao.updateCarNo(objReq);
		return obj; 
   }
    @Override
    public Map<String, Object> checkPrint(RandomOil objReq) throws   Exception   {
        
    	Map<String,Object>     obj =  new  HashMap<String,Object>();
    	obj  = randomOilDao.checkPrint(objReq);
		return obj; 
   }
    @Override
    public Map<String, Object> updateCancelStatus(RandomOil objReq) throws   Exception   {
        
    	Map<String,Object>     obj =  new  HashMap<String,Object>();
    	obj  = randomOilDao.updateCancelStatus(objReq);
		return obj; 
   }
    @Override
    public Map<String, Object> updateFlgRandom(RandomOil objReq) throws   Exception   {
        
    	Map<String,Object>     obj =  new  HashMap<String,Object>();
    	obj  = randomOilDao.updateFlgRandom(objReq);
		return obj; 
   }
    @Override
    public Map<String, Object> queryDataFreeCar(RandomOil objReq) throws   Exception   {
        
    	Map<String,Object>     obj =  new  HashMap<String,Object>();
    	obj  = randomOilDao.queryDataFreeCar(objReq);
		return obj; 
   }
    @Override
    public  Map<String,Object>    inquiryRandomOilDetail(RandomOil objReq) throws   Exception   {
        
    	 Map<String,Object>  obj  =  new  HashMap<String,Object> ();
    	 
    	   
    	 obj=	randomOilDao.inquiryRandomOilDetail(objReq);
		 
       
		return obj;
       
    }
    @Override
    public  Map<String,Object>    inquiryRandomLastResult(RandomOil objReq) throws   Exception   {
        
    	 Map<String,Object>  obj  =  new  HashMap<String,Object> ();
    	 
    	   
    	 obj=	randomOilDao.inquiryRandomLastResult(objReq);
		 
       
		return obj;
       
    }
    @Override
    public  Map<String,Object>    inquiryRandomOilSpareDetail(RandomOil objReq) throws   Exception   {
    	 
    	 Map<String,Object>  obj  =  new  HashMap<String,Object> ();
    	 
    	   
    	 obj=	randomOilDao.inquirySpareGroupDetail(objReq);
		 
       
		return obj;
       
    }
    @Override
    public  Map<String,Object>    randomOilRequestNoDetail(RandomOil objReq) throws   Exception   {
    	 
    	 Map<String,Object>  obj  =  new  HashMap<String,Object> ();
    	 
    	   
    	 obj=	randomOilDao.randomOilRequestNoDetail(objReq);
		 
       
		return obj;
       
    }
    @Override
    public  Map<String,Object>    assignRandomLastResultDetail(RandomOil objReq) throws   Exception   {
    	 
    	 Map<String,Object>  obj  =  new  HashMap<String,Object> ();
    	 
    	   
    	 obj=	randomOilDao.assignRandomLastResultDetail(objReq);
		 
       
		return obj;
       
    }
    @Override
    public  List<Map<String, Object>>    groupNameStoreRandomOil(RandomOil objReq) throws   Exception   {
        
    	 List<Map<String, Object>> list=	randomOilDao.groupNameStoreRandomOil(objReq);
		  
		return list;
       
    }
    @Override
    public  Map<String, Object>    getNameStoreSetupRandomOil(RandomOil objReq) throws   Exception   {
        
    	  Map<String, Object>  list=	randomOilDao.getNameStoreSetupRandomOil(objReq);
		  
		return list;
       
    }
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public  Map<String,Object>   insertRandomLastResult(RandomOil objReq) throws   Exception   {
    	 Map<String,Object>     obj =  new  HashMap<String,Object>();
    	try{
    	
    	         
    	 RandomOil recObjReq = randomOilDao.insertRandomLastResult(objReq);
	     if(recObjReq.getResult().equals("1")){	 
		    obj= randomOilDao.summaryRandomLastResult(recObjReq);
	     } 
		 obj.put("success", recObjReq.getResult())  ;
	     obj.put("message", recObjReq.getMessage());
       }catch(Exception ex){
    	   obj.put("success", "0")  ;
  	     obj.put("message", ex.getMessage());
       }
		return obj;
       
    }
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public  Map<String,Object>   sendRequestAssignRandomOil(RandomOil objReq) throws   Exception   {
    	 Map<String,Object>     obj =  new  HashMap<String,Object>();
    		 
    	try{
    	
    	         
    	 RandomOil recObjReq = randomOilDao.sendRequestAssignRandomOil(objReq);
	    
		 obj.put("success", recObjReq.getResult())  ;
	     obj.put("message", recObjReq.getMessage());
       }catch(Exception ex){
    	   obj.put("success", "0")  ;
  	     obj.put("message", ex.getMessage());
       }
		return obj;
       
    }
    @Override
    public  Map<String, Object>    cntWaitingRandomLastResult(RandomOil objReq) throws   Exception   {
        
    	  Map<String, Object>  list=	randomOilDao.cntWaitingRandomLastResult(objReq);
		  
		return list;
       
    }
	@Override
	public Map<String, Object> updateAssignFlagStatus(RandomOil objReq) throws Exception {
		return randomOilDao.updateFlagAssignmentResult(objReq);
	}
	@Override
	public Map<String, Object> getSampleData(RandomOil entity) throws Exception {
		return randomOilDao.getSampleData(entity);
	}
	@Override
	public Map<String, Object> getWorkgroupMember(MemberWorkGroupBean bean) throws Exception {
		return randomOilDao.getWorkgroupMember(bean);
	}
	@Override
	public Map<String, Object> getAssignmentFlag(GetItemListEntity entity) throws Exception {
		return randomOilDao.getAssignFlag(entity);
	}
	@Override
	public Map<String, Object> updateAssignFlag(SubmitRequestEntity entity) throws Exception {
		return randomOilDao.updateAssignFlag(entity);
	}
	@Override
	public Map<String, Object> getAllTask(RandomOil objReq) throws Exception {
		return randomOilDao.getAllTask(objReq);
	}
	@Override
	public Map<String, Object> saveAssignment(ReturnAssignmentEntity entity) throws Exception {
		return randomOilDao.saveAssignment(entity);
	}

	@Override
	public Map<String, Object> insertAcssignJob(ParamMap paramMap, CreateRequestResponse response) {
		return randomOilDao.insertAcssignJob(paramMap,response);
	}

	@Override
	public List<RandomSampleDto> findSampleByLabCodes(List<String> labcode) throws Exception {
		return randomOilDao.findSampleByLabCodes(labcode);
	}

	@Override
	public Map<String, Object> saveTaskList(List<Map<String, Object>> list, String labCode, MemberObj member) throws Exception {
		return randomOilDao.saveTaskList(list,labCode,member);
	}

	@Override
	public boolean saveFlagAll(String labCode) throws Exception {
		return ltrDao.saveFlagAll(labCode);
	}

    @Override
    public boolean resultFlagYAndUpdate(String labCode,MemberObj member) throws Exception {
    	if(ltrDao.resultFlagY(labCode)){
    		LtrDto ltrDto = new LtrDto();
    		ltrDto.setResultLtr("Y");
    		ltrDto.setUpdateBy(member.getCodempid());
    		ltrDto.setLabCode(labCode);
    		return ltrDao.updateResultLtr(ltrDto);
		}else {
    		return false;
		}
    }

	@Override
	public boolean updateLtrResultStatus(LtrDto ltrDto) throws Exception {
		return ltrDao.updateLtrResultStatus(ltrDto);
	}
	@Override
	public JasperPrint getDataRandomOilReport(RandomOil objReq) {
		List<Map<String, Object>>  obj =null;
		ReportRequestNo pr =null;
		Map<String,Object> map =null;
		List<ReportRequestNo> listExport =null;
		JRBeanCollectionDataSource jr  = null;
		JasperPrint jasperPrint = null;	
		 try {
			 listExport = new ArrayList<>();
			 map = new HashMap<String, Object>();
			 obj=  new  ArrayList<>();
			 obj=	randomOilDao.getDataRandomOilReport(objReq);
			 for(Map<String,Object> m:obj) {
	    			pr=new ReportRequestNo();
	    			pr.setLabCode(m.get("LAB_CODE").toString());
	    			pr.setType(m.get("SAMPLE_TYPE_NAME")==null?"":m.get("SAMPLE_TYPE_NAME").toString());
	    			pr.setProduct(m.get("PRODUCT_NAME")==null?"":m.get("PRODUCT_NAME").toString());
	    			pr.setRef(m.get("SOURCE_NAME")==null?"":m.get("SOURCE_NAME").toString());
	    			if("T".equals(pr.getType())) {
	    				pr.setTransportationSystem("-");
	    			}else {
	    				pr.setTransportationSystem(m.get("LOGIS_NAME")==null?"":m.get("LOGIS_NAME").toString());
	    			}
	    			pr.setCollectionFormat(m.get("SAMPLE_LEVEL_DESC")==null?"":m.get("SAMPLE_LEVEL_DESC").toString());
	    			pr.setRandomGroup(m.get("SAMPLE_REFER")==null?"":m.get("SAMPLE_REFER").toString());
	    			pr.setPoNumber(m.get("PO_NO")==null?"":m.get("PO_NO").toString());
	    			pr.setPoDate(m.get("STRPO_DATE")==null?"":m.get("STRPO_DATE").toString());
	    			pr.setDoNumber(m.get("DO_NO")==null?"":m.get("DO_NO").toString());
	    			pr.setShipmentNo(m.get("SHIPMENT_NO")==null?"":m.get("SHIPMENT_NO").toString());
	    			pr.setNo(m.get("SAMPLE_DATA_GROUP")==null?"":m.get("SAMPLE_DATA_GROUP").toString());
	    			pr.setSubNo(m.get("SAMPLE_DATA_SEQ")==null?"":m.get("SAMPLE_DATA_SEQ").toString());
	    			pr.setMeterNo(m.get("METER_NO")==null?"":m.get("METER_NO").toString());
	    			pr.setCarNo(m.get("CAR_NO")==null?"":m.get("CAR_NO").toString());
	    			pr.setCarLane(m.get("CAR_SLOT")==null?"":m.get("CAR_SLOT").toString());
	    			pr.setNameBoat(m.get("BOAT_NAME")==null?"":m.get("BOAT_NAME").toString());
	    			pr.setBoatLaneP(m.get("BOAT_SLOTP")==null?"":m.get("BOAT_SLOTP").toString());
	    			pr.setBoatLaneS(m.get("BOAT_SLOTS")==null?"":m.get("BOAT_SLOTS").toString());
	    			pr.setLotNo(m.get("ADTV_LOT_NO")==null?"":m.get("ADTV_LOT_NO").toString());
	    			pr.setRandomDate(m.get("STR_SAMPLE_DATE")==null?"":m.get("STR_SAMPLE_DATE").toString());
	    			pr.setDateExpier(m.get("STR_SAMPLE_EXPIRE_DATE")==null?"":m.get("STR_SAMPLE_EXPIRE_DATE").toString());
	    			pr.setEmployeeCode(m.get("SAMPLE_STAFF_ID")==null?"":m.get("SAMPLE_STAFF_ID").toString());
	    			pr.setEmployeeName(m.get("SAMPLE_STAFF_NAME")==null?"":m.get("SAMPLE_STAFF_NAME").toString());
	    			listExport.add(pr);
	    		} 
			    jr = new JRBeanCollectionDataSource(listExport);
	 			map.put("CollectionBeanParam", jr);
	 			map.put("request_number", objReq.getReqNo());
	 			jasperPrint=ReportUtils.exportReport("REQUEST_NO",map , new JREmptyDataSource());
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
       
		return jasperPrint;
	}
	
	
	@Override
	public JasperPrint reportAssignmentWork(List<Map<String,Object>>  obj) {
		
		ReportRequestNo pr =null;
		Map<String,Object> map =null;
		List<ReportRequestNo> listExport =null;
		JRBeanCollectionDataSource jr  = null;
		JasperPrint jasperPrint = null;	
		 try {
			 listExport = new ArrayList<>();
			 map = new HashMap<String, Object>();
			 for(Map<String,Object> m:obj) {
	    			pr=new ReportRequestNo();
	    			pr.setLabCode(m.get("LAB_CODE").toString());
	    			pr.setType(m.get("SAMPLE_TYPE_NAME")==null?"":m.get("SAMPLE_TYPE_NAME").toString());
	    			pr.setProduct(m.get("PRODUCT_NAME")==null?"":m.get("PRODUCT_NAME").toString());
	    			pr.setRef(m.get("SOURCE_NAME")==null?"":m.get("SOURCE_NAME").toString());
	    			if("T".equals(pr.getType())) {
	    				pr.setTransportationSystem("-");
	    			}else {
	    				pr.setTransportationSystem(m.get("LOGIS_NAME")==null?"":m.get("LOGIS_NAME").toString());
	    			}
	    			pr.setCollectionFormat(m.get("SAMPLE_LEVEL_DESC")==null?"":m.get("SAMPLE_LEVEL_DESC").toString());
	    			pr.setRandomGroup(m.get("SAMPLE_REFER")==null?"":m.get("SAMPLE_REFER").toString());
	    			pr.setPoNumber(m.get("PO_NO")==null?"":m.get("PO_NO").toString());
	    			pr.setPoDate(m.get("STR_SAMPLE_DATE")==null?"":m.get("STR_SAMPLE_DATE").toString());
	    			pr.setDoNumber(m.get("DO_NO")==null?"":m.get("DO_NO").toString());
	    			pr.setShipmentNo(m.get("SHIPMENT_NO")==null?"":m.get("SHIPMENT_NO").toString());
	    			pr.setNo(m.get("SAMPLE_DATA_GROUP")==null?"":m.get("SAMPLE_DATA_GROUP").toString());
	    			pr.setSubNo(m.get("SAMPLE_DATA_SEQ")==null?"":m.get("SAMPLE_DATA_SEQ").toString());
	    			pr.setMeterNo(m.get("METER_NO")==null?"":m.get("METER_NO").toString());
	    			pr.setCarNo(m.get("CAR_NO")==null?"":m.get("CAR_NO").toString());
	    			pr.setCarLane(m.get("CAR_SLOT")==null?"":m.get("CAR_SLOT").toString());
	    			pr.setNameBoat(m.get("BOAT_NAME")==null?"":m.get("BOAT_NAME").toString());
	    			pr.setBoatLaneP(m.get("BOAT_SLOTP")==null?"":m.get("BOAT_SLOTP").toString());
	    			pr.setBoatLaneS(m.get("BOAT_SLOTS")==null?"":m.get("BOAT_SLOTS").toString());
	    			pr.setLotNo(m.get("ADTV_LOT_NO")==null?"":m.get("ADTV_LOT_NO").toString());
	    			pr.setRandomDate(m.get("STR_SAMPLE_DATE")==null?"":m.get("STR_SAMPLE_DATE").toString());
	    			pr.setDateExpier(m.get("STR_SAMPLE_EXPIRE_DATE")==null?"":m.get("STR_SAMPLE_EXPIRE_DATE").toString());
	    			pr.setEmployeeCode(m.get("SAMPLE_STAFF_ID")==null?"":m.get("SAMPLE_STAFF_ID").toString());
	    			pr.setEmployeeName(m.get("SAMPLE_STAFF_NAME")==null?"":m.get("SAMPLE_STAFF_NAME").toString());
	    			pr.setTanknumber(m.get("TANK_NO")==null?"":m.get("TANK_NO").toString());
	    			pr.setDetailpoint(m.get("SAMPLE_POINT_DESC")==null?"":m.get("SAMPLE_POINT_DESC").toString());
	    			 
	    			listExport.add(pr);
	    		} 
			    jr = new JRBeanCollectionDataSource(listExport);
	 			map.put("CollectionBeanParam", jr);
	 			jasperPrint=ReportUtils.exportReport("ASSIGN_WORK",map , new JREmptyDataSource());
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
       
		return jasperPrint;
	}
	
	
	@Override
    public  List<Map<String,Object>> inquiryRandomOilDetailGetList(RandomOil objReq) throws   Exception   {
        
    	 List<Map<String,Object>>  obj  =  new  ArrayList<>();
    	 
    	 obj=	randomOilDao.inquiryRandomOilDetailGetList(objReq);
		 
       
		return obj;
       
    }
	
}
