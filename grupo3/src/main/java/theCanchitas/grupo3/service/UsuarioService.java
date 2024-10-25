package theCanchitas.grupo3.service;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import theCanchitas.grupo3.dto.UsuarioDto;
import theCanchitas.grupo3.model.Usuario;
import theCanchitas.grupo3.model.UsuarioRol;
import theCanchitas.grupo3.repository.UsuarioRepository;
import theCanchitas.grupo3.repository.UsuarioRolRepository;
import theCanchitas.grupo3.security.UserInfoDetails;

@Service
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioRolRepository usuarioRolRepository;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserInfoDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByEmail(email); // **Asumimos que el username es el Email**

        // Converting UserInfo to UserDetails
        return usuario.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
	}
	
	public String addUser(Usuario usuario) {
        // Encode password before saving the user
        usuario.setContraseñaUsuario(encoder.encode(usuario.getContraseñaUsuario()));
        String uuid = UUID.randomUUID().toString();
        usuario.setId(uuid);
        usuario.setCantidadReserva(0);
        repository.save(usuario);
        return usuario.getNombreUsuario().toString();
    }
	
	public String findRolById(String id) {
	    Optional<UsuarioRol> usuarioRolOpt = usuarioRolRepository.findByIdUsuario(id);
	    return usuarioRolOpt.map(ur -> ur.getRol().getNombre())
	                         .orElse("Rol no encontrado");
	}


	public String agregaUsuarioNuevo(UsuarioDto usuariodto) {
		usuariodto.setContraseñaUsuario(encoder.encode(usuariodto.getContraseñaUsuario()));
		String uuid = UUID.randomUUID().toString();
		usuariodto.setContraseñaUsuario(uuid);
		usuariodto.setCantidadReserva(0);
		/*
		repository.save(usuariodto);
		*/
		return "El Usuario: "+usuariodto.getNombre()+", fue agregado.";
	}
	
}
