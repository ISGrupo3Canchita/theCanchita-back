package ar.edu.unq.grupo3.theCanchita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.grupo3.theCanchita.model.EstadoReserva;
import java.util.List;
import java.util.Optional;


@Repository
public interface EstadoReservaRepository extends JpaRepository<EstadoReserva, Integer> {
	
	List<EstadoReserva> findByNombreEstado(String nombreEstado);
	
}