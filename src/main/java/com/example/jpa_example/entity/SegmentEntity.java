package com.example.jpa_example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "segment_tab")
public class SegmentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_segment_id")
    private Long segmentId;
    @Column(name = "st_segment_name")
    private String segmentName;
    @Column(name = "st_application_type")
    private String applicationType;
    @Column(name = "st_channel_code")
    private String channelCode;
    @OneToMany(mappedBy = "segment")
    private List<TenureEntity> tenureEntities = new ArrayList<>();

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

    public List<TenureEntity> getTenureEntities() {
        return tenureEntities;
    }

    public void setTenureEntities(List<TenureEntity> tenureEntities) {
        this.tenureEntities = tenureEntities;
    }
}
