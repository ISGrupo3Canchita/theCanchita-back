package ar.edu.unq.grupo3.theCanchita.request;

import java.sql.Time;

public class ReservaRequest {
	
	private String id;
	private String idUsuario;
	private String idCancha;
	private String estadoreserva;
	private Time inicioReserva;
	private Time finReserva;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getIdCancha() {
		return idCancha;
	}
	public void setIdCancha(String idCancha) {
		this.idCancha = idCancha;
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
