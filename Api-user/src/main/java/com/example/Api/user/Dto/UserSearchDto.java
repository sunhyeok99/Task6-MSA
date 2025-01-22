package com.example.Api.user.Dto;

import java.time.LocalDateTime;
import java.util.Date;

public class UserSearchDto {
    private String userNm;
    private String userId;
    private String regiUser;
    private String updaUser;
    private LocalDateTime regiDtFrom;
    private LocalDateTime regiDtTo;
    private LocalDateTime updaDtFrom;
    private LocalDateTime updaDtTo;

    public String getUserNm() {
        return userNm;
    }

    public String getUserId() {
        return userId;
    }

    public String getRegiUser() {
        return regiUser;
    }

    public String getUpdaUser() {
        return updaUser;
    }

    public LocalDateTime getRegiDtFrom() {
        return regiDtFrom;
    }

    public LocalDateTime getRegiDtTo() {
        return regiDtTo;
    }

    public LocalDateTime getUpdaDtFrom() {
        return updaDtFrom;
    }

    public LocalDateTime getUpdaDtTo() {
        return updaDtTo;
    }
}
