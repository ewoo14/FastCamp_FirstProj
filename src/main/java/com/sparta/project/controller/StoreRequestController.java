package com.sparta.project.controller;

import com.sparta.project.dto.StoreRequestCreateRequest;
import com.sparta.project.dto.StoreRequestResponse;
import com.sparta.project.service.StoreRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/store-requests")
public class StoreRequestController {

    private StoreRequestService storeRequestService;

    // 자신의 요청 목록 조회
    @GetMapping("/my")
    public List<StoreRequestResponse> getMyStoreRequests() {
        return storeRequestService.getMyStoreRequests();
    }

    // 음식점 생성 요청 상세 조회
    @GetMapping("/{request_id}")
    public StoreRequestResponse getStoreRequestById(@PathVariable String request_id) {
        return storeRequestService.getStoreRequestById(request_id);
    }

    // 음식점 생성 요청 목록 조회
    @GetMapping
    public List<StoreRequestResponse> getAllStoreRequests() {
        return storeRequestService.getAllStoreRequests();
    }

    // 음식점 생성 요청
    @PostMapping("/stores")
    public StoreRequestResponse createStoreRequest(@RequestBody StoreRequestCreateRequest request) {
        return storeRequestService.createStoreRequest(request);
    }

    // 음식점 생성 요청 승인
    @PostMapping("/{request_id}/approve")
    public StoreRequestResponse approveStoreRequest(@PathVariable String request_id) {
        return storeRequestService.approveStoreRequest(request_id);
    }

    // 음식점 생성 요청 반려
    @DeleteMapping("/{request_id}")
    public void deleteStoreRequest(@PathVariable String request_id) {
        storeRequestService.deleteStoreRequest(request_id);
    }
}
