package com.mydo.core.model;

import java.util.Date;

public class Session {

	private String id_user;
	private String date;

	public Session() {
	}

	public Session(String id_user, String date) {
		this.id_user = id_user;
		this.date = new Date().toString();
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
