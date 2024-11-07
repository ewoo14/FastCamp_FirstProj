package com.sparta.project.controller;

import com.sparta.project.dto.order.OrderRequest;
import com.sparta.project.dto.order.OrderResponse;
import com.sparta.project.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    // 자신의 주문내역 목록 조회
    @GetMapping("/my")
    public List<OrderResponse> getMyOrders(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String sortBy
    ) {
        return orderService.getMyOrders(page, size, sortBy);
    }

    // 주문내역 상세 조회
    @GetMapping("/{order_id}")
    public OrderResponse getOrderById(@PathVariable String order_id) {
        return orderService.getOrderById(order_id);
    }

    // 고객의 주문내역 목록 조회
    @GetMapping("/users/{user_id}")
    public List<OrderResponse> getOrdersByUser(@PathVariable String user_id) {
        return orderService.getOrdersByUser(user_id);
    }

    // 주문 요청
    @PostMapping
    public OrderResponse placeOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.placeOrder(orderRequest);
    }

    // 주문 승인
    @PostMapping("/{order_id}")
    public OrderResponse updateOrder(@PathVariable String order_id, @RequestBody OrderRequest orderRequest) {
        return orderService.updateOrder(order_id, orderRequest);
    }

    // 주문 취소
    @DeleteMapping("/{order_id}")
    public void deleteOrder(@PathVariable String order_id) {
        orderService.cancelOrder(order_id);
    }
}
