import com.mydo.utilities.SecurityPassword;

public class testEncriptacion {

	public static void main(String[] args) throws Exception {
			
	String encriptado = SecurityPassword.Encriptar("Esto es una prueba");
    System.out.println(encriptado);
    String desencriptado = SecurityPassword.Desencriptar(encriptado);
    System.out.println(desencriptado);

	}

}
