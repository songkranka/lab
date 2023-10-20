package th.co.pt.ptgapp.service.task;

import th.co.pt.ptgapp.dao.task.DrawdownDto;

import java.util.List;

public interface IMasterService {
    List<DrawdownDto> getVisualDdl() throws Exception;
    List<DrawdownDto> getColorDdl() throws Exception;
}
