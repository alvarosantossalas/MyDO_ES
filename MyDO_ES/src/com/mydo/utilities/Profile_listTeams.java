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
		
		// lista todos los nombres de los equipos de un usuario
		ArrayList<String> names = TeamCtrl.getInstance().listAllTeamsForOneUser(id_user_logado);
		// Por cada equipo...
		String team_name;
		String admin;
		ArrayList<String> members;
		
		String str="";
		
		// Almacena todos los id's de los equipos de un usuario
		ArrayList<String> ids = turnOnAllTheIdsInList(names);
		
		for (int i = 0; i < names.size(); i++) {
			
			team_name = names.get(i);
			System.out.println("\n Nombre del equipo: " + team_name);
			
			str += "<tr><th scope='row'>"+(i+1)+"</th>"
					+ "<td>" + team_name + "</td>";
			
			admin = UserCtrl.getInstance().selectNameById_user(TeamCtrl.getInstance().selectAdminByIdTeam(ids.get(i)));
			
			str += "<td>" + admin + "</td>";
			
			System.out.println("Administrador de " + team_name + " es: " + admin);
			
			members = TeamCtrl.getInstance().listAllUsersForATeam(ids.get(i));
			
			str += "<td class='text-left'>";
			
			for (int x = 0; x < members.size(); x++) {
				//str += UserCtrl.getInstance().selectNameById_user(members.get(x));
				if (admin.equals(UserCtrl.getInstance().selectNameById_user(members.get(x)))) {
					str += "<a href='#' class='btn btn-primary' style='margin-left: 5px;'>" + UserCtrl.getInstance().selectNameById_user(members.get(x)) + "</a>";
				} else {
					str += "<a href='#' class='btn btn-outline-primary' style='margin-left: 5px;'>" + UserCtrl.getInstance().selectNameById_user(members.get(x)) + "</a>";
				}
				
				
				System.out.println("Usuario-"+x+": " + members.get(x));
			}
			
			str += "</td></tr>";
		}
		System.out.println(str);
		return str;
		/*
		 * <tr>
		 * 		<th scope='row'>1</th>
	 	 * 		<td>mdes_manager1_team</td>
	 	 * 		<td>mdes_manager1</td>
	 	 * 		<td class='text-left'>user_4dc02417-1271-4b02-bac6-2148181af21a</td>
	 	 * </tr>
 * 					<tr>
						<th scope="row">1</th>
						<td>Mark</td>
						<td>Otto</td>
						<td class="text-left">@mdo</td>
					</tr>
		 */
	}

	public ArrayList<String> turnOnAllTheIdsInList(ArrayList<String> names) throws SQLException {
		ArrayList<String> ids = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			ids.add(i, TeamCtrl.getInstance().selectIdTeamByName(names.get(i)));
		}

		return ids;
	}
	
	

}
