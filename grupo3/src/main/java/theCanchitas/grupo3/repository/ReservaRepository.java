package theCanchitas.grupo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import theCanchitas.grupo3.model.Reserva;
import theCanchitas.grupo3.model.Usuario;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
	
	Reserva findByusuario(Usuario usuario);
}
