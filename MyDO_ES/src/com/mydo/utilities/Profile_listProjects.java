package com.mydo.utilities;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mydo.controller.ProjectCtrl;
import com.mydo.controller.TaskCtrl;
import com.mydo.controller.UserCtrl;
import com.mydo.core.model.Task;

public class Profile_listProjects {

	private static Profile_listProjects instance = null;

	public static Profile_listProjects getInstance() throws SQLException {
		if (instance == null)
			instance = new Profile_listProjects();
		return instance;
	}

	public String fillListProjects(String id_user_logado) throws Exception {
		StringBuffer sb = new StringBuffer();
		if (ProjectCtrl.getInstance().listAllProjectsForOneUser(id_user_logado) == null) {
			sb.append("<tr><td class='bg-dark' colspan='5'><p class='display-4 text-light'>Todav�a no tienes ning�n proyecto</p></td></tr>");
		} else {
			ArrayList<String> names = ProjectCtrl.getInstance().listAllProjectsForOneUser(id_user_logado);
			String project_name;
			String project_manager;
			int n_tasks;
			ArrayList<String> tasks;
			ArrayList<String> ids = turnOnAllTheIdsInList(names);
			for (int i = 0; i < names.size(); i++) {
				project_name = names.get(i);
				sb.append("<tr class='text-left'>" + "<td>"
						+ "<button class='btn btn-outline-primary'><img src='icons/icon-admin_32px.png'></button> "
						+ "<button class='btn btn-outline-danger'><img src='icons/icon-trash_32px.png'></button>"
						+ "</td>" + "<td>" + project_name + "</td>");
				project_manager = UserCtrl.getInstance()
						.selectNameSurname(ProjectCtrl.getInstance().selectProjectManagerForProjectById(ids.get(i)));
				sb.append("<td>" + project_manager + "</td>");
				n_tasks = ProjectCtrl.getInstance().countHowManyTasks(ids.get(i));
				sb.append("<td>" + n_tasks + "</td>");
				tasks = ProjectCtrl.getInstance().listAllTasksForOneProject(ids.get(i));
				sb.append("<td>");
				for (int x = 0; x < tasks.size(); x++) {
					Task task = TaskCtrl.getInstance().listById(tasks.get(x));
					sb.append("<a href='http://localhost:8080/MyDO_ES/task.jsp?id_task=" + task.getId_task()
							+ "' class='btn " + task.getStatus() + "' style='margin-left:5px; margin-top:2px;'>"
							+ TaskCtrl.getInstance().selectTaskNameByIdTask(tasks.get(x)) + "</a>");
				}
				sb.append("</td></tr>");
			}

		}
		return sb.toString();
	}

	public ArrayList<String> turnOnAllTheIdsInList(ArrayList<String> names) throws SQLException {
		ArrayList<String> ids = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			ids.add(i, ProjectCtrl.getInstance().selectIdProjectByName(names.get(i)));
		}

		return ids;
	}

}
