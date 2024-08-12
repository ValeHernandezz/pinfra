package com.cliente.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletListarActivos", urlPatterns = "/SvListarActivos")
public class SvListarActivos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filtro = request.getParameter("filtro");
		String urlAnterior = (String) request.getHeader("referer");
		if (filtro.equals("D")) {
			response.sendRedirect(urlAnterior);
			return;
		}
		request.getSession().setAttribute("filtroActivo", filtro);
		response.sendRedirect(urlAnterior);
	}

}
