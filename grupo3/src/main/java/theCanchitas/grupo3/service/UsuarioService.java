package theCanchitas.grupo3.service;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import theCanchitas.grupo3.model.Rol;
import theCanchitas.grupo3.model.Usuario;
import theCanchitas.grupo3.model.UsuarioRol;
import theCanchitas.grupo3.repository.RolRepository;
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
	private RolRepository rolRepository;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserInfoDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> usuario = repository.findByEmail(email); // **Asumimos que el username es el Email**

        // Converting UserInfo to UserDetails
        return usuario.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
	}
	
	@Transactional
	public String addUser(Usuario usuario) {
        // Encode password before saving the user
        usuario.setContraseñaUsuario(encoder.encode(usuario.getContraseñaUsuario()));
        String uuid = UUID.randomUUID().toString();
        usuario.setId(uuid);
        usuario.setCantidadReserva(0);
        repository.save(usuario);
        
        
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuarios(usuario);
        
        
        Rol rol = rolRepository.findByNombre("Usuario");
        
        usuarioRol.setRol(rol);
        
        System.out.println(usuario);
        System.out.println(rol.getNombre() + "este es el rol");
        System.out.println(usuarioRol.getRol() + "" +  usuarioRol.getUsuarios() + "" + "este es el usuarioRol");
       
        if(usuario.getUsuariorol() != null) {
        	for (UsuarioRol usuariorol : usuario.getUsuariorol()) {
        		usuariorol.setUsuarios(usuario);
        	}
        }
        
        /*
         * falla al guardar:
         */
        usuarioRolRepository.save(usuarioRol);
		
        
        return usuario.getNombreUsuario().toString();
    }
	
	public String findRolById(String id) {
	    Optional<UsuarioRol> usuarioRolOpt = usuarioRolRepository.findByIdUsuario(id);
	    return usuarioRolOpt.map(ur -> ur.getRol().getNombre())
	                         .orElse("Rol no encontrado");
	}


	
}
