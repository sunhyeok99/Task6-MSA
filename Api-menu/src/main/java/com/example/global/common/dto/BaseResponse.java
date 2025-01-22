package com.example.global.common.dto;

public abstract class BaseResponse<T> {

    private final String status;
    private final T data;

    public BaseResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }
}