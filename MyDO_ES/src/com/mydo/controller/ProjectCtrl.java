package com.mydo.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mydo.core.dao.ProjectDAO;
import com.mydo.core.model.Project;

public class ProjectCtrl {

	private static ProjectCtrl instance = null;
	/**
	 * Retorna una instancia de la clase
	 * @return
	 * @throws SQLException
	 */
	public static ProjectCtrl getInstance() throws SQLException {
		if (instance == null)
			instance = new ProjectCtrl();
		return instance;
	}

	/**
	 * Inserta un proyecto
	 * @param project
	 * @throws SQLException
	 */
	public void insert(Project project) throws SQLException {
		ProjectDAO.getInstance().insert(project);
	}

	/**
	 * Actualiza un proyecto
	 * @param project
	 * @throws SQLException
	 */
	public void update(Project project) throws SQLException {
		ProjectDAO.getInstance().update(project);
	}

	/**
	 * Elimina un proyecto
	 * @param id
	 * @throws SQLException
	 */
	public void remove(String id) throws SQLException {
		ProjectDAO.getInstance().remove(id);
	}

	/**
	 * Retorna todos los proyectos existentes
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Project> listAll() throws SQLException {
		return ProjectDAO.getInstance().listAll();
	}

	/**
	 * Retorna un proyecto filtrando por id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Project listById(String id) throws SQLException {
		return ProjectDAO.getInstance().listById(id);
	}

	/**
	 * Retorna el id de un proyecto filtrando por su nombre
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public String selectIdProjectByName(String name) throws SQLException {
		return ProjectDAO.getInstance().selectIdProjectByName(name);
	}

	/**
	 * Retorna todos los nombres de los proyectos existentes
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> findAllNames() throws SQLException {
		return ProjectDAO.getInstance().listAllNames();
	}

	/**
	 * Crea una relación entre tarea, proyecto y equipo
	 * @param id_project
	 * @param id_task
	 * @param id_team
	 * @throws SQLException
	 */
	public void createRelationShip(String id_project, String id_task, String id_team) throws SQLException {
		ProjectDAO.getInstance().createTasksInProject(id_project, id_task, id_team);
	}

	/**
	 * Retorna todos los proyectos a los que pertenece un usuario
	 * @param id_user
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> listAllProjectsForOneUser(String id_user) throws SQLException {
		return ProjectDAO.getInstance().listAllProjectsForOneUser(id_user);
	}

	/**
	 * Retorna el nombre de un proyecto filtrado por id
	 * @param id_project
	 * @return
	 * @throws SQLException
	 */
	public String selectNameByIdProject(String id_project) throws SQLException {
		return ProjectDAO.getInstance().selectNameByIdProject(id_project);
	}

	/**
	 * Cuenta las tareas que existen en un proyecto filtrado por id
	 * @param id_project
	 * @return
	 * @throws SQLException
	 */
	public int countHowManyTasks(String id_project) throws SQLException {
		return ProjectDAO.getInstance().countHowManyTasks(id_project);
	}

	/**
	 * Retorna todas las tareas que existen dentro de un proyecto filtrando por id
	 * @param id_project
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> listAllTasksForOneProject(String id_project) throws SQLException {
		return ProjectDAO.getInstance().listAllTasksForOneProject(id_project);
	}

	/**
	 * Retorna el project manager de un proyecto filtrando por id
	 * @param id_project
	 * @return
	 * @throws SQLException
	 */
	public String selectProjectManagerForProjectById(String id_project) throws SQLException {
		return ProjectDAO.getInstance().selectProjectManagerForProjectById(id_project);
	}

	/**
	 * Retorna todos los proyectos para un usuario. Se muestra en HTML
	 * @param id_user
	 * @return
	 * @throws SQLException
	 */
	public String showProjectsForUser(String id_user) throws SQLException {
		StringBuffer sb = new StringBuffer();
		ArrayList<String> listProject;
		String id_project;
		if (listAllProjectsForOneUser(id_user) != null) {
			 listProject = listAllProjectsForOneUser(id_user);
			for (int i = 0; i < listProject.size(); i++) {
				id_project = selectIdProjectByName(listProject.get(i));
				sb.append("<option value='" + id_project + "'>" + listProject.get(i) + "</option>");
			}
		} else {
			sb.append("<option>No se han encontrado resultados</option>");
		}
		return sb.toString();
	}
	
	/**
	 * Retorna todos los proyectos a los que pertenece una tarea. Se muestra en HTML
	 * @param id_task
	 * @return
	 * @throws SQLException
	 */
	public String showProjectsWhereTaskExistIn(String id_task) throws SQLException {
		StringBuffer sb = new StringBuffer();
		ArrayList<String> names;
		if (ProjectDAO.getInstance().listAllProjectsForOneTask(id_task) == null) {
			sb.append("<p`class='h3'> Esta tarea no pertenece a ningún proyecto</p>");
		} else {
			names = ProjectDAO.getInstance().listAllProjectsForOneTask(id_task);
			for (int i = 0; i < names.size(); i++) {
				sb.append("<dd style='margin-left:7px;'><button class='btn btn-info'>" + names.get(i) + "</button></dd>");
			}
		}
		return sb.toString();
	}

}
