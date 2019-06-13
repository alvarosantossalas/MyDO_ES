import java.sql.SQLException;
import java.util.UUID;

public class test {

	public static void main(String[] args) throws SQLException {
		
		/*String id_user = "user_4dc02417-1271-4b02-bac6-2148181af21a";
		String id_task = "task_a12b7954-6925-4e42-bf63-77418a17cec4";
		
		Task result = TaskCtrl.getInstance().listById(id_task);
		*/
		
		String uno = UUID.randomUUID().toString();
		String dos = UUID.randomUUID().toString();
		
		String tres = uno + dos;
		
		System.out.println("Uno : " + uno);
		System.out.println("Dos : " + dos);
		System.out.println("Tres: " + tres);
		
	}
	
}
