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
public interface CiudadEjbRemote extends EntitiesFacade{
	
	/**
	 * Trae las ciudades que coinciden con un String
	 * 
	 * @param name	Nombre de la ciudad que se busca.
	 * @return		Retorna la lista que coincide con la busqueda
	 */	
	public List<Object> findByName(String name);
	
	/**
	 * Trae las ciudades que coinciden con el idPais
	 * @param	idPais identificador de pais de la ciudad
	 * @return	Retorna la lista que coincide con la busqueda
	 */
	public List<Object> findByCountryId(long idPais);

}
