package theCanchitas.grupo3.model;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuarios", schema = "canchitaBS", indexes = {
@Index(name = "index_userInfo_email", columnList = "email", unique = true) }) //genera un indice en la columna mail que no acepta dublicado
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Usuario;
	private String nombre_Usuario;
	private String email;
	private String contraseña_Usuario;
	private Integer telefono_Usuario;
	private Integer cantidad_Reserva;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarios", cascade = CascadeType.ALL)	
	private Set<UsuarioRol> usuarioRoles;
	

	
	
	
	public Set<UsuarioRol> getUsuarioRoles() {
		return usuarioRoles;
	}
	public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}
	public int getId_Usuario() {
		return id_Usuario;
	}
	public void setId_Usuario(int id_Usuario) {
		this.id_Usuario = id_Usuario;
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

	public void setId_Usuario(Integer id_Usuario) {
		this.id_Usuario = id_Usuario;
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
