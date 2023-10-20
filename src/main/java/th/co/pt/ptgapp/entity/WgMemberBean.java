package th.co.pt.ptgapp.entity;

import java.io.Serializable;

public class WgMemberBean  implements Serializable {

    private String opt;
    private String value;

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public WgMemberBean() {
    }

    public WgMemberBean(String opt, String value) {
        this.opt = opt;
        this.value = value;
    }
}
