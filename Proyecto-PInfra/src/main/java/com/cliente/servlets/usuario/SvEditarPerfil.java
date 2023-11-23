package com.cliente.servlets.usuario;

import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cliente.contexto.Fabrica;
import com.cliente.contexto.helpers.Actualizar;
import com.cliente.contexto.helpers.Buscar;
import com.cliente.services.ServiceArea;
import com.cliente.services.ServiceGenero;
import com.cliente.services.ServiceItr;
import com.cliente.services.ServiceJWT;
import com.cliente.services.ServiceUbicacion;
import com.servidor.entidades.Analista;
import com.servidor.entidades.Departamento;
import com.servidor.entidades.Estudiante;
import com.servidor.entidades.Genero;
import com.servidor.entidades.Itr;
import com.servidor.entidades.Localidad;
import com.servidor.entidades.Tutor;
import com.servidor.entidades.Usuario;

@WebServlet(name = "ServletEditarPerfil", urlPatterns = "/SvEditarPerfil")
public class SvEditarPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ServiceJWT.validarToken(request, response)) {
			response.sendRedirect("/Proyecto-PInfra/pages/login/index.jsp");
			return;
		}

		request.setCharacterEncoding("UTF-8");

		String nombres = request.getParameter("nombres");
		String apellidos = request.getParameter("apellidos");
		String telefono = request.getParameter("telefono");
		String mailPersonal = request.getParameter("mailPersonal");
		String clave = request.getParameter("clave");
		String fechaNacimiento = request.getParameter("fechaNacimiento");
		String generoTexto = request.getParameter("genero");
		String itrTexto = request.getParameter("itr");
		String departamentoTexto = request.getParameter("departamento");
		String localidadTexto = request.getParameter("localidad");

		String nombres2[] = nombres.split(" ");
		String apellidos2[] = apellidos.split(" ");

		String primerNombre = nombres2.length > 0 ? nombres2[0] : "";
		String segundoNombre = nombres2.length > 1 ? nombres2[1] : "";

		String primerApellido = apellidos2.length > 0 ? apellidos2[0] : "";
		String segundoApellido = apellidos2.length > 1 ? apellidos2[1] : "";

		Usuario oUsuarioEditado = (Usuario) request.getSession().getAttribute("usuarioLogueado");

		String nombreUsuario = Fabrica.generarNombreUsuario(oUsuarioEditado.getMailInstitucional());

		Departamento departamento = ServiceUbicacion.listarDepartamentosFiltro(departamentoTexto).get(0);
		Genero genero = ServiceGenero.listarGenerosFiltro(generoTexto).get(0);
		Itr itr = ServiceItr.listarItrsFiltro(itrTexto).get(0);
		Localidad localidad = ServiceUbicacion.listarLocalidadesFiltro(localidadTexto).get(0);

		Usuario oUsuarioNuevo = new Usuario(clave, oUsuarioEditado.getDocumento(),
				Fabrica.getFechaDesdeString(fechaNacimiento), oUsuarioEditado.getMailInstitucional(), mailPersonal,
				nombreUsuario, primerApellido, primerNombre, segundoApellido, segundoNombre, telefono, "S", "S",
				departamento, genero, itr, localidad, oUsuarioEditado.getRol());

		oUsuarioNuevo.setIdUsuario(oUsuarioEditado.getIdUsuario());

		if (oUsuarioEditado.getRol().getDescripcion().equals("Analista")) {
			Analista oAnalistaAntiguo = Buscar.analistaFiltro(oUsuarioEditado.getDocumento().toString(), "Documento")
					.get(0);

			boolean oAnalistaEditado = Actualizar.usuario(oUsuarioNuevo, oAnalistaAntiguo);
			request.getSession().removeAttribute("usuarioLogueado");

			var oUsuarioActualizado = Fabrica
					.buscarUsuarioPorCampoYFiltro(oUsuarioEditado.getDocumento().toString(), "Documento").get(0);

			request.getSession().setAttribute("usuarioLogueado", oUsuarioActualizado);
			response.sendRedirect("/Proyecto-PInfra/pages/perfil/index.jsp");
			return;
		}

		if (oUsuarioEditado.getRol().getDescripcion().equals("Tutor")
				|| oUsuarioEditado.getRol().getDescripcion().equals("Encargado")) {
			String areaTexto = request.getParameter("area");

			boolean oTutorEditado = Actualizar.usuario(oUsuarioNuevo, new Tutor(
					Buscar.tutorFiltro(oUsuarioEditado.getDocumento().toString(), "Documento").get(0).getIdTutor(),
					ServiceArea.listarAreasFiltro(areaTexto).get(0), oUsuarioNuevo));
			request.getSession().removeAttribute("usuarioLogueado");

			var oUsuarioActualizado = Fabrica
					.buscarUsuarioPorCampoYFiltro(oUsuarioEditado.getDocumento().toString(), "Documento").get(0);

			request.getSession().setAttribute("usuarioLogueado", oUsuarioActualizado);
			response.sendRedirect("/Proyecto-PInfra/pages/perfil/index.jsp");
			return;
		}

		if (oUsuarioEditado.getRol().getDescripcion().equals("Estudiante")) {
			String semestreTexto = request.getParameter("semestre");
			String generacionTexto = request.getParameter("generacion");
			boolean oEstudianteEditado = Actualizar
					.usuario(oUsuarioNuevo,
							new Estudiante(
									Buscar.estudianteFiltro(oUsuarioEditado.getDocumento().toString(), "Documento")
											.get(0).getIdEstudiante(),
									generacionTexto, new BigDecimal(semestreTexto), oUsuarioNuevo));
			request.getSession().removeAttribute("usuarioLogueado");

			var oUsuarioActualizado = Fabrica
					.buscarUsuarioPorCampoYFiltro(oUsuarioEditado.getDocumento().toString(), "Documento").get(0);

			request.getSession().setAttribute("usuarioLogueado", oUsuarioActualizado);
			response.sendRedirect("/Proyecto-PInfra/pages/perfil/index.jsp");
			return;
		}

	}

}
