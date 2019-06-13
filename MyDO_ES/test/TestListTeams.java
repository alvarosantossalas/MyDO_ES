import java.sql.SQLException;
import java.util.ArrayList;

import com.mydo.controller.TeamCtrl;
import com.mydo.utilities.Profile_listProjects;

public class TestListTeams {

	public static void main(String[] args) throws SQLException {
		
		/*Profile_listTeams prueba = new Profile_listTeams();
		
		String id_user = "user_4dc02417-1271-4b02-bac6-2148181af21a";
		ArrayList<String> names = TeamCtrl.getInstance().listAllTeamsForOneUser(id_user);
		ArrayList<String> ids = prueba.turnOnAllTheIdsInList(names);
		
		System.out.println("\n");
		for(int i = 0; i < names.size(); i++) {
			System.out.println("Nombre: " +i+ ", " + names.get(i));
		}
		System.out.println("\n");
		for(int i = 0; i < ids.size(); i++) {
			System.out.println("Id: " + i +", "+ ids.get(i));
		}*/
		
		String id_user = "user_4dc02417-1271-4b02-bac6-2148181af21a";

		Profile_listProjects prueba2 = new Profile_listProjects();
		ArrayList<String> names = TeamCtrl.getInstance().listAllTeamsForOneUser(id_user);
		ArrayList<String> ids = prueba2.turnOnAllTheIdsInList(names);
		 
			System.out.println("\n");
			for(int i = 0; i < names.size(); i++) {
				System.out.println("Nombre: " +i+ ", " + names.get(i));
			}
			System.out.println("\n");
			for(int i = 0; i < ids.size(); i++) {
				System.out.println("Id: " + i +", "+ ids.get(i));
			}
	}
	
}
