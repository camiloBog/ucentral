package com.model.ejb;

import javax.ejb.Stateless;

/**
 * 
 * @author camilo
 * @version 1.0, Noviembre de 2015
 * 
 */
@Stateless
public class VueloEjb extends EntitiesEjbFacade implements VueloEjbRemote {

	/**
	 * Clase que realiza las actividades CRUD de persistencia
	 * para la entidad Vuelo
	 */
    public VueloEjb() {
    	
    }

}
