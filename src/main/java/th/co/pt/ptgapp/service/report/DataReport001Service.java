package th.co.pt.ptgapp.service.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import th.co.pt.ptgapp.dao.task.*;
import th.co.pt.ptgapp.entity.MBReportData;
import th.co.pt.ptgapp.entity.report.PerformanceOil;
import th.co.pt.ptgapp.entity.report.ReportAudit;
import th.co.pt.ptgapp.entity.report.ReportAuditOil;
import th.co.pt.ptgapp.entity.report.ReportOilStation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("dataReport001Service")
public class DataReport001Service {

    @Autowired
    private ReportAuditOliDao reportAuditOliDao;

    @Autowired
    private ReportAuditDao reportAuditDao;

    @Autowired
    private ReportReceiveOilDao reportReceiveOilDao;

    @Autowired
    private ReportOilStationDao reportOilStationDao;

    public List<ReportAuditOil> listReportAuditOilPTC(String sDate,String eDate,String trip){
        List<ReportAuditOil> listReportAuditOil = new ArrayList<>();
        ReportAuditOil reportAuditOil1 = new ReportAuditOil();
        List<ReportAuditOliDto> smap = reportAuditOliDao.getTotalStation();
        List<ReportAuditOliDto> pmap = reportAuditOliDao.getTotalTripByCondition(sDate,eDate,trip);
        reportAuditOil1.setCategory("PTC");
        for(ReportAuditOliDto report : smap) {
            if(report.getStationType().equalsIgnoreCase("PTC")) {
                reportAuditOil1.setTotal(report.getTotals());
            }
        }
        for(ReportAuditOliDto report : pmap) {
            if(report.getStationType().equalsIgnoreCase("PTC")) {
                reportAuditOil1.setNum(report.getTotals());
            }
        }
        listReportAuditOil.add(reportAuditOil1);
        return listReportAuditOil;

    }

    public List<ReportAuditOil> listReportAuditOilPTF(String sDate,String eDate,String trip){
        List<ReportAuditOil> listReportAuditOil = new ArrayList<>();
        ReportAuditOil reportAuditOil1 = new ReportAuditOil();
        List<ReportAuditOliDto> smap = reportAuditOliDao.getTotalStation();
        List<ReportAuditOliDto> pmap = reportAuditOliDao.getTotalTripByCondition(sDate,eDate,trip);
        reportAuditOil1.setCategory("PTF");
        for(ReportAuditOliDto report : smap) {
            if(report.getStationType().equalsIgnoreCase("PTF")) {
                reportAuditOil1.setTotal(report.getTotals());
            }
        }
        for(ReportAuditOliDto report : pmap) {
            if(report.getStationType().equalsIgnoreCase("PTF")) {
                reportAuditOil1.setNum(report.getTotals());
            }
        }
        listReportAuditOil.add(reportAuditOil1);
        return listReportAuditOil;

    }

