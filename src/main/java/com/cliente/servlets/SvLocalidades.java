package com.cliente.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cliente.contexto.helpers.Buscar;
import com.servidor.entidades.Localidad;

@WebServlet("/SvLocalidades")
public class SvLocalidades extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SvLocalidades() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String departamento = request.getParameter("departamento");
		ArrayList<Localidad> localidades = Buscar.localidadPorDepartamento(departamento);

		JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
		for (Localidad localidad : localidades) {
			JsonObject localidadJson = Json.createObjectBuilder().add("nombre", localidad.getNombre()).build();
			jsonArrayBuilder.add(localidadJson);
		}

		JsonArray jsonArray = jsonArrayBuilder.build();
		String jsonLocalidades = jsonArray.toString();

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonLocalidades);
	}

}
