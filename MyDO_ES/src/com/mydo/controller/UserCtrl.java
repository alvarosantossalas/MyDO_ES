package com.mydo.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mydo.core.dao.UserDAO;
import com.mydo.core.model.Team;
import com.mydo.core.model.User;

public class UserCtrl {

	private static UserCtrl instance = null;

	/**
	 * Retorna una instancia de la clase
	 * @return
	 * @throws SQLException
	 */
	public static UserCtrl getInstance() throws SQLException {
		if (instance == null)
			instance = new UserCtrl();
		return instance;
	}

	/**
	 * Inserta un usuario sin un equipo relacionado
	 * @param user
	 * @throws Exception
	 */
	public void insertWithoutTeam(User user) throws Exception {
		UserDAO.getInstance().insertWithoutTeam(user);
	}

	
	/**
	 * Inserta un usuario con un equipo relacionado
	 * @param user
	 * @param team
	 * @throws SQLException
	 */
	public void insertWithTeam(User user, Team team) throws SQLException {
		UserDAO.getInstance().insertWithTeam(user, team);
	}

	/**
	 * Actualiza un equipo
	 * @param user
	 * @throws Exception
	 */
	public void update(User user) throws Exception {
		UserDAO.getInstance().update(user);
	}

	/**
	 * Elimina un equipo filtrando por su id
	 * @param id
	 * @throws SQLException
	 */
	public void remove(String id) throws SQLException {
		UserDAO.getInstance().remove(id);
	}

	/**
	 * Retorna todos los usuarios existentes
	 * @return
	 * @throws Exception
	 */
	public ArrayList<User> listAll() throws Exception {
		return UserDAO.getInstance().listAll();
	}

	/**
	 * Retorna un usuario filtrandolo por su id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User listById(String id) throws Exception {	
		return UserDAO.getInstance().listById(id);
	}

	/**
	 * Comprueba si las credenciales del usuario son correctas,
	 *  y permite o no, entrar al usuario a la aplicación
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public boolean canLoginOrNot(String username, String password) throws Exception {
		return UserDAO.getInstance().login(username, password);
	}

	/**
	 * Retorna el id de un usuario filtrando por username
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public String selectIdByUsername(String username) throws SQLException {
		return UserDAO.getInstance().selectIdByUsername(username);
	}

	/**
	 * Retorna el nombre de un usuario filtrando por su username
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public String selectNameByUsername(String username) throws SQLException {
		return UserDAO.getInstance().selectNameByUsername(username);
	}

	/**
	 * Retorna name y surname de un usuario filtrando por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String selectNameSurname(String id) throws Exception {
		User user = listById(id);
		return user.getName() + " " + user.getLastname();
	}

	/**
	 * Retorna la contraseña de un usuario filtrando por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public String selectPasswordById_user(String id) throws Exception {
		return UserDAO.getInstance().selectPasswordById_user(id);
	}

	/**
	 * Retorna el nombre de un usuario filtrando por su id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public String selectNameById_user(String id) throws SQLException {
		return UserDAO.getInstance().selectUsernameByIdUser(id);
	}

	/**
	 * Elimina un usuario de un equipo
	 * @param id_user
	 * @param id_team
	 * @throws SQLException
	 */
	public void removeUserFromTeam(String id_user, String id_team) throws SQLException {
		UserDAO.getInstance().removeUserFromTeam(id_user, id_team);
	}

	/**
	 * Comprueba que el usuario contiene todos sus datos rellenos en la base de datos
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User checkDataForUser(User user) throws SQLException {
		if (user.getUsername() == null) {
			user.setUsername("No tenemos registrado tu nombre de usuario...");
		} else if (user.getName() == null) {
			user.setName("No tenemos registrado tu nombre...");
		} else if (user.getLastname() == null) {
			user.setLastname("No tenemos registrados tus apellidos...");
		} else if (user.getEmail() == null) {
			user.setEmail("No tenemos registrado tu email...");
		} else if (user.getPhone() == null) {
			user.setPhone("No tenemos registrado tu teléfono...");
		}
		return user;
	}

	/**
	 * Muestra la información principal del usuario registrado.
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public String showPersonalData(User user) throws Exception {
		return "<p class='display-3'>" + selectNameSurname(user.getId_user()) + "</p>" + "<p class='h5'>"
				+ user.getEmail() + "</p>" + "<p class='h6'>" + user.getPhone() + "</p>";
	}

	/**
	 * Muestra la información principal de un usuario externo
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public String showPersonalDataForExternalUser(User user) throws Exception {
		return "<p class='display-3'>" + selectNameSurname(user.getId_user()) + "</p>"
				+ "<p class='h5'>Nombre de usuario: " + user.getUsername() + "</p>" + "<p class='h5'>Email: "
				+ user.getEmail() + "</p>" + "<p class='h5'>Phone: " + user.getPhone() + "</p>";
	}

	/**
	 * Retorna en HTML un input con el valor del username del usuario logado
	 * @param user
	 * @return
	 */
	public String inputTypeTextForUsername(User user) {
		return "<input type='text' class='form-control disabled' id='_username_update' name='_username_update' placeholder='Nombre de usuario' value='"
				+ user.getUsername() + "' disabled>";
	}

	/**
	 * Retorna en HTML un input con el valor del name del usuario logado
	 * @param user
	 * @return
	 */
	public String inputTypeTextForName(User user) {
		return "<input type='text' class='form-control' id='_name_update' name='_name_update' placeholder='Nombre' value='"
				+ user.getName() + "' required>";
	}

	/**
	 * Retorna el HTML un input con el valor del lastname del usuario logado
	 * @param user
	 * @return
	 */
	public String inputTypeTextForLastname(User user) {
		return "<input type='text' class='form-control' id='_lastname_update' name='_lastname_update' placeholder='Apellidos' value='"
				+ user.getLastname() + "' required>";
	}

	/**
	 * Retorna en HTML un input con el valor del email del usuario logado
	 * @param user
	 * @return
	 */
	public String inputTypeTextForEmail(User user) {
		return "<input type='text' class='form-control' id='_email_update' name='_email_update' placeholder='Correo electrónico' value='"
				+ user.getEmail() + "' required>";
	}

	/**
	 * Retorna en HTML un input con el valor del phone del usuario logado
	 * @param user
	 * @return
	 */
	public String inputTypeTextForPhone(User user) {
		return "<input type='text' class='form-control' id='_phone_update' name='_phone_update' placeholder='Teléfono' value='"
				+ user.getPhone() + "' required>";
	}

}
