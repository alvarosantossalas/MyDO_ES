package com.mydo.utilities;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mydo.controller.TeamCtrl;
import com.mydo.controller.UserCtrl;

public class Profile_listTeams {

	private static Profile_listTeams instance = null;
	
	public static Profile_listTeams getInstance() throws SQLException {
		if (instance == null)
			instance = new Profile_listTeams();
		return instance;
	}
	
	public String fillListTeams(String id_user_logado) throws SQLException {
		
		ArrayList<String> names = TeamCtrl.getInstance().listAllTeamsForOneUser(id_user_logado);
		String team_name;
		String admin;
		ArrayList<String> members;
		String str="";
		ArrayList<String> ids = turnOnAllTheIdsInList(names);
		
		for (int i = 0; i < names.size(); i++) {
			team_name = names.get(i);
			str += "<tr><th scope='row'>"+(i+1)+"</th>"
					+ "<td>" + team_name + "</td>";
			admin = UserCtrl.getInstance().selectNameSurname(TeamCtrl.getInstance().selectAdminByIdTeam(ids.get(i)));
			str += "<td>" + admin + "</td>";
			members = TeamCtrl.getInstance().listAllUsersForATeam(ids.get(i));
			str += "<td class='text-left'>";
			for (int x = 0; x < members.size(); x++) {
				if (admin.equals(UserCtrl.getInstance().selectNameSurname(members.get(x)))) {
					str += "<a href='#' class='btn btn-primary' style='margin-left: 5px;'>" + UserCtrl.getInstance().selectNameSurname(members.get(x)) + "</a>";
				} else {
					str += "<a href='#' class='btn btn-outline-primary' style='margin-left: 5px;'>" + UserCtrl.getInstance().selectNameSurname(members.get(x)) + "</a>";
				}
			}
			str += "</td></tr>";
		}
		return str;
	}

	public ArrayList<String> turnOnAllTheIdsInList(ArrayList<String> names) throws SQLException {
		ArrayList<String> ids = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			ids.add(i, TeamCtrl.getInstance().selectIdTeamByName(names.get(i)));
		}
		return ids;
	}
	
	

}
