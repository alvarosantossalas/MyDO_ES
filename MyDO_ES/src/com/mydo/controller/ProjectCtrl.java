package com.mydo.controller;

import com.mydo.core.model.Project;
import com.mydo.core.dao.ProjectDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjectCtrl {

	private static ProjectCtrl instance = null;
	
	public static ProjectCtrl getInstance() throws SQLException {
		if (instance == null)
			instance = new ProjectCtrl();
		return instance;
	}
	
	// insert project object
	public void insert(Project project) throws SQLException {
		ProjectDAO.getInstance().insert(project);
	}
	
	// update project object
	public void update(Project project) throws SQLException {
		ProjectDAO.getInstance().update(project);
	}
	
	// remove project object
	public void remove(String id) throws SQLException {
		ProjectDAO.getInstance().remove(id);
	}
	
	// list all the existing project objects
	public ArrayList<Project> listAll() throws SQLException {
		return ProjectDAO.getInstance().listAll();
	}
	
	// list project object by id
	public Project listById(String id) throws SQLException {
		return ProjectDAO.getInstance().listById(id);
	}
	
	// select id by name
	public String selectIdProjectByName(String name) throws SQLException {
		return ProjectDAO.getInstance().selectIdProjectByName(name);
	}
	
	// return all project names
	public ArrayList<String> findAllNames() throws SQLException {
		return ProjectDAO.getInstance().listAllNames();
	}
	
	// create relationship between task and project objects
	public void createRelationShip(String id_project, String id_task, String id_team) throws SQLException {
		ProjectDAO.getInstance().createTasksInProject(id_project, id_task, id_team);
	}
	
}