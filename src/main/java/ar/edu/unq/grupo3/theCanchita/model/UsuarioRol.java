package ar.edu.unq.grupo3.theCanchita.model;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedSubgraph;
import jakarta.persistence.Table;

@Entity
@NamedEntityGraph(name = "usuarioRolWithUsuario",
attributeNodes = {
		@NamedAttributeNode("usuario"),
		@NamedAttributeNode(value = "usuario", subgraph = "usuario-subgraph")
	},
	subgraphs = {
			@NamedSubgraph(
					name = "usuario-subgraph",
					attributeNodes = @NamedAttributeNode("usuariorol"))
	})


@Table(name="usuariorol", schema="canchitabs")
public class UsuarioRol {
	
	@Id
	private String id = UUID.randomUUID().toString();
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idRol")
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
