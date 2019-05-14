package com.mydo.controller;

import com.mydo.core.model.Task;
import com.mydo.core.dao.TaskDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaskCtrl {

	private static TaskCtrl instance = null;
	
	public static TaskCtrl getInstance() throws SQLException {
		if (instance == null) 
			instance = new TaskCtrl();
		return instance;
	}
	
	// insert task object
	public void insert(Task task) throws SQLException {
		TaskDAO.getInstance().insert(task);
	}
	
	// update task object
	public void update(Task task) throws SQLException {
		TaskDAO.getInstance().update(task);
	}
	
	// remove task object
	public void remove(String id) throws SQLException {
		TaskDAO.getInstance().remove(id);
	}
	
	// list all the existing task objects
	public ArrayList<Task> listAll() throws SQLException {
		return TaskDAO.getInstance().listAll();
	}
	
	// list task object by id task
	public Task listById(String id) throws SQLException {
		return TaskDAO.getInstance().listById(id);
	}
	
	// returns an int and admin if a project object is created or not
	public int projectIsCreaterOrNot(String subject) throws SQLException {
		return TaskDAO.getInstance().projectIsCreatedOrNot(subject);
	}
	
	// select id by name
	public String selectIdTaskByName(String name) throws SQLException {
		return TaskDAO.getInstance().selectIdTaskByName(name);
	}
	
	// list of all projects objects related to a team object to show them the user
	// when creating a task object
	public ArrayList<String> listAllProjectsForATeam(String id) throws SQLException {
		return TaskDAO.getInstance().listAllProjectsForATeam(id);
	}
	
	// list all names for a concrete project object
	public ArrayList<String> listAllNamesForConcreteProject(String id) throws SQLException {
		return TaskDAO.getInstance().listAllNamesForConcreteProjects(id);
	}
	
	public void insertTaskAndTeamRelationShip(String id_team, String id_task) throws SQLException {
		TaskDAO.getInstance().insertTaskAndTeamRelationShip(id_team, id_task);
	}
	
	public ArrayList<Task> listAllTasksForOneUser(String id_user) throws SQLException {
		return TaskDAO.getInstance().listAllTasksForOneUser(id_user);
	}
	
}
