package com.mydo.utilities.structure;

import java.sql.SQLException;

public class HeaderWith {

	private static HeaderWith instance = null;

	public static HeaderWith getInstance() throws SQLException {
		if (instance == null)
			instance = new HeaderWith();
		return instance;
	}

	public String returnHeaderWithLogin() {
		return "<header>" + "<nav class='navbar navbar-expand-lg navbar-light bg-light'>"
				+ "<a class='navbar-brand' href='#'>LOGO MyDO Application</a>"
				+ "<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarNav' aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>"
				+ "<span class='navbar-toggler-icon'></span>" + "</button>"
				+ "<div class='collapse navbar-collapse' id='navbarNav'>" + "<ul class='navbar-nav'>"
				+ "<li class='nav-item active'>" + "<a class='nav-link' href='board.jsp'>Tablero</a>" + "</li>"
				+ "<li class='nav-item'>" + "<a class='nav-link' href='profile.jsp#myprojects'>Proyectos</a>" + "</li>"
				+ "<li class='nav-item'>" + "<a class='nav-link' href='profile.jsp#myteams'>Equipos</a>" + "</li>"
				+ "<li class='nav-item'>" + "<a class='nav-link' href='profile.jsp'>Mi cuenta</a>" + "</li>" + "</ul>"
				+ "</div>" + "</nav>" + "</header>";
	}

}
