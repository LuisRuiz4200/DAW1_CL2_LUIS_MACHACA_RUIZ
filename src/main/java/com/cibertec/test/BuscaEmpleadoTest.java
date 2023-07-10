package com.cibertec.test;

import com.cibertec.dao.EmpleadoDao;
import com.cibertec.dao.impl.EmpleadoDaoImpl;
import com.cibertec.model.Empleado;

public class BuscaEmpleadoTest {
	public static void main(String[] args) {

		EmpleadoDao empleadoDao = new EmpleadoDaoImpl();

		Empleado obj = empleadoDao.buscarEmpleado(1);

		System.out.println(obj.toString());

	}
}
