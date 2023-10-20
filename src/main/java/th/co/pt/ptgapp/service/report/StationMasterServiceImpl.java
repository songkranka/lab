package th.co.pt.ptgapp.service.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.co.pt.ptgapp.dao.report.StationMasterDao;
import th.co.pt.ptgapp.entity.ResultLTrBean;
import th.co.pt.ptgapp.entity.StationBean;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class StationMasterServiceImpl implements IStationMasterService {

    @Autowired
    private StationMasterDao stationMasterDao;

    @Override
    public Map<String, Integer> getTotalStation() {
        return stationMasterDao.getTotalStation();
    }

    @Override
    public Map<String, Integer> getTotalLtr(Date dateFrom, Date dateTo) {
        return stationMasterDao.getTotalLtr(dateFrom,dateTo);
    }

    @Override
    public List<ResultLTrBean> getResultlLtr(Date dateFrom, Date dateTo) {
        return stationMasterDao.getResultlLtr(dateFrom,dateTo);
    }

    @Override
    public List<ResultLTrBean> getReceiveOil(Date dateFrom, Date dateTo) {
        return stationMasterDao.getReceiveOil(dateFrom,dateTo);
    }

    @Override
    public List<ResultLTrBean> getResultTool(Date dateFrom, Date dateTo) {
        return stationMasterDao.getResultTool(dateFrom,dateTo);
    }

    @Override
    public List<ResultLTrBean> getResult5Liter(Date dateFrom, Date dateTo) {
        return stationMasterDao.getResult5Liter(dateFrom,dateTo);
    }

    @Override
    public List<ResultLTrBean> getResultTrain(Date dateFrom, Date dateTo) {
        return stationMasterDao.getResultTrain(dateFrom,dateTo);
    }

    @Override
    public List<StationBean> getStationNotReceiveOil(Date dateFrom, Date dateTo) {
        return stationMasterDao.getStationNotReceiveOil(dateFrom,dateTo);
    }

    @Override
    public List<StationBean> getStationOffSpac(Date dateFrom, Date dateTo) {
        return stationMasterDao.getStationOffSpac(dateFrom,dateTo);
    }

}
