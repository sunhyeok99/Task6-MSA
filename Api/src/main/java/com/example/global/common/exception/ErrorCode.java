package com.example.global.common.exception;

public enum ErrorCode {

    USER_NOT_FOUND_ERROR1(404, "존재하지 않는 유저입니다. 수정 실패"),

    USER_NOT_FOUND_ERROR2(404, "존재하지 않는 유저입니다. 삭제 실패"),

    USER_ALREADY_EXIST_ERROR(405, "이미 존재하는 회원아이디 입니다.");

    private final int status;
    private final String message;

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
