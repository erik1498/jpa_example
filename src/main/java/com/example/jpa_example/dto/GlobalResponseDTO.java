package com.example.jpa_example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GlobalResponseDTO<T> {
    private Integer code;
    private Boolean status;
    private String message;
    private T data;
}
