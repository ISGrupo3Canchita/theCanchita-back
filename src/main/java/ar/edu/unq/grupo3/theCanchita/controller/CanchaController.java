package ar.edu.unq.grupo3.theCanchita.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.unq.grupo3.theCanchita.dto.CanchaDto;
import ar.edu.unq.grupo3.theCanchita.model.Cancha;
import ar.edu.unq.grupo3.theCanchita.model.EstadoCancha;
import ar.edu.unq.grupo3.theCanchita.service.CanchaService;

@RestController
@RequestMapping("/cancha")
public class CanchaController {

	
	@Autowired
	private CanchaService canchaService;
	
	@PostMapping()
	public String postCancha(@RequestBody CanchaDto canchaDto) {  
		System.out.println(canchaDto.getNombreCancha());
		Cancha cancha = new Cancha();	
		cancha.setNombreCancha(canchaDto.getNombreCancha());
		cancha.setDireccion(canchaDto.getDireccion());
		cancha.setHorarioInicio(canchaDto.getHorarioInicio());
		cancha.setHorarioFin(canchaDto.getHorarioFin());
		
		EstadoCancha estado = this.canchaService.obtenerEstadoCancha(1);
		
		cancha.setEstadoCancha(estado);
		
		return this.canchaService.agregarCancha(cancha);
	}
	
	@GetMapping()
	public List<CanchaDto> getCanchasHabilitadas(){
		List<Cancha> canchasHab =  this.canchaService.todasCanchasHabilitadas();
		
		List<CanchaDto> canchasDto = new ArrayList<CanchaDto>();
		
		String estado = this.canchaService.obtenerEstadoCancha(1).getNombreEstado();
		
		canchasHab.forEach(cancha -> {
			CanchaDto canchaDto = new CanchaDto(cancha.getId(), cancha.getNombreCancha(), cancha.getDireccion(),
									  	cancha.getHorarioInicio(), cancha.getHorarioCierre(), estado);
			canchasDto.add(canchaDto);
		});
		
		return canchasDto;
		
	}
	
	@PutMapping("/{id}/estado/{estado}")
	public String actualizarEstadoCancha(@PathVariable String id, @PathVariable String estado) {
		return this.canchaService.actualizarEstadoCancha(id, estado);
	}
	
	
	@GetMapping("/nombre/{nombre}")
	public CanchaDto traerPorNombre(@PathVariable String nombre) {
		Cancha cancha = this.canchaService.canchaPorNombre(nombre);
		CanchaDto canchaDto = new CanchaDto(cancha.getId(), cancha.getNombreCancha(), cancha.getDireccion(), cancha.getHorarioInicio(), cancha.getHorarioCierre(),
											cancha.getEstadoCancha().getNombreEstado());
		
		return canchaDto;
	}
	
	@GetMapping("/id/{id}")
	public CanchaDto traerPorId(@PathVariable String id) {
		Cancha cancha = this.canchaService.canchaPorId(id);
		CanchaDto canchaDto = new CanchaDto(cancha.getId(), cancha.getNombreCancha(), cancha.getDireccion(), cancha.getHorarioInicio(), cancha.getHorarioCierre(),
				cancha.getEstadoCancha().getNombreEstado());
		
		return canchaDto;
	}
	
	@GetMapping("/direccion/{direccion}")
	public CanchaDto traerPorDireccion(@PathVariable String direccion) {
		Cancha cancha = this.canchaService.canchaPorDireccion(direccion);
		CanchaDto canchaDto = new CanchaDto(cancha.getId(), cancha.getNombreCancha(), cancha.getDireccion(), cancha.getHorarioInicio(), cancha.getHorarioCierre(),
				cancha.getEstadoCancha().getNombreEstado());
		
		return canchaDto;
		
	}
	
	@GetMapping("/estado/{estado}")
	public List<CanchaDto> todasLasCanchasDeEstado(@PathVariable String estado){
		List<Cancha> canchas = this.canchaService.canchaPorEstado(estado);
		
		List<CanchaDto> canchasDto = new ArrayList<CanchaDto>();
		
		
		canchas.forEach(cancha -> {
			CanchaDto canchaDto = new CanchaDto(cancha.getId(), cancha.getNombreCancha(), cancha.getDireccion(),
									  	cancha.getHorarioInicio(), cancha.getHorarioCierre(), cancha.getEstadoCancha().getNombreEstado());
			canchasDto.add(canchaDto);
		});
		
		return canchasDto;
		
		
	  }
  }


