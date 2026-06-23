package com.bajrang.securecode_ai.service;

import com.bajrang.securecode_ai.dto.response.ZipUploadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class FileService {

    public ZipUploadResponse uploadZip(
            Long projectId,
            MultipartFile zipFile) {

        return new ZipUploadResponse(
                projectId,
                0,
                "ZIP processing not implemented yet"
        );
    }
}