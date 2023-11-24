package com.cliente.servlets.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cliente.contexto.Fabrica;
import com.cliente.contexto.helpers.Borrar;
import com.cliente.services.ServiceJWT;

@WebServlet(name = "ServletEliminarUsuario", urlPatterns = "/SvEliminarUsuario")
public class SvEliminarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Long idUsuario = null;

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
		if (request.getSession().getAttribute("mostrarModal") == null) {
			idUsuario = Long.parseLong(request.getParameter("idUsuario"));

			Fabrica.generarModal(request, "/Proyecto-PInfra/SvEliminarUsuario",
					"¿Está seguro de que desea eliminar el usuario?", "Se dara de baja logica el usuario.", "POST");
			String urlAnterior = (String) request.getHeader("referer");
			response.sendRedirect(urlAnterior);
			return;
		}
		Borrar.darBajaLogicaUsuario(idUsuario);
		idUsuario = null;
		request.getSession().removeAttribute("mostrarModal");
		String urlAnterior = (String) request.getHeader("referer");
		response.sendRedirect(urlAnterior);
	}

}
