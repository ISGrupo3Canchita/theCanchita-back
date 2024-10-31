package theCanchitas.grupo3.repository.Imple.copy;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import theCanchitas.grupo3.model.Reserva;
import theCanchitas.grupo3.repository.CustomUsuarioRepository;

public class CustomRepositorioImplemento implements CustomUsuarioRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public List<Reserva> listadoReservaPorUsuario(String userName) {
		//TODO Generar el jpql 
		return null;
	}
}
