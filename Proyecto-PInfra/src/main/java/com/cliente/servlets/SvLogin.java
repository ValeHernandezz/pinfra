package com.cliente.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletLogin", urlPatterns = { "/Login" })
public class SvLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SvLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombreUsuario = request.getParameter("nombreUsuario");
		String clave = request.getParameter("clave");

		if ((nombreUsuario.trim().isEmpty() || clave.trim().isEmpty()) || (nombreUsuario == null || clave == null)) {
			System.out.println("hola desde el if");
			response.sendRedirect("index.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombreUsuario = request.getParameter("nombreUsuario");
		String clave = request.getParameter("clave");

		if ((nombreUsuario.trim().isEmpty() || clave.trim().isEmpty()) || (nombreUsuario == null || clave == null)) {
			System.out.println("hola desde el if");
			response.sendRedirect("index.jsp");
		}

	}

}
