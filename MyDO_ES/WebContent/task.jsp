<%@ page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="com.mydo.controller.TeamCtrl"%>
<%@page import="com.mydo.controller.TaskCtrl"%>
<%@page import="com.mydo.controller.ProjectCtrl"%>
<%@page import="com.mydo.controller.UserCtrl"%>
<%@page import="com.mydo.core.model.User"%>
<%@page import="com.mydo.core.model.Task"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="styles/footer.css">
<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
	<%
		if ((String) session.getAttribute("id_user") != null) {
			String id_user_logado = (String) session.getAttribute("id_user");
			System.out.println("ID user_logado en task: " + id_user_logado);

			String id_task = request.getParameter("id_task");
			Task selected_task = TaskCtrl.getInstance().listById(id_task);
	%>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">LOGO MyDO Application</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="board.jsp">Home</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="board.jsp">Tablero</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="tasks.jsp">Tareas</a></li>
					<li class="nav-item"><a class="nav-link" href="projects.jsp">Proyectos</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="contact.jsp">Contacto</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>

	<div class="jumbotron text-light"
		style="background: url(images/partearriba.PNG);">
		<div class="container">
			<div style="width: 70rem;">
				<div class="card-body">
					<h5 class="display-4">Special title treatment</h5>
					<p class="card-text">With supporting text below as a natural
						lead-in to additional content.</p>
					<a href="#" class="btn btn-primary">Crear </a>
				</div>
			</div>
		</div>
	</div>

	<form action="UpdateTask" method="POST">
		<div id="centro-registro" class="text-center">

			<div id="task_board" class="container text-left">
				<%
					out.println("<p class='display-4'>" + selected_task.getName() + "</p>");
				%>
				<!-- <p class="display-4">Titulo de la tarea</p>-->
				<dl class="row">
					<dt class="col-sm-2">Asunto</dt>
					<dd class="col-sm-12">
						<%
							out.println("<input type='text' class='form-control' value='" + selected_task.getSubject()
										+ "' name='_subject' required>");
						%>
					</dd>

					<dt class="col-sm-2">Descripción</dt>
					<dd class="col-sm-12">

						<%
							out.println("<textarea class='form-control' id='_description' name='_description' rows='10' required>"
										+ selected_task.getDescription() + "</textarea>");
						%>

					</dd>


					<dt class="col-sm-2">Tipo de tarea</dt>
					<dd class="col-sm-2">
						<select class="form-control" name="_type">
							<%
								if (selected_task.getType().equals("trabajo")) {
										out.println("<option value='trabajo' selected>Trabajo</option>");
										out.println("<option value='estudios'>Estudios</option>");
										out.println("<option value='personal'>Personal</option>");
										out.println("<option value='importante'>Importante</option>");
										out.println("<option value='recordatorio'>Recordatorio</option>");
									} else if (selected_task.getType().equals("estudios")) {
										out.println("<option value='trabajo'>Trabajo</option>");
										out.println("<option value='estudios' selected>Estudios</option>");
										out.println("<option value='personal'>Personal</option>");
										out.println("<option value='importante'>Importante</option>");
										out.println("<option value='recordatorio'>Recordatorio</option>");
									} else if (selected_task.getType().equals("personal")) {
										out.println("<option value='trabajo'>Trabajo</option>");
										out.println("<option value='estudios'>Estudios</option>");
										out.println("<option value='personal' selected>Personal</option>");
										out.println("<option value='importante'>Importante</option>");
										out.println("<option value='recordatorio'>Recordatorio</option>");
									} else if (selected_task.getType().equals("importante")) {
										out.println("<option value='trabajo'>Trabajo</option>");
										out.println("<option value='estudios'>Estudios</option>");
										out.println("<option value='personal'>Personal</option>");
										out.println("<option value='importante' selected>Importante</option>");
										out.println("<option value='recordatorio'>Recordatorio</option>");
									} else if (selected_task.getType().equals("recordatorio")) {
										out.println("<option value='trabajo'>Trabajo</option>");
										out.println("<option value='estudios'>Estudios</option>");
										out.println("<option value='personal'>Personal</option>");
										out.println("<option value='importante'>Importante</option>");
										out.println("<option value='recordatorio' selected>Recordatorio</option>");
									}
							%>
						</select>
					</dd>

					<dt class="col-sm-2 text-truncate">Equipo responsable:</dt>
					<dd class="col-sm-2">
						<select class="form-control" name="_team">
							<%
								if (TeamCtrl.getInstance().listAllTeamsForOneUser(id_user_logado) != null) {
										ArrayList<String> team_list = TeamCtrl.getInstance().listAllTeamsForOneUser(id_user_logado);
										for (int i = 0; i < team_list.size(); i++) {
											// Por cada nombre que recorre sacaremos su id
											String current_id_team = TeamCtrl.getInstance().selectIdTeamByName(team_list.get(i));
											System.out.println("El id de: " + team_list.get(i) + " es: " + current_id_team);
											System.out.println(
													"El id que estamos buscando es: team_pd47dhksklj-jfsjflks984-nfhkd que debería ser igual a: "
															+ selected_task.getId_team());
											// Si el id que recorremos es igual al id que buscamos...
											if (!current_id_team.equals(selected_task.getId_team())) {
												out.println("<option value='" + team_list.get(i) + "'>" + team_list.get(i) + "</option>");
												System.out.println("\n Valor sin seleccionar: " + team_list.get(i));
											} else {
												out.println("<option value='" + team_list.get(i) + "' selected>" + team_list.get(i)
														+ "</option>");
												System.out.println("\n Valor seleccionado: " + team_list.get(i));
											}
										}
									}
							%>
						</select>
					</dd>
					<dt class="col-sm-1">Estado</dt>
					<dd class="col-sm-3">
						<select class="form-control" name="_status">
						<%
							if (selected_task.getStatus().equals("btn-secondary")) {
								out.println("<option value='btn-secondary' selected>Prioridad baja</option>");
								out.println("<option value='btn-primary'>Prioridad normal</option>");
								out.println("<option value='btn-warning'>Prioridad alta</option>");
								out.println("<option value='btn-danger'>Abortada</option>");
								out.println("<option value='btn-success'>Cumplida</option>");
							} else if (selected_task.getStatus().equals("btn-primary")) {
								out.println("<option value='btn-secondary'>Prioridad baja</option>");
								out.println("<option value='btn-primary' selected>Prioridad normal</option>");
								out.println("<option value='btn-warning'>Prioridad alta</option>");
								out.println("<option value='btn-danger'>Abortada</option>");
								out.println("<option value='btn-success'>Cumplida</option>");
							} else if (selected_task.getStatus().equals("btn-warning")) {
								out.println("<option value='btn-secondary'>Prioridad baja</option>");
								out.println("<option value='btn-primary'>Prioridad normal</option>");
								out.println("<option value='btn-warning' selected>Prioridad alta</option>");
								out.println("<option value='btn-danger'>Abortada</option>");
								out.println("<option value='btn-success'>Cumplida</option>");
							} else if (selected_task.getStatus().equals("btn-danger")) {
								out.println("<option value='btn-secondary'>Prioridad baja</option>");
								out.println("<option value='btn-primary'>Prioridad normal</option>");
								out.println("<option value='btn-warning'>Prioridad alta</option>");
								out.println("<option value='btn-danger' selected>Abortada</option>");
								out.println("<option value='btn-success'>Cumplida</option>");
							} else if (selected_task.getStatus().equals("btn-success")) {
								out.println("<option value='btn-secondary'>Prioridad baja</option>");
								out.println("<option value='btn-primary'>Prioridad normal</option>");
								out.println("<option value='btn-warning'>Prioridad alta</option>");
								out.println("<option value='btn-danger'>Abortada</option>");
								out.println("<option value='btn-success' selected>Cumplida</option>");
							}
						%>
						</select>
					</dd>
					<dt class="col-sm-2">Horas consumidas</dt>
					<dd class="col-sm-3">
						<%
							out.println("Tiempo consumido:<input type='number' class='form-control' value='"
										+ selected_task.getConsumed_time() + "' name='_consumed_time' required>");
						%>
					</dd>
					<dd class="col-sm-3">
						<%
							out.println("Tiempo estimado:<input type='number' class='form-control' value='"
										+ selected_task.getEstimated_time() + "'name='_estimated_time' required>");
						%>
					</dd>
					<dd class="col-sm-4">
						<%
							out.println("Progreso: " + TaskCtrl.getInstance().selectPercentageOfProgress(id_task) + "%");
						%>
						<div class="progress" style="height: 38px;">
							<%
								out.println("<div class='progress-bar progress-bar-striped bg-success' role='progressbar' style='width:"
											+ TaskCtrl.getInstance().selectPercentageOfProgress(id_task)
											+ "%' aria-valuenow='25' aria-voluemin='0' aria-valuemax='100'></div>");
							%>
						</div>
					</dd>

					<br>
					<br>
					<br>
					<br>

					<dt class="col-sm-2">En proyecto:</dt>

					<%
						if (ProjectCtrl.getInstance().listAllProjectsForOneUser("ffdf") != null) {
								ArrayList<String> listProject = ProjectCtrl.getInstance().listAllProjectsForOneUser(id_user_logado);
								for (int i = 0; i < listProject.size(); i++) {
									out.print("<dd style='margin-left:7px;'> <button class='btn btn-info'>" + listProject.get(i)
											+ "</button> </dd>");
								}
							} else {
								out.println("<p class='h3'> Esta tarea no pertenece a ningún proyecto </p>");
							}
					%>

					<br>
					<br>
					<br>


				</dl>
			</div>

		</div>

		<div class="btn-group text-center" role="group" style="margin-left: 40%">
			<%
				out.println("<a class='btn btn-danger' href='http://localhost:8080/MyDO_ES/DeleteTask?id_task="
							+ id_task + "'>Eliminar tarea</a>");
				out.println("<input type='hidden' name='_id_task' value='"+id_task+"'>");
			%>
			
			<input type="submit" class="btn btn-success" value="Guardar cambios">

		</div>
	</form>


	<br>
	<section id="info" style="background: url(images/pruebaabajo.PNG);">
		<p class="display-4">No importa quien seas, MyDO está diseñado
			para tí</p>
	</section>

	<footer id="myFooter">
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<h2 class="logo">
						<a href="#"> LOGO </a>
					</h2>
				</div>
				<div class="col-sm-2">
					<h5>Comenzemos</h5>
					<ul>
						<li><a href="#">Home</a></li>
						<li><a href="#">Registrarse</a></li>
						<li><a href="#">Descargas</a></li>
					</ul>
				</div>
				<div class="col-sm-2">
					<h5>Sobre nosotros</h5>
					<ul>
						<li><a href="#">Información de la compañía</a></li>
						<li><a href="#">Contactar</a></li>
					</ul>
				</div>
				<div class="col-sm-2">
					<h5>Soporte</h5>
					<ul>
						<li><a href="#">FAQ</a></li>
						<li><a href="#">Ayuda</a></li>
						<li><a href="#">Foros</a></li>
					</ul>
				</div>
				<div class="col-sm-3">
					<div class="social-networks">
						<a href="#" class="twitter"><i class="fa fa-twitter"></i></a> <a
							href="#" class="facebook"><i class="fa fa-facebook"></i></a> <a
							href="#" class="google"><i class="fa fa-google-plus"></i></a>
					</div>
					<button type="button" class="btn btn-default">Contactar</button>
				</div>
			</div>
		</div>
		<div class="footer-copyright">
			<p>© 2019 MyDO ES Co.</p>
		</div>
	</footer>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<%
		} else {
			session.invalidate();
			System.out.println("La sesión ha sido invalidada en board.jsp");
			response.sendRedirect("error403.html");
		}
	%>
</body>
</html>