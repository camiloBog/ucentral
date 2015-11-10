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
public interface AeropuertoEjbRemote extends EntitiesFacade{
	
	/**
	 * Trae los aeropuertos que coinciden con un String.
	 * 
	 * @param name	Nombre del aeropuerto que se busca.
	 * @return		Retorna la lista que coincide con la busqueda.
	 */	
	public List<Object> findByName(String name);
	
	/**
	 * Trae el aeropuerto que tiene el codigo IATA mencionado.
	 * @param iata	Codigo IATA
	 * @return		Aeropuerto que coincide con la busqueda.
	 */
	public Object findByCodIata(String iata);

}
