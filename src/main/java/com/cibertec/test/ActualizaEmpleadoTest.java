package com.cibertec.test;

import com.cibertec.dao.EmpleadoDao;
import com.cibertec.dao.impl.EmpleadoDaoImpl;
import com.cibertec.model.Empleado;

public class ActualizaEmpleadoTest {
	public static void main(String[] args) {

		EmpleadoDao empleadoDao = new EmpleadoDaoImpl();

		Empleado obj = new Empleado();
		obj.setIdEmpleado(1);
		obj.setNombre("Angel");
		obj.setApellidos("Machaca Ruiz");
		obj.setDni("75963004");

		String mensaje = empleadoDao.actualizarEmpleado(obj);

		System.out.println(mensaje);

	}
}
