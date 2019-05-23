package com.mydo.utilities.structure;

import java.sql.SQLException;

public class Head {

	private static Head instance = null;

	public static Head getInstance() throws SQLException {
		if (instance == null)
			instance = new Head();
		return instance;
	}

	public String returnHead() {
		return "<meta http-equiv='Content-type' content='text/html; charset=UTF-8'>"
				+ "<title>MyDO Es</title>"
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

}
