package com.itgirl.project.worktracker.repos;

import com.itgirl.project.worktracker.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
}
