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

	// Variable that will be user throughout the program to manage queries in the
	// database
	private static String query;

	private Connection con = null;
	private static ProjectDAO instance = null;

	// Method that returns the connection to the database
	private ProjectDAO() throws SQLException {
		con = DBConnection.getConnection();
	}

	// Create an instance of the class ProjectDao
	public static ProjectDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new ProjectDAO();
		}
		return instance;
	}

	// Insert project with related Task object in the database
	public void insert(Project project) throws SQLException {
		query = "INSERT INTO tfg_project (_id_project, _name, _status, _subject) VALUES (?,?,?,?);";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, project.getId_project());
			ps.setString(2, project.getName());
			ps.setInt(3, project.getStatus());
			ps.setString(4, project.getSubject());
			ps.executeUpdate();
			ps.close();
		}
	}

	// This method list all the existing Project objects in the database
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
						rs.getString("_subject")));
			}
			rs.close();
		}
		return result;
	}

	// List Project object by id_project
	public Project listById(String id_project) throws SQLException {
		query = "SELECT * FROM tfg_project WHERE _id_project = ?;";
		Project result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_project);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					result = new Project(rs.getString("_id_project"), rs.getString("_name"), rs.getInt("_status"),
							rs.getString("_subject"));
				}
			}
		}
		return result;
	}

	// Remove Project object in the database
	public void remove(Project project) throws SQLException {
		remove(project.getId_project());
	}

	// Remove Project object in the database by id_project
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

	// Update Project object in the database
	public void update(Project project) throws SQLException {
		if ("".equals(project.getId_project())) {
			return;
		}
		query = "UPDATE tfg_project SET _id_project=?, _name=?, _status=?, _subject=? WHERE _id_project=?;";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, project.getId_project());
			ps.setString(2, project.getName());
			ps.setInt(3, project.getStatus());
			ps.setString(4, project.getSubject());
			ps.setString(5, project.getId_project());
			ps.executeUpdate();
			ps.close();
		}
	}

	// Select id_project by name
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

	// Return all project names
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

	// Create a relationship between Task and Project objects
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

	// SELECT _name FROM tfg_project WHERE _id_project IN (SELECT _id_project FROM
	// tfg_tasks_in_projects WHERE _id_team IN (SELECT _id_team FROM
	// tfg_members_team WHERE _id_user =
	// 'user_a17e6be1-129d-48dc-8974-c67a489f347f'));
	// list all projects for one user
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

}






