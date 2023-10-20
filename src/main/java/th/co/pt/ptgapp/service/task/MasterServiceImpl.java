package th.co.pt.ptgapp.service.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.co.pt.ptgapp.dao.task.DrawdownDto;
import th.co.pt.ptgapp.dao.task.MasterDao;

import java.util.List;

@Service
public class MasterServiceImpl implements IMasterService {

    @Autowired
    private MasterDao masterDao;

    @Override
    public List<DrawdownDto> getVisualDdl() throws Exception {
        return masterDao.getVisualDdl();
    }

    @Override
    public List<DrawdownDto> getColorDdl() throws Exception {
        return masterDao.getColorDdl();
    }
}
