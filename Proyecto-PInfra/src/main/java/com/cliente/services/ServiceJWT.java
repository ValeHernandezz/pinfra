package com.cliente.services;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servidor.entidades.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class ServiceJWT {

	private static final String SECRET_KEY = "fda57524b818c4015ae923dede9a390c5a6711c1a4c6e803fd3e85e269c1edbe";

	public static String generarToken(Usuario oUsuario, Date fechaExpiracion) {
		return Jwts.builder().setSubject(oUsuario.getNombreUsuario()).claim("rol", oUsuario.getRol().getDescripcion())
				.setExpiration(fechaExpiracion).signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

	public static boolean validarToken(HttpServletRequest request, HttpServletResponse response) {
		try {
			String token = (String) request.getSession().getAttribute("token");
			Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();

			Date expirationDate = claims.getExpiration();
			Date now = new Date();
			if (expirationDate != null && now.after(expirationDate)) {
				return false;
			}

			String nombreUsuario = claims.getSubject();
			boolean existeUsuario = ServiceUsuario.comprobarNombreUsuario(nombreUsuario);
			if (existeUsuario) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static void comprobarSesion(HttpServletRequest request, HttpServletResponse response, String pagina) throws IOException {
		boolean tienePermiso = false;

		if (request.getSession().getAttribute("token") == null) {
			response.sendRedirect("/Proyecto-PInfra/pages/login/index.jsp");
			return;
		}

		tienePermiso = ServiceJWT.validarToken(request, response);

		if (!tienePermiso) {
			response.sendRedirect("/Proyecto-PInfra/pages/login/index.jsp");
			return;
		}

		String rol = getRol(request);
		if ((rol.equals("Estudiante") || rol.equals("Tutor") || rol.equals("Encargado")) && !pagina.equals("Perfil")) {
			response.sendRedirect("/Proyecto-PInfra/index.jsp");
			return;
		}
	}

	public static String getRol(HttpServletRequest request) {
		String token = (String) request.getSession().getAttribute("token");
		Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
		return (String) claims.get("rol");
	}

}
