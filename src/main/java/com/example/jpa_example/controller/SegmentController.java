package com.example.jpa_example.controller;

import com.example.jpa_example.dto.request.SegmentInsertRequest;
import com.example.jpa_example.dto.response.SegmentInsertResponse;
import com.example.jpa_example.entity.SegmentEntity;
import com.example.jpa_example.entity.TenureEntity;
import com.example.jpa_example.service.SegmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/segment")
public class SegmentController {
    final SegmentService segmentService;
    public SegmentController(SegmentService segmentService) {
        this.segmentService = segmentService;
    }
    @GetMapping("/")
    public List<SegmentInsertResponse> getAllSegment(){
        return this.segmentService.getAll();
    }

    @PostMapping("/")
    public ResponseEntity<SegmentInsertResponse> saveSegment(@Valid @RequestBody SegmentInsertRequest segmentInsertRequest, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(500).body(null);
        }
        SegmentInsertResponse response = this.segmentService.saveSegmentEntity(segmentInsertRequest);
        return ResponseEntity.ok(response);
    }
}
