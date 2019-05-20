<%@page import="com.mydo.utilities.structure.Head"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="com.mydo.controller.UserCtrl"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<!DOCTYPE html>
<html>
<head>
	<% out.println(Head.getInstance().returnHead()); %>
</head>
<body>
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
						href="index.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
					<li class="nav-item"><a class="nav-link"
						href="registration.jsp">Registro</a></li>
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
			<p class="display-4 text-center">¡Bienvenido!</p>
		</div>
	</div>

	<div id="centro-registro" style="width: 50%; margin: 15px auto 15px;">
		<form action="Login" method="POST">
			<div class="alert alert-danger" role="alert">
				Vaya... los datos que has introducidos no coinciden con ningún
				usuario. Si quieres crear una cuenta <a href="registration.jsp"
					class="alert-link">hazlo aquí</a>.
			</div>
			<div class="form-group">
				<label for="_username">Introduce tu nombre de usuario</label> <input
					type="text" class="form-control" id="_username" name="_username"
					placeholder="Nombre de usuario" required>
			</div>
			<div class="form-group">
				<label for="_password">Contraseña</label> <input type="password"
					class="form-control" id="_password" name="_password"
					placeholder="Contraseña" required>
			</div>
			<div class="form-group">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" id="gridCheck">
					<label class="form-check-label" for="gridCheck"> Recordar
						mis credenciales </label>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Entrar en mi
				cuenta</button>
		</form>
	</div>
	<br>
	<section id="info" style="background: url(images/pruebaabajo.PNG);">
		<br> <br> <br> <br>
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
					<h5>Comencemos</h5>
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
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
