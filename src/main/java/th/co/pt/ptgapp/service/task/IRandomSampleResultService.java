package th.co.pt.ptgapp.service.task;

import th.co.pt.ptgapp.dao.task.RandomSampleResultDto;

import java.util.List;

public interface IRandomSampleResultService {

    List<RandomSampleResultDto> findRandomSampleByLabCode(List<String> labCodeList) throws Exception ;
}
