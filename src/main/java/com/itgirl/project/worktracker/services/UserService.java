package com.itgirl.project.worktracker.services;

import com.itgirl.project.worktracker.models.Task;
import com.itgirl.project.worktracker.models.User;
import com.itgirl.project.worktracker.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    // Dummy data
    @PostConstruct
    private void generateUsers() {
        if (userRepo.count() < 1) {
            for (int i = 0; i < 100; i++) {
                User user = new User();
                user.setFirstName("User" + i);
                userRepo.save(user);
            }
        }
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User getUser(Long id) {
        return userRepo.getOne(id);
    }

    public boolean saveUser(User user) {
        userRepo.save(user);
        return true;
    }

    public void removeUser(User user) {
        userRepo.delete(user);
    }

    public void removeUserById(Long id) {
        userRepo.deleteById(id);
    }
}
