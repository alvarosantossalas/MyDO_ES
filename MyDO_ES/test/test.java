import java.sql.SQLException;

import com.mydo.controller.TaskCtrl;
import com.mydo.core.model.Task;

public class test {

	public static void main(String[] args) throws SQLException {
		
		String id_user = "user_4dc02417-1271-4b02-bac6-2148181af21a";
		String id_task = "task_a12b7954-6925-4e42-bf63-77418a17cec4";
		
		Task result = TaskCtrl.getInstance().listById(id_task);
		
		
		
	}
	
}
