package com.itgirl.project.worktracker.services;

import com.itgirl.project.worktracker.models.Project;
import com.itgirl.project.worktracker.models.Task;
import com.itgirl.project.worktracker.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

@Service
public class DataLoader {

    private UserService userService;
    private ProjectService projectService;
    private TaskService taskService;

    @Autowired
    public DataLoader(UserService userService, ProjectService projectService, TaskService taskService) {
        this.userService = userService;
        this.projectService = projectService;
        this.taskService = taskService;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Dummy data
    @PostConstruct
    private void generateProjectsForUsers() {
        List<User> users = userService.getAll();

        System.out.println(users);

        Random random = new Random();

        for (User user : users) {
            while (user.getProjects().size() < 3){

                // use the up to date user to add new project
                // user = userService.getById(user.getId());

                Project project = projectService.getById((long) random.nextInt(100) + 1);

                user.addProject(project);

                user = userService.save(user);

            }
        }
    }

    /**
     * Generate dummy Projects
     */
    @PostConstruct
    private void generateProjects() {
        if (projectService.count() < 1) {
            for (int i = 0; i < 100; i++) {
                Project project = new Project();
                project.setName("Name" + i);
                projectService.save(project);
            }
        }
    }

    /**
     * Generate dummy Users
     */
    @PostConstruct
    private void generateUsers() {
        if (userService.count() < 1) {
            for (int i = 0; i < 100; i++) {
                User user = new User();
                user.setFirstName("User" + i);
                userService.save(user);
            }
        }
    }

    // Dummy data
    @PostConstruct
    private void generateTasks() {
        if (taskService.count() < 1) {
            for (int i = 0; i < 100; i++) {
                Task task = new Task();
                task.setName("Name" + i);
                taskService.save(task);
            }
        }
    }
}
