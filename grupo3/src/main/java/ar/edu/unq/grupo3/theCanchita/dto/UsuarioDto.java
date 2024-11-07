package ar.edu.unq.grupo3.theCanchita.dto;

import java.io.Serializable;

import ar.edu.unq.grupo3.theCanchita.security.UserInfoDetails;

public class UsuarioDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String id;
	private String nombre;
	private String email;
	private String telefono;
	private Integer cantidadReserva;
	private String contraseña;
	private String rol;
	private String token;
	
	/*
	public UsuarioDto(UserInfoDetails usuario, String token, String rol) {
		this.nombre = usuario.getNombre();
		this.email = usuario.getEmail();
		this.telefono = usuario.getTelefono();
		this.cantidadReserva = usuario.getCantidad_Reserva();
		this.contraseña = usuario.getContraseña();
		this.id = usuario.getId();
		this.token = token;
		this.rol = rol;
	}
	*/
	
	public UsuarioDto(String nombre, String email, String telefono, Integer cantidadReserva,
			String contraseña, String id, String rol, String token) {
		this.nombre = nombre;
		this.cantidadReserva = cantidadReserva;
		this.rol = rol;
		this.contraseña = contraseña;
		this.email = email;
		this.telefono = telefono;
		this.token = token;
		this.id = id;
		
	}
	
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getCantidadReserva() {
		return cantidadReserva;
	}
	public void setCantidadReserva(Integer cantidadReserva) {
		this.cantidadReserva = cantidadReserva;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
