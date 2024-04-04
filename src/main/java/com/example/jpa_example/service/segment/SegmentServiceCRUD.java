package com.example.jpa_example.service.segment;

import com.example.jpa_example.constant.ResponseConstant;
import com.example.jpa_example.dto.GlobalResponseDTO;
import com.example.jpa_example.dto.request.SegmentRequestDTO;
import com.example.jpa_example.dto.request.TenureRequestDTO;
import com.example.jpa_example.dto.response.SegmentResponseDTO;
import com.example.jpa_example.entity.SegmentEntity;
import com.example.jpa_example.entity.TenureEntity;
import com.example.jpa_example.repository.ISegmentRepository;
import com.example.jpa_example.repository.ITenureRepository;
import com.example.jpa_example.service.base.BaseServiceAPICRUD;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SegmentServiceCRUD implements BaseServiceAPICRUD<SegmentRequestDTO, SegmentResponseDTO> {
    final ISegmentRepository segmentRepository;
    final ITenureRepository tenureRepository;

    public SegmentServiceCRUD(ISegmentRepository segmentRepository, ITenureRepository tenureRepository) {
        this.segmentRepository = segmentRepository;
        this.tenureRepository = tenureRepository;
    }

    @Override
    public GlobalResponseDTO<List<SegmentResponseDTO>> getAll() {
        try{
            List<SegmentEntity> segmentEntities = this.segmentRepository.findAll();

            List<SegmentResponseDTO> segmentInsertResponseDTOS = new ArrayList<>();

            for (SegmentEntity segmentEntity : segmentEntities){
                List<TenureEntity> tenureEntities = this.tenureRepository.findBySegment(segmentEntity);
                segmentInsertResponseDTOS.add(SegmentResponseDTO.setSegmentEntityToSegmentResponse(segmentEntity, tenureEntities));
            }

            return new GlobalResponseDTO<>(HttpStatus.OK.value(), true, ResponseConstant.SUCCESS, segmentInsertResponseDTOS);
        }catch (Exception e){
            return new GlobalResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), false, e.getLocalizedMessage(), null);
        }
    }

    @Override
    public GlobalResponseDTO<SegmentResponseDTO> save(SegmentRequestDTO segmentRequestDTO) {
        try{
            SegmentEntity segment = new SegmentEntity();

            Optional<SegmentEntity> segmentEntity = this.segmentRepository.findById(segmentRequestDTO.getSegmentId());

            if (segmentEntity.isPresent()) {
                segment = segmentEntity.get();
            }else{
                segment.setSegmentId(segmentRequestDTO.getSegmentId());
            }

            segment.setSegmentName(segmentRequestDTO.getSegmentName());
            segment.setApplicationType(segmentRequestDTO.getApplicationType());
            segment.setChannelCode(segmentRequestDTO.getChannelCode());

            SegmentEntity savedSegment = this.segmentRepository.saveAndFlush(segment);
            segment.setSegmentId(savedSegment.getSegmentId());

            List<TenureEntity> tenureEntities = new ArrayList<>();

            for (TenureRequestDTO tenureRequestDTO : segmentRequestDTO.getTenureEntities()){
                TenureEntity tenure = new TenureEntity();

                Optional<TenureEntity> tenureEntity = this.tenureRepository.findById(tenureRequestDTO.getTenureId());

                if (tenureEntity.isPresent()){
                    tenure = tenureEntity.get();
                }

                tenure.setTenureId(tenureRequestDTO.getTenureId());
                tenure.setMsc(tenureRequestDTO.getMsc());
                tenure.setTenore(tenureRequestDTO.getTenore());
                tenure.setInsuranceFee(tenureRequestDTO.getInsuranceFee());
                tenure.setAdminFee(tenureRequestDTO.getAdminFee());
                tenure.setSegment(savedSegment);

                TenureEntity saveTenure = this.tenureRepository.saveAndFlush(tenure);
                tenureEntities.add(saveTenure);
            }
            return new GlobalResponseDTO<>(HttpStatus.OK.value(), true, ResponseConstant.SUCCESS, SegmentResponseDTO.setSegmentEntityToSegmentResponse(segment, tenureEntities));
        }catch (Exception e){
            return new GlobalResponseDTO<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), false, e.getLocalizedMessage(), null);
        }
    }
}
