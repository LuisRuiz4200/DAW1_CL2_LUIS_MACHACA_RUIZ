package com.cibertec.dao.impl;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.cibertec.dao.EmpleadoDao;
import com.cibertec.model.Empleado;

public class EmpleadoDaoImpl implements EmpleadoDao {

	private static final String REGISTRA_OK = "Se registro correctamente";
	private static final String REGISTRA_ERROR="No se registro correctamente";
	
	private static final String ACTUALIZA_OK = "Se actualizo correctamente";
	private static final String ACTUALIZA_ERROR="No se actualizo correctamente";

	private static final String ELIMINA_OK = "Se elimino correctamente";
	private static final String ELIMINA_ERROR="No se elimino correctamente";
	

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("DAW1_CL2_LUIS_MACHACA_RUIZ");
	EntityManager manager = factory.createEntityManager();
	
	
	@Override
	public String registrarEmpleado(Empleado empleado) {
		String mensaje = REGISTRA_ERROR;
		
		if(!Objects.isNull(empleado)) {
			manager.getTransaction().begin();
			
			manager.persist(empleado);
			
			manager.getTransaction().commit();
			manager.close();
			
			mensaje = REGISTRA_OK;
		}
		
		return mensaje;
	}

	@Override
	public Empleado buscarEmpleado(int idEmpleado) {
		
		return manager.find(Empleado.class, idEmpleado);
	}

	@Override
	public List<Empleado> listarEmpleado() {
		
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Empleado> criteriaQuery = criteriaBuilder.createQuery(Empleado.class);
		Root<Empleado> registro = criteriaQuery.from(Empleado.class);
		CriteriaQuery<Empleado> todos = criteriaQuery.select(registro);
		TypedQuery<Empleado> lista = manager.createQuery(todos);
		
		return lista.getResultList();
	}

	@Override
	public String actualizarEmpleado(Empleado empleado) {
		String mensaje = ACTUALIZA_ERROR;
		Empleado obj = buscarEmpleado(empleado.getIdEmpleado());
		
		if(!Objects.isNull(empleado)) {
			manager.getTransaction().begin();
			
			obj.setNombre(empleado.getNombre());
			obj.setApellidos(empleado.getApellidos());
			obj.setDni(empleado.getDni());
			
			manager.persist(obj);
			
			manager.getTransaction().commit();
			manager.close();
			
			mensaje = ACTUALIZA_OK;
		}
		
		return mensaje;
	}

	@Override
	public String eliminarEmpleado(int idEmpleado) {
		String mensaje = ELIMINA_ERROR;
		Empleado obj = buscarEmpleado(idEmpleado);
		
		
		if(!Objects.isNull(obj)) {
			manager.getTransaction().begin();
			
			manager.remove(obj);
			
			manager.getTransaction().commit();
			manager.close();
			
			mensaje = ELIMINA_OK;
		}
		
		return mensaje;
	}
	
}
