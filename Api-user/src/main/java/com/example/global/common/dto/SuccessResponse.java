package com.example.global.common.dto;

public class SuccessResponse<T> extends BaseResponse<T> {
    public SuccessResponse(T data) {
        super("success", data);
    }
}