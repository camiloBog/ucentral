package com.pruebas;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletDePruebas")
public class ServletDePruebas extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ServletDePruebas() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String txt = request.getParameter("txt");
		System.out.println("-Texto: "+txt);
		

		ClaseDePruebas prueba = new ClaseDePruebas();
		String respuesta = prueba.pruebas(txt, "", ""); 
		
		System.out.println("Respuesta: "+respuesta);		
		response.getWriter().write(respuesta);

	}

}
