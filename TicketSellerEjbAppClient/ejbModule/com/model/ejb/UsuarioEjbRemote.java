package com.model.ejb;

import java.math.BigDecimal;

import javax.ejb.Remote;

@Remote
public interface UsuarioEjbRemote extends EntitiesFacade {

	public Object findByDocument(BigDecimal bigDecimal);

}
