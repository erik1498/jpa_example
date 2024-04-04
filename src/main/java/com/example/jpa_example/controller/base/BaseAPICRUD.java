package com.example.jpa_example.controller.base;

import com.example.jpa_example.dto.GlobalResponseDTO;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface BaseAPICRUD<TRequest, TResponse> {
    @GetMapping("/")
    public GlobalResponseDTO<List<TResponse>> getAllData();
    @PostMapping("/")
    public GlobalResponseDTO<TResponse> insertData(@Valid @RequestBody TRequest insertData, Errors errors);
}
