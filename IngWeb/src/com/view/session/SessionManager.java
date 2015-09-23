package com.view.session;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionManager implements HttpSessionListener {

	private static SessionManager instance;
	private List<HttpSession> sessionsList;

	private SessionManager() {
		
	}
	
	/**
	 * Devuelve la unica instancia creada
	 * @return
	 */
	public static SessionManager getInstance() {
		
		if(instance == null)
			instance = new SessionManager();
		
		return instance;
		
	}

	/**
	 * Agrega la session a la lista
	 */
	@Override
	public void sessionCreated(HttpSessionEvent SessionEvent) {

		getInstance().getSessionsList().add(SessionEvent.getSession());
		
	}

	/**
	 * Elimina la session de la lista
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent SessionEvent) {
		
		for (int i = 0; i < getInstance().getSessionsList().size(); i++) 
			if( getInstance().getSessionsList().get(i).equals( SessionEvent.getSession() ) )
				getInstance().getSessionsList().remove( i );
	}

	public List<HttpSession> getSessionsList() {
		return sessionsList;
	}

}
