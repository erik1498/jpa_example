package com.example.jpa_example.dto.response;

import com.example.jpa_example.entity.SegmentEntity;
import com.example.jpa_example.entity.TenureEntity;

import java.util.ArrayList;
import java.util.List;

public class SegmentResponseDTO {
    public Long segmentId;
    public String segmentName;
    public String applicationType;
    public String channelCode;
    public List<TenureResponseDTO> tenureEntities = new ArrayList<>();

    public static SegmentResponseDTO setSegmentEntityToSegmentResponse(SegmentEntity segmentEntity, List<TenureEntity> tenureEntities) {
        SegmentResponseDTO response = new SegmentResponseDTO();
        response.setSegmentId(segmentEntity.getSegmentId());
        response.setSegmentName(segmentEntity.getSegmentName());
        response.setApplicationType(segmentEntity.getApplicationType());
        response.setChannelCode(segmentEntity.getChannelCode());

        for (TenureEntity tenureEntity : tenureEntities){
            TenureResponseDTO tenureResponseDTO = getTenureInsertResponse(segmentEntity, tenureEntity);
            response.getTenureEntities().add(tenureResponseDTO);
        }
        return response;
    }

    private static TenureResponseDTO getTenureInsertResponse(SegmentEntity segmentEntity, TenureEntity tenureEntity) {
        TenureResponseDTO tenureResponseDTO = new TenureResponseDTO();

        tenureResponseDTO.setSegmentId(segmentEntity.getSegmentId());
        tenureResponseDTO.setTenureId(tenureEntity.getTenureId());
        tenureResponseDTO.setAdminFee(tenureEntity.getAdminFee());
        tenureResponseDTO.setMsc(tenureEntity.getMsc());
        tenureResponseDTO.setTenore(tenureEntity.getTenore());
        tenureResponseDTO.setInsuranceFee(tenureEntity.getInsuranceFee());
        return tenureResponseDTO;
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

    public List<TenureResponseDTO> getTenureEntities() {
        return tenureEntities;
    }

    public void setTenureEntities(List<TenureResponseDTO> tenureEntities) {
        this.tenureEntities = tenureEntities;
    }
}
