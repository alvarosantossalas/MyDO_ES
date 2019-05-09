<%@page import="com.mydo.controller.UserCtrl"%>
<%@page import="com.mydo.core.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyDO_ES</title>
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
		String id_user_logado = (String) session.getAttribute("id_user");
		if (id_user_logado != null) {
			User user_logado = UserCtrl.getInstance().listById(id_user_logado);
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
					<li class="nav-item"><a class="nav-link" href="my_tasks.jsp">Tareas</a></li>
					<li class="nav-item"><a class="nav-link"
						href="my_projects.jsp">Proyectos</a></li>
					<li class="nav-item"><a class="nav-link" href="profile.jsp">Mi
							cuenta</a></li>
				</ul>
			</div>

		</nav>
	</header>

	<div class="jumbotron text-light"
		style="background: url(images/fondo.jpg);">

		<div class="container">
			<div class="row">
				<div class="col-sm">
					<p class="display-3">Álvaro Santos Salas</p>
					<p class="h5">alvaro.santoscc@gmail.com</p>
					<p class="h6">699 924 476</p>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#exampleModalScrollable">Modificar mis datos
						personales</button>

					<!-- Modal -->
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
								<div class="modal-body text-dark">
									<form>
										<div class="form-group">

											<label for="_username_update">Nombre de usuario</label>
											<%
												out.println(
															"<input type='text' class='form-control' id='_username_update' name='_username_update' placeholder='Nombre de usuario' value='"
																	+ user_logado.getUsername() + "' required>");
											%>

										</div>
										<div class="form-group">
											<label for="_name_update">Nombre</label>
											<%
												out.println("<input type='text' class='form-control' id='_name_update' placeholder='Nombre' value='"
															+ user_logado.getName() + "' required>");
											%>
										</div>
										<div class="form-group">
											<label for="_lastname_update">Apellidos</label>
											<%
												out.println(
															"<input type='text' class='form-control' id='_lastname_update' name='_lastname_update' placeholder='Apellidos' value='"
																	+ user_logado.getLastname() + "' required>");
											%>
										</div>
										<div class="form-row">
											<div class="form-group col-md-9">
												<label for="_email_update">Correo electrónico</label>
												<%
													out.println(
																"<input type='text' class='form-control' id='_email_update' name='_email_update' placeholder='Correo electrónico' value='"
																		+ user_logado.getEmail() + "' required>");
												%>
											</div>
											<div class="form-group col-md-3">
												<label for="_phone_update">Teléfono</label>
												<%
													out.println(
																"<input type='text' class='form-control' id='_phone_update' name='_phone_update' placeholder='Teléfono' value='"
																		+ user_logado.getPhone() + "' required>");
												%>
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



										<!-- lidhjsdhjoisahhdi -->

										<div class="rounded bg-light" aria-live="polite"
											aria-atomic="true"
											style="position: relative; min-height: 200px; top: 20px;">
											<div class="toast" style="padding: 15px; top: 0; right: 0;">
												<p class="h6">Si deseas modificar tu contraseña hazlo
													aquí : )</p>
												<div class="form-group">
													<label for="_password_actual">Contraseña actual</label> <input
														type="password" class="form-control" id="_password_actual"
														placeholder="Contraseña actal">
												</div>
												<div class="form-group">
													<label for="_password_new">Nueva contraseña</label> <input
														type="password" class="form-control" id="_password_new"
														placeholder="Nueva contraseña">
												</div>
											</div>
										</div>



										<!-- idjhsoiadjioasjdi -->
									</form>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-danger"
										data-dismiss="modal">Cancelar</button>
									<input type="submit" class="btn btn-success"
										value="Guardar cambios">
								</div>
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
		<!-- CENTRO -->

		<div class="btn-group" role="group">
			<button class="btn btn-primary">Mis equipos</button>
			<button class="btn btn-primary">Mis proyectos</button>
			<button class="btn btn-primary disabled">Administración</button>
			<form action="CloseSession" method="POST">
				<input type="submit" class="btn btn-danger" value="Cerrar sesión">
			</form>
		</div>
		<br> <br>
		<div class="container-fluid border border-secondary rounded"
			id="container-equipos">
			<p class="display-4 text-left">Mis equipos</p>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">#</th>
						<th scope="col">Equipo</th>
						<th scope="col">Administrador</th>
						<th scope="col">Usuarios</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>Mark</td>
						<td>Otto</td>
						<td>@mdo</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>Jacob</td>
						<td>Thornton</td>
						<td>@fat</td>
					</tr>
					<tr>
						<th scope="row">3</th>
						<td>Larry</td>
						<td>the Bird</td>
						<td>@twitter , @twitter, @twitter, @twitter, @twitter,
							@twitter, @twitter, @twitter, @twitter, @twitter, @twitter,
							@twitter, @twitter, @twitter, @twitter, @twitter, @twitter,
							@twitter, @twitter, @twitter, @twitter, @twitter, @twitter,
							@twitter, @twitter @twitter @twitter @twitter @twitter@twitter
							@twitter @twitter @twitter @twitter @twitter
							@twitter@twitter@twitter@twitter@twitter@twitter@twitter@twitter
							@twitter @twitter@twitter@twitter
							@twitter@twitter@twitter@twitter @twitter
							@twitter@twitter@twitter@twitter@twitter@twitter@twitter@twitter@twitter@twitter@twitter@twitter@twihhdi</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="container-fluid border border-secondary rounded"
			id="container-proyectos">
			<p class="display-4 text-left">Mis proyectos</p>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">#</th>
						<th scope="col">Proyecto</th>
						<th scope="col">Project Manager</th>
						<th scope="col">Nº tareas</th>
						<th scope="col">Tareas del proyecto</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>Mark</td>
						<td><a href="#">Otto</a></td>
						<td>@mdo</td>
						<td class="text-left">
							<button class="btn btn-warning">Tarea 3</button>
							<button class="btn btn-primary">Tarea 4</button>
							<button class="btn btn-success">Tarea 5</button>
							<button class="btn btn-warning">Tarea 3</button>
							<button class="btn btn-primary">Tarea 4</button>
							<button class="btn btn-success">Tarea 5</button>
							<button class="btn btn-warning">Tarea 3</button>
							<button class="btn btn-primary">Tarea 4</button>
							<button class="btn btn-success">Tarea 5</button>
							<button class="btn btn-warning" style="margin-top: 2px">Tarea
								3</button>
							<button class="btn btn-primary">Tarea 4</button>
							<button class="btn btn-success">Tarea 5</button>
							<button class="btn btn-warning">Tarea 3</button>
							<button class="btn btn-primary">Tarea 4</button>
							<button class="btn btn-success">Tarea 5</button>
							<button class="btn btn-success">Tarea 1</button>
							<button class="btn btn-success">Tarea 2</button>
							<button class="btn btn-warning">Tarea 3</button>
							<button class="btn btn-primary" style="margin-top: 2px">Tarea
								4</button>
							<button class="btn btn-success">Tarea 5</button>
						</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>Jacob</td>
						<td><a href="#">Thornton</a></td>
						<td>@fat</td>
						<td class="text-left">
							<button class="btn btn-primary">Tarea 4</button>
							<button class="btn btn-success">Tarea 5</button>
							<button class="btn btn-success">Tarea 1</button>
							<button class="btn btn-success">Tarea 2</button>
							<button class="btn btn-warning">Tarea 3</button>
							<button class="btn btn-primary" style="margin-top: 2px">Tarea
								4</button>
							<button class="btn btn-success">Tarea 5</button>
						</td>
					</tr>
					<tr>
						<th scope="row">3</th>
						<td>Larry</td>
						<td><a href="#">the Bird</a></td>
						<td>@twitter</td>
						<td class="text-left">
							<button class="btn btn-primary">Tarea 4</button>
							<button class="btn btn-success">Tarea 5</button>
							<button class="btn btn-success">Tarea 1</button>
							<button class="btn btn-success">Tarea 2</button>
							<button class="btn btn-warning">Tarea 3</button>
							<button class="btn btn-primary" style="margin-top: 2px">Tarea
								4</button>
							<button class="btn btn-success">Tarea 5</button>
							<button class="btn btn-primary">Tarea 4</button>
							<button class="btn btn-success">Tarea 5</button>
							<button class="btn btn-success">Tarea 1</button>
							<button class="btn btn-success">Tarea 2</button>
							<button class="btn btn-warning">Tarea 3</button>
							<button class="btn btn-primary" style="margin-top: 2px">Tarea
								4</button>
							<button class="btn btn-success">Tarea 5</button>
							<button class="btn btn-primary">Tarea 4</button>
							<button class="btn btn-success">Tarea 5</button>
							<button class="btn btn-success">Tarea 1</button>
							<button class="btn btn-success">Tarea 2</button>
							<button class="btn btn-warning">Tarea 3</button>
							<button class="btn btn-primary" style="margin-top: 2px">Tarea
								4</button>
							<button class="btn btn-success">Tarea 5</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="container-fluid border border-secondary rounded"
			id="container-administracion">
			<p class="display-4 text-left">Administración</p>
		</div>

		<!-- FIN CENTRO -->
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
	<%
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