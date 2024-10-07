package theCanchitas.grupo3.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="UsuarioRoles", schema="canchitaBS")
public class UsuarioRoles {
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Usuario")
    private Usuarios usuarios;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Rol")
    private Rol Rol;


	public Usuarios getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}


	public Rol getRol() {
		return Rol;
	}


	public void setRol(Rol rol) {
		Rol = rol;
	}


	
	
	

}
