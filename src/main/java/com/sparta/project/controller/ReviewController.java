package com.sparta.project.controller;

import com.sparta.project.dto.review.ReviewRequest;
import com.sparta.project.dto.review.ReviewResponse;
import com.sparta.project.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 리뷰 상세 조회
    @GetMapping("/{review_id}")
    public ReviewResponse getReviewById(@PathVariable String review_id) {
        return reviewService.getReviewById(review_id);
    }

    // 내 리뷰 목록 조회
    @GetMapping("/my")
    public List<ReviewResponse> getMyReviews() {
        return reviewService.getMyReviews();
    }

    // 가게 리뷰 목록 조회
    @GetMapping("/stores/{store_id}")
    public List<ReviewResponse> getReviewsByStore(@PathVariable String store_id) {
        return reviewService.getReviewsByStore(store_id);
    }

    // 리뷰 작성
    @PostMapping
    public ReviewResponse addReview(@RequestBody ReviewRequest reviewRequest) {
        return reviewService.addReview(reviewRequest);
    }

    // 리뷰 수정
    @PatchMapping("/{review_id}")
    public ReviewResponse updateReview(@PathVariable String review_id, @RequestBody ReviewRequest reviewRequest) {
        return reviewService.updateReview(review_id, reviewRequest);
    }

    // 리뷰 삭제
    @DeleteMapping("/{review_id}")
    public void deleteReview(@PathVariable String review_id) {
        reviewService.deleteReview(review_id);
    }
}
