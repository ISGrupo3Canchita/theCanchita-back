package theCanchitas.grupo3.model;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario", schema = "canchitabs", indexes = {
@Index(name = "index_userInfo_email", columnList = "email", unique = true) }) //genera un indice en la columna mail que no acepta dublicado
public class Usuario {

	@Id
	private String id;
	private String nombre_Usuario;
	private String email;
	private String contraseña_Usuario;
	private Integer telefono_Usuario;
	private Integer cantidad_Reserva;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)	
	private Set<UsuarioRol> usuariorol;
	

	
	
	
	public Set<UsuarioRol> getUsuarioRoles() {
		return usuariorol;
	}
	public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
		this.usuariorol = usuarioRoles;
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id_Usuario) {
		this.id = id_Usuario;
	}
	public String getNombre_Usuario() {
		return nombre_Usuario;
	}
	public void setNombre_Usuario(String nombre_Usuario) {
		this.nombre_Usuario = nombre_Usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email_Usuario) {
		this.email = email_Usuario;
	}
	public String getContraseña_Usuario() {
		return contraseña_Usuario;
	}
	public void setContraseña_Usuario(String contraseña_Usuario) {
		this.contraseña_Usuario = contraseña_Usuario;
	}

	public Integer getTelefono_Usuario() {
		return telefono_Usuario;
	}
	public void setTelefono_Usuario(Integer telefono_Usuario) {
		this.telefono_Usuario = telefono_Usuario;
	}
	public Integer getCantidad_Reserva() {
		return cantidad_Reserva;
	}
	public void setCantidad_Reserva(Integer cantidad_Reserva) {
		this.cantidad_Reserva = cantidad_Reserva;
	}
	

}
