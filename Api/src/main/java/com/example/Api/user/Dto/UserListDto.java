package com.example.Api.user.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.LocalDateTime;
import java.util.Date;
// 전체 데이터 조회할 때 사용
public class UserListDto {

    private Integer id;
    private String userNm;
    private String userId;
    private String pw;
    private LocalDateTime regiDt;
    private String regiUser;
    private LocalDateTime updaDt;
    private String updaUser;
    private String useYn = "Y";

    public UserListDto(Integer id, String userNm, String userId, String pw, LocalDateTime regiDt, String regiUser, String updaUser, LocalDateTime updaDt, String useYn) {
        this.id = id;
        this.userNm = userNm;
        this.userId = userId;
        this.pw = pw;
        this.regiDt = regiDt;
        this.regiUser = regiUser;
        this.updaUser = updaUser;
        this.updaDt = updaDt;
        this.useYn = useYn;
    }
    // getter
    public Integer getId() {
        return id;
    }

    public String getuserNm() {
        return userNm;
    }

    public String getuserId() {
        return userId;
    }

    public String getPw() {
        return pw;
    }

    public LocalDateTime getregiDt() {
        return regiDt;
    }

    public String getregiUser() {
        return regiUser;
    }

    public LocalDateTime getupdaDt() {
        return updaDt;
    }

    public String getupdaUser() {
        return updaUser;
    }

    public String getuseYn() {
        return useYn;
    }

}
