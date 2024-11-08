//package com.sparta.project.controller;
//
//import com.sparta.project.dto.AddressRequest;
//import com.sparta.project.dto.AddressResponse;
//import com.sparta.project.dto.ApiResponse;
//import com.sparta.project.dto.PageResponse;
//import com.sparta.project.service.AddressService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/addresses")
//public class AddressController {
//
//    private final AddressService addressService;
//
//    // 배송지 목록 조회(CUSTOMER, MANAGER, MASTER)
//    @GetMapping
//    public ApiResponse<PageResponse<AddressResponse>> getAllAddresses(
//            @RequestParam("page") int page,
//            @RequestParam("size") int size,
//            @RequestParam("sortBy") String sortBy) {
//        Page<AddressResponse> addresses = addressService.getAllAddresses(page, size, sortBy);
//        return ApiResponse.of("message", PageResponse.of(addresses));
//    }
//
//    // 배송지 상세 조회(CUSTOMER)
//    @GetMapping("/{address_id}")
//    public ApiResponse<AddressResponse> getAddressById(@PathVariable String address_id) {
//        AddressResponse address = addressService.getAddressById(address_id);
//        return ApiResponse.of("message", address);
//    }
//
//    // 배송지 등록(CUSTOMER)
//    @PostMapping
//    public ApiResponse<AddressResponse> createAddress(@RequestBody AddressRequest addressRequest) {
//        AddressResponse madeAddress = addressService.createAddress(addressRequest);
//        return ApiResponse.of("message", madeAddress);
//    }
//
//    // 배송지 수정(CUSTOMER)
//    @PatchMapping("/{address_id}")
//    public ApiResponse<AddressResponse> updateAddress(
//            @PathVariable String address_id,
//            @RequestBody AddressRequest addressRequest) {
//        AddressResponse updatedAddress = addressService.updateAddress(address_id, addressRequest);
//        return ApiResponse.of("message", updatedAddress);
//    }
//
//    // 배송지 삭제(CUSTOMER)
//    @DeleteMapping("/{address_id}")
//    public ApiResponse<Void> deleteAddress(@PathVariable String address_id) {
//        addressService.deleteAddress(address_id);
//        return ApiResponse.of("message", null);
//    }
//}