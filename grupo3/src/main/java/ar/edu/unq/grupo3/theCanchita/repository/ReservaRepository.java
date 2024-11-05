package ar.edu.unq.grupo3.theCanchita.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.grupo3.theCanchita.model.Cancha;
import ar.edu.unq.grupo3.theCanchita.model.EstadoReserva;
import ar.edu.unq.grupo3.theCanchita.model.Reserva;
import ar.edu.unq.grupo3.theCanchita.model.Usuario;
import java.util.List;
import java.util.Optional;


@Repository
public interface ReservaRepository extends JpaRepository<Reserva, String> {

	@EntityGraph(value = "ReservaWithUsuarioAndCanchaAndEstado" )
	public List<Reserva> findWithUsuarioAndCanchaAndEstadoByUsuario(Usuario usuario);
	
	@EntityGraph(value = "ReservaWithUsuarioAndCanchaAndEstado" )
	public List<Reserva> findWithUsuarioAndCanchaAndEstadoByCancha(Cancha cancha);
	
	@EntityGraph(value = "ReservaWithUsuarioAndCanchaAndEstado")
	public List<Reserva> findWithUsuarioAndCanchaAndEstadoByEstadoreserva(EstadoReserva estadoreserva);
	
//	@EntityGraph(value = "ReservaWithEstado")
//	public Optional<Reserva> findWithEstadoById(String Id);
//	
}
