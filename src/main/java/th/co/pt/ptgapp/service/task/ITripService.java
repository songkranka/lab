package th.co.pt.ptgapp.service.task;

import th.co.pt.ptgapp.dao.task.TripDto;

import java.util.List;

public interface ITripService {
    List<TripDto> findTripByComplete() throws Exception;
}
