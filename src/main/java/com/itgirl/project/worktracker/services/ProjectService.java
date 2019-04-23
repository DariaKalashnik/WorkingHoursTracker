package com.itgirl.project.worktracker.services;

import com.itgirl.project.worktracker.models.Project;
import com.itgirl.project.worktracker.repos.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepo projectRepo;

    // Dummy data
    @PostConstruct
    private void generateProjects() {
        for (int i = 0; i < 100; i++) {
            Project project = new Project();
            project.setName("Name" + i);
            projectRepo.save(project);
        }
    }

    public List<Project> getProjects() {
        return this.projectRepo.findAll();
    }

    public Project getProject(Long id) {
        return projectRepo.getOne(id);
    }

    public boolean saveProject(Project project) {
        projectRepo.save(project);
        return true;
    }

    public void removeProject(Project project) {
        this.projectRepo.delete(project);
    }

    public void removeProjectById(Long id) {
        this.projectRepo.deleteById(id);
    }
}
