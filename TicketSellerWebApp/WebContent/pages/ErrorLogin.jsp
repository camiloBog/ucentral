<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<html:html>
	<head>
		<title><bean:message key="login.title" /></title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		
		<link rel="stylesheet" href="pages/assets/css/main.css" type="text/css"/>
		<link rel="stylesheet" href="pages/css/jquery-ui-1.10.4.custom.css" type="text/css" />

	</head>
	<body>
		<header id="header">
			<img alt="logotipo" src="pages/images/Logo_Blanco_Transp_mediana.png">			
		</header>

		<html:form action="LoginForm" styleId="signup-form">
			<br />
			<label><bean:message key="login.username" /></label>
			<html:text property="userName"></html:text>
			<html:errors property="userName" />
			
			<label><bean:message key="login.password" /></label>
			<html:password property="password" ></html:password>
			<html:errors property="password" />
			
			<span class="message visible failure">
				<bean:message key="login.credencialesErroneas" />
			</span>
			
			<br /><br />
			<html:submit value="Enviar" />
						
		</html:form>

		<footer id="footer">
			<ul class="copyright">
				<li>&copy;<bean:message key="ticket.footer" /></li>
				<li><a href="Ticket.do">Home</a></li>
			</ul>
		</footer>
	</body>
</html:html>