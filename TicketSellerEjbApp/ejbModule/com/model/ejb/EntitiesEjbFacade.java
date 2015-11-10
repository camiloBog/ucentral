package com.model.ejb;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * 
 * @author camilo
 * @version 1.0, Noviembre de 2015
 * 
 */
public abstract class EntitiesEjbFacade {
	
	@Resource
	protected SessionContext sessionContext;

	@PersistenceContext(unitName="TicketSellerEjbApp")
	protected EntityManager em;
	
	/**
	 * Se encarga de generar el objeto Query dependiendo
	 * de la cantida de objetos devueltos por la transaccion.
	 * 
	 * @param jpqlStmt		Query ejectado.
	 * @param firstResult	Primer resultado.
	 * @param maxResults	Resultado maximo.
	 * @return				Objeto devuelto.
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult,
                               int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }

        return query.getResultList();
    }

	/**
	 * Funcion generica para persistir las entidades.
	 * 
	 * @param object	Objeto a persistir.
	 * @return			Objeto persistido.
	 */
	public Object persist(Object object) {
		em.persist(object);
		return object;
	}

	/**
	 * Funcion generica para hacer update sobre
	 * una entidad.
	 * 
	 * @param object	Entidad sobre la que se realiza el update
	 * @return			Entidad sobre la que se realizo el uptdate
	 */
	public Object merge(Object object) {
		return em.merge(object);
	}

	/**
	 * Funcion generica para eliminar un registro.
	 * 
	 * @param object	Tipo de objeto del que se realizara la accion.
	 * @param id		Identificador del registro que se eliminara.
	 */
	public void remove(Object object, Long id) {
		object = em.find(object.getClass(), id);
        em.remove(object);
	}
	
	/**
	 * Funcion generica para traer todos los registros de una tabla
	 * 
	 * @param object	Tipo de objeto del que se realizara la accion.
	 * @return			Lista del tipo de objetos solicitada.
	 */
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Object> FindAll(Object object) {
		
		try {
			return em.createNamedQuery(
					object.getClass().getSimpleName() + ".findAll").getResultList();
		} catch (NoResultException e) {
			return null;
		}
		
	}
	
	/**
     * Funcion generica para traer un registro de una tabla
     * a partir del id.
     * 
     * @param object	Tipo de objeto que se esta buscando.
     * @param id		Identificador del objeto buscado.
     * @return			Objeto entrontrado.
     */
	public Object FindById(Object object, Long id) {
		
		try {
			return em.createNamedQuery(
					object.getClass().getSimpleName() + ".findById")
					.setParameter("id", id)
					.getSingleResult();			
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
