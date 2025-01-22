package com.example.Api.menu.Entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TEST_SUNHYEOK99_MENU", schema = "TEST")
public class Menu {

    @Id
    @Column(name = "menu_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY 방식으로 자동 생성
    private Integer menuId;

    @Column(name = "menu_nm", nullable = false, length = 50)
    private String menuNm;

    @Column(name = "sort", nullable = false)
    private Integer sort;

    @Column(name = "upr_menu_id", nullable = false)
    private Integer uprMenuId;

    @Column(name = "url", nullable = false, length = 250)
    private String url;

    @Column(name = "use_yn", nullable = false, length = 1)
    private String useYn = "Y";

    @Column(name = "regi_user", nullable = false, length = 20)
    private String regiUser;

    @Column(name = "REGI_DT", nullable = false)
    private LocalDateTime regiDt = LocalDateTime.now();

    @Column(name = "upda_user", length = 20)
    private String updaUser;

    @Column(name = "upda_dt")
    private LocalDateTime updaDt;

    public Menu(Integer menuId, String menuNm, Integer sort, Integer uprMenuId, String url, String useYn, String regiUser, LocalDateTime regiDt, String updaUser, LocalDateTime updaDt) {
        this.menuId = menuId;
        this.menuNm = menuNm;
        this.sort = sort;
        this.uprMenuId = uprMenuId;
        this.url = url;
        this.useYn = useYn;
        this.regiUser = regiUser;
        this.regiDt = regiDt;
        this.updaUser = updaUser;
        this.updaDt = updaDt;
    }

    public Menu(LocalDateTime regiDt, String useYn, String url, Integer uprMenuId, Integer sort, String menuNm, Integer menuId) {
        this.regiDt = regiDt;
        this.useYn = useYn;
        this.url = url;
        this.uprMenuId = uprMenuId;
        this.sort = sort;
        this.menuNm = menuNm;
        this.menuId = menuId;
    }

    public Menu(String menuNm, Integer sort, Integer uprMenuId, String url, String regiUser) {
        this.menuNm = menuNm;
        this.sort = sort;
        this.uprMenuId = uprMenuId;
        this.url = url;
        this.regiUser = regiUser;
    }

    public Menu() {

    }

    public Integer getMenuId() {
        return menuId;
    }

    public String getMenuNm() {
        return menuNm;
    }

    public Integer getSort() {
        return sort;
    }

    public Integer getUprMenuId() {
        return uprMenuId;
    }

    public String getUrl() {
        return url;
    }

    public String getUseYn() {
        return useYn;
    }

    public LocalDateTime getRegiDt() {
        return regiDt;
    }

    public String getUpdaUser() {
        return updaUser;
    }

    public LocalDateTime getUpdaDt() {
        return updaDt;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public void setMenuNm(String menuNm) {
        this.menuNm = menuNm;
    }

    public String getRegiUser() {
        return regiUser;
    }

    public void setRegiUser(String regiUser) {
        this.regiUser = regiUser;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public void setUprMenuId(Integer uprMenuId) {
        this.uprMenuId = uprMenuId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }

    public void setRegiDt(LocalDateTime regiDt) {
        this.regiDt = regiDt;
    }

    public void setUpdaUser(String updaUser) {
        this.updaUser = updaUser;
    }

    public void setUpdaDt(LocalDateTime updaDt) {
        this.updaDt = updaDt;
    }

}