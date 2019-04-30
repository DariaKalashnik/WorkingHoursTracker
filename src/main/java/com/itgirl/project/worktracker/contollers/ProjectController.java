package com.itgirl.project.worktracker.contollers;

import com.itgirl.project.worktracker.models.Project;
import com.itgirl.project.worktracker.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO 1: modify later when frontend part is done
@RestController
public class ProjectController {

    @Autowired
    public ProjectService projectService;

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getProjects() {

        List<Project> projects = projectService.getProjects();

        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProject(@PathVariable long id) {

        Project project = projectService.getProject(id);

        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> addProject(@RequestBody Project project) {

        projectService.saveProject(project);

        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateTask(@PathVariable long id, @RequestBody Project project) {

        Project isExists = projectService.getProject(id);

        if (isExists == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else if (project == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        projectService.saveProject(project);

        return new ResponseEntity<>(project, HttpStatus.OK);

    }

    @DeleteMapping("/projects")
    public ResponseEntity<Project> removeProject(@RequestBody Project project) {

        projectService.removeProject(project);

        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Project> removeProjectById(@RequestBody long id) {

        projectService.removeProjectById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
