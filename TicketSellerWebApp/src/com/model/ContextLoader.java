package com.model;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ContextLoader {

	private ContextLoader() {

	}

	public static Object getContext(String EjbName) {

		try {
			Context c = new InitialContext();
			return c.lookup("java:global/TicketSellerEar/TicketSellerEjbApp/"
					+ EjbName + "!com.model.ejb." + EjbName + "Remote");
		} catch (NamingException ne) {
			Logger.getLogger(ContextLoader.class.getName()).log(Level.SEVERE,
					"exception caught", ne);
			throw new RuntimeException(ne);
		}

	}

}
