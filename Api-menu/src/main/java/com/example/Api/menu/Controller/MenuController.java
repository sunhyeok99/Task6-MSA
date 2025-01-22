package com.example.Api.menu.Controller;

import com.example.Api.menu.Entity.Menu;
import com.example.Api.menu.Service.MenuService;
import com.example.global.common.dto.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bi/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    // 메뉴 조회
    @GetMapping("/table")
    public List<Menu> getMenuTable() {
        return menuService.getAllMenus();
    }

    // 메뉴 등록
    @PostMapping("/regi")
    public SuccessResponse<?> registerMenu(@RequestBody Menu menu) {
        menuService.saveMenu(menu);
        return new SuccessResponse<>(HttpStatus.OK.value());
    }

    // 메뉴 삭제
    @PostMapping("/delete/{id}")
    public SuccessResponse<?> deleteMenu(@PathVariable Integer id) {
        menuService.deleteMenu(id);
        return new SuccessResponse<>(HttpStatus.OK.value());
    }
}
