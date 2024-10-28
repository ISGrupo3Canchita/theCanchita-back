package theCanchitas.grupo3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import theCanchitas.grupo3.model.Cancha;
import theCanchitas.grupo3.model.EstadoCancha;
import theCanchitas.grupo3.repository.CanchaRepository;
import theCanchitas.grupo3.repository.EstadoCanchaRepository;

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
}
