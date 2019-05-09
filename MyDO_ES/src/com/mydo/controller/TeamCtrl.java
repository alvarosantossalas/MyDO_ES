package com.mydo.controller;

import com.mydo.core.model.Team;
import com.mydo.core.dao.TeamDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeamCtrl {

	private static TeamCtrl instance = null;
	
	public static TeamCtrl getInstance() throws SQLException {
		if (instance == null)
			instance = new TeamCtrl();
		return instance;
	}
	
	// insert team object
	public void insert(Team team) throws SQLException {
		TeamDAO.getInstance().insert(team);
	}
	
	// update team object
	public void update(Team team) throws SQLException {
		TeamDAO.getInstance().update(team);
	}
	
	// remove team object
	public void remove(String id) throws SQLException {
		TeamDAO.getInstance().remove(id);
	}
	
	// list all the existing team objects
	public ArrayList<Team> listAll() throws SQLException {
		return TeamDAO.getInstance().listAll();
	}
	
	// list team object by id
	public Team listById(String id) throws SQLException {
		return TeamDAO.getInstance().listById(id);
	}
	
	// select id by name
	public String selectIdTeamByName(String name) throws SQLException {
		return TeamDAO.getInstance().selectIdTeamByName(name);
	}
	
	// select name by id
	public String selectNameTeamById(String id) throws SQLException {
		return TeamDAO.getInstance().selectNameTeamById(id);
	}
	
	// list all names for team object
	public ArrayList<String> findAllTeamNames() throws SQLException {
		return TeamDAO.getInstance().listAllNames();
	}
	
	// list all names for team objects that have one user in common
	public ArrayList<String> listAllTeamsForOneUser(String id) throws SQLException {
		return TeamDAO.getInstance().listAllTeamsForOneUser(id);
	}
	
}
