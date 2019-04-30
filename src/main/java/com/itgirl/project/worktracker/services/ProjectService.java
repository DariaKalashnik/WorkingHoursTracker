package com.itgirl.project.worktracker.services;

import com.itgirl.project.worktracker.models.Project;
import com.itgirl.project.worktracker.repos.ProjectRepo;
import com.itgirl.project.worktracker.services.abstract_service.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements ServiceHelper<Project> {

    @Autowired
    ProjectRepo projectRepo;

    public List<Project> getAll() {
        return this.projectRepo.findAll();
    }

    public Project getById(Long id) {
        return projectRepo.getOne(id);
    }

    public Project save(Project project) {
        return projectRepo.save(project);
    }

    public void remove(Project project) {
        this.projectRepo.delete(project);
    }

    public void removeById(Long id) {
        this.projectRepo.deleteById(id);
    }

    public long count() {
        return projectRepo.count();
    }
}
