package theCanchitas.grupo3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import theCanchitas.grupo3.dto.UsuarioDto;
import theCanchitas.grupo3.model.Usuario;
import theCanchitas.grupo3.request.AuthRequest;
import theCanchitas.grupo3.security.UserInfoDetails;
import theCanchitas.grupo3.service.JwtService;
import theCanchitas.grupo3.service.UsuarioService;

@RestController
@RequestMapping("/theCanchita")
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

    @PostMapping("/registro")
    public String addNewUser(@RequestBody Usuario usuario) {
    	System.out.println(usuario.getEmail());
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
    
    @PostMapping("/ingreso")
    public UsuarioDto usuarioPorEmail(@RequestBody AuthRequest authRequest) {
    	UserInfoDetails usuario =  this.service.loadUserByUsername(authRequest.getUsername());
    	 Authentication authentication = authenticationManager.authenticate(
    	            new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
    	        );
    	        if (authentication.isAuthenticated()) {
    	
    	            String token = jwtService.generateToken(authRequest.getUsername());
    	            String usuarioRol = this.service.findRolById(usuario.getId());
    	            UsuarioDto usuarioDto = new UsuarioDto(usuario, token, usuarioRol);
    	            return usuarioDto;
    	            
    	        } else {
    	            throw new UsernameNotFoundException("Invalid user request!");
    	        } 
    }

}
