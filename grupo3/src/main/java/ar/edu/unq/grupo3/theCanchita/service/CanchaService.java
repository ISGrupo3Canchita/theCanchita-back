package ar.edu.unq.grupo3.theCanchita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.grupo3.theCanchita.model.Cancha;
import ar.edu.unq.grupo3.theCanchita.model.EstadoCancha;
import ar.edu.unq.grupo3.theCanchita.repository.CanchaRepository;
import ar.edu.unq.grupo3.theCanchita.repository.EstadoCanchaRepository;

@Service
public class CanchaService {
	
	@Autowired
	private CanchaRepository canchaRepository;
	
	@Autowired
	private EstadoCanchaRepository estadoCanchaRepository;
		
	
	public EstadoCancha obtenerEstadoCancha(Integer idEstado) {
		return this.estadoCanchaRepository.findById(idEstado).get();
	}
	
	public String agregarCancha(Cancha cancha) {
		
		this.canchaRepository.save(cancha);

		return "Se ha añadido con éxito";
		
	}
	
	public List<Cancha> todasCanchasHabilitadas(){
		return this.canchaRepository.findCanchasHabilitadas();
	}
}
