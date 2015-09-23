package com.view.filter;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

/**
 * Se encarga de realizar una auditoria
 * de la cantidad de veces que una URL ha sido accedida
 */
@WebFilter(
		filterName="/TicketFilter", urlPatterns="/*",
		dispatcherTypes = {	
			DispatcherType.REQUEST, 
			DispatcherType.FORWARD,
			DispatcherType.ASYNC,
			DispatcherType.ERROR,
			DispatcherType.INCLUDE
		},
		initParams = { 
			@WebInitParam(name =  "msg", value = "FILTRO::: ") 
		})
public class TicketFilter implements Filter {
	
	private String attribute = "stats";
	private FilterConfig filterConfig;

    public TicketFilter() {
    	
    }
    
    public void init(FilterConfig fConfig) throws ServletException {
    	this.filterConfig = fConfig;
	}

	public void destroy() {
		
	}

	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
		
		//Se captura el request y el context
		HttpServletRequest servletRequest = ( HttpServletRequest ) request;
		ServletContext context = request.getServletContext();
		
		System.out.println( filterConfig.getInitParameter("msg") + servletRequest.getRequestURL() );
		
		HashMap<String, Integer> urlList;
		
		//Se inicia la lista
		if( null == context.getAttribute( attribute ) ){
			
			//Se llena la lista con Url
			urlList = new HashMap<String, Integer>();
			urlList.put( servletRequest.getRequestURI().toString(), 1 );
			
			//Se envia la lista al context
			context.setAttribute( attribute, urlList) ;		
		
		}else{
			
			//Se actualiza la lista desde el context
			urlList = (HashMap<String, Integer>) context.getAttribute( attribute );
			
			//Si la url no esta en la lista, se agrega
			//Sino se incrementa
			if( urlList.get( servletRequest.getRequestURI().toString() ) == null )
				urlList.put( servletRequest.getRequestURI().toString(), 1 );
			else
				urlList.put( servletRequest.getRequestURI().toString(), 
						urlList.get( servletRequest.getRequestURI().toString() + 1 ) );
			
		}
		
		chain.doFilter(request, response);
		
	}

}
