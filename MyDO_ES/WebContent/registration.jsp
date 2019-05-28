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
			<p class="display-4 text-center">Necesitamos conocerte un poco...</p>
		</div>
	</div>
	<div id="centro-registro" style="width: 50%; margin: 15px auto 15px;">
		<form action="UserRegistration" method="POST"
			name="form_registration_user">
			<div class="form-group">
				<label for="_username">Nombre de usuario</label> <input type="text"
					class="form-control" id="_username" name="_username"
					placeholder="Nombre de usuario" autocomplete="off" required>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="_password_1">Contraseña</label> <input type="password"
						class="form-control" id="_password_1" name="_password_1"
						placeholder="Contraseña" autocomplete="off" required>
				</div>

				<div class="form-group col-md-6">
					<label for="_password_2">Repite contraseña</label> <input
						type="password" class="form-control" id="_password_2"
						name="_password_2" placeholder="Repite contraseña"
						autocomplete="off" required>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="_name">Nombre</label> <input type="text"
						class="form-control" id="_name" name="_name" placeholder="Nombre"
						autocomplete="off" required>
				</div>
				<div class="form-group col-md-8">
					<label for="_lastname">Apellidos</label> <input type="text"
						class="form-control" id="_lastname" name="_lastname"
						placeholder="Apellidos" autocomplete="off" required>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-8">
					<label for="_email">Correo electrónico</label> <input type="email"
						class="form-control" id="_email" name="_email"
						placeholder="Correo electrónico" autocomplete="off" required>
				</div>
				<div class="form-group col-md-4">
					<label for="_phone">Teléfono</label> <input type="text"
						class="form-control" id="_phone" name="_phone"
						placeholder="Teléfono" autocomplete="off" required>
				</div>
			</div>
			<div class="form-group">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" id="gridCheck"
						checked> <label class="form-check-label" for="gridCheck">
						Acepto recibir ofertas comerciales </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" id="gridCheck"
						checked> <label class="form-check-label" for="gridCheck">
						Acepto los <a href="#">términos y condiciones</a>
					</label>
				</div>
			</div>
			<input type="submit" class="btn btn-primary"
				value="Registrar mi cuenta" onclick="checkPassword()">
		</form>
		<iframe name="null" style="display: none;"></iframe>
	</div>
	<br>
	<%
		out.println(Structure.getInstance().returnFooterWithoutLogin());
	%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>
