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

	public ArrayList<String> listAllProjectsForOneUser(String id_user) throws SQLException {
		return ProjectDAO.getInstance().listAllProjectsForOneUser(id_user);
	}

	public String selectNameByIdProject(String id_project) throws SQLException {
		return ProjectDAO.getInstance().selectNameByIdProject(id_project);
	}

	public int countHowManyTasks(String id_project) throws SQLException {
		return ProjectDAO.getInstance().countHowManyTasks(id_project);
	}

	public ArrayList<String> listAllTasksForOneProject(String id_project) throws SQLException {
		return ProjectDAO.getInstance().listAllTasksForOneProject(id_project);
	}

	public String selectProjectManagerForProjectById(String id_project) throws SQLException {
		return ProjectDAO.getInstance().selectProjectManagerForProjectById(id_project);
	}
	
	public String showProjectsForUser(String id_user) throws SQLException {
		String str = "";
		if (listAllProjectsForOneUser(id_user) != null) {
			ArrayList<String> listProject = listAllProjectsForOneUser(id_user);
			for (int i = 0; i < listProject.size(); i++) {
				String id_project = selectIdProjectByName(listProject.get(i));
				str += "<option value='" + id_project + "'>" + listProject.get(i) + "</option>";
			}
		} else {
			str += "<option>No se han encontrado resultados</option>";
		}
		return str;
	}
	
	public String showProjectsWhereTaskExistIn(String id_user) throws SQLException {
		String str = "";
		if (listAllProjectsForOneUser(id_user) != null) {
			ArrayList<String> listProject = listAllProjectsForOneUser(id_user);
			for (int i = 0; i < listProject.size(); i++) {
				str += "<dd style='margin-left:7px;'><button class='btn btn-info'>" + listProject.get(i) + "</button></dd>";
			}
		} else {
			str += "<p class='h3'> Esta tarea no pertenece a ningún proyecto </p>";
		}
		return str;
	}

}











