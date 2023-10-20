package th.co.pt.ptgapp.service.report;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.SendMailWFObj;
import th.co.pt.ptgapp.dao.report.ReportLTRDao;
import th.co.pt.ptgapp.dao.report.StationMasterDao;
import th.co.pt.ptgapp.entity.RequestCondition;
import th.co.pt.ptgapp.entity.ResultLTrBean;
import th.co.pt.ptgapp.entity.StationBean;
import th.co.pt.ptgapp.entity.WaitWorkModel;
import th.co.pt.ptgapp.entity.report.ReportRequestNo;
import th.co.pt.ptgapp.service.SendMailService;
import th.co.pt.ptgapp.service.UtilService;
import th.co.pt.ptgapp.utils.CGlobal;
import th.co.pt.ptgapp.utils.ReportUtils;
import th.co.pt.ptgapp.utils.WebUtil;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import org.apache.poi.ss.usermodel.Row;

@Service
public class ReportLTRServiceImpl implements ReportLTRService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Value("${url.complete.redirect}")
	private  String BASE_URL;

	
    @Autowired
    ReportLTRDao reportLTRDao;
    @Autowired
    UtilService utilService;
    @Autowired
    SendMailService sendMailService;
	@Autowired
	private Environment env;
	@Autowired
	ReportLTRService reportLTRService;
	@Override
	public List<Map<String, Object>> mapDataForReportLTR(String []labCode,String productType,String reportType,String reportedBy,String codEmpId) {
			// TODO Auto-generated method stub
		List<Map<String, Object>>  resultList = new ArrayList<Map<String,Object>>();
		
		try{
			if("LTR".equals(reportType)) {
				if("00006".equals(productType)) { //Additive
					resultList = reportLTRDao.getDataReportAdditives3(labCode,reportedBy,codEmpId);
					//resultList =  reportLTRDao.getDataReportAdditives2(labCode,reportedBy,codEmpId);
					
				}else {
					resultList =  reportLTRDao.getDataForLTR(labCode,reportedBy,codEmpId);
				}
			}else {
					resultList =  reportLTRDao.getDataForCOQ(labCode,reportedBy,codEmpId);
			}
			
			logger.debug("resultList :{}",resultList.size());
			return resultList;
		}catch(Exception e){
			logger.error("Exception : {}");
			throw new RuntimeException(e.getMessage());
		}
			
	}
	
	@Override
	public Workbook exportReportPageHeader(String[] labCode) {
		// TODO Auto-generated method stub
		logger.info("=== exportReportPageHeader ==== ");
	
         XSSFWorkbook wb = new XSSFWorkbook();
       
		try {
			
			SimpleDateFormat DateFor = new SimpleDateFormat("YY");
			Date date = new Date();
			String stringDate= DateFor.format(date);
			
			String productCodeStr ="";
			
			Cell cell;
			//SET HEADER
			CellStyle headerStyle = wb.createCellStyle();
			headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
			headerStyle.setFillPattern(FillPatternType.SQUARES);

			CellStyle headerStyleRed = wb.createCellStyle();
			headerStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
			headerStyle.setFillPattern(FillPatternType.SQUARES);
			
			XSSFFont font = ((XSSFWorkbook) wb).createFont();
			font.setFontName("Tahoma");
			font.setFontHeightInPoints((short) 8);
			font.setBold(false);
			
			
			XSSFFont fontHeader = ((XSSFWorkbook) wb).createFont();
			font.setFontName("Tahoma");
			font.setFontHeightInPoints((short) 9);
			font.setBold(true);
			headerStyle.setFont(fontHeader);
			
			XSSFFont fontDetail = ((XSSFWorkbook) wb).createFont();
			fontDetail.setFontName("Tahoma");
			fontDetail.setFontHeightInPoints((short) 8);
			fontDetail.setBold(false);
			headerStyle.setFont(fontDetail);
			
			XSSFFont fontRed = ((XSSFWorkbook) wb).createFont();
			fontRed.setFontName("Tahoma");
			fontRed.setFontHeightInPoints((short) 8);
			fontRed.setBold(false);
			fontRed.setColor((short) 8);
			headerStyleRed.setFont(fontRed);
			
			CellStyle styleRed;
			styleRed = wb.createCellStyle();
			styleRed.setWrapText(true);
			styleRed.setAlignment(HorizontalAlignment.CENTER);
			styleRed.setBorderRight(BorderStyle.THIN);
			styleRed.setRightBorderColor(IndexedColors.BLACK.getIndex());
			styleRed.setBorderLeft(BorderStyle.THIN);
			styleRed.setLeftBorderColor(IndexedColors.BLACK.getIndex());
			styleRed.setBorderTop(BorderStyle.THIN);
			styleRed.setTopBorderColor(IndexedColors.BLACK.getIndex());
			styleRed.setBorderBottom(BorderStyle.THIN);
			styleRed.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			styleRed.setVerticalAlignment(VerticalAlignment.CENTER);
			styleRed.setFont(fontRed);

			//CELL STYLE
			CellStyle style;
			style = wb.createCellStyle();
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
			style.setFont(fontDetail);
			//List<Map<String, Object>> productNamList = reportLTRDao.getProductNameByLabCode(labCode);
			List<Map<String, Object>> productNamListSheet = reportLTRDao.getProductNameByLabCodeSheet(labCode);
			List<Map<String, Object>> resultListData = reportLTRDao.getDataInfoByLabCode(labCode);
			List<Map<String, Object>> resultListDataDetail = reportLTRDao.getDataDetailInLabCode(labCode);
			System.out.println(resultListDataDetail);
			Sheet sheet =null;
			
			for (Map<String, Object> mapProductName : productNamListSheet) {
			if("100000031".equals(mapProductName.get("PRODUCT_ID").toString())) {
				 sheet = wb.createSheet("RESULT RECORDS - ADDITIVE ( RAW MATERIAL )");
			}else {
				 sheet = wb.createSheet(mapProductName.get("PRODUCT_NAME").toString());
			}
			
			List<Map<String, Object>> dataListLTR = reportLTRDao.getDataForLTRReportHeaderExcel(labCode);
			
			sheet.addMergedRegion(CellRangeAddress.valueOf("A1:J1"));	
			//sheet.addMergedRegion(CellRangeAddress.valueOf("B3:J3"));		
			Row header = sheet.createRow(1);
		
//			Cell headerCell = header.createCell(0);
//			headerCell.setCellStyle(headerStyle);
//			headerCell.setCellStyle(style);
//			headerCell.setCellValue("Test by.");
//			headerCell = header.createCell(1);
//			headerCell.setCellStyle(headerStyle);
//			headerCell.setCellStyle(style);
//			headerCell.setCellValue("KNL/ANS");
//			headerCell = header.createCell(2);
//			RegionUtil.setBorderBottom(1, CellRangeAddress.valueOf("B3:J3"), sheet);
//			RegionUtil.setBorderTop(1, CellRangeAddress.valueOf("B3:J3"), sheet);
//			RegionUtil.setBorderLeft(1, CellRangeAddress.valueOf("B3:J3"), sheet);
//			RegionUtil.setBorderRight(1, CellRangeAddress.valueOf("B3:J3"), sheet);

			Integer firstCol = 10;
			Integer lastCol = firstCol + dataListLTR.size() +1;
			Cell headerCell24 = header.createCell(10);
		    sheet.addMergedRegion(new CellRangeAddress(2,2,firstCol,lastCol));
//			headerCell24.setCellValue("SD");
//			headerCell24.setCellStyle(headerStyle);
//			headerCell24.setCellStyle(style);
//			RegionUtil.setBorderBottom(1,new CellRangeAddress(2,2,firstCol,lastCol), sheet);
//			RegionUtil.setBorderTop(1, new CellRangeAddress(2,2,firstCol,lastCol), sheet);
//			RegionUtil.setBorderLeft(1, new CellRangeAddress(2,2,firstCol,lastCol), sheet);
//			RegionUtil.setBorderRight(1,new CellRangeAddress(2,2,firstCol,lastCol), sheet);
//		



			CellStyle styleVertical;
			styleVertical = wb.createCellStyle();
			styleVertical.setWrapText(true);
			styleVertical.setRotation((short) 90);
			styleVertical.setAlignment(HorizontalAlignment.CENTER);
			styleVertical.setBorderRight(BorderStyle.THIN);
			styleVertical.setRightBorderColor(IndexedColors.BLACK.getIndex());
			styleVertical.setBorderLeft(BorderStyle.THIN);
			styleVertical.setLeftBorderColor(IndexedColors.BLACK.getIndex());
			styleVertical.setBorderTop(BorderStyle.THIN);
			styleVertical.setTopBorderColor(IndexedColors.BLACK.getIndex());
			styleVertical.setBorderBottom(BorderStyle.THIN);
			styleVertical.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			styleVertical.setVerticalAlignment(VerticalAlignment.CENTER);

			XSSFFont fontNotBold = ((XSSFWorkbook) wb).createFont();
			fontNotBold.setFontName("Tahoma");
			fontNotBold.setFontHeightInPoints((short) 9);
			fontNotBold.setBold(false);
			styleVertical.setFont(fontNotBold);






			Row row3 = sheet.createRow(3);
			row3.setHeight((short) 1000);

			Cell headerRow2Cell0 = row3.createCell(0);
			headerRow2Cell0.setCellStyle(headerStyle);
			headerRow2Cell0.setCellStyle(style);
			headerRow2Cell0.setCellValue("Lab. Code");


			Cell headerRow2Cell1 = row3.createCell(1);
			headerRow2Cell1.setCellStyle(headerStyle);
			headerRow2Cell1.setCellStyle(style);
			headerRow2Cell1.setCellValue("Req No.");

			Cell headerRow2Cell2 = row3.createCell(2);
			headerRow2Cell2.setCellStyle(headerStyle);
			headerRow2Cell2.setCellStyle(style);
			headerRow2Cell2.setCellValue("Referance");


			Cell headerRow2Cell3 = row3.createCell(3);
			headerRow2Cell3.setCellStyle(headerStyle);
			headerRow2Cell3.setCellStyle(style);
			headerRow2Cell3.setCellValue("Sampling Date");

			Cell headerRow2Cell4 = row3.createCell(4);
			headerRow2Cell4.setCellStyle(headerStyle);
			headerRow2Cell4.setCellStyle(style);
			headerRow2Cell4.setCellValue("Receive Date");

			Cell headerRow2Cell5 = row3.createCell(5);
			headerRow2Cell5.setCellStyle(headerStyle);
			headerRow2Cell5.setCellStyle(style);
			headerRow2Cell5.setCellValue("Product");

			Cell headerRow2Cell6 = row3.createCell(6);
			headerRow2Cell6.setCellStyle(headerStyle);
			headerRow2Cell6.setCellStyle(style);
			headerRow2Cell6.setCellValue("Vessel");


			Cell headerRow2Cell8 = row3.createCell(7);
			headerRow2Cell8.setCellStyle(headerStyle);
			headerRow2Cell8.setCellStyle(style);
			headerRow2Cell8.setCellValue("Report Date");

			Cell headerRow2Cell9 = row3.createCell(8);
			headerRow2Cell9.setCellStyle(headerStyle);
			headerRow2Cell9.setCellStyle(style);
			headerRow2Cell9.setCellValue("Report No.");

			Cell headerRow2Cell10 = row3.createCell(9);
			headerRow2Cell10.setCellStyle(headerStyle);
			headerRow2Cell10.setCellStyle(style);
			headerRow2Cell10.setCellValue("To");


		
//			logger.info("dataListLTR  :{}",dataListLTR.size());
//			Integer celmerge = dataListLTR.size() +11;
//		    sheet.addMergedRegion(new CellRangeAddress(0,0,0,celmerge));  
//			sheet.addMergedRegion(CellRangeAddress.valueOf("A1:AE1"));
		    
			Row rowH = sheet.createRow(0);
			Cell cellTitle = rowH.createCell(0);
			
			cellTitle.setCellValue("RESULT  " +mapProductName.get("PRODUCT_NAME").toString());
			cellTitle.setCellStyle(headerStyle);
			cellTitle.setCellStyle(style);
//			RegionUtil.setBorderBottom(1,new CellRangeAddress(0,0,0,celmerge), sheet);
//			RegionUtil.setBorderTop(1, new CellRangeAddress(0,0,0,celmerge), sheet);
//			RegionUtil.setBorderLeft(1, new CellRangeAddress(0,0,0,celmerge), sheet);
//			RegionUtil.setBorderRight(1,new CellRangeAddress(0,0,0,celmerge), sheet);
			
			
		   
			
			
			int cellInt = 10;
			Map<String, Object> headerSpec = new HashMap<>();
			//Map<String, Object> headerSpecProduct = new HashMap<>();
			int countRemarkAppove = 0;
			for (int i = 0; i < dataListLTR.size(); i++) {	
				headerSpec = dataListLTR.get(i);
				if(headerSpec.get("PRODUCT_ID").toString().equals(mapProductName.get("PRODUCT_ID").toString())) {
					//System.out.println(headerSpec.get("ITEM_NAME").toString());
					Cell headerCellSpec = row3.createCell(cellInt++);
					headerCellSpec.setCellStyle(styleVertical);
					headerCellSpec.setCellValue(headerSpec.get("ITEM_NAME").toString());
					countRemarkAppove += 1;
				}				
//				for(int j=0;j<productNamList.size() ;j++) {
//					headerSpec = dataListLTR.get(i);
//					headerSpecProduct = productNamList.get(j);
//					if(headerSpec.get("LAB_CODE").toString().equals(headerSpecProduct.get("LAB_CODE").toString())) {
//						Cell headerCellSpec = row3.createCell(cellInt++);
//						headerCellSpec.setCellStyle(styleVertical);
//						headerCellSpec.setCellValue(headerSpec.get("ITEM_NAME").toString());
//					}
//				}
			}
			
			int cellApproveAndRemark = dataListLTR.size() +11;

			Cell headerRow2CellRemark = row3.createCell(cellInt++);
			headerRow2CellRemark.setCellStyle(styleVertical);
			headerRow2CellRemark.setCellValue("Remark");

			Cell headerRow2CellApproveBy = row3.createCell(cellInt++);
			headerRow2CellApproveBy.setCellStyle(styleVertical);
			headerRow2CellApproveBy.setCellValue("Approve By");
			
			Cell headerRow2CellRootcause = row3.createCell(cellInt);
			headerRow2CellRootcause.setCellStyle(styleVertical);
			headerRow2CellRootcause.setCellValue("Rootcause");
			int rowDetail = 4;
			int cellDetailNo = 0;
		
			
			
			
			
			
			
			int sequent = 1;
				Row rowData = sheet.createRow(rowDetail);
				rowData.setHeight((short) 450);
			for (int i = 0; i < labCode.length; i++) {
				for (Map<String, Object> m : resultListData) {
					if(mapProductName.get("PRODUCT_ID").toString().equals(m.get("PRODUCT_ID").toString())){
					if (labCode[i].equalsIgnoreCase(m.get("LAB_CODE").toString())) {
						rowData = sheet.createRow(rowDetail++);
						rowData.setHeight((short) 450);
						sheet.setColumnWidth(cellDetailNo, 6000);
						Cell cellDetail = rowData.createCell(cellDetailNo++);
						cellDetail.setCellStyle(headerStyle);
						cellDetail.setCellStyle(style);
						sheet.setColumnWidth(cellDetailNo, 4000);
						cellDetail.setCellValue(m.get("LAB_CODE") == null ? "" : m.get("LAB_CODE").toString());
						cellDetail = rowData.createCell(cellDetailNo++);
						cellDetail.setCellStyle(headerStyle);
						cellDetail.setCellStyle(style);
						sheet.setColumnWidth(cellDetailNo, 4000);
						cellDetail.setCellValue(m.get("SEND_REQT_ID") == null ? "" : m.get("SEND_REQT_ID").toString());
						productCodeStr = m.get("PRODUCT_CODE") ==null ?"" : m.get("PRODUCT_CODE").toString().trim();
						//logger.info(" productCodeStr : {}",productCodeStr);
						if("LZ9045".equals(productCodeStr)||"HITEC6421".equals(productCodeStr)) {
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("ADTV_LOT_NO") == null ? "" : m.get("ADTV_LOT_NO").toString());
						}else if("00005".equals(m.get("SAMPLE_TYPE").toString()) || "00007".equals(m.get("SAMPLE_TYPE").toString())) {
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("RETURNR_DESC") == null ? "" : m.get("RETURNR_DESC").toString());
						}else if("00004".equals(m.get("SAMPLE_TYPE").toString())) {
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("SAMPLE_TYPEC_DESC") == null ? "" : m.get("SAMPLE_TYPEC_DESC").toString());
						}else if("00002".equals(m.get("SAMPLE_TYPE").toString())||"00008".equals(m.get("SAMPLE_TYPE").toString())||"00009".equals(m.get("SAMPLE_TYPE").toString())) {
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("BOAT_NO") == null ? "" : m.get("BOAT_NO").toString());
						}else if("00003".equals(m.get("SAMPLE_TYPE").toString())) {
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("METER_NO") == null ? "" : m.get("METER_NO").toString());
						}else if("00001".equals(m.get("SAMPLE_TYPE").toString())||"00010".equals(m.get("SAMPLE_TYPE").toString())) {
							if("100000041".equals(m.get("PRODUCT_ID").toString()) || "Y".equals(m.get("MANUAL_TYPE").toString())) {
								cellDetail = rowData.createCell(cellDetailNo++);
								cellDetail.setCellStyle(headerStyle);
								cellDetail.setCellStyle(style);
								sheet.setColumnWidth(cellDetailNo, 4000);
								cellDetail.setCellValue(m.get("SAMPLE_TYPEC_DESC") == null ? "" : m.get("SAMPLE_TYPEC_DESC").toString());
							}else {
								cellDetail = rowData.createCell(cellDetailNo++);
								cellDetail.setCellStyle(headerStyle);
								cellDetail.setCellStyle(style);
								sheet.setColumnWidth(cellDetailNo, 4000);
								cellDetail.setCellValue(m.get("PO_NO") == null ? "" : m.get("PO_NO").toString());
							}
								
						}else {
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("SAMPLE_TYPEC_DESC") == null ? "" : m.get("SAMPLE_TYPEC_DESC").toString());	
						}
						
						cellDetail = rowData.createCell(cellDetailNo++);
						cellDetail.setCellStyle(headerStyle);
						cellDetail.setCellStyle(style);
						sheet.setColumnWidth(cellDetailNo, 4000);
						cellDetail.setCellValue(m.get("RAN_CREATE_DATE_SAMPLE").toString() == null ? "" : m.get("RAN_CREATE_DATE_SAMPLE").toString());
						cellDetail = rowData.createCell(cellDetailNo++);
						cellDetail.setCellStyle(headerStyle);
						cellDetail.setCellStyle(style);
						sheet.setColumnWidth(cellDetailNo, 4000);
						cellDetail.setCellValue(m.get("DTS_CREATE_DATE") == null ? "" : m.get("DTS_CREATE_DATE").toString());
						
						if("LZ9045".equals(productCodeStr)||"HITEC6421".equals(productCodeStr)) {
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("PRODUCT_CODE") == null ? "" : m.get("PRODUCT_CODE").toString());
						}else {
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("PRODUCT_NAME") == null ? "-" : m.get("PRODUCT_NAME").toString());
						}
						
						if("LZ9045".equals(productCodeStr)||"HITEC6421".equals(productCodeStr)) {
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("SAMPLE_POINT_DESC") == null ? "" : m.get("SAMPLE_POINT_DESC").toString());
						}else if("00005".equals(m.get("SAMPLE_TYPE").toString()) || "00007".equals(m.get("SAMPLE_TYPE").toString())) {
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("SAMPLE_POINT_DESC") == null ? "" : m.get("SAMPLE_POINT_DESC").toString());
						}else if("00004".equals(m.get("SAMPLE_TYPE").toString())) {
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("TANK_NO") == null ? "" : m.get("TANK_NO").toString());
						}else if("00001".equals(m.get("SAMPLE_TYPE").toString()) || "00003".equals(m.get("SAMPLE_TYPE").toString())|| "00010".equals(m.get("SAMPLE_TYPE").toString())) {
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							String cellValC_Truck = m.get("CAR_NO") == null ? "" : m.get("CAR_NO").toString();
							cellValC_Truck += m.get("CAR_SLOT") == null ? "" : "/".concat(m.get("CAR_SLOT").toString());
							cellDetail.setCellValue(cellValC_Truck);
						}else if("00002".equals(m.get("SAMPLE_TYPE").toString())||"00008".equals(m.get("SAMPLE_TYPE").toString())||"00009".equals(m.get("SAMPLE_TYPE").toString())) {
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("BOAT_NAME") == null ? "" : m.get("BOAT_NAME").toString());
						}else {
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("TANK_NO") == null ? "-" : m.get("TANK_NO").toString());
						}
				
						cellDetail = rowData.createCell(cellDetailNo++);
						cellDetail.setCellStyle(headerStyle);
						cellDetail.setCellStyle(style);
						sheet.setColumnWidth(cellDetailNo, 4000);

						cellDetail.setCellValue(m.get("REPORT_DATE_LTR").toString() == null ? "" : m.get("REPORT_DATE_LTR").toString());
						cellDetail = rowData.createCell(cellDetailNo++);
						cellDetail.setCellStyle(headerStyle);
						cellDetail.setCellStyle(style);
						sheet.setColumnWidth(cellDetailNo, 4000);
						cellDetail.setCellValue(m.get("report_no").toString() == null ? "" : m.get("report_no").toString());
						cellDetail = rowData.createCell(cellDetailNo++);
						cellDetail.setCellStyle(headerStyle);
						cellDetail.setCellStyle(style);
						sheet.setColumnWidth(cellDetailNo, 4000);
						cellDetail.setCellValue(m.get("PLANT_NAME").toString() == null ? "" : m.get("PLANT_NAME").toString());
					}
				}

				}
				
				for (Map<String, Object> m : resultListDataDetail) {
					//countRemarkAppove = 0;
					if (mapProductName.get("PRODUCT_ID").toString().equals(m.get("PRODUCT_ID").toString())) {
						if (labCode[i].equalsIgnoreCase(m.get("LAB_CODE").toString())) {
							
								for (Map<String, Object> mapDetail : dataListLTR) {
									sheet.setColumnWidth(cellDetailNo, 2500);
									//logger.info("check item name :{},{}",mapDetail.get("ITEM_NAME").toString(),m.get("ITEM_NAME").toString());
									
									if (mapDetail.get("ITEM_ID").toString().equals(m.get("ITEM_ID").toString()) 
											&& mapDetail.get("PRODUCT_ID").toString().equals(m.get("PRODUCT_ID").toString())) {
										
										if("Y".equals(m.get("STATUS_FLAG").toString())) {
											Cell cellDetail = rowData.createCell(cellDetailNo++);
											cellDetail.setCellStyle(style);
											checkDataExcel(cellDetail,m,"");
										}else if("U".equals(m.get("STATUS_FLAG").toString())){
											Cell cellDetail = rowData.createCell(cellDetailNo++);
											cellDetail.setCellStyle(style);
											checkDataExcel(cellDetail,m,"");
										}else {
											Cell cellDetail = rowData.createCell(cellDetailNo++);
											cellDetail.setCellStyle(styleRed);
											checkDataExcel(cellDetail,m,"*");
										
										}
											
									}else {
										
									}
								}

							}
						}
				}

				cellDetailNo = 0;
			}
			//get Approve By
			List<Map<String, Object>> listApproveBy = reportLTRDao.getApproveByAndRemark(labCode);
			//logger.info("listApproveBy : {}",listApproveBy.size());
			// write data ApproveBy and Remark 
			int rowDetailApproveBy = 4;
		
			logger.info("size countRemarkAppove : {}",countRemarkAppove);
			for (int i = 0; i < labCode.length; i++) {
				for(Map<String,Object> m : listApproveBy) {
//					logger.info("labCode[i] : {}",labCode[i]);
//					logger.info("m.get(\"LAB_CODE\") : {}",m.get("LAB_CODE").toString());
//					logger.info("mapProductName.get(\"PRODUCT_ID\") :{}",mapProductName.get("PRODUCT_ID").toString());
					//logger.info("m.get(\"PRODUCT_ID\").toString() :{}",m.get("PRODUCT_ID").toString());
					if(mapProductName.get("PRODUCT_ID").toString().equals(m.get("PRODUCT_ID").toString())){
//					logger.info("mapProductName.get(\"PRODUCT_ID\") :{}",mapProductName.get("PRODUCT_ID").toString());
//					logger.info("m.get(\"PRODUCT_ID\").toString() :{}",m.get("PRODUCT_ID").toString());
						if (labCode[i].equalsIgnoreCase(m.get("LAB_CODE").toString())) {
							//logger.info("===========================================");
							Integer cellApproveIndex = countRemarkAppove+10;
							//logger.info("row Detail :{}",rowDetailApproveBy);
							Row rowApprove = sheet.getRow(rowDetailApproveBy);
							//logger.info("rowApprove : {}",rowApprove);
							Cell cellApprove = rowApprove.createCell(cellApproveIndex++);
							if("00003".equals(m.get("SAMPLE_TYPE").toString())) {
								if("ผ่านแบบมีเงื่อนไข".equals(m.get("RESULT_FLAG").toString())) {
									cellApprove.setCellValue("ผ่าน");
								}else {
									cellApprove.setCellValue(m.get("RESULT_FLAG").toString());	
								}
								
							}else {
								cellApprove.setCellValue(m.get("RESULT_FLAG").toString());
							}
							
							cellApprove.setCellStyle(style);
							
							Row rowRemark = sheet.getRow(rowDetailApproveBy);
							Cell cellRemark  = rowRemark.createCell(cellApproveIndex++);
							cellRemark.setCellValue(m.get("APPROVE_BY").toString());
							cellRemark.setCellStyle(style);
							
							Row rowRootcause = sheet.getRow(rowDetailApproveBy);
							Cell cellrootcause  = rowRootcause.createCell(cellApproveIndex);
							cellrootcause.setCellValue(m.get("RTDESC")==null?"":m.get("RTDESC").toString());
							cellrootcause.setCellStyle(style);
							
							rowDetailApproveBy ++;
						
						}
					}
				}
			}
		}
			return wb;
		}catch(Exception e){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}

	public void checkDataExcel(Cell cellDetail,Map<String, Object> m,String strCheck) {
		if("-".equals(m.get("RESULT_TEST")==null?"":m.get("RESULT_TEST").toString())) {
			cellDetail.setCellValue("-");
		}else {
			if("0004".equals(m.get("ITEM_ID").toString())) {
				String resultNum = String.format("%.1f", Double.parseDouble(m.get("RESULT_TEST").toString() ==null ? "0" : m.get("RESULT_TEST").toString()));
				cellDetail.setCellValue(resultNum.concat(strCheck));
			}else if("0005".equals(m.get("ITEM_ID").toString())||"0006".equals(m.get("ITEM_ID").toString())||"0007".equals(m.get("ITEM_ID").toString())||"0008".equals(m.get("ITEM_ID").toString())||"0009".equals(m.get("ITEM_ID").toString())) {
				String resultNum = String.format("%.1f", Double.parseDouble(m.get("RESULT_TEST").toString() ==null ? "0" : m.get("RESULT_TEST").toString()));
				cellDetail.setCellValue(resultNum.concat(strCheck));
			}else if("0010".equals(m.get("ITEM_ID").toString())) {
				String str = m.get("RESULT_TEST").toString() ==null ? "0" : m.get("RESULT_TEST").toString();
				if(str != null && str.matches("[0-9.]+")) {
					String resultNum = String.format("%.1f", Double.parseDouble(str));
					cellDetail.setCellValue(resultNum.concat(strCheck));
				}else {
					cellDetail.setCellValue(str.concat(strCheck));	
				}		
			}else if("0021".equals(m.get("ITEM_ID").toString())) {
				if(m.get("METHOD_ID").toString().equals("0018")) {
					if("-".equals(m.get("RESULT_TEST").toString())) {
						cellDetail.setCellValue("-");
					}else {
						String resultNum = String.format("%.0f", Double.parseDouble(m.get("RESULT_TEST").toString() ==null ? "0" : m.get("RESULT_TEST").toString()));
						cellDetail.setCellValue(resultNum.concat(strCheck));
					}
				}else {
					if("-".equals(m.get("RESULT_TEST").toString())) {
						cellDetail.setCellValue("-");
					}else {
						String resultNum = String.format("%.1f", Double.parseDouble(m.get("RESULT_TEST").toString() ==null ? "0" : m.get("RESULT_TEST").toString()));
						cellDetail.setCellValue(resultNum.concat(strCheck));
					}
				}
			}else if("0016".equals(m.get("ITEM_ID").toString())) {
				double val = Double.parseDouble(m.get("RESULT_TEST").toString());
				int resultNum = (int) Math.floor(val);   
				cellDetail.setCellValue(String.valueOf(resultNum).concat(strCheck));
			}else if("0017".equals(m.get("ITEM_ID").toString())) {
				if("-".equals(m.get("RESULT_TEST").toString())) {
					cellDetail.setCellValue("-");
				}else {
					String resultNum = String.format("%.3f", Double.parseDouble(m.get("RESULT_TEST").toString() ==null ? "0" : m.get("RESULT_TEST").toString()));
					cellDetail.setCellValue(resultNum.concat(strCheck));
				}
			}
			else if("0011".equals(m.get("ITEM_ID").toString())) {
				if("-".equals(m.get("RESULT_TEST").toString())) {
					cellDetail.setCellValue("-");
				}else {
					String resultNum = String.format("%.1f", Double.parseDouble(m.get("RESULT_TEST").toString() ==null ? "0" : m.get("RESULT_TEST").toString()));
					cellDetail.setCellValue(resultNum.concat(strCheck));
				}
			}else if("0018".equals(m.get("ITEM_ID").toString())) {
				if("-".equals(m.get("RESULT_TEST").toString())) {
					cellDetail.setCellValue("-");
				}else {
					String resultNum = String.format("%.1f", Double.parseDouble(m.get("RESULT_TEST").toString() ==null ? "0" : m.get("RESULT_TEST").toString()));
					cellDetail.setCellValue(resultNum.concat(strCheck));
				}
			}else if("0022".equals(m.get("ITEM_ID").toString())) {
				String str = m.get("RESULT_TEST").toString() ==null ? "0" : m.get("RESULT_TEST").toString();
				if(str != null && str.matches("[0-9.]+")) {
					String resultNum = String.format("%.0f", Double.parseDouble(str));
					cellDetail.setCellValue(resultNum);
				}else {
					cellDetail.setCellValue(str);
				}
			}else if("0023".equals(m.get("ITEM_ID").toString())) {
				String resultNum = String.format("%.4f", Double.parseDouble(m.get("RESULT_TEST").toString() ==null ? "0" : m.get("RESULT_TEST").toString()));
				cellDetail.setCellValue(resultNum.concat(strCheck));
			}else if("0019".equals(m.get("ITEM_ID").toString())) {
				if("-".equals(m.get("RESULT_TEST").toString())) {
					cellDetail.setCellValue("-");
				}else {
					String resultNum = String.format("%.1f", Double.parseDouble(m.get("RESULT_TEST").toString() ==null ? "0" : m.get("RESULT_TEST").toString()));
					cellDetail.setCellValue(resultNum.concat(strCheck));	
				}
			
			}else if("0013".equals(m.get("ITEM_ID").toString())) {
				if("-".equals(m.get("RESULT_TEST").toString())) {
					cellDetail.setCellValue("-");
				}else {
					String resultNum = String.format("%.3f", Double.parseDouble(m.get("RESULT_TEST").toString() ==null ? "0" : m.get("RESULT_TEST").toString()));
					cellDetail.setCellValue(resultNum.concat(strCheck));	
				}
			
			}else {
				cellDetail.setCellValue(m.get("RESULT_TEST")==null?"":m.get("RESULT_TEST").toString().concat(strCheck));
			}
		}
	}
	
	public void checkDataExcelTools(Cell cellDetail,Map<String, Object> m) {
		if("-".equals(m.get("TOOL_NAME")==null?"":m.get("TOOL_NAME").toString())) {
			cellDetail.setCellValue("-");
		}else {
				cellDetail.setCellValue(m.get("TOOL_NAME").toString());
		}
	}
	@Override
	public List<Map<String,Object>> getDataReportLTR(String startDate, String endDate, String []productType, String []sampleTypeCode,String plantID,String typeReportSearch,String result) {
		// TODO Auto-generated method stub
		
		try{
			return reportLTRDao.getDataReportLTR(startDate,endDate,productType,sampleTypeCode,plantID,typeReportSearch,result);
		}catch(Exception  e){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	
	}
	
	public String pad(Integer num) {
	    String s = num.toString();
	    while (s.length() < 5) s = "0" + s;
	    return s;
	}

	@Override
	public String findLicen(String string) {
	
		String path ="";
		try{
			path = reportLTRDao.findLicen(string);
			
		}catch(Exception  e){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
		return path;
	}

	@Override
	public Workbook exportReportCancel(String year, String month, String plant) {
				logger.info("=== exportReportCancel ==== ");
		         XSSFWorkbook wb = new XSSFWorkbook();
		       int yearThai =0;
				try {
					
					//SET HEADER
					CellStyle headerStyle = wb.createCellStyle();
					headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
					headerStyle.setFillPattern(FillPatternType.SQUARES);

					
					XSSFFont font = ((XSSFWorkbook) wb).createFont();
					font.setFontName("Tahoma");
					font.setFontHeightInPoints((short) 8);
					font.setBold(false);
					
					
					XSSFFont fontHeader = ((XSSFWorkbook) wb).createFont();
					font.setFontName("Tahoma");
					font.setFontHeightInPoints((short) 5);
					font.setBold(true);
					headerStyle.setFont(fontHeader);
					
					XSSFFont fontDetail = ((XSSFWorkbook) wb).createFont();
					fontDetail.setFontName("Tahoma");
					fontDetail.setFontHeightInPoints((short) 8);
					fontDetail.setBold(false);
					headerStyle.setFont(fontDetail);
					

					//CELL STYLE
					CellStyle style;
					style = wb.createCellStyle();
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
					style.setFont(fontDetail);
					//List<Map<String, Object>> productNamList = reportLTRDao.getProductNameByLabCode(labCode);
					List<Map<String, Object>> cancelreportSheet = reportLTRDao.getCancelDataReport(year,month,plant,"");
					Sheet sheet =null;
					
		
	
				    sheet = wb.createSheet("CancelReport"+month+""+year);
					
					
					sheet.addMergedRegion(CellRangeAddress.valueOf("A2:I2"));	
					//sheet.addMergedRegion(CellRangeAddress.valueOf("B3:J3"));		
					//Row header = sheet.createRow(1);	

					CellStyle styleVertical;
					styleVertical = wb.createCellStyle();
					styleVertical.setWrapText(true);
					styleVertical.setRotation((short) 90);
					styleVertical.setAlignment(HorizontalAlignment.CENTER);
					styleVertical.setBorderRight(BorderStyle.THIN);
					styleVertical.setRightBorderColor(IndexedColors.BLACK.getIndex());
					styleVertical.setBorderLeft(BorderStyle.THIN);
					styleVertical.setLeftBorderColor(IndexedColors.BLACK.getIndex());
					styleVertical.setBorderTop(BorderStyle.THIN);
					styleVertical.setTopBorderColor(IndexedColors.BLACK.getIndex());
					styleVertical.setBorderBottom(BorderStyle.THIN);
					styleVertical.setBottomBorderColor(IndexedColors.BLACK.getIndex());
					styleVertical.setVerticalAlignment(VerticalAlignment.CENTER);

					XSSFFont fontNotBold = ((XSSFWorkbook) wb).createFont();
					fontNotBold.setFontName("Tahoma");
					fontNotBold.setFontHeightInPoints((short) 9);
					fontNotBold.setBold(false);
					styleVertical.setFont(fontNotBold);






					Row row3 = sheet.createRow(3);
					row3.setHeight((short) 1000);

					Cell headerRow2Cell0 = row3.createCell(0);
					headerRow2Cell0.setCellStyle(headerStyle);
					headerRow2Cell0.setCellStyle(style);
					headerRow2Cell0.setCellValue("Lab Code");


					Cell headerRow2Cell1 = row3.createCell(1);
					headerRow2Cell1.setCellStyle(headerStyle);
					headerRow2Cell1.setCellStyle(style);
					headerRow2Cell1.setCellValue("PRODUCT NAME");

					Cell headerRow2Cell2 = row3.createCell(2);
					headerRow2Cell2.setCellStyle(headerStyle);
					headerRow2Cell2.setCellStyle(style);
					headerRow2Cell2.setCellValue("LOGIS NAME");


					Cell headerRow2Cell3 = row3.createCell(3);
					headerRow2Cell3.setCellStyle(headerStyle);
					headerRow2Cell3.setCellStyle(style);
					headerRow2Cell3.setCellValue("SOURCE NAME");

					Cell headerRow2Cell4 = row3.createCell(4);
					headerRow2Cell4.setCellStyle(headerStyle);
					headerRow2Cell4.setCellStyle(style);
					headerRow2Cell4.setCellValue("PO DATE");

					Cell headerRow2Cell5 = row3.createCell(5);
					headerRow2Cell5.setCellStyle(headerStyle);
					headerRow2Cell5.setCellStyle(style);
					headerRow2Cell5.setCellValue("CAR NO");

					Cell headerRow2Cell6 = row3.createCell(6);
					headerRow2Cell6.setCellStyle(headerStyle);
					headerRow2Cell6.setCellStyle(style);
					headerRow2Cell6.setCellValue("CAR SLOT");


					Cell headerRow2Cell8 = row3.createCell(7);
					headerRow2Cell8.setCellStyle(headerStyle);
					headerRow2Cell8.setCellStyle(style);
					headerRow2Cell8.setCellValue("PLANT NAME");

					Cell headerRow2Cell9 = row3.createCell(8);
					headerRow2Cell9.setCellStyle(headerStyle);
					headerRow2Cell9.setCellStyle(style);
					headerRow2Cell9.setCellValue("CANCEL DESC");

					CellStyle Topstyle = wb.createCellStyle();
					//CellStyle fontTop = wb.createCellStyle();
					Font fontTop = wb.createFont();  
					//XSSFFont fontTop = ((XSSFWorkbook) wb).createFont();
					fontTop.setFontName("Tahoma");
					fontTop.setFontHeightInPoints((short) 16);
					fontTop.setBold(true);
					
					Topstyle.setFont(fontTop);
					Topstyle.setAlignment(CellStyle.ALIGN_CENTER);
					Row rowH = sheet.createRow(1);
					Cell cellTitle = rowH.createCell(0);
					yearThai=Integer.parseInt(year)+543;
					cellTitle.setCellValue("รายงานตัวอย่าง CANCEL ประจำเดือน "+getThaiMonth(month)+" ปี "+yearThai);
					cellTitle.setCellStyle(Topstyle);
					//cellTitle.setCellStyle(style);
					int rowDetail = 4;
					int cellDetailNo = 0;
					Row rowData = sheet.createRow(rowDetail);
					rowData.setHeight((short) 450);
					for (Map<String, Object> m : cancelreportSheet) {
							rowData = sheet.createRow(rowDetail++);
							rowData.setHeight((short) 450);
							sheet.setColumnWidth(cellDetailNo, 6000);
							
							Cell cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("LAB_CODE") == null ? "" : m.get("LAB_CODE").toString());
							
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("PRODUCT_NAME") == null ? "" : m.get("PRODUCT_NAME").toString());
							
							
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("LOGIS_NAME") == null ? "" : m.get("LOGIS_NAME").toString());
							
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("SOURCE_NAME") == null ? "" : m.get("SOURCE_NAME").toString());							
					
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("PO_DATE") == null ? "" : m.get("PO_DATE").toString());
							
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("CAR_NO") == null ? "" : m.get("CAR_NO").toString());
							
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("CAR_SLOT")== null ? "" : m.get("CAR_SLOT").toString());
						
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("PLANT_NAME") == null ? "" : m.get("PLANT_NAME").toString());
							
							cellDetail = rowData.createCell(cellDetailNo++);
							cellDetail.setCellStyle(headerStyle);
							cellDetail.setCellStyle(style);
							sheet.setColumnWidth(cellDetailNo, 4000);
							cellDetail.setCellValue(m.get("CANCEL_DESC") == null ? "" : m.get("CANCEL_DESC").toString());
							
							cellDetailNo = 0;

					}
				
					return wb;
				}catch(Exception e){
					logger.error("Exception : {}",e);
					throw new RuntimeException(e.getMessage());
				}
	}
	
	public static String getThaiMonth(String numOfMonth) {
		if("01".equals(numOfMonth)) {
			return "มกราคม";
					
		}else if("02".equals(numOfMonth)) {
			return "กุมภาพันธ์";
					
		}else if("03".equals(numOfMonth)) {
			return "มีนาคม";
					
		}else if("04".equals(numOfMonth)) {
			return "เมษายน";
					
		}else if("05".equals(numOfMonth)) {
			return "พฤษภาคม";
					
		}else if("06".equals(numOfMonth)) {
			return "มิถุนายน";
					
		}else if("07".equals(numOfMonth)) {
			return "กรกฎาคม";
					
		}else if("08".equals(numOfMonth)) {
			return "สิงหาคม";
					
		}else if("09".equals(numOfMonth)) {
			return "กันยายน";
					
		}else if("10".equals(numOfMonth)) {
			return "ตุลาคม";
					
		}else if("11".equals(numOfMonth)) {
			return "พฤศจิกายน";
					
		}else if("12".equals(numOfMonth)) {
			return "ธันวาคม";
					
		}
		return "";
	}
	

	
	public String SendMail(SendMailWFObj sen) {
		String result = "";
		String uri = "https://asv-it-bot03-uat.azurewebsites.net/sendmail";
		System.out.println(uri+"|URL");
		System.out.println(sen.getEmailFrom()+"|From");
		System.out.println(sen.getEmailTo()+"|TO");
		System.out.println("Test Sub Mail|SUB");
		System.out.println("TEST MSG|MSG");
		System.out.println(sen.getTokenMail()+"|TOKEN");
		System.out.println(sen.getTimeEmal()+"|TIME");
		System.out.println("PTG01|SRC");
				
		String msgDetail = "<h4 >เรียน "+sen.getNameTo()+"</h4>\r\n" + 
				"<h5 >&nbsp;&nbsp;&nbsp;&nbsp;มีรายการอนุมัติ LTR<br>\r\n" + 
				"  &nbsp;&nbsp;&nbsp;&nbsp;เลข LTR : "+sen.getLtr_code()+"<br>\r\n" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;ประเภทตัวอย่าง : "+sen.getSampleTypeName()+"<br>\r\n" + 
				"&nbsp;&nbsp;&nbsp;&nbsp;ผลิตภัณฑ์ : "+sen.getProductName()+"<br>\r\n" + 
				"  &nbsp;&nbsp;&nbsp;&nbsp;click link <a href="+sen.getUrl_wf()+">"+sen.getUrl_wf()+"</a></h5>\r\n" + 
				"<br><h5>Best Regards<br>Lab Analysis.</h5>";
		
		sen.setMsgMail(msgDetail);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		Map<String, Object> map = new HashMap<>();
		map.put("FROM", sen.getEmailFrom());
		map.put("TO", sen.getEmailTo());
		map.put("SUB", "Approve MainLab");
		map.put("MSG", sen.getMsgMail());
		map.put("TOKEN",sen.getTokenMail());
		map.put("TIME", sen.getTimeEmal());
		map.put("SRC", "PTG01");
		
		System.out.println(map+"|"+headers);
		// build the request
		HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

		// send POST request
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity(uri, entity, String.class);
		
		/*
		if (response.getStatusCode() == HttpStatus.CREATED) {
		    System.out.println("Request Successful");
		    System.out.println(response.getBody());
		} else {
		    System.out.println("Request Failed");
		    System.out.println(response.getStatusCode());
		}
		*/
		return result;
	}

	@Override
	public List<Map<String, String>> getRoleAdmin(String role_id) {
		List<Map<String,String>> obj=	reportLTRDao.getRoleAdmin(role_id);
		return obj;
	}

	@Override
	public List<Map<String, Object>> exportReportCrate(String productid,String sampletype) {
		logger.info("=== exportReportCancel ==== ");
		List<Map<String, Object>> cratereportSheet=null;
		try {
			cratereportSheet = reportLTRDao.getCrateDataReport(productid,sampletype);
			return cratereportSheet;
		}catch(Exception e){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Map<String, Object>> filterDataCrate(String sampletype, List<Map<String, Object>> res) {
		List<Map<String, Object>> resdata = null;
		List<Map<String, Object>> subdata = null;
		Map<String, Object> mapsub =null;    
		Map<String, Object> map =null;   
		Map<String, Object> SampleLevel=null;
		int indexcond =0;

		mapsub= new HashMap<String, Object>();
		
		try {
			   
			resdata=new  ArrayList<>();   
			map = new HashMap<String, Object>();
			subdata = new  ArrayList<>();                               
			if("00005".equals(sampletype)||"00007".equals(sampletype)||"00004".equals(sampletype)||"00006".equals(sampletype)||"00010".equals(sampletype)) {
				for(Map<String, Object> m:res) {
					indexcond++;
					for(int k=0;k<4;k++) {
						SampleLevel = new HashMap<String, Object>();
						SampleLevel=mapSampleLevel(utilService.getDropdownGetSample(),m.get("SAMPLE_LEVEL_CODE").toString());
						if(("00001".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())
								||"00012".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())
								||"00013".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString()))&&k==0) {
							if("00012".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())
									||"00013".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())) {
								mapsub.put("num_"+indexcond+"_"+k, m.get("LAB_CODE").toString().split("-")[6]+"("+SampleLevel.get("SAMPLE_LEVEL_DESC").toString().substring(0,1)+")");
							}else {
								mapsub.put("num_"+indexcond+"_"+k, m.get("LAB_CODE").toString().split("-")[6]);
							}
							
							
						}
						if(("00004".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())
								||"00005".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())
								||"00006".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())
								||"00007".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())
								||"00008".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())
								||"00010".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())
								)&&k==1
								
								) {
							if("00008".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())
									||"00010".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())) {
								mapsub.put("num_"+indexcond+"_"+k, m.get("LAB_CODE").toString().split("-")[6]+"("+SampleLevel.get("SAMPLE_LEVEL_DESC").toString().substring(0,1)+")");
							}else {
								mapsub.put("num_"+indexcond+"_"+k, m.get("LAB_CODE").toString().split("-")[6]);
							}
							
						}
						
						if(("00003".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())
								||"00005".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())
								||"00007".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())
								||"00009".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())
								||"00011".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())
								)&&k==2
								
								) {
							if("00009".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())
									||"00011".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())) {
								mapsub.put("num_"+indexcond+"_"+k, m.get("LAB_CODE").toString().split("-")[6]+"("+SampleLevel.get("SAMPLE_LEVEL_DESC").toString().substring(0,1)+")");
							}else {
								mapsub.put("num_"+indexcond+"_"+k, m.get("LAB_CODE").toString().split("-")[6]);
							}
							
						}
						if(("00002".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())
								||"00005".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())
								||"00006".equals(SampleLevel.get("SAMPLE_LEVEL_CODE").toString())
								)&&k==3
								
								) {
								mapsub.put("num_"+indexcond+"_"+k, m.get("LAB_CODE").toString().split("-")[6]);
							
						}
						
						if(mapsub.get("num_"+indexcond+"_"+k)==null) {
							mapsub.put("num_"+indexcond+"_"+k,"");
						}
						
						
		
					}
					
					if(indexcond==10) {
						subdata.add(mapsub);
						indexcond=0;
						mapsub= new HashMap<String, Object>();
					
					}
					
				}
			}else {
				for(Map<String, Object> m:res) {
					indexcond++;
					
					mapsub.put("num"+indexcond, m.get("LAB_CODE").toString().split("-")[6]);
					
					
					if(indexcond==40) {
						subdata.add(mapsub);
						indexcond=0;
						mapsub= new HashMap<String, Object>();
						
					}
					
				}
				
			}
			if(subdata.size()==0||mapsub.size()!=0) {
				subdata.add(mapsub);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return subdata;
	}

	@Override
	public JasperPrint filterDataCrate(Map<String, Object> m,Map<String, Object> detail) {
		JasperPrint jasperPrint = null;
		Map parameters =  new HashMap();
		List<Map<String,String>> mapRole = null;
		List<Map<String,Object>>list = new ArrayList<>();
		try {
			mapRole = reportLTRService.getRoleAdmin("0007");
			parameters.put("product1", detail.get("PRODUCT_CODE").toString());
			parameters.put("product2", detail.get("PRODUCT_CODE").toString());
			parameters.put("sampletype1", detail.get("SAMPLE_TYPE_NAME").toString());
			parameters.put("sampletype2", detail.get("SAMPLE_TYPE_NAME").toString());
			parameters.put("recive1", detail.get("RECIEVE_DATE").toString());
			parameters.put("recive2", detail.get("RECIEVE_DATE").toString());
			parameters.put("reject1", detail.get("REJECT_DATE").toString());
			parameters.put("reject2", detail.get("REJECT_DATE").toString());
			parameters.put("appperson1", mapRole.get(0).get("NAMET"));
			parameters.put("appperson2", mapRole.get(0).get("NAMET"));
			;
			list.add(m);
			if("00005".equals(detail.get("SAMPLE_TYPE_CODE").toString())
					||"00007".equals(detail.get("SAMPLE_TYPE_CODE").toString())
					||"00004".equals(detail.get("SAMPLE_TYPE_CODE").toString())
					||"00006".equals(detail.get("SAMPLE_TYPE_CODE").toString())
					||"00010".equals(detail.get("SAMPLE_TYPE_CODE").toString())
					
					) {
				jasperPrint =  ReportUtils.exportReport("reportcrate_cond",parameters , new JRBeanCollectionDataSource(list));
			}else {
				jasperPrint =  ReportUtils.exportReport("reportcrate",parameters , new JRBeanCollectionDataSource(list));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return jasperPrint;
	}
	private static Map<String,Object> mapSampleLevel(List<Map<String,Object>> list,String code){
		Map<String,Object> res = null;
		try {
			res = new HashMap<String, Object>();
			for(Map<String,Object> m:list) {
				if(code.equals(m.get("SAMPLE_LEVEL_CODE").toString())) {
					res=m;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	@Override
	public String SendMailCancel(List<Map<String,String>> userTo,String userfrom,String labcode) {
		String result = "0";
		List<Map<String,Object>> list = null;
		String texthtml=null;
		try {
			list = new ArrayList<Map<String,Object>>();
			String uri = WebUtil.WebServiceUrl() + "HrisService/member-getmemberprofile";
			MemberObj dataTo = new MemberObj();	
			list=reportLTRDao.getCancelDataReport("", "", "",labcode);
			if(list.size()>0) {
			texthtml=createSendgridText(list.get(0),userfrom);
			for(Map<String,String> m:userTo) {	
				dataTo.codempid = m.get("CODEMP_ID");
				RestTemplate restTemplate = new RestTemplate();
				MemberObj member_dataTo = restTemplate.postForObject(uri,dataTo,MemberObj.class);
				String test ="zomads17@gmail.com";//member_dataTo.getEmail()
				if(null!=member_dataTo.getEmail()) {
					sendMailService.sendGridSendMail("text/html", texthtml, "",member_dataTo.getEmail(), "แจ้งรายการยกเลิกตัวอย่าง");
				}			
			}
			}
			result = "1";
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
	public String createSendgridText(Map<String,Object> m,String emp){
		
		String labcode =m.get("LAB_CODE")==null?"-":m.get("LAB_CODE").toString();
		String productname =m.get("PRODUCT_NAME")==null?"-":m.get("PRODUCT_NAME").toString();
		String logisname =m.get("LOGIS_NAME")==null?"-":m.get("LOGIS_NAME").toString();
		String sorucename =m.get("SOURCE_NAME")==null?"-":m.get("SOURCE_NAME").toString();
		String podate =m.get("PO_DATE")==null?"-":m.get("PO_DATE").toString();
		String carno =m.get("CAR_NO")==null?"-":m.get("CAR_NO").toString();
		String carslot =m.get("CAR_SLOT")==null?"-":m.get("CAR_SLOT").toString();
		String plantname =m.get("PLANT_NAME")==null?"-":m.get("PLANT_NAME").toString();
		String canceldesc =m.get("CANCEL_DESC")==null?"-":m.get("CANCEL_DESC").toString();
		
		StringBuilder sb = new StringBuilder();
		sb.append("<h3>แจ้งรายการยกเลิก</h3>");
		sb.append("<br>");
		sb.append("<table border='1' style='border-collapse:collapse;text-align: center;border-radius:3px;'>");
		sb.append("<tr><th style='padding: 5px;background-color: #1ab394;'>Lab Code</th><th style='padding: 5px;background-color: #1ab394;'>PRODUCT NAME</th><th style='padding: 5px;background-color: #1ab394;'>LOGIS NAME</th><th style='padding: 5px;background-color: #1ab394;'>SOURCE NAME</th><th style='padding: 5px;background-color: #1ab394;'>PO DATE</th><th style='padding: 5px;background-color: #1ab394;'>CAR NO</th><th style='padding: 5px;background-color: #1ab394;'>CAR SLOT</th><th style='padding: 5px;background-color: #1ab394;'>PLANT NAME</th><th style='padding: 5px;background-color: #1ab394;'>CANCEL DESC</th><th style='padding: 5px;background-color: #1ab394;'>CANCEL BY</th></tr>");
		sb.append("<tr><td style='padding: 5px;'>"+labcode+"</td><td style='padding: 5px;'>"+productname+"</td><td style='padding: 5px;'>"+logisname+"</td><td style='padding: 5px;'>"+sorucename+"</td><td style='padding: 5px;'style='padding: 5px;'>"+podate+"</td><td style='padding: 5px;'>"+carno+"</td><td style='padding: 5px;'>"+carslot+"</td><td style='padding: 5px;'>"+plantname+"</td><td style='padding: 5px;'>"+canceldesc+"</td><td style='padding: 5px;'>"+emp+"</td></tr>");
		sb.append("</table>");
		return sb.toString();
	}
	@Override
	public void sendmailCompleteLtr() {

		List<Map<String,Object>> listForGroupPlant=null;
		List<Map<String,Object>> listReport=null;
		List<Map<String,Object>> listUserPlant=null;
		String uri = WebUtil.WebServiceUrl() + "HrisService/member-getmemberprofile";
		String texthtml=null;
		MemberObj dataTo =	null;
		try {
			listUserPlant = new ArrayList<Map<String,Object>>();
			listForGroupPlant = new ArrayList<Map<String,Object>>();
			//first for get group plant
			listForGroupPlant=reportLTRDao.getGroupPlant();
			if(listForGroupPlant.size()>0) {
				for(Map<String,Object> gplant:listForGroupPlant) {
					
					listReport=reportLTRDao.getReportComplete(gplant.get("CENTER_CODE").toString());
					texthtml=createSendgridTextComplete(listReport);
					listUserPlant=reportLTRDao.getUserPlant(gplant.get("CENTER_CODE").toString());
					for(Map<String,Object> m:listUserPlant) {
						dataTo= new MemberObj();
						dataTo.codempid = m.get("CODEMP_ID").toString();
						RestTemplate restTemplate = new RestTemplate();
						MemberObj member_dataTo = restTemplate.postForObject(uri,dataTo,MemberObj.class);
						String test ="zomads17@gmail.com";//member_dataTo.getEmail()
						if(null!=member_dataTo.getEmail()) {
							sendMailService.sendGridSendMail("text/html", texthtml, "",member_dataTo.getEmail(), "รายการออก LTR/COQ");
						}
					}
					
					
					
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public String createSendgridTextComplete(List<Map<String,Object>> list){
		String labcode ="";
		String reportno="";
		String ltrcode ="";
		String productname ="";
		String plantname ="";
		String approvedate ="";
		String approveby ="";

		StringBuilder sb = new StringBuilder();
		sb.append("<h3>รายการออก LTR/COQ</h3>");
		sb.append("<br>");
		sb.append("<table border='1' style='border-collapse:collapse;text-align: center;border-radius:3px;'>");
		sb.append("<tr><th style='padding: 5px;background-color: #1ab394;'>LAB CODE</th><th style='padding: 5px;background-color: #1ab394;'>REPORT NO</th><th style='padding: 5px;background-color: #1ab394;'>LTR CODE</th><th style='padding: 5px;background-color: #1ab394;'>PRODUCT NAME</th><th style='padding: 5px;background-color: #1ab394;'>PLANT NAME</th><th style='padding: 5px;background-color: #1ab394;'>APPROVE DATE</th><th style='padding: 5px;background-color: #1ab394;'>APPROVE BY</th><th style='padding: 5px;background-color: #1ab394;'>LINK</th></tr>");
		for(Map<String,Object> m:list) {
			labcode =m.get("LAB_CODE")==null?"-":m.get("LAB_CODE").toString();
			reportno =m.get("report_no")==null?"-":m.get("report_no").toString();
			ltrcode =m.get("LTR_CODE")==null?"-":m.get("LTR_CODE").toString();
			productname =m.get("PRODUCT_NAME")==null?"-":m.get("PRODUCT_NAME").toString();
			plantname =m.get("PLANT_NAME")==null?"-":m.get("PLANT_NAME").toString();
			approvedate =m.get("APPROVE_DATE")==null?"-":m.get("APPROVE_DATE").toString();
			approveby =m.get("APPROVE_BY")==null?"-":m.get("APPROVE_BY").toString();
		
		sb.append("<tr><td style='padding: 5px;'>"+labcode+"</td><td style='padding: 5px;'>"+reportno+"</td><td style='padding: 5px;'>"+ltrcode+"</td><td style='padding: 5px;'>"+productname+"</td><td style='padding: 5px;'style='padding: 5px;'>"+plantname+"</td><td style='padding: 5px;'>"+approvedate+"</td><td style='padding: 5px;'>"+approveby+"</td><td style='padding: 5px;'>"+BASE_URL+"</td></tr>");
		}
		sb.append("</table>");
		return sb.toString();
	}

	@Override
	public List<Map<String, Object>> conditionLTRService(RequestCondition requestCondition) {
				logger.info("=== conditionLTRService ==== ");
				List<Map<String, Object>> res =null;
				List<Map<String, Object>> result =null;
				Map<String, Object> map = null;
				String productCodeStr = null;
				try {
					
					result = new ArrayList<Map<String,Object>>();
					res=reportLTRService.getRemarkReport(requestCondition);
					for(int i=0;i<res.size();i++) {
						map= new HashMap<String, Object>();
						map.put("LAB_CODE", res.get(i).get("LAB_CODE"));
						map.put("REQ_NO", res.get(i).get("SEND_REQT_ID"));
						productCodeStr= res.get(i).get("PRODUCT_CODE") ==null ?"" :res.get(i).get("PRODUCT_CODE").toString().trim();
						
						if("LZ9045".equals(productCodeStr)||"HITEC6421".equals(productCodeStr)) {
							map.put("REF",res.get(i).get("ADTV_LOT_NO") == null ? "" : res.get(i).get("ADTV_LOT_NO").toString());
						}else if("00005".equals(res.get(i).get("SAMPLE_TYPE").toString()) || "00007".equals(res.get(i).get("SAMPLE_TYPE").toString())) {
							map.put("REF", res.get(i).get("RETURNR_DESC") == null ? "" : res.get(i).get("RETURNR_DESC").toString());
						}else if("00004".equals(res.get(i).get("SAMPLE_TYPE").toString())) {
							map.put("REF", res.get(i).get("SAMPLE_TYPEC_DESC") == null ? "" : res.get(i).get("SAMPLE_TYPEC_DESC").toString());
						}else if("00002".equals(res.get(i).get("SAMPLE_TYPE").toString())||"00008".equals(res.get(i).get("SAMPLE_TYPE").toString())||"00009".equals(res.get(i).get("SAMPLE_TYPE").toString())) {
							map.put("REF", res.get(i).get("BOAT_NO") == null ? "" : res.get(i).get("BOAT_NO").toString());
						}else if("00003".equals(res.get(i).get("SAMPLE_TYPE").toString())) {
							map.put("REF", res.get(i).get("METER_NO") == null ? "" : res.get(i).get("METER_NO").toString());
							
						}else if("00001".equals(res.get(i).get("SAMPLE_TYPE").toString())||"00010".equals(res.get(i).get("SAMPLE_TYPE").toString())) {
							if("100000041".equals(res.get(i).get("PRODUCT_ID").toString()) || "Y".equals(res.get(i).get("MANUAL_TYPE").toString())) {
								map.put("REF",res.get(i).get("SAMPLE_TYPEC_DESC") == null ? "" : res.get(i).get("SAMPLE_TYPEC_DESC").toString());
							}else {
								map.put("REF", res.get(i).get("PO_NO") == null ? "" : res.get(i).get("PO_NO").toString());
							}
								
						}else {
							map.put("REF",res.get(i).get("SAMPLE_TYPEC_DESC") == null ? "" : res.get(i).get("SAMPLE_TYPEC_DESC").toString());
						}
						map.put("SAMPLING_DATE",res.get(i).get("RAN_CREATE_DATE_SAMPLE") == null ? "" : res.get(i).get("RAN_CREATE_DATE_SAMPLE").toString());
						map.put("RECEIVE_DATE",res.get(i).get("DTS_CREATE_DATE") == null ? "" : res.get(i).get("DTS_CREATE_DATE").toString());
						if("LZ9045".equals(productCodeStr)||"HITEC6421".equals(productCodeStr)) {
							map.put("PRODUCT",res.get(i).get("PRODUCT_CODE") == null ? "" : res.get(i).get("PRODUCT_CODE").toString());
						}else {
							map.put("PRODUCT",res.get(i).get("PRODUCT_NAME") == null ? "" : res.get(i).get("PRODUCT_NAME").toString());
						}
					
						map.put("REPORT_DATE",res.get(i).get("REPORT_DATE_LTR") == null ? "" : res.get(i).get("REPORT_DATE_LTR").toString());
						map.put("REMARK",res.get(i).get("RESULT_FLAG") == null ? "" : res.get(i).get("RESULT_FLAG").toString());
						map.put("ROOTCAUSE",res.get(i).get("RTDESC") == null ? "" : res.get(i).get("RTDESC").toString());
						map.put("RTCODE",res.get(i).get("RTCODE") == null ? "" : res.get(i).get("RTCODE").toString());
						map.put("REPORT_NO",res.get(i).get("report_no") == null ? "" : res.get(i).get("report_no").toString());
						map.put("TO",res.get(i).get("PLANT_NAME") == null ? "" : res.get(i).get("PLANT_NAME").toString());
						result.add(map);
						
					}

				}catch(Exception e){
					e.printStackTrace();
				}
				return result;
	}

	@Override
	public List<Map<String, Object>> getRemarkReport(RequestCondition requestCondition) {
		List<Map<String,Object>> obj=	reportLTRDao.getRemarkReport(requestCondition);
		return obj;
	}

	@Override
	public List<WaitWorkModel> getDataLtrIdWaitwork(String ltrid, String codempid,String role) {
		String arrLtr[] = ltrid.split(",");
		List<Map<String, Object>> response = null;

		List<WaitWorkModel> obj  =null;
		WaitWorkModel waitwork=null;
		try {
			obj = new ArrayList<WaitWorkModel>();
			for(int i=0;i<arrLtr.length;i++) {
				response=new ArrayList<Map<String,Object>>();

				response=reportLTRDao.getDataLtrIdWaitwork(arrLtr[i],codempid);
				if(response.size()>0) {
				waitwork = new WaitWorkModel();
				waitwork.setLabcode(response.get(0).get("LAB_CODE").toString().split("-")[6]);
				waitwork.setProduct(response.get(0).get("PRODUCT_CODE").toString());
				waitwork.setTypeOfSampling(response.get(0).get("SAMPLE_LEVEL_DESC").toString());
			
				if("0008".equals(role)) {
					for(Map<String,Object> msub:response) {
						if("0018".equals(msub.get("ITEM_ID").toString())) {
							if("0012".equals(msub.get("TOOL_ID").toString())) { 
								waitwork.setFtir("");
							}else {
								waitwork.setEralytics("");
							}
						}
						if("0014".equals(msub.get("ITEM_ID").toString())) {
							waitwork.setSulfur("");
						}
						if("0005".equals(msub.get("ITEM_ID").toString())
								||"0006".equals(msub.get("ITEM_ID").toString())
								||"0007".equals(msub.get("ITEM_ID").toString())
								||"0008".equals(msub.get("ITEM_ID").toString())
								||"0009".equals(msub.get("ITEM_ID").toString())) {
							waitwork.setDistillation("");
							
						}
						if("0022".equals(msub.get("ITEM_ID").toString())) {
							waitwork.setOxidation("");
						}
					}
					
				}else if("0009".equals(role)) {
					for(Map<String,Object> msub:response) {
						if("0021".equals(msub.get("ITEM_ID").toString())) {
							
							if("0012".equals(msub.get("TOOL_ID").toString())) {
								waitwork.setFtir("");
							}
							if("0015".equals(msub.get("TOOL_ID").toString())){
								waitwork.setGc("");
							}
							if("0011".equals(msub.get("TOOL_ID").toString())) {
								waitwork.setEralytics("");
							}
						}
						if("0005".equals(msub.get("ITEM_ID").toString())
								||"0006".equals(msub.get("ITEM_ID").toString())
								||"0007".equals(msub.get("ITEM_ID").toString())
								||"0008".equals(msub.get("ITEM_ID").toString())
								||"0009".equals(msub.get("ITEM_ID").toString())) {
							waitwork.setDistillation("");
						}
						
						if("0017".equals(msub.get("ITEM_ID").toString())) {
							waitwork.setWater("");
						}
					}
				}else if("0011".equals(role)) {
					for(Map<String,Object> msub:response) {
						if("0011".equals(msub.get("ITEM_ID").toString())) {
							waitwork.setApiDen_U("");
							waitwork.setApi60F_U("");
							waitwork.setDen_U("");
							waitwork.setApiDen_M("");
							waitwork.setApi60f_M("");
							waitwork.setDen_M("");
							waitwork.setApiDen_L("");
							waitwork.setApi60F_L("");
							waitwork.setDen_L("");
							waitwork.setRange("");
							waitwork.setApiDen_C("");
							waitwork.setApi60F_C("");
							waitwork.setDen_C("");
						
						}
						if("0013".equals(msub.get("TOOL_ID").toString())) {
							waitwork.setRvp("");
						}
	
					}
				}else if("0012".equals(role)) {
					for(Map<String,Object> msub:response) {
						
						if("0003".equals(msub.get("ITEM_ID").toString())) {
							waitwork.setColor_astm("");
						}
						if( "0016".equals(msub.get("ITEM_ID").toString())) {
							waitwork.setConduct("");
						}
						if("0010".equals(msub.get("ITEM_ID").toString())) {
							if("0005".equals(msub.get("TOOL_ID").toString())) { 
								waitwork.setResult_fp("");
								waitwork.setPressure_fp("");
							}else {
								waitwork.setResult_fps("");
								waitwork.setPressure_fps("");

							}
						}

					}
				}else if("0013".equals(role)) {
					for(Map<String,Object> msub:response) {
						if("0005".equals(msub.get("ITEM_ID").toString())
								||"0006".equals(msub.get("ITEM_ID").toString())
								||"0007".equals(msub.get("ITEM_ID").toString())
								||"0008".equals(msub.get("ITEM_ID").toString())
								||"0009".equals(msub.get("ITEM_ID").toString())) {
							
							waitwork.setAutodis("");
						}
						if("0021".equals(msub.get("ITEM_ID").toString())) {
							waitwork.setShake("");
						}
						if("0011".equals(msub.get("ITEM_ID").toString())) {
							waitwork.setApi60F_U("");
							waitwork.setApiDen_U("");
							waitwork.setDen_U("");
						}
					}
				}else if("0014".equals(role)) {
					for(Map<String,Object> msub:response) {
						
						if("0011".equals(msub.get("ITEM_ID").toString())) {
							waitwork.setApiDen_U("");
							waitwork.setApi60F_U("");
							waitwork.setDen_U("");
							waitwork.setApiDen_M("");
							waitwork.setApi60f_M("");
							waitwork.setDen_M("");
							waitwork.setApiDen_L("");
							waitwork.setApi60F_L("");
							waitwork.setDen_L("");
							waitwork.setRange("");
							waitwork.setApiDen_C("");
							waitwork.setApi60F_C("");
							waitwork.setDen_C("");
						
						}
						
						if("0013".equals(msub.get("ITEM_ID").toString())) {
							waitwork.setViscosity("");
						}
						if("0015".equals(msub.get("ITEM_ID").toString())) {
							waitwork.setCu_test1("");
							waitwork.setCu_test2("");
						}
						if("0020".equals(msub.get("ITEM_ID").toString())) {
							waitwork.setAg_test1("");
							waitwork.setAg_test2("");
						}
					}
				}
				}
				obj.add(waitwork);			
				}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public Map<String,List<WaitWorkModel>> filterDataWaitwork(List<WaitWorkModel> res,String role) {
		List<WaitWorkModel> listRes = null;
		Map<String,List<WaitWorkModel>> mapRes = null;
		int k=0;
		int g=0;
		try {
			mapRes = new HashMap<String, List<WaitWorkModel>>();
			listRes = new ArrayList<WaitWorkModel>();
			if("0013".equals(role)) {
				for(int i = 0 ;i <res.size();i++) {
					listRes.add(res.get(i));
					k++;
					if(k==24) {
						
					mapRes.put("num"+g, listRes);	
					listRes = new ArrayList<WaitWorkModel>();
					k=0;
					g++;
					}
				}
			}else {
				
				for(int i = 0 ;i <res.size();i++) {
					listRes.add(res.get(i));
					k++;
					if(k==15) {
						
					mapRes.put("num"+g, listRes);	
					listRes = new ArrayList<WaitWorkModel>();
					k=0;
					g++;
					}
				}
				
			}

			if(mapRes.size()==0||listRes.size()!=0) {
				mapRes.put("num"+g, listRes);	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return mapRes;
	}

	@Override
	public JasperPrint exportWaitwork(List<WaitWorkModel> listwaitwork, String role) {
		Map<String,Object> map =null;
		JRBeanCollectionDataSource jr  = null;
		JasperPrint jasperPrint = null;	
		 try {
			 map = new HashMap<String, Object>();

			    jr = new JRBeanCollectionDataSource(listwaitwork);
			    
	 			map.put("CollectionBeanParam", jr);
	 			if("0012".equals(role)) {
	 				jasperPrint=ReportUtils.exportReport("REPORT_B2",map , new JREmptyDataSource());
	 			}else if("0013".equals(role)) {
	 				jasperPrint=ReportUtils.exportReport("REPORT_B3",map , new JREmptyDataSource());
	 			}else if("0008".equals(role)) {
	 				jasperPrint=ReportUtils.exportReport("REPORT_A2",map , new JREmptyDataSource());
	 			}else if("0009".equals(role)) {
	 				jasperPrint=ReportUtils.exportReport("REPORT_A3",map , new JREmptyDataSource());
	 			}else if("0011".equals(role)) {
	 				jasperPrint=ReportUtils.exportReport("REPORT_B1",map , new JREmptyDataSource());
	 			}
	 			else if("0014".equals(role)) {
	 				jasperPrint=ReportUtils.exportReport("REPORT_B4",map , new JREmptyDataSource());
	 			}
	 			
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
       
		return jasperPrint;
	}

	@Override
	public void getUpdateStatusPrintWaitwork(String status, String ltrid,String roleId) {
		reportLTRDao.getUpdateStatusPrintWaitwork(status,ltrid,roleId);
		
	}

	@Override
	public void testmail() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sendMailService.sendGridSendMail("text/html", "<h1>"+simpleDateFormat.format(new Date())+"</h1>", "","zomads17@gmail.com", "ทดสอบ email");
		
	}
	
	@Override
	public Workbook exportReportExcelRandomSample2(String from) {
		logger.info("=== exportReportExcelRandomSample2 ==== ");
        XSSFWorkbook wb = new XSSFWorkbook();

		try {
			
			//SET HEADER
			CellStyle headerStyle = wb.createCellStyle();
			headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
			headerStyle.setFillPattern(FillPatternType.SQUARES);

			
			XSSFFont font = ((XSSFWorkbook) wb).createFont();
			font.setFontName("Tahoma");
			font.setFontHeightInPoints((short) 8);
			font.setBold(false);
			
			
			XSSFFont fontHeader = ((XSSFWorkbook) wb).createFont();
			font.setFontName("Tahoma");
			font.setFontHeightInPoints((short) 5);
			font.setBold(true);
			headerStyle.setFont(fontHeader);
			
			XSSFFont fontDetail = ((XSSFWorkbook) wb).createFont();
			fontDetail.setFontName("Tahoma");
			fontDetail.setFontHeightInPoints((short) 8);
			fontDetail.setBold(false);
			headerStyle.setFont(fontDetail);
			

			//CELL STYLE
			CellStyle style;
			style = wb.createCellStyle();
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
			style.setFont(fontDetail);
			//List<Map<String, Object>> productNamList = reportLTRDao.getProductNameByLabCode(labCode);
			List<Map<String, Object>> randombeforelist = reportLTRDao.getRandomSample2(from);
			Sheet sheet =null;
		    sheet = wb.createSheet("รายการก่อนสุ่มรอบ2");
			

			CellStyle styleVertical;
			styleVertical = wb.createCellStyle();
			styleVertical.setWrapText(true);
			styleVertical.setRotation((short) 90);
			styleVertical.setAlignment(HorizontalAlignment.CENTER);
			styleVertical.setBorderRight(BorderStyle.THIN);
			styleVertical.setRightBorderColor(IndexedColors.BLACK.getIndex());
			styleVertical.setBorderLeft(BorderStyle.THIN);
			styleVertical.setLeftBorderColor(IndexedColors.BLACK.getIndex());
			styleVertical.setBorderTop(BorderStyle.THIN);
			styleVertical.setTopBorderColor(IndexedColors.BLACK.getIndex());
			styleVertical.setBorderBottom(BorderStyle.THIN);
			styleVertical.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			styleVertical.setVerticalAlignment(VerticalAlignment.CENTER);

			XSSFFont fontNotBold = ((XSSFWorkbook) wb).createFont();
			fontNotBold.setFontName("Tahoma");
			fontNotBold.setFontHeightInPoints((short) 9);
			fontNotBold.setBold(false);
			styleVertical.setFont(fontNotBold);


			Row row3 = sheet.createRow(0);
			row3.setHeight((short) 1000);

			Cell headerRow2Cell0 = row3.createCell(0);
			headerRow2Cell0.setCellStyle(headerStyle);
			headerRow2Cell0.setCellStyle(style);
			headerRow2Cell0.setCellValue("LAB_CODE");


			Cell headerRow2Cell1 = row3.createCell(1);
			headerRow2Cell1.setCellStyle(headerStyle);
			headerRow2Cell1.setCellStyle(style);
			headerRow2Cell1.setCellValue("PRODUCT_ID");

			Cell headerRow2Cell2 = row3.createCell(2);
			headerRow2Cell2.setCellStyle(headerStyle);
			headerRow2Cell2.setCellStyle(style);
			headerRow2Cell2.setCellValue("PRODUCT_NAME");


			Cell headerRow2Cell3 = row3.createCell(3);
			headerRow2Cell3.setCellStyle(headerStyle);
			headerRow2Cell3.setCellStyle(style);
			headerRow2Cell3.setCellValue("LOGIS_ID");

			Cell headerRow2Cell4 = row3.createCell(4);
			headerRow2Cell4.setCellStyle(headerStyle);
			headerRow2Cell4.setCellStyle(style);
			headerRow2Cell4.setCellValue("LOGIS_NAME");

			Cell headerRow2Cell5 = row3.createCell(5);
			headerRow2Cell5.setCellStyle(headerStyle);
			headerRow2Cell5.setCellStyle(style);
			headerRow2Cell5.setCellValue("PLANT_ID");

			Cell headerRow2Cell6 = row3.createCell(6);
			headerRow2Cell6.setCellStyle(headerStyle);
			headerRow2Cell6.setCellStyle(style);
			headerRow2Cell6.setCellValue("PLANT_NAME");


			Cell headerRow2Cell7 = row3.createCell(7);
			headerRow2Cell7.setCellStyle(headerStyle);
			headerRow2Cell7.setCellStyle(style);
			headerRow2Cell7.setCellValue("SOURCE_ID");

			Cell headerRow2Cell8 = row3.createCell(8);
			headerRow2Cell8.setCellStyle(headerStyle);
			headerRow2Cell8.setCellStyle(style);
			headerRow2Cell8.setCellValue("SOURCE_NAME");
			
			Cell headerRow2Cell9 = row3.createCell(9);
			headerRow2Cell9.setCellStyle(headerStyle);
			headerRow2Cell9.setCellStyle(style);
			headerRow2Cell9.setCellValue("PO_DATE");
			
			Cell headerRow2Cell10 = row3.createCell(10);
			headerRow2Cell10.setCellStyle(headerStyle);
			headerRow2Cell10.setCellStyle(style);
			headerRow2Cell10.setCellValue("CAR_NO");
			
			Cell headerRow2Cell11 = row3.createCell(11);
			headerRow2Cell11.setCellStyle(headerStyle);
			headerRow2Cell11.setCellStyle(style);
			headerRow2Cell11.setCellValue("CAR_SLOT");
			
			Cell headerRow2Cell12 = row3.createCell(12);
			headerRow2Cell12.setCellStyle(headerStyle);
			headerRow2Cell12.setCellStyle(style);
			headerRow2Cell12.setCellValue("CREATE_DATE");


			int rowDetail = 1;
			int cellDetailNo = 0;
			Row rowData = sheet.createRow(rowDetail);
			rowData.setHeight((short) 450);
			for (Map<String, Object> m : randombeforelist) {
					rowData = sheet.createRow(rowDetail++);
					rowData.setHeight((short) 450);
					sheet.setColumnWidth(cellDetailNo, 6000);
					
					Cell cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("LAB_CODE") == null ? "" : m.get("LAB_CODE").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("PRODUCT_ID") == null ? "" : m.get("PRODUCT_ID").toString());
					
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("PRODUCT_NAME") == null ? "" : m.get("PRODUCT_NAME").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("LOGIS_ID") == null ? "" : m.get("LOGIS_ID").toString());							
			
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("LOGIS_NAME") == null ? "" : m.get("LOGIS_NAME").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("PLANT_ID") == null ? "" : m.get("PLANT_ID").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("PLANT_NAME")== null ? "" : m.get("PLANT_NAME").toString());
				
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("SOURCE_ID") == null ? "" : m.get("SOURCE_ID").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("SOURCE_NAME") == null ? "" : m.get("SOURCE_NAME").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("PO_DATE") == null ? "" : m.get("PO_DATE").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("CAR_NO") == null ? "" : m.get("CAR_NO").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("CAR_SLOT") == null ? "" : m.get("CAR_SLOT").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("CREATE_DATE") == null ? "" : m.get("CREATE_DATE").toString());
					
					cellDetailNo = 0;

			}
		
			//After random
			List<Map<String, Object>> randombeforelistAfter = reportLTRDao.getRandomSample2After(from);
			
			Sheet sheet2 =null;
			sheet2 = wb.createSheet("รายการหลังสุ่มรอบ2");
			

			Row row3_2 = sheet2.createRow(0);
			row3_2.setHeight((short) 1000);

			Cell headerRow2Cell0_2 = row3_2.createCell(0);
			headerRow2Cell0_2.setCellStyle(headerStyle);
			headerRow2Cell0_2.setCellStyle(style);
			headerRow2Cell0_2.setCellValue("LAB_CODE");


			Cell headerRow2Cell1_2 = row3_2.createCell(1);
			headerRow2Cell1_2.setCellStyle(headerStyle);
			headerRow2Cell1_2.setCellStyle(style);
			headerRow2Cell1_2.setCellValue("PRODUCT_ID");

			Cell headerRow2Cell2_2 = row3_2.createCell(2);
			headerRow2Cell2_2.setCellStyle(headerStyle);
			headerRow2Cell2_2.setCellStyle(style);
			headerRow2Cell2_2.setCellValue("PRODUCT_NAME");


			Cell headerRow2Cell3_2 = row3_2.createCell(3);
			headerRow2Cell3_2.setCellStyle(headerStyle);
			headerRow2Cell3_2.setCellStyle(style);
			headerRow2Cell3_2.setCellValue("LOGIS_ID");

			Cell headerRow2Cell4_2 = row3_2.createCell(4);
			headerRow2Cell4_2.setCellStyle(headerStyle);
			headerRow2Cell4_2.setCellStyle(style);
			headerRow2Cell4_2.setCellValue("LOGIS_NAME");

			Cell headerRow2Cell5_2 = row3_2.createCell(5);
			headerRow2Cell5_2.setCellStyle(headerStyle);
			headerRow2Cell5_2.setCellStyle(style);
			headerRow2Cell5_2.setCellValue("PLANT_ID");

			Cell headerRow2Cell6_2 = row3_2.createCell(6);
			headerRow2Cell6_2.setCellStyle(headerStyle);
			headerRow2Cell6_2.setCellStyle(style);
			headerRow2Cell6_2.setCellValue("PLANT_NAME");


			Cell headerRow2Cell7_2 = row3_2.createCell(7);
			headerRow2Cell7_2.setCellStyle(headerStyle);
			headerRow2Cell7_2.setCellStyle(style);
			headerRow2Cell7_2.setCellValue("SOURCE_ID");

			Cell headerRow2Cell8_2 = row3_2.createCell(8);
			headerRow2Cell8_2.setCellStyle(headerStyle);
			headerRow2Cell8_2.setCellStyle(style);
			headerRow2Cell8_2.setCellValue("SOURCE_NAME");
			
			Cell headerRow2Cell9_2 = row3_2.createCell(9);
			headerRow2Cell9_2.setCellStyle(headerStyle);
			headerRow2Cell9_2.setCellStyle(style);
			headerRow2Cell9_2.setCellValue("PO_DATE");
			
			Cell headerRow2Cell10_2 = row3_2.createCell(10);
			headerRow2Cell10_2.setCellStyle(headerStyle);
			headerRow2Cell10_2.setCellStyle(style);
			headerRow2Cell10_2.setCellValue("CAR_NO");
			
			Cell headerRow2Cell11_2 = row3_2.createCell(11);
			headerRow2Cell11_2.setCellStyle(headerStyle);
			headerRow2Cell11_2.setCellStyle(style);
			headerRow2Cell11_2.setCellValue("CAR_SLOT");
			
			Cell headerRow2Cell12_2 = row3_2.createCell(12);
			headerRow2Cell12_2.setCellStyle(headerStyle);
			headerRow2Cell12_2.setCellStyle(style);
			headerRow2Cell12_2.setCellValue("CREATE_DATE");


			rowDetail = 1;
			cellDetailNo = 0;
			rowData = sheet2.createRow(rowDetail);
			rowData.setHeight((short) 450);
			for (Map<String, Object> m : randombeforelistAfter) {
					rowData = sheet2.createRow(rowDetail++);
					rowData.setHeight((short) 450);
					sheet2.setColumnWidth(cellDetailNo, 6000);
					
					Cell cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("LAB_CODE") == null ? "" : m.get("LAB_CODE").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("PRODUCT_ID") == null ? "" : m.get("PRODUCT_ID").toString());
					
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("PRODUCT_NAME") == null ? "" : m.get("PRODUCT_NAME").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("LOGIS_ID") == null ? "" : m.get("LOGIS_ID").toString());							
			
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("LOGIS_NAME") == null ? "" : m.get("LOGIS_NAME").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("PLANT_ID") == null ? "" : m.get("PLANT_ID").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("PLANT_NAME")== null ? "" : m.get("PLANT_NAME").toString());
				
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("SOURCE_ID") == null ? "" : m.get("SOURCE_ID").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("SOURCE_NAME") == null ? "" : m.get("SOURCE_NAME").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("PO_DATE") == null ? "" : m.get("PO_DATE").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("CAR_NO") == null ? "" : m.get("CAR_NO").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("CAR_SLOT") == null ? "" : m.get("CAR_SLOT").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("CREATE_DATE") == null ? "" : m.get("CREATE_DATE").toString());
					
					cellDetailNo = 0;

			}
			
			return wb;
		}catch(Exception e){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Workbook exportReportExcelRandomSampleBefore(String from,String round) {
		logger.info("=== exportReportExcelRandomSampleBefore ==== ");
        XSSFWorkbook wb = new XSSFWorkbook();

		try {
			
			//SET HEADER
			CellStyle headerStyle = wb.createCellStyle();
			headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
			headerStyle.setFillPattern(FillPatternType.SQUARES);

			
			XSSFFont font = ((XSSFWorkbook) wb).createFont();
			font.setFontName("Tahoma");
			font.setFontHeightInPoints((short) 8);
			font.setBold(false);
			
			
			XSSFFont fontHeader = ((XSSFWorkbook) wb).createFont();
			font.setFontName("Tahoma");
			font.setFontHeightInPoints((short) 5);
			font.setBold(true);
			headerStyle.setFont(fontHeader);
			
			XSSFFont fontDetail = ((XSSFWorkbook) wb).createFont();
			fontDetail.setFontName("Tahoma");
			fontDetail.setFontHeightInPoints((short) 8);
			fontDetail.setBold(false);
			headerStyle.setFont(fontDetail);
			

			//CELL STYLE
			CellStyle style;
			style = wb.createCellStyle();
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
			style.setFont(fontDetail);
			//List<Map<String, Object>> productNamList = reportLTRDao.getProductNameByLabCode(labCode);
			List<Map<String, Object>> randomFirstList = reportLTRDao.getRandomSampleFirst(from,"N",round);
			Sheet sheet =null;
		    sheet = wb.createSheet("รายการก่อนสุ่ม");
			

			CellStyle styleVertical;
			styleVertical = wb.createCellStyle();
			styleVertical.setWrapText(true);
			styleVertical.setRotation((short) 90);
			styleVertical.setAlignment(HorizontalAlignment.CENTER);
			styleVertical.setBorderRight(BorderStyle.THIN);
			styleVertical.setRightBorderColor(IndexedColors.BLACK.getIndex());
			styleVertical.setBorderLeft(BorderStyle.THIN);
			styleVertical.setLeftBorderColor(IndexedColors.BLACK.getIndex());
			styleVertical.setBorderTop(BorderStyle.THIN);
			styleVertical.setTopBorderColor(IndexedColors.BLACK.getIndex());
			styleVertical.setBorderBottom(BorderStyle.THIN);
			styleVertical.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			styleVertical.setVerticalAlignment(VerticalAlignment.CENTER);

			XSSFFont fontNotBold = ((XSSFWorkbook) wb).createFont();
			fontNotBold.setFontName("Tahoma");
			fontNotBold.setFontHeightInPoints((short) 9);
			fontNotBold.setBold(false);
			styleVertical.setFont(fontNotBold);


			Row row3 = sheet.createRow(0);
			row3.setHeight((short) 1000);

			Cell headerRow2Cell0 = row3.createCell(0);
			headerRow2Cell0.setCellStyle(headerStyle);
			headerRow2Cell0.setCellStyle(style);
			headerRow2Cell0.setCellValue("LAB_CODE");


			Cell headerRow2Cell1 = row3.createCell(1);
			headerRow2Cell1.setCellStyle(headerStyle);
			headerRow2Cell1.setCellStyle(style);
			headerRow2Cell1.setCellValue("PRODUCT_ID");

			Cell headerRow2Cell2 = row3.createCell(2);
			headerRow2Cell2.setCellStyle(headerStyle);
			headerRow2Cell2.setCellStyle(style);
			headerRow2Cell2.setCellValue("PRODUCT_NAME");


			Cell headerRow2Cell3 = row3.createCell(3);
			headerRow2Cell3.setCellStyle(headerStyle);
			headerRow2Cell3.setCellStyle(style);
			headerRow2Cell3.setCellValue("LOGIS_ID");

			Cell headerRow2Cell4 = row3.createCell(4);
			headerRow2Cell4.setCellStyle(headerStyle);
			headerRow2Cell4.setCellStyle(style);
			headerRow2Cell4.setCellValue("LOGIS_NAME");

			Cell headerRow2Cell5 = row3.createCell(5);
			headerRow2Cell5.setCellStyle(headerStyle);
			headerRow2Cell5.setCellStyle(style);
			headerRow2Cell5.setCellValue("PLANT_ID");

			Cell headerRow2Cell6 = row3.createCell(6);
			headerRow2Cell6.setCellStyle(headerStyle);
			headerRow2Cell6.setCellStyle(style);
			headerRow2Cell6.setCellValue("PLANT_NAME");


			Cell headerRow2Cell7 = row3.createCell(7);
			headerRow2Cell7.setCellStyle(headerStyle);
			headerRow2Cell7.setCellStyle(style);
			headerRow2Cell7.setCellValue("SOURCE_ID");

			Cell headerRow2Cell8 = row3.createCell(8);
			headerRow2Cell8.setCellStyle(headerStyle);
			headerRow2Cell8.setCellStyle(style);
			headerRow2Cell8.setCellValue("SOURCE_NAME");
			
			Cell headerRow2Cell9 = row3.createCell(9);
			headerRow2Cell9.setCellStyle(headerStyle);
			headerRow2Cell9.setCellStyle(style);
			headerRow2Cell9.setCellValue("PO_DATE");
			
			Cell headerRow2Cell10 = row3.createCell(10);
			headerRow2Cell10.setCellStyle(headerStyle);
			headerRow2Cell10.setCellStyle(style);
			headerRow2Cell10.setCellValue("CAR_NO");
			
			Cell headerRow2Cell11 = row3.createCell(11);
			headerRow2Cell11.setCellStyle(headerStyle);
			headerRow2Cell11.setCellStyle(style);
			headerRow2Cell11.setCellValue("CAR_SLOT");
			
			Cell headerRow2Cell12 = row3.createCell(12);
			headerRow2Cell12.setCellStyle(headerStyle);
			headerRow2Cell12.setCellStyle(style);
			headerRow2Cell12.setCellValue("CREATE_DATE");
			



			int rowDetail = 1;
			int cellDetailNo = 0;
			Row rowData = sheet.createRow(rowDetail);
			rowData.setHeight((short) 450);
			for (Map<String, Object> m : randomFirstList) {
					rowData = sheet.createRow(rowDetail++);
					rowData.setHeight((short) 450);
					sheet.setColumnWidth(cellDetailNo, 6000);
					
					Cell cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("LAB_CODE") == null ? "" : m.get("LAB_CODE").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("PRODUCT_ID") == null ? "" : m.get("PRODUCT_ID").toString());
					
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("PRODUCT_NAME") == null ? "" : m.get("PRODUCT_NAME").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("LOGIS_ID") == null ? "" : m.get("LOGIS_ID").toString());							
			
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("LOGIS_NAME") == null ? "" : m.get("LOGIS_NAME").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("PLANT_ID") == null ? "" : m.get("PLANT_ID").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("PLANT_NAME")== null ? "" : m.get("PLANT_NAME").toString());
				
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("SOURCE_ID") == null ? "" : m.get("SOURCE_ID").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("SOURCE_NAME") == null ? "" : m.get("SOURCE_NAME").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("PO_DATE") == null ? "" : m.get("PO_DATE").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("CAR_NO") == null ? "" : m.get("CAR_NO").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("CAR_SLOT") == null ? "" : m.get("CAR_SLOT").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("CREATE_DATE") == null ? "" : m.get("CREATE_DATE").toString());
					

					
					cellDetailNo = 0;

			}
		
			//After random
			List<Map<String, Object>> randombeforelistAfter = reportLTRDao.getRandomSampleFirst(from,"Y",round);
			
			Sheet sheet2 =null;
			sheet2 = wb.createSheet("รายการหลังสุ่ม");
			

			Row row3_2 = sheet2.createRow(0);
			row3_2.setHeight((short) 1000);

			Cell headerRow2Cell0_2 = row3_2.createCell(0);
			headerRow2Cell0_2.setCellStyle(headerStyle);
			headerRow2Cell0_2.setCellStyle(style);
			headerRow2Cell0_2.setCellValue("LAB_CODE");


			Cell headerRow2Cell1_2 = row3_2.createCell(1);
			headerRow2Cell1_2.setCellStyle(headerStyle);
			headerRow2Cell1_2.setCellStyle(style);
			headerRow2Cell1_2.setCellValue("PRODUCT_ID");

			Cell headerRow2Cell2_2 = row3_2.createCell(2);
			headerRow2Cell2_2.setCellStyle(headerStyle);
			headerRow2Cell2_2.setCellStyle(style);
			headerRow2Cell2_2.setCellValue("PRODUCT_NAME");


			Cell headerRow2Cell3_2 = row3_2.createCell(3);
			headerRow2Cell3_2.setCellStyle(headerStyle);
			headerRow2Cell3_2.setCellStyle(style);
			headerRow2Cell3_2.setCellValue("LOGIS_ID");

			Cell headerRow2Cell4_2 = row3_2.createCell(4);
			headerRow2Cell4_2.setCellStyle(headerStyle);
			headerRow2Cell4_2.setCellStyle(style);
			headerRow2Cell4_2.setCellValue("LOGIS_NAME");

			Cell headerRow2Cell5_2 = row3_2.createCell(5);
			headerRow2Cell5_2.setCellStyle(headerStyle);
			headerRow2Cell5_2.setCellStyle(style);
			headerRow2Cell5_2.setCellValue("PLANT_ID");

			Cell headerRow2Cell6_2 = row3_2.createCell(6);
			headerRow2Cell6_2.setCellStyle(headerStyle);
			headerRow2Cell6_2.setCellStyle(style);
			headerRow2Cell6_2.setCellValue("PLANT_NAME");


			Cell headerRow2Cell7_2 = row3_2.createCell(7);
			headerRow2Cell7_2.setCellStyle(headerStyle);
			headerRow2Cell7_2.setCellStyle(style);
			headerRow2Cell7_2.setCellValue("SOURCE_ID");

			Cell headerRow2Cell8_2 = row3_2.createCell(8);
			headerRow2Cell8_2.setCellStyle(headerStyle);
			headerRow2Cell8_2.setCellStyle(style);
			headerRow2Cell8_2.setCellValue("SOURCE_NAME");
			
			Cell headerRow2Cell9_2 = row3_2.createCell(9);
			headerRow2Cell9_2.setCellStyle(headerStyle);
			headerRow2Cell9_2.setCellStyle(style);
			headerRow2Cell9_2.setCellValue("PO_DATE");
			
			Cell headerRow2Cell10_2 = row3_2.createCell(10);
			headerRow2Cell10_2.setCellStyle(headerStyle);
			headerRow2Cell10_2.setCellStyle(style);
			headerRow2Cell10_2.setCellValue("CAR_NO");
			
			Cell headerRow2Cell11_2 = row3_2.createCell(11);
			headerRow2Cell11_2.setCellStyle(headerStyle);
			headerRow2Cell11_2.setCellStyle(style);
			headerRow2Cell11_2.setCellValue("CAR_SLOT");
			
			Cell headerRow2Cell12_2 = row3_2.createCell(12);
			headerRow2Cell12_2.setCellStyle(headerStyle);
			headerRow2Cell12_2.setCellStyle(style);
			headerRow2Cell12_2.setCellValue("CREATE_DATE");


			rowDetail = 1;
			cellDetailNo = 0;
			rowData = sheet2.createRow(rowDetail);
			rowData.setHeight((short) 450);
			for (Map<String, Object> m : randombeforelistAfter) {
					rowData = sheet2.createRow(rowDetail++);
					rowData.setHeight((short) 450);
					sheet2.setColumnWidth(cellDetailNo, 6000);
					
					Cell cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("LAB_CODE") == null ? "" : m.get("LAB_CODE").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("PRODUCT_ID") == null ? "" : m.get("PRODUCT_ID").toString());
					
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("PRODUCT_NAME") == null ? "" : m.get("PRODUCT_NAME").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("LOGIS_ID") == null ? "" : m.get("LOGIS_ID").toString());							
			
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("LOGIS_NAME") == null ? "" : m.get("LOGIS_NAME").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("PLANT_ID") == null ? "" : m.get("PLANT_ID").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("PLANT_NAME")== null ? "" : m.get("PLANT_NAME").toString());
				
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("SOURCE_ID") == null ? "" : m.get("SOURCE_ID").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("SOURCE_NAME") == null ? "" : m.get("SOURCE_NAME").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("PO_DATE") == null ? "" : m.get("PO_DATE").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("CAR_NO") == null ? "" : m.get("CAR_NO").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("CAR_SLOT") == null ? "" : m.get("CAR_SLOT").toString());
					
					cellDetail = rowData.createCell(cellDetailNo++);
					cellDetail.setCellStyle(headerStyle);
					cellDetail.setCellStyle(style);
					sheet2.setColumnWidth(cellDetailNo, 4000);
					cellDetail.setCellValue(m.get("CREATE_DATE") == null ? "" : m.get("CREATE_DATE").toString());
					
					cellDetailNo = 0;

			}
			
			return wb;
		}catch(Exception e){
			logger.error("Exception : {}",e);
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Workbook exportReportPageHeaderTools(String[] labCode) {
		// TODO Auto-generated method stub
				logger.info("=== exportReportPageHeader ==== ");
			
		         XSSFWorkbook wb = new XSSFWorkbook();
		       
				try {
					
					SimpleDateFormat DateFor = new SimpleDateFormat("YY");
					Date date = new Date();
					String stringDate= DateFor.format(date);
					
					String productCodeStr ="";
					
					Cell cell;
					//SET HEADER
					CellStyle headerStyle = wb.createCellStyle();
					headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
					headerStyle.setFillPattern(FillPatternType.SQUARES);

					CellStyle headerStyleRed = wb.createCellStyle();
					headerStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
					headerStyle.setFillPattern(FillPatternType.SQUARES);
					
					XSSFFont font = ((XSSFWorkbook) wb).createFont();
					font.setFontName("Tahoma");
					font.setFontHeightInPoints((short) 8);
					font.setBold(false);
					
					
					XSSFFont fontHeader = ((XSSFWorkbook) wb).createFont();
					font.setFontName("Tahoma");
					font.setFontHeightInPoints((short) 9);
					font.setBold(true);
					headerStyle.setFont(fontHeader);
					
					XSSFFont fontDetail = ((XSSFWorkbook) wb).createFont();
					fontDetail.setFontName("Tahoma");
					fontDetail.setFontHeightInPoints((short) 8);
					fontDetail.setBold(false);
					headerStyle.setFont(fontDetail);
					
					XSSFFont fontRed = ((XSSFWorkbook) wb).createFont();
					fontRed.setFontName("Tahoma");
					fontRed.setFontHeightInPoints((short) 8);
					fontRed.setBold(false);
					fontRed.setColor((short) 8);
					headerStyleRed.setFont(fontRed);
					
					CellStyle styleRed;
					styleRed = wb.createCellStyle();
					styleRed.setWrapText(true);
					styleRed.setAlignment(HorizontalAlignment.CENTER);
					styleRed.setBorderRight(BorderStyle.THIN);
					styleRed.setRightBorderColor(IndexedColors.BLACK.getIndex());
					styleRed.setBorderLeft(BorderStyle.THIN);
					styleRed.setLeftBorderColor(IndexedColors.BLACK.getIndex());
					styleRed.setBorderTop(BorderStyle.THIN);
					styleRed.setTopBorderColor(IndexedColors.BLACK.getIndex());
					styleRed.setBorderBottom(BorderStyle.THIN);
					styleRed.setBottomBorderColor(IndexedColors.BLACK.getIndex());
					styleRed.setVerticalAlignment(VerticalAlignment.CENTER);
					styleRed.setFont(fontRed);

					//CELL STYLE
					CellStyle style;
					style = wb.createCellStyle();
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
					style.setFont(fontDetail);
					//List<Map<String, Object>> productNamList = reportLTRDao.getProductNameByLabCode(labCode);
					List<Map<String, Object>> productNamListSheet = reportLTRDao.getProductNameByLabCodeSheet(labCode);
					List<Map<String, Object>> resultListData = reportLTRDao.getDataInfoByLabCode(labCode);
					List<Map<String, Object>> resultListDataDetail = reportLTRDao.getDataDetailInLabCode(labCode);
					System.out.println(resultListDataDetail);
					Sheet sheet =null;
					
					for (Map<String, Object> mapProductName : productNamListSheet) {
					if("100000031".equals(mapProductName.get("PRODUCT_ID").toString())) {
						 sheet = wb.createSheet("RESULT RECORDS - ADDITIVE ( RAW MATERIAL )");
					}else {
						 sheet = wb.createSheet(mapProductName.get("PRODUCT_NAME").toString());
					}
					
					List<Map<String, Object>> dataListLTR = reportLTRDao.getDataForLTRReportHeaderExcelForTool(labCode);
					
					sheet.addMergedRegion(CellRangeAddress.valueOf("A1:J1"));	
					//sheet.addMergedRegion(CellRangeAddress.valueOf("B3:J3"));		
					Row header = sheet.createRow(1);
				
//					Cell headerCell = header.createCell(0);
//					headerCell.setCellStyle(headerStyle);
//					headerCell.setCellStyle(style);
//					headerCell.setCellValue("Test by.");
//					headerCell = header.createCell(1);
//					headerCell.setCellStyle(headerStyle);
//					headerCell.setCellStyle(style);
//					headerCell.setCellValue("KNL/ANS");
//					headerCell = header.createCell(2);
//					RegionUtil.setBorderBottom(1, CellRangeAddress.valueOf("B3:J3"), sheet);
//					RegionUtil.setBorderTop(1, CellRangeAddress.valueOf("B3:J3"), sheet);
//					RegionUtil.setBorderLeft(1, CellRangeAddress.valueOf("B3:J3"), sheet);
//					RegionUtil.setBorderRight(1, CellRangeAddress.valueOf("B3:J3"), sheet);

					Integer firstCol = 10;
					Integer lastCol = firstCol + dataListLTR.size() +1;
					Cell headerCell24 = header.createCell(10);
				    sheet.addMergedRegion(new CellRangeAddress(2,2,firstCol,lastCol));
//					headerCell24.setCellValue("SD");
//					headerCell24.setCellStyle(headerStyle);
//					headerCell24.setCellStyle(style);
//					RegionUtil.setBorderBottom(1,new CellRangeAddress(2,2,firstCol,lastCol), sheet);
//					RegionUtil.setBorderTop(1, new CellRangeAddress(2,2,firstCol,lastCol), sheet);
//					RegionUtil.setBorderLeft(1, new CellRangeAddress(2,2,firstCol,lastCol), sheet);
//					RegionUtil.setBorderRight(1,new CellRangeAddress(2,2,firstCol,lastCol), sheet);
//				



					CellStyle styleVertical;
					styleVertical = wb.createCellStyle();
					styleVertical.setWrapText(true);
					styleVertical.setRotation((short) 90);
					styleVertical.setAlignment(HorizontalAlignment.CENTER);
					styleVertical.setBorderRight(BorderStyle.THIN);
					styleVertical.setRightBorderColor(IndexedColors.BLACK.getIndex());
					styleVertical.setBorderLeft(BorderStyle.THIN);
					styleVertical.setLeftBorderColor(IndexedColors.BLACK.getIndex());
					styleVertical.setBorderTop(BorderStyle.THIN);
					styleVertical.setTopBorderColor(IndexedColors.BLACK.getIndex());
					styleVertical.setBorderBottom(BorderStyle.THIN);
					styleVertical.setBottomBorderColor(IndexedColors.BLACK.getIndex());
					styleVertical.setVerticalAlignment(VerticalAlignment.CENTER);

					XSSFFont fontNotBold = ((XSSFWorkbook) wb).createFont();
					fontNotBold.setFontName("Tahoma");
					fontNotBold.setFontHeightInPoints((short) 9);
					fontNotBold.setBold(false);
					styleVertical.setFont(fontNotBold);






					Row row3 = sheet.createRow(3);
					row3.setHeight((short) 1000);

					Cell headerRow2Cell0 = row3.createCell(0);
					headerRow2Cell0.setCellStyle(headerStyle);
					headerRow2Cell0.setCellStyle(style);
					headerRow2Cell0.setCellValue("Lab. Code");


					Cell headerRow2Cell1 = row3.createCell(1);
					headerRow2Cell1.setCellStyle(headerStyle);
					headerRow2Cell1.setCellStyle(style);
					headerRow2Cell1.setCellValue("Req No.");

					Cell headerRow2Cell2 = row3.createCell(2);
					headerRow2Cell2.setCellStyle(headerStyle);
					headerRow2Cell2.setCellStyle(style);
					headerRow2Cell2.setCellValue("Referance");


					Cell headerRow2Cell3 = row3.createCell(3);
					headerRow2Cell3.setCellStyle(headerStyle);
					headerRow2Cell3.setCellStyle(style);
					headerRow2Cell3.setCellValue("Sampling Date");

					Cell headerRow2Cell4 = row3.createCell(4);
					headerRow2Cell4.setCellStyle(headerStyle);
					headerRow2Cell4.setCellStyle(style);
					headerRow2Cell4.setCellValue("Receive Date");

					Cell headerRow2Cell5 = row3.createCell(5);
					headerRow2Cell5.setCellStyle(headerStyle);
					headerRow2Cell5.setCellStyle(style);
					headerRow2Cell5.setCellValue("Product");

					Cell headerRow2Cell6 = row3.createCell(6);
					headerRow2Cell6.setCellStyle(headerStyle);
					headerRow2Cell6.setCellStyle(style);
					headerRow2Cell6.setCellValue("Vessel");


					Cell headerRow2Cell8 = row3.createCell(7);
					headerRow2Cell8.setCellStyle(headerStyle);
					headerRow2Cell8.setCellStyle(style);
					headerRow2Cell8.setCellValue("Report Date");

					Cell headerRow2Cell9 = row3.createCell(8);
					headerRow2Cell9.setCellStyle(headerStyle);
					headerRow2Cell9.setCellStyle(style);
					headerRow2Cell9.setCellValue("Report No.");

					Cell headerRow2Cell10 = row3.createCell(9);
					headerRow2Cell10.setCellStyle(headerStyle);
					headerRow2Cell10.setCellStyle(style);
					headerRow2Cell10.setCellValue("To");


				
//					logger.info("dataListLTR  :{}",dataListLTR.size());
//					Integer celmerge = dataListLTR.size() +11;
//				    sheet.addMergedRegion(new CellRangeAddress(0,0,0,celmerge));  
//					sheet.addMergedRegion(CellRangeAddress.valueOf("A1:AE1"));
				    
					Row rowH = sheet.createRow(0);
					Cell cellTitle = rowH.createCell(0);
					
					cellTitle.setCellValue("RESULT  " +mapProductName.get("PRODUCT_NAME").toString());
					cellTitle.setCellStyle(headerStyle);
					cellTitle.setCellStyle(style);
//					RegionUtil.setBorderBottom(1,new CellRangeAddress(0,0,0,celmerge), sheet);
//					RegionUtil.setBorderTop(1, new CellRangeAddress(0,0,0,celmerge), sheet);
//					RegionUtil.setBorderLeft(1, new CellRangeAddress(0,0,0,celmerge), sheet);
//					RegionUtil.setBorderRight(1,new CellRangeAddress(0,0,0,celmerge), sheet);
					
					
				   
					
					
					int cellInt = 10;
					Map<String, Object> headerSpec = new HashMap<>();
					//Map<String, Object> headerSpecProduct = new HashMap<>();
					int countRemarkAppove = 0;
					for (int i = 0; i < dataListLTR.size(); i++) {	
						headerSpec = dataListLTR.get(i);
						if(headerSpec.get("PRODUCT_ID").toString().equals(mapProductName.get("PRODUCT_ID").toString())) {
							//System.out.println(headerSpec.get("ITEM_NAME").toString());
							Cell headerCellSpec = row3.createCell(cellInt++);
							headerCellSpec.setCellStyle(styleVertical);
							headerCellSpec.setCellValue(headerSpec.get("ITEM_NAME").toString());
							countRemarkAppove += 1;
						}				
//						for(int j=0;j<productNamList.size() ;j++) {
//							headerSpec = dataListLTR.get(i);
//							headerSpecProduct = productNamList.get(j);
//							if(headerSpec.get("LAB_CODE").toString().equals(headerSpecProduct.get("LAB_CODE").toString())) {
//								Cell headerCellSpec = row3.createCell(cellInt++);
//								headerCellSpec.setCellStyle(styleVertical);
//								headerCellSpec.setCellValue(headerSpec.get("ITEM_NAME").toString());
//							}
//						}
					}
					
					int cellApproveAndRemark = dataListLTR.size() +11;

					int rowDetail = 4;
					int cellDetailNo = 0;
				
					
					
					
					
					
					
					int sequent = 1;
						Row rowData = sheet.createRow(rowDetail);
						rowData.setHeight((short) 450);
					for (int i = 0; i < labCode.length; i++) {
						for (Map<String, Object> m : resultListData) {
							if(mapProductName.get("PRODUCT_ID").toString().equals(m.get("PRODUCT_ID").toString())){
							if (labCode[i].equalsIgnoreCase(m.get("LAB_CODE").toString())) {
								rowData = sheet.createRow(rowDetail++);
								rowData.setHeight((short) 450);
								sheet.setColumnWidth(cellDetailNo, 6000);
								Cell cellDetail = rowData.createCell(cellDetailNo++);
								cellDetail.setCellStyle(headerStyle);
								cellDetail.setCellStyle(style);
								sheet.setColumnWidth(cellDetailNo, 4000);
								cellDetail.setCellValue(m.get("LAB_CODE") == null ? "" : m.get("LAB_CODE").toString());
								cellDetail = rowData.createCell(cellDetailNo++);
								cellDetail.setCellStyle(headerStyle);
								cellDetail.setCellStyle(style);
								sheet.setColumnWidth(cellDetailNo, 4000);
								cellDetail.setCellValue(m.get("SEND_REQT_ID") == null ? "" : m.get("SEND_REQT_ID").toString());
								productCodeStr = m.get("PRODUCT_CODE") ==null ?"" : m.get("PRODUCT_CODE").toString().trim();
								//logger.info(" productCodeStr : {}",productCodeStr);
								if("LZ9045".equals(productCodeStr)||"HITEC6421".equals(productCodeStr)) {
									cellDetail = rowData.createCell(cellDetailNo++);
									cellDetail.setCellStyle(headerStyle);
									cellDetail.setCellStyle(style);
									sheet.setColumnWidth(cellDetailNo, 4000);
									cellDetail.setCellValue(m.get("ADTV_LOT_NO") == null ? "" : m.get("ADTV_LOT_NO").toString());
								}else if("00005".equals(m.get("SAMPLE_TYPE").toString()) || "00007".equals(m.get("SAMPLE_TYPE").toString())) {
									cellDetail = rowData.createCell(cellDetailNo++);
									cellDetail.setCellStyle(headerStyle);
									cellDetail.setCellStyle(style);
									sheet.setColumnWidth(cellDetailNo, 4000);
									cellDetail.setCellValue(m.get("RETURNR_DESC") == null ? "" : m.get("RETURNR_DESC").toString());
								}else if("00004".equals(m.get("SAMPLE_TYPE").toString())) {
									cellDetail = rowData.createCell(cellDetailNo++);
									cellDetail.setCellStyle(headerStyle);
									cellDetail.setCellStyle(style);
									sheet.setColumnWidth(cellDetailNo, 4000);
									cellDetail.setCellValue(m.get("SAMPLE_TYPEC_DESC") == null ? "" : m.get("SAMPLE_TYPEC_DESC").toString());
								}else if("00002".equals(m.get("SAMPLE_TYPE").toString())||"00008".equals(m.get("SAMPLE_TYPE").toString())||"00009".equals(m.get("SAMPLE_TYPE").toString())) {
									cellDetail = rowData.createCell(cellDetailNo++);
									cellDetail.setCellStyle(headerStyle);
									cellDetail.setCellStyle(style);
									sheet.setColumnWidth(cellDetailNo, 4000);
									cellDetail.setCellValue(m.get("BOAT_NO") == null ? "" : m.get("BOAT_NO").toString());
								}else if("00003".equals(m.get("SAMPLE_TYPE").toString())) {
									cellDetail = rowData.createCell(cellDetailNo++);
									cellDetail.setCellStyle(headerStyle);
									cellDetail.setCellStyle(style);
									sheet.setColumnWidth(cellDetailNo, 4000);
									cellDetail.setCellValue(m.get("METER_NO") == null ? "" : m.get("METER_NO").toString());
								}else if("00001".equals(m.get("SAMPLE_TYPE").toString())||"00010".equals(m.get("SAMPLE_TYPE").toString())) {
									if("100000041".equals(m.get("PRODUCT_ID").toString()) || "Y".equals(m.get("MANUAL_TYPE").toString())) {
										cellDetail = rowData.createCell(cellDetailNo++);
										cellDetail.setCellStyle(headerStyle);
										cellDetail.setCellStyle(style);
										sheet.setColumnWidth(cellDetailNo, 4000);
										cellDetail.setCellValue(m.get("SAMPLE_TYPEC_DESC") == null ? "" : m.get("SAMPLE_TYPEC_DESC").toString());
									}else {
										cellDetail = rowData.createCell(cellDetailNo++);
										cellDetail.setCellStyle(headerStyle);
										cellDetail.setCellStyle(style);
										sheet.setColumnWidth(cellDetailNo, 4000);
										cellDetail.setCellValue(m.get("PO_NO") == null ? "" : m.get("PO_NO").toString());
									}
										
								}else {
									cellDetail = rowData.createCell(cellDetailNo++);
									cellDetail.setCellStyle(headerStyle);
									cellDetail.setCellStyle(style);
									sheet.setColumnWidth(cellDetailNo, 4000);
									cellDetail.setCellValue(m.get("SAMPLE_TYPEC_DESC") == null ? "" : m.get("SAMPLE_TYPEC_DESC").toString());	
								}
								
								cellDetail = rowData.createCell(cellDetailNo++);
								cellDetail.setCellStyle(headerStyle);
								cellDetail.setCellStyle(style);
								sheet.setColumnWidth(cellDetailNo, 4000);
								cellDetail.setCellValue(m.get("RAN_CREATE_DATE_SAMPLE").toString() == null ? "" : m.get("RAN_CREATE_DATE_SAMPLE").toString());
								cellDetail = rowData.createCell(cellDetailNo++);
								cellDetail.setCellStyle(headerStyle);
								cellDetail.setCellStyle(style);
								sheet.setColumnWidth(cellDetailNo, 4000);
								cellDetail.setCellValue(m.get("DTS_CREATE_DATE") == null ? "" : m.get("DTS_CREATE_DATE").toString());
								
								if("LZ9045".equals(productCodeStr)||"HITEC6421".equals(productCodeStr)) {
									cellDetail = rowData.createCell(cellDetailNo++);
									cellDetail.setCellStyle(headerStyle);
									cellDetail.setCellStyle(style);
									sheet.setColumnWidth(cellDetailNo, 4000);
									cellDetail.setCellValue(m.get("PRODUCT_CODE") == null ? "" : m.get("PRODUCT_CODE").toString());
								}else {
									cellDetail = rowData.createCell(cellDetailNo++);
									cellDetail.setCellStyle(headerStyle);
									cellDetail.setCellStyle(style);
									sheet.setColumnWidth(cellDetailNo, 4000);
									cellDetail.setCellValue(m.get("PRODUCT_NAME") == null ? "-" : m.get("PRODUCT_NAME").toString());
								}
								
								if("LZ9045".equals(productCodeStr)||"HITEC6421".equals(productCodeStr)) {
									cellDetail = rowData.createCell(cellDetailNo++);
									cellDetail.setCellStyle(headerStyle);
									cellDetail.setCellStyle(style);
									sheet.setColumnWidth(cellDetailNo, 4000);
									cellDetail.setCellValue(m.get("SAMPLE_POINT_DESC") == null ? "" : m.get("SAMPLE_POINT_DESC").toString());
								}else if("00005".equals(m.get("SAMPLE_TYPE").toString()) || "00007".equals(m.get("SAMPLE_TYPE").toString())) {
									cellDetail = rowData.createCell(cellDetailNo++);
									cellDetail.setCellStyle(headerStyle);
									cellDetail.setCellStyle(style);
									sheet.setColumnWidth(cellDetailNo, 4000);
									cellDetail.setCellValue(m.get("SAMPLE_POINT_DESC") == null ? "" : m.get("SAMPLE_POINT_DESC").toString());
								}else if("00004".equals(m.get("SAMPLE_TYPE").toString())) {
									cellDetail = rowData.createCell(cellDetailNo++);
									cellDetail.setCellStyle(headerStyle);
									cellDetail.setCellStyle(style);
									sheet.setColumnWidth(cellDetailNo, 4000);
									cellDetail.setCellValue(m.get("TANK_NO") == null ? "" : m.get("TANK_NO").toString());
								}else if("00001".equals(m.get("SAMPLE_TYPE").toString()) || "00003".equals(m.get("SAMPLE_TYPE").toString())|| "00010".equals(m.get("SAMPLE_TYPE").toString())) {
									cellDetail = rowData.createCell(cellDetailNo++);
									cellDetail.setCellStyle(headerStyle);
									cellDetail.setCellStyle(style);
									sheet.setColumnWidth(cellDetailNo, 4000);
									String cellValC_Truck = m.get("CAR_NO") == null ? "" : m.get("CAR_NO").toString();
									cellValC_Truck += m.get("CAR_SLOT") == null ? "" : "/".concat(m.get("CAR_SLOT").toString());
									cellDetail.setCellValue(cellValC_Truck);
								}else if("00002".equals(m.get("SAMPLE_TYPE").toString())||"00008".equals(m.get("SAMPLE_TYPE").toString())||"00009".equals(m.get("SAMPLE_TYPE").toString())) {
									cellDetail = rowData.createCell(cellDetailNo++);
									cellDetail.setCellStyle(headerStyle);
									cellDetail.setCellStyle(style);
									sheet.setColumnWidth(cellDetailNo, 4000);
									cellDetail.setCellValue(m.get("BOAT_NAME") == null ? "" : m.get("BOAT_NAME").toString());
								}else {
									cellDetail = rowData.createCell(cellDetailNo++);
									cellDetail.setCellStyle(headerStyle);
									cellDetail.setCellStyle(style);
									sheet.setColumnWidth(cellDetailNo, 4000);
									cellDetail.setCellValue(m.get("TANK_NO") == null ? "-" : m.get("TANK_NO").toString());
								}
						
								cellDetail = rowData.createCell(cellDetailNo++);
								cellDetail.setCellStyle(headerStyle);
								cellDetail.setCellStyle(style);
								sheet.setColumnWidth(cellDetailNo, 4000);

								cellDetail.setCellValue(m.get("REPORT_DATE_LTR").toString() == null ? "" : m.get("REPORT_DATE_LTR").toString());
								cellDetail = rowData.createCell(cellDetailNo++);
								cellDetail.setCellStyle(headerStyle);
								cellDetail.setCellStyle(style);
								sheet.setColumnWidth(cellDetailNo, 4000);
								cellDetail.setCellValue(m.get("report_no").toString() == null ? "" : m.get("report_no").toString());
								cellDetail = rowData.createCell(cellDetailNo++);
								cellDetail.setCellStyle(headerStyle);
								cellDetail.setCellStyle(style);
								sheet.setColumnWidth(cellDetailNo, 4000);
								cellDetail.setCellValue(m.get("PLANT_NAME").toString() == null ? "" : m.get("PLANT_NAME").toString());
							}
						}

						}
						
						for (Map<String, Object> m : resultListDataDetail) {
							//countRemarkAppove = 0;
							if (mapProductName.get("PRODUCT_ID").toString().equals(m.get("PRODUCT_ID").toString())) {
								if (labCode[i].equalsIgnoreCase(m.get("LAB_CODE").toString())) {
									
										for (Map<String, Object> mapDetail : dataListLTR) {
											sheet.setColumnWidth(cellDetailNo, 2500);
											//logger.info("check item name :{},{}",mapDetail.get("ITEM_NAME").toString(),m.get("ITEM_NAME").toString());
											
											if (mapDetail.get("ITEM_ID").toString().equals(m.get("ITEM_ID").toString()) 
													&& mapDetail.get("PRODUCT_ID").toString().equals(m.get("PRODUCT_ID").toString())) {
												
												if("Y".equals(m.get("STATUS_FLAG").toString())) {
													Cell cellDetail = rowData.createCell(cellDetailNo++);
													cellDetail.setCellStyle(style);
													checkDataExcelTools(cellDetail,m);
												}else if("U".equals(m.get("STATUS_FLAG").toString())){
													Cell cellDetail = rowData.createCell(cellDetailNo++);
													cellDetail.setCellStyle(style);
													checkDataExcelTools(cellDetail,m);
												}else {
													Cell cellDetail = rowData.createCell(cellDetailNo++);
													cellDetail.setCellStyle(styleRed);
													checkDataExcelTools(cellDetail,m);
												
												}
													
											}else {
												
											}
										}

									}
								}
						}

						cellDetailNo = 0;
					}
					//get Approve By
//					List<Map<String, Object>> listApproveBy = reportLTRDao.getApproveByAndRemark(labCode);
					//logger.info("listApproveBy : {}",listApproveBy.size());
					// write data ApproveBy and Remark 
//					int rowDetailApproveBy = 4;
//				
//					logger.info("size countRemarkAppove : {}",countRemarkAppove);
//					for (int i = 0; i < labCode.length; i++) {
//						for(Map<String,Object> m : listApproveBy) {
//							logger.info("labCode[i] : {}",labCode[i]);
//							logger.info("m.get(\"LAB_CODE\") : {}",m.get("LAB_CODE").toString());
//							logger.info("mapProductName.get(\"PRODUCT_ID\") :{}",mapProductName.get("PRODUCT_ID").toString());
							//logger.info("m.get(\"PRODUCT_ID\").toString() :{}",m.get("PRODUCT_ID").toString());
//							if(mapProductName.get("PRODUCT_ID").toString().equals(m.get("PRODUCT_ID").toString())){
//							logger.info("mapProductName.get(\"PRODUCT_ID\") :{}",mapProductName.get("PRODUCT_ID").toString());
//							logger.info("m.get(\"PRODUCT_ID\").toString() :{}",m.get("PRODUCT_ID").toString());
//								if (labCode[i].equalsIgnoreCase(m.get("LAB_CODE").toString())) {
									//logger.info("===========================================");
//									Integer cellApproveIndex = countRemarkAppove+10;
									//logger.info("row Detail :{}",rowDetailApproveBy);
//									Row rowApprove = sheet.getRow(rowDetailApproveBy);
									//logger.info("rowApprove : {}",rowApprove);
//									Cell cellApprove = rowApprove.createCell(cellApproveIndex++);
//									if("00003".equals(m.get("SAMPLE_TYPE").toString())) {
//										if("ผ่านแบบมีเงื่อนไข".equals(m.get("RESULT_FLAG").toString())) {
//											cellApprove.setCellValue("ผ่าน");
//										}else {
//											cellApprove.setCellValue(m.get("RESULT_FLAG").toString());	
//										}
//										
//									}else {
//										cellApprove.setCellValue(m.get("RESULT_FLAG").toString());
//									}
//									
//									cellApprove.setCellStyle(style);
//									
//									Row rowRemark = sheet.getRow(rowDetailApproveBy);
//									Cell cellRemark  = rowRemark.createCell(cellApproveIndex++);
//									cellRemark.setCellValue(m.get("APPROVE_BY").toString());
//									cellRemark.setCellStyle(style);
//									
//									Row rowRootcause = sheet.getRow(rowDetailApproveBy);
//									Cell cellrootcause  = rowRootcause.createCell(cellApproveIndex);
//									cellrootcause.setCellValue(m.get("RTDESC")==null?"":m.get("RTDESC").toString());
//									cellrootcause.setCellStyle(style);
//									
//									rowDetailApproveBy ++;
//								
//								}
//							}
//						}
//					}
				}
					return wb;
				}catch(Exception e){
					logger.error("Exception : {}",e);
					throw new RuntimeException(e.getMessage());
				}
	}
}
