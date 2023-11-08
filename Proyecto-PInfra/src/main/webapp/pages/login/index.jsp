<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Tenemos dos hojas de estilo porque mantenmos el estilo y propocion del header, main y footer -->
<!-- Creemos contenido dentro del main con clases personalizadas -->
<!-- pero solo las utilizamos en la hoja de estilo que este en la misma carpeta que este archivo -->
<!-- Nos ayuda a tener más organizado el .css y no todo en un mismo archivo jajaja -->
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" type="text/css" href="../../style.css">
<meta name="description"
	content="Página de gestión de constancias de UTEC. Inicia sesión y ponte al día de tus constanciass.">
<meta name="viewport" content="width=device-width">
<link rel="icon" type="image/ico" href="../../utils/img/faviconapp.ico">
<title>Inicio de sesión</title>
</head>

<body>
	<div class="app">
		<!-- Encabezado de la página -->
		<header class="encabezado">
			<a class="btnHome" href="../../index.html"> <img
				class="imagenUtec" src="../../utils/img/utec.png" alt="Logo de UTEC">
			</a>
			<nav class="menu">
				<ul class="links">
					<li><a href="#">Cursos</a></li>
					<li><a href="#">Itrs</a></li>
					<!--Temporal mientras
				maquetamos el apartado va a estar visible siempre-->
					<li><a href="../gestion/index.jsp">Gestión de usuarios</a></li>
					<!--Temporal mientras
				maquetamos el apartado va a estar visible siempre-->
				</ul>

				<div class="btnSesion">
					<a href="./index.jsp">Iniciar sesión</a> <a
						href="../registro/index.jsp">Registrarme</a>
				</div>
			</nav>
		</header>

		<!-- Contenido de la página -->
		<main class="contenido">
			<!-- Modificar a gusto -->
			<section class="loginContenido">
				<div class="columnaIzq">
					<div class="bannerLogin">
						<div class="eslogan">
							<h2>Gestión de Constancias UTEC</h2>
							<p>La puerta a tus constancias, a solo un clic de distancia.</p>
						</div>
					</div>
				</div>

				<div class="columnaDer">
					<form class="formularioLogin">
						<img class="imagenapp" src="../../utils/img/logo-app.png"
							alt="Logo de la aplicación">
						<h2>Iniciar sesión</h2>
						<label> Nombre de Usuario <input type="text"
							name="usuario" placeholder="Ingrese su nombre de usuario...">
						</label> <label> Contraseña <input type="password"
							name="contrasenia" placeholder="Ingrese su contraseña...">
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
			<img class="imagenEquipo" src="../../utils/img/error404.png"
				alt="Logo de Error404">
		</footer>
	</div>
</body>

</html>