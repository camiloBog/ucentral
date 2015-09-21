package com.model.entities;

public class User {

	private String nombre;
	private String password;
	private String profile;

	public User() {
		
	}
	
	public User(String nombre, String password) {
		this.nombre = nombre;
		this.password = password;
	}
	
	public User(String nombre, String password, String profile) {
		this.nombre = nombre;
		this.password = password;
		this.profile = profile;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

}
