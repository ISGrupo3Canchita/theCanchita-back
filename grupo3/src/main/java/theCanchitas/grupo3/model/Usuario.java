package theCanchitas.grupo3.model;


import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario", schema = "canchitabs", indexes = {
@Index(name = "indexUserInfoEmail", columnList = "email", unique = true) }) //genera un indice en la columna mail que no acepta dublicado
public class Usuario {

	@Id
	private String id;
	private String nombreUsuario;
	private String email;
	private String contraseñaUsuario;
	private String telefonoUsuario;
	private Integer cantidadReserva;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")	
	private Set<UsuarioRol> usuariorol;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseñaUsuario() {
		return contraseñaUsuario;
	}

	public void setContraseñaUsuario(String contraseñaUsuario) {
		this.contraseñaUsuario = contraseñaUsuario;
	}

	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}

	public Integer getCantidadReserva() {
		return cantidadReserva;
	}

	public void setCantidadReserva(Integer cantidadReserva) {
		this.cantidadReserva = cantidadReserva;
	}

	public Set<UsuarioRol> getUsuariorol() {
		return usuariorol;
	}

	public void setUsuariorol(Set<UsuarioRol> usuariorol) {
		this.usuariorol = usuariorol;
	}
	
}
