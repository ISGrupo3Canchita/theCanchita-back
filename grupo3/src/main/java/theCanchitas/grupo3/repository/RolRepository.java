package theCanchitas.grupo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import theCanchitas.grupo3.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
		
	public Rol findByNombre(String nombre);
}
