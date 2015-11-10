package com.model.ejb;

import java.math.BigInteger;

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
public class UsuarioEjb extends EntitiesEjbFacade implements UsuarioEjbRemote {

	/**
	 * Clase que realiza las actividades CRUD de persistencia
	 * para la entidad Usuario.
	 */
    public UsuarioEjb() {
    	super();
    }
    
	@Override
	public Usuario findByDocument(BigInteger document) {

		Query query = em.createNamedQuery("Usuario.findByDocument");
        query.setParameter("documentoUsu", document);

        try {
        	return (Usuario) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            return null;
        }
	}

}
