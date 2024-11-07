package ar.edu.unq.grupo3.theCanchita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		
	@Transactional(readOnly = true)
	public EstadoCancha obtenerEstadoCancha(Integer idEstado) {
		return this.estadoCanchaRepository.findById(idEstado).get();
	}
	
	@Transactional(readOnly = false)
	public String agregarCancha(Cancha cancha) {
		
		this.canchaRepository.save(cancha);

		return "Se ha añadido con éxito";
		
	}
	
	@Transactional(readOnly = true)
	public List<Cancha> todasCanchasHabilitadas(){
		return this.canchaRepository.findCanchasHabilitadas();
	}
	
	
	@Transactional(readOnly = false)
	public String actualizarEstadoCancha(String id, String estadoCancha) {
		try {
	
		Cancha cancha = this.canchaRepository.findWithEstadoById(id).get();
		
		EstadoCancha estado = this.estadoCanchaRepository.findByNombreEstado(estadoCancha);
		
		cancha.setEstadoCancha(estado);
		
		this.canchaRepository.save(cancha);
		
		return "Actualizada Con Exito ";
		
	
		}
		
		catch(Exception e){
			 System.out.println(e);
			 return e.toString();
		}
		
	}
	
	@Transactional(readOnly = true)
	public Cancha canchaPorNombre(String nombre) {
		return this.canchaRepository.findByNombreCancha(nombre).get();
	}
	
	@Transactional(readOnly = true)
	public Cancha canchaPorId(String id) {
		return this.canchaRepository.findById(id).get();
	}
	
	
	@Transactional(readOnly = true)
	public Cancha canchaPorDireccion(String direccion) {
		return this.canchaRepository.findByDireccion(direccion).get();
	}
	
	
	@Transactional(readOnly = true)
	public List<Cancha> canchaPorEstado(String estado){
		if(estado.equals("Habilitada")) {
			return this.canchaRepository.findEstado(1);
		}
		
		else if(estado.equals("Deshabilitada")) {
			return this.canchaRepository.findEstado(2);
		}
		
		else {
			return this.canchaRepository.findEstado(3);
		}
		
		
	}
	
	
}
