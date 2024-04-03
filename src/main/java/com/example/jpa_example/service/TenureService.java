package com.example.jpa_example.service;

import com.example.jpa_example.entity.TenureEntity;
import com.example.jpa_example.repository.ITenureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenureService {
    final ITenureRepository tenureRepository;
    public TenureService(ITenureRepository tenureRepository){
        this.tenureRepository = tenureRepository;
    }

    public List<TenureEntity> getAll(){
        return this.tenureRepository.findAll();
    }
}
