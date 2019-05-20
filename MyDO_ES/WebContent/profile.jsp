<%@page import="com.mydo.utilities.structure.Head"%>
<%@page import="com.mydo.utilities.structure.FooterWith"%>
<%@page import="com.mydo.utilities.structure.HeaderWith"%>
<%@page import="com.mydo.utilities.Profile_listProjects"%>
<%@page import="com.mydo.utilities.Profile_listTeams"%>
<%@page import="com.mydo.controller.TeamCtrl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mydo.controller.UserCtrl"%>
<%@page import="com.mydo.core.model.User"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%
	out.println(Head.getInstance().returnHead());
%>
</head>
<body>
	<%
		String id_user_logado = (String) session.getAttribute("id_user");
		if (id_user_logado != null) {
			User user_logado = UserCtrl.getInstance().checkDataForUser(id_user_logado);
			out.println(HeaderWith.getInstance().returnHeaderWithLogin());
	%>
	<div class="jumbotron text-light"
		style="background: url(images/fondo.jpg);">
		<div class="container">
			<div class="row">
				<div class="col-sm">
					<% out.println(UserCtrl.getInstance().showPersonalData(user_logado)); %>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#exampleModalScrollable">Modificar mis datos
						personales</button>
					<div class="modal fade" id="exampleModalScrollable" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalScrollableTitle"
						aria-hidden="true">
						<div class="modal-dialog modal-dialog-scrollable" role="document">
							<div class="modal-content">
								<div class="modal-header"
									style="background-image: url(images/partearriba.PNG)">
									<h5 class="modal-title">Mantén al día un perfil</h5>
									<button type="button" class="close text-light"
										data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<form action="UpdateUserData" method="POST"
									enctype="multipart/form-data">
									<div class="modal-body text-dark">
										<div class="form-group">
											<label for="_username_update">Nombre de usuario</label>
											<% out.println(UserCtrl.getInstance().inputTypeTextForUsername(user_logado)); %>
										</div>
										<div class="form-group">
											<label for="_name_update">Nombre</label>
											<% out.println(UserCtrl.getInstance().inputTypeTextForName(user_logado)); %>
										</div>
										<div class="form-group">
											<label for="_lastname_update">Apellidos</label>
											<% out.println(UserCtrl.getInstance().inputTypeTextForLastname(user_logado)); %>
										</div>
										<div class="form-row">
											<div class="form-group col-md-9">
												<label for="_email_update">Correo electrónico</label>
												<% out.println(UserCtrl.getInstance().inputTypeTextForEmail(user_logado)); %>
											</div>
											<div class="form-group col-md-3">
												<label for="_phone_update">Teléfono</label>
												<% out.println(UserCtrl.getInstance().inputTypeTextForEmail(user_logado)); %>
											</div>
										</div>
										<label>Cambiar mi foto de perfil</label>
										<div class="input-group">
											<div class="custom-file">
												<input type="file" class="custom-file-input"
													id="inputGroupFile04"> <label
													class="custom-file-label" for="inputGroupFile04">Selecciona
													tu mejor foto : )</label>
											</div>
										</div>
										<div class="rounded bg-light" aria-live="polite"
											aria-atomic="true"
											style="position: relative; min-height: 200px; top: 20px;">
											<div class="toast" style="padding: 15px; top: 0; right: 0;">
												<p class="h6">Si deseas modificar tu contraseña hazlo
													aquí : )</p>
												<div class="form-group">
													<label for="_password_actual">Contraseña actual</label> <input
														type="password" class="form-control" id="_password_actual"
														name="_password_actual" placeholder="Contraseña actual">
												</div>
												<div class="form-group">
													<label for="_password_new">Nueva contraseña</label> <input
														type="password" class="form-control" id="_password_new"
														name="_password_new" placeholder="Nueva contraseña">
												</div>
											</div>
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-danger"
											data-dismiss="modal">Cancelar</button>
										<input type="submit" class="btn btn-success"
											value="Guardar cambios">
									</div>
								</form>
							</div>
						</div>
					</div>
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
		<div class="btn-group" role="group">
			<button class="btn btn-primary">Mis equipos</button>
			<button class="btn btn-primary">Mis proyectos</button>
			<button class="btn btn-primary disabled">Administración</button>
			<form action="CloseSession" method="POST">
				<input type="submit" class="btn btn-danger rounded-right"
					value="Cerrar sesión">
			</form>
		</div>
		<br> <br>
		<div class="container-fluid" id="container-equipos">
			<p class="display-4 text-left">Mis equipos</p>
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
					<% out.println(Profile_listTeams.getInstance().fillListTeams(id_user_logado)); %>
				</tbody>
			</table>
		</div>
		<div class="container-fluid" id="container-proyectos">
			<p class="display-4 text-left">Mis proyectos</p>
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
					<% out.println(Profile_listProjects.getInstance().fillListProjects(id_user_logado)); %>
				</tbody>
			</table>
		</div>
		<div class="container-fluid" id="container-administracion">
			<p class="display-4 text-left">Administración</p>
		</div>
	</div>
	<br>
	<section id="info" style="background: url(images/pruebaabajo.PNG);">
		<p class="display-4">No importa quien seas, MyDO está diseñado
			para tí</p>
	</section>
	<% out.println(FooterWith.getInstance().returnFooterWithLogin()); 
	
		} else {
			session.invalidate();
			System.out.println("La sesión ha sido validada en profile.jsp");
			response.sendRedirect("error403.html");
		}
	%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>