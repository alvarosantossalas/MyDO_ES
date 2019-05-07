package com.mydo.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydo.controller.UserCtrl;
import com.mysql.fabric.Response;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String username;
	private static String password;
	private static boolean enter;
	private static PrintWriter out;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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

		try {
			username = request.getParameter("_username");
			password = request.getParameter("_password");
			enter = false;

			if (username.isEmpty() || password.isEmpty()) {
				System.out.println("No se ha introducido el username o la contraseña");
				return;
			} else {
				UserCtrl userc = new UserCtrl();
				if (userc.canLoginOrNot(username, password)) { // the user exists and has correctly set their
																// credentials
					enter = true;
					UserCtrl uctrl = new UserCtrl();
					request.getSession().setAttribute("_name", uctrl.selectNameByUsername(username));
					response.sendRedirect("board.jsp");
				} else { // User doesnt exist
					response.setContentType("text/html;charset=UTF-8");
					out = response.getWriter();
					out.println("<script type:\"text/javascript\">");
					out.println("setTimeout('location.href = charge_screen.jsp',1000");
					out.println("</script>");
				}
			}
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}

	}

}
