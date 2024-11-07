package com.sparta.project.controller;

import com.sparta.project.dto.payment.PaymentRequest;
import com.sparta.project.dto.payment.PaymentResponse;
import com.sparta.project.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;

    // 자신의 결제 내역 목록 조회
    @GetMapping("/my")
    public List<PaymentResponse> getMyPayments() {
        return paymentService.getMyPayments();
    }

    // 가게 결제 내역 목록 조회
    @GetMapping("/stores/{store_id}")
    public List<PaymentResponse> getPaymentsByStore(@PathVariable String store_id) {
        return paymentService.getPaymentsByStore(store_id);
    }

    // 결제 내역 상세 조회
    @PostMapping("/{payment_id}")
    public PaymentResponse updatePayment(@PathVariable String payment_id, @RequestBody PaymentRequest paymentRequest) {
        return paymentService.updatePayment(payment_id, paymentRequest);
    }

    // 결제 요청
    @PostMapping
    public PaymentResponse createPayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.createPayment(paymentRequest);
    }

    // 결제 취소
    @DeleteMapping("/{payment_id}")
    public void deletePayment(@PathVariable String payment_id) {
        paymentService.deletePayment(payment_id);
    }
}
