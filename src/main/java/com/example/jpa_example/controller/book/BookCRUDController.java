package com.example.jpa_example.controller.book;

import com.example.jpa_example.controller.BaseCRUDController;
import com.example.jpa_example.dto.GlobalResponseDTO;
import com.example.jpa_example.dto.book.request.BookSaveRequestDTO;
import com.example.jpa_example.entity.BookEntity;
import com.example.jpa_example.service.book.BookCRUDService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookCRUDController implements BaseCRUDController<BookSaveRequestDTO, BookEntity, String> {
    final BookCRUDService bookCRUDService;

    public BookCRUDController(BookCRUDService bookCRUDService) {
        this.bookCRUDService = bookCRUDService;
    }

    @Override
    public GlobalResponseDTO<List<BookEntity>> getAllData() {
        return this.bookCRUDService.getAll();
    }

    @Override
    public GlobalResponseDTO<BookEntity> insertData(@Valid @RequestBody BookSaveRequestDTO insertData, Errors errors) {
        if (errors.hasErrors()){
            return new GlobalResponseDTO<>(HttpStatus.BAD_REQUEST.value(), false, errors.getAllErrors().get(0).getDefaultMessage(), null);
        }
        return this.bookCRUDService.save(insertData);
    }

    @Override
    public GlobalResponseDTO<BookEntity> updateData(BookSaveRequestDTO updateData, String id, Errors errors) {
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
