package theCanchitas.grupo3.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="UsuarioRoles", schema="canchitaBS")
public class UsuarioRoles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_UsuarioRoles;
	
	public Integer getId_UsuarioRoles() {
		return id_UsuarioRoles;
	}


	public void setId_UsuarioRoles(Integer id_UsuarioRoles) {
		this.id_UsuarioRoles = id_UsuarioRoles;
	}


	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Usuario")
    private Usuarios usuarios;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Rol")
    private Rol rol;


	public Usuarios getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}


	
	
	

}
