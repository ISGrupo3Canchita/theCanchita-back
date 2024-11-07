package ar.edu.unq.grupo3.theCanchita.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unq.grupo3.theCanchita.model.Cancha;

@Repository
public interface CanchaRepository extends JpaRepository<Cancha, String> {

	@Query("SELECT c FROM Cancha c WHERE c.estadoCancha.id = 1")
    List<Cancha> findCanchasHabilitadas();
	
	@EntityGraph(value = "CanchaWithEstado")
	Optional<Cancha> findWithEstadoById(String id);
	
	Optional<Cancha> findByNombreCancha(String nombre);
	
	Optional<Cancha> findByDireccion(String direccion);
	
	@Query("SELECT c FROM Cancha c WHERE c.estadoCancha.id = :estado")
	List<Cancha> findEstado(Integer estado);
}
