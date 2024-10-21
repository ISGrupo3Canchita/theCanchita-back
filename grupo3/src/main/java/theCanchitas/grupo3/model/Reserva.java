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
	@Column
	private String id;
	@Column
	private String id_Usuario;
	@Column
	private String id_Cancha;
	@Column
	private String id_Estado_Reserva;
	@Column
	private Time inicio_Reserva;
	@Column
	private Time fin_Reserva;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="reserva", cascade = CascadeType.ALL)
	private Set<EstadoReserva> estadoreserva;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Cancha")
	private Cancha cancha;

	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(String id_Usuario) {
		this.id_Usuario = id_Usuario;
	}

	public String getId_Cancha() {
		return id_Cancha;
	}

	public void setId_Cancha(String id_Cancha) {
		this.id_Cancha = id_Cancha;
	}

	public String getId_Estado_Reserva() {
		return id_Estado_Reserva;
	}

	public void setId_Estado_Reserva(String id_Estado_Reserva) {
		this.id_Estado_Reserva = id_Estado_Reserva;
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

	public Set<EstadoReserva> getEstadoreserva() {
		return estadoreserva;
	}

	public void setEstadoreserva(Set<EstadoReserva> estadoreserva) {
		this.estadoreserva = estadoreserva;
	}

	public Cancha getCancha() {
		return cancha;
	}

	public void setCancha(Cancha cancha) {
		this.cancha = cancha;
	}


	
	
	
}
