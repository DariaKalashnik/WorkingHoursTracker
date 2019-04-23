package com.itgirl.project.worktracker.contollers;

import com.itgirl.project.worktracker.models.User;
import com.itgirl.project.worktracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO 1: modify later when frontend part is done

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {

        List<User> users = userService.getUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {

        User user = userService.getUser(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {

        userService.saveUser(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) {

        User isExists = userService.getUser(id);

        if (isExists == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else if (user == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        userService.saveUser(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> removeUser(@PathVariable long id) {

        userService.removeUserById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
