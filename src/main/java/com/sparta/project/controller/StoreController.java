package com.sparta.project.controller;

import com.sparta.project.dto.store.StoreUpdateRequest;
import com.sparta.project.dto.store.StoreResponse;
import com.sparta.project.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    // 자신의 음식점 조회
    @GetMapping("/my")
    public List<StoreResponse> getMyStores() {
        return storeService.getMyStores();
    }

    // 음식점 목록 조회
    @GetMapping
    public List<StoreResponse> getAllStores(@RequestParam(required = false) Integer page,
                                            @RequestParam(required = false) Integer size,
                                            @RequestParam(required = false) String sortBy) {
        return storeService.findAllStores(page, size, sortBy);
    }

    // 음식점 상세 조회
    @GetMapping("/{store_id}")
    public StoreResponse getStoreById(@PathVariable String store_id) {
        return storeService.getStoreById(store_id);
    }

    // 음식점 검색
    @GetMapping("/search")
    public List<StoreResponse> searchStores(@RequestParam(required = false) String name,
                                            @RequestParam(required = false) String categoryId,
                                            @RequestParam(required = false) Integer page,
                                            @RequestParam(required = false) Integer size,
                                            @RequestParam(required = false) String sortBy) {
        return storeService.searchStores(name, categoryId, page, size, sortBy);
    }

    // 음식점 정보 수정
    @PatchMapping("/{store_id}")
    public StoreResponse updateStore(@PathVariable String store_id, @RequestBody StoreUpdateRequest updateRequest) {
        return storeService.updateStore(store_id, updateRequest);
    }

    // 음식점 삭제
    @DeleteMapping("/{store_id}")
    public void deleteStore(@PathVariable String store_id) {
        storeService.deleteStore(store_id);
    }
}
