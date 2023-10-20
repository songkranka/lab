package th.co.pt.ptgapp.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import th.co.pt.ptgapp.controller.bean.MbStationMaster;
import th.co.pt.ptgapp.controller.bean.MemberObj;

public class FileUploadUtil {

/*	
	public static List<MbStationMaster> ExcelFileStationPTC(MultipartFile file) {

		Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);
		
		logger.info("ExcelFileStationPTC()...");
		
		List<MbStationMaster> list = new ArrayList<MbStationMaster>();
		String original_name;
		InputStream excelFile;
		Sheet sheet = null;
		
		logger.info("start get excel...");
		try {
			original_name = FilenameUtils.getExtension(file.getOriginalFilename());
			logger.info("1 original_name = "+original_name);
			excelFile = file.getInputStream();
			logger.info("2");
			
			if(original_name.equalsIgnoreCase("xlsx")){
				logger.info("2 xlsx");
				XSSFWorkbook wb = new XSSFWorkbook(excelFile);
				logger.info("2 XSSFWorkbook");
				sheet = wb.getSheetAt(0);
			}else if(original_name.equalsIgnoreCase("xls")){
				logger.info("2 xls");
				HSSFWorkbook wb = new HSSFWorkbook(excelFile);
				logger.info("2 HSSFWorkbook");
				sheet = wb.getSheetAt(0);
			}else if(original_name.equalsIgnoreCase("csv")){
				logger.info("2 csv");
				Workbook wb = new HSSFWorkbook(excelFile);
				//HSSFWorkbook wb = new HSSFWorkbook(excelFile);
				logger.info("2 HSSFWorkbook CSV");
				sheet = wb.getSheetAt(0);
			}
			logger.info("3");
			

			Row row = null;
			Iterator rows = sheet.rowIterator();
			logger.info("4");
			
			int cell_row_number = 0;
			int i = 0;
			logger.info("5");
			
			while (rows.hasNext()) {

				if(original_name.equalsIgnoreCase("xlsx")){
					row = (XSSFRow) rows.next();
				}else if(original_name.equalsIgnoreCase("xls")){
					row = (HSSFRow) rows.next();
				}else if(original_name.equalsIgnoreCase("csv")){
					row = (HSSFRow) rows.next();
				}
				
				if (cell_row_number != 0) {
					
					MbStationMaster master = new MbStationMaster();
										
					if(!String.valueOf(row.getCell(1)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(1)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setType(String.valueOf(row.getCell(1)).replace("null", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setType("");
					if(!String.valueOf(row.getCell(2)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(2)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setProductID(String.valueOf(row.getCell(2)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setProductID(""); 
					if(!String.valueOf(row.getCell(4)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(4)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setSiteCode(String.valueOf(row.getCell(4)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setSiteCode("");
					if(!String.valueOf(row.getCell(5)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(5)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setRef(String.valueOf(row.getCell(5)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setRef("");
					if(!String.valueOf(row.getCell(8)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(8)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setPlace(String.valueOf(row.getCell(8)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setPlace("");
					if(!String.valueOf(row.getCell(9)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(9)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setPlantID(String.valueOf(row.getCell(9)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setPlantID(""); 
					if(!String.valueOf(row.getCell(10)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(10)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setCostCenter(String.valueOf(row.getCell(10)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setCostCenter(""); 
					if(!String.valueOf(row.getCell(11)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(11)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setProfitCenter(String.valueOf(row.getCell(11)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setProfitCenter("");
					if(!String.valueOf(row.getCell(12)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(12)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setCenterName(String.valueOf(row.getCell(12)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setCenterName("");
					if(!String.valueOf(row.getCell(13)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(13)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setPart(String.valueOf(row.getCell(13)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setPart("");
					if(!String.valueOf(row.getCell(14)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(14)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setAddrTumbon(String.valueOf(row.getCell(14)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setAddrTumbon(""); 
					if(!String.valueOf(row.getCell(15)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(15)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setAddrAmphur(String.valueOf(row.getCell(15)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setAddrAmphur(""); 
					if(!String.valueOf(row.getCell(16)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(16)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setAddrProvince(String.valueOf(row.getCell(16)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setAddrProvince("");
					if(!String.valueOf(row.getCell(17)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(17)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setPostCode(String.valueOf(row.getCell(17)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setPostCode("");
					if(!String.valueOf(row.getCell(18)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(18)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setAddress(String.valueOf(row.getCell(18)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setAddress(""); 
					if(!String.valueOf(row.getCell(22)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(22)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setEmail(String.valueOf(row.getCell(22)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setEmail(""); 
					if(!String.valueOf(row.getCell(24)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(24)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setMobileNo(String.valueOf(row.getCell(24)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setMobileNo(""); 
					if(!String.valueOf(row.getCell(25)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(25)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setPhoneNo(String.valueOf(row.getCell(25)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setPhoneNo(""); 
					if(!String.valueOf(row.getCell(42)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(42)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setGps(String.valueOf(row.getCell(42)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setGps(""); 
					if(!String.valueOf(row.getCell(45)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(45)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setModel(String.valueOf(row.getCell(45)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setModel("");
					if(!String.valueOf(row.getCell(46)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(46)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setPlantReceive(String.valueOf(row.getCell(46)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setPlantReceive("");
					if(!String.valueOf(row.getCell(47)).replace(".0", "").trim().equalsIgnoreCase("") && !String.valueOf(row.getCell(47)).replace(".0", "").trim().equalsIgnoreCase("null")) master.setOperatingStatus(String.valueOf(row.getCell(47)).replace(".0", "").trim().split(",")[1].replace("\"", "").replace(")", "").trim()); else master.setOperatingStatus("");

					list.add(master);
					if (cell_row_number >2) break;
				}
				cell_row_number++;
			}
			
			logger.info("6");
			
			excelFile.close();
			
			
		} catch (IOException e){
			logger.error("Error ExcelFileStationPTC IOException ",e);
		} catch (Exception e){

			logger.error("Error ExcelFileStationPTC Exception ",e);
		}
		
		return list;
	}
	*/
	public static List<MbStationMaster> ExcelFileStationPTC_csv(MultipartFile file, MemberObj  memberObj) {

		Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);
		
