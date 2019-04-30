package com.itgirl.project.worktracker.services;

import com.itgirl.project.worktracker.models.Task;
import com.itgirl.project.worktracker.repos.TaskRepo;
import com.itgirl.project.worktracker.services.abstract_service.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ServiceHelper<Task> {

    @Autowired
    TaskRepo taskRepo;

    public List<Task> getAll() {
        return taskRepo.findAll();
    }

    public Task getById(Long id) {
        return taskRepo.getOne(id);
    }

    /**
     * Method for adding new task and updating the existing one
     *
     * @param task required parameter (new or updated task)
     * @return true if save was successful
     */
    public Task save(Task task) {
        // We don't check the id as explained here -> https://www.baeldung.com/spring-data-crud-repository-save
        return taskRepo.save(task);
    }

    public void remove(Task task) {
        taskRepo.delete(task);
    }

    public void removeById(Long id) {
        taskRepo.deleteById(id);
    }

    public long count() {
        return taskRepo.count();
    }
}
