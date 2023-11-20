package com.cliente.servlets.itr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cliente.contexto.helpers.Borrar;

@WebServlet(name = "ServletEliminarItr", urlPatterns = "/SvEliminarItr")
public class SvEliminarItr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("itrEditar");
		request.getSession().removeAttribute("mostrarForm");
		response.sendRedirect("/Proyecto-PInfra/pages/itrs/index.jsp");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		Long idItr = Long.parseLong(request.getParameter("idItr"));

		Borrar.darBajaLogicaItr(idItr);

		response.sendRedirect("/Proyecto-PInfra/pages/itrs/index.jsp");

	}

}
