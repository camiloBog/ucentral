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
public interface AvionEjbRemote extends EntitiesFacade {

	/**
	 * Trae el avion que coincide con el codigo ingresado.
	 * 
	 * @param codigo	Codigo del avion a traer.
	 * @return			Avion correspondiente al modelo.
	 */
	public Object findByCodigo(String codigo);
	
	/**
	 * Trae la lista de aviones que coinciden con el
	 * modelo solicitado.
	 * 
	 * @param modelo	Modelo de avion buscado.
	 * @return			Lista de aviones que coinciden con el modelo.
	 */
	public List<Object> findByModelo(String modelo);
	
}
