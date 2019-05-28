<%@page import="com.mydo.controller.SessionCtrl"%>
<%@page import="com.mydo.utilities.structure.Structure" %>
<%@page import="com.mydo.utilities.structure.Head"%>
<%@page import="com.mydo.utilities.structure.FooterWith"%>
<%@page import="com.mydo.utilities.structure.HeaderWith"%>
<%@page import="org.omg.CORBA._IDLTypeStub"%>
<%@page import="com.mydo.core.model.Project"%>
<%@page import="com.mydo.controller.TeamCtrl"%>
<%@page import="com.mydo.controller.TaskCtrl"%>
<%@page import="com.mydo.controller.ProjectCtrl"%>
<%@page import="com.mydo.controller.UserCtrl"%>
<%@page import="com.mydo.core.model.User"%>
<%@page import="com.mydo.core.model.Task"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
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
			//String id_user_logado = (String) session.getAttribute("id_user");
			us_logado = UserCtrl.getInstance().checkDataForUser(us_logado);
			out.println(HeaderWith.getInstance().returnHeaderWithLogin());
	%>

	<div class="jumbotron text-light"
		style="background: url(images/partearriba.PNG);"></div>
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
					<a><button class="btn btn-danger text-dark bg-light"
							type="button">
							Iniciar guía rápida <img src="icons/icon-manual_32px.png">
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
					<th scope="col">Progreso de la tarea</th>
					<th scope="col">Equipo responsable</th>
				</tr>
			</thead>
			<tbody>
				<%
					out.println(TaskCtrl.getInstance().showTaskInBoard(us_logado.getId_user()));
				%>
			</tbody>
		</table>
	</div>
	<br>
	<section id="info" style="background: url(images/pruebaabajo.PNG);">
		<p class="display-4">No importa quien seas, MyDO está diseñado
			para tí</p>
	</section>
	<%
		out.println(Structure.getInstance().returnFooterWithLogin());
	%>
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
				<%
					out.println("<form action='CreateTask?id_user=" + us_logado.getId_user() + "' method='POST'>");
				%>
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
									name="_estimated_time" min="1" required>
							</div>
						</div>
						<div class="form-group">
							<label for="_team">Selecciona un equipo</label> <select
								id="_team" name="_team" class="form-control" required>
								<option selected>Tus equipos...</option>
								<%
									out.println(TeamCtrl.getInstance().showTeamsForThisUser(us_logado));
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
								<option selected>Proyecto</option>
								<%
									out.println(ProjectCtrl.getInstance().showProjectsForUser(us_logado.getId_user()));
								%>
							</select>
							<hr>
							<input class="form-check-input" type="radio" name="_project"
								id="_project3" value="_no_create_project" checked> <label
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
