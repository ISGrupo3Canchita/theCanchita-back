package ar.edu.unq.grupo3.theCanchita.dto;

import java.sql.Time;

import ar.edu.unq.grupo3.theCanchita.model.Reserva;

public class ReservaDto {
	
	private String id;
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
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
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
