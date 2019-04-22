package com.itgirl.project.worktracker.services;

import com.itgirl.project.worktracker.models.Task;
import com.itgirl.project.worktracker.repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepo taskRepo;

    // Dummy data
    @PostConstruct
    private void generateTasks() {
        for (int i = 0; i < 100; i++) {
            Task task = new Task();
            task.setName("Name" + i);
            taskRepo.save(task);
        }
    }

    public List<Task> getTasks() {
        return taskRepo.findAll();
    }

    public Task getTask(Long id) {
        return taskRepo.getOne(id);
    }

    /**
     * Method for adding new task and updating the existing one
     *
     * @param task required parameter (new or updated task)
     * @return true if save was successful
     */
    public boolean saveTask(Task task) {
        // We don't check the id as explained here -> https://www.baeldung.com/spring-data-crud-repository-save
        taskRepo.save(task);
        return true;
    }

    public void removeTask(Task task) {
        taskRepo.delete(task);
    }

    public void removeById(Long id) {
       taskRepo.deleteById(id);
    }
}
