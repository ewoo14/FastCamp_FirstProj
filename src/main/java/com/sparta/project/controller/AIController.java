//package com.sparta.project.controller;
//
//import com.sparta.project.dto.AIRequest;
//import com.sparta.project.dto.AIResponse;
//import com.sparta.project.dto.ApiResponse;
//import com.sparta.project.dto.PageResponse;
//import com.sparta.project.service.AIService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/ai")
//public class AIController {
//
//    private final AIService aiService;
//
//    // 메뉴 설명 생성
//    @PostMapping("/menu-description")
//    public ApiResponse<AIResponse> createMenuDescription(@RequestBody AIRequest aiRequest) {
//        AIResponse madeDescription = aiService.createMenuDescription(aiRequest);
//        return ApiResponse.of("message", madeDescription);
//    }
//
//    // 생성한 설명 목록 조회
//    @GetMapping("/menu-description")
//    public ApiResponse<AIResponse> getMenuDescription(
//            @RequestParam String menuId,
//            @RequestParam("page") int page,
//            @RequestParam("size") int size,
//            @RequestParam("sortBy") String sortBy) {
//        Page<AIResponse> descriptions = aiService.getMenuDescriptions(menuId, page, size, sortBy);
//        return ApiResponse.of("message", PageResponse.of(descriptions));
//    }
//}
