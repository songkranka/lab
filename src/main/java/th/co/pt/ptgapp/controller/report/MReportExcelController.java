package th.co.pt.ptgapp.controller.report;

import java.io.IOException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import th.co.pt.ptgapp.controller.bean.RandomOil;

@Controller 
@RequestMapping("/api/report")
public class MReportExcelController {

	@Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;
	
	@SuppressWarnings({ "resource" })
	@RequestMapping(value = "/reportExcelTrip/{tripID}/{productID}/{tripName}/{productName}/{typeReport}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<StreamingResponseBody> reportExcelTrip(RandomOil objReq
    		,@PathVariable("tripID") String tripID
    		,@PathVariable("productID") String productID
    		,@PathVariable("tripName") String tripName
    		,@PathVariable("productName") String productName
    		,@PathVariable("typeReport") String typeReport)throws  Exception{
		objReq.setTripID(tripID);
		objReq.setProductID(productID);
		objReq.setTripName(tripName);
		objReq.setProductName(productName);
		objReq.setTypeReport(typeReport);
		//System.out.println(objReq.getTripID());
    	Workbook workBook = new XSSFWorkbook();
    	//workBook.close();
    	String nameReport = "";
    	if(objReq.getTypeReport().equals("groupReport")) {
    		workBook = exportExcelGroupMB(objReq);
    		nameReport = "ExcelGroupMB";
    	}else if(objReq.getTypeReport().equals("summaryReport")){
    		workBook = exportExcelSummaryMB(objReq);
    		nameReport = "ExcelSummaryMB";  
    	}
    	return ResponseEntity
    		    .ok()
    		    .contentType(MediaType.APPLICATION_OCTET_STREAM)
    		    .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename="+nameReport+".xlsx")
    		    .body(workBook::write);
    }
    public Map<String,Object> queryReportExcel(RandomOil objReq) {
    	Map<String,Object> result = new HashMap<String, Object>();
    	try{	
            SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER)
                    .withProcedureName("queryReportExcelMB");
            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("tripID", objReq.getTripID(), Types.VARCHAR)
                    .addValue("typeReport", objReq.getTypeReport(), Types.VARCHAR)
                    .addValue("productID", objReq.getProductID(), Types.VARCHAR);
            List<Map<String, Object>> list = (List<Map<String, Object>>) call.execute(in).get("#result-set-1"); 
            result.put("list", list);
    	}catch (Exception ex){
    		ex.printStackTrace();
    	}
    	return result;
    }
    public Workbook exportExcelGroupMB(RandomOil objReq) throws IOException {
    	Workbook workbook = new XSSFWorkbook();
    	try {
        	Map<String,Object> resultList = queryReportExcel(objReq);
        	//List list =  (List)objReq.get("list") ;
    		//System.out.println(resultList);
    		List list =  (List)resultList.get("list") ;
    		
        	
    		
    		Sheet sheet = workbook.createSheet(objReq.getProductName());
    			
    	
    		
    		//Merge CELL
    		sheet.addMergedRegion(CellRangeAddress.valueOf("A1:O1"));
    		
    		
    		//SET HEADER
    		CellStyle headerStyle = workbook.createCellStyle();
    		headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
    		headerStyle.setFillPattern(FillPatternType.SQUARES);
    		
    		XSSFFont font = ((XSSFWorkbook) workbook).createFont();
    		font.setFontName("Tahoma");
    		font.setFontHeightInPoints((short) 11);
    		font.setBold(true);
    		headerStyle.setFont(font);
    		
    		//CELL STYLE
    		CellStyle style;
    		style = workbook.createCellStyle();
    		//style.setAlignment(HorizontalAlignment.CENTER);
    		style.setBorderRight(BorderStyle.THIN);
    		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
    		style.setBorderLeft(BorderStyle.THIN);
    		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
    		style.setBorderTop(BorderStyle.THIN);
    		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
    		style.setBorderBottom(BorderStyle.THIN);
    		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
    				
    		//HEADER
    		Row header = sheet.createRow(3);
    		String array[] = {"วันที่เก็บตัวอย่าง","No.","สถานีบริการ","visual","Color","API@60F",
    				"T_10","T_50","T_90","FP","%B100","Cl","FBP","%กาก","%EtOH","RON","MON","AG",
    				"Remark","Code","เขตขาย","คลังที่รับน้ำมัน"};
    		Cell headerCell = header.createCell(0);
    		headerCell.setCellStyle(headerStyle);
    		int h=1;
    		for(String setHeader : array) {
    			headerCell.setCellStyle(style);
    			headerCell.setCellValue(setHeader);	 
    			headerCell = header.createCell(h++);
    		} 
    		
    		//BODY
    		
    		Cell cell;
    		
    		Row rowH = sheet.createRow(0);
    		cell = rowH.createCell(0);
    		cell.setCellValue("รายงานผลการตรวจสอบคุณภาพน้ำมัน "+objReq.getProductName()+" ตามโปรแกรมการตรวจสอบและทดสอบคุณภาพน้ำมันของสถานีบริการ");
    		
    		Row rowH2 = sheet.createRow(1);
    		cell = rowH2.createCell(0);
    		cell.setCellValue("Trip : "+objReq.getTripName());
    		String cellName[] = {"CREATE_DATE","rowNum","CENTER_NAME","FEATURE","COLOR_NAME","API_60"
    				,"EVAPORATION_10","EVAPORATION_50","EVAPORATION_90","FLASH_POINT","BIODIESEL","CETANE"
    				,"BOIL","WASTE_OIL","ETHANOL","RON","MON","Ag","COMPLETE_FLG","TYPE_STATION","PLACE","PLANT_RECEIVE"};
    		int i = 4;
    		//System.out.println(cellName[1]);
    		for(int iN = 0 ; iN<list.size();iN++){
    			 Map mapReq = (Map) list.get(iN);
    			 //System.out.println(list);	 
    			 Row row = sheet.createRow(i++);
    			 for(int createCell = 0;createCell<cellName.length;createCell++) {
    				if(cellName[createCell].equals("CENTER_NAME")) {
    					style.setAlignment(HorizontalAlignment.LEFT);	 		
    				}else {
    					 style.setAlignment(HorizontalAlignment.CENTER);
    				}
    				cell = row.createCell(createCell);
  					cell.setCellStyle(style);
  					cell.setCellValue(mapReq.get(cellName[createCell]).toString());	
    					//System.out.println(createCell+"|"+cellName[createCell]+"|"+cellName.length);
    			 }			
    		}
    		
    		//FOOTER
    		//SET AVG
    		objReq.setTypeReport("AVG");
    		Map<String,Object> resultAVG = queryReportExcel(objReq);
    		List listAVG =  (List)resultAVG.get("list") ;
    		//SET MAX
    		objReq.setTypeReport("MAX");
    		Map<String,Object> resultMAX = queryReportExcel(objReq);
    		List listMAX =  (List)resultMAX.get("list") ;
    		
    		//SET MIN
    		objReq.setTypeReport("MIN");
    		Map<String,Object> resultMIN = queryReportExcel(objReq);
    		List listMIN =  (List)resultMIN.get("list") ;
    		
    		String arrayFooter[] = {"AVERAGE","MAX","MIN"};
    		String cellNameAMM[] = {"API_60","EVAPORATION_10","EVAPORATION_50","EVAPORATION_90","FLASH_POINT","BIODIESEL","CETANE"
    				,"BOIL","WASTE_OIL","ETHANOL","RON","MON"};
    		int f=1;
    		for(int fR=0;fR<arrayFooter.length;fR++) {
    			Row footer = sheet.createRow(i++);
    			Cell footerCell = footer.createCell(0);
    			footerCell.setCellStyle(style);
    			footerCell.setCellValue(arrayFooter[fR]);
    			//MERGE
    			//sheet.addMergedRegion(CellRangeAddress.valueOf("A"+i+":C"+i));
    			//footerCell = footer.createCell(f++);
    			Cell cellSum ;
    			int iCn = 5;
    			if(fR==0) {
    				Map mapReq = (Map) listAVG.get(0);
    				//System.out.println(mapReq.get(cellNameAMM[1]));
    				for(int createCell = 0;createCell<cellNameAMM.length;createCell++) {
    					cellSum = footer.createCell(iCn++);
    					cellSum.setCellStyle(style);
    					cellSum.setCellValue(mapReq.get(cellNameAMM[createCell]).toString());	
    				}
    			}
    			else if(fR==1) {
    				Map mapReq = (Map) listMAX.get(0);
    				for(int createCell = 0;createCell<cellNameAMM.length;createCell++) {
    					cellSum = footer.createCell(iCn++);
    					cellSum.setCellStyle(style);
    					cellSum.setCellValue(mapReq.get(cellNameAMM[createCell]).toString());	
    				}
    			}else if(fR==2) {
    				Map mapReq = (Map) listMIN.get(0);
    				for(int createCell = 0;createCell<cellNameAMM.length;createCell++) {
    					cellSum = footer.createCell(iCn++);
    					cellSum.setCellStyle(style);
    					cellSum.setCellValue(mapReq.get(cellNameAMM[createCell]).toString());	
    				}
    			}
    			
    			
    		}
    		for(int iMer=(i-2);iMer<=(i);iMer++) {
    			sheet.addMergedRegion(CellRangeAddress.valueOf("B"+iMer+":E"+iMer+""));
    			//"F3:L4"
    			RegionUtil.setBorderBottom(1, CellRangeAddress.valueOf("B"+iMer+":E"+iMer+""), sheet);
    			RegionUtil.setBorderTop(1, CellRangeAddress.valueOf("B"+iMer+":E"+iMer+""), sheet);
    			RegionUtil.setBorderLeft(1, CellRangeAddress.valueOf("B"+iMer+":E"+iMer+""), sheet);
    			RegionUtil.setBorderRight(1, CellRangeAddress.valueOf("B"+iMer+":E"+iMer+""), sheet);
    			
    			RegionUtil.setBorderBottom(1, CellRangeAddress.valueOf("M"+iMer+":V"+iMer+""), sheet);
    			RegionUtil.setBorderTop(1, CellRangeAddress.valueOf("M"+iMer+":V"+iMer+""), sheet);
    			RegionUtil.setBorderLeft(1, CellRangeAddress.valueOf("M"+iMer+":V"+iMer+""), sheet);
    			RegionUtil.setBorderRight(1, CellRangeAddress.valueOf("M"+iMer+":V"+iMer+""), sheet);
    		}
    		
    	    
    		
    		//SET SIZE
    		for (int col=0;col<array.length;col++) {
    			sheet.autoSizeColumn(col);
    		} 	
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}

		return workbook;
	}
	public Workbook exportExcelSummaryMB(RandomOil objReq) throws IOException {
    	short ixx = 1;
    	//BorderStyle ixx = BorderStyle.THIN;
    	Workbook workbook = new XSSFWorkbook();
    	
    	try {
    		Map<String,Object> resultList = queryReportExcel(objReq);
        	//List list =  (List)objReq.get("list") ;
    		//System.out.println(resultList);
    		List list =  (List)resultList.get("list") ;
    		Sheet sheet = workbook.createSheet("สรุปผล");
    		//System.out.println(objReq);
    		//Merge CELL
    		sheet.addMergedRegion(CellRangeAddress.valueOf("A1:H1"));
    		
    		
    		//SET HEADER
    		CellStyle headerStyle = workbook.createCellStyle();
    		headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
    		headerStyle.setFillPattern(FillPatternType.SQUARES);
    		
    		
    		XSSFFont font = ((XSSFWorkbook) workbook).createFont();
    		font.setFontName("Tahoma");
    		font.setFontHeightInPoints((short) 11);
    		font.setBold(true);
    		headerStyle.setFont(font);
    		
    		//CELL STYLE
    		CellStyle style;
    		style = workbook.createCellStyle();
    		style.setWrapText(true);
    		style.setAlignment(HorizontalAlignment.CENTER);
    		style.setBorderRight(BorderStyle.THIN);
    		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
    		style.setBorderLeft(BorderStyle.THIN);
    		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
    		style.setBorderTop(BorderStyle.THIN);
    		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
    		style.setBorderBottom(BorderStyle.THIN);
    		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
    		style.setVerticalAlignment(VerticalAlignment.CENTER);
    		
    		//HEADER
    		Cell cell;
    		
    		Row row0,row1,row2,row3,row4;
    		row0 = sheet.createRow(0);
    		cell = row0.createCell(0);
    		cell.setCellValue("สรุปผลการตรวจสอบคุณภาพน้ำมัน ณ สถานีบริการ   Trip : "+objReq.getTripName()+" มีรายละเอียด  ดังต่อไปนี้");
    		String array[] = {"ลำดับ","สถานีบริการ","ชื่อสถานีบริการ","เขตการขาย","Cost Center","คลังที่รับผิดชอบ"};
   		
    		for(int iMerge=0;iMerge<array.length;iMerge++) {
    			sheet.addMergedRegion(new CellRangeAddress(2, 4, iMerge, iMerge));
    		}
    		row2 = sheet.createRow(2);	
    		
    		cell = row2.createCell(0);
    		//cellH2.setCellStyle(style);	
    		int hR=1;
    		for(String setHeader : array) {		
    			cell.setCellValue(setHeader);	
    			cell.setCellStyle(style);
    			cell = row2.createCell(hR++); 			
    		} 
//    		RegionUtil.setBorderBottom(1, CellRangeAddress.valueOf("C3:D5"), sheet);
//    		RegionUtil.setBorderTop(1, CellRangeAddress.valueOf("C3:D5"), sheet);
//    		RegionUtil.setBorderLeft(1, CellRangeAddress.valueOf("C3:D5"), sheet);
//    		RegionUtil.setBorderRight(1, CellRangeAddress.valueOf("C3:D5"), sheet);
    		String[] mergeArray = {"A","B","C","D","E"};
    		for(String m : mergeArray) {	
    			RegionUtil.setBorderBottom(ixx, CellRangeAddress.valueOf(""+m+"3:"+m+"5"), sheet);
        		RegionUtil.setBorderTop(ixx,CellRangeAddress.valueOf(""+m+"3:"+m+"5"), sheet);
        		RegionUtil.setBorderLeft(ixx, CellRangeAddress.valueOf(""+m+"3:"+m+"5"), sheet);
        		RegionUtil.setBorderRight(ixx,CellRangeAddress.valueOf(""+m+"3:"+m+"5"), sheet);	
    		} 
    	
    	
    		cell = row2.createCell(6);
            cell = sheet.getRow(2).getCell(6);
            cell.setCellValue("ผลการตรวจสอบอุปกรณ์ประจำสถานีบริการ");
            cell.setCellStyle(style);
            
            cell = row2.createCell(13);
            cell = sheet.getRow(2).getCell(13);
            cell.setCellValue("ผลการฝึกอบรมพนักงาน");
            cell.setCellStyle(style);
            
            sheet.addMergedRegion(CellRangeAddress.valueOf("G3:M4"));
    		sheet.addMergedRegion(CellRangeAddress.valueOf("N3:S3"));
    		//"F3:L4"
    		RegionUtil.setBorderBottom(ixx, CellRangeAddress.valueOf("G3:M4"), sheet);
    		RegionUtil.setBorderTop(ixx, CellRangeAddress.valueOf("G3:M4"), sheet);
    		RegionUtil.setBorderLeft(ixx,CellRangeAddress.valueOf("G3:M4"), sheet);
    		RegionUtil.setBorderRight(ixx, CellRangeAddress.valueOf("G3:M4"), sheet);
    		//"M3:R3"
    		RegionUtil.setBorderBottom(ixx, CellRangeAddress.valueOf("N3:S3"), sheet);
    		RegionUtil.setBorderTop(ixx,CellRangeAddress.valueOf("N3:S3"), sheet);
    		RegionUtil.setBorderLeft(ixx, CellRangeAddress.valueOf("N3:S3"), sheet);
    		RegionUtil.setBorderRight(ixx, CellRangeAddress.valueOf("N3:S3"), sheet);	
    		
    		String arrayH[] = {"ความเข้าใจเรื่องคุณภาพ","ความถ่วงเอพีไอ","ปริมาณเอทานอล","ADO","GSL","GSH95","GSH91","E20"
    				,"E85","B20","B10"};
    		int zzi = 0;
    		row3 = sheet.createRow(3);
    		
    		for(int zz=13;zz<35;zz+=2) {
    			sheet.addMergedRegion(new CellRangeAddress(3, 3, zz, zz+1));
    			cell = row3.createCell(zz);
    		    cell = sheet.getRow(3).getCell(zz);
    		    cell.setCellValue(arrayH[zzi]);
    		    cell.setCellStyle(style);
    		    
    		    RegionUtil.setBorderBottom(ixx, new CellRangeAddress(3, 3, zz, zz+1), sheet);
    			RegionUtil.setBorderTop(ixx, new CellRangeAddress(3, 3, zz, zz+1), sheet);
    			RegionUtil.setBorderLeft(ixx,new CellRangeAddress(3, 3, zz, zz+1), sheet);
    			RegionUtil.setBorderRight(ixx,new CellRangeAddress(3, 3, zz, zz+1), sheet);
    		    zzi++;
    		}
    		
    		sheet.addMergedRegion(new CellRangeAddress(2,2 ,19 ,34 ));
    	    cell = row2.createCell(19);
            cell = sheet.getRow(2).getCell(19);
            cell.setCellValue("สรุปผลการตรวจสอบคุณภาพ");
            cell.setCellStyle(style);
            RegionUtil.setBorderBottom(ixx, new CellRangeAddress(2,2 ,19 ,34 ), sheet);
    		RegionUtil.setBorderTop(ixx, new CellRangeAddress(2,2 ,19 ,34 ), sheet);
    		RegionUtil.setBorderLeft(ixx,new CellRangeAddress(2,2 ,19 ,34 ), sheet);
    		RegionUtil.setBorderRight(ixx,new CellRangeAddress(2,2 ,19 ,34 ), sheet);
            
    		String array2[] = {"ชุดไฮโดรมิเตอร์ (4 อัน)","เทอร์โมมิเตอร์ (2 อัน)","กระบอกแก้ว","ตาราง 5B","กระบองตวง(มีฝาปิด)","ถังตวง 5 ลิตร","น้ำยาวัดน้ำ(ธรรมดา)",
    				"คะแนนการฝึกอบรม","ผ่าน/ไม่ผ่านเกณฑ์","คะแนนการฝึกอบรม","ผ่าน/ไม่ผ่านเกณฑ์","คะแนนการฝึกอบรม","ผ่าน/ไม่ผ่านเกณฑ์","ผ่าน/ไม่ผ่าน","รายการที่ไม่ผ่าน",
    				"ผ่าน/ไม่ผ่าน","รายการที่ไม่ผ่าน","ผ่าน/ไม่ผ่าน","รายการที่ไม่ผ่าน","ผ่าน/ไม่ผ่าน","รายการที่ไม่ผ่าน","ผ่าน/ไม่ผ่าน","รายการที่ไม่ผ่าน","ผ่าน/ไม่ผ่าน","รายการที่ไม่ผ่าน",
    				"ผ่าน/ไม่ผ่าน","รายการที่ไม่ผ่าน","ผ่าน/ไม่ผ่าน","รายการที่ไม่ผ่าน"};
    		//int firstRow2 = 2;
    		row4 = sheet.createRow(4);	
    		cell = row4.createCell(6);
    		cell.setCellStyle(style);	
    		int hR3=7;
    		for(String setHeader3 : array2) {
    			cell.setCellStyle(style);
    			cell.setCellValue(setHeader3);	 
    			cell = row4.createCell(hR3++);
    		}
    		
    		//BODY
    		
    		String cellName[] = {"rowNums","TYPE_STATION","CENTER_NAME","PLACE","COST_CENTER","PLANT_RECEIVE"
    				,"Tool1","Tool2","Tool3","Tool4","Tool5","Tool6"
    				,"Tool7","SCORE_GENERAL","CHECK_SCORE_GENERAL","SCORE_API","CHECK_SCORE_API","SCORE_ETHANOL",
    				"CHECK_SCORE_ETHANOL","Y1","N1","Y2","N2","Y3","N3","Y4","N4","Y5","N5","Y6","N6","Y7","N7",
    				"Y8","N8"};
    		int i = 5;
    		//System.out.println(list);
    		for(int iN = 0 ; iN<list.size();iN++){
    			 Map mapReq = (Map) list.get(iN);
    			 //System.out.println(mapReq.get("CREATE_DATE"));	 
    			 Row row = sheet.createRow(i++);
    			 for(int createCell = 0;createCell<cellName.length;createCell++) {
    				 	cell = row.createCell(createCell);
    				 	//System.out.println(cellName[createCell].toString());
    					cell.setCellStyle(style);
    					
    					
    					if(cellName[createCell].toString().equals("CENTER_NAME")) {
							cell.setCellValue(mapReq.get(cellName[createCell]).toString());	
							style.setAlignment(HorizontalAlignment.LEFT);
							cell.setCellStyle(style);
						}else {
							if(mapReq.get(cellName[createCell]).toString().equals("FAIL")){
	    						cell.setCellValue("ไม่ผ่าน");
	    					}else if(mapReq.get(cellName[createCell]).toString().equals("PASS")) {
	    						cell.setCellValue("ผ่าน");
	    					}else {
	    						cell.setCellValue(mapReq.get(cellName[createCell]).toString());
								style.setAlignment(HorizontalAlignment.CENTER);
								cell.setCellStyle(style);
	    					}
							
						}
    					//System.out.println(createCell+"|"+cellName[createCell]+"|"+cellName.length);
    			 }			
    		}  		
    		//SET SIZE
    		for (int col=0;col<array.length;col++) {
    			sheet.autoSizeColumn(col);
    		}
//    		try (FileOutputStream outputStream1 = new FileOutputStream("Export_Oil_MB_SUMMARY.xlsx")) {
//                workbook.write(outputStream1);
//            }
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}	
    	return workbook;
	}
}
