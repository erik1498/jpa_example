package com.example.jpa_example.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tenure_tab")
public class TenureEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tt_tenure_id")
    private Long tenureId;
    @Column(name = "tt_msc")
    private String msc;
    @Column(name = "tt_tenore")
    private String tenore;
    @Column(name = "tt_admin_fee")
    private String adminFee;
    @Column(name = "tt_insurance_fee")
    private String insuranceFee;
    @ManyToOne(optional = true)
    @JoinColumn(name = "tt_segment_id", referencedColumnName = "st_segment_id")
    private SegmentEntity segment;

    public SegmentEntity getSegment() {
        return segment;
    }

    public void setSegment(SegmentEntity segment) {
        this.segment = segment;
    }

    public Long getTenureId() {
        return tenureId;
    }

    public void setTenureId(Long tenureId) {
        this.tenureId = tenureId;
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
