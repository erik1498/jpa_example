package com.example.jpa_example.dto.response;

import com.example.jpa_example.dto.request.TenureInsertRequest;
import com.example.jpa_example.entity.SegmentEntity;
import com.example.jpa_example.entity.TenureEntity;

import java.util.ArrayList;
import java.util.List;

public class SegmentInsertResponse {
    public Long segmentId;
    public String segmentName;
    public String applicationType;
    public String channelCode;
    public List<TenureInsertResponse> tenureEntities = new ArrayList<>();

    public static SegmentInsertResponse setSegmentEntityToSegmentResponse(SegmentEntity segmentEntity, List<TenureEntity> tenureEntities) {
        SegmentInsertResponse response = new SegmentInsertResponse();
        response.setSegmentId(segmentEntity.getSegmentId());
        response.setSegmentName(segmentEntity.getSegmentName());
        response.setApplicationType(segmentEntity.getApplicationType());
        response.setChannelCode(segmentEntity.getChannelCode());

        for (TenureEntity tenureEntity : tenureEntities){
            TenureInsertResponse tenureInsertResponse = getTenureInsertResponse(segmentEntity, tenureEntity);
            response.getTenureEntities().add(tenureInsertResponse);
        }
        return response;
    }

    private static TenureInsertResponse getTenureInsertResponse(SegmentEntity segmentEntity, TenureEntity tenureEntity) {
        TenureInsertResponse tenureInsertResponse = new TenureInsertResponse();

        tenureInsertResponse.setSegmentId(segmentEntity.getSegmentId());
        tenureInsertResponse.setTenureId(tenureEntity.getTenureId());
        tenureInsertResponse.setAdminFee(tenureEntity.getAdminFee());
        tenureInsertResponse.setMsc(tenureEntity.getMsc());
        tenureInsertResponse.setTenore(tenureEntity.getTenore());
        tenureInsertResponse.setInsuranceFee(tenureEntity.getInsuranceFee());
        return tenureInsertResponse;
    }

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

    public List<TenureInsertResponse> getTenureEntities() {
        return tenureEntities;
    }

    public void setTenureEntities(List<TenureInsertResponse> tenureEntities) {
        this.tenureEntities = tenureEntities;
    }
}
