package theCanchitas.grupo3.dto;

import theCanchitas.grupo3.security.UserInfoDetails;

public class UsuarioDto {
	
	private String nombre;
	private String email;
	private Integer telefono;
	private String contraseñaUsuario;
	private Integer cantidadReserva;
	private String rol;
	private String token;
	
	
	public UsuarioDto(UserInfoDetails usuario, String token) {
		this.nombre = usuario.getNombre();
		this.email = usuario.getEmail();
		this.telefono = usuario.getTelefono();
		this.contraseñaUsuario = usuario.getContraseña();
		this.cantidadReserva = usuario.getCantidad_Reserva();
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
	public String getContraseñaUsuario() {
		return contraseñaUsuario;
	}
	public void setContraseñaUsuario(String contraseñaUsuario) {
		this.contraseñaUsuario = contraseñaUsuario;
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
	
	
}