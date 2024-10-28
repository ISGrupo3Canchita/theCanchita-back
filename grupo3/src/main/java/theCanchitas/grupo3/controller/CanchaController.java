package theCanchitas.grupo3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import theCanchitas.grupo3.dto.CanchaDto;
import theCanchitas.grupo3.model.Cancha;
import theCanchitas.grupo3.model.EstadoCancha;
import theCanchitas.grupo3.service.CanchaService;

@RestController
@RequestMapping("/cancha")
public class CanchaController {

	
	@Autowired
	private CanchaService canchaService;
	
	
	@PostMapping("/post/cancha")
	public String postCancha(@RequestBody CanchaDto canchaDto) {  
		
		Cancha cancha = new Cancha();	
		cancha.setNombreCancha(canchaDto.getNombreCancha());
		cancha.setDireccion(canchaDto.getDireccion());
		cancha.setHorarioInicio(canchaDto.getHorarioInicio());
		cancha.setHorarioFin(canchaDto.getHorarioFin());
		
		EstadoCancha estado = this.canchaService.obtenerEstadoCancha(1);
		
		System.out.println(estado.getNombreEstado());
		cancha.setEstadoCancha(estado);
		//Falla ACA
		return this.canchaService.agregarCancha(cancha);
		
		
	}
}
