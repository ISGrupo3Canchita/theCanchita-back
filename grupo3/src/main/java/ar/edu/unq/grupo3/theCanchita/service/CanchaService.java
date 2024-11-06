package ar.edu.unq.grupo3.theCanchita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.grupo3.theCanchita.model.Cancha;
import ar.edu.unq.grupo3.theCanchita.model.EstadoCancha;
import ar.edu.unq.grupo3.theCanchita.repository.CanchaRepository;
import ar.edu.unq.grupo3.theCanchita.repository.EstadoCanchaRepository;
import jakarta.transaction.Transactional;

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
	
	@Transactional
	public List<Cancha> todasCanchasHabilitadas(){
		return this.canchaRepository.findCanchasHabilitadas();
	}
	
	public String actualizarEstadoCancha(String id, String rol) {
		try {
			/*
		Cancha cancha = this.canchaRepository.findById(id).get();
		EstadoCancha estadoEliminado = this.estadoCanchaRepository.findById(3).get();
		cancha.setEstadoCancha(estadoEliminado);
		this.canchaRepository.save(cancha);
		
		return "Se ha eliminado con éxtio";
		*/
			
		Cancha cancha = this.canchaRepository.findWithEstadoById(id).get();
		
		EstadoCancha estado = this.estadoCanchaRepository.findByNombreEstado(rol);
		
		cancha.setEstadoCancha(estado);
		
		this.canchaRepository.save(cancha);
		
		return "Actualizada Con Exito ";
		
		
			
		}
		
		catch(Exception e){
			 System.out.println(e);
			 return e.toString();
		}
		
		
		
		
		
	}
}
