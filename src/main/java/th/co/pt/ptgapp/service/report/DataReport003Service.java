package th.co.pt.ptgapp.service.report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import th.co.pt.ptgapp.dao.task.ReportAuditResultDao;
import th.co.pt.ptgapp.dao.task.ReportAuditResultDto;
import th.co.pt.ptgapp.entity.report.ReportAuditResult;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("dataReport003Service")
public class DataReport003Service {
	
	Logger logger = LoggerFactory.getLogger(DataReport003Service.class);

    @Autowired
    private ReportAuditResultDao reportAuditResultDao;

    public List<ReportAuditResult> listReportAuditResultPTC(String sDate,String eDate,String trip){

        List<ReportAuditResult> listReportAuditResult = new ArrayList<ReportAuditResult>();
        
        
        List<ReportAuditResultDto> allList = reportAuditResultDao.getAuditResultAll("PTC",sDate,eDate,trip);
        List<ReportAuditResultDto> yList = reportAuditResultDao.getAuditResultN("PTC",sDate,eDate,trip);
        for(ReportAuditResultDto all:allList){
            List<ReportAuditResultDto> ytemp = yList.stream().filter(e->e.getStationType().equalsIgnoreCase(all.getStationType())).collect(Collectors.toList());
            if(!StringUtils.isEmpty(ytemp) && all.getTotals() != 0) {
            	logger.info(all.getStationType()+" "+all.getTotals());
            	ReportAuditResultDto audit = ytemp.get(0);

            	logger.info(audit.getStationType()+" "+audit.getTotals());
                BigDecimal perc = new BigDecimal(audit.getTotals()).multiply(new BigDecimal(100));
                perc = perc.divide(new BigDecimal(all.getTotals()),2, RoundingMode.HALF_UP);
                ReportAuditResult reportAudit = new ReportAuditResult(all.getStationType(), all.getTotals(), audit.getTotals(), perc.doubleValue());
                listReportAuditResult.add(reportAudit);
            }else {
            	ReportAuditResult reportAudit = new ReportAuditResult(all.getStationType(),all.getTotals(),0,-1);
                listReportAuditResult.add(reportAudit);
            }
        }
        return listReportAuditResult;
    }

    public List<ReportAuditResult> listReportAuditResultPTF(String sDate,String eDate,String trip){

        List<ReportAuditResult> listReportAuditResult = new ArrayList<ReportAuditResult>();

        List<ReportAuditResultDto> allList = reportAuditResultDao.getAuditResultAll("PTF",sDate,eDate,trip);
        List<ReportAuditResultDto> yList = reportAuditResultDao.getAuditResultN("PTF",sDate,eDate,trip);
        for(ReportAuditResultDto all:allList){
            List<ReportAuditResultDto> ytemp = yList.stream().filter(e->e.getStationType().equalsIgnoreCase(all.getStationType())).collect(Collectors.toList());
            if(!StringUtils.isEmpty(ytemp) && all.getTotals() != 0) {
            	ReportAuditResultDto audit = ytemp.get(0);
                BigDecimal perc = new BigDecimal(audit.getTotals()).multiply(new BigDecimal(100));
                perc = perc.divide(new BigDecimal(all.getTotals()),2, RoundingMode.HALF_UP);
                ReportAuditResult reportAudit = new ReportAuditResult(all.getStationType(), all.getTotals(), audit.getTotals(), perc.doubleValue());
                listReportAuditResult.add(reportAudit);
            }else {
            	ReportAuditResult reportAudit = new ReportAuditResult(all.getStationType(),all.getTotals(),0,-1);
                listReportAuditResult.add(reportAudit);
            }
        }
        return listReportAuditResult;

    }


    public List<ReportAuditResult> listReportAuditTestResult(String sDate,String eDate,String trip){

    	List<ReportAuditResult> listReportAuditResult = new ArrayList<ReportAuditResult>();

        List<ReportAuditResultDto> allList = reportAuditResultDao.getAuditResultAllStation("PTC",sDate,eDate,trip);
        List<ReportAuditResultDto> yList = reportAuditResultDao.getAuditResultLiter("PTC",sDate,eDate,trip);
        for(ReportAuditResultDto all:allList){
            List<ReportAuditResultDto> ytemp = yList.stream().filter(e->e.getStationType().equalsIgnoreCase(all.getStationType())).collect(Collectors.toList());
            if(!StringUtils.isEmpty(ytemp) && all.getTotals() != 0) {
            	ReportAuditResultDto audit = ytemp.get(0);
                BigDecimal perc = new BigDecimal(audit.getTotals()).multiply(new BigDecimal(100));
                perc = perc.divide(new BigDecimal(all.getTotals()),2, RoundingMode.HALF_UP);
                ReportAuditResult reportAudit = new ReportAuditResult(all.getStationType(), all.getTotals(), audit.getTotals(), perc.doubleValue());
                listReportAuditResult.add(reportAudit);
            }else {
            	ReportAuditResult reportAudit = new ReportAuditResult(all.getStationType(),all.getTotals(),0,-1);
                listReportAuditResult.add(reportAudit);
            }
        }
        return listReportAuditResult;

    }

