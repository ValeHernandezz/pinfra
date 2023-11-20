package com.cliente.contexto.validaciones;

import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpSession;
import com.cliente.contexto.Fabrica;

public class ValidacionUsuario {

	public static boolean validarUnUsuario(String clave, String cedula, Date fechaNacimiento, String mailInstitucional,
			String mailPersonal, String primerApellido, String primerNombre, String segundoApellido,
			String segundoNombre, String telefono, String rol, HttpSession sesion) {

		var validarNombres = validarNombres(primerNombre, segundoNombre, sesion);
		var validarApellidos = validarApellidos(primerApellido, segundoApellido, sesion);
		var validarMailPersonal = validarMailPersonal(mailPersonal, cedula, sesion);
		var validarMailInstitucional = false;

		if (rol.equals("estudiante")) {
			validarMailInstitucional = validarMailInstitucionalEstudiante(mailInstitucional, sesion);
		}
		if (rol.equals("funcionario")) {
			validarMailInstitucional = validarMailInstitucionalFuncionario(mailInstitucional, sesion);
		}

		var validarTelefono = validarTelefono(telefono, sesion);
		var validarCedula = validarCedulaUruguaya(cedula, sesion);
		var validarFechaNacimiento = validarFechaDeNacimiento(fechaNacimiento, sesion);
		var validarClave = validarClave(clave, sesion);

		if (validarNombres && validarApellidos && validarMailPersonal && validarMailInstitucional && validarTelefono
				&& validarCedula && validarFechaNacimiento && validarClave) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean validarNombres(String primerNombre, String segundoNombre, HttpSession sesion) {
		boolean resultado = true;

		if (segundoNombre.equals("")) {

			if (primerNombre.length() > 20 || primerNombre.length() < 3) {
				sesion.setAttribute("errorNombre", "El nombre debe ser entre 3 y 20 caracteres.");
				resultado = false;
			}

		} else {
			if ((primerNombre.length() > 20 || primerNombre.length() < 3)
					&& (segundoNombre.length() > 20 || segundoNombre.length() < 3)) {
				sesion.setAttribute("errorNombre", "Los nombres deben ser entre 3 y 20 caracteres.");
				resultado = false;
			}
		}

		return resultado;
	}

	private static boolean validarApellidos(String primerApellido, String segundoApellido, HttpSession sesion) {
		boolean resultado = true;

		if (segundoApellido.equals("")) {

			if (primerApellido.length() > 20 || primerApellido.length() < 3) {
				sesion.setAttribute("errorApellido", "El apellido debe ser entre 3 y 20 caracteres.");
				resultado = false;
			}

		} else {
			if ((primerApellido.length() > 20 || primerApellido.length() < 3)
					&& (segundoApellido.length() > 20 || segundoApellido.length() < 3)) {
				sesion.setAttribute("errorApellido", "Los apellidos deben ser entre 3 y 20 caracteres.");
				resultado = false;
			}
		}
		return resultado;
	}

	private static boolean validarCedulaUruguaya(String cedula, HttpSession sesion) {

		// Para evitar cualquier ingreso mayor o menor a 8 dígitos
		if (cedula.isEmpty() || cedula.length() != 8 || cedula.trim().equals("")) {
			sesion.setAttribute("errorCedula", "La cédula debe ser 8 dígitos sin puntos ni guiones.");
			return false;
		}

		// Para evitar que todos los digitos de la cédula sean iguales
		if (cedula.matches("(\\d)[-]*[$1]+")) {
			sesion.setAttribute("errorCedula", "La cédula no es válida en Uruguay.");
			return false;
		}

		int suma = 0;
		for (int i = 0; i < 7; i++) {
			int digito = Integer.parseInt(String.valueOf(cedula.charAt(i)));
			int factor = Integer.parseInt(String.valueOf("2987634".charAt(i)));
			suma += digito * factor;
		}

		int verificador = 10 - (suma % 10);
		if (verificador > 9) {
			verificador = 0;
		}

		int ultimoDigito = Integer.parseInt(String.valueOf(cedula.charAt(7)));
		if (verificador != ultimoDigito) {
			sesion.setAttribute("errorCedula", "La cédula no es válida en Uruguay.");
			return false;
		}
		return true;
	}

	private static boolean validarMailPersonal(String mailPersonal, String documento, HttpSession sesion) {

		// Verificar que el mail sea el de la persona que lo ingresa, lo sabemos por su
		// documento
		var existe = Fabrica.buscarUsuarioPorCampoYFiltro(mailPersonal, "Mail Personal");

		if (existe != null && existe.size() >= 1) {
			// Si existe un registro con el documento que llega y ademas el mail le
			// pertenece a esa persona devolvemos true
			if (existe != null && existe.get(0).getDocumento().toString().equals(documento)
					&& existe.get(0).getMailPersonal().equals(mailPersonal)) {
				return true;
			}
			sesion.setAttribute("errorMailPersonal", "El mail personal ingresado ya existe.");
			return false;
		}

		// Verificar que el correo contenga "@" y ".com" luego de "@"
		if (mailPersonal.contains("@") && mailPersonal.contains(".com")
				&& mailPersonal.indexOf("@") < mailPersonal.lastIndexOf(".com")) {
			return true;
		} else {
			sesion.setAttribute("errorMailPersonal", "El mail personal ingresado no es válido.");
			return false;
		}
	}

	private static boolean validarMailInstitucionalEstudiante(String correo, HttpSession sesion) {
		// Verificar que el correo tenga el formato especificado
		if (correo.matches("^[A-Za-z]+(\\.[A-Za-z]+)*@estudiantes\\.utec\\.edu\\.uy$") && contarPuntos(correo) == 4) {
			return true;
		} else {
			sesion.setAttribute("errorMailInstitucional", "El mail institucional ingresado no es válido.");
			return false;
		}
	}

	private static boolean validarMailInstitucionalFuncionario(String correo, HttpSession sesion) {

		if (correo.trim().length() < 8) {
			sesion.setAttribute("errorMailInstitucional", "El mail institucional ingresado no es válido.");
			return false;
		}

		// Verificar que el correo tenga el formato especificado
		if (correo.matches("^[A-Za-z]+(\\.[A-Za-z]+)*@utec\\.edu\\.uy$") && contarPuntos(correo) == 3) {
			return true;
		} else {
			sesion.setAttribute("errorMailInstitucional", "El mail institucional ingresado no es válido.");
			return false;
		}
	}

	private static int contarPuntos(String correo) {
		// Contar la cantidad de puntos en el correo
		int contador = 0;
		for (int i = 0; i < correo.length(); i++) {
			if (correo.charAt(i) == '.') {
				contador++;
			}
		}
		return contador;
	}

	private static boolean validarTelefono(String telefono, HttpSession sesion) {
		// Verificar que la cadena contenga solo dígitos
		if (!telefono.matches("\\d+")) {
			sesion.setAttribute("errorTelefono", "El número de teléfono ingresado no es válido.");
			return false;
		}

		// Verificar que la longitud sea la correcta
		if (telefono.length() != 9) {
			sesion.setAttribute("errorTelefono", "El número de teléfono ingresado no es válido.");
			return false;
		}

		return true;
	}

	private static boolean validarClave(String clave, HttpSession sesion) {
		if (clave.length() < 7) {
			sesion.setAttribute("errorClave", "La contraseña debe ser al menos de 8 caracteres.");
			return false;
		}

		// Verificar si la clave contiene al menos una letra y un número
		boolean contieneLetra = false;
		boolean contieneNumero = false;

		for (char c : clave.toCharArray()) {
			if (Character.isLetter(c)) {
				contieneLetra = true;
			} else if (Character.isDigit(c)) {
				contieneNumero = true;
			}

			if (contieneLetra && contieneNumero) {
				return true;
			}
		}
		sesion.setAttribute("errorClave", "La contraseña debe ser al menos de 8 caracteres.");
		return false;
	}

	private static boolean validarFechaDeNacimiento(Date fechaNacimiento, HttpSession sesion) {

		if (fechaNacimiento == null) {
			sesion.setAttribute("errorFechaNacimiento", "Debe seleccionar una fecha de nacimiento.");
			return false;
		}

		Calendar calendarNacimiento = Calendar.getInstance();
		calendarNacimiento.setTime(fechaNacimiento);

		Calendar calendarHoy = Calendar.getInstance();

		// Restamos 18 años a la fecha actual
		calendarHoy.add(Calendar.YEAR, -18);

		if (calendarNacimiento.before(calendarHoy) || calendarNacimiento.equals(calendarHoy)) {
			return true;
		}
		sesion.setAttribute("errorFechaNacimiento", "Debe ser mayor de edad para solicitar el registro.");
		return false;
	}

	public static boolean esUnNumero(String documento) {

		boolean esUnNumero;

		try {

			int numero = Integer.parseInt(documento);
			return esUnNumero = true;

		} catch (NumberFormatException e) {
			return esUnNumero = false;

		}
	}

	public static boolean existeLaCedula(String documento) {
		try {

			var oExisteUsuario = Fabrica.buscarUsuarioPorCampoYFiltro(documento, "Documento").get(0);
			if (oExisteUsuario != null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
}
