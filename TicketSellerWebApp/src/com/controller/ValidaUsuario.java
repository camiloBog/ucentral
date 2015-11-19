package com.controller;

import java.math.BigInteger;

import com.model.ContextLoader;
import com.model.ejb.UsuarioEjbRemote;
import com.model.entities.Usuario;


public class ValidaUsuario {
	
	private Usuario usuario;
	private UsuarioEjbRemote usuarioService = 
			(UsuarioEjbRemote) ContextLoader.getContext("UsuarioEjb");

	public ValidaUsuario() {
		
	}
	
	public boolean valida(String user, String pass){
		
		try {
			usuario = (Usuario) usuarioService.findByDocument( new BigInteger(user) );
			
			if( null!=usuario && pass.equals( usuario.getPass() ))
				return true;
			
		} catch (Exception e) {
			return false;
		}
		
		return false;

	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
