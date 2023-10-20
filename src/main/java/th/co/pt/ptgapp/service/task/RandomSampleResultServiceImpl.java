package th.co.pt.ptgapp.service.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.co.pt.ptgapp.dao.task.RandomSampleResultDao;
import th.co.pt.ptgapp.dao.task.RandomSampleResultDto;

import java.util.List;

@Service
public class RandomSampleResultServiceImpl implements IRandomSampleResultService {

    @Autowired
    private RandomSampleResultDao randomSampleResultDao;

    @Override
    public List<RandomSampleResultDto> findRandomSampleByLabCode(List<String> labCodeList) throws Exception {
        return randomSampleResultDao.findRandomSampleByLabCode(labCodeList);
    }
}
