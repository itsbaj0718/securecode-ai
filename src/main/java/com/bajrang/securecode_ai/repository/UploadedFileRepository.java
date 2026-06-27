package com.bajrang.securecode_ai.repository;

import com.bajrang.securecode_ai.entity.Project;
import com.bajrang.securecode_ai.entity.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UploadedFileRepository  extends JpaRepository<UploadedFile, Long> {
    List<UploadedFile> findByProject(Project project);
}
