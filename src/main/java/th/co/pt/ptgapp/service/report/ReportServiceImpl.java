package th.co.pt.ptgapp.service.report;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.pt.ptgapp.controller.bean.ReportInfoEntity;
import th.co.pt.ptgapp.controller.bean.report.MbServiceStationEntity;
import th.co.pt.ptgapp.dao.ReportDao;

@Service("ReportService")
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportDao reportDao;
	
	@Override
	public Map<String, Object> getReportInfo(ReportInfoEntity entity) throws Exception {
		return reportDao.getReportInfo(entity);
	}

	@Override
	public List<Map<String, Object>> getRptMbServiceStation(MbServiceStationEntity entity) throws Exception {
		return reportDao.getRptMbServiceStation(entity);
	}

	@Override
	public Map<String, Object> pushReportTransaction(Map<String, Object> obj) throws Exception {
		return reportDao.pushReportTransaction(obj);
	}

}
