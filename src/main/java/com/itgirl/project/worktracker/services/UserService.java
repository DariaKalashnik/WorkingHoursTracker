package com.itgirl.project.worktracker.services;

import com.itgirl.project.worktracker.models.User;
import com.itgirl.project.worktracker.repos.UserRepo;
import com.itgirl.project.worktracker.services.abstract_service.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements ServiceHelper<User> {

    @Autowired
    UserRepo userRepo;

    public List<User> getAll() {
        return userRepo.findAll();
    }

    public User getById(Long id) {
        return userRepo.getOne(id);
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    public void remove(User user) {
        userRepo.delete(user);
    }

    public void removeById(Long id) {
        userRepo.deleteById(id);
    }

    public long count() {
        return userRepo.count();
    }
}
