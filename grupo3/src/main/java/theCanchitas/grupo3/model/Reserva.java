package theCanchitas.grupo3.model;

import java.sql.Time;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
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
	private Set<estadoReserva> estadoreserva;
	
	@ManyToOne
	private Set<Cancha> cancha;
}
