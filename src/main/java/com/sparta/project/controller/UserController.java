package com.sparta.project.controller;

import com.sparta.project.dto.user.UserLoginRequest;
import com.sparta.project.dto.user.UserRegisterRequest;
import com.sparta.project.dto.user.UserUpdateRequest;
import com.sparta.project.dto.user.UserResponse;
import com.sparta.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    // 회원가입
    @PostMapping("/signup")
    public UserResponse registerUser(@RequestBody UserRegisterRequest userRequest) {
        return userService.registerUser(userRequest);
    }

    // 로그인
    @PostMapping("/login")
    public UserResponse login(@RequestBody UserLoginRequest loginRequest) {
        return userService.login(loginRequest);
    }

    // 모든 회원 정보 불러오기
    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    // 회원정보 수정
    @PatchMapping("/{user_id}")
    public UserResponse updateUser(@PathVariable String user_id, @RequestBody UserUpdateRequest updateRequest) {
        return userService.updateUser(user_id, updateRequest);
    }

    // 회원 탈퇴
    @DeleteMapping("/{user_id}")
    public void deleteUser(@PathVariable String user_id) {
        userService.deleteUser(user_id);
    }
}
