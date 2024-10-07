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
	
	@Id
	private Integer id_Usuario;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Usuario")
    private Usuarios usuarios;
	
	
	public Integer getId_Usuario() {
		return id_Usuario;
	}


	public void setId_Usuario(Integer id_Usuario) {
		this.id_Usuario = id_Usuario;
	}


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


	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Rol")
    private Rol Rol;
	
	

}
