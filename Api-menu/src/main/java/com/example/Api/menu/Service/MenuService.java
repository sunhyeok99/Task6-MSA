package com.example.Api.menu.Service;

import com.example.Api.menu.Entity.Menu;
import com.example.Api.menu.Repository.MenuRepository;
import com.example.global.common.exception.CustomException;
import com.example.global.common.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    // 메뉴 목록 조회
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    // 메뉴 등록
    @Transactional
    public void saveMenu(Menu menu) {
        Menu tmpMenu = menuRepository.findByMenuNm(menu.getMenuNm());
        // 이미 존재하는 메뉴 이름인지 확인
        if(tmpMenu != null){
            throw new CustomException(ErrorCode.MENU_ALREADY_EXIST_ERROR);
        }
        menuRepository.save(menu);
    }

    // 메뉴 삭제
    @Transactional
    public void deleteMenu(Integer menuId) {
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new CustomException(ErrorCode.MENU_NOT_FOUND_ERROR2));
        // 현재 선택한 메뉴가 이미 N인지 확인
        if(menu.getUseYn().equals("N")){
            throw new CustomException(ErrorCode.MENU_NOT_FOUND_ERROR2);
        }
        menu.setUseYn("N");
    }

}
