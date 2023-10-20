package th.co.pt.ptgapp.service.ws.lotusnotes.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberForCreate implements Serializable {

    private String membersName;
    private String memberID;

    @JsonProperty("MembersName")
    public String getMembersName() {
        return membersName;
    }

    public void setMembersName(String membersName) {
        this.membersName = membersName;
    }

    @JsonProperty("MemberID")
    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    @Override
    public String toString() {
        return "MemberForCreate{" +
                "membersName='" + membersName + '\'' +
                ", memberID='" + memberID + '\'' +
                '}';
    }
}
