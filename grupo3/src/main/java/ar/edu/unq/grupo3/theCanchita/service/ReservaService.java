package ar.edu.unq.grupo3.theCanchita.service;

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

	public String agregarReserva(ReservaDto nuevaReserva) {
		String uuid = UUID.randomUUID().toString();
		EstadoReserva estadoReserva = estadoReservaRepository.findById(3).get();
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
		List<Reserva> reservas = this.repository.findWithUsuarioAndCanchaAndEstadoByUsuario(usuarioRepository.findById(idUsuario).get());
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
			if(estado.equals("Pendiente")) {
				 reservas = this.repository.findWithUsuarioAndCanchaAndEstadoByEstadoreserva(estadoReservaRepository.findById(3).get());
			}else if(estado.equals("Reservada")) {
				reservas = this.repository.findWithUsuarioAndCanchaAndEstadoByEstadoreserva(estadoReservaRepository.findById(1).get());
			}else if(estado.equals("Finalizada")) {
				reservas = this.repository.findWithUsuarioAndCanchaAndEstadoByEstadoreserva(estadoReservaRepository.findById(2).get());
			}else if (estado.equals("Cancelada")) {
				reservas = this.repository.findWithUsuarioAndCanchaAndEstadoByEstadoreserva(estadoReservaRepository.findById(4).get());
			}
		return reservas;
	}
	
	@Transactional
	public Reserva reservaPorId(String id) {
		return repository.findWithUsuarioAndCanchaAndEstadoById(id).get();
	}
	
	@Transactional(readOnly = true)
	public void actualizarEstado(String idReserva, String estadoReserva) {
		
		Reserva reserva = this.repository.findWithUsuarioAndCanchaAndEstadoById(idReserva).get();
		

		System.out.println("ID RESERVA: "+reserva.getId()+" ESTADO: "+reserva.getEstadoreserva().getNombreEstado() );
		
		EstadoReserva nuevoEstado= new EstadoReserva();
		System.out.println("Estado despues de crearlo"+nuevoEstado.getNombreEstado() );
		nuevoEstado = this.estadoReservaRepository.findByNombreEstado(estadoReserva).get(0);
		System.out.println("Estado despues cargarlo:  "+nuevoEstado.getNombreEstado() );

		reserva.setEstadoreserva(nuevoEstado);
		System.out.println("RESERVA CON EL ESTADO CAMBIADO / ID RESERVA: "+reserva.getId()+" ESTADO: "+reserva.getEstadoreserva().getNombreEstado() );
		
		repository.save(reserva);
		
		Reserva reserva2 = this.repository.findWithUsuarioAndCanchaAndEstadoById(idReserva).get();
		System.out.println("RESERVA CON EL ESTADO CAMBIADO / ID RESERVA: "+reserva2.getId()+" ESTADO: "+reserva2.getEstadoreserva().getNombreEstado() );
		
	}
}
 
