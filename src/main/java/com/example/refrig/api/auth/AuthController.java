package com.example.refrig.api.auth;

import com.example.refrig.api.common.ResponseWrapperDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "인증", description = "인증")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<ResponseWrapperDto<JwtResponseDto>> memberLogin() {

    }
}
