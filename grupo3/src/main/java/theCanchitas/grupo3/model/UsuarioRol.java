package theCanchitas.grupo3.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarioRol", schema="canchitabs")
public class UsuarioRol {
	
	@Id
	private String id;
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Usuario")
    private Usuario usuario;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Rol")
    private Rol rol;


	public Usuario getUsuarios() {
		return usuario;
	}


	public void setUsuarios(Usuario usuarios) {
		this.usuario = usuarios;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}


	
	
	

}
