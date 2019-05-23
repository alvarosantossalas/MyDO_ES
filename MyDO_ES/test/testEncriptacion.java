import com.mydo.utilities.SecurityPassword;

public class testEncriptacion {

	public static void main(String[] args) throws Exception {
			
	String encriptado = SecurityPassword.encryptPassword("Esto es una prueba");
    System.out.println(encriptado);
    String desencriptado = SecurityPassword.decryptPassword(encriptado);
    System.out.println(desencriptado);

	}

}
