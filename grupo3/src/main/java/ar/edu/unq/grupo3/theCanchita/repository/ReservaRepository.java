package ar.edu.unq.grupo3.theCanchita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.grupo3.theCanchita.model.Reserva;
import ar.edu.unq.grupo3.theCanchita.model.Usuario;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, String> {
	
	Reserva findByusuario(Usuario usuario);
}
