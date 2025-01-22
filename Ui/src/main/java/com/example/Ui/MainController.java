package com.example.Ui;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    // index.html 반환
    public String index() {
        return "index";
    }

    @GetMapping("/page1")
    // page1.html을 반환
    public String page1() {
        return "page1";
    }

    @GetMapping("/page2")
    public String getMenuPage() {
        return "page2"; // 메뉴 관리 페이지
    }

}
