package com.example.jpa_example.controller.book;

import com.example.jpa_example.controller.BaseCRUDController;
import com.example.jpa_example.dto.GlobalResponseDTO;
import com.example.jpa_example.dto.book.request.BookSearchRequestDTO;
import com.example.jpa_example.dto.book.request.BookSaveRequestDTO;
import com.example.jpa_example.entity.BookEntity;
import com.example.jpa_example.service.book.BookCRUDService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookCRUDController implements BaseCRUDController<BookSaveRequestDTO, BookEntity, String, BookSearchRequestDTO> {
    final BookCRUDService bookCRUDService;

    public BookCRUDController(BookCRUDService bookCRUDService) {
        this.bookCRUDService = bookCRUDService;
    }

    @Override
    public GlobalResponseDTO<List<BookEntity>> getAllData() {
        return this.bookCRUDService.getAll();
    }

    @Override
    public GlobalResponseDTO<Page<BookEntity>> getAllBySizeAndPage(BookSearchRequestDTO bookSearchRequestDTO, Integer size, Integer page, String sortingBy, String sortingType, Errors errors) {
        if (errors.hasErrors()){
            List<String> errorList = new ArrayList<>();
            for (ObjectError error : errors.getAllErrors())
                errorList.add(error.getDefaultMessage());
            return new GlobalResponseDTO<>(HttpStatus.BAD_REQUEST.value(), false, String.join(",", errorList), null);
        }
        return this.bookCRUDService.getAllBySizeAndPage(bookSearchRequestDTO, size, page, sortingBy, sortingType);
    }

    @Override
    public GlobalResponseDTO<BookEntity> insertData(@Valid BookSaveRequestDTO insertData, Errors errors) {
        if (errors.hasErrors()){
            return new GlobalResponseDTO<>(HttpStatus.BAD_REQUEST.value(), false, errors.getAllErrors().get(0).getDefaultMessage(), null);
        }
        return this.bookCRUDService.save(insertData);
    }

    @Override
    public GlobalResponseDTO<BookEntity> updateData(@Valid BookSaveRequestDTO updateData, String id, Errors errors) {
        if (errors.hasErrors()){
            return new GlobalResponseDTO<>(HttpStatus.BAD_REQUEST.value(), false, errors.getAllErrors().get(0).getDefaultMessage(), null);
        }
        return this.bookCRUDService.update(updateData, id);
    }

    @Override
    public GlobalResponseDTO<Boolean> deleteData(String id) {
        return this.bookCRUDService.delete(id);
    }
}
