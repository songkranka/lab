package th.co.pt.ptgapp.controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import th.co.pt.ptgapp.controller.bean.MbStationMaster;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.service.UploadDataStationPTCService;
import th.co.pt.ptgapp.utils.CGlobal;
import th.co.pt.ptgapp.utils.FileUploadUtil;

@Controller
public class UploadDataStationPTC {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UploadDataStationPTCService uploadDataStationPTCService;
	
	@Autowired
	ServletContext context;
	
    @RequestMapping("uploadPTCStation")
    public ModelAndView home_uploadPTCStation(HttpServletRequest req, HttpSession session, Model model) throws Exception {
    	
    	//System.getProperty("catalina.base");
    	
    	ModelAndView view = new ModelAndView("uploadPTCStation");
    	MemberObj  memberObj = CGlobal.getC_UserInfo(session);
    	//userService.getUser("xx");
    	
    	RandomOil objReq =new RandomOil();
    	//objReq.setNameStore(memberObj.getPlantId());
 
        return view;
    }

	@RequestMapping(value = "/importPTCStation", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> ImportPTCStation(HttpSession session, HttpServletRequest request, @RequestParam("file") MultipartFile file) {
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			String original_name = FilenameUtils.getExtension(file.getOriginalFilename());
			logger.info("original_name === "+original_name);
			if (!file.isEmpty()) {
				
				if (original_name.equalsIgnoreCase("xls")||original_name.equalsIgnoreCase("xlsx")||original_name.equalsIgnoreCase("csv")) {
					
					logger.info(" Format file excel Allright ");
					
					//List<MbStationMaster> list = FileUploadUtil.ExcelFileStationPTC(file);
					
					
					//logger.info("Read file for upload "+list.toString());
				} else {
					result.put("status","E");
					result.put("msg", "File '" + original_name + "' is not Excel format.");
				}
			} else {
				result.put("status","E");
				result.put("msg", "You failed to upload " + original_name + " because the file was empty.");
			}
		} catch(Exception e){
			result.put("status","E");
			result.put("msg",e.getMessage());
			logger.error("",e);
		}
		return result;
	}


	@RequestMapping(value = "/importPTCStation_csv", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> ImportPTCStation_csv(HttpSession session, HttpServletRequest request, @RequestParam("file") MultipartFile file) {
		Map<String, Object> result = new HashMap<String, Object>();
		try{
			MemberObj  memberObj = CGlobal.getC_UserInfo(session);
			
			String original_name = FilenameUtils.getExtension(file.getOriginalFilename());
			logger.info("original_name === "+original_name);
			if (!file.isEmpty()) {
				
				if (original_name.equalsIgnoreCase("xls")||original_name.equalsIgnoreCase("xlsx")||original_name.equalsIgnoreCase("csv")) {
					
					logger.info(" Format file excel Allright ");
					//logger.info(" Path "+Paths.get("D:\\project_in_git\\ptg-lab-webapp-project2\\src\\main\\webapp\\assets\\uploads").toString());
					/*
					List<MbStationMaster> list = FileUploadUtil.ExcelFileStationPTC_csv(file, memberObj);
					logger.info("setup list Entity ");
					Map<String, Object> importRes = uploadDataStationPTCService.importMasterStationPTC(list);
					 
					logger.info("Read file for upload "+importRes.toString());
					*/
					/*
					if(!Files.exists(Paths.get("D:\\project_in_git\\ptg-lab-webapp-project2\\src\\main\\webapp\\assets\\uploads"))){
						Files.createDirectory(Paths.get("D:\\project_in_git\\ptg-lab-webapp-project2\\src\\main\\webapp\\assets\\uploads"));
					}
					
					Files.deleteIfExists(Paths.get("D:\\project_in_git\\ptg-lab-webapp-project2\\src\\main\\webapp\\assets\\uploads\\station.csv"));
				
					
					Files.copy(file.getInputStream(), Paths.get("D:\\project_in_git\\ptg-lab-webapp-project2\\src\\main\\webapp\\assets\\uploads").resolve("station.csv"));
					*/
					
					String absolutePath = context.getRealPath("resources/uploads");

					if(!Files.exists(Paths.get(absolutePath))){
						Files.createDirectory(Paths.get(absolutePath));
					}
					
					Files.deleteIfExists(Paths.get(absolutePath+"/station.csv"));
				
					
					Files.copy(file.getInputStream(), Paths.get(absolutePath).resolve("station.csv"));
					
					
					
					result.put("status","S");
					result.put("msg", " อัพโหลดไฟล์สำเร็จ กรุณารอตรวจสอบผลจากอีเมลล์");
				} else {
					result.put("status","E");
					result.put("msg", "File '" + original_name + "' is not Excel format.");
				}
			} else {
				result.put("status","E");
				result.put("msg", "You failed to upload " + original_name + " because the file was empty.");
			}
		} catch(Exception e){
			result.put("status","E");
			result.put("msg",e);
			logger.error("Exception import PTC Station Controller ",e);
		}
		return result;
	}

	
}
