package com.cliente.servlets.usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cliente.contexto.Fabrica;
import com.cliente.services.ServiceJWT;
import com.cliente.services.ServiceUsuario;
import com.servidor.entidades.Usuario;

@WebServlet(name = "ServletConfirmarUsuario", urlPatterns = "/SvConfirmarUsuario")
public class SvConfirmarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ServiceJWT.validarToken(request, response)) {
			response.sendRedirect("/Proyecto-PInfra/pages/login/index.jsp");
			return;
		}
		
		String documento = request.getParameter("cedula");

		Usuario oUsuarioAConfirmar = Fabrica.buscarUsuarioPorCampoYFiltro(documento, "Documento").get(0);
		oUsuarioAConfirmar.setActivo("N");

		var oUsuarioConfirmado = ServiceUsuario.actualizarUsuario(oUsuarioAConfirmar);

		response.sendRedirect("/Proyecto-PInfra/pages/confirmacion/index.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ServiceJWT.validarToken(request, response)) {
			response.sendRedirect("/Proyecto-PInfra/pages/login/index.jsp");
			return;
		}
		
		String documento = request.getParameter("cedula");

		Usuario oUsuarioAConfirmar = Fabrica.buscarUsuarioPorCampoYFiltro(documento, "Documento").get(0);
		oUsuarioAConfirmar.setConfirmado("S");

		var oUsuarioConfirmado = ServiceUsuario.actualizarUsuario(oUsuarioAConfirmar);

		response.sendRedirect("/Proyecto-PInfra/pages/confirmacion/index.jsp");
	}

}
