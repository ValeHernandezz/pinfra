package com.cliente.contexto.utils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import com.cliente.contexto.helpers.Crear;
import com.cliente.services.ServiceArea;
import com.cliente.services.ServiceEstudiante;
import com.cliente.services.ServiceGenero;
import com.cliente.services.ServiceItr;
import com.cliente.services.ServiceRol;
import com.cliente.services.ServiceUbicacion;
import com.servidor.entidades.Analista;
import com.servidor.entidades.Area;
import com.servidor.entidades.Departamento;
import com.servidor.entidades.Estudiante;
import com.servidor.entidades.Genero;
import com.servidor.entidades.Itr;
import com.servidor.entidades.Localidad;
import com.servidor.entidades.Rol;
import com.servidor.entidades.Tutor;
import com.servidor.entidades.Usuario;

public class CargarDatos {

	public static void empezar() {

		var contador = ServiceRol.listarRoles().size();

		if (contador != 0) {
			return;
		}

		Rol oRol = new Rol("Analista");
		Rol oRol2 = new Rol("Estudiante");
		Rol oRol3 = new Rol("Tutor");
		Rol oRol4 = new Rol("Encargado");

		var rolCreado = ServiceRol.crearRol(oRol);
		var rolCreado2 = ServiceRol.crearRol(oRol2);
		var rolCreado3 = ServiceRol.crearRol(oRol3);
		var rolCreado4 = ServiceRol.crearRol(oRol4);

		Genero genero = new Genero("Masculino");
		Genero genero2 = new Genero("Femenino");
		Genero genero3 = new Genero("Otro");

		var generoCreado = ServiceGenero.crearGenero(genero);
		var generoCreado2 = ServiceGenero.crearGenero(genero2);
		var generoCreado3 = ServiceGenero.crearGenero(genero3);

		Departamento departamento = new Departamento("Artigas");
		Departamento departamento2 = new Departamento("Canelones");
		Departamento departamento3 = new Departamento("Cerro Largo");
		Departamento departamento4 = new Departamento("Colonia");
		Departamento departamento5 = new Departamento("Durazno");
		Departamento departamento6 = new Departamento("Flores");
		Departamento departamento7 = new Departamento("Florida");
		Departamento departamento8 = new Departamento("Lavalleja");
		Departamento departamento9 = new Departamento("Maldonado");
		Departamento departamento10 = new Departamento("Montevideo");
		Departamento departamento11 = new Departamento("Paysandú");
		Departamento departamento12 = new Departamento("Río Negro");
		Departamento departamento13 = new Departamento("Rivera");
		Departamento departamento14 = new Departamento("Rocha");
		Departamento departamento15 = new Departamento("Salto");
		Departamento departamento16 = new Departamento("San José");
		Departamento departamento17 = new Departamento("Soriano");
		Departamento departamento18 = new Departamento("Tacuarembó");
		Departamento departamento19 = new Departamento("Treinta y Tres");

		var departamentoCreado = ServiceUbicacion.crearDepartamento(departamento);
		var departamentoCreado2 = ServiceUbicacion.crearDepartamento(departamento2);
		var departamentoCreado3 = ServiceUbicacion.crearDepartamento(departamento3);
		var departamentoCreado4 = ServiceUbicacion.crearDepartamento(departamento4);
		var departamentoCreado5 = ServiceUbicacion.crearDepartamento(departamento5);
		var departamentoCreado6 = ServiceUbicacion.crearDepartamento(departamento6);
		var departamentoCreado7 = ServiceUbicacion.crearDepartamento(departamento7);
		var departamentoCreado8 = ServiceUbicacion.crearDepartamento(departamento8);
		var departamentoCreado9 = ServiceUbicacion.crearDepartamento(departamento9);
		var departamentoCreado10 = ServiceUbicacion.crearDepartamento(departamento10);
		var departamentoCreado11 = ServiceUbicacion.crearDepartamento(departamento11);
		var departamentoCreado12 = ServiceUbicacion.crearDepartamento(departamento12);
		var departamentoCreado13 = ServiceUbicacion.crearDepartamento(departamento13);
		var departamentoCreado14 = ServiceUbicacion.crearDepartamento(departamento14);
		var departamentoCreado15 = ServiceUbicacion.crearDepartamento(departamento15);
		var departamentoCreado16 = ServiceUbicacion.crearDepartamento(departamento16);
		var departamentoCreado17 = ServiceUbicacion.crearDepartamento(departamento17);
		var departamentoCreado18 = ServiceUbicacion.crearDepartamento(departamento18);
		var departamentoCreado19 = ServiceUbicacion.crearDepartamento(departamento19);

		Localidad localidad4 = new Localidad("Artigas", departamentoCreado);
		Localidad localidad5 = new Localidad("Bella Unión", departamentoCreado);
		Localidad localidad6 = new Localidad("Tomás Gomensoro", departamentoCreado);

		Localidad localidad7 = new Localidad("Canelones", departamentoCreado2);
		Localidad localidad8 = new Localidad("Ciudad de la Costa", departamentoCreado2);
		Localidad localidad9 = new Localidad("Las Piedras", departamentoCreado2);

		Localidad localidad10 = new Localidad("Melo", departamentoCreado3);
		Localidad localidad11 = new Localidad("Río Branco", departamentoCreado3);
		Localidad localidad12 = new Localidad("Fraile Muerto", departamentoCreado3);

		Localidad localidad13 = new Localidad("Colonia del Sacramento", departamentoCreado4);
		Localidad localidad14 = new Localidad("Nueva Helvecia", departamentoCreado4);
		Localidad localidad15 = new Localidad("Carmelo", departamentoCreado4);

		Localidad localidad16 = new Localidad("Durazno", departamentoCreado5);
		Localidad localidad17 = new Localidad("Sarandí del Yí", departamentoCreado5);
		Localidad localidad18 = new Localidad("Villa del Carmen", departamentoCreado5);

		Localidad localidad19 = new Localidad("Trinidad", departamentoCreado6);
		Localidad localidad20 = new Localidad("Ismael Cortinas", departamentoCreado6);
		Localidad localidad21 = new Localidad("Andresito", departamentoCreado6);

		Localidad localidad22 = new Localidad("Florida", departamentoCreado7);
		Localidad localidad23 = new Localidad("Sarandí Grande", departamentoCreado7);
		Localidad localidad24 = new Localidad("Casupá", departamentoCreado7);

		Localidad localidad = new Localidad("Minas", departamentoCreado8);
		Localidad localidad2 = new Localidad("José Pedro Varela", departamentoCreado8);
		Localidad localidad3 = new Localidad("Solís de Mataojo", departamentoCreado8);

		Localidad localidad25 = new Localidad("Maldonado", departamentoCreado9);
		Localidad localidad26 = new Localidad("Punta del Este", departamentoCreado9);
		Localidad localidad27 = new Localidad("San Carlos", departamentoCreado9);

		Localidad localidad28 = new Localidad("Montevideo", departamentoCreado10);

		Localidad localidad31 = new Localidad("Paysandú", departamentoCreado11);
		Localidad localidad32 = new Localidad("Guichón", departamentoCreado11);
		Localidad localidad33 = new Localidad("Quebracho", departamentoCreado11);

		Localidad localidad34 = new Localidad("Fray Bentos", departamentoCreado12);
		Localidad localidad35 = new Localidad("Young", departamentoCreado12);
		Localidad localidad36 = new Localidad("Nuevo Berlín", departamentoCreado12);

		Localidad localidad37 = new Localidad("Rivera", departamentoCreado13);
		Localidad localidad38 = new Localidad("Tranqueras", departamentoCreado13);
		Localidad localidad39 = new Localidad("Minas de Corrales", departamentoCreado13);

		Localidad localidad40 = new Localidad("Lascano", departamentoCreado14);
		Localidad localidad41 = new Localidad("Chuy", departamentoCreado14);
		Localidad localidad42 = new Localidad("Castillos", departamentoCreado14);

		Localidad localidad43 = new Localidad("Salto", departamentoCreado15);
		Localidad localidad44 = new Localidad("Constitución", departamentoCreado15);
		Localidad localidad45 = new Localidad("Belén", departamentoCreado15);

		Localidad localidad46 = new Localidad("San José de Mayo", departamentoCreado16);
		Localidad localidad47 = new Localidad("Ciudad del Plata", departamentoCreado16);
		Localidad localidad48 = new Localidad("Libertad", departamentoCreado16);

		Localidad localidad49 = new Localidad("Mercedes", departamentoCreado17);
		Localidad localidad50 = new Localidad("Dolores", departamentoCreado17);
		Localidad localidad51 = new Localidad("Cardona", departamentoCreado17);

		Localidad localidad52 = new Localidad("Tacuarembó", departamentoCreado18);
		Localidad localidad53 = new Localidad("Paso de los Toros", departamentoCreado18);
		Localidad localidad54 = new Localidad("San Gregorio de Polanco", departamentoCreado18);

		Localidad localidad55 = new Localidad("Treinta y Tres", departamentoCreado19);
		Localidad localidad56 = new Localidad("Vergara", departamentoCreado19);
		Localidad localidad57 = new Localidad("Santa Clara De Olimar", departamentoCreado19);

		var localidadCreada = ServiceUbicacion.crearLocalidad(localidad);
		var localidadCreada2 = ServiceUbicacion.crearLocalidad(localidad2);
		var localidadCreada3 = ServiceUbicacion.crearLocalidad(localidad3);
		var localidadCreada4 = ServiceUbicacion.crearLocalidad(localidad4);
		var localidadCreada5 = ServiceUbicacion.crearLocalidad(localidad5);
		var localidadCreada6 = ServiceUbicacion.crearLocalidad(localidad6);
		var localidadCreada7 = ServiceUbicacion.crearLocalidad(localidad7);
		var localidadCreada8 = ServiceUbicacion.crearLocalidad(localidad8);
		var localidadCreada9 = ServiceUbicacion.crearLocalidad(localidad9);
		var localidadCreada10 = ServiceUbicacion.crearLocalidad(localidad10);
		var localidadCreada11 = ServiceUbicacion.crearLocalidad(localidad11);
		var localidadCreada12 = ServiceUbicacion.crearLocalidad(localidad12);
		var localidadCreada13 = ServiceUbicacion.crearLocalidad(localidad13);
		var localidadCreada14 = ServiceUbicacion.crearLocalidad(localidad14);
		var localidadCreada15 = ServiceUbicacion.crearLocalidad(localidad15);
		var localidadCreada16 = ServiceUbicacion.crearLocalidad(localidad16);
		var localidadCreada17 = ServiceUbicacion.crearLocalidad(localidad17);
		var localidadCreada18 = ServiceUbicacion.crearLocalidad(localidad18);
		var localidadCreada19 = ServiceUbicacion.crearLocalidad(localidad19);
		var localidadCreada20 = ServiceUbicacion.crearLocalidad(localidad20);
		var localidadCreada21 = ServiceUbicacion.crearLocalidad(localidad21);
		var localidadCreada22 = ServiceUbicacion.crearLocalidad(localidad22);
		var localidadCreada23 = ServiceUbicacion.crearLocalidad(localidad23);
		var localidadCreada24 = ServiceUbicacion.crearLocalidad(localidad24);
		var localidadCreada25 = ServiceUbicacion.crearLocalidad(localidad25);
		var localidadCreada26 = ServiceUbicacion.crearLocalidad(localidad26);
		var localidadCreada27 = ServiceUbicacion.crearLocalidad(localidad27);
		var localidadCreada28 = ServiceUbicacion.crearLocalidad(localidad28);
		var localidadCreada31 = ServiceUbicacion.crearLocalidad(localidad31);
		var localidadCreada32 = ServiceUbicacion.crearLocalidad(localidad32);
		var localidadCreada33 = ServiceUbicacion.crearLocalidad(localidad33);
		var localidadCreada34 = ServiceUbicacion.crearLocalidad(localidad34);
		var localidadCreada35 = ServiceUbicacion.crearLocalidad(localidad35);
		var localidadCreada36 = ServiceUbicacion.crearLocalidad(localidad36);
		var localidadCreada37 = ServiceUbicacion.crearLocalidad(localidad37);
		var localidadCreada38 = ServiceUbicacion.crearLocalidad(localidad38);
		var localidadCreada39 = ServiceUbicacion.crearLocalidad(localidad39);
		var localidadCreada40 = ServiceUbicacion.crearLocalidad(localidad40);
		var localidadCreada41 = ServiceUbicacion.crearLocalidad(localidad41);
		var localidadCreada42 = ServiceUbicacion.crearLocalidad(localidad42);
		var localidadCreada43 = ServiceUbicacion.crearLocalidad(localidad43);
		var localidadCreada44 = ServiceUbicacion.crearLocalidad(localidad44);
		var localidadCreada45 = ServiceUbicacion.crearLocalidad(localidad45);
		var localidadCreada46 = ServiceUbicacion.crearLocalidad(localidad46);
		var localidadCreada47 = ServiceUbicacion.crearLocalidad(localidad47);
		var localidadCreada48 = ServiceUbicacion.crearLocalidad(localidad48);
		var localidadCreada49 = ServiceUbicacion.crearLocalidad(localidad49);
		var localidadCreada50 = ServiceUbicacion.crearLocalidad(localidad50);
		var localidadCreada51 = ServiceUbicacion.crearLocalidad(localidad51);
		var localidadCreada52 = ServiceUbicacion.crearLocalidad(localidad52);
		var localidadCreada53 = ServiceUbicacion.crearLocalidad(localidad53);
		var localidadCreada54 = ServiceUbicacion.crearLocalidad(localidad54);
		var localidadCreada55 = ServiceUbicacion.crearLocalidad(localidad55);
		var localidadCreada56 = ServiceUbicacion.crearLocalidad(localidad56);
		var localidadCreada57 = ServiceUbicacion.crearLocalidad(localidad57);

		Itr itr = new Itr("ITR Suroeste", departamentoCreado, "S");
		Itr itr2 = new Itr("ITR Centro-Sur", departamentoCreado2, "S");
		Itr itr3 = new Itr("ITR Norte", departamentoCreado3, "S");

		var itrCreada = ServiceItr.crearItr(itr);
		var itrCreada2 = ServiceItr.crearItr(itr2);
		var itrCreada3 = ServiceItr.crearItr(itr3);

		// Edad Martina
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2002);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 25);
		Date dateMartina = calendar.getTime();

		// Edad Rony
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(Calendar.YEAR, 2002);
		calendar2.set(Calendar.MONTH, Calendar.JANUARY);
		calendar2.set(Calendar.DAY_OF_MONTH, 16);
		Date dateRony = calendar2.getTime();

		// Edad Matias
		Calendar calendar3 = Calendar.getInstance();
		calendar3.set(Calendar.YEAR, 2001);
		calendar3.set(Calendar.MONTH, Calendar.JANUARY);
		calendar3.set(Calendar.DAY_OF_MONTH, 22);
		Date dateMatias = calendar3.getTime();

		// Edad Valentina
		Calendar calendar4 = Calendar.getInstance();
		calendar4.set(Calendar.YEAR, 2001);
		calendar4.set(Calendar.MONTH, Calendar.JANUARY);
		calendar4.set(Calendar.DAY_OF_MONTH, 12);
		Date dateValentina = calendar4.getTime();

		// Edad Pepe
		Calendar calendar5 = Calendar.getInstance();
		calendar5.set(Calendar.YEAR, 2000);
		calendar5.set(Calendar.MONTH, Calendar.JANUARY);
		calendar5.set(Calendar.DAY_OF_MONTH, 21);
		Date datePepe = calendar5.getTime();

		// Edad Nico
		Calendar calendar6 = Calendar.getInstance();
		calendar6.set(Calendar.YEAR, 1995);
		calendar6.set(Calendar.MONTH, Calendar.JANUARY);
		calendar6.set(Calendar.DAY_OF_MONTH, 20);
		Date dateNico = calendar6.getTime();

		Calendar calendar7 = Calendar.getInstance();
		calendar7.set(Calendar.YEAR, 1990);
		calendar7.set(Calendar.MONTH, Calendar.JANUARY);
		calendar7.set(Calendar.DAY_OF_MONTH, 15);
		Date date1 = calendar7.getTime();

		Calendar calendar8 = Calendar.getInstance();
		calendar8.set(Calendar.YEAR, 1987);
		calendar8.set(Calendar.MONTH, Calendar.MARCH);
		calendar8.set(Calendar.DAY_OF_MONTH, 23);
		Date date2 = calendar8.getTime();

		Calendar calendar9 = Calendar.getInstance();
		calendar9.set(Calendar.YEAR, 1995);
		calendar9.set(Calendar.MONTH, Calendar.JULY);
		calendar9.set(Calendar.DAY_OF_MONTH, 8);
		Date date3 = calendar9.getTime();

		Calendar calendar10 = Calendar.getInstance();
		calendar10.set(Calendar.YEAR, 1993);
		calendar10.set(Calendar.MONTH, Calendar.APRIL);
		calendar10.set(Calendar.DAY_OF_MONTH, 30);
		Date date4 = calendar10.getTime();

		Calendar calendar11 = Calendar.getInstance();
		calendar11.set(Calendar.YEAR, 1991);
		calendar11.set(Calendar.MONTH, Calendar.FEBRUARY);
		calendar11.set(Calendar.DAY_OF_MONTH, 12);
		Date date5 = calendar11.getTime();

		Calendar calendar12 = Calendar.getInstance();
		calendar12.set(Calendar.YEAR, 1999);
		calendar12.set(Calendar.MONTH, Calendar.NOVEMBER);
		calendar12.set(Calendar.DAY_OF_MONTH, 5);
		Date date6 = calendar12.getTime();

		Calendar calendar13 = Calendar.getInstance();
		calendar13.set(Calendar.YEAR, 1988);
		calendar13.set(Calendar.MONTH, Calendar.DECEMBER);
		calendar13.set(Calendar.DAY_OF_MONTH, 18);
		Date date7 = calendar7.getTime();

		BigDecimal cedula = new BigDecimal(12111111);
		BigDecimal cedula2 = new BigDecimal(22222222);
		BigDecimal cedula3 = new BigDecimal(33333333);
		BigDecimal cedula4 = new BigDecimal(44444444);
		BigDecimal cedula5 = new BigDecimal(55555555);
		BigDecimal cedula6 = new BigDecimal(66666666);

		BigDecimal cedula7 = new BigDecimal(77777777);
		BigDecimal cedula8 = new BigDecimal(88888888);
		BigDecimal cedula9 = new BigDecimal(99999999);
		BigDecimal cedula10 = new BigDecimal(10101010);
		BigDecimal cedula11 = new BigDecimal(20202020);
		BigDecimal cedula12 = new BigDecimal(30303030);
		BigDecimal cedula13 = new BigDecimal(40404040);

		Usuario oUsuarioNuevo = new Usuario("12345678a", cedula, dateNico, "nicolas.melendez@utec.edu.uy",
				"nico@hotmail.com", "nicolas.melendez", "Meléndez", "Nicolás", "Gutierrez", "Nahuel", "099616534", "S",
				"S", departamentoCreado8, generoCreado, itrCreada, localidadCreada, rolCreado);

		Usuario oUsuarioNuevo2 = new Usuario("12345678a", cedula2, dateRony, "rony.palacios@utec.edu.uy",
				"rony@adinet.com", "rony.palacios", "Palacios", "Rony", "Guerra", "", "099652242", "S", "S",
				departamentoCreado8, generoCreado, itrCreada, localidadCreada, rolCreado3);

		Usuario oUsuarioNuevo3 = new Usuario("12345678a", cedula3, dateMartina, "matias.luzardo@utec.edu.uy",
				"matias@gmail.com", "matias.luzardo", "Luzardo", "Matias", "Frade", "Gabriel", "092344423", "S", "N",
				departamentoCreado7, generoCreado, itrCreada, localidadCreada22, rolCreado4);

		Usuario oUsuarioNuevo4 = new Usuario("12345678a", cedula4, dateValentina, "valentina.hernandez@utec.edu.uy",
				"vale@gmail.com", "valentina.hernandez", "Hernandez", "Valentina", "Modino", "", "094567443", "S", "S",
				departamentoCreado8, generoCreado2, itrCreada, localidadCreada, rolCreado);

		Usuario oUsuarioNuevo5 = new Usuario("12345678a", cedula5, dateMartina,
				"martina.fernandez@estudiantes.utec.edu.uy", "marti@gmail.com", "martina.fernandez", "Fernandez",
				"Martina", "Baladón", "", "095672344", "S", "S", departamentoCreado2, generoCreado2, itrCreada,
				localidadCreada8, rolCreado2);

		Usuario oUsuarioNuevo6 = new Usuario("12345678a", cedula6, datePepe, "pepe.lopez@estudiantes.utec.edu.uy",
				"pepe@gmail.com", "pepe.lopez", "Lopez", "Pepe", "Roman", "", "091342344", "S", "S",
				departamentoCreado3, generoCreado, itrCreada, localidadCreada12, rolCreado2);

		Usuario oUsuarioNuevo7 = new Usuario("23456789b", cedula7, date1, "juan.gonzalez@estudiantes.utec.edu.uy",
				"juan@gmail.com", "juan.gonzalez", "Gonzalez", "Juan", "Carlos", "Herrera", "098765432", "S", "S",
				departamentoCreado2, generoCreado2, itrCreada2, localidadCreada8, rolCreado2);

		Usuario oUsuarioNuevo8 = new Usuario("34567890c", cedula8, date2, "maria.rodriguez@estudiantes.utec.edu.uy",
				"maria@gmail.com", "maria.rodriguez", "Rodriguez", "Maria", "Fernanda", "Furtado", "095623421", "S",
				"N", departamentoCreado3, generoCreado, itrCreada, localidadCreada10, rolCreado2);

		Usuario oUsuarioNuevo9 = new Usuario("45678901d", cedula9, date3, "ana.martinez@estudiantes.utec.edu.uy",
				"ana@gmail.com", "ana.martinez", "Martinez", "Ana", "Laura", "Silva", "092345678", "S", "S",
				departamentoCreado4, generoCreado2, itrCreada2, localidadCreada14, rolCreado2);

		Usuario oUsuarioNuevo10 = new Usuario("56789012e", cedula10, date4, "luis.perez@estudiantes.utec.edu.uy",
				"luis@gmail.com", "luis.perez", "Perez", "Luis", "Alberto", "Urterio", "096734521", "S", "S",
				departamentoCreado5, generoCreado, itrCreada, localidadCreada18, rolCreado2);

		Usuario oUsuarioNuevo11 = new Usuario("67890123f", cedula11, date5, "laura.garcia@estudiantes.utec.edu.uy",
				"laura@gmail.com", "laura.garcia", "Garcia", "Laura", "Isabel", "", "091234567", "S", "N",
				departamentoCreado6, generoCreado2, itrCreada2, localidadCreada21, rolCreado2);

		Usuario oUsuarioNuevo12 = new Usuario("78901234g", cedula12, date6, "pedro.fernandez@utec.edu.uy",
				"pedro@gmail.com", "pedro.fernandez", "Fernandez", "Pedro", "Jose", "Gonzalez", "098765432", "S", "N",
				departamentoCreado7, generoCreado, itrCreada, localidadCreada23, rolCreado3);

		Usuario oUsuarioNuevo13 = new Usuario("89012345h", cedula13, date7, "carla.sanchez@utec.edu.uy",
				"carla@gmail.com", "carla.sanchez", "Sanchez", "Carla", "Lucia", "", "092345678", "N", "S",
				departamentoCreado8, generoCreado2, itrCreada2, localidadCreada2, rolCreado4);

