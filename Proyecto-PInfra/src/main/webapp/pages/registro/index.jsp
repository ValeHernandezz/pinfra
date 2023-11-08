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
<link rel="icon" type="image/ico" href="../../utils/img/favicon.ico">
<title>Registro</title>
</head>

<body>
	<!-- Encabezado de la página -->
	<header class="encabezado">
		<a class="btnHome" href="../../index.html"> <img
			class="imagenUtec" src="../../utils/img/utec.png" alt="Logo de UTEC">
		</a>
		<nav class="menu">
			<ul class="links">
				<li><a href="#">Cursos</a></li>
				<li><a href="#">Itrs</a></li>
				<li><a href="#">Sobre nosotros</a></li>
				<!--Temporal mientras
				maquetamos el apartado va a estar visible siempre-->
				<li><a href="../gestion/index.jsp">Gestión de usuarios</a></li>
				<!--Temporal mientras
				maquetamos el apartado va a estar visible siempre-->
			</ul>

			<div class="btnSesion">
				<a href="../login/index.jsp">Iniciar sesión</a> <a
					href="./index.jsp">Registrarme</a>
			</div>
		</nav>
	</header>

	<!-- Contenido de la página -->
	<main class="contenido">
		<!-- Modificar a gusto -->
		<section class="loginContenido">
			<div class="columnaIzq">
					<h2>Registro</h2>
				<form class="formularioLogin">
					<label>Nombres<input type="text" name="nombres"
						placeholder="Ingrese sus nombres...">
					</label> <label>Apellidos<input type="text" name="apellidos"
						placeholder="Ingrese sus apellidos...">
					</label> <label>Cédula<input type="number" name="cedula"
						placeholder="Ingrese su cédula...">
					</label> <label>Teléfono<input type="number" name="telefono"
						placeholder="Ingrese su teléfono...">
					</label> <label>Mail Personal<input type="text" name="mailPersonal"
						placeholder="Ingrese su mail personal...">
					</label> <label>Mail Institucional<input type="text"
						name="mailInstitucional"
						placeholder="Ingrese su mail institucional...">
					</label> <label>Contraseña<input type="password" name="contrasenia"
						placeholder="Ingrese su contraseña...">
					</label>
					<label>Fecha de Nacimiento<input type="text"
						name="fechaNacimeinto"
						placeholder="Ingrese su fecha de nacimiento...">
					</label>
					<label>Género
						<select name="genero">
							<option selected>Selecciona un género</option>
						</select>
					</label>
					<label>ITR<select name="itr">
						<option selected>Selecciona un ITR</option>
					</select></label>
					<label>Departamento<select name="departamento">
						<option selected>Selecciona un departamento</option>
					</select></label>
					<label>Localidad<select name="localidad">
						<option selected>Selecciona una localidad</option>
					</select></label>


					<button type="submit">Registrarme</button>
					<p class="loguearse">
						¿Ya tienes una cuenta? <a href="../login/index.jsp">Inicia
							sesión aquí</a>
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
</body>

</html>