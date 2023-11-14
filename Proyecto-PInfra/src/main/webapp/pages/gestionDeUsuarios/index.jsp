<%@page import="com.cliente.services.ServiceUsuario"%>
<%@page import="com.servidor.entidades.Usuario"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
HttpSession sessionActual = request.getSession(false); // No crear una nueva sesión si no existe
Usuario usuarioLogueado = (Usuario) sessionActual
		.getAttribute("usuarioLogueado");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./style.css">
<link rel="stylesheet" type="text/css" href="../../style.css">
<meta name="description"
	content="Página de gestión de constancias de UTEC. Crea tus usuarios y gestionalos de una manera sencilla.">
<meta name="viewport" content="width=device-width">
<link rel="icon" type="image/ico" href=../../utils/img/faviconapp.ico>
<title>Gestión de usuarios</title>
</head>

<body>
	<div class="app">

		<!-- Encabezado de la página -->
		<header class="encabezado">
			<a class="btnHome" href="../../index.jsp"> <img
				class="imagenUtec" src="../..//utils/img/utec.png"
				alt="Logo de UTEC">
			</a>
			<nav class="menu">
				<%
				if (usuarioLogueado != null) {
				%>

				<ul class="links">
					<li><a href="#">Cursos</a></li>
					<li><a href="#">Itrs</a></li>
					<li><a href="./pages/gestionDeUsuarios/index.jsp">Gestión de
							usuarios</a></li>
				</ul>

				<%
				}
				%>
			</nav>
			<%
			if (usuarioLogueado != null) {
			%>
			<div class="btnSesion">
				<p style="font-size: 12px; font-weight: bold;"><%=usuarioLogueado.getNombreUsuario()%></p>
				<a href="/Proyecto-PInfra/CerrarSesion">Cerrar sesión</a>
			</div>
			<%
			} else {
			%>
			<div class="btnSesion">
				<a href="/Proyecto-PInfra/pages/login/index.jsp">Iniciar sesión</a>
				<a href="/Proyecto-PInfra/pages/registro/index.jsp">Registrarme</a>
			</div>
			<%
			}
			%>

		</header>

		<!-- Contenido de la página -->
		<main class="contenido">
			<!-- Modificar a gusto -->
			<section class="gestionContenido">
				<br>
				<h2>Gestión de Usuarios</h2>
				
				<div>
					<table>
						<thead>
							<tr>
								<th>Cédula</th>
								<th>Nombres</th>
								<th>Apellidos</th>
								<th>Mail Personal</th>
								<th>Mail Institucional</th>
								<th>Género</th>
								<th>Departamento</th>
								<th>Localidad</th>
								<th>ITR</th>
								<th>Teléfono</th>
								<th>Fecha de Nacimiento</th>
								<th>Rol</th>
								<th>Acciones</th>					
							</tr>
						</thead>
						<tbody>
							<%
							for(Usuario oUsuario : ServiceUsuario.listarUsuarios()) {
							%>
							<tr>	
								<td ><%=oUsuario.getDocumento() %></td>	
								<td><%=oUsuario.getNombres() %></td>
								<td><%=oUsuario.getApellidos() %></td>
								<td><%=oUsuario.getMailPersonal() %></td>
								<td><%=oUsuario.getMailInstitucional() %></td>
								<td><%=oUsuario.getGenero().getNombre() %></td>
								<td><%=oUsuario.getDepartamento().getNombre() %></td>
								<td><%=oUsuario.getLocalidad().getNombre() %></td>
								<td><%=oUsuario.getItr().getNombre() %></td>
								<td><%=oUsuario.getTelefono() %></td>
								<td><%=oUsuario.getFechaNacimiento() %></td>
								<td><%=oUsuario.getRol().getDescripcion() %></td>
								<td>
									<div>
										<form name="editar" action="/Proyecto-PInfra/SvEditarUsuario" method="GET">
											<button type="submit">Editar</button>
											<input type="hidden" name="cedula" value="<%=oUsuario.getDocumento()%>">										
										</form>
										<form name="eliminar" action="/Proyecto-PInfra/SvEliminarUsuario" method="POST">
											<button type="submit">Eliminar</button>
											<input type="hidden" name="idUsuario" value="<%=oUsuario.getIdUsuario()%>">						
										</form>
									</div>
								</td>		
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				
				</div>

			</section>
		</main>

		<!-- Pie de página -->
		<footer class="pieDePagina">
			<p>Creado por</p>
			<img class="imagenEquipo" src="../../utils/img/error404.png"
				alt="Logo de Error404">
		</footer>
	</div>
</body>

</html>