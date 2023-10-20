package th.co.pt.ptgapp.service.task;

import th.co.pt.ptgapp.dao.task.ItemDto;

import java.util.List;

public interface IItemService {

    List<ItemDto> findItemByReqNo(String wfId);

}
