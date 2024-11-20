package ar.edu.unq.grupo3.theCanchita.model;


import java.sql.Time;
import java.time.LocalTime;
import java.util.Optional;
import java.util.UUID;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.Table;

@Entity
@NamedEntityGraph(name = "ReservaWithUsuarioAndCanchaAndEstado", 
	attributeNodes = { 
			@NamedAttributeNode("usuario"),
			@NamedAttributeNode("estadoreserva"),
			@NamedAttributeNode("cancha"),
			})


@Table(name = "reserva", schema ="canchitabs")
public class Reserva {
	
	@Id
	private String id = UUID.randomUUID().toString();
	private LocalTime inicioReserva;
	private LocalTime finReserva;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCancha")
	private Cancha cancha;
	

	@ManyToOne()
	@JoinColumn (name = "idEstadoReserva")
	private EstadoReserva estadoreserva;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;

	}

	public LocalTime getInicioReserva() {
		return inicioReserva;
	}

	public void setInicioReserva(LocalTime inicioReserva) {
		this.inicioReserva = inicioReserva;
	}

	public LocalTime getFinReserva() {
		return finReserva;
	}

	public void setFinReserva(LocalTime finReserva) {
		this.finReserva = finReserva;
	}

	public EstadoReserva getEstadoreserva() {
		return estadoreserva;
	}

	public void setEstadoreserva(EstadoReserva estadoreserva) {
		this.estadoreserva = estadoreserva;
	}

	public Cancha getCancha() {
		return cancha;
	}

	public void setCancha(Cancha cancha) {
		this.cancha = cancha;
	}
	


	
	
}
