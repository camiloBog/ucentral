<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html>
<head>
	<title>TicketSeller Hangar-Config</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	

	<link href="pages/css/bootstrap.css" rel="stylesheet">
	<link href="pages/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<link href="pages/css/ticketSeller.css" rel="stylesheet">

	<script src="pages/js/jquery.min.js"></script>
	<script src="pages/js/bootstrap.js"></script>
	<script type="text/javascript" src="pages/js/move-top.js"></script>
	<script type="text/javascript" src="pages/js/easing.js"></script>

	<link
		href='http://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700,300italic,400italic,500italic,700italic'
		rel='stylesheet' type='text/css'>
	<link
		href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,700,300,600,800,400'
		rel='stylesheet' type='text/css'>
	
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event) {
				event.preventDefault();
				$('html,body').animate({
					scrollTop : $(this.hash).offset().top
				}, 900);
			});
		});
	</script>

</head>
<body>

	
	<header>
		<div class="services">
		<h3>Hangar Config</h3>
			<div class="container">
								
				<div class="logo">
					<a href="Ticket.do">
					<img src="pages/images/Logo_Negro_mediana.png" alt="logo" /></a>
				</div>
								
			</div>
		</div>
	</header>

	<div class="grid_3 grid_5">

		<div class="bs-example bs-example-tabs" role="tabpanel"
			data-example-id="togglable-tabs">

			<!--  COFIGURACION DE PESTAÑAS -->
			<ul id="myTab" class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a href="#aeropuertos" id="aeropuertos-tab" role="tab" data-toggle="tab" aria-controls="aeropuertos" aria-expanded="true">Aeropuertos</a></li>
				<li role="presentation" class="deactive"><a href="#clases" role="tab" id="clases-tab2" data-toggle="tab" aria-controls="clases" aria-expanded="false">Clases</a></li>
				<li role="presentation" class="deactive"><a href="#aviones" role="tab" id="aviones-tab3" data-toggle="tab" aria-controls="aviones" aria-expanded="false">Aviones</a></li>
				<li role="presentation" class="deactive"><a href="#sesiones" role="tab" id="sesiones-tab4" data-toggle="tab" aria-controls="sesiones" aria-expanded="false">Sesiones</a></li>
			<!-- 
				<li role="presentation" class="deactive"><a href="#usuarios" role="tab" id="usuarios-tab4" data-toggle="tab" aria-controls="usuarios" aria-expanded="false">Usuarios</a></li>
			 -->
			</ul>

			<div id="myTabContent" class="tab-content">
				
				<!--  PESTAÑA AEROPUERTOS -->
				<div role="tabpanel" class="tab-pane fade active in" id="aeropuertos" aria-labelledby="aeropuertos-tab">
					
					<div class="forma-config">
						<html:form action="HangarConfigForm">
						
							
							<label><bean:message key="config.aerop.country" /></label>
							<html:select property="paises">
								<html:optionsCollection property="paisesLista" 
									label="nombre" value="idPais"/>
							</html:select>
							
							<label><bean:message key="config.aerop.city" /></label>
							<html:select property="ciudades">
								<html:optionsCollection property="ciudadesLista" 
									label="nombre" value="idCiudad"/>
							</html:select>
						
							
						
						
						
						
							<label><bean:message key="config.aerop.country" /></label>
							<html:text property="country"></html:text>
							<html:errors property="country" />
							
							<label><bean:message key="config.aerop.city" /></label>
							<html:text property="city"></html:text>
							<html:errors property="city" />
							
							<label><bean:message key="config.aerop.name" /></label>
							<html:text property="name"></html:text>
							<html:errors property="name" />
							
							<label><bean:message key="config.aerop.iata" /></label>
							<html:text property="iata"></html:text>
							<html:errors property="iata" />
							
							<html:submit value="Guardar" />
						</html:form>
					</div>
