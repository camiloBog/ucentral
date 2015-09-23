package com.view.session;

import java.util.Date;

public class SessionUsuario {
	
	private String name;
	private String profile;
	private Date ingreso;
	private boolean active;

	public SessionUsuario() {
		
	}

	public String getName() {
		return name;	
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Date getIngreso() {
		return ingreso;
	}

	public void setIngreso(Date date) {
		this.ingreso = date;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	

}
