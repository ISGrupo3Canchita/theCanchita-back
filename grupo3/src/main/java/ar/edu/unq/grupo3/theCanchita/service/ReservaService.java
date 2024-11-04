package ar.edu.unq.grupo3.theCanchita.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unq.grupo3.theCanchita.dto.ReservaDto;
import ar.edu.unq.grupo3.theCanchita.model.Cancha;
import ar.edu.unq.grupo3.theCanchita.model.EstadoCancha;
import ar.edu.unq.grupo3.theCanchita.model.EstadoReserva;
import ar.edu.unq.grupo3.theCanchita.model.Reserva;
import ar.edu.unq.grupo3.theCanchita.model.Usuario;
import ar.edu.unq.grupo3.theCanchita.repository.CanchaRepository;
import ar.edu.unq.grupo3.theCanchita.repository.EstadoReservaRepository;
import ar.edu.unq.grupo3.theCanchita.repository.ReservaRepository;
import ar.edu.unq.grupo3.theCanchita.repository.UsuarioRepository;


@Service
public class ReservaService {
	@Autowired
	private ReservaRepository repository;
	@Autowired
	private EstadoReservaRepository estadoReservaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private CanchaRepository canchaRepository;

	public String agregarReserva(ReservaDto nuevaReserva) {
		String uuid = UUID.randomUUID().toString();
		EstadoReserva estadoReserva = estadoReservaRepository.findByNombreEstado("Pendiente");
		Usuario usuario = (usuarioRepository.findById(nuevaReserva.getIdUsuario())).get();
		Cancha cancha = (canchaRepository.findById(nuevaReserva.getIdCancha())).get();
		
		Reserva reserva= new Reserva();
		reserva.setId(uuid);
		reserva.setEstadoreserva(estadoReserva);
		reserva.setCancha(cancha);
		reserva.setUsuario(usuario);
		reserva.setInicioReserva(nuevaReserva.getInicioReserva());
		reserva.setFinReserva(nuevaReserva.getFinReserva());
		this.repository.save(reserva);
		
		return "Reserva Guardada";
	}
	@Transactional(readOnly = true)
	public List<Reserva> todasLasReservas(){
		return this.repository.findAll();
	}
	

	@Transactional(readOnly = true)
	public List<Reserva> reservasPoridUsuario(String idUsuario) {
		List<Reserva> reservas = this.repository.findAllReservaByUsuario(usuarioRepository.findById(idUsuario).get());
		return reservas;
	}
	
	@Transactional(readOnly = true)
	public List<Reserva> reservasPorIdCancha(String idCancha) {
		Cancha cancha = (canchaRepository.findById(idCancha).get());
		System.out.println(cancha.getNombreCancha());
		List<Reserva> reservas = this.repository.findByCancha(cancha);
		return reservas;
	}
	
	@Transactional(readOnly = true)
	public List<Reserva> reservasPorEstado(String Estado) {
		EstadoReserva estado = (estadoReservaRepository.findByNombreEstado(Estado));
		System.out.println(estado.getId());
		List<Reserva> reservas = this.repository.findByEstadoreserva(estado);
		return reservas;
	}
}
