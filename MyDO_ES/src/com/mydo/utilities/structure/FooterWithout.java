package com.mydo.utilities.structure;

import java.sql.SQLException;

public class FooterWithout {

	private static FooterWithout instance = null;

	public static FooterWithout getInstance() throws SQLException {
		if (instance == null)
			instance = new FooterWithout();
		return instance;
	}

	public String returnFooterWithoutLogin() {
		return "<footer id='myFooter'>" + "<div class='container'>" + "<div class='row'>" + "<div class='col-sm-3'>"
				+ "<h2 class='logo'>" + "<a href='#'><img src='images/MyDo-128.gif'></a>" + "</h2>" + "</div>"
				+ "<div class='col-sm-2'>" + "<h5>Comencemos</h5>" + "<ul>" + "<li><a href='index.jsp'>Home</a></li>"
				+ "<li><a href='registration.jsp'>Registrarse</a></li>" + "<li><a href='#'>Descargas</a></li>" + "</ul>"
				+ "</div>" + "<div class='col-sm-2'>" + "<h5>Sobre nosotros</h5>" + "<ul>"
				+ "<li><a href='#'>Información de la compañía</a></li>" + "<li><a href='contact.jsp'>Contactar</a></li>"
				+ "</ul>" + "</div>" + "<div class='col-sm-2'>" + "<h5>Soporte</h5>" + "<ul>"
				+ "<li><a href='#'>FAQ</a></li>" + "<li><a href='#'>Ayuda</a></li>" + "<li><a href='#'>Foros</a></li>"
				+ "</ul>" + "</div>" + "<div class='col-sm-3'>" + "<div class='social-networks'>"
				+ "<a href='#' class='twitter'><i class='fa fa-twitter'></i></a>"
				+ "<a href='#' class='facebook'><i class='fa fa-facebook'></i></a>"
				+ "<a href='#' class='google'><i class='fa fa-google-plue'></i></a>" + "</div>"
				+ "<button type='button' class='btn btn-default'>Contactar</button>" + "</div>" + "</div>" + "</div>"
				+ "<div class='footer-copyright'>" + "<p>© 2019 MyDO ES Co.</p>" + "</div>" + "</footer>";
	}

}
