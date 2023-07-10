package com.cibertec.test;

import java.util.List;

import com.cibertec.dao.EmpleadoDao;
import com.cibertec.dao.impl.EmpleadoDaoImpl;
import com.cibertec.model.Empleado;

public class ListaEmpleadoTest {
	public static void main(String[] args) {

		EmpleadoDao empleadoDao = new EmpleadoDaoImpl();

		List<Empleado> lista = empleadoDao.listarEmpleado();

		for(Empleado obj: lista) {
			System.out.println(obj.toString());
		}
		

	}
}
