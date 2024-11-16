package ar.edu.unq.grupo3.theCanchita.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ar.edu.unq.grupo3.theCanchita.model.Usuario;

public class UserInfoDetails implements UserDetails {
	
	private static final long serialVersionUID = 1l;
	
	private String email; // Changed from 'name' to 'username' for clarity
    private String contraseña;
    private String nombre;
    private String id;
    private String telefono;
    private Integer cantidad_Reserva;
    private List<GrantedAuthority> authorities;
    
    public UserInfoDetails(Usuario userInfo) {
    	this.email = userInfo.getEmail(); // Assuming 'email' is used as 'username'
        this.contraseña = userInfo.getContraseñaUsuario();
        this.nombre = userInfo.getNombreUsuario();
        this.id = userInfo.getId();
        this.telefono = userInfo.getTelefonoUsuario();
        this.cantidad_Reserva = userInfo.getCantidadReserva();
        this.authorities = userInfo.getUsuariorol()
                .stream()
                .map(x -> x.getRol().getNombre())
               .map(SimpleGrantedAuthority::new)
               .collect(Collectors.toList());
    }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}
	@Override
	public String getPassword() {

		return contraseña;
	}
	@Override
	public String getUsername() {
		
		return email;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Integer getCantidad_Reserva() {
		return cantidad_Reserva;
	}
	public void setCantidad_Reserva(Integer cantidad_Reserva) {
		this.cantidad_Reserva = cantidad_Reserva;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	@Override
    public boolean isAccountNonExpired() {
        return true; // Implement your logic if you need this
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implement your logic if you need this
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implement your logic if you need this
    }

    @Override
    public boolean isEnabled() {
        return true; // Implement your logic if you need this
    }
}
