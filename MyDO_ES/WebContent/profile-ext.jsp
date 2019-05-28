<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="com.mydo.utilities.structure.Structure" %>
<%@page import="com.mydo.utilities.Profile_listProjects"%>
<%@page import="com.mydo.utilities.Profile_listTeams"%>
<%@page import="com.mydo.controller.TeamCtrl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mydo.controller.UserCtrl"%>
<%@page import="com.mydo.core.model.User"%>
<!DOCTYPE html>
<html>
<head>
<%
	out.println(Structure.getInstance().returnHead());
%>
</head>
<body>
	<%
		if ((User) session.getAttribute("us_logado") != null) {
			User us_logado = (User) session.getAttribute("us_logado");
			us_logado = UserCtrl.getInstance().checkDataForUser(us_logado);
			String id_user_ext = request.getParameter("id_user_ext");
			User us_ext = UserCtrl.getInstance().listById(id_user_ext);
			out.println(Structure.getInstance().returnHeaderWithLogin());
	%>
	<div class="jumbotron text-light"
		style="background: url(images/fondo.jpg);">
		<div class="container">
			<div class="row">
				<div class="col-sm">
					<%
						out.println(UserCtrl.getInstance().showPersonalDataForExternalUser(us_ext));
					%>
					<!-- Button trigger modal -->
				</div>
				<div class="col-sm">
					<div id="marco-imagen" class="container text-center">
						<img src="images/foto-perfil-test.jpg">
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="centro" class="container text-center">
		<div class="container"></div>

		<div class="container-fluid" id="container-equipos">
			<p class="display-4 text-left">
				<% out.println("<a name='myteams'></a>Equipos a los que pertenece " + us_ext.getName()); %>
			</p>
			<form action="RemoveUserFromTeam" method="POST">
				<table class="table text-left">
					<thead class="thead-dark">
						<tr>
							<th scope="col">#</th>
							<th scope="col">Equipo</th>
							<th scope="col">Administrador</th>
							<th scope="col">Usuarios</th>
						</tr>
					</thead>
					<tbody>
						<%	
						if (us_logado.getAdmin() == 1) {
							if (Profile_listTeams.getInstance().fillListTeamsForAdmin(us_ext.getId_user()) != null) {
								out.println(Profile_listTeams.getInstance().fillListTeamsForAdmin(us_ext.getId_user()));	
							} else {
								out.println("<p class='display-4'>No existen equipos</p>");
							}
						} else {
							if (Profile_listTeams.getInstance().fillListTeams(us_ext.getId_user()) != null) {
								out.println(Profile_listTeams.getInstance().fillListTeams(us_ext.getId_user()));	
							} else {
								out.println("<p class='display-4'>No existen proyectos</p>");
							}
							
						}
						
					%>
					</tbody>
				</table>
			</form>
		</div>
		<div class="container-fluid" id="container-proyectos">
			<p class="display-4 text-left">
				<% out.println("<a name='myprojects'></a>Proyectos a los que pertenece " + us_ext.getName()); %>
			</p>
			<table class="table">
				<thead class="thead-dark">
					<tr class="text-left">
						<th scope="col">#</th>
						<th scope="col">Proyecto</th>
						<th scope="col">Project Manager</th>
						<th scope="col">Nº tareas</th>
						<th scope="col">Tareas del proyecto</th>
					</tr>
				</thead>
				<tbody>
					<%
						out.println(Profile_listProjects.getInstance().fillListProjects(us_ext.getId_user()));
					%>
				</tbody>
			</table>
		</div>
		<div class="container-fluid" id="container-administracion">
			<p class="display-4 text-left">
				<a name="administration">Administración</a>
			</p>
		</div>
	</div>
	<br>
	<section id="info" style="background: url(images/pruebaabajo.PNG);">
		<p class="display-4">No importa quien seas, MyDO está diseñado
			para tí</p>
	</section>
	<%
		out.println(Structure.getInstance().returnFooterWithLogin());
		} else {
			session.removeAttribute("us_logado");
			session.invalidate();
			System.out.println("La sesión ha sido validada en profile.jsp");
			response.sendRedirect("error403.jsp");
		}
	%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>