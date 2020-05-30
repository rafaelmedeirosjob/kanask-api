package com.supero.kanask.dto.task;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.supero.kanask.model.Task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class TaskDto {

	private Long id;
	private boolean isConcluded;
	private String title;
	private String type;
	private String status;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime removeAt;
	
	public static List<TaskDto> converter(List<Task> tasks) {
		List<TaskDto> tasksDto = new ArrayList<>();
		for (Task task : tasks) {
			tasksDto.add(new TaskDto(task.getId(), task.isConcluded(), task.getTitle(),task.getType(),task.getStatus(),task.getCreatedAt(),task.getUpdatedAt(),task.getRemoveAt()));
		}
		return tasksDto;
	}

	public TaskDto(Task task) {
		this.id = task.getId();
		this.isConcluded = task.isConcluded();
		this.title = task.getTitle();
		this.type = task.getType();
		this.status = task.getStatus();
		this.createdAt = task.getCreatedAt();
		this.updatedAt = task.getUpdatedAt();
		this.removeAt = task.getRemoveAt();
	}


}