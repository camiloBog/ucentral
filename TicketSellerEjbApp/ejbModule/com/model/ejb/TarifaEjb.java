package com.model.ejb;

import javax.ejb.Stateless;

/**
 * 
 * @author camilo
 * @version 1.0, Noviembre de 2015
 * 
 */
@Stateless
public class TarifaEjb extends EntitiesEjbFacade implements TarifaEjbRemote {


	/**
	 * Clase que realiza las actividades CRUD de persistencia
	 * para la entidad Tarifa 
	 */
    public TarifaEjb() {
    	
    }

}
