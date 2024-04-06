package com.example.jpa_example.service;

import com.example.jpa_example.dto.GlobalResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BaseCRUDService<TRequest, TResponse, TIdType, TSearchRequest> {
    GlobalResponseDTO<List<TResponse>> getAll();
    GlobalResponseDTO<TResponse> save(TRequest saveRequest);
    GlobalResponseDTO<TResponse> update(TRequest updateRequest, TIdType id);
    GlobalResponseDTO<Boolean> delete(TIdType id);
    GlobalResponseDTO<Page<TResponse>> getAllBySizeAndPage(TSearchRequest searchRequest, Integer size, Integer page, String sortingBy, String sortingType);
}
