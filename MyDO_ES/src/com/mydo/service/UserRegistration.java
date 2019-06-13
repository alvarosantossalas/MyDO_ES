package com.mydo.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydo.controller.UserCtrl;
import com.mydo.core.model.Team;
import com.mydo.core.model.User;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final UserCtrl userCtrl = new UserCtrl();

	private static String username;
	private static String password;
	private static String name;
	private static String lastname;
	private static String email;
	private static String phone;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (checkInputs(request)) {
			try {
				userCtrl.insertWithTeam(new User(username, password, name, lastname, email, phone),
						new Team(username + "_team", username + "_image", ""));
				response.sendRedirect("login.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("El proceso ha finalizado ya que no puede haber campos sin rellenar");
		}

	}

	private boolean checkInputs(HttpServletRequest request) {
		boolean result = true;
		username = request.getParameter("_username");
		password = request.getParameter("_password_1");
		name = request.getParameter("_name");
		lastname = request.getParameter("_lastname");
		email = request.getParameter("_email");
		phone = request.getParameter("_phone");

		if (username.equals("") || password.equals("") || name.equals("") || lastname.equals("") || email.equals("")
				|| phone.equals("")) {
			result = false;
		}
		return result;
	}

}
