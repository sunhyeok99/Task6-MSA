package com.example.Api.user.Dto;

import java.util.Date;

// 유저 등록할 때 사용
public class UserDto {

    private String userNm;
    private String userId;
    private String pw;
    private String regiUser;

    // 생성자
    public UserDto(String userNm, String userId, String pw, String regiUser) {
        this.userNm = userNm;
        this.userId = userId;
        this.pw = pw;
        this.regiUser = regiUser;
    }

    // Getter
    public String getUserNm() {
        return userNm;
    }

    public String getUserId() {
        return userId;
    }

    public String getPw() {
        return pw;
    }

    public String getRegiUser() {
        return regiUser;
    }

}
