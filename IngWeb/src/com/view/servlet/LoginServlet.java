package com.view.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.secure.Loger;

@WebServlet(name = "LoginServlet", displayName="Hangar", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Llego al Servlet!!! doPost");
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		String parametros = user + " - " + pass;
		System.out.println(parametros);
		
		response.setContentType("text/html");
		
		if(new Loger().validate(user, pass)){
			response.getWriter().write("OK");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/HangarConfig.html");
			rd.include(request, response);
		}else{
			
			response.getWriter().write(parametros);
		}

		
	}

}
