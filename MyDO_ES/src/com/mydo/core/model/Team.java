package com.mydo.core.model;

import java.util.UUID;

public class Team {

	private String id_team;
	private String name;
	private String image;

	public Team() {
	}

	public Team(String name, String image) {
		super();
		this.id_team = "team_" + UUID.randomUUID().toString();
		this.name = name;
		this.image = image;
	}

	public Team(String id_team, String name, String image) {
		super();
		this.id_team = id_team;
		this.name = name;
		this.image = image;
	}

	public String getId_team() {
		return id_team;
	}

	public void setId_team(String id_team) {
		this.id_team = id_team;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
