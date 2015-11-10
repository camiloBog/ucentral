package com.model.ejb;

import java.util.List;

/**
 * 
 * @author camilo
 * @version 1.0, Noviembre de 2015
 * 
 */
public interface EntitiesFacade {
	
	/**
	 * Se encarga de generar el objeto Query dependiendo
	 * de la cantida de objetos devueltos por la transaccion.
	 * 
	 * @param jpqlStmt		Query ejectado.
	 * @param firstResult	Primer resultado.
	 * @param maxResults	Resultado maximo.
	 * @return				Objeto devuelto.
	 */
	Object queryByRange(String jpqlStmt, int firstResult, int maxResults);
	
	/**
	 * Funcion generica para persistir las entidades.
	 * 
	 * @param object	Objeto a persistir.
	 * @return			Objeto persistido.
	 */
	public Object persist(Object object);
	
	/**
	 * Funcion generica para hacer update sobre
	 * una entidad.
	 * 
	 * @param object	Entidad sobre la que se realiza el update
	 * @return			Entidad sobre la que se realizo el uptdate
	 */
    public Object merge(Object object);
    
    /**
	 * Funcion generica para eliminar un registro.
	 * 
	 * @param object	Tipo de objeto del que se realizara la accion.
	 * @param id		Identificador del registro que se eliminara.
	 */
    public void remove(Object object, Long id);
    
    /**
	 * Funcion generica para traer todos los registros de una tabla
	 * 
	 * @param object	Tipo de objeto del que se realizara la accion.
	 * @return			Lista del tipo de objetos solicitada.
	 */
    public List<Object> FindAll(Object object);
    
}
