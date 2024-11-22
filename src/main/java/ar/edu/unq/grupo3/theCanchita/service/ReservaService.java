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
	private ReservaRepository reservaRepository;
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
	    
	    else if (!reservaRepository.findReservasOcupadas(canchaComprobacion, inicio, fin).isEmpty()) {
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
		this.reservaRepository.save(reserva);
		return "Reserva Guardada";
	}
	}
	
	@Transactional(readOnly = true)
	public List<Reserva> todasLasReservas(){
		return this.reservaRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<Reserva> reservasPoridUsuario(String idemail) {
		
		List<Reserva> reservas = this.reservaRepository.findWithUsuarioAndCanchaAndEstadoByUsuario(usuarioRepository.findByEmail(idemail).get());
		return reservas;
	}
	
	
	@Transactional(readOnly = true)
	public List<Reserva> reservasPorIdCancha(String idCancha) {
		List<Reserva> reservas = this.reservaRepository.findWithUsuarioAndCanchaAndEstadoByCancha(canchaRepository.findById(idCancha).get());
		return reservas;
	}
	
	@Transactional(readOnly = true)
	public List<Reserva> reservasPorEstado(String estado) {
		List<Reserva> reservas = new ArrayList<Reserva>();
		EstadoReserva porEstado = estadoReservaRepository.findOneByNombreEstado(estado).orElse(null);
		reservas = this.reservaRepository.findWithUsuarioAndCanchaAndEstadoByEstadoreserva(porEstado);
		return reservas;
	}
	
	@Transactional(readOnly = true)
	public Reserva reservaPorId(String id) {
		return reservaRepository.findWithUsuarioAndCanchaAndEstadoById(id).get();
	}
	
	@Transactional(readOnly = false)
	public void actualizarEstado(String idReserva, String estadoReserva) {

		Reserva reserva = this.reservaRepository.findWithUsuarioAndCanchaAndEstadoById(idReserva).get();
		
		if(estadoReserva.equals("Finalizada") || (estadoReserva.equals("Cancelada"))) {
			Usuario usuario = reserva.getUsuario();
			usuario.setCantidadReserva(usuario.getCantidadReserva() - 1);
			this.usuarioRepository.save(usuario);
		}
		
		
		EstadoReserva nuevoEstado = this.estadoReservaRepository.findOneByNombreEstado(estadoReserva).get();
		reserva.setEstadoreserva(nuevoEstado);
		
		reservaRepository.save(reserva);
	}
	
	@Transactional(readOnly= true)
	public List<Reserva> listaReservaConEstadoPendienteOReservadaPorUsuarioEmail(String email){
		Usuario usuario = this.usuarioRepository.findWithRolesByEmail(email);
		
		System.out.println(usuario.getUsuariorol());
	
		EstadoReserva estadoUno = this.estadoReservaRepository.findOneByNombreEstado("Pendiente").get();
		EstadoReserva estadoDos = this.estadoReservaRepository.findOneByNombreEstado("Reservada").get();
		List<EstadoReserva> estados = new ArrayList<EstadoReserva>();
		estados.add(estadoUno);
		estados.add(estadoDos);
		List<Reserva> reservas = this.reservaRepository.findReservasPendienteReservadaByUsuario(usuario,estados);
//		List<Reserva> reservas = this.reservaRepository.findByUsuarioAndEstadoreservaIn(usuario, estados);
		return reservas;
	}
}
 
