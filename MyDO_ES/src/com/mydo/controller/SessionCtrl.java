package com.mydo.controller;

import com.mydo.core.model.Session;
import com.mydo.core.dao.SessionDAO;
import java.sql.SQLException;

public class SessionCtrl {

	private static SessionCtrl instance = null;
	
	public static SessionCtrl getInstance() throws SQLException {
		if (instance == null) 
			instance = new SessionCtrl();
		return instance;
	}
	
	// open session
	public void openSession(Session session) throws SQLException {
		SessionDAO.getInstance().createSession(session);
	}
	
	// close session by id
	public void closeSession(String id) throws SQLException {
		SessionDAO.getInstance().closeSession(id);
	}
	
	// close session
	public void closeSession(Session session) throws SQLException {
		SessionDAO.getInstance().closeSession(session.getId_user());
	}
	
	// create session in history
	public void insertInHistory(Session session) throws SQLException {
		SessionDAO.getInstance().insertInHistory(session);
	}
	
}
