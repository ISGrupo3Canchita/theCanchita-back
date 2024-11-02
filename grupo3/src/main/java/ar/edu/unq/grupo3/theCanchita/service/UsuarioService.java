package ar.edu.unq.grupo3.theCanchita.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unq.grupo3.theCanchita.dto.ReservaDto;
import ar.edu.unq.grupo3.theCanchita.model.Rol;
import ar.edu.unq.grupo3.theCanchita.model.Usuario;
import ar.edu.unq.grupo3.theCanchita.model.UsuarioRol;
import ar.edu.unq.grupo3.theCanchita.repository.RolRepository;
import ar.edu.unq.grupo3.theCanchita.repository.UsuarioRepository;
import ar.edu.unq.grupo3.theCanchita.repository.UsuarioRolRepository;
import ar.edu.unq.grupo3.theCanchita.security.UserInfoDetails;
import jakarta.transaction.Transactional;

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
        /*
        System.out.println(usuario);
        System.out.println(rol.getNombre() + "este es el rol");
        System.out.println(usuarioRol.getRol() + "" +  usuarioRol.getUsuarios() + "" + "este es el usuarioRol");
       */
        if(usuario.getUsuariorol() != null) {
        	for (UsuarioRol usuariorol : usuario.getUsuariorol()) {
        		usuariorol.setUsuarios(usuario);
        	}
        }
        
        usuarioRolRepository.save(usuarioRol);
		
        
        return usuario.getNombreUsuario().toString();
    }
	
	public String findRolById(String id) {
	    Optional<UsuarioRol> usuarioRolOpt = usuarioRolRepository.findByIdUsuario(id);
	    return usuarioRolOpt.map(ur -> ur.getRol().getNombre())
	                         .orElse("Rol no encontrado");
	}
	
	public List<ReservaDto> findReservaByUserName (String userName) {
		// TODO traerme el id del usuario
		Optional<Usuario> usuario = repository.findByEmail(userName);
		
		System.out.println(usuario);		
		// TODO traerme las reservas segun el id anterior
		//List<ReservaDto> listaReservaDto

		
		return null;
	}


	public List<Usuario> todosLosUsuarios(){
		List<Usuario> usuarios = this.repository.findAll();
//		List<UserInfoDetails> usuariosDetails = new ArrayList<UserInfoDetails>();
//		
//		usuarios.forEach(usuario -> {
//			UserInfoDetails usuarioDetails = new UserInfoDetails(usuario);
//			usuariosDetails.add(usuarioDetails);
//		});
		
		return usuarios;
	}
	
}
