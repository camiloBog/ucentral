<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html>
	<head>
		<title>TicketSeller Home</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body>

		<!-- Header -->
			<header id="header">
				<img alt="logotipo" src="images/Logo_Blanco_Transp_mediana.png">				
				<p>El lugar al que deseas llegar se encuentra a un par de clicks de distancia...</p>
			</header>

		<!-- Signup Form -->
			<form id="signup-form" method="post" action="LoginServlet"><label></label>
				<label>Fecha</label><input type="text" name="fecha" id="fecha" placeholder="Fecha del Vuelo"/>
				<label>Origen</label><input type="text" name="origen" id="origen" placeholder="Ciudad de Origen"/>
				<label>Destino</label><input type="text" name="destino" id="destino" placeholder="Ciudad de Destino"/>
				<label>Clase</label><input type="text" name="clase" id="clase" placeholder="Clase de Turista"/>
				<label>Pasajeros</label><input type="text" name="pasajes" id="pasajes" placeholder="Numero de Pasajeros"/>
				<input type="submit" value="Buscar Vuelo" />
			</form>

			<footer id="footer">
				<ul class="copyright">
					<li>&copy; TicketSeller.</li>
					<li><a href="index.html">Hangar</a></li>
				</ul>
			</footer>	
			<script src="assets/js/main.js"></script>
	</body>
</html:html>