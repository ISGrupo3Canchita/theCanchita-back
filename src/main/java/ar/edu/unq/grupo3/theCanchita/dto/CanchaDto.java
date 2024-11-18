package ar.edu.unq.grupo3.theCanchita.dto;

import java.time.LocalTime;

public class CanchaDto {
	
	private String id;
	private String nombreCancha;
	private String direccion;
	private LocalTime horarioInicio;
	private LocalTime horarioFin;
	private String estado;
	
	
	public CanchaDto(String id, String nombre, String direcc, LocalTime horarioIni, LocalTime horarioFin, String estadoCancha) {
		this.id = id;
		this.nombreCancha = nombre;
		this.direccion = direcc;
		this.horarioInicio = horarioIni;
		this.horarioFin = horarioFin;
		this.estado = estadoCancha;
	}
	

	
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
	public LocalTime getHorarioInicio() {
		return horarioInicio;
	}
	public void setHorarioInicio(LocalTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	public LocalTime getHorarioFin() {
		return horarioFin;
	}
	public void setHorarioFin(LocalTime horarioFin) {
		this.horarioFin = horarioFin;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