		logger.info("ExcelFileStationPTC()...");
		
		List<MbStationMaster> list = new ArrayList<MbStationMaster>();
		BufferedReader br = null;
		InputStreamReader isr = null;
		InputStream is = null;
		
		try {

			is = file.getInputStream() ;
			isr = new InputStreamReader(is);  /// ,"UTF-8"
			br = new BufferedReader(isr) ;
			String line;
			int brLine = 0;
			
			logger.info("========== FILE ENDCODING  ================ ");
			logger.info(isr.getEncoding());
			
			while ((line = br.readLine()) != null) {
				
				if(brLine > 8){
					MbStationMaster master = new MbStationMaster();
					
					//String finalLine;
					//byte[] toByte = line.getBytes("MS874");
					//logger.info("get Byte = "+toByte.toString());
					
					//finalLine = new String(toByte,"UTF-8");
					//logger.info("final Line data = "+line);
					
					String csv[] = line.toString().trim().split("\\|");	
					//String csv[] = finalLine.toString().trim().split("\\|");

		            //logger.info("info after split == "+csv.toString());
		            //logger.info("  csv[1] == "+csv[1].trim());
		            //logger.info("  csv[2] == "+csv[2].trim());
					logger.info("line"+csv[0]+" --- model :"+csv[45]);
					
					
		            master.setType(csv[1]);
		            master.setProductID(csv[2]);
		            master.setSiteCode(csv[4]);
		            master.setRef(csv[5]);
		            master.setPlace(csv[8]);
		            master.setPlantID(csv[9]);
		            master.setCostCenter(csv[10]);
		            master.setProfitCenter(csv[11]);
		            master.setCenterName(csv[12]);
		            master.setPart(csv[13]);
		            master.setAddrTumbon(csv[14]);
		            master.setAddrAmphur(csv[15]);
		            master.setAddrProvince(csv[16]);
		            master.setPostCode(csv[17]);
		            master.setAddress(csv[18]);
		            master.setEmail(csv[22]);
		            master.setMobileNo(csv[24]);
		            master.setPhoneNo(csv[25]);
		            master.setGps(csv[42]);
		            master.setModel(csv[45]);
		            master.setPlantReceive(csv[46]);
//		            master.setOperatingStatus(csv[47]);
		            master.setTypeStation("PTC");
		            master.setCreateBy(memberObj.getCodempid());
		            
		            list.add(master);					
				}

	            brLine++;
	            
	           // if(brLine > 10) break;
	        }
			
		} catch (IOException e) {
			logger.error("Error csv IOException ",e);
		} finally {
			try{if (br!=null) br.close();}catch(IOException e){}
		}
		
		return list;
	}
}
