package th.co.pt.ptgapp.service.report;

import th.co.pt.ptgapp.entity.ResultLTrBean;
import th.co.pt.ptgapp.entity.StationBean;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IStationMasterService {
    Map<String,Integer> getTotalStation();
    Map<String,Integer> getTotalLtr(Date dateFrom, Date dateTo);
    List<ResultLTrBean> getResultlLtr(Date dateFrom, Date dateTo);
    List<ResultLTrBean> getReceiveOil(Date dateFrom, Date dateTo);
    List<ResultLTrBean> getResultTool(Date dateFrom, Date dateTo);
    List<ResultLTrBean> getResult5Liter(Date dateFrom, Date dateTo);
    List<ResultLTrBean> getResultTrain(Date dateFrom, Date dateTo);
    List<StationBean> getStationNotReceiveOil(Date dateFrom, Date dateTo);
    List<StationBean> getStationOffSpac(Date dateFrom, Date dateTo);

}
