package com.mydo.controller;

import com.mydo.core.model.Notify;
import com.mydo.core.dao.NotifyDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class NotifyCtrl {

	// Insert notify object
	public void insert(Notify notify) throws SQLException {
		NotifyDAO.getInstance().insert(notify);
	}
	
	// update notify object
	public void update(Notify notify) throws SQLException {
		NotifyDAO.getInstance().update(notify);
	}
	
	// remove notify Remove notify object
	public void remove(String id) throws SQLException {
		NotifyDAO.getInstance().remove(id);
	}
	
	// list all the existing notify objects
	public ArrayList<Notify> listAll() throws SQLException {
		return NotifyDAO.getInstance().listAll();
	}
	
	// list notify object by id_notify
	public Notify listById(String id) throws SQLException {
		return NotifyDAO.getInstance().listById(id);
	}
	
}
