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
@Index(name = "index_userInfo_email", columnList = "email_Usuario", unique = true) }) //genera un indice en la columna mail que no acepta dublicado
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Usuario;
	private String nombre_Usuario;
	private String email_Usuario;
	private String contraseña_Usuario;
	private Integer telefono_Usuario;
	private Integer cantidad_Reserva;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarios", cascade = CascadeType.ALL)	
	private Set<UsuarioRoles> usuarioRoles;
	
	
	
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
	public String getEmail_Usuario() {
		return email_Usuario;
	}
	public void setEmail_Usuario(String email_Usuario) {
		this.email_Usuario = email_Usuario;
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
