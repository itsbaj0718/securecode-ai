package com.bajrang.securecode_ai.controller;

import com.bajrang.securecode_ai.dto.request.LoginRequest;
import com.bajrang.securecode_ai.dto.request.RegisterRequest;
import com.bajrang.securecode_ai.dto.response.AuthResponse;
import com.bajrang.securecode_ai.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @Valid @RequestBody RegisterRequest request) {

        return ResponseEntity.ok(
                authService.register(request)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody LoginRequest request) {

        String token =
                authService.login(request);

        return ResponseEntity.ok(
                new AuthResponse(token)
        );
    }
}