package com.example.Api.menu.Repository;

import com.example.Api.menu.Entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    Menu findByMenuNm(String menuNm);

}
