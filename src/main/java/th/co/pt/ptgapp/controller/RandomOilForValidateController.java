package th.co.pt.ptgapp.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.workflow.MemberWorkGroupBean;
import th.co.pt.ptgapp.controller.bean.workflow.SubmitRequestEntity;
import th.co.pt.ptgapp.controller.ws.WFConstant;
import th.co.pt.ptgapp.entity.WgMemberBean;
import th.co.pt.ptgapp.service.RandomService;
import th.co.pt.ptgapp.service.SendMailServiceImpl;
import th.co.pt.ptgapp.service.ws.lotusnotes.IPtgService;
import th.co.pt.ptgapp.service.ws.lotusnotes.dto.RandomSampleDto;
import th.co.pt.ptgapp.service.ws.lotusnotes.request.CreateRequestRequest;
import th.co.pt.ptgapp.service.ws.lotusnotes.request.ItemRequest;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.*;
import th.co.pt.ptgapp.utils.CGlobal;
import th.co.pt.ptgapp.utils.ParamMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

@Controller
public class RandomOilForValidateController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RandomService randomService;
	@Autowired
	private IPtgService ptgService;


	@GetMapping("randomOilForValidate")
	public String randOilPage(Model model) throws Exception {
		return "randomOilForValidate";
	}

	@RequestMapping(value = "/api/stores", method = RequestMethod.POST)
	public @ResponseBody  Map<String,Object> storeList(@RequestBody HashMap<String,Object> params,HttpSession session) throws Exception{
		Map<String,Object>  result  =  new HashMap<>();
		result.put(WsConstant.WEB_STATUS_CODE,WsConstant.WEB_ERROR_CODE);
		try{
			ParamMap paramMap = new ParamMap();
			paramMap.setParamMap(params);
			List<Map<String, Object>> storeList = (List<Map<String, Object>>) session.getAttribute("storeList");
			if(storeList.isEmpty()){
				storeList = randomService.groupNameStoreRandomOil(new RandomOil());
			}
			result.put(WsConstant.WEB_STATUS_CODE, WsConstant.WEB_SUCCESS_CODE);
			result.put(WsConstant.WEB_DATA_STORE, storeList);
			session.setAttribute("storeList",storeList);

		}catch (Exception ex){
			ex.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/api/plants", method = RequestMethod.POST)
	public @ResponseBody  Map<String,Object> getStoreName(@RequestBody HashMap<String,Object> params,
														  HttpSession session) throws Exception{
		Map<String,Object>  result  =  new HashMap<>();
		result.put(WsConstant.WEB_STATUS_CODE,WsConstant.WEB_ERROR_CODE);
		try{
			ParamMap paramMap = new ParamMap();
			paramMap.setParamMap(params);
			String storeId = paramMap.getString("param_store_id");
			String chkMenu = paramMap.getString("chk_menu");
			String productID = paramMap.getString("chk_productID");
			RandomOil randomOil = new RandomOil();
			if(StringUtils.isEmpty(storeId)){
				storeId = (String) session.getAttribute("sessionStoreId");
			}
			//System.out.println(session.getAttribute("sessionStoreId"));
			//System.out.println(paramMap.getString("chk_menu"));
			randomOil.setNameStore(null);
			randomOil.setChkmenu(chkMenu);
			randomOil.setProductID(productID);
			Map<String,Object> randomLastResult = randomService.inquiryRandomLastResult(randomOil);
			
			List<Map<String, Object>> list = (List<Map<String, Object>>) randomLastResult.get("list");
			
			/*
			 * System.out.println(list); for(Map<String, Object> map : list) {
			 * System.out.println(map.get("status")); if("05".equals(map.get("status"))) {
			 * result.put(WsConstant.WEB_DATA_RESULT_LISTS, list); }else
			 * if("06".equals(map.get("status"))) {
			 * 
			 * }else if("08".equals(map.get("status"))) {
			 * 
			 * }else {
			 * 
			 * } }
			 */
	        
			result.put(WsConstant.WEB_STATUS_CODE, WsConstant.WEB_SUCCESS_CODE);
			result.put(WsConstant.WEB_DATA_RESULT_LISTS, list);
			List<Map<String, Object>> sessionStore = (List<Map<String, Object>>) session.getAttribute("storeList");
			if(sessionStore!=null) {
				for(Map<String, Object> map : sessionStore){
					if(String.valueOf(map.get("PLANT_ID")).equals(storeId)){
						result.put(WsConstant.WEB_DATA_PLANT, String.valueOf(map.get("PLANT_NAME")));
						break;
					}
				}
			}else{
				result.put(WsConstant.WEB_DATA_PLANT, "");
			}
			result.put("selPlantId",storeId);
			session.setAttribute("sessionStoreId",storeId);
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/api/assignjob", method = RequestMethod.POST)
	public @ResponseBody  Map<String,Object> assignJob(@RequestBody HashMap<String,Object> params,HttpSession session) throws Exception{
		Map<String,Object>  result  =  new HashMap<>();
		StringBuilder msgResultList = new StringBuilder();
		result.put(WsConstant.WEB_STATUS_CODE,WsConstant.WEB_ERROR_CODE);
		try{
			ParamMap paramMap = new ParamMap();
			paramMap.setParamMap(params);
			List<String> list = paramMap.getList("param_lab_codes");
			List<RandomSampleDto> sampleList = randomService.findSampleByLabCodes(list);
			for(RandomSampleDto sample : sampleList){
				if(StringUtils.isEmpty(sample.getAssignStatus())) {
					Map<String,Object> resultMap = ptgService.assignJob(sample,session);
					msgResultList.append(resultMap.get(WsConstant.WEB_STATUS_SMG));
					msgResultList.append("\n");
				}
			}
			result.put(WsConstant.WEB_STATUS_CODE, WsConstant.WEB_SUCCESS_CODE);
			result.put(WsConstant.WEB_DATA_RESULT_LISTS, msgResultList.toString());
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/api/assignTaskByProductCode", method = RequestMethod.POST)
	public @ResponseBody  Map<String,Object> assignTaskByProductCode(@RequestBody HashMap<String,Object> params,HttpSession session) throws Exception{
		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
		Map<String,Object>  result  =  new HashMap<>();
		result.put(WsConstant.WEB_STATUS_CODE,WsConstant.WEB_ERROR_CODE);
		try{
			ParamMap paramMap = new ParamMap();
			paramMap.setParamMap(params);
			List<String> wgLists = paramMap.getList("workGroupMember");
			List<String> itemCode = new ArrayList<>();
			List<String> toolCode = new ArrayList();
			List<String> mathodCode = new ArrayList();
			List<String> spaceCode = new ArrayList();
			List<String> unitCode = new ArrayList();
			Map<String,Integer> key = new HashMap<>();
			int seq = 1;
			for(String s : wgLists){
				if(!StringUtils.isEmpty(s)){
					String[] dtl = s.split("_");
					if(dtl.length==8) {
						if (StringUtils.isEmpty(key.get(dtl[1] + dtl[2] + dtl[3]))) {
							itemCode.add(StringUtils.isEmpty(dtl[1])?"":dtl[1]);
							toolCode.add(StringUtils.isEmpty(dtl[2])?"":dtl[2]);
							mathodCode.add(StringUtils.isEmpty(dtl[3])?"":dtl[3]);
							spaceCode.add(StringUtils.isEmpty(dtl[4])?"":dtl[4]);
							unitCode.add(StringUtils.isEmpty(dtl[5])?"":dtl[5]);
							key.put(dtl[1] + dtl[2] + dtl[3], seq);
							seq++;
						}
					}
				}
			}
			String members = null;
			key = key
					.entrySet()
					.stream()
					.sorted(comparingByValue())
					.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
									LinkedHashMap::new));
			for (Map.Entry k : key.entrySet()) {
				for(String s : wgLists){
					if(!StringUtils.isEmpty(s)){
						String[] dtl = s.split("_");
						if(k.getKey().equals(dtl[1]+dtl[2]+dtl[3])){
							members = members+ (StringUtils.isEmpty(dtl[7])?"":dtl[7]) +",";
						}
					}
				}
				members = members+"|";
			}
			String productCodeId = paramMap.getString("productCodeId");
			String sampleTypeNameId = paramMap.getString("sampleTypeNameId");
			String detailLength = paramMap.getString("detailLength");
			CreateRequestRequest request = new CreateRequestRequest();
			request.setSystemName(WFConstant.SYSTEM_NAME);
			request.setProcess(WFConstant.PROCESS_ASSIGNMENT);
			request.setRequestID(productCodeId);
			request.setRequesterID(memberObj.getCodempid());
			request.setTotalrecord(Integer.parseInt(detailLength));
			request.setDummy01(WFConstant.FIELD_PRODUCT+WFConstant.DUMMY_DELIM+productCodeId);
			request.setDummy02(WFConstant.FIELD_TYPE+WFConstant.DUMMY_DELIM+sampleTypeNameId);
			request.setSeq(WsConstant.genSeq(Integer.parseInt(detailLength)));
			request.setTestItemCode(WsConstant.getPip(itemCode.stream().collect(Collectors.toList())));
			request.setTesttoolCode(WsConstant.getPip(toolCode.stream().collect(Collectors.toList())));
			request.setTestMethodCode(WsConstant.getPip(mathodCode.stream().collect(Collectors.toList())));
			request.setTestSpecCode(WsConstant.getPip(spaceCode.stream().collect(Collectors.toList())));
			request.setTestUnitCode(WsConstant.getPip(unitCode.stream().collect(Collectors.toList())));
			request.setMemberlist(members.substring(0,members.length()-1));
			ObjectMapper mapper = new ObjectMapper();
			String requestDetail = ptgService.getRequestDetail(request);
			CreateRequestResponse createRequestResponse = mapper.readValue(requestDetail, CreateRequestResponse.class);
			String createSmg = createRequestResponse.getErrorCode().concat(" : ").concat(createRequestResponse.getErrorMsg());
			if(StringUtils.isEmpty(WsConstant.getErrorCode().getString(createRequestResponse.getErrorCode()))){
				try {
					HashMap<String,Object> map = new HashMap<>();
					map.put("product",request.getDummy01());
					map.put("sampleType",request.getDummy01());
					map.put("reqBy",memberObj.getCodempid());
					ParamMap param = new ParamMap();
					paramMap.setParamMap(map);
					Map<String,Object> assignJobResult = randomService.insertAcssignJob(param,createRequestResponse);
					if(!assignJobResult.isEmpty() && "S".equalsIgnoreCase(String.valueOf(assignJobResult.get("status")))){
						SubmitRequestEntity requestEntity = new SubmitRequestEntity();
						requestEntity.setAssignFlag("1");
						requestEntity.setLabCode(createRequestResponse.getRequestID());
						requestEntity.setEmployeeID(memberObj.getCodempid());
						Map<String,Object> updFlg = randomService.updateAssignFlag(requestEntity);
						logger.debug("{}",updFlg);
						result.put(WsConstant.WEB_STATUS_CODE,WsConstant.WEB_SUCCESS_CODE);
						result.put(WsConstant.WEB_STATUS_SMG,"assigned success");
						result.put(WsConstant.WEB_DATA_KEY,createRequestResponse.getRequestID());
					}else{
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
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return result;
	}


	@RequestMapping(value = "/assignmentTaskLastResult")
	public String assignmentTaskDetail(@RequestParam(value = "labCodeNo", required = false) String labCodeNo,
									   @RequestParam(value = "plantId", required = false) String plantId,
									   @RequestParam(value = "assignFlag", required = false) String assignFlag,
									   Model model)throws  Exception{
		RandomOil randomOil = new RandomOil();
		randomOil.setNameStore(plantId);
		randomOil.setLabCode_No(labCodeNo);
		Map<String,Object> randomLastResult = randomService.inquiryRandomLastResult(randomOil);
		if(!randomLastResult.isEmpty()) {
			List<Map<String, Object>> list = (List<Map<String, Object>>) randomLastResult.get("list");
			model.addAttribute("task", list.get(0));
			ItemRequest itemRequest = new ItemRequest();
			itemRequest.setSystem(WFConstant.SYSTEM_NAME);
			itemRequest.setDummy01(WFConstant.FIELD_PRODUCT + WFConstant.DUMMY_DELIM + list.get(0).get("PRODUCT_CODE"));
			itemRequest.setDummy02(WFConstant.FIELD_TYPE + WFConstant.DUMMY_DELIM + list.get(0).get("SAMPLE_TYPE_NAME"));
			String items = ptgService.getItemList(itemRequest);
			ObjectMapper mapper = new ObjectMapper();
			ItemResponse itemResponse = mapper.readValue(items, ItemResponse.class);
			if(itemResponse!=null) {
				model.addAttribute("details", itemResponse.getDetail());
			}
			model.addAttribute("assignFlag",StringUtils.isEmpty(assignFlag)||assignFlag.equals("null")?"N":"Y");

		}
		return "assignmentTaskLastResult";
	}


	@RequestMapping(value = "/api/getkeyforsample", method = RequestMethod.POST)
	public @ResponseBody  Map<String,Object> getkeyforsample(@RequestBody HashMap<String,Object> params) throws Exception{
		Map<String,Object>  result  =  new HashMap<>();
		result.put(WsConstant.WEB_STATUS_CODE,WsConstant.WEB_ERROR_CODE);
		try{
			ParamMap paramMap = new ParamMap();
			paramMap.setParamMap(params);
			String productCode = paramMap.getString("param_product_code");
			String sampleTypeName = paramMap.getString("param_sample_type_name");
			ItemRequest itemRequest = new ItemRequest();
			itemRequest.setSystem(WFConstant.SYSTEM_NAME);
			itemRequest.setDummy01(WFConstant.FIELD_PRODUCT + WFConstant.DUMMY_DELIM + productCode);
			itemRequest.setDummy02(WFConstant.FIELD_TYPE + WFConstant.DUMMY_DELIM + sampleTypeName);
			String items = ptgService.getItemList(itemRequest);
			ObjectMapper mapper = new ObjectMapper();
			ItemResponse itemResponse = mapper.readValue(items, ItemResponse.class);
			List<String> genKey = new ArrayList<>();
			if(itemResponse!=null) {
				for(Detail dl : itemResponse.getDetail()){
					for(Workgroup wg :dl.getWorkgroup()){
						for(Member m : wg.getMemberList()){
							String key = "m_"+dl.getTestItemcode()+"_"+dl.getTesttoolcode()+"_"+dl.getTestmathodcode()+"_"+dl.getTestSpeccode()+"_"+dl.getTestUnitcode()+"_"+wg.getRoleGroup()+"_"+m.getMemberID();
							genKey.add(key);
						}
					}
				}
			}
			result.put(WsConstant.WEB_DATA_KEY,genKey);
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return result;
	}

    @RequestMapping(value = "/api/getitems", method = RequestMethod.POST)
    public @ResponseBody  Map<String,Object> getItems(@RequestBody HashMap<String,Object> params,HttpSession session) throws Exception{
        Map<String,Object>  result  =  new HashMap<>();
        result.put(WsConstant.WEB_STATUS_CODE,WsConstant.WEB_ERROR_CODE);
        try{
            ParamMap paramMap = new ParamMap();
            paramMap.setParamMap(params);
            String productCode = paramMap.getString("param_product_code");
            String sampleTypeName = paramMap.getString("param_sample_type_name");
            ItemRequest itemRequest = new ItemRequest();
            itemRequest.setSystem(WFConstant.SYSTEM_NAME);
            itemRequest.setDummy01(WFConstant.FIELD_PRODUCT+WFConstant.DUMMY_DELIM+productCode);
            itemRequest.setDummy02(WFConstant.FIELD_TYPE+WFConstant.DUMMY_DELIM+sampleTypeName);
			String items = ptgService.getItemList(itemRequest);
            ObjectMapper mapper = new ObjectMapper();
            ItemResponse itemResponse = mapper.readValue(items, ItemResponse.class);
            logger.debug("{}",itemResponse);
            result.put(WsConstant.WEB_STATUS_CODE, WsConstant.WEB_SUCCESS_CODE);
            result.put(WsConstant.WEB_DATA_RESULT_LISTS, itemResponse.getDetail());
            session.setAttribute("detailSession",itemResponse.getDetail());
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

	@RequestMapping(value = "/api/getmember", method = RequestMethod.POST)
	public @ResponseBody  Map<String,Object> getmember(@RequestBody HashMap<String,Object> params,HttpSession session) throws Exception{
		Map<String,Object>  result  =  new HashMap<>();
		result.put(WsConstant.WEB_STATUS_CODE,WsConstant.WEB_ERROR_CODE);
		List<WgMemberBean> gmList = new ArrayList<>();
		try{
			ParamMap paramMap = new ParamMap();
			paramMap.setParamMap(params);
			String[] itemGroup = paramMap.getString("param_rolegroup_testitemcode").split("_");
			if(itemGroup.length == 4) {
				String roleGroup = itemGroup[0];
				String testItemcode = itemGroup[1];
				String testToolCode = itemGroup[2];
				String testMethodCode = itemGroup[3];
				List<Detail> details = (List<Detail>) session.getAttribute("detailSession");
				details = details
						.stream()
						.filter(e -> e.getTestItemcode().equals(testItemcode) && e.getTesttoolcode().equals(testToolCode) && e.getTestmathodcode().equals(testMethodCode))
						.collect(Collectors.toList());
				if (!details.isEmpty()) {
					List<Workgroup> workgroups = details.get(0).getWorkgroup()
							.stream()
							.filter(e -> e.getRoleGroup().equals(roleGroup))
							.collect(Collectors.toList());
					String value = "m_"+details.get(0).getTestItemcode()+"_"+details.get(0).getTesttoolcode()+"_"+details.get(0).getTestmathodcode()+"_"+details.get(0).getTestSpeccode()+"_"+details.get(0).getTestUnitcode();
					for(Workgroup wg : workgroups){
						value = value + "_"+wg.getRoleGroup();
						for (Member m : wg.getMemberList()){
							gmList.add(new WgMemberBean(m.getMemberName(),value+"_"+m.getMemberID()));
						}
					}

					result.put(WsConstant.WEB_STATUS_CODE, WsConstant.WEB_SUCCESS_CODE);
					result.put(WsConstant.WEB_DATA_RESULT_LISTS, gmList);
					result.put("ddlid",itemGroup[1]+"_"+itemGroup[2]+"_"+itemGroup[3]);
				} else {
					result.put(WsConstant.WEB_STATUS_CODE, WsConstant.WEB_ERROR_CODE);
				}
			}

		}catch (Exception ex){
			ex.printStackTrace();
		}
		return result;
	}


	/** update for validation oil date 2019-09-15
	 * ****************************** **/
    
    @RequestMapping("randomOilForValidate_bak")
    public ModelAndView home_test(HttpServletRequest req,Model model) throws Exception {
    	ModelAndView mod = new ModelAndView("randomOilForValidate");
    	RandomOil objReq = new RandomOil();
    	List<Map<String, Object>> resultList = randomService.groupNameStoreRandomOil(objReq);
    	mod.addObject("Model",resultList);
    	String listPlant = "";
    	for( int i = 0; i < resultList.size(); i++ ) {
    		Map<String, Object> map = resultList.get(i);
    		listPlant += map.get("PLANT_ID").toString() + "," + map.get("PLANT_NAME").toString() + "|";
    		
    	}
    	logger.info("listPlant 		= "+listPlant);
    	logger.info("listPlant_last = "+listPlant.substring(0, listPlant.length()-1));
    	mod.addObject("listPlant", listPlant.substring(0, listPlant.length()-1));

        return mod;
    }
    @RequestMapping(value = "/insertRandomLastResult", method = RequestMethod.POST)
    public @ResponseBody  	 Map<String,Object>   saveRandomOil(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
   	 Map<String,Object>  obj  =  new HashMap<String, Object>();
    	try{
    		int i=0 ;
    		/*while(i<100000){
    			System.out.println(i);
    			i++;
    		}*/
    		
    		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
    		
			//System.out.println(memberObj.getCodempid());
    		objReq.setCreateBy(memberObj.getCodempid());
            obj = randomService.insertRandomLastResult(objReq);
            
    	}catch (Exception ex){
    		 obj.put("success", 0);
    		 obj.put("message", (ex.getMessage().length()>500?ex.getMessage().substring(0, 500):ex.getMessage())); 
    		 ex.printStackTrace();
    	}
    	    	
        return obj;
    }
    @RequestMapping(value = "/cntWaitingRandomLastResult", method = RequestMethod.POST)
    public @ResponseBody  Map<String,Object>  cntWaitingRandomLastResult(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
    	 Map<String,Object>  obj  =  new HashMap<String, Object>();
    	try{
    	 
    		  obj = randomService.cntWaitingRandomLastResult(objReq);
            
            obj.put("success", "1") ;
    	}catch (Exception ex){
    	    obj.put("success", "0") ;
    		 obj.put("message", ex.getMessage());
    		ex.printStackTrace();
    	}
    	    	
        return obj;
    }
    @RequestMapping(value = "/inquiryRandomLastResult", method = RequestMethod.POST)
    public @ResponseBody  Map<String,Object>  inquiryRandomLastResult(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
    	 Map<String,Object>  obj  =  new HashMap<String, Object>();
    	try{
    		obj = randomService.inquiryRandomLastResult(objReq);
    		obj.put("passParam", objReq) ;
            obj.put("success", "1") ;
    	}catch (Exception ex){
    	    obj.put("success", "0") ;
    		 obj.put("message", ex.getMessage());
    		ex.printStackTrace();
    	}
    	    	
        return obj;
    }
    @RequestMapping(value = "/assignRandomLastResult")
    public ModelAndView   assignRandomLastResult()throws  Exception{
       	
    	  return new ModelAndView("assignRandomLastResult");
    }

	@RequestMapping(value = "/assignmentTaskLastResult_bak")
	public ModelAndView assignmentTaskLastResult()throws  Exception{

		return new ModelAndView("assignmentTaskLastResult");
	}
    @RequestMapping(value = "/assignRandomLastResultDetail", method = RequestMethod.POST)
    public @ResponseBody  Map<String,Object>  assignRandomLastResultDetail(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
    	 Map<String,Object>  obj  =  new HashMap<String, Object>();
    	try {
    		  obj = randomService.assignRandomLastResultDetail(objReq);
            
            obj.put("success", "1") ;
    	} catch (Exception ex) {
    	    obj.put("success", "0") ;
    		 obj.put("message", ex.getMessage());
    		ex.printStackTrace();
    	}
    	    	
        return obj;
    }
    @RequestMapping(value = "/getLastSampleData", method = RequestMethod.POST)
    public @ResponseBody  	 Map<String,Object>   getLastSampleData(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
      	 Map<String,Object>  obj  =  new HashMap<String, Object>();
       	try{
       		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
       		
   			System.out.println(memberObj.getCodempid());
       		objReq.setCreateBy(memberObj.getCodempid());
       		
            obj = randomService.getSampleData(objReq);
            obj.put("success", 1);
              
       	}catch (Exception ex){
       		 obj.put("success", 0);
       		 obj.put("message", (ex.getMessage().length()>500?ex.getMessage().substring(0, 500):ex.getMessage())); 
       		 ex.printStackTrace();
       	}
       	    	
           return obj;
    }

    @RequestMapping(value = "/getWorkgroupMember", method = RequestMethod.POST)
    public @ResponseBody  	 Map<String,Object>   getWorkgroupMember(@RequestBody MemberWorkGroupBean bean, HttpServletRequest req,HttpSession session )throws  Exception{
      	 Map<String,Object>  obj  =  new HashMap<String, Object>();
       	try{
       		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
       		
   			System.out.println(memberObj.getCodempid());
       		
            obj = randomService.getWorkgroupMember(bean);
            obj.put("success", 1);
              
       	}catch (Exception ex){
       		 obj.put("success", 0);
       		 obj.put("message", (ex.getMessage().length()>500?ex.getMessage().substring(0, 500):ex.getMessage())); 
       		 ex.printStackTrace();
       	}
       	    	
           return obj;
    }
       		
       		
    @RequestMapping(value = "/sendRequestAssignRandomOil", method = RequestMethod.POST)
    public @ResponseBody  	 Map<String,Object>   sendRequestAssignRandomOil(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception{
   	 Map<String,Object>  obj  =  new HashMap<String, Object>();
    	try{
    		int i=0 ;
    		/*while(i<100000){
    			System.out.println(i);
    			i++;
    		}*/
    		
    		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
    		
			System.out.println(memberObj.getCodempid());
    		objReq.setCreateBy(memberObj.getCodempid());
            obj = randomService.sendRequestAssignRandomOil(objReq);
            
           
    	}catch (Exception ex){
    		 obj.put("success", 0);
    		 obj.put("message", (ex.getMessage().length()>500?ex.getMessage().substring(0, 500):ex.getMessage())); 
    		 ex.printStackTrace();
    	}
    	    	
        return obj;
    }
    
    @RequestMapping(value = "/getAllTask", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> getAllTask(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception {
    	
    	Map<String,Object>  obj  =  new HashMap<String, Object>();
    	
    	try {
    		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
    		String codempid = memberObj.getCodempid();
    		
    		obj = randomService.getAllTask(objReq);
    	} catch(Exception e) {
    		
    	}
    	
    	return obj;
    }
    
    @RequestMapping(value = "/loadOwnerJob", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> loadOwnerJob(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session )throws  Exception {
    	
    	Map<String,Object>  obj  =  new HashMap<String, Object>();
    	
    	try {
    		MemberObj  memberObj = CGlobal.getC_UserInfo(session);
    		String codempid = memberObj.getCodempid();
    		
    		obj = randomService.getAllTask(objReq);
    	} catch(Exception e) {
    		
    	}
    	
    	return obj;
    }
}
