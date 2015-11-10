package com.model.ejb;

import java.math.BigInteger;
import javax.ejb.Remote;

/**
 * 
 * @author camilo
 * @version 1.0, Noviembre de 2015
 * 
 */
@Remote
public interface UsuarioEjbRemote extends EntitiesFacade {

	/**
	 * Encuentra el usuario a partir del numero del
	 * documento de identidad. 
	 * 
	 * @param document	numero del documento de identidad.
	 * @return Usuario	Usuario encontrado.
	 */
	public Object findByDocument(BigInteger document);

}
