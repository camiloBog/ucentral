package com.model.ejb;

import javax.ejb.Stateless;

/**
 * 
 * @author camilo
 * @version 1.0, Noviembre de 2015
 * 
 */
@Stateless
public class AeropuertoEjb extends EntitiesEjbFacade implements AeropuertoEjbRemote {

	/**
	 * Clase que realiza las actividades CRUD de persistencia
	 * para la entidad Aeropuerto 
	 */
    public AeropuertoEjb() {

    }

}
