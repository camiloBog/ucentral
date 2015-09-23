package com.controller.secure;

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
		
		if( loger.validate(user, pass) ){
			
			if( loger.getProfile(user).equals("IT_User") ) return "/HangarConfig.html";
			if( loger.getProfile(user).equals("Seller") ) return "/HangarAdmin.html";
			if( loger.getProfile(user).equals("Customer") ) return "/Usuario.html";
			
		}

		return "/ErrorLogin.html";
	}

}
