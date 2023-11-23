package com.cliente.services;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servidor.entidades.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class ServiceJWT {

	private static final String SECRET_KEY = "clavesupersecreta";

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

}
