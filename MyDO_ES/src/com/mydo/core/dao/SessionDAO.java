package com.mydo.core.dao;

import com.mydo.core.model.Session;
import com.mydo.core.dao.connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SessionDAO {

	private static String query;

	private Connection con = null;
	private static SessionDAO instance = null;

	/**
	 * Retorna una conexión con la base de datos
	 * @throws SQLException
	 */
	private SessionDAO() throws SQLException {
		con = DBConnection.getConnection();
	}

	/**
	 * Retorna una instancia de la clase
	 * @return
	 * @throws SQLException
	 */
	public static SessionDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new SessionDAO();
		}
		return instance;
	}

	/**
	 * Inserta una objeto sesión en la base de datos
	 * @param session
	 * @throws SQLException
	 */
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

	/**
	 * Inserta un objecto sesión en el historial
	 * @param session
	 * @throws SQLException
	 */
	public void insertInHistory(Session session) throws SQLException {
		query = "INSERT INTO tfg_history (_id_user, _date) VALUES (?,?);";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, session.getId_user());
			ps.setString(2, session.getDate());
			ps.executeUpdate();
			ps.close();
		}
	}

	/**
	 * Elimina un objecto sesión de la base de datos
	 * @param id_user
	 * @throws SQLException
	 */
	public void closeSession(String id_user) throws SQLException {
		query = "DELETE FROM tfg_login WHERE _id_user = ?;";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_user);
			ps.executeUpdate();
		}
	}

}
