package com.mydo.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydo.controller.TeamCtrl;
import com.mydo.controller.UserCtrl;

/**
 * Servlet implementation class RemoveUserFromTeam
 */
@WebServlet("/RemoveUserFromTeam")
public class RemoveUserFromTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String id_user;
	private static String team_name;
	private static String id_team;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveUserFromTeam() {
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
			id_user = request.getParameter("id_user");
			team_name = request.getParameter("team_name");
			id_team = TeamCtrl.getInstance().selectIdTeamByName(team_name);
			UserCtrl.getInstance().removeUserFromTeam(id_user, id_team);
			System.out.println("Relación eliminada");
			response.sendRedirect("profile-ext.jsp?id_user_ext="+id_user);
			
			
		} catch (Exception e) {
			e.getMessage();
		} 
				
	}

}
