package com.sparta.project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // UNAUTHORIZED & FORBIDDEN
    FORBIDDEN_ACCESS(HttpStatus.FORBIDDEN, "접근 권한이 존재하지 않습니다."),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "비밀번호 정보가 일치하지 않습니다."),

    // NOT FOUND
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "일치하는 유저 정보가 존재하지 않습니다.")

    ;
    private final HttpStatus httpStatus;
    private final String message;

}
