package theCanchitas.grupo3.dto;

import java.sql.Time;

import theCanchitas.grupo3.model.Reserva;

public class ReservaDto {
	
	private Integer id;
	private String usuario;
	private String 	estadoreserva;
	private Time inicioReserva;
	private Time finReserva;
	
	
	public ReservaDto (Reserva reserva) {
		this.id = reserva.getId();
		this.usuario = reserva.getUsuario().getNombreUsuario();
		this.estadoreserva = reserva.getEstadoreserva().getNombreEstado();
		this.inicioReserva = reserva.getInicioReserva();
		this.finReserva = reserva.getFinReserva();
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEstadoreserva() {
		return estadoreserva;
	}
	public void setEstadoreserva(String estadoreserva) {
		this.estadoreserva = estadoreserva;
	}
	public Time getInicioReserva() {
		return inicioReserva;
	}
	public void setInicioReserva(Time inicioReserva) {
		this.inicioReserva = inicioReserva;
	}
	public Time getFinReserva() {
		return finReserva;
	}
	public void setFinReserva(Time finReserva) {
		this.finReserva = finReserva;
	}
	
	
}
