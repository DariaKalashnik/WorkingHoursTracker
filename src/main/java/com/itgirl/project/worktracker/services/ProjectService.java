package com.itgirl.project.worktracker.services;

import com.itgirl.project.worktracker.models.Project;
import com.itgirl.project.worktracker.repos.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProjectService {

    @Autowired
    ProjectRepo projectRepo;

    public List<Project> getProjects() {
        return this.projectRepo.findAll();
    }

    public Project getProject(Long id) {
        return this.projectRepo.getOne(id);
    }


    public boolean saveTask(Project project) {
        projectRepo.save(project);
        return true;
    }

    public void removeProject(Project project) {
        this.projectRepo.delete(project);
    }

    public void removeById(Long id) {
        this.projectRepo.deleteById(id);
    }
}
