package com.example.jpa_example.service;

import com.example.jpa_example.dto.GlobalResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BaseCRUDService<P, Q, R, S> {
    GlobalResponseDTO<List<Q>> getAll();
    GlobalResponseDTO<Q> save(P saveRequest);
    GlobalResponseDTO<Q> update(P updateRequest, R id);
    GlobalResponseDTO<Boolean> delete(R id);
    GlobalResponseDTO<Page<Q>> getAllBySizeAndPage(S searchRequest, Integer size, Integer page, String sortingBy, String sortingType);
}
