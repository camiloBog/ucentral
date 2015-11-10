package com.model.ejb;

import java.util.List;

import javax.ejb.Remote;

/**
 * 
 * @author camilo
 * @version 1.0, Noviembre de 2015
 * 
 */
@Remote
public interface PaisEjbRemote extends EntitiesFacade {
	
	/**
	 * Trae los paises que coinciden con un String
	 * 
	 * @param name	nombre del pais que se busca
	 * @return		Retorna la lista que coincide con la busqueda
	 */	
	public List<Object> findByName(String name);

}
