package theCanchitas.grupo3.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Rol" , schema="canchitaBS")
public class Rol {
	
	@Id
	private Integer id_Rol;
	private String nombre;
	private String descripcion;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rol", cascade = CascadeType.ALL)
    private Set<UsuarioRoles> usuarioRoles;

	
	public Integer getId_Rol() {
		return id_Rol;
	}

	public void setId_Rol(Integer id_Rol) {
		this.id_Rol = id_Rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<UsuarioRoles> getUsuarioRoles() {
		return usuarioRoles;
	}

	public void setUsuarioRoles(Set<UsuarioRoles> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}


	
}
