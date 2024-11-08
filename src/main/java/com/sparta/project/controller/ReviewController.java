//package com.sparta.project.controller;
//
//import com.sparta.project.dto.ReviewRequest;
//import com.sparta.project.dto.ReviewResponse;
//import com.sparta.project.dto.ApiResponse;
//import com.sparta.project.dto.PageResponse;
//import com.sparta.project.service.ReviewService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/reviews")
//public class ReviewController {
//
//    private final ReviewService reviewService;
//
//    // 리뷰 상세 조회(ALL)
//    @GetMapping("/{review_id}")
//    public ApiResponse<ReviewResponse> getReviewById(@PathVariable Long review_id) {
//        ReviewResponse review = reviewService.getReviewById(review_id);
//        return ApiResponse.of("message", review);
//    }
//
//    // 내 리뷰 목록 조회(CUSTOMER)
//    @GetMapping("/my")
//    public ApiResponse<PageResponse<ReviewResponse>> getMyReviews(
//            @RequestParam Long userId,
//            @RequestParam("page") int page,
//            @RequestParam("size") int size,
//            @RequestParam("sortBy") String sortBy) {
//        Page<ReviewResponse> myReviews = reviewService.getMyReviews(userId, page, size, sortBy);
//        return ApiResponse.of("message", PageResponse.of(myReviews));
//    }
//
//    // 가게 리뷰 목록 조회(ALL)
//    @GetMapping
//    public ApiResponse<PageResponse<ReviewResponse>> getAllReviewsByStore(
//            @RequestParam String storeId,
//            @RequestParam("page") int page,
//            @RequestParam("size") int size,
//            @RequestParam("sortBy") String sortBy) {
//        Page<ReviewResponse> storeReviews = reviewService.getReviewsByStore(storeId, page, size, sortBy);
//        return ApiResponse.of("message", PageResponse.of(storeReviews));
//    }
//
//    // 리뷰 작성(CUSTOMER)
//    @PostMapping
//    public ApiResponse<ReviewResponse> createReview(@RequestBody ReviewRequest reviewRequest) {
//        ReviewResponse review = reviewService.createReview(reviewRequest);
//        return ApiResponse.of("message", review);
//    }
//
//    // 리뷰 수정(CUSTOMER)
//    @PatchMapping("/{review_id}")
//    public ApiResponse<ReviewResponse> updateReview(
//            @PathVariable String review_id,
//            @RequestBody ReviewRequest reviewRequest) {
//        ReviewResponse updatedReview = reviewService.updateReview(review_id, reviewRequest);
//        return ApiResponse.of("message", updatedReview);
//    }
//
//    // 리뷰 삭제(CUSTOMER)
//    @DeleteMapping("/{review_id}")
//    public ApiResponse<Void> deleteReview(@PathVariable String review_id) {
//        reviewService.deleteReview(review_id);
//        return ApiResponse.of("message", null);
//    }
//}
