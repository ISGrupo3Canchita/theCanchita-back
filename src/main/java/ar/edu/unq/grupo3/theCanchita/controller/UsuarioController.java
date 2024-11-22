package ar.edu.unq.grupo3.theCanchita.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.unq.grupo3.theCanchita.dto.UsuarioDto;
import ar.edu.unq.grupo3.theCanchita.model.Usuario;
import ar.edu.unq.grupo3.theCanchita.request.AuthRequest;
import ar.edu.unq.grupo3.theCanchita.security.UserInfoDetails;
import ar.edu.unq.grupo3.theCanchita.service.JwtService;
import ar.edu.unq.grupo3.theCanchita.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/prueba")
    public String welcome() {
        return "The Canchita futbol club";
    }


    @PostMapping()
    public String addNewUser(@RequestBody UsuarioDto usuarioDto) { 
    	    	

    	Usuario usuario = new Usuario();
    	usuario.setNombreUsuario(usuarioDto.getNombre());
    	usuario.setEmail(usuarioDto.getEmail());
    	usuario.setTelefonoUsuario(usuarioDto.getTelefono());
    	usuario.setContraseñaUsuario(usuarioDto.getContraseña());

    	return service.addUser(usuario);
    }

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('Usuario')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }
    

    @PostMapping("/login")
    public UsuarioDto usuarioPorEmail(@RequestBody AuthRequest authRequest) {
    	UserInfoDetails usuario =  this.service.loadUserByUsername(authRequest.getUsername());
   
    	 Authentication authentication = authenticationManager.authenticate(
    	            new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
    	        );
    	        if (authentication.isAuthenticated()) {
    	
    	            String token = jwtService.generateToken(authRequest.getUsername());
    	            String usuarioRol = this.service.findRolById(usuario.getId());
    	            
    	            UsuarioDto usuarioDto = new UsuarioDto(usuario.getNombre(), usuario.getEmail(), usuario.getTelefono()
    	            		, usuario.getCantidad_Reserva(), null,  usuario.getId(), usuarioRol, token);
    	            return usuarioDto;
    	            
    	        } else {
    	            throw new UsernameNotFoundException("Invalid user request!");

    	        }
    }
    
  
    @GetMapping()
    public List<UsuarioDto> getTodosUsuarios(){
    	List<Usuario> usuarios = this.service.todosLosUsuarios();
    	List<UsuarioDto> usuariosDto = new ArrayList<UsuarioDto>();
    	
    	usuarios.forEach(usuario -> {
    		String rol = this.service.findRolById(usuario.getId());
    		UsuarioDto usuarioDto = new UsuarioDto(usuario.getNombreUsuario(), usuario.getEmail(), usuario.getTelefonoUsuario(), 
    								usuario.getCantidadReserva(), null, usuario.getId(), rol, null);
    		
    		usuariosDto.add(usuarioDto);
    	});
    	
    	return usuariosDto;
    }
    

    @PutMapping("/{id}/rol/{rol}")
    public String actualizarEstadoUsuario(@PathVariable String id, @PathVariable String rol) {
    	return this.service.actualizarEstado(id, rol);
    } 
}
