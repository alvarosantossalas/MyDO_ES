<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="subiendofoto.jsp" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>
					<input type="file" name="file">
					<input type="submit" value="Subir archivo">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>