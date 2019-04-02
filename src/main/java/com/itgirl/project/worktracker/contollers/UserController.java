package com.itgirl.project.worktracker.contollers;

import com.itgirl.project.worktracker.models.User;
import com.itgirl.project.worktracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO 1: modify later when frontend part is done
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/users")
    public void removeUser(@RequestBody User user) {
        userService.removeUser(user);
    }

    @PostMapping("/users")
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void removeUserById(@RequestBody long id) {
        userService.removeById(id);
    }
}
