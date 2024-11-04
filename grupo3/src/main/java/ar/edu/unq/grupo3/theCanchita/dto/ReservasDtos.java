package ar.edu.unq.grupo3.theCanchita.dto;

import java.sql.Time;

import ar.edu.unq.grupo3.theCanchita.model.Reserva;

public class ReservasDtos {
	
	//----------------------Constante
	
		private static final long serialVersionUID =1l;
		
		//----------------------Atributos
		
		private String id;
		private String idUsuario;
		private String idCancha;
		private String estadoreserva;
		private Time inicioReserva;
		private Time finReserva;

		//----------------------Constructores
		
		public ReservasDtos(Reserva reserva, boolean usuario, boolean cancha, boolean estado) {
			this.id = reserva.getId();
			this.inicioReserva = reserva.getInicioReserva();
			this.finReserva = reserva.getFinReserva();
			if(usuario) {
				this.idUsuario = reserva.getUsuario().toString();
			}
			if(cancha) {
				this.idCancha = reserva.getCancha().toString();
			}
			if (estado) {
				this.estadoreserva = reserva.getEstadoreserva().getNombreEstado();
			}
		}

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
