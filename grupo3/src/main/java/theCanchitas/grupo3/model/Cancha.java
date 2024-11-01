package theCanchitas.grupo3.model;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "cancha", schema = "canchitabs")
public class Cancha {
	
	@Id
	private String id = UUID.randomUUID().toString();;
	private String nombreCancha;
	private String direccion;
	private String horarioInicio;
	private String horarioCierre;
	
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idEstadoCancha")
	private EstadoCancha estadoCancha;




	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreCancha() {
		return nombreCancha;
	}

	public void setNombreCancha(String nombreCancha) {
		this.nombreCancha = nombreCancha;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public EstadoCancha getEstadoCancha() {
		return estadoCancha;
	}

	public void setEstadoCancha(EstadoCancha estadoCancha) {
		this.estadoCancha = estadoCancha;
	}
	
	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioCierre() {
		return horarioCierre;
	}

	public void setHorarioFin(String horarioFin) {
		this.horarioCierre = horarioFin;
	}

	
	
}
