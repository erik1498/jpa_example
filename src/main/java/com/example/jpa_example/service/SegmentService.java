package com.example.jpa_example.service;

import com.example.jpa_example.dto.request.SegmentInsertRequest;
import com.example.jpa_example.dto.request.TenureInsertRequest;
import com.example.jpa_example.dto.response.SegmentInsertResponse;
import com.example.jpa_example.entity.SegmentEntity;
import com.example.jpa_example.entity.TenureEntity;
import com.example.jpa_example.repository.ISegmentRepository;
import com.example.jpa_example.repository.ITenureRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SegmentService {
    final ISegmentRepository segmentRepository;
    final ITenureRepository tenureRepository;
    public SegmentService(ISegmentRepository segmentRepository, ITenureRepository tenureRepository){
        this.segmentRepository = segmentRepository;
        this.tenureRepository = tenureRepository;
    }
    public List<SegmentInsertResponse> getAll() {
        List<SegmentEntity> segmentEntities = this.segmentRepository.findAll();
        List<SegmentInsertResponse> segmentInsertResponses = new ArrayList<>();

       for (SegmentEntity segmentEntity : segmentEntities){
           List<TenureEntity> tenureEntities = this.tenureRepository.findBySegment(segmentEntity);
           segmentInsertResponses.add(SegmentInsertResponse.setSegmentEntityToSegmentResponse(segmentEntity, tenureEntities));
       }

       return segmentInsertResponses;

    }

    public SegmentInsertResponse saveSegmentEntity(SegmentInsertRequest segmentInsertRequest){
        Optional<SegmentEntity> segmentEntity = this.segmentRepository.findById(segmentInsertRequest.getSegmentId());

        SegmentEntity segment = new SegmentEntity();
        if (segmentEntity.isPresent()){
            segment = segmentEntity.get();
        }else {
            segment.setSegmentId(segmentInsertRequest.getSegmentId());
        }

        segment.setSegmentName(segmentInsertRequest.getSegmentName());
        segment.setApplicationType(segmentInsertRequest.getApplicationType());
        segment.setChannelCode(segmentInsertRequest.getChannelCode());

        SegmentEntity savedSegment = this.segmentRepository.saveAndFlush(segment);
        segment.setSegmentId(savedSegment.getSegmentId());

        List<TenureEntity> tenureEntities = new ArrayList<>();

        for (TenureInsertRequest tenureInsertRequest : segmentInsertRequest.getTenureEntities()){
            TenureEntity tenure = new TenureEntity();

            Optional<TenureEntity> tenureEntity = this.tenureRepository.findById(tenureInsertRequest.getTenureId());

            if (tenureEntity.isPresent()){
                tenure = tenureEntity.get();
            }

            tenure.setTenureId(tenureInsertRequest.getTenureId());
            tenure.setMsc(tenureInsertRequest.getMsc());
            tenure.setTenore(tenureInsertRequest.getTenore());
            tenure.setInsuranceFee(tenureInsertRequest.getInsuranceFee());
            tenure.setAdminFee(tenureInsertRequest.getAdminFee());
            tenure.setSegment(savedSegment);

            TenureEntity saveTenure = this.tenureRepository.saveAndFlush(tenure);
            tenureEntities.add(saveTenure);
        }
        return SegmentInsertResponse.setSegmentEntityToSegmentResponse(segment, tenureEntities);
    }
}
