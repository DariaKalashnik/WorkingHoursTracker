package com.itgirl.project.worktracker.contollers;

import com.itgirl.project.worktracker.models.Task;
import com.itgirl.project.worktracker.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO 1: modify later when frontend part is done
@RestController
public class TaskController {

    @Autowired
    public TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTasks() {

        List<Task> tasks = taskService.getAll();

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTask(@PathVariable long id) {

        Task task = taskService.getById(id);

        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {

        taskService.save(task);

        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id, @RequestBody Task task) {

        Task isExists = taskService.getById(id);

        if (isExists == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else if (task == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        taskService.save(task);

        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Task> removeTask(@PathVariable long id) {

        taskService.removeById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
