package theCanchitas.grupo3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import theCanchitas.grupo3.model.Reserva;
import theCanchitas.grupo3.model.Usuario;
	
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,String>, CustomUsuarioRepository{
	Optional<Usuario> findByEmail(String email);
	
	String idUsuario idUsuarioByUsername(String username);
	
	List<Reserva> listadoReservaPorUsuario(String userName);
	
	
}
