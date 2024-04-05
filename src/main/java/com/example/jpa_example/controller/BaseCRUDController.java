package com.example.jpa_example.controller;

import com.example.jpa_example.dto.GlobalResponseDTO;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface BaseCRUDController<TRequest, TResponse, TIdType> {
    @GetMapping("/all")
    GlobalResponseDTO<List<TResponse>> getAllData();
    @PostMapping("/save")
    GlobalResponseDTO<TResponse> insertData(@Valid @RequestBody TRequest insertData, Errors errors);
    @PutMapping("/update/{id}")
    GlobalResponseDTO<TResponse> updateData(@Valid @RequestBody TRequest updateData, @PathVariable("id") TIdType id, Errors errors);
    @DeleteMapping("/delete/{id}")
    GlobalResponseDTO<Boolean> deleteData(@PathVariable("id") TIdType id);
}
