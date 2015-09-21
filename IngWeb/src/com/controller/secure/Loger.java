package com.controller.secure;

import java.util.List;

import com.model.entities.User;

public class Loger {

	/**
	 * Valida si el usuario y la contrase;a coinciden
	 * @param name
	 * @param pass
	 * @return
	 */
	public boolean validate(String name, String pass) {
		
		List<User> users = LogerSingleton.getInstance().getUsers();
		for (User user : users)
			if( user.getNombre().equals(name) && 
				user.getPassword().equals(pass) )
				return true;
		
		return false;
	}
	
	/**
	 * Obtiene el perfil de un usuario
	 * @param name
	 * @return
	 */
	public String getProfile(String name) {
		
		List<User> users = LogerSingleton.getInstance().getUsers();
		for (User user : users)
			if( user.getNombre().equals(name) )
				return user.getProfile();
		
		return null;
	}

}
