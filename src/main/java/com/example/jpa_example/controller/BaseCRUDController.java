package com.example.jpa_example.controller;

import com.example.jpa_example.dto.GlobalResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface BaseCRUDController<TRequest, TResponse, TIdType, TSearchRequest> {
    @GetMapping("/all")
    GlobalResponseDTO<List<TResponse>> getAllData();
    @GetMapping("/page/{size}/{page}/{sortingBy}/{sortingType}")
    GlobalResponseDTO<Page<TResponse>> getAllBySizeAndPage(@Valid @RequestBody TSearchRequest searchRequest, @PathVariable("size") Integer size, @PathVariable("page") Integer page, @PathVariable("sortingBy") String sortingBy, @PathVariable("sortingType") String sortingType, Errors errors);
    @PostMapping("/save")
    GlobalResponseDTO<TResponse> insertData(@Valid @RequestBody TRequest insertData, Errors errors);
    @PutMapping("/update/{id}")
    GlobalResponseDTO<TResponse> updateData(@Valid @RequestBody TRequest updateData, @PathVariable("id") TIdType id, Errors errors);
    @DeleteMapping("/delete/{id}")
    GlobalResponseDTO<Boolean> deleteData(@PathVariable("id") TIdType id);
}
