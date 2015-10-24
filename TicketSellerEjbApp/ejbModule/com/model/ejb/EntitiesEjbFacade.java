package com.model.ejb;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class EntitiesEjbFacade {
	
	@Resource
	SessionContext sessionContext;

	@PersistenceContext(unitName="TicketSellerEjbApp")
	private EntityManager em;
	
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

	public Object persist(Object object) {
		System.out.println("PERSISTIENDO.... "+object.getClass());
		em.persist(object);
		return object;
	}

	public Object merge(Object object) {
		return em.merge(object);
	}

	public void remove(Object object, Long id) {
		object = em.find(object.getClass(), id);
        em.remove(object);
	}
	
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Object> FindAll(Object object) {	
        return em.createNamedQuery(object.getClass() + ".findAll").getResultList();
    }
	
}
