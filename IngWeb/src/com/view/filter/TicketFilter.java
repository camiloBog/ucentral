package com.view.filter;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Se encarga de realizar una auditoria
 * de la cantidad de veces que una URL ha sido accedida.
 */
@WebFilter(filterName="/TicketFilter",urlPatterns="/*")
public class TicketFilter implements Filter {
	
	private String attribute = "stats";

    public TicketFilter() {
    	
    }

	public void destroy() {
		
	}

	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		
		//Se captura el request y el context
		HttpServletRequest servletRequest = ( HttpServletRequest ) request;
		ServletContext context = request.getServletContext();
		
		HashMap<String, Integer> urlList;
		
		//Se inicia la lista
		if( null == context.getAttribute( attribute ) ){
			
			//Se llena la lista con Url
			urlList = new HashMap<String, Integer>();
			urlList.put( servletRequest.getRequestURL().toString(), 1 );
			
			//Se envia la lista al context
			context.setAttribute( attribute, urlList) ;			
		
		}else{
			
			//Se actualiza la lista desde el context
			urlList = (HashMap<String, Integer>) context.getAttribute( attribute );
			
			//Si la url no esta en la lista, se agrega
			//Sino se incrementa
			if( urlList.get( servletRequest.getRequestURL().toString() ) == null )
				urlList.put( servletRequest.getRequestURL().toString(), 1 );
			else
				urlList.put( servletRequest.getRequestURL().toString(), 
						urlList.get( servletRequest.getRequestURL().toString() + 1 ) );
			
		}
		
		chain.doFilter(request, response);
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
