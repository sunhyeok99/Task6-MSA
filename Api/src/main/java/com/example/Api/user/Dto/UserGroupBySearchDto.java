package com.example.Api.user.Dto;

public class UserGroupBySearchDto {

    private String regiDt;
    private Long count;


    public UserGroupBySearchDto(String regiDt, Long count) {
        this.regiDt = regiDt;
        this.count = count;
    }

    public String getRegiDate() {
        return regiDt;
    }

    public Long getCount() {
        return count;
    }
}
