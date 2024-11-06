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
			CanchaDto canchaDto = new CanchaDto(cancha.getNombreCancha(), cancha.getDireccion(),
									  	cancha.getHorarioInicio(), cancha.getHorarioCierre(), estado);
			canchasDto.add(canchaDto);
		});
		
		return canchasDto;
		
	}
	
	
	
	@PutMapping("/{id}/estado/{estado}")
	public String actualizarEstadoCancha(@PathVariable String id, @PathVariable String estado) {
		return this.canchaService.actualizarEstadoCancha(id, estado);
	}
	
	
	
}
