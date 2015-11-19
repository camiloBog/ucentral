package com.controller;

import com.model.ContextLoader;
import com.model.ejb.AeropuertoEjbRemote;
import com.model.ejb.CiudadEjbRemote;
import com.model.ejb.PaisEjbRemote;
import com.model.ejb.UsuarioEjbRemote;
import com.model.entities.Aeropuerto;
import com.model.entities.Ciudad;

public class ValidaAeropuerto {
	
	private CiudadEjbRemote ciudadService = 
			(CiudadEjbRemote) ContextLoader.getContext("CiudadEjb");
	
	private PaisEjbRemote paisService = 
			(PaisEjbRemote) ContextLoader.getContext("PaisEjb");
	
	private AeropuertoEjbRemote aeropuertoService = 
			(AeropuertoEjbRemote) ContextLoader.getContext("AeropuertoEjb");

	public ValidaAeropuerto() {
		
	}

	public String guardaAerop(String city, String country, String name,
			String iata) {
		
		/*
		Ciudad ciudad = aeropuertoService.findByName(name)
		
		
		Aeropuerto aeropuerto = new Aeropuerto();
		aeropuerto.setCiudad();
		aeropuerto.set
		aeropuerto.set
		aeropuerto.set
		*/
		
		
		return "";
		
	}

}
