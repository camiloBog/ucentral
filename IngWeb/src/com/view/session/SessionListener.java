package com.view.session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
	
	private static int sesionesActivas;

	public SessionListener() {
		
	}
	
	public static int getSesionesActivas(){
		return sesionesActivas;
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		sesionesActivas++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		sesionesActivas--;
	}

}
