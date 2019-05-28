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

	private static String query;

	private Connection con = null;
	private static TaskDAO instance = null;

	/**
	 * Retorna una conexi�n con la base de datos
	 * @throws SQLException
	 */
	private TaskDAO() throws SQLException {
		con = DBConnection.getConnection();
	}

	/**
	 * Retorna una instancia de la clase
	 * @return
	 * @throws SQLException
	 */
	public static TaskDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new TaskDAO();
		}
		return instance;
	}

	/**
	 * Inserta una tarea en la base de datos
	 * @param task
	 * @throws SQLException
	 */
	public void insert(Task task) throws SQLException {
		query = "INSERT INTO tfg_task (_id_task, _name, _subject, _description, _type, _estimated_time, _consumed_time, _finalized, _status, _creation_date, _id_team) VALUES (?,?,?,?,?,?,?,?,?, NOW(),?);";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, task.getId_task());
			ps.setString(2, task.getName());
			ps.setString(3, task.getSubject());
			ps.setString(4, task.getDescription());
			ps.setString(5, task.getType());
			ps.setInt(6, task.getEstimated_time());
			ps.setInt(7, task.getConsumed_time());
			ps.setInt(8, task.getFinalized());
			ps.setString(9, task.getStatus());
			ps.setString(10, task.getId_team());
			ps.executeUpdate();
			ps.close();
			// CURDATE()
		}
	}

	/**
	 * Retorna todas las tareas existentes de la base de datos 
	 * @return
	 * @throws SQLException
	 */
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
						rs.getInt("_consumed_time"), rs.getInt("_finalized"), rs.getString("_status"),
						rs.getString("_id_team")));
			}
		}
		return result;
	}

	/**
	 * Retorna una tarea filtrando por _id_task
	 * @param id_task
	 * @return
	 * @throws SQLException
	 */
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
							rs.getInt("_consumed_time"), rs.getInt("_finalized"), rs.getString("_status"),
							rs.getString("_id_team"));
				}
			}
		}
		return result;
	}

	/**
	 * Elimina una tarea de la base de datos
	 * @param task
	 * @throws SQLException
	 */
	public void remove(Task task) throws SQLException {
		remove(task.getId_task());
	}

	/**
	 * Elimina una tarea de la base de datos filtrando por _id_task
	 * @param id_task
	 * @throws SQLException
	 */
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

	/**
	 * Actualiza una tarea en la base de datos
	 * @param task
	 * @throws SQLException
	 */
	public void update(Task task) throws SQLException {
		if ("".equals(task.getId_task())) {
			return;
		}

		query = "UPDATE tfg_task SET _id_task=?, _name=?, _subject=?, _description=?, _type=?, _estimated_time=?, _consumed_time=?, _finalized=?, _status=?, _id_team=? WHERE _id_task=?;";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, task.getId_task());
			ps.setString(2, task.getName());
			ps.setString(3, task.getSubject());
			ps.setString(4, task.getDescription());
			ps.setString(5, task.getType());
			ps.setInt(6, task.getEstimated_time());
			ps.setInt(7, task.getConsumed_time());
			ps.setInt(8, task.getFinalized());
			ps.setString(9, task.getStatus());
			ps.setString(10, task.getId_team());
			ps.setString(11, task.getId_task());
			ps.executeUpdate();
			ps.close();
		}
	}

	/**
	 * Retorna un entero dependiendo de la cantidad de tareas que existan con el mismo campo _subject
	 * @param subject
	 * @return
	 * @throws SQLException
	 */
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

	/**
	 * Retorna el _id_task de una tarea filtrando por _name
	 * @param taskName
	 * @return
	 * @throws SQLException
	 */
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

	/**
	 * Retorna todos los projectos relacionados con un equipo en concreto
	 * @param id_team
	 * @return
	 * @throws SQLException
	 */
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

	/**
	 * Lista todos los nombres para un _id_project concreto
	 * @param id_team
	 * @return
	 * @throws SQLException
	 */
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

	/**
	 * Crea una relaci�n entre una tarea y un equipo
	 * @param id_team
	 * @param id_task
	 * @throws SQLException
	 */
	public void insertTaskAndTeamRelationShip(String id_team, String id_task) throws SQLException {
		query = "INSERT INTO tfg_team_task (_id_team_task, _id_team, _id_task) VALUES (?, ?, ?);";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, UUID.randomUUID().toString());
			ps.setString(2, id_team);
			ps.setString(3, id_task);
		}
	}

	/**
	 * Retorna todas las tareas para un usuario
	 * @param id_user
	 * @return
	 * @throws SQLException
	 */
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
					result.add(new Task(rs.getString("_id_task"), rs.getString("_name"), rs.getString("_subject"),
							rs.getString("_description"), rs.getString("_type"), rs.getInt("_estimated_time"), rs.getInt("_consumed_time"),
							rs.getInt("_finalized"), rs.getString("_status"), rs.getString("_id_team")));
				}
			}
		}
		return result;
	}
	
	/**
	 * Retorna el _name de la tarea filtrando por _id_task
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public String selectTaskNameByIdTask(String id) throws SQLException {
		query = "SELECT _name FROM tfg_task WHERE _id_task = ?;";
		String result; 
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					result = rs.getString("_name");
				}
			}
		}
		return result;
	}

}









