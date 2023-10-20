package th.co.pt.ptgapp.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.util.StringUtils;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.Manager;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.Member;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.Substitue;
import th.co.pt.ptgapp.service.ws.lotusnotes.response.Workgroup;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
//        String json = "{\"SystemT\":\"Lab Assignment\",\"Dummy01\":\"Product#ADO\",\"Dummy02\":\"Type#C-BOAT\",\"Dummy03\":\"#\",\"Dummy04\":\"#\",\"Dummy05\":\"#\",\"Dummy06\":\"#\",\"Dummy07\":\"#\",\"Dummy08\":\"#\",\"Dummy09\":\"#\",\"Dummy10\":\"#\",\"Dummy11\":\"#\",\"Dummy12\":\"#\",\"Dummy13\":\"#\",\"Dummy14\":\"#\",\"Dummy15\":\"#\",\"Dummy16\":\"#\",\"Dummy17\":\"#\",\"Dummy18\":\"#\",\"Dummy19\":\"#\",\"Dummy20\":\"#\",\"ErrorMsg\":\"this dummy not found in master set up\",\"Errorcode\":\"203\",\"Remark\":\"\"}";
//        String json = "{\"StrVal\":\"some value\"}";
//        String json = "{\"SystemT\":\"Lab Assignment\",\"Dummy01\":\"Product#ADO\",\"Dummy02\":\"Type#C-CAR\",\"Dummy03\":\"#\",\"Dummy04\":\"#\",\"Dummy05\":\"#\",\"Dummy06\":\"#\",\"Dummy07\":\"#\",\"Dummy08\":\"#\",\"Dummy09\":\"#\",\"Dummy10\":\"#\",\"Dummy11\":\"#\",\"Dummy12\":\"#\",\"Dummy13\":\"#\",\"Dummy14\":\"#\",\"Dummy15\":\"#\",\"Dummy16\":\"#\",\"Dummy17\":\"#\",\"Dummy18\":\"#\",\"Dummy19\":\"#\",\"Dummy20\":\"#\",\"ErrorMsg\":\"Complete\",\"Errorcode\":\"900\",\"Remark\":\"\" ,\"Detail\": [{\"TestItem\": \"Visual\",\"TestItemcode\": \"0016\",\"Testtool\": \"การมองด้วยสายตา\",\"Testtoolcode\": \"0005\",\"Testmathod\": \"Visual\",\"Testmathodcode\": \"0026\",\"TestSpec\": \"Clear\",\"TestSpeccode\": \"0023\",\"TestSpec2\": \"\",\"TestUnit\": \"\",\"TestUnitcode\": \"\",\"workgroup\": [{\"RoleGroup\": \"A1\",\"RoleDef\": \"Y\",\"MemberList\": [{\"MemberID\" : \"470251\",\"MemberName\" : \"Artitaya Labjuti\"},{\"MemberID\" : \"619599\",\"MemberName\" : \"Ongon Thaikul\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]}]},{\"TestItem\": \"Color\",\"TestItemcode\": \"0003\",\"Testtool\": \"การมองด้วยสายตา\",\"Testtoolcode\": \"0005\",\"Testmathod\": \"Visual\",\"Testmathodcode\": \"0026\",\"TestSpec\": \"Yellow\",\"TestSpeccode\": \"0029\",\"TestSpec2\": \"\",\"TestUnit\": \"\",\"TestUnitcode\": \"\",\"workgroup\": [{\"RoleGroup\": \"A1\",\"RoleDef\": \"Y\",\"MemberList\": [{\"MemberID\" : \"470251\",\"MemberName\" : \"Artitaya Labjuti\"},{\"MemberID\" : \"619599\",\"MemberName\" : \"Ongon Thaikul\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]}]},{\"TestItem\": \"Flash Piont, จุดวาบไฟ\",\"TestItemcode\": \"0011\",\"Testtool\": \"Flash Point lab\",\"Testtoolcode\": \"0001\",\"Testmathod\": \"ASTM D 93\",\"Testmathodcode\": \"0014\",\"TestSpec\": \"55 min\",\"TestSpeccode\": \"0017\",\"TestSpec2\": \"\",\"TestUnit\": \"\",\"TestUnitcode\": \"\",\"workgroup\": [{\"RoleGroup\": \"B1\",\"RoleDef\": \"Y\",\"MemberList\": [{\"MemberID\" : \"584804\",\"MemberName\" : \"Arporn Mittranon\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]}]},{\"TestItem\": \"Flash Piont, จุดวาบไฟ\",\"TestItemcode\": \"0011\",\"Testtool\": \"Flash Point Seta\",\"Testtoolcode\": \"0002\",\"Testmathod\": \"ASTM D 7236\",\"Testmathodcode\": \"0012\",\"TestSpec\": \"55 min\",\"TestSpeccode\": \"0017\",\"TestSpec2\": \"\",\"TestUnit\": \"\",\"TestUnitcode\": \"\",\"workgroup\": [{\"RoleGroup\": \"B1\",\"RoleDef\": \"Y\",\"MemberList\": [{\"MemberID\" : \"584804\",\"MemberName\" : \"Arporn Mittranon\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]}]},{\"TestItem\": \"API gravity @ 60 F\",\"TestItemcode\": \"0001\",\"Testtool\": \"เครื่อง Density\",\"Testtoolcode\": \"0008\",\"Testmathod\": \"ASTM D 4052\",\"Testmathodcode\": \"0005\",\"TestSpec\": \"31\",\"TestSpeccode\": \"0015\",\"TestSpec2\": \"43\",\"TestUnit\": \"\",\"TestUnitcode\": \"\",\"workgroup\": [{\"RoleGroup\": \"B2\",\"RoleDef\": \"Y\",\"MemberList\": [{\"MemberID\" : \"573839\",\"MemberName\" : \"Atthapon Chalee\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]}]},{\"TestItem\": \"FAME(B100), ปริมาณB100\",\"TestItemcode\": \"0010\",\"Testtool\": \"เครื่อง Eralytic\",\"Testtoolcode\": \"0011\",\"Testmathod\": \"EN 14078\",\"Testmathodcode\": \"0028\",\"TestSpec\": \"6.5\",\"TestSpeccode\": \"0020\",\"TestSpec2\": \"7.0\",\"TestUnit\": \"\",\"TestUnitcode\": \"\",\"workgroup\": [{\"RoleGroup\": \"A2\",\"RoleDef\": \"Y\",\"MemberList\": [{\"MemberID\" : \"582204\",\"MemberName\" : \"Sirirat Sittikool\"}],\"ManagerList\": [{\"ManagerID\" : \"\",\"Manager\" : \"\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]}]}]}";
//        String json = "{\"SystemT\":\"Lab Assignment\",\"Dummy01\":\"Product#GSH91\",\"Dummy02\":\"Type#C CAR\",\"Dummy03\":\"#\",\"Dummy04\":\"#\",\"Dummy05\":\"#\",\"Dummy06\":\"#\",\"Dummy07\":\"#\",\"Dummy08\":\"#\",\"Dummy09\":\"#\",\"Dummy10\":\"#\",\"Dummy11\":\"#\",\"Dummy12\":\"#\",\"Dummy13\":\"#\",\"Dummy14\":\"#\",\"Dummy15\":\"#\",\"Dummy16\":\"#\",\"Dummy17\":\"#\",\"Dummy18\":\"#\",\"Dummy19\":\"#\",\"Dummy20\":\"#\",\"ErrorMsg\":\"Complete\",\"Errorcode\":\"900\",\"Remark\":\"\" ,\"Detail\": [{\"TestItem\": \"Visual\",\"TestItemcode\": \"0004\",\"Testtool\": \"การมองด้วยสายตา\",\"Testtoolcode\": \"0008\",\"Testmathod\": \"Visual\",\"Testmathodcode\": \"0023\",\"TestSpec\": \"Clear&amp;Bright\",\"TestSpeccode\": \"0021\",\"TestSpec2\": \"\",\"TestUnit\": \"\",\"TestUnitcode\": \"\",\"workgroup\": {\"A1\": {\"MemberList\": [{\"MemberID\" : \"470251\",\"MemberName\" : \"Artitaya Labjuti\"},{\"MemberID\" : \"619599\",\"MemberName\" : \"Ongon Thaikul\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]}}},{\"TestItem\": \"Color\",\"TestItemcode\": \"0003\",\"Testtool\": \"การมองด้วยสายตา\",\"Testtoolcode\": \"0008\",\"Testmathod\": \"Visual\",\"Testmathodcode\": \"0023\",\"TestSpec\": \"Green\",\"TestSpeccode\": \"0026\",\"TestSpec2\": \"\",\"TestUnit\": \"\",\"TestUnitcode\": \"\",\"workgroup\": {\"A1\": {\"MemberList\": [{\"MemberID\" : \"470251\",\"MemberName\" : \"Artitaya Labjuti\"},{\"MemberID\" : \"619599\",\"MemberName\" : \"Ongon Thaikul\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]}}},{\"TestItem\": \"Distillation, การกลั่น\",\"TestItemcode\": \"0008\",\"Testtool\": \"เครื่องกลั่น Auto และกลั่น Manual\",\"Testtoolcode\": \"0007\",\"Testmathod\": \"ASTM D 86\",\"Testmathodcode\": \"0010\",\"TestSpec\": \"10%;  70 max\",\"TestSpeccode\": \"0007\",\"TestSpec2\": \"\",\"TestUnit\": \"°C\",\"TestUnitcode\": \"0003\",\"workgroup\": {\"A3\": {\"MemberList\": [{\"MemberID\" : \"584806\",\"MemberName\" : \"Jinrapee Khoumtonwong\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]},\"A2\": {\"MemberList\": [{\"MemberID\" : \"582204\",\"MemberName\" : \"Sirirat Sittikool\"}],\"ManagerList\": [{\"ManagerID\" : \"\",\"Manager\" : \"\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]},\"B3\": {\"MemberList\": [{\"MemberID\" : \"603676\",\"MemberName\" : \"Boripat Keawkomdee\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]}}},{\"TestItem\": \"Distillation, การกลั่น\",\"TestItemcode\": \"0008\",\"Testtool\": \"เครื่องกลั่น Auto และกลั่น Manual\",\"Testtoolcode\": \"0007\",\"Testmathod\": \"ASTM D 86\",\"Testmathodcode\": \"0010\",\"TestSpec\": \"EP; 200 max\",\"TestSpeccode\": \"0032\",\"TestSpec2\": \"\",\"TestUnit\": \"°C\",\"TestUnitcode\": \"0003\",\"workgroup\": {\"A3\": {\"MemberList\": [{\"MemberID\" : \"584806\",\"MemberName\" : \"Jinrapee Khoumtonwong\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]},\"A2\": {\"MemberList\": [{\"MemberID\" : \"582204\",\"MemberName\" : \"Sirirat Sittikool\"}],\"ManagerList\": [{\"ManagerID\" : \"\",\"Manager\" : \"\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]},\"B3\": {\"MemberList\": [{\"MemberID\" : \"603676\",\"MemberName\" : \"Boripat Keawkomdee\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]}}},{\"TestItem\": \"Distillation, การกลั่น\",\"TestItemcode\": \"0008\",\"Testtool\": \"เครื่องกลั่น Auto และกลั่น Manual\",\"Testtoolcode\": \"0007\",\"Testmathod\": \"ASTM D 86\",\"Testmathodcode\": \"0010\",\"TestSpec\": \"Residue; 2.0max\",\"TestSpeccode\": \"0033\",\"TestSpec2\": \"\",\"TestUnit\": \"%vol.\",\"TestUnitcode\": \"0001\",\"workgroup\": {\"A3\": {\"MemberList\": [{\"MemberID\" : \"584806\",\"MemberName\" : \"Jinrapee Khoumtonwong\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]},\"A2\": {\"MemberList\": [{\"MemberID\" : \"582204\",\"MemberName\" : \"Sirirat Sittikool\"}],\"ManagerList\": [{\"ManagerID\" : \"\",\"Manager\" : \"\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]},\"B3\": {\"MemberList\": [{\"MemberID\" : \"603676\",\"MemberName\" : \"Boripat Keawkomdee\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]}}},{\"TestItem\": \"Density @ 15 C\",\"TestItemcode\": \"0006\",\"Testtool\": \"เครื่อง Density\",\"Testtoolcode\": \"0005\",\"Testmathod\": \"ASTM D 4052\",\"Testmathodcode\": \"0005\",\"TestSpec\": \"Report (รายงานผลที่วัดได้)\",\"TestSpeccode\": \"0022\",\"TestSpec2\": \"\",\"TestUnit\": \"g/cm3\",\"TestUnitcode\": \"0005\",\"workgroup\": {\"B2\": {\"MemberList\": [{\"MemberID\" : \"573839\",\"MemberName\" : \"Atthapon Chalee\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]}}},{\"TestItem\": \"API gravity @ 60 F\",\"TestItemcode\": \"0001\",\"Testtool\": \"เครื่อง Density\",\"Testtoolcode\": \"0005\",\"Testmathod\": \"ASTM D 4052\",\"Testmathodcode\": \"0005\",\"TestSpec\": \"Report (รายงานผลที่วัดได้)\",\"TestSpeccode\": \"0022\",\"TestSpec2\": \"\",\"TestUnit\": \"\",\"TestUnitcode\": \"\",\"workgroup\": {\"B2\": {\"MemberList\": [{\"MemberID\" : \"573839\",\"MemberName\" : \"Atthapon Chalee\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]}}},{\"TestItem\": \"Silver Strip corrosion 3 hr @50 C\",\"TestItemcode\": \"0009\",\"Testtool\": \"\",\"Testtoolcode\": \"\",\"Testmathod\": \"ASTM D 4814(ANNEX A)\",\"Testmathodcode\": \"0007\",\"TestSpec\": \"No. 1 max\",\"TestSpeccode\": \"0023\",\"TestSpec2\": \"\",\"TestUnit\": \"\",\"TestUnitcode\": \"\",\"workgroup\": {\"B1\": {\"MemberList\": [{\"MemberID\" : \"584804\",\"MemberName\" : \"Arporn Mittranon\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]}}},{\"TestItem\": \"Denatured Ethanol\",\"TestItemcode\": \"0010\",\"Testtool\": \"Eralytic\",\"Testtoolcode\": \"0012\",\"Testmathod\": \"ASTM D 5845\",\"Testmathodcode\": \"0026\",\"TestSpec\": \"9\",\"TestSpeccode\": \"0025\",\"TestSpec2\": \"10\",\"TestUnit\": \"%vol.\",\"TestUnitcode\": \"0001\",\"workgroup\": {\"A3\": {\"MemberList\": [{\"MemberID\" : \"584806\",\"MemberName\" : \"Jinrapee Khoumtonwong\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]}}},{\"TestItem\": \"Distillation, การกลั่น\",\"TestItemcode\": \"0008\",\"Testtool\": \"เครื่องกลั่น Auto และกลั่น Manual\",\"Testtoolcode\": \"0007\",\"Testmathod\": \"ASTM D 86\",\"Testmathodcode\": \"0010\",\"TestSpec\": \"10%;  70 max\",\"TestSpeccode\": \"0007\",\"TestSpec2\": \"\",\"TestUnit\": \"°C\",\"TestUnitcode\": \"0003\",\"workgroup\": {\"A3\": {\"MemberList\": [{\"MemberID\" : \"584806\",\"MemberName\" : \"Jinrapee Khoumtonwong\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]},\"A2\": {\"MemberList\": [{\"MemberID\" : \"582204\",\"MemberName\" : \"Sirirat Sittikool\"}],\"ManagerList\": [{\"ManagerID\" : \"\",\"Manager\" : \"\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]},\"B3\": {\"MemberList\": [{\"MemberID\" : \"603676\",\"MemberName\" : \"Boripat Keawkomdee\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]}}},{\"TestItem\": \"Distillation, การกลั่น\",\"TestItemcode\": \"0008\",\"Testtool\": \"เครื่องกลั่น Auto และกลั่น Manual\",\"Testtoolcode\": \"0007\",\"Testmathod\": \"ASTM D 86\",\"Testmathodcode\": \"0010\",\"TestSpec\": \"50%; 70-110\",\"TestSpeccode\": \"0030\",\"TestSpec2\": \"\",\"TestUnit\": \"°C\",\"TestUnitcode\": \"0003\",\"workgroup\": {\"A3\": {\"MemberList\": [{\"MemberID\" : \"584806\",\"MemberName\" : \"Jinrapee Khoumtonwong\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]},\"A2\": {\"MemberList\": [{\"MemberID\" : \"582204\",\"MemberName\" : \"Sirirat Sittikool\"}],\"ManagerList\": [{\"ManagerID\" : \"\",\"Manager\" : \"\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]},\"B3\": {\"MemberList\": [{\"MemberID\" : \"603676\",\"MemberName\" : \"Boripat Keawkomdee\"}],\"ManagerList\": [{\"ManagerID\" : \"612981\",\"Manager\" : \"Natthawat Srisombat\"}],\"SubstitueList\": [{\"SubstitueID\" : \"\",\"SubstitueName\" : \"\"}]}}}]}";
//        ObjectMapper mapper = new ObjectMapper();
//        ItemResponse obj = mapper.readValue(json, ItemResponse.class);
//        List<List<Workgroup>> list = new ArrayList<>();
//        for(Detail d : obj.getDetail()){
//            list.add(d.getWorkgroup());
//        }
//        System.out.println(getMemList(list));
        //    LAB_CODE,PLANT_ID,plant_name,DO_NO,PO_NO,SHIPMENT_NO,CAR_SLOT,BOAT_NO,BOAT_NAME,BOAT_SLOT,TANK_NO,CREATE_BY,
