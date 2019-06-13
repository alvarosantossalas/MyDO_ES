package com.mydo.utilities.structure;

import java.sql.SQLException;

public class Structure {

	private static Structure instance = null;
	private static String title = "MyDO Es";
	private static String title_in_nav = "LOGO MyDO Application";
	//private static String logo_footer = "<img src='images/MyDo-128.gif'>";
	private static String logo_footer = "<p class=h1>MYDO LOGO</p>";
	
	/**
	 * Retorna una instancia de la clase
	 * @return
	 * @throws SQLException
	 */
	public static Structure getInstance() throws SQLException {
		if (instance == null)
			instance = new Structure();
		return instance;
	}

	/**
	 * Retorna el Header de todas las páginas .jsp para cuando no haya ningún usuario logado
	 * @return
	 */
	public String returnHeaderWithLogin() {
		return "<header>" + "<nav class='navbar navbar-expand-lg navbar-light bg-light'>"
				+ "<a class='navbar-brand' href='#'>" + title_in_nav + "</a>"
				+ "<button class='navbar-toggler' type='button' data-toggle='collapse' data-target='#navbarNav' aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>"
				+ "<span class='navbar-toggler-icon'></span>" + "</button>"
				+ "<div class='collapse navbar-collapse' id='navbarNav'>" + "<ul class='navbar-nav'>"
				+ "<li class='nav-item active'>" + "<a class='nav-link' href='board.jsp'>Tablero</a>" + "</li>"
				+ "<li class='nav-item'>" + "<a class='nav-link' href='profile.jsp#myprojects'>Proyectos</a>" + "</li>"
				+ "<li class='nav-item'>" + "<a class='nav-link' href='profile.jsp#myteams'>Equipos</a>" + "</li>"
				+ "<li class='nav-item'>" + "<a class='nav-link' href='profile.jsp'>Mi cuenta</a>" + "</li>" + "</ul>"
				+ "</div>" + "</nav>" + "</header>";
	}

	/**
	 * Retorna el Header de todas las páginas .jsp para cuando hay algún usuario logado
	 * @return
	 */
	public String returnHeaderWithoutLogin() {
		return "<header>" + "<nav class='navbar navbar-expand-lg navbar-light bg-light'>"
				+ "<a class='navbar-brand' href='#'>" + title_in_nav + "</a>"
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

	/**
	 * Retorna el head de todas las páginas .jsp
	 * @return
	 */
	public String returnHead() {
		return "<meta http-equiv='Content-type' content='text/html; charset=UTF-8'>" + "<title>" + title + "</title>"
				+ "<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>"
				+ "<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>"
				+ "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>"
				+ "<script src='https://code.jquery.com/jquery-3.2.1.slim.min.js' integrity='sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN' crossorigin='anonymous'></script>"
				+ "<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js' integrity='sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q' crossorigin='anonymous'></script>"
				+ "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js' integrity='sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl' crossorigin='anonymous'></script>"
				+ "<link href='//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css' rel='stylesheet'>"
				+ "<script src='javascript/checkPassword.js'></script>"
				+ "<link rel='stylesheet' href='styles/footer.css'>"
				+ "<link rel='stylesheet' href='styles/styles.css'>";
	}

	/**
	 * Retorna el Footer de  todas las páginas .jsp las cuales esté el usuario logado
	 * @return
	 */
	public String returnFooterWithLogin() {
		return "<footer id='myFooter'>" + "<div class='container'>" + "<div class='row'>" + "<div class='col-sm-3'>"
				+ "<h2 class='logo'>" + "<a href='#'>" + logo_footer + "</a>" + "</h2>" + "</div>"
				+ "<div class='col-sm-2'>" + "<h5>Sobre nosotros</h5>" + "<ul>"
				+ "<li><a href='#'>Información de la compañía</a></li>" + "<li><a href='contact.jsp'>Contactar</a></li>"
				+ "</ul>" + "</div>" + "<div class='col-sm-2'>" + "<h5>Soporte</h5>" + "<ul>"
				+ "<li><a href='#'>FAQ</a></li>" + "<li><a href='#'>Ayuda</a></li>" + "<li><a href='#'>Foros</a></li>"
				+ "</ul>" + "</div>" + "<div class='col-sm-3'>" + "<div class='social-networks'>"
				+ "<a href='#' class='twitter'><i class='fa fa-twitter'></i></a>"
				+ "<a href='#' class='facebook'><i class='fa fa-facebook'></i></a>"
				+ "<a href='#' class='google'><i class='fa fa-google-plus'></i></a>" + "</div>"
				+ "<button type='button' class='btn btn-default'>Contactar</button>" + "</div>" + "</div>" + "</div>"
				+ "<div class='footer-copyright'>" + "<p>© 2019 MyDO ES Co.</p>" + "</div>" + "</footer>";
	}
	
	/**
	 * Retorna el Footer de todas las páginas .jsp las cuales el usuario no esté logado.
	 * @return
	 */
	public String returnFooterWithoutLogin() {
		return "<footer id='myFooter'>" + "<div class='container'>" + "<div class='row'>" + "<div class='col-sm-3'>"
				+ "<h2 class='logo'>" + "<a href='#'>" + logo_footer + "</a>" + "</h2>" + "</div>"
				+ "<div class='col-sm-2'>" + "<h5>Comencemos</h5>" + "<ul>" + "<li><a href='index.jsp'>Home</a></li>"
				+ "<li><a href='registration.jsp'>Registrarse</a></li>" + "<li><a href='#'>Descargas</a></li>" + "</ul>"
				+ "</div>" + "<div class='col-sm-2'>" + "<h5>Sobre nosotros</h5>" + "<ul>"
				+ "<li><a href='#'>Información de la compañía</a></li>" + "<li><a href='contact.jsp'>Contactar</a></li>"
				+ "</ul>" + "</div>" + "<div class='col-sm-2'>" + "<h5>Soporte</h5>" + "<ul>"
				+ "<li><a href='#'>FAQ</a></li>" + "<li><a href='#'>Ayuda</a></li>" + "<li><a href='#'>Foros</a></li>"
				+ "</ul>" + "</div>" + "<div class='col-sm-3'>" + "<div class='social-networks'>"
				+ "<a href='#' class='twitter'><i class='fa fa-twitter'></i></a>"
				+ "<a href='#' class='facebook'><i class='fa fa-facebook'></i></a>"
				+ "<a href='#' class='google'><i class='fa fa-google-plus'></i></a>" + "</div>"
				+ "<button type='button' class='btn btn-default'>Contactar</button>" + "</div>" + "</div>" + "</div>"
				+ "<div class='footer-copyright'>" + "<p>© 2019 MyDO ES Co.</p>" + "</div>" + "</footer>";
	}

}
