package com.bajrang.securecode_ai.controller;

import com.bajrang.securecode_ai.dto.response.ScanSummaryResponse;
import com.bajrang.securecode_ai.service.ScannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/scans")
public class ScannerController {

    private final ScannerService scannerService;

    @PostMapping("/start/{projectId}")
    public ScanSummaryResponse scanProject(@PathVariable Long projectId){
        return scannerService.scanProject(projectId);
    }
}
