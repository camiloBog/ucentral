package com.view.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.ejb.CiudadEjbRemote;
import com.model.ejb.PaisEjbRemote;
import com.model.entities.Pais;

@WebServlet("/ServletDePrueba")
public class ServletDePrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	PaisEjbRemote paisService;
	
	@EJB
	CiudadEjbRemote ciudadService;
	
	public ServletDePrueba() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String txt = request.getParameter("txt");
		System.out.println("****SERVLET: " + txt);

		Pais pais = new Pais();
		pais.setNombre(txt);
		
		Pais pais2 = (Pais) paisService.persist(pais);
		String respuesta = "- PAIS: " + pais2.getIdPais() + " - " + pais2.getNombre(); 
		//String respuesta = ejbService.tester(txt);
		
		response.getWriter().write(respuesta);
		
	}

}
