package com.mydo.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydo.controller.TaskCtrl;

/**
 * Servlet implementation class DeleteTask
 */
@WebServlet("/DeleteTask")
public class DeleteTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	private static String id_task;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			id_task = request.getParameter("id_task");
			TaskCtrl.getInstance().remove(id_task);
			System.out.println("Se ha eliminado con éxito el id: " + id_task);
			out = response.getWriter();
			out.print("<head>" + "<title>MyDO Application</title>"
					+ "<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>" + "</head>"
					+ "<body style='background-image: url(images/fondo.jpg);'>" + "<script>"
					+ "swal('La tarea se ha eliminado con éxito : )','','success')" + ".then((value) => {"
					+ "document.location.href='board.jsp';});" + "</script>" + "</body>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
