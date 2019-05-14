<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
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
			<h1 class="display-4">¡Totalmente gratis!</h1>
			<p class="lead">Proponemos soluciones para particulares y
				empresas</p>
			<a class="btn btn-primary btn-lg" href="#" role="button">Leer más</a>
		</div>
	</div>
	<div id="centro">
		<p class="h2 text-center">¡Bienvenido!</p>
		<p class="text-center">MyDO ofrece una experiencia diseñada
			específicamente para cada uno de nuestros usuarios</p>

		<div class="container">
			<div class="row">
				<div class="col">
					<!-- Para la izquierda arriba -->
					<p class="text-center display-4">Algunos clientes...</p>
					<table class="table text-center">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Compañía</th>
								<th scope="col">Sector</th>
								<th scope="col">Sede</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">IMF Business School</th>
								<td>Enseñanza</td>
								<td>Madrid</td>
							</tr>
							<tr>
								<th scope="row">STUCOM Centre d' estudis</th>
								<td>Enseñanza</td>
								<td>Barcelona</td>
							</tr>
							<tr>
								<th scope="row">VILT Ibérica</th>
								<td>Consultoría</td>
								<td>Madrid</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="col">
					<!-- Para la derecha arriba -->
					<p class="text-center display-4">TOP 3 Ciudades</p>
					<table class="table text-center">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Ciudad</th>
								<th scope="col">País</th>
								<th scope="col">Usuarios</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">Madrid</th>
								<td>España</td>
								<td>8.315</td>
							</tr>
							<tr>
								<th scope="row">Barcelona</th>
								<td>España</td>
								<td>7.804</td>
							</tr>
							<tr>
								<th scope="row">Braga</th>
								<td>Portugal</td>
								<td>7.221</td>
							</tr>
						</tbody>
					</table>
				</div>

			</div>
		</div>
		<br>
	</div>
	<section id="info" style="background: url(images/pruebaabajo.PNG);">
		<p class="display-4">No pierdas tu tiempo...</p>
		<div class="contenedor">
			<div class="info-music">
				<img src="images/calendario.png">
				<p class="text-light">
					<br>Organiza tus <br> prioridades
				</p>
			</div>
			<div class="info-music">
				<img src="images/proyecto.png">
				<p class="text-light">
					<br>Ten presente <br> tu futuro
				</p>
			</div>
			<div class="info-music">
				<img src="images/beneficio.png">
				<p class="text-light">
					<br> Evita malgastar <br> tu tiempo
				</p>
			</div>
			<div class="info-music">
				<img src="images/usuario.png">
				<p class="text-light">
					<br> Experiencia <br> exclusiva
			</div>
		</div>
		<p class="display-4">No importa quien seas, MyDO está diseñado
			para tí</p>
	</section>
	<footer id="myFooter">
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<h2 class="logo">
						<a href="#"><img src="images/MyDo-128.gif"></a>
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
