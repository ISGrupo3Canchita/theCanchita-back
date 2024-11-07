package ar.edu.unq.grupo3.theCanchita.dto;

public class CanchaDto {
	
	
	private String nombreCancha;
	private String direccion;
	private String horarioInicio;
	private String horarioFin;
	private String estado;
	
	
	public CanchaDto(String nombre, String direcc, String horarioIni, String horarioFin, String estadoCancha) {
		this.nombreCancha = nombre;
		this.direccion = direcc;
		this.horarioInicio = horarioIni;
		this.horarioFin = horarioFin;
		this.estado = estadoCancha;
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
	public String getHorarioInicio() {
		return horarioInicio;
	}
	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	public String getHorarioFin() {
		return horarioFin;
	}
	public void setHorarioFin(String horarioFin) {
		this.horarioFin = horarioFin;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
