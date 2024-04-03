package com.example.jpa_example.controller;

import com.example.jpa_example.entity.SegmentEntity;
import com.example.jpa_example.service.SegmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/segment")
public class SegmentController {
    final SegmentService segmentService;
    public SegmentController(SegmentService segmentService) {
        this.segmentService = segmentService;
    }
    @GetMapping("/all")
    public List<SegmentEntity> getAllSegment(){
        return this.segmentService.getAll();
    }
}
