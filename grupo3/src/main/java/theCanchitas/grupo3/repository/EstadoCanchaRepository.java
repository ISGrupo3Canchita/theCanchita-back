package theCanchitas.grupo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import theCanchitas.grupo3.model.EstadoCancha;

@Repository
public interface EstadoCanchaRepository extends JpaRepository<EstadoCancha, Integer> {
	
}
