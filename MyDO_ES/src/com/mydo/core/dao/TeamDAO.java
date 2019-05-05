package com.mydo.core.dao;

import com.mydo.core.model.Team;
import com.mydo.core.dao.connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeamDAO {

	// Variable that will be used throughout the program to manage queries in the database
	private static String query;

	private Connection con = null;
	private static TeamDAO instance = null;

	// Method that returns the connection to the database
	private TeamDAO() throws SQLException {
		con = DBConnection.getConnection();
	}

	// Create an instance of the class TeamDao
	public static TeamDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new TeamDAO();
		}
		return instance;
	}

	// Insert Team object in the database
	public void insert(Team team) throws SQLException {
		query = "INSERT INTO tfg_team (_id_team, _name, _image) VALUES (?,?,?);";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, team.getId_team());
			ps.setString(2, team.getName());
			ps.setString(3, team.getImage());
			ps.executeUpdate();
			ps.close();
		}
	}

	// This method list all the existing Team object in the database
	public ArrayList<Team> listAll() throws SQLException {
		query = "SELECT * FROM tfg_team;";
		ArrayList<Team> result;
		try (PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			result = null;
			while (rs.next()) {
				if (result == null) {
					result = new ArrayList<>();
				}
				result.add(new Team(rs.getString("_id_team"), rs.getString("_name"), rs.getString("_image")));
			}
		}
		return result;
	}

	// List Team object by id_team
	public Team listById(String id_team) throws SQLException {
		query = "SELECT * FROM tfg_team WHERE _id_team = ?;";
		Team result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_team);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					result = new Team(rs.getString("_id_team"), rs.getString("_name"), rs.getString("_image"));
				}
			}
		}
		return result;
	}

	// Remove Team object in the database
	public void remove(Team team) throws SQLException {
		remove(team.getId_team());
	}

	// Remove Team object in the database by id_team
	public void remove(String id_team) throws SQLException {
		if ("".equals(id_team)) {
			return;
		}
		query = "DELETE FROM tfg_team WHERE _id_team = ?;";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_team);
			ps.executeUpdate();
		}
	}

	// Update a Team object in the database
	public void update(Team team) throws SQLException {
		if ("".equals(team.getId_team())) {
			return;
		}
		query = "UPDATE tfg_team SET _id_team=?, _name=?, _image=? WHERE _id_team=?;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, team.getId_team());
		ps.setString(2, team.getName());
		ps.setString(3, team.getImage());
		ps.setString(4, team.getId_team());
		ps.executeUpdate();
	}

	// Select id_team by name
	public String selectIdTeamByName(String teamName) throws SQLException {
		query = "SELECT _id_team FROM tfg_team WHERE _name = ?;";
		String result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, teamName);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					result = rs.getString("_id_team");
				}
			}
		}
		return result;
	}

	// List all names for Team objects
	public ArrayList<String> listAllNames() throws SQLException {
		query = "SELECT _name FROM tfg_team;";
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

	// List all Team objects for one user
	public ArrayList<String> listAllTeamsForOneUser(String id_user) throws SQLException {
		query = "SELECT _id_team FROM tfg_members_team WHERE _id_user = ?;";
		ArrayList<String> temp;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_user);
			try (ResultSet rs = ps.executeQuery()) {
				temp = null;
				while (rs.next()) {
					if (temp == null) {
						temp = new ArrayList<>();
					}
					temp.add(rs.getString("_id_team"));
				}
			}
		}

		ArrayList<String> result = null;
		for (int i = 0; i < temp.size(); i++) {
			query = "SELECT _name FROM tfg_team WHERE _id_team = ?;";
			try (PreparedStatement ps = con.prepareStatement(query)) {
				ps.setString(1, temp.get(i));
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						if (result == null) {
							result = new ArrayList<>();
						}
						result.add(rs.getString("_name"));
					}
				}
			} catch (Exception e) {
				System.out.println("Err: " + e);
			}
		}
		return result;
	}

	// Select name by id_team
	public String selectNameTeamById(String id_team) throws SQLException {
		query = "SELECT _name FROM tfg_team WHERE _id_team = ?;";
		String result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_team);
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
