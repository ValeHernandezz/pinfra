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

		// Artigas
		Localidad localidad1 = new Localidad("Artigas", departamentoCreado);
		Localidad localidad2 = new Localidad("Bella Unión", departamentoCreado);
		Localidad localidad3 = new Localidad("Tomás Gomensoro", departamentoCreado);
		Localidad localidad4 = new Localidad("Baltasar Brum", departamentoCreado);
		Localidad localidad5 = new Localidad("Sequeira", departamentoCreado);
		Localidad localidad6 = new Localidad("Franquia", departamentoCreado);
		Localidad localidad7 = new Localidad("Colonia Palma", departamentoCreado);
		Localidad localidad8 = new Localidad("Coronado", departamentoCreado);
		Localidad localidad9 = new Localidad("Bernabé Rivera", departamentoCreado);
		Localidad localidad10 = new Localidad("Portones de Hierro y Campodónico", departamentoCreado);
		Localidad localidad11 = new Localidad("Paso Campamento", departamentoCreado);
		Localidad localidad12 = new Localidad("Javier de Viana", departamentoCreado);
		Localidad localidad13 = new Localidad("Diego Lamas", departamentoCreado);
		Localidad localidad14 = new Localidad("Topador", departamentoCreado);
		Localidad localidad15 = new Localidad("Cuaró", departamentoCreado);

		// Canelones
		Localidad localidad16 = new Localidad("Ciudad de la Costa", departamentoCreado2);
		Localidad localidad17 = new Localidad("Las Piedras", departamentoCreado2);
		Localidad localidad18 = new Localidad("Pando", departamentoCreado2);
		Localidad localidad19 = new Localidad("Barros Blancos", departamentoCreado2);
		Localidad localidad20 = new Localidad("Canelones", departamentoCreado2);
		Localidad localidad21 = new Localidad("Salinas", departamentoCreado2);
		Localidad localidad22 = new Localidad("18 de Mayo", departamentoCreado2);
		Localidad localidad23 = new Localidad("Paso Carrasco", departamentoCreado2);
		Localidad localidad24 = new Localidad("La Paz", departamentoCreado2);
		Localidad localidad25 = new Localidad("Toledo", departamentoCreado2);
		Localidad localidad26 = new Localidad("Santa Lucía", departamentoCreado2);
		Localidad localidad27 = new Localidad("Suárez", departamentoCreado2);
		Localidad localidad28 = new Localidad("Nicolich", departamentoCreado2);
		Localidad localidad29 = new Localidad("Progreso", departamentoCreado2);
		Localidad localidad30 = new Localidad("Sauce", departamentoCreado2);
		Localidad localidad31 = new Localidad("Parque del Plata", departamentoCreado2);
		Localidad localidad32 = new Localidad("Atlántida", departamentoCreado2);
		Localidad localidad33 = new Localidad("Tala", departamentoCreado2);
		Localidad localidad34 = new Localidad("La Floresta", departamentoCreado2);
		Localidad localidad35 = new Localidad("San Ramón", departamentoCreado2);
		Localidad localidad36 = new Localidad("Los Cerrillos", departamentoCreado2);
		Localidad localidad37 = new Localidad("Santa Rosa", departamentoCreado2);
		Localidad localidad38 = new Localidad("San Jacinto", departamentoCreado2);
		Localidad localidad39 = new Localidad("Empalme Olmos", departamentoCreado2);
		Localidad localidad40 = new Localidad("Soca", departamentoCreado2);
		Localidad localidad41 = new Localidad("Migues", departamentoCreado2);
		Localidad localidad42 = new Localidad("San Bautista", departamentoCreado2);
		Localidad localidad43 = new Localidad("San Antonio", departamentoCreado2);
		Localidad localidad44 = new Localidad("Aguas Corrientes", departamentoCreado2);
		Localidad localidad45 = new Localidad("Montes", departamentoCreado2);

		// Cerro Largo
		Localidad localidad46 = new Localidad("Melo", departamentoCreado3);
		Localidad localidad47 = new Localidad("Río Branco", departamentoCreado3);
		Localidad localidad48 = new Localidad("Fraile Muerto", departamentoCreado3);
		Localidad localidad49 = new Localidad("Isidoro Noblía", departamentoCreado3);
		Localidad localidad51 = new Localidad("Barrio Hipódromo", departamentoCreado3);
		Localidad localidad52 = new Localidad("Aceguá", departamentoCreado3);
		Localidad localidad53 = new Localidad("Tupambaé", departamentoCreado3);
		Localidad localidad54 = new Localidad("Plácido Rosas", departamentoCreado3);
		Localidad localidad55 = new Localidad("Arévalo", departamentoCreado3);
		Localidad localidad56 = new Localidad("Barrio López Benítez", departamentoCreado3);
		Localidad localidad57 = new Localidad("Ramón Trigo", departamentoCreado3);
		Localidad localidad58 = new Localidad("Barrio La Vinchuca", departamentoCreado3);
		Localidad localidad59 = new Localidad("Arbolito", departamentoCreado3);
		Localidad localidad60 = new Localidad("Cerro de las Cuentas", departamentoCreado3);
		Localidad localidad61 = new Localidad("Bañado de Medina", departamentoCreado3);
		Localidad localidad62 = new Localidad("Tres Islas", departamentoCreado3);
		Localidad localidad63 = new Localidad("La Pedrera", departamentoCreado3);
		Localidad localidad64 = new Localidad("Las Cañas", departamentoCreado3);
		Localidad localidad65 = new Localidad("Quebracho", departamentoCreado3);
		Localidad localidad66 = new Localidad("Centurión", departamentoCreado3);
		Localidad localidad67 = new Localidad("Esperanza", departamentoCreado3);
		Localidad localidad68 = new Localidad("Arachania", departamentoCreado3);
		Localidad localidad69 = new Localidad("Nando", departamentoCreado3);
		Localidad localidad70 = new Localidad("Soto Goro", departamentoCreado3);
		Localidad localidad71 = new Localidad("Mangrullo", departamentoCreado3);
		Localidad localidad72 = new Localidad("Ñangapiré", departamentoCreado3);

		// Colonia
		Localidad localidad73 = new Localidad("Colonia del Sacramento", departamentoCreado4);
		Localidad localidad74 = new Localidad("Carmelo", departamentoCreado4);
		Localidad localidad75 = new Localidad("Juan Lacaze", departamentoCreado4);
		Localidad localidad76 = new Localidad("Nueva Helvecia", departamentoCreado4);
		Localidad localidad77 = new Localidad("Rosario", departamentoCreado4);
		Localidad localidad78 = new Localidad("Nueva Palmira", departamentoCreado4);
		Localidad localidad79 = new Localidad("Tarariras", departamentoCreado4);
		Localidad localidad80 = new Localidad("Colonia Valdense", departamentoCreado4);
		Localidad localidad81 = new Localidad("Florencio Sánchez", departamentoCreado4);
		Localidad localidad82 = new Localidad("Ombúes de Lavalle", departamentoCreado4);
		Localidad localidad83 = new Localidad("Miguelete", departamentoCreado4);
		Localidad localidad84 = new Localidad("La Paz", departamentoCreado4);
		Localidad localidad85 = new Localidad("El Semillero", departamentoCreado4);
		Localidad localidad86 = new Localidad("Colonia Cosmopolita", departamentoCreado4);
		Localidad localidad87 = new Localidad("Conchillas", departamentoCreado4);
		Localidad localidad88 = new Localidad("Pueblo Gil", departamentoCreado4);
		Localidad localidad89 = new Localidad("Campana", departamentoCreado4);
		Localidad localidad90 = new Localidad("Radial Conchillas", departamentoCreado4);
		Localidad localidad91 = new Localidad("Estanzuela", departamentoCreado4);
		Localidad localidad92 = new Localidad("Santa Ana", departamentoCreado4);
		Localidad localidad93 = new Localidad("Los Pinos", departamentoCreado4);
		Localidad localidad94 = new Localidad("Barker", departamentoCreado4);
		Localidad localidad95 = new Localidad("Riachuelo", departamentoCreado4);
		Localidad localidad96 = new Localidad("Laguna de los Patos", departamentoCreado4);
		Localidad localidad97 = new Localidad("Minuano", departamentoCreado4);
		Localidad localidad98 = new Localidad("Arrivillaga", departamentoCreado4);
		Localidad localidad99 = new Localidad("Playa Britópolis", departamentoCreado4);
		Localidad localidad100 = new Localidad("La Horqueta", departamentoCreado4);
		Localidad localidad101 = new Localidad("Zagarzazú", departamentoCreado4);
		Localidad localidad102 = new Localidad("Playa Fomento", departamentoCreado4);

		// Durazno
		Localidad localidad103 = new Localidad("Durazno", departamentoCreado5);
		Localidad localidad104 = new Localidad("Sarandí del Yí", departamentoCreado5);
		Localidad localidad105 = new Localidad("Villa del Carmen", departamentoCreado5);
		Localidad localidad106 = new Localidad("La Paloma", departamentoCreado5);
		Localidad localidad107 = new Localidad("Centenario", departamentoCreado5);
		Localidad localidad108 = new Localidad("Santa Bernardina", departamentoCreado5);
		Localidad localidad109 = new Localidad("Blanquillo", departamentoCreado5);
		Localidad localidad110 = new Localidad("Carlos Reyles", departamentoCreado5);
		Localidad localidad111 = new Localidad("San Jorge", departamentoCreado5);
		Localidad localidad112 = new Localidad("Baygorria", departamentoCreado5);
		Localidad localidad113 = new Localidad("Ombúes de Oribe", departamentoCreado5);
		Localidad localidad114 = new Localidad("Aguas Buenas", departamentoCreado5);
		Localidad localidad115 = new Localidad("Feliciano", departamentoCreado5);
		Localidad localidad116 = new Localidad("Rossell y Rius", departamentoCreado5);
		Localidad localidad117 = new Localidad("Pueblo de Álvarez", departamentoCreado5);
		Localidad localidad118 = new Localidad("Las Palmas", departamentoCreado5);

		// Flores
		Localidad localidad119 = new Localidad("Trinidad", departamentoCreado6);
		Localidad localidad120 = new Localidad("Ismael Cortinas", departamentoCreado6);
		Localidad localidad121 = new Localidad("Andresito", departamentoCreado6);
		Localidad localidad122 = new Localidad("La Casilla", departamentoCreado6);
		Localidad localidad123 = new Localidad("Juan José Castro", departamentoCreado6);
		Localidad localidad124 = new Localidad("Cerro Colorado", departamentoCreado6);

		// Florida
		Localidad localidad125 = new Localidad("Florida", departamentoCreado7);
		Localidad localidad126 = new Localidad("Sarandí Grande", departamentoCreado7);
		Localidad localidad127 = new Localidad("Fray Marcos", departamentoCreado7);
		Localidad localidad128 = new Localidad("Cerro Chato", departamentoCreado7);
		Localidad localidad129 = new Localidad("Casupá", departamentoCreado7);
		Localidad localidad130 = new Localidad("25 de Mayo", departamentoCreado7);
		Localidad localidad131 = new Localidad("25 de Agosto", departamentoCreado7);
		Localidad localidad132 = new Localidad("Alejandro Gallinal", departamentoCreado7);
		Localidad localidad133 = new Localidad("Cardal", departamentoCreado7);
		Localidad localidad134 = new Localidad("Nico Pérez", departamentoCreado7);
		Localidad localidad135 = new Localidad("Capilla del Sauce", departamentoCreado7);
		Localidad localidad136 = new Localidad("Mendoza Chico", departamentoCreado7);
		Localidad localidad137 = new Localidad("La Cruz", departamentoCreado7);
		Localidad localidad138 = new Localidad("Mendoza", departamentoCreado7);
		Localidad localidad139 = new Localidad("San Gabriel", departamentoCreado7);
		Localidad localidad140 = new Localidad("Chamizo", departamentoCreado7);
		Localidad localidad141 = new Localidad("Independencia", departamentoCreado7);
		Localidad localidad142 = new Localidad("Reboledo", departamentoCreado7);
		Localidad localidad143 = new Localidad("Goñi", departamentoCreado7);
		Localidad localidad144 = new Localidad("Valentines", departamentoCreado7);
		Localidad localidad145 = new Localidad("Pintado", departamentoCreado7);
		Localidad localidad146 = new Localidad("Berrondo", departamentoCreado7);
		Localidad localidad147 = new Localidad("Puntas de Maciel", departamentoCreado7);
		Localidad localidad148 = new Localidad("Illescas", departamentoCreado7);
		Localidad localidad149 = new Localidad("La Macana", departamentoCreado7);
		Localidad localidad150 = new Localidad("Montecoral", departamentoCreado7);
		Localidad localidad151 = new Localidad("Estación Capilla del Sauce", departamentoCreado7);
		Localidad localidad152 = new Localidad("Polanco del Yí", departamentoCreado7);
		Localidad localidad153 = new Localidad("Caserío La Fundación", departamentoCreado7);

		// Lavalleja
		Localidad localidad154 = new Localidad("Minas", departamentoCreado8);
		Localidad localidad155 = new Localidad("José Pedro Varela", departamentoCreado8);
		Localidad localidad156 = new Localidad("Solís de Mataojo", departamentoCreado8);
		Localidad localidad157 = new Localidad("José Batlle y Ordóñez", departamentoCreado8);
		Localidad localidad158 = new Localidad("Mariscala", departamentoCreado8);
		Localidad localidad159 = new Localidad("Pirarajá", departamentoCreado8);
		Localidad localidad160 = new Localidad("Zapicán", departamentoCreado8);
		Localidad localidad161 = new Localidad("Colón", departamentoCreado8);
		Localidad localidad162 = new Localidad("Villa del Rosario", departamentoCreado8);
		Localidad localidad163 = new Localidad("Illescas", departamentoCreado8);
		Localidad localidad164 = new Localidad("Blanes Viale", departamentoCreado8);
		Localidad localidad165 = new Localidad("Aramendía", departamentoCreado8);
		Localidad localidad166 = new Localidad("Villa Serrana", departamentoCreado8);
		Localidad localidad167 = new Localidad("Polanco Norte", departamentoCreado8);
		Localidad localidad168 = new Localidad("San Francisco de las Sierras", departamentoCreado8);
		Localidad localidad169 = new Localidad("19 de Junio", departamentoCreado8);
		Localidad localidad170 = new Localidad("Estación Solís", departamentoCreado8);
		Localidad localidad171 = new Localidad("Gaetán", departamentoCreado8);

		// Maldonado
		Localidad localidad172 = new Localidad("Maldonado", departamentoCreado9);
		Localidad localidad173 = new Localidad("San Carlos", departamentoCreado9);
		Localidad localidad174 = new Localidad("Piriápolis", departamentoCreado9);
		Localidad localidad175 = new Localidad("Punta del Este", departamentoCreado9);
		Localidad localidad176 = new Localidad("Pan de Azúcar", departamentoCreado9);
		Localidad localidad177 = new Localidad("Aiguá", departamentoCreado9);
		Localidad localidad178 = new Localidad("Solís Grande", departamentoCreado9);
		Localidad localidad179 = new Localidad("Garzón", departamentoCreado9);

		// Montevideo
		Localidad localidad180 = new Localidad("Montevideo A", departamentoCreado10);
		Localidad localidad181 = new Localidad("Montevideo B", departamentoCreado10);
		Localidad localidad182 = new Localidad("Montevideo C", departamentoCreado10);
		Localidad localidad183 = new Localidad("Montevideo CH", departamentoCreado10);
		Localidad localidad184 = new Localidad("Montevideo D", departamentoCreado10);
		Localidad localidad185 = new Localidad("Montevideo E", departamentoCreado10);
		Localidad localidad186 = new Localidad("Montevideo F", departamentoCreado10);
		Localidad localidad187 = new Localidad("Montevideo G", departamentoCreado10);

		// Paysandú
		Localidad localidad188 = new Localidad("Paysandú", departamentoCreado11);
		Localidad localidad189 = new Localidad("Nuevo Paysandú", departamentoCreado11);
		Localidad localidad190 = new Localidad("Guichón", departamentoCreado11);
		Localidad localidad191 = new Localidad("Porvenir", departamentoCreado11);
		Localidad localidad192 = new Localidad("Chacras de Paysandú", departamentoCreado11);
		Localidad localidad193 = new Localidad("Quebracho", departamentoCreado11);
		Localidad localidad194 = new Localidad("Piedras Coloradas", departamentoCreado11);
		Localidad localidad195 = new Localidad("San Félix", departamentoCreado11);
		Localidad localidad196 = new Localidad("Lorenzo Geyres", departamentoCreado11);
		Localidad localidad197 = new Localidad("Tambores", departamentoCreado11);
		Localidad localidad198 = new Localidad("Chapicuy", departamentoCreado11);
		Localidad localidad199 = new Localidad("Gallinal", departamentoCreado11);
		Localidad localidad200 = new Localidad("Casa Blanca", departamentoCreado11);
		Localidad localidad201 = new Localidad("Cerro Chato", departamentoCreado11);
		Localidad localidad202 = new Localidad("El Eucalipto", departamentoCreado11);
		Localidad localidad203 = new Localidad("Cañada del Pueblo", departamentoCreado11);
		Localidad localidad204 = new Localidad("Zeballos", departamentoCreado11);
		Localidad localidad205 = new Localidad("Villa María", departamentoCreado11);
		Localidad localidad206 = new Localidad("Soto", departamentoCreado11);
		Localidad localidad207 = new Localidad("Federación", departamentoCreado11);
		Localidad localidad208 = new Localidad("Cuchilla de Buricayupí", departamentoCreado11);
		Localidad localidad209 = new Localidad("Poblado Alonso", departamentoCreado11);

		// Río Negro
		Localidad localidad210 = new Localidad("Fray Bentos", departamentoCreado12);
		Localidad localidad211 = new Localidad("Young", departamentoCreado12);
		Localidad localidad212 = new Localidad("San Javier", departamentoCreado12);
		Localidad localidad213 = new Localidad("Nuevo Berlín", departamentoCreado12);
		Localidad localidad214 = new Localidad("Barrio Anglo", departamentoCreado12);
		Localidad localidad215 = new Localidad("Algorta", departamentoCreado12);
		Localidad localidad216 = new Localidad("Grecco", departamentoCreado12);
		Localidad localidad217 = new Localidad("Villa General Borges", departamentoCreado12);
		Localidad localidad218 = new Localidad("Paso de los Mellizos", departamentoCreado12);
		Localidad localidad219 = new Localidad("Bellaco", departamentoCreado12);
		Localidad localidad220 = new Localidad("Los Arrayanes", departamentoCreado12);
		Localidad localidad221 = new Localidad("Sarandí de Navarro", departamentoCreado12);
		Localidad localidad222 = new Localidad("Villa María", departamentoCreado12);
		Localidad localidad223 = new Localidad("Las Cañas", departamentoCreado12);
		Localidad localidad224 = new Localidad("Tres Quintas", departamentoCreado12);
		Localidad localidad225 = new Localidad("El Ombú", departamentoCreado12);
		Localidad localidad226 = new Localidad("Menafra", departamentoCreado12);
		Localidad localidad227 = new Localidad("Colonia Ofir", departamentoCreado12);
		Localidad localidad228 = new Localidad("Gartental", departamentoCreado12);

		// Rivera
		Localidad localidad229 = new Localidad("Rivera", departamentoCreado13);
		Localidad localidad230 = new Localidad("Tranqueras", departamentoCreado13);
		Localidad localidad231 = new Localidad("Cerros de la Calera", departamentoCreado13);
		Localidad localidad232 = new Localidad("Vichadero", departamentoCreado13);
		Localidad localidad233 = new Localidad("Minas de Corrales", departamentoCreado13);
		Localidad localidad234 = new Localidad("Las Flores", departamentoCreado13);
		Localidad localidad235 = new Localidad("La Puente", departamentoCreado13);
		Localidad localidad236 = new Localidad("Paso Hospital", departamentoCreado13);
		Localidad localidad237 = new Localidad("Lagos del Norte", departamentoCreado13);
		Localidad localidad238 = new Localidad("Masoller", departamentoCreado13);
		Localidad localidad239 = new Localidad("Moirones", departamentoCreado13);
		Localidad localidad240 = new Localidad("Cerro Pelado", departamentoCreado13);
		Localidad localidad241 = new Localidad("Cerrillada", departamentoCreado13);
		Localidad localidad242 = new Localidad("Paso Ataques", departamentoCreado13);
		Localidad localidad243 = new Localidad("Arroyo Blanco", departamentoCreado13);
		Localidad localidad245 = new Localidad("Amarillo", departamentoCreado13);

		// Rocha
		Localidad localidad246 = new Localidad("Rocha", departamentoCreado14);
		Localidad localidad247 = new Localidad("Chuy", departamentoCreado14);
		Localidad localidad248 = new Localidad("Castillos", departamentoCreado14);
		Localidad localidad249 = new Localidad("La Paloma", departamentoCreado14);
		Localidad localidad250 = new Localidad("Cebollatí", departamentoCreado14);
		Localidad localidad251 = new Localidad("Velázquez", departamentoCreado14);
		Localidad localidad252 = new Localidad("18 de Julio", departamentoCreado14);
		Localidad localidad253 = new Localidad("Punta del Diablo", departamentoCreado14);
		Localidad localidad254 = new Localidad("San Luis al Medio", departamentoCreado14);
		Localidad localidad255 = new Localidad("Capacho", departamentoCreado14);
		Localidad localidad256 = new Localidad("La Coronilla", departamentoCreado14);
		Localidad localidad257 = new Localidad("Puimayen", departamentoCreado14);
		Localidad localidad258 = new Localidad("Barra del Chuy", departamentoCreado14);
		Localidad localidad259 = new Localidad("Barra de Valizas", departamentoCreado14);
		Localidad localidad260 = new Localidad("19 de Abril", departamentoCreado14);
		Localidad localidad261 = new Localidad("Barrio Pereira", departamentoCreado14);
		Localidad localidad262 = new Localidad("Santa Isabel de la Pedrera", departamentoCreado14);
		Localidad localidad263 = new Localidad("Barrio Torres", departamentoCreado14);
		Localidad localidad264 = new Localidad("Puente Valizas", departamentoCreado14);
		Localidad localidad265 = new Localidad("La Riviera", departamentoCreado14);
		Localidad localidad266 = new Localidad("Puerto de los Botes", departamentoCreado14);
		Localidad localidad267 = new Localidad("Parallé", departamentoCreado14);
		Localidad localidad268 = new Localidad("Palmares de la Coronilla", departamentoCreado14);
		Localidad localidad269 = new Localidad("Pueblo Nuevo", departamentoCreado14);
		Localidad localidad270 = new Localidad("Oceanía del Polonio", departamentoCreado14);
		Localidad localidad271 = new Localidad("Tajamares de la Pedrera", departamentoCreado14);
		Localidad localidad272 = new Localidad("Barrancas", departamentoCreado14);
		Localidad localidad273 = new Localidad("Cabo Polonio", departamentoCreado14);

		// Salto
		Localidad localidad274 = new Localidad("Salto", departamentoCreado15);
		Localidad localidad275 = new Localidad("Villa Constitución", departamentoCreado15);
		Localidad localidad276 = new Localidad("San Antonio", departamentoCreado15);
		Localidad localidad277 = new Localidad("Colonia Lavalleja", departamentoCreado15);
		Localidad localidad278 = new Localidad("Belén", departamentoCreado15);
		Localidad localidad279 = new Localidad("Rincón de Valentín", departamentoCreado15);
		Localidad localidad280 = new Localidad("Mataojo", departamentoCreado15);
		Localidad localidad281 = new Localidad("Colonia 18 de Julio", departamentoCreado15);
		Localidad localidad282 = new Localidad("Migliaro", departamentoCreado15);
		Localidad localidad283 = new Localidad("Colonia Itapebí", departamentoCreado15);
		Localidad localidad284 = new Localidad("Termas del Daymán", departamentoCreado15);
		Localidad localidad285 = new Localidad("Termas del Arapey", departamentoCreado15);
		Localidad localidad286 = new Localidad("Campo de Todos", departamentoCreado15);
		Localidad localidad287 = new Localidad("Puntas de Valentín", departamentoCreado15);
		Localidad localidad288 = new Localidad("Cerros de Vera", departamentoCreado15);
		Localidad localidad289 = new Localidad("Arenitas Blancas", departamentoCreado15);
		Localidad localidad290 = new Localidad("Laureles", departamentoCreado15);
		Localidad localidad291 = new Localidad("Paso Cementerio", departamentoCreado15);
		Localidad localidad292 = new Localidad("Arerunguá", departamentoCreado15);
		Localidad localidad293 = new Localidad("Pueblo Cayetano", departamentoCreado15);
		Localidad localidad294 = new Localidad("Paso del Parque del Daymán", departamentoCreado15);

		// San José
		Localidad localidad295 = new Localidad("San José de Mayo", departamentoCreado16);
		Localidad localidad296 = new Localidad("Ciudad del Plata", departamentoCreado16);
		Localidad localidad297 = new Localidad("Libertad", departamentoCreado16);
		Localidad localidad298 = new Localidad("Ecilda Paullier", departamentoCreado16);
		Localidad localidad299 = new Localidad("Rodríguez", departamentoCreado16);
		Localidad localidad300 = new Localidad("Puntas de Valdez", departamentoCreado16);
		Localidad localidad301 = new Localidad("Rafael Perazza", departamentoCreado16);
		Localidad localidad302 = new Localidad("Ituzaingó", departamentoCreado16);
		Localidad localidad303 = new Localidad("Raigón", departamentoCreado16);
		Localidad localidad304 = new Localidad("Villa María", departamentoCreado16);
		Localidad localidad305 = new Localidad("Capurro", departamentoCreado16);
		Localidad localidad306 = new Localidad("18 de Julio-Pueblo Nuevo", departamentoCreado16);
		Localidad localidad307 = new Localidad("Mal Abrigo", departamentoCreado16);
		Localidad localidad308 = new Localidad("Juan Soler", departamentoCreado16);
		Localidad localidad309 = new Localidad("Kiyú-Ordeig", departamentoCreado16);
		Localidad localidad310 = new Localidad("La Radial", departamentoCreado16);
		Localidad localidad311 = new Localidad("González", departamentoCreado16);
		Localidad localidad312 = new Localidad("Scavino", departamentoCreado16);
		Localidad localidad313 = new Localidad("Rincón del Pino", departamentoCreado16);
		Localidad localidad314 = new Localidad("Cololó", departamentoCreado16);
		Localidad localidad315 = new Localidad("Costas de Pereira", departamentoCreado16);
		Localidad localidad316 = new Localidad("Carreta Quemada", departamentoCreado16);
		Localidad localidad317 = new Localidad("Cerámicas del Sur", departamentoCreado16);
		Localidad localidad318 = new Localidad("Mangrullo", departamentoCreado16);
		Localidad localidad319 = new Localidad("La Boyada", departamentoCreado16);
		Localidad localidad320 = new Localidad("Cañada Grande - Fabre", departamentoCreado16);
		Localidad localidad321 = new Localidad("Colonia Delta", departamentoCreado16);
		Localidad localidad322 = new Localidad("San Gregorio", departamentoCreado16);
		Localidad localidad323 = new Localidad("Bocas del Cufré", departamentoCreado16);

		// Soriano
		Localidad localidad324 = new Localidad("Mercedes", departamentoCreado17);
		Localidad localidad325 = new Localidad("Dolores", departamentoCreado17);
		Localidad localidad326 = new Localidad("Cardona", departamentoCreado17);
		Localidad localidad327 = new Localidad("José Enrique Rodó", departamentoCreado17);
		Localidad localidad328 = new Localidad("Palmitas", departamentoCreado17);
		Localidad localidad329 = new Localidad("Chacras de Dolores", departamentoCreado17);
		Localidad localidad330 = new Localidad("Villa Soriano", departamentoCreado17);
		Localidad localidad331 = new Localidad("Santa Catalina", departamentoCreado17);
		Localidad localidad332 = new Localidad("Egaña", departamentoCreado17);
		Localidad localidad333 = new Localidad("Agraciada", departamentoCreado17);
		Localidad localidad334 = new Localidad("Risso", departamentoCreado17);
		Localidad localidad335 = new Localidad("Sacachispas", departamentoCreado17);
		Localidad localidad336 = new Localidad("Cañada Nieto", departamentoCreado17);
		Localidad localidad337 = new Localidad("Palmar", departamentoCreado17);
		Localidad localidad338 = new Localidad("Palo Solo", departamentoCreado17);
		Localidad localidad339 = new Localidad("Castillos", departamentoCreado17);
		Localidad localidad340 = new Localidad("Perseverano", departamentoCreado17);
		Localidad localidad341 = new Localidad("La Loma", departamentoCreado17);
		Localidad localidad342 = new Localidad("Lares", departamentoCreado17);
		Localidad localidad343 = new Localidad("La Concordia", departamentoCreado17);
		Localidad localidad344 = new Localidad("El Tala", departamentoCreado17);
		Localidad localidad345 = new Localidad("Colonia Concordia", departamentoCreado17);
		Localidad localidad346 = new Localidad("Cuchilla del Perdido", departamentoCreado17);

		// Tacuarembó
		Localidad localidad347 = new Localidad("Tacuarembó", departamentoCreado18);
		Localidad localidad348 = new Localidad("Paso de los Toros", departamentoCreado18);
		Localidad localidad349 = new Localidad("San Gregorio de Polanco", departamentoCreado18);
		Localidad localidad350 = new Localidad("Ansina", departamentoCreado18);
		Localidad localidad351 = new Localidad("Tambores", departamentoCreado18);
		Localidad localidad352 = new Localidad("Las Toscas", departamentoCreado18);
		Localidad localidad353 = new Localidad("Curtina", departamentoCreado18);
		Localidad localidad354 = new Localidad("Achar", departamentoCreado18);
		Localidad localidad355 = new Localidad("Paso Bonilla", departamentoCreado18);
		Localidad localidad356 = new Localidad("Cuchilla de Caraguatá", departamentoCreado18);
		Localidad localidad357 = new Localidad("Balneario Iporá", departamentoCreado18);
		Localidad localidad358 = new Localidad("La Pedrera", departamentoCreado18);
		Localidad localidad359 = new Localidad("Paso del Cerro", departamentoCreado18);
		Localidad localidad360 = new Localidad("Cuchilla de Peralta", departamentoCreado18);
		Localidad localidad361 = new Localidad("Piedra Sola", departamentoCreado18);
		Localidad localidad362 = new Localidad("Pueblo de Arriba", departamentoCreado18);
		Localidad localidad363 = new Localidad("Clara", departamentoCreado18);
		Localidad localidad364 = new Localidad("Sauce de Batoví", departamentoCreado18);
		Localidad localidad365 = new Localidad("Punta de Carretera", departamentoCreado18);
		Localidad localidad366 = new Localidad("La Hilera", departamentoCreado18);
		Localidad localidad367 = new Localidad("Pueblo del Barro", departamentoCreado18);
		Localidad localidad368 = new Localidad("Cuchilla del Ombú", departamentoCreado18);
		Localidad localidad369 = new Localidad("Puntas de Cinco Sauces", departamentoCreado18);
		Localidad localidad370 = new Localidad("Cardozo", departamentoCreado18);
		Localidad localidad371 = new Localidad("Montevideo Chico", departamentoCreado18);
		Localidad localidad372 = new Localidad("Rincón de Pereira", departamentoCreado18);
		Localidad localidad373 = new Localidad("Laureles", departamentoCreado18);
		
		// Treinta y Tres
		Localidad localidad374 = new Localidad("Treinta y Tres", departamentoCreado19);
		Localidad localidad375 = new Localidad("Ejido de Treinta y Tres", departamentoCreado19);
		Localidad localidad376 = new Localidad("Vergara", departamentoCreado19);
		Localidad localidad377 = new Localidad("Cerro Chato", departamentoCreado19);
		Localidad localidad378 = new Localidad("Santa Clara de Olimar", departamentoCreado19);
		Localidad localidad379 = new Localidad("General Enrique Martínez", departamentoCreado19);
		Localidad localidad380 = new Localidad("Estación Rincón", departamentoCreado19);
		Localidad localidad381 = new Localidad("Arrozal Treinta y Tres", departamentoCreado19);
		Localidad localidad382 = new Localidad("Isla Patrulla", departamentoCreado19);
		Localidad localidad383 = new Localidad("Valentines", departamentoCreado19);
		Localidad localidad384 = new Localidad("Arrocera Zapata", departamentoCreado19);
		Localidad localidad385 = new Localidad("Mendizábal", departamentoCreado19);
		Localidad localidad386 = new Localidad("Arrocera San Fernando", departamentoCreado19);
		Localidad localidad387 = new Localidad("María Albina", departamentoCreado19);
		Localidad localidad388 = new Localidad("Arrocera Rincón", departamentoCreado19);
		Localidad localidad389 = new Localidad("El Bellaco", departamentoCreado19);
		Localidad localidad390 = new Localidad("Arrocera Mini", departamentoCreado19);
		Localidad localidad391 = new Localidad("Arrocera Las Palmas", departamentoCreado19);
		Localidad localidad392 = new Localidad("Arrocera El Tigre", departamentoCreado19);
		Localidad localidad393 = new Localidad("Arrocera La Catumbera", departamentoCreado19);
		Localidad localidad394 = new Localidad("Arrocera La Querencia", departamentoCreado19);
		Localidad localidad395 = new Localidad("Arrocera Santa Fé", departamentoCreado19);
		Localidad localidad396 = new Localidad("Arrocera Los Teros", departamentoCreado19);
		Localidad localidad397 = new Localidad("Arrocera Procipa", departamentoCreado19);
		Localidad localidad398 = new Localidad("Alonso", departamentoCreado19);
		Localidad localidad399 = new Localidad("Villa Passano", departamentoCreado19);
		Localidad localidad400 = new Localidad("Puntas del Parao", departamentoCreado19);
		Localidad localidad401 = new Localidad("Arrocera Bonomo", departamentoCreado19);
		Localidad localidad402 = new Localidad("Arrocera Los Ceibos", departamentoCreado19);
		
		
		var localidadCreada1 = ServiceUbicacion.crearLocalidad(localidad1);
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
		var localidadCreada51 = ServiceUbicacion.crearLocalidad(localidad51);
		var localidadCreada52 = ServiceUbicacion.crearLocalidad(localidad52);
		var localidadCreada53 = ServiceUbicacion.crearLocalidad(localidad53);
		var localidadCreada54 = ServiceUbicacion.crearLocalidad(localidad54);
		var localidadCreada55 = ServiceUbicacion.crearLocalidad(localidad55);
		var localidadCreada56 = ServiceUbicacion.crearLocalidad(localidad56);
		var localidadCreada57 = ServiceUbicacion.crearLocalidad(localidad57);
		var localidadCreada58 = ServiceUbicacion.crearLocalidad(localidad58);
		var localidadCreada59 = ServiceUbicacion.crearLocalidad(localidad59);
		var localidadCreada60 = ServiceUbicacion.crearLocalidad(localidad60);
		var localidadCreada61 = ServiceUbicacion.crearLocalidad(localidad61);
		var localidadCreada62 = ServiceUbicacion.crearLocalidad(localidad62);
		var localidadCreada63 = ServiceUbicacion.crearLocalidad(localidad63);
		var localidadCreada64 = ServiceUbicacion.crearLocalidad(localidad64);
		var localidadCreada65 = ServiceUbicacion.crearLocalidad(localidad65);
		var localidadCreada66 = ServiceUbicacion.crearLocalidad(localidad66);
		var localidadCreada67 = ServiceUbicacion.crearLocalidad(localidad67);
		var localidadCreada68 = ServiceUbicacion.crearLocalidad(localidad68);
		var localidadCreada69 = ServiceUbicacion.crearLocalidad(localidad69);
		var localidadCreada70 = ServiceUbicacion.crearLocalidad(localidad70);
		var localidadCreada71 = ServiceUbicacion.crearLocalidad(localidad71);
		var localidadCreada72 = ServiceUbicacion.crearLocalidad(localidad72);
		var localidadCreada73 = ServiceUbicacion.crearLocalidad(localidad73);
		var localidadCreada74 = ServiceUbicacion.crearLocalidad(localidad74);
		var localidadCreada75 = ServiceUbicacion.crearLocalidad(localidad75);
		var localidadCreada76 = ServiceUbicacion.crearLocalidad(localidad76);
		var localidadCreada77 = ServiceUbicacion.crearLocalidad(localidad77);
		var localidadCreada78 = ServiceUbicacion.crearLocalidad(localidad78);
		var localidadCreada79 = ServiceUbicacion.crearLocalidad(localidad79);
		var localidadCreada80 = ServiceUbicacion.crearLocalidad(localidad80);
		var localidadCreada81 = ServiceUbicacion.crearLocalidad(localidad81);
		var localidadCreada82 = ServiceUbicacion.crearLocalidad(localidad82);
		var localidadCreada83 = ServiceUbicacion.crearLocalidad(localidad83);
		var localidadCreada84 = ServiceUbicacion.crearLocalidad(localidad84);
		var localidadCreada85 = ServiceUbicacion.crearLocalidad(localidad85);
		var localidadCreada86 = ServiceUbicacion.crearLocalidad(localidad86);
		var localidadCreada87 = ServiceUbicacion.crearLocalidad(localidad87);
		var localidadCreada88 = ServiceUbicacion.crearLocalidad(localidad88);
		var localidadCreada89 = ServiceUbicacion.crearLocalidad(localidad89);
		var localidadCreada90 = ServiceUbicacion.crearLocalidad(localidad90);
		var localidadCreada91 = ServiceUbicacion.crearLocalidad(localidad91);
		var localidadCreada92 = ServiceUbicacion.crearLocalidad(localidad92);
		var localidadCreada93 = ServiceUbicacion.crearLocalidad(localidad93);
		var localidadCreada94 = ServiceUbicacion.crearLocalidad(localidad94);
		var localidadCreada95 = ServiceUbicacion.crearLocalidad(localidad95);
		var localidadCreada96 = ServiceUbicacion.crearLocalidad(localidad96);
		var localidadCreada97 = ServiceUbicacion.crearLocalidad(localidad97);
		var localidadCreada98 = ServiceUbicacion.crearLocalidad(localidad98);
		var localidadCreada99 = ServiceUbicacion.crearLocalidad(localidad99);
		var localidadCreada100 = ServiceUbicacion.crearLocalidad(localidad100);
		var localidadCreada101 = ServiceUbicacion.crearLocalidad(localidad101);
		var localidadCreada102 = ServiceUbicacion.crearLocalidad(localidad102);
		var localidadCreada103 = ServiceUbicacion.crearLocalidad(localidad103);
		var localidadCreada104 = ServiceUbicacion.crearLocalidad(localidad104);
		var localidadCreada105 = ServiceUbicacion.crearLocalidad(localidad105);
		var localidadCreada106 = ServiceUbicacion.crearLocalidad(localidad106);
		var localidadCreada107 = ServiceUbicacion.crearLocalidad(localidad107);
		var localidadCreada108 = ServiceUbicacion.crearLocalidad(localidad108);
		var localidadCreada109 = ServiceUbicacion.crearLocalidad(localidad109);
		var localidadCreada110 = ServiceUbicacion.crearLocalidad(localidad110);
		var localidadCreada111 = ServiceUbicacion.crearLocalidad(localidad111);
		var localidadCreada112 = ServiceUbicacion.crearLocalidad(localidad112);
		var localidadCreada113 = ServiceUbicacion.crearLocalidad(localidad113);
		var localidadCreada114 = ServiceUbicacion.crearLocalidad(localidad114);
		var localidadCreada115 = ServiceUbicacion.crearLocalidad(localidad115);
		var localidadCreada116 = ServiceUbicacion.crearLocalidad(localidad116);
		var localidadCreada117 = ServiceUbicacion.crearLocalidad(localidad117);
		var localidadCreada118 = ServiceUbicacion.crearLocalidad(localidad118);
		var localidadCreada119 = ServiceUbicacion.crearLocalidad(localidad119);
		var localidadCreada120 = ServiceUbicacion.crearLocalidad(localidad120);
		var localidadCreada121 = ServiceUbicacion.crearLocalidad(localidad121);
		var localidadCreada122 = ServiceUbicacion.crearLocalidad(localidad122);
		var localidadCreada123 = ServiceUbicacion.crearLocalidad(localidad123);
		var localidadCreada124 = ServiceUbicacion.crearLocalidad(localidad124);
		var localidadCreada125 = ServiceUbicacion.crearLocalidad(localidad125);
		var localidadCreada126 = ServiceUbicacion.crearLocalidad(localidad126);
		var localidadCreada127 = ServiceUbicacion.crearLocalidad(localidad127);
		var localidadCreada128 = ServiceUbicacion.crearLocalidad(localidad128);
		var localidadCreada131 = ServiceUbicacion.crearLocalidad(localidad131);
		var localidadCreada132 = ServiceUbicacion.crearLocalidad(localidad132);
		var localidadCreada133 = ServiceUbicacion.crearLocalidad(localidad133);
		var localidadCreada134 = ServiceUbicacion.crearLocalidad(localidad134);
		var localidadCreada135 = ServiceUbicacion.crearLocalidad(localidad135);
		var localidadCreada136 = ServiceUbicacion.crearLocalidad(localidad136);
		var localidadCreada137 = ServiceUbicacion.crearLocalidad(localidad137);
		var localidadCreada138 = ServiceUbicacion.crearLocalidad(localidad138);
		var localidadCreada139 = ServiceUbicacion.crearLocalidad(localidad139);
		var localidadCreada140 = ServiceUbicacion.crearLocalidad(localidad140);
		var localidadCreada141 = ServiceUbicacion.crearLocalidad(localidad141);
		var localidadCreada142 = ServiceUbicacion.crearLocalidad(localidad142);
		var localidadCreada143 = ServiceUbicacion.crearLocalidad(localidad143);
		var localidadCreada144 = ServiceUbicacion.crearLocalidad(localidad144);
		var localidadCreada145 = ServiceUbicacion.crearLocalidad(localidad145);
		var localidadCreada146 = ServiceUbicacion.crearLocalidad(localidad146);
		var localidadCreada147 = ServiceUbicacion.crearLocalidad(localidad147);
		var localidadCreada148 = ServiceUbicacion.crearLocalidad(localidad148);
		var localidadCreada149 = ServiceUbicacion.crearLocalidad(localidad149);
		var localidadCreada150 = ServiceUbicacion.crearLocalidad(localidad150);
		var localidadCreada151 = ServiceUbicacion.crearLocalidad(localidad151);
		var localidadCreada152 = ServiceUbicacion.crearLocalidad(localidad152);
		var localidadCreada153 = ServiceUbicacion.crearLocalidad(localidad153);
		var localidadCreada154 = ServiceUbicacion.crearLocalidad(localidad154);
		var localidadCreada155 = ServiceUbicacion.crearLocalidad(localidad155);
		var localidadCreada156 = ServiceUbicacion.crearLocalidad(localidad156);
		var localidadCreada157 = ServiceUbicacion.crearLocalidad(localidad157);
		var localidadCreada158 = ServiceUbicacion.crearLocalidad(localidad158);
		var localidadCreada159 = ServiceUbicacion.crearLocalidad(localidad159);
		var localidadCreada160 = ServiceUbicacion.crearLocalidad(localidad160);
		var localidadCreada161 = ServiceUbicacion.crearLocalidad(localidad161);
		var localidadCreada162 = ServiceUbicacion.crearLocalidad(localidad162);
		var localidadCreada163 = ServiceUbicacion.crearLocalidad(localidad163);
		var localidadCreada164 = ServiceUbicacion.crearLocalidad(localidad164);
		var localidadCreada165 = ServiceUbicacion.crearLocalidad(localidad165);
		var localidadCreada166 = ServiceUbicacion.crearLocalidad(localidad166);
		var localidadCreada167 = ServiceUbicacion.crearLocalidad(localidad167);
		var localidadCreada168 = ServiceUbicacion.crearLocalidad(localidad168);
		var localidadCreada169 = ServiceUbicacion.crearLocalidad(localidad169);
		var localidadCreada170 = ServiceUbicacion.crearLocalidad(localidad170);
		var localidadCreada171 = ServiceUbicacion.crearLocalidad(localidad171);
		var localidadCreada172 = ServiceUbicacion.crearLocalidad(localidad172);
		var localidadCreada173 = ServiceUbicacion.crearLocalidad(localidad173);
		var localidadCreada174 = ServiceUbicacion.crearLocalidad(localidad174);
		var localidadCreada175 = ServiceUbicacion.crearLocalidad(localidad175);
		var localidadCreada176 = ServiceUbicacion.crearLocalidad(localidad176);
		var localidadCreada177 = ServiceUbicacion.crearLocalidad(localidad177);
		var localidadCreada178 = ServiceUbicacion.crearLocalidad(localidad178);
		var localidadCreada179 = ServiceUbicacion.crearLocalidad(localidad179);
		var localidadCreada180 = ServiceUbicacion.crearLocalidad(localidad180);
		var localidadCreada181 = ServiceUbicacion.crearLocalidad(localidad181);
		var localidadCreada182 = ServiceUbicacion.crearLocalidad(localidad182);
		var localidadCreada183 = ServiceUbicacion.crearLocalidad(localidad183);
		var localidadCreada184 = ServiceUbicacion.crearLocalidad(localidad184);
		var localidadCreada185 = ServiceUbicacion.crearLocalidad(localidad185);
		var localidadCreada186 = ServiceUbicacion.crearLocalidad(localidad186);
		var localidadCreada187 = ServiceUbicacion.crearLocalidad(localidad187);
		var localidadCreada188 = ServiceUbicacion.crearLocalidad(localidad188);
		var localidadCreada189 = ServiceUbicacion.crearLocalidad(localidad189);
		var localidadCreada190 = ServiceUbicacion.crearLocalidad(localidad190);
		var localidadCreada191 = ServiceUbicacion.crearLocalidad(localidad191);
		var localidadCreada192 = ServiceUbicacion.crearLocalidad(localidad192);
		var localidadCreada193 = ServiceUbicacion.crearLocalidad(localidad193);
		var localidadCreada194 = ServiceUbicacion.crearLocalidad(localidad194);
		var localidadCreada195 = ServiceUbicacion.crearLocalidad(localidad195);
		var localidadCreada196 = ServiceUbicacion.crearLocalidad(localidad196);
		var localidadCreada197 = ServiceUbicacion.crearLocalidad(localidad197);
		var localidadCreada198 = ServiceUbicacion.crearLocalidad(localidad198);
		var localidadCreada199 = ServiceUbicacion.crearLocalidad(localidad199);		
		var localidadCreada200 = ServiceUbicacion.crearLocalidad(localidad200);
		var localidadCreada201 = ServiceUbicacion.crearLocalidad(localidad201);
		var localidadCreada202 = ServiceUbicacion.crearLocalidad(localidad202);
		var localidadCreada203 = ServiceUbicacion.crearLocalidad(localidad203);
		var localidadCreada204 = ServiceUbicacion.crearLocalidad(localidad204);
		var localidadCreada205 = ServiceUbicacion.crearLocalidad(localidad205);
		var localidadCreada206 = ServiceUbicacion.crearLocalidad(localidad206);
		var localidadCreada207 = ServiceUbicacion.crearLocalidad(localidad207);
		var localidadCreada208 = ServiceUbicacion.crearLocalidad(localidad208);
		var localidadCreada209 = ServiceUbicacion.crearLocalidad(localidad209);
		var localidadCreada210 = ServiceUbicacion.crearLocalidad(localidad210);
		var localidadCreada211 = ServiceUbicacion.crearLocalidad(localidad211);
		var localidadCreada212 = ServiceUbicacion.crearLocalidad(localidad212);
		var localidadCreada213 = ServiceUbicacion.crearLocalidad(localidad213);
		var localidadCreada214 = ServiceUbicacion.crearLocalidad(localidad214);
		var localidadCreada215 = ServiceUbicacion.crearLocalidad(localidad215);
		var localidadCreada216 = ServiceUbicacion.crearLocalidad(localidad216);
		var localidadCreada217 = ServiceUbicacion.crearLocalidad(localidad217);
		var localidadCreada218 = ServiceUbicacion.crearLocalidad(localidad218);
		var localidadCreada219 = ServiceUbicacion.crearLocalidad(localidad219);
		var localidadCreada220 = ServiceUbicacion.crearLocalidad(localidad220);
		var localidadCreada221 = ServiceUbicacion.crearLocalidad(localidad221);
		var localidadCreada222 = ServiceUbicacion.crearLocalidad(localidad222);
		var localidadCreada223 = ServiceUbicacion.crearLocalidad(localidad223);
		var localidadCreada224 = ServiceUbicacion.crearLocalidad(localidad224);
		var localidadCreada225 = ServiceUbicacion.crearLocalidad(localidad225);
		var localidadCreada226 = ServiceUbicacion.crearLocalidad(localidad226);
		var localidadCreada227 = ServiceUbicacion.crearLocalidad(localidad227);
		var localidadCreada228 = ServiceUbicacion.crearLocalidad(localidad228);
		var localidadCreada231 = ServiceUbicacion.crearLocalidad(localidad231);
		var localidadCreada232 = ServiceUbicacion.crearLocalidad(localidad232);
		var localidadCreada233 = ServiceUbicacion.crearLocalidad(localidad233);
		var localidadCreada234 = ServiceUbicacion.crearLocalidad(localidad234);
		var localidadCreada235 = ServiceUbicacion.crearLocalidad(localidad235);
		var localidadCreada236 = ServiceUbicacion.crearLocalidad(localidad236);
		var localidadCreada237 = ServiceUbicacion.crearLocalidad(localidad237);
		var localidadCreada238 = ServiceUbicacion.crearLocalidad(localidad238);
		var localidadCreada239 = ServiceUbicacion.crearLocalidad(localidad239);
		var localidadCreada240 = ServiceUbicacion.crearLocalidad(localidad240);
		var localidadCreada241 = ServiceUbicacion.crearLocalidad(localidad241);
		var localidadCreada242 = ServiceUbicacion.crearLocalidad(localidad242);
		var localidadCreada243 = ServiceUbicacion.crearLocalidad(localidad243);
		var localidadCreada245 = ServiceUbicacion.crearLocalidad(localidad245);
		var localidadCreada246 = ServiceUbicacion.crearLocalidad(localidad246);
		var localidadCreada247 = ServiceUbicacion.crearLocalidad(localidad247);
		var localidadCreada248 = ServiceUbicacion.crearLocalidad(localidad248);
		var localidadCreada249 = ServiceUbicacion.crearLocalidad(localidad249);
		var localidadCreada250 = ServiceUbicacion.crearLocalidad(localidad250);
		var localidadCreada251 = ServiceUbicacion.crearLocalidad(localidad251);
		var localidadCreada252 = ServiceUbicacion.crearLocalidad(localidad252);
		var localidadCreada253 = ServiceUbicacion.crearLocalidad(localidad253);
		var localidadCreada254 = ServiceUbicacion.crearLocalidad(localidad254);
		var localidadCreada255 = ServiceUbicacion.crearLocalidad(localidad255);
		var localidadCreada256 = ServiceUbicacion.crearLocalidad(localidad256);
		var localidadCreada257 = ServiceUbicacion.crearLocalidad(localidad257);
		var localidadCreada258 = ServiceUbicacion.crearLocalidad(localidad258);
		var localidadCreada259 = ServiceUbicacion.crearLocalidad(localidad259);
		var localidadCreada260 = ServiceUbicacion.crearLocalidad(localidad260);
		var localidadCreada261 = ServiceUbicacion.crearLocalidad(localidad261);
		var localidadCreada262 = ServiceUbicacion.crearLocalidad(localidad262);
		var localidadCreada263 = ServiceUbicacion.crearLocalidad(localidad263);
		var localidadCreada264 = ServiceUbicacion.crearLocalidad(localidad264);
		var localidadCreada265 = ServiceUbicacion.crearLocalidad(localidad265);
		var localidadCreada266 = ServiceUbicacion.crearLocalidad(localidad266);
		var localidadCreada267 = ServiceUbicacion.crearLocalidad(localidad267);
		var localidadCreada268 = ServiceUbicacion.crearLocalidad(localidad268);
		var localidadCreada269 = ServiceUbicacion.crearLocalidad(localidad269);
		var localidadCreada270 = ServiceUbicacion.crearLocalidad(localidad270);
		var localidadCreada271 = ServiceUbicacion.crearLocalidad(localidad271);
		var localidadCreada272 = ServiceUbicacion.crearLocalidad(localidad272);
		var localidadCreada273 = ServiceUbicacion.crearLocalidad(localidad273);
		var localidadCreada274 = ServiceUbicacion.crearLocalidad(localidad274);
		var localidadCreada275 = ServiceUbicacion.crearLocalidad(localidad275);
		var localidadCreada276 = ServiceUbicacion.crearLocalidad(localidad276);
		var localidadCreada277 = ServiceUbicacion.crearLocalidad(localidad277);
		var localidadCreada278 = ServiceUbicacion.crearLocalidad(localidad278);
		var localidadCreada279 = ServiceUbicacion.crearLocalidad(localidad279);
		var localidadCreada280 = ServiceUbicacion.crearLocalidad(localidad280);
		var localidadCreada281 = ServiceUbicacion.crearLocalidad(localidad281);
		var localidadCreada282 = ServiceUbicacion.crearLocalidad(localidad282);
		var localidadCreada283 = ServiceUbicacion.crearLocalidad(localidad283);
		var localidadCreada284 = ServiceUbicacion.crearLocalidad(localidad284);
		var localidadCreada285 = ServiceUbicacion.crearLocalidad(localidad285);
		var localidadCreada286 = ServiceUbicacion.crearLocalidad(localidad286);
		var localidadCreada287 = ServiceUbicacion.crearLocalidad(localidad287);
		var localidadCreada288 = ServiceUbicacion.crearLocalidad(localidad288);
		var localidadCreada289 = ServiceUbicacion.crearLocalidad(localidad289);
		var localidadCreada290 = ServiceUbicacion.crearLocalidad(localidad290);
		var localidadCreada291 = ServiceUbicacion.crearLocalidad(localidad291);
		var localidadCreada292 = ServiceUbicacion.crearLocalidad(localidad292);
		var localidadCreada293 = ServiceUbicacion.crearLocalidad(localidad293);
		var localidadCreada294 = ServiceUbicacion.crearLocalidad(localidad294);
		var localidadCreada295 = ServiceUbicacion.crearLocalidad(localidad295);
		var localidadCreada296 = ServiceUbicacion.crearLocalidad(localidad296);
		var localidadCreada297 = ServiceUbicacion.crearLocalidad(localidad297);
		var localidadCreada298 = ServiceUbicacion.crearLocalidad(localidad298);
		var localidadCreada299 = ServiceUbicacion.crearLocalidad(localidad299);
		var localidadCreada300 = ServiceUbicacion.crearLocalidad(localidad300);
		var localidadCreada301 = ServiceUbicacion.crearLocalidad(localidad301);
		var localidadCreada302 = ServiceUbicacion.crearLocalidad(localidad302);
		var localidadCreada303 = ServiceUbicacion.crearLocalidad(localidad303);
		var localidadCreada304 = ServiceUbicacion.crearLocalidad(localidad304);
		var localidadCreada305 = ServiceUbicacion.crearLocalidad(localidad305);
		var localidadCreada306 = ServiceUbicacion.crearLocalidad(localidad306);
		var localidadCreada307 = ServiceUbicacion.crearLocalidad(localidad307);
		var localidadCreada308 = ServiceUbicacion.crearLocalidad(localidad308);
		var localidadCreada309 = ServiceUbicacion.crearLocalidad(localidad309);
		var localidadCreada310 = ServiceUbicacion.crearLocalidad(localidad310);
		var localidadCreada311 = ServiceUbicacion.crearLocalidad(localidad311);
		var localidadCreada312 = ServiceUbicacion.crearLocalidad(localidad312);
		var localidadCreada313 = ServiceUbicacion.crearLocalidad(localidad313);
		var localidadCreada314 = ServiceUbicacion.crearLocalidad(localidad314);
		var localidadCreada315 = ServiceUbicacion.crearLocalidad(localidad315);
		var localidadCreada316 = ServiceUbicacion.crearLocalidad(localidad316);
		var localidadCreada317 = ServiceUbicacion.crearLocalidad(localidad317);
		var localidadCreada318 = ServiceUbicacion.crearLocalidad(localidad318);
		var localidadCreada319 = ServiceUbicacion.crearLocalidad(localidad319);
		var localidadCreada320 = ServiceUbicacion.crearLocalidad(localidad320);
		var localidadCreada321 = ServiceUbicacion.crearLocalidad(localidad321);
		var localidadCreada322 = ServiceUbicacion.crearLocalidad(localidad322);
		var localidadCreada323 = ServiceUbicacion.crearLocalidad(localidad323);
		var localidadCreada324 = ServiceUbicacion.crearLocalidad(localidad324);
		var localidadCreada325 = ServiceUbicacion.crearLocalidad(localidad325);
		var localidadCreada326 = ServiceUbicacion.crearLocalidad(localidad326);
		var localidadCreada327 = ServiceUbicacion.crearLocalidad(localidad327);
		var localidadCreada328 = ServiceUbicacion.crearLocalidad(localidad328);
		var localidadCreada331 = ServiceUbicacion.crearLocalidad(localidad331);
		var localidadCreada332 = ServiceUbicacion.crearLocalidad(localidad332);
		var localidadCreada333 = ServiceUbicacion.crearLocalidad(localidad333);
		var localidadCreada334 = ServiceUbicacion.crearLocalidad(localidad334);
		var localidadCreada335 = ServiceUbicacion.crearLocalidad(localidad335);
		var localidadCreada336 = ServiceUbicacion.crearLocalidad(localidad336);
		var localidadCreada337 = ServiceUbicacion.crearLocalidad(localidad337);
		var localidadCreada338 = ServiceUbicacion.crearLocalidad(localidad338);
		var localidadCreada339 = ServiceUbicacion.crearLocalidad(localidad339);
		var localidadCreada340 = ServiceUbicacion.crearLocalidad(localidad340);
		var localidadCreada341 = ServiceUbicacion.crearLocalidad(localidad341);
		var localidadCreada342 = ServiceUbicacion.crearLocalidad(localidad342);
		var localidadCreada343 = ServiceUbicacion.crearLocalidad(localidad343);
		var localidadCreada344 = ServiceUbicacion.crearLocalidad(localidad344);
		var localidadCreada345 = ServiceUbicacion.crearLocalidad(localidad345);
		var localidadCreada346 = ServiceUbicacion.crearLocalidad(localidad346);
		var localidadCreada347 = ServiceUbicacion.crearLocalidad(localidad347);
		var localidadCreada348 = ServiceUbicacion.crearLocalidad(localidad348);
		var localidadCreada349 = ServiceUbicacion.crearLocalidad(localidad349);
		var localidadCreada350 = ServiceUbicacion.crearLocalidad(localidad350);
		var localidadCreada351 = ServiceUbicacion.crearLocalidad(localidad351);
		var localidadCreada352 = ServiceUbicacion.crearLocalidad(localidad352);
		var localidadCreada353 = ServiceUbicacion.crearLocalidad(localidad353);
		var localidadCreada354 = ServiceUbicacion.crearLocalidad(localidad354);
		var localidadCreada355 = ServiceUbicacion.crearLocalidad(localidad355);
		var localidadCreada356 = ServiceUbicacion.crearLocalidad(localidad356);
		var localidadCreada357 = ServiceUbicacion.crearLocalidad(localidad357);
		var localidadCreada358 = ServiceUbicacion.crearLocalidad(localidad358);
		var localidadCreada359 = ServiceUbicacion.crearLocalidad(localidad359);
		var localidadCreada360 = ServiceUbicacion.crearLocalidad(localidad360);
		var localidadCreada361 = ServiceUbicacion.crearLocalidad(localidad361);
		var localidadCreada362 = ServiceUbicacion.crearLocalidad(localidad362);
		var localidadCreada363 = ServiceUbicacion.crearLocalidad(localidad363);
		var localidadCreada364 = ServiceUbicacion.crearLocalidad(localidad364);
		var localidadCreada365 = ServiceUbicacion.crearLocalidad(localidad365);
		var localidadCreada366 = ServiceUbicacion.crearLocalidad(localidad366);
		var localidadCreada367 = ServiceUbicacion.crearLocalidad(localidad367);
		var localidadCreada368 = ServiceUbicacion.crearLocalidad(localidad368);
		var localidadCreada369 = ServiceUbicacion.crearLocalidad(localidad369);
		var localidadCreada370 = ServiceUbicacion.crearLocalidad(localidad370);
		var localidadCreada371 = ServiceUbicacion.crearLocalidad(localidad371);
		var localidadCreada372 = ServiceUbicacion.crearLocalidad(localidad372);
		var localidadCreada373 = ServiceUbicacion.crearLocalidad(localidad373);
		var localidadCreada374 = ServiceUbicacion.crearLocalidad(localidad374);
		var localidadCreada375 = ServiceUbicacion.crearLocalidad(localidad375);
		var localidadCreada376 = ServiceUbicacion.crearLocalidad(localidad376);
		var localidadCreada377 = ServiceUbicacion.crearLocalidad(localidad377);
		var localidadCreada378 = ServiceUbicacion.crearLocalidad(localidad378);
		var localidadCreada379 = ServiceUbicacion.crearLocalidad(localidad379);
		var localidadCreada380 = ServiceUbicacion.crearLocalidad(localidad380);
		var localidadCreada381 = ServiceUbicacion.crearLocalidad(localidad381);
		var localidadCreada382 = ServiceUbicacion.crearLocalidad(localidad382);
		var localidadCreada383 = ServiceUbicacion.crearLocalidad(localidad383);
		var localidadCreada384 = ServiceUbicacion.crearLocalidad(localidad384);
		var localidadCreada385 = ServiceUbicacion.crearLocalidad(localidad385);
		var localidadCreada386 = ServiceUbicacion.crearLocalidad(localidad386);
		var localidadCreada387 = ServiceUbicacion.crearLocalidad(localidad387);
		var localidadCreada388 = ServiceUbicacion.crearLocalidad(localidad388);
		var localidadCreada389 = ServiceUbicacion.crearLocalidad(localidad389);
		var localidadCreada390 = ServiceUbicacion.crearLocalidad(localidad390);
		var localidadCreada391 = ServiceUbicacion.crearLocalidad(localidad391);
		var localidadCreada392 = ServiceUbicacion.crearLocalidad(localidad392);
		var localidadCreada393 = ServiceUbicacion.crearLocalidad(localidad393);
		var localidadCreada394 = ServiceUbicacion.crearLocalidad(localidad394);
		var localidadCreada395 = ServiceUbicacion.crearLocalidad(localidad395);
		var localidadCreada396 = ServiceUbicacion.crearLocalidad(localidad396);
		var localidadCreada397 = ServiceUbicacion.crearLocalidad(localidad397);
		var localidadCreada398 = ServiceUbicacion.crearLocalidad(localidad398);
		var localidadCreada399 = ServiceUbicacion.crearLocalidad(localidad399);
		var localidadCreada400 = ServiceUbicacion.crearLocalidad(localidad400);
		var localidadCreada401 = ServiceUbicacion.crearLocalidad(localidad401);
		var localidadCreada402 = ServiceUbicacion.crearLocalidad(localidad402);
		

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
				"S", departamentoCreado8, generoCreado, itrCreada, localidadCreada1, rolCreado);

		Usuario oUsuarioNuevo2 = new Usuario("12345678a", cedula2, dateRony, "rony.palacios@utec.edu.uy",
				"rony@adinet.com", "rony.palacios", "Palacios", "Rony", "Guerra", "", "099652242", "S", "S",
				departamentoCreado8, generoCreado, itrCreada, localidadCreada154, rolCreado3);

		Usuario oUsuarioNuevo3 = new Usuario("12345678a", cedula3, dateMartina, "matias.luzardo@utec.edu.uy",
				"matias@gmail.com", "matias.luzardo", "Luzardo", "Matias", "Frade", "Gabriel", "092344423", "S", "N",
				departamentoCreado7, generoCreado, itrCreada, localidadCreada125, rolCreado4);

		Usuario oUsuarioNuevo4 = new Usuario("12345678a", cedula4, dateValentina, "valentina.hernandez@utec.edu.uy",
				"vale@gmail.com", "valentina.hernandez", "Hernandez", "Valentina", "Modino", "", "094567443", "S", "S",
				departamentoCreado8, generoCreado2, itrCreada, localidadCreada154, rolCreado);

		Usuario oUsuarioNuevo5 = new Usuario("12345678a", cedula5, dateMartina,
				"martina.fernandez@estudiantes.utec.edu.uy", "marti@gmail.com", "martina.fernandez", "Fernandez",
				"Martina", "Baladón", "", "095672344", "S", "S", departamentoCreado2, generoCreado2, itrCreada,
				localidadCreada16, rolCreado2);

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
