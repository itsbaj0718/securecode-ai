package com.bajrang.securecode_ai.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ZipUploadResponse {

    private Long projectId;
    private Integer filesUploaded;
    private String message;
}