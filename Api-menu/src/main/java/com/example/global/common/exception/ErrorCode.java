package com.example.global.common.exception;

public enum ErrorCode {

    MENU_NOT_FOUND_ERROR1(404, "존재하지 않는 메뉴입니다. 수정 실패"),

    MENU_NOT_FOUND_ERROR2(404, "존재하지 않는 메뉴입니다. 삭제 실패"),

    MENU_ALREADY_EXIST_ERROR(404, "이미 존재하는 메뉴입니다.");

    private final int status;
    private final String message;

    ErrorCode(int status, String message) {
        System.out.println(status +" "+message);
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