//    SAMPLE_STAFF_ID,SAMPLE_STAFF_NAME,SAMPLE_REFER,SAMPLE_DATA_GROUP,SAMPLE_DATA_SEQ,SOURCE_ID,source_name,
//    PRODUCT_ID,PRODUCT_CODE,product_name,LOGIS_ID,logis_name,PO_DATE,status,STRPO_DATE,COLOR_FLAG,RESULT_STATUS,STATUS_DESC,SAMPLE_TYPE_CODE,SAMPLE_TYPE_NAME,ASSIGN_STATUS

        String s = "LAB_CODE,PLANT_ID,plant_name,DO_NO,PO_NO,SHIPMENT_NO,CAR_SLOT,BOAT_NO,BOAT_NAME,BOAT_SLOT,TANK_NO,CREATE_BY,SAMPLE_STAFF_ID,SAMPLE_STAFF_NAME,SAMPLE_REFER,SAMPLE_DATA_GROUP,SAMPLE_DATA_SEQ,SOURCE_ID,source_name,PRODUCT_ID,PRODUCT_CODE,product_name,LOGIS_ID,logis_name,PO_DATE,status,STRPO_DATE,COLOR_FLAG,RESULT_STATUS,STATUS_DESC,SAMPLE_TYPE_CODE,SAMPLE_TYPE_NAME,ASSIGN_STATUS";
        System.out.println(s.toLowerCase());

    }
    
    private static String genSeq(int total){
        StringBuilder list = new StringBuilder();
        for(int i=1;i<=total;i++){
            list.append(i);
            if(i<total) {
                list.append("|");
            }
        }
        return list.toString();
    }

    private static String getPip(List<String> params){
        StringBuilder list = new StringBuilder();
        for(String s : params){
            list.append(s);
            list.append("|");
        }
        return list.deleteCharAt(list.length()-1).toString();
    }

    private static String getMemList(List<List<Workgroup>> workgroups){
        StringBuilder list = new StringBuilder();
        for(List<Workgroup> wg : workgroups){
            for(Workgroup s : wg) {
                StringBuilder sb = new StringBuilder();
                for (Member m : s.getMemberList()) {
                    if(!StringUtils.isEmpty(m.getMemberID())) {
                        sb.append(m.getMemberID());
                        sb.append(",");
                    }
                }
                for (Manager m : s.getManagerList()) {
                    if(!StringUtils.isEmpty(m.getManagerID())) {
                        sb.append(m.getManagerID());
                        sb.append(",");
                    }
                }
                for (Substitue m : s.getSubstitueList()) {
                    if(!StringUtils.isEmpty(m.getSubstitueID())) {
                        sb.append(m.getSubstitueID());
                        sb.append(",");
                    }
                }
                sb.deleteCharAt(sb.length() - 1).toString();
                list.append(sb);
                list.append("|");
            }
        }
        return list.deleteCharAt(list.length()-1).toString();
    }


    private static String createMembers(List<String> memb,List<String> mang,List<String> subs){
        StringBuilder list = new StringBuilder();
        StringBuilder sbMemb = new StringBuilder();
        StringBuilder sbMang = new StringBuilder();
        StringBuilder sbSubs = new StringBuilder();
        for(String s : memb){
            sbMemb.append(s);
            sbMemb.append(",");
        }
        sbMemb.deleteCharAt(sbMemb.length()-1).toString();
        list.append(sbMemb);
        list.append("|");
        for(String s : mang){
            sbMang.append(s);
            sbMang.append(",");
        }
        sbMang.deleteCharAt(sbMang.length()-1).toString();
        list.append(sbMemb);
        list.append("|");
        for(String s : subs){
            sbSubs.append(s);
            sbSubs.append(",");
        }
        sbSubs.deleteCharAt(sbSubs.length()-1).toString();
        list.append(sbSubs);
        return list.toString();
    }
}



@JsonInclude(JsonInclude.Include.NON_NULL)
class MyDto {
    private String stringValue;
    private String mane;

    @JsonProperty("StrVal")
    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    @JsonProperty("Name")
    public String getMane() {
        return mane;
    }

    public void setMane(String mane) {
        this.mane = mane;
    }

    @Override
    public String toString() {
        return "MyDto{" +
                "stringValue='" + stringValue + '\'' +
                ", mane='" + mane + '\'' +
                '}';
    }
}