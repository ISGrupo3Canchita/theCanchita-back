package theCanchitas.grupo3.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "cancha", schema = "canchitabs")
public class Cancha {
	
	@Id
	private Integer id;
	private String nombreCancha;
	private String direccion;
	private String horario;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idEstadoCancha")
	private EstadoCancha estadoCancha;




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public EstadoCancha getEstadoCancha() {
		return estadoCancha;
	}

	public void setEstadoCancha(EstadoCancha estadoCancha) {
		this.estadoCancha = estadoCancha;
	}
	
	
}
