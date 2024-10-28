package theCanchitas.grupo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import theCanchitas.grupo3.model.Cancha;

@Repository
public interface CanchaRepository extends JpaRepository<Cancha, Integer> {

}
