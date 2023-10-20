package th.co.pt.ptgapp.service.ws.lotusnotes.dto;

import java.io.Serializable;

public class RandomSampleDto implements Serializable {

    private String labCode;
    private String plantId;
    private String productCode;
    private String sampleTypeName;
    private String assignStatus;

    public RandomSampleDto() {
    }

    public RandomSampleDto(String labCode, String plantId, String productCode, String sampleTypeName, String assignStatus) {
        this.labCode = labCode;
        this.plantId = plantId;
        this.productCode = productCode;
        this.sampleTypeName = sampleTypeName;
        this.assignStatus = assignStatus;
    }

    public String getLabCode() {
        return labCode;
    }

    public void setLabCode(String labCode) {
        this.labCode = labCode;
    }

    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getSampleTypeName() {
        return sampleTypeName;
    }

    public void setSampleTypeName(String sampleTypeName) {
        this.sampleTypeName = sampleTypeName;
    }

    public String getAssignStatus() {
        return assignStatus;
    }

    public void setAssignStatus(String assignStatus) {
        this.assignStatus = assignStatus;
    }
}
