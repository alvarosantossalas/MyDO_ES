package com.mydo.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mydo.core.dao.connection.DBConnection;
import com.mydo.core.model.Session;

/**
 * Define todos los métodos para interactuar en la base de datos con objetos de tipo Session
 * @author alvaro.santos
 * @version 30/05/2019 A
 */
public class SessionDAO {

	private static String query;

	private Connection con = null;
	private static SessionDAO instance = null;

	/**
	 * <b>Constructor</b>
	 * Llama a clase DBConnection y concretamente con el método getConnection que es el que se encarga
	 * de crear una conexión con la base de datos
	 * @throws SQLException
	 */
	private SessionDAO() throws SQLException {
		con = DBConnection.getConnection();
	} /* close constructor */

	/**
	 * <b>getInstance()</b>
	 * Obtiene una instancia de la clase SessionDAO para poder interactuar con sus métodos
	 * @return una instancia de la clase
	 * @throws SQLException
	 */
	public static SessionDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new SessionDAO();
		} /* close if */
		return instance;
	} /* close method */

	/**
	 * <b>createSession</b>
	 * Inserta una sesión en la base de datos. Cada vez que se crea una sesión, llama al método que inserta
	 * esa sesión en el historial donde permanecerá permanentemente sin aspirar a ser borrado
	 * @param session se crea una sesión con los datos introducidos previamente
	 * @throws SQLException
	 */
	public void createSession(Session session) throws SQLException {
		query = "INSERT INTO tfg_login (_id_user, _date) VALUES (?,?);";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, session.getId_user());
			ps.setString(2, session.getDate());
			ps.executeUpdate();
			ps.close();
		} /* close try */
		insertInHistory(session); 
	} /* close method */

	/**
	 * <b>insertInHistory()</b>
	 * Inserta un objecto sesión en el historial
	 * @param session se crea un registro en el historial de la aplicación con los datos de la sesión
	 * @throws SQLException
	 */
	public void insertInHistory(Session session) throws SQLException {
		query = "INSERT INTO tfg_history (_id_user, _date) VALUES (?,?);";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, session.getId_user());
			ps.setString(2, session.getDate());
			ps.executeUpdate();
			ps.close();
		} /* close try */
	} /* close method */

	/**
	 * <b>closeSession</b>
	 * Elimina un objecto sesión de la base de datos
	 * @param id_user El id del usuario del cual se va a eliminar la sesión
	 * @throws SQLException
	 */
	public void closeSession(String id_user) throws SQLException {
		query = "DELETE FROM tfg_login WHERE _id_user = ?;";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_user);
			ps.executeUpdate();
			ps.close();
		} /* close try */
	} /* close method */

} /* close class */ 
