package ar.edu.unq.grupo3.theCanchita.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unq.grupo3.theCanchita.dto.ReservaDto;
import ar.edu.unq.grupo3.theCanchita.model.Cancha;
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
	
    @Transactional(readOnly = false)
	public String agregarReserva(ReservaDto nuevaReserva) {
		LocalTime inicio = nuevaReserva.getInicioReserva();
	    LocalTime fin = nuevaReserva.getFinReserva();
	    Cancha canchaComprobacion = canchaRepository.findById(nuevaReserva.getIdCancha()).get();
	    Usuario usuario = (usuarioRepository.findById(nuevaReserva.getIdUsuario())).get();
	    
	    System.out.println(usuario.getCantidadReserva() + "CANTIDAD RESERVA ANTES DE RESERVAR");

	    //List<Reserva> reservasOcupadas = repository.findReservasOcupadas(canchaComprobacion, inicio, fin);
	    
	    if(usuario.getCantidadReserva() >= 3) {
	    	return ( "Ya has sobrepasado el limite de reservas");
	    }
	    
	    else if(this.canchaRepository.findCanchaHorario(canchaComprobacion.getId(), inicio, fin).isEmpty()){
	    	return "El horario es Invalido";
	    }
	    
	    else if (!repository.findReservasOcupadas(canchaComprobacion, inicio, fin).isEmpty()) {
	 	       return ("El horario ya está reservado.");
	    }
		
	    else {
		
	    usuario.setCantidadReserva(usuario.getCantidadReserva() + 1);
	    System.out.println(usuario.getCantidadReserva() + "CANTIDAD RESERVA DESPUES DE RESERVAR");
	    this.usuarioRepository.save(usuario);
	    String uuid = UUID.randomUUID().toString();
		EstadoReserva estadoReserva = estadoReservaRepository.findById(3).get();
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
	}
	
	@Transactional(readOnly = true)
	public List<Reserva> todasLasReservas(){
		return this.repository.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<Reserva> reservasPoridUsuario(String idemail) {
		
		List<Reserva> reservas = this.repository.findWithUsuarioAndCanchaAndEstadoByUsuario(usuarioRepository.findByEmail(idemail).get());
		return reservas;
	}
	
	@Transactional(readOnly = true)
	public List<Reserva> reservasPorIdCancha(String idCancha) {
		List<Reserva> reservas = this.repository.findWithUsuarioAndCanchaAndEstadoByCancha(canchaRepository.findById(idCancha).get());
		return reservas;
	}
	
	@Transactional(readOnly = true)
	public List<Reserva> reservasPorEstado(String estado) {
		List<Reserva> reservas = new ArrayList<Reserva>();
		EstadoReserva porEstado = estadoReservaRepository.findOneByNombreEstado(estado).orElse(null);
		reservas = this.repository.findWithUsuarioAndCanchaAndEstadoByEstadoreserva(porEstado);
		return reservas;
	}
	
	@Transactional(readOnly = true)
	public Reserva reservaPorId(String id) {
		return repository.findWithUsuarioAndCanchaAndEstadoById(id).get();
	}
	
	@Transactional(readOnly = false)
	public void actualizarEstado(String idReserva, String estadoReserva) {
		Reserva reserva = this.repository.findWithUsuarioAndCanchaAndEstadoById(idReserva).get();
		
		if(estadoReserva.equals("Finalizada") || (estadoReserva.equals("Cancelada"))) {
			Usuario usuario = reserva.getUsuario();
			usuario.setCantidadReserva(usuario.getCantidadReserva() - 1);
			this.usuarioRepository.save(usuario);
		}
		
		
		EstadoReserva nuevoEstado = this.estadoReservaRepository.findOneByNombreEstado(estadoReserva).get();
		reserva.setEstadoreserva(nuevoEstado);
		
		repository.save(reserva);
		
		
	}
}
 
