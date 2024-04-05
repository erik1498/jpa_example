package com.example.jpa_example.dto.book.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class BookSaveRequestDTO {
    @JsonAlias(value = {"book_name", "bookName"})
    @NotNull(message = "book_name is required")
    @NotEmpty(message = "book_name is required")
    private String bookName;

    @JsonAlias(value = {"book_year", "bookYear"})
    @NotNull(message = "book_year is required")
    private Integer bookYear;
}
