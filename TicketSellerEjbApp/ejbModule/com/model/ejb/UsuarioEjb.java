package com.model.ejb;

import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.model.entities.Usuario;

@Stateless
public class UsuarioEjb extends EntitiesEjbFacade implements UsuarioEjbRemote {

    public UsuarioEjb() {
    	super();
    }
    
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

	@Override
	public Usuario findByDocument(BigDecimal document) {
		
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
