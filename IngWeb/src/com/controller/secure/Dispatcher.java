package com.controller.secure;

import java.util.Date;

import com.view.session.SessionUsuario;

public class Dispatcher {
	
	String user;
	String pass;
	Loger loger;

	public Dispatcher(String user, String pass) {
		this.user = user;
		this.pass = pass;
		this.loger = new Loger();
	}

	/**
	 * Se encarga de dirigir la ruta post autenticacion.
	 * @return
	 */
	public String getWay() {
		
		if( validate() ){
			
			if( loger.getProfile(user).equals("IT_User") )  return "/HangarConfig.html";
			if( loger.getProfile(user).equals("Seller") )   return "/HangarAdmin.html";
			if( loger.getProfile(user).equals("Customer") ) return "/Usuario.html";
			
		}

		return "/ErrorLogin.html";
	}
	
	/**
	 * Genera el objeto que sera enviado a la session
	 * @return
	 */
	public SessionUsuario getSessionUsu() {
		
		if( validate() ){
			
			SessionUsuario sessUsu = new SessionUsuario();
			sessUsu.setName( user );
			sessUsu.setProfile( loger.getProfile(user) );
			sessUsu.setIngreso( new Date() );
			sessUsu.setActive( Boolean.TRUE );			
			
			return sessUsu;
		}

		return null;
	}
	
	/**
	 * Valida si el usuario y la contraseña
	 * estan correctos.
	 * @return
	 */
	public Boolean validate() {
		return loger.validate( user, pass );
	}

}
