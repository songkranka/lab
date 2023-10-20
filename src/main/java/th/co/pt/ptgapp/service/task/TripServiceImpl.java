package th.co.pt.ptgapp.service.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.co.pt.ptgapp.dao.task.TripDao;
import th.co.pt.ptgapp.dao.task.TripDto;

import java.util.List;

@Service
public class TripServiceImpl implements ITripService {

    @Autowired
    private TripDao tripDao;
    @Override
    public List<TripDto> findTripByComplete() throws Exception {
        return tripDao.findTripByComplete();
    }
}
