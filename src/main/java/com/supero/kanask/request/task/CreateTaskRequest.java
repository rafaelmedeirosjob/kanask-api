package com.supero.kanask.request.task;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;
import com.supero.kanask.model.Task;
import com.supero.kanask.repository.TaskRepository;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateTaskRequest {
	@NotNull @NotEmpty
	private String title;
	@NotNull @NotEmpty
	private String type;
	@NotNull @NotEmpty
	private String status;
	@NotNull @NotEmpty
	private boolean isConcluded;
	
	public Task create(TaskRepository taskRepository) {
		Task task = new Task();
		task.setConcluded(this.isConcluded);
		task.setTitle(this.title);
		task.setType(this.type);
		task.setStatus(this.status);
		task.setCreatedAt(LocalDateTime.now());
		
		return task;
	}

}
