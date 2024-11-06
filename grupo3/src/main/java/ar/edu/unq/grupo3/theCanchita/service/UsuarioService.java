package ar.edu.unq.grupo3.theCanchita.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unq.grupo3.theCanchita.model.Rol;
import ar.edu.unq.grupo3.theCanchita.model.Usuario;
import ar.edu.unq.grupo3.theCanchita.model.UsuarioRol;
import ar.edu.unq.grupo3.theCanchita.repository.RolRepository;
import ar.edu.unq.grupo3.theCanchita.repository.UsuarioRepository;
import ar.edu.unq.grupo3.theCanchita.repository.UsuarioRolRepository;
import ar.edu.unq.grupo3.theCanchita.security.UserInfoDetails;
import org.springframework.transaction.annotation.Transactional;

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
		
		
		Usuario usuario = repository.findWithRolesByEmail(email); // **Asumimos que el username es el Email**
		System.out.println(usuario.getEmail());
		// Converting UserInfo to UserDetails

		if (usuario != null) {
			UserInfoDetails usuarioP = new UserInfoDetails(usuario);
			return usuarioP;
		}	
		return null;
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
		 * System.out.println(usuario); System.out.println(rol.getNombre() +
		 * "este es el rol"); System.out.println(usuarioRol.getRol() + "" +
		 * usuarioRol.getUsuarios() + "" + "este es el usuarioRol");
		 */
		if (usuario.getUsuariorol() != null) {
			for (UsuarioRol usuariorol : usuario.getUsuariorol()) {
				usuariorol.setUsuarios(usuario);
			}
		}

		usuarioRolRepository.save(usuarioRol);

		return usuario.getNombreUsuario().toString();
	}

	public String findRolById(String id) {
		Optional<UsuarioRol> usuarioRolOpt = usuarioRolRepository.findByIdUsuario(id);
		return usuarioRolOpt.map(ur -> ur.getRol().getNombre()).orElse("Rol no encontrado");
	}

	public List<Usuario> todosLosUsuarios() {
		List<Usuario> usuarios = this.repository.findAll();

		return usuarios;
	}
	

	@Transactional  
	public String actualizarEstado(String id, String rol) {
	  try { 
	  //Usuario usuario = this.repository.findById(id).get();
		  
		  Usuario usuario = this.repository.findWithRolesById(id).get();
		  
		  UsuarioRol usuarioRol = this.usuarioRolRepository.findWithUsuarioByUsuario(usuario);
		  
	 
	  if(rol.equals("Operador")) {
		  Rol rolBase = rolRepository.findByNombre("Operador");
		  usuarioRol.setRol(rolBase);
//		  this.repository.save(usuario);
		  this.usuarioRolRepository.save(usuarioRol);
		  return "rol actualizado a Operador";
	  } 
	  else if (rol.equals("Administrador")) {
		  Rol rolBase = rolRepository.findByNombre("Administrador");
		  usuarioRol.setRol(rolBase);
//		  this.repository.save(usuario);
		  this.usuarioRolRepository.save(usuarioRol);
		  
		  return "rol actualizado a Administrador";
	  }
	  else if (rol.equals("Usuario")) {
		  Rol rolBase = rolRepository.findByNombre("Usuario");
		  usuarioRol.setRol(rolBase);
//		  this.repository.save(usuario);
		  this.usuarioRolRepository.save(usuarioRol);
		  return "rol actualizado Usuario";
	  }
	  
	  else if (rol.equals("Eliminado")){
		  Rol rolBase = rolRepository.findByNombre("Eliminado");
		  usuarioRol.setRol(rolBase);
//		  this.repository.save(usuario);
		  this.usuarioRolRepository.save(usuarioRol);
		  return "rol actualizado a Eliminado";
	  }
	  
	  else {
		  return "Rol no reconocido";
	  }
	  
	  }
	  
	  catch(Exception e){
		  return e.toString();
	  }
	  
	  }
	  
	 
}
