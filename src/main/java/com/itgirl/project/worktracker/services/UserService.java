package com.itgirl.project.worktracker.services;

import com.itgirl.project.worktracker.models.User;
import com.itgirl.project.worktracker.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<User> getUsers() {
        return this.userRepo.findAll();
    }

    public User getUser(Long id) {
        return this.userRepo.getOne(id);
    }

    public boolean saveUser(User user) {
        userRepo.save(user);
        return true;
    }

    public void removeUser(User user) {
        this.userRepo.delete(user);
    }

    public void removeById(Long id) {
        this.userRepo.deleteById(id);
    }
}
