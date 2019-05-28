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
	
	/**
	 * Retorna una instancia de la clase
	 * @return
	 * @throws SQLException
	 */
	public static TeamCtrl getInstance() throws SQLException {
		if (instance == null)
			instance = new TeamCtrl();
		return instance;
	}
	
	/**
	 * Inserta un equipo en la base de datos
	 * @param team
	 * @throws SQLException
	 */
	public void insert(Team team) throws SQLException {
		TeamDAO.getInstance().insert(team);
	}
	
	/**
	 * Actualiza un equipo en la base de datos
	 * @param team
	 * @throws SQLException
	 */
	public void update(Team team) throws SQLException {
		TeamDAO.getInstance().update(team);
	}
	
	/**
	 * Se elimina un equipo filtrando por id
	 * @param id
	 * @throws SQLException
	 */
	public void remove(String id) throws SQLException {
		TeamDAO.getInstance().remove(id);
	}
	
	/**
	 * Retorna todos los equipos existentes en la base de datos
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Team> listAll() throws SQLException {
		return TeamDAO.getInstance().listAll();
	}
	
	/**
	 * Retorna un equipo de la base de datos filtrando por su id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Team listById(String id) throws SQLException {
		return TeamDAO.getInstance().listById(id);
	}
	
	/**
	 * Retorna el id de un equipo filtrando por su nombre
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public String selectIdTeamByName(String name) throws SQLException {
		return TeamDAO.getInstance().selectIdTeamByName(name);
	}
	
	/**
	 * Retorna el nombre de un equipo filtrando por su id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public String selectNameTeamById(String id) throws SQLException {
		return TeamDAO.getInstance().selectNameTeamById(id);
	}
	
	/**
	 * Retorna todos los nombres de los equipos existentes
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> findAllTeamNames() throws SQLException {
		return TeamDAO.getInstance().listAllNames();
	}
	
	/**
	 * Retorna todos los equipos en los que está un usuario
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> listAllTeamsForOneUser(String id) throws SQLException {
		return TeamDAO.getInstance().listAllTeamsForOneUser(id);
	}
	
	/**
	 * Retorna todos los usuarios que pertenecen a un equipo
	 * @param id_team
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> listAllUsersForATeam(String id_team) throws SQLException {
		return TeamDAO.getInstance().listAllUsersForATeam(id_team);
	}
	
	/**
	 * Retorna el usuario administrador de un equipo
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public String selectAdminByIdTeam(String id) throws SQLException {
		return UserDAO.getInstance().selectAdminByIdTeam(id);
	}
	
	/**
	 * Muestra en HTML los equipos a los que pertenece un usuario
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public String showTeamsForThisUser(User user) throws SQLException {
		StringBuffer sb = new StringBuffer();
		ArrayList<String> team_list;
		if (TeamCtrl.getInstance().listAllTeamsForOneUser(user.getId_user()) != null) {
		 	team_list = listAllTeamsForOneUser(user.getId_user());
			for (int i = 0; i < team_list.size(); i++) {
				sb.append("<option value='" + team_list.get(i) + "'>" + team_list.get(i) + "</option>");
			}
		} else {
			sb.append("<option>No se han encontrado resultados</option>");
		}
		return sb.toString();
	}
	
	/**
	 * Refleja en HTML cuál de los usuarios de ese equipo es el responsable
	 * @param id_user
	 * @param selected_task
	 * @return
	 * @throws SQLException
	 */
	public String showResponsibleTeamForATask(String id_user, Task selected_task) throws SQLException {
		StringBuffer sb = new StringBuffer();
		ArrayList<String> team_list;
		String current_id_team;
		if (listAllTeamsForOneUser(id_user) != null) {
			team_list = listAllTeamsForOneUser(id_user);
			for (int i = 0; i < team_list.size(); i++) {
				current_id_team = selectIdTeamByName(team_list.get(i));
				if (!current_id_team.equals(selected_task.getId_team())) {
					sb.append("<option value='"+team_list.get(i)+"'>"+team_list.get(i)+"</option>");
				} else {
					sb.append("<option value='"+team_list.get(i)+"' selected>" + team_list.get(i) + "</option>");
				}
			}
		}
		return sb.toString();
	}	
}
