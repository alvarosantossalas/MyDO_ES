package com.mydo.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mydo.controller.SessionCtrl;
import com.mydo.core.model.User;

/**
 * Servlet implementation class CloseSession
 */
@WebServlet("/CloseSession")
public class CloseSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static HttpSession session;
	private static User us_logado;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CloseSession() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			session = request.getSession();
			us_logado = (User) session.getAttribute("us_logado");
			SessionCtrl.getInstance().closeSession(us_logado.getId_user());
			session.removeAttribute("us_logado");
			session.invalidate();
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			e.getMessage();
		}
	
	}

}
