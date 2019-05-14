<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyDO ES</title>
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
			User user_logado = UserCtrl.getInstance().checkDataForUser(id_user_logado);
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
					<li class="nav-item active"><a class="nav-link"
						href="board.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="board.jsp">Tablero</a></li>
					<li class="nav-item"><a class="nav-link" href="tasks.jsp">Tareas</a></li>
					<li class="nav-item"><a class="nav-link" href="projects.jsp">Proyectos</a></li>
					<li class="nav-item"><a class="nav-link" href="contact.jsp">Contacto</a></li>
				</ul>
			</div>

		</nav>
	</header>

	<div class="jumbotron text-light"
		style="background: url(images/partearriba.PNG);">
		<div class="container">
			<%
				out.println("<h1 class='display-4')>¡Bienvenido de nuevo, " + user_logado.getName() + "!</h1>");
			%>
		</div>
	</div>
	<div id="centro" class="container-fluid">
		<p class="display-4 text-center">Un poco de organización...</p>
		<hr class="hr">

		<div class="container text-center">
			<button class="btn btn-info btn-lg" data-toggle="modal"
				data-target="#exampleModalScrollable">Crear una tarea</button>
			<button class="btn btn-info btn-lg">Ver mis proyectos</button>
			<a href="profile.jsp" class="btn btn-success btn-lg">Mi cuenta</a>
		</div>
		<br>

		<div class="pos-f-t">
			<div class="collapse" id="navbarToggleExternalContent">
				<div class="bg-dark p-4">
					<div class="form-check text-light filtros">
						<p class="h3">Mostrar tareas</p>
						<input type="checkbox" checked> <label
							class="form-check-label">De prioridad baja</label> <br> <input
							type="checkbox" checked> <label class="form-check-label">De
							prioridad media</label> <br> <input type="checkbox" checked>
						<label class="form-check-label">De prioridad alta</label> <br>
					</div>
					<div class="form-check text-light filtros">
						<input type="checkbox" checked> <label
							class="form-check-label">Finalizadas</label> <br> <input
							type="checkbox" checked> <label class="form-check-label">Abortadas</label>
						<br> <input type="checkbox" checked> <label
							class="form-check-label">Que pertenecen a un proyecto</label>
					</div>
					<div class="form-check text-light filtros">
						<input type="checkbox" checked> <label
							class="form-check-label">De trabajo</label> <br> <input
							type="checkbox" checked> <label class="form-check-label">De
							estudios</label> <br> <input type="checkbox" checked> <label
							class="form-check-label">Personales</label> <br>
					</div>
					<div class="form-check text-light filtros">
						<input type="checkbox" checked> <label
							class="form-check-label">De tipo recordatorio</label> <br> <input
							type="checkbox"> <label class="form-check-label">Creadas
							por tí únicamente</label> <br> <select
							class="custom-select custom-select-sm">
							<option selected>Tarea creada por:</option>
							<option value="1">One</option>
							<option value="2">Two</option>
							<option value="3">Three</option>
						</select>
					</div>

				</div>
			</div>
			<nav class="navbar navbar-dark bg-dark"
				style="background-image: url(images/centro.PNG)">
				<button class="navbar-toggler text-light" type="button"
					data-toggle="collapse" data-target="#navbarToggleExternalContent"
					aria-controls="navbarToggleExternalContent" aria-expanded="false"
					aria-label="Toggle navigation">
					Filtrar por <span class="navbar-toggler-icon"></span>
				</button>
				<form action="DeleteTask">
				<a><button class="btn btn-danger text-dark bg-light" type="button">
					Eliminar seleccionado <img src="icons/icon-trash_32px.png">
				</button></a>
				</form>
			</nav>
		</div>

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col"></th>
					<th scope="col"></th>
					<th scope="col">Título</th>
					<th scope="col">Asunto</th>
					<th scope="col">Descripción</th>
					<th scope="col">Tipo de tarea</th>
					<th scope="col">Tiempo empleado / Tiempo estimado</th>
					<th scope="col">Equipo responsable</th>
				</tr>
			</thead>
			<tbody>
				<%
					if (TaskCtrl.getInstance().listAllTasksForOneUser(id_user_logado) != null) {
							ArrayList<Task> listTasks = TaskCtrl.getInstance().listAllTasksForOneUser(id_user_logado);
							if (listTasks.isEmpty()) {
								System.out.println("No existen tareas");
							} else {
								for (int i = 0; i < listTasks.size(); i++) {
									out.print("<tr class='" + listTasks.get(i).getStatus() + "'>");
									out.print(
											"<th scope='row'><a href='http://localhost:8080/MyDO_ES/profile.jsp' target='_blank'><button target='_blank' class='btn'><img src='icons/icon-behind_24px.png'></button></a></th>");
									out.print("<th scope='row'><a href='DeleteTask?id_task="+listTasks.get(i).getId_task()+"'><button class='btn'><img src='icons/icon-trash_24px.png'></button></a></th>");
									
									out.print("<td>" + listTasks.get(i).getName() + "</td>");
									out.print("<td>" + listTasks.get(i).getSubject() + "</td>");
									out.print("<td style='widht: 50px;'>" + listTasks.get(i).getDescription() + "</td>");
									out.print("<td>" + listTasks.get(i).getType() + "</td>");
									out.print("<td>" + listTasks.get(i).getEstimated_time() + "</td>");
									String team_name = TeamCtrl.getInstance().selectNameTeamById(listTasks.get(i).getId_team());
									out.print("<td>" + team_name + "</td>");
								}
							}
						} else {

							out.print("<th class='btn-primary text-center display-4' colspan='8'>No existen tareas</th>");
						}
				%>


			</tbody>
		</table>
	</div>
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
						<li><a href="index.jsp">Home</a></li>
						<li><a href="registration.jsp">Registrarse</a></li>
						<li><a href="#">Descargas</a></li>
					</ul>
				</div>
				<div class="col-sm-2">
					<h5>Sobre nosotros</h5>
					<ul>
						<li><a href="#">Información de la compañía</a></li>
						<li><a href="contact.jsp">Contactar</a></li>
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

	<!-- Modal -->
	<div class="modal fade" id="exampleModalScrollable" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalScrollableTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable" role="document">
			<div class="modal-content">
				<div class="modal-header text-light"
					style="background-image: url(images/partearriba.PNG)">
					<h5 class="modal-title h2" id="exampleModalScrollableTitle">Crear
						una nueva tarea</h5>
					<button type="button" class="close text-light" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="CreateTask" method="POST">
					<div class="modal-body">

						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="_name">Nombre</label> <input type="text"
									class="form-control" id="_name" name="_name"
									placeholder="Nombre" required>
							</div>
							<div class="form-group col-md-6">
								<label for="_subject">Asunto</label> <input type="text"
									class="form-control" id="_subject" name="_subject"
									placeholder="Asunto" required>
							</div>
						</div>
						<div class="form-group">
							<label for="_description">Descripción</label>
							<textarea class="form-control" id="_description"
								name="_description" rows="10" required></textarea>
						</div>

						<div class="form-row">
							<div class="form-group col-md-4">
								<label for="_type">Tipo</label> <select id="_type" name="_type"
									class="form-control" required>
									<option>Selecciona...</option>
									<option value="trabajo">Trabajo</option>
									<option value="estudios">Estudios</option>
									<option value="personal">Personal</option>
									<option value="importante">Importante</option>
									<option value="recordatorio">Recordatorio</option>
								</select>
							</div>
							<div class="form-group col-md-4">
								<label for="_status">Prioridad</label> <select id="_status"
									name="_status" class="form-control" required>
									<option>Selecciona...</option>
									<option value="btn-warning">Alta</option>
									<option value="btn-primary">Normal</option>
									<option value="btn-secondary">Baja</option>
								</select>
							</div>
							<div class="form-group col-md-4">
								<label for="_estimated_time">Tiempo estimado</label> <input
									type="number" class="form-control" id="_estimated_time"
									name="_estimated_time" placeholder="00" required>
							</div>
						</div>

						<div class="form-group">
							<label for="_team">Selecciona un equipo</label> <select
								id="_team" name="_team" class="form-control" required>
								<option selected>Tus equipos...</option>
								<%
									if (TeamCtrl.getInstance().listAllTeamsForOneUser(user_logado.getId_user()) != null) {
											ArrayList<String> team_list = TeamCtrl.getInstance()
													.listAllTeamsForOneUser(user_logado.getId_user());
											for (int i = 0; i < team_list.size(); i++) {
												out.print("<option value='" + team_list.get(i) + "'>" + team_list.get(i) + "</option>");
											}
										} else {
											out.print("<option value=''>No se han encontrado resultados</option>");
										}
								%>
							</select>
						</div>
						<hr>

						<div class="form-check">
							<input class="form-check-input" type="radio" name="_project"
								id="_project1" value="create_new_project" checked> <label
								class="form-check-label" for="_project1">Crear proyecto</label>
							<input type="text" class="form-control" id="_name_project"
								name="_name_project"
								placeholder="Introduce el nombre de tu nuevo proyecto..."
								autocomplete="off">

							<hr>

							<input class="form-check-input" type="radio" name="_project"
								id="_project2" value="select_existing_project"> <label
								class="form-check-label" for="_project2">Selecciona un
								proyecto existente</label> <select name="_project_selected"
								class="form-control">
								<option selected>Tus proyectos...</option>
								<%
									if (ProjectCtrl.getInstance().listAllProjectsForOneUser(id_user_logado) != null) {
											ArrayList<String> listProject = ProjectCtrl.getInstance().listAllProjectsForOneUser(id_user_logado);
											for (int i = 0; i < listProject.size(); i++) {
												out.print("<option value=" + listProject.get(i) + ">" + listProject.get(i) + "</option>");
											}
										} else {
											out.print("<option value=''>No se han encontrado resultados</option>");
										}
								%>
							</select>

							<hr>

							<input class="form-check-input" type="radio" name="_project"
								id="_project3" value="_no_create_project"> <label
								class="form-check-label" for="_projecy3"><b>Crear
									esta tarea sin ningún proyecto asociado</b></label>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
						<input type="submit" class="btn btn-success"
							value="Guardar cambios">
					</div>
				</form>
			</div>
		</div>
	</div>
	<%
		} else {
			session.invalidate();
			System.out.println("La sesión ha sido invalidada en board.jsp");
			response.sendRedirect("error403.html");
		}
	%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
