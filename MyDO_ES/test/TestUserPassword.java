import com.mydo.core.model.User;

public class TestUserPassword {

	public static void main(String[] args) throws Exception {
		
		User user = new User("alvaro", "123");
		System.out.println("User: " + user.getUsername() + " password: " + user.getPassword());
		
	}
	
}
