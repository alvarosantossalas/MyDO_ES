package com.mydo.utilities.structure;

import java.sql.SQLException;

public class HeaderWithout {

	private static HeaderWithout instance = null;

	public static HeaderWithout getInstance() throws SQLException {
		if (instance == null)
			instance = new HeaderWithout();
		return instance;
	}

	public String returnHeaderWithoutLogin() {
		return "<header>" + "<nav class='navbar navbar-expand-lg navbar-light bg-light'>"
				+ "<a class='navbar-brand' href='#'>LOGO MyDO Application</a>"
				+ "<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarNav' aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>"
				+ "<span class='navbar-toggler-icon'></span>" + "</button>"
				+ "<div class='collapse navbar-collapse' id='navbarNav'>" + "<ul class='navbar-nav'>"
				+ "<li class='nav-item active'>" + "<a class='nav-link' href='index.jsp'>Home</a>" + "</li>"
				+ "<li class='nav-item'>" + "<a class='nav-link' href='login.jsp'>Login</a>" + "</li>"
				+ "<li class='nav-item'>" + "<a class='nav-link' href='registration.jsp'>Registro</a>" + "</li>"
				+ "<li class='nav-item'>" + "<a class='nav-link' href='tasks.jsp'>Tareas</a>" + "</li>"
				+ "<li class='nav-item'>" + "<a class='nav-link' href='projects.jsp'>Proyectos</a>" + "</li>"
				+ "<li class='nav-item'>" + "<a class='nav-link' href='contact.jsp'>Contacto</a>" + "</li>" + "</ul>"
				+ "</div>" + "</nav>" + "</header>";
	}

}
