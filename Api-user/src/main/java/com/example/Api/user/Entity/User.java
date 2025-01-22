package com.example.Api.user.Entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TEST_SUNHYEOK99_USER" ,schema = "TEST")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "user_nm", nullable = false)
    private String userNm;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "PW", nullable = false)
    private String pw;

    @Column(name = "regi_dt")
    private LocalDateTime regiDt;

    @Column(name = "regi_user", nullable = false)
    private String regiUser;

    @Column(name = "upda_dt")
    private LocalDateTime updaDt;

    @Column(name = "upda_user")
    private String updaUser;

    @Column(name = "use_yn", nullable = false)
    private String useYn = "Y";

    // 생성자
    public User() {

    }
    public User(String userNm, String userId, String pw, LocalDateTime regiDt, String regiUser, String useYn) {
        this.userNm = userNm;
        this.userId = userId;
        this.pw = pw;
        this.regiDt = regiDt;
        this.regiUser = regiUser;
        this.useYn = useYn;
    }
    public User(String userNm, String userId, String pw, String regiUser) {
        this.userNm = userNm;
        this.userId = userId;
        this.pw = pw;
        this.regiDt = LocalDateTime.now();
        this.regiUser = regiUser;
        this.useYn = "Y";
    }

    public User(String userNm, String userId, String regiUser, String updaUser, LocalDateTime regiDt, LocalDateTime updaDt) {
        this.userNm = userNm;
        this.userId = userId;
        this.regiUser = regiUser;
        this.updaUser = updaUser;
        this.regiDt = regiDt;
        this.updaDt = updaDt;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getUserNm() {
        return userNm;
    }

    public String getUserId() {
        return userId;
    }

    public String getPw() {
        return pw;
    }

    public LocalDateTime getRegiDt() {
        return regiDt;
    }

    public String getRegiUser() {
        return regiUser;
    }

    public LocalDateTime getUpdaDt() {
        return updaDt;
    }


    public String getUpdaUser() {
        return updaUser;
    }

    public String getUseYn() {
        return useYn;
    }

    // 수정 메서드
    public void update(){
        this.updaUser = this.regiUser;
        this.updaDt = LocalDateTime.now();
    }

    // 삭제 메서드
    public void delete() {
        this.updaUser = this.regiUser;
        this.updaDt = LocalDateTime.now();
        this.useYn = "N";
    }

}
