<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="com.mydo.utilities.structure.Structure" %>
<!DOCTYPE html>
<html>
<head>
<%
	out.println(Structure.getInstance().returnHead());
%>
</head>
<body>

	<%
		out.println(Structure.getInstance().returnHeaderWithoutLogin());
	%>

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
		<p class="display-4 text-center">¿Cómo me puedo organizar?</p>
		<p class="text-center">
			Entendemos que tienes mil cosas en la cabeza pero no te preocupes...
			¡Te podemos ayudar! <br> MyDO se encargará de relacionar tus
			tareas y así poder trabajar directamente en proyectos
		</p>
		<br>
		<div id="tablero">
			<div class="card border-primary mb-3" style="max-width: 18rem;"
				id="tarea_ejemplo_1">
				<div class="card-header">Tarea actual 1</div>
				<div class="card-body text-primary">
					<h5 class="card-title">En progreso...</h5>
					<p class="card-text">
						Este tipo de tarea es para aquellas que están en ejecución, y de
						prioridad <b>normal.</b>
					</p>
				</div>
			</div>
			<img src="icons/mas.png" id="mas">
			<div class="card border-primary mb-3" style="max-width: 18rem;"
				id="tarea_ejemplo_2">
				<div class="card-header">Tarea actual 2</div>
				<div class="card-body text-primary">
					<h5 class="card-title">En progreso...</h5>
					<p class="card-text">
						Este tipo de tarea es para aquellas que están en ejecución, y de
						prioridad <b>normal.</b>
					</p>
				</div>
			</div>
			<img src="icons/flecha-derecha.png" id="flecha">
			<div class="card border-info mb-3" style="max-width: 18rem;"
				id="tarea_ejemplo_3">
				<div class="card-header">Proyecto</div>
				<div class="card-body text-info">
					<h5 class="card-title">¡Proyecto creado!</h5>
					<button class="btn btn-primary">Tarea1</button>
					<button class="btn btn-primary">Tarea2</button>
				</div>
			</div>
		</div>
		<p class="text-center">
			<br> Podrás gestionar tus proyectos manualmente en todo momento.
			MyDO ofrecerá un sistema automatizado en el cual <br> podrá
			ordenar las tareas en proyectos siguiendo un algoritmo basado en la
			casilla "asunto" de cada tarea.
		</p>
	</div>
	<br>
	<br>
	<section id="info" style="background: url(images/fondo.jpg);">
		<p class="display-4">No importa quien seas, MyDO está diseñado
			para tí</p>



	</section>
	<%
		out.println(Structure.getInstance().returnFooterWithoutLogin());
	%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
