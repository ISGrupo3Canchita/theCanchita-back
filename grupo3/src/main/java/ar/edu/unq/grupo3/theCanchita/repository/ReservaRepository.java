package ar.edu.unq.grupo3.theCanchita.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.grupo3.theCanchita.model.Cancha;
import ar.edu.unq.grupo3.theCanchita.model.EstadoReserva;
import ar.edu.unq.grupo3.theCanchita.model.Reserva;
import ar.edu.unq.grupo3.theCanchita.model.Usuario;
import java.util.List;


@Repository
public interface ReservaRepository extends JpaRepository<Reserva, String> {
	
//	public List<Reserva> findByUsuario(Usuario usuario);
	
	public List<Reserva> findAllReservaByUsuario(Usuario usuario);
	
	public List<Reserva> findByCancha(Cancha cancha);
	
	public List<Reserva> findByEstadoreserva(EstadoReserva estadoreserva);
}
