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
			<h1 class="display-4">�Totalmente gratis!</h1>
			<p class="lead">Proponemos soluciones para particulares y
				empresas</p>
			<a class="btn btn-primary btn-lg" href="#" role="button">Leer m�s</a>
		</div>
	</div>
	<div id="centro">
		<p class="h2 text-center">�Bienvenido!</p>
		<p class="text-center">MyDO ofrece una experiencia dise�ada
			espec�ficamente para cada uno de nuestros usuarios</p>

		<div class="container">
			<div class="row">
				<div class="col">
					<!-- Para la izquierda arriba -->
					<p class="text-center display-4">Algunos clientes...</p>
					<table class="table text-center">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Compa��a</th>
								<th scope="col">Sector</th>
								<th scope="col">Sede</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">IMF Business School</th>
								<td>Ense�anza</td>
								<td>Madrid</td>
							</tr>
							<tr>
								<th scope="row">STUCOM Centre d' estudis</th>
								<td>Ense�anza</td>
								<td>Barcelona</td>
							</tr>
							<tr>
								<th scope="row">VILT Ib�rica</th>
								<td>Consultor�a</td>
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
								<th scope="col">Pa�s</th>
								<th scope="col">Usuarios</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">Madrid</th>
								<td>Espa�a</td>
								<td>8.315</td>
							</tr>
							<tr>
								<th scope="row">Barcelona</th>
								<td>Espa�a</td>
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
		<p class="display-4">No importa quien seas, MyDO est� dise�ado
			para t�</p>
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
