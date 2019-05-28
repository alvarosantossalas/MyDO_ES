package com.mydo.core.dao;

import com.mydo.core.model.User;
import com.mydo.utilities.SecurityPassword;
import com.mydo.core.model.Team;
import com.mydo.core.dao.connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class UserDAO {

	private static String query;

	private Connection con = null;
	private static UserDAO instance = null;

	/**
	 * Retorna una conexión con la base de datos
	 * @throws SQLException
	 */
	private UserDAO() throws SQLException {
		con = DBConnection.getConnection();
	}

	/**
	 * Retorna una instancia de la clase
	 * @return
	 * @throws SQLException
	 */
	public static UserDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	/**
	 * Inserta un usuario sin ningún equipo en la base de datos
	 * @param user
	 * @throws Exception
	 */
	public void insertWithoutTeam(User user) throws Exception {
		query = "INSERT INTO tfg_user (_id_user, _admin, _username, _password, _name, _lastname, _email, _phone) VALUES (?,?,?,?,?,?,?,?);";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, user.getId_user());
			ps.setInt(2, user.getAdmin());
			ps.setString(3, user.getUsername());
			ps.setString(4, SecurityPassword.encryptPassword(user.getPassword()));
			ps.setString(5, user.getName());
			ps.setString(6, user.getLastname());
			ps.setString(7, user.getEmail());
			ps.setString(8, user.getPhone());
			ps.executeUpdate();
			ps.close();
		}
	}

	/**
	 * Inserta un usuario y lo relaciona con un equipo en la base de datos
	 * @param user
	 * @param team
	 * @throws SQLException
	 */
	public void insertWithTeam(User user, Team team) throws SQLException {
		query = "INSERT INTO tfg_user (_id_user, _admin, _username, _password, _name, _lastname, _email, _phone) VALUES (?,?,?,?,?,?,?,?);";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, user.getId_user());
			ps.setInt(2, user.getAdmin());
			ps.setString(3, user.getUsername());
			ps.setString(4, SecurityPassword.encryptPassword(user.getPassword()));
			ps.setString(5, user.getName());
			ps.setString(6, user.getLastname());
			ps.setString(7, user.getEmail());
			ps.setString(8, user.getPhone());
			ps.executeUpdate();
			ps.close();
		} catch (Exception ex1) {
			System.out.println("El error está en UserDAO al insertar al usuario \n Error: " + ex1);
		}

		query = "INSERT INTO tfg_team(_id_team, _name, _image, _admin) VALUES (?,?,?,?);";
		try (PreparedStatement ps2 = con.prepareStatement(query)) {
			ps2.setString(1, team.getId_team());
			ps2.setString(2, team.getName());
			ps2.setString(3, team.getImage());
			ps2.setString(4, user.getId_user());
			ps2.executeUpdate();
			ps2.close();
		} catch (Exception ex2) {
			System.out.println("El error está en UserDAO al insertar el equipo \n Error: " + ex2);
		}

		query = "INSERT INTO tfg_members_team (_id_members_team, _id_team, _id_user) VALUES (?,?,?);";
		try (PreparedStatement ps3 = con.prepareStatement(query)) {
			ps3.setString(1, UUID.randomUUID().toString());
			ps3.setString(2, team.getId_team());
			ps3.setString(3, user.getId_user());
			ps3.executeUpdate();
			ps3.close();
		} catch (Exception ex3) {
			System.out.println("El error está en UserDAO al insertar la relación \n Error: " + ex3);
		}
	}

	/**
	 * Retorna todos los usuarios que existen en la base de datos
	 * @return
	 * @throws Exception
	 */
	public ArrayList<User> listAll() throws Exception {
		query = "SELECT * FROM tfg_user;";
		ArrayList<User> result;
		try (PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			result = null;
			while (rs.next()) {
				if (result == null) {
					result = new ArrayList<>();
				}
				String decrypted_password = SecurityPassword.decryptPassword(rs.getString("_password"));
				result.add(new User(rs.getString("_id_user"), rs.getInt("_admin"), rs.getString("_username"),
						decrypted_password, rs.getString("_name"), rs.getString("_lastname"),
						rs.getString("_email"), rs.getString("_phone")));
			}
		}
		return result;
	}

	/**
	 * Retorna un usuario filtrando por _id_user
	 * @param id_user
	 * @return
	 * @throws Exception
	 */
	public User listById(String id_user) throws Exception {
		query = "SELECT * FROM tfg_user WHERE _id_user = ?;";
		User result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_user);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					String decrypted_password = SecurityPassword.decryptPassword(rs.getString("_password"));
					result = new User(rs.getString("_id_user"), rs.getInt("_admin"), rs.getString("_username"),
							decrypted_password, rs.getString("_name"), rs.getString("_lastname"),
							rs.getString("_email"), rs.getString("_phone"));
				}
			}
		}
		return result;
	}
	
	/**
	 * Retorna un _id_user filtrando por _username
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public String selectIdByUsername(String username) throws SQLException {
		query = "SELECT _id_user FROM tfg_user WHERE _username = ?;";
		String result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) 
					result = rs.getString("_id_user");
			}
		}
		return result;
	}
	
	/**
	 * Retorna un _name filtrando por _username
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public String selectNameByUsername(String username) throws SQLException {
		query = "SELECT _name FROM tfg_user WHERE _username = ?;";
		String result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					result = rs.getString("_name");
				}
			}
		}
		return result;
	}
	
	/**
	 * Retorna el usuario administrador de un equipo
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public String selectAdminByIdTeam(String id) throws SQLException {
		query = "SELECT _admin FROM tfg_team WHERE _id_team = ?";
		String result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					result = rs.getString("_admin");
				}
			}
		}
		return result;
	}
	
	/**
	 * Retorna _password filtrando por _id_user
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String selectPasswordById_user(String id) throws Exception {
		query = "SELECT _password FROM tfg_user WHERE _id_user = ?;";
		String result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					result = SecurityPassword.decryptPassword(rs.getString("_password"));
				}
			}
		}
		return result;
	}
	
	/**
	 * Retorna _username filtrando por _id_user
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public String selectUsernameByIdUser(String id) throws SQLException {
		query = "SELECT _username FROM tfg_user WHERE _id_user = ?;";
		String result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				result = null;
				if (rs.next()) {
					result = rs.getString("_username");
				}
			}
		}
		return result;
	}

	/**
	 * Elimina un usuario de la base de datos
	 * @param user
	 * @throws SQLException
	 */
	public void remove(User user) throws SQLException {
		remove(user.getId_user());
	}

	/**
	 * Elimina un usuario de la base de datos filtrando por _id_user
	 * @param id_user
	 * @throws SQLException
	 */
	public void remove(String id_user) throws SQLException {
		if ("".equals(id_user)) {
			return;
		}
		query = "DELETE FROM tfg_user WHERE _id_user = ?;";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_user);
			ps.executeUpdate();
		}
	}

	/**
	 * Actualiza un usuario en la base de datos
	 * @param user
	 * @throws Exception
	 */
	public void update(User user) throws Exception {
		if ("".equals(user.getId_user())) {
			return;
		}
		query = "UPDATE tfg_user SET _id_user=?, _admin=?, _username=?, _password=?, _name=?, _lastname=?, _email=?, _phone=? WHERE _id_user=?;";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, user.getId_user());
			ps.setInt(2, user.getAdmin());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getName());
			ps.setString(6, user.getLastname());
			ps.setString(7, user.getEmail());
			ps.setString(8, user.getPhone());
			ps.setString(9, user.getId_user());
			ps.executeUpdate();
			ps.close();
		}
	}

	/**
	 * Comprueba las credenciales introducidas por el usuario y las compara con las registradas en la base de datos
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public boolean login(String username, String password) throws Exception {
		
		query = "SELECT _username, _password FROM tfg_user WHERE _username = ?;";
		User user;
		boolean result;
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()) {
				result = false;
				if (rs.next()) {
					user = new User(rs.getString("_username"), rs.getString("_password"));
					String decrypted_password = SecurityPassword.decryptPassword(user.getPassword());
					if (decrypted_password.equals(password)) {
						result = true;
					}
				}
			}
		}
		return result;
	}
	
	/**
	 * Elimina a un usuario de un quipo
	 * @param id_user
	 * @param id_team
	 * @throws SQLException
	 */
	public void removeUserFromTeam(String id_user, String id_team) throws SQLException {
		query = "DELETE FROM tfg_members_team WHERE _id_user = ? AND _id_team = ?;";
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, id_user);
			ps.setString(2, id_team);
			ps.executeUpdate();
			ps.close();
		}
	}

}
