package theCanchitas.grupo3.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="rol" , schema="canchitabs")
public class Rol {
	
	@Id
	private String id;
	private String nombre;
	private String descripcion;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rol", cascade = CascadeType.ALL)
    private Set<UsuarioRol> usuarioRol;

	
	public String getId() {
		return id;
	}

	public void setIdl(String id_Rol) {
		this.id = id_Rol;
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

	public Set<UsuarioRol> getUsuarioRoles() {
		return usuarioRol;
	}

	public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
		this.usuarioRol = usuarioRoles;
	}


	
}
