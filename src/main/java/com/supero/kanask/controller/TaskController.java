package com.supero.kanask.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.supero.kanask.dto.task.TaskDto;
import com.supero.kanask.model.Task;
import com.supero.kanask.repository.TaskRepository;
import com.supero.kanask.request.task.CreateTaskRequest;
import com.supero.kanask.request.task.UpdateTaskRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;
	
	@CrossOrigin(origins = "https://kanask-client.herokuapp.com")
	@GetMapping
	public List<TaskDto> list() {
		List<Task> Tasks = taskRepository.findAll();
		return TaskDto.converter(Tasks);
	}
	@CrossOrigin(origins = "https://kanask-client.herokuapp.com")
	@PostMapping
	@Transactional
	public ResponseEntity<?> create(@RequestBody @Valid CreateTaskRequest request, UriComponentsBuilder uriBuilder) {

		
		Task task = request.create(taskRepository);
		taskRepository.save(task);
		URI uri = uriBuilder.path("/tasks/{id}").buildAndExpand(task.getId()).toUri();
		return ResponseEntity.created(uri).body(new TaskDto(task));
	}
	@CrossOrigin(origins = "https://kanask-client.herokuapp.com")
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TaskDto> update(@PathVariable Long id, @RequestBody @Valid UpdateTaskRequest request) {
		Optional<Task> optional = taskRepository.findById(id);
		if (optional.isPresent()) {
			Task Task = request.update(id, taskRepository);
			return ResponseEntity.ok(new TaskDto(Task));
		}
		return ResponseEntity.notFound().build();
	}
	@CrossOrigin(origins = "https://kanask-client.herokuapp.com")
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<Task> optional = taskRepository.findById(id);
		if (optional.isPresent()) {
			taskRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}