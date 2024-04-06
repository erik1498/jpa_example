package com.example.jpa_example.controller;

import com.example.jpa_example.dto.GlobalResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface BaseCRUDController<P, Q, R, S> {
    @GetMapping("/all")
    GlobalResponseDTO<List<Q>> getAllData();
    @GetMapping("/page/{size}/{page}/{sortingBy}/{sortingType}")
    GlobalResponseDTO<Page<Q>> getAllBySizeAndPage(@Valid @RequestBody S searchRequest, @PathVariable("size") Integer size, @PathVariable("page") Integer page, @PathVariable("sortingBy") String sortingBy, @PathVariable("sortingType") String sortingType, Errors errors);
    @PostMapping("/save")
    GlobalResponseDTO<Q> insertData(@Valid @RequestBody P insertData, Errors errors);
    @PutMapping("/update/{id}")
    GlobalResponseDTO<Q> updateData(@Valid @RequestBody P updateData, @PathVariable("id") R id, Errors errors);
    @DeleteMapping("/delete/{id}")
    GlobalResponseDTO<Boolean> deleteData(@PathVariable("id") R id);
}
