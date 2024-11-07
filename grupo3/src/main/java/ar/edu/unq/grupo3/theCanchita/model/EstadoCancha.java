package ar.edu.unq.grupo3.theCanchita.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estadocancha")
public class EstadoCancha {
	
	@Id
	private Integer id;
	
	private String nombreEstado;
	private String descripcionEstado;
	
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombreEstado() {
		return nombreEstado;
	}
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}
	public String getDescripcionEstado() {
		return descripcionEstado;
	}
	public void setDescripcionEstado(String descripcion) {
		this.descripcionEstado = descripcion;
	}
	
	

}
