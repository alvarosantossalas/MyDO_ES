package com.mydo.core.model;

import java.util.UUID;

public class Task {

	private String id_task;
	private String name;
	private String subject;
	private String description;
	private String type;
	private int estimated_time; // in hours
	private int finalized;
	private String status;
	private String created_by;
	private String id_team;

	public Task() {
	}

	public Task(String name, String subject, String description, String type, int estimated_time, String id_team) {
		super();
		this.id_task = "task_" + UUID.randomUUID().toString();
		this.name = name;
		this.subject = subject;
		this.description = description;
		this.type = type;
		this.estimated_time = estimated_time;
		this.finalized = 0;
		this.status = "Nueva"; // by default this task will be "Nueva"
		this.id_team = id_team;
		this.created_by = id_task;
	}

	public Task(String id_task, String name, String subject, String description, String type, int estimated_time,
			int finalized, String status, String created_by, String id_team) {
		super();
		this.id_task = id_task;
		this.name = name;
		this.subject = subject;
		this.description = description;
		this.type = type;
		this.estimated_time = estimated_time;
		this.finalized = finalized;
		this.status = status;
		this.created_by = created_by;
		this.id_team = id_team;
	}

	public String getId_task() {
		return id_task;
	}

	public void setId_task(String id_task) {
		this.id_task = id_task;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getEstimated_time() {
		return estimated_time;
	}

	public void setEstimated_time(int estimated_time) {
		this.estimated_time = estimated_time;
	}

	public int getFinalized() {
		return finalized;
	}

	public void setFinalized(int finalized) {
		this.finalized = finalized;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getId_team() {
		return id_team;
	}

	public void setId_team(String id_team) {
		this.id_team = id_team;
	}

}
