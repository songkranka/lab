package th.co.pt.ptgapp.service.ws.lotusnotes.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Detail implements Serializable {

    private String testItem;
    private String testItemcode;
    private String testtool;
    private String testtoolcode;
    private String testmathod;
    private String testmathodcode;
    private String testSpec;
    private String testSpeccode;
    private String testSpec2;
    private String testUnit;
    private String testUnitcode;
    private List<Workgroup> workgroup;

    @JsonProperty("TestItem")
    public String getTestItem() {
        return testItem;
    }

    public void setTestItem(String testItem) {
        this.testItem = testItem;
    }

    @JsonProperty("TestItemcode")
    public String getTestItemcode() {
        return testItemcode;
    }

    public void setTestItemcode(String testItemcode) {
        this.testItemcode = testItemcode;
    }

    @JsonProperty("Testtool")
    public String getTesttool() {
        return testtool;
    }

    public void setTesttool(String testtool) {
        this.testtool = testtool;
    }

    @JsonProperty("Testtoolcode")
    public String getTesttoolcode() {
        return testtoolcode;
    }

    public void setTesttoolcode(String testtoolcode) {
        this.testtoolcode = testtoolcode;
    }

    @JsonProperty("Testmathod")
    public String getTestmathod() {
        return testmathod;
    }

    public void setTestmathod(String testmathod) {
        this.testmathod = testmathod;
    }

    @JsonProperty("Testmathodcode")
    public String getTestmathodcode() {
        return testmathodcode;
    }

    public void setTestmathodcode(String testmathodcode) {
        this.testmathodcode = testmathodcode;
    }

    @JsonProperty("TestSpec")
    public String getTestSpec() {
        return testSpec;
    }

    public void setTestSpec(String testSpec) {
        this.testSpec = testSpec;
    }

    @JsonProperty("TestSpeccode")
    public String getTestSpeccode() {
        return testSpeccode;
    }

    public void setTestSpeccode(String testSpeccode) {
        this.testSpeccode = testSpeccode;
    }

    @JsonProperty("TestSpec2")
    public String getTestSpec2() {
        return testSpec2;
    }

    public void setTestSpec2(String testSpec2) {
        this.testSpec2 = testSpec2;
    }

    @JsonProperty("TestUnit")
    public String getTestUnit() {
        return testUnit;
    }

    public void setTestUnit(String testUnit) {
        this.testUnit = testUnit;
    }

    @JsonProperty("TestUnitcode")
    public String getTestUnitcode() {
        return testUnitcode;
    }

    public void setTestUnitcode(String testUnitcode) {
        this.testUnitcode = testUnitcode;
    }


    @JsonProperty("workgroup")
    public List<Workgroup> getWorkgroup() {
        return workgroup;
    }

    public void setWorkgroup(List<Workgroup> workgroup) {
        this.workgroup = workgroup;
    }
}
