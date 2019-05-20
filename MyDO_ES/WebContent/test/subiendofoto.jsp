<%@page import="java.io.PrintWriter"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello world</h1>
	<%
	String url = "C:\\Users\\alvaro.santos\\git\\my_do_es\\MyDO_ES\\WebContent\\user_images";
	DiskFileItemFactory factory = new DiskFileItemFactory();
	
	factory.setSizeThreshold(1024);
	
	factory.setRepository(new File(url));
	
	ServletFileUpload upload = new ServletFileUpload(factory);
	
	try {
		List<FileItem> partes = upload.parseRequest(request);
		for(FileItem items: partes) {
			File file = new File(url, items.getName());
			items.write(file);
		}
		
		out.println("El archivo se ha subido correctamente");
	} catch (Exception e) {
		e.printStackTrace();
	}
	%>
</body>
</html>