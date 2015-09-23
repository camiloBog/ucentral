package com.view.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.secure.Dispatcher;

@WebServlet(name = "LoginServlet", 
			displayName="Hangar", 
			urlPatterns = { "/LoginServlet" }
			)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
			
		Dispatcher dispatcher = new Dispatcher(user, pass);
		
		RequestDispatcher rd = getServletContext().
				getRequestDispatcher( dispatcher.getWay() );
		
		
		response.setContentType("text/html");
		rd.include(request, response);
		
	}

}
