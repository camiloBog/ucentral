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
public class AvionEjb extends EntitiesEjbFacade implements AvionEjbRemote {

	/**
	 * Clase que realiza las actividades CRUD de persistencia
	 * para la entidad Avion 
	 */
    public AvionEjb() {

    }

	@Override
	public Object findByCodigo(String codigo) {

		Query query = em.createNamedQuery("Avion.findByCodigo");
        query.setParameter("codigo", codigo);

        try {
        	return (Usuario) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            return null;
        }
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findByModelo(String modelo) {
		
		Query query = em.createNamedQuery("Avion.findByModelo");
        query.setParameter("modelo", modelo);

        try {
        	return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
		
	}

}
