package ar.edu.unq.grupo3.theCanchita.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.unq.grupo3.theCanchita.dto.ReservaDto;
import ar.edu.unq.grupo3.theCanchita.dto.ReservasDtos;
import ar.edu.unq.grupo3.theCanchita.model.Reserva;
import ar.edu.unq.grupo3.theCanchita.service.ReservaService;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
	
	@Autowired
	private ReservaService reservaServicio;
	
	@GetMapping("/prueba")
	public String welcome() {
        return "Si llegas al Controller Reserva";
	}
   
	@PostMapping("/post/agregarReserva")
	public String agregarReserva(@RequestBody ReservaDto nuevaReserva) {
		return this.reservaServicio.agregarReserva(nuevaReserva);
	}
	
	@GetMapping("/get/reservas")
	public List<ReservaDto> todasReservas(){
	List<Reserva> reservas = this.reservaServicio.todasLasReservas();
	List<ReservaDto> reservasDtos = new ArrayList<ReservaDto>();
	reservas.forEach(reserva -> {
		ReservaDto reservaDto = new ReservaDto(reserva);
		reservasDtos.add(reservaDto);
	});
	return reservasDtos;
	}
	
	@GetMapping ("/get/reservaXusuario/{idUsuario}")
	public List<Reserva> reservasPorUsuario(@PathVariable String idUsuario){
		return this.reservaServicio.reservasPoridUsuario(idUsuario);
	}
	
	@GetMapping ("/get/reservaXcancha/{idCancha}")
	public List<Reserva> reservasPorCancha(@PathVariable String idCancha){
		System.out.println("CONTROLLER RESERVA POR CANCHA");
		return this.reservaServicio.reservasPorIdCancha(idCancha);
	}
	@GetMapping ("/get/reservaXestado/{estado}")
	public List<Reserva> reservasPorEstado(@PathVariable String Estado){
		System.out.println("CONTROLLER RESERVA POR ESTADO");
		return this.reservaServicio.reservasPorEstado(Estado);
	}
}
	
	

