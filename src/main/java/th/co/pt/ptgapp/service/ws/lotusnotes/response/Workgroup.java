package th.co.pt.ptgapp.service.ws.lotusnotes.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Workgroup implements Serializable {

    private String roleGroup;
    private String roleDef;
    private List<Member> memberList;
    private List<Manager> managerList;
    private List<Substitue> substitueList;

    @JsonProperty("RoleGroup")
    public String getRoleGroup() {
        return roleGroup;
    }

    public void setRoleGroup(String roleGroup) {
        this.roleGroup = roleGroup;
    }
    @JsonProperty("RoleDef")
    public String getRoleDef() {
        return roleDef;
    }

    public void setRoleDef(String roleDef) {
        this.roleDef = roleDef;
    }
    @JsonProperty("MemberList")
    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }
    @JsonProperty("ManagerList")
    public List<Manager> getManagerList() {
        return managerList;
    }

    public void setManagerList(List<Manager> managerList) {
        this.managerList = managerList;
    }
    @JsonProperty("SubstitueList")
    public List<Substitue> getSubstitueList() {
        return substitueList;
    }

    public void setSubstitueList(List<Substitue> substitueList) {
        this.substitueList = substitueList;
    }
}
