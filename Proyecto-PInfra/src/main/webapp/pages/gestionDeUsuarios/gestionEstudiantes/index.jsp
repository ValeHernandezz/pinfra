<%@page import="com.cliente.services.ServiceEstudiante"%>
<%@page import="com.servidor.entidades.Estudiante"%>
<%@page import="java.util.ArrayList"%>
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
	href="/Proyecto-PInfra/pages/gestionDeUsuarios/gestionEstudiantes/style.css">
<meta name="description"
	content="Página de gestión de constancias de UTEC. Crea tus usuarios y gestionalos de una manera sencilla.">
<meta name="viewport" content="width=device-width">
<link rel="icon" type="image/ico"
	href="/Proyecto-PInfra/utils/img/faviconapp.ico">
<title>Gestión de estudiantes</title>
</head>

<body>
	<div class="app">

		<!-- Encabezado de la página -->
		<jsp:include page="/components/layout/nav/index.jsp" />

		<!-- Contenido de la página -->
		<main class="contenido">
			<!-- Modificar a gusto -->
			<section class="gestionContenido">
				<h2>Lista de Estudiantes</h2>

				<div class="tableContenido">
					<table>
						<thead>
							<tr>
								<th class="comienzo">Cédula</th>
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
								<th class="fin">Acciones</th>
							</tr>
						</thead>
						<tbody>
							<%
							ArrayList<Estudiante> listaDeEstudiantes = ServiceEstudiante
									.listarEstudiantes();
							if (listaDeEstudiantes == null) {
								return;
							}
							for (Estudiante oEstudiante : listaDeEstudiantes) {
							%>
							<tr>
								<td><%=oEstudiante.getUsuario().getDocumento()%></td>
								<td><%=oEstudiante.getUsuario().getNombres()%></td>
								<td><%=oEstudiante.getUsuario().getApellidos()%></td>
								<td><%=oEstudiante.getUsuario().getMailPersonal()%></td>
								<td><%=oEstudiante.getUsuario().getMailInstitucional()%></td>
								<td><%=oEstudiante.getUsuario().getGenero().getNombre()%></td>
								<td><%=oEstudiante.getUsuario().getDepartamento().getNombre()%></td>
								<td><%=oEstudiante.getUsuario().getLocalidad().getNombre()%></td>
								<td><%=oEstudiante.getUsuario().getItr().getNombre()%></td>
								<td><%=oEstudiante.getUsuario().getTelefono()%></td>
								<td><%=oEstudiante.getUsuario().getFechaNacimiento()%></td>
								<td>
									<div>
										<form name="editar" action="/Proyecto-PInfra/SvEditarUsuario"
											method="GET">
											<button class="btnEditar" type="submit">
												<svg xmlns="http://www.w3.org/2000/svg"
													class="icon icon-tabler icon-tabler-edit" width="20"
													height="20" viewBox="0 0 24 24" stroke-width="2"
													stroke="currentColor" fill="none" stroke-linecap="round"
													stroke-linejoin="round">
													<path stroke="none" d="M0 0h24v24H0z" fill="none" />
													<path
														d="M7 7h-1a2 2 0 0 0 -2 2v9a2 2 0 0 0 2 2h9a2 2 0 0 0 2 -2v-1" />
													<path
														d="M20.385 6.585a2.1 2.1 0 0 0 -2.97 -2.97l-8.415 8.385v3h3l8.385 -8.415z" />
													<path d="M16 5l3 3" /></svg>
											</button>
											<input type="hidden" name="cedula"
												value="<%=oEstudiante.getUsuario().getDocumento()%>">
										</form>
										<form name="eliminar"
											action="/Proyecto-PInfra/SvEliminarUsuario" method="POST">
											<button class="btnEliminar" type="submit">
												<svg xmlns="http://www.w3.org/2000/svg"
													class="icon icon-tabler icon-tabler-trash-x-filled"
													width="20" height="20" viewBox="0 0 24 24" stroke-width="2"
													stroke="currentColor" fill="none" stroke-linecap="round"
													stroke-linejoin="round">
													<path stroke="none" d="M0 0h24v24H0z" fill="none" />
													<path
														d="M20 6a1 1 0 0 1 .117 1.993l-.117 .007h-.081l-.919 11a3 3 0 0 1 -2.824 2.995l-.176 .005h-8c-1.598 0 -2.904 -1.249 -2.992 -2.75l-.005 -.167l-.923 -11.083h-.08a1 1 0 0 1 -.117 -1.993l.117 -.007h16zm-9.489 5.14a1 1 0 0 0 -1.218 1.567l1.292 1.293l-1.292 1.293l-.083 .094a1 1 0 0 0 1.497 1.32l1.293 -1.292l1.293 1.292l.094 .083a1 1 0 0 0 1.32 -1.497l-1.292 -1.293l1.292 -1.293l.083 -.094a1 1 0 0 0 -1.497 -1.32l-1.293 1.292l-1.293 -1.292l-.094 -.083z"
														stroke-width="0" fill="currentColor" />
													<path
														d="M14 2a2 2 0 0 1 2 2a1 1 0 0 1 -1.993 .117l-.007 -.117h-4l-.007 .117a1 1 0 0 1 -1.993 -.117a2 2 0 0 1 1.85 -1.995l.15 -.005h4z"
														stroke-width="0" fill="currentColor" /></svg>
											</button>
											<input type="hidden" name="idUsuario"
												value="<%=oEstudiante.getUsuario().getIdUsuario()%>">
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
		<jsp:include page="/components/layout/footer/index.jsp" />
	</div>
</body>

</html>