package com.supero.kanask.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Task {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private boolean isConcluded = false;
	private String title;
	private String type;
	private String status;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime removeAt;
	private LocalDateTime concludedAt;
	public Task(String title,String type, String status) {
		super();
		this.title = title;
		this.type = type;
		this.status = status;
	}
}