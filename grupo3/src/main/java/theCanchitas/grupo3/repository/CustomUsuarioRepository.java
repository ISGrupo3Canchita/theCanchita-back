package theCanchitas.grupo3.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import theCanchitas.grupo3.model.Reserva;

@Repository
public interface CustomUsuarioRepository  {
	
	public List<Reserva> listadoReservaPorUsuario(String userName);
	
	public String idUsuarioByUsername(String username);
	
}
