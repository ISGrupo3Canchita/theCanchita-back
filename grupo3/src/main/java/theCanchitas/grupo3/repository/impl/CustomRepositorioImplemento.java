package theCanchitas.grupo3.repository.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import theCanchitas.grupo3.model.Reserva;
import theCanchitas.grupo3.repository.CustomUsuarioRepository;

public class CustomRepositorioImplemento implements CustomUsuarioRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<Reserva> listadoReservaPorUsuario(String userName) {
		String jpql = "hola"; // TODO hacer el Query para la consulta
		TypedQuery<Reserva> query = entityManager.createQuery(jpql, Reserva.class);
		return query.getResultList();
	}
	
	@Override
	public String idUsuarioByUsername(String username) {
		String jpql = "Se";
		return null;
	}
	
}
