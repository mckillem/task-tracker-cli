package org.example;

import com.google.gson.annotations.Expose;

import java.time.LocalDateTime;

public class Task {
	@Expose
	private int id;
	@Expose
	private String description;
	@Expose
	private String status;
	@Expose
	private LocalDateTime createdAt;
//	private LocalDateTime updatedAt;

	public Task(int id, String description, String status, LocalDateTime createdAt) {
		this.id = id;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
//		this.updatedAt = updatedAt;
	}

//	public Task(int id, String description, String status) {
//		this.id = id;
//		this.description = description;
//		this.status = status;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public LocalDateTime getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(LocalDateTime createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public LocalDateTime getUpdatedAt() {
//		return updatedAt;
//	}
//
//	public void setUpdatedAt(LocalDateTime updatedAt) {
//		this.updatedAt = updatedAt;
//	}

	@Override
	public String toString() {
		return "Task{" +
				"id=" + id +
				", description='" + description + '\'' +
				", status='" + status + '\'' +
//				", createdAt=" + createdAt +
//				", updatedAt=" + updatedAt +
				'}';
	}
}
