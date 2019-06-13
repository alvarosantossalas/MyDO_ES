package com.mydo.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydo.controller.TaskCtrl;
import com.mydo.controller.TeamCtrl;
import com.mydo.core.model.Task;

/**
 * Servlet implementation class UpdateTask
 */
@WebServlet("/UpdateTask")
public class UpdateTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final TaskCtrl taskCtrl = new TaskCtrl();
	private static final TeamCtrl teamCtrl = new TeamCtrl();
	PrintWriter out;
	private String id_task;
    private String subject;   
    private String description;
    private String type;
    private String status;
    private String team;
    private int consumed_time;
    private int estimated_time;
    
    private static Task current_task;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		try {
			
			id_task = request.getParameter("_id_task");
			subject = request.getParameter("_subject");
			description = request.getParameter("_description");
			type = request.getParameter("_type");
			status = request.getParameter("_status");
			team = request.getParameter("_team");
			consumed_time = Integer.parseInt(request.getParameter("_consumed_time"));
			estimated_time = Integer.parseInt(request.getParameter("_estimated_time"));
			String id_team = teamCtrl.selectIdTeamByName(team);
			
			current_task = taskCtrl.listById(id_task);
			current_task.setSubject(subject);
			current_task.setDescription(description);
			current_task.setType(type);
			current_task.setStatus(status);
			current_task.setConsumed_time(consumed_time);
			current_task.setEstimated_time(estimated_time);
			current_task.setId_team(id_team);
			
			taskCtrl.update(current_task);
			out = response.getWriter();
			out.print("<head>"
					+ "<title>MyDO Application</title>"
					+ "<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>"
					+ "</head>"
					+ "<body style='background-image: url(images/fondo.jpg);'>"
					+ "<script>"
					+ "swal('¡Tarea actualizada!','','success')"
					+ ".then((value) => {"
					+ "document.location.href='task.jsp?id_task="+id_task+"';});"
					+ "</script>"
					+ "</body>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
