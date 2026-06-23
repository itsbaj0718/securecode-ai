package com.bajrang.securecode_ai.controller;

import com.bajrang.securecode_ai.dto.request.CreateProjectRequest;
import com.bajrang.securecode_ai.entity.Project;
import com.bajrang.securecode_ai.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public Project createProject(
            @Valid
            @RequestBody
            CreateProjectRequest request,

            Authentication authentication
    ) {

        return projectService.createProject(
                request,
                authentication
        );
    }

    @GetMapping
    public List<Project> getProjects(
            Authentication authentication
    ) {

        return projectService.getMyProjects(
                authentication
        );
    }
}