package ar.edu.unq.grupo3.theCanchita.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping(path = "")
	@ResponseBody
	public ResponseEntity<List<ReservaDto>> todasReservas(){
	List<Reserva> reservas = this.reservaServicio.todasLasReservas();
	List<ReservaDto> reservasDtos = new ArrayList<ReservaDto>();
	reservas.forEach(reserva -> {
		ReservaDto reservaDto = new ReservaDto(reserva);
		reservasDtos.add(reservaDto);
	});
	return ResponseEntity.ok(reservasDtos);
	}
	
	@GetMapping(path ="/usuario/{idUsuario}")
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
	
	@GetMapping(path ="/email2/{email}")
	@ResponseBody
	public ResponseEntity<List<ReservaDto>> reservasParaUsuario(@PathVariable String email){
		List<Reserva> reservas =this.reservaServicio.reservasPoridUsuario(email);
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
	
	@GetMapping(path ="/email/{email}")
	@ResponseBody
	public ResponseEntity<List<ReservaDto>> listaReservaParaUsuarioSegunEstado(@PathVariable String email){
		
		List<Reserva> reservas = this.reservaServicio.listaReservaConEstadoPendienteOReservadaPorUsuarioEmail(email);
		List<ReservaDto> reservasDto = new ArrayList<ReservaDto>();
		reservas.forEach(reserva -> {
			ReservaDto reservaDto = new ReservaDto(reserva);
			reservasDto.add(reservaDto);
		});
		return ResponseEntity.ok(reservasDto);
	}
	
	@GetMapping (path = "/cancha/{idCancha}")
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
	@GetMapping (path = "/estado/{estado}")
	@ResponseBody
	public ResponseEntity<List<ReservaDto>> reservasPorEstado(@PathVariable String estado){
		System.out.println(estado);
		List<Reserva> reservas =this.reservaServicio.reservasPorEstado(estado);
		List<ReservaDto> reservasDtos = new ArrayList<ReservaDto>();
		reservas.forEach(reserva -> {
			ReservaDto reservaDto = new ReservaDto(reserva);
			reservasDtos.add(reservaDto);
		});
		return ResponseEntity.ok(reservasDtos);
	}
	
	@PutMapping("/{idReserva}/estado/{nuevoEstado}")
	public String  cambioEstadoReservaPut( @PathVariable String idReserva,@PathVariable String nuevoEstado ) {
		this.reservaServicio.actualizarEstado(idReserva,nuevoEstado);
		
		return "Actualizado";
	}	
}