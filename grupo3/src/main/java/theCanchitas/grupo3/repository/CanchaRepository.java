package theCanchitas.grupo3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import theCanchitas.grupo3.model.Cancha;

@Repository
public interface CanchaRepository extends JpaRepository<Cancha, String> {

	@Query("SELECT c FROM Cancha c WHERE c.estadoCancha.id = 1")
    List<Cancha> findCanchasHabilitadas();
	
}
