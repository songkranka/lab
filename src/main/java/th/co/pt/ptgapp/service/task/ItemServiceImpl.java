package th.co.pt.ptgapp.service.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.co.pt.ptgapp.dao.task.ItemDao;
import th.co.pt.ptgapp.dao.task.ItemDto;

import java.util.List;

@Service
public class ItemServiceImpl implements IItemService{

    @Autowired
    private ItemDao itemDao;

    @Override
    public List<ItemDto> findItemByReqNo(String wfId) {
        try {
            return itemDao.findItemByReqNo(wfId);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
