package com.cliente.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cliente.contexto.Fabrica;

@WebServlet(name = "ServletEditarUsuario", urlPatterns = "/SvEditarUsuario")
public class SvEditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cedula = request.getParameter("cedula");
		BigDecimal documento = new BigDecimal(cedula);
		
		var oUsuarioAEditar = Fabrica.buscarUsuarioPorCampoYFiltro(cedula, "Documento").get(0);
		
		HttpSession sesion = request.getSession();
		sesion.setAttribute("oUsuarioAEditar", oUsuarioAEditar);
		
		response.sendRedirect("/Proyecto-PInfra/pages/edicion/index.jsp");

		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
	}

}
