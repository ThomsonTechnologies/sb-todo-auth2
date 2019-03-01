package com.thomsoncodes.todo.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class ToDo {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String Id;
	@NotNull
	@NotBlank
	private String description;
	
	@Column(insertable = true, updatable = false)
	private LocalDateTime created;
	private LocalDateTime modified;
	private boolean completed;
	
	public ToDo() {}
	public ToDo(String description) {
		this.description = description;
	}
	
	@PrePersist
	void onCreate() {
		this.setCreated(LocalDateTime.now());
		this.setModified(LocalDateTime.now());
	}
	
	@PreUpdate
	void onUpdate() {
		this.setModified(LocalDateTime.now());
	}
	

}