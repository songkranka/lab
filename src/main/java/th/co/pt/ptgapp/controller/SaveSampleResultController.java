package th.co.pt.ptgapp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import th.co.pt.ptgapp.config.MSGLabPropertiesServiceImpl;
import th.co.pt.ptgapp.config.PtgPropertiesServiceImpl;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.service.SaveSampleResultService;
import th.co.pt.ptgapp.utils.CGlobal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SaveSampleResultController {
    @Autowired
    private SaveSampleResultService saveSampleResultService;

    @Autowired
    private PtgPropertiesServiceImpl PtgPropertiesServiceImpl;

    @Autowired
    private MSGLabPropertiesServiceImpl msgLabPropertiesService;

    @RequestMapping("initSampleResult")
    public ModelAndView initSampleResult(HttpServletRequest req, Model model) throws Exception {
        // System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        //userService.getUser("xx");
        //RandomOil objReq =new RandomOil();
        //List<Map<String, Object>> resultList = randomService.groupNameStoreRandomOil(objReq);


        return new ModelAndView("initSampleResult");
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping(value = "/saveSampleResult", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> SampleResult(@RequestBody RandomOil objReq, HttpServletRequest req, HttpSession session) throws Exception {
        Map<String, Object> obj = new HashMap<String, Object>();
        try {
            System.out.println(objReq.getOtherddlSource());
            //SET BOAT SLOT
            String boatSlot="";
            if(null!=objReq.getBoatSlot()) {
            	  for(int i=0;i<objReq.getBoatSlot().split(",").length;i++) {
                  	boatSlot+=objReq.getBoatSlot().split(",")[i];
                  }
            	  //System.out.println(boatSlot);
                  objReq.setBoatSlotP(boatSlot);
                  objReq.setBoatSlotS(boatSlot);
            }
          
            
            MemberObj memberObj = CGlobal.getC_UserInfo(session);
            //System.out.println("Other Logistic = "+objReq.getLogisticTH());
            objReq.setCreateBy(memberObj.getCodempid());
            objReq.setNameCreate(memberObj.getNamempt());
            obj = saveSampleResultService.saveSampleResult(objReq);
            System.out.println(objReq);


        } catch (Exception ex) {
//            obj.put("success", 0);
//            obj.put("message", (ex.getMessage().length() > 500 ? ex.getMessage().substring(0, 500) : ex.getMessage()));
//            ex.printStackTrace();
			logger.error("Exception : {}",ex);
			throw new RuntimeException(ex.getMessage());
        }

        return obj;
    }
    @RequestMapping(value = "/queryDataRandomSimpleResult", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> queryDataRandomSimpleResult(@RequestBody RandomOil objReq, HttpServletRequest req, HttpSession session) throws Exception {
        Map<String, Object> obj = new HashMap<String, Object>();
        MemberObj memberObj = CGlobal.getC_UserInfo(session);
        objReq.setPlantid(memberObj.getPlantId());
        try {
            obj = saveSampleResultService.queryDataRandomSimpleResult(objReq);
            obj.put("success",1);
            //System.out.println(obj);

        } catch (Exception ex) {
            obj.put("success", 0);
            obj.put("message", (ex.getMessage().length() > 500 ? ex.getMessage().substring(0, 500) : ex.getMessage()));
            ex.printStackTrace();
        }

        return obj;
    }

}
