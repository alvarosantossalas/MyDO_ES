package com.mydo.core.dao;

import com.mydo.core.model.Session;
import com.mydo.core.dao.connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SessionDAO {

	// variable that will be used throughout the program to manage queries in the
	// database
	private static String query;

	private Connection con = null;
	private static SessionDAO instance = null;

	// method that returns the database connection
	private SessionDAO() throws SQLException {
		con = DBConnection.getConnection();
	}

	// create an instance of the class SessionDao
	public static SessionDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new SessionDAO();
		}
		return instance;
	}

	// create a Session object
	public void createSession(Session session) throws SQLException {
		query = "INSERT INTO tfg_login (_id_user, _date) VALUES (?,?);";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, session.getId_user());
			ps.setString(2, session.getDate());
			ps.executeUpdate();
			ps.close();
		}
		insertInHistory(session);
	}

	// insert a Session object in Historys
	public void insertInHistory(Session session) throws SQLException {
		query = "INSERT INTO tfg_history (_id_user, _date) VALUES (?,?);";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, session.getId_user());
			ps.setString(2, session.getDate());
			ps.executeUpdate();
			ps.close();
		}
	}

	// remove Session
	public void closeSession(String id_user) throws SQLException {
		query = "DELETE FROM tfg_login WHERE _id_user = ?;";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_user);
			ps.executeUpdate();
		}
	}

}
