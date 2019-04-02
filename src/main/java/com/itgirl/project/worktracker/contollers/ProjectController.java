package com.itgirl.project.worktracker.contollers;

import com.itgirl.project.worktracker.models.Project;
import com.itgirl.project.worktracker.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO 1: modify later when frontend part is done
public class ProjectController {

    @Autowired
    public ProjectService projectService;

    @GetMapping("/projects")
    public List<Project> getProjects() {
        return projectService.getProjects();
    }

    @GetMapping("/projects/{id}")
    public Project getProject(@PathVariable long id) {
        return projectService.getProject(id);
    }

    @PostMapping("/projects")
    public void saveProject(@RequestBody Project project) {
        projectService.saveProject(project);
    }

    @DeleteMapping("/projects")
    public void removeProject(@RequestBody Project project) {
        projectService.removeProject(project);
    }

    @DeleteMapping("/projects/{id}")
    public void removeProjectById(@RequestBody long id) {
        projectService.removeById(id);
    }
}
