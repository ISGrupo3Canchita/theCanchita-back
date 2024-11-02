package ar.edu.unq.grupo3.theCanchita.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.grupo3.theCanchita.service.JwtService;
import ar.edu.unq.grupo3.theCanchita.service.ReservaService;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
	
	@Autowired
	private ReservaService reservaServicio;
	
	@Autowired
	private JwtService jwtService;
	
	@GetMapping("/prueba")
	public String welcome() {
        return "Si llegas al Controller Reserva";
    }
	
	
}
