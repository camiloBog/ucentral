package com.model.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findByName(String name) {
		
		Query query = em.createNamedQuery("Ciudad.findByName");
        query.setParameter("name", name);

        try {
        	return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
        
	}

}