<!-- 					
					<div class="forma-config">
						<form action="post">
							<label>Pais</label><input type="text" name="ap-pais" id="pais" placeholder="Pais"/>
							<label>Ciudad</label><input type="text" name="ap-ciudad" id="ciudad" placeholder="Ciudad"/>
							<label>Nombre</label><input type="text" name="ap-nombre" id="nombre" placeholder="Nombre"/>
							<label>Codigo</label><input type="text" name="ap-codigo" id="codigo" placeholder="Codigo IATA"/>
							<input type="submit" value="Buscar" />
							<input type="submit" value="Guardar" />
						</form>
					</div>
 -->					
					<div class="page-header"></div>
			        
			        <div class="bs-docs-example">
			            <table class="table table-hover">
			              <thead>
			                <tr>
			                  <th>#</th>
			                  <th>Pais</th>
			                  <th>Ciudad</th>
			                  <th>Nombre</th>
			                  <th>Codigo</th>
			                  <th></th>
			                </tr>
			              </thead>
			              <tbody>
			                <tr>
			                  <td>1</td>
			                  <td>Colombia</td>
			                  <td>Bogota</td>
			                  <td>Eldorado Intl</td>
			                  <td>BOG</td>
			                  <td><input class="grid-button" type="button" value="Eliminar"/></td>
			                </tr>
			                <tr>
			                  <td>2</td>
			                  <td>United States</td>
			                  <td>Los Angeles</td>
			                  <td>Los Angeles Intl</td>
			                  <td>LAX</td>
			                  <td><input class="grid-button" type="button" value="Eliminar"/></td>
			                </tr>
			                <tr>
			                  <td>3</td>
			                  <td>United States</td>
			                  <td>New York</td>
			                  <td>John F Kennedy Intl</td>
			                  <td>JFK</td>
			                  <td><input class="grid-button" type="button" value="Eliminar"/></td>
			                </tr>
			                <tr>
			                  <td>4</td>
			                  <td>Peru</td>
			                  <td>Lima</td>
			                  <td>Jorge Chavez Intl</td>
			                  <td>LIM</td>
			                  <td><input class="grid-button" type="button" value="Eliminar"/></td>
			                </tr>
			                <tr>
			                  <td>5</td>
			                  <td>Japan</td>
			                  <td>Tokyo</td>
			                  <td>Narita Intl</td>
			                  <td>NRT</td>
			                  <td><input class="grid-button" type="button" value="Eliminar"/></td>
			                </tr>
			              </tbody>
			            </table>
			          </div>
									
				</div> 
				
				
				
				<!--  PESTAÑA CLASES DE TURISTA -->
				<div role="tabpanel" class="tab-pane fade" id="clases" aria-labelledby="clases-tab2">
					<div class="forma-config">
						<form action="post">
							<label>Clase de Turista</label><input type="text" name="c-clase" id="c-clase" placeholder="Clase de Turista"/>
							<label>Descripcion</label><input type="text" name="c-descri" id="c-descri" placeholder="Descripcion"/>
							<input type="submit" value="Buscar" />
							<input type="submit" value="Guardar" />
						</form>
					</div>
					
					<div class="page-header"></div>
			        
			        <div class="bs-docs-example">
			            <table class="table table-hover">
			              <thead>
			                <tr>
			                  <th>#</th>
			                  <th>Clase</th>
			                  <th>Descripcion</th>
			                  <th></th>
			                </tr>
			              </thead>
			              <tbody>
			                <tr>
			                  <td>1</td>
			                  <td>Economica</td>
			                  <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</td>
			                  <td><input class="grid-button" type="button" value="Eliminar"/></td>
			                </tr>
			                <tr>
			                  <td>2</td>
			                  <td>Estudiante</td>
			                  <td>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. </td>
			                  <td><input class="grid-button" type="button" value="Eliminar"/></td>
			                </tr>
			                <tr>
			                  <td>3</td>
			                  <td>Ejecutiva</td>
			                  <td>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium.</td>
			                  <td><input class="grid-button" type="button" value="Eliminar"/></td>
			                </tr>
			              </tbody>
			            </table>
			          </div>
					
				</div>
				
				<!--  PESTAÑA AVIONES -->
				<div role="tabpanel" class="tab-pane fade" id="aviones" aria-labelledby="aviones-tab3">
					<div class="forma-config">
						<form action="post">
							<label>Avion</label><input type="text" name="av-avion" id="av-avion" placeholder="Id. Avion"/>
							<label>Modelo</label><input type="text" name="av-modelo" id="av-modelo" placeholder="Modelo"/>
							<label>Asientos</label><input type="text" name="ap-asientos" id="ap-asientos" placeholder="Asientos"/>
							<input type="submit" value="Buscar" />
							<input type="submit" value="Guardar" />
						</form>
					</div>
					
					<div class="page-header"></div>
			        
			        <div class="bs-docs-example">
			            <table class="table table-hover">
			              <thead>
			                <tr>
			                  <th>#</th>
			                  <th>Avion</th>
			                  <th>Modelo</th>
			                  <th>Asientos</th>
			                  <th></th>
			                </tr>
			              </thead>
			              <tbody>
			                <tr>
			                  <td>1</td>
			                  <td>TS-B747-1</td>
			                  <td>Boeing 747</td>
			                  <td>416</td>
			                  <td><input class="grid-button" type="button" value="Eliminar"/></td>
			                </tr>
			                <tr>
			                  <td>2</td>
			                  <td>TS-B777-2</td>
			                  <td>Boeing 777</td>
			                  <td>300</td>
			                  <td><input class="grid-button" type="button" value="Eliminar"/></td>
			                </tr>
			                <tr>
			                  <td>3</td>
			                  <td>TS-AB340-3</td>
			                  <td>Airbus A340</td>
			                  <td>496</td>
			                  <td><input class="grid-button" type="button" value="Eliminar"/></td>
			                </tr>
			                <tr>
			                  <td>4</td>
			                  <td>TS-B767-4</td>
			                  <td>Boeing 767</td>
			                  <td>343</td>
			                  <td><input class="grid-button" type="button" value="Eliminar"/></td>
			                </tr>
			                <tr>
			                  <td>5</td>
			                  <td>TS-MD80-5</td>
			                  <td>McDonnell Douglas MD-80</td>
			                  <td>550</td>
			                  <td><input class="grid-button" type="button" value="Eliminar"/></td>
			                </tr>
			              </tbody>
			            </table>
			          </div>
								
				</div>
				
				<div role="tabpanel" class="tab-pane fade" id="sesiones" aria-labelledby="sesiones-tab4">
					<div class="forma-config">
						<form id="SessionWiew" action="SessionView" method="post">
							<input type="submit" value="Ver Sesiones Activas" />
						</form>
					</div>
				</div>
				
				
			</div>
		</div>
	</div>
</body>
</html:html>