package com.pruebas;

import java.math.BigInteger;

import com.model.ContextLoader;
import com.model.ejb.UsuarioEjbRemote;
import com.model.entities.Usuario;

public class ClaseDePruebas {
	
	UsuarioEjbRemote usuarioService = (UsuarioEjbRemote) ContextLoader.getContext("UsuarioEjb");

	public ClaseDePruebas() {
		
	}
	
	public String pruebas(String txt1, String txt2, String txt3){
	
		BigInteger documento = new BigInteger(txt1);
		Usuario usu = (Usuario) usuarioService.findByDocument(documento); 
		
		return usu.getNombre() + " " + usu.getApellido();
		
	}

}
