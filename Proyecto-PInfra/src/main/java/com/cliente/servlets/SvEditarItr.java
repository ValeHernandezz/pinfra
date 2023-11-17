package com.cliente.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cliente.contexto.helpers.Actualizar;
import com.cliente.contexto.helpers.Buscar;
import com.cliente.services.ServiceUbicacion;
import com.servidor.entidades.Departamento;
import com.servidor.entidades.Itr;

@WebServlet(name = "ServletEditarItr", urlPatterns = "/SvEditarItr")
public class SvEditarItr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		Long idItr = Long.parseLong(request.getParameter("idItr"));
		
		Itr oItrEditar = Buscar.itrPorId(idItr);
		
		request.getSession().setAttribute("itrEditar", oItrEditar);
		response.sendRedirect("/Proyecto-PInfra/pages/itrs/index.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String nombreItr = request.getParameter("nombreItrEditar");
		String departamentoTexto = request.getParameter("departamentoEditar");
		
		Departamento departamento = ServiceUbicacion.listarDepartamentosFiltro(departamentoTexto).get(0);

		Itr oItrAntiguo = (Itr) request.getSession().getAttribute("itrEditar");
		
		Itr oItrEditado = new Itr(nombreItr, departamento, "S");
		oItrEditado.setIdItr(oItrAntiguo.getIdItr());
		
		Actualizar.itr(oItrEditado);
		
		request.getSession().removeAttribute("itrEditar");
		response.sendRedirect("/Proyecto-PInfra/pages/itrs/index.jsp");
		
	}

}
