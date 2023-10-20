package th.co.pt.ptgapp.service.ws.lotusnotes;

import th.co.pt.ptgapp.service.ws.lotusnotes.dto.RandomSampleDto;
import th.co.pt.ptgapp.service.ws.lotusnotes.request.CreateRequestRequest;
import th.co.pt.ptgapp.service.ws.lotusnotes.request.ItemRequest;
import th.co.pt.ptgapp.utils.ParamMap;

import javax.servlet.http.HttpSession;
import java.rmi.RemoteException;
import java.util.Map;

public interface IPtgService {
    String getMyWork(ParamMap param) throws RemoteException;
    String getItemList(ItemRequest request) throws RemoteException;
    String getRequestDetail(CreateRequestRequest request) throws RemoteException;
    String requestGetMaster(ParamMap param) throws RemoteException;
    String requestGetStatus(ParamMap param) throws RemoteException;
    String submitChangeRequest(ParamMap param) throws RemoteException;
//    String submitDecision(ParamMap param) throws RemoteException;
    Map<String,Object> submitDecision(String labcode,String comment,String empId,String act,String process,String changeId) throws RemoteException;
    Map<String,Object> submitTask(String labcode) throws RemoteException;
    Map<String,Object> assignJob(RandomSampleDto sample, HttpSession session);
}
