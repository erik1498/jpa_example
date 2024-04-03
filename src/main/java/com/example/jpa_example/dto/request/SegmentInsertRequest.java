package com.example.jpa_example.dto.request;

import javax.validation.constraints.NotNull;
import java.util.List;
public class SegmentInsertRequest {
    @NotNull(message = "segmentId is required")
    public Long segmentId;
    @NotNull(message = "segmentName is required")
    public String segmentName;
    @NotNull(message = "applicationType is required")
    public String applicationType;
    @NotNull(message = "channelCode is required")
    public String channelCode;
    public List<TenureInsertRequest> tenureEntities;

    public Long getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(Long segmentId) {
        this.segmentId = segmentId;
    }

    public String getSegmentName() {
        return segmentName;
    }

    public void setSegmentName(String segmentName) {
        this.segmentName = segmentName;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public List<TenureInsertRequest> getTenureEntities() {
        return tenureEntities;
    }

    public void setTenureEntities(List<TenureInsertRequest> tenureEntities) {
        this.tenureEntities = tenureEntities;
    }
}
