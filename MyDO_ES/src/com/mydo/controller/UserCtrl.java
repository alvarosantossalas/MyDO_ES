package com.mydo.controller;

import com.mydo.core.model.User;
import com.mydo.core.model.Team;
import com.mydo.core.dao.UserDAO;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserCtrl {

	private static UserCtrl instance = null;

	public static UserCtrl getInstance() throws SQLException {
		if (instance == null)
			instance = new UserCtrl();
		return instance;
	}

	// insert a user object without team object
	public void insertWithoutTeam(User user) throws SQLException {
		UserDAO.getInstance().insertWithoutTeam(user);
	}

	// insert a user object with team object relation
	public void insertWithTeam(User user, Team team) throws SQLException {
		UserDAO.getInstance().insertWithTeam(user, team);
	}

	// update a user object
	public void update(User user) throws SQLException {
		UserDAO.getInstance().update(user);
	}

	// remove a user object
	public void remove(String id) throws SQLException {
		UserDAO.getInstance().remove(id);
	}

	// list all the user objects
	public ArrayList<User> listAll() throws SQLException {
		return UserDAO.getInstance().listAll();
	}

	// list user object by id
	public User listById(String id) throws SQLException {
		User result = UserDAO.getInstance().listById(id);
		return result;
	}

	// check if user can login or not
	public boolean canLoginOrNot(String username, String password) throws SQLException {
		return UserDAO.getInstance().canLogin(username, password);
	}

	public String selectIdByUsername(String username) throws SQLException {
		return UserDAO.getInstance().selectIdByUsername(username);
	}

	public String selectNameByUsername(String username) throws SQLException {
		return UserDAO.getInstance().selectNameByUsername(username);
	}

	public String selectNameSurname(String id) throws SQLException {
		User user = listById(id);
		return user.getName() + " " + user.getLastname();
	}

	public String selectPasswordById_user(String id) throws SQLException {
		return UserDAO.getInstance().selectPasswordById_user(id);
	}

	public String selectNameById_user(String id) throws SQLException {
		return UserDAO.getInstance().selectUsernameByIdUser(id);
	}

	public void removeUserFromTeam(String id_user, String id_team) throws SQLException {
		UserDAO.getInstance().removeUserFromTeam(id_user, id_team);
	}

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

	public String showPersonalData(User user) throws SQLException {
		return "<p class='display-3'>" + selectNameSurname(user.getId_user()) + "</p>" + "<p class='h5'>"
				+ user.getEmail() + "</p>" + "<p class='h6'>" + user.getPhone() + "</p>";
	}

	public String showPersonalDataForExternalUser(User user) throws SQLException {
		return "<p class='display-3'>" + selectNameSurname(user.getId_user()) + "</p>"
				+ "<p class='h5'>Nombre de usuario: " + user.getUsername() + "</p>" + "<p class='h5'>Email: "
				+ user.getEmail() + "</p>" + "<p class='h5'>Phone: " + user.getPhone() + "</p>";
	}

	public String inputTypeTextForUsername(User user) {
		return "<input type='text' class='form-control disabled' id='_username_update' name='_username_update' placeholder='Nombre de usuario' value='"
				+ user.getUsername() + "' disabled>";
	}

	public String inputTypeTextForName(User user) {
		return "<input type='text' class='form-control' id='_name_update' name='_name_update' placeholder='Nombre' value='"
				+ user.getName() + "' required>";
	}

	public String inputTypeTextForLastname(User user) {
		return "<input type='text' class='form-control' id='_lastname_update' name='_lastname_update' placeholder='Apellidos' value='"
				+ user.getLastname() + "' required>";
	}

	public String inputTypeTextForEmail(User user) {
		return "<input type='text' class='form-control' id='_email_update' name='_email_update' placeholder='Correo electrónico' value='"
				+ user.getEmail() + "' required>";
	}

	public String inputTypeTextForPhone(User user) {
		return "<input type='text' class='form-control' id='_phone_update' name='_phone_update' placeholder='Teléfono' value='"
				+ user.getPhone() + "' required>";
	}

}
