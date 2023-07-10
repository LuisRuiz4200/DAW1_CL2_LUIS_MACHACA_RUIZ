package com.cibertec.test;

import com.cibertec.dao.EmpleadoDao;
import com.cibertec.dao.impl.EmpleadoDaoImpl;

public class EliminaEmpleadoTest {
	public static void main(String[] args) {

		EmpleadoDao empleadoDao = new EmpleadoDaoImpl();

		String mensaje = empleadoDao.eliminarEmpleado(2);

		System.out.println(mensaje);

	}
}
