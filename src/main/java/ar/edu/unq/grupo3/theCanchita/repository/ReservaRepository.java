package ar.edu.unq.grupo3.theCanchita.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unq.grupo3.theCanchita.model.Cancha;
import ar.edu.unq.grupo3.theCanchita.model.EstadoReserva;
import ar.edu.unq.grupo3.theCanchita.model.Reserva;
import ar.edu.unq.grupo3.theCanchita.model.Usuario;

import java.time.LocalTime;
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
	
	@EntityGraph(value = "ReservaWithUsuarioAndCanchaAndEstado")
	public Optional<Reserva> findWithUsuarioAndCanchaAndEstadoById(String Id);
	
	@Query("SELECT r FROM Reserva r " +
		       "JOIN r.estadoreserva e " +  
		       "WHERE r.cancha = :cancha AND " +
		       "(e.nombreEstado = 'PENDIENTE' OR e.nombreEstado = 'RESERVADA') AND " +  
		       "((:horarioInicio BETWEEN r.inicioReserva AND r.finReserva) OR " +
		       "(:horarioFin BETWEEN r.inicioReserva AND r.finReserva) OR " +
		       "(r.inicioReserva BETWEEN :horarioInicio AND :horarioFin) OR " +
		       "(r.finReserva BETWEEN :horarioInicio AND :horarioFin))")

	List<Reserva> findReservasOcupadas(@Param("cancha") Cancha cancha, 
		                               @Param("horarioInicio") LocalTime horarioInicio, 
		                               @Param("horarioFin") LocalTime horarioFin);
	
	@Query("SELECT r FROM Reserva r WHERE r.usuario = :usuario AND  r.estadoreserva IN (:estados)")
	List<Reserva> findReservasPendienteReservadaByUsuario(@Param("usuario")Usuario usuario,
												@Param("estados")List<EstadoReserva> estados);
	
	List<Reserva> findByUsuarioAndEstadoreservaIn(Usuario usuario, List<EstadoReserva> estados);
			
}
