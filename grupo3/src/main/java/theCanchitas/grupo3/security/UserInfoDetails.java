package theCanchitas.grupo3.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import theCanchitas.grupo3.model.Usuarios;

public class UserInfoDetails implements UserDetails {
	
	private static final long serialVersionUID = 1l;
	
	private String username; // Changed from 'name' to 'username' for clarity
    private String password;
    private List<GrantedAuthority> authorities;
    
    
    public UserInfoDetails(Usuarios userInfo) {
    	this.username = userInfo.getEmail(); // Assuming 'email' is used as 'username'
        this.password = userInfo.getContraseña_Usuario();
        this.authorities = userInfo.getUsuarioRoles()
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

		return password;
	}
	@Override
	public String getUsername() {
		
		return username;
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
