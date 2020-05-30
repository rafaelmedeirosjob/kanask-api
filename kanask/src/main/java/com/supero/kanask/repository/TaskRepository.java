package com.supero.kanask.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.supero.kanask.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
