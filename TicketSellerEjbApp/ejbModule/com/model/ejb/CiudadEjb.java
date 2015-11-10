package com.model.ejb;

import javax.ejb.Stateless;

/**
 * 
 * @author camilo
 * @version 1.0, Noviembre de 2015
 * 
 */
@Stateless
public class CiudadEjb extends EntitiesEjbFacade implements CiudadEjbRemote {

	/**
	 * Clase que realiza las actividades CRUD de persistencia
	 * para la entidad Ciudad 
	 */
    public CiudadEjb() {

    }

}
