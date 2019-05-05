<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mydo.controller.TeamCtrl"%>
<%@page import="com.mydo.controller.TaskCtrl"%>
<%@page import="com.mydo.controller.ProjectCtrl"%>
<%@page import="java.util.ArrayList"%>
<%
	TeamCtrl tc = new TeamCtrl();
	TaskCtrl tac = new TaskCtrl();
	ProjectCtrl pc = new ProjectCtrl();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Task object</title>
</head>
<body>
	<h3>Create new task</h3>
	<form action="../CreateTask" method="POST">
		<p>
			Name <input type="text" name="_name" placeholder="Name" required>
		</p>
		<p>
			Subject <input type="text" name="_subject" placeholder="Subject" required>
		</p>
		<p>
			Description <input type="text" name="_description" placeholder="Description" required>
		</p>
		<p>
			Type <select name="_type" required>
				<option value="trabajo">Trabajo</option>
				<option value="estudios">Estudios</option>
				<option value="personal">Personal</option>
				<option value="importante">Importante</option>
				<option value="recordatorio">Recordatorio</option>
			</select>
		</p>
		<p>
			Estimated time <input type="number" name="_estimated_time" required>
		</p>
		<p>
			Select a team: <select name="_team_selected">
				<%
					// Suponemos que user_95d2fa5b-5680-466f-9ace-97042ca89004 es el usuario logado
					ArrayList<String> team_list = tc.listAllTeamsForOneUser("user_95d2fa5b-5680-466f-9ace-97042ca89004");
					for (int i = 0; i < team_list.size(); i++) {
						out.print("<option value='" + team_list.get(i) + "'>" + team_list.get(i) + "</option>");
					}
				%>
			</select>
		</p>
		<p>
			Create project <input type="radio" name="create_task_radio" value="create_project_radio"><input type="text" name="_name_project" placeholder="Enter the name of the new project">
		</p>
		<p>
			Select project <input type="radio" name="create_task_radio" value="select_project_radio"><select name="_project_selected">
				<%
					// Suponemos que team_195af45c-f3de-4675-ac28-2ba2042ad7c3 es el equipo seleccionado.
					// Esto habrá que trabajarlo con jQuery
					ArrayList<String> project_list = tac.listAllProjectsForATeam("team_195af45c-f3de-4675-ac28-2ba2042ad7c3");
					for (int i = 0; i < project_list.size(); i++) {
						out.print("<option value='" + project_list.get(i) + "'>" + project_list.get(i) + "</option>");
					}
				%>
			</select>
		</p>
		<input type="submit" name="send">
	</form>
</body>
</html>
