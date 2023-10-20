package th.co.pt.ptgapp.service.ws.lotusnotes.response;

import org.springframework.util.StringUtils;
import th.co.pt.ptgapp.utils.ParamMap;

import java.util.List;

public class WsConstant {

    public final static String WEB_SUCCESS_CODE = "200";
    public final static String WEB_ERROR_CODE = "000";
    public final static String WEB_STATUS_CODE = "status";
    public final static String WEB_STATUS_SMG = "msg";
    public final static String WEB_DATA_KEY = "data";

    public final static String MEMBER_TYPE_ASSIGNMENT = "0";

    public final static String WEB_DATA_STORE = "store";
    public final static String WEB_DATA_PLANT = "plant";
    public final static String WEB_DATA_RESULT_LISTS = "result";

    public final static String TXT_ASSIGN_STATUS = "ASSIGN_STATUS";
    public final static String TXT_F = "F";
    public final static String TXT_T = "T";
    public final static String TXT_ASGNFLG = "asgnflg";

    public final static String TXT_Y = "Y";
    public final static String TXT_N = "N";

    public final static String TXT_1 = "1";
    public final static String TXT_0 = "0";

    public final static ParamMap getErrorCode() {
        ParamMap map = new ParamMap();
        map.put("201", "Required field is null");
        map.put("202", "This system not found in configuration");
        map.put("203", "This dummy not found in master setup");
        map.put("204", "This dummy not has item list");
        map.put("205", "Invalid total record");
        map.put("206", "[WF] Workflow App. profile not found");
        map.put("207", "[WF] Field zwf_InterfaceDB in ApplicationProfile is null");
        map.put("208", "[WF] This request id alredy submit");
        map.put("209", "Invalid Seq no./ Employee ID");
        map.put("210", "[WF] This request id is null");
        map.put("211", "HR database not found");
        map.put("212", "[WF] This change request id is null");
        map.put("213", "This request id is already completed, can't re-submit");
        map.put("214", "This table not found");
        map.put("215", "Employee ID not found");
        return map;
    }

    public static String genSeq(int total){
        StringBuilder list = new StringBuilder();
        for(int i=1;i<=total;i++){
            list.append(i);
            if(i<total) {
                list.append("|");
            }
        }
        return list.toString();
    }

    public static String getPip(List<String> params){
        StringBuilder list = new StringBuilder();
        for(String s : params){
            list.append(s);
            list.append("|");
        }
        return list.deleteCharAt(list.length()-1).toString();
    }

    public static String getMemList(List<Detail> details){
        StringBuilder list = new StringBuilder();
        for(Detail dl : details){
            StringBuilder sb = new StringBuilder();
            List<Workgroup> wgs = dl.getWorkgroup();
            for(Workgroup s : wgs) {
                for (Member m : s.getMemberList()) {
                    if(!StringUtils.isEmpty(m.getMemberID())) {
                        sb.append(m.getMemberID());
                        sb.append(",");
                    }
                }
            }
            sb.deleteCharAt(sb.length() - 1).toString();
            list.append(sb);
            list.append("|");
        }
        return list.deleteCharAt(list.length()-1).toString();
    }


    public static String replaceNull(String s){
            return StringUtils.isEmpty(s) || "null".equalsIgnoreCase(s)?"":s.trim();
    }
}
