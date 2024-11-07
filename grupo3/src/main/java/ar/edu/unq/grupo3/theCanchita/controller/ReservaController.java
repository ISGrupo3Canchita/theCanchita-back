package ar.edu.unq.grupo3.theCanchita.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.unq.grupo3.theCanchita.dto.ReservaDto;
import ar.edu.unq.grupo3.theCanchita.model.Reserva;
import ar.edu.unq.grupo3.theCanchita.request.ReservaRequest;
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
   
	@PostMapping()
	public String agregarReserva(@RequestBody ReservaDto nuevaReserva) {
		return this.reservaServicio.agregarReserva(nuevaReserva);
	}
	
	@GetMapping("/get/reservastodas")
	public List<ReservaDto> todasReservas(){
	List<Reserva> reservas = this.reservaServicio.todasLasReservas();
	List<ReservaDto> reservasDtos = new ArrayList<ReservaDto>();
	reservas.forEach(reserva -> {
		ReservaDto reservaDto = new ReservaDto(reserva);
		reservasDtos.add(reservaDto);
	});
	return reservasDtos;
	}
	
	@GetMapping(path ="/get/reservatodasporusuario/{idUsuario}")
	@ResponseBody
	public ResponseEntity<List<ReservaDto>> reservasPorUsuario(@PathVariable String idUsuario){
		List<Reserva> reservas =this.reservaServicio.reservasPoridUsuario(idUsuario);
		List<ReservaDto> reservasDtos = new ArrayList<ReservaDto>();
		reservas.forEach(reserva -> {
			ReservaDto reservaDto = new ReservaDto(reserva);
			reservasDtos.add(reservaDto);
		});
		return ResponseEntity.ok(reservasDtos);
	}
	
	@GetMapping(path ="/get/reservaparausuario/{idUsuario}")
	@ResponseBody
	public ResponseEntity<List<ReservaDto>> reservasParaUsuario(@PathVariable String idUsuario){
		List<Reserva> reservas =this.reservaServicio.reservasPoridUsuario(idUsuario);
		List<ReservaDto> reservasDtos = new ArrayList<ReservaDto>();
		
		List<Reserva>reservasFiltradas = reservas.stream()
										.filter(reserva -> (reserva.getEstadoreserva().getNombreEstado().equals("Pendiente") ) || (reserva.getEstadoreserva().getNombreEstado().equals("Reservada") ))
										.toList();
						
		reservasFiltradas.forEach(reserva -> {
			ReservaDto reservaDto = new ReservaDto(reserva);
			reservasDtos.add(reservaDto);
		});
		return ResponseEntity.ok(reservasDtos);
	}
	
	@GetMapping (path = "/get/reservaporcancha/{idCancha}")
	@ResponseBody
	public ResponseEntity<List<ReservaDto>> reservasPorCancha(@PathVariable String idCancha){
		List<Reserva> reservas = this.reservaServicio.reservasPorIdCancha(idCancha);
		List<ReservaDto> reservasDtos = new ArrayList<ReservaDto>();
		reservas.forEach(reserva ->{
			ReservaDto reservaDto = new ReservaDto(reserva);
			reservasDtos.add(reservaDto);
		});
		return ResponseEntity.ok(reservasDtos);
	}
	@GetMapping (path = "/get/reservaporestado/{estado}")
	@ResponseBody
	public ResponseEntity<List<ReservaDto>> reservasPorEstado(@PathVariable String estadoReserva){
		List<Reserva> reservas =this.reservaServicio.reservasPorEstado(estadoReserva);
		List<ReservaDto> reservasDtos = new ArrayList<ReservaDto>();
		reservas.forEach(reserva -> {
			ReservaDto reservaDto = new ReservaDto(reserva);
			reservasDtos.add(reservaDto);
		});
		return ResponseEntity.ok(reservasDtos);
	}
	
	@PostMapping(path ="post/actualizaestado")
	public String  cambioEstadoReserva(@RequestBody ReservaRequest reservaRequest ) {
		System.out.println("Estoy en el controller");
		this.reservaServicio.actualizarEstado(reservaRequest.getId(),reservaRequest.getEstadoreserva());
		
		return "Actualiado";
	}
	
}