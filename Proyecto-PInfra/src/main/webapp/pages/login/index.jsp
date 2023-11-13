<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.servidor.entidades.Usuario"%>
<%@ page import="javax.servlet.http.HttpSession"%>

<%
HttpSession sessionActual = request.getSession(false); // No crear una nueva sesión si no existe
Usuario usuarioLogueado = (Usuario) sessionActual.getAttribute("usuarioLogueado");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Proyecto-PInfra/style.css">
<link rel="stylesheet" type="text/css"
	href="/Proyecto-PInfra/pages/login/style.css">
<meta name="description"
	content="Página de gestión de constancias de UTEC. Inicia sesión y ponte al día de tus constanciass.">
<meta name="viewport" content="width=device-width">
<link rel="icon" type="image/ico"
	href="/Proyecto-PInfra/utils/img/faviconapp.ico">
<title>Inicio de sesión</title>
</head>

<body>
	<div class="app">
		<!-- Encabezado de la página -->
		<header class="encabezado">
			<a class="btnHome" href="/Proyecto-PInfra/index.jsp"> <img
				class="imagenUtec" src="/Proyecto-PInfra/utils/img/utec.png"
				alt="Logo de UTEC">
			</a>
			<nav class="menu">
				<%
				if (usuarioLogueado != null) {
				%>

				<ul class="links">
					<li><a href="#">Cursos</a></li>
					<li><a href="#">Itrs</a></li>
					<li><a href="./pages/gestion/index.jsp">Gestión de
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
			<section class="loginContenido">
				<div class="columnaIzq">
					
				</div>

				<div class="columnaDer">
					<form action="/Proyecto-PInfra/Login" method="POST"
						class="formularioLogin">
						<img class="imagenapp"
							src="/Proyecto-PInfra/utils/img/logo-app.png"
							alt="Logo de la aplicación">
						<div class="">
							<h2>Iniciar sesión</h2>
							<%
							if (request.getAttribute("mensajeError") != null) {
							%>
							<p
								style="max-width: 300px; font-size: 10px; color: red; margin-top: 10px;"><%=request.getAttribute("mensajeError")%></p>
							<%
							}
							%>

						</div>
						<label> Nombre de Usuario <input type="text"
							name="nombreUsuario"
							placeholder="Ingrese su nombre de usuario...">
						</label> <label> Contraseña <input type="password" name="clave"
							placeholder="Ingrese su contraseña...">
						</label>
						<button type="submit">Ingresar</button>
						<p class="registrarse">
							¿No tienes una cuenta? <a href="../registro/index.jsp">Registrate
								aquí</a>
						</p>
					</form>
				</div>
			</section>
		</main>

		<!-- Pie de página -->
		<footer class="pieDePagina">
			<p>Creado por</p>
			<img class="imagenEquipo"
				src="/Proyecto-PInfra/utils/img/error404.png" alt="Logo de Error404">
		</footer>
	</div>
</body>

</html>