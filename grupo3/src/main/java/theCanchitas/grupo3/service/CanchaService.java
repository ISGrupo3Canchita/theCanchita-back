package theCanchitas.grupo3.service;

import java.util.List;

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
	
	public List<Cancha> todasCanchasHabilitadas(){
		return this.canchaRepository.findCanchasHabilitadas();
	}
	
	public String eliminarCancha(String id) {
		try {
		Cancha cancha = this.canchaRepository.findById(id).get();
		EstadoCancha estadoEliminado = this.estadoCanchaRepository.findById(3).get();
		cancha.setEstadoCancha(estadoEliminado);
		this.canchaRepository.save(cancha);
		}
		
		catch(Exception e){
			 System.out.println(e);
			 return e.toString();
		}
		
		return "Se ha eliminado con éxtio";
		
		
		
		
	}
}
