package theCanchitas.grupo3.model;


import java.sql.Time;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva", schema ="canchitabs")
public class Reserva {
	
	@Id
	private String id = UUID.randomUUID().toString();;
	private Time inicioReserva;
	private Time finReserva;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "idUsuario")
	private Usuario Usuario;
	
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn (name = "estadoReserva")
	private EstadoReserva estadoreserva;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCancha")
	private Cancha cancha;
	
	



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	public Time getInicioReserva() {
		return inicioReserva;
	}

	public void setInicioReserva(Time inicioReserva) {
		this.inicioReserva = inicioReserva;
	}

	public Time getFinReserva() {
		return finReserva;
	}

	public void setFinReserva(Time finReserva) {
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
