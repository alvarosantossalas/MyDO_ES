package com.mydo.core.dao;

import com.mydo.core.model.Task;
import com.mydo.core.dao.connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class TaskDAO {

	// Variable that will be user throughout the program to manage queries in the
	// database
	private static String query;

	private Connection con = null;
	private static TaskDAO instance = null;

	// Method that returns the connection to the database
	private TaskDAO() throws SQLException {
		con = DBConnection.getConnection();
	}

	// Create an instance of the class TaskDao
	public static TaskDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new TaskDAO();
		}
		return instance;
	}

	// Insert simple Task object in the database
	public void insert(Task task) throws SQLException {
		query = "INSERT INTO tfg_task (_id_task, _name, _subject, _description, _type, _estimated_time, _finalized, _status, _creation_date, _id_team) VALUES (?,?,?,?,?,?,?,?, NOW(),?);";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, task.getId_task());
			ps.setString(2, task.getName());
			ps.setString(3, task.getSubject());
			ps.setString(4, task.getDescription());
			ps.setString(5, task.getType());
			ps.setInt(6, task.getEstimated_time());
			ps.setInt(7, task.getFinalized());
			ps.setString(8, task.getStatus());
			ps.setString(9, task.getId_team());
			ps.executeUpdate();
			ps.close();
			// CURDATE()
		}
	}

	// list all the existing Task objects in the database
	public ArrayList<Task> listAll() throws SQLException {
		query = "SELECT * FROM tfg_task;";
		ArrayList<Task> result;
		try (PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			result = null;
			while (rs.next()) {
				if (result == null) {
					result = new ArrayList<>();
				}
				result.add(new Task(rs.getString("_id_task"), rs.getString("_name"), rs.getString("_subject"),
						rs.getString("_description"), rs.getString("_type"), rs.getInt("_estimated_time"),
						rs.getInt("_finalized"), rs.getString("_status"), rs.getString("_id_team")));
			}
		}
		return result;
	}

	// List Task object by id_task
	public Task listById(String id_task) throws SQLException {
		query = "SELECT * FROM tfg_task WHERE _id_task = ?;";
		Task result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_task);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					result = new Task(rs.getString("_id_task"), rs.getString("_name"), rs.getString("_subject"),
							rs.getString("_description"), rs.getString("_type"), rs.getInt("_estimated_time"),
							rs.getInt("_finalized"), rs.getString("_status"), rs.getString("_id_team"));
				}
			}
		}
		return result;
	}

	// Remove Task object in the database
	public void remove(Task task) throws SQLException {
		remove(task.getId_task());
	}

	// Remove Task object in the database by id_task
	public void remove(String id_task) throws SQLException {
		if ("".equals(id_task)) {
			return;
		}
		query = "DELETE FROM tfg_task WHERE _id_task = ?;";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_task);
			ps.executeUpdate();
		}
	}

	// Update Task object in the database
	public void update(Task task) throws SQLException {
		if ("".equals(task.getId_task())) {
			return;
		}

		query = "UPDATE tfg_task SET _id_task=?, _name=?, _subject=?, _description=?, _type=?, _estimated_time=?, _finalized=?, _status=?, _id_team=? WHERE _id_task=?;";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, task.getId_task());
			ps.setString(2, task.getName());
			ps.setString(3, task.getSubject());
			ps.setString(4, task.getDescription());
			ps.setString(5, task.getType());
			ps.setInt(6, task.getEstimated_time());
			ps.setInt(7, task.getFinalized());
			ps.setString(8, task.getStatus());
			ps.setString(9, task.getId_team());
			ps.setString(10, task.getId_task());
			ps.executeUpdate();
			ps.close();
		}
	}

	// Returns an int and is admin if a Project object is created or not
	public int projectIsCreatedOrNot(String subject) throws SQLException {
		int result = 0;
		query = "SELECT COUNT('_subject') FROM tfg_task WHERE _subject = '" + subject + "';";
		try (PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			if (rs.next()) {
				result = rs.getInt(1);
			}
		}
		return result;
	}

	// Select id_task by name
	public String selectIdTaskByName(String taskName) throws SQLException {
		query = "SELECT _id_task FROM tfg_task WHERE _name = ?;";
		String result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, taskName);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					result = rs.getString("_id_task");
				}
			}
		}
		return result;
	}

	// List of all Project objects related to a team to show them
	// to the user when creating a task
	public ArrayList<String> listAllProjectsForATeam(String id_team) throws SQLException {
		query = "SELECT _id_project FROM tfg_tasks_in_projects WHERE _id_team = '" + id_team + "';";
		ArrayList<String> result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ResultSet rs = ps.executeQuery();
			result = null;
			while (rs.next()) {
				if (result == null) {
					result = new ArrayList<>();
				}
				result.add(rs.getString("_id_project"));
			}
			rs.close();
		}
		return result;
	}

	// List all names for a concrete Project object
	public ArrayList<String> listAllNamesForConcreteProjects(String id_team) throws SQLException {
		ArrayList<String> projects = listAllProjectsForATeam(id_team);
		ArrayList<String> result = null;

		for (int i = 0; i < projects.size(); i++) {
			query = "SELECT _name FROM tfg_project WHERE _id_project = '" + projects.get(i) + "';";
			try (PreparedStatement ps = con.prepareStatement(query)) {
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					if (result == null) {
						result = new ArrayList<>();
					}
					result.add(rs.getString("_name"));
				}
				rs.close();
			} catch (Exception ex) {
				System.out.println("err: " + ex);
			}
		}
		return result;
	}

	public void insertTaskAndTeamRelationShip(String id_team, String id_task) throws SQLException {
		query = "INSERT INTO tfg_team_task (_id_team_task, _id_team, _id_task) VALUES (?, ?, ?);";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, UUID.randomUUID().toString());
			ps.setString(2, id_team);
			ps.setString(3, id_task);
		}
	}
	
	public ArrayList<Task> listAllTasksForOneUser(String id_user) throws SQLException {
		query = "SELECT * FROM tfg_task WHERE _id_team IN (SELECT _id_team FROM tfg_members_team WHERE _id_user = ?) ORDER BY _creation_date DESC;";
		ArrayList<Task> result = null;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_user);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				while (rs.next()) {
					if (result == null) {
						result = new ArrayList<>();
					}
					result.add(new Task(rs.getString("_id_task"), rs.getString("_name"), rs.getString("_subject"), rs.getString("_description"), rs.getString("_type"), rs.getInt("_estimated_time"),
							rs.getInt("_finalized"), rs.getString("_status"), rs.getString("_id_team")));
				}
			}
		}
		return result;
	}
	

	
	
	
}
