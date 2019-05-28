<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="com.mydo.utilities.structure.Structure" %>
<%@page import="com.mydo.controller.UserCtrl"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<!DOCTYPE html>
<html>
<head>
<% out.println(Structure.getInstance().returnHead()); %>
</head>
<body>
	
	<% out.println(Structure.getInstance().returnHeaderWithoutLogin()); %>

	<div class="jumbotron text-light"
		style="background: url(images/partearriba.PNG);">
		<div class="container">
			<p class="display-4 text-center">¡Bienvenido!</p>
		</div>
	</div>

	<div id="centro-registro" style="width: 50%; margin: 15px auto 15px;">
		<form action="Login" method="POST" name="form_login">
			<div class="form-group">
				<label for="_username">Introduce tu nombre de usuario</label> <input
					type="text" class="form-control" id="_username" name="_username"
					placeholder="Nombre de usuario" autocomplete="off" required>
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
	<% out.println(Structure.getInstance().returnFooterWithoutLogin()); %>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
