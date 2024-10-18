package theCanchitas.grupo3.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import theCanchitas.grupo3.model.Usuario;
import theCanchitas.grupo3.repository.UsuarioRepository;
import theCanchitas.grupo3.security.UserInfoDetails;

@Service
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByEmail(email); // Assuming 'email' is used as username

        // Converting UserInfo to UserDetails
        return usuario.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
	}
	
	public String addUser(Usuario usuario) {
        // Encode password before saving the user
        usuario.setContraseña_Usuario(encoder.encode(usuario.getContraseña_Usuario()));
        String uuid = UUID.randomUUID().toString();
        usuario.setId(uuid);
        repository.save(usuario);
        return "User Added Successfully";
    }
	
}
