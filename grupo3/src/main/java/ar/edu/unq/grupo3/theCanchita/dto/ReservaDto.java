package ar.edu.unq.grupo3.theCanchita.dto;

import java.io.Serializable;
import java.sql.Time;

import ar.edu.unq.grupo3.theCanchita.model.Reserva;

public class ReservaDto implements Serializable {
	
	//----------------------Constante
	
	private static final long serialVersionUID =1l;
	
	//----------------------Atributos
	
	private String id;
	private String idUsuario;
	private String idCancha;
	private String nombreCancha;
	private String estadoreserva;
	private Time inicioReserva;
	private Time finReserva;

	//----------------------Constructores
	public ReservaDto(Reserva reserva) {
		this.id = reserva.getId();
		this.idUsuario = reserva.getUsuario().getId();
		this.idCancha = reserva.getCancha().getId();
		this.nombreCancha = reserva.getCancha().getNombreCancha();
		this.estadoreserva = reserva.getEstadoreserva().getNombreEstado();
		this.inicioReserva = reserva.getInicioReserva();
		this.finReserva = reserva.getFinReserva();	
	}

//	-----------------------Setter and Getter
	
	
	public String getId() {
		return id;
	}
	public String getNombreCancha() {
		return nombreCancha;
	}

	public void setNombreCancha(String nombreCancha) {
		this.nombreCancha = nombreCancha;
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
