package com.mydo.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mydo.controller.SessionCtrl;

/**
 * Servlet implementation class CloseSession
 */
@WebServlet("/CloseSession")
public class CloseSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession httpSession;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CloseSession() {
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
			System.out.println("La sesión ha sido invalidada en CloseSession.jsp");
		} else {
			String id_user = (String) httpSession.getAttribute("id_user");
			try {				
				SessionCtrl.getInstance().closeSession(id_user);
				httpSession.invalidate();
				response.sendRedirect("index.jsp");
				System.out.println("La sesión se ha invalidado a través de post en CloseSession.java");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
