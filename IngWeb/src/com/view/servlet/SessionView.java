package com.view.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.view.session.SessionManager;
import com.view.session.SessionUsuario;

@WebServlet("/SessionView")
public class SessionView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionView() {
        super();
    }

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		
		String page = 
			"<!DOCTYPE html>"+
			"<html>"+
			"<head>"+
			"<meta charset='UTF-8'>"+
			"<title>Vista de Sesion</title>"+
			"</head>"+
			"<body>"+
				"<h1>Sessiones</h1>"+
				"<br/>";

		
		List<HttpSession> SessionsList = SessionManager.getInstance().getSessionsList();
		for (HttpSession list : SessionsList) {
			SessionUsuario usu = (SessionUsuario) list.getAttribute("TicketUsu");
			System.out.println(usu.getName() + " - " + usu.getProfile() + " - " +  usu.getIngreso());
			page += "<h3>" +usu.getName() + " - " + usu.getProfile() + " - " +  usu.getIngreso() + "</h3>";
		}
		
		
		page +=
			"</body>"+
			"</html>";
		
		response.setContentType("text/html");
		response.getWriter().write(page);
		
	}

}
