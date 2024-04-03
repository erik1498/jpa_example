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
        SegmentEntity newSegmentEntity = new SegmentEntity();

        newSegmentEntity.setSegmentId(segmentInsertRequest.getSegmentId());
        newSegmentEntity.setSegmentName(segmentInsertRequest.getSegmentName());
        newSegmentEntity.setApplicationType(segmentInsertRequest.getApplicationType());
        newSegmentEntity.setChannelCode(segmentInsertRequest.getChannelCode());

        SegmentEntity savedSegment = this.segmentRepository.saveAndFlush(newSegmentEntity);
        newSegmentEntity.setSegmentId(savedSegment.getSegmentId());

        List<TenureEntity> tenureEntities = new ArrayList<>();

        for (TenureInsertRequest tenureInsertRequest : segmentInsertRequest.getTenureEntities()){
            TenureEntity tenureEntity = new TenureEntity();
            tenureEntity.setTenureId(tenureInsertRequest.getTenureId());
            tenureEntity.setMsc(tenureInsertRequest.getMsc());
            tenureEntity.setTenore(tenureInsertRequest.getTenore());
            tenureEntity.setInsuranceFee(tenureInsertRequest.getInsuranceFee());
            tenureEntity.setAdminFee(tenureInsertRequest.getAdminFee());
            tenureEntity.setSegment(savedSegment);

            TenureEntity saveTenure = this.tenureRepository.saveAndFlush(tenureEntity);
            tenureEntities.add(saveTenure);
        }
        return SegmentInsertResponse.setSegmentEntityToSegmentResponse(newSegmentEntity, tenureEntities);
    }
}
