package th.co.pt.ptgapp.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.utils.CGlobal;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SaveSampleResultDao {

    @Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public RandomOil saveSampleResult(RandomOil objReq) throws Exception {
        RandomOil rtnObjReq = new RandomOil();
        
        //logger.debug("----- saveSampleResult ------ ");
        //logger.debug("objReq : {}", objReq);
        System.out.println(objReq);

        try {
        	 SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                     .withProcedureName("saveManualSampleResult");

             SqlParameterSource in = new MapSqlParameterSource()
                     .addValue("plantId", objReq.getNameStore(), Types.VARCHAR)
                     .addValue("productId", objReq.getProductOil(), Types.VARCHAR)
                     .addValue("logisticId", objReq.getOwnerLogistic(), Types.VARCHAR)
                     .addValue("sourceId", objReq.getSourceId(), Types.VARCHAR)
                     .addValue("sampleDate", objReq.getSampleDate(), Types.VARCHAR)
                     .addValue("carNo", objReq.getLicenseCar(), Types.VARCHAR)

                     .addValue("subset", objReq.getSubset(), Types.VARCHAR)
                     .addValue("seqinsubset", objReq.getSeqInSubset(), Types.VARCHAR)
                     .addValue("poNo", objReq.getPoNo(), Types.VARCHAR)
                     .addValue("doNo", objReq.getDoNo(), Types.VARCHAR)
                     .addValue("shipmentNo", objReq.getShipmentNo(), Types.VARCHAR)
                     .addValue("carSlot", objReq.getCarSlot(), Types.VARCHAR)
                     .addValue("licenseCar", objReq.getLicenseCar(), Types.VARCHAR)
                     //ADDTITIVE
                     .addValue("ddlLotNo", objReq.getDdlLotNo(), Types.VARCHAR)
                     .addValue("ddlPoNo", objReq.getDdlPoNo(), Types.VARCHAR)
                     //OTHER
                     .addValue("otherOilStation", objReq.getOtherOilStation(), Types.VARCHAR)
                     
                     .addValue("poDate", objReq.getPoDate(), Types.VARCHAR)
                     .addValue("boatNo", objReq.getBoatNo(), Types.VARCHAR)
                     .addValue("boatName", objReq.getBoatName(), Types.VARCHAR)
                     .addValue("boatSlotS", objReq.getBoatSlotS(), Types.VARCHAR)
                     .addValue("boatSlotP", objReq.getBoatSlotP(), Types.VARCHAR)

                     .addValue("tankno", objReq.getTankNo(), Types.VARCHAR)
                     .addValue("createBy", objReq.getCreateBy(), Types.VARCHAR)
                     .addValue("sampleLevel", objReq.getGetSample(), Types.VARCHAR)
                     .addValue("sampleType", objReq.getSampleType(), Types.VARCHAR)

                     .addValue("staffName", objReq.getStaffName(), Types.VARCHAR)
                     .addValue("meterNo", objReq.getMeterNo(), Types.VARCHAR)
                     
                     .addValue("refRemindFlag", objReq.getRefRemindFlag(), Types.VARCHAR)
                     .addValue("refRandomId", objReq.getRefRandomId(), Types.VARCHAR)
                     .addValue("namecreate",objReq.getNameCreate(), Types.VARCHAR) 
                     .addValue("otherlogistic",objReq.getOtherLogistic(), Types.VARCHAR) //Not Data
                     
                     .addValue("otherSource",objReq.getOtherddlSource(), Types.VARCHAR)
                     .addValue("subTypeT",objReq.getSubTypeT(), Types.VARCHAR)
                     .addValue("subTypeR",objReq.getSubTypeR(), Types.VARCHAR)
                     .addValue("ddlPointSave",objReq.getddlPointSave(), Types.VARCHAR)
                     .addValue("ddlPointSaveDetail",objReq.getPointSaveDetail(), Types.VARCHAR)
                     .addValue("causeReturn",objReq.getcauseReturn(),Types.VARCHAR)
                     .addValue("tsubTypeDetail",objReq.getTsubTypeDetail(), Types.VARCHAR)
                     .addValue("invNo",objReq.getInvNo(), Types.VARCHAR)
                     .addValue("labCode", Types.VARCHAR)
                     .addValue("pResult", Types.VARCHAR)
                     .addValue("pMessage", Types.VARCHAR);
             Map<String, Object> out = call.execute(in);
             String lab_Code = (String) out.get("labCode");
             String result = (String) out.get("pResult");
             String msg = (String) out.get("pMessage");
             rtnObjReq.setLabCode_No(lab_Code);
             rtnObjReq.setResult(result);
             rtnObjReq.setMessage(msg);
             System.out.println(objReq.getInvNo());
             //logger.info("result"+result);
             //logger.info("msg==>"+msg);
             //System.out.println(objReq.getOtherSource()+"\n"+objReq.getSubTypeT()+"\n"+objReq.getSubTypeR()+"\n"+objReq.getddlPointSave()+"\n"+objReq.getLogisticTH());
             return rtnObjReq;
        }catch(Exception e) {
        	logger.error("Exceptioj :{}",e);
        	throw new RuntimeException(e.getMessage());
        }
       


    }

	public Map<String, Object> queryDataRandomSimpleResult(RandomOil objReq) {
		Map<String, Object> result = new HashMap<String, Object>();
        System.out.println(objReq.getPlantid());
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                .withProcedureName("queryDataRandomSimpleResult");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("sampleType", objReq.getSampleType(), Types.VARCHAR)
                .addValue("status", objReq.getStatus(), Types.VARCHAR)
                .addValue("plantID", objReq.getPlantid(), Types.VARCHAR);
        List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		result.put("list", list);
        return result;
	}
}