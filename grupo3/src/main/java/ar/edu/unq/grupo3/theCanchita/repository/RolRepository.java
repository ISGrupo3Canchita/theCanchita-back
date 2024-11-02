package ar.edu.unq.grupo3.theCanchita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.grupo3.theCanchita.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
		
	public Rol findByNombre(String nombre);
}
