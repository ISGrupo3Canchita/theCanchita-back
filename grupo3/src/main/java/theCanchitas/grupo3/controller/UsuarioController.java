package theCanchitas.grupo3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import theCanchitas.grupo3.dto.UsuarioDto;
import theCanchitas.grupo3.model.Rol;
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

    @PostMapping("/registrarUsuario")
    public String addNewUser(@RequestBody Usuario userInfo) {
        return service.addUser(userInfo);
    }

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
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
    
    @GetMapping("/usuarioPorEmail/{email}")
    public UsuarioDto usuarioPorEmail(@RequestBody String email) {
    	UserInfoDetails usuario =  this.service.loadUserByUsername(email);
    	
    	String token = new String("");
    	
    	Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword())
            );
            if (authentication.isAuthenticated()) {
                token =  jwtService.generateToken(usuario.getUsername());
            } else {
                throw new UsernameNotFoundException("Invalid user request!");
            }
           
        //esto es de prueba
    	Rol rol = new Rol();
    	rol.setNombre("USUARIO");
    	
    	
    	UsuarioDto usuarioDto = new UsuarioDto(usuario, token, rol);
    	
    	return usuarioDto;
    }	
}
