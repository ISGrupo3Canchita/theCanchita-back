package ar.edu.unq.grupo3.theCanchita.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.grupo3.theCanchita.dto.ReservaDto;
import ar.edu.unq.grupo3.theCanchita.model.Reserva;
import ar.edu.unq.grupo3.theCanchita.model.Usuario;
import ar.edu.unq.grupo3.theCanchita.repository.ReservaRepository;

@Service
public class ReservaService {
	@Autowired
	private ReservaRepository repository;

	public String agregarReserva(ReservaDto reservaDto) {
		// TODO hacer el toModel() --> Reserva nuevaReserva = reservaDto.toModel();
		return "Hacer el tomodel()";
	}
	
	public Reserva reservaPorUsuario(Usuario usuario) {
		
		return repository.findByusuario(usuario);
	}
}
