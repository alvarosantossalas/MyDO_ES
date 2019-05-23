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
		// doGet(request, response);

		try {
			HttpSession session = request.getSession();
			User us_logado = (User) session.getAttribute("us_logado");
			SessionCtrl.getInstance().closeSession(us_logado.getId_user());
			session.removeAttribute("us_logado");
			session.invalidate();
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			e.getMessage();
		}
	
	}

}
