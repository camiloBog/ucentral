package com.view.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.view.session.SessionListener;
import com.view.session.SessionUsuario;

@WebServlet("/SessionView")
public class SessionView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionView() {
        super();
    }

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		
		String page = 
			"<!DOCTYPE html>"+
			"<html>"+
			"<head>"+
			
			"<link href='css/bootstrap.css' rel='stylesheet'>"+
			"<link href='css/style.css' rel='stylesheet' type='text/css' media='all' />"+
			"<link href='css/ticketSeller.css' rel='stylesheet'>"+

			"<script src='js/jquery.min.js'></script>"+
			"<script src='js/bootstrap.js'></script>"+
			"<script type='text/javascript' src='js/move-top.js'></script>"+
			"<script type='text/javascript' src='js/easing.js'></script>"+

			"<meta charset='UTF-8'>"+
			"<title>Vista de Sesion</title>"+
			"</head>"+
			"<body>"+
			
				"<header>"+
					"<div class='services'>"+
					"<h3>Monitor de Cantidad de Sesiones</h3>"+
						"<div class='container'>"+
											
							"<div class='logo'>"+
								"<a href='Ticket.html'>"+
								"<img src='images/Logo_Negro_mediana.png' alt='logo' /></a>"+
							"</div>"+
											
						"	</div>"+
					"</div>"+
				"</header>"+
				"<br/><br/>"+
				"<div class='sesiones'><br/>";

		
		SessionUsuario usu = (SessionUsuario) sesion.getAttribute("TicketUsu");
		page += "<p><h3>Sr(a).  " + usu.getName() + "</h3></p>";

		Integer cant = SessionListener.getSesionesActivas();
		
		if( cant != 0 && cant != null )
			page += "<p><h3>Hay " + cant + " Sesiones Activas</h3></p>";
		else
			page += "<p><h3>Ninguna Sesion Activa.</h3></p>";
		
		page +=
				"</div>"+
			"</body>"+
			"</html>";
		
		response.setContentType("text/html");
		response.getWriter().write(page);
		
	}

}
