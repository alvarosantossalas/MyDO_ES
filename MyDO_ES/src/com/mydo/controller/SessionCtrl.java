package com.mydo.controller;

import com.mydo.core.model.Session;
import com.mydo.core.dao.SessionDAO;
import java.sql.SQLException;

public class SessionCtrl {

	private static SessionCtrl instance = null;

	/**
	 * Retorna una instancia de la clase
	 * @return
	 * @throws SQLException
	 */
	public static SessionCtrl getInstance() throws SQLException {
		if (instance == null)
			instance = new SessionCtrl();
		return instance;
	}

	/**
	 * Abre una sesión de usuario
	 * @param session
	 * @throws SQLException
	 */
	public void openSession(Session session) throws SQLException {
		SessionDAO.getInstance().createSession(session);
	}

	/**
	 * Termina una sesión de usuario filtando por id
	 * @param id
	 * @throws SQLException
	 */
	public void closeSession(String id) throws SQLException {
		SessionDAO.getInstance().closeSession(id);
	}

	/**
	 * Termina una sesión de usuario
	 * @param session
	 * @throws SQLException
	 */
	public void closeSession(Session session) throws SQLException {
		SessionDAO.getInstance().closeSession(session.getId_user());
	}

	/**
	 * Inserta un registro de sesión de usuario en el historial de login
	 * @param session
	 * @throws SQLException
	 */
	public void insertInHistory(Session session) throws SQLException {
		SessionDAO.getInstance().insertInHistory(session);
	}

}
