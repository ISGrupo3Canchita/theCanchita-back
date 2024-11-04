package ar.edu.unq.grupo3.theCanchita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.grupo3.theCanchita.model.EstadoReserva;

@Repository
public interface EstadoReservaRepository extends JpaRepository<EstadoReserva, Integer> {
	
	public EstadoReserva findByNombreEstado(String nombreEstado);
}
