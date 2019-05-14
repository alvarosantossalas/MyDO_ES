package com.mydo.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mydo.core.model.User;
import com.mydo.controller.UserCtrl;

/**
 * Servlet implementation class UpdateUserData
 */
@WebServlet("/UpdateUserData")
public class UpdateUserData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession httpSession;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		httpSession = (HttpSession) request.getSession();
		if (httpSession == null) {
			httpSession.invalidate();
			System.out.println("La sesión ha sido invalidada en UpdateUserData.jsp");
		} else {

			String id_user = (String) httpSession.getAttribute("id_user");

			try {

				String password_actual = request.getParameter("_password_actual");
				if (!password_actual.equals("")) { // Si no está vacío
					if (password_actual.equals(UserCtrl.getInstance().selectPasswordById_user(id_user))) {
						String name = request.getParameter("_name_update");
						String lastname = request.getParameter("_lastname_update");
						String email = request.getParameter("_email_update");
						String phone = request.getParameter("_phone_update");
						String pass_update = request.getParameter("_password_new");

						User user = UserCtrl.getInstance().listById(id_user);
						user.setPassword(pass_update);
						user.setName(name);
						user.setLastname(lastname);
						user.setEmail(email);
						user.setPhone(phone);

						UserCtrl.getInstance().update(user);
						System.out.println("Se ha actualizado con contraseña");
					} else {
						response.setContentType("text/html;charset=UTF-8");
						PrintWriter out = response.getWriter();
						out.println("<h1 class='h1'>No se ha podido actualizar con contraseña</h1>");
						System.out.println("No se ha podido actualizar con contraseña");
					}
				} else {
					String name = request.getParameter("_name_update");
					String lastname = request.getParameter("_lastname_update");
					String email = request.getParameter("_email_update");
					String phone = request.getParameter("_phone_update");
					User user = UserCtrl.getInstance().listById(id_user);

					user.setName(name);
					user.setLastname(lastname);
					user.setEmail(email);
					user.setPhone(phone);
					UserCtrl.getInstance().update(user);
					System.out.println("Se ha actualizado sin contraseña");
				}
				response.sendRedirect("profile.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
