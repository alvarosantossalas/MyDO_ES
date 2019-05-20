package com.mydo.controller;

import com.mydo.core.model.Task;
import com.mydo.core.model.Team;
import com.mydo.core.model.User;
import com.mydo.core.dao.TeamDAO;
import com.mydo.core.dao.UserDAO;

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
	
	public ArrayList<String> listAllUsersForATeam(String id_team) throws SQLException {
		return TeamDAO.getInstance().listAllUsersForATeam(id_team);
	}
	
	public String selectAdminByIdTeam(String id) throws SQLException {
		return UserDAO.getInstance().selectAdminByIdTeam(id);
	}
	
	public String showTeamsForThisUser(User user) throws SQLException {
		String str = "";
		if (TeamCtrl.getInstance().listAllTeamsForOneUser(user.getId_user()) != null) {
			ArrayList<String> team_list = listAllTeamsForOneUser(user.getId_user());
			for (int i = 0; i < team_list.size(); i++) {
				str += "<option value='" + team_list.get(i) + "'>" + team_list.get(i) + "</option>";
			}
		} else {
			str += "<option>No se han encontrado resultados</option>";
		}
		return str;
	}
	
	public String showResponsibleTeamForATask(String id_user, Task selected_task) throws SQLException {
		String str = "";
		if (listAllTeamsForOneUser(id_user) != null) {
			ArrayList<String> team_list = listAllTeamsForOneUser(id_user);
			for (int i = 0; i < team_list.size(); i++) {
				String current_id_team = selectIdTeamByName(team_list.get(i));
				if (!current_id_team.equals(selected_task.getId_team())) {
					str += "<option value='"+team_list.get(i)+"'>"+team_list.get(i)+"</option>";
				} else {
					str += "<option value='"+team_list.get(i)+"' selected>" + team_list.get(i) + "</option>";
				}
			}
		}
		return str;
	}
	
	/*
 * 								if (TeamCtrl.getInstance().listAllTeamsForOneUser(id_user_logado) != null) {
									ArrayList<String> team_list = TeamCtrl.getInstance().listAllTeamsForOneUser(id_user_logado);
									for (int i = 0; i < team_list.size(); i++) {
										// Por cada nombre que recorre sacaremos su id
										String current_id_team = TeamCtrl.getInstance().selectIdTeamByName(team_list.get(i));
										// Si el id que recorremos es igual al id que buscamos...
										if (!current_id_team.equals(selected_task.getId_team())) {
											out.println("<option value='" + team_list.get(i) + "'>" + team_list.get(i) + "</option>");
										} else {
											out.println("<option value='" + team_list.get(i) + "' selected>" + team_list.get(i)
													+ "</option>");
										}
									}
								}
	 */
	
	
}
