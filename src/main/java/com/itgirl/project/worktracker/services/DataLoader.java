package com.itgirl.project.worktracker.services;

import com.itgirl.project.worktracker.models.Project;
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

    @Autowired
    public DataLoader(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Dummy data
    @PostConstruct
    private void generateProjectsForUsers() {
        List<User> users = userService.getUsers();

        System.out.println(users);

        Random random = new Random();

        for (User user : users) {
            while (user.getProjects().size() < 3){

                // use the up to date user to add new project
                user = userService.getUser(user.getId());

                Project project = projectService.getProject((long) random.nextInt(100) + 1);

                user.addProject(project);

                userService.saveUser(user);

            }
        }
    }
}
