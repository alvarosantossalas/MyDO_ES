package com.mydo.core.model;

import java.util.UUID;

public class Project {

	private String id_project;
	private String name;
	private int status;
	private String subject;
	private String project_manager;

	public Project() {
	}

	public Project(String name, String subject, String project_manager) {
		this.id_project = "project_" + UUID.randomUUID().toString();
		this.name = name;
		this.status = 1; // by default
		this.subject = subject;
		this.project_manager = project_manager;
	}

	public Project(String id_project, String name, int status, String subject, String project_manager) {
		this.id_project = id_project;
		this.name = name;
		this.status = status;
		this.subject = subject;
		this.project_manager = project_manager;
	}

	public String getId_project() {
		return id_project;
	}

	public void setId_project(String id_project) {
		this.id_project = id_project;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getProject_manager() {
		return project_manager;
	}

	public void setProject_manager(String project_manager) {
		this.project_manager = project_manager;
	}

}