//		var oUsuarioCreado = Crear.usuario(oUsuarioNuevo, new Analista());
		var oUsuarioCreado4 = Crear.usuario(oUsuarioNuevo4, new Analista());

		var oUsuarioCreado5 = Crear.usuario(oUsuarioNuevo5, new Estudiante("2019", new BigDecimal(4)));
		var oUsuarioCreado6 = Crear.usuario(oUsuarioNuevo6, new Estudiante("2022", new BigDecimal(1)));
		var oUsuarioCreado7 = Crear.usuario(oUsuarioNuevo7, new Estudiante("2018", new BigDecimal(4)));
		var oUsuarioCreado8 = Crear.usuario(oUsuarioNuevo8, new Estudiante("2020", new BigDecimal(3)));
		var oUsuarioCreado9 = Crear.usuario(oUsuarioNuevo9, new Estudiante("2019", new BigDecimal(2)));
		var oUsuarioCreado10 = Crear.usuario(oUsuarioNuevo10, new Estudiante("2023", new BigDecimal(1)));
		var oUsuarioCreado11 = Crear.usuario(oUsuarioNuevo11, new Estudiante("2019", new BigDecimal(3)));

		Area oArea = new Area("Programación");
		Area oArea2 = new Area("Testing");
		Area oArea3 = new Area("Base de Datos");
		Area oArea4 = new Area("Infraestructura");

		var oAreaCreada = ServiceArea.crearArea(oArea);
		var oAreaCreada2 = ServiceArea.crearArea(oArea2);
		var oAreaCreada3 = ServiceArea.crearArea(oArea3);
		var oAreaCreada4 = ServiceArea.crearArea(oArea4);

		var oUsuarioCreado3 = Crear.usuario(oUsuarioNuevo2, new Tutor(oAreaCreada));
		var oUsuarioCreado2 = Crear.usuario(oUsuarioNuevo3, new Tutor(oAreaCreada2));
		var oUsuarioCreado12 = Crear.usuario(oUsuarioNuevo12, new Tutor(oAreaCreada));
		var oUsuarioCreado13 = Crear.usuario(oUsuarioNuevo13, new Tutor(oAreaCreada2));

//		Estudiante oEstudiante = ServiceEstudiante.listarEstudiantes().get(1);
//		Estudiante oEstudiante2 = ServiceEstudiante.listarEstudiantes().get(0);
//
//		var estudiante = ServiceEstudiante.listarEstudiantes().get(0);
//		var estudiante2 = ServiceEstudiante.listarEstudiantes().get(1);

	}

}
