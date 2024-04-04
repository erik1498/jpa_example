package com.example.jpa_example.dto;


public class GlobalResponseDTO<T> {
    private Integer code;
    private Boolean status;
    private String message;
    private T data;

    public GlobalResponseDTO(Integer code, Boolean status, String message, T data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
