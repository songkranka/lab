package th.co.pt.ptgapp.dao ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.StringUtils;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.workflow.*;
import th.co.pt.ptgapp.dao.task.LtrDao;
import th.co.pt.ptgapp.dao.task.LtrDtlDto;
import th.co.pt.ptgapp.dao.task.LtrDto;
import th.co.pt.ptgapp.service.ws.lotusnotes.dto.RandomSampleDto;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.CreateRequestResponse;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.DetailForCreate;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.MemberForCreate;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.WsConstant;
import th.co.pt.ptgapp.utils.ParamMap;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RandomOilDao  {

    @Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;

    @Autowired
    private NamedParameterJdbcTemplate npJdbcTemplate;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
	private PlatformTransactionManager txManager;

    @Autowired
	private RequestItemDao requestItemDao;

    @Autowired
    private LtrDao ltrDao;

    public RandomOil insertGroupRandomOil(RandomOil objReq) throws Exception{
    //	Map<String,Object> result = new HashMap<String, Object>();
    	RandomOil rtnObjReq  = new RandomOil();
		logger.info("----- insertGroupRandomOil ------ ");


		  logger.info("objReq.getNameStore() = ["+objReq.getNameStore()+"]");
		  logger.info("objReq.getProductOil() = ["+objReq.getProductOil()+"]");
		  logger.info("objReq.getOwnerLogistic() = ["+objReq.getOwnerLogistic()+"]");
		  logger.info("objReq.getSourceId() = ["+objReq.getSourceId()+"]");
		  logger.info("objReq.getPoDate() = ["+objReq.getPoDate()+"]");
		  logger.info("objReq.getPoDate() = ["+objReq.getCreateBy()+"]");


		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("insertGroupRandomOil");
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("nameStore",objReq.getNameStore(),Types.VARCHAR)
				.addValue("productOil",objReq.getProductOil(),Types.VARCHAR)
				.addValue("ownerLogistic",objReq.getOwnerLogistic(),Types.VARCHAR)
				.addValue("source",objReq.getSourceId(),Types.VARCHAR)
				.addValue("poDate",objReq.getPoDate(),Types.VARCHAR)
				.addValue("createBy",objReq.getCreateBy(),Types.VARCHAR)
				.addValue("percenRan",objReq.getPercenRan(),Types.VARCHAR)
				.addValue("referenceNo",Types.VARCHAR)
				.addValue("pResult",Types.VARCHAR)
				.addValue("pMessage",Types.VARCHAR);


				Map<String, Object> out = call.execute(in);
				String referenceNo =(String)out.get("referenceNo");
				String result =(String)out.get("pResult");
				String msg =(String)out.get("pMessage");
				rtnObjReq.setReferenceNo(referenceNo);
				rtnObjReq.setResult(result);
				rtnObjReq.setMessage(msg);
				//logger.info("result"+result);
				//logger.info("msg==>"+msg);
				System.out.println("RESULT = "+result);
      return		rtnObjReq;


    }

    public RandomOil editSubSeqRandomOil(RandomOil objReq) throws Exception{
    //	Map<String,Object> result = new HashMap<String, Object>();
    	RandomOil rtnObjReq  = new RandomOil();

		logger.info("----- editSubSeqRandomOil ------ ");


		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("editSubSeqRandomOil");
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("labcode",objReq.getLabCode_No(),Types.VARCHAR)
				.addValue("subset",objReq.getSubset(),Types.VARCHAR)
				.addValue("seqInSubset",objReq.getSeqInSubset(),Types.VARCHAR)
				.addValue("referenceNo",objReq.getReferenceNo(),Types.VARCHAR)
				.addValue("createBy",objReq.getCreateBy(),Types.VARCHAR)
//				.addValue("PRODUCT_OIL",objReq.getProductOil(),Types.VARCHAR)
//				.addValue("OWNER_PRODUCT_OIL",objReq.getOwnerProductOil(),Types.VARCHAR)
//				.addValue("OWNER_LOGISTIC",objReq.getOwnerLogistic(),Types.VARCHAR)
				.addValue("pResult",Types.VARCHAR)
				.addValue("pMessage",Types.VARCHAR);


				Map<String, Object> out = call.execute(in);
				String result =(String)out.get("pResult");
				String msg =(String)out.get("pMessage");
				rtnObjReq.setResult(result);
				rtnObjReq.setMessage(msg);
				//logger.info("result"+result);
				//logger.info("msg==>"+msg);
      return		rtnObjReq;


    }

    public void insertRequestAnalysis(RandomOil objReq)throws Exception,ParseException {
    	logger.info("----- insertRandomOilHD ------ ");

    		System.out.println(objReq.getLabCode());
    		System.out.println(objReq.getICheck());
    		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("insertRequestAnalysis");
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("plant_id",objReq.getNameStore(),Types.VARCHAR)
				.addValue("createBy",objReq.getCreateBy(),Types.VARCHAR)
				.addValue("pReqNo",Types.VARCHAR)
				.addValue("pResult",Types.VARCHAR)
				.addValue("pMessage",Types.VARCHAR);


				Map<String, Object> out = call.execute(in);
				String reqNo =(String)out.get("pReqNo");
				String result =(String)out.get("pResult");
				String msg =(String)out.get("pMessage");
				objReq.setReqNo(reqNo);
				objReq.setResult(result);
				objReq.setMessage(msg);
				//logger.info("result"+result);
				//logger.info("msg==>"+msg);



    }
    public void updateStatusSendAnalysis(RandomOil objReq)throws Exception,ParseException {
    	logger.info("----- Update Status ------ ");
    	//logger.info(objReq.getCreateBy());
    	//logger.info(objReq.getStatus());
    	//logger.info(objReq.getLabCode_No());
    		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("updateStatusSendAnalysis");
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("plant_id",objReq.getNameStore(),Types.VARCHAR)
				.addValue("createBy",objReq.getCreateBy(),Types.VARCHAR)
				.addValue("labcode",objReq.getLabCode_No(),Types.VARCHAR)
				.addValue("status",objReq.getStatus(),Types.VARCHAR)
				.addValue("flagVerify",objReq.getflagVerify(),Types.VARCHAR)
				.addValue("pResult",Types.VARCHAR)
				.addValue("pMessage",Types.VARCHAR);


				Map<String, Object> out = call.execute(in);
				String result =(String)out.get("pResult");
				String msg =(String)out.get("pMessage");
				objReq.setResult(result);
				objReq.setMessage(msg);
				//logger.info("result"+result);
				//logger.info("msg==>"+msg);



    }
    public void updateStatusRandomOil(RandomOil objReq)throws Exception {
   //	 System.out.println("date==>"+objReq.getPoDate());
   	//StringBuffer sql = new StringBuffer();
		logger.info("----- updateStatusRandomOil ------ ");
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("updateStatusRandomOilDetail");
			SqlParameterSource in = new MapSqlParameterSource()
			.addValue("labcode",objReq.getNameStore(),Types.VARCHAR)
			.addValue("status",objReq.getStatus(),Types.VARCHAR)
			.addValue("pResult",Types.VARCHAR)
			.addValue("pMessage",Types.VARCHAR);


			Map<String, Object> out = call.execute(in);
			String result =(String)out.get("pResult");
			String msg =(String)out.get("pMessage");

			objReq.setResult(result);
			objReq.setMessage(msg);

   }
    public void updateStatusRandomOilDte(RandomOil objReq)throws Exception {

      //	StringBuffer sql = new StringBuffer();
   		logger.info("----- updateStatusRandomOilDte ------ ");

		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("updateStatusRandomOilDetail");
			SqlParameterSource in = new MapSqlParameterSource()
			.addValue("labcode",objReq.getLabCode_No(),Types.VARCHAR)
			.addValue("status",objReq.getStatus(),Types.VARCHAR)
			.addValue("pResult",Types.VARCHAR)
			.addValue("pMessage",Types.VARCHAR);


			Map<String, Object> out = call.execute(in);
			String result =(String)out.get("pResult");
			String msg =(String)out.get("pMessage");

			objReq.setResult(result);
			objReq.setMessage(msg);


      }
    public void updateReceiveFlgRandomOilDte(RandomOil objReq)throws Exception {

      	//StringBuffer sql = new StringBuffer();
   		logger.info("----- updateReceiveFlgRandomOilDte ------ ");

   		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("updateReceiveFlgRandomOilDetail");
			SqlParameterSource in = new MapSqlParameterSource()
			.addValue("labcode",objReq.getLabCode_No(),Types.VARCHAR)
			.addValue("status",objReq.getReceiveFlg(),Types.VARCHAR)
			.addValue("pResult",Types.VARCHAR)
			.addValue("pMessage",Types.VARCHAR);


			Map<String, Object> out = call.execute(in);
			String result =(String)out.get("pResult");
			String msg =(String)out.get("pMessage");

			objReq.setResult(result);
			objReq.setMessage(msg);


    }
    public void updateStatusSendRequest(RandomOil objReq)throws Exception {

      	//StringBuffer sql = new StringBuffer();
   		logger.info("----- updateStatusSendRequest ------ ");
   		logger.info("objReq.getReqNo() ------ "+objReq.getReqNo());
   		logger.info("objReq.getStatus()------ "+objReq.getStatus());
   		logger.info("getUpdateBy ------ "+objReq.getUpdateBy());
   		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("updateStatusSendRequest");
			SqlParameterSource in = new MapSqlParameterSource()
			.addValue("reqNo",objReq.getReqNo(),Types.VARCHAR)
			.addValue("status",objReq.getStatus(),Types.VARCHAR)
			.addValue("updateBy",objReq.getUpdateBy(),Types.VARCHAR)
			.addValue("pResult",Types.VARCHAR)
			.addValue("pMessage",Types.VARCHAR);


			Map<String, Object> out = call.execute(in);
			String result =(String)out.get("pResult");
			String msg =(String)out.get("pMessage");

			objReq.setResult(result);
			objReq.setMessage(msg);


    }
    public void updateLtrDTE(RandomOil objReq)throws Exception {

    	TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = txManager.getTransaction(def);

      	//StringBuffer sql = new StringBuffer();
   		logger.info("----- updateLtrDTE ------ ");
   		String result ="",msg ="";
   		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("updateLtrDTE");
   		for (int i=0 ; objReq.getListRandomOil()!=null&&i<objReq.getListRandomOil().size();i++){

   		   RandomOil objLTE = (RandomOil)objReq.getListRandomOil().get(i);
   		 logger.info("----- param------ "+objLTE.getLtrResult());
			SqlParameterSource in = new MapSqlParameterSource()
			.addValue("ltrNo",objLTE.getLtrNo(),Types.VARCHAR)
			.addValue("ltrDteNo",objLTE.getLtrDteNo(),Types.VARCHAR)
			.addValue("id_material",objLTE.getId_material(),Types.VARCHAR)
			.addValue("ltrResult",objLTE.getLtrResult(),Types.VARCHAR)
			.addValue("desc",objLTE.getDesc(),Types.VARCHAR)
			.addValue("updateBy",objReq.getCreateBy(),Types.VARCHAR)
			.addValue("pResult",Types.VARCHAR)
			.addValue("pMessage",Types.VARCHAR);


			Map<String, Object> out = call.execute(in);

			  result =(String)out.get("pResult");
			  msg =(String)out.get("pMessage");
			  if(result.equals("0")){
				  break;
			  }

         }
   	     if(!result.equals("0")){

   	    	if(objReq.getStatus().equals("02")){
   		    	updateStatusLTRNO(objReq);
   		    }

   		    txManager.commit(status);


   	     }else{

   	    	txManager.rollback(status);
   	     }
			objReq.setResult(result);
			objReq.setMessage(msg);


    }
    public void updateStatusLTRNO(RandomOil objReq)throws Exception {

        //	StringBuffer sql = new StringBuffer();
     		logger.info("----- updateStatusLTRNO ------ ");

  		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
  				 .withProcedureName("updateStatusLTRNO");
  			SqlParameterSource in = new MapSqlParameterSource()
  			.addValue("ltrNo",objReq.getLtrNo(),Types.VARCHAR)
  			.addValue("status",objReq.getStatus(),Types.VARCHAR)
  			.addValue("resultLtr",objReq.getResult(),Types.VARCHAR)
  			.addValue("createBy",objReq.getCreateBy(),Types.VARCHAR)
  			.addValue("pResult",Types.VARCHAR)
  			.addValue("pMessage",Types.VARCHAR);


  			Map<String, Object> out = call.execute(in);
  			String result =(String)out.get("pResult");
  			String msg =(String)out.get("pMessage");

  			objReq.setResult(result);
  			objReq.setMessage(msg);


        }
    public Map<String,Object> inquiryRequestAnalysis(RandomOil objReq) throws Exception{
    	//System.out.println(objReq.getStatus());
    	Map<String,Object> result = new HashMap<String, Object>();
    	logger.info(" status : {}",objReq.getStatus());
			StringBuffer sql = new StringBuffer();
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("inquiryRequestAnalysis") ;
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("plant_id",objReq.getNameStore(),Types.VARCHAR)
				.addValue("status",objReq.getStatus(),Types.VARCHAR)  ;
				List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

			 result.put("list", list);



		return result;
    }
    public Map<String,Object> inquiryRequestAnalysisOilDetail(RandomOil objReq) throws Exception{
    	Map<String,Object> result = new HashMap<String, Object>();
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("inquiryRequestAnalysisOilDetail") ;
			SqlParameterSource in = new MapSqlParameterSource()
			.addValue("reqNo",objReq.getReqNo(),Types.VARCHAR) 
			.addValue("status",objReq.getStatus(),Types.VARCHAR);
			List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		 result.put("list", list);

		return result;
    }
    public Map<String, Object> updateCarNo(RandomOil objReq) throws Exception{
    	Map<String,Object> result = new HashMap<String, Object>();
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("updateDataCarNo") ;
			SqlParameterSource in = new MapSqlParameterSource()
			.addValue("poNo",objReq.getPoNo(),Types.VARCHAR)
			.addValue("doNo",objReq.getDoNo(),Types.VARCHAR)
			.addValue("shipmentNo",objReq.getShipmentNo(),Types.VARCHAR)
			.addValue("plantid",objReq.getPlantid(),Types.VARCHAR)
			.addValue("sourceId",objReq.getSourceId(),Types.VARCHAR)
			.addValue("ownerLogistic",objReq.getOwnerLogistic(),Types.VARCHAR)
			.addValue("productOil",objReq.getProductOil(),Types.VARCHAR)
			.addValue("carNo",objReq.getCarNo(),Types.VARCHAR)
			.addValue("group_seq",objReq.getGroup_seq(),Types.VARCHAR)
			.addValue("seq",objReq.getSeq(),Types.VARCHAR)
			.addValue("status",objReq.getStatus(),Types.VARCHAR)
			.addValue("labcode",objReq.getLabCode_No(),Types.VARCHAR)
			.addValue("causeChgStatus",objReq.getcauseChgStatus(),Types.VARCHAR)
			.addValue("selectCause",objReq.getselectCause(),Types.VARCHAR)
			.addValue("pResult",Types.VARCHAR)
			.addValue("pMessage",Types.VARCHAR);
			List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			result.put("list", list);

			System.out.println(objReq.getcauseChgStatus());
			System.out.println(objReq.getselectCause());
			return result;


    }
    public Map<String, Object> checkPrint(RandomOil objReq) throws Exception{
    	System.out.println("LAB CODE"+objReq.getLabCode());
    	Map<String,Object> result = new HashMap<String, Object>();
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("updateFlagPrint") ;
			SqlParameterSource in = new MapSqlParameterSource()
			.addValue("labcode",objReq.getLabCode(),Types.VARCHAR)
			.addValue("pResult",Types.VARCHAR)
			.addValue("pMessage",Types.VARCHAR);
			List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			result.put("list", list);
			return result;


    }
    public Map<String, Object> queryDataFreeCar(RandomOil objReq) throws Exception{
    	Map<String,Object> result = new HashMap<String, Object>();
    	//System.out.println(objReq.getLabCode());
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("queryDataFreeCar") ;
			SqlParameterSource in = new MapSqlParameterSource()
			.addValue("sample_refer",objReq.getReferenceNo(),Types.VARCHAR)
			.addValue("labCode",objReq.getLabCode(),Types.VARCHAR)
			.addValue("pResult",Types.VARCHAR)
			.addValue("pMessage",Types.VARCHAR);
			List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			result.put("list", list);
			return result;
    }
    public Map<String, Object> updateCancelStatus(RandomOil objReq) throws Exception{
    	Map<String,Object> result = new HashMap<String, Object>();
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("updateCancelStatus") ;
			SqlParameterSource in = new MapSqlParameterSource()
			.addValue("status",objReq.getStatus(),Types.VARCHAR)
			.addValue("labcode",objReq.getLabCode_No(),Types.VARCHAR)
			.addValue("causeChgStatus",objReq.getcauseChgStatus(),Types.VARCHAR)
			.addValue("selectCause",objReq.getselectCause(),Types.VARCHAR)
			.addValue("pResult",Types.VARCHAR)
			.addValue("pMessage",Types.VARCHAR);
			List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			result.put("list", list);
			return result;
    }
    public Map<String, Object> updateFlgRandom(RandomOil objReq) throws Exception{
    	Map<String,Object> result = new HashMap<String, Object>();
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("updateFlgRandom") ;
			SqlParameterSource in = new MapSqlParameterSource()
			.addValue("flgRandom",objReq.getFlgRan(),Types.VARCHAR)
			.addValue("flgCode",objReq.getFlgCode(),Types.VARCHAR)
			.addValue("pResult",Types.VARCHAR)
			.addValue("pMessage",Types.VARCHAR);
			List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
			result.put("list", list);
			return result;
    }
    public Map<String,Object> inquiryRandomOilDetail(RandomOil objReq) throws Exception{
    	//System.out.println("Status = "+objReq.getCreateBy());
    	System.out.println(objReq.getPrintName());
    	if(objReq.getPrintName()==null) {
    		objReq.setPrintName("");
    	}
    	Map<String,Object> result = new HashMap<String, Object>();

    	logger.info("labcode :{}",objReq.getLabCode_No());
    	logger.info("labcode_in :{}",objReq.getLabCode_NoIn());
    	logger.info("namestore :{}",objReq.getNameStore());
    	logger.info("podate :{}",objReq.getPoDate());
    	logger.info("status :{}",objReq.getStatus());
    	logger.info("manualType :{}",objReq.getManualType());
    	logger.info("reqNo :{}",objReq.getReqNo());
    	logger.info("createBy :{}",objReq.getCreateBy());
    	logger.info("printName :{}",objReq.getPrintName());
    	logger.info("sampleType :{}",objReq.getSampleType());


		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("inquiryRandomOilDetail") ;
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("labcode",objReq.getLabCode_No(),Types.VARCHAR)
				.addValue("labcode_in",objReq.getLabCode_NoIn(),Types.VARCHAR)
				.addValue("namestore",objReq.getNameStore(),Types.VARCHAR)
				.addValue("podate",objReq.getPoDate(),Types.VARCHAR)
				.addValue("status",objReq.getStatus(),Types.VARCHAR)
				.addValue("manualType",objReq.getManualType(),Types.VARCHAR)
				.addValue("reqNo",objReq.getReqNo(),Types.VARCHAR)
				.addValue("createBy",objReq.getCreateBy(),Types.VARCHAR)
				.addValue("printName",objReq.getPrintName(),Types.VARCHAR)
				.addValue("sampleType",objReq.getSampleType(),Types.VARCHAR) ;
				List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

			 result.put("list", list);





		return result;
    }
    public Map<String,Object> inquiryRandomLastResult(RandomOil objReq) throws Exception{
    	Map<String,Object> result = new HashMap<String, Object>();
    		//System.out.println(objReq.getChkmenu());

		/*
		 * System.out.println(objReq.getProductID());
		 * System.out.println(objReq.getChkmenu());
		 * System.out.println(objReq.getLabCode_No());
		 * System.out.println(objReq.getNameStore());
		 */
    	System.out.println(objReq.getNameStore());
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("inquiryRandomLastResult") ;
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("productID",objReq.getProductID(),Types.VARCHAR)
				.addValue("chkmenu",objReq.getChkmenu(),Types.VARCHAR)
				.addValue("labcode",objReq.getLabCode_No(),Types.VARCHAR)
				.addValue("plant_id",objReq.getNameStore(),Types.VARCHAR);
				List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
				//System.out.println(list);
			 result.put("list", list);


		return result;
    }

    public Map<String,Object> inquirySpareGroupDetail(RandomOil objReq) throws Exception{
    	Map<String,Object> result = new HashMap<String, Object>();


		logger.info("----- inquirySpareGroupDetail ------ ");

		System.out.println(objReq);
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("inquirySpareGroupDetail") ;
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("referenceNo",objReq.getReferenceNo(),Types.VARCHAR)
				.addValue("namestore",objReq.getNameStore(),Types.VARCHAR)
				.addValue("SAMPLE_DATA_GROUP",objReq.getDataGroup(),Types.VARCHAR) ;
				//.addValue("SAMPLE_DATA_GROUP",objReq.getSubset(),Types.VARCHAR) ;
				List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
				logger.info("ReferenceNO = "+objReq.getReferenceNo());
				logger.info("namestore = "+objReq.getNameStore());
				logger.info("SAMPLE_DATA_GROUP = "+objReq.getDataGroup());
			 result.put("list", list);

		System.out.println(result);
		return result;
    }
    public Map<String,Object> randomOilRequestNoDetail(RandomOil objReq) throws Exception{
    	Map<String,Object> result = new HashMap<String, Object>();


		logger.info("----- randomOilRequestNoDetail ------ ");


			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("randomOilRequestNoDetail") ;
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("referenceNo",objReq.getReqNo(),Types.VARCHAR)   ;
				List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

			 result.put("list", list);


		return result;
    }
    public Map<String,Object> assignRandomLastResultDetail(RandomOil objReq) throws Exception{
    	Map<String,Object> result = new HashMap<String, Object>();

			logger.info("----- assignRandomLastResultDetail ------ ");

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					.withProcedureName("assignRandomLastResultDetail") ;

			SqlParameterSource in = new MapSqlParameterSource()
					.addValue("labCode",objReq.getLabCode_No(),Types.VARCHAR) ;

			List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

			result.put("list", list);


		return result;
    }
    public Map<String,Object> summaryRandomOilDetail(RandomOil objReq) throws Exception{

    	 Map<String,Object> result = new HashMap<String, Object>();


		logger.info("----- summaryRandomOilDetail ------ ");



		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("summaryRandomOilDetail") ;
			SqlParameterSource in = new MapSqlParameterSource()
			.addValue("referenceNo",objReq.getReferenceNo(),Types.VARCHAR) ;
			List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		 result.put("list", list);

		return result;
    }
    public Map<String,Object> summaryRandomLastResult(RandomOil objReq) throws Exception{

    	 Map<String,Object> result = new HashMap<String, Object>();


		logger.info("----- summaryRandomLastResult ------ ");
		//System.out.println("group id ="+objReq.getGroup_seq());


		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("summaryRandomLastResult") ;
			SqlParameterSource in = new MapSqlParameterSource()
			.addValue("group_seq",objReq.getGroup_seq(),Types.VARCHAR) ;
			List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

		 result.put("list", list);

		return result;
    }
    public List<Map<String, Object>> groupNameStoreRandomOil(RandomOil objReq)  throws Exception{

			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("groupNameStoreRandomOil") ;
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("nameStore",objReq.getNameStore(),Types.VARCHAR) ;
				List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");


		return list;
    }
    public  Map<String, Object>  getNameStoreSetupRandomOil(RandomOil objReq)  throws Exception{
			StringBuffer sql = new StringBuffer();

            sql.append(" SELECT     PNAMET from TEST_SETUP_STOREOIL  where PID= '"+objReq.getNameStore()+"'  ");

			Map<String, Object>  result  = jdbcTemplateSQLSERVER.queryForMap(sql.toString())  ;


		return result;
    }
    public RandomOil insertRandomLastResult(RandomOil objReq) throws Exception{

        	RandomOil rtnObjReq  = new RandomOil();

    		logger.info("----- insertRandomLastResult ------ ");

    		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
    					 .withProcedureName("insertRandomLastResult");
    				SqlParameterSource in = new MapSqlParameterSource()
    			    .addValue("createBy",objReq.getCreateBy(),Types.VARCHAR)
    			    .addValue("pGroup_seq",Types.VARCHAR)
    				.addValue("pResult",Types.VARCHAR)
    				.addValue("pMessage",Types.VARCHAR);


    				Map<String, Object> out = call.execute(in);
    				String group_seq =(String)out.get("pGroup_seq");
    				String result =(String)out.get("pResult");
    				String msg =(String)out.get("pMessage");
    				rtnObjReq.setGroup_seq(group_seq);
    				rtnObjReq.setResult(result);
    				rtnObjReq.setMessage(msg);
    				//logger.info("result"+result);
    				//logger.info("msg==>"+msg);
          return		rtnObjReq;


      }
	    public RandomOil sendRequestAssignRandomOil(RandomOil objReq) throws Exception{
	     	TransactionDefinition def = new DefaultTransactionDefinition();
		    TransactionStatus status = txManager.getTransaction(def);
	    	RandomOil rtnObjReq  = new RandomOil();
//	    	TransactionDefinition def = new DefaultTransactionDefinition();
//		    TransactionStatus status = txManager.getTransaction(def);
			logger.info("----- sendRequestAssignRandomOil ------ ");
			String result ="",msg ="",ltrNo = "";
	      	SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("insertRequestLTR");
			SqlParameterSource in = new MapSqlParameterSource()
			   .addValue("labcode_no",objReq.getLabCode_No(),Types.VARCHAR)
		      .addValue("createBy",objReq.getCreateBy(),Types.VARCHAR)
		      .addValue("ltr_no",Types.VARCHAR)
			.addValue("pResult",Types.VARCHAR)
			.addValue("pMessage",Types.VARCHAR);

			Map<String, Object> out = call.execute(in);
			  result =(String)out.get("pResult");
			  msg =(String)out.get("pMessage");
			  ltrNo =  (String)out.get("ltr_no");
			  if(!result.equals("0")){
				            result ="0";
				            msg ="";
				     	SimpleJdbcCall call2 = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
						 .withProcedureName("insertRequestLTRDetail");
				      	for (int i=0 ; objReq.getListRandomOil()!=null&&i<objReq.getListRandomOil().size();i++){
				    		   RandomOil objLTE = (RandomOil)objReq.getListRandomOil().get(i);
				    			//logger.info("labcode_no"+objLTE.getLabCode_No());
								logger.info("role_id"+objLTE.getRole_id());
								logger.info("role_mapping_id"+objLTE.getRole_mapping_id());
										  in = new MapSqlParameterSource()
										   .addValue("ltr_no",ltrNo,Types.VARCHAR)
									     .addValue("role_id",objLTE.getRole_id(),Types.VARCHAR)
									    .addValue("role_mapping_id",objLTE.getRole_mapping_id(),Types.VARCHAR)
									      .addValue("createBy",objReq.getCreateBy(),Types.VARCHAR)
										.addValue("pResult",Types.VARCHAR)
										.addValue("pMessage",Types.VARCHAR);

										  out = call2.execute(in);
										  result =(String)out.get("pResult");
										  msg =(String)out.get("pMessage");

											logger.info("result"+result);
											logger.info("msg"+msg);

										  if(result.equals("0")){
											  break;
										  }

				         }
				      	rtnObjReq.setResult(result);
				      	rtnObjReq.setMessage(msg);
				   	     if(!result.equals("0")){

				   		    txManager.commit(status);
				   	     }else{

				   	    	txManager.rollback(status);
				   	     }
			  }else{
					txManager.rollback(status);
					rtnObjReq.setResult(result);
			      	rtnObjReq.setMessage(msg);
			  }

					//logger.info("result"+result);
					//logger.info("msg==>"+msg);
	        return		rtnObjReq;


	  }
	  public Map<String,Object> inquirySaveResultAnalysisOil(RandomOil objReq) throws Exception{
	    	Map<String,Object> result = new HashMap<String, Object>();

			logger.info("----- inquirySaveResultAnalysisOil ------ ");

				StringBuffer sql = new StringBuffer();


				SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
						 .withProcedureName("inquirySaveResultAnalysisOil") ;
					SqlParameterSource in = new MapSqlParameterSource()
					.addValue("LTRNO",objReq.getLtrNo(),Types.VARCHAR)   ;
					List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

				 result.put("list", list);



			return result;
	    }
	  public Map<String,Object> inquiryLTRNO(RandomOil objReq) throws Exception{
	    	Map<String,Object> result = new HashMap<String, Object>();

			logger.info("----- inquiryLTRNO ------ ");

				StringBuffer sql = new StringBuffer();
				System.out.println(objReq.getRole_id());


				SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
						 .withProcedureName("inquiryLTRNO") ;
					SqlParameterSource in = new MapSqlParameterSource()
					.addValue("role_id",objReq.getRole_id(),Types.VARCHAR)
					.addValue("status",objReq.getStatus(),Types.VARCHAR) ;
					List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

				 result.put("list", list);



			return result;
	    }
	  public Map<String,Object> inquiryLTRByLTRNO(RandomOil objReq) throws Exception{
	    	Map<String,Object> result = new HashMap<String, Object>();

			logger.info("----- inquiryLTRNO ------ ");

				StringBuffer sql = new StringBuffer();
				System.out.println(objReq.getRole_id());


				SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
						 .withProcedureName("inquiryLTRByLTRNO") ;
					SqlParameterSource in = new MapSqlParameterSource()
					.addValue("ltrNo",objReq.getLtrNo(),Types.VARCHAR)    ;
					List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

				 result.put("list", list);



			return result;
	  }
	   public Map<String,Object> inquiryAnalyzeSpec(RandomOil objReq) throws Exception{
	    	Map<String,Object> result = new HashMap<String, Object>();

			logger.info("----- inquiryAnalyzeSpec ------ ");

				StringBuffer sql = new StringBuffer();
				System.out.println(objReq.getRole_id());


				SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
						 .withProcedureName("inquiryAnalyzeSpec") ;
					SqlParameterSource in = new MapSqlParameterSource()
					.addValue("LABCODE",objReq.getLabCode_No() ,Types.VARCHAR)    ;
					List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

				 result.put("list", list);



			return result;
	    }
	   public Map<String,Object> cntWaitingRandomLastResult(RandomOil objReq) throws Exception{
	    	Map<String,Object> result = new HashMap<String, Object>();

			logger.info("----- cntWaitingRandomLastResult ------ ");

				StringBuffer sql = new StringBuffer();
				System.out.println(objReq.getRole_id());


				SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
						 .withProcedureName("cntWaitingRandomLastResult") ;
					SqlParameterSource in = new MapSqlParameterSource()
					.addValue("cnt",Types.VARCHAR)    ;
					Map<String, Object> out = call.execute(in);

				String	 cnt =  (String)out.get("cnt");

				 result.put("cnt", cnt);



			return result;
	    }
	public Map<String, Object> updateFlagAssignmentResult(RandomOil objReq) {

     		logger.info("----- updateFlagAssignmentResult ------ ");

  		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
  				 .withProcedureName("updateFlagAssignmentResult");
  			SqlParameterSource in = new MapSqlParameterSource()
  			.addValue("labcode",objReq.getLabCode_No(),Types.VARCHAR)
  			.addValue("asmflag",objReq.getAssignFlag(),Types.VARCHAR)
  			.addValue("updateBy",objReq.getUpdateBy(),Types.VARCHAR)
  			.addValue("pResult",Types.VARCHAR)
  			.addValue("pMessage",Types.VARCHAR);


  			Map<String, Object> out = call.execute(in);
  			String result =(String)out.get("pResult");
  			String msg =(String)out.get("pMessage");

  			objReq.setResult(result);
  			objReq.setMessage(msg);

		return out;
	}
	public Map<String, Object> getSampleData(RandomOil entity) {
		StringBuffer sql = new StringBuffer();

        sql.append(" ");
        sql.append("select  ");
        sql.append("h.REQ_ITEM_ID,h.PRODUCT_CODE,h.SAMPLE_TYPE,h.lab_code, ");
        sql.append("d.REQ_DTL_NO,d.ANALYZE_CODE, d.ANALYZE_VALUE, d.MATERIAL_CODE,  ");
        sql.append("d.MATERIAL_VALUE, d.METHOD_CODE,d.METHOD_VALUE,d.SPEC_CODE, ");
        sql.append("d.SPEC_VALUE, d.SPEC2_CODE, d.SPEC2_VALUE, d.UNIT_CODE, d.UNIT_VALUE ");
        sql.append("from GET_ITEM_REQT_HD h  ");
        sql.append("left join GET_ITEM_REQT_DL d on h.REQ_ITEM_ID = d.REQ_ITEM_ID ");
        sql.append("where h.LAB_CODE = '"+entity.getLabCode()+"' ");

		logger.info("SQL:-> "+sql.toString());

		List<Map<String, Object>> list = jdbcTemplateSQLSERVER.queryForList(sql.toString());
		//Map<String, Object>  result  = jdbcTemplateSQLSERVER.queryForMap(sql.toString())  ;

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("dataList", list);
		return result;
	}

	public Map<String, Object> getWorkgroupMember(MemberWorkGroupBean bean) {
		StringBuffer sql = new StringBuffer();
		sql.append(" ");
		sql.append(" SELECT ");
		if(bean.getLevel().equals("R")){
			sql.append(" W.WORK_GROUP ");
		} else {
			sql.append(" W.WORK_GROUP,W.EMP_ID,W.EMP_NAME ");
		}
		sql.append(" ");
		sql.append(" FROM GET_ITEM_WORKGROUP W ");
		sql.append(" WHERE W.REQ_DTL_NO = '"+bean.getDtlNo()+"' ");
		sql.append(" AND W.MEMBER_TYPE = "+bean.getMemberType());
		if(bean.getLevel().equals("M")) {
			sql.append(" AND W.WORK_GROUP = '"+bean.getRoleName()+"' ");
		}
		if(bean.getLevel().equals("R")) {
			sql.append(" GROUP BY W.WORK_GROUP ");
			sql.append(" ORDER BY W.WORK_GROUP ");
		}

		logger.info("SQL:-> "+sql.toString());

		List<Map<String, Object>> list = jdbcTemplateSQLSERVER.queryForList(sql.toString());
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("dataList", list);
		return result;
	}

	public Map<String, Object> getAssignFlag ( GetItemListEntity entity ) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ASSIGN_STATUS FROM DBO.RANDOM_SAMPLE_LAST_RESULT WHERE LAB_CODE = '"+entity.getLabCode()+"' ");
		Map<String, Object> map = jdbcTemplateSQLSERVER.queryForMap(sql.toString());

		return map;
	}

	public List<RandomSampleDto> findSampleByLabCodes(List<String> labcode) {
		StringBuffer sql = new StringBuffer();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("labcode", labcode);
		sql.append(" SELECT a.LAB_CODE,a.PLANT_ID,(SELECT b.product_code  FROM product b WHERE b.PRODUCT_ID=a.product_id ) AS PRODUCT_CODE,ST.SAMPLE_TYPE_NAME,re.ASSIGN_STATUS ");
		sql.append(" FROM RANDOM_SAMPLE_RESULT  a ");
		sql.append(" LEFT JOIN RANDOM_SAMPLE_LAST_RESULT re ON re.LAB_CODE   = a.LAB_CODE ");
		sql.append(" LEFT JOIN LTR l ON l.LAB_CODE = re.LAB_CODE ");
		sql.append(" LEFT JOIN MASTER_SAMPLE_TYPE ST ON ST.SAMPLE_TYPE_CODE = A.SAMPLE_TYPE ");
		sql.append(" WHERE 1=1  AND re.ASSIGN_STATUS IS NULL ");
		sql.append(" AND a.status <> '04' AND  (l.result_status ='01' OR l.result_status IS NULL) ");
		sql.append(" AND a.LAB_CODE IN (:labcode) ");
		sql.append(" ORDER BY re.ASSIGN_STATUS ASC,a.PO_DATE ");
		List<RandomSampleDto> list = npJdbcTemplate.query(sql.toString(), parameters, new RowMapper<RandomSampleDto>() {
			@Override
			public RandomSampleDto mapRow(ResultSet resultSet, int i) throws SQLException {
				return toRandomSampleDto(resultSet);
			}
		});

		return list;
	}

	public Map<String, Object> updateAssignFlag ( SubmitRequestEntity entity ) {

		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE dbo.RANDOM_SAMPLE_LAST_RESULT SET ASSIGN_STATUS = '"+entity.getAssignFlag()+"' , UPDATE_BY = '"+entity.getEmployeeID()+"' ,UPDATE_DATE = GETDATE() WHERE LAB_CODE = '"+entity.getLabCode()+"' ");

		Map<String, Object> map = new HashMap<String, Object>();

		int update_flag = jdbcTemplateSQLSERVER.update(sql.toString());
		map.put("exe_return", update_flag);

		return map;

	}
	public Map<String, Object> getAllTask(RandomOil objReq) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT A.PLANT_ID,A.LAB_CODE,ST.SAMPLE_TYPE_NAME,P.PRODUCT_CODE ");
		sql.append("FROM RANDOM_SAMPLE_RESULT A INNER JOIN RANDOM_SAMPLE_LAST_RESULT RE ON RE.LAB_CODE = A.LAB_CODE ");
		sql.append("LEFT JOIN MASTER_SAMPLE_TYPE ST ON ST.SAMPLE_TYPE_CODE = A.SAMPLE_TYPE ");
		sql.append("LEFT JOIN PRODUCT P ON A.PRODUCT_ID = P.PRODUCT_ID ");
		sql.append("WHERE RE.ASSIGN_STATUS IS NULL AND A.STATUS <> '04' AND A.PLANT_ID = '"+objReq.getPlantid()+"' ");
		sql.append("");
		logger.info(sql.toString());

		List<Map<String, Object>> list = jdbcTemplateSQLSERVER.queryForList(sql.toString());
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("dataList", list);

		return result;
	}


	public Map<String, Object> saveAssignment(ReturnAssignmentEntity entity) {

		Map<String,Object> result = new HashMap<String, Object>();
		Date currDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyMM");
		String dbReqId = requestItemDao.getReqId().get("NEW_ID").toString();
		int reqLen = dbReqId.length();
		String newReqId = format.format(currDate)+"10000000000".substring(0, 11-reqLen)+dbReqId;

		Map<String,Object> wfItemHead = new HashMap<String, Object>();
		wfItemHead.put("reqId", newReqId);
		wfItemHead.put("prodCode", entity.getProduct());
		wfItemHead.put("samType", entity.getSampleType());
		wfItemHead.put("wfid", entity.getRequestID());
		wfItemHead.put("stsCode", entity.getErrorcode());
		wfItemHead.put("msg", entity.getErrorMsg());
		wfItemHead.put("remark", entity.getRemark());
		wfItemHead.put("reqBy", entity.getReqBy());

		String insertWFItemResult = requestItemDao.insertWFItemRequest(wfItemHead).get("pResult").toString();
		//logger.info("=========== SAVE HEAD REQUEST ==============");
		//logger.info("RESPONSE  ===  "+insertWFItemResult);

		if (entity.getErrorcode().equals("900") ) {
			if(entity.getDetail().size() > 0) {

				for (ReturnAssignmentDtlEntity dtl : entity.getDetail()) {
					String TestItemCode 	= (( dtl.getTestItemCode() !=null) ? dtl.getTestItemCode() : "") ;
					String TestItem 		= (( dtl.getTestItem() !=null) ? dtl.getTestItem() : "") ;
					String SeqNo 			= (( dtl.getSeqNo() !=null) ? dtl.getSeqNo() : "") ;
					String TestToolCode 	= (( dtl.getTestToolCode() !=null) ? dtl.getTestToolCode() : "") ;
					String TestTool 		= (( dtl.getTestTool() !=null) ? dtl.getTestTool() : "") ;
					String TestMethodCode 	= (( dtl.getTestMethodCode() !=null) ? dtl.getTestMethodCode() : "") ;
					String TestMethod 		= (( dtl.getTestMethod() !=null) ? dtl.getTestMethod() : "") ;
					String TestSpecCode 	= (( dtl.getTestSpecCode() !=null) ? dtl.getTestSpecCode() : "") ;
					String TestSpec 		= (( dtl.getTestSpec() !=null) ? dtl.getTestSpec() : "") ;
					String TestSpec2 		= (( dtl.getTestSpec2() !=null) ? dtl.getTestSpec2() : "") ;
					String TestUnitCode 	= (( dtl.getTestUnitCode() !=null) ? dtl.getTestUnitCode() : "") ;
					String TestUnit 		= (( dtl.getTestUnit() !=null) ? dtl.getTestUnit() : "") ;

					//logger.info(" TestItemCode 	    = " + TestItemCode 	 );
					//logger.info(" TestItem 		    = " + TestItem 		 );
					//logger.info(" SeqNo 			= " + SeqNo 		 );
					//logger.info(" TestToolCode 	    = " + TestToolCode 	 );
					//logger.info(" TestTool 		    = " + TestTool 		 );
					//logger.info(" TestMethodCode 	= " + TestMethodCode );
					//logger.info(" TestMethod 		= " + TestMethod 	 );
					//logger.info(" TestSpecCode 	    = " + TestSpecCode 	 );
					//logger.info(" TestSpec 		    = " + TestSpec 		 );
					//logger.info(" TestSpec2 		= " + TestSpec2 	 );
					//logger.info(" TestUnitCode 	    = " + TestUnitCode 	 );
					//logger.info(" TestUnit 		    = " + TestUnit 		 );

					String dbDtlNo = requestItemDao.getDtlNo().get("NEW_ID").toString();
					int DtlLen = dbDtlNo.length();
					String newDtlNo = format.format(currDate) + "90000000000".substring(0, 11-DtlLen) + dbDtlNo;

					Map<String, Object> wfItemDtl = new HashMap<String, Object>();

					wfItemDtl.put("reqid", newReqId);
					wfItemDtl.put("dtlno", newDtlNo);
					wfItemDtl.put("anaC", TestItemCode);
					wfItemDtl.put("anaV", TestItem);
					wfItemDtl.put("matC", TestToolCode);
					wfItemDtl.put("matV", TestTool);
					wfItemDtl.put("metC", TestMethodCode);
					wfItemDtl.put("metV", TestMethod);
					wfItemDtl.put("specC", TestSpecCode);
					wfItemDtl.put("specV", TestSpec);
					wfItemDtl.put("specC2", ""); // ------------ not yet
					wfItemDtl.put("specV2", TestSpec2);
					wfItemDtl.put("unitC", TestUnitCode);
					wfItemDtl.put("unitV", TestUnit);
					wfItemDtl.put("reqBy", entity.getReqBy());

					String insertWFItemDtlResult = requestItemDao.insertWFItemRequestDtl(wfItemDtl).get("pResult").toString();
					//logger.info("   Result Detail ["+newDtlNo+"] = "+insertWFItemDtlResult);

					List<ReturnAssignmentMemberEntity> d = dtl.getMember() ;
					for (ReturnAssignmentMemberEntity m : dtl.getMember() ){
						Map<String, Object> wfGroup = new HashMap<String, Object>();
						String memberID = m.getMemberID() ;
						String memberName = m.getMembersName() ;

						wfGroup.put("dtlno", newDtlNo);
						wfGroup.put("mType", m.MEMBER_TYPE_ASSIGNMENT);
						wfGroup.put("empId", memberID);
						wfGroup.put("empName", memberName);
						wfGroup.put("reqBy", entity.getReqBy());

						String insertWFItemMemberResult = requestItemDao.insertWFItemRequestWorkGroup(wfGroup).get("pResult").toString();
						//logger.info("      Result Member ["+newDtlNo+"] = "+insertWFItemMemberResult);
					}

					//logger.info(" ");
				}

				result.put("status", "S");
			} else {
				logger.info("No have Detail");
				result.put("status", "E");
			}

		} else {
			logger.warn("Data from workflow not found by status code :: "+entity.getErrorcode());
			result.put("status", "E");
		}
		return result;
	}



	@Transactional
	public Map<String, Object> insertAcssignJob(ParamMap paramMap,CreateRequestResponse response) {
		Map<String,Object> result = new HashMap<>();
		Date currDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyMM");
		String dbReqId = requestItemDao.getReqId().get("NEW_ID").toString();
		int reqLen = dbReqId.length();
		String newReqId = format.format(currDate)+"10000000000".substring(0, 11-reqLen)+dbReqId;
		Map<String,Object> wfItemHead = new HashMap<>();
		wfItemHead.put("reqId", newReqId);
		wfItemHead.put("prodCode", paramMap.getString("product"));
		wfItemHead.put("samType", paramMap.getString("sampleType"));
		wfItemHead.put("wfid", response.getRequestID());
		wfItemHead.put("stsCode", response.getErrorCode());
		wfItemHead.put("msg", response.getErrorMsg());
		wfItemHead.put("remark", response.getRemark());
		wfItemHead.put("reqBy", paramMap.getString("reqBy"));
		String insertWFItemResult = requestItemDao.insertWFItemRequest(wfItemHead).get("pResult").toString();
        logger.debug("{}",insertWFItemResult);
		if (response.getErrorCode().equals("900") ) {
			if(response.getDetail().size() > 0) {
				for (DetailForCreate dtl : response.getDetail()) {
					String TestItemCode 	= (( dtl.getTestItemCode() !=null) ? dtl.getTestItemCode() : "") ;
					String TestItem 		= (( dtl.getTestItem() !=null) ? dtl.getTestItem() : "") ;
					String SeqNo 			= (( dtl.getSeqNo() !=null) ? dtl.getSeqNo() : "") ;
					String TestToolCode 	= (( dtl.getTestToolCode() !=null) ? dtl.getTestToolCode() : "") ;
					String TestTool 		= (( dtl.getTestTool() !=null) ? dtl.getTestTool() : "") ;
					String TestMethodCode 	= (( dtl.getTestMethodCode() !=null) ? dtl.getTestMethodCode() : "") ;
					String TestMethod 		= (( dtl.getTestMethod() !=null) ? dtl.getTestMethod() : "") ;
					String TestSpecCode 	= (( dtl.getTestSpecCode() !=null) ? dtl.getTestSpecCode() : "") ;
					String TestSpec 		= (( dtl.getTestSpec() !=null) ? dtl.getTestSpec() : "") ;
					String TestSpec2 		= (( dtl.getTestSpec2() !=null) ? dtl.getTestSpec2() : "") ;
					String TestUnitCode 	= (( dtl.getTestUnitCode() !=null) ? dtl.getTestUnitCode() : "") ;
					String TestUnit 		= (( dtl.getTestUnit() !=null) ? dtl.getTestUnit() : "") ;
					String dbDtlNo = requestItemDao.getDtlNo().get("NEW_ID").toString();
					int DtlLen = dbDtlNo.length();
					String newDtlNo = format.format(currDate) + "90000000000".substring(0, 11-DtlLen) + dbDtlNo;
					Map<String, Object> wfItemDtl = new HashMap<String, Object>();
					wfItemDtl.put("reqid", newReqId);
					wfItemDtl.put("dtlno", newDtlNo);
					wfItemDtl.put("anaC", TestItemCode);
					wfItemDtl.put("anaV", TestItem);
					wfItemDtl.put("matC", TestToolCode);
					wfItemDtl.put("matV", TestTool);
					wfItemDtl.put("metC", TestMethodCode);
					wfItemDtl.put("metV", TestMethod);
					wfItemDtl.put("specC", TestSpecCode);
					wfItemDtl.put("specV", TestSpec);
					wfItemDtl.put("specC2", "");
					wfItemDtl.put("specV2", TestSpec2);
					wfItemDtl.put("unitC", TestUnitCode);
					wfItemDtl.put("unitV", TestUnit);
					wfItemDtl.put("reqBy", paramMap.getString("reqBy"));
					String insertWFItemDtlResult = requestItemDao.insertWFItemRequestDtl(wfItemDtl).get("pResult").toString();
					logger.debug("{}",insertWFItemDtlResult);
					for (MemberForCreate m : dtl.getMemberList()){
						Map<String, Object> wfGroup = new HashMap<String, Object>();
						wfGroup.put("dtlno", newDtlNo);
						wfGroup.put("mType", WsConstant.MEMBER_TYPE_ASSIGNMENT);
						wfGroup.put("empId", m.getMemberID());
						wfGroup.put("empName", m.getMembersName());
						wfGroup.put("reqBy", paramMap.getString("reqBy"));
						String insertWFItemMemberResult = requestItemDao.insertWFItemRequestWorkGroup(wfGroup).get("pResult").toString();
						logger.debug("{}",insertWFItemMemberResult);
					}
				}
				result.put("status", "S");
			} else {
				logger.info("No have Detail");
				result.put("status", "E");
			}

		} else {
			logger.warn("Data from workflow not found by status code :: "+response.getErrorCode());
			result.put("status", "E");
		}
		return result;
	}


	/*************** insert LTR and LTRDTE ********
	 *
	 * @param
	 * @return
	 * @throws SQLException
	 */
	public Map<String,Object> saveTaskList(List<Map<String,Object>> list, String labCode, MemberObj member) throws Exception{
		Map<String,Object> response = new HashMap<>();
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = txManager.getTransaction(def);
		boolean flag = true;
		try {
			LtrDto ltr = ltrDao.findLtrByLabCode(labCode);
			if (ltr != null) {
				List<LtrDtlDto> ltrDtlDtoList = ltrDao.findLtrDtlByLtrNo(ltr.getLtrNo());
				if (!ltrDtlDtoList.isEmpty()) {
					for (LtrDtlDto dtl : ltrDtlDtoList) {
						List<Map<String, Object>> l = list.stream()
								.filter(e -> e.get("meterialCode").equals(dtl.getIdMaterial()))
								.collect(Collectors.toList());
						if (!l.isEmpty()) {
							Map<String, Object> map = l.get(0);
							if (!(Boolean) map.get("readOnly")) {
								dtl.setRole(String.valueOf(map.get("workGroup")));
								dtl.setFlagSave(WsConstant.TXT_Y);
								if (map.get("analyzeCode").equals("0003")) {
									dtl.setColor(String.valueOf(map.get("spaceValue")));
									dtl.setColorDesc(String.valueOf(map.get("spaceValueDesc")));
									if(map.get("spaceValueOld").equals(map.get("spaceValue"))){
										dtl.setFlagResult("Y");
									}else{
										dtl.setFlagResult("N");
									}
								} else if (map.get("analyzeCode").equals("0016")) {
									dtl.setVisual(String.valueOf(map.get("spaceValue")));
									dtl.setVisualDesc(String.valueOf(map.get("spaceValueDesc")));
									if(map.get("spaceValueOld").equals(map.get("spaceValue"))){
										dtl.setFlagResult("Y");
									}else{
										dtl.setFlagResult("N");
									}
								} else {
                                    String v = String.valueOf(map.get("spaceValue")).trim();
                                    dtl.setResult(v);
                                    dtl.setVisualDesc("");
                                    BigDecimal valueNew = StringUtils.isEmpty(v)? BigDecimal.ZERO:new BigDecimal(v);
                                    String vOld = String.valueOf(map.get("spaceValueOld")).trim();
                                    BigDecimal valueOld = StringUtils.isEmpty(vOld)?BigDecimal.ZERO:new BigDecimal(vOld);
								    if(!StringUtils.isEmpty(map.get("space2Value"))){
                                        String v2Old = String.valueOf(map.get("space2Value")).trim();
                                        BigDecimal value2Old = StringUtils.isEmpty(v2Old)? BigDecimal.ZERO:new BigDecimal(v2Old);
                                        if(valueNew.compareTo(valueOld) >= 0 && valueNew.compareTo(value2Old) <= 0){
                                            dtl.setFlagResult("Y");
                                        }else{
                                            dtl.setFlagResult("N");
                                        }
                                    }else{
								        if(valueNew.compareTo(valueOld) == 0){
                                            dtl.setFlagResult("Y");
                                        }else{
                                            dtl.setFlagResult("N");
                                        }
                                    }
								}
								dtl.setUpdateBy(member.getCodempid());
								dtl.setCreateBy(member.getCodempid());
								if(ltrDao.updateLtrdtl(dtl) == null){
									flag = false;
									break;
								}
							}
						}
					}
				}else{
					flag = false;
				}
				if(flag) {
					txManager.commit(status);
					response.put("result", WsConstant.WEB_SUCCESS_CODE);
					response.put("msg", "");
				}else{
					txManager.rollback(status);
					response.put("result",WsConstant.WEB_ERROR_CODE);
					response.put("msg","");
				}
			} else {
				LtrDto ltrDto = new LtrDto();
				ltrDto.setLabCode(labCode);
				ltrDto.setResultStatus("01");
				ltrDto.setResultLtr("N");
				ltrDto.setCreateBy(member.codempid);
				ltrDto.setUpdateBy(member.getCodempid());
				String getLtrNo = ltrDao.genLtrNo();
				if(!StringUtils.isEmpty(getLtrNo)) {
					ltrDto.setLtrNo(getLtrNo);
					LtrDto ltrResult = ltrDao.insertLtr(ltrDto);
					if (ltrResult != null) {
						int i = 1;
						for (Map<String, Object> ml : list) {
							LtrDtlDto dtlDto = new LtrDtlDto();
							dtlDto.setIdMaterial(String.valueOf(ml.get("meterialCode")));
							dtlDto.setLtrNoDtl(String.valueOf(i));
							dtlDto.setLtrNo(ltrResult.getLtrNo());
							dtlDto.setFlagResult(WsConstant.TXT_N);
							dtlDto.setRole(String.valueOf(ml.get("workGroup")));
							if (!(Boolean) ml.get("readOnly")) {
								dtlDto.setFlagSave(WsConstant.TXT_Y);
								if (ml.get("analyzeCode").equals("0003")) {
									dtlDto.setColor(String.valueOf(ml.get("spaceValue")));
									dtlDto.setColorDesc(String.valueOf(ml.get("spaceValueDesc")));
                                    if(ml.get("spaceValueOld").equals(ml.get("spaceValue"))){
                                        dtlDto.setFlagResult("Y");
                                    }else{
                                        dtlDto.setFlagResult("N");
                                    }
								} else if (ml.get("analyzeCode").equals("0016")) {
									dtlDto.setVisual(String.valueOf(ml.get("spaceValue")));
									dtlDto.setVisualDesc(String.valueOf(ml.get("spaceValueDesc")));
                                    if(ml.get("spaceValueOld").equals(ml.get("spaceValue"))){
                                        dtlDto.setFlagResult("Y");
                                    }else{
                                        dtlDto.setFlagResult("N");
                                    }
								} else {
                                    String v = String.valueOf(ml.get("spaceValue")).trim();
                                    dtlDto.setResult(v);
                                    dtlDto.setVisualDesc("");
                                    BigDecimal valueNew = StringUtils.isEmpty(v)? BigDecimal.ZERO:new BigDecimal(v);
                                    String vOld = String.valueOf(ml.get("spaceValueOld")).trim();
                                    BigDecimal valueOld = StringUtils.isEmpty(vOld)?BigDecimal.ZERO:new BigDecimal(vOld);
                                    if(!StringUtils.isEmpty(ml.get("space2Value"))){
                                        String v2Old = String.valueOf(ml.get("space2Value")).trim();
                                        BigDecimal value2Old = StringUtils.isEmpty(v2Old)? BigDecimal.ZERO:new BigDecimal(v2Old);
                                        if(valueNew.compareTo(valueOld) >= 0 && valueNew.compareTo(value2Old) <= 0){
                                            dtlDto.setFlagResult("Y");
                                        }else{
                                            dtlDto.setFlagResult("N");
                                        }
                                    }else{
                                        if(valueNew.compareTo(valueOld) == 0){
                                            dtlDto.setFlagResult("Y");
                                        }else{
                                            dtlDto.setFlagResult("N");
                                        }
                                    }
								}
								dtlDto.setUpdateBy(member.getCodempid());
							} else {
								dtlDto.setFlagSave(WsConstant.TXT_N);
								dtlDto.setUpdateBy("");
							}
							dtlDto.setCreateBy(member.getCodempid());
							dtlDto.setIdAnalyze(String.valueOf(ml.get("analyzeCode")));
							if (ltrDao.insertLtrDtl(dtlDto) == null) {
								flag = false;
								break;
							}
							i++;
						}
					} else {
						flag = false;
					}

					if (flag) {
						txManager.commit(status);
						response.put("result", WsConstant.WEB_SUCCESS_CODE);
						response.put("msg", "");
					} else {
						txManager.rollback(status);
						response.put("result", WsConstant.WEB_ERROR_CODE);
						response.put("msg", "");
					}
				}else{
					txManager.rollback(status);
					response.put("result", WsConstant.WEB_ERROR_CODE);
					response.put("msg", "");
				}
			}
		}catch (Exception ex){
			txManager.rollback(status);
			response.put("result",WsConstant.WEB_ERROR_CODE);
			response.put("msg","");
		}
		return response;
	}

	private RandomSampleDto toRandomSampleDto(ResultSet resultSet) throws SQLException {
			RandomSampleDto dto = new RandomSampleDto();
			dto.setLabCode(resultSet.getString("LAB_CODE"));
			dto.setAssignStatus(resultSet.getString("ASSIGN_STATUS"));
			dto.setPlantId(resultSet.getString("PLANT_ID"));
			dto.setProductCode(resultSet.getString("PRODUCT_CODE"));
			dto.setSampleTypeName(resultSet.getString("SAMPLE_TYPE_NAME"));
			return dto;
	}

	public List<Map<String, Object>> getDataRandomOilReport(RandomOil objReq) {
		List<Map<String, Object>> list = null;
		try {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
				 .withProcedureName("RandomOilForReport") ;
			SqlParameterSource in = new MapSqlParameterSource()
			.addValue("namestore",objReq.getNameStore(),Types.VARCHAR)
			.addValue("status",objReq.getStatus(),Types.VARCHAR)
			.addValue("manualType",objReq.getManualType(),Types.VARCHAR)
			.addValue("reqNo",objReq.getReqNo(),Types.VARCHAR)
			.addValue("sampleType",objReq.getSampleType(),Types.VARCHAR) ;
			list= (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		}catch(Exception e) {
			
		}
		return list;
	}

	
    public List<Map<String, Object>> inquiryRandomOilDetailGetList(RandomOil objReq) throws Exception{

    	System.out.println(objReq.getPrintName());
    	if(objReq.getPrintName()==null) {
    		objReq.setPrintName("");
    	}
    	List<Map<String, Object>> list=null;
    	list=new ArrayList<Map<String,Object>>();
    	logger.info("labcode :{}",objReq.getLabCode_No());
    	logger.info("labcode_in :{}",objReq.getLabCode_NoIn());
    	logger.info("namestore :{}",objReq.getNameStore());
    	logger.info("podate :{}",objReq.getPoDate());
    	logger.info("status :{}",objReq.getStatus());
    	logger.info("manualType :{}",objReq.getManualType());
    	logger.info("reqNo :{}",objReq.getReqNo());
    	logger.info("createBy :{}",objReq.getCreateBy());
    	logger.info("printName :{}",objReq.getPrintName());
    	logger.info("sampleType :{}",objReq.getSampleType());


		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
					 .withProcedureName("inquiryRandomOilDetail") ;
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("labcode",objReq.getLabCode_No(),Types.VARCHAR)
				.addValue("labcode_in",objReq.getLabCode_NoIn(),Types.VARCHAR)
				.addValue("namestore",objReq.getNameStore(),Types.VARCHAR)
				.addValue("podate",objReq.getPoDate(),Types.VARCHAR)
				.addValue("status",objReq.getStatus(),Types.VARCHAR)
				.addValue("manualType",objReq.getManualType(),Types.VARCHAR)
				.addValue("reqNo",objReq.getReqNo(),Types.VARCHAR)
				.addValue("createBy",objReq.getCreateBy(),Types.VARCHAR)
				.addValue("printName",objReq.getPrintName(),Types.VARCHAR)
				.addValue("sampleType",objReq.getSampleType(),Types.VARCHAR) ;
				list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");

			





		return list;
    }


}
