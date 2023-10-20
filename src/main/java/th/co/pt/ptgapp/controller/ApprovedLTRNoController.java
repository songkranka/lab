package th.co.pt.ptgapp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import th.co.pt.ptgapp.config.MSGLabPropertiesServiceImpl;
import th.co.pt.ptgapp.config.PtgPropertiesServiceImpl;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.service.RandomService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ApprovedLTRNoController {
	@Autowired
	private RandomService randomService;
	
    @Autowired
    private PtgPropertiesServiceImpl PtgPropertiesServiceImpl;
  
    @Autowired
    private MSGLabPropertiesServiceImpl msgLabPropertiesService;

    @RequestMapping("/initApprovedLTRNo")
    public ModelAndView initApprovedLTRNo(HttpServletRequest req,Model model) throws Exception{
       // System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
       
        //userService.getUser("xx");
    	RandomOil objReq =new RandomOil();
    	//List<Map<String, Object>> resultList = randomService.groupNameStoreRandomOil(objReq);
    	
    	 
        return new ModelAndView("initApprovedLTRNo");
    }
   
 
 
}
