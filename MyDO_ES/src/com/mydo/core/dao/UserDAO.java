package com.mydo.core.dao;

import com.mydo.core.model.User;
import com.mydo.core.model.Team;
import com.mydo.core.dao.connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class UserDAO {

	// Variable that will be used throughout the program to manage queries in the
	// database
	private static String query;

	private Connection con = null;
	private static UserDAO instance = null;

	// Method that returns the connection to the database
	private UserDAO() throws SQLException {
		con = DBConnection.getConnection();
	}

	// Create an instance of the class UserDao
	public static UserDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	// Insert a User object without Team object
	public void insertWithoutTeam(User user) throws SQLException {
		query = "INSERT INTO tfg_user (_id_user, _admin, _username, _password, _name, _lastname, _email, _phone) VALUES (?,?,?,?,?,?,?,?);";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, user.getId_user());
			ps.setInt(2, user.getAdmin());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getName());
			ps.setString(6, user.getLastname());
			ps.setString(7, user.getEmail());
			ps.setString(8, user.getPhone());
			ps.executeUpdate();
			ps.close();
		}
	}

	// Insert a User object with Team Object relation
	public void insertWithTeam(User user, Team team) throws SQLException {
		query = "INSERT INTO tfg_user (_id_user, _admin, _username, _password, _name, _lastname, _email, _phone) VALUES (?,?,?,?,?,?,?,?);";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, user.getId_user());
			ps.setInt(2, user.getAdmin());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getName());
			ps.setString(6, user.getLastname());
			ps.setString(7, user.getEmail());
			ps.setString(8, user.getPhone());
			ps.executeUpdate();
			ps.close();
		}

		query = "INSERT INTO tfg_team(_id_team, _name, _image) VALUES (?,?,?);";
		try (PreparedStatement ps2 = con.prepareStatement(query)) {
			ps2.setString(1, team.getId_team());
			ps2.setString(2, team.getName());
			ps2.setString(3, team.getImage());
			ps2.executeUpdate();
			ps2.close();
		}

		query = "INSERT INTO tfg_members_team (_id_members_team, _id_team, _id_user) VALUES (?,?,?);";
		try (PreparedStatement ps3 = con.prepareStatement(query)) {
			ps3.setString(1, UUID.randomUUID().toString());
			ps3.setString(2, team.getId_team());
			ps3.setString(3, user.getId_user());
			ps3.executeUpdate();
			ps3.close();
		}
	}

	// List all the User objects that exists in the database
	public ArrayList<User> listAll() throws SQLException {
		query = "SELECT * FROM tfg_user;";
		ArrayList<User> result;
		try (PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			result = null;
			while (rs.next()) {
				if (result == null) {
					result = new ArrayList<>();
				}
				result.add(new User(rs.getString("_id_user"), rs.getInt("_admin"), rs.getString("_username"),
						rs.getString("_password"), rs.getString("_name"), rs.getString("_lastname"),
						rs.getString("_email"), rs.getString("_phone")));
			}
		}
		return result;
	}

	// List User object by id_user
	public User listById(String id_user) throws SQLException {
		query = "SELECT * FROM tfg_user WHERE _id_user = ?;";
		User result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_user);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					result = new User(rs.getString("_id_user"), rs.getInt("_admin"), rs.getString("_username"),
							rs.getString("_password"), rs.getString("_name"), rs.getString("_lastname"),
							rs.getString("_email"), rs.getString("_phone"));
				}
			}
		}
		return result;
	}

	// Remove a User object in the database
	public void remove(User user) throws SQLException {
		remove(user.getId_user());
	}

	// Remove a User object in the database by id_user
	public void remove(String id_user) throws SQLException {
		if ("".equals(id_user)) {
			return;
		}
		query = "DELETE FROM tfg_user WHERE _id_user = ?;";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_user);
			ps.executeUpdate();
		}
	}

	// Update a User object in the database
	public void update(User user) throws SQLException {
		if ("".equals(user.getId_user())) {
			return;
		}
		query = "UPDATE tfg_user SET _id_user=?, _admin=?, _username=?, _password=?, _name=?, _lastname=?, _email=?, _phone=? WHERE _id_user=?;";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, user.getId_user());
			ps.setInt(2, user.getAdmin());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getName());
			ps.setString(6, user.getLastname());
			ps.setString(7, user.getEmail());
			ps.setString(8, user.getPhone());
			ps.setString(9, user.getId_user());
			ps.executeUpdate();
			ps.close();
		}
	}

	// This method check if User object exist in the database
	public boolean canLogin(String username, String password) throws SQLException {
		query = "SELECT _username, _password FROM tfg_user WHERE _username = ? AND _password = ?;";
		boolean result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, username);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery()) {
				result = false;
				if (rs.next()) {
					result = true;
				}
			}
		}
		return result;
	}

}