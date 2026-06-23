package com.bajrang.securecode_ai.repository;

import com.bajrang.securecode_ai.entity.Project;
import com.bajrang.securecode_ai.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository
        extends JpaRepository<Project, Long> {

    List<Project> findByOwner(User owner);
}