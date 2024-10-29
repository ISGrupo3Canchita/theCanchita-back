package theCanchitas.grupo3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import theCanchitas.grupo3.model.UsuarioRol;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Integer>{
	
	@Query(value ="SELECT ur FROM UsuarioRol ur WHERE ur.usuario.id = :id")
	Optional<UsuarioRol> findByIdUsuario(String id);
	
	@Modifying
	@Transactional
	@Query("INSERT INTO UsuarioRol (idUsuario, idRol) VALUES (:idUsuario, :idRol)")
	void insertUsuarioRol(String idUsuario, Integer idRol);
}
