<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.mydo.utilities.structure.Structure"%>
<!DOCTYPE html>
<html>
<head>
<%
	out.println(Structure.getInstance().returnHead());
%>
</head>
<body style="background-image: url(images/fondo.jpg);">

	<div class="container text-light text-center "
		style="width: 500px; height: 610px; background: rgba(55, 55, 55, .5); margin-top: 9.3%; border-radius: 15px; box-shadow: 0px 0px 150px 10px #888888;">
		<br>
		<p class="h1">¡Uuuuuuups!</p>
		<p class="h1" style="font-size: 200px;">403</p>
		<p class="display-4">Acceso denegado para este recurso</p>
		<br> <br> <a href="index.jsp" class="btn btn-primary btn-lg">Volver
			al menú principal</a>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>