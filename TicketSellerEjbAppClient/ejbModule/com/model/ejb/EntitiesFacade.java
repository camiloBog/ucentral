package com.model.ejb;

import java.util.List;

public interface EntitiesFacade {
	
	Object queryByRange(String jpqlStmt, int firstResult, int maxResults);
	
	public Object persist(Object object);
    public Object merge(Object object);
    public void remove(Object object, Long id);
    public List<Object> FindAll(Object object);
    
}
