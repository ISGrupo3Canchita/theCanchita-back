package theCanchitas.grupo3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import theCanchitas.grupo3.dto.ReservaDto;
import theCanchitas.grupo3.model.Reserva;
import theCanchitas.grupo3.model.Usuario;
import theCanchitas.grupo3.repository.ReservaRepository;

@Service
public class ReservaService {
	@Autowired
	private ReservaRepository repository;

	public String agregarReserva(ReservaDto reservaDto) {
		// TODO hacer el toModel() --> Reserva nuevaReserva = reservaDto.toModel();
		return "Hacer el tomodel()";
	}
	
	public Reserva reservaPorUsuario(Usuario usuario) {
		
		return repository.findByUsuario(usuario);
	}
}
