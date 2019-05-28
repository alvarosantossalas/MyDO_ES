package com.mydo.core.dao;

import com.mydo.core.model.Project;
import com.mydo.core.dao.connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class ProjectDAO {

	private static String query;

	private Connection con = null;
	private static ProjectDAO instance = null;

	/**
	 * Retorna una conexión con la base de datos
	 * @throws SQLException
	 */
	private ProjectDAO() throws SQLException {
		con = DBConnection.getConnection();
	}

	/**
	 * Retorna una instancia de la clase
	 * @return
	 * @throws SQLException
	 */
	public static ProjectDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new ProjectDAO();
		}
		return instance;
	}

	/**
	 * Inserta un projecto en la base de datos
	 * @param project
	 * @throws SQLException
	 */
	public void insert(Project project) throws SQLException {
		query = "INSERT INTO tfg_project (_id_project, _name, _status, _subject, _project_manager) VALUES (?,?,?,?,?);";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, project.getId_project());
			ps.setString(2, project.getName());
			ps.setInt(3, project.getStatus());
			ps.setString(4, project.getSubject());
			ps.setString(5, project.getProject_manager());
			ps.executeUpdate();
			ps.close();
		}
	}

	/**
	 * Lista todos los projectos de la base de datos sin ningún filtro
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Project> listAll() throws SQLException {
		query = "SELECT * FROM tfg_project;";
		ArrayList<Project> result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ResultSet rs = ps.executeQuery();
			result = null;
			while (rs.next()) {
				if (result == null) {
					result = new ArrayList<>();
				}
				result.add(new Project(rs.getString("_id_project"), rs.getString("_name"), rs.getInt("_status"),
						rs.getString("_subject"), rs.getString("_project_manager")));
			}
			rs.close();
		}
		return result;
	}

	/**
	 * Retorna un proyecto de la base de datos con filtro: id_project
	 * @param id_project
	 * @return
	 * @throws SQLException
	 */
	public Project listById(String id_project) throws SQLException {
		query = "SELECT * FROM tfg_project WHERE _id_project = ?;";
		Project result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_project);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					result = new Project(rs.getString("_id_project"), rs.getString("_name"), rs.getInt("_status"),
							rs.getString("_subject"), rs.getString("_project_manager"));
				}
			}
		}
		return result;
	}

	/**
	 * Elimina un projecto de la base de datos
	 * @param project
	 * @throws SQLException
	 */
	public void remove(Project project) throws SQLException {
		remove(project.getId_project());
	}

	/**
	 * Elimina un project de la base de datos por id_project
	 * @param id_project
	 * @throws SQLException
	 */
	public void remove(String id_project) throws SQLException {
		if ("".equals(id_project)) {
			return;
		}
		query = "DELETE FROM tfg_project WHERE _id_project = ?;";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_project);
			ps.executeUpdate();
		}
	}

	/**
	 * Actualiza un projecto en la base de datos
	 * @param project
	 * @throws SQLException
	 */
	public void update(Project project) throws SQLException {
		if ("".equals(project.getId_project())) {
			return;
		}
		query = "UPDATE tfg_project SET _id_project=?, _name=?, _status=?, _subject=?, _project_manager=? WHERE _id_project=?;";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, project.getId_project());
			ps.setString(2, project.getName());
			ps.setInt(3, project.getStatus());
			ps.setString(4, project.getSubject());
			ps.setString(5, project.getProject_manager());
			ps.setString(6, project.getId_project());
			ps.executeUpdate();
			ps.close();
		}
	}

	/**
	 * Retorna el id de un proyecto con filtro: _name
	 * @param projectName
	 * @return
	 * @throws SQLException
	 */
	public String selectIdProjectByName(String projectName) throws SQLException {
		query = "SELECT _id_project FROM tfg_project WHERE _name = ?;";
		String result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, projectName);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					result = rs.getString("_id_project");
				}
			}
		}
		return result;
	}

	/**
	 * Retorna el nombre de un proyecto con filtro: _id_project
	 * @param id_project
	 * @return
	 * @throws SQLException
	 */
	public String selectNameByIdProject(String id_project) throws SQLException {
		query = "SELECT _name FROM tfg_project WHERE _id_project = ?;";
		String result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_project);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					result = rs.getString("_name");
				}
			}
		}
		return result;
	}
    
	/**
	 * Retorna todos los nombres de los proyectos que existen en la base de datos
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> listAllNames() throws SQLException {
		query = "SELECT _name FROM tfg_project;";
		ArrayList<String> result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ResultSet rs = ps.executeQuery();
			result = null;
			while (rs.next()) {
				if (result == null) {
					result = new ArrayList<>();
				}
				result.add(rs.getString("_name"));
			}
			rs.close();
		}
		return result;
	}

	/**
	 * Crea una relación entre una tarea, un equipo y un proyecto
	 * @param id_project
	 * @param id_task
	 * @param id_team
	 * @throws SQLException
	 */
	public void createTasksInProject(String id_project, String id_task, String id_team) throws SQLException {
		query = "INSERT INTO tfg_tasks_in_projects (_id_tasks_in_projects, _id_project, _id_task, _id_team) VALUES (?,?,?,?);";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, UUID.randomUUID().toString());
			ps.setString(2, id_project);
			ps.setString(3, id_task);
			ps.setString(4, id_team);
			ps.executeUpdate();
			ps.close();
		}
		System.out.println("Relation inserted");
	}

	/**
	 * Retorna todos los proyectos a los que pertenece un usuario
	 * @param id_user
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> listAllProjectsForOneUser(String id_user) throws SQLException {
		query = "SELECT _name FROM tfg_project WHERE _id_project IN (SELECT _id_project FROM tfg_tasks_in_projects WHERE _id_team IN (SELECT _id_team FROM tfg_members_team WHERE _id_user = ?));";
		ArrayList<String> result = null;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_user);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				while (rs.next()) {
					if (result == null) {
						result = new ArrayList<>();
					}
					result.add(rs.getString("_name"));
				}
			}
		}
		return result;
	}

	/**
	 * Retorna el número de tareas que existen dentro de un proyecto
	 * @param id_project
	 * @return
	 * @throws SQLException
	 */
	public int countHowManyTasks(String id_project) throws SQLException {
		int result = 0;
		query = "SELECT COUNT('_id_task') FROM tfg_tasks_in_projects WHERE _id_project = '" + id_project + "';";
		try (PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			if (rs.next()) {
				result = rs.getInt(1);
			}
		}
		return result;
	}

	/**
	 * Retorna todas las tareas de un proyecto
	 * @param id_project
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> listAllTasksForOneProject(String id_project) throws SQLException {
		query = "SELECT _id_task FROM tfg_tasks_in_projects WHERE _id_project = ?;";
		ArrayList<String> result = null;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_project);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				while (rs.next()) {
					if (result == null) {
						result = new ArrayList<>();
					}
					result.add(rs.getString("_id_task"));
				}
			}
		}
		return result;
	}

	/**
	 * Retorna todos los proyectos en los que existe una tarea en concreto
	 * @param id_task
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> listAllProjectsForOneTask(String id_task) throws SQLException {
		query = "SELECT _name FROM tfg_project WHERE _id_project IN (SELECT _id_project FROM tfg_tasks_in_projects WHERE _id_task = ?);";
		ArrayList<String> result = null;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_task);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				while (rs.next()) {
					if (result == null) {
						result = new ArrayList<>();
					}
					result.add(rs.getString("_name"));
				}
			}
		}
		return result;
	}

	/**
	 * Retorna el project manager de un proyecto
	 * @param id_project
	 * @return
	 * @throws SQLException
	 */
	public String selectProjectManagerForProjectById(String id_project) throws SQLException {
		query = "SELECT _project_manager FROM tfg_project WHERE _id_project = ?;";
		String result = null;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_project);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					result = rs.getString("_project_manager");
				}
			}
		}
		return result;
	}

}