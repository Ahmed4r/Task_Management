package com.projects.Task_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projects.Task_Management.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
