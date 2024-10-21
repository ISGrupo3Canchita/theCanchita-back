package theCanchitas.grupo3.dto;

import theCanchitas.grupo3.model.Rol;

import theCanchitas.grupo3.security.UserInfoDetails;

public class UsuarioDto {
	
	private String nombre;
	private String email;
	private Integer telefono;
	private String contraseña_Usuario;
	private Integer cantidad_Reserva;
	private String rol;
	private String token;
	
	
	public UsuarioDto(UserInfoDetails usuario, String token, Rol rol) {
		this.nombre = usuario.getNombre();
		this.email = usuario.getEmail();
		this.telefono = usuario.getTelefono();
		this.contraseña_Usuario = usuario.getContraseña();
		this.cantidad_Reserva = usuario.getCantidad_Reserva();
		this.rol = rol.getNombre();
		this.token = token;
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
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getContraseña_Usuario() {
		return contraseña_Usuario;
	}
	public void setContraseña_Usuario(String contraseña_Usuario) {
		this.contraseña_Usuario = contraseña_Usuario;
	}
	public Integer getCantidad_Reserva() {
		return cantidad_Reserva;
	}
	public void setCantidad_Reserva(Integer cantidad_Reserva) {
		this.cantidad_Reserva = cantidad_Reserva;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
}
