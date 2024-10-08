package com.servidor.beans.departamento;

import java.util.ArrayList;
import javax.ejb.Remote;
import com.servidor.entidades.Departamento;
import com.servidor.exception.ServiciosException;

@Remote
public interface DepartamentoBeanRemote {

	Departamento crearDepartamento(Departamento oDepartamento) throws ServiciosException;

	Departamento actualizarDepartamento(Departamento oDepartamento) throws ServiciosException;

	boolean eliminarDepartamento(Long idDepartamento) throws ServiciosException;

	ArrayList<Departamento> listarDepartamentos() throws ServiciosException;

	ArrayList<Departamento> listarDepartamentosFiltro(String filtro) throws ServiciosException;

}
