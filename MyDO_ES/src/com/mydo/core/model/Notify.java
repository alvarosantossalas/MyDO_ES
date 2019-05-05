package com.mydo.core.model;

import java.util.UUID;

public class Notify {

	private String id_notify;
	private String title;
	private String message;
	private String image;

	public Notify() {
	}

	public Notify(String title, String message, String image) {
		this.id_notify = "notify_" + UUID.randomUUID().toString();
		this.title = title;
		this.message = message;
		this.image = image;
	}

	public Notify(String id_notify, String title, String message, String image) {
		this.id_notify = id_notify;
		this.title = title;
		this.message = message;
		this.image = image;
	}

	public String getId_notify() {
		return id_notify;
	}

	public void setId_notify(String id_notify) {
		this.id_notify = id_notify;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
