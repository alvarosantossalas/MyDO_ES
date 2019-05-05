package com.mydo.core.model;

import java.util.UUID;

public class User {

	private String id_user;
	private int admin;
	private String username;
	private String password;
	private String name;
	private String lastname;
	private String email;
	private String phone;

	public User() {
	}

	public User(String username, String password, String name, String lastname, String email, String phone) {
		super();
		this.id_user = "user_" + UUID.randomUUID().toString();
		this.admin = 0;
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
	}

	public User(String id_user, int admin, String username, String password, String name, String lastname, String email,
			String phone) {
		super();
		this.id_user = id_user;
		this.admin = admin;
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
