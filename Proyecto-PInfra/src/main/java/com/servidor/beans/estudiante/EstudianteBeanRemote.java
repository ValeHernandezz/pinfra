package com.servidor.beans.estudiante;

import java.util.ArrayList;
import javax.ejb.Remote;
import com.servidor.entidades.Estudiante;
import com.servidor.exception.ServiciosException;

@Remote
public interface EstudianteBeanRemote {

	boolean crearEstudiante(Estudiante estudiante) throws ServiciosException;

	boolean actualizarEstudiante(Estudiante estudiante) throws ServiciosException;

	boolean borrarEstudiante(Long idEstudiante) throws ServiciosException;

	ArrayList<Estudiante> listarEstudiantes() throws ServiciosException;

	ArrayList<Estudiante> listarEstudiantesFiltro(String filtro) throws ServiciosException;

}
