package ar.edu.unq.grupo3.theCanchita.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import ar.edu.unq.grupo3.theCanchita.model.Usuario;
import ar.edu.unq.grupo3.theCanchita.model.UsuarioRol;

public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, String>{
	
	@Query(value ="SELECT ur FROM UsuarioRol ur WHERE ur.usuario.id = :id")
	Optional<UsuarioRol> findByIdUsuario(String id);
	
	@EntityGraph(value = "usuarioRolWithUsuario")
	UsuarioRol findWithUsuarioByUsuario(Usuario usuario);

}

