package com.bajrang.securecode_ai.service;

import com.bajrang.securecode_ai.dto.request.CreateProjectRequest;
import com.bajrang.securecode_ai.entity.Project;
import com.bajrang.securecode_ai.entity.User;
import com.bajrang.securecode_ai.repository.ProjectRepository;
import com.bajrang.securecode_ai.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public Project createProject(
            CreateProjectRequest request,
            Authentication authentication
    ) {

        String email =
                authentication.getName();

        User user =
                userRepository.findByEmail(email)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "User not found"));

        Project project =
                Project.builder()
                        .name(request.getName())
                        .description(
                                request.getDescription())
                        .owner(user)
                        .createdAt(
                                LocalDateTime.now())
                        .updatedAt(
                                LocalDateTime.now())
                        .build();

        return projectRepository.save(project);
    }

    public List<Project> getMyProjects(
            Authentication authentication
    ) {

        String email =
                authentication.getName();

        User user =
                userRepository.findByEmail(email)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "User not found"));

        return projectRepository.findByOwner(user);
    }
}