package com.cliente.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cliente.services.ServiceUsuario;
import com.servidor.entidades.Usuario;
import com.servidor.utils.Respuesta;

@WebServlet(name = "ServletLogin", urlPatterns = { "/Login" })

public class SvLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SvLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombreUsuario = request.getParameter("nombreUsuario");
		String clave = request.getParameter("clave");

		if (nombreUsuario == null || clave == null || nombreUsuario.trim().isEmpty() || clave.trim().isEmpty()) {
			String mensajeError = "Debe completar todos los campos para ingresar a su cuenta.";
			request.setAttribute("mensajeError", mensajeError);
			System.out.println(request.getContextPath());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/login/index.jsp");

			requestDispatcher.forward(request, response);

			return;
		}

		Respuesta oRespuesta = ServiceUsuario.login(nombreUsuario, clave);

		if (oRespuesta == null || oRespuesta.getStatus().equals("error")) {
			String mensajeError = oRespuesta != null ? oRespuesta.getMessage() : "Datos incorrectos";
			request.setAttribute("mensajeError", mensajeError);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/login/index.jsp");

			requestDispatcher.forward(request, response);

			return;
		}

		if (oRespuesta.getStatus().equals("success")) {
			Usuario oUsuario = (Usuario) oRespuesta.getData();

			HttpSession session = request.getSession(true);

			session.setAttribute("usuarioLogueado", oUsuario);
		}

		response.sendRedirect("index.jsp");
	}

}
