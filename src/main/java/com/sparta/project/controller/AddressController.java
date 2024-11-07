package com.sparta.project.controller;

import com.sparta.project.dto.address.AddressRequest;
import com.sparta.project.dto.address.AddressResponse;
import com.sparta.project.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/address")
public class AddressController {

    private AddressService addressService;

    // 전체 배송지 정보 불러오기
    @GetMapping
    public List<AddressResponse> getAllAddresses() {
        return addressService.getAllAddresses();
    }
    // 배송지 상세 조회
    @GetMapping("/{address_id}")
    public AddressResponse getAddressById(@PathVariable String address_id) {
        return addressService.getAddressById(address_id);
    }

    // 배송지 등록
    @PostMapping
    public AddressResponse addAddress(@RequestBody AddressRequest addressRequest) {
        return addressService.addAddress(addressRequest);
    }

    // 배송지 수정
    @PatchMapping("/{address_id}")
    public AddressResponse updateAddress(@PathVariable String address_id, @RequestBody AddressRequest addressRequest) {
        return addressService.updateAddress(address_id, addressRequest);
    }

    // 배송지 삭제
    @DeleteMapping("/{address_id}")
    public void deleteAddress(@PathVariable String address_id) {
        addressService.deleteAddress(address_id);
    }
}