    public List<ReportAudit> listReportAuditPTC(String sDate,String eDate,String trip){
        List<ReportAudit> listReportAudit = new ArrayList<ReportAudit>();
        List<ReportAuditDto> allList = reportAuditDao.getAllResultTripByCondition(sDate,eDate,trip,"PTC");
        List<ReportAuditDto> yList = reportAuditDao.getYResultTripByCondition(sDate,eDate,trip,"PTC");
        for(ReportAuditDto all:allList){
            List<ReportAuditDto> ytemp = yList.stream().filter(e->e.getPlant().equalsIgnoreCase(all.getPlant())).collect(Collectors.toList());
            if(!StringUtils.isEmpty(ytemp) && all.getTotal() != 0) {
                ReportAuditDto audit = ytemp.get(0);
                BigDecimal perc = new BigDecimal(audit.getTotal()).multiply(new BigDecimal(100));
                perc = perc.divide(new BigDecimal(all.getTotal()),2,RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
                ReportAudit reportAudit = new ReportAudit(all.getPlant(), all.getTotal(), audit.getTotal(), perc.doubleValue());
                listReportAudit.add(reportAudit);
            }else {
                ReportAudit reportAudit = new ReportAudit();
                reportAudit.setCategory(all.getPlant());
                listReportAudit.add(reportAudit);
            }
        }
        return listReportAudit;

    }

    public List<ReportAudit> listReportAuditPTF(String sDate,String eDate,String trip){
        List<ReportAudit> listReportAudit = new ArrayList<ReportAudit>();
        List<ReportAuditDto> allList = reportAuditDao.getAllResultTripByCondition(sDate,eDate,trip,"PTF");
        List<ReportAuditDto> yList = reportAuditDao.getYResultTripByCondition(sDate,eDate,trip,"PTF");
        for(ReportAuditDto all:allList){
            List<ReportAuditDto> ytemp = yList.stream().filter(e->e.getPlant().equalsIgnoreCase(all.getPlant())).collect(Collectors.toList());
            if(!StringUtils.isEmpty(ytemp) && all.getTotal() != 0) {
                ReportAuditDto audit = ytemp.get(0);
                BigDecimal perc = new BigDecimal(audit.getTotal()).multiply(new BigDecimal(100));
                perc = perc.divide(new BigDecimal(all.getTotal()),2,RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
                ReportAudit reportAudit = new ReportAudit(all.getPlant(), all.getTotal(), audit.getTotal(), perc.doubleValue());
                listReportAudit.add(reportAudit);
            }else {
                ReportAudit reportAudit = new ReportAudit();
                reportAudit.setCategory(all.getPlant());
                listReportAudit.add(reportAudit);
            }
        }
        return listReportAudit;

    }

    public List<ReportAudit> listReportAuditFranchisePTF(String sDate,String eDate,String trip){
        List<ReportAudit> listReportAudit = new ArrayList<ReportAudit>();
        List<ReportReceiveOilDto> rep1 =  reportReceiveOilDao.getFranchiseReceiveOil(sDate,eDate,trip,"1"); //ไม่รับน้ำมัน
        List<ReportReceiveOilDto> rep2 =  reportReceiveOilDao.getFranchiseReceiveOil(sDate,eDate,trip,"2"); //รับน้ำมัน
        for(ReportReceiveOilDto report:rep2){
            List<ReportReceiveOilDto> rep1Temp = rep1.stream().filter(e->e.getPlantReceive().equals(report.getPlantReceive())).collect(Collectors.toList());
            if(!StringUtils.isEmpty(rep1Temp) && report.getTotals()!=0){
                ReportReceiveOilDto temp = rep1Temp.get(0);
                BigDecimal perc = new BigDecimal(report.getTotals()).multiply(new BigDecimal(100));
                perc = perc.divide(new BigDecimal(report.getTotals()+temp.getTotals()),2, RoundingMode.HALF_UP);
                ReportAudit reportAudit1 = new ReportAudit(report.getPlantReceive(),report.getTotals()+temp.getTotals(),report.getTotals(),perc.doubleValue());
                listReportAudit.add(reportAudit1);
            }else{
                ReportAudit reportAudit1 = new ReportAudit(report.getPlantReceive(),report.getTotals(),0,-1);
                listReportAudit.add(reportAudit1);
            }
        }

//        ReportAudit reportAudit1 = new ReportAudit("CP",0,0,0);
//        ReportAudit reportAudit2 = new ReportAudit("KK",5,5,100);
//        ReportAudit reportAudit3 = new ReportAudit("LP",0,0,0);
//        ReportAudit reportAudit4 = new ReportAudit("MK",9,9,100);
//        ReportAudit reportAudit5 = new ReportAudit("NK",6,6,100);
//        ReportAudit reportAudit6 = new ReportAudit("NS",0,0,0);
//        ReportAudit reportAudit7 = new ReportAudit("PC",1,1,100);
//        ReportAudit reportAudit8 = new ReportAudit("PL",2,2,100);
//        ReportAudit reportAudit9 = new ReportAudit("SRI",10,10,100);
//        ReportAudit reportAudit10 = new ReportAudit("SU",0,0,0);
//        listReportAudit.add(reportAudit1);
//        listReportAudit.add(reportAudit2);
//        listReportAudit.add(reportAudit3);
//        listReportAudit.add(reportAudit4);
//        listReportAudit.add(reportAudit5);
//        listReportAudit.add(reportAudit6);
//        listReportAudit.add(reportAudit7);
//        listReportAudit.add(reportAudit8);
//        listReportAudit.add(reportAudit9);
//        listReportAudit.add(reportAudit10);

        return listReportAudit;

    }

    public List<ReportOilStation> listReportOilStation(String sDate,String eDate,String trip) {

    	String[] arr_date = eDate.split("/");
    	int year = Integer.parseInt(arr_date[2]);
        List<ReportOilStation> listReportOilStation = new ArrayList<ReportOilStation>();
        
        List<ReportOilStationDto> allList1 = reportOilStationDao.getOilStation(Integer.toString(year));
        List<ReportOilStationDto> allList2 = reportOilStationDao.getOilStation(Integer.toString(year-1));
        List<ReportOilStationDto> allList3 = reportOilStationDao.getOilStation(Integer.toString(year-2));

        for(ReportOilStationDto report:allList1){
            List<ReportOilStationDto> rep2Temp = allList2.stream().filter(e->e.getTypeStation().equals(report.getTypeStation())).collect(Collectors.toList());
            List<ReportOilStationDto> rep3Temp = allList3.stream().filter(e->e.getTypeStation().equals(report.getTypeStation())).collect(Collectors.toList());
            if(!StringUtils.isEmpty(rep2Temp) && !StringUtils.isEmpty(rep3Temp) && report.getTotals()!=0){
            	ReportOilStationDto temp = rep2Temp.get(0);
            	ReportOilStationDto temp2 = rep3Temp.get(0);
            	ReportOilStation reportAudit1 = new ReportOilStation(report.getTypeStation(),report.getTotals(),temp.getTotals(),temp2.getTotals(),report.getYears(),temp.getYears(),temp2.getYears());
                listReportOilStation.add(reportAudit1);
            }else{
            	ReportOilStation reportAudit1 = new ReportOilStation(report.getTypeStation(),0,0,0,"","","");
                listReportOilStation.add(reportAudit1);
            }
        }
        /*
        
        ReportOilStation reportOilStation1 = new ReportOilStation("PTC","2562",179);
        ReportOilStation reportOilStation2 = new ReportOilStation("PTC","2561",1432);
        ReportOilStation reportOilStation3 = new ReportOilStation("PTC","2560",1350);

        ReportOilStation reportOilStation4 = new ReportOilStation("PTF","2562",8);
        ReportOilStation reportOilStation5 = new ReportOilStation("PTF","2561",140);
        ReportOilStation reportOilStation6 = new ReportOilStation("PTF","2560",125);


        listReportOilStation.add(reportOilStation1);
        listReportOilStation.add(reportOilStation2);
        listReportOilStation.add(reportOilStation3);
        listReportOilStation.add(reportOilStation4);
        listReportOilStation.add(reportOilStation5);
        listReportOilStation.add(reportOilStation6);
*/
        return listReportOilStation;
    }
    
    public List<ReportAudit> listReportAuditPTCPlace(String sDate,String eDate,String trip){
        List<ReportAudit> listReportAudit = new ArrayList<ReportAudit>();
        List<ReportAuditDto> allList = reportAuditDao.getAllResultTripByConditionPlace(sDate,eDate,trip,"PTC");
        List<ReportAuditDto> yList = reportAuditDao.getYResultTripByConditionPlace(sDate,eDate,trip,"PTC");
        for(ReportAuditDto all:allList){
            List<ReportAuditDto> ytemp = yList.stream().filter(e->e.getPlant().equalsIgnoreCase(all.getPlant())).collect(Collectors.toList());
            if(!StringUtils.isEmpty(ytemp) && all.getTotal() != 0) {
                ReportAuditDto audit = ytemp.get(0);
                BigDecimal perc = new BigDecimal(audit.getTotal()).multiply(new BigDecimal(100));
                perc = perc.divide(new BigDecimal(all.getTotal()),2, RoundingMode.HALF_UP);
                ReportAudit reportAudit = new ReportAudit(all.getPlant(), all.getTotal(), audit.getTotal(), perc.doubleValue());
                listReportAudit.add(reportAudit);
            }else {
                ReportAudit reportAudit = new ReportAudit();
                reportAudit.setCategory(all.getPlant());
                listReportAudit.add(reportAudit);
            }
        }
        return listReportAudit;

    }
    
    public List<ReportAudit> listReportAudit(String sDate,String eDate,String trip,String company){
        List<ReportAudit> listReportAudit = new ArrayList<ReportAudit>();
        List<ReportAuditDto> allList = reportAuditDao.getAllResultTripByCondition(sDate,eDate,trip,company);
        List<ReportAuditDto> yList = reportAuditDao.getYResultTripByCondition(sDate,eDate,trip,company);
        for(ReportAuditDto all:allList){
            List<ReportAuditDto> ytemp = yList.stream().filter(e->e.getPlant().equalsIgnoreCase(all.getPlant())).collect(Collectors.toList());
            if(!StringUtils.isEmpty(ytemp) && all.getTotal() != 0) {
                ReportAuditDto audit = ytemp.get(0);
                BigDecimal perc = new BigDecimal(audit.getTotal()).multiply(new BigDecimal(100));
                perc = perc.divide(new BigDecimal(all.getTotal()),2,RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP);
                ReportAudit reportAudit = new ReportAudit(all.getPlant(), all.getTotal(), audit.getTotal(), perc.doubleValue());
                listReportAudit.add(reportAudit);
            }else {
                ReportAudit reportAudit = new ReportAudit();
                reportAudit.setCategory(all.getPlant());
                listReportAudit.add(reportAudit);
            }
        }
        return listReportAudit;

    }
    public List<ReportAudit> listReportAuditPTCPlaceV2(String sDate,String eDate,String trip,String company){
        List<ReportAudit> listReportAudit = new ArrayList<ReportAudit>();
        List<ReportAuditDto> allList = reportAuditDao.getAllResultTripByConditionPlace(sDate,eDate,trip,company);
        List<ReportAuditDto> yList = reportAuditDao.getYResultTripByConditionPlace(sDate,eDate,trip,company);
        for(ReportAuditDto all:allList){
            List<ReportAuditDto> ytemp = yList.stream().filter(e->e.getPlant().equalsIgnoreCase(all.getPlant())).collect(Collectors.toList());
            if(!StringUtils.isEmpty(ytemp) && all.getTotal() != 0) {
                ReportAuditDto audit = ytemp.get(0);
                BigDecimal perc = new BigDecimal(audit.getTotal()).multiply(new BigDecimal(100));
                perc = perc.divide(new BigDecimal(all.getTotal()),2, RoundingMode.HALF_UP);
                ReportAudit reportAudit = new ReportAudit(all.getPlant(), all.getTotal(), audit.getTotal(), perc.doubleValue());
                reportAudit.setSeries("GRAPH");
                listReportAudit.add(reportAudit);
            }else {
                ReportAudit reportAudit = new ReportAudit();
                reportAudit.setCategory(all.getPlant());
                reportAudit.setSeries("GRAPH");
                listReportAudit.add(reportAudit);
            }
        }
        return listReportAudit;

    }
    

    public List<ReportAudit> listReportAuditV2(String sDate,String eDate,String trip){
        List<ReportAudit> listReportAudit = new ArrayList<ReportAudit>();
        List<Map<String, Object>> allList = reportAuditDao.getMBProduct();
        List<Map<String, Object>> yList = reportAuditDao.getMBProductResult(trip,sDate,eDate);
        for(Map<String, Object> m:allList){

                ReportAudit reportAudit = new ReportAudit();
                reportAudit.setSeries("GRAPH");
                reportAudit.setCategory(m.get("PRODUCT_CODE").toString());
                for(Map<String, Object> m2:yList) {
                	if(m.get("PRODUCT_CODE").toString().equals(m2.get("PRODUCT_CODE").toString())) {
                		reportAudit.setNum(Integer.parseInt(m2.get("TOTALS").toString()));
                		break;
                	}
                }
                listReportAudit.add(reportAudit);
        }
        
        return listReportAudit;

  }
    
    public Map<String, Object> listMBResultTest(String company,String trip){
        List<Map<String, Object>> listMBResult = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> params = new HashMap<String, Object>();
        List<Map<String, Object>> yList = reportAuditDao.getMBResultTest(trip,company);
        int countP_pass=0,countP_fail=0,countA_pass=0,countA_fail=0;
       
       
        for(Map<String, Object> m:yList){
        			
        	if(0<Double.parseDouble(m.get("SCORE_GENERAL").toString().equals("-")?"0":m.get("SCORE_GENERAL").toString())) {
        		if(Double.parseDouble(m.get("SCORE_GENERAL").toString())<80) {
        			countP_fail++;
        		}else {
        			countP_pass++;
        		}
        	}
        	
        	if(0<Double.parseDouble(m.get("SCORE_API").toString().equals("-")?"0":m.get("SCORE_API").toString())&&0<Double.parseDouble(m.get("SCORE_ETHANOL").toString().equals("-")?"0":m.get("SCORE_ETHANOL").toString())) {
            	
            		if(Double.parseDouble(m.get("SCORE_API").toString())<80||Integer.parseInt(m.get("SCORE_ETHANOL").toString())<80) {
            			countA_fail++;
            		}else {
            			countA_pass++;
            		}
            	
        	}
                
        }
        
        if(countP_fail==0&&countP_pass==0) {
        	map.put("series", "GRAPH");
        	map.put("name", "A");
        	map.put("unit", Double.valueOf(0));
        	listMBResult.add(map);
        	map = new HashMap<String, Object>();
        	map.put("series","GRAPH");
        	map.put("name", "B");
        	map.put("unit", Double.valueOf(0));
        	listMBResult.add(map);
        	map = new HashMap<String, Object>();
        	map.put("series","GRAPH");
        	map.put("name", "C");
        	map.put("unit", Double.valueOf(0));
        	listMBResult.add(map);
        	map = new HashMap<String, Object>();
        }else {
        	double result=0;
        	result=((double)(countP_fail+countP_pass)/(double)yList.size())*100;
        	map.put("series","GRAPH");
        	map.put("name", "A");
        	map.put("unit",  (double)Math.round(result));
        	listMBResult.add(map);
        	map = new HashMap<String, Object>();
        	result=((double)countP_pass/(double)(countP_fail+countP_pass))*100;
        	map.put("series", "GRAPH");
        	map.put("name", "B");
        	map.put("unit", (double)Math.round(result));
        	listMBResult.add(map);
        	map = new HashMap<String, Object>();
        	result=((double)countP_fail/(double)(countP_fail+countP_pass))*100;
        	map.put("series", "GRAPH");
        	map.put("name", "C");
        	map.put("unit",(double)Math.round(result));
        	listMBResult.add(map);
        }
        
        params.put("CHOICE_EXAMPLE_DATASET",new JRBeanCollectionDataSource(listMBResult));
        listMBResult=new ArrayList<Map<String,Object>>();
        map = new HashMap<String, Object>();
        if(countA_fail==0&&countA_pass==0) {
        	map.put("series", "GRAPH");
        	map.put("name", "A");
        	map.put("unit",Double.valueOf(0));
        	listMBResult.add(map);
        	map = new HashMap<String, Object>();
        	map.put("series","GRAPH");
        	map.put("name", "B");
        	map.put("unit",Double.valueOf(0));
        	listMBResult.add(map);
        	map = new HashMap<String, Object>();
        	map.put("series","GRAPH");
        	map.put("name", "C");
        	map.put("unit", Double.valueOf(0));
        	listMBResult.add(map);
        	map = new HashMap<String, Object>();
        }else {
        	double result=0;
        	result=((double)(countA_fail+countA_pass)/(double)yList.size())*100;
        	map.put("series","GRAPH");
        	map.put("name", "A");
        	map.put("unit", (double) Math.round(result));
        	listMBResult.add(map);
        	map = new HashMap<String, Object>();
        	result=((double)countA_pass/(double)(countP_fail+countP_pass))*100;
        	map.put("series", "GRAPH");
        	map.put("name", "B");
        	map.put("unit",(double)Math.round(result));
        	listMBResult.add(map);
        	map = new HashMap<String, Object>();
        	result=((double)countA_fail/(double)(countP_fail+countP_pass))*100;
        	map.put("series", "GRAPH");
        	map.put("name", "C");
        	map.put("unit",(double)Math.round(result) );
        	listMBResult.add(map);
        	map = new HashMap<String, Object>();
        }
      
    	params.put("PRACTICE_EXAMPLE_DATASET",new JRBeanCollectionDataSource(listMBResult));
        return params;

  }

	public List<Map<String, Object>> listWrongTool(String trip,String company) {
		 List<Map<String, Object>> res =null;
		 List<Map<String, Object>> result =null;
		 Map<String,Object> map  =null;
		 String area ="";
		 String tools="";
		 String station="";
	
		try {
			map = new HashMap<String, Object>();
			result = new ArrayList<>();
			res=reportAuditDao.getMBBreakdown(trip,company);
			//fileter data
			for(int i=0;i<res.size();i++) {
				if(i==0) {
					area=res.get(i).get("PLACE").toString();
					tools=res.get(i).get("TOOLS_NAME").toString()+" "+res.get(i).get("REMARK").toString()+"| "+res.get(i).get("total").toString()+",";
					station=res.get(i).get("CENTER_NAME").toString();
				}else {
						
					if(station.equals(res.get(i).get("CENTER_NAME").toString())) {
						tools+=res.get(i).get("TOOLS_NAME").toString()+" "+res.get(i).get("REMARK").toString()+"| "+res.get(i).get("total").toString()+",";
						if(i==(res.size()-1)) {
							tools=tools.substring(0,tools.length()-1);
							map.put("station", station);
							map.put("area", area);
							map.put("tool_des", tools);
							result.add(map);
						}
					}else{
						tools=tools.substring(0,tools.length()-1);
						map.put("station", station);
						map.put("area", area);
						map.put("tool_des", tools);
						result.add(map);
						
						map=new HashMap<String, Object>();
						area=res.get(i).get("PLACE").toString();
						tools=res.get(i).get("TOOLS_NAME").toString()+" "+res.get(i).get("REMARK").toString()+"| "+res.get(i).get("total").toString()+",";
						station=res.get(i).get("CENTER_NAME").toString();
						if(i==(res.size()-1)) {
							tools=tools.substring(0,tools.length()-1);
							map.put("station", station);
							map.put("area", area);
							map.put("tool_des", tools);
							result.add(map);
						}
						
					}
					
					
				}
				
			}
			
			if(res.size()>0&&result.size()==0) {
				tools=tools.substring(0,tools.length()-1);
				map.put("station", station);
				map.put("area", area);
				map.put("tool_des", tools);
				result.add(map);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Map<String, Object>> getMBDateBetween(String tripid) {
		List<Map<String, Object>> result =null;
		try {
			result=reportAuditDao.getMBDateBetweenDao(tripid);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Map<String, Object>> getMBGroupProvince(String tripid) {
		List<Map<String, Object>> result =null;
		try {
			result=reportAuditDao.getMBGroupProvinceDao(tripid);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Map<String, Object>> getMBGroupPlant(String tripid) {
		List<Map<String, Object>> result =null;
		try {
			result=reportAuditDao.getMBGroupPlantDao(tripid);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}



	public List<Map<String, Object>> getMBListScheduleOil(String tripid,String station) {
		List<Map<String, Object>> result =null;
		try {
			result=reportAuditDao.getMBListScheduleOilDao(tripid,station);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Map<String, Object>> getMBListReceiveOil(String tripid,String station) {
		List<Map<String, Object>> result =null;
		try {
			result=reportAuditDao.getMBListReceiveOilDao(tripid,station);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public List<Map<String, Object>> saveListReceive(MBReportData mbReportData) {
		List<Map<String, Object>> result =null;
		try {
			result=reportAuditDao.saveListReceiveDao(mbReportData);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Map<String, Object>> updateNCRNo(MBReportData mbReportData) {
		List<Map<String, Object>> result =null;
		try {
			result=reportAuditDao.updateNCRNo(mbReportData);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Map<String, Object>> saveListSchedule(MBReportData mbReportData) {
		List<Map<String, Object>> result =null;
		try {
			result=reportAuditDao.saveListSchedule(mbReportData);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Map<String, String>> listAuditOil(String trip) {
		List<Map<String, String>> result =null;
		try {
			result=reportAuditDao.listAuditOil(trip);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Map<String, String>> listAuditNot(String trip,String company) {
		List<Map<String, String>> result =null;
		try {
			result=reportAuditDao.listAuditNot(trip,company);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<PerformanceOil> getReportAuditBytripId(String trip,String company) {
		List<Map<String, Object>> result =null;
		List<Map<String, Object>> resultTotal =null;
		List<PerformanceOil> performanceOilList =null;
		try {
			result=reportAuditDao.getReportAuditBytripId(trip,company);
			resultTotal=reportAuditDao.getReportAuditTotalBytripId(trip,company);
			performanceOilList=toPerformanceOilModel(result);
			performanceOilList=getPercentOil(performanceOilList,resultTotal);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return performanceOilList;
	}

	private List<PerformanceOil> getPercentOil(List<PerformanceOil> performanceOilList,List<Map<String, Object>> resultTotal) {
		
		for(PerformanceOil data:performanceOilList) {
			for(Map<String, Object> m:resultTotal) {
				if(m.get("PRODUCT_CODE").toString().equals(data.getName_unit())) {
					double resultSet =(data.getUnit()/Double.parseDouble(m.get("TOTALS").toString()))*100;
					data.setPercents(resultSet);
					break;
				}
			}
		}
		return performanceOilList;
	}

	public List<Map<String, Object>> getReportAuditNotBytripId(String trip) {
		List<Map<String, Object>> result =null;
		try {
			result=reportAuditDao.getReportAuditNotBytripId(trip);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Map<String, Object>> getWording(String trip) {
		List<Map<String, Object>> result =null;
		try {
			result=reportAuditDao.getWording(trip);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Map<String, Object>> getMBCreateDateHD(String trip) {
		List<Map<String, Object>> result =null;
		try {
			result=reportAuditDao.getMBCreateDateHD(trip);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public List<Map<String, Object>> deleteMBListReceive(String tripid, String station, String productcode) {
		List<Map<String, Object>> result =null;
		try {
			result=reportAuditDao.deleteMBListReceive(tripid,station,productcode);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Map<String, Object>> deleteMBListSchedule(String tripid, String station, String productcode) {
		List<Map<String, Object>> result =null;
		try {
			result=reportAuditDao.deleteMBListSchedule(tripid,station,productcode);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public  List<PerformanceOil> toPerformanceOilModel(List<Map<String, Object>> list) {
		PerformanceOil model =null;
		List<PerformanceOil> listModel = new ArrayList<PerformanceOil>();
		for(Map<String, Object>l:list) {
			model = new PerformanceOil();
			model.setName_unit(l.get("name_unit").toString());
			model.setSeries(l.get("series").toString());
			model.setUnit(Integer.parseInt(l.get("unit").toString()));
			listModel.add(model);
		}
		return listModel;
	}

	public List<PerformanceOil> getlistResultLite(String trip, String company) {
		List<Map<String, Object>>  result =null;
		List<Map<String, Object>>  resultotal =null;
		List<PerformanceOil> r =null;
		try {
			result=reportAuditDao.getlistResultLiteDao(trip,company);
			resultotal=reportAuditDao.getlistResultTotalLiteDao(trip,company);
			r=toLiteMobel(result);
			r=getPercentLite(r,resultotal);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	private List<PerformanceOil> getPercentLite(List<PerformanceOil> r, List<Map<String, Object>> resultotal) {

		for(PerformanceOil data:r) {
			for(Map<String, Object> m:resultotal) {
				if(m.get("PLACE").toString().equals(data.getName_unit())) {
					double resultSet =(data.getUnit()/Double.parseDouble(m.get("TOTALS").toString()))*100;
					data.setPercents(resultSet);
					break;
				}
			}
		}
		return r;
	}

	private List<PerformanceOil> toLiteMobel(List<Map<String, Object>> resultotal) {
		PerformanceOil model =null;
		List<PerformanceOil> listModel = new ArrayList<PerformanceOil>();
		for(Map<String, Object>l:resultotal) {
			model = new PerformanceOil();
			model.setName_unit(l.get("PLACE").toString());
			model.setUnit(Integer.parseInt(l.get("TOTALS").toString()));
			listModel.add(model);
		}
		return listModel;
	}

	public List<PerformanceOil> getlistSummaryTest(String trip, String company) {
		List<Map<String, Object>>  result =null;
		List<Map<String, Object>>  resultotal =null;
		List<PerformanceOil> r =null;
		try {
			result=reportAuditDao.getlistResultSummary(trip,company);
			resultotal=reportAuditDao.getlistResultTotalSummary(trip,company);
			r=getListSummary(result);
			r=getPercentSummaryTest(r,resultotal);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	private List<PerformanceOil> getPercentSummaryTest(List<PerformanceOil> r, List<Map<String, Object>> resultotal) {
		for(PerformanceOil data:r) {
			//for(Map<String, Object> m:resultotal) {
				//if(m.get("PLACE").toString().equals(data.getName_unit())) {
					double resultSet =(data.getUnit()/Double.parseDouble(resultotal.get(0).get("TOTALS").toString()))*100;
					data.setPercents(resultSet);
					//break;
				//}
			//}
		}
		return r;
	}

	//TYPENOTRAND
	public List<PerformanceOil> getListSummary(List<Map<String, Object>> resultotal){
		//List<PerformanceOil> listResult = new ArrayList<PerformanceOil>();
		List<PerformanceOil> listModel = getDetailTest();
		for(PerformanceOil m:listModel) {
			for(Map<String, Object> m2:resultotal) {
				if(m2.get("TYPENOTRAND").toString().equals(m.getSeries())) {
						m.setUnit(Integer.parseInt(m2.get("TOTALS").toString()));
					break;
				}
			}
		}
		return listModel;
	}

	private List<PerformanceOil> getDetailTest() {
		List<PerformanceOil> listModel = new ArrayList<PerformanceOil>();
		PerformanceOil model =new PerformanceOil();
		model.setName_unit("กำลังนับเงิน");
		model.setSeries("1");
		listModel.add(model);
		model =new PerformanceOil();
		model.setName_unit("ไปฝากเงิน");
		model.setSeries("2");
		listModel.add(model);
		
		model =new PerformanceOil();
		model.setName_unit("ติดธุระ/ไปทำธุระ");
		model.setSeries("3");
		listModel.add(model);
		model =new PerformanceOil();
		model.setName_unit("ผจก.ดูสองสาขา");
		model.setSeries("4");
		listModel.add(model);
		model =new PerformanceOil();
		model.setName_unit("กำลังลงน้ำมัน");
		model.setSeries("5");
		listModel.add(model);
		model =new PerformanceOil();
		model.setName_unit("ช่วยเต็มน้ำมัน");
		model.setSeries("6");
		listModel.add(model);
		model =new PerformanceOil();
		model.setName_unit("เข้าตรวจหลัง 17.00น.");
		model.setSeries("7");
		listModel.add(model);
		model =new PerformanceOil();
		model.setName_unit("ผจก.ลาหยุด");
		model.setSeries("8");
		listModel.add(model);

		model =new PerformanceOil();
		model.setName_unit("วันหยุด");
		model.setSeries("9");
		listModel.add(model);

		model =new PerformanceOil();
		model.setName_unit("ติดอบรม/ประชุม");
		model.setSeries("10");
		listModel.add(model);
		
		model =new PerformanceOil();
		model.setName_unit("ยังไม่มีผจก.ประจำ");
		model.setSeries("11");
		listModel.add(model);

		return listModel;
	}
	
	
}
