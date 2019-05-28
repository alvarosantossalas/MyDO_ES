package com.mydo.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mydo.controller.SessionCtrl;
import com.mydo.controller.UserCtrl;
import com.mydo.core.model.Session;
import com.mydo.core.model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PrintWriter pw;
	
	private static String username;
	private static String password;
	private static PrintWriter out;
	
	private static User us_logado;

	private HttpSession session;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response, String id_user)
			throws ServletException, IOException {
		session = request.getSession(true);
		session.setAttribute("id_user", id_user);
		pw = response.getWriter();
		pw.println("Usuario en sessión: " + id_user);
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		session = request.getSession(false);
		if (session == null) {
			session.invalidate();
			System.out.println("La sesión ha sido invalidada en Login.java");
		} else {
			try {
				username = request.getParameter("_username");
				password = request.getParameter("_password");
				if (username.isEmpty() || password.isEmpty()) {
					System.out.println("No se ha introducido el username o la contraseña");
					return;
				} else { 

					if (UserCtrl.getInstance().canLoginOrNot(username, password)) {
						SessionCtrl.getInstance().openSession(new Session(
								UserCtrl.getInstance().selectIdByUsername(username), new Date().toString()));
						us_logado = UserCtrl.getInstance().listById(UserCtrl.getInstance().selectIdByUsername(username));
						session = request.getSession();
						session.setAttribute("us_logado", us_logado);
						System.out
								.println("ID USER EN SERVLET: " + us_logado.getId_user());
						response.sendRedirect("board.jsp");
					} else { // User doesnt exist
						out = response.getWriter();
						out.print("<head>"
								+ "<title>MyDO Application</title>"
								+ "<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>"
								+ "</head>"
								+ "<body style='background-image: url(images/fondo.jpg);'>"
								+ "<script>"
								+ "swal('¡Vaya...! Usuario o contraseña incorrectos','','error')"
								+ ".then((value) => {"
								+ "document.location.href='login.jsp';});"
								+ "</script>"
								+ "</body>");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
