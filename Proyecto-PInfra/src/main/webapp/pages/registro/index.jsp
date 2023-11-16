<%@page import="com.cliente.services.ServiceArea"%>
<%@page import="com.servidor.entidades.Area"%>
<%@page import="com.cliente.services.ServiceRol"%>
<%@page import="com.servidor.entidades.Rol"%>
<%@page import="com.cliente.services.ServiceItr"%>
<%@page import="com.cliente.services.ServiceUbicacion"%>
<%@page import="com.servidor.entidades.Itr"%>
<%@page import="com.servidor.entidades.Departamento"%>
<%@page import="com.servidor.entidades.Localidad"%>
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
<link rel="stylesheet" type="text/css" href="/Proyecto-PInfra/style.css">
<link rel="stylesheet" type="text/css"
	href="/Proyecto-PInfra/pages/registro/style.css">
<meta name="description"
	content="Página de gestión de constancias de UTEC. Inicia sesión y ponte al día de tus constanciass.">
<meta name="viewport" content="width=device-width">
<link rel="icon" type="image/ico"
	href="/Proyecto-PInfra/utils/img/faviconapp.ico">
<title>Registro</title>
</head>

<body>
	<div class="app">
		<!-- Encabezado de la página -->
		<jsp:include page="/components/layout/nav/index.jsp" />

		<!-- Contenido de la página -->
		<main class="contenido">
			<!-- Modificar a gusto -->
			<section class="registroSeccion">
				<div class="registroContenido">
					<h2 class="tituloRegistro">Registro</h2>
					<form class="formularioLogin"
						action="/Proyecto-PInfra/SvCrearUsuario" method="post">
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
							</label> <label>Contraseña <input type="password" name="clave"
								placeholder="Ingrese su contraseña...">
							</label> <label>Fecha de Nacimiento <input type="text"
								name="fechaNacimiento"
								placeholder="Ingrese su fecha de nacimiento...">
							</label> <label>Género <select name="genero">
									<option selected>Selecciona un género</option>
									<option value="Femenino">Femenino</option>
									<option value="Masculino">Masculino</option>
									<option value="Otro">Otro</option>
							</select>
							</label> <label>ITR <select name="itr">
									<option selected>Selecciona un ITR</option>
									<%
									for (Itr oItr : ServiceItr.listarItrs()) {
									%>

									<option value="<%=oItr.getNombre()%>"><%=oItr.getNombre()%></option>

									<%
									}
									%>
							</select>
							</label> <label>Departamento <select name="departamento"
								id="departamentoSelect" onchange="cargarLocalidades()">
									<option selected>Selecciona un departamento</option>
									<%
									for (Departamento oDepartamento : ServiceUbicacion.listarDepartamentos()) {
									%>
									<option value="<%=oDepartamento.getNombre()%>"><%=oDepartamento.getNombre()%></option>
									<%
									}
									%>
							</select>
							</label> <label>Localidad <select name="localidad"
								id="localidadSelect" disabled>
									<option selected>Selecciona una localidad</option>
							</select>
							</label> <label>Rol <select name="rol" id="rolSelect"
								onchange="mostrarCampos()">
									<option selected>Seleccione su rol</option>
									<%
									for (Rol oRol : ServiceRol.listarRoles()) {
									%>

									<option value="<%=oRol.getDescripcion()%>"><%=oRol.getDescripcion()%></option>


									<%
									}
									%>
							</select>
							</label> <label id="areaLabel" style="display: none;">Área <select
								name="area">
									<option selected>Seleccione su área</option>
									<%
									for (Area oArea : ServiceArea.listarAreas()) {
									%>

									<option value="<%=oArea.getDescripcion()%>"><%=oArea.getDescripcion()%></option>


									<%
									}
									%>
							</select>
							</label> <label id="semestreLabel" style="display: none;">Semestre
								<select name="semestre">
									<option selected>Seleccione su semestre</option>
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
							</select>
							</label> <label id="generacionLabel" style="display: none;">Generación
								<select name="generacion">
									<option selected>Seleccione su generación</option>
									<option value="2016">2016</option>
									<option value="2017">2017</option>
									<option value="2018">2018</option>
									<option value="2019">2019</option>
									<option value="2020">2020</option>
									<option value="2021">2021</option>
									<option value="2022">2022</option>
									<option value="2023">2023</option>
							</select>
							</label>
						</div>

						<div class="btnContenido">
							<button type="submit">Registrarme</button>
							<p class="loguearse">
								¿Ya tienes una cuenta? <a
									href="/Proyecto-PInfra/pages/login/index.jsp">Inicia sesión
									aquí</a>
							</p>
						</div>
					</form>

				</div>
			</section>
		</main>

		<!-- Pie de página -->
		<jsp:include page="/components/layout/footer/index.jsp" />
	</div>
</body>
<script src="/Proyecto-PInfra/utils/script/localidades.js"></script>
<script src="/Proyecto-PInfra/utils/script/mostrarCampos.js"></script>
</html>