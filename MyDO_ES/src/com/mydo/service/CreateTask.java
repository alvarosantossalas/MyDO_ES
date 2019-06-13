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
	private static final TeamCtrl teamCtrl = new TeamCtrl();
	private static final TaskCtrl taskCtrl = new TaskCtrl();
	private static final ProjectCtrl projectCtrl = new ProjectCtrl();
	private String name;
	private String subject;
	private String description;
	private String type;
	private int estimated_time;
	private String status;
	private String team;
	
	private static String id_user;
	private static String id_team;
	private static String project;
	
	private static String name_project;
	private static Task task;
	private static Project proj;
	
	private static String project_selected;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// collecting data
			name = request.getParameter("_name");
			subject = request.getParameter("_subject");
			description = request.getParameter("_description");
			type = request.getParameter("_type");
			estimated_time = Integer.parseInt(request.getParameter("_estimated_time"));
			status = request.getParameter("_status");
			team = request.getParameter("_team");
			
			id_user = request.getParameter("id_user");

			// select the id_team by the name that the user select in form
			id_team = teamCtrl.selectIdTeamByName(team);
			// collect the option that the user choose for projects
			project = request.getParameter("_project");

			switch (project) {
			case "create_new_project":
				try {
					name_project = request.getParameter("_name_project");
					task = new Task(name, subject, description, type, estimated_time, 0, status, id_team);
					taskCtrl.insert(task);
					proj = new Project(name_project, subject, id_user);
					taskCtrl.insertTaskAndTeamRelationShip(task.getId_team(), task.getId_task());
					projectCtrl.insert(proj);
					projectCtrl.createRelationShip(proj.getId_project(), task.getId_task(), task.getId_team());
					taskCtrl.insertTaskAndTeamRelationShip(task.getId_team(), task.getId_task());
				} catch (Exception e) {
					System.out.println("Error en 1");
					e.printStackTrace();
				}
				break;
			case "select_existing_project":
				try {
					project_selected = request.getParameter("_project_selected");
					System.out.println("Proyecto seleccionado: " + project_selected);
					task = new Task(name, subject, description, type, estimated_time, 0, status, id_team);
					taskCtrl.insert(task);
					taskCtrl.insertTaskAndTeamRelationShip(task.getId_team(), task.getId_task());
					projectCtrl.createRelationShip(project_selected, task.getId_task(), id_team);
				} catch (Exception e) {
					System.out.println("Error en 2");
					e.printStackTrace();
				}
				break;
			case "_no_create_project":
				try {
					task = new Task(name, subject, description, type, estimated_time, 0, status, id_team);
					taskCtrl.insert(task);
					taskCtrl.insertTaskAndTeamRelationShip(task.getId_team(), task.getId_task());
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
