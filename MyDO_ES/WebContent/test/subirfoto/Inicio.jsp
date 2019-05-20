<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="codigo.js"></script>
</head>
<body>
<form name="formulario" method="post" enctype="multipart/form-data">
<table>
<tr>
<td>Seleccione archivo</td><td><input type="file" onchange="cargarArchivo(this)" name="archivo"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" name="proceso" value="Procesar"></td>
</tr>
</table>
<input type="hidden" name="nombre" value="">
</form>
<iframe name="null" style="display: none;"></iframe>
</body>
</html>