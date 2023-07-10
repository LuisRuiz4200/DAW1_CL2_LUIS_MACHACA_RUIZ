package com.cibertec.dao;

import java.util.List;

import com.cibertec.model.Empleado;

public interface EmpleadoDao {
	
	public String registrarEmpleado(Empleado empleado);
	
	public Empleado buscarEmpleado(int idEmpleado);
	
	public List<Empleado> listarEmpleado();
	
	public String actualizarEmpleado(Empleado empleado);
	
	public String eliminarEmpleado(int idEmpleado);
}
