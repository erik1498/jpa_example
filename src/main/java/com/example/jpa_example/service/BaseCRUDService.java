package com.example.jpa_example.service;

import com.example.jpa_example.dto.GlobalResponseDTO;

import java.util.List;

public interface BaseCRUDService<TRequest, TResponse, TIdType> {
    GlobalResponseDTO<List<TResponse>> getAll();
    GlobalResponseDTO<TResponse> save(TRequest saveRequest);
    GlobalResponseDTO<TResponse> update(TRequest updateRequest, TIdType id);
    GlobalResponseDTO<Boolean> delete(TIdType id);
}
