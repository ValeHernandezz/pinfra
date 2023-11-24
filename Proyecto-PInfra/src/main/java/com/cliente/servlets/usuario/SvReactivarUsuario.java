package com.cliente.servlets.usuario;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cliente.contexto.Fabrica;
import com.cliente.services.ServiceUsuario;
import com.servidor.entidades.Usuario;

@WebServlet(name = "ServletReactivarUsuario", urlPatterns = "/SvReactivarUsuario")
public class SvReactivarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String documento = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String urlAnterior = (String) request.getHeader("referer");

		if (request.getSession().getAttribute("mostrarModal") == null) {
			documento = request.getParameter("documento");
			Fabrica.generarModal(request, "/Proyecto-PInfra/SvReactivarUsuario",
					"¿Está seguro que desea reactivar este usuario?",
					"El usuario volverá a estar activo en la plataforma.", "POST");
			response.sendRedirect(urlAnterior);
			return;
		}
		Usuario oUsuario = Fabrica.buscarUsuarioPorCampoYFiltro(documento, "Documento").get(0);
		oUsuario.setActivo("S");
		Usuario oUsuarioReactivado = ServiceUsuario.actualizarUsuario(oUsuario);
		documento = null;
		request.getSession().removeAttribute("mostrarModal");
		response.sendRedirect(urlAnterior);
	}

}
