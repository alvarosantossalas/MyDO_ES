<%@page import="com.mydo.utilities.structure.Structure" %>
<%@page import="com.mydo.utilities.structure.Head"%>
<%@page import="com.mydo.utilities.structure.FooterWithout"%>
<%@page import="com.mydo.utilities.structure.HeaderWithout"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<% out.println(Head.getInstance().returnHead()); %>
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
		<p class="display-4 text-center">Llena tu vida de color, llena tu
			trabajo de alegría.</p>
		<p class="h5 text-center">Optimizar tu tiempo es nuestro trabajo,
			por tanto, tienes a tu disposición distintos tipos de tareas
			definidas según colores para mejorar tu rendimiento.</p>


		<div class="card border-primary mb-3 tarea_ejemplo"
			style="max-width: 18rem;">
			<div class="card-header">Tarea actual</div>
			<div class="card-body text-primary">
				<h5 class="card-title">En progreso...</h5>
				<p class="card-text">
					Este tipo de tarea es para aquellas que están en ejecución, y de
					prioridad <b>normal.</b>
				</p>
			</div>
		</div>
		<div class="card border-secondary mb-3 tarea_ejemplo"
			style="max-width: 18rem;">
			<div class="card-header">Tarea actual</div>
			<div class="card-body text-secondary">
				<h5 class="card-title">Relax, no hay prisa</h5>
				<p class="card-text">
					Este tipo de tareas es para aquellas que están en ejecución, y de
					prioridad <b>baja</b>.
				</p>
			</div>
		</div>
		<div class="card border-warning mb-3 tarea_ejemplo"
			style="max-width: 18rem;">
			<div class="card-header">Tarea actual</div>
			<div class="card-body text-warning">
				<h5 class="card-title">¡No te relajes!</h5>
				<p class="card-text">
					Este tipo de tareas es para aquellas que están en ejecución, y de
					prioridad <b>alta</b>
				</p>
			</div>
		</div>
		<div class="card border-success mb-3 tarea_ejemplo"
			style="max-width: 18rem;">
			<div class="card-header">Tarea finalizada</div>
			<div class="card-body text-success">
				<h5 class="card-title">¡Buen trabajo!</h5>
				<p class="card-text">El trabajo se ha cumplido. Esta tarea se
					quedará abierta hasta que el usuario decida cerrarla.</p>
			</div>
		</div>
		<div class="card border-danger mb-3 tarea_ejemplo"
			style="max-width: 18rem;">
			<div class="card-header">Tarea abortada</div>
			<div class="card-body text-danger">
				<h5 class="card-title">Vaya...</h5>
				<p class="card-text">Por una cosa o por otra, alguna vez
					tendremos que abandonar tareas. Esta será la tarjeta.</p>
			</div>
		</div>

		<div class="card border-info mb-3 tarea_ejemplo"
			style="max-width: 18rem;">
			<div class="card-header">Tarea en proyecto</div>
			<div class="card-body text-info">
				<h5 class="card-title">¡Trabajo en equipo!</h5>
				<p class="card-text">Así se marcarán las tareas que pertenezcan
					a un proyecto. Te ayudará a manterte organizado : )</p>
			</div>
		</div>
		<br>

	</div>
	<p class="text-center">
		¿Crees que esta definición de tareas no se corresponde a lo que estás
		buscando? <br> No te preocupes, dispondrás de un modo de
		personalización para que diseñes tarjetas a tu gusto.
	</p>
	<br>
	<br>
	<section id="info" style="background: url(images/fondo.jpg);">
		<p class="display-4">No importa quien seas, MyDO está diseñado
			para ti</p>



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
