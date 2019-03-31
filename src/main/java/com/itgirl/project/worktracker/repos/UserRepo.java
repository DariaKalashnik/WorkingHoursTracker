package com.itgirl.project.worktracker.repos;

import com.itgirl.project.worktracker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {


}
