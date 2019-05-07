package com.mydo.controller;

import com.mydo.core.model.User;
import com.mydo.core.model.Team;
import com.mydo.core.dao.UserDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserCtrl {

	// insert a user object without team object
	public void insertWithoutTeam(User user) throws SQLException {
		UserDAO.getInstance().insertWithoutTeam(user);
	}
	
	// insert a user object with team object relation
	public void insertWithTeam(User user, Team team) throws SQLException {
			UserDAO.getInstance().insertWithTeam(user, team);
	}
	
	// update a user object
	public void update(User user) throws SQLException {
		UserDAO.getInstance().update(user);
	}
	
	// remove a user object
	public void remove(String id) throws SQLException {
		UserDAO.getInstance().remove(id);
	}
	
	// list all the user objects
	public ArrayList<User> listAll() throws SQLException {
		return UserDAO.getInstance().listAll();
	}
	
	// list user object by id
	public User listById(String id) throws SQLException {
		return UserDAO.getInstance().listById(id);
	}
	
	// check if user can login or not
	public boolean canLoginOrNot(String username, String password) throws SQLException {
		return UserDAO.getInstance().canLogin(username, password);
	}
	
	public String selectNameByUsername(String username) throws SQLException {
		return UserDAO.getInstance().selectNameByUsername(username);
	}
}
