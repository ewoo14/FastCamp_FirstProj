package com.sparta.project.controller;

import com.sparta.project.dto.MenuRequest;
import com.sparta.project.dto.MenuResponse;
import com.sparta.project.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {

    private MenuService menuService;

    // 음식점 메뉴 조회
    @GetMapping("/stores/{store_id}")
    public List<MenuResponse> getMenusByStore(@PathVariable String store_id) {
        return menuService.getMenusByStore(store_id);
    }

    // 메뉴 단건 조회
    @GetMapping("/{menu_id}")
    public MenuResponse getMenuById(@PathVariable String menu_id) {
        return menuService.getMenuById(menu_id);
    }

    // 메뉴 추가
    @PostMapping
    public MenuResponse addMenu(@RequestBody MenuRequest menuRequest) {
        return menuService.addMenu(menuRequest);
    }

    // 메뉴 수정
    @PatchMapping("/{menu_id}")
    public MenuResponse updateMenu(@PathVariable String menu_id, @RequestBody MenuRequest menuRequest) {
        return menuService.updateMenu(menu_id, menuRequest);
    }

    // 메뉴 삭제
    @DeleteMapping("/{menu_id}")
    public void deleteMenu(@PathVariable String menu_id) {
        menuService.deleteMenu(menu_id);
    }
}
