<%@page import="com.servidor.entidades.Usuario"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
HttpSession sessionActual = request.getSession(false); // No crear una nueva sesión si no existe
Usuario usuarioLogueado = (Usuario) sessionActual.getAttribute("usuarioLogueado");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="../../style.css">
<meta name="description"
	content="Página de gestión de constancias de UTEC. Inicia sesión y ponte al día de tus constanciass.">
<meta name="viewport" content="width=device-width">
<link rel="icon" type="image/ico" href="../../utils/img/faviconapp.ico">
<title>Registro</title>
</head>

<body>
	<div class="app">
		<!-- Encabezado de la página -->
		<header class="encabezado">
			<a class="btnHome" href="../../index.jsp"> <img
				class="imagenUtec" src="../../utils/img/utec.png" alt="Logo de UTEC">
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
			<!-- Mostrar nombre de usuario y botón de cerrar sesión -->
			<div class="btnSesion">
				<p style="font-size: 12px; font-weight: bold;"><%=usuarioLogueado.getNombreUsuario()%></p>
				<a href="/Proyecto-PInfra/CerrarSesion">Cerrar sesión</a>
			</div>
			<%
			} else {
			%>
			<!-- Mostrar enlaces de inicio de sesión y registro -->
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
			<section class="registroContenido">
				<div class="columnaIzq">
					<h2 class="tituloRegistro">Registro</h2>
					<form class="formularioLogin">
						<div class="formularioContenido">
							<label>Nombres <input type="text" name="nombres"
								placeholder="Ingrese sus nombres...">
							</label> <label>Apellidos <input type="text" name="apellidos"
								placeholder="Ingrese sus apellidos...">
							</label> <label>Cédula <input type="number" name="cedula"
								placeholder="Ingrese su cédula...">
							</label> <label>Teléfono <input type="number" name="telefono"
								placeholder="Ingrese su teléfono...">
							</label> <label>Mail Personal <input type="text"
								name="mailPersonal" placeholder="Ingrese su mail personal...">
							</label> <label>Mail Institucional <input type="text"
								name="mailInstitucional"
								placeholder="Ingrese su mail institucional...">
							</label> <label>Contraseña <input type="password"
								name="contrasenia" placeholder="Ingrese su contraseña...">
							</label> <label>Fecha de Nacimiento <input type="text"
								name="fechaNacimeinto"
								placeholder="Ingrese su fecha de nacimiento...">
							</label> <label>Género <select name="genero">
									<option selected>Selecciona un género</option>
							</select>
							</label> <label>ITR <select name="itr">
									<option selected>Selecciona un ITR</option>
							</select>
							</label> <label>Departamento <select name="departamento">
									<option selected>Selecciona un departamento</option>
							</select>
							</label> <label>Localidad <select name="localidad">
									<option selected>Selecciona una localidad</option>
							</select>
							</label>
						</div>

						<div class="btnContenido">
							<button type="submit">Registrarme</button>
							<p class="loguearse">
								¿Ya tienes una cuenta? <a href="../login/index.jsp">Inicia
									sesión aquí</a>
							</p>
						</div>
					</form>

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