package com.example.jpa_example.dto.response;

public class TenureResponseDTO {
    public Long tenureId;
    public Long segmentId;
    public String msc;
    public String tenore;
    public String adminFee;
    public String insuranceFee;

    public Long getTenureId() {
        return tenureId;
    }

    public void setTenureId(Long tenureId) {
        this.tenureId = tenureId;
    }

    public Long getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(Long segmentId) {
        this.segmentId = segmentId;
    }

    public String getMsc() {
        return msc;
    }

    public void setMsc(String msc) {
        this.msc = msc;
    }

    public String getTenore() {
        return tenore;
    }

    public void setTenore(String tenore) {
        this.tenore = tenore;
    }

    public String getAdminFee() {
        return adminFee;
    }

    public void setAdminFee(String adminFee) {
        this.adminFee = adminFee;
    }

    public String getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(String insuranceFee) {
        this.insuranceFee = insuranceFee;
    }
}
