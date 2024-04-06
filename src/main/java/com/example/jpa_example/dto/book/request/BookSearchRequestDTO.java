package com.example.jpa_example.dto.book.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BookSearchRequestDTO {
    @JsonAlias(value = {"search_by_book_name", "searchByBookName"})
    @NotNull(message = "search_by_book_name is required")
    private String searchByBookName;
}
