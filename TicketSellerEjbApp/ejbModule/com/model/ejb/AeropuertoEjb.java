package com.model.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import com.model.entities.Usuario;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findByName(String name) {
		
		Query query = em.createNamedQuery("Aeropuerto.findByName");
        query.setParameter("name", name);

        try {
        	return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
        
	}

	@Override
	public Object findByCodIata(String iata) {
		
		Query query = em.createNamedQuery("Aeropuerto.findByCodIata");
        query.setParameter("iata", iata);

        try {
        	return (Usuario) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            return null;
        }
		
	}

}
