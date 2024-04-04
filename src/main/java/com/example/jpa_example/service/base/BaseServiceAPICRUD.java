package com.example.jpa_example.service.base;

import com.example.jpa_example.dto.GlobalResponseDTO;

import java.util.List;

public interface BaseServiceAPICRUD<TRequest, TResponse> {
    public GlobalResponseDTO<List<TResponse>> getAll();
    public GlobalResponseDTO<TResponse> save(TRequest request);
}
