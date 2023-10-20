package th.co.pt.ptgapp.dao.task;

import org.springframework.util.StringUtils;

import java.util.List;

public class ItemDto {

    private String wfId;
    private String reqItemId;
    private String reqDtlNo;
    private String analyzeCode;
    private String analyzeValue;
    private String meterialCode;
    private String meterialValue;
    private String methodCode;
    private String methodValue;
    private String spaceCode;
    private String spaceValue;
    private String spaceValueDesc;
    private String space2Code;
    private String space2Value;
    private String unitCode;
    private String unitValue;
    private String empId;
    private String empName;
    private String workGroup;

    private List<DrawdownDto> visualDdl;
    private List<DrawdownDto> colorDdl;

    private String ownerItem;
    private boolean readOnly;

    public String getWfId() {
        return wfId;
    }

    public void setWfId(String wfId) {
        this.wfId = wfId;
    }

    public String getReqItemId() {
        return reqItemId;
    }

    public void setReqItemId(String reqItemId) {
        this.reqItemId = reqItemId;
    }

    public String getReqDtlNo() {
        return reqDtlNo;
    }

    public void setReqDtlNo(String reqDtlNo) {
        this.reqDtlNo = reqDtlNo;
    }

    public String getAnalyzeCode() {
        return analyzeCode;
    }

    public void setAnalyzeCode(String analyzeCode) {
        this.analyzeCode = analyzeCode;
    }

    public String getAnalyzeValue() {
        return analyzeValue;
    }

    public void setAnalyzeValue(String analyzeValue) {
        this.analyzeValue = analyzeValue;
    }

    public String getMeterialCode() {
        return meterialCode;
    }

    public void setMeterialCode(String meterialCode) {
        this.meterialCode = meterialCode;
    }

    public String getMeterialValue() {
        return meterialValue;
    }

    public void setMeterialValue(String meterialValue) {
        this.meterialValue = meterialValue;
    }

    public String getMethodCode() {
        return methodCode;
    }

    public void setMethodCode(String methodCode) {
        this.methodCode = methodCode;
    }

    public String getMethodValue() {
        return methodValue;
    }

    public void setMethodValue(String methodValue) {
        this.methodValue = methodValue;
    }

    public String getSpaceCode() {
        return spaceCode;
    }

    public void setSpaceCode(String spaceCode) {
        this.spaceCode = spaceCode;
    }

    public String getSpaceValue() {
        return spaceValue;
    }

    public void setSpaceValue(String spaceValue) {
        this.spaceValue = spaceValue;
    }

    public String getSpace2Code() {
        return space2Code;
    }

    public void setSpace2Code(String space2Code) {
        this.space2Code = space2Code;
    }

    public String getSpace2Value() {
        return space2Value;
    }

    public void setSpace2Value(String space2Value) {
        this.space2Value = space2Value;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(String unitValue) {
        this.unitValue = unitValue;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getWorkGroup() {
        return workGroup;
    }

    public void setWorkGroup(String workGroup) {
        this.workGroup = workGroup;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public String getOwnerItem() {
        return ownerItem;
    }

    public void setOwnerItem(String ownerItem) {
        this.ownerItem = ownerItem;
    }

    public List<DrawdownDto> getVisualDdl() {
        return visualDdl;
    }

    public void setVisualDdl(List<DrawdownDto> visualDdl) {
        this.visualDdl = visualDdl;
    }

    public List<DrawdownDto> getColorDdl() {
        return colorDdl;
    }

    public void setColorDdl(List<DrawdownDto> colorDdl) {
        this.colorDdl = colorDdl;
    }

    public String getSpaceValueDesc() {
        return StringUtils.isEmpty(spaceValueDesc)?"":spaceValueDesc;
    }

    public void setSpaceValueDesc(String spaceValueDesc) {
        this.spaceValueDesc = spaceValueDesc;
    }
}
