package com.example.refrig.api.common;

import lombok.Getter;

@Getter

public enum ErrorCode {
    NO_JWT_TOKEN(401, "AUT000", "JWT 토큰이 존재하지 않습니다.");

    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
