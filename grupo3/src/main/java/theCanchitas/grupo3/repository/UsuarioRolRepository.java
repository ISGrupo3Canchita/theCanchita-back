package theCanchitas.grupo3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import theCanchitas.grupo3.model.UsuarioRol;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, String>{
	Optional<UsuarioRol> findById(String id);
}
