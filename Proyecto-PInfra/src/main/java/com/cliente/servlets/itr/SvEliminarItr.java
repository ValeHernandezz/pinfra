package com.cliente.servlets.itr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cliente.contexto.Fabrica;
import com.cliente.contexto.helpers.Borrar;
import com.cliente.services.ServiceJWT;

@WebServlet(name = "ServletEliminarItr", urlPatterns = "/SvEliminarItr")
public class SvEliminarItr extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Long idItr = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("itrEditar");
		request.getSession().removeAttribute("mostrarForm");
		response.sendRedirect("/Proyecto-PInfra/pages/itrs/index.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ServiceJWT.validarToken(request, response)) {
			response.sendRedirect("/Proyecto-PInfra/pages/login/index.jsp");
			return;
		}

		request.setCharacterEncoding("UTF-8");
		if (request.getSession().getAttribute("mostrarModal") == null) {
			idItr = Long.parseLong(request.getParameter("idItr"));
			Fabrica.generarModal(request, "/Proyecto-PInfra/SvEliminarItr", "¿Está seguro que desea eliminar el ITR?",
					"El ITR se dara de baja logica.", "POST");
			response.sendRedirect("/Proyecto-PInfra/pages/itrs/index.jsp");
			return;
		}

		Borrar.darBajaLogicaItr(idItr);
		request.getSession().removeAttribute("mostrarModal");
		idItr = null;
		response.sendRedirect("/Proyecto-PInfra/pages/itrs/index.jsp");

	}

}
