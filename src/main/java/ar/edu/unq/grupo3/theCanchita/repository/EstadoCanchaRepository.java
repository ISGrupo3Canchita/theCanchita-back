package ar.edu.unq.grupo3.theCanchita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.grupo3.theCanchita.model.EstadoCancha;

@Repository
public interface EstadoCanchaRepository extends JpaRepository<EstadoCancha, Integer> {

	EstadoCancha findByNombreEstado(String nombre);

	
}
