package com.bajrang.securecode_ai.service;

import com.bajrang.securecode_ai.dto.response.ZipUploadResponse;
import com.bajrang.securecode_ai.entity.Project;
import com.bajrang.securecode_ai.entity.UploadedFile;
import com.bajrang.securecode_ai.repository.ProjectRepository;
import com.bajrang.securecode_ai.repository.UploadedFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
@RequiredArgsConstructor
public class FileService {

    private final ProjectRepository projectRepository;
    private final UploadedFileRepository uploadedFileRepository;

    public ZipUploadResponse uploadZip(
            Long projectId,
            MultipartFile zipFile) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() ->
                        new RuntimeException("Project not found"));

        if (zipFile.isEmpty()) {
            throw new RuntimeException("ZIP file is empty");
        }

        int filesSaved = 0;

        try (ZipInputStream zis =
                     new ZipInputStream(zipFile.getInputStream())) {

            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {

                if (entry.isDirectory()) {
                    continue;
                }

                if (!isSupportedFile(entry.getName())) {
                    continue;
                }

                String content = new String(
                        zis.readAllBytes(),
                        StandardCharsets.UTF_8
                );

                String filePath = entry.getName();

                String fileName =
                        filePath.substring(
                                filePath.lastIndexOf("/") + 1
                        );

                String extension = "";

                int lastDot = fileName.lastIndexOf(".");

                if (lastDot != -1) {
                    extension =
                            fileName.substring(lastDot + 1);
                }

                UploadedFile uploadedFile =
                        UploadedFile.builder()
                                .project(project)
                                .fileName(fileName)
                                .filePath(filePath)
                                .fileType(extension)
                                .fileContent(content)
                                .build();

                uploadedFileRepository.save(uploadedFile);

                filesSaved++;
            }

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to process ZIP file",
                    e
            );
        }

        return new ZipUploadResponse(
                projectId,
                filesSaved,
                "ZIP uploaded successfully"
        );
    }

    private boolean isSupportedFile(String fileName) {

        return fileName.endsWith(".java")
                || fileName.endsWith(".xml")
                || fileName.endsWith(".properties")
                || fileName.endsWith(".yml")
                || fileName.endsWith(".yaml")
                || fileName.endsWith(".json")
                || fileName.endsWith(".sql")
                || fileName.endsWith(".js")
                || fileName.endsWith(".ts")
                || fileName.endsWith(".md");
    }
}