package com.projects.Task_Management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projects.Task_Management.entity.Task;

// data layer
public interface TaskRepository extends JpaRepository<Task, Long> {

}
