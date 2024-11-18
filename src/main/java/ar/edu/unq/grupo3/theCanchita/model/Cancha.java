package ar.edu.unq.grupo3.theCanchita.model;


import java.time.LocalTime;
import java.util.UUID;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedSubgraph;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@NamedEntityGraph(
		name = "CanchaWithEstado",
		attributeNodes = {
				@NamedAttributeNode("estadoCancha"),
				@NamedAttributeNode(value = "estadoCancha", subgraph = "estado-subgraph")
		},
		subgraphs = {
				@NamedSubgraph(
						name = "estado-subgraph",
						attributeNodes = @NamedAttributeNode("nombreEstado"))
		})

@Table(name = "cancha", schema = "canchitabs")
public class Cancha {
	
	@Id
	private String id = UUID.randomUUID().toString();;
	private String nombreCancha;
	private String direccion;
	private LocalTime horarioInicio;
	private LocalTime horarioCierre;
	
	

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
	
	public LocalTime getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(LocalTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public LocalTime getHorarioCierre() {
		return horarioCierre;
	}

	public void setHorarioFin(LocalTime horarioFin) {
		this.horarioCierre = horarioFin;
	}

}
