package com.bajrang.securecode_ai.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @Email
    private String email;

    @NotBlank
    private String password;
}