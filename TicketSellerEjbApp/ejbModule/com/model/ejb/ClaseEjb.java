package com.model.ejb;

import javax.ejb.Stateless;

/**
 * 
 * @author camilo
 * @version 1.0, Noviembre de 2015
 * 
 */
@Stateless
public class ClaseEjb extends EntitiesEjbFacade implements ClaseEjbRemote {

	/**
	 * Clase que realiza las actividades CRUD de persistencia
	 * para la entidad Clase 
	 */
    public ClaseEjb() {

    }

}
