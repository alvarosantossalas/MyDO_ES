import java.sql.SQLException;
import java.util.ArrayList;

import com.mydo.core.dao.ProjectDAO;

public class test {

	public static void main(String[] args) throws SQLException {
		
		String id_user = "user_c906be03-b218-47db-b7a7-4d0395511817";
		ArrayList<String> list = ProjectDAO.getInstance().listAllProjectsForOneUser(id_user);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Proyecto: " + list.get(i));
		}
	}
	
}
