package theCanchitas.grupo3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import theCanchitas.grupo3.service.JwtService;
import theCanchitas.grupo3.service.ReservaService;

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