    public List<ReportAuditResult> listReportAuditTrainingResult(String sDate,String eDate,String trip){

    	List<ReportAuditResult> listReportAuditResult = new ArrayList<ReportAuditResult>();

        List<ReportAuditResultDto> allList = reportAuditResultDao.getAuditResultAllStation("PTC",sDate,eDate,trip);
        List<ReportAuditResultDto> yList = reportAuditResultDao.getAuditResultScore("PTC",sDate,eDate,trip);
        for(ReportAuditResultDto all:allList){
            List<ReportAuditResultDto> ytemp = yList.stream().filter(e->e.getStationType().equalsIgnoreCase(all.getStationType())).collect(Collectors.toList());
            if(!StringUtils.isEmpty(ytemp) && all.getTotals() != 0) {
            	ReportAuditResultDto audit = ytemp.get(0);
                BigDecimal perc = new BigDecimal(audit.getTotals()).multiply(new BigDecimal(100));
                perc = perc.divide(new BigDecimal(all.getTotals()),2, RoundingMode.HALF_UP);
                ReportAuditResult reportAudit = new ReportAuditResult(all.getStationType(), all.getTotals(), audit.getTotals(), perc.doubleValue());
                listReportAuditResult.add(reportAudit);
            }else {
            	ReportAuditResult reportAudit = new ReportAuditResult(all.getStationType(),all.getTotals(),0,-1);
                listReportAuditResult.add(reportAudit);
            }
        }
        return listReportAuditResult;

    }
    
    public List<ReportAuditResult> listReportAuditResult(String sDate,String eDate,String trip,String company){

        List<ReportAuditResult> listReportAuditResult = new ArrayList<ReportAuditResult>();
        
        
        List<ReportAuditResultDto> allList = reportAuditResultDao.getAuditResultAll(company,sDate,eDate,trip);
        List<ReportAuditResultDto> yList = reportAuditResultDao.getAuditResultN(company,sDate,eDate,trip);
        for(ReportAuditResultDto all:allList){
            List<ReportAuditResultDto> ytemp = yList.stream().filter(e->e.getStationType().equalsIgnoreCase(all.getStationType())).collect(Collectors.toList());
            if(!StringUtils.isEmpty(ytemp) && all.getTotals() != 0) {
            	logger.info(all.getStationType()+" "+all.getTotals());
            	ReportAuditResultDto audit = ytemp.get(0);

            	logger.info(audit.getStationType()+" "+audit.getTotals());
                BigDecimal perc = new BigDecimal(audit.getTotals()).multiply(new BigDecimal(100));
                perc = perc.divide(new BigDecimal(all.getTotals()),2, RoundingMode.HALF_UP);
                ReportAuditResult reportAudit = new ReportAuditResult(all.getStationType(), all.getTotals(), audit.getTotals(), perc.doubleValue());
                listReportAuditResult.add(reportAudit);
            }else {
            	ReportAuditResult reportAudit = new ReportAuditResult(all.getStationType(),all.getTotals(),0,-1);
                listReportAuditResult.add(reportAudit);
            }
        }
        return listReportAuditResult;
    }

    
    public List<ReportAuditResult> listReportAuditResultV2(String sDate,String eDate,String trip,String company){
    	
        List<ReportAuditResult> listReportAuditResult = new ArrayList<ReportAuditResult>();
        List<Map<String,Object>> allList = reportAuditResultDao.getTotalBreakdown(company,trip);
        List<ReportAuditResultDto> yList = reportAuditResultDao.getAuditResultNV2(company,sDate,eDate,trip);
        for(ReportAuditResultDto all:yList){

                ReportAuditResult reportAudit = new ReportAuditResult();
                reportAudit.setCategory(all.getToolsName());
                reportAudit.setNum(all.getTotals());
                for(Map<String,Object> map:allList) {
                	if(all.getItemName().equals(map.get("TOOLS_NAME").toString())) {
                		double result = (reportAudit.getNum()/Double.parseDouble(map.get("TOTALS").toString()))*100;
                		reportAudit.setPerCent(result);
                		break;
                	}
                }
                listReportAuditResult.add(reportAudit);
        }
        
        if(listReportAuditResult.size()==0) {
        	ReportAuditResult reportAudit = new ReportAuditResult();
            reportAudit.setCategory("");
            reportAudit.setNum(0);
            listReportAuditResult.add(reportAudit);
        }
        return listReportAuditResult;
    }

}
