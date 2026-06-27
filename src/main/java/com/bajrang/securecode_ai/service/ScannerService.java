package com.bajrang.securecode_ai.service;

import com.bajrang.securecode_ai.dto.response.ScanSummaryResponse;
import com.bajrang.securecode_ai.entity.Project;
import com.bajrang.securecode_ai.entity.UploadedFile;
import com.bajrang.securecode_ai.repository.ProjectRepository;
import com.bajrang.securecode_ai.repository.UploadedFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScannerService {

    private final ProjectRepository projectRepository;
    private final UploadedFileRepository uploadedFileRepository;

    public ScanSummaryResponse scanProject(Long projectId) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() ->
                        new RuntimeException("Project not found"));

        List<UploadedFile> files =
                uploadedFileRepository.findByProject(project);

        System.out.println("Scanning Project : " + project.getName());

        int totalVulnerabilities = 0;
        for (UploadedFile file : files) {

            System.out.println("--------------------------------");
            System.out.println(file.getFileName());

            totalVulnerabilities+= scanForHardcodedSecrets(file);
        }

        return ScanSummaryResponse.builder()
                .projectId(projectId)
                .filesScanned(files.size())
                .vulnerabilitiesFound(totalVulnerabilities)
                .message("Project scanned successfully")
                .build();
    }

    private int scanForHardcodedSecrets(UploadedFile file) {

        String[] lines = file.getFileContent().split("\n");

        int lineNumber = 1;
        int vulnerabilitiesFound =0;

        for (String line : lines) {

            String lower = line.toLowerCase();

            if (lower.contains("password")
                    || lower.contains("secret")
                    || lower.contains("apikey")
                    || lower.contains("api_key")
                    || lower.contains("token")) {

                vulnerabilitiesFound++;

                System.out.println("Potential Secret Found");

                System.out.println(file.getFileName());

                System.out.println("Line " + lineNumber);

                System.out.println(line.trim());

                System.out.println("----------------------------");
            }

            lineNumber++;
        }
        return vulnerabilitiesFound;
    }
}