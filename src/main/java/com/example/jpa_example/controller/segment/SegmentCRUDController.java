package com.example.jpa_example.controller.segment;

import com.example.jpa_example.controller.base.BaseAPICRUD;
import com.example.jpa_example.dto.GlobalResponseDTO;
import com.example.jpa_example.dto.request.SegmentRequestDTO;
import com.example.jpa_example.dto.response.SegmentResponseDTO;
import com.example.jpa_example.service.segment.SegmentServiceCRUD;
import jdk.jfr.Name;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/segment")
public class SegmentCRUDController implements BaseAPICRUD<SegmentRequestDTO, SegmentResponseDTO> {

    final SegmentServiceCRUD segmentService;

    public SegmentCRUDController(SegmentServiceCRUD segmentService) {
        this.segmentService = segmentService;
    }

    @Override
    public GlobalResponseDTO<List<SegmentResponseDTO>> getAllData() {
        return this.segmentService.getAll();
    }

    @Override
    public GlobalResponseDTO<SegmentResponseDTO> insertData(SegmentRequestDTO insertData, Errors errors) {
        if (errors.hasErrors()){
            return new GlobalResponseDTO<>(HttpStatus.BAD_REQUEST.value(), false, errors.getAllErrors().get(0).getDefaultMessage(), null);
        }
        return this.segmentService.save(insertData);
    }
}
