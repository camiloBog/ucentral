package com.controller;

import java.math.BigInteger;

import com.model.ContextLoader;
import com.model.ejb.UsuarioEjbRemote;
import com.model.entities.Usuario;


public class ValidaUsuario {
	
	UsuarioEjbRemote usuarioService = (UsuarioEjbRemote) ContextLoader.getContext("UsuarioEjb");

	public ValidaUsuario() {
		
	}
	
	public boolean valida(String user, String pass){
		
		try {
			Usuario usuario = (Usuario) usuarioService.findByDocument( new BigInteger(user) );
			
			if( null!=usuario && pass.equals( usuario.getPass() ))
				return true;
			
		} catch (Exception e) {
			return false;
		}
		
		return false;

	}

}
