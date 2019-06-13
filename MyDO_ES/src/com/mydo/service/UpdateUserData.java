package com.mydo.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mydo.controller.UserCtrl;
import com.mydo.core.model.User;

/**
 * Servlet implementation class UpdateUserData
 */
@WebServlet("/UpdateUserData")
public class UpdateUserData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final UserCtrl userCtrl = new UserCtrl();
	private HttpSession httpSession;

	private static String password_actual;
	
	private static String id_user;
	
	private static String name;
	private static String lastname;
	private static String email;
	private static String phone;
	private static String pass_update;
	
	private static User user;
	 
	private static PrintWriter out;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	

		httpSession = (HttpSession) request.getSession();
		if (httpSession == null) {
			httpSession.invalidate();
			System.out.println("La sesión ha sido invalidada en UpdateUserData.jsp");
		} else {

			id_user = (String) httpSession.getAttribute("id_user");
			
			try {

				password_actual = request.getParameter("_password_actual");
				if (!password_actual.equals("")) { // Si no está vacío
					if (password_actual.equals(userCtrl.selectPasswordById_user(id_user))) {
						name = request.getParameter("_name_update");
						lastname = request.getParameter("_lastname_update");
						email = request.getParameter("_email_update");
						phone = request.getParameter("_phone_update");
						pass_update = request.getParameter("_password_new");

						user = userCtrl.listById(id_user);
						user.setPassword(pass_update);
						user.setName(name);
						user.setLastname(lastname);
						user.setEmail(email);
						user.setPhone(phone);

						userCtrl.update(user);
						System.out.println("Se ha actualizado con contraseña");
					} else {
						response.setContentType("text/html;charset=UTF-8");
						out = response.getWriter();
						out.println("<h1 class='h1'>No se ha podido actualizar con contraseña</h1>");
						System.out.println("No se ha podido actualizar con contraseña");
					}
				} else {
					name = request.getParameter("_name_update");
					lastname = request.getParameter("_lastname_update");
					email = request.getParameter("_email_update");
					phone = request.getParameter("_phone_update");
					user = UserCtrl.getInstance().listById(id_user);

					user.setName(name);
					user.setLastname(lastname);
					user.setEmail(email);
					user.setPhone(phone);
					userCtrl.update(user);
					System.out.println("Se ha actualizado sin contraseña");
				}
				response.sendRedirect("profile.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
