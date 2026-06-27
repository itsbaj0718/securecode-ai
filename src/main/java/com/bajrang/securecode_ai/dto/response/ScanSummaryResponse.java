package com.bajrang.securecode_ai.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScanSummaryResponse {

    private Long projectId;

    private Integer filesScanned;

    private Integer vulnerabilitiesFound;

    private String message;
}