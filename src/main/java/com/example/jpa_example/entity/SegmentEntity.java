package com.example.jpa_example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "segment_tab")
@Setter
@Getter
public class SegmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_segment_id")
    private Long segmentId;
    @Column(name = "st_segment_name")
    private String segmentName;
}
