package com.bajrang.securecode_ai.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateProjectRequest {

    @NotBlank
    private String name;

    private String description;
}