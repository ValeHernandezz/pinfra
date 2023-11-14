package com.cliente.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cliente.contexto.helpers.Borrar;

@WebServlet(name = "ServletEliminarUsuario", urlPatterns = "/SvEliminarUsuario")
public class SvEliminarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		Long idUsuario = Long.parseLong(request.getParameter("idUsuario"));
		
		Borrar.darBajaLogica(idUsuario);
		
		response.sendRedirect("/Proyecto-PInfra/pages/gestionDeUsuarios/index.jsp");
		
		
	}

}
