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
	private String id;
	private String nombre_Cancha;
	private String direccion;
	private String horario;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Estado_Cancha")
	private EstadoCancha estadoCancha;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre_Cancha() {
		return nombre_Cancha;
	}


	public void setNombre_Cancha(String nombre_Cancha) {
		this.nombre_Cancha = nombre_Cancha;
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
