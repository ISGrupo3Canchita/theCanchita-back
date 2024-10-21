package theCanchitas.grupo3.model;


import java.sql.Time;
import java.util.Set;

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
	private String id;
	private Time inicio_Reserva;
	private Time fin_Reserva;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Usuario")
	private Usuario Usuario;
	
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn (name = "estado_Reserva")
	private EstadoReserva estadoreserva;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Cancha")
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

	public Time getInicio_Reserva() {
		return inicio_Reserva;
	}

	public void setInicio_Reserva(Time inicio_Reserva) {
		this.inicio_Reserva = inicio_Reserva;
	}

	public Time getFin_Reserva() {
		return fin_Reserva;
	}

	public void setFin_Reserva(Time fin_Reserva) {
		this.fin_Reserva = fin_Reserva;
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
