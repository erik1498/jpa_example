package com.example.jpa_example.service;

import com.example.jpa_example.entity.SegmentEntity;
import com.example.jpa_example.repository.ISegmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SegmentService {
    final ISegmentRepository segmentRepository;
    public SegmentService(ISegmentRepository segmentRepository){
        this.segmentRepository = segmentRepository;
    }
    public List<SegmentEntity> getAll() {
        return segmentRepository.findAll();
    }
}
