package com.bajrang.securecode_ai.controller;

import com.bajrang.securecode_ai.dto.response.ZipUploadResponse;
import com.bajrang.securecode_ai.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/upload-zip/{projectId}")
    public ZipUploadResponse uploadZip(
            @PathVariable Long projectId,
            @RequestParam("file") MultipartFile file) {

        return fileService.uploadZip(
                projectId,
                file
        );
    }
}