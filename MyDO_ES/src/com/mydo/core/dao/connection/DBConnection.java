package com.mydo.core.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	// for the connection
	private static String dialect = "jdbc:mysql";
	private static String host = "localhost";
	private static String port = "3306";
	private static String database = "MyDO_Application";
	private static String charset = "?useUnicode=true&characterEncoding=utf-8";
	
	// user credentials
	private static String user = "root";
	private static String password = "";
	
	private static final String JDBC_URL = dialect + "://" + host + ":" + port + "/" + database + charset; // for the database connection
	private static Connection instance = null;
	
	private DBConnection() {}
	
	/**
	 * Crea una conexi�n con la base de datos usando los credenciales de usuario para MySQL
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		if (instance == null) {
			Properties props = new Properties();
			props.put("user", user);
			props.put("password", password);
			instance = DriverManager.getConnection(JDBC_URL, props);
		}
		return instance;
	}
	
}
