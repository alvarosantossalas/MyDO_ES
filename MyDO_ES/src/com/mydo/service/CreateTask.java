package com.mydo.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydo.controller.ProjectCtrl;
import com.mydo.controller.TaskCtrl;
import com.mydo.controller.TeamCtrl;
import com.mydo.core.model.Project;
import com.mydo.core.model.Task;

/**
 * Servlet implementation class CreateTask
 */
@WebServlet("/CreateTask")
public class CreateTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name;
	private String subject;
	private String description;
	private String type;
	private int estimated_time;
	private String status;
	private String team;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateTask() {
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

		try {
			// collecting data
			name = request.getParameter("_name");
			subject = request.getParameter("_subject");
			description = request.getParameter("_description");
			type = request.getParameter("_type");
			estimated_time = Integer.parseInt(request.getParameter("_estimated_time"));
			status = request.getParameter("_status");
			team = request.getParameter("_team");
			
			String id_user = request.getParameter("id_user");

			// select the id_team by the name that the user select in form
			String id_team = TeamCtrl.getInstance().selectIdTeamByName(team);
			// collect the option that the user choose for projects
			String project = request.getParameter("_project");

			switch (project) {
			case "create_new_project":
				try {
					String name_project = request.getParameter("_name_project");
					Task task = new Task(name, subject, description, type, estimated_time, 0, status, id_team);
					TaskCtrl.getInstance().insert(task);
					Project proj = new Project(name_project, subject, id_user);
					ProjectCtrl.getInstance().insert(proj);
					TaskCtrl.getInstance().insertTaskAndTeamRelationShip(task.getId_team(), task.getId_task());
					ProjectCtrl.getInstance().createRelationShip(proj.getId_project(), task.getId_task(), task.getId_team());
					TaskCtrl.getInstance().insertTaskAndTeamRelationShip(task.getId_team(), task.getId_task());
				} catch (Exception e) {
					System.out.println("Error en 1");
					e.printStackTrace();
				}
				break;
			case "select_existing_project":
				try {
					String project_selected = request.getParameter("_project_selected");
					System.out.println("Proyecto seleccionado: " + project_selected);
					Task task = new Task(name, subject, description, type, estimated_time, 0, status, id_team);
					TaskCtrl.getInstance().insert(task);
					ProjectCtrl.getInstance().createRelationShip(project_selected, task.getId_task(), id_team);
					TaskCtrl.getInstance().insertTaskAndTeamRelationShip(task.getId_team(), task.getId_task());
				} catch (Exception e) {
					System.out.println("Error en 2");
					e.printStackTrace();
				}
				break;
			case "_no_create_project":
				try {
					Task task = new Task(name, subject, description, type, estimated_time, 0, status, id_team);
					TaskCtrl.getInstance().insert(task);
					TaskCtrl.getInstance().insertTaskAndTeamRelationShip(task.getId_team(), task.getId_task());
					
				} catch (Exception e) {
					System.out.println("Error 3");
					e.printStackTrace();
				}
				break;
			default:
				break;
			}
			response.sendRedirect("board.jsp");
		} catch (SQLException e) {
			System.out.println("Error general");
			e.getStackTrace();
		}

	}

}